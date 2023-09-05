
import javax.swing.*;

public class Main {
    public static void main(String[] args) throws Exception {

        JOptionPane.showMessageDialog(null, "Seja bem vindo, Crie sua lista com seus games favoritos :) ! ");

        VetorObjeto vetor = new VetorObjeto(10);
        int resp = 0;
        do {
            String valores[] = {"Adicionar um jogo a sua lista", "Buscar um jogo pela posição na lista"
                    , "Buscar um jogo pelo seu nome", "Remover um jogo da lista",
                    "Exibir a lista completa", "sair"};
            Object escolha = JOptionPane.showInputDialog(null, "o que deseja fazer na sua lista?",
                    "Cadastro", JOptionPane.WARNING_MESSAGE,
                    null, valores, valores[0]);
            if (escolha.equals("Adicionar um jogo a sua lista")) {
                adicionaJogo(vetor);

            } else if (escolha.equals("Buscar um jogo pela posição na lista")) {
                int posicao = Integer.parseInt(JOptionPane.showInputDialog("digite a posição na lista que deseja buscar: "));
                if (posicao >= 0 && posicao < vetor.getTamanhoAtual()) {
                    JOptionPane.showMessageDialog(null, "Jogo encontrado na posição " + posicao + ":\n" + " da lista");
                } else {
                    JOptionPane.showMessageDialog(null, "Jogo não encontrado na posição " + posicao);
                }

            } else if (escolha.equals("Buscar um jogo pelo seu nome")) {
                String nome = JOptionPane.showInputDialog("Digite o nome do jogo que deseja procurar: ");
                Jogos jogoEncontrado = vetor.buscaJogoNome(nome);
                if (jogoEncontrado != null) {
                    JOptionPane.showMessageDialog(null, "Jogo encontrado pelo nome '" + nome + "':\n" + jogoEncontrado);
                } else {
                    JOptionPane.showMessageDialog(null, "Jogo não encontrado pelo nome '" + nome + "'");
                }
            } else if (escolha.equals("Remover um jogo da lista")) {
                int posicao = Integer.parseInt(JOptionPane.showInputDialog("Digite qual a posição do jogo que deseja excluir"));
                vetor.removerJogo(posicao);
                JOptionPane.showMessageDialog(null, "Jogo removido com sucesso.");

            } else if (escolha.equals("Exibir a lista completa")) {
                JOptionPane.showMessageDialog(null, vetor.toString());

            }
            resp = JOptionPane.showConfirmDialog(null, "deseja alterar/adicionar alguma coisa na sua lista? ");
        } while (resp == JOptionPane.YES_OPTION);
    }

    public static void adicionaJogo(VetorObjeto vetor) {
        Jogos novo = new Jogos();

        novo.setNomeJogo(JOptionPane.showInputDialog("Digite o nome do jogo: "));
        novo.setAnoJogo(Integer.parseInt(JOptionPane.showInputDialog("Digite o ano de lançamento do jogo: ")));
        novo.setDuracaoJogo(Double.parseDouble(JOptionPane.showInputDialog("DIgite a tempo para finalizar o game:")));
        try {
            vetor.adiciona(novo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
