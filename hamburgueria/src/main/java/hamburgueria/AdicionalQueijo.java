package hamburgueria;

public class AdicionalQueijo extends LancheDecorator {
    public AdicionalQueijo(Lanche lanche) { super(lanche); }

    @Override
    public String getDescricao() { return super.getDescricao() + " + Queijo Cheddar"; }

    @Override
    public double getPreco() { return super.getPreco() + 3.5; } // Queijo custa +3.50
}