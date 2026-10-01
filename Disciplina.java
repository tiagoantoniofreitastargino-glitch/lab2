public class Disciplina {
    private String nomeDisciplina;
    private int horasEstudo;
    private double[] notas;
    private static final int QUANTIDADE_NOTAS = 4;
    private static final double MEDIA_MINIMA_APROVACAO = 7.0;

    public Disciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.horasEstudo = 0;
        this.notas = new double[QUANTIDADE_NOTAS + 1];
    }

    public void cadastraHoras(int horas) {
        this.horasEstudo += horas;
    }

    public void cadastraNota(int nota, double valorNota) {
        if (nota >= 1 && nota <= QUANTIDADE_NOTAS) {
            this.notas[nota] = valorNota;
        }
    }

    private double calculaMedia() {
        double soma = 0;
        for (int i = 1; i <= QUANTIDADE_NOTAS; i++) {
            soma += notas[i];
        }
        return soma / QUANTIDADE_NOTAS;
    }

    public boolean aprovado() {
    return calculaMedia() >= MEDIA_MINIMA_APROVACAO;
    }
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Disciplina: ").append(nomeDisciplina);
            sb.append(" | Horas de estudo: ").append(horasEstudo);
            sb.append(" | Média: ").append(calculaMedia());
            sb.append(" | Notas: ");
            for (int i = 1; i <= QUANTIDADE_NOTAS; i++) {
            sb.append(notas[i]);
            if (i < QUANTIDADE_NOTAS) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}
