public class RegistraResumos {
    private int numeroDeResumos; 
    private String[] temas; 
    private String[] conteudos; 
    private int quantidadeAtual; 
    private int proximaPosicao; 
    public RegistraResumos(int numeroDeResumos) {
        this.numeroDeResumos = numeroDeResumos;
        this.temas = new String[numeroDeResumos]; 
        this.conteudos = new String[numeroDeResumos];
        this.quantidadeAtual = 0; 
        this.proximaPosicao = 0; 
    }
    public void adiciona(String tema, String conteudo)
    {
        if (temResumo(tema)) {
            return;
        }

      temas[proximaPosicao] = tema; 
      conteudos[proximaPosicao] = conteudo; 
      proximaPosicao = (proximaPosicao + 1) % numeroDeResumos; 
      if (quantidadeAtual < numeroDeResumos) { 
          quantidadeAtual++; 
      } 
    } 
    public String[] pegaResumos() { 
        String[] resultado = new String[quantidadeAtual];
        for (int i = 0; i < quantidadeAtual; i++) { 
            resultado[i] = temas[i]; 
        } 
        return resultado; 
    } 
    public String imprimeResumos() 
    {StringBuilder sb = new StringBuilder(); 
        for (int i = 0; i < quantidadeAtual; i++) { 
            sb.append("Tema: ").append(temas[i]); 
            sb.append(" | Conteúdo: ").append(conteudos[i]); 
            sb.append("\n"); 
        } 
        return sb.toString(); 
    } 
    public int conta() {
        return quantidadeAtual; 
    } 
    public boolean temResumo(String tema) { 
        for (int i = 0; i < quantidadeAtual; i++) { 
            if (temas[i].equals(tema)) { 
                return true; 
            } 
        } 
        return false;
    } 
}
