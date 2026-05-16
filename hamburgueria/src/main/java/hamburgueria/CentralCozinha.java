package hamburgueria;

public class CentralCozinha {
    public String comandarPreparo(ProcessoPreparo preparo) {
        return "Cozinha informa: " + preparo.prepararLanche();
    }
}