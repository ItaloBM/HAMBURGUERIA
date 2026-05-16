package hamburgueria;

public abstract class ValidadorPedido {
    protected ValidadorPedido proximo;

    public void setProximo(ValidadorPedido proximo) { this.proximo = proximo; }
    public abstract boolean validar(PedidoCompleto pedido);
}

class ValidadorEstoque extends ValidadorPedido {
    public boolean validar(PedidoCompleto pedido) {
        if (pedido.getItens() == null) return false;
        if (proximo != null) return proximo.validar(pedido);
        return true;
    }
}