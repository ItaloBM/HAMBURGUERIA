package hamburgueria;

// 1. A classe implementa a interface nativa Cloneable
public class Combo implements Cloneable {

    // Atributos base pesados
    private String nomeCombo;
    private String itensInclusos;

    // Atributo variável
    private String nomeCliente;

    public Combo(String nomeCombo, String itensInclusos) {
        try {
            // Simulando lentidão: verificação de estoque, cálculo de impostos, etc.
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.nomeCombo = nomeCombo;
        this.itensInclusos = itensInclusos;
    }

    // Getters e Setters
    public void setNomeCliente(String nomeCliente) { this.nomeCliente = nomeCliente; }
    public String getNomeCliente() { return nomeCliente; }
    public String getNomeCombo() { return nomeCombo; }
    public String getItensInclusos() { return itensInclusos; }

    // 2. O Método de Clonagem Mágica
    @Override
    public Combo clone() {
        try {
            // O super.clone() copia o objeto diretamente na memória, pulando o construtor!
            return (Combo) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}