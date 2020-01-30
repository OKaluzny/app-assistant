# JAVA MICROSERVICE IMAGE
FROM postgres:12

ENV POSTGRES_DB=it
ENV POSTGRES_USER=ms_assistant
ENV POSTGRES_PASSWORD=ms_assistant

ADD src/main/resources/db/sql/schema.sql /docker-entrypoint-initdb.d/

#COPY docker-entrypoint-initdb.d /docker-entrypoint-initdb.d
