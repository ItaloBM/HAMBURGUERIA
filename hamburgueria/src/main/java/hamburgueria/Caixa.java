package hamburgueria;

public class Caixa {
    private static Caixa instancia = new Caixa();
    private double saldoTotal = 0.0;

    private Caixa() {}

    public static Caixa getInstancia() {
        return instancia;
    }

    public void registrarVenda(double valor) {
        this.saldoTotal += valor;
    }

    public double getSaldoTotal() {
        return saldoTotal;
    }

    public void zerarCaixa() {
        this.saldoTotal = 0.0;
    }
}