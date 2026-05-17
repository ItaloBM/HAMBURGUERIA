package hamburgueria;

public class PedidoCompleto {
    private ItemPedido itens;
    private EstrategiaDesconto desconto;
    private StatusPedido status;
    private Notificavel cliente;

    // Construtor privado para o Builder
    PedidoCompleto() { this.status = new StatusPendente(); }

    public ItemPedido getItens() { return itens; }

    public void setStatus(StatusPedido status) {
        this.status = status;
        if(cliente != null) {
            cliente.atualizar("Pedido está agora: " + status.getNomeStatus());
        }
    }

    public double calcularTotal() {
        return desconto.aplicarDesconto(itens.getPreco());
    }

    // A classe Builder interna
    public static class Builder {
        private PedidoCompleto pedido = new PedidoCompleto();

        public Builder setItens(ItemPedido itens) { pedido.itens = itens; return this; }
        public Builder setDesconto(EstrategiaDesconto desc) { pedido.desconto = desc; return this; }
        public Builder setCliente(Notificavel cliente) { pedido.cliente = cliente; return this; }

        public PedidoCompleto build() { return pedido; }
    }

    public PedidoMemento salvarEstado() {
        return new PedidoMemento(this.status);
    }

    public void restaurarEstado(PedidoMemento memento) {
        this.status = memento.getStatusSalvo();
        if(cliente != null) {
            cliente.atualizar("Status desfeito! Pedido voltou para: " + status.getNomeStatus());
        }
    }
}