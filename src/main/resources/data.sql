DROP TABLE IF EXISTS flights;

CREATE TABLE flights (
    flight_id INTEGER PRIMARY KEY NOT NULL,
    flight_number INTEGER NOT NULL,
    departure_airport_IATA_code VARCHAR(3) NOT NULL,
    arrival_airport_IATA_code VARCHAR(3) NOT NULL,
    departure_date VARCHAR NOT NULL
);

INSERT INTO flights VALUES (1, 4197, 'SEA', 'MIT', '2019-05-27T01:29:31'),
                           (2, 2583, 'YYZ', 'PPX', '2018-11-12T06:08:13'),
                           (3, 4050, 'YYT', 'MIT', '2017-12-26T08:41:41'),
                           (4, 8508, 'ANC', 'MIT', '2017-05-12T06:07:07'),
                           (5, 2537, 'YYT', 'MIT', '2016-11-09T08:22:39');

DROP TABLE IF EXISTS baggage;

CREATE TABLE baggage (
    id INTEGER PRIMARY KEY NOT NULL,
    weight INTEGER NOT NULL,
    weight_unit VARCHAR(2) NOT NULL,
    pieces INTEGER NOT NULL
);

INSERT INTO baggage VALUES    (1,443,'kg',819),
                                (2,832,'kg',345),
                                (3,198,'kg',507),
                                (4,12,'kg',257),
                                (5,532,'lb',644),
                                (6,41,'kg',438),
                                (7,232,'lb',620),
                                (8,554,'lb',258),
                                (9,276,'kg',982),
                                (10,880,'lb',911),
                                (11,707,'kg',127),
                                (12,445,'lb',859),
                                (13,70,'lb',539),
                                (14,704,'lb',810),
                                (15,766,'lb',915),
                                (16,811,'kg',186),
                                (17,398,'lb',940),
                                (18,457,'lb',390),
                                (19,833,'lb',241),
                                (20,883,'lb',629),
                                (21,936,'lb',856),
                                (22,485,'lb',851),
                                (23,425,'lb',400),
                                (24,816,'kg',216),
                                (25,4,'kg',505),
                                (26,142,'kg',351),
                                (27,284,'lb',160),
                                (28,514,'lb',786),
                                (29,341,'kg',802),
                                (30,666,'kg',821),
                                (31,322,'kg',497),
                                (32,704,'kg',786);

DROP TABLE IF EXISTS cargo;

CREATE TABLE cargo (
    id INTEGER PRIMARY KEY NOT NULL,
    weight INTEGER NOT NULL,
    weight_unit VARCHAR(2) NOT NULL,
    pieces INTEGER NOT NULL
);

INSERT INTO cargo VALUES  (1,351,'lb',373),
                            (2,216,'lb',620),
                            (3,616,'kg',949),
                            (4,2,'lb',71),
                            (5,998,'kg',21),
                            (6,932,'kg',78),
                            (7,572,'lb',498),
                            (8,520,'lb',591),
                            (9,482,'kg',242),
                            (10,105,'lb',975),
                            (11,159,'kg',718),
                            (12,852,'lb',834),
                            (13,560,'lb',837),
                            (14,142,'kg',975),
                            (15,126,'lb',818),
                            (16,247,'kg',128),
                            (17,136,'lb',717),
                            (18,501,'kg',599),
                            (19,936,'kg',912);

DROP TABLE IF EXISTS flight_baggage;

CREATE TABLE flight_baggage (
    id INTEGER PRIMARY KEY NOT NULL,
    flight_id INTEGER NOT NULL,
    baggage_id INTEGER NOT NULL
);

DROP TABLE IF EXISTS flight_cargo;

CREATE TABLE flight_cargo (
    id INTEGER PRIMARY KEY NOT NULL,
    flight_id INTEGER NOT NULL,
    cargo_id INTEGER NOT NULL
);

INSERT INTO flight_baggage VALUES   (1,1,1),
                                    (2,1,2),
                                    (3,1,3),
                                    (4,1,4),
                                    (5,1,5),
                                    (6,1,6),
                                    (7,2,7),
                                    (8,2,8),
                                    (9,2,9),
                                    (10,2,10),
                                    (11,2,11),
                                    (12,2,12),
                                    (13,2,13),
                                    (14,3,14),
                                    (15,3,15),
                                    (16,3,16),
                                    (17,3,17),
                                    (18,3,18),
                                    (19,3,19),
                                    (20,4,20),
                                    (21,4,21),
                                    (22,4,22),
                                    (23,4,23),
                                    (24,4,24),
                                    (25,4,25),
                                    (26,5,26),
                                    (27,5,27),
                                    (28,5,28),
                                    (29,5,29),
                                    (30,5,30),
                                    (31,5,31),
                                    (32,5,32);

INSERT INTO flight_cargo VALUES
                                (1,1,1),
                                (2,1,2),
                                (3,1,3),
                                (4,1,4),
                                (5,2,5),
                                (6,2,6),
                                (7,2,7),
                                (8,2,8),
                                (9,3,9),
                                (10,3,10),
                                (11,3,11),
                                (12,3,12),
                                (13,4,13),
                                (14,4,14),
                                (15,4,15),
                                (16,4,16),
                                (17,5,17),
                                (18,5,18),
                                (19,5,19);


