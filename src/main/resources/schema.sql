
/*
CREATE TABLE oauth_access_token (
  token_id VARCHAR(256) DEFAULT NULL,
  token BYTEA,
  authentication_id VARCHAR(256) DEFAULT NULL,
  user_name VARCHAR(256) DEFAULT NULL,
  client_id VARCHAR(256) DEFAULT NULL,
  authentication BYTEA,
  refresh_token VARCHAR(256) DEFAULT NULL
 );
 
CREATE TABLE oauth_refresh_token (
  token_id VARCHAR(256) DEFAULT NULL,
  token BYTEA,
  authentication BYTEA
 );
 
  CREATE TABLE shop_oauth2_authority (
  name VARCHAR(50) NOT NULL PRIMARY KEY
 );
 
 CREATE TABLE oauth2_user_authority (
 bmb_user_id BIGINT NOT NULL,
   username VARCHAR(50) NOT NULL,
   authority VARCHAR(50) NOT NULL,
   FOREIGN KEY (bmb_user_id) REFERENCES shop_bmb_user (bmb_user_id),
   FOREIGN KEY (authority) REFERENCES shop_oauth2_authority (name)
 );
*/