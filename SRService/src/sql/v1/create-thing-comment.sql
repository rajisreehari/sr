CREATE TABLE thing_comment (
  id int(11) NOT NULL AUTO_INCREMENT,
  thing_id bigint(20) NOT NULL,
  comment varchar(400) NOT NULL,
  created_by varchar(100) NOT NULL,
  updated_by varchar(100) NOT NULL,
  created_time datetime NOT NULL DEFAULT NOW(),
  updated_time datetime NOT NULL DEFAULT NOW(),
  main_image_path varchar(250) DEFAULT NULL,
  thumb_image_path varchar(250) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

