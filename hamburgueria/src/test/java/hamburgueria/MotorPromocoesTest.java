package hamburgueria;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class MotorPromocoesTest {

    @Test
    void deveValidarCupomComplexoDinamicamente() {
        // Regra do Marketing: (Tem X-Bacon OU Tem Coca-Cola) E (Valor >= 50.0)

        // 1. Criamos as peças do quebra-cabeça
        RegraDesconto temBacon = new RegraItemPresente("X-Bacon");
        RegraDesconto temCoca = new RegraItemPresente("Coca-Cola");
        RegraDesconto valorMaior50 = new RegraValorMinimo(50.0);

        // 2. Montamos a lógica: (Bacon OU Coca)
        RegraDesconto baconOuCoca = new RegraOu(temBacon, temCoca);

        // 3. Montamos a lógica final: (Bacon OU Coca) E Valor >= 50
        RegraDesconto cupomFimDeSemana = new RegraE(baconOuCoca, valorMaior50);

        // TESTE A: Pedido que passa na regra do item, mas falha no valor (40.0)
        PedidoCliente pedido1 = new PedidoCliente("João", Arrays.asList("X-Bacon", "Batata"), 40.0);
        assertFalse(cupomFimDeSemana.avaliar(pedido1));

        // TESTE B: Pedido que atende a todos os requisitos (Tem Coca e deu 60.0)
        PedidoCliente pedido2 = new PedidoCliente("Maria", Arrays.asList("X-Salada", "Coca-Cola", "Sobremesa"), 60.0);
        assertTrue(cupomFimDeSemana.avaliar(pedido2));
    }
}