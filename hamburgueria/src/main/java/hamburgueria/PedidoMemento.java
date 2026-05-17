package hamburgueria;

public class PedidoMemento {
    private StatusPedido statusSalvo;

    public PedidoMemento(StatusPedido status) {
        this.statusSalvo = status;
    }

    public StatusPedido getStatusSalvo() {
        return statusSalvo;
    }
}