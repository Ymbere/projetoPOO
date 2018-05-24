package dao;

import controller.FacadeManterProjetoDataAccessObject;
import to.ProjetoTransferObject;

import java.util.*;

public class ManterProjetoDataAccessObject implements FacadeManterProjetoDataAccessObject {

    private ArrayList<ProjetoTransferObject> projetoList = new ArrayList<>();

    public void cadastrarProjeto(ProjetoTransferObject projetoTO){
        projetoList.add(projetoTO);
    }

    public void deletaProjeto(String nomeProjeto){
        for(ProjetoTransferObject projeto: projetoList){
            if (projeto.getTitulo().equals(nomeProjeto)){
                projetoList.remove(projeto);
                break;
            }
        }
    }

    public void editarProjeto(String nomeProjeto, ProjetoTransferObject projetoTO){
        int index = 0;
        for(ProjetoTransferObject projeto: projetoList){
            if (projeto.getTitulo().equals(nomeProjeto)){
                projetoList.get(index).setTitulo(projetoTO.getTitulo());
                projetoList.get(index).setOrientado(projeto.getOrientado());
                projetoList.get(index).setResumo(projetoTO.getResumo());
                projetoList.get(index).setOrientador(projetoTO.getOrientador());
            }
            index++;
        }
    }

    public ProjetoTransferObject retornaUmProjeto(String projetoTitulo){
        Iterator<ProjetoTransferObject> projetos = projetoList.iterator();

        ProjetoTransferObject retorno = null;

        while (projetos.hasNext()){
            ProjetoTransferObject p = projetos.next();
            if (projetoTitulo.equals(p.getTitulo())){
                retorno = p;
            }
        }

        return retorno;
    }

    @Override
    public ArrayList<ProjetoTransferObject> ordenaERetorna() {

        Collections.sort(projetoList);

        return projetoList;
    }

}
