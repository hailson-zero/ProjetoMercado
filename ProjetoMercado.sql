create database mercado;
use mercado;

create table produto (
	id_produto int primary key auto_increment not null,
    nome varchar(20) not null,
    descricao varchar(80),
    fornecedor varchar(20),
    marca varchar(20),
    valorcompra decimal(10,2) not null,
    valorvenda decimal(10,2),
    valorlucro decimal(10,2)
)engine innodb;

delimiter $$
create trigger tr_valorlucro before insert
	on produto for each row
begin
	set new.valorlucro = (new.valorcompra*0.10);
end; $$
delimiter ;

delimiter $$
create trigger tr_valorvenda before insert
	on produto for each row
begin
	set new.valorvenda = (new.valorcompra+(new.valorcompra*0.10));
end; $$
delimiter ;

delimiter $$
create trigger tr_up_valorlucro before update
	on produto for each row
begin
	if (new.valorcompra != old.valorcompra) then
		set new.valorlucro = (new.valorcompra*0.10);
	end if;
end; $$
delimiter ;

delimiter $$
create trigger tr_up_valorvenda before update
	on produto for each row
begin
	if (new.valorcompra != old.valorcompra) then
		set new.valorvenda = (new.valorcompra+(new.valorcompra*0.10));
	end if;
end; $$
delimiter ;