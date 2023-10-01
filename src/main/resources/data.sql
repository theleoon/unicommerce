
INSERT into categoria (id, nome, status) values (1, "Informática", 1);
INSERT into categoria (id, nome, status) values (2, "Móveis", 1);
INSERT into categoria (id, nome, status) values (3, "Livros", 1);
INSERT into categoria (id, nome, status) values (4, "Celulares", 1);

INSERT into usuario (id, login, senha) values (1, "alura","$2a$10$MDq5ezVRAL1fwG4HHd35UuLoNNaytfsK4whgjnL64.vD5mweS6Fcu");
INSERT into usuario (id, login, senha) values (2, "leonardo","$2a$10$MDq5ezVRAL1fwG4HHd35UuLoNNaytfsK4whgjnL64.vD5mweS6Fcu");
INSERT into usuario (id, login, senha) values (3, "flavio","$2a$10$MDq5ezVRAL1fwG4HHd35UuLoNNaytfsK4whgjnL64.vD5mweS6Fcu");

INSERT into cliente (id, nome, cpf, telefone, rua, numero, complemento, bairro, cidade, estado, usuario_id) 
	values (1, "Alura Online","44444444477","(11)2121-2221", "Rua sem nome", 100, "", "Planalto", "São Paulo", "SP", 1);
INSERT into cliente (id, nome, cpf, telefone, rua, numero, complemento, bairro, cidade, estado, usuario_id) 
	values (2, "Flavio","44444444479","(11)2121-2221", "Rua sem nome", 100, "", "Planalto", "São Paulo", "SP", 3);
INSERT into cliente (id, nome, cpf, telefone, rua, numero, complemento, bairro, cidade, estado, usuario_id) 
	values (3, "Leonardo","44444444478","(11)2121-2221", "Rua sem nome", 100, "", "Planalto", "São Paulo", "SP", 2);

INSERT into produto (id, descricao, nome, preco, quantidade_estoque, categoria_id) values (1, "Notebook Samsung", "Notebook Samsung 500gb", 2350, 10, 1);
INSERT into produto (id, descricao, nome, preco, quantidade_estoque, categoria_id) values (2, "Samsung S15", "S15 Samsung 256gb", 1300, 100, 4);
INSERT into produto (id, descricao, nome, preco, quantidade_estoque, categoria_id) values (3, "iPhone 19", "Apple iPhone 19 256gb", 8900, 100, 4);
INSERT into produto (id, descricao, nome, preco, quantidade_estoque, categoria_id) values (4, "Mesa de jantar 6 lugares", "Mesa de jantar 6 lugares", 3900, 20, 2);
INSERT into produto (id, descricao, nome, preco, quantidade_estoque, categoria_id) values (5, "Clean Code", "Clean Code Nova Edição", 98, 1000, 3);
