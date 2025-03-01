GRANT USAGE ON SCHEMA public TO "nsbandsql-api";
GRANT CREATE ON SCHEMA public TO "nsbandsql-api";
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO "nsbandsql-api";
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA public TO "nsbandsql-api";
GRANT ALL PRIVILEGES ON ALL FUNCTIONS IN SCHEMA public TO "nsbandsql-api";
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT ALL ON TABLES TO "nsbandsql-api";

GRANT ALL PRIVILEGES ON SCHEMA public TO "nsbandsql-api";
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT ALL ON TABLES TO "nsbandsql-api";

ALTER ROLE "nsbandsql-api" SET search_path TO public;

GRANT ALL PRIVILEGES ON SCHEMA public TO "nsbandsql-api";
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT ALL ON TABLES TO "nsbandsql-api";
ALTER ROLE "nsbandsql-api" SET search_path TO public;

ALTER ROLE "nsbandsql-api" SET search_path TO public;