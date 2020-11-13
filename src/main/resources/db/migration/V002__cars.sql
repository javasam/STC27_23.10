create table cars
(
    id  serial not null
        constraint cars_pk
            primary key,
    model_name varchar,
    price bigint
);

INSERT INTO cars (id, model_name, price)
VALUES (1, 'Toyota', 130000),
       (2, 'BMW', 500000),
       (3, 'JEEP', 550000),
       (4, 'HONDA', 190000),
       (5, 'LADA', 180000);