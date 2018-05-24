package view;

import to.AlunoTransferObject;

public interface FacadeAlunoController {

    void cadastrar_aluno(AlunoTransferObject alunoTO);

    AlunoTransferObject retorna_aluno(String nomeAluno);

}
