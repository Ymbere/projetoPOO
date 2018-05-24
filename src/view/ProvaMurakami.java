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
            System.out.println("5 - Sair");
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
            }
        }while (opcao != 5);


    }
}
