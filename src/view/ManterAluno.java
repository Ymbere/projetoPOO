package view;

import controller.ManterAlunoController;
import to.AlunoTransferObject;
import java.util.Scanner;

class ManterAluno {
    private Scanner ler = new Scanner(System.in);

    void cadastraAluno(FacadeAlunoController alunoController){


        String nome;
        String rg;
        System.out.println("Digite o nome do aluno a ser cadastrado");
        nome = ler.nextLine();
        System.out.println("Digite o RG do aluno a ser cadastrado");
        rg = ler.nextLine();

        AlunoTransferObject aluno = new AlunoTransferObject();
        aluno.setNome(nome);
        aluno.setRg(rg);

        alunoController.cadastrar_aluno(aluno);
    }

    void retornaAluno(FacadeAlunoController alunoController){



        String nome;
        System.out.println("Digite o nome do aluno que deseja retornar");
        nome = ler.nextLine();

        AlunoTransferObject aluno_retornado;
        aluno_retornado = alunoController.retorna_aluno(nome);

        System.out.println("Nome: " + aluno_retornado.getNome());
        System.out.println("RG: " + aluno_retornado.getRg());
    }

    void editaAluno(FacadeAlunoController alunoController){



        String rg;
        String novo_nome;
        System.out.println("Digite o RG do aluno que deseja retornar");
        rg = ler.nextLine();

        AlunoTransferObject aluno_retornado;
        aluno_retornado = alunoController.retorna_por_rg(rg);

        System.out.println("Digite o novo nome para o aluno | atual:  " + aluno_retornado.getNome());
        novo_nome = ler.nextLine();

        AlunoTransferObject aluno_atualizado = new AlunoTransferObject();
        aluno_atualizado.setNome(novo_nome);
        aluno_atualizado.setRg(aluno_retornado.getRg());

        alunoController.editar_aluno(rg, aluno_atualizado);
    }

    void deletaAluno(FacadeAlunoController alunoController){



        String rg;
        System.out.println("Digite o RG do aluno que deseja deletar");
        rg = ler.nextLine();

        alunoController.deletar_aluno(rg);
    }
}
