package dao;

import controller.FacadeManterAlunoDataAccessObject;
import to.AlunoTransferObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

        return alunoTransferObject;
    }

    @Override
    public void deletarAluno(String rg_aluno) throws SQLException {
        Connection connection = conexaoBanco.getConnection();
        String sql;
        sql ="DELETE FROM aluno WHERE rg = ?";
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,rg_aluno);
        preparedStatement.execute();
        preparedStatement.close();
    }

    @Override
    public void atualizarAluno(String rg_aluno, AlunoTransferObject alunoTO) throws SQLException {
        Connection connection = conexaoBanco.getConnection();
        String sql;
        sql = "UPDATE aluno SET nome= ? WHERE rg = ?";
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,alunoTO.getNome());
        preparedStatement.setString(2,rg_aluno);
        preparedStatement.execute();
        preparedStatement.close();
    }

    @Override
    public ArrayList<AlunoTransferObject> retornaAlunos() throws SQLException {
        Connection connection = conexaoBanco.getConnection();
        String sql;
        sql = "SELECT * FROM aluno ORDER BY rg ASC;";
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<AlunoTransferObject> alunoTransferObjects = new ArrayList<>();
        
        while (resultSet.next()) {
            AlunoTransferObject alunoTransferObject = new AlunoTransferObject();
            alunoTransferObject.setNome(resultSet.getString("nome"));
            alunoTransferObject.setRg(resultSet.getString("rg"));
            alunoTransferObjects.add(alunoTransferObject);            
        }
        
        preparedStatement.close();
        
        return alunoTransferObjects;        
    }
}
