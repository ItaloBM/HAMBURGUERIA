package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AdapteriFoodTest {

    @Test
    void deveAdaptarPedidoiFoodParaTelaDaCozinha() {
        PainelCozinha tela = new PainelCozinha();

        // 1. Pedido normal do salão (Funciona perfeitamente)
        PedidoCozinha pedidoSalao = new PedidoBalcao("X-Salada", false);
        assertEquals("PREPARAR: X-Salada -> SERVIR NA BANDEJA", tela.exibirPreparo(pedidoSalao));

        // 2. Chega um pedido do iFood
        PedidoiFood pedidoExterno = new PedidoiFood("2x X-Bacon, 1x Coca-Cola", "MOTOBOY");

        // tela.exibirPreparo(pedidoExterno); // ERRO! A tela não aceita PedidoiFood.

        // 3. Usamos o Adaptador! Ele encapsula o pedido do iFood e disfarça-se de PedidoCozinha
        PedidoCozinha pedidoAdaptado = new AdapteriFood(pedidoExterno);

        // 4. A tela aceita o adaptador e tudo funciona magicamente!
        String resultado = tela.exibirPreparo(pedidoAdaptado);

        assertEquals("PREPARAR: [iFood] 2x X-Bacon, 1x Coca-Cola -> EMBALAR PARA MOTOBOY", resultado);
    }
}