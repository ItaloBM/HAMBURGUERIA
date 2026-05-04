package hamburgueria;

public abstract class LancheDecorator implements Lanche {
    protected Lanche lancheDecorado;

    public LancheDecorator(Lanche lanche) {
        this.lancheDecorado = lanche;
    }

    public String getDescricao() {
        return lancheDecorado.getDescricao();
    }

    public double getPreco() {
        return lancheDecorado.getPreco();
    }
}