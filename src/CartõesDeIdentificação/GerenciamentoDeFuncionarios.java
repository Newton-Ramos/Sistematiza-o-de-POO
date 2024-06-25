package CartõesDeIdentificação;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GerenciamentoDeFuncionarios {
    private List<Funcionario> funcionarios;
    private Random random;
    private Scanner scanner;

    public GerenciamentoDeFuncionarios() {
        this.funcionarios = new ArrayList<>();
        this.random = new Random();
        this.scanner = new Scanner(System.in);
    }

    public void adicionarFuncionario() {
        Funcionario novoFuncionario = new Funcionario();

        novoFuncionario.setNomeCompleto(validarEntrada("Nome Completo", true));
        novoFuncionario.setCPF(validarCPF());
        novoFuncionario.setIdade(validarIdade("Idade"));
        novoFuncionario.setPeso(validarPeso("Peso (em kg)"));
        novoFuncionario.setAltura(validarAltura("Altura (em metros)"));
        novoFuncionario.setDoencasPreexistentes(validarDoencasPreexistentes());
        novoFuncionario.setTelefoneContato(validarEntrada("Telefone de Contato", false));
        novoFuncionario.setEmailContato(validarEmail());
        novoFuncionario.setContatoEmergencia(validarEntrada("Contato de Emergência", false));

        novoFuncionario.setCodigo(gerarCodigoFuncionario());
        funcionarios.add(novoFuncionario);

        System.out.println("Funcionário adicionado com sucesso!");
        System.out.println("Código gerado: " + formatarCodigo(novoFuncionario.getCodigo()));
    }

    public void buscarFuncionarioPorCodigo() {
        long codigo = validarCodigoFuncionario();
        Funcionario funcionarioEncontrado = null;

        for (Funcionario f : funcionarios) {
            if (f.getCodigo() == codigo) {
                funcionarioEncontrado = f;
                break;
            }
        }

        if (funcionarioEncontrado != null) {
            System.out.println("Funcionário encontrado:");
            System.out.println(funcionarioEncontrado);
        } else {
            System.out.println("Nenhum funcionário encontrado com o código informado.");
        }
    }

    public void buscarFuncionarioPorNome() {
        String nomeBusca = validarEntrada("Digite parte ou todo o nome do funcionário para buscar", true);
        List<Funcionario> funcionariosEncontrados = new ArrayList<>();

        for (Funcionario f : funcionarios) {
            if (f.getNomeCompleto().toLowerCase().contains(nomeBusca.toLowerCase())) {
                funcionariosEncontrados.add(f);
            }
        }

        if (!funcionariosEncontrados.isEmpty()) {
            System.out.println("Funcionários encontrados:");
            for (Funcionario f : funcionariosEncontrados) {
                System.out.println(f);
            }
        } else {
            System.out.println("Nenhum funcionário encontrado com o nome informado.");
        }
    }

    public void exibirTodosFuncionarios() {
        if (funcionarios.isEmpty()) {
            System.out.println("Não há funcionários cadastrados.");
        } else {
            System.out.println("Lista de funcionários:");
            for (Funcionario f : funcionarios) {
                System.out.println(f);
            }
        }
    }

    private String validarEntrada(String mensagem, boolean requerTexto) {
        String entrada;
        do {
            System.out.print(mensagem + ": ");
            entrada = scanner.nextLine().trim();
            if (requerTexto && (entrada.isEmpty() || entrada.matches(".*\\d.*"))) {
                System.out.println("Entrada inválida. Por favor, insira corretamente.");
            } else if (!requerTexto && (entrada.isEmpty() || entrada.startsWith("-") || !entrada.matches("\\d+"))) {
                System.out.println("Entrada inválida. Por favor, insira corretamente.");
            }
        } while (entrada.isEmpty() || (requerTexto && entrada.matches(".*\\d.*")) || (!requerTexto && (entrada.isEmpty() || entrada.startsWith("-") || !entrada.matches("\\d+"))));
        return entrada;
    }

    private String validarCPF() {
        String cpf;
        do {
            cpf = validarEntrada("CPF", false);
            if (existeFuncionario(cpf)) {
                System.out.println("Já existe um funcionário cadastrado com esse CPF.");
            }
        } while (existeFuncionario(cpf));
        return cpf;
    }

    private int validarIdade(String mensagem) {
        int idade;
        do {
            idade = validarNumeroInteiro(mensagem);
            if (idade <= 0) {
                System.out.println("Idade inválida. Insira uma idade válida.");
            }
        } while (idade <= 0);
        return idade;
    }

    private double validarPeso(String mensagem) {
        double peso;
        do {
            peso = validarNumeroReal(mensagem);
            if (peso <= 0) {
                System.out.println("Peso inválido. Insira um peso válido.");
            }
        } while (peso <= 0);
        return peso;
    }

    private double validarAltura(String mensagem) {
        double altura;
        do {
            altura = validarNumeroReal(mensagem);
            if (altura <= 0) {
                System.out.println("Altura inválida. Insira uma altura válida.");
            }
        } while (altura <= 0);
        return altura;
    }

    private int validarNumeroInteiro(String mensagem) {
        int numero = 0;
        boolean valido = false;
        do {
            System.out.print(mensagem + ": ");
            try {
                numero = Integer.parseInt(scanner.nextLine().trim());
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Insira um valor numérico inteiro.");
            }
        } while (!valido);
        return numero;
    }

    private double validarNumeroReal(String mensagem) {
        double numero = 0;
        boolean valido = false;
        do {
            System.out.print(mensagem + ": ");
            try {
                numero = Double.parseDouble(scanner.nextLine().trim());
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Insira um valor numérico real.");
            }
        } while (!valido);
        return numero;
    }

    private String validarDoencasPreexistentes() {
        String resposta;
        do {
            System.out.print("Doença Preexistente (S/N): ");
            resposta = scanner.nextLine().trim().toUpperCase();
            if ("S".equals(resposta)) {
                System.out.print("Qual doença preexistente? ");
                return scanner.nextLine().trim();
            } else if (!"N".equals(resposta)) {
                System.out.println("Resposta inválida. Digite 'S' para sim ou 'N' para não.");
            }
        } while (!"S".equals(resposta) && !"N".equals(resposta));
        return "";
    }

    private String validarEmail() {
        String email;
        do {
            System.out.print("E-mail: ");
            email = scanner.nextLine().trim();
            if (email.isEmpty() || !email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
                System.out.println("E-mail inválido. Insira um e-mail válido.");
            }
        } while (email.isEmpty() || !email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}"));
        return email;
    }

    private long gerarCodigoFuncionario() {
        long codigo;
        do {
            codigo = random.nextInt(900000000) + 1000000000; // Números aleatórios de 1000000000 a 1999999999
        } while (existeCodigo(codigo));
        return codigo;
    }

    private long validarCodigoFuncionario() {
        long codigo;
        do {
            codigo = validarNumeroInteiro("Digite o código do funcionário");
            if (!existeCodigo(codigo)) {
                System.out.println("Funcionário com o código informado não encontrado.");
            }
        } while (!existeCodigo(codigo));
        return codigo;
    }

    private boolean existeFuncionario(String cpf) {
        return funcionarios.stream().anyMatch(f -> f.getCPF().equals(cpf));
    }

    private boolean existeCodigo(long codigo) {
        return funcionarios.stream().anyMatch(f -> f.getCodigo() == codigo);
    }

    private String formatarCodigo(long codigo) {
        return String.format("%010d", codigo);
    }

    public void exibirMenu() {
        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Adicionar funcionário");
            System.out.println("2. Buscar funcionário pelo código");
            System.out.println("3. Buscar funcionário pelo nome");
            System.out.println("4. Exibir todos os funcionários");
            System.out.println("5. Sair");

            int escolha = validarNumeroInteiro("Opção");

            switch (escolha) {
                case 1:
                    adicionarFuncionario();
                    break;
                case 2:
                    buscarFuncionarioPorCodigo();
                    break;
                case 3:
                    buscarFuncionarioPorNome();
                    break;
                case 4:
                    exibirTodosFuncionarios();
                    break;
                case 5:
                    
                    System.out.println("Sistema encerrado.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        }
    }

    public static void main(String[] args) {
        GerenciamentoDeFuncionarios gerenciamento = new GerenciamentoDeFuncionarios();
        gerenciamento.exibirMenu();
    }
}