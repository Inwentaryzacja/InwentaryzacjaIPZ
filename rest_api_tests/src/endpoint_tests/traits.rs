use anyhow::Result;
use async_trait::async_trait;
use reqwest::Client;
use reqwest::Url;

#[async_trait]
pub trait EndpointTestCase {
    async fn execute(&self, endpoint_url: Url, client: &Client) -> Result<()>;
}
