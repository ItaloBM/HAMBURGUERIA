package hamburgueria;

import java.util.List;

public class PedidoCliente {
    private String nomeCliente;
    private List<String> itensNoCarrinho;
    private double valorTotal;

    public PedidoCliente(String nomeCliente, List<String> itensNoCarrinho, double valorTotal) {
        this.nomeCliente = nomeCliente;
        this.itensNoCarrinho = itensNoCarrinho;
        this.valorTotal = valorTotal;
    }

    public boolean temItem(String nomeItem) {
        return itensNoCarrinho.contains(nomeItem);
    }

    public double getValorTotal() {
        return valorTotal;
    }
}