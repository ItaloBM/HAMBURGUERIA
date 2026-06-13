package hamburgueria;

public class RegraE implements RegraDesconto {
    private RegraDesconto regra1;
    private RegraDesconto regra2;

    public RegraE(RegraDesconto regra1, RegraDesconto regra2) {
        this.regra1 = regra1;
        this.regra2 = regra2;
    }

    @Override
    public boolean avaliar(PedidoCliente pedido) {
        // Ambas têm que ser verdadeiras
        return regra1.avaliar(pedido) && regra2.avaliar(pedido);
    }
}