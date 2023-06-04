use crate::test_lib;
use crate::test_lib::traits::ExpectResponse;
use anyhow::Result;
use async_trait::async_trait;

use reqwest::{Client, Url};
use serde::Deserialize;
use serde::Serialize;

#[allow(non_camel_case_types)]
#[derive(Deserialize, Serialize, Debug, Eq, PartialEq)]
struct Item {
    id: Option<usize>,
    name: String,
    fillable: bool,
    description: String,
    tags: Vec<Tag>,
}

#[derive(Deserialize, Serialize, Debug, Eq, PartialEq)]
struct Tag {
    id: Option<usize>,
    name: String,
    attributes: Vec<Attribute>,
}

#[derive(Deserialize, Serialize, Debug, Eq, PartialEq)]
struct Attribute {
    id: Option<usize>,
    name: String,
    r#type: AttributeType,
}

#[derive(Deserialize, Serialize, Debug, Eq, PartialEq)]
struct AttributeType {
    id: Option<usize>,
    name: String,
}

#[derive(Clone, Debug)]
pub struct AttributeInTagDelete;

#[async_trait]
impl test_lib::EndpointTest for AttributeInTagDelete {
    async fn execute(&self, endpoint: Url, client: &Client) -> Result<()> {
        let all_attributes = test_lib::get(&endpoint, client)
            .await?
            .json::<Vec<Attribute>>()
            .await?;

        let post_attr_body = Attribute {
            id: None,
            name: "Wilgotność powietrza".to_string(),
            r#type: AttributeType {
                id: None,
                name: "[%]".to_string(),
            },
        };

        let attr_post_res = test_lib::post(&endpoint, client, &post_attr_body)
            .await?
            .should_be(&post_attr_body)
            .await?;
        
        let added_attr_id = attr_post_res
            .id
            .expect("Response should respond with and id on attribute.");

        let post_tag_body = Tag {
            id: None,
            name: "Testowy tag".to_string(),
            attributes: vec![post_attr_body],
        };

        let _added_tag_res = test_lib::post(&endpoint, client, &post_tag_body).await?;

        let delete_url = endpoint.join(&format!("/{added_attr_id}"))?;

        let delete_res = test_lib::delete(&delete_url, client)
            .await?
            .json::<Attribute>().await?;

        test_lib::get(&endpoint, client).await?;

        Ok(())
    }
}
