alter table sm_post modify column posted_on datetime;
alter table sm_post modify column modified_on datetime;


INSERT INTO app.sm_config_type (id, deleted, description, inactive, name, value) VALUES ('locations', 0, 'Locations', 0, 'Locations', 'Locations');

INSERT INTO app.sm_app_config (id, deleted, description, inactive, name, sm_config_type_id) VALUES (1, 0, 'Sylhet', 0, 'Sylhet', 'locations');
INSERT INTO app.sm_app_config (id, deleted, description, inactive, name, sm_config_type_id) VALUES (2, 0, 'Bandarban', 0, 'Bandarban', 'locations');
INSERT INTO app.sm_app_config (id, deleted, description, inactive, name, sm_config_type_id) VALUES (3, 0, 'Khulna', 0, 'Khulna', 'locations');

INSERT INTO app.sm_user_detail (id, address, deleted, email, father_name, first_name, gender, inactive, last_name, mother_name, phone, sm_user_id, DESIGNATION) VALUES (1, 'Dhaka', 0, 'shikhor@gmail.com', 'S', 'SK.', 'M', 0, 'Roy', 'SH.', '01788210215', 1, null);
INSERT INTO app.sm_user_detail (id, address, deleted, designation, email, father_name, first_name, gender, inactive, last_name, mother_name, phone, sm_user_id) VALUES (2, null, 0, 'Admin', '', null, 'Root', null, 0, 'User', null, '', null);

INSERT INTO app.sm_user (id, deleted, inactive, sm_config_type_id, username) VALUES (1, 0, 0, null, 'roy');
INSERT INTO app.sm_user (id, deleted, inactive, password, sm_config_type_id, username) VALUES (2, 0, 0, '$2a$10$mls2vIDenxTAQluuslAu8OB6ij3XHc2SHqpjEPSzW4/WPduTk.nS2', null, 'user');

INSERT INTO app.sm_post (id, deleted, inactive, modified_on, posted_on, privacy, sm_app_config_id, status, sm_user_id) VALUES (3, 0, 0, '2019-05-11 00:00:00', null, 'PUBLIC', 1, 'Test', 1);
INSERT INTO app.sm_post (id, deleted, inactive, modified_on, posted_on, privacy, sm_app_config_id, status, sm_user_id) VALUES (4, 0, 0, '2019-05-11 00:00:00', null, 'PUBLIC', 2, 'This is my first public post. Add Another Line.', 1);
INSERT INTO app.sm_post (id, deleted, inactive, modified_on, posted_on, privacy, sm_app_config_id, status, sm_user_id) VALUES (5, 0, 0, '2019-05-11 00:00:00', '2019-05-11 00:00:00', 'PUBLIC', null, 'This is my another public post.', 1);
INSERT INTO app.sm_post (id, deleted, inactive, modified_on, posted_on, privacy, sm_app_config_id, status, sm_user_id) VALUES (6, 0, 0, '2019-05-11 00:00:00', null, 'PRIVATE', 1, 'Evaluate empty or null JSTL c tags

How can I validate if a String is null or empty using the c tags of JSTL?

I have a variable of name var1 and I can display it, but I want to add a comparator to validate it.

<c:out value="${var1}" />
I want to validate when it is null or empty (my values are strings).', 1);
INSERT INTO app.sm_post (id, deleted, inactive, modified_on, posted_on, privacy, sm_app_config_id, status, sm_user_id) VALUES (7, 0, 0, '2019-05-11 00:00:00', null, 'PUBLIC', 3, 'Other than RedirectView , Spring provides another option to perform redirection, that is return redirected url as String with prefix ''redirect:''

The net effect is the same as if the controller had returned a RedirectView, but with this option the controller itself can simply operate in terms of logical view names.

The prefix ''redirect:'' is a special directive for the view resolver to treat the returned string as URL redirection rather than as a view name.

A logical view name such as redirect:/some/resource will redirect relative to the current Servlet context, while a name such as redirect:http://www.example.com/path will redirect to an absolute URL.', 1);
INSERT INTO app.sm_post (id, deleted, inactive, modified_on, posted_on, privacy, sm_app_config_id, status, sm_user_id) VALUES (8, 0, 0, '2019-05-11 00:00:00', null, 'PUBLIC', 1, 'This application has no explicit mapping for /error, so you are seeing this as a fallback.

Sat May 11 18:38:02 BDT 2019
There was an unexpected error (type=Internal Server Error, status=500).
The request was rejected because the URL was not normalized.
org.springframework.security.web.firewall.RequestRejectedException: The request was rejected', 1);
