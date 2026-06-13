package hamburgueria;

public class PedidoBalcao implements PedidoCozinha {
    private String nomeLanche;
    private boolean delivery;

    public PedidoBalcao(String nomeLanche, boolean delivery) {
        this.nomeLanche = nomeLanche;
        this.delivery = delivery;
    }

    @Override
    public String getLanche() { return nomeLanche; }

    @Override
    public boolean isParaEntregar() { return delivery; }
}