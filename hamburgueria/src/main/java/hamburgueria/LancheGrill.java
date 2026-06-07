package hamburgueria;

public class LancheGrill {
    // Estado Extrínseco (Único de cada pedido)
    private int idPedido;
    private String observacaoCliente;

    // Estado Intrínseco (Partilhado / Flyweight)
    private FichaNutricional ficha;

    public LancheGrill(int idPedido, String observacaoCliente, FichaNutricional ficha) {
        this.idPedido = idPedido;
        this.observacaoCliente = observacaoCliente;
        this.ficha = ficha;
    }

    public String exibirNaTelaDaCozinha() {
        return "Pedido #" + idPedido + " | " + ficha.getNome() + " | Obs: " + observacaoCliente;
    }
}