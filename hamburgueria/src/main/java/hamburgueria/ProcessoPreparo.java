package hamburgueria;

public abstract class ProcessoPreparo {
    // O Esqueleto do preparo
    public final String prepararLanche() {
        return aquecerPao() + " -> " + prepararProteina() + " -> " + embalar();
    }

    private String aquecerPao() { return "Pão na chapa"; }
    private String embalar() { return "Embalado no papel kraft"; }

    // O passo que muda
    protected abstract String prepararProteina();
}

class PreparoCarne extends ProcessoPreparo {
    protected String prepararProteina() { return "Hambúrguer grelhado ao ponto"; }
}