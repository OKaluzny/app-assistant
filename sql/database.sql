-- schema owner
CREATE USER ms_assistant WITH password 'ms_assistant';

-- schema user
CREATE USER ms_assistant_ms WITH password 'ms_assistant_ms';


-- create schema
CREATE SCHEMA ms_assistant AUTHORIZATION ms_assistant;

GRANT USAGE ON SCHEMA ms_assistant TO ms_assistant_ms;

ALTER DEFAULT PRIVILEGES FOR USER ms_assistant IN SCHEMA ms_assistant GRANT SELECT,INSERT,UPDATE,DELETE,TRUNCATE ON TABLES TO ms_assistant_ms;
ALTER DEFAULT PRIVILEGES FOR USER ms_assistant IN SCHEMA ms_assistant GRANT USAGE ON SEQUENCES TO ms_assistant_ms;
ALTER DEFAULT PRIVILEGES FOR USER ms_assistant IN SCHEMA ms_assistant GRANT EXECUTE ON FUNCTIONS TO ms_assistant_ms;

ALTER USER ms_assistant_ms SET search_path = 'ms_assistant';
