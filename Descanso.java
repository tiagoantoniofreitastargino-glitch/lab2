/**
 * Controla a rotina de descanso do aluno.
 *
 * O aluno e considerado descansado quando descansa pelo menos 26 horas por
 * semana. Sem horas ou semanas registradas, ele comeca cansado.
 */
public class Descanso {
    private static final int META_SEMANAL = 26;
    private static final String STATUS_DESCANSADO = "descansado";
    private static final String STATUS_CANSADO = "cansado";

    private int totalHoras;
    private int semanas;

    /**
     * Cria uma rotina de descanso sem horas e sem semanas registradas.
     */
    public Descanso() {
        totalHoras = 0;
        semanas = 0;
    }

    /**
     * Define o total de horas de descanso do periodo.
     *
     * @param valor total de horas de descanso.
     */
    public void defineHorasDescanso(int valor) {
        totalHoras = valor;
    }

    /**
     * Define quantas semanas o periodo possui.
     *
     * @param valor numero de semanas.
     */
    public void defineNumeroSemanas(int valor) {
        semanas = valor;
    }

    /**
     * Informa o estado geral de descanso do aluno.
     *
     * @return "descansado" se a media semanal de descanso for de pelo menos 26
     *         horas; "cansado" caso contrario ou se nao houver semanas
     *         registradas.
     */
    public String getStatusGeral() {
        boolean metaCumprida = semanas > 0 && totalHoras >= META_SEMANAL * semanas;
        return metaCumprida ? STATUS_DESCANSADO : STATUS_CANSADO;
    }
}
