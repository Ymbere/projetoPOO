package to;

abstract class PessoaTransferObject {
    private String nome;
    private String  rg;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getRg() {
        return rg;
    }
}
