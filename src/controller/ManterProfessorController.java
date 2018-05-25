package controller;

import dao.ManterProfessorBanco;
import dao.ManterProfessorDataAccessObject;
import to.ProfessorTransferObject;
import view.FacadeProfessorController;

import java.sql.SQLException;

public class ManterProfessorController implements FacadeProfessorController {

    private FacadeManterProfessorDataAccessObject dao = new ManterProfessorBanco();

    @Override
    public void cadastratProfessor(ProfessorTransferObject professorTO) {
        try {
            dao.cadastrarProfessor(professorTO);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ProfessorTransferObject retornaProfessor(String nomeProfessor) {
        try {
            return dao.retornaProfessor(nomeProfessor);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ProfessorTransferObject retornaPorRg(String rg_professor) {
        try {
            return dao.retornaPorRg(rg_professor);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void editaProfessor(String rg_professor, ProfessorTransferObject professorTO) {
        try {
            dao.atualizaProfessor(rg_professor,professorTO);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void deletaProfessor(String rg_professor) {
        try{
            dao.deletaProfessor(rg_professor);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

}
