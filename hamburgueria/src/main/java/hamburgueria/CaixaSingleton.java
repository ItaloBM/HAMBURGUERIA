package hamburgueria;

public class CaixaSingleton {
    private static CaixaSingleton instancia = new CaixaSingleton();
    private double saldo = 0;

    private CaixaSingleton() {}

    public static CaixaSingleton getInstancia() { return instancia; }
    public void registrarVenda(double valor) { saldo += valor; }
    public double getSaldo() { return saldo; }
    public void zerar() { saldo = 0; }
}