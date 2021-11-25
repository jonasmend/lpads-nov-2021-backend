INSERT INTO Cliente(id, nome, nascimento, cpf, convenio, telefone, email) VALUES(1, 'Jonas', '2001-12-13', '460.126.618-19', 'S', '99000-0000', 'jonas_mendonca@email.com');
INSERT INTO Cliente(id, nome, nascimento, cpf, convenio, telefone, email) VALUES(2, 'Denis', '1993-07-05', '000.000.000-00', 'S', '99000-1111', 'denis_mendonca@email.com');
INSERT INTO Cliente(id, nome, nascimento, cpf, convenio, telefone, email) VALUES(3, 'Maria', '1996-08-02', '111.111.111-11', 'N', '99000-2222', 'maria_silva@email.com');

INSERT INTO Especie(id, descricao) VALUES(1, 'Pastor Alemão');
INSERT INTO Especie(id, descricao) VALUES(2, 'Pastor Belga');
INSERT INTO Especie(id, descricao) VALUES(3, 'PitBull');
INSERT INTO Especie(id, descricao) VALUES(4, 'Pincher');
INSERT INTO Especie(id, descricao) VALUES(5, 'Boxer');

INSERT INTO Animal(id, cliente_id, especie_id, nome, nascimento) VALUES(1, 1, 1, 'Rex', '2019-09-09');
INSERT INTO Animal(id, cliente_id, especie_id, nome, nascimento) VALUES(2, 3, 5, 'Bolt', '2018-04-25');
INSERT INTO Animal(id, cliente_id, especie_id, nome, nascimento) VALUES(3, 2, 4, 'Amora', '2020-01-19');

INSERT INTO Procedimento(id, valor, descricao, estoque) VALUES(1, 10.99, 'Curativo', 50);
INSERT INTO Procedimento(id, valor, descricao, estoque) VALUES(2, 5.99, 'Pomada', 20);
INSERT INTO Procedimento(id, valor, descricao, estoque) VALUES(3, 15, 'Anestesia', 30);
INSERT INTO Procedimento(id, valor, descricao, estoque) VALUES(4, 8.99, 'Antibiótico', 10);
INSERT INTO Procedimento(id, valor, descricao, estoque) VALUES(5, 19.99, 'Desinfecção', 15);

INSERT INTO Ficha_Atendimento(id, animal_id, data_atendimento, finalizado, total) VALUES(1, 1, '2020-06-21', 'N', 0);
INSERT INTO Ficha_Atendimento(id, animal_id, data_atendimento, finalizado, total) VALUES(2, 3, '2020-04-08', 'N', 0);
INSERT INTO Ficha_Atendimento(id, animal_id, data_atendimento, finalizado, total) VALUES(3, 2, '2020-05-15', 'S', 0);

INSERT INTO Procedimento_Realizado(id, ficha_atendimento, procedimento, quantidade, total) VALUES(1, 1, 1, 0, 0);
INSERT INTO Procedimento_Realizado(id, ficha_atendimento, procedimento, quantidade, total) VALUES(2, 1, 2, 0, 0);
INSERT INTO Procedimento_Realizado(id, ficha_atendimento, procedimento, quantidade, total) VALUES(3, 2, 2, 0, 0);
INSERT INTO Procedimento_Realizado(id, ficha_atendimento, procedimento, quantidade, total) VALUES(4, 3, 1, 0, 0);
INSERT INTO Procedimento_Realizado(id, ficha_atendimento, procedimento, quantidade, total) VALUES(5, 3, 2, 0, 0);