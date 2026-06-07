package hamburgueria;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class FlyweightHamburgueriaTest {

    @Test
    void deveEconomizarMemoriaCompartilhandoFichasTecnicas() {
        List<LancheGrill> pedidosDaNoite = new ArrayList<>();

        // 1. O sistema recebe 5.000 pedidos de "X-Bacon"
        for (int i = 1; i <= 5000; i++) {
            FichaNutricional fichaBacon = FabricaFichas.getFicha(
                    "X-Bacon Supremo", "Pão, 2x Carne, Bacon, Queijo", 850
            );
            pedidosDaNoite.add(new LancheGrill(i, "Sem cebola", fichaBacon));
        }

        // 2. O sistema recebe mais 5.000 pedidos de "X-Salada"
        for (int i = 5001; i <= 10000; i++) {
            FichaNutricional fichaSalada = FabricaFichas.getFicha(
                    "X-Salada Light", "Pão integral, Carne soja, Alface, Tomate", 400
            );
            pedidosDaNoite.add(new LancheGrill(i, "Extra molho", fichaSalada));
        }

        // Temos 10.000 lanches na grelha consumindo memória!
        assertEquals(10000, pedidosDaNoite.size());

        // A GRANDE VITÓRIA: Apesar de 10.000 lanches, só existem 2 Fichas pesadas na memória!
        assertEquals(2, FabricaFichas.getTotalFichasEmMemoria());

        // Verificando se os dados únicos foram mantidos corretamente
        assertEquals("Pedido #1 | X-Bacon Supremo | Obs: Sem cebola", pedidosDaNoite.get(0).exibirNaTelaDaCozinha());
        assertEquals("Pedido #10000 | X-Salada Light | Obs: Extra molho", pedidosDaNoite.get(9999).exibirNaTelaDaCozinha());
    }
}