package hamburgueria;

import java.util.Stack;

public class HistoricoPedido {
    private Stack<PedidoMemento> historico = new Stack<>();

    public void salvar(PedidoCompleto pedido) {
        historico.push(pedido.salvarEstado());
    }

    public void desfazer(PedidoCompleto pedido) {
        if (!historico.isEmpty()) {
            pedido.restaurarEstado(historico.pop());
        }
    }
}