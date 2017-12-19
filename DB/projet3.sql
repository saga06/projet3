--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.6
-- Dumped by pg_dump version 9.6.6

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: image; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE image (
    id integer NOT NULL,
    alt character varying,
    title character varying,
    path character varying,
    id_site integer
);


ALTER TABLE image OWNER TO postgres;

--
-- Name: length; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE length (
    id integer NOT NULL,
    name character varying,
    id_way integer,
    description character varying
);


ALTER TABLE length OWNER TO postgres;

--
-- Name: point; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE point (
    id integer NOT NULL,
    id_length integer,
    name character varying,
    description character varying
);


ALTER TABLE point OWNER TO postgres;

--
-- Name: sector; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE sector (
    id integer NOT NULL,
    name character varying(15),
    description character varying(300),
    id_site integer
);


ALTER TABLE sector OWNER TO postgres;

--
-- Name: site; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE site (
    id integer NOT NULL,
    name character varying(15),
    location character varying(30),
    postcode integer,
    latitude real,
    longitude real,
    description character varying
);


ALTER TABLE site OWNER TO postgres;

--
-- Name: topo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE topo (
    id integer NOT NULL,
    name character varying,
    description character varying,
    free boolean,
    id_site integer
);


ALTER TABLE topo OWNER TO postgres;

--
-- Name: user; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "user" (
    id integer NOT NULL,
    login character varying,
    password character varying,
    role integer
);


ALTER TABLE "user" OWNER TO postgres;

--
-- Name: user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE user_id_seq OWNER TO postgres;

--
-- Name: user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE user_id_seq OWNED BY "user".id;


--
-- Name: way; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE way (
    id integer NOT NULL,
    id_sector integer,
    name character varying,
    height real,
    quotation character varying
);


ALTER TABLE way OWNER TO postgres;

--
-- Name: user id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "user" ALTER COLUMN id SET DEFAULT nextval('user_id_seq'::regclass);


--
-- Name: image image_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY image
    ADD CONSTRAINT image_pkey PRIMARY KEY (id);


--
-- Name: length length_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY length
    ADD CONSTRAINT length_pkey PRIMARY KEY (id);


--
-- Name: point point_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY point
    ADD CONSTRAINT point_pkey PRIMARY KEY (id);


--
-- Name: sector sector_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sector
    ADD CONSTRAINT sector_pkey PRIMARY KEY (id);


--
-- Name: site site_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY site
    ADD CONSTRAINT site_pkey PRIMARY KEY (id);


--
-- Name: topo topo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY topo
    ADD CONSTRAINT topo_pkey PRIMARY KEY (id);


--
-- Name: user user_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "user"
    ADD CONSTRAINT user_pkey PRIMARY KEY (id);


--
-- Name: way way_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY way
    ADD CONSTRAINT way_pkey PRIMARY KEY (id);


--
-- Name: fki_id_length; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_id_length ON point USING btree (id_length);


--
-- Name: fki_id_sector; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_id_sector ON way USING btree (id_sector);


--
-- Name: fki_id_site; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_id_site ON sector USING btree (id_site);


--
-- Name: fki_id_way; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_id_way ON length USING btree (id_way);


--
-- Name: point id_length; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY point
    ADD CONSTRAINT id_length FOREIGN KEY (id_length) REFERENCES length(id);


--
-- Name: way id_sector; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY way
    ADD CONSTRAINT id_sector FOREIGN KEY (id_sector) REFERENCES sector(id);


--
-- Name: sector id_site; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sector
    ADD CONSTRAINT id_site FOREIGN KEY (id_site) REFERENCES site(id);


--
-- Name: image id_site; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY image
    ADD CONSTRAINT id_site FOREIGN KEY (id_site) REFERENCES site(id);


--
-- Name: topo id_site; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY topo
    ADD CONSTRAINT id_site FOREIGN KEY (id_site) REFERENCES site(id);


--
-- Name: length id_way; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY length
    ADD CONSTRAINT id_way FOREIGN KEY (id_way) REFERENCES way(id);


--
-- PostgreSQL database dump complete
--

