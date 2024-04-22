CREATE TABLE app_user (
                         id BIGSERIAL PRIMARY KEY NOT NULL,
                       username VARCHAR(255) NOT NULL,
                         email VARCHAR(255) NOT NULL,
--                        goods_monthly_limit_usd DECIMAL(10, 2) DEFAULT 1000.00,
--                        services_monthly_limit_usd DECIMAL(10, 2) DEFAULT 1000.00,
--                        limit_set_date TIMESTAMP
);
