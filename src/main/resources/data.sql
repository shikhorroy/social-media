alter table sm_post modify column posted_on datetime;
alter table sm_post modify column modified_on datetime;


INSERT INTO app.sm_config_type (ID, NAME, DESCRIPTION, VALUE, INACTIVE, DELETED) VALUES ('locations', 'Locations', 'Locations', 'Locations', 0, 0);

INSERT INTO app.sm_app_config (ID, SM_CONFIG_TYPE_ID, NAME, DESCRIPTION, INACTIVE, DELETED) VALUES (1, 'locations', 'Sylhet', 'Sylhet', 0, 0);
INSERT INTO app.sm_app_config (ID, SM_CONFIG_TYPE_ID, NAME, DESCRIPTION, INACTIVE, DELETED) VALUES (2, 'locations', 'Bandarban', 'Bandarban', 0, 0);
INSERT INTO app.sm_app_config (ID, SM_CONFIG_TYPE_ID, NAME, DESCRIPTION, INACTIVE, DELETED) VALUES (3, 'locations', 'Khulna', 'Khulna', 0, 0);
