package hamburgueria;
public class AcompanhamentoFactory {
    public static Acompanhamento criar(String tipo) {
        if (tipo.equalsIgnoreCase("Batata")) return new BatataFrita();
        if (tipo.equalsIgnoreCase("Cebola")) return new OnionRings();
        throw new IllegalArgumentException("Acompanhamento inválido");
    }
}