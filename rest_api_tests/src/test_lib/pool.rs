use anyhow::Result;
use reqwest::{Client, IntoUrl, Url};
use sqlx::MySqlPool;

use crate::database;
use crate::test_lib::traits::EndpointTestCase;

use crate::test_lib::dotenv_load;

type Test = Box<dyn EndpointTestCase>;

pub struct TestCaseCtx {
    test: Test,
    endpoint: Url,
}
pub struct TestSuiteBuilder {
    pool: MySqlPool,
    tests: Vec<TestCaseCtx>,
}

impl TestSuiteBuilder {
    pub async fn create() -> Result<Self> {
        let url = dotenv_load::db_url();
        println!("Trying to connect to db at {url}");
        let pool = MySqlPool::connect(&url).await?;

        Ok(Self {
            pool,
            tests: vec![],
        })
    }

    pub fn add_test(
        mut self,
        test_case: impl EndpointTestCase + 'static,
        endpoint_url: impl IntoUrl,
    ) -> Result<Self> {
        self.tests.push(TestCaseCtx {
            test: Box::new(test_case),
            endpoint: endpoint_url.into_url()?,
        });
        Ok(self)
    }

    pub fn compile(self) -> TestPool {
        let http_client = Client::new();
        TestPool {
            test_cases: self.tests,
            pool: self.pool,
            http_client,
        }
    }
}

pub struct TestPool {
    pool: MySqlPool,
    test_cases: Vec<TestCaseCtx>,
    http_client: Client,
}

impl TestPool {
    /// Execute all the test.
    /// Please note that before every test is ran, whole database is dropped and reinitialized using the provided database connection pool.
    pub async fn execute(self) -> Result<()> {
        for TestCaseCtx { test, endpoint } in self.test_cases {
            // let init_script_path = dotenv_load::get_path();
            // println!("Reloading the database");
            // database::drop_all_tables(&self.pool).await?;
            // database::execute_file(&init_script_path, &self.pool).await?;
            // println!("Initialized the database with {init_script_path}");
            test.execute(endpoint, &self.http_client).await?;
        }
        Ok(())
    }
}
