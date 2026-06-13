package hamburgueria;

public class OrdemPreparoBurguer implements AcaoCozinha {
    private EstacaoPreparo estacao;
    private String nomeLanche;

    public OrdemPreparoBurguer(EstacaoPreparo estacao, String nomeLanche) {
        this.estacao = estacao;
        this.nomeLanche = nomeLanche;
    }

    @Override
    public void executar() {
        // Ação de ida
        estacao.iniciarPreparo(nomeLanche);
    }

    @Override
    public void desfazer() {
        // Ação de volta (O "Ctrl+Z")
        estacao.cancelarPreparo();
    }
}