use aps;

drop table aluno;
drop table endereco;
drop table professor;
drop table pessoa;
drop table disciplina;

create table pessoa
(nome varchar(80),
email varchar(80),
data_nascimento date,
sexo varchar(1),
cpf varchar(15),
rg varchar(15),
primary key(cpf));

create table aluno
(ra int,
periodo int,
ano int,
cpf varchar(15),
primary key(ra),
foreign key(cpf) references pessoa);

create table professor
(rp int,
formacao varchar(100),
salario int,
departamento varchar(30),
cpf varchar(15),
primary key(rp),
foreign key(cpf) references pessoa);

create table endereco
(cep varchar(15),
rua varchar(50),
bairro varchar (50),
numero int,
complemento varchar(100),
cpf varchar(15),
primary key(cep,rua,bairro,numero,complemento),
foreign key(cpf) references pessoa);

create table disciplina
(nome varchar(30),
codigo varchar (5),
bloco varchar(1),
sala int,
cargaHoraria int,
ementa varchar(100),
bibliografia varchar(100),
primary key(codigo));




