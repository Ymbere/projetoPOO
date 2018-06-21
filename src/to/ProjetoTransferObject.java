package to;

public class ProjetoTransferObject implements Comparable<ProjetoTransferObject> {
    private  String titulo;
    private String resumo;
    private ProfessorTransferObject orientador;
    private AlunoTransferObject orientado;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public AlunoTransferObject getOrientado() {
        return orientado;
    }

    public void setOrientado(AlunoTransferObject orientado) {
        this.orientado = orientado;
    }

    public ProfessorTransferObject getOrientador() {
        return orientador;
    }

    public void setOrientador(ProfessorTransferObject orientador) {
        this.orientador = orientador;
    }

    @Override
    public int compareTo(ProjetoTransferObject outroProjeto) {
        int a = Integer.parseInt(this.getOrientador().getRg().
                replace(".", "").replace("-", ""));
        int b = Integer.parseInt(outroProjeto.getOrientador().getRg().
                replace(".", "").replace("-", ""));
        if (a > b){
            return  -1;
        }
        if (a < b) {
            return 1;
        }
        return 0;
    }
}