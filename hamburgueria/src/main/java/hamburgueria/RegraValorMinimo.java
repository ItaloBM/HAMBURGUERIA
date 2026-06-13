package hamburgueria;

public class RegraValorMinimo implements RegraDesconto {
    private double valorMinimo;

    public RegraValorMinimo(double valorMinimo) {
        this.valorMinimo = valorMinimo;
    }

    @Override
    public boolean avaliar(PedidoCliente pedido) {
        return pedido.getValorTotal() >= valorMinimo;
    }
}