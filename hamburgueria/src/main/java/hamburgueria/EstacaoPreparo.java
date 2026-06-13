package hamburgueria;

public class EstacaoPreparo {
    private boolean preparando = false;
    private String lancheAtual = "";

    public void iniciarPreparo(String lanche) {
        this.lancheAtual = lanche;
        this.preparando = true;
    }

    public void cancelarPreparo() {
        this.lancheAtual = "";
        this.preparando = false;
    }

    public boolean isPreparando() { return preparando; }
    public String getLancheAtual() { return lancheAtual; }
}