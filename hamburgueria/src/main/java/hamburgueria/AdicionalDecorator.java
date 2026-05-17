package hamburgueria;

public abstract class AdicionalDecorator implements ItemPedido {
    protected ItemPedido item;

    public AdicionalDecorator(ItemPedido item) {
        this.item = item;
    }

    public double getPreco() { return item.getPreco(); }
    public String getDescricao() { return item.getDescricao(); }
}

class BaconExtra extends AdicionalDecorator {
    public BaconExtra(ItemPedido item) { super(item); }
    public double getPreco() { return super.getPreco() + 5.0; }
    public String getDescricao() { return super.getDescricao() + " + Bacon"; }

    @Override
    public void aceitar(ItemVisitor visitor) {
        super.item.aceitar(visitor);
        visitor.visitar(this);
    }
}