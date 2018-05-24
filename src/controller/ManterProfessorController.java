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

}
