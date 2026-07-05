CREATE TABLE credit_applications (
    id BIGSERIAL PRIMARY KEY,
    customer_id BIGINT NOT NULL,
    vehicle_id BIGINT NOT NULL,
    loan_amount NUMERIC(19, 2) NOT NULL,
    tenor_month INTEGER NOT NULL,
    status VARCHAR(30) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_credit_applications_customer
        FOREIGN KEY (customer_id)
        REFERENCES customers (id),

    CONSTRAINT fk_credit_applications_vehicle
        FOREIGN KEY (vehicle_id)
        REFERENCES vehicles (id)
);