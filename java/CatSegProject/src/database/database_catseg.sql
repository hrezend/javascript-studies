create database if not exists catseg;
use catseg;

create table if not exists administradores(
	adminID varchar(45) not null primary key,
	adminName varchar(45) not null,
	adminLogin varchar(45) not null,
	adminPassword varchar(45) not null,
	adminEmail varchar(45) not null
);

create table if not exists funcionarios(
	funcionarioID varchar(45) not null primary key,
	funcionarioName varchar(45) not null,
	funcionarioEmail varchar(45) not null,
	funcionarioTelefone varchar(45) not null,
	funcionarioCPF varchar(45) not null
);

create table if not exists indicadores(
	indicadorID int not null primary key auto_increment,
	idade int not null,
	quantidadeDeAdvertencias int not null,
	quantidadeDeAcidentes int not null,
	cargaHorariaSemanalDeTrabalho int not null,
	cargaHorariaTotalDeTreinamento int not null,
	cargo varchar(45) not null,
	setor varchar(45) not null,
	funcionarioID varchar(45) not null
);

 
 
