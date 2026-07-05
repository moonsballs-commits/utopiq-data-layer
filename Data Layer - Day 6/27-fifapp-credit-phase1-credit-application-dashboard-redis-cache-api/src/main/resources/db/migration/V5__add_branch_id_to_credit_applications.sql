ALTER TABLE credit_applications
ADD COLUMN branch_id BIGINT NOT NULL DEFAULT 10;

CREATE INDEX idx_credit_applications_branch_id
ON credit_applications (branch_id);

CREATE INDEX idx_credit_applications_branch_status
ON credit_applications (branch_id, status);