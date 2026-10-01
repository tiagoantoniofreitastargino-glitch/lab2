public class RegistroTempoOnline {
    private String nomeDisciplina;
    private int tempoOnlineUsado;
    private int tempoOnlineEsperado;
    private static final int HORAS_PADRAO_DISCIPLINA = 60;
    private static final int MULTIPLICADOR_TEMPO_ESPERADO = 2;

    public RegistroTempoOnline(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.tempoOnlineUsado = 0;
        this.tempoOnlineEsperado = HORAS_PADRAO_DISCIPLINA * MULTIPLICADOR_TEMPO_ESPERADO;
    }

    public RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado) {
        this.nomeDisciplina = nomeDisciplina;
        this.tempoOnlineUsado = 0;
        this.tempoOnlineEsperado = tempoOnlineEsperado;
    }

    public void adicionaTempoOnline(int tempo) {
        this.tempoOnlineUsado += tempo;
    }

    public boolean atingiuMetaTempoOnline() {
        return this.tempoOnlineUsado >= this.tempoOnlineEsperado;
    }

    @Override
    public String toString() {
        return "Disciplina: " + nomeDisciplina + " | Tempo online usado: " + tempoOnlineUsado + "h" + " | Tempo online esperado: " + tempoOnlineEsperado + "h";
    }
}

