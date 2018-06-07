package view;

import controller.ManterAlunoController;
import controller.ManterProfessorController;
import controller.ManterProjetoController;
import to.ProjetoTransferObject;
import java.util.ArrayList;
import java.util.Scanner;

class ManterProjeto {
    private Scanner ler = new Scanner(System.in);

    void cadastrarProjeto(){

        FacadeProfessorController professorController = new ManterProfessorController();

        FacadeAlunoController alunoController = new ManterAlunoController();

        FacadeProjetoController manterProjetoController = new ManterProjetoController();


        String projeoTitulo;
        String resumo;
        String orientador;
        String orientado;
        System.out.println("Digite o titulo do projeto");
        projeoTitulo = ler.nextLine();
        System.out.println("Digite o resumo do projeto");
        resumo = ler.nextLine();
        System.out.println("Digite o professor orientador");
        orientador = ler.nextLine();
        System.out.println("Digite o nome do orientado");
        orientado = ler.nextLine();

        ProjetoTransferObject projeto = new ProjetoTransferObject();
        projeto.setTitulo(projeoTitulo);
        projeto.setResumo(resumo);
        projeto.setOrientador(professorController.retornaProfessor(orientador));
        projeto.setOrientado(alunoController.retorna_aluno(orientado));

        manterProjetoController.cadastrarProjeto(projeto);

    }

    void retornarProjeto(){

        FacadeProjetoController manterProjetoController = new ManterProjetoController();

        System.out.println("$$$$$$$$$$$$$$$$$$$ Relatorio de projetos $$$$$$$$$$$$$$$$$$$");

        int projetosSize = manterProjetoController.ordenaERetorna().size();
        ArrayList<ProjetoTransferObject> projetos = manterProjetoController.ordenaERetorna();
        String temp1;
        String temp2;


        for (int i = 0; i < projetosSize; i++){

            int j = i;
            int repeticao = 0;

            while (true){
                temp1 = projetos.get(j).getOrientador().getNome();
                if (j+1 == projetosSize){
                    break;
                }
                else {
                    temp2 = projetos.get(j+1).getOrientador().getNome();
                }
                if (temp1.equals(temp2)){
                    repeticao++;
                    j++;
                }
                else {
                    break;
                }
            }

            System.out.println("########################################################");
            System.out.println("Nome: " + projetos.get(i).getOrientador().getNome());
            System.out.println("--------------------------------------------------------");

            int x = i;
            i = i +repeticao;
            while (repeticao >= 0){
                System.out.println("Titulo do projeto: " + projetos.get(x).getTitulo() + "| Orientado: " +
                        projetos.get(x).getOrientado().getNome());

                System.out.println("--------------------------------------------------------");
                x++;
                repeticao--;
            }

            System.out.println("########################################################");

        }
    }

    void atualizaProjeto(){

        FacadeProfessorController professorController = new ManterProfessorController();

        FacadeAlunoController alunoController = new ManterAlunoController();

        FacadeProjetoController manterProjetoController = new ManterProjetoController();



        String titulo;
        String projeoTitulo;
        String resumo;
        String orientador;
        String orientado;
        ProjetoTransferObject projetoEstadoAtual;
        System.out.println("Digite o titulo do projeto a ser editado para ser atualizado");
        titulo = ler.nextLine();

        projetoEstadoAtual = manterProjetoController.retornaProjeto(titulo);

        System.out.println("Digite o titulo do projeto | titulo autal: " + projetoEstadoAtual.getTitulo());
        projeoTitulo = ler.nextLine();
        System.out.println("Digite o resumo do projeto | resumo atual: " + projetoEstadoAtual.getResumo());
        resumo = ler.nextLine();
        System.out.println("Digite o professor orientador | professor autal: " + projetoEstadoAtual.getOrientador().getNome());
        orientador = ler.nextLine();
        System.out.println("Digite o nome do orientado | orientado atual: " + projetoEstadoAtual.getOrientado().getNome());
        orientado = ler.nextLine();

        ProjetoTransferObject projeto = new ProjetoTransferObject();
        projeto.setTitulo(projeoTitulo);
        projeto.setResumo(resumo);
        projeto.setOrientador(professorController.retornaProfessor(orientador));
        projeto.setOrientado(alunoController.retorna_aluno(orientado));

        manterProjetoController.editarProjeto(titulo, projeto);

    }

    void deletaProjeto(){

        FacadeProjetoController manterProjetoController = new ManterProjetoController();

        String titulo;
        System.out.println("Digite o titulo do projeto que deseja deletar");
        titulo = ler.nextLine();
        manterProjetoController.deletaProjeto(titulo);
    }

}
