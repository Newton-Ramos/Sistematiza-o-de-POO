package CartõesDeIdentificação;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciamentoDeFuncionarios {
    private List<Pessoa> pessoas;

    public GerenciamentoDeFuncionarios() {
        this.pessoas = new ArrayList<>();
    }

    public void adicionarPessoa(Funcionario funcionario) {
        // Verificar se o CPF já está cadastrado
        if (existePessoaComCPF(funcionario.getCPF())) {
            System.out.println("Este CPF já foi cadastrado, tente novamente por favor!");
            return;
        }

        pessoas.add(funcionario);
    }

    private boolean existePessoaComCPF(String CPF) {
        for (Pessoa p : pessoas) {
            if (p.getCPF().equals(CPF)) {
                return true;
            }
        }
        return false;
    }

    public Funcionario buscarFuncionarioPorId(long codigo) {
        for (Pessoa p : pessoas) {
            if (p instanceof Funcionario && ((Funcionario) p).getCodigo() == codigo) {
                return (Funcionario) p;
            }
        }
        return null;
    }

    public List<Pessoa> buscarPessoaPorNome(String nome) {
        List<Pessoa> resultados = new ArrayList<>();
        for (Pessoa p : pessoas) {
            if (p.getNomeCompleto().toLowerCase().contains(nome.toLowerCase())) {
                resultados.add(p);
            }
        }
        return resultados;
    }

    public void exibirTodosFuncionarios() {
        for (Pessoa p : pessoas) {
            if (p instanceof Funcionario) {
                System.out.println(p);
            }
        }
    }

    public static void main(String[] args) {
        GerenciamentoDeFuncionarios gerenciamento = new GerenciamentoDeFuncionarios();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Adicionar funcionário");
            System.out.println("2. Buscar funcionário por identificador");
            System.out.println("3. Buscar funcionário por nome");
            System.out.println("4. Exibir todos os funcionários");
            System.out.println("5. Sair");

            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            if (escolha == 1) {
                System.out.print("Nome Completo: ");
                String nomeCompleto = scanner.nextLine();

                System.out.print("CPF: ");
                String CPF = scanner.nextLine();

                // Verificar se o CPF já está cadastrado
                if (gerenciamento.existePessoaComCPF(CPF)) {
                    System.out.println("Este CPF já foi cadastrado, tente novamente por favor!");
                    continue;
                }

                System.out.print("Idade: ");
                int idade = scanner.nextInt();
                scanner.nextLine(); // Consumir a nova linha

                System.out.print("Peso (em kg): ");
                double peso = scanner.nextDouble();
                scanner.nextLine(); // Consumir a nova linha

                System.out.print("Altura (em metros): ");
                double altura = scanner.nextDouble();
                scanner.nextLine(); // Consumir a nova linha

                System.out.print("Doença Preexistente: ");
                String doencasPreexistentes = scanner.nextLine();

                System.out.print("Telefone de Contato: ");
                String telefoneContato = scanner.nextLine();

                System.out.print("E-mail de Contato: ");
                String emailContato = scanner.nextLine();

                System.out.print("Contato de Emergência: ");
                String contatoEmergencia = scanner.nextLine();

                boolean hasDoencasPreexistentes = !doencasPreexistentes.isEmpty();

                Funcionario funcionario = new Funcionario(nomeCompleto, CPF, idade, peso, altura, telefoneContato, emailContato, contatoEmergencia, hasDoencasPreexistentes, doencasPreexistentes);
                gerenciamento.adicionarPessoa(funcionario);
                System.out.println("Funcionário adicionado com sucesso!");
                System.out.println("Código gerado: " + funcionario.getCodigo());

            } else if (escolha == 2) {
                System.out.print("Código do Funcionário: ");
                long codigo = scanner.nextLong();
                scanner.nextLine(); // Consumir a nova linha

                Funcionario funcionario = gerenciamento.buscarFuncionarioPorId(codigo);
                if (funcionario != null) {
                    System.out.println("Dados do Funcionário:");
                    System.out.println(funcionario);
                } else {
                    System.out.println("Funcionário não encontrado.");
                }

            } else if (escolha == 3) {
                System.out.print("Nome do Funcionário: ");
                String nome = scanner.nextLine().trim();

                List<Pessoa> funcionariosEncontrados = gerenciamento.buscarPessoaPorNome(nome);
                if (!funcionariosEncontrados.isEmpty()) {
                    System.out.println("Funcionários encontrados:");
                    for (Pessoa p : funcionariosEncontrados) {
                        System.out.println(p);
                    }
                } else {
                    System.out.println("Nenhum funcionário encontrado com esse nome.");
                }

            } else if (escolha == 4) {
                gerenciamento.exibirTodosFuncionarios();

            } else if (escolha == 5) {
                System.out.println("Operação finalizada!");
                break;

            } else {
                System.out.println("Opção inválida, tente novamente.");
            }
        }

        scanner.close();
    }
}
