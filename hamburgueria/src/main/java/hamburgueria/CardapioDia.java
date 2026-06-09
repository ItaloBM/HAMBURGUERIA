package hamburgueria;

public class CardapioDia implements Menu {
    private ItemCardapio[] itens;
    private int tamanho = 0;

    public CardapioDia() {
        itens = new ItemCardapio[10];
    }

    public void adicionarItem(String nome, double preco) {
        if (tamanho < itens.length) {
            itens[tamanho] = new ItemCardapio(nome, preco);
            tamanho++;
        }
    }

    @Override
    public IteradorCardapio criarIterador() {
        return new IteradorMenuArray(itens);
    }
}