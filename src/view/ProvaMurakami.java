package view;

import controller.ManterAlunoController;
import controller.ManterProfessorController;
import controller.ManterProjetoController;
import populabanco.*;



import java.util.Scanner;

public class ProvaMurakami {

    //Tudo que vier aqui é associação

    public static void main(String[] args){
        //Tudo o que vier aqui é dependencia

        Scanner ler = new Scanner(System.in);
        int opcao;
        ManterProjeto projeto = new ManterProjeto();
        ManterAluno aluno = new ManterAluno();

        FacadeProfessorController manterProfessorController = new ManterProfessorController();

        FacadeAlunoController manterAlunoController = new ManterAlunoController();

        FacadeProjetoController manterProjetoController = new ManterProjetoController();


        new PopulaAluno(manterAlunoController);
        new PopulaProfessor(manterProfessorController);
        new PopulaProjetoTeste(manterProjetoController,manterProfessorController,manterAlunoController);


        do {
            System.out.println("Digite apcao desejada");
            System.out.println("1 - Cadastrar Projeto");
            System.out.println("2 - Retornar Projetos");
            System.out.println("3 - Atualizar projeto");
            System.out.println("4 - Deletar Projeto");
            System.out.println("5 - Cadastrar Aluno");
            System.out.println("6 - Retornar Aluno");
            System.out.println("7 - Atualizar Aluno");
            System.out.println("8 - Deletar Aluno");
            System.out.println("9 - Sair");
            opcao = ler.nextInt();
            switch (opcao){
                case 1:
                    projeto.cadastrarProjeto(manterAlunoController, manterProfessorController, manterProjetoController);
                    break;
                case 2:
                    projeto.retornarProjeto(manterProjetoController);
                    break;
                case 3:
                    projeto.atualizaProjeto(manterProjetoController, manterProfessorController, manterAlunoController);
                    break;
                case 4:
                    projeto.deletaProjeto(manterProjetoController);
                    break;
                case 5:
                    aluno.cadastraAluno(manterAlunoController);
                    break;
                case 6:
                    aluno.retornaAluno(manterAlunoController);
                    break;
                case 7:
                    aluno.editaAluno(manterAlunoController);
                    break;
                case 8:
                    aluno.deletaAluno(manterAlunoController);
                    break;
            }
        }while (opcao != 9);


    }
}
