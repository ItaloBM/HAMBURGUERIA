package hamburgueria;

import java.util.HashMap;
import java.util.Map;

public class FabricaFichas {
    // O nosso "Cofre" de memória (Cache)
    private static Map<String, FichaNutricional> cache = new HashMap<>();

    public static FichaNutricional getFicha(String nome, String ingredientes, int calorias) {
        if (!cache.containsKey(nome)) {
            // Se a ficha não existe, criamos e guardamos
            cache.put(nome, new FichaNutricional(nome, ingredientes, calorias));
        }
        // Se já existe, apenas devolvemos a que está na memória!
        return cache.get(nome);
    }

    public static int getTotalFichasEmMemoria() {
        return cache.size();
    }
}