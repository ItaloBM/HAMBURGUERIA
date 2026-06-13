package hamburgueria;

public class PedidoiFood {
    private String carrinhoCompleto;
    private String metodoLogistica; // Retorna "MOTOBOY" ou "RETIRADA_LOJA"

    public PedidoiFood(String carrinhoCompleto, String metodoLogistica) {
        this.carrinhoCompleto = carrinhoCompleto;
        this.metodoLogistica = metodoLogistica;
    }

    public String obterCarrinhoCompleto() {
        return carrinhoCompleto;
    }

    public String getMetodoLogistica() {
        return metodoLogistica;
    }
}