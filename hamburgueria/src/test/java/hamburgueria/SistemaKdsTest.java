package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SistemaKdsTest {

    @Test
    void deveEnviarECancelarOrdemRapidamente() {
        // 1. Criamos a grelha (Recebedor)
        EstacaoPreparo grelha = new EstacaoPreparo();

        // 2. Criamos o pedido (A Ação)
        AcaoCozinha pedidoBacon = new OrdemPreparoBurguer(grelha, "Duplo Bacon");

        // 3. O Atendente usa o terminal (Invocador)
        TerminalAtendimento terminal = new TerminalAtendimento();

        // Cliente pediu! A carne foi para a grelha.
        terminal.enviarOrdem(pedidoBacon);
        assertTrue(grelha.isPreparando());
        assertEquals("Duplo Bacon", grelha.getLancheAtual());

        // Cliente arrependeu-se 5 segundos depois! Atendente clica no botão "Desfazer Último"
        terminal.cancelarUltimaOrdem();

        // A grelha para de preparar imediatamente e o hambúrguer é retirado
        assertFalse(grelha.isPreparando());
        assertEquals("", grelha.getLancheAtual());
    }
}