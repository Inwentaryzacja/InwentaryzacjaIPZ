FROM rust:latest as rust-builder

RUN cargo install cargo-build-dependencies

RUN cd /tmp && USER=root cargo new --bin rest_api_tests

WORKDIR /tmp/rest_api_tests

COPY rest_api_tests/Cargo.toml rest_api_tests/Cargo.lock ./

RUN cargo build-dependencies --release

COPY rest_api_tests/src /tmp/rest_api_tests/src

COPY rest_api_tests/.env .env
RUN cargo build --release


FROM debian:stable-slim


COPY ./db/init.sql .

WORKDIR /app

RUN apt update \
    && apt install -y openssl ca-certificates \
    && apt clean \
    && rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*

COPY --from=rust-builder /tmp/rest_api_tests/target/release/rest_api_tests ./

CMD ["/app/rest_api_tests"]
