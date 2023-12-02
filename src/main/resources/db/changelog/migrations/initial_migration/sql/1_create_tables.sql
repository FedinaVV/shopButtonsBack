CREATE table buttons
(
    id         serial,
    title      varchar not null,
    price      int     not null,
    image      varchar,
    confige_id int     not null unique,
    created_at timestamptz  not null default now(),
    updated_at timestamptz,
    deleted_at timestamptz
);

CREATE TABLE configures
(
    id       SERIAL,
    diameter INT     not null,
    color    VARCHAR not null,
    height   INT     not null,
    code     INT     not null,
    created_at timestamptz  not null default now(),
    updated_at timestamptz,
    deleted_at timestamptz
);

CREATE TABLE basket
(
    id SERIAL,
    button_id INT,
    confige_id INT,
    user_id INT,
    created_at timestamptz not null default now(),
    updated_at timestamptz,
    deleted_at timestamptz
);
