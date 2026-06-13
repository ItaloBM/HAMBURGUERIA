package hamburgueria;

public class PainelCozinha {
    // A cozinha é restrita! Ela só aceita objetos que implementem 'PedidoCozinha'
    public String exibirPreparo(PedidoCozinha pedido) {
        String tipo = pedido.isParaEntregar() ? "EMBALAR PARA MOTOBOY" : "SERVIR NA BANDEJA";
        return "PREPARAR: " + pedido.getLanche() + " -> " + tipo;
    }
}