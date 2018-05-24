package dao;

import controller.FacadeManterProjetoDataAccessObject;
import to.ProjetoTransferObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManterProjetoBanco implements FacadeManterProjetoDataAccessObject {

    private ConexaoBanco conexaoBanco = new ConexaoBanco();

    @Override
    public void cadastrarProjeto(ProjetoTransferObject projetoTO) throws SQLException {
        Connection connection = conexaoBanco.getConnection();
        String sql;
        sql = "INSERT INTO projeto VALUES (?,?,?,?)";
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,projetoTO.getTitulo());
        preparedStatement.setString(2,projetoTO.getResumo());
        preparedStatement.setString(3,projetoTO.getOrientador().getRg());
        preparedStatement.setString(4,projetoTO.getOrientado().getRg());
        preparedStatement.execute();
        preparedStatement.close();
        connection.close();
    }

    @Override
    public void deletaProjeto(String nomeProjeto) throws SQLException {
        Connection connection = conexaoBanco.getConnection();
        String sql;
        sql = "DELETE FROM projeto WHERE titulo_projeto = ?";
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,nomeProjeto);
        preparedStatement.execute();
        preparedStatement.close();
        connection.close();
    }

    @Override
    public void editarProjeto(String nomeProjeto, ProjetoTransferObject projetoTO) throws SQLException {
        Connection connection = conexaoBanco.getConnection();
        String sql;
        sql = "UPDATE projeto SET titulo_projeto=?, resumo=?, rg_professor=?, rg_aluno=? " +
                "WHERE titulo_projeto = ? ";
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,projetoTO.getTitulo());
        preparedStatement.setString(2,projetoTO.getResumo());
        preparedStatement.setString(3,projetoTO.getOrientador().getRg());
        preparedStatement.setString(4,projetoTO.getOrientado().getRg());
        preparedStatement.setString(5,nomeProjeto);
        preparedStatement.execute();
        preparedStatement.close();
        connection.close();
    }

    @Override
    public ProjetoTransferObject retornaUmProjeto(String projetoTitulo) throws SQLException {
        Connection connection = conexaoBanco.getConnection();
        ManterAlunoBanco manterAlunoBanco = new ManterAlunoBanco();
        ManterProfessorBanco manterProfessorBanco = new ManterProfessorBanco();
        ProjetoTransferObject projetoTransferObject = new ProjetoTransferObject();
        String sql;
        sql = "SELECT * FROM projeto WHERE titulo_projeto = ?";
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,projetoTitulo);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            projetoTransferObject.setTitulo(resultSet.getString("titulo_projeto"));
            projetoTransferObject.setResumo(resultSet.getString("resumo"));
            projetoTransferObject.setOrientador(manterProfessorBanco.retornaPorRg
                    (resultSet.getString("rg_professor")));
            projetoTransferObject.setOrientado(manterAlunoBanco.retornaPorRg(resultSet.getString("rg_aluno")));
        }

        preparedStatement.close();
        connection.close();
        return projetoTransferObject;
    }

    @Override
    public ArrayList<ProjetoTransferObject> ordenaERetorna() throws SQLException {
        Connection connection = conexaoBanco.getConnection();
        ManterAlunoBanco manterAlunoBanco = new ManterAlunoBanco();
        ManterProfessorBanco manterProfessorBanco = new ManterProfessorBanco();
        String sql = "SELECT * FROM projeto ORDER BY rg_professor ASC";
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<ProjetoTransferObject> projetoTransferObjects = new ArrayList<>();
        while (resultSet.next()){
            ProjetoTransferObject projetoTransferObject = new ProjetoTransferObject();
            projetoTransferObject.setTitulo(resultSet.getString("titulo_projeto"));
            projetoTransferObject.setResumo(resultSet.getString("resumo"));
            projetoTransferObject.setOrientador(manterProfessorBanco.retornaPorRg
                    (resultSet.getString("rg_professor")));
            projetoTransferObject.setOrientado(manterAlunoBanco.retornaPorRg(resultSet.getString("rg_aluno")));
            projetoTransferObjects.add(projetoTransferObject);
        }

        preparedStatement.close();
        connection.close();
        return projetoTransferObjects;
    }
}
