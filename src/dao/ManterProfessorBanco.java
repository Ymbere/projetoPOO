package dao;

import controller.FacadeManterProfessorDataAccessObject;
import to.ProfessorTransferObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManterProfessorBanco implements FacadeManterProfessorDataAccessObject {

    private ConexaoBanco conexaoBanco = new ConexaoBanco();

    @Override
    public void cadastrarProfessor(ProfessorTransferObject professorTO) throws SQLException {
        Connection connection = conexaoBanco.getConnection();
        String sql;
        sql = "INSERT INTO professor VALUES (?,?,?)";
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,professorTO.getNome());
        preparedStatement.setString(2,professorTO.getRg());
        preparedStatement.setString(3,professorTO.getTitulo());
        preparedStatement.execute();
        preparedStatement.close();

    }

    @Override
    public ProfessorTransferObject retornaProfessor(String nomeProfessor) throws SQLException {
        Connection connection = conexaoBanco.getConnection();
        ProfessorTransferObject professorTransferObject = new ProfessorTransferObject();
        String sql;
        sql = "SELECT * FROM public.professor WHERE nome = ?";
        PreparedStatement preparedStatement;
        preparedStatement= connection.prepareStatement(sql);
        preparedStatement.setString(1,nomeProfessor);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            professorTransferObject.setNome(resultSet.getString("nome"));
            professorTransferObject.setRg(resultSet.getString("rg"));
            professorTransferObject.setTitulo(resultSet.getString("titulo"));
        }

        preparedStatement.close();

        return professorTransferObject;

    }

    @Override
    public ProfessorTransferObject retornaPorRg(String rg) throws SQLException {
        Connection connection = conexaoBanco.getConnection();
        ProfessorTransferObject professorTransferObject = new ProfessorTransferObject();
        String sql;
        sql = "SELECT * FROM public.professor WHERE rg = ?";
        PreparedStatement preparedStatement;
        preparedStatement= connection.prepareStatement(sql);
        preparedStatement.setString(1,rg);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            professorTransferObject.setNome(resultSet.getString("nome"));
            professorTransferObject.setRg(resultSet.getString("rg"));
            professorTransferObject.setTitulo(resultSet.getString("titulo"));
        }

        preparedStatement.close();

        return professorTransferObject;
    }

    @Override
    public void deletaProfessor(String rg_professor) throws SQLException {
        Connection connection = conexaoBanco.getConnection();
        ProfessorTransferObject professorTransferObject = new ProfessorTransferObject();
        String sql;
        sql = "DELETE FROM professor WHERE rg = ?";
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,rg_professor);
        preparedStatement.execute();
        preparedStatement.close();
    }

    @Override
    public void atualizaProfessor(String rg_professor, ProfessorTransferObject professorTO) throws SQLException {
        Connection connection = conexaoBanco.getConnection();
        String sql;
        sql = "UPDATE professor SET nome= ?, titulo= ? WHERE rg = ?";
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,professorTO.getNome());
        preparedStatement.setString(2,professorTO.getTitulo());
        preparedStatement.setString(3,rg_professor);
        preparedStatement.execute();
        preparedStatement.close();

    }
}
