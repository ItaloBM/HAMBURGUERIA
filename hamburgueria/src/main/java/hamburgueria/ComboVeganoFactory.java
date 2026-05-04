package hamburgueria;
public class ComboVeganoFactory implements ComboFactory {
    public Lanche criarLanche() { return new LancheVegano(); }
    public Bebida criarBebida() { return new SucoNatural(); }
}