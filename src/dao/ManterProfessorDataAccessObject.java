package dao;

import controller.FacadeManterProfessorDataAccessObject;
import to.ProfessorTransferObject;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class ManterProfessorDataAccessObject implements FacadeManterProfessorDataAccessObject {

    private ArrayList<ProfessorTransferObject> professorList = new ArrayList<>();

    public void cadastrarProfessor(ProfessorTransferObject professorTO){
        professorList.add(professorTO);
    }

    public ProfessorTransferObject retornaProfessor(String nomeProfessor){
        Iterator<ProfessorTransferObject> professor = professorList.iterator();

        ProfessorTransferObject retorno = null;

        while (professor.hasNext()){
            ProfessorTransferObject p = professor.next();
            if (nomeProfessor.equals(p.getNome())){
                retorno = p;
            }
        }
        return retorno;
    }

    @Override
    public ProfessorTransferObject retornaPorRg(String rg) throws SQLException {
        Iterator<ProfessorTransferObject> professor = professorList.iterator();

        ProfessorTransferObject retorno = null;

        while (professor.hasNext()){
            ProfessorTransferObject p = professor.next();
            if (rg.equals(p.getRg())){
                retorno = p;
            }
        }
        return retorno;
    }

    @Override
    public void deletaProfessor(String rg_professor) throws SQLException {  
        for(ProfessorTransferObject professor: professorList){
            if(professor.getRg().equals(rg_professor)){
                professorList.remove(professor);
                break;
            }
        }            
    }

    @Override
    public void atualizaProfessor(String rg_professor, ProfessorTransferObject professorTO) throws SQLException {
        int index = 0;
        for(ProfessorTransferObject professor: professorList){
            if(professor.getRg().equals(rg_professor)){
                professorList.get(index).setNome(professorTO.getNome());
                professorList.get(index).setRg(professorTO.getRg());
                professorList.get(index).setTitulo(professorTO.getTitulo());
            }
            index++;
        }
    }

    @Override
    public ArrayList<ProfessorTransferObject> retornaProfessores() throws SQLException { 
        return professorList;
    }

}
