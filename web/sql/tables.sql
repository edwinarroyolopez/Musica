USE musica_db;
GO
CREATE TABLE ARTISTA (
  "Id_artista" INT NOT NULL IDENTITY(1,1),
  "Nombre" VARCHAR(30) NOT NULL ,
  "Edad" INT NOT NULL ,
  "Pais" VARCHAR(20) NULL ,
  "Genero_musical" VARCHAR(100) NULL ,
   CONSTRAINT "PK_ARTISTA" PRIMARY KEY ( "Id_artista" ) );

INSERT INTO Artista (Nombre,Edad,Pais,Genero_musical) values ('Cuarterto de nos',34,'Uruguay','Rock Alternativa')


USE musica_db;
GO
CREATE TABLE ALBUM (
  "Id_album" INT NOT NULL IDENTITY(1,1),
  "Descripcion" VARCHAR(20) NOT NULL ,
  "Anio" INT NOT NULL ,
  "Id_artista" INT NOT NULL FOREIGN KEY ("Id_artista") REFERENCES ARTISTA("Id_artista")
   CONSTRAINT "PK_ALBUM" PRIMARY KEY ( "Id_album" ) );

INSERT INTO Album (Descripcion,Anio,Id_artista) values ('Habla tu espejo',2014,1)


USE musica_db;
GO
CREATE TABLE CANCION (
  "Id_cancion" INT NOT NULL IDENTITY(1,1),
  "Descripcion" VARCHAR(20) NOT NULL,
  "Id_album" INT NOT NULL FOREIGN KEY ("Id_album") REFERENCES ALBUM("Id_album")
   CONSTRAINT "PK_CANCION" PRIMARY KEY ( "Id_cancion" ) );

INSERT INTO Cancion (Descripcion,Id_album) values ('No llora',1)

select * from Artista
select * from Album
select * from Cancion

/**/
