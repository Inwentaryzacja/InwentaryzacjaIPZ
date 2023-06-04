use anyhow::Result;
use async_trait::async_trait;
use reqwest::Client;
use reqwest::Url;
use serde::de::DeserializeOwned;
use serde::Serialize;
use std::fmt;

#[async_trait]
pub trait EndpointTest {
    async fn execute(&self, endpoint_url: Url, client: &Client) -> Result<()>;
}

#[async_trait]
pub trait ExpectResponse<S> {
    async fn should_be(self, expected: &S) -> Result<S>
    where
        Self: Send + Sync,
        S: Serialize + DeserializeOwned + fmt::Debug + Send + Sync + Eq;
}
