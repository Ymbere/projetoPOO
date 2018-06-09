package controller;

import to.AlunoTransferObject;

import java.sql.SQLException;
import java.util.ArrayList;

public interface FacadeManterAlunoDataAccessObject {

    void cadastrarAluno(AlunoTransferObject alunoTO) throws SQLException;

    AlunoTransferObject retornaAluno(String nomeAluno) throws SQLException;

    AlunoTransferObject retornaPorRg(String rg) throws  SQLException;

    void deletarAluno(String rg_aluno) throws SQLException;

    void atualizarAluno(String rg_aluno, AlunoTransferObject alunoTO) throws SQLException;
    
    ArrayList<AlunoTransferObject> retornaAlunos() throws SQLException;
}
