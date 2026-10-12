import java.util.ArrayList;
import java.util.List;

/**
 * Registro de resumos de estudo com capacidade limitada.
 *
 * Quando a capacidade e atingida, o resumo mais antigo e substituido pelo
 * novo. Nao existe mais de um resumo com o mesmo tema: adicionar um tema ja
 * cadastrado apenas atualiza o conteudo do resumo existente.
 */
public class RegistraResumos {
    private final int capacidade;
    private final List<Resumo> itens;

    /**
     * Cria um registro com a capacidade informada.
     *
     * @param numeroDeResumos quantidade maxima de resumos (pelo menos 1).
     * @throws IllegalArgumentException se a capacidade for menor que 1.
     */
    public RegistraResumos(int numeroDeResumos) {
        if (numeroDeResumos < 1) {
            throw new IllegalArgumentException("capacidade invalida");
        }
        this.capacidade = numeroDeResumos;
        this.itens = new ArrayList<>();
    }

    /**
     * Adiciona um resumo. Se o tema ja existir, apenas o conteudo e atualizado;
     * se o registro estiver cheio, o resumo mais antigo e removido.
     *
     * @param tema tema do resumo.
     * @param conteudo conteudo do resumo.
     */
    public void adiciona(String tema, String conteudo) {
        Resumo existente = localiza(tema);
        if (existente != null) {
            existente.setTexto(conteudo);
            return;
        }
        if (itens.size() == capacidade) {
            itens.remove(0);
        }
        itens.add(new Resumo(tema, conteudo));
    }

    /**
     * Retorna os resumos cadastrados, do mais antigo ao mais novo, cada um no
     * formato "tema: conteudo".
     *
     * @return array com os resumos cadastrados.
     */
    public String[] pegaResumos() {
        return itens.stream().map(Resumo::toString).toArray(String[]::new);
    }

    /**
     * Gera um texto com a quantidade de resumos e a lista de seus temas
     * separados por " | ".
     *
     * @return texto com a quantidade e os temas dos resumos.
     */
    public String imprimeResumos() {
        List<String> titulos = new ArrayList<>();
        for (Resumo resumo : itens) {
            titulos.add(resumo.getTitulo());
        }
        return "- " + conta() + " resumo(s) cadastrado(s)\n- " + String.join(" | ", titulos);
    }

    /**
     * Retorna quantos resumos estao armazenados no momento.
     *
     * @return quantidade de resumos.
     */
    public int conta() {
        return itens.size();
    }

    /**
     * Verifica se existe um resumo com o tema informado.
     *
     * @param tema tema procurado.
     * @return true se existir um resumo com esse tema.
     */
    public boolean temResumo(String tema) {
        return localiza(tema) != null;
    }

    /**
     * Busca resumos cujo conteudo contem a chave, ignorando maiusculas e
     * minusculas.
     *
     * @param chaveDeBusca texto procurado no conteudo dos resumos.
     * @return temas dos resumos encontrados, em ordem alfabetica.
     */
    public String[] busca(String chaveDeBusca) {
        String alvo = chaveDeBusca.toLowerCase();
        return itens.stream()
                .filter(resumo -> resumo.getTexto().toLowerCase().contains(alvo))
                .map(Resumo::getTitulo)
                .sorted()
                .toArray(String[]::new);
    }

    private Resumo localiza(String tema) {
        for (Resumo resumo : itens) {
            if (resumo.getTitulo().equals(tema)) {
                return resumo;
            }
        }
        return null;
    }
}
