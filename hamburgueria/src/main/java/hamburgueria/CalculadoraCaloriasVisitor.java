package hamburgueria;

public class CalculadoraCaloriasVisitor implements ItemVisitor {
    private int caloriasTotais = 0;

    @Override
    public void visitar(HamburguerBase hamburguer) {
        caloriasTotais += 600; // Calorias base do pão e carne
    }

    @Override
    public void visitar(BaconExtra bacon) {
        caloriasTotais += 250; // Calorias do bacon extra
    }

    @Override
    public void visitar(ComboMisto combo) {
        // O combo em si não tem calorias, apenas repassa para os itens dentro dele
    }

    public int getCaloriasTotais() {
        return caloriasTotais;
    }
}