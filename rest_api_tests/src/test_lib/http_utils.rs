use anyhow::{anyhow, Result};
use async_trait::async_trait;
use reqwest::{Client, Response, Url};
use serde::de::DeserializeOwned;
use serde::Serialize;
use std::fmt;

use super::traits::ExpectResponse;

pub async fn get(endpoint: &Url, client: &Client) -> Result<Response> {
    println!("Get request on {endpoint}");
    client
        .get(endpoint.clone())
        .build()
        .map(|req| async { client.execute(req).await })?
        .await
        .map_err(|err| anyhow!("Failed to execute get request:\nurl={endpoint}\n{err}"))
}

pub async fn post<B: Serialize + fmt::Debug>(
    endpoint: &Url,
    client: &Client,
    body: &B,
) -> Result<Response> {
    println!("Post request on {endpoint} with body {body:#?}");
    client
        .post(endpoint.clone())
        .json(body)
        .send()
        .await
        .map_err(|err| {
            anyhow!("Failed to execute post request:\nurl={endpoint}\nbody={body:#?}\n{err}")
        })
}

pub async fn delete(endpoint: &Url, client: &Client) -> Result<Response> {
    println!("Delete request on {endpoint}");
    client
        .delete(endpoint.clone())
        .send()
        .await
        .map_err(|err| anyhow!("Failed to execute delete request:\nurl={endpoint}\n\n{err}"))
}

#[async_trait]
impl<S: Serialize + DeserializeOwned + fmt::Debug + Send + Sync + Eq> ExpectResponse<S>
    for Response
{
    async fn should_be(self, expected: &S) -> Result<S> {
        let response = self.text().await.unwrap();

        let actual = serde_json::from_str::<S>(&response).map_err(|parse_err| anyhow!("Failed to parse the response: {parse_err}\n\nExpected:{expected:?}\n\nstructure didn't match for\n{response}"))?;

        if !(&actual == expected) {
            return Err(anyhow!("Expected and actual responses dont match:\n\nExpected:\n{expected:#?}\n\nActual:\n{:#?}", &actual));
        }

        Ok(actual)
    }
}
