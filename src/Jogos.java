public class Jogos {
    private String nomeJogo;
    private int anoJogo;
    private double duracaoJogo;

    public Jogos() {
    }

    public Jogos(String nomeJogo, int anoJogo, double duracaoJogo) {
        this.nomeJogo = nomeJogo;
        this.anoJogo = anoJogo;
        this.duracaoJogo = duracaoJogo;
    }

    public String getNomeJogo() {
        return this.nomeJogo;
    }

    public void setNomeJogo(String nomeJogo) {
        this.nomeJogo = nomeJogo;
    }

    public int getAnoJogo() {
        return this.anoJogo;
    }

    public void setAnoJogo(int anoJogo) {
        this.anoJogo = anoJogo;
    }

    public double getDuracaoJogo() {
        return this.duracaoJogo;
    }

    public void setDuracaoJogo(double duracaoJogo) {
        this.duracaoJogo = duracaoJogo;
    }

    @Override
    public String toString() {
        return " \n" +
                " Nome do jogo: " + getNomeJogo() + " \n" +
                " Ano de lançamento do jogo: " + getAnoJogo() + " \n" +
                " duracao em horas do jogo: " + getDuracaoJogo() + " horas \n";
    }
}
