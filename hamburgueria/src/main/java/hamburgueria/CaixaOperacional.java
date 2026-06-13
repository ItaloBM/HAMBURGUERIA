package hamburgueria;

public interface CaixaOperacional {
    void registrarVenda(double valor);
    double verFaturamentoTotal();
    void fecharCaixa();
}