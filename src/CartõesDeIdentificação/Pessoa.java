package CartõesDeIdentificação;

public class Pessoa {
    private String nomeCompleto;
    private String CPF;
    private int idade;
    private double peso;
    private double altura;
    private String telefoneContato;
    private String emailContato;
    private String contatoEmergencia;

    // Construtor vazio
    public Pessoa() {
    }

    // Getters e Setters para todos os atributos
    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getTelefoneContato() {
        return telefoneContato;
    }

    public void setTelefoneContato(String telefoneContato) {
        this.telefoneContato = telefoneContato;
    }

    public String getEmailContato() {
        return emailContato;
    }

    public void setEmailContato(String emailContato) {
        this.emailContato = emailContato;
    }

    public String getContatoEmergencia() {
        return contatoEmergencia;
    }

    public void setContatoEmergencia(String contatoEmergencia) {
        this.contatoEmergencia = contatoEmergencia;
    }

    // toString() para exibir os detalhes da Pessoa
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
                ", contatoEmergencia='" + contatoEmergencia + '\'' +
                '}';
    }
}
