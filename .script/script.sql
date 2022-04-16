CREATE DATABASE dbdperks;
USE dbdperks;


CREATE TABLE builds(
    id_Build INT NOT NULL AUTO_INCREMENT, 
    CONSTRAINT PK_IDBUILD PRIMARY KEY(id_Build),
    perk1_id VARCHAR(30),
    perk2_id VARCHAR(30),
    perk3_id VARCHAR(30),
    perk4_id VARCHAR(30),
    nameBuild VARCHAR(25) NOT NULL,
    infoBuild VARCHAR(100) NOT NULL
);


