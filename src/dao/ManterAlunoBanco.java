package dao;

import controller.FacadeManterAlunoDataAccessObject;
import to.AlunoTransferObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManterAlunoBanco implements FacadeManterAlunoDataAccessObject {

    private ConexaoBanco conexaoBanco = new ConexaoBanco();

    @Override
    public void cadastrarAluno(AlunoTransferObject alunoTO) throws SQLException {
        Connection connection = conexaoBanco.getConnection();
        String sql;
        sql = "INSERT INTO aluno VALUES (?,?)";
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,alunoTO.getNome());
        preparedStatement.setString(2,alunoTO.getRg());
        preparedStatement.execute();
        preparedStatement.close();
        connection.close();
    }

    @Override
    public AlunoTransferObject retornaAluno(String nomeAluno) throws SQLException {
        Connection connection = conexaoBanco.getConnection();
        AlunoTransferObject alunoTransferObject = new AlunoTransferObject();
        String sql;
        sql = "SELECT * FROM public.aluno WHERE nome = ?";
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,nomeAluno);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            alunoTransferObject.setNome(resultSet.getString("nome"));
            alunoTransferObject.setRg(resultSet.getString("rg"));
        }

        preparedStatement.close();
        connection.close();
        return alunoTransferObject;

    }

    @Override
    public AlunoTransferObject retornaPorRg(String rg) throws SQLException {
        Connection connection = conexaoBanco.getConnection();
        AlunoTransferObject alunoTransferObject = new AlunoTransferObject();
        String sql;
        sql = "SELECT * FROM public.aluno WHERE rg = ?";
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,rg);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            alunoTransferObject.setNome(resultSet.getString("nome"));
            alunoTransferObject.setRg(resultSet.getString("rg"));
        }

        preparedStatement.close();
        connection.close();
        return alunoTransferObject;
    }
}
