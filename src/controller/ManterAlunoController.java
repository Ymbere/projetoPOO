package controller;


import dao.ManterAlunoBanco;
import dao.ManterAlunoDataAccessObject;
import view.FacadeAlunoController;
import to.AlunoTransferObject;

import java.sql.SQLException;
import java.util.ArrayList;

public class ManterAlunoController implements FacadeAlunoController {

    private FacadeManterAlunoDataAccessObject dao = new ManterAlunoDataAccessObject();

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

    @Override
    public void deletar_aluno(String rg_aluno) {
        try {
            dao.deletarAluno(rg_aluno);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void editar_aluno(String rg, AlunoTransferObject alunoTO) {
        try{
            dao.atualizarAluno(rg, alunoTO);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public AlunoTransferObject retorna_por_rg(String rg_aluno) {
        try{
            return dao.retornaPorRg(rg_aluno);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<AlunoTransferObject> retornaAlunos() {
        try {
            return dao.retornaAlunos();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
