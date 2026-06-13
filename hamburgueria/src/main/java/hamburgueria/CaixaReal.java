package hamburgueria;

public class CaixaReal implements CaixaOperacional {
    private double saldoTotal = 0;

    public CaixaReal() {
        System.out.println("Iniciando conexão segura com o Banco central da Hamburgueria...");
    }

    @Override
    public void registrarVenda(double valor) {
        saldoTotal += valor;
    }

    @Override
    public double verFaturamentoTotal() {
        return saldoTotal;
    }

    @Override
    public void fecharCaixa() {
        saldoTotal = 0;
        System.out.println("Caixa fechado, dinheiro recolhido e sistema zerado com sucesso.");
    }
}