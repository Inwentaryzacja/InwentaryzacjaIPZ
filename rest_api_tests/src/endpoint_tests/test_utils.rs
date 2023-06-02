use anyhow::{anyhow, Result};
use reqwest::{Client, Response, Url};
use serde::Serialize;
use std::fmt::Debug;

pub async fn get(endpoint: Url, client: &Client) -> Result<Response> {
    client
        .get(endpoint.clone())
        .build()
        .map(|req| async { client.execute(req).await })?
        .await
        .map_err(|err| anyhow!("Failed to execute get request:\nurl={endpoint}\n{err}"))
}

pub async fn post<B: Serialize + Debug>(
    endpoint: Url,
    client: &Client,
    body: &B,
) -> Result<Response> {
    client
        .post(endpoint.clone())
        .json(body)
        .send()
        .await
        .map_err(|err| {
            anyhow!("Failed to execute post request:\nurl={endpoint}\nbody={body:#?}\n{err}")
        })
}
