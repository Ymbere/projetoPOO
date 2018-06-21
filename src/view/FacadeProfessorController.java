package view;

import java.util.ArrayList;
import to.ProfessorTransferObject;

public interface FacadeProfessorController {

    void cadastratProfessor(ProfessorTransferObject professorTO);

    ProfessorTransferObject retornaProfessor(String nomeProfessor);

    ProfessorTransferObject retornaPorRg(String rg_professor);

    void editaProfessor(String rg_professor, ProfessorTransferObject professorTO);

    void deletaProfessor(String rg_professor);
    
    ArrayList<ProfessorTransferObject> retornaProfessores();

}
