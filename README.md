# Easy Tech
Proposta de sistema online para agendamento médico, promovendo acesso facilitado à saúde e aplicando os princípios da Sociedade 5.0 para melhorar a qualidade de vida dos pacientes.
## Integrantes

- MATHEUS MATOS - RM:99792
- KAREN VITORIA JESUS DA SILVA - RM:99468
- JULIANNY ARAUJO PEREIRA - RM:99554
- DIEGO HENRIQUE SANTOS DE OLIVEIRA - RM:550269
- JULIA DE FATIMA QUEIROZ - RM:551130

## Instruções para uso

### Configuração do Spring
- site: https://start.spring.io/
![Configuração Spring](https://github.com/diegohs13/SP2_JAVA/blob/main/configSpring.png)
- application.properties
![Configuração application.properties](https://github.com/diegohs13/SP2_JAVA/blob/main/appProp.png)

### Import insominia
- insomnia v4
- InsomniaSP2.json
- Importar arquivo
![Importar arquivo](https://github.com/diegohs13/SP2_JAVA/blob/main/importInsomnia.png)
![Import completo](https://github.com/diegohs13/SP2_JAVA/blob/main/importCompleto.png)

### Execução
Após a importação do arquivo InsomniaSP2.json e a configuração do application.properties, o usuario pode rodar o Sprint2JavaApplication dentro do projeto java.
![Execução](https://github.com/diegohs13/SP2_JAVA/blob/main/runApp.png)

### Utilização
O usuario pode cadastrar os seguintes dados no sistema utilizando o metodo POST:
- Paciente
- Exame
- Receita
- Unidade
- Consulta
- Agendamento
- Clinica

O usuario pode deletar os seguintes dados no sistema utilizando o metodo DELETE:
- Um paciente pelo cpf
- Um exame pelo id
- Uma receita pelo id
- Uma unidade pelo id
- Uma consulta pelo id
- Um agendamento pelo n_protocolo
- Uma clinica pelo cnpj

O usuario pode visualizar os seguintes dados no sistema utilizando o metodo GET:
- Lista de todos os pacientes e de um paciente específico
- Lista de todos os exames e de um exame específico
- Lista de todas as receitas e de uma receita específica
- Lista de todas as unidades e de uma unidade específica
- Lista de todas as consultas e de uma consulta específica
- Lista de todos os agendamentos e de um agendamento específico
- Lista de todas as clinicas e de uma clinica específica

O usuario pode atualizar os seguintes dados no sistema utilizando o metodo PUT:
- Senha do paciente
- Data de hora da consulta
- Resultado do exame
- Data de hora do agendamento
- Telefone da clinica
- Encaminhamento da receita
- Tipo de exame da unidade

O usuario tambem pode realizar o login de um paciente no sistema com os seguintes dados utilizando o metodo POST:
- cpf
- senha

## Endpoints
PACIENTES
- GET `/pacientes` - Retorna a lista de pacientes cadastrados no sistema.
- POST `/pacientes/cadastrarPaciente` - Cadastra um novo paciente no sistema.
- GET `/pacientes/{cpf}` - Retorna os dados de um paciente específico.
- PUT `/pacientes/{cpf}/atualizarSenha` - Atualiza a senha de um paciente específico.
- DELETE `/pacientes/{cpf}` - Deleta um paciente específico.
- POST `/pacientes/{cpf}/login` - Realiza o login de um paciente no sistema.

EXAMES
- GET `/exames` - Retorna a lista de exames cadastrados no sistema.
- GET `/exames/{id_exame}` - Retorna os dados de um exame específico.
- PUT `/exames/{id_exame}/atualizarResultado` - Atualiza o resultado de um exame específico.
- DELETE `/exames/{id_exame}` - Deleta um exame específico.
- POST `/exames/cadastrarExame` - Cadastra um novo exame no sistema.

RECEITAS
- GET `/receitas` - Retorna a lista de receitas cadastradas no sistema.
- GET `/receitas/{id_receita}` - Retorna os dados de uma receita específica.
- PUT `/receitas/{id_receita}/atualizarEncaminhamento` - Atualiza o encaminhamento de uma receita específica.
- DELETE `/receitas/{id_receita}` - Deleta uma receita específica.
- POST `/receitas/cadastrarReceita` - Cadastra uma nova receita no sistema.

UNIDADES
- GET `/unidades` - Retorna a lista de unidades cadastradas no sistema.
- GET `/unidades/{id_unidade}` - Retorna os dados de uma unidade específica.
- PUT `/unidades/{id_unidade}/atualizarTipoExame` - Atualiza o tipo de exame de uma unidade específica.
- DELETE `/unidades/{id_unidade}` - Deleta uma unidade específica.
- POST `/unidades/cadastrarUnidade` - Cadastra uma nova unidade no sistema.


CONSULTAS
- GET `/consultas` - Retorna a lista de consultas cadastradas no sistema.
- GET `/consultas/{id_unidade}` - Retorna os dados de uma consulta específica.
- PUT `/consultas/{id_unidade}/atualizarDataHoraConsulta` - Atualiza a data e hora de uma consulta específica.
- DELETE `/consultas/{id_unidade}` - Deleta uma consulta específica.
- POST `/consultas/cadastrarConsulta` - Cadastra uma nova consulta no sistema.


AGENDAMENTOS
- GET `/agendamentos` - Retorna a lista de agendamentos cadastrados no sistema.
- GET `/agendamentos/{n_protocolo}` - Retorna os dados de um agendamento específico.
- PUT `/agendamentos/{n_protocolo}/atualizarDataHoraAgendamento` - Atualiza a data e hora de um agendamento específico.
- DELETE `/agendamentos/{n_protocolo}` - Deleta um agendamento específico.
- POST `/agendamentos/cadastrarAgendamento` - Cadastra um novo agendamento no sistema.


CLINICAS
- GET `/clinicas` - Retorna a lista de clinicas cadastradas no sistema.
- GET `/clinicas/{cnpj}` - Retorna os dados de uma clinica específica.
- PUT `/clinicas/{cnpj}/atualizarTelefone` - Atualiza o telefone de uma clinica específica.
- DELETE `/clinicas/{cnpj}` - Deleta uma clinica específica.
- POST `/clinicas/cadastrarClinica` - Cadastra uma nova clinica no sistema.

## Imagens
![Diagrama de relacionamentos](https://github.com/diegohs13/SP1_JAVA/blob/main/Diagrama1.png)
- _**Entidades e Atributos**_<br>
  <br>

- **Paciente**
- cpf (chave primária)
- nome_completo
- data_nasc
- end_paciente
- tel_paciente
- email_paciente<br>
  <br>

- **Clínica**
- cnpj (chave primária)
- nome_clinica
- cel_clinica
- conveniada<br>
  <br>

- **Consulta**
- id_consulta (chave primária)
- data_hora_consulta
- idClinica (chave estrangeira)
- idPaciente (chave estrangeira)
- idAgendamento (chave estrangeira)<br>
  <br>

- **Exames**
- idExame (chave primária)
- idConsulta (chave estrangeira)
- tipo_exame
- resultado<br>
  <br>

- **Agendamento**
- n_protocolo (chave primária)
- idPaciente (chave estrangeira)
- dataHora_agendamento
- clinica_agendamento<br>
  <br>
  <br>

- **_Relacionamentos_**<br>
  <br>

- **Paciente para Consulta**
- Um paciente pode ter várias consultas.
- Uma consulta é específica de um paciente.<br>
  <br>

- **Paciente para Agendamento**
- Um paciente pode ter vários agendamentos.
- Um agendamento é específico de um paciente.<br>
  <br>

- **Consulta para Exames**
- Uma consulta pode ter vários exames associados.
- Um exame é específico de uma consulta.<br>
  <br>

- **Clínica para Consulta**
- Uma clínica pode hospedar várias consultas.
- Uma consulta acontece em uma clínica.<br>

![Diagrama de clases](https://github.com/diegohs13/SP1_JAVA/blob/main/Diagrama2.png)
- Paciente e Clinica estão associados a Agendamento(classe pai),  Consulta e Exame são heranças de Agendamento.<br>


## Nome da Aplicação
Health Tech

## Nome completo e breve apresentação dos integrantes do Grupo
- Diego Henrique Santos de Oliveira:
  Atividade: ADVANCED BUSINESS DEVELOPMENT WITH .NET
  Responsabilidades:
  •	Desenvolver a Proposta de Solução, detalhando como a solução do projeto gera valor para o público-alvo e os benefícios oferecidos.
  •	Realizar a Análise da Concorrência, mapeando os principais concorrentes diretos e indiretos para entender o cenário competitivo.
  •	Especificar os Modelos de Receita, detalhando como o projeto gerará receita e apresentando as diversas fontes de renda previstas.

- Júlia de Fatima Queiroz:
  Atividade: MASTERING RELATIONAL AND NON-RELATIONAL DATABASE
  Responsabilidades:
  •	Desenvolver os Diagramas no Oracle Data Modeler, cumprindo a notação DER (Logical Model) e MER (Physical Model), utilizando a notação de Barker para o DER (Logical Model) e garantindo que esteja na 3ª Forma Normal (3FN).
  •	Gerar o Modelo Físico e criar os objetos/esquema no banco de dados.
  •	Preencher no mínimo 5 registros para cada tabela, de acordo com a especificação do projeto.
  •	Criar dois blocos anônimos para mostrar os dados inseridos, com pelo menos 3 consultas de junções (Joins) utilizando agrupamento (group by) e ordenação (order by).
  •	Preparar o entregável, que consiste em um arquivo zipado contendo o PDF do Projeto de Banco de Dados Relacional e um arquivo .sql com os scripts separados por tabela, além do PDF do modelo lógico e físico.

- Julianny Araujo Pereira:
  Atividade: MOBILE APP DEVELOPMENT
  Responsabilidades:
  •	Desenvolvimento do Protótipo Não Funcional de uma Solução Mobile
  •	Criar um wireframe de uma solução mobile com no mínimo 5 telas.
  •	Acompanhar cada tela com explicações detalhadas, incluindo descrições dos elementos e funcionalidades presentes em cada tela.
  •	Incluir cenários possíveis de sucesso e erro, detalhando como a solução se comportará em diferentes situações.
  •	Preparar o entregável, que consiste em um documento do Word com imagens e explicações, contendo o nome completo e RM de todos os integrantes do grupo na capa.

- Karen Vitória Jesus da Silva:
  Atividade: DEVOPS TOOLS E CLOUD COMPUTING
  Responsabilidades:
  •	Justificar a Contribuição da Técnica de Virtualização para o Projeto
  •	Justificar como a técnica de Virtualização pode contribuir na entrega do projeto identificado pelo grupo.
  •	Organizar e estruturar o material gerado de forma coerente e organizada.
  •	Demonstrar os conhecimentos adquiridos em aula e apresentar um texto aderente à solução proposta pelo grupo.
  •	Incluir exemplos e aderência para a solução apresentada pelo grupo.
  •	Adicionar imagens explicativas para ilustrar e melhorar o entendimento da dissertação e da solução apresentada.
  •	Preparar o entregável em formato PDF.

- Matheus Matos Pereira:
  Atividade: DISRUPTIVE ARCHITECTURES: IOT, IOB &
  GENERATIVE IA
  Responsabilidades:
  •	Criar um vídeo pitch com duração máxima de 3 minutos, apresentando a ideia do projeto de forma macro.
  •	Apresentar o tema escolhido pelo grupo.
  •	Explicar o problema identificado.
  •	Apresentar as alternativas de solução consideradas.
  •	Descrever os frameworks/bibliotecas Python que serão utilizados, sendo específico quanto aos motivos de escolha.
  •	Descrever de que forma os conceitos de Machine Learning / IA serão aplicados no desenvolvimento do projeto, sendo específico neste requisito.

- Todos os membros:
  Atividade: COMPLIANCE & QUALITY ASSURANCE
  •	Desenvolvimento da Declaração de Visão e Escopo do Projeto em Formato PITCH:
  •	Todos os membros devem colaborar para desenvolver a declaração de visão e escopo do projeto em formato PITCH, contendo:
  •	Descrição do problema a resolver
  •	Descrição dos objetivos da solução idealizada
  •	Definição do público-alvo que comprará/usará a solução
  •	Estudo de produtos semelhantes já existentes no mercado
  •	Avaliação do potencial de mercado

- Todos os membros:
  Atividade: JAVA ADVANCED

•	Desenvolvimento da Solução Java com Spring Boot:
•	Apresentar o cronograma de desenvolvimento e respeitar os prazos.
•	Apresentar imagens explicativas da arquitetura, definição das classes de domínio da aplicação e o respectivo Diagrama de Classes de Entidade.
•	Implementar as classes de Entidade necessárias para solução do problema, com atenção ao correto encapsulamento, à tipagem dos atributos e ao Mapeamento Objeto Relacional com JPA e Hibernate.
•	Garantir que a aplicação respeite os conceitos fundamentais do REST (RESTful) e que a API esteja de acordo com o modelo de maturidade nível 1.
•	Demonstrar a Gestão de Configuração dos Artefatos de Software, disponibilizando todos os artefatos produzidos no Github.
•	Enviar o link para o projeto público compartilhado no github contendo toda a documentação, código-fonte, arquivo README.md com informações pertinentes, diagramas, vídeo apresentando a Proposta Tecnológica, e a listagem de todos os endpoints (Documentação da API).
•	Demonstrar preocupação em testar a aplicação e provar com documentos, disponibilizando arquivos para que os professores possam realizar testes dos endpoints e garantir a perfeita persistência e recuperação dos dados.

## Link Pitch
https://www.youtube.com/watch?v=EkemseY8PlA




