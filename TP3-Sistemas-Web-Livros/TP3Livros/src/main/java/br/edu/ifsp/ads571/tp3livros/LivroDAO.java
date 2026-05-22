package br.edu.ifsp.ads571.tp3livros;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

/*
 * TP3 - Sistemas Web 1
 * Matéria: CBTSWE - ADS 571
 * Professor: Wellington Tuler Moraes
 *
 * Dupla:
 * 1 - Gustavo Murai
 * 2 - igor Murai
 *
 * Classe DAO.
 * DAO significa Data Access Object.
 *
 * Esta classe é responsável por acessar o banco de dados MySQL.
 * Aqui ficam os comandos INSERT, SELECT, UPDATE e DELETE.
 */
public class LivroDAO {

    private String jdbcURL = "jdbc:mysql://localhost:3306/tp3_livros?useSSL=false&serverTimezone=America/Sao_Paulo&allowPublicKeyRetrieval=true";

    private String jdbcUsuario = "root";

    /*
     * ATENÇÃO:
     * No seu caso, você disse que a senha também é root.
     * Então deixei como "root".
     */
    private String jdbcSenha = "root";


    protected Connection conectar() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException erro) {
            throw new SQLException("Driver JDBC do MySQL não encontrado.", erro);
        }

        return DriverManager.getConnection(jdbcURL, jdbcUsuario, jdbcSenha);
    }


    public boolean inserirLivro(Livro livro) throws SQLException {
        String sql = "INSERT INTO livro (titulo, autor, preco) VALUES (?, ?, ?)";

        try (Connection conexao = conectar();
             PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setString(1, livro.getTitulo());
            comando.setString(2, livro.getAutor());
            comando.setBigDecimal(3, livro.getPreco());

            return comando.executeUpdate() > 0;
        }
    }


    public List<Livro> listarTodosLivros() throws SQLException {
        List<Livro> listaLivros = new ArrayList<>();

        String sql = "SELECT id, titulo, autor, preco FROM livro ORDER BY id DESC";

        try (Connection conexao = conectar();
             PreparedStatement comando = conexao.prepareStatement(sql);
             ResultSet resultado = comando.executeQuery()) {

            while (resultado.next()) {
                int id = resultado.getInt("id");
                String titulo = resultado.getString("titulo");
                String autor = resultado.getString("autor");
                BigDecimal preco = resultado.getBigDecimal("preco");

                Livro livro = new Livro(id, titulo, autor, preco);

                listaLivros.add(livro);
            }
        }

        return listaLivros;
    }


    public Livro buscarLivroPorId(int id) throws SQLException {
        Livro livro = null;

        String sql = "SELECT id, titulo, autor, preco FROM livro WHERE id = ?";

        try (Connection conexao = conectar();
             PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setInt(1, id);

            try (ResultSet resultado = comando.executeQuery()) {
                if (resultado.next()) {
                    String titulo = resultado.getString("titulo");
                    String autor = resultado.getString("autor");
                    BigDecimal preco = resultado.getBigDecimal("preco");

                    livro = new Livro(id, titulo, autor, preco);
                }
            }
        }

        return livro;
    }


    public boolean atualizarLivro(Livro livro) throws SQLException {
        String sql = "UPDATE livro SET titulo = ?, autor = ?, preco = ? WHERE id = ?";

        try (Connection conexao = conectar();
             PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setString(1, livro.getTitulo());
            comando.setString(2, livro.getAutor());
            comando.setBigDecimal(3, livro.getPreco());
            comando.setInt(4, livro.getId());

            return comando.executeUpdate() > 0;
        }
    }


    public boolean excluirLivro(int id) throws SQLException {
        String sql = "DELETE FROM livro WHERE id = ?";

        try (Connection conexao = conectar();
             PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setInt(1, id);

            return comando.executeUpdate() > 0;
        }
    }
}