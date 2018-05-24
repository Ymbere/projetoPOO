package view;

import to.ProjetoTransferObject;

import java.util.ArrayList;
import java.util.List;

public interface FacadeProjetoController {

    void cadastrarProjeto(ProjetoTransferObject projetoTO);

    void deletaProjeto(String nomeProjeto);

    void editarProjeto(String nomeProjeto, ProjetoTransferObject projetoTO);

    ProjetoTransferObject retornaProjeto(String projetoTitulo);

    ArrayList<ProjetoTransferObject> ordenaERetorna();

}
