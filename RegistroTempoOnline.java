/**
 * Registra o tempo online, em horas, dedicado a uma disciplina e o compara com
 * o tempo esperado.
 *
 * Por padrao, a disciplina tem 60 horas e se espera o dobro disso (120 horas)
 * de tempo online.
 */
public class RegistroTempoOnline {
    private static final int CARGA_HORARIA_PADRAO = 60;
    private static final int FATOR_ESPERADO = 2;

    private final String materia;
    private final int horasMeta;
    private int horasAcumuladas;

    /**
     * Cria um registro com o tempo esperado padrao de 120 horas.
     *
     * @param nomeDisciplina nome da disciplina.
     */
    public RegistroTempoOnline(String nomeDisciplina) {
        this(nomeDisciplina, CARGA_HORARIA_PADRAO * FATOR_ESPERADO);
    }

    /**
     * Cria um registro informando o tempo online esperado.
     *
     * @param nomeDisciplina nome da disciplina.
     * @param tempoOnlineEsperado tempo online esperado, em horas.
     */
    public RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado) {
        this.materia = nomeDisciplina;
        this.horasMeta = tempoOnlineEsperado;
        this.horasAcumuladas = 0;
    }

    /**
     * Soma horas ao tempo online ja usado. E permitido continuar adicionando
     * depois de atingir a meta.
     *
     * @param tempo horas a adicionar.
     */
    public void adicionaTempoOnline(int tempo) {
        horasAcumuladas += tempo;
    }

    /**
     * Verifica se o tempo online usado atingiu o esperado.
     *
     * @return true se o tempo usado for maior ou igual ao esperado.
     */
    public boolean atingiuMetaTempoOnline() {
        return horasAcumuladas >= horasMeta;
    }

    /**
     * Representa o registro no formato "NOME usado/esperado", por exemplo
     * "LP2 32/30".
     *
     * @return a representacao textual do registro.
     */
    @Override
    public String toString() {
        return String.format("%s %d/%d", materia, horasAcumuladas, horasMeta);
    }
}
