package populabanco;

import to.ProjetoTransferObject;
import view.FacadeAlunoController;
import view.FacadeProfessorController;
import view.FacadeProjetoController;

public class PopulaProjetoTeste {
    public PopulaProjetoTeste(FacadeProjetoController manterProjetoController,
                              FacadeProfessorController professorController,
                              FacadeAlunoController alunoController){

        //Instancia e popula primeiro projeto de teste
        ProjetoTransferObject projeto1 = new ProjetoTransferObject();

        projeto1.setOrientado(alunoController.retorna_aluno("Joao"));
        projeto1.setOrientador(professorController.retornaProfessor("Claudio"));
        projeto1.setResumo("Resumo do projeto do aluno Joao e orientador Claudio");
        projeto1.setTitulo("COO");

        manterProjetoController.cadastrarProjeto(projeto1);


        //Instancia e popula segundo projeto de teste
        ProjetoTransferObject projeto2 = new ProjetoTransferObject();

        projeto2.setOrientado(alunoController.retorna_aluno("Ricardo"));
        projeto2.setOrientador(professorController.retornaProfessor("Matheus"));
        projeto2.setResumo("Resumo do projeto do aluno Ricardo e orientador Matheus");
        projeto2.setTitulo("TCC");

        manterProjetoController.cadastrarProjeto(projeto2);


        //Instancia e popula o terceiro projeto de teste
        ProjetoTransferObject projeto3 = new ProjetoTransferObject();

        projeto3.setOrientador(professorController.retornaProfessor("William"));
        projeto3.setOrientado(alunoController.retorna_aluno("Cleber"));
        projeto3.setResumo("Resumo do projeto do aluno William e orientador Cleber");
        projeto3.setTitulo("QWE");

        manterProjetoController.cadastrarProjeto(projeto3);


        //Instancia e popula o quarto projeto de teste
        ProjetoTransferObject projeto4 = new ProjetoTransferObject();

        projeto4.setOrientado(alunoController.retorna_aluno("Adevaldo"));
        projeto4.setOrientador(professorController.retornaProfessor("Claudio"));
        projeto4.setResumo("Resumo do projeto do aluno Adevaldo e orientador Claudio");
        projeto4.setTitulo("POO");

        manterProjetoController.cadastrarProjeto(projeto4);


        //Instancia e popula o quinto projeto teste
        ProjetoTransferObject projeto5 = new ProjetoTransferObject();

        projeto5.setOrientado(alunoController.retorna_aluno("Adevaldo"));
        projeto5.setOrientador(professorController.retornaProfessor("Estevao"));
        projeto5.setResumo("Resumo do projeto do aluno Adevaldo e orientador Estevao");
        projeto5.setTitulo("LLL");

        manterProjetoController.cadastrarProjeto(projeto5);


        //Instancia e popula o sexto projeto teste
        ProjetoTransferObject projeto6 = new ProjetoTransferObject();

        projeto6.setOrientado(alunoController.retorna_aluno("Joao"));
        projeto6.setOrientador(professorController.retornaProfessor("Estevao"));
        projeto6.setResumo("Resumo do projeto do aluno Joao e orientador Estevao");
        projeto6.setTitulo("VVV");

        manterProjetoController.cadastrarProjeto(projeto6);


        //Instancia e popula o projeto 7
        ProjetoTransferObject projeto7 = new ProjetoTransferObject();

        projeto7.setOrientado(alunoController.retorna_aluno("Joao"));
        projeto7.setOrientador(professorController.retornaProfessor("Matheus"));
        projeto7.setResumo("Resumo do projeto do aluno Joao e orientador Matheus");
        projeto7.setTitulo("BBB");

        manterProjetoController.cadastrarProjeto(projeto7);

    }
}
