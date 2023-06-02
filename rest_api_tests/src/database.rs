use std::path::Path;

use anyhow::Result;
use itertools::Itertools;
use sqlx::MySqlPool;
use sqlx::Row;
use tokio::fs::File;
use tokio::io::AsyncReadExt;

/// Drop all tables from database using provided database pool;
/// Returns Error if any query to the database has failed.
pub async fn drop_all_tables(pool: &MySqlPool) -> Result<()> {
    let table_names = sqlx::query("SHOW TABLES;")
        .fetch_all(pool)
        .await?
        .iter()
        .map(|row| {
            let table_name: String = row.get(0);
            table_name
        })
        .collect_vec();

    for table_name in table_names {
        let q = format!("DROP TABLE IF EXISTS `{}`;", table_name);
        sqlx::query(&q).execute(pool).await?;
    }

    Ok(())
}

// Executes the file on mysql pool.
pub async fn execute_file(path: impl AsRef<Path>, pool: &MySqlPool) -> Result<()> {
    let mut file = File::open(path).await?;
    let mut contents = String::new();
    file.read_to_string(&mut contents).await?;

    let statements: Vec<&str> = contents.split(';').collect();

    for statement in statements {
        if !statement.trim().is_empty() {
            sqlx::query(statement).execute(pool).await?;
        }
    }

    Ok(())
}
