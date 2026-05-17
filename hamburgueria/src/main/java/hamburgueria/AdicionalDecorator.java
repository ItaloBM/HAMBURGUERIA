package hamburgueria;

public abstract class AdicionalDecorator implements ItemPedido {
    protected ItemPedido item;

    public AdicionalDecorator(ItemPedido item) {
        this.item = item;
    }

    public double getPreco() { return item.getPreco(); }
    public String getDescricao() { return item.getDescricao(); }
}

// Mudamos o nome para BaconExtra para não conflitar com o antigo!
class BaconExtra extends AdicionalDecorator {
    public BaconExtra(ItemPedido item) { super(item); }
    public double getPreco() { return super.getPreco() + 5.0; }
    public String getDescricao() { return super.getDescricao() + " + Bacon"; }
}