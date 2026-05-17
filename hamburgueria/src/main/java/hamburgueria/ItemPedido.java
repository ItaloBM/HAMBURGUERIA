package hamburgueria;

public interface ItemPedido {
    void aceitar(ItemVisitor visitor);
    double getPreco();
    String getDescricao();
}