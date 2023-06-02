use anyhow::Result;
use endpoint_tests::item;
mod database;

mod endpoint_tests;
mod test_lib;

use test_lib::TestSuiteBuilder;

#[tokio::main]
async fn main() -> Result<()> {
    TestSuiteBuilder::create()
        .await?
        // .add_test(attribute::AttributeTest, "http://back:8080/attributes")?
        .add_test(item::AddGetRemoveItemTest, "http://localhost:8080/items")?
        .compile()
        .execute()
        .await?;

    Ok(())
}
