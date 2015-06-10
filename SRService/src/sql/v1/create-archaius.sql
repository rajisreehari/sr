create table system_properties (
  property_key VARCHAR(40) NOT NULL PRIMARY KEY,
  property_value VARCHAR (500) NOT NULL,
  property_description VARCHAR(255),
  created_by VARCHAR(30) DEFAULT 'SUCKRATE' NOT NULL,
  created_dt TIMESTAMP DEFAULT now() NOT NULL,
  last_updated_by VARCHAR(30) DEFAULT 'SUCKRATE' NOT NULL,
  last_updated_dt TIMESTAMP DEFAULT now() NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;