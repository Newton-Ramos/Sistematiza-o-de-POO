PROJETO CARTÃO DE IDENTIFICAÇÃO DOS FUNCIONÁRIOS - EMPRESA MGS
=============================

# GERENCIAMENTO DE FUNCIONÁRIOS
=============================

Este projeto em Java oferece uma aplicação para gerenciar informações de funcionários, permitindo adicionar novos funcionários, buscar por código ou nome, listar todos os funcionários cadastrados, entre outras funcionalidades básicas de gerenciamento.

## FUNCIONALIDADES
=============================

- Adicionar um funcionário com informações detalhadas como nome completo, CPF, idade, peso, altura, telefone, e-mail, contato de emergência, e doenças preexistentes.
- Buscar funcionário por código único.
- Buscar funcionário por nome, retornando todos os funcionários que correspondem à busca.
- Listar todos os funcionários cadastrados.

## ESTRUTURA DO PROJETO
=============================

- **Pessoa**: Classe abstrata que define atributos básicos como nome completo, CPF, idade, peso, altura, telefone e e-mail de contato.
- **Funcionario**: Classe que herda de Pessoa e adiciona informações específicas de funcionários como código único e doenças preexistentes.
- **GerenciamentoDeFuncionarios**: Classe principal que controla uma lista de funcionários, oferecendo métodos para adicionar, buscar e listar funcionários. Também possui métodos para validação de entrada de dados e interação com o usuário através de um menu.

## COMO EXECUTAR
=============================

### PRÉ-REQUISITOS
-----------------------------
- JDK (Java Development Kit) 8 ou superior instalado.
- Uma IDE Java como Eclipse, IntelliJ IDEA, ou qualquer outra IDE de sua preferência.

### EXECUÇÃO
-----------------------------
1. Clone o repositório do projeto: 
```bash
    git clone https://github.com/Newton-Ramos/Sistematizacao-de-POO
    ```

2. Abra o projeto na sua IDE.

3. Compile e execute a classe `GerenciamentoDeFuncionarios.java`.

4. O programa exibirá um menu no console com opções para interagir com o sistema de gerenciamento de funcionários.

### EXEMPLO DE USO
=============================
1. Ao iniciar o programa, você verá um menu com opções numeradas:

	Escolha uma opção:

	1. Adicionar funcionário
	2. Buscar funcionário pelo código
	3. Buscar funcionário pelo nome
	4. Exibir todos os funcionários
	5. Sair

2. Para adicionar um funcionário, escolha a opção 1 e siga as instruções para preencher os dados do funcionário.

3. Para buscar um funcionário pelo código, escolha a opção 2 e digite o código único do funcionário.

4. Para buscar um funcionário pelo nome, escolha a opção 3 e digite parte ou todo o nome do funcionário.

5. Para listar todos os funcionários cadastrados, escolha a opção 4.

6. Para encerrar o programa, escolha a opção 5.

## LINKS IMPORTANTES
=============================
- Repositório no GitHub: (https://github.com/Newton-Ramos/Sistematizacao-de-POO.git)

- Vídeo de Apresentação: (https://drive.google.com/file/d/198PvIisv6dR9Ll-__eHSjj94VVddh6dK/view?usp=drive_link)

- Google Drive com o Trabalho Completo: https://drive.google.com/drive/folders/1vBBM0f92VYSuozfp2iVRgxMRFwGkuPZo
=============================
## LICENÇA
=============================
Este projeto está licenciado sob a Licença MIT. Consulte o arquivo LICENSE para mais detalhes.
=============================
Desenvolvido por Newton Ramos Chaves Junior - RA: 72400904
Disciplina: Programação Orientada a Objetos – Turma: B
=============================
