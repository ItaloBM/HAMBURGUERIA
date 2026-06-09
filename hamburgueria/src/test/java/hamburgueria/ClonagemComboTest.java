package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClonagemComboTest {

    @Test
    void deveClonarCombosInstantaneamente() {
        long tempoInicial = System.currentTimeMillis();

        // 1. Pagamos o preço da lentidão (1 segundo) UMA ÚNICA VEZ para o modelo base
        Combo comboModelo = new Combo("Combo Festa", "10x Mini-Burgers, 5x Fritas, 2x Refri 2L");

        // 2. O cliente pediu 3 combos iguais! Clonamos instantaneamente.
        Combo pedido1 = comboModelo.clone();
        pedido1.setNomeCliente("Mesa 1 - João");

        Combo pedido2 = comboModelo.clone();
        pedido2.setNomeCliente("Mesa 2 - Maria");

        Combo pedido3 = comboModelo.clone();
        pedido3.setNomeCliente("Mesa 3 - Carlos");

        long tempoFinal = System.currentTimeMillis();
        long tempoTotalSegundos = (tempoFinal - tempoInicial) / 1000;

        // A GRANDE VITÓRIA: Apesar de termos criado 4 instâncias, o teste demorou apenas ~1 segundo!
        // Se usássemos o 'new' para todos, demoraria 4 segundos.
        assertTrue(tempoTotalSegundos < 2);

        // Garantimos que os dados originais foram mantidos, mas as etiquetas são únicas
        assertEquals("Combo Festa", pedido1.getNomeCombo());
        assertEquals("10x Mini-Burgers, 5x Fritas, 2x Refri 2L", pedido2.getItensInclusos());

        assertEquals("Mesa 1 - João", pedido1.getNomeCliente());
        assertEquals("Mesa 2 - Maria", pedido2.getNomeCliente());
    }
}