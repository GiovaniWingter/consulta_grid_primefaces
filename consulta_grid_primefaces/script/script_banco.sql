USE [JavaJSF]
GO

SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[funcionario](
	[idFuncionario] [int] IDENTITY(1,1) NOT NULL,
	[nome_funcionario] [varchar](70) NULL,
	[sexo] [char](1) NULL,
	[cpf_funcionario] [varchar](14) NULL,
	[rg_funcionario] [varchar](13) NULL,
	[email_funcionario] [varchar](70) NULL,
	[login_funcionario] [varchar](30) NULL,
	[senha_funcionario] [varchar](64) NULL,
 CONSTRAINT [PK_funcionario] PRIMARY KEY CLUSTERED 
(
	[idFuncionario] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO


INSERT INTO [dbo].[funcionario]
           ([nome_funcionario]
           ,[sexo]
           ,[cpf_funcionario]
           ,[rg_funcionario]
           ,[email_funcionario]
           ,[login_funcionario]
           ,[senha_funcionario])
     VALUES
           ('Joca'
           ,'M'
           ,'12345678901'
           ,'121231234'
           ,'joca@gmail.com'
           ,'joca'
           ,'A6xnQhbz4Vx2HuGl4lXwZ5U2I8iziLRFnhP5eNfIRvQ=')
					
GO

SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[hq](
	[idhq] [int] IDENTITY(1,1) NOT NULL,
	[nome_hq] [varchar](150) NULL,
	[descr_hq] [varchar](200) NULL,
	[url_imagem] [varchar](120) NULL,
 CONSTRAINT [PK_jogo] PRIMARY KEY CLUSTERED 
(
	[idhq] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO


SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[preco_hq](
	[idpreco_hq] [int] IDENTITY(1,1) NOT NULL,
	[hq_idhq] [int] NULL,
	[dt_inicio] [date] NULL,
	[dt_fim] [date] NULL,
	[preco] [float] NULL,
 CONSTRAINT [PK_preco_hq] PRIMARY KEY CLUSTERED 
(
	[idpreco_hq] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

ALTER TABLE [dbo].[preco_hq]  WITH CHECK ADD  CONSTRAINT [FK_preco_hq_hq] FOREIGN KEY([idpreco_hq])
REFERENCES [dbo].[hq] ([idhq])
GO

ALTER TABLE [dbo].[preco_hq] CHECK CONSTRAINT [FK_preco_hq_hq]
GO



SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[contato](
	[idcontato] [int] IDENTITY(1,1) NOT NULL,
	[nome] [varchar](70) NULL,
	[email] [varchar](40) NULL,
	[telefone] [varchar](15) NULL
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO