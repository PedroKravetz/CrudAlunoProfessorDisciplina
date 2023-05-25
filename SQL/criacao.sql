use aps;

drop table aluno;
drop table endereco;
drop table pessoa;

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

create table endereco
(genID int(5) auto_increment,
cep varchar(15),
rua varchar(50),
bairro varchar (50),
numero int,
complemento varchar(100),
cpf varchar(15),
primary key(genID),
foreign key(cpf) references pessoa)


