package hamburgueria;

public interface Notificavel {
    void atualizar(String mensagem);
}

class ClienteObserver implements Notificavel {
    private String nome;
    private String ultimoAviso;

    public ClienteObserver(String nome) { this.nome = nome; }

    public void atualizar(String mensagem) {
        this.ultimoAviso = "Aviso para " + nome + ": " + mensagem;
    }

    public String getUltimoAviso() { return ultimoAviso; }
}