use dotenv_codegen::dotenv;

pub fn get_path() -> String {
    dotenv!("DB_INIT_FILE_PATH").into()
}

pub fn db_url() -> String {
    dotenv!("DATABASE_URL").into()
}
