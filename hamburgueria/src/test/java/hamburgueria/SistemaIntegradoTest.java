package hamburgueria;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SistemaIntegradoTest {

    @BeforeEach
    void setUp() {
        CaixaSingleton.getInstancia().zerar();
    }

    @Test
    void deveExecutarTodosOs14PadroesJuntos() {
        // 1. Observer e Decorator
        ClienteObserver eu = new ClienteObserver("Italo");
        ItemPedido lanche = new BaconExtra(new HamburguerBase()); // 25 + 5 = 30

        // 2. Builder e Strategy
        PedidoCompleto pedido = new PedidoCompleto.Builder()
                .setItens(lanche)
                .setDesconto(new DescontoFidelidade()) // 10% de 30 = 27
                .setCliente(eu)
                .build();

        // 3. Facade organiza o caos (usa Chain, Mediator, Template, State e Singleton)
        HamburgueriaFacade sistema = new HamburgueriaFacade();
        String resultado = sistema.processarPedido(pedido, new PreparoCarne());

        // Validações de Sucesso:
        assertEquals("Cozinha informa: Pão na chapa -> Hambúrguer grelhado ao ponto -> Embalado no papel kraft | Total pago: R$ 27.0", resultado);
        assertEquals(27.0, CaixaSingleton.getInstancia().getSaldo());
        assertEquals("Aviso para Italo: Pedido está agora: Pronto para Entrega", eu.getUltimoAviso());
    }
}