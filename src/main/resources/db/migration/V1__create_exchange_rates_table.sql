CREATE TABLE exchange_rates (
                                id SERIAL PRIMARY KEY,
                                base_currency VARCHAR(3) NOT NULL,
                                quote_currency VARCHAR(3) NOT NULL,
                                rate DECIMAL(10, 6) NOT NULL,
                                rate_date DATE NOT NULL
);
