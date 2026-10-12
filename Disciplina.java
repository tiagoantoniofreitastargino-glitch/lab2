import java.util.Arrays;

/**
 * Representa uma disciplina com horas de estudo e notas.
 *
 * Por padrao possui 4 notas e a media e aritmetica. Tambem pode ser criada com
 * outro numero de notas e, opcionalmente, com pesos para uma media ponderada.
 * O aluno e aprovado com media maior ou igual a 7.0, e notas nao cadastradas
 * valem zero.
 */
public class Disciplina {
    private static final int TOTAL_PROVAS_PADRAO = 4;
    private static final double CORTE_APROVACAO = 7.0;

    private final String titulo;
    private final double[] pontuacoes;
    private final int[] fatores;
    private final int somaFatores;
    private int horasDedicadas;

    /**
     * Cria uma disciplina com 4 notas e media aritmetica.
     *
     * @param nomeDisciplina nome da disciplina.
     */
    public Disciplina(String nomeDisciplina) {
        this(nomeDisciplina, TOTAL_PROVAS_PADRAO);
    }

    /**
     * Cria uma disciplina com o numero de notas informado e media aritmetica.
     *
     * @param nomeDisciplina nome da disciplina.
     * @param numeroDeNotas quantidade de notas (pelo menos 1).
     * @throws IllegalArgumentException se o numero de notas for menor que 1.
     */
    public Disciplina(String nomeDisciplina, int numeroDeNotas) {
        this(nomeDisciplina, numeroDeNotas, null);
    }

    /**
     * Cria uma disciplina com o numero de notas informado e media ponderada.
     * Por exemplo, com 2 notas e pesos {6, 4}, a media e
     * (6 * notas[0] + 4 * notas[1]) / 10.
     *
     * @param nomeDisciplina nome da disciplina.
     * @param numeroDeNotas quantidade de notas (pelo menos 1).
     * @param pesos peso de cada nota; se for null, todas tem o mesmo peso.
     * @throws IllegalArgumentException se o numero de notas for menor que 1, se
     *         a quantidade de pesos for diferente da de notas ou se a soma dos
     *         pesos nao for positiva.
     */
    public Disciplina(String nomeDisciplina, int numeroDeNotas, int[] pesos) {
        if (numeroDeNotas < 1) {
            throw new IllegalArgumentException("numero de notas invalido");
        }
        int[] escolhidos = (pesos == null) ? pesosIguais(numeroDeNotas) : pesos.clone();
        if (escolhidos.length != numeroDeNotas) {
            throw new IllegalArgumentException("quantidade de pesos diferente da de notas");
        }
        int soma = 0;
        for (int peso : escolhidos) {
            soma += peso;
        }
        if (soma <= 0) {
            throw new IllegalArgumentException("soma dos pesos invalida");
        }
        this.titulo = nomeDisciplina;
        this.pontuacoes = new double[numeroDeNotas];
        this.fatores = escolhidos;
        this.somaFatores = soma;
        this.horasDedicadas = 0;
    }

    private static int[] pesosIguais(int quantidade) {
        int[] resultado = new int[quantidade];
        Arrays.fill(resultado, 1);
        return resultado;
    }

    /**
     * Cadastra horas de estudo. As horas sao cumulativas.
     *
     * @param horas horas a somar as ja cadastradas.
     */
    public void cadastraHoras(int horas) {
        horasDedicadas += horas;
    }

    /**
     * Cadastra uma nota, substituindo a anterior se ela ja existir. Numeros de
     * nota fora do intervalo de 1 ate o total de notas sao ignorados.
     *
     * @param nota numero da nota, comecando em 1.
     * @param valorNota valor da nota.
     */
    public void cadastraNota(int nota, double valorNota) {
        int posicao = nota - 1;
        if (posicao >= 0 && posicao < pontuacoes.length) {
            pontuacoes[posicao] = valorNota;
        }
    }

    private double mediaPonderada() {
        double acumulado = 0;
        for (int i = 0; i < pontuacoes.length; i++) {
            acumulado += pontuacoes[i] * fatores[i];
        }
        return acumulado / somaFatores;
    }

    /**
     * Informa se o aluno foi aprovado, isto e, se a media e de pelo menos 7.0.
     *
     * @return true se aprovado, false caso contrario.
     */
    public boolean aprovado() {
        return mediaPonderada() >= CORTE_APROVACAO;
    }

    /**
     * Representa a disciplina no formato "NOME horas media [notas]", por
     * exemplo "PROGRAMACAO 2 4 7.0 [5.0, 6.0, 7.0, 10.0]".
     *
     * @return a representacao textual da disciplina.
     */
    @Override
    public String toString() {
        return titulo + " " + horasDedicadas + " " + mediaPonderada() + " " + Arrays.toString(pontuacoes);
    }
}
