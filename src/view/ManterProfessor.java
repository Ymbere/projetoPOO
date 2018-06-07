package view;

import controller.ManterProfessorController;
import to.ProfessorTransferObject;

import java.util.Scanner;

class ManterProfessor {
    private Scanner ler = new Scanner(System.in);

    void cadastraProfessor(){

        FacadeProfessorController professorController = new ManterProfessorController();

        String nome;
        String rg;
        String titulo;
        System.out.println("Digite o nome do professor a ser cadastrado");
        nome = ler.nextLine();
        System.out.println("Digite o RG do professor a ser cadastrado");
        rg = ler.nextLine();
        System.out.println("Digite o titulo do professor a ser cadastrado");
        titulo = ler.nextLine();

        ProfessorTransferObject professor = new ProfessorTransferObject();
        professor.setNome(nome);
        professor.setRg(rg);
        professor.setTitulo(titulo);

        professorController.cadastratProfessor(professor);

    }

    void retornaProfessor(){

        FacadeProfessorController professorController = new ManterProfessorController();

        String nome;
        System.out.println("Digite o nome do aluno que deseja retornar");
        nome = ler.nextLine();

        ProfessorTransferObject professor_retornado;
        professor_retornado = professorController.retornaProfessor(nome);

        System.out.println("Nome: " + professor_retornado.getNome());
        System.out.println("RG: " + professor_retornado.getRg());
        System.out.println("Titulo: " + professor_retornado.getTitulo());

    }

    void editaProfessor(){

        FacadeProfessorController professorController = new ManterProfessorController();

        String rg;
        String novo_nome;
        String titulo;
        System.out.println("Digite o RG do professor que deseja retornar");
        rg = ler.nextLine();

        ProfessorTransferObject professor_retornado;
        professor_retornado = professorController.retornaPorRg(rg);

        System.out.println("Digite o novo nome para o professor | atual:  " + professor_retornado.getNome());
        novo_nome = ler.nextLine();
        System.out.println("Digite o novo titulo para o professor retornado | atual: " + professor_retornado.getTitulo());
        titulo = ler.nextLine();

        ProfessorTransferObject professor_atualizado = new ProfessorTransferObject();
        professor_atualizado.setNome(novo_nome);
        professor_atualizado.setTitulo(titulo);
        professor_atualizado.setRg(professor_retornado.getRg());

        professorController.editaProfessor(rg, professor_atualizado);

    }

    void deletaProfessor(){

        FacadeProfessorController professorController = new ManterProfessorController();

        String rg;
        System.out.println("Digite o RG do professor que deseja deletar");
        rg = ler.nextLine();

        professorController.deletaProfessor(rg);
    }
}
