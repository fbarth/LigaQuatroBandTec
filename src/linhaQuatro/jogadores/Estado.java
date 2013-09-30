package linhaQuatro.jogadores;

/**
 * Representa um estado do mundo e as transicoes possiveis
 */
public interface Estado {

    public boolean ehMeta();
    public int custo();
}
