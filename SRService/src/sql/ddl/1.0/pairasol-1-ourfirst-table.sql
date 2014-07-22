CREATE TABLE `thing` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(500) NOT NULL,
  `name` varchar(150) NOT NULL,
  `rate` bigint(20) NOT NULL,
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `created_by` varchar(45) NOT NULL,
  `updated_by` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_jpo6dujb9bu42rmu2mmqrb8i4` (`rate`)
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=latin1;

CREATE TABLE users (
   username VARCHAR(50) NOT NULL PRIMARY KEY,
   password VARCHAR(50) NOT NULL,
   enabled BIT NOT NULL
);

CREATE TABLE authorities (
   username VARCHAR(50) NOT NULL,
   authority VARCHAR(50) NOT NULL
);
CREATE UNIQUE INDEX ix_auth_username ON authorities (username, authority);

ALTER TABLE authorities ADD CONSTRAINT fk_authorities_users foreign key (username) REFERENCES users(username);

INSERT INTO users VALUES ('jorge', 'jorge', true);
INSERT INTO users VALUES ('george', 'george', true);
INSERT INTO users VALUES ('tylor', 'tylor', true);

INSERT INTO authorities VALUES ('jorge', 'ROLE_USER');
INSERT INTO authorities VALUES ('jorge', 'ROLE_ADMIN');
INSERT INTO authorities VALUES ('george', 'ROLE_USER');
INSERT INTO authorities VALUES ('tylor', 'ROLE_USER');