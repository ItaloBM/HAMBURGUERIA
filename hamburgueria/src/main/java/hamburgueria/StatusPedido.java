package hamburgueria;

public interface StatusPedido {
    void avancar(PedidoCompleto pedido);
    String getNomeStatus();
}

class StatusPendente implements StatusPedido {
    public void avancar(PedidoCompleto p) { p.setStatus(new StatusPronto()); }
    public String getNomeStatus() { return "Pendente"; }
}

class StatusPronto implements StatusPedido {
    public void avancar(PedidoCompleto p) { /* Fim da linha */ }
    public String getNomeStatus() { return "Pronto para Entrega"; }
}