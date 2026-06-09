package hamburgueria;

public class IteradorMenuArray implements IteradorCardapio {
    private ItemCardapio[] itens;
    private int posicaoAtual = 0;

    public IteradorMenuArray(ItemCardapio[] itens) {
        this.itens = itens;
    }

    @Override
    public boolean temProximo() {
        // Se chegarmos ao limite do array ou encontrarmos um espaço vazio, paramos a leitura
        if (posicaoAtual >= itens.length || itens[posicaoAtual] == null) {
            return false;
        }
        return true;
    }

    @Override
    public ItemCardapio proximo() {
        ItemCardapio item = itens[posicaoAtual];
        posicaoAtual++;
        return item;
    }
}