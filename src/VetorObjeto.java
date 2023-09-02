public class VetorObjeto extends Jogos {
    private Object[] elementos;
    private int tamanho;


    public VetorObjeto() {
    }

    public VetorObjeto(String nomeJogo, int anoJogo, double duracaoJogo) {
        super(nomeJogo, anoJogo, duracaoJogo);
    }

    public VetorObjeto(int capacidade){
        this.elementos = new Object[capacidade];
        this.tamanho = 0;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void adiciona (Object elemento) throws Exception{
        this.aumentaCapacidade();
        if(this.tamanho < this.elementos.length){
            this.elementos[this.tamanho] = elemento;
            this.tamanho++;
        }else{
            throw new Exception ("o sua lista ja esta cheia, " + "não e possivel adicionar novos jogos");
        }
    }

    public int tamanho(){
        return this.tamanho;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(" ");

        for (int i = 0; i < this.tamanho-1; i++) {
            s.append(this.elementos[i]);
            s.append(" ");
        }

        if(this.tamanho >0) {
            s.append(this.elementos[this.tamanho-1]);
        }

        s.append(" ");

        return s.toString();
    }

    public Object buscaJogosPosicao(int posicao) throws Exception {
        if(posicao >=0 && posicao < tamanho) {
            return elementos[posicao];
        }else{
            throw new Exception("posição nao encontrada");
        }
    }

    public Jogos buscaJogoNome(String nome) {
        for (int i = 0; i < tamanho; i++) {
            if (elementos[i] instanceof Jogos) {
                Jogos jogo = (Jogos) elementos[i];
                if (jogo.getNomeJogo().equalsIgnoreCase(nome)) {
                    return jogo;
                }
            }
        }
        return null;
    }
    public boolean adicionaInicio(int posicao, Object elemento) throws Exception {
        this.aumentaCapacidade();
        if(posicao >= 0 && posicao < tamanho) {
            for (int i = this.tamanho; i>posicao ; i--) {
                this.elementos[i+1] = this.elementos[i];
            }
            this.elementos[posicao] = elemento;
            this.tamanho++;
        }else{
            throw new Exception("posição imvalida");
        }
        return true;
    }

    private void aumentaCapacidade() {
        if(this.tamanho == this.elementos.length){
            Object[] elementosNovos = new String[this.elementos.length *2];
            for (int i = 0; i < this.elementos.length; i++) {
                elementosNovos[i] = this.elementos[i];
            }
            this.elementos = elementosNovos;
        }
    }

    public void removerJogo(int posicao) throws Exception{
        if(posicao >= 0 && posicao < tamanho) {
            for (int i = posicao; i < this.tamanho; i++) {
                this.elementos[i] = this.elementos[i+1];
            }
            this.tamanho--;
        }else {
            throw new Exception("posição invalida");
        }
    }

    public int getTamanhoAtual() {
        return this.tamanho();
    }
}
