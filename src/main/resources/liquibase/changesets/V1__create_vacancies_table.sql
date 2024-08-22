--changeset Miroslav Kosiuk:vacancies-1
CREATE TABLE schema_vacancies.vacancies
(
    slug         VARCHAR(256) PRIMARY KEY,
    company_name VARCHAR(128) NOT NULL,

    title        VARCHAR(256) NOT NULL,
    description  TEXT         NOT NULL,
    remote       BOOLEAN      NOT NULL,

    url          VARCHAR(256),

    location     VARCHAR(128)
);

CREATE INDEX u_idx_vacancies_company_name ON schema_vacancies.vacancies (company_name);
CREATE INDEX u_idx_vacancies_location ON schema_vacancies.vacancies (location);
