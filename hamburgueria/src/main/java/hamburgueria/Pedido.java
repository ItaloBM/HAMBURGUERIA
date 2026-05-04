package hamburgueria;

public abstract class Pedido {
    protected FormaPagamento formaPagamento;

    public Pedido(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
    public abstract double finalizarPedido(double valorItens);
}