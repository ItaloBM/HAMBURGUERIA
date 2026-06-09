package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GarcomIteratorTest {

    @Test
    void garcomDeveLerCardapioSemSaberSuaEstrutura() {
        CardapioDia cardapio = new CardapioDia();
        cardapio.adicionarItem("X-Burguer Tradicional", 25.0);
        cardapio.adicionarItem("Batata Frita Média", 12.0);
        cardapio.adicionarItem("Refrigerante Cola", 8.0);

        // O Garçom pede o cardápio. O sistema entrega apenas o Iterador!
        IteradorCardapio iterador = cardapio.criarIterador();

        int contadorLidos = 0;
        String nomesLidos = "";

        // O ciclo WHILE puro e universal do padrão Iterator
        while (iterador.temProximo()) {
            ItemCardapio item = iterador.proximo();
            nomesLidos += item.getNome() + " | ";
            contadorLidos++;
        }

        assertEquals(3, contadorLidos);
        assertEquals("X-Burguer Tradicional | Batata Frita Média | Refrigerante Cola | ", nomesLidos);
    }
}