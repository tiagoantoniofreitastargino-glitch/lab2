public class Resumo {
    private String tema;
    private String conteudo;

    public Resumo(String tema, String conteudo) {
        this.tema = tema;
        this.conteudo = conteudo;
    }


    public String getTema() {
        return tema;
    }

    public String getConteudo() {
        return conteudo;
    }


    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    @Override
    public String toString() {
        return tema + ": " + conteudo;
    }
}
