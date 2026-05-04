package hamburgueria;
public class PagamentoPix implements FormaPagamento {
    public double cobrar(double valor) {
        double valorFinal = valor * 0.90; // 10% desconto
        Caixa.getInstancia().registrarVenda(valorFinal); // Chama o Singleton!
        return valorFinal;
    }
}