CREATE TABLE users (
  user_id int(11) NOT NULL AUTO_INCREMENT,
  username varchar(100) NOT NULL,
  password varchar(50) NOT NULL,
  created_by varchar(100) DEFAULT NULL,
  updated_by varchar(100) DEFAULT NULL,
  first_name varchar(200) DEFAULT NULL,
  last_name varchar(200) DEFAULT NULL,
  enabled bit(1) NOT NULL,
  created_time datetime DEFAULT NULL,
  updated_time datetime DEFAULT NULL,
  PRIMARY KEY (user_id)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;