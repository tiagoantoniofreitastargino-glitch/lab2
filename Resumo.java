/**
 * Resumo de estudo: um pequeno texto ou anotacao sobre um tema.
 */
public class Resumo {
    private final String titulo;
    private String texto;

    /**
     * Cria um resumo.
     *
     * @param tema tema do resumo.
     * @param conteudo texto do resumo.
     */
    public Resumo(String tema, String conteudo) {
        this.titulo = tema;
        this.texto = conteudo;
    }

    /**
     * Retorna o tema do resumo.
     *
     * @return o tema.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Retorna o texto do resumo.
     *
     * @return o conteudo.
     */
    public String getTexto() {
        return texto;
    }

    /**
     * Substitui o texto do resumo.
     *
     * @param novoTexto novo conteudo.
     */
    public void setTexto(String novoTexto) {
        this.texto = novoTexto;
    }

    /**
     * Representa o resumo no formato "tema: conteudo".
     *
     * @return a representacao textual do resumo.
     */
    @Override
    public String toString() {
        return titulo + ": " + texto;
    }
}
