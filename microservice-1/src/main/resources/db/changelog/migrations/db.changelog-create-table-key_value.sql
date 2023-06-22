-- changeset OlegM:1

CREATE TABLE key_value
(
    id bigint NOT NULL,
    value character varying(255),
    CONSTRAINT key_value_pkey PRIMARY KEY (id)
)