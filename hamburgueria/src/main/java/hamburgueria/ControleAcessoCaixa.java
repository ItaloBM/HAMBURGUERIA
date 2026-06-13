package hamburgueria;

public class ControleAcessoCaixa implements CaixaOperacional {
    private CaixaReal caixaVerdadeiro;
    private String cargoFuncionario;

    public ControleAcessoCaixa(String cargoFuncionario) {
        this.cargoFuncionario = cargoFuncionario;
    }

    // Lazy Load: O caixa verdadeiro só é ativado quando for realmente necessário
    private CaixaReal getCaixaVerdadeiro() {
        if (caixaVerdadeiro == null) {
            caixaVerdadeiro = new CaixaReal();
        }
        return caixaVerdadeiro;
    }

    @Override
    public void registrarVenda(double valor) {
        // Para registrar vendas, não tem barreira. Qualquer cargo pode!
        getCaixaVerdadeiro().registrarVenda(valor);
    }

    @Override
    public double verFaturamentoTotal() {
        // BARREIRA DE SEGURANÇA (Protection Proxy)
        if (cargoFuncionario.equals("Gerente") || cargoFuncionario.equals("Dono")) {
            return getCaixaVerdadeiro().verFaturamentoTotal();
        }
        throw new SecurityException("Acesso Negado: O cargo '" + cargoFuncionario + "' não tem permissão para ver o cofre.");
    }

    @Override
    public void fecharCaixa() {
        // BARREIRA DE SEGURANÇA
        if (cargoFuncionario.equals("Gerente") || cargoFuncionario.equals("Dono")) {
            getCaixaVerdadeiro().fecharCaixa();
        } else {
            throw new SecurityException("Acesso Negado: Apenas gerentes podem fechar o caixa.");
        }
    }
}