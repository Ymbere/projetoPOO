package view;

import java.util.ArrayList;
import to.AlunoTransferObject;
import to.ProjetoTransferObject;

public interface FacadeAlunoController {

    void cadastrar_aluno(AlunoTransferObject alunoTO);

    AlunoTransferObject retorna_aluno(String nomeAluno);

    void deletar_aluno(String rg_aluno);

    void editar_aluno(String rg, AlunoTransferObject alunoTO);

    AlunoTransferObject retorna_por_rg(String rg_aluno);
    
    ArrayList<AlunoTransferObject> retornaAlunos();

}
