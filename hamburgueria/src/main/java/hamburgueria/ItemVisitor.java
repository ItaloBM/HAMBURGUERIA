package hamburgueria;

public interface ItemVisitor {
    void visitar(HamburguerBase hamburguer);
    void visitar(BaconExtra bacon);
    void visitar(ComboMisto combo);
}