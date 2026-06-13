package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SegurancaCaixaTest {

    @Test
    void devePermitirVendaMasBloquearFaturamentoParaAtendente() {
        // O sistema entrega o "Guarda-costas" para o Atendente, que acha que é o terminal real
        CaixaOperacional terminal = new ControleAcessoCaixa("Atendente");

        // Ele consegue registrar vendas normalmente
        terminal.registrarVenda(50.0);
        terminal.registrarVenda(25.0);

        // Mas se tentar ver o total de dinheiro...
        Exception exception = assertThrows(SecurityException.class, () -> {
            terminal.verFaturamentoTotal();
        });

        assertEquals("Acesso Negado: O cargo 'Atendente' não tem permissão para ver o cofre.", exception.getMessage());
    }

    @Test
    void devePermitirAcessoTotalParaGerente() {
        // O gerente faz o login
        CaixaOperacional terminal = new ControleAcessoCaixa("Gerente");

        terminal.registrarVenda(100.0);
        terminal.registrarVenda(200.0);

        // O gerente tenta ver o faturamento (Tem que dar certo!)
        double total = terminal.verFaturamentoTotal();

        assertEquals(300.0, total);

        // E consegue fechar o caixa sem tomar erro
        assertDoesNotThrow(() -> {
            terminal.fecharCaixa();
        });
    }
}