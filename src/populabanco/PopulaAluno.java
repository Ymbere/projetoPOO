package populabanco;

import to.AlunoTransferObject;
import view.FacadeAlunoController;

public class PopulaAluno {
    public PopulaAluno(FacadeAlunoController controller){

        //Instancia e popula aluno 1
        AlunoTransferObject aluno1 = new AlunoTransferObject();

        aluno1.setNome("Joao");
        aluno1.setRg("31.879.938-8");

        controller.cadastrar_aluno(aluno1);


        //Instancia e popula aluno 2
        AlunoTransferObject aluno2 = new AlunoTransferObject();

        aluno2.setNome("Ricardo");
        aluno2.setRg("44.820.059-4");

        controller.cadastrar_aluno(aluno2);


        //Instancia e popula aluno 3
        AlunoTransferObject aluno3 = new AlunoTransferObject();

        aluno3.setNome("Cleber");
        aluno3.setRg("24.906.902-7");

        controller.cadastrar_aluno(aluno3);


        //Instancia e popula aluno 4
        AlunoTransferObject aluno4 = new AlunoTransferObject();

        aluno4.setNome("Adevaldo");
        aluno4.setRg("11.035.425-4");

        controller.cadastrar_aluno(aluno4);

    }
}
