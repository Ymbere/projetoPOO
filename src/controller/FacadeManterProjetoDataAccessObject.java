package controller;

import to.ProjetoTransferObject;

import java.sql.SQLException;
import java.util.ArrayList;

public interface FacadeManterProjetoDataAccessObject {

    void cadastrarProjeto(ProjetoTransferObject projetoTO) throws SQLException;

    void deletaProjeto(String nomeProjeto) throws SQLException;

    void editarProjeto(String nomeProjeto, ProjetoTransferObject projetoTO) throws SQLException;

    ProjetoTransferObject retornaUmProjeto(String projetoTitulo) throws SQLException;

    ArrayList<ProjetoTransferObject> ordenaERetorna() throws SQLException;
}
