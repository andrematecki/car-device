select * from am_contato;
select * from am_investidor;
select * from am_noticia;
select * from am_status;
select * from am_usuario;

delete from am_contato;
delete from am_investidor;
delete from am_noticia;
delete from am_status;
delete from am_usuario where id != 21;