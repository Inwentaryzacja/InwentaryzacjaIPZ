use crate::test_lib;
use crate::test_lib::traits::ExpectResponse;
use anyhow::Result;
use async_trait::async_trait;
use reqwest::{Client, Url};
use serde::{Deserialize, Serialize};

#[derive(Deserialize, Serialize, Debug, Eq, PartialEq)]
struct Item {
    name: String,
    fillable: bool,
    description: String,
    tags: Vec<Tag>,
}

#[derive(Deserialize, Serialize, Debug, Eq, PartialEq)]
struct Tag {
    name: String,
    attributes: Vec<Attribute>,
}

#[derive(Deserialize, Serialize, Debug, Eq, PartialEq)]
struct Attribute {
    name: String,
    r#type: AttributeType,
}

#[derive(Deserialize, Serialize, Debug, Eq, PartialEq)]
struct AttributeType {
    name: String,
}

#[derive(Serialize, Deserialize, Debug, Eq, PartialEq)]
struct ItemEndpointResponse {
    timestamp: String,
    status: usize,
    error: Option<String>,
    message: Option<String>,
}

#[derive(Clone, Debug)]
pub struct TagAdd;

#[async_trait]
impl test_lib::EndpointTest for TagAdd {
    async fn execute(&self, endpoint: Url, client: &Client) -> Result<()> {
        let body = Tag {
            name: "Jakiś tag".to_string(),
            attributes: vec![
                Attribute {
                    name: "Czerwony".to_string(),
                    r#type: AttributeType {
                        name: "Kolor".to_string(),
                    },
                },
                Attribute {
                    name: "351".to_string(),
                    r#type: AttributeType {
                        name: "[m^2]".to_string(),
                    },
                },
            ],
        };

        test_lib::post(&endpoint, client, &body)
            .await?
            .should_be(&body)
            .await?;

        Ok(())
    }
}
