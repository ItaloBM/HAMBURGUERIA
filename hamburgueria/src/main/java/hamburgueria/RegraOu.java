package hamburgueria;

public class RegraOu implements RegraDesconto {
    private RegraDesconto regra1;
    private RegraDesconto regra2;

    public RegraOu(RegraDesconto regra1, RegraDesconto regra2) {
        this.regra1 = regra1;
        this.regra2 = regra2;
    }

    @Override
    public boolean avaliar(PedidoCliente pedido) {
        // Pelo menos uma tem que ser verdadeira
        return regra1.avaliar(pedido) || regra2.avaliar(pedido);
    }
}