use anyhow::Result;
use endpoint_tests::{tag, attribute};
mod database;

mod endpoint_tests;
mod test_lib;

use test_lib::TestSuiteBuilder;

#[tokio::main]
async fn main() -> Result<()> {
    TestSuiteBuilder::create()
        .await?
        .add_test(attribute::AttributeInTagDelete, "http://localhost:8080/attributes")?
        .compile()
        .execute()
        .await?;

    Ok(())
}
