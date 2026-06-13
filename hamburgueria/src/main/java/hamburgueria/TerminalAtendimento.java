package hamburgueria;

import java.util.Stack;

public class TerminalAtendimento {
    // A pilha que guarda a história das ações
    private Stack<AcaoCozinha> historico = new Stack<>();

    public void enviarOrdem(AcaoCozinha acao) {
        acao.executar();
        historico.push(acao); // Guarda na memória para poder desfazer depois
    }

    public void cancelarUltimaOrdem() {
        if (!historico.isEmpty()) {
            AcaoCozinha ultimaAcao = historico.pop();
            ultimaAcao.desfazer(); // Chama o "Ctrl+Z"
        }
    }
}