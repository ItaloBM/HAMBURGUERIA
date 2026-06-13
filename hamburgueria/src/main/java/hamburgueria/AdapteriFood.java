package hamburgueria;

public class AdapteriFood implements PedidoCozinha {

    // O adaptador guarda o objeto incompatível
    private PedidoiFood pedidoExterno;

    public AdapteriFood(PedidoiFood pedidoExterno) {
        this.pedidoExterno = pedidoExterno;
    }

    @Override
    public String getLanche() {
        // Traduz a chamada: a cozinha pede 'getLanche', o adapter pede 'obterCarrinhoCompleto'
        return "[iFood] " + pedidoExterno.obterCarrinhoCompleto();
    }

    @Override
    public boolean isParaEntregar() {
        // Traduz a lógica: converte a String do iFood para o booleano da cozinha
        String logistica = pedidoExterno.getMetodoLogistica();
        return logistica.equals("MOTOBOY");
    }
}