create table ShipWreck (
    id bigint auto_increment,
    name varchar(50),
    description varchar(2000),
    condition varchar(255),
    depth int,
    discovered_year int,
    latitude double,
    longitude double
);