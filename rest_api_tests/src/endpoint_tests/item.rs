use crate::test_lib::EndpointTestCase;

use crate::endpoint_tests::test_utils;
use anyhow::anyhow;
use anyhow::Result;
use async_trait::async_trait;
use reqwest::StatusCode;
use reqwest::{Client, Url};
use serde::Deserialize;
use serde::Serialize;

#[allow(non_camel_case_types)]
#[derive(Deserialize, Serialize, Debug)]
struct Item {
    name: String,
    fillable: bool,
    description: String,
    tags: Vec<Tag>,
}

#[derive(Deserialize, Serialize, Debug)]
struct Tag {
    attributes: Vec<Attribute>,
}

#[derive(Deserialize, Serialize, Debug)]
struct Attribute {
    name: String,
    r#type: AttributeType,
}

#[derive(Deserialize, Serialize, Debug)]
struct AttributeType {
    name: String,
}

#[derive(Serialize, Deserialize, Debug)]
struct ItemEndpointResponse {
    timestamp: String,
    status: usize,
    error: Option<String>,
    message: Option<String>,
}

// czy jakiegolwiek id powinno być podawane w request body?
// dlaczego frontend ma podawać datę używaną w createdAt
// po co
#[derive(Clone, Debug)]
pub struct AddGetRemoveItemTest;

#[async_trait]
impl EndpointTestCase for AddGetRemoveItemTest {
    async fn execute(&self, endpoint: Url, client: &Client) -> Result<()> {
        let body = Item {
            name: "Bulbulator".to_string(),
            fillable: false,
            description: "Wichajster do tegesowania.".to_string(),
            tags: vec![Tag {
                attributes: vec![Attribute {
                    name: "Rzecz niepoważna".to_string(),
                    r#type: AttributeType {
                        name: "string".to_string(),
                    },
                }],
            }],
        };

        let res = test_utils::post(endpoint, client, &body)
            .await?
            .json::<ItemEndpointResponse>()
            .await
            .map_err(|err| anyhow!("Failed to post request:\nbody: {body:#?}\nerr: {err:#}"))?;

        println!("{:#?}", res);
        Ok(())
    }
}
