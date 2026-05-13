package hamburgueria;

import java.util.ArrayList;
import java.util.List;

public class ComboMisto implements ItemPedido {
    private List<ItemPedido> itens = new ArrayList<>();

    public void adicionarItem(ItemPedido item) { itens.add(item); }

    public double getPreco() {
        return itens.stream().mapToDouble(ItemPedido::getPreco).sum();
    }

    public String getDescricao() {
        return "Combo com " + itens.size() + " itens";
    }
}