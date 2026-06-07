package hamburgueria;

public class FichaNutricional {
    private String nome;
    private String ingredientesDetalhados;
    private int calorias;

    public FichaNutricional(String nome, String ingredientesDetalhados, int calorias) {
        this.nome = nome;
        this.ingredientesDetalhados = ingredientesDetalhados;
        this.calorias = calorias;

        // Simulando um processamento pesado (ex: buscar tabela nutricional no BD)
        System.out.println("Criando Ficha Técnica pesada para: " + nome);
    }

    public String getNome() { return nome; }
    public String getIngredientes() { return ingredientesDetalhados; }
    public int getCalorias() { return calorias; }
}