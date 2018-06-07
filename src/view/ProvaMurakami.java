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
        ManterProfessor professor = new ManterProfessor();

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
            System.out.println("9 - Cadastrar Professor");
            System.out.println("10 - Retornar Professor");
            System.out.println("11 - Atualizar Professor");
            System.out.println("12 - Deletar Professor");
            System.out.println("13 - Sair");
            opcao = ler.nextInt();
            switch (opcao){
                case 1:
                    projeto.cadastrarProjeto();
                    break;
                case 2:
                    projeto.retornarProjeto();
                    break;
                case 3:
                    projeto.atualizaProjeto();
                    break;
                case 4:
                    projeto.deletaProjeto();
                    break;
                case 5:
                    aluno.cadastraAluno();
                    break;
                case 6:
                    aluno.retornaAluno();
                    break;
                case 7:
                    aluno.editaAluno();
                    break;
                case 8:
                    aluno.deletaAluno();
                    break;
                case 9:
                    professor.cadastraProfessor();
                    break;
                case 10:
                    professor.retornaProfessor();
                    break;
                case 11:
                    professor.editaProfessor();
                    break;
                case 12:
                    professor.deletaProfessor();
                    break;
            }
        }while (opcao != 13);


    }
}
