import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RegistraResumos {
    private Resumo[] resumos;
    private int quantidadeAtual;
    private int proximaPosicao;

    public RegistraResumos(int numeroDeResumos) {
        if (numeroDeResumos < 1) {
            throw new IllegalArgumentException("O registro precisa comportar ao menos um resumo.");
        }
        this.resumos = new Resumo[numeroDeResumos];
        this.quantidadeAtual = 0;
        this.proximaPosicao = 0;
    }

    public void adiciona(String tema, String conteudo) {
        int existente = indiceDoTema(tema);
        if (existente != -1) {
            resumos[existente].setConteudo(conteudo);
            return;
        }
        resumos[proximaPosicao] = new Resumo(tema, conteudo);
        proximaPosicao = (proximaPosicao + 1) % resumos.length;
        if (quantidadeAtual < resumos.length) {
            quantidadeAtual++;
        }
    }

    public String[] pegaResumos() {
        String[] resultado = new String[quantidadeAtual];
        for (int i = 0; i < quantidadeAtual; i++) {
            resultado[i] = resumos[i].toString();
        }
        return resultado;
    }

    public String imprimeResumos() {
        StringBuilder sb = new StringBuilder();
        sb.append("- ").append(conta()).append(" resumo(s) cadastrado(s)\n");
        sb.append("- ");
        for (int i = 0; i < quantidadeAtual; i++) {
            sb.append(resumos[i].getTema());
            if (i < quantidadeAtual - 1) {
                sb.append(" | ");
            }
        }
        return sb.toString();
    }

    public int conta() {
        return quantidadeAtual;
    }

    public boolean temResumo(String tema) {
        return indiceDoTema(tema) != -1;
    }

    public String[] busca(String chaveDeBusca) {
        String chave = chaveDeBusca.toLowerCase();
        List<String> encontrados = new ArrayList<>();
        for (int i = 0; i < quantidadeAtual; i++) {
            if (resumos[i].getConteudo().toLowerCase().contains(chave)) {
                encontrados.add(resumos[i].getTema());
            }
        }
        Collections.sort(encontrados);
        return encontrados.toArray(new String[0]);
    }

    private int indiceDoTema(String tema) {
        for (int i = 0; i < quantidadeAtual; i++) {
            if (resumos[i].getTema().equals(tema)) {
                return i;
            }
        }
        return -1;
    }
}

