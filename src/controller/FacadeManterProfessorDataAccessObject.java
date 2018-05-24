package controller;


import to.ProfessorTransferObject;

import java.sql.SQLException;

public interface FacadeManterProfessorDataAccessObject {

    void cadastrarProfessor(ProfessorTransferObject professorTO) throws SQLException;

    ProfessorTransferObject retornaProfessor(String nomeProfessor) throws SQLException;

    ProfessorTransferObject retornaPorRg(String rg) throws SQLException;

}
