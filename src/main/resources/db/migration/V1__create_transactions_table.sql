CREATE TABLE transactions (
                              id SERIAL PRIMARY KEY,
                              amount DECIMAL(10, 2) NOT NULL,
                              currency VARCHAR(3) NOT NULL,
                              transaction_date TIMESTAMP NOT NULL,
                              limit_exceeded BOOLEAN NOT NULL,
                              user_id BIGINT REFERENCES users(id)
);