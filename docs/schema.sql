1° 
-- SEQUENCE: public.matriculations_matriculation_id_seq

-- DROP SEQUENCE public.matriculations_matriculation_id_seq;

CREATE SEQUENCE public.matriculations_matriculation_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.matriculations_matriculation_id_seq
    OWNER TO postgres;

-- SEQUENCE: public.students_student_id_seq

-- DROP SEQUENCE public.students_student_id_seq;

CREATE SEQUENCE public.students_student_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.students_student_id_seq
    OWNER TO postgres;

-- SEQUENCE: public.subjects_subject_id_seq

-- DROP SEQUENCE public.subjects_subject_id_seq;

CREATE SEQUENCE public.subjects_subject_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.subjects_subject_id_seq
    OWNER TO postgres;
	
	
--------------------------------------------------------------------------------------
2°
-- Table: public.matriculations

-- DROP TABLE public.matriculations;

CREATE TABLE public.matriculations
(
    matriculation_id integer NOT NULL DEFAULT nextval('matriculations_matriculation_id_seq'::regclass),
    student_id integer NOT NULL,
    creation_date date NOT NULL,
    creation_time time without time zone NOT NULL,
    paid boolean NOT NULL,
    pay_day timestamp without time zone,
    total bigint NOT NULL,
    currency character varying(3) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT matriculations_pk PRIMARY KEY (matriculation_id),
    CONSTRAINT students_matriculations_fk FOREIGN KEY (student_id)
        REFERENCES public.students (student_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public.matriculations
    OWNER to postgres;


-- Table: public.students

-- DROP TABLE public.students;

CREATE TABLE public.students
(
    student_id integer NOT NULL DEFAULT nextval('students_student_id_seq'::regclass),
    first_name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    last_name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    birth_date date,
    gender character varying(1) COLLATE pg_catalog."default" NOT NULL,
    height real,
    weight real,
    email character(40) COLLATE pg_catalog."default",
    creation_date_time time without time zone NOT NULL,
    document_number character varying(15) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT students_pk PRIMARY KEY (student_id)
)

TABLESPACE pg_default;

ALTER TABLE public.students
    OWNER to postgres;
	
	
	-- Table: public.subjects

-- DROP TABLE public.subjects;

CREATE TABLE public.subjects
(
    subject_id integer NOT NULL DEFAULT nextval('subjects_subject_id_seq'::regclass),
    name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT subjects_pk PRIMARY KEY (subject_id)
)

TABLESPACE pg_default;

ALTER TABLE public.subjects
    OWNER to postgres;
	
-- Table: public.matriculation_subjects

-- DROP TABLE public.matriculation_subjects;

CREATE TABLE public.matriculation_subjects
(
    matriculation_id integer NOT NULL,
    subject_id integer NOT NULL,
    amount bigint NOT NULL,
    CONSTRAINT matriculation_subjects_pk PRIMARY KEY (matriculation_id, subject_id),
    CONSTRAINT matriculations_matriculation_subjects_fk FOREIGN KEY (matriculation_id)
        REFERENCES public.matriculations (matriculation_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT subjects_matriculation_subjects_fk FOREIGN KEY (subject_id)
        REFERENCES public.subjects (subject_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public.matriculation_subjects
    OWNER to postgres;
