CREATE DATABASE dbdperks;
USE dbdperks;


CREATE TABLE builds(
    id_Build INT NOT NULL AUTO_INCREMENT, 
    CONSTRAINT PK_IDBUILD PRIMARY KEY(id_Build),
    perk1_id VARCHAR(30),
    perk1_image VARCHAR(150),
    perk2_id VARCHAR(30),
    perk2_image VARCHAR(150),
    perk3_id VARCHAR(30),
    perk3_image VARCHAR(150),
    perk4_id VARCHAR(30),
    perk4_image VARCHAR(150),
    nameBuild VARCHAR(25) NOT NULL,
    infoBuild VARCHAR(100) NOT NULL,
    tipeBuild BIT NOT NULL
);


CREATE DATABASE dbdperks;
USE dbdperks;


CREATE TABLE builds(
    id_Build INT NOT NULL AUTO_INCREMENT, 
    CONSTRAINT PK_IDBUILD PRIMARY KEY(id_Build),
    perks JSON,
    nameBuild VARCHAR(25) NOT NULL,
    infoBuild VARCHAR(100) NOT NULL,
    tipeBuild BIT NOT NULL
);