package hamburgueria;

public class HamburguerBase implements ItemPedido {
    public double getPreco() { return 25.0; }
    public String getDescricao() { return "Hambúrguer Artesanal"; }
}