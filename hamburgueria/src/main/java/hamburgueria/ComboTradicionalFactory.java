package hamburgueria;
public class ComboTradicionalFactory implements ComboFactory {
    public Lanche criarLanche() { return new LancheCarne(); }
    public Bebida criarBebida() { return new Refrigerante(); }
}