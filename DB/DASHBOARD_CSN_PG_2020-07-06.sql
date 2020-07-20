--
-- PostgreSQL database dump
--

-- Dumped from database version 12.3
-- Dumped by pg_dump version 12.3

-- Started on 2020-07-06 09:48:51

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
-- TOC entry 216 (class 1259 OID 17813)
-- Name: Incident; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Incident" (
    "Id" bigint NOT NULL,
    "DateStart" timestamp without time zone,
    "Status" text,
    "TotalCi" numeric,
    "Ouvert" boolean,
    "Category" bigint
);


ALTER TABLE public."Incident" OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 17819)
-- Name: IncidentCi; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."IncidentCi" (
    id bigint NOT NULL,
    "Ci" bigint,
    "DateFin" timestamp without time zone,
    "DateDebut" timestamp without time zone,
    "Symptom" bigint,
    "Incident" bigint
);


ALTER TABLE public."IncidentCi" OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 17822)
-- Name: LookUp; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."LookUp" (
    "Id" bigint NOT NULL,
    "Description" text,
    "ParentId" bigint,
    "Type" text,
    "Status" text
);


ALTER TABLE public."LookUp" OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 17828)
-- Name: MBTS; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."MBTS" (
    "Id" bigint NOT NULL,
    "Description" text,
    "Latitude" text,
    "Longitude" text,
    "Infrastructure" bigint,
    "Division" bigint,
    "Brand" bigint
);


ALTER TABLE public."MBTS" OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 17861)
-- Name: MBTS2G; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."MBTS2G" (
    "Id" bigint NOT NULL,
    "Description" text,
    "Latitude" text,
    "Longitude" text,
    "Infrastructure" bigint,
    "Division" bigint,
    "Brand" bigint
);


ALTER TABLE public."MBTS2G" OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 17869)
-- Name: MBTS3G; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."MBTS3G" (
    "Id" bigint NOT NULL,
    "Description" text,
    "Latitude" text,
    "Longitude" text,
    "Infrastructure" bigint,
    "Division" bigint,
    "Brand" bigint
);


ALTER TABLE public."MBTS3G" OWNER TO postgres;

--
-- TOC entry 225 (class 1259 OID 17877)
-- Name: MBTS4G; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."MBTS4G" (
    "Id" bigint NOT NULL,
    "Description" text,
    "Latitude" text,
    "Longitude" text,
    "Infrastructure" bigint,
    "Division" bigint,
    "Brand" bigint
);


ALTER TABLE public."MBTS4G" OWNER TO postgres;

--
-- TOC entry 226 (class 1259 OID 17885)
-- Name: MSAN; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."MSAN" (
    "Id" bigint NOT NULL,
    "Description" text,
    "GpsLatitude" text,
    "Observation" text,
    "Infrastructure" bigint,
    "Division" bigint,
    "Brand" bigint
);


ALTER TABLE public."MSAN" OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 17834)
-- Name: NetworkElement; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."NetworkElement" (
    "Id" bigint NOT NULL,
    "Infrastructure" text,
    "Division" bigint
);


ALTER TABLE public."NetworkElement" OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 17644)
-- Name: Req1; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Req1" (
    etat text,
    nombre text
);


ALTER TABLE public."Req1" OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 17650)
-- Name: Req2; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Req2" (
    jour timestamp without time zone,
    etat text,
    nombre text
);


ALTER TABLE public."Req2" OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 17656)
-- Name: Req3; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Req3" (
    jour timestamp without time zone,
    division text,
    nombre text
);


ALTER TABLE public."Req3" OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 17662)
-- Name: Req4; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Req4" (
    jour timestamp without time zone,
    division text,
    nombre text
);


ALTER TABLE public."Req4" OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 17668)
-- Name: Req5; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Req5" (
    jour timestamp without time zone,
    equipe text,
    nombre text
);


ALTER TABLE public."Req5" OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 17674)
-- Name: Req6; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Req6" (
    jour timestamp without time zone,
    equipe text,
    nombre text
);


ALTER TABLE public."Req6" OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 17680)
-- Name: ReqEquip; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."ReqEquip" (
    description text,
    latitude text,
    longitude text,
    datedebut text,
    symptome text,
    infra text,
    dr text,
    iddr text,
    dc text,
    iddc text,
    categorie text,
    fournisseur text,
    idfournisseur text
);


ALTER TABLE public."ReqEquip" OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 17686)
-- Name: ReqEquip2g; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."ReqEquip2g" (
    description text,
    latitude text,
    longitude text,
    datedebut text,
    symptome text,
    infra text,
    dr text,
    iddr text,
    dc text,
    iddc text,
    categorie text,
    fournisseur text,
    idfournisseur text
);


ALTER TABLE public."ReqEquip2g" OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 17692)
-- Name: ReqEquip3g; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."ReqEquip3g" (
    description text,
    latitude text,
    longitude text,
    datedebut text,
    symptome text,
    infra text,
    dr text,
    iddr text,
    dc text,
    iddc text,
    categorie text,
    fournisseur text,
    idfournisseur text
);


ALTER TABLE public."ReqEquip3g" OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 17698)
-- Name: ReqEquip4g; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."ReqEquip4g" (
    description text,
    latitude text,
    longitude text,
    datedebut text,
    symptome text,
    infra text,
    dr text,
    iddr text,
    dc text,
    iddc text,
    categorie text,
    fournisseur text,
    idfournisseur text
);


ALTER TABLE public."ReqEquip4g" OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 17704)
-- Name: ReqMSAN; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."ReqMSAN" (
    description text,
    gpslatitude text,
    observation text,
    datedebut text,
    symptome text,
    infra text,
    dr text,
    iddr text,
    dc text,
    iddc text,
    categorie text,
    fournisseur text,
    idfournisseur text
);


ALTER TABLE public."ReqMSAN" OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 17840)
-- Name: TeamCsnInfra; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."TeamCsnInfra" (
    id bigint NOT NULL,
    "TeamCsn" bigint,
    "Infrastructure" text
);


ALTER TABLE public."TeamCsnInfra" OWNER TO postgres;

--
-- TOC entry 213 (class 1259 OID 17710)
-- Name: dc; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.dc (
    id text,
    description text,
    parentid text
);


ALTER TABLE public.dc OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 17716)
-- Name: dr; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.dr (
    id text,
    description text
);


ALTER TABLE public.dr OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 17722)
-- Name: fournisseur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.fournisseur (
    id text,
    description text,
    "typeEquipement" text
);


ALTER TABLE public.fournisseur OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 17846)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

--
-- TOC entry 227 (class 1259 OID 26053)
-- Name: req_stat_mbts; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.req_stat_mbts (
    dr text,
    nombre text
);


ALTER TABLE public.req_stat_mbts OWNER TO postgres;

--
-- TOC entry 228 (class 1259 OID 26059)
-- Name: req_stat_msan; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.req_stat_msan (
    dr text,
    nombre text
);


ALTER TABLE public.req_stat_msan OWNER TO postgres;

--
-- TOC entry 2972 (class 0 OID 17813)
-- Dependencies: 216
-- Data for Name: Incident; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."Incident" VALUES (8, NULL, NULL, NULL, NULL, 12);
INSERT INTO public."Incident" VALUES (9, NULL, NULL, NULL, NULL, 12);
INSERT INTO public."Incident" VALUES (10, NULL, NULL, NULL, NULL, 12);
INSERT INTO public."Incident" VALUES (11, NULL, NULL, NULL, NULL, 12);
INSERT INTO public."Incident" VALUES (12, NULL, NULL, NULL, NULL, 12);
INSERT INTO public."Incident" VALUES (13, NULL, NULL, NULL, NULL, 12);
INSERT INTO public."Incident" VALUES (14, NULL, NULL, NULL, NULL, 12);
INSERT INTO public."Incident" VALUES (15, NULL, NULL, NULL, NULL, 12);
INSERT INTO public."Incident" VALUES (16, NULL, NULL, NULL, NULL, 12);
INSERT INTO public."Incident" VALUES (17, NULL, NULL, NULL, NULL, 12);
INSERT INTO public."Incident" VALUES (18, NULL, NULL, NULL, NULL, 12);
INSERT INTO public."Incident" VALUES (19, NULL, NULL, NULL, NULL, 12);
INSERT INTO public."Incident" VALUES (1, '2020-05-30 04:05:06', 'A', 5, true, 12);
INSERT INTO public."Incident" VALUES (2, '2020-05-31 06:05:06', 'A', 5, true, 12);
INSERT INTO public."Incident" VALUES (3, '2020-06-04 06:05:06', 'A', 5, true, 12);
INSERT INTO public."Incident" VALUES (4, '2020-06-02 10:05:06', 'A', 5, true, 12);
INSERT INTO public."Incident" VALUES (5, '2020-06-03 15:05:06', 'A', 5, true, 12);
INSERT INTO public."Incident" VALUES (6, '2020-05-30 15:05:06', 'A', 5, true, 12);
INSERT INTO public."Incident" VALUES (7, '2020-05-30 20:05:06', 'A', 5, false, 12);


--
-- TOC entry 2973 (class 0 OID 17819)
-- Dependencies: 217
-- Data for Name: IncidentCi; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."IncidentCi" VALUES (38, 23, NULL, NULL, 8, 8);
INSERT INTO public."IncidentCi" VALUES (39, 24, NULL, NULL, 8, 10);
INSERT INTO public."IncidentCi" VALUES (40, 25, NULL, NULL, 8, 10);
INSERT INTO public."IncidentCi" VALUES (41, 26, NULL, NULL, 8, 11);
INSERT INTO public."IncidentCi" VALUES (42, 27, NULL, NULL, 9, 12);
INSERT INTO public."IncidentCi" VALUES (43, 28, NULL, NULL, 9, 13);
INSERT INTO public."IncidentCi" VALUES (44, 29, NULL, NULL, 9, 11);
INSERT INTO public."IncidentCi" VALUES (45, 30, NULL, NULL, 10, 10);
INSERT INTO public."IncidentCi" VALUES (46, 31, NULL, NULL, 11, 10);
INSERT INTO public."IncidentCi" VALUES (47, 32, NULL, NULL, 11, 4);
INSERT INTO public."IncidentCi" VALUES (48, 33, NULL, NULL, 10, 4);
INSERT INTO public."IncidentCi" VALUES (49, 34, NULL, NULL, 8, 5);
INSERT INTO public."IncidentCi" VALUES (50, 35, NULL, NULL, 9, 6);
INSERT INTO public."IncidentCi" VALUES (51, 36, NULL, NULL, 9, 4);
INSERT INTO public."IncidentCi" VALUES (52, 37, NULL, NULL, 10, 4);
INSERT INTO public."IncidentCi" VALUES (53, 38, NULL, NULL, 11, 5);
INSERT INTO public."IncidentCi" VALUES (54, 39, NULL, NULL, 10, 7);
INSERT INTO public."IncidentCi" VALUES (55, 40, NULL, NULL, 10, 8);
INSERT INTO public."IncidentCi" VALUES (56, 41, NULL, NULL, 10, 7);
INSERT INTO public."IncidentCi" VALUES (57, 42, NULL, NULL, 10, 9);
INSERT INTO public."IncidentCi" VALUES (58, 43, NULL, NULL, 8, 8);
INSERT INTO public."IncidentCi" VALUES (59, 44, NULL, NULL, 8, 7);
INSERT INTO public."IncidentCi" VALUES (60, 45, NULL, NULL, 8, 14);
INSERT INTO public."IncidentCi" VALUES (61, 46, NULL, NULL, 8, 18);
INSERT INTO public."IncidentCi" VALUES (1, 1, NULL, NULL, NULL, 1);
INSERT INTO public."IncidentCi" VALUES (2, 2, NULL, NULL, NULL, 2);
INSERT INTO public."IncidentCi" VALUES (3, 3, NULL, NULL, NULL, 3);
INSERT INTO public."IncidentCi" VALUES (4, 1, NULL, NULL, NULL, 1);
INSERT INTO public."IncidentCi" VALUES (5, 2, NULL, NULL, NULL, 2);
INSERT INTO public."IncidentCi" VALUES (6, 3, NULL, NULL, NULL, 3);
INSERT INTO public."IncidentCi" VALUES (7, 1, NULL, NULL, NULL, 4);
INSERT INTO public."IncidentCi" VALUES (8, 2, NULL, NULL, NULL, 4);
INSERT INTO public."IncidentCi" VALUES (9, 3, NULL, NULL, NULL, 4);
INSERT INTO public."IncidentCi" VALUES (10, 1, '2020-06-03 18:05:06', '2020-06-19 10:00:00', NULL, 5);
INSERT INTO public."IncidentCi" VALUES (12, 3, '2020-06-03 18:05:06', '2020-06-19 10:00:00', NULL, 6);
INSERT INTO public."IncidentCi" VALUES (13, 1, '2020-06-03 14:05:06', '2020-06-21 14:00:00', NULL, 7);
INSERT INTO public."IncidentCi" VALUES (14, 2, '2020-06-03 14:05:06', '2020-06-22 14:00:00', NULL, 7);
INSERT INTO public."IncidentCi" VALUES (15, 3, '2020-06-03 14:05:06', '2020-06-23 14:00:00', NULL, 8);
INSERT INTO public."IncidentCi" VALUES (16, 1, NULL, NULL, NULL, 9);
INSERT INTO public."IncidentCi" VALUES (17, 2, NULL, NULL, NULL, 10);
INSERT INTO public."IncidentCi" VALUES (18, 3, NULL, NULL, NULL, 11);
INSERT INTO public."IncidentCi" VALUES (19, 4, NULL, NULL, NULL, 12);
INSERT INTO public."IncidentCi" VALUES (20, 5, NULL, NULL, NULL, 13);
INSERT INTO public."IncidentCi" VALUES (21, 6, NULL, NULL, NULL, 15);
INSERT INTO public."IncidentCi" VALUES (22, 7, NULL, NULL, NULL, 16);
INSERT INTO public."IncidentCi" VALUES (23, 8, NULL, NULL, NULL, 17);
INSERT INTO public."IncidentCi" VALUES (24, 9, NULL, NULL, NULL, 18);
INSERT INTO public."IncidentCi" VALUES (25, 10, NULL, NULL, NULL, 19);
INSERT INTO public."IncidentCi" VALUES (26, 11, NULL, NULL, NULL, 16);
INSERT INTO public."IncidentCi" VALUES (27, 12, NULL, NULL, NULL, 16);
INSERT INTO public."IncidentCi" VALUES (28, 13, NULL, NULL, NULL, 17);
INSERT INTO public."IncidentCi" VALUES (29, 14, NULL, NULL, NULL, 17);
INSERT INTO public."IncidentCi" VALUES (30, 15, NULL, NULL, NULL, 18);
INSERT INTO public."IncidentCi" VALUES (31, 16, NULL, NULL, NULL, 18);
INSERT INTO public."IncidentCi" VALUES (32, 17, NULL, NULL, NULL, 8);
INSERT INTO public."IncidentCi" VALUES (33, 18, NULL, NULL, NULL, 9);
INSERT INTO public."IncidentCi" VALUES (34, 19, NULL, NULL, NULL, 8);
INSERT INTO public."IncidentCi" VALUES (35, 20, NULL, NULL, NULL, 9);
INSERT INTO public."IncidentCi" VALUES (36, 21, NULL, NULL, NULL, 8);
INSERT INTO public."IncidentCi" VALUES (37, 22, NULL, NULL, NULL, 7);
INSERT INTO public."IncidentCi" VALUES (62, 47, NULL, NULL, 9, 19);
INSERT INTO public."IncidentCi" VALUES (63, 48, NULL, NULL, 9, 14);
INSERT INTO public."IncidentCi" VALUES (64, 49, NULL, NULL, 9, 13);
INSERT INTO public."IncidentCi" VALUES (65, 50, NULL, NULL, 9, 12);
INSERT INTO public."IncidentCi" VALUES (66, 51, NULL, NULL, 10, 11);
INSERT INTO public."IncidentCi" VALUES (11, 2, NULL, '2020-06-20 10:00:00', NULL, 5);
INSERT INTO public."IncidentCi" VALUES (67, 52, NULL, NULL, 10, 14);
INSERT INTO public."IncidentCi" VALUES (68, 53, NULL, NULL, 11, 17);
INSERT INTO public."IncidentCi" VALUES (69, 54, NULL, NULL, 11, 15);
INSERT INTO public."IncidentCi" VALUES (70, 55, NULL, NULL, 8, 16);
INSERT INTO public."IncidentCi" VALUES (71, 56, NULL, NULL, 8, 16);
INSERT INTO public."IncidentCi" VALUES (72, 57, NULL, NULL, 8, 14);
INSERT INTO public."IncidentCi" VALUES (73, 58, NULL, NULL, 8, 11);
INSERT INTO public."IncidentCi" VALUES (74, 59, NULL, NULL, 9, 12);
INSERT INTO public."IncidentCi" VALUES (75, 60, NULL, NULL, 9, 13);
INSERT INTO public."IncidentCi" VALUES (76, 61, NULL, NULL, 9, 11);


--
-- TOC entry 2974 (class 0 OID 17822)
-- Dependencies: 218
-- Data for Name: LookUp; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."LookUp" VALUES (8, 'NE HS', NULL, 'CI Symptome', NULL);
INSERT INTO public."LookUp" VALUES (9, 'CI HS', NULL, 'CI Symptome', NULL);
INSERT INTO public."LookUp" VALUES (10, 'CI HS par intermittence', NULL, 'CI Symptome', NULL);
INSERT INTO public."LookUp" VALUES (11, 'NE HS par intermittence', NULL, 'CI Symptome', NULL);
INSERT INTO public."LookUp" VALUES (12, 'Défaut Equipement', NULL, NULL, NULL);
INSERT INTO public."LookUp" VALUES (13, 'SRAN-HW', NULL, NULL, NULL);
INSERT INTO public."LookUp" VALUES (14, 'SRAN-ERC', NULL, NULL, NULL);
INSERT INTO public."LookUp" VALUES (15, 'SRAN-NSN', NULL, NULL, NULL);
INSERT INTO public."LookUp" VALUES (16, 'IAM', NULL, NULL, NULL);
INSERT INTO public."LookUp" VALUES (1, 'activité1', 14, NULL, NULL);
INSERT INTO public."LookUp" VALUES (2, 'activité2', 15, NULL, NULL);
INSERT INTO public."LookUp" VALUES (3, 'activité3', 16, NULL, NULL);
INSERT INTO public."LookUp" VALUES (7, 'activité4', 21, NULL, NULL);
INSERT INTO public."LookUp" VALUES (1525, 'ERICSSON', NULL, 'Brand', 'A');
INSERT INTO public."LookUp" VALUES (1528, 'HUAWEI', NULL, 'Brand', 'A');
INSERT INTO public."LookUp" VALUES (1535, 'NSN', NULL, 'Brand', 'A');
INSERT INTO public."LookUp" VALUES (1542, 'ZTE', NULL, 'Brand', 'A');
INSERT INTO public."LookUp" VALUES (17, 'DRC', NULL, 'IM Direction', 'A');
INSERT INTO public."LookUp" VALUES (18, 'DRO', NULL, 'IM Direction', 'A');
INSERT INTO public."LookUp" VALUES (19, 'DRR', NULL, 'IM Direction', 'A');
INSERT INTO public."LookUp" VALUES (20, 'DRF', NULL, 'IM Direction', 'A');
INSERT INTO public."LookUp" VALUES (21, 'DRM', NULL, 'IM Direction', 'A');
INSERT INTO public."LookUp" VALUES (22, 'DRT', NULL, 'IM Direction', 'A');
INSERT INTO public."LookUp" VALUES (23, 'DRS', NULL, 'IM Direction', 'A');
INSERT INTO public."LookUp" VALUES (24, 'DRA', NULL, 'IM Direction', 'A');
INSERT INTO public."LookUp" VALUES (25, 'DC AIN SBAA BERNOUSSI MOHAMMADIA', 17, 'IM Division', 'A');
INSERT INTO public."LookUp" VALUES (26, 'DC ANFA', 17, 'IM Division', 'A');
INSERT INTO public."LookUp" VALUES (27, 'DC HAY HASSANI BOUSKOURA', 17, 'IM Division', 'A');
INSERT INTO public."LookUp" VALUES (28, 'DC BERKANE-TAOURIRT-JERRADA-BOUARFA', 17, 'IM Division', 'A');
INSERT INTO public."LookUp" VALUES (29, 'DC AIN CHOCK EL FIDA', 17, 'IM Division', 'A');
INSERT INTO public."LookUp" VALUES (30, 'DC KENITRA - SIDI KACEM', 19, 'IM Division', 'A');
INSERT INTO public."LookUp" VALUES (31, 'DC BEN MSIK SIDI OTHMANE', 17, 'IM Division', 'A');
INSERT INTO public."LookUp" VALUES (32, 'DC RABAT', 19, 'IM Division', 'A');
INSERT INTO public."LookUp" VALUES (33, 'DC MARRAKECH', 21, 'IM Division', 'A');
INSERT INTO public."LookUp" VALUES (34, 'DC TAROUDANT-TATA-CHTOUKA', 24, 'IM Division', 'A');
INSERT INTO public."LookUp" VALUES (35, 'DC TETOUAN-CHEFCHAOUEN', 20, 'IM Division', 'A');
INSERT INTO public."LookUp" VALUES (36, 'DC SAFI-ESSAOUIRA-CHICHAOUA', 24, 'IM Division', 'A');
INSERT INTO public."LookUp" VALUES (37, 'DC FES', 20, 'IM Division', 'A');
INSERT INTO public."LookUp" VALUES (38, 'DC MEKNES IFRAN-HAJEB-MISSOUR', 23, 'IM Division', 'A');
INSERT INTO public."LookUp" VALUES (39, 'DC BENIMELLAL-AZILAL-KHOURIBGA', 24, 'IM Division', 'A');
INSERT INTO public."LookUp" VALUES (40, 'DC OUARZAZATE-ZAGORA', 22, 'IM Division', 'A');
INSERT INTO public."LookUp" VALUES (41, 'DC BENIMELLAL-AZILAL-KHOURIBGA', 23, 'IM Division', 'A');
INSERT INTO public."LookUp" VALUES (42, 'DC EL JADIDA', 19, 'IM Division', 'A');
INSERT INTO public."LookUp" VALUES (43, 'DC AGADIR', 24, 'IM Division', 'A');
INSERT INTO public."LookUp" VALUES (1522, 'ALCATEL', NULL, 'Brand', 'A');


--
-- TOC entry 2975 (class 0 OID 17828)
-- Dependencies: 219
-- Data for Name: MBTS; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."MBTS" VALUES (1, 'CAS_ClubSportifZnata', '33,6234', '-7,526861111', 14, 25, 16);
INSERT INTO public."MBTS" VALUES (2, 'CAS_ALMANAR', '33,59902778', '-7,651527778', 13, 26, 16);
INSERT INTO public."MBTS" VALUES (3, 'CAS_CasaMouhit', '33,52572222', '-7,804916667', 13, 27, 16);
INSERT INTO public."MBTS" VALUES (4, 'CAS_MEGAMIX', '33,5794', '-7,643311111', 14, 28, 16);
INSERT INTO public."MBTS" VALUES (5, 'DCBR_BOUFARTISS', '33,0215', '-2,351733333', 13, 29, 16);
INSERT INTO public."MBTS" VALUES (6, 'CAS_CasaNassim', '33,51875', '-7,660416667', 15, 25, 16);
INSERT INTO public."MBTS" VALUES (7, 'CAS_MohammadiaPlageMonica', '33,7154', '-7,351330556', 13, 25, 16);
INSERT INTO public."MBTS" VALUES (8, 'CAS_MICAIRFRANCE', '33,59686111', '-7,615388889', 14, 25, 16);
INSERT INTO public."MBTS" VALUES (9, 'CAS_CasaSofaca', '33,53616667', '-7,613555556', 15, 43, 16);
INSERT INTO public."MBTS" VALUES (10, 'BTS_Mobile', '33,9593638888889', '-6,85320833333333', 13, 43, 16);
INSERT INTO public."MBTS" VALUES (11, 'CAS_CasaChahbi', '33,5895', '-7,526061111', 14, 42, 16);
INSERT INTO public."MBTS" VALUES (12, 'CAS_Pepsi', '33,44077778', '-7,641861111', 13, 42, 16);
INSERT INTO public."MBTS" VALUES (13, 'RAB_PALAISRCHID', '33,93033611', '-6,82125', 15, 40, 16);
INSERT INTO public."MBTS" VALUES (14, 'AAU1_STADEMEDVENTREE', '33,5830277777778', '-7,64803888888889', 13, 41, 16);
INSERT INTO public."MBTS" VALUES (15, 'CAS_MICTRIANON', '33,5890916666667', '-7,63110555555556', 14, 41, 16);
INSERT INTO public."MBTS" VALUES (16, 'FES_HotelBarceloMini', '34,0433', '-4,99719444444444', 14, 43, 16);
INSERT INTO public."MBTS" VALUES (17, 'ISKIGBAL', '31,0000277777778', '-9,47427777777778', 13, 42, 16);
INSERT INTO public."MBTS" VALUES (18, 'RAB_MiniDarEsslam', '0', '0', 13, 35, 16);
INSERT INTO public."MBTS" VALUES (19, 'RAB_MICROCOMPLEXE', '33,9675', '-6,883219444', 13, 35, 16);
INSERT INTO public."MBTS" VALUES (20, 'CAS_ELHANK', '33,60527778', '-7,657527778', 15, 35, 16);
INSERT INTO public."MBTS" VALUES (21, 'Marrakechmouassin', '31,62375', '-7,97125', 13, 36, 16);
INSERT INTO public."MBTS" VALUES (22, 'Talghijt', '28,950075', '-8,6501', 14, 36, 16);
INSERT INTO public."MBTS" VALUES (23, 'CAS_CasaMabsoute', '33,561997', '-7,595136', 15, 37, 16);
INSERT INTO public."MBTS" VALUES (24, 'Ighirnomajdadar', '31,2065833333333', '-5,74902777777778', 15, 38, 16);
INSERT INTO public."MBTS" VALUES (25, 'Taouinekht', '30,7810833333333', '-8,49094444444444', 13, 39, 16);
INSERT INTO public."MBTS" VALUES (26, 'MEK_Zidane', '33,9214444444444', '-5,49133333333333', 14, 40, 16);
INSERT INTO public."MBTS" VALUES (27, 'DCND_AMJOUAMRT', '35,1721944444444', '-3,25286111111111', 13, 40, 16);
INSERT INTO public."MBTS" VALUES (28, 'DCND_IMOUSSATEN', '35,1509444444444', '-3,40538888888889', 15, 40, 16);
INSERT INTO public."MBTS" VALUES (29, 'DCTE_BNIFAGHLOUM', '34,8992222222222', '-5,15127777777778', 13, 28, 16);
INSERT INTO public."MBTS" VALUES (30, 'AGHBALOUASSAIS', '30,8327222222222', '-9,23133333333333', 14, 28, 16);
INSERT INTO public."MBTS" VALUES (31, 'Chichaouaautoroute', '31,5006388888889', '-8,72586111111111', 13, 28, 16);
INSERT INTO public."MBTS" VALUES (32, 'AutoDouarLmih', '31,8475611111111', '-8,02483333333333', 15, 28, 16);
INSERT INTO public."MBTS" VALUES (33, 'DouerLmih', '31,8475611111111', '-8,02483333333333', 13, 29, 16);
INSERT INTO public."MBTS" VALUES (34, 'DCKE_DouarHoumoudou', '34,2246388888889', '-6,32238888888889', 14, 30, 16);
INSERT INTO public."MBTS" VALUES (35, 'DCKE_SidiAbderahman', '34,1728611111111', '-6,35275', 15, 30, 16);
INSERT INTO public."MBTS" VALUES (36, 'Darka', '30,91', '-8,96075', 13, 30, 16);
INSERT INTO public."MBTS" VALUES (47, 'Islane', '30,75980556', '-8,855861111', 14, 25, 16);
INSERT INTO public."MBTS" VALUES (48, 'SidiDahman', '30,4821944444444', '-8,82372222222222', 14, 25, 16);
INSERT INTO public."MBTS" VALUES (49, 'Arsassidaoukazzou', '30,8646388888889', '-9,58661111111111', 15, 26, 16);
INSERT INTO public."MBTS" VALUES (50, 'IRAMANE', '30,9188888888889', '-9,58475', 13, 26, 16);
INSERT INTO public."MBTS" VALUES (51, 'Plagetafdna', '31,1007666666667', '-9,80110277777778', 13, 26, 16);
INSERT INTO public."MBTS" VALUES (52, 'Timzguide', '30,9365277777778', '-9,70491666666667', 14, 26, 16);
INSERT INTO public."MBTS" VALUES (53, 'Ichida', '30,8887777777778', '-9,63325', 15, 27, 16);
INSERT INTO public."MBTS" VALUES (54, 'DCBM_AITBAADI', '31,63583333', '-6,838055556', 13, 27, 16);
INSERT INTO public."MBTS" VALUES (55, 'KEN_AutoTangerKm54', '34,41', '-6,52472222222222', 14, 27, 16);
INSERT INTO public."MBTS" VALUES (37, 'Ibaloulene', '30,9338888888889', '-8,93861111111111', 14, 36, 16);
INSERT INTO public."MBTS" VALUES (38, 'Fotlag', '30,01819444', '-8,783166667', 13, 32, 16);
INSERT INTO public."MBTS" VALUES (39, 'Pc44Bis', '21,76805556', '-14,8475', 15, 32, 16);
INSERT INTO public."MBTS" VALUES (40, 'Ouledaissa', '32,1266388888889', '-7,41036111111111', 13, 32, 16);
INSERT INTO public."MBTS" VALUES (41, 'BNA_MARINE', '35,2598888888889', '-2,92972222222222', 14, 32, 16);
INSERT INTO public."MBTS" VALUES (42, 'AITIAZZASUD', '30,5031111111111', '-8,8035', 13, 32, 16);
INSERT INTO public."MBTS" VALUES (43, 'JAOUDA', '30,508', '-8,788', 15, 26, 16);
INSERT INTO public."MBTS" VALUES (44, 'Pt740Arazane', '30,4614444444444', '-8,57213888888889', 14, 26, 16);
INSERT INTO public."MBTS" VALUES (45, 'Tansimtimoulass', '30,7494444444444', '-8,82613888888889', 14, 25, 16);
INSERT INTO public."MBTS" VALUES (46, 'Tioutamrt', '30,3984194444444', '-8,68722777777778', 14, 26, 16);
INSERT INTO public."MBTS" VALUES (56, 'KEN_OuladFzara', '34,3527805555556', '-6,55096944444444', 15, 34, 16);
INSERT INTO public."MBTS" VALUES (57, 'MarrakechMhamdia', '31,6458888888889', '-7,88688888888889', 13, 34, 16);
INSERT INTO public."MBTS" VALUES (58, 'TET_DarChkara', '35,51677778', '-5,221472222', 13, 34, 16);
INSERT INTO public."MBTS" VALUES (59, 'AUTOROUTESETTAT3', '32,735', '-7,737', 13, 34, 16);
INSERT INTO public."MBTS" VALUES (60, 'SET_PeageHadSoualem', '33,4165', '-7,819138889', 13, 43, 16);
INSERT INTO public."MBTS" VALUES (61, 'CAS_CENTREALLAL', '33,59586111', '-7,614138889', 15, 42, 16);


--
-- TOC entry 2979 (class 0 OID 17861)
-- Dependencies: 223
-- Data for Name: MBTS2G; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2980 (class 0 OID 17869)
-- Dependencies: 224
-- Data for Name: MBTS3G; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2981 (class 0 OID 17877)
-- Dependencies: 225
-- Data for Name: MBTS4G; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2982 (class 0 OID 17885)
-- Dependencies: 226
-- Data for Name: MSAN; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2976 (class 0 OID 17834)
-- Dependencies: 220
-- Data for Name: NetworkElement; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."NetworkElement" VALUES (1, 'i1
', 1);
INSERT INTO public."NetworkElement" VALUES (2, 'i1', 2);
INSERT INTO public."NetworkElement" VALUES (3, 'i1', 1);
INSERT INTO public."NetworkElement" VALUES (4, 'i2', 2);
INSERT INTO public."NetworkElement" VALUES (5, 'i2', 2);
INSERT INTO public."NetworkElement" VALUES (6, 'i3', 3);
INSERT INTO public."NetworkElement" VALUES (7, 'i3', 1);
INSERT INTO public."NetworkElement" VALUES (8, 'i1', 3);


--
-- TOC entry 2958 (class 0 OID 17644)
-- Dependencies: 202
-- Data for Name: Req1; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."Req1" VALUES ('Fermé', '165');
INSERT INTO public."Req1" VALUES ('Ouvert', '85');


--
-- TOC entry 2959 (class 0 OID 17650)
-- Dependencies: 203
-- Data for Name: Req2; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."Req2" VALUES ('2020-06-18 00:00:00', 'ferme', '322');
INSERT INTO public."Req2" VALUES ('2020-06-18 00:00:00', 'ouvert', '23');
INSERT INTO public."Req2" VALUES ('2020-06-19 00:00:00', 'ferme', '289');
INSERT INTO public."Req2" VALUES ('2020-06-19 00:00:00', 'ouvert', '16');
INSERT INTO public."Req2" VALUES ('2020-06-20 00:00:00', 'ferme', '399');
INSERT INTO public."Req2" VALUES ('2020-06-20 00:00:00', 'ouvert', '31');
INSERT INTO public."Req2" VALUES ('2020-06-21 00:00:00', 'ferme', '450');
INSERT INTO public."Req2" VALUES ('2020-06-21 00:00:00', 'ouvert', '20');
INSERT INTO public."Req2" VALUES ('2020-06-22 00:00:00', 'ouvert', '38');
INSERT INTO public."Req2" VALUES ('2020-06-22 00:00:00', 'ferme', '402');
INSERT INTO public."Req2" VALUES ('2020-06-23 00:00:00', 'ferme', '368');
INSERT INTO public."Req2" VALUES ('2020-06-23 00:00:00', 'ouvert', '51');
INSERT INTO public."Req2" VALUES ('2020-06-24 00:00:00', 'ouvert', '209');
INSERT INTO public."Req2" VALUES ('2020-06-24 00:00:00', 'ferme', '194');


--
-- TOC entry 2960 (class 0 OID 17656)
-- Dependencies: 204
-- Data for Name: Req3; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."Req3" VALUES ('2020-06-24 00:00:00', 'DIRECTION EXPLOITATION', '2');
INSERT INTO public."Req3" VALUES ('2020-06-24 00:00:00', 'DRA', '3');
INSERT INTO public."Req3" VALUES ('2020-06-24 00:00:00', 'DRC', '3');
INSERT INTO public."Req3" VALUES ('2020-06-24 00:00:00', 'DRF', '9');
INSERT INTO public."Req3" VALUES ('2020-06-24 00:00:00', 'DRM', '3');
INSERT INTO public."Req3" VALUES ('2020-06-24 00:00:00', 'DRR', '2');
INSERT INTO public."Req3" VALUES ('2020-06-24 00:00:00', 'DRS', '1');
INSERT INTO public."Req3" VALUES ('2020-06-25 00:00:00', 'DIRECTION EXPLOITATION', '3');
INSERT INTO public."Req3" VALUES ('2020-06-25 00:00:00', 'DRC', '1');
INSERT INTO public."Req3" VALUES ('2020-06-25 00:00:00', 'DRF', '2');
INSERT INTO public."Req3" VALUES ('2020-06-25 00:00:00', 'DRM', '7');
INSERT INTO public."Req3" VALUES ('2020-06-25 00:00:00', 'DRR', '3');
INSERT INTO public."Req3" VALUES ('2020-06-26 00:00:00', 'DIRECTION EXPLOITATION', '10');
INSERT INTO public."Req3" VALUES ('2020-06-26 00:00:00', 'DRA', '2');
INSERT INTO public."Req3" VALUES ('2020-06-26 00:00:00', 'DRC', '6');
INSERT INTO public."Req3" VALUES ('2020-06-26 00:00:00', 'DRF', '3');
INSERT INTO public."Req3" VALUES ('2020-06-26 00:00:00', 'DRM', '6');
INSERT INTO public."Req3" VALUES ('2020-06-26 00:00:00', 'DRR', '3');
INSERT INTO public."Req3" VALUES ('2020-06-26 00:00:00', 'DRS', '1');
INSERT INTO public."Req3" VALUES ('2020-06-27 00:00:00', 'DRA', '7');
INSERT INTO public."Req3" VALUES ('2020-06-27 00:00:00', 'DRC', '2');
INSERT INTO public."Req3" VALUES ('2020-06-27 00:00:00', 'DRF', '2');
INSERT INTO public."Req3" VALUES ('2020-06-27 00:00:00', 'DRM', '2');
INSERT INTO public."Req3" VALUES ('2020-06-27 00:00:00', 'DRO', '5');
INSERT INTO public."Req3" VALUES ('2020-06-27 00:00:00', 'DRR', '3');
INSERT INTO public."Req3" VALUES ('2020-06-27 00:00:00', 'DRS', '1');
INSERT INTO public."Req3" VALUES ('2020-06-27 00:00:00', 'DRT', '1');
INSERT INTO public."Req3" VALUES ('2020-06-28 00:00:00', 'DIRECTION EXPLOITATION', '6');
INSERT INTO public."Req3" VALUES ('2020-06-28 00:00:00', 'DRA', '13');
INSERT INTO public."Req3" VALUES ('2020-06-28 00:00:00', 'DRC', '2');
INSERT INTO public."Req3" VALUES ('2020-06-28 00:00:00', 'DRF', '4');
INSERT INTO public."Req3" VALUES ('2020-06-28 00:00:00', 'DRM', '4');
INSERT INTO public."Req3" VALUES ('2020-06-28 00:00:00', 'DRO', '1');
INSERT INTO public."Req3" VALUES ('2020-06-28 00:00:00', 'DRR', '5');
INSERT INTO public."Req3" VALUES ('2020-06-28 00:00:00', 'DRT', '3');
INSERT INTO public."Req3" VALUES ('2020-06-29 00:00:00', 'DIRECTION EXPLOITATION', '3');
INSERT INTO public."Req3" VALUES ('2020-06-29 00:00:00', 'DRA', '5');
INSERT INTO public."Req3" VALUES ('2020-06-29 00:00:00', 'DRF', '8');
INSERT INTO public."Req3" VALUES ('2020-06-29 00:00:00', 'DRM', '17');
INSERT INTO public."Req3" VALUES ('2020-06-29 00:00:00', 'DRO', '1');
INSERT INTO public."Req3" VALUES ('2020-06-29 00:00:00', 'DRR', '5');
INSERT INTO public."Req3" VALUES ('2020-06-29 00:00:00', 'DRS', '6');
INSERT INTO public."Req3" VALUES ('2020-06-29 00:00:00', 'DRT', '5');
INSERT INTO public."Req3" VALUES ('2020-06-30 00:00:00', 'DIRECTION EXPLOITATION', '5');
INSERT INTO public."Req3" VALUES ('2020-06-30 00:00:00', 'DRA', '48');
INSERT INTO public."Req3" VALUES ('2020-06-30 00:00:00', 'DRC', '38');
INSERT INTO public."Req3" VALUES ('2020-06-30 00:00:00', 'DRF', '17');
INSERT INTO public."Req3" VALUES ('2020-06-30 00:00:00', 'DRM', '23');
INSERT INTO public."Req3" VALUES ('2020-06-30 00:00:00', 'DRO', '3');
INSERT INTO public."Req3" VALUES ('2020-06-30 00:00:00', 'DRR', '31');
INSERT INTO public."Req3" VALUES ('2020-06-30 00:00:00', 'DRS', '20');
INSERT INTO public."Req3" VALUES ('2020-06-30 00:00:00', 'DRT', '8');


--
-- TOC entry 2961 (class 0 OID 17662)
-- Dependencies: 205
-- Data for Name: Req4; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."Req4" VALUES ('2020-06-17 00:00:00', 'DRA', '75');
INSERT INTO public."Req4" VALUES ('2020-06-17 00:00:00', 'DRC', '11');
INSERT INTO public."Req4" VALUES ('2020-06-17 00:00:00', 'DRF', '53');
INSERT INTO public."Req4" VALUES ('2020-06-17 00:00:00', 'DRM', '87');
INSERT INTO public."Req4" VALUES ('2020-06-17 00:00:00', 'DRO', '13');
INSERT INTO public."Req4" VALUES ('2020-06-17 00:00:00', 'DRR', '28');
INSERT INTO public."Req4" VALUES ('2020-06-17 00:00:00', 'DRS', '27');
INSERT INTO public."Req4" VALUES ('2020-06-17 00:00:00', 'DRT', '28');
INSERT INTO public."Req4" VALUES ('2020-06-18 00:00:00', 'DIRECTION EXPLOITATION', '8');
INSERT INTO public."Req4" VALUES ('2020-06-18 00:00:00', 'DRA', '73');
INSERT INTO public."Req4" VALUES ('2020-06-18 00:00:00', 'DRC', '14');
INSERT INTO public."Req4" VALUES ('2020-06-18 00:00:00', 'DRF', '82');
INSERT INTO public."Req4" VALUES ('2020-06-18 00:00:00', 'DRM', '50');
INSERT INTO public."Req4" VALUES ('2020-06-18 00:00:00', 'DRO', '9');
INSERT INTO public."Req4" VALUES ('2020-06-18 00:00:00', 'DRR', '14');
INSERT INTO public."Req4" VALUES ('2020-06-18 00:00:00', 'DRS', '12');
INSERT INTO public."Req4" VALUES ('2020-06-18 00:00:00', 'DRT', '27');
INSERT INTO public."Req4" VALUES ('2020-06-19 00:00:00', 'DIRECTION EXPLOITATION', '10');
INSERT INTO public."Req4" VALUES ('2020-06-19 00:00:00', 'DRA', '71');
INSERT INTO public."Req4" VALUES ('2020-06-19 00:00:00', 'DRC', '41');
INSERT INTO public."Req4" VALUES ('2020-06-19 00:00:00', 'DRF', '47');
INSERT INTO public."Req4" VALUES ('2020-06-19 00:00:00', 'DRM', '123');
INSERT INTO public."Req4" VALUES ('2020-06-19 00:00:00', 'DRO', '17');
INSERT INTO public."Req4" VALUES ('2020-06-19 00:00:00', 'DRR', '25');
INSERT INTO public."Req4" VALUES ('2020-06-19 00:00:00', 'DRS', '26');
INSERT INTO public."Req4" VALUES ('2020-06-19 00:00:00', 'DRT', '39');
INSERT INTO public."Req4" VALUES ('2020-06-20 00:00:00', 'DIRECTION EXPLOITATION', '10');
INSERT INTO public."Req4" VALUES ('2020-06-20 00:00:00', 'DRA', '86');
INSERT INTO public."Req4" VALUES ('2020-06-20 00:00:00', 'DRC', '28');
INSERT INTO public."Req4" VALUES ('2020-06-20 00:00:00', 'DRF', '47');
INSERT INTO public."Req4" VALUES ('2020-06-20 00:00:00', 'DRM', '115');
INSERT INTO public."Req4" VALUES ('2020-06-20 00:00:00', 'DRO', '1');
INSERT INTO public."Req4" VALUES ('2020-06-20 00:00:00', 'DRR', '58');
INSERT INTO public."Req4" VALUES ('2020-06-20 00:00:00', 'DRS', '64');
INSERT INTO public."Req4" VALUES ('2020-06-20 00:00:00', 'DRT', '41');
INSERT INTO public."Req4" VALUES ('2020-06-21 00:00:00', 'DIRECTION EXPLOITATION', '6');
INSERT INTO public."Req4" VALUES ('2020-06-21 00:00:00', 'DRA', '97');
INSERT INTO public."Req4" VALUES ('2020-06-21 00:00:00', 'DRC', '39');
INSERT INTO public."Req4" VALUES ('2020-06-21 00:00:00', 'DRF', '38');
INSERT INTO public."Req4" VALUES ('2020-06-21 00:00:00', 'DRM', '102');
INSERT INTO public."Req4" VALUES ('2020-06-21 00:00:00', 'DRO', '12');
INSERT INTO public."Req4" VALUES ('2020-06-21 00:00:00', 'DRR', '60');
INSERT INTO public."Req4" VALUES ('2020-06-21 00:00:00', 'DRS', '30');
INSERT INTO public."Req4" VALUES ('2020-06-21 00:00:00', 'DRT', '18');
INSERT INTO public."Req4" VALUES ('2020-06-22 00:00:00', 'DIRECTION EXPLOITATION', '2');
INSERT INTO public."Req4" VALUES ('2020-06-22 00:00:00', 'DRA', '88');
INSERT INTO public."Req4" VALUES ('2020-06-22 00:00:00', 'DRC', '20');
INSERT INTO public."Req4" VALUES ('2020-06-22 00:00:00', 'DRF', '39');
INSERT INTO public."Req4" VALUES ('2020-06-22 00:00:00', 'DRM', '103');
INSERT INTO public."Req4" VALUES ('2020-06-22 00:00:00', 'DRO', '17');
INSERT INTO public."Req4" VALUES ('2020-06-22 00:00:00', 'DRR', '49');
INSERT INTO public."Req4" VALUES ('2020-06-22 00:00:00', 'DRS', '21');
INSERT INTO public."Req4" VALUES ('2020-06-22 00:00:00', 'DRT', '30');
INSERT INTO public."Req4" VALUES ('2020-06-23 00:00:00', 'DIRECTION EXPLOITATION', '4');
INSERT INTO public."Req4" VALUES ('2020-06-23 00:00:00', 'DRA', '94');
INSERT INTO public."Req4" VALUES ('2020-06-23 00:00:00', 'DRC', '14');
INSERT INTO public."Req4" VALUES ('2020-06-23 00:00:00', 'DRF', '7');
INSERT INTO public."Req4" VALUES ('2020-06-23 00:00:00', 'DRM', '50');
INSERT INTO public."Req4" VALUES ('2020-06-23 00:00:00', 'DRO', '8');
INSERT INTO public."Req4" VALUES ('2020-06-23 00:00:00', 'DRR', '15');
INSERT INTO public."Req4" VALUES ('2020-06-23 00:00:00', 'DRS', '19');
INSERT INTO public."Req4" VALUES ('2020-06-23 00:00:00', 'DRT', '11');


--
-- TOC entry 2962 (class 0 OID 17668)
-- Dependencies: 206
-- Data for Name: Req5; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."Req5" VALUES ('2020-06-25 00:00:00', 'Transmission', '29');
INSERT INTO public."Req5" VALUES ('2020-06-19 00:00:00', 'Commutation', '7');
INSERT INTO public."Req5" VALUES ('2020-06-19 00:00:00', 'Radio', '16');
INSERT INTO public."Req5" VALUES ('2020-06-20 00:00:00', 'Commutation', '5');
INSERT INTO public."Req5" VALUES ('2020-06-20 00:00:00', 'PFS', '1');
INSERT INTO public."Req5" VALUES ('2020-06-20 00:00:00', 'Radio', '8');
INSERT INTO public."Req5" VALUES ('2020-06-20 00:00:00', 'Transmission', '2');
INSERT INTO public."Req5" VALUES ('2020-06-21 00:00:00', 'Commutation', '7');
INSERT INTO public."Req5" VALUES ('2020-06-21 00:00:00', 'PFS', '10');
INSERT INTO public."Req5" VALUES ('2020-06-21 00:00:00', 'Radio', '12');
INSERT INTO public."Req5" VALUES ('2020-06-21 00:00:00', 'Transmission', '2');
INSERT INTO public."Req5" VALUES ('2020-06-22 00:00:00', 'Commutation', '1');
INSERT INTO public."Req5" VALUES ('2020-06-22 00:00:00', 'PFS', '2');
INSERT INTO public."Req5" VALUES ('2020-06-22 00:00:00', 'Radio', '16');
INSERT INTO public."Req5" VALUES ('2020-06-22 00:00:00', 'Transmission', '4');
INSERT INTO public."Req5" VALUES ('2020-06-23 00:00:00', 'Commutation', '11');
INSERT INTO public."Req5" VALUES ('2020-06-23 00:00:00', 'PFS', '1');
INSERT INTO public."Req5" VALUES ('2020-06-23 00:00:00', 'Radio', '22');
INSERT INTO public."Req5" VALUES ('2020-06-23 00:00:00', 'Transmission', '4');
INSERT INTO public."Req5" VALUES ('2020-06-24 00:00:00', 'Commutation', '7');
INSERT INTO public."Req5" VALUES ('2020-06-24 00:00:00', 'PFS', '3');
INSERT INTO public."Req5" VALUES ('2020-06-24 00:00:00', 'Radio', '37');
INSERT INTO public."Req5" VALUES ('2020-06-24 00:00:00', 'Transmission', '3');
INSERT INTO public."Req5" VALUES ('2020-06-25 00:00:00', 'Commutation', '24');
INSERT INTO public."Req5" VALUES ('2020-06-25 00:00:00', 'PFS', '12');
INSERT INTO public."Req5" VALUES ('2020-06-25 00:00:00', 'Radio', '133');


--
-- TOC entry 2963 (class 0 OID 17674)
-- Dependencies: 207
-- Data for Name: Req6; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."Req6" VALUES ('2020-06-17 00:00:00', 'Commutation', '42');
INSERT INTO public."Req6" VALUES ('2020-06-17 00:00:00', 'PFS', '2');
INSERT INTO public."Req6" VALUES ('2020-06-17 00:00:00', 'Radio', '258');
INSERT INTO public."Req6" VALUES ('2020-06-17 00:00:00', 'Transmission', '20');
INSERT INTO public."Req6" VALUES ('2020-06-18 00:00:00', 'Commutation', '33');
INSERT INTO public."Req6" VALUES ('2020-06-18 00:00:00', 'PFS', '11');
INSERT INTO public."Req6" VALUES ('2020-06-18 00:00:00', 'Radio', '231');
INSERT INTO public."Req6" VALUES ('2020-06-18 00:00:00', 'Transmission', '15');
INSERT INTO public."Req6" VALUES ('2020-06-19 00:00:00', 'Commutation', '48');
INSERT INTO public."Req6" VALUES ('2020-06-19 00:00:00', 'PFS', '10');
INSERT INTO public."Req6" VALUES ('2020-06-19 00:00:00', 'Radio', '324');
INSERT INTO public."Req6" VALUES ('2020-06-19 00:00:00', 'Transmission', '17');
INSERT INTO public."Req6" VALUES ('2020-06-20 00:00:00', 'Commutation', '43');
INSERT INTO public."Req6" VALUES ('2020-06-20 00:00:00', 'PFS', '11');
INSERT INTO public."Req6" VALUES ('2020-06-20 00:00:00', 'Radio', '380');
INSERT INTO public."Req6" VALUES ('2020-06-20 00:00:00', 'Transmission', '16');
INSERT INTO public."Req6" VALUES ('2020-06-21 00:00:00', 'Commutation', '42');
INSERT INTO public."Req6" VALUES ('2020-06-21 00:00:00', 'PFS', '9');
INSERT INTO public."Req6" VALUES ('2020-06-21 00:00:00', 'Radio', '308');
INSERT INTO public."Req6" VALUES ('2020-06-21 00:00:00', 'Transmission', '43');
INSERT INTO public."Req6" VALUES ('2020-06-22 00:00:00', 'Commutation', '44');
INSERT INTO public."Req6" VALUES ('2020-06-22 00:00:00', 'PFS', '10');
INSERT INTO public."Req6" VALUES ('2020-06-22 00:00:00', 'Radio', '288');
INSERT INTO public."Req6" VALUES ('2020-06-22 00:00:00', 'Transmission', '27');
INSERT INTO public."Req6" VALUES ('2020-06-23 00:00:00', 'Commutation', '21');
INSERT INTO public."Req6" VALUES ('2020-06-23 00:00:00', 'PFS', '6');
INSERT INTO public."Req6" VALUES ('2020-06-23 00:00:00', 'Transmission', '18');
INSERT INTO public."Req6" VALUES ('2020-06-23 00:00:00', 'Radio', '177');


--
-- TOC entry 2964 (class 0 OID 17680)
-- Dependencies: 208
-- Data for Name: ReqEquip; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."ReqEquip" VALUES ('CAS_ClubSportifZnata', '33,6234', '-7,526861111', '2019-11-10 16:23:32', 'CI HS par intermittence', 'SRAN-HW', 'DRC', '1550', 'DC AIN SBAA BERNOUSSI MOHAMMADIA', '1561', 'Défaut Equipement', 'HUAWEI', '1528');
INSERT INTO public."ReqEquip" VALUES ('CAS_ALMANAR', '33,59902778', '-7,651527778', '2018-10-10 16:26:27', 'CI HS', 'SRAN-HW', 'DRC', '1550', 'DC ANFA', '2477', 'Défaut Equipement', 'HUAWEI', '1528');
INSERT INTO public."ReqEquip" VALUES ('CAS_CasaMouhit', '33,52572222', '-7,804916667', '2018-10-18 06:17:25', 'CI HS', 'SRAN-HW', 'DRC', '1550', 'DC HAY HASSANI BOUSKOURA', '1560', 'Défaut Equipement', 'HUAWEI', '1528');
INSERT INTO public."ReqEquip" VALUES ('CAS_MEGAMIX', '33,5794', '-7,643311111', '2018-11-05 23:01:13', 'CI HS', 'SRAN-HW', 'DRC', '1550', 'DC ANFA', '2477', 'Défaut Environnement', 'HUAWEI', '1528');
INSERT INTO public."ReqEquip" VALUES ('DCBR_BOUFARTISS', '33,0215', '-2,351733333', '2019-06-26 01:49:45', 'CI HS', 'SRAN-NSN', 'DRO', '1554', 'DC BERKANE-TAOURIRT-JERRADA-BOUARFA', '2482', 'Défaut Equipement', 'NSN', '1535');
INSERT INTO public."ReqEquip" VALUES ('CAS_CasaNassim', '33,51875', '-7,660416667', '2018-03-14 12:16:59', 'CI HS', 'SRAN-HW', 'DRC', '1550', 'DC HAY HASSANI BOUSKOURA', '1560', 'Défaut Equipement', 'HUAWEI', '1528');
INSERT INTO public."ReqEquip" VALUES ('CAS_MohammadiaPlageMonica', '33,7154', '-7,351330556', '2018-08-25 12:32:43', 'CI HS', 'SRAN-HW', 'DRC', '1550', 'DC AIN SBAA BERNOUSSI MOHAMMADIA', '1561', 'Défaut Equipement', 'HUAWEI', '1528');
INSERT INTO public."ReqEquip" VALUES ('Ouhakayne', '30,8644444444444', '-9,22113888888889', '2020-06-07 12:25:21', 'CI HS', 'SRAN-ERC', 'DRM', '1552', 'DC SAFI-ESSAOUIRA-CHICHAOUA', '2510', 'Défaut Equipement', 'ERICSSON', '1525');
INSERT INTO public."ReqEquip" VALUES ('Pc18bis', '24,974', '-12,364', '2020-06-08 01:22:20', 'CI HS', 'SRAN-ERC', 'DRA', '1556', 'DC LAAYOUNE-SAKIA LHAMRA-BOUJDOUR', '2492', 'Défaut Equipement', 'ERICSSON', '1525');
INSERT INTO public."ReqEquip" VALUES ('CAS_Plagejackbeach', '33,52902778', '-7,828388889', '2020-06-08 12:31:49', 'CI HS', 'SRAN-HW', 'DRC', '1550', 'DC HAY HASSANI BOUSKOURA', '1560', 'Défaut Equipement', 'HUAWEI', '1528');
INSERT INTO public."ReqEquip" VALUES ('BNA_MARINE', '35,2598888888889', '-2,92972222222222', '2020-06-08 17:01:37', 'CI HS', 'SRAN-NSN', 'DRO', '1554', 'DC NADOR', '2520', 'Défaut Environnement', 'NSN', '1535');
INSERT INTO public."ReqEquip" VALUES ('Capaawserd', '22,5640555555556', '-14,3100833333333', '2020-06-08 17:30:56', 'CI HS', 'SRAN-ERC', 'DRA', '1556', 'DC LAAYOUNE-SAKIA LHAMRA-BOUJDOUR', '2492', 'Défaut Equipement', 'ERICSSON', '1525');
INSERT INTO public."ReqEquip" VALUES ('DCFS_HAMMOUYAT', '34,4969388888889', '-4,49510277777778', '2020-06-08 19:58:17', 'CI HS', 'SRAN-NSN', 'DRF', '1553', 'DC FES', '2501', 'Défaut Environnement', 'NSN', '1535');
INSERT INTO public."ReqEquip" VALUES ('Akermoud', '31,7659388888889', '-9,53158888888889', '2020-06-08 20:32:27', 'CI HS', 'SRAN-ERC', 'DRM', '1552', 'DC SAFI-ESSAOUIRA-CHICHAOUA', '2510', 'Défaut Equipement', 'ERICSSON', '1525');
INSERT INTO public."ReqEquip" VALUES ('Rbatichamraren', '31,16480556', '-9,182055556', '2020-06-08 20:32:27', 'CI HS', 'SRAN-ERC', 'DRM', '1552', 'DC SAFI-ESSAOUIRA-CHICHAOUA', '2510', 'Défaut Equipement', 'ERICSSON', '1525');
INSERT INTO public."ReqEquip" VALUES ('Tagout', '29,4044166666667', '-9,54711111111111', '2020-06-08 20:53:27', 'CI HS', 'SRAN-ERC', 'DRA', '1556', 'DC GUELMIM-ASSA ZAG-TAN TAN', '2498', 'Défaut Equipement', 'ERICSSON', '1525');
INSERT INTO public."ReqEquip" VALUES ('Mezindra', '32,2166916666667', '-8,40012222222222', '2020-06-08 22:22:30', 'CI HS', 'SRAN-ERC', 'DRM', '1552', 'DC SAFI-ESSAOUIRA-CHICHAOUA', '2510', 'Défaut Equipement', 'ERICSSON', '1525');
INSERT INTO public."ReqEquip" VALUES ('LAR_SoukTolba', '35,1210555555556', '-5,89975', '2020-06-09 01:10:59', 'CI HS', 'SRAN-HW', 'DRT', '1557', 'DC LARACHE', '2491', 'Défaut Transmission', 'HUAWEI', '1528');
INSERT INTO public."ReqEquip" VALUES ('CAS_BouskouraCFCIM', '33,4209722222222', '-7,64519444444444', '2020-06-09 04:18:59', 'CI HS', 'SRAN-HW', 'DRC', '1550', 'DC HAY HASSANI BOUSKOURA', '1560', 'Défaut Equipement', 'HUAWEI', '1528');
INSERT INTO public."ReqEquip" VALUES ('DCMK_TENDIT', '33,7025277777778', '-3,62061111111111', '2020-06-09 05:19:59', 'CI HS', 'SRAN-NSN', 'DRF', '1553', 'DC MEKNES IFRAN-HAJEB-MISSOUR', '2523', 'Défaut Equipement', 'NSN', '1535');
INSERT INTO public."ReqEquip" VALUES ('Gueltatzemmour', '25,1482166666667', '-12,3691083333333', '2020-06-09 04:42:53', 'CI HS', 'SRAN-ERC', 'DRA', '1556', 'DC LAAYOUNE-SAKIA LHAMRA-BOUJDOUR', '2492', 'Défaut Equipement', 'ERICSSON', '1525');
INSERT INTO public."ReqEquip" VALUES ('Lbeir', '24,8523888888889', '-14,8420833333333', '2020-06-09 05:07:53', 'CI HS', 'SRAN-ERC', 'DRA', '1556', 'DC LAAYOUNE-SAKIA LHAMRA-BOUJDOUR', '2492', 'Défaut Equipement', 'ERICSSON', '1525');
INSERT INTO public."ReqEquip" VALUES ('Fotlag', '30,01819444', '-8,783166667', '2020-06-09 07:12:59', 'CI HS', 'SRAN-ERC', 'DRA', '1556', 'DC TAROUDANT-TATA-CHTOUKA', '2507', 'Défaut Equipement', 'ERICSSON', '1525');
INSERT INTO public."ReqEquip" VALUES ('ARG', '31,0213888888889', '-7,47822222222222', '2020-06-09 07:44:32', 'CI HS', 'SRAN-ERC', 'DRM', '1552', 'DC OUARZAZATE-ZAGORA', '2519', 'Défaut Equipement', 'ERICSSON', '1525');
INSERT INTO public."ReqEquip" VALUES ('DerbMgouna', '31,243', '-6,128', '2020-06-09 08:18:59', 'CI HS', 'SRAN-ERC', 'DRM', '1552', 'DC OUARZAZATE-ZAGORA', '2519', 'Défaut Equipement', 'ERICSSON', '1525');
INSERT INTO public."ReqEquip" VALUES ('Haddounizdar', '31,2315555555556', '-5,32455555555556', '2020-06-09 08:27:10', 'CI HS', 'SRAN-ERC', 'DRM', '1552', 'DC OUARZAZATE-ZAGORA', '2519', 'Défaut Equipement', 'ERICSSON', '1525');
INSERT INTO public."ReqEquip" VALUES ('Haddounoufella', '31,2573888888889', '-5,36806666666667', '2020-06-09 08:27:10', 'CI HS', 'SRAN-ERC', 'DRM', '1552', 'DC OUARZAZATE-ZAGORA', '2519', 'Défaut Equipement', 'ERICSSON', '1525');
INSERT INTO public."ReqEquip" VALUES ('CAS_MICAIRFRANCE', '33,59686111', '-7,615388889', '2019-11-26 12:04:43', 'CI HS', 'SRAN-HW', 'DRC', '1550', 'DC ANFA', '2477', 'Défaut Equipement', 'HUAWEI', '1528');
INSERT INTO public."ReqEquip" VALUES ('RAB_ALABDARI', '34,0205', '-6,84216944444444', '2020-06-09 08:51:34', 'CI HS', 'SRAN-HW', 'DRR', '1555', 'DC RABAT', '2516', 'Défaut Transmission', 'HUAWEI', '1528');
INSERT INTO public."ReqEquip" VALUES ('RAB_BMCE', '34,0218611111111', '-6,83693888888889', '2020-06-09 08:51:34', 'CI HS', 'SRAN-HW', 'DRR', '1555', 'DC RABAT', '2516', 'Défaut Transmission', 'HUAWEI', '1528');
INSERT INTO public."ReqEquip" VALUES ('RAB_MICMAMOUNIA', '34,0214388888889', '-6,83868888888889', '2020-06-09 08:51:34', 'CI HS', 'SRAN-HW', 'DRR', '1555', 'DC RABAT', '2516', 'Défaut Transmission', 'HUAWEI', '1528');
INSERT INTO public."ReqEquip" VALUES ('samanah', '31,50463889', '-8,061027778', '2020-06-09 09:11:59', 'CI HS', 'SRAN-ERC', 'DRM', '1552', 'DC EL KELAA-AL HAOUZ', '2496', 'Défaut Equipement', 'ERICSSON', '1525');
INSERT INTO public."ReqEquip" VALUES ('DCKH_IZTATMINI', '32,9991111111111', '-4,79191666666667', '2020-06-09 08:52:24', 'CI HS', 'SRAN-NSN', 'DRF', '1553', 'DC KHENIFRA', '2493', 'Défaut Equipement', 'NSN', '1535');
INSERT INTO public."ReqEquip" VALUES ('RAB_RESMYRACHID', '33,92503056', '-6,824430556', '2020-06-09 09:26:59', 'CI HS', 'SRAN-HW', 'DRR', '1555', 'DC RABAT', '2516', 'Défaut Equipement', 'HUAWEI', '1528');
INSERT INTO public."ReqEquip" VALUES ('DCBR_Ouled Ali', '34,0491638888889', '-2,04527777777778', '2020-06-09 09:10:29', 'CI HS', 'SRAN-NSN', 'DRO', '1554', 'DC BERKANE-TAOURIRT-JERRADA-BOUARFA', '2482', 'Défaut Equipement', 'NSN', '1535');
INSERT INTO public."ReqEquip" VALUES ('DCTZ_BABMARZOUKA', '34,2109972222222', '-4,14447777777778', '2020-06-09 09:12:33', 'CI HS', 'SRAN-NSN', 'DRF', '1553', 'DC TAZA', '2505', 'Défaut Environnement', 'NSN', '1535');
INSERT INTO public."ReqEquip" VALUES ('SKALA', '31,525', '-9,753', '2020-06-09 09:39:18', 'CI HS', 'SRAN-ERC', 'DRM', '1552', 'DC SAFI-ESSAOUIRA-CHICHAOUA', '2510', 'Défaut Transmission', 'ERICSSON', '1525');
INSERT INTO public."ReqEquip" VALUES ('DCTE_ADELDAL', '35,1394444444444', '-5,07997222222222', '2020-06-09 10:05:19', 'CI HS', 'SRAN-NSN', 'DRT', '1557', 'DC TETOUAN-CHEFCHAOUEN', '2503', 'Défaut Equipement', 'NSN', '1535');
INSERT INTO public."ReqEquip" VALUES ('Ouidouran', '30,1370833333333', '-8,99977777777778', '2020-06-09 10:09:16', 'CI HS', 'SRAN-ERC', 'DRA', '1556', 'DC AGADIR', '2486', 'Défaut Equipement', 'ERICSSON', '1525');
INSERT INTO public."ReqEquip" VALUES ('DCND_SIDIBRAHIM', '35,0714722222222', '-2,50027777777778', '2020-06-09 10:42:11', 'CI HS', 'SRAN-NSN', 'DRO', '1554', 'DC NADOR', '2520', 'Défaut Equipement', 'NSN', '1535');
INSERT INTO public."ReqEquip" VALUES ('CAS_CasaSofaca', '33,53616667', '-7,613555556', '2019-12-12 11:04:37', 'CI HS', 'SRAN-HW', 'DRC', '1550', 'DC AIN CHOCK EL FIDA', '2487', 'Défaut Equipement', 'HUAWEI', '1528');
INSERT INTO public."ReqEquip" VALUES ('BTS_Mobile', '33,9593638888889', '-6,85320833333333', '2019-12-24 17:23:09', 'CI HS', 'SRAN-NSN', 'DRR', '1555', 'DC KENITRA - SIDI KACEM', '2495', 'Défaut Equipement', 'NSN', '1535');
INSERT INTO public."ReqEquip" VALUES ('CAS_CasaChahbi', '33,5895', '-7,526061111', '2020-01-30 23:11:42', 'CI HS', 'SRAN-HW', 'DRC', '1550', 'DC BEN MSIK SIDI OTHMANE', '2479', 'Défaut Equipement', 'HUAWEI', '1528');
INSERT INTO public."ReqEquip" VALUES ('CAS_Pepsi', '33,44077778', '-7,641861111', '2020-02-27 15:26:00', 'CI HS', 'SRAN-HW', 'DRC', '1550', 'DC HAY HASSANI BOUSKOURA', '1560', 'Défaut Equipement', 'HUAWEI', '1528');
INSERT INTO public."ReqEquip" VALUES ('RAB_PALAISRCHID', '33,93033611', '-6,82125', '2020-03-03 11:48:44', 'CI HS', 'SRAN-HW', 'DRR', '1555', 'DC RABAT', '2516', 'Défaut Equipement', 'HUAWEI', '1528');
INSERT INTO public."ReqEquip" VALUES ('AAU1_STADEMEDVENTREE', '33,5830277777778', '-7,64803888888889', '2020-03-21 19:10:20', 'CI HS', 'SRAN-HW', 'DRC', '1550', 'DC ANFA', '2477', 'Défaut Equipement', 'HUAWEI', '1528');
INSERT INTO public."ReqEquip" VALUES ('CAS_MICTRIANON', '33,5890916666667', '-7,63110555555556', '2020-03-30 12:00:39', 'CI HS', 'SRAN-HW', 'DRC', '1550', 'DC ANFA', '2477', 'Défaut Equipement', 'HUAWEI', '1528');
INSERT INTO public."ReqEquip" VALUES ('FES_HotelBarceloMini', '34,0433', '-4,99719444444444', '2020-04-03 10:03:32', 'CI HS', 'SRAN-NSN', 'DRF', '1553', 'DC FES', '2501', 'Défaut Equipement', 'NSN', '1535');
INSERT INTO public."ReqEquip" VALUES ('RAB_MiniDarEsslam', '33,948675', '-6,83473056', '2020-05-15 19:09:29', 'CI HS', 'SRAN-HW', 'DRR', '1555', 'DC RABAT', '2516', 'Défaut Equipement', 'HUAWEI', '1528');
INSERT INTO public."ReqEquip" VALUES ('RAB_MICROCOMPLEXE', '33,9675', '-6,883219444', '2020-05-24 19:37:27', 'CI HS', 'SRAN-HW', 'DRR', '1555', 'DC RABAT', '2516', 'Défaut Equipement', 'HUAWEI', '1528');
INSERT INTO public."ReqEquip" VALUES ('CAS_ELHANK', '33,60527778', '-7,657527778', '2020-05-29 14:18:06', 'CI HS', 'SRAN-HW', 'DRC', '1550', 'DC ANFA', '2477', 'Défaut Equipement', 'HUAWEI', '1528');
INSERT INTO public."ReqEquip" VALUES ('Talghijt', '28,950075', '-8,6501', '2020-06-02 06:44:59', 'CI HS', 'SRAN-ERC', 'DRA', '1556', 'DC TAROUDANT-TATA-CHTOUKA', '2507', 'Défaut Equipement', 'ERICSSON', '1525');
INSERT INTO public."ReqEquip" VALUES ('CAS_CasaMabsoute', '33,561997', '-7,595136', '2020-06-02 14:26:10', 'CI HS', 'SRAN-HW', 'DRC', '1550', 'DC AIN CHOCK EL FIDA', '2487', 'Défaut Equipement', 'HUAWEI', '1528');
INSERT INTO public."ReqEquip" VALUES ('CAS_CentralPark', '33,4790916666667', '-7,63519166666667', '2020-06-05 09:48:59', 'CI HS', 'SRAN-HW', 'DRC', '1550', 'DC HAY HASSANI BOUSKOURA', '1560', 'Défaut Equipement', 'HUAWEI', '1528');
INSERT INTO public."ReqEquip" VALUES ('KTIFATE', '32,1066666666667', '-9,20655555555556', '2020-06-06 00:15:41', 'CI HS', 'SRAN-ERC', 'DRM', '1552', 'DC SAFI-ESSAOUIRA-CHICHAOUA', '2510', 'Défaut Equipement', 'ERICSSON', '1525');
INSERT INTO public."ReqEquip" VALUES ('Aitouassif', '31,27096111', '-6,139097222', '2020-06-06 16:22:06', 'CI HS', 'SRAN-ERC', 'DRM', '1552', 'DC OUARZAZATE-ZAGORA', '2519', 'Défaut Environnement', 'ERICSSON', '1525');


--
-- TOC entry 2965 (class 0 OID 17686)
-- Dependencies: 209
-- Data for Name: ReqEquip2g; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."ReqEquip2g" VALUES ('2G_DCTE_IKHARRIMANE_191095', '35,3016666666667', '-5,05055555555556', '2020-06-07 19:50:15', 'CI HS', 'SRAN-NSN', 'DRT', '1557', 'DC TETOUAN-CHEFCHAOUEN', '2503', 'Défaut Equipement', 'NSN', '1535');


--
-- TOC entry 2966 (class 0 OID 17692)
-- Dependencies: 210
-- Data for Name: ReqEquip3g; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."ReqEquip3g" VALUES ('S3GD_Amslane', '31,0720277777778', '-8,06527777777778', '2020-06-09 02:28:07', 'CI HS', 'SRAN-ERC', 'DRM', '1552', 'DC EL KELAA-AL HAOUZ', '2496', 'Défaut Equipement', 'ERICSSON', '1525');
INSERT INTO public."ReqEquip3g" VALUES ('S3G_MarrakechEntreeMenara', '31,614', '-8,017', '2020-06-09 02:28:07', 'CI HS', 'SRAN-ERC', 'DRM', '1552', 'DC MARRAKECH', '2490', 'Défaut Equipement', 'ERICSSON', '1525');
INSERT INTO public."ReqEquip3g" VALUES ('S3GD_Bouizdadane', '30,6105833333333', '-7,97336111111111', '2020-06-09 02:48:07', 'CI HS', 'SRAN-ERC', 'DRA', '1556', 'DC TAROUDANT-TATA-CHTOUKA', '2507', 'Défaut Equipement', 'ERICSSON', '1525');
INSERT INTO public."ReqEquip3g" VALUES ('S3G_ALMAHKAMA', '30,354', '-9,535', '2020-06-09 01:51:11', 'CI HS', 'SRAN-ERC', 'DRA', '1556', 'DC AGADIR', '2486', 'Défaut Equipement', 'ERICSSON', '1525');
INSERT INTO public."ReqEquip3g" VALUES ('S3GB_Mirleftamical', '29,588675', '-10,040645', '2020-06-09 01:18:56', 'CI HS', 'SRAN-ERC', 'DRA', '1556', 'DC GUELMIM-ASSA ZAG-TAN TAN', '2498', 'Défaut Equipement', 'ERICSSON', '1525');


--
-- TOC entry 2967 (class 0 OID 17698)
-- Dependencies: 211
-- Data for Name: ReqEquip4g; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."ReqEquip4g" VALUES ('4G_Asrir', '30,35363889', '-5,844888889', '2020-06-08 12:41:41', 'CI HS', 'SRAN-ERC', 'DRM', '1552', 'DC OUARZAZATE-ZAGORA', '2519', 'Défaut Equipement', 'ERICSSON', '1525');
INSERT INTO public."ReqEquip4g" VALUES ('4G_MarrakechBenohoud', '31,62578056', '-8,005944444', '2020-06-07 19:03:07', 'CI HS', 'SRAN-ERC', 'DRM', '1552', 'DC MARRAKECH', '2490', 'Défaut Environnement', 'ERICSSON', '1525');
INSERT INTO public."ReqEquip4g" VALUES ('4G_MarrakechAsoufit', '31,55828056', '-8,094527778', '2019-12-19 14:53:20', 'CI HS', 'SRAN-ERC', 'DRM', '1552', 'DC MARRAKECH', '2490', 'Défaut Equipement', 'ERICSSON', '1525');
INSERT INTO public."ReqEquip4g" VALUES ('4G-Fes-Wahda2-43000269', '34,01761111', '-5,062888889', '2020-06-08 15:41:32', 'CI HS', 'SRAN-NSN', 'DRF', '1553', 'DC FES', '2501', 'Défaut Equipement', 'NSN', '1535');
INSERT INTO public."ReqEquip4g" VALUES ('4G-Fes-HayNouzha-43000507', '34,01507778', '-5,011705556', '2020-06-09 08:20:09', 'CI HS', 'SRAN-NSN', 'DRF', '1553', 'DC FES', '2501', 'Défaut Equipement', 'NSN', '1535');
INSERT INTO public."ReqEquip4g" VALUES ('4GB_Awsserd', '22,55111667', '-14,33173333', '2020-06-05 04:45:18', 'CI HS', 'SRAN-ERC', 'DRA', '1556', 'DC LAAYOUNE-SAKIA LHAMRA-BOUJDOUR', '2492', 'Défaut Configuration', 'ERICSSON', '1525');
INSERT INTO public."ReqEquip4g" VALUES ('4G_AgadirCibelMini', '30,44092222', '-9,650977778', '2020-06-08 21:15:03', 'CI HS', 'SRAN-ERC', 'DRA', '1556', 'DC AGADIR', '2486', 'Défaut Equipement', 'ERICSSON', '1525');


--
-- TOC entry 2968 (class 0 OID 17704)
-- Dependencies: 212
-- Data for Name: ReqMSAN; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."ReqMSAN" VALUES ('MHOu-Ta-MellousaDiar', '35,725744', '-5.632133', '2020-06-10 00:00:50', 'CI HS', 'MSAN-HW', 'DRT', '1557', 'DC TANGER', '2508', 'Défaut Environnement', 'HUAWEI', '1528');
INSERT INTO public."ReqMSAN" VALUES ('MHIM-NKOB1-1', '30,88225', '-5.868111', '2020-06-10 08:20:36', 'CI HS', 'MSAN-HW', 'DRM', '1552', 'DC OUARZAZATE-ZAGORA', '2519', 'Défaut Transmission', 'HUAWEI', '1528');
INSERT INTO public."ReqMSAN" VALUES ('MHIM-OuladSlimane1-1', '30,58', '-6.148983', '2020-06-10 08:20:36', 'CI HS', 'MSAN-HW', 'DRM', '1552', 'DC OUARZAZATE-ZAGORA', '2519', 'Défaut Transmission', 'HUAWEI', '1528');
INSERT INTO public."ReqMSAN" VALUES ('MZIn-Mar-Oua-Agdez', '30,69651', '-6.448588', '2020-06-10 08:20:36', 'CI HS', 'MSAN-ZTE', 'DRM', '1552', 'DC OUARZAZATE-ZAGORA', '2519', 'Défaut Transmission', 'ZTE', '1542');
INSERT INTO public."ReqMSAN" VALUES ('MZIn-Mar-Oua-Tamazmoute', '30,66763', '-6.144394', '2020-06-10 08:20:36', 'CI HS', 'MSAN-ZTE', 'DRM', '1552', 'DC OUARZAZATE-ZAGORA', '2519', 'Défaut Transmission', 'ZTE', '1542');
INSERT INTO public."ReqMSAN" VALUES ('MZIn-Mar-Oua-Tazarine', '30,78227', '-5.566678', '2020-06-10 08:20:36', 'CI HS', 'MSAN-ZTE', 'DRM', '1552', 'DC OUARZAZATE-ZAGORA', '2519', 'Défaut Transmission', 'ZTE', '1542');
INSERT INTO public."ReqMSAN" VALUES ('MHIn-Ca-Bricolage1-1', '33,38', '-7.692532', '2020-06-10 10:45:19', 'CI HS', 'MSAN-HW', 'DRC', '1550', 'DC HAY HASSANI BOUSKOURA', '1560', 'Défaut Equipement', 'HUAWEI', '1528');
INSERT INTO public."ReqMSAN" VALUES ('MZOu-Ra-Keni-OuledMBarek', '34,231119', '-6.622117', '2020-06-10 10:48:49', 'CI HS', 'MSAN-ZTE', 'DRR', '1555', 'DC KENITRA - SIDI KACEM', '2495', 'Défaut Environnement', 'ZTE', '1542');


--
-- TOC entry 2977 (class 0 OID 17840)
-- Dependencies: 221
-- Data for Name: TeamCsnInfra; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."TeamCsnInfra" VALUES (1, 1, 'i1');
INSERT INTO public."TeamCsnInfra" VALUES (2, 1, 'i2');
INSERT INTO public."TeamCsnInfra" VALUES (3, 1, 'i3');
INSERT INTO public."TeamCsnInfra" VALUES (4, 2, 'i1');
INSERT INTO public."TeamCsnInfra" VALUES (5, 2, 'i2');
INSERT INTO public."TeamCsnInfra" VALUES (6, 2, 'i3');
INSERT INTO public."TeamCsnInfra" VALUES (7, 3, 'i1');
INSERT INTO public."TeamCsnInfra" VALUES (8, 3, 'i2');
INSERT INTO public."TeamCsnInfra" VALUES (9, 3, 'i3');
INSERT INTO public."TeamCsnInfra" VALUES (10, 1, 'i1');
INSERT INTO public."TeamCsnInfra" VALUES (11, 2, 'i2');
INSERT INTO public."TeamCsnInfra" VALUES (12, 3, 'i3');


--
-- TOC entry 2969 (class 0 OID 17710)
-- Dependencies: 213
-- Data for Name: dc; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.dc VALUES ('1562', 'DC AL HOUCEIMA', '1557');
INSERT INTO public.dc VALUES ('1561', 'DC AIN SBAA BERNOUSSI MOHAMMADIA', '1550');
INSERT INTO public.dc VALUES ('2487', 'DC AIN CHOCK EL FIDA', '1550');
INSERT INTO public.dc VALUES ('2479', 'DC BEN MSIK SIDI OTHMANE', '1550');
INSERT INTO public.dc VALUES ('2481', 'DC BENIMELLAL-AZILAL-KHOURIBGA', '1551');
INSERT INTO public.dc VALUES ('2482', 'DC BERKANE-TAOURIRT-JERRADA-BOUARFA', '1554');
INSERT INTO public.dc VALUES ('2488', 'DC EL JADIDA', '1551');
INSERT INTO public.dc VALUES ('2477', 'DC ANFA', '1550');
INSERT INTO public.dc VALUES ('2496', 'DC EL KELAA-AL HAOUZ', '1552');
INSERT INTO public.dc VALUES ('2518', 'DC OUJDA', '1554');
INSERT INTO public.dc VALUES ('2507', 'DC TAROUDANT-TATA-CHTOUKA', '1556');
INSERT INTO public.dc VALUES ('2500', 'DC ERRACHIDIA', '1553');
INSERT INTO public.dc VALUES ('2519', 'DC OUARZAZATE-ZAGORA', '1552');
INSERT INTO public.dc VALUES ('2520', 'DC NADOR', '1554');
INSERT INTO public.dc VALUES ('2523', 'DC MEKNES IFRAN-HAJEB-MISSOUR', '1553');
INSERT INTO public.dc VALUES ('2501', 'DC FES', '1553');
INSERT INTO public.dc VALUES ('2508', 'DC TANGER', '1557');
INSERT INTO public.dc VALUES ('2503', 'DC TETOUAN-CHEFCHAOUEN', '1557');
INSERT INTO public.dc VALUES ('2504', 'DC TEMARA', '1555');
INSERT INTO public.dc VALUES ('2505', 'DC TAZA', '1553');
INSERT INTO public.dc VALUES ('2510', 'DC SAFI-ESSAOUIRA-CHICHAOUA', '1552');
INSERT INTO public.dc VALUES ('2513', 'DC SETTAT', '1551');
INSERT INTO public.dc VALUES ('2514', 'DC SALE', '1555');
INSERT INTO public.dc VALUES ('2516', 'DC RABAT', '1555');
INSERT INTO public.dc VALUES ('2490', 'DC MARRAKECH', '1552');
INSERT INTO public.dc VALUES ('2491', 'DC LARACHE', '1557');
INSERT INTO public.dc VALUES ('2492', 'DC LAAYOUNE-SAKIA LHAMRA-BOUJDOUR', '1556');
INSERT INTO public.dc VALUES ('2493', 'DC KHENIFRA', '1553');
INSERT INTO public.dc VALUES ('2494', 'DC KHEMISSET', '1555');
INSERT INTO public.dc VALUES ('2495', 'DC KENITRA - SIDI KACEM', '1555');
INSERT INTO public.dc VALUES ('2486', 'DC AGADIR', '1556');
INSERT INTO public.dc VALUES ('2498', 'DC GUELMIM-ASSA ZAG-TAN TAN', '1556');
INSERT INTO public.dc VALUES ('1560', 'DC HAY HASSANI BOUSKOURA', '1550');


--
-- TOC entry 2970 (class 0 OID 17716)
-- Dependencies: 214
-- Data for Name: dr; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.dr VALUES ('1550', 'DRC');
INSERT INTO public.dr VALUES ('1556', 'DRA');
INSERT INTO public.dr VALUES ('1551', 'DRS');
INSERT INTO public.dr VALUES ('1552', 'DRM');
INSERT INTO public.dr VALUES ('1553', 'DRF');
INSERT INTO public.dr VALUES ('1554', 'DRO');
INSERT INTO public.dr VALUES ('1557', 'DRT');
INSERT INTO public.dr VALUES ('1555', 'DRR');


--
-- TOC entry 2971 (class 0 OID 17722)
-- Dependencies: 215
-- Data for Name: fournisseur; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.fournisseur VALUES ('1522', 'ALCATEL', 'MSAN');
INSERT INTO public.fournisseur VALUES ('1528', 'HUAWEI', 'MSAN');
INSERT INTO public.fournisseur VALUES ('1528', 'HUAWEI', NULL);
INSERT INTO public.fournisseur VALUES ('1525', 'ERICSSON', NULL);
INSERT INTO public.fournisseur VALUES ('1535', 'NSN', 'MSAN');
INSERT INTO public.fournisseur VALUES ('1525', 'NSN', NULL);
INSERT INTO public.fournisseur VALUES ('1542', 'ZTE', 'MSAN');


--
-- TOC entry 2983 (class 0 OID 26053)
-- Dependencies: 227
-- Data for Name: req_stat_mbts; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.req_stat_mbts VALUES ('DRC', '14');
INSERT INTO public.req_stat_mbts VALUES ('DRF', '3');
INSERT INTO public.req_stat_mbts VALUES ('DRM', '15');
INSERT INTO public.req_stat_mbts VALUES ('DRO', '2');
INSERT INTO public.req_stat_mbts VALUES ('DRR', '4');
INSERT INTO public.req_stat_mbts VALUES ('DRS', '7');
INSERT INTO public.req_stat_mbts VALUES ('DRT', '10');


--
-- TOC entry 2984 (class 0 OID 26059)
-- Dependencies: 228
-- Data for Name: req_stat_msan; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.req_stat_msan VALUES ('DRM', '1');


--
-- TOC entry 2990 (class 0 OID 0)
-- Dependencies: 222
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 1, false);


--
-- TOC entry 2815 (class 2606 OID 17849)
-- Name: IncidentCi IncidentCi_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."IncidentCi"
    ADD CONSTRAINT "IncidentCi_pkey" PRIMARY KEY (id);


--
-- TOC entry 2813 (class 2606 OID 17851)
-- Name: Incident Incident_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Incident"
    ADD CONSTRAINT "Incident_pkey" PRIMARY KEY ("Id");


--
-- TOC entry 2817 (class 2606 OID 17853)
-- Name: LookUp LookUp_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."LookUp"
    ADD CONSTRAINT "LookUp_pkey" PRIMARY KEY ("Id");


--
-- TOC entry 2825 (class 2606 OID 17868)
-- Name: MBTS2G MBTS2G_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."MBTS2G"
    ADD CONSTRAINT "MBTS2G_pkey" PRIMARY KEY ("Id");


--
-- TOC entry 2827 (class 2606 OID 17876)
-- Name: MBTS3G MBTS3G_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."MBTS3G"
    ADD CONSTRAINT "MBTS3G_pkey" PRIMARY KEY ("Id");


--
-- TOC entry 2829 (class 2606 OID 17884)
-- Name: MBTS4G MBTS4G_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."MBTS4G"
    ADD CONSTRAINT "MBTS4G_pkey" PRIMARY KEY ("Id");


--
-- TOC entry 2819 (class 2606 OID 17855)
-- Name: MBTS MBTS_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."MBTS"
    ADD CONSTRAINT "MBTS_pkey" PRIMARY KEY ("Id");


--
-- TOC entry 2831 (class 2606 OID 17892)
-- Name: MSAN MSAN_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."MSAN"
    ADD CONSTRAINT "MSAN_pkey" PRIMARY KEY ("Id");


--
-- TOC entry 2821 (class 2606 OID 17857)
-- Name: NetworkElement NetworkElement_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."NetworkElement"
    ADD CONSTRAINT "NetworkElement_pkey" PRIMARY KEY ("Id");


--
-- TOC entry 2823 (class 2606 OID 17859)
-- Name: TeamCsnInfra TeamCsnInfra_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."TeamCsnInfra"
    ADD CONSTRAINT "TeamCsnInfra_pkey" PRIMARY KEY (id);


-- Completed on 2020-07-06 09:48:51

--
-- PostgreSQL database dump complete
--

