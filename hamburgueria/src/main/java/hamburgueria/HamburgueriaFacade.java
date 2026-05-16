package hamburgueria;

public class HamburgueriaFacade {
    private CentralCozinha cozinha = new CentralCozinha();

    public String processarPedido(PedidoCompleto pedido, ProcessoPreparo preparo) {

        // 1. Validar (Chain)
        ValidadorPedido validador = new ValidadorEstoque();
        if (!validador.validar(pedido)) return "Erro na validação";

        // 2. Preparar (Mediator + Template Method)
        String logCozinha = cozinha.comandarPreparo(preparo);

        // 3. Atualizar Status (State aciona Observer internamente)
        pedido.setStatus(new StatusPronto());

        // 4. Cobrar (Strategy de desconto) e Guardar no Cofre (Singleton)
        double valorFinal = pedido.calcularTotal();
        CaixaSingleton.getInstancia().registrarVenda(valorFinal);

        return logCozinha + " | Total pago: R$ " + valorFinal;
    }
}