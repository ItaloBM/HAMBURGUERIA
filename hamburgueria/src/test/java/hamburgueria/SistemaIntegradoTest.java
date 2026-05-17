package hamburgueria;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SistemaIntegradoTest {

    @BeforeEach
    void setUp() { CaixaSingleton.getInstancia().zerar(); }

    @Test
    void deveTestarVisitorEMementoIntegrados() {
        // 1. Criando o lanche (Composite + Decorator)
        ItemPedido lanche = new BaconExtra(new HamburguerBase());

        // VISITOR: Calculando calorias do lanche sem alterar regras de preço
        CalculadoraCaloriasVisitor nutri = new CalculadoraCaloriasVisitor();
        lanche.aceitar(nutri);
        assertEquals(850, nutri.getCaloriasTotais()); // 600 base + 250 bacon

        // 2. Criando pedido (Builder)
        ClienteObserver eu = new ClienteObserver("Italo");
        PedidoCompleto pedido = new PedidoCompleto.Builder()
                .setItens(lanche)
                .setDesconto(new SemDesconto())
                .setCliente(eu)
                .build();

        // MEMENTO: Salvando estado atual ("Pendente")
        HistoricoPedido historico = new HistoricoPedido();
        historico.salvar(pedido);

        // Avançando status indevidamente (State)
        pedido.setStatus(new StatusPronto());
        assertEquals("Aviso para Italo: Pedido está agora: Pronto para Entrega", eu.getUltimoAviso());

        // MEMENTO: Desfazendo o erro (Restaurando "Pendente")
        historico.desfazer(pedido);
        assertEquals("Aviso para Italo: Status desfeito! Pedido voltou para: Pendente", eu.getUltimoAviso());
    }
}