CREATE TABLE social (
  username varchar(100) NOT NULL,
  network_name varchar(100) NOT NULL,
  twitter_oauth_access_token varchar(400) NOT NULL,
  twitter_oauth_access_token_secret varchar(400) NOT NULL,
  created_by varchar(100) NOT NULL,
  updated_by varchar(100) NOT NULL,
  created_time datetime NOT NULL DEFAULT NOW(),
  updated_time datetime NOT NULL DEFAULT NOW(),
  PRIMARY KEY (username)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;