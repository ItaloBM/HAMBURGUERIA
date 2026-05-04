package hamburgueria;
public class PagamentoCartao implements FormaPagamento {
    public double cobrar(double valor) {
        double valorFinal = valor * 1.05; // 5% de taxa
        Caixa.getInstancia().registrarVenda(valorFinal); // Chama o Singleton!
        return valorFinal;
    }
}