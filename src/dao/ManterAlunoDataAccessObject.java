package dao;

import controller.FacadeManterAlunoDataAccessObject;
import to.AlunoTransferObject;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class ManterAlunoDataAccessObject implements FacadeManterAlunoDataAccessObject {

    private ArrayList<AlunoTransferObject> alunosList = new ArrayList<>();

    public void cadastrarAluno(AlunoTransferObject alunoTO){
        alunosList.add(alunoTO);
    }

    public AlunoTransferObject retornaAluno(String nomeAluno){
        Iterator<AlunoTransferObject> aluno = alunosList.iterator();

        AlunoTransferObject retorno = null;

        while (aluno.hasNext()){
            AlunoTransferObject a = aluno.next();
            if (nomeAluno.equals(a.getNome())){
                retorno = a;
            }
        }
        return retorno;
    }

    @Override
    public AlunoTransferObject retornaPorRg(String rg) throws SQLException {
        Iterator<AlunoTransferObject> aluno = alunosList.iterator();

        AlunoTransferObject retorno = null;

        while (aluno.hasNext()){
            AlunoTransferObject a = aluno.next();
            if (rg.equals(a.getRg())){
                retorno = a;
            }
        }
        return retorno;
    }

    @Override
    public void deletarAluno(String rg_aluno) throws SQLException {
        for(AlunoTransferObject aluno: alunosList){
            if(aluno.getRg().equals(rg_aluno)){
                alunosList.remove(aluno);
                break;
            }            
        }    
    }

    @Override
    public void atualizarAluno(String rg_aluno, AlunoTransferObject alunoTO) throws SQLException {
        int index = 0;
        for(AlunoTransferObject aluno: alunosList){
            if(aluno.getRg().equals(rg_aluno)){
                alunosList.get(index).setNome(alunoTO.getNome());
                alunosList.get(index).setRg(alunoTO.getRg());
            }
            index++;
        }
    }

    @Override
    public ArrayList<AlunoTransferObject> retornaAlunos() throws SQLException {
        return alunosList;
    }

}
