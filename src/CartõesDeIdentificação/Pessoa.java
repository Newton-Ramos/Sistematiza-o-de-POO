package CartõesDeIdentificação;

public abstract class Pessoa {
    private String nomeCompleto;
    private String CPF;
    private int idade;
    private double peso;
    private double altura;
    private String telefoneContato;
    private String emailContato;

    public Pessoa(String nomeCompleto, String CPF, int idade, double peso, double altura, String telefoneContato, String emailContato) {
        this.nomeCompleto = nomeCompleto;
        this.CPF = CPF;
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
        this.telefoneContato = telefoneContato;
        this.emailContato = emailContato;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public String getCPF() {
        return CPF;
    }

    public int getIdade() {
        return idade;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }

    public String getTelefoneContato() {
        return telefoneContato;
    }

    public String getEmailContato() {
        return emailContato;
    }

    public abstract String getTipo();

    @Override
    public String toString() {
        return "Pessoa{" +
                "nomeCompleto='" + nomeCompleto + '\'' +
                ", CPF='" + CPF + '\'' +
                ", idade=" + idade +
                ", peso=" + peso +
                ", altura=" + altura +
                ", telefoneContato='" + telefoneContato + '\'' +
                ", emailContato='" + emailContato + '\'' +
                '}';
    }
}
