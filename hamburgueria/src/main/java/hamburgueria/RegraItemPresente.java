package hamburgueria;

public class RegraItemPresente implements RegraDesconto {
    private String itemExigido;

    public RegraItemPresente(String itemExigido) {
        this.itemExigido = itemExigido;
    }

    @Override
    public boolean avaliar(PedidoCliente pedido) {
        return pedido.temItem(itemExigido);
    }
}