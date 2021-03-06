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
-- Name: comment; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE comment (
    comment_id integer NOT NULL,
    content character varying NOT NULL,
    site_id integer NOT NULL,
    user_nickname character varying
);


ALTER TABLE comment OWNER TO postgres;

--
-- Name: comment_comment_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE comment_comment_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE comment_comment_id_seq OWNER TO postgres;

--
-- Name: comment_comment_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE comment_comment_id_seq OWNED BY comment.comment_id;


--
-- Name: image; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE image (
    alt character varying,
    title character varying,
    path character varying,
    image_id integer NOT NULL,
    site_id integer
);


ALTER TABLE image OWNER TO postgres;

--
-- Name: image_image_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE image_image_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE image_image_id_seq OWNER TO postgres;

--
-- Name: image_image_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE image_image_id_seq OWNED BY image.image_id;


--
-- Name: length; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE length (
    name character varying,
    description character varying,
    length_id integer NOT NULL,
    way_id integer
);


ALTER TABLE length OWNER TO postgres;

--
-- Name: length_length_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE length_length_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE length_length_id_seq OWNER TO postgres;

--
-- Name: length_length_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE length_length_id_seq OWNED BY length.length_id;


--
-- Name: point; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE point (
    name character varying,
    description character varying,
    point_id integer NOT NULL,
    length_id integer
);


ALTER TABLE point OWNER TO postgres;

--
-- Name: point_point_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE point_point_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE point_point_id_seq OWNER TO postgres;

--
-- Name: point_point_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE point_point_id_seq OWNED BY point.point_id;


--
-- Name: sector; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE sector (
    name character varying(15),
    description character varying(300),
    site_id integer,
    sector_id integer NOT NULL
);


ALTER TABLE sector OWNER TO postgres;

--
-- Name: sector_sector_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE sector_sector_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE sector_sector_id_seq OWNER TO postgres;

--
-- Name: sector_sector_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE sector_sector_id_seq OWNED BY sector.sector_id;


--
-- Name: site; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE site (
    name character varying(15),
    location character varying(30),
    description character varying,
    site_id integer NOT NULL,
    latitude character varying,
    longitude character varying,
    zipcode character varying NOT NULL
);


ALTER TABLE site OWNER TO postgres;

--
-- Name: site_site_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE site_site_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE site_site_id_seq OWNER TO postgres;

--
-- Name: site_site_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE site_site_id_seq OWNED BY site.site_id;


--
-- Name: topo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE topo (
    topo_name character varying,
    description character varying,
    free boolean DEFAULT true,
    topo_id integer NOT NULL,
    site_id integer,
    owner_nickname character varying
);


ALTER TABLE topo OWNER TO postgres;

--
-- Name: topo_booking; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE topo_booking (
    topo_booking_id integer NOT NULL,
    topo_booking_topo_id integer NOT NULL,
    topo_booking_borrower_nickname character varying NOT NULL,
    topo_booking_date character varying NOT NULL
);


ALTER TABLE topo_booking OWNER TO postgres;

--
-- Name: topo_booking_topo_booking_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE topo_booking_topo_booking_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE topo_booking_topo_booking_id_seq OWNER TO postgres;

--
-- Name: topo_booking_topo_booking_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE topo_booking_topo_booking_id_seq OWNED BY topo_booking.topo_booking_id;


--
-- Name: topo_topo_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE topo_topo_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE topo_topo_id_seq OWNER TO postgres;

--
-- Name: topo_topo_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE topo_topo_id_seq OWNED BY topo.topo_id;


--
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE users (
    user_id integer NOT NULL,
    email character varying,
    pass character(56) NOT NULL,
    firstname character varying,
    surname character varying,
    nickname character varying NOT NULL
);


ALTER TABLE users OWNER TO postgres;

--
-- Name: user_user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE user_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE user_user_id_seq OWNER TO postgres;

--
-- Name: user_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE user_user_id_seq OWNED BY users.user_id;


--
-- Name: way; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE way (
    name character varying,
    height integer,
    quotation character varying,
    way_id integer NOT NULL,
    sector_id integer,
    nb_point integer
);


ALTER TABLE way OWNER TO postgres;

--
-- Name: way_way_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE way_way_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE way_way_id_seq OWNER TO postgres;

--
-- Name: way_way_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE way_way_id_seq OWNED BY way.way_id;


--
-- Name: comment comment_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY comment ALTER COLUMN comment_id SET DEFAULT nextval('comment_comment_id_seq'::regclass);


--
-- Name: image image_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY image ALTER COLUMN image_id SET DEFAULT nextval('image_image_id_seq'::regclass);


--
-- Name: length length_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY length ALTER COLUMN length_id SET DEFAULT nextval('length_length_id_seq'::regclass);


--
-- Name: point point_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY point ALTER COLUMN point_id SET DEFAULT nextval('point_point_id_seq'::regclass);


--
-- Name: sector sector_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sector ALTER COLUMN sector_id SET DEFAULT nextval('sector_sector_id_seq'::regclass);


--
-- Name: site site_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY site ALTER COLUMN site_id SET DEFAULT nextval('site_site_id_seq'::regclass);


--
-- Name: topo topo_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY topo ALTER COLUMN topo_id SET DEFAULT nextval('topo_topo_id_seq'::regclass);


--
-- Name: topo_booking topo_booking_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY topo_booking ALTER COLUMN topo_booking_id SET DEFAULT nextval('topo_booking_topo_booking_id_seq'::regclass);


--
-- Name: users user_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users ALTER COLUMN user_id SET DEFAULT nextval('user_user_id_seq'::regclass);


--
-- Name: way way_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY way ALTER COLUMN way_id SET DEFAULT nextval('way_way_id_seq'::regclass);


--
-- Name: comment comment_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY comment
    ADD CONSTRAINT comment_pkey PRIMARY KEY (comment_id);


--
-- Name: image image_id; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY image
    ADD CONSTRAINT image_id PRIMARY KEY (image_id);


--
-- Name: length length_id; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY length
    ADD CONSTRAINT length_id PRIMARY KEY (length_id);


--
-- Name: point point_id; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY point
    ADD CONSTRAINT point_id PRIMARY KEY (point_id);


--
-- Name: sector sector_id; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sector
    ADD CONSTRAINT sector_id PRIMARY KEY (sector_id);


--
-- Name: site site_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY site
    ADD CONSTRAINT site_pkey PRIMARY KEY (site_id);


--
-- Name: topo_booking topo_booking_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY topo_booking
    ADD CONSTRAINT topo_booking_pkey PRIMARY KEY (topo_booking_id);


--
-- Name: topo topo_id; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY topo
    ADD CONSTRAINT topo_id PRIMARY KEY (topo_id);


--
-- Name: users user_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users
    ADD CONSTRAINT user_pkey PRIMARY KEY (user_id);


--
-- Name: way way_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY way
    ADD CONSTRAINT way_pkey PRIMARY KEY (way_id);


--
-- Name: fki_length_id; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_length_id ON point USING btree (length_id);


--
-- Name: fki_sector_id; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_sector_id ON way USING btree (sector_id);


--
-- Name: fki_site_id; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_site_id ON sector USING btree (site_id);


--
-- Name: fki_topo_id; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_topo_id ON topo_booking USING btree (topo_booking_topo_id);


--
-- Name: fki_way_id; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_way_id ON length USING btree (way_id);


--
-- Name: comment comment_site_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY comment
    ADD CONSTRAINT comment_site_id_fkey FOREIGN KEY (site_id) REFERENCES site(site_id);


--
-- Name: point length_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY point
    ADD CONSTRAINT length_id FOREIGN KEY (length_id) REFERENCES length(length_id);


--
-- Name: way sector_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY way
    ADD CONSTRAINT sector_id FOREIGN KEY (sector_id) REFERENCES sector(sector_id);


--
-- Name: sector site_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sector
    ADD CONSTRAINT site_id FOREIGN KEY (site_id) REFERENCES site(site_id);


--
-- Name: topo site_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY topo
    ADD CONSTRAINT site_id FOREIGN KEY (site_id) REFERENCES site(site_id);


--
-- Name: image site_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY image
    ADD CONSTRAINT site_id FOREIGN KEY (site_id) REFERENCES site(site_id);


--
-- Name: topo_booking topo_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY topo_booking
    ADD CONSTRAINT topo_id FOREIGN KEY (topo_booking_topo_id) REFERENCES topo(topo_id);


--
-- Name: length way_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY length
    ADD CONSTRAINT way_id FOREIGN KEY (way_id) REFERENCES way(way_id);


--
-- PostgreSQL database dump complete
--
