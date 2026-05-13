package hamburgueria;

public abstract class AdicionalDecorator implements ItemPedido {
    protected ItemPedido item;

    public AdicionalDecorator(ItemPedido item) {
        this.item = item;
    }

    public double getPreco() { return item.getPreco(); }
    public String getDescricao() { return item.getDescricao(); }
}

class AdicionalBacon extends AdicionalDecorator {
    public AdicionalBacon(ItemPedido item) { super(item); }
    public double getPreco() { return super.getPreco() + 5.0; }
    public String getDescricao() { return super.getDescricao() + " + Bacon"; }
}