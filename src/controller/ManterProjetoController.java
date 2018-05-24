package controller;

import dao.ManterProjetoBanco;
import dao.ManterProjetoDataAccessObject;
import view.FacadeProjetoController;
import to.ProjetoTransferObject;

import java.sql.SQLException;
import java.util.ArrayList;


public class ManterProjetoController implements FacadeProjetoController {

    private FacadeManterProjetoDataAccessObject dao = new ManterProjetoBanco();

    @Override
    public void cadastrarProjeto(ProjetoTransferObject projetoTO) {
        try {
            dao.cadastrarProjeto(projetoTO);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletaProjeto(String nomeProjeto) {
        try {
            dao.deletaProjeto(nomeProjeto);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editarProjeto(String nomeProjeto, ProjetoTransferObject projetoTO) {
        try {
            dao.editarProjeto(nomeProjeto, projetoTO);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ProjetoTransferObject retornaProjeto(String projetoTitulo) {
        try {
            return dao.retornaUmProjeto(projetoTitulo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<ProjetoTransferObject> ordenaERetorna() {
        try {
            return dao.ordenaERetorna();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
