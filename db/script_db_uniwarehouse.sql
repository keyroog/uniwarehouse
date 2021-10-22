drop schema uniwarehouse;

create schema uniwarehouse;

use uniwarehouse;


create table utente(
	matricola int NOT NULL PRIMARY KEY,
    nome varchar(10) not null,
    cognome varchar(10) not null,
	pass varchar(15) not null,
    email varchar(50) not null,
    cellulare varchar(15) not null,
    dipartimento varchar(50) not null,
    tipolaurea varchar(50) not null
);

create table annuncio(
	idannuncio int not null auto_increment primary key,
	nomelibro varchar(50) not null,
    descrizione varchar(250) not null,
    image mediumblob not null,
    datainserimento datetime not null,
	fk_annuncio int not null,
    prezzo varchar(8) not null,
    nome varchar(10),
    cognome varchar(10),
    foreign key(fk_annuncio) references utente(matricola)
);
