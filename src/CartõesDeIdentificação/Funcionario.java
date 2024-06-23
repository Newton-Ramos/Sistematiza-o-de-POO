package CartõesDeIdentificação;

import java.util.UUID;

public class Funcionario extends Pessoa {
    private String contatoEmergencia;
    private boolean hasDoencasPreexistentes;
    private String doencasPreexistentes;
    private long codigo;

    public Funcionario(String nomeCompleto, String CPF, int idade, double peso, double altura, String telefoneContato, String emailContato, String contatoEmergencia, boolean hasDoencasPreexistentes, String doencasPreexistentes) {
        super(nomeCompleto, CPF, idade, peso, altura, telefoneContato, emailContato);
        this.contatoEmergencia = contatoEmergencia;
        this.hasDoencasPreexistentes = hasDoencasPreexistentes;
        this.doencasPreexistentes = doencasPreexistentes;
        this.codigo = gerarCodigoUnico(); // Gera um código único para o funcionário
    }

    public String getContatoEmergencia() {
        return contatoEmergencia;
    }

    public boolean hasDoencasPreexistentes() {
        return hasDoencasPreexistentes;
    }

    public String getDoencasPreexistentes() {
        return doencasPreexistentes;
    }

    public long getCodigo() {
        return codigo;
    }

    @Override
    public String getTipo() {
        return "Funcionario";
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "nomeCompleto='" + getNomeCompleto() + '\'' +
                ", CPF='" + getCPF() + '\'' +
                ", idade=" + getIdade() +
                ", peso=" + getPeso() +
                ", altura=" + getAltura() +
                ", telefoneContato='" + getTelefoneContato() + '\'' +
                ", emailContato='" + getEmailContato() + '\'' +
                ", contatoEmergencia='" + contatoEmergencia + '\'' +
                ", hasDoencasPreexistentes=" + hasDoencasPreexistentes +
                ", doencasPreexistentes='" + doencasPreexistentes + '\'' +
                ", codigo=" + codigo +
                '}';
    }

    // Método privado para gerar código único aleatório de 10 dígitos
    private long gerarCodigoUnico() {
        return UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
    }
}
