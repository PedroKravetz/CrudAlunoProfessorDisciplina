
insert into pessoa(nome, email, data_nascimento, sexo, cpf, rg)
values
    ('Maria Silva', 'maria.silva@example.com', '1990-05-10', 'F', '123.456.789-00', '12.345.678-9'),
    ('João Santos', 'joao.santos@example.com', '1985-07-15', 'M', '987.654.321-00', '98.765.432-1'),
    ('Ana Oliveira', 'ana.oliveira@example.com', '1992-03-20', 'F', '555.666.777-00', '55.666.777-0'),
    ('Carlos Ferreira', 'carlos.ferreira@example.com', '1988-09-05', 'M', '111.222.333-00', '11.222.333-0'),
    ('Larissa Lima', 'larissa.lima@example.com', '1995-02-14', 'F', '999.888.777-00', '99.888.777-0'),
    ('Rodrigo Almeida', 'rodrigo.almeida@example.com', '1991-06-30', 'M', '444.555.666-00', '44.555.666-0'),
    ('Camila Souza', 'camila.souza@example.com', '1994-12-12', 'F', '777.888.999-00', '77.888.999-0'),
    ('Renato Santos', 'renato.santos@example.com', '1993-08-18', 'M', '222.333.444-00', '22.333.444-0'),
    ('Juliana Oliveira', 'juliana.oliveira@example.com', '1997-04-25', 'F', '666.777.888-00', '66.777.888-0'),
    ('Carolina Santos', 'carolina.santos@example.com', '1987-09-15', 'F', '111.222.333-01', '11.222.333-1'),
    ('Ricardo Oliveira', 'ricardo.oliveira@example.com', '1984-12-28', 'M', '222.333.444-01', '22.333.444-1'),
    ('Fernanda Silva', 'fernanda.silva@example.com', '1990-06-05', 'F', '333.444.555-01', '33.444.555-1'),
    ('Gustavo Almeida', 'gustavo.almeida@example.com', '1989-02-19', 'M', '444.555.666-01', '44.555.666-1'),
    ('Patrícia Souza', 'patricia.souza@example.com', '1986-07-10', 'F', '555.666.777-01', '55.666.777-1');

insert into aluno(ra, periodo, ano, cpf)
values
    (1002, '3', '2021', '123.456.789-00'),
    (1003, '2', '2022', '987.654.321-00'),
    (1004, '1', '2023', '555.666.777-00'),
    (1005, '4', '2019', '111.222.333-00'),
    (1006, '6', '2018', '999.888.777-00'),
    (1007, '3', '2021', '444.555.666-00'),
    (1008, '2', '2022', '777.888.999-00'),
    (1009, '5', '2020', '222.333.444-00'),
    (1010, '1', '2023', '666.777.888-00');

insert into endereco(cep, rua, bairro, numero, complemento, cpf)
values
    ('12345-678', 'Rua das Flores', 'Centro', 100, 'Apartamento 101', '123.456.789-00'),
    ('98765-432', 'Avenida Brasil', 'Jardim América', 500, 'Casa', '987.654.321-00'),
    ('55555-666', 'Rua dos Pinheiros', 'Vila Nova', 150, 'Casa', '555.666.777-00'),
    ('11111-222', 'Avenida Paulista', 'Bela Vista', 300, 'Apartamento 501', '111.222.333-00'),
    ('99999-888', 'Rua da Praia', 'Beira Mar', 50, 'Casa', '999.888.777-00'),
    ('44444-555', 'Rua dos Coqueiros', 'Parque das Palmeiras', 250, 'Casa', '444.555.666-00'),
    ('77777-888', 'Avenida das Estrelas', 'Céu Azul', 400, 'Apartamento 201', '777.888.999-00'),
    ('22222-333', 'Rua das Montanhas', 'Serra Verde', 120, 'Casa', '222.333.444-00'),
    ('66666-777', 'Avenida dos Girassóis', 'Jardim das Flores', 80, 'Casa', '666.777.888-00'),
    ('21445-678', 'Rua dos Professores', 'Cidade Universitária', 50, 'Apartamento 201', '111.222.333-01'),
    ('12321-432', 'Avenida dos Estudantes', 'Vila Acadêmica', 300, 'Casa', '222.333.444-01'),
    ('21312-666', 'Rua das Pesquisas', 'Bairro da Ciência', 150, 'Casa', '333.444.555-01'),
    ('21322-222', 'Avenida do Saber', 'Cidade do Conhecimento', 200, 'Apartamento 501', '444.555.666-01'),
    ('12334-888', 'Rua das Palestras', 'Centro Educacional', 80, 'Casa', '555.666.777-01');
    
insert into professor(rp, formacao, salario, departamento, cpf)
values
    (2004, 'Mestre em Economia pela Universidade Federal', 9800, 'Economia', '111.222.333-01'),
    (2005, 'Doutor em Engenharia Civil pela Universidade XYZ', 11500, 'Engenharia Civil', '222.333.444-01'),
    (2006, 'Mestre em Administração de Empresas pela Universidade ABC', 9000, 'Administração', '333.444.555-01'),
    (2007, 'Doutor em Psicologia pela Universidade XYZ', 10500, 'Psicologia', '444.555.666-01'),
    (2008, 'Mestre em Direito pela Universidade Federal', 9500, 'Direito', '555.666.777-01');

    
insert into disciplina(nome, codigo, bloco, sala, cargaHoraria, ementa, bibliografia)
values
    ('Programação I', '10001', 'B', 201, 120, 'Introdução à programação', 'Livro de programação em C'),
    ('Matemática Discreta', '10002', 'C', 305, 150, 'Fundamentos matemáticos para computação', 'Livro de Matemática Discreta'),
    ('Redes de Computadores', '10003', 'A', 415, 180, 'Fundamentos de redes de computadores', 'Livro de Redes de Computadores'),
    ('Engenharia de Software', '10004', 'D', 101, 200, 'Princípios de engenharia de software', 'Livro de Engenharia de Software'),
    ('Sistemas Operacionais', '10005', 'E', 510, 160, 'Fundamentos de sistemas operacionais', 'Livro de Sistemas Operacionais');