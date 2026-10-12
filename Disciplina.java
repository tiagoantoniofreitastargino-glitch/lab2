import java.util.Arrays;

public class Disciplina {
    private static final int QUANTIDADE_NOTAS_PADRAO = 4;
    private static final double MEDIA_MINIMA_APROVACAO = 7.0;

    private String nomeDisciplina;
    private int horasEstudo;
    private double[] notas;
    private int[] pesos;

    public Disciplina(String nomeDisciplina) {
        this(nomeDisciplina, QUANTIDADE_NOTAS_PADRAO);
    }

    public Disciplina(String nomeDisciplina, int numeroDeNotas) {
        this(nomeDisciplina, numeroDeNotas, null);
    }

    public Disciplina(String nomeDisciplina, int numeroDeNotas, int[] pesos) {
        if (numeroDeNotas < 1) {
            throw new IllegalArgumentException("A disciplina precisa ter ao menos uma nota.");
        }
        this.nomeDisciplina = nomeDisciplina;
        this.horasEstudo = 0;
        this.notas = new double[numeroDeNotas];
        this.pesos = new int[numeroDeNotas];
        if (pesos == null) {
            Arrays.fill(this.pesos, 1);
        } else {
            if (pesos.length != numeroDeNotas) {
                throw new IllegalArgumentException("A quantidade de pesos deve ser igual a de notas.");
            }
            int somaPesos = 0;
            for (int peso : pesos) {
                somaPesos += peso;
            }
            if (somaPesos <= 0) {
                throw new IllegalArgumentException("A soma dos pesos deve ser positiva.");
            }
            this.pesos = pesos.clone();
        }
    }

    public void cadastraHoras(int horas) {
        this.horasEstudo += horas;
    }

    public void cadastraNota(int nota, double valorNota) {
        if (nota >= 1 && nota <= notas.length) {
            this.notas[nota - 1] = valorNota;
        }
    }

    private double calculaMedia() {
        double soma = 0;
        int somaPesos = 0;
        for (int i = 0; i < notas.length; i++) {
            soma += notas[i] * pesos[i];
            somaPesos += pesos[i];
        }
        return soma / somaPesos;
    }

    public boolean aprovado() {
        return calculaMedia() >= MEDIA_MINIMA_APROVACAO;
    }

    @Override
    public String toString() {
        return nomeDisciplina + " " + horasEstudo + " " + calculaMedia() + " " + Arrays.toString(notas);
    }
}
