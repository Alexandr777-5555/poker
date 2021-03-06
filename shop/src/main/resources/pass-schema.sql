CREATE TABLE USERS (
    USERNAME    VARCHAR(50)    NOT NULL,
    PASSWORD    VARCHAR(70)    NOT NULL,
    ENABLED     SMALLINT,
    PRIMARY KEY (USERNAME)
);

CREATE TABLE AUTHORITIES (
    USERNAME    VARCHAR(50)    NOT NULL,
    AUTHORITY   VARCHAR(50)    NOT NULL,
    FOREIGN KEY (USERNAME) REFERENCES USERS
);