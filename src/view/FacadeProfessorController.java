package view;

import to.ProfessorTransferObject;

public interface FacadeProfessorController {

    void cadastratProfessor(ProfessorTransferObject professorTO);

    ProfessorTransferObject retornaProfessor(String nomeProfessor);

}
