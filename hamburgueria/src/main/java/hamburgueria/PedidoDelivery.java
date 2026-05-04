// --- Com taxa de entrega fixa de R$ 10,00 ---
package hamburgueria;
public class PedidoDelivery extends Pedido {
    public PedidoDelivery(FormaPagamento fp) { super(fp); }
    public double finalizarPedido(double valorItens) {
        return this.formaPagamento.cobrar(valorItens + 10.0);
    }
}