--
-- PostgreSQL database dump
--

-- Dumped from database version 13.3
-- Dumped by pg_dump version 13.3

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: product; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.product (
    id integer NOT NULL,
    product_name character varying(45) NOT NULL,
    price integer NOT NULL,
    quantity integer NOT NULL
);


ALTER TABLE public.product OWNER TO postgres;

--
-- Name: product_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.product ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.product_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: product_in; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.product_in (
    id integer NOT NULL,
    id_product integer NOT NULL,
    tanggal date NOT NULL,
    quantity integer NOT NULL
);


ALTER TABLE public.product_in OWNER TO postgres;

--
-- Name: product_in_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.product_in ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.product_in_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: product_out; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.product_out (
    id integer NOT NULL,
    id_product integer NOT NULL,
    tanggal date NOT NULL,
    quantity integer NOT NULL
);


ALTER TABLE public.product_out OWNER TO postgres;

--
-- Name: product_out_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.product_out ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.product_out_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: user; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."user" (
    id integer NOT NULL,
    username character varying(50) NOT NULL,
    password character varying(80) NOT NULL,
    first_name character varying(50) NOT NULL,
    last_name character varying(50) NOT NULL,
    email character varying(50)
);


ALTER TABLE public."user" OWNER TO postgres;

--
-- Name: user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public."user" ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Data for Name: product; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.product (id, product_name, price, quantity) FROM stdin;
1	Air Mineral	5000	180
3	Kopi sachet	1500	50
2	Susu Bubuk	25000	50
4	Mie Instan	2500	100
5	Roti Tawar	10000	50
\.


--
-- Data for Name: product_in; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.product_in (id, id_product, tanggal, quantity) FROM stdin;
1	1	2021-06-24	200
2	3	2021-06-24	100
3	2	2021-06-24	100
4	4	2021-06-24	200
5	5	2021-06-24	100
\.


--
-- Data for Name: product_out; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.product_out (id, id_product, tanggal, quantity) FROM stdin;
1	1	2021-06-24	20
2	3	2021-06-24	50
3	2	2021-06-24	50
4	4	2021-06-24	100
5	5	2021-06-24	50
\.


--
-- Data for Name: user; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."user" (id, username, password, first_name, last_name, email) FROM stdin;
1	john	$2a$10$ATSGkmj28WeB6Mmh51CME.oYVEpQdGGDjvnBJTKwtcnUi/QtdPpG6	John	Doe	john@email.com
\.


--
-- Name: product_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.product_id_seq', 5, true);


--
-- Name: product_in_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.product_in_id_seq', 5, true);


--
-- Name: product_out_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.product_out_id_seq', 5, true);


--
-- Name: user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_id_seq', 1, true);


--
-- Name: product_in product_in_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product_in
    ADD CONSTRAINT product_in_pkey PRIMARY KEY (id);


--
-- Name: product_out product_out_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product_out
    ADD CONSTRAINT product_out_pkey PRIMARY KEY (id);


--
-- Name: product product_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product
    ADD CONSTRAINT product_pkey PRIMARY KEY (id);


--
-- Name: user user_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."user"
    ADD CONSTRAINT user_pkey PRIMARY KEY (id);


--
-- Name: product_in FK_PRODUCT_IN; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product_in
    ADD CONSTRAINT "FK_PRODUCT_IN" FOREIGN KEY (id_product) REFERENCES public.product(id);


--
-- Name: product_out FK_PRODUCT_OUT; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product_out
    ADD CONSTRAINT "FK_PRODUCT_OUT" FOREIGN KEY (id_product) REFERENCES public.product(id);


--
-- PostgreSQL database dump complete
--

