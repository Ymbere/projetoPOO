package controller;


import to.ProfessorTransferObject;

import java.sql.SQLException;
import java.util.ArrayList;


public interface FacadeManterProfessorDataAccessObject {

    void cadastrarProfessor(ProfessorTransferObject professorTO) throws SQLException;

    ProfessorTransferObject retornaProfessor(String nomeProfessor) throws SQLException;

    ProfessorTransferObject retornaPorRg(String rg) throws SQLException;

    void deletaProfessor(String rg_professor) throws SQLException;

    void atualizaProfessor(String rg_professor, ProfessorTransferObject professorTO) throws SQLException;
    
    ArrayList<ProfessorTransferObject> retornaProfessores() throws SQLException;

}
