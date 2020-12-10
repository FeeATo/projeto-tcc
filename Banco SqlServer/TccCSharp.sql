--
--
-- Antes de criar as tabelas e inserir valores, 
--fa�a as altera��es sitadas no pdf "Guia para rodar as aplica��es", 
--disponibilizado junto aos projetos
--
--

create database TccCSharp
use TccCSharp

create table Tipo_servico(
id_plano int identity primary key,
nome varchar(30),

)

create table ADM(
id_adm int identity primary key,
nome char(30),
login_adm char(30),
senha varchar(30),
email char(30),
)

--insira os dados a seguir:
insert into ADM values('Seu Nome', 'seu_login', '123', 'seu_email@email.com')

----------------

create table notas(
id_notas int primary key,
texto varchar(500),
visivel varchar(3),
)

----------------

create table msg(
id int identity primary key,
titulo varchar(30),
mensagem varchar(500),
qual_tabela varchar(30),
)

----------------

create table Plano(
id int primary key,
nome varchar(30),
preco varchar(30),
)

--insira os dados a seguir:
insert into Plano values (0, '------', '------')
insert into Plano values (1, 'Premium', '29,99')

----------------

create table PrestServ(
id_prestserv int identity primary key,
id_plano int foreign key references Plano(id),
nome_prestserv char(30),
senha char(15),
dtNasc varchar(10),
endereco char(30),
numero int,
complemento char(15),
cpf varchar(11),
telefone varchar(11),
email char(30),
tipo_serv varchar(30),
prestImg varbinary(max),
)

-- Antes de inserir, altere os valores sitados no PDF "Guia para rodar as aplica��es".
--insira os dados a seguir:
insert into PrestServ values ('1','Claudio Freire Teles','123','13/09/1980','Rua Mauricio de Oliveira',170,'ap 161A','15611151',
'11953193155','claudio@email','Cozinheiro', (SELECT * FROM OPENROWSET(BULK N'D:\\Nome_da_pasta\\Imagem_escolhida.png', SINGLE_BLOB) as Image))

insert into PrestServ values ('0','Miguel Alota Teles','123','20/08/1970','Rua Cabo Jo�o',307,'','510888666333',
'11987453251','miguelalota@email','Faxineiro', (SELECT * FROM OPENROWSET(BULK N'D:\\Nome_da_pasta\\Imagem_escolhida.png', SINGLE_BLOB) as Image))

insert into PrestServ values ('1','Trisha Souza Klein','123','02/03/1966','Rua Tenente Pereira',57,'Casa 3','515849620323',
'11999261542','trishasouza@email','Encanador', (SELECT * FROM OPENROWSET(BULK N'D:\\Nome_da_pasta\\Imagem_escolhida.png', SINGLE_BLOB) as Image))

insert into PrestServ values ('0','Jo�o Charles Silva','123','10/05/1957','Avenida Santana',563,'','488948451516',
'22515184848','joaocharles@email','Manicure', (SELECT * FROM OPENROWSET(BULK N'D:\\Nome_da_pasta\\Imagem_escolhida.png', SINGLE_BLOB) as Image))

----------------

create table Servico(
id_servico int identity primary key,
id_prestservF int foreign key references PrestServ(id_prestserv),
id_usuF int foreign key references Usuario(id_usu),
avaliacao int
)

--insira os dados a seguir:
insert into Servico values (1,1,0)
insert into Servico values (1,2,1)
insert into Servico values (2,1,3)
insert into Servico values (1,4,5)
insert into Servico values (3,2,2)
insert into Servico values (4,3,0)

----------------

create table Usuario(
id_usu int identity primary key,
nome_usu char(30),
senha char(15),
dtNasc varchar(10),
endereco char(30),
numero int,
complemento char(15),
cpf varchar(11),
telefone varchar(11),
email char(30),
)

--insira os dados a seguir:
insert into Usuario values ('Diego Donato Cardena','123','05/12/2002','Rua Teruel Fregoni',120,'Casa 22','11561561561','11953193155','diegodonato@email.com')
insert into Usuario values ('Clara Martines Molin','123','20/10/1995','Rua Teste Teste',20,'','51044522103','11858585821','diegodonato@email.com')
insert into Usuario values ('Fernando Alota Teles','123','08/08/1995','Rua Lagoa Azul',780,'','65484565203','11825251512','fernandoalota@email.com')
insert into Usuario values ('Pedro Henrique Luis','123','10/04/1991','Rua Dentro Janela',231,'Ap 112','5151202301','11558899663','pedrohenrique@email.com')

--=============================================================--

-- Os procedimentos a seguir n�o foram criados por mim. Foram baseados no seguinte v�deo:
---https://www.youtube.com/watch?v=cQQy_IfFddg

-- === EXPLICA��O === --

-- Estes procedimentos adicionam e alteram valores. Ele adicionar� ou alterar� dependendo
--do ID passado. Passado o valor do ID (@id_usu, ou @id_prestserv, ou @id_adm, ou @id_servico), 
--ele adicionar� valores caso o ID seja 0 e atualizar� valores caso o ID seja diferente de 0, usando os outros par�metros passados.
-- Se o ID passado for diferente de zero, ser� atualizada a linha com o ID passado.

--OBS.: O par�metro ID n�o ser� adicionado como id nas tabelas, os ids s�o 
--adicionados automaticamente, pois possuem IDENTITY. 

-------------------------------------------------------------------------------------

CREATE PROC AddOrEditUsuario
@id_usu int,
@nome_usu char(30),
@senha char(15),
@dtNasc varchar(10),
@endereco char(30),
@numero int,
@complemento char(15),
@cpf varchar(11),
@telefone varchar(11),
@email char(30)
AS
	-- Caso o @id_usu for passado como 0, ele insirir� os outros valores passados. 
	IF @id_usu = 0
	-- Note que o par�metro "@id_usu" n�o � usado para inserir, j� que o mesmo serve como um meio 
	--de identificar se ser� adicionado ou atualizado o valor
	insert into Usuario values(@nome_usu, @senha,@dtNasc,@endereco,@numero,@complemento,@cpf,@telefone,@email)
	else

	-- Caso o @id_usu passado for diferente de 0, ele atualizar� os valores passados de acordo com o ID. 
	-- Note que agora o par�metro @id_usu � usado como condi��o, j� que � diferente de zero.
	update Usuario set nome_usu=@nome_usu, senha = @senha, dtNasc = @dtNasc, endereco = @endereco, numero = @numero, 
	complemento = @complemento, cpf = @cpf, telefone = @telefone, email = @email
	where id_usu = @id_usu

-------------------------------------------------------------------------------------

CREATE PROC AddOrEditPrestServ
@id_prestServ int,
@id_plano int,
@nome_prestServ char(30),
@senha char(15),
@dtNasc varchar(10),
@endereco char(30),
@numero int,
@complemento char(15),
@cpf varchar(11),
@telefone varchar(11),
@email char(30),
@tipo_serv varchar(30),
@prestImg_nome varchar(30)
AS
	IF @id_prestServ = 0
	insert into PrestServ values(@id_plano,@nome_prestServ, @senha,@dtNasc,@endereco,@numero,@complemento,@cpf,@telefone,
	@email,@tipo_serv,@prestImg_nome, (SELECT * FROM OPENROWSET(BULK N'D:\\SQL IMAGE UPLOAD\\User.jpg', SINGLE_BLOB) as Image))
	else

	update PrestServ set id_plano = @id_plano, nome_prestserv=@nome_prestServ, senha = @senha, dtNasc = @dtNasc, endereco = @endereco, 
	numero = @numero, complemento = @complemento, cpf = @cpf, telefone = @telefone, email = @email, tipo_serv=@tipo_serv,prestImg_nome = @prestImg_nome
	where id_prestserv = @id_prestServ

--------------------------------------------------------------------------------------

CREATE PROC AddOrEditAdm
@id_adm int,
@nome_adm char(30),
@senha char(15),
@login_adm varchar(30),
@email char(30)
AS
	IF @id_adm = 0
	insert into ADM values(@nome_adm, @login_adm,@senha,@email)
	else
	update ADM set nome=@nome_adm, senha = @senha, login_adm = @login_adm, email = @email
	where id_adm = @id_adm

select * from ADM

----------------------------------------------------------------------------------------

CREATE PROC AddOrEditServico
@id_servico int,
@id_prestservF int,
@nome_prestservF varchar(30),
@id_usuF int,
@nome_usuF varchar(30),
@avaliacao int
AS
	IF @id_servico = 0
	insert into Servico values(@id_prestservF,@id_usuF, @avaliacao)
	else
	update Servico set id_prestservF=@id_prestservF, id_usuF = @id_usuF, avaliacao = @avaliacao
	where id_servico = @id_servico
	



