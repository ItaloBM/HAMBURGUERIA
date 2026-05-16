package hamburgueria;

public interface EstrategiaDesconto {
    double aplicarDesconto(double valorOriginal);
}

class DescontoFidelidade implements EstrategiaDesconto {
    public double aplicarDesconto(double valor) { return valor * 0.90; } // 10% Off
}

class SemDesconto implements EstrategiaDesconto {
    public double aplicarDesconto(double valor) { return valor; }
}