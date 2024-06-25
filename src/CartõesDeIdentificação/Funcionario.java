package CartõesDeIdentificação;

public class Funcionario extends Pessoa {
    private long codigo;
    private String doencasPreexistentes;

    // Construtor vazio
    public Funcionario() {
    }

    // Getters e Setters específicos para Funcionario
    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getDoencasPreexistentes() {
        return doencasPreexistentes;
    }

    public void setDoencasPreexistentes(String doencasPreexistentes) {
        this.doencasPreexistentes = doencasPreexistentes;
    }

    // toString() para exibir os detalhes do Funcionario
    @Override
    public String toString() {
        return "Funcionario{" +
                "codigo=" + codigo +
                ", doencasPreexistentes='" + doencasPreexistentes + '\'' +
                "} " + super.toString();
    }
}
