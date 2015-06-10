CREATE TABLE thing (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  description varchar(500) NOT NULL COMMENT 'Use for display and searching.',
  name varchar(140) NOT NULL COMMENT 'The name of the thing and this field get''s posted to twitter if the creator decides to tweet.',
  created_by varchar(100) NOT NULL,
  updated_by varchar(100) NOT NULL,
  rate bigint(50) NOT NULL COMMENT 'This is the current voting rate of the thing.',
  author_vote bigint(50) DEFAULT NULL COMMENT 'this is the vote the author of the thing posted when the thing was created.',
  number_of_votes bigint(20) DEFAULT NULL COMMENT 'The number of people that have voted on this thing',
  created_time datetime NOT NULL DEFAULT NOW(),
  updated_time datetime NOT NULL DEFAULT NOW(),
  main_image_path varchar(250) DEFAULT NULL,
  thumb_image_path varchar(250) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FK_jpo6dujb9bu42rmu2mmqrb8i4 (rate)
) ENGINE=InnoDB AUTO_INCREMENT=233 DEFAULT CHARSET=utf8;