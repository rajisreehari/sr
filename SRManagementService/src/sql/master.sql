DROP ALL OBJECTS;
CREATE SCHEMA suckrate;

RUNSCRIPT FROM 'classpath:sql/v1/changelog.sql';
