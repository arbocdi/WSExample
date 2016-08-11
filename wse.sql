--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: user_data; Type: SCHEMA; Schema: -; Owner: -
--

CREATE SCHEMA user_data;


--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: -
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = user_data, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: token_history; Type: TABLE; Schema: user_data; Owner: -; Tablespace: 
--

CREATE TABLE token_history (
    id bigint NOT NULL,
    u_email text NOT NULL,
    u_token text NOT NULL,
    u_token_expire timestamp with time zone NOT NULL
);


--
-- Name: token_history_id_seq; Type: SEQUENCE; Schema: user_data; Owner: -
--

CREATE SEQUENCE token_history_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: token_history_id_seq; Type: SEQUENCE OWNED BY; Schema: user_data; Owner: -
--

ALTER SEQUENCE token_history_id_seq OWNED BY token_history.id;


--
-- Name: users; Type: TABLE; Schema: user_data; Owner: -; Tablespace: 
--

CREATE TABLE users (
    u_email text NOT NULL,
    u_pw text NOT NULL,
    u_token text,
    u_token_expire timestamp with time zone
);


--
-- Name: id; Type: DEFAULT; Schema: user_data; Owner: -
--

ALTER TABLE ONLY token_history ALTER COLUMN id SET DEFAULT nextval('token_history_id_seq'::regclass);


--
-- Data for Name: token_history; Type: TABLE DATA; Schema: user_data; Owner: -
--

COPY token_history (id, u_email, u_token, u_token_expire) FROM stdin;
1	fpi@bk.ru	5145ce4a-fbab-4e67-8fff-a62c958e4e1d	2016-08-10 16:17:41.209+06
2	fpi@bk.ru	14845373-dd1e-4536-9d6d-8a0a70adcb32	2016-08-10 16:18:54.866+06
3	fpi@bk.ru	967f5f5b-f08c-44c0-832b-8c87321135f5	2016-08-10 16:18:56.417+06
4	fpi@bk.ru	32813263-b263-4013-a2e5-235909568af8	2016-08-11 10:31:08.08+06
5	fpi@bk.ru	f69ff6bf-cac7-4596-b5b8-974fd8b2d5fb	2016-08-11 10:31:52.553+06
6	fpi@bk.ru	5e0d6572-861c-418a-a9b5-795fa8b8f9b1	2016-08-11 10:31:53.488+06
7	fpi@bk.ru	90914b5f-0aad-4475-b757-f37bfd1597e2	2016-08-11 10:31:53.858+06
8	fpi@bk.ru	0fcfa552-9ecb-424e-9ed5-b89357e185cb	2016-08-11 10:31:54.086+06
9	fpi@bk.ru	d584ef59-8dd3-4d7d-8124-ef37772733f5	2016-08-11 10:31:54.287+06
10	fpi@bk.ru	84082027-ed79-4f71-a1c6-97a2b958b20f	2016-08-11 10:31:54.488+06
11	fpi@bk.ru	88bfcd92-1386-4328-8133-62e59e76bba4	2016-08-11 10:31:54.696+06
12	fpi@bk.ru	5c81734e-89d9-42d1-91ba-297e14eb3546	2016-08-11 10:31:54.887+06
13	fpi@bk.ru	e4540456-9e20-43d1-b760-71b848256638	2016-08-11 10:31:55.072+06
14	fpi@bk.ru	efd7db90-06a1-4212-8af3-cf5c5ef3f7f4	2016-08-11 10:31:55.279+06
15	fpi@bk.ru	f1fba1e2-52f4-4f43-87dc-e633ae1fda84	2016-08-11 10:31:55.462+06
16	fpi@bk.ru	30297a86-ac7c-4fa9-8eaf-d8b040f51c1c	2016-08-11 10:31:55.671+06
17	fpi@bk.ru	54d56e92-620d-4ece-9a5a-51fcae02d415	2016-08-11 10:31:55.886+06
18	fpi@bk.ru	6c3cb142-2ec3-4058-bc30-540c6f3301c5	2016-08-11 10:31:56.096+06
19	fpi@bk.ru	371a7091-8987-4dbb-939d-9fb2a95cca1c	2016-08-11 10:31:56.31+06
20	fpi@bk.ru	f278156d-7d51-4577-8fd0-47e7741ab2e6	2016-08-11 10:31:56.849+06
21	fpi@bk.ru	7a5d480b-8ece-4f8d-8916-3243e452fee8	2016-08-11 10:31:57.038+06
22	fpi@bk.ru	552bf084-a42c-41ed-b872-5896cd655c0a	2016-08-11 10:31:57.246+06
\.


--
-- Name: token_history_id_seq; Type: SEQUENCE SET; Schema: user_data; Owner: -
--

SELECT pg_catalog.setval('token_history_id_seq', 22, true);


--
-- Data for Name: users; Type: TABLE DATA; Schema: user_data; Owner: -
--

COPY users (u_email, u_pw, u_token, u_token_expire) FROM stdin;
fpi@bk.ru	123123	552bf084-a42c-41ed-b872-5896cd655c0a	2016-08-11 10:31:57.246+06
\.


--
-- Name: token_history_pkey; Type: CONSTRAINT; Schema: user_data; Owner: -; Tablespace: 
--

ALTER TABLE ONLY token_history
    ADD CONSTRAINT token_history_pkey PRIMARY KEY (id);


--
-- Name: users_pkey; Type: CONSTRAINT; Schema: user_data; Owner: -; Tablespace: 
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (u_email);


--
-- Name: token_history_u_email_fkey; Type: FK CONSTRAINT; Schema: user_data; Owner: -
--

ALTER TABLE ONLY token_history
    ADD CONSTRAINT token_history_u_email_fkey FOREIGN KEY (u_email) REFERENCES users(u_email) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: public; Type: ACL; Schema: -; Owner: -
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

