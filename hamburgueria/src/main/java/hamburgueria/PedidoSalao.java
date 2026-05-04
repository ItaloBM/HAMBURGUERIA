// --- Sem taxa de entrega ---
package hamburgueria;
public class PedidoSalao extends Pedido {
    public PedidoSalao(FormaPagamento fp) { super(fp); }
    public double finalizarPedido(double valorItens) {
        return this.formaPagamento.cobrar(valorItens);
    }
}