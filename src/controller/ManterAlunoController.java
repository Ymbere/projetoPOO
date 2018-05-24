package controller;


import dao.ManterAlunoBanco;
import dao.ManterAlunoDataAccessObject;
import view.FacadeAlunoController;
import to.AlunoTransferObject;

import java.sql.SQLException;

public class ManterAlunoController implements FacadeAlunoController {

    private FacadeManterAlunoDataAccessObject dao = new ManterAlunoBanco();

    @Override
    public void cadastrar_aluno(AlunoTransferObject alunoTO) {
        try {
            dao.cadastrarAluno(alunoTO);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public AlunoTransferObject retorna_aluno(String nomeAluno) {
        try {
            return dao.retornaAluno(nomeAluno);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
