--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.4
-- Dumped by pg_dump version 9.5.4

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET search_path = public, pg_catalog;

--
-- Data for Name: authority; Type: TABLE DATA; Schema: public; Owner: kanelones
--

INSERT INTO authority (id, authority, description) VALUES (0, 'root', 'Permiso para ser Super Usuario');
INSERT INTO authority (id, authority, description) VALUES (1, 'Alumnos', 'permiso para el modulo alumnos');


--
-- Data for Name: role; Type: TABLE DATA; Schema: public; Owner: kanelones
--

INSERT INTO role (id, description, rolename) VALUES (0, 'Rol SuperUsuario', 'root');
INSERT INTO role (id, description, rolename) VALUES (1, 'rol de ejemplo, limitado a usar el modulo alumnos', 'alumno');


--
-- Data for Name: roleauthority; Type: TABLE DATA; Schema: public; Owner: kanelones
--

INSERT INTO roleauthority (id, authority_id, role_id) VALUES (0, 0, 0);
INSERT INTO roleauthority (id, authority_id, role_id) VALUES (1, 1, 1);


--
-- Data for Name: userinfo; Type: TABLE DATA; Schema: public; Owner: kanelones
--

INSERT INTO userinfo (id, active, password, username) VALUES (0, true, 'sql', 'root');


--
-- Data for Name: userrole; Type: TABLE DATA; Schema: public; Owner: kanelones
--

INSERT INTO userrole (id, description, role_id, userinfo_id) VALUES (0, NULL, 0, 0);


--
-- PostgreSQL database dump complete
--



select setval('authority_id_seq', max(id) + 1) from authority;

select setval('role_id_seq', max(id) + 1) from role;

select setval('roleauthority_id_seq', max(id) + 1) from roleauthority;

select setval('userrole_id_seq', max(id) + 1) from userrole;

select setval('user_id_seq', max(id) + 1) from userinfo;
