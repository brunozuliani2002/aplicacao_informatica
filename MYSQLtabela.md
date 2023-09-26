create database dbinfox;


use dbinfox;
create table tbusuarios(
id INT AUTO_INCREMENT PRIMARY KEY,
nome varchar (50) not null,
fone varchar (15),
login varchar (15) not null unique,
senha varchar (15) not null
);

describe tbusuarios;

insert into tbusuarios(nome,fone,login,senha)
values ('bruno zuliani','51986819521','brunoesz','memelo01');

insert into tbusuarios(nome,fone,login,senha)
values ('administrador','51986819521','admin','admin');

insert into tbusuarios(nome,fone,login,senha)
values ('jose','51986819521','jose','jose');

select * from tbusuarios;



update usuarios set fone = '8888-88888' where iduser = 2;

delete from tbusuarios where iduser =3;

create table tbclientes(
idcli int primary key auto_increment,
nomecli varchar (50) not null,
endcli varchar (100),
fonecli varchar (20) not null,
emailcli varchar (50)
);

insert into tbclientes(nomecli, endcli, fonecli, emailcli)
values('alguem','rua teor','1111-1111','pao@gmail.com');

describe tbclientes;



create table tbpedidos(
id INT AUTO_INCREMENT PRIMARY KEY,
produto varchar (50) not null,
preco varchar (20) not null
);


insert into tbpedidos(produto, preco)
values('brocolis','20.00');

select * from tbpedidos;