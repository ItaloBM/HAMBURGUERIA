package hamburgueria;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HamburgueriaTest {

    @BeforeEach
    void setUp() {
        Caixa.getInstancia().zerarCaixa();
    }

    @Test
    void deveFazerPedidoCompletoIntegrandoTodosOsPadroes() {
        // 1. ABSTRACT FACTORY: Cliente pede um Combo Tradicional
        ComboFactory comboTradicional = new ComboTradicionalFactory();
        Lanche meuLanche = comboTradicional.criarLanche(); // R$ 25.00
        Bebida minhaBebida = comboTradicional.criarBebida();

        assertEquals("Refrigerante Cola", minhaBebida.getDescricao());

        // 2. DECORATOR: Cliente quer adicionar Bacon e Queijo no lanche
        meuLanche = new AdicionalQueijo(meuLanche); // + R$ 3.50
        meuLanche = new AdicionalBacon(meuLanche);  // + R$ 5.00

        assertEquals("Hambúrguer de Carne Artesanal + Queijo Cheddar + Bacon Crocante", meuLanche.getDescricao());
        assertEquals(33.50, meuLanche.getPreco());

        // 3. FACTORY METHOD: Cliente decide pedir uma batata extra
        Acompanhamento extra = AcompanhamentoFactory.criar("Batata");
        assertEquals("Porção de Batata Frita", extra.emitir());

        // 4. BRIDGE: O cliente vai pedir por Delivery e pagar no Pix
        // O lanche custou 33.50. O Delivery custa + 10.00. Total = 43.50
        // O Pix dá 10% de desconto no valor final: 43.50 * 0.90 = 39.15
        FormaPagamento pix = new PagamentoPix();
        Pedido meuPedido = new PedidoDelivery(pix);

        double valorPago = meuPedido.finalizarPedido(meuLanche.getPreco());

        assertEquals(39.15, valorPago, 0.01);

        // 5. SINGLETON: O Caixa deve ter registrado exatamente este valor
        assertEquals(39.15, Caixa.getInstancia().getSaldoTotal(), 0.01);
    }
}