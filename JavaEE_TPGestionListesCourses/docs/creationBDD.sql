CREATE TABLE Listes
(
	id int identity(1,1) CONSTRAINT PK_LISTES PRIMARY KEY,
	nom varchar(100) NOT NULL
);

CREATE TABLE Articles
(
	id int identity(1,1) CONSTRAINT PK_ARTICLES PRIMARY KEY,
	nom varchar(50) NOT NULL,
	prixUnitaire float NOT NULL,
	quantite int NOT NULL,
	id_liste int NOT NULL
);

ALTER TABLE Articles ADD CONSTRAINT
	FK_ARTICLES_LISTES FOREIGN KEY(id_liste) REFERENCES LISTES(id);