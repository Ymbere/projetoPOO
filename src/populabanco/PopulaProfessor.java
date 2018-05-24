package populabanco;

import to.ProfessorTransferObject;
import view.FacadeProfessorController;

public class PopulaProfessor {
    public PopulaProfessor(FacadeProfessorController controller){

        //Instancia e popula professor 1
        ProfessorTransferObject professor1 = new ProfessorTransferObject();

        professor1.setNome("Claudio");
        professor1.setRg("22.918.536-8");
        professor1.setTitulo("Doutor");

        controller.cadastratProfessor(professor1);


        //Instancia e popula professor 2
        ProfessorTransferObject professor2 = new ProfessorTransferObject();

        professor2.setNome("Matheus");
        professor2.setRg("10.186.734-7");
        professor2.setTitulo("Tecnologo");

        controller.cadastratProfessor(professor2);


        //Instancia e popula professor 3
        ProfessorTransferObject professor3 = new ProfessorTransferObject();

        professor3.setNome("William");
        professor3.setRg("45.764.099-6");
        professor3.setTitulo("Bacharel");

        controller.cadastratProfessor(professor3);


        //Instancia e popula professor 4
        ProfessorTransferObject professor4 = new ProfessorTransferObject();

        professor4.setNome("Fabio");
        professor4.setRg("49.809.055-3");
        professor4.setTitulo("Major");

        controller.cadastratProfessor(professor4);


        //Instancia e popula o quinto professor
        ProfessorTransferObject professor5 = new ProfessorTransferObject();

        professor5.setNome("Marcio");
        professor5.setRg("11.111.111-1");
        professor5.setTitulo("Nao sei");

        controller.cadastratProfessor(professor5);


        //Instancia e popula o sexto professor

        ProfessorTransferObject professor6 = new ProfessorTransferObject();
        professor6.setNome("Estevao");
        professor6.setRg("99.999.999-9");
        professor6.setTitulo("Deus");

        controller.cadastratProfessor(professor6);

    }
}
