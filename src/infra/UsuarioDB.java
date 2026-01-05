package infra;

import model.Funcionarios;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Arthur
 */
public class UsuarioDB {

    public static Funcionarios validarUsuarioSeguro(Funcionarios funcionarios) {
        // Criando consulta parametrizada
        String sql = "SELECT * FROM funcionarios WHERE email = ? AND cpf = ?";
        Funcionarios usuarioEncontrado = null;

        try {
            Connection conexao = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pi01_arthur_pompollo", "root", "");
            PreparedStatement stmt = conexao.prepareStatement(sql);

            // Atribuindo os valores na consulta
            stmt.setString(1, funcionarios.getEmail());
            stmt.setString(2, funcionarios.getCpf());
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                usuarioEncontrado = new Funcionarios();
                usuarioEncontrado.setId(rs.getInt("id"));
                usuarioEncontrado.setNome(rs.getString("nome"));
                usuarioEncontrado.setDataNasc(rs.getString("data_nasc"));
                usuarioEncontrado.setRg(rs.getString("rg"));
                usuarioEncontrado.setCpf(rs.getString("cpf"));
                usuarioEncontrado.setTelefone(rs.getString("telefone"));
                usuarioEncontrado.setEndereco(rs.getString("endereco"));
                usuarioEncontrado.setEmail(rs.getString("email"));
                usuarioEncontrado.setRegistro_exame(rs.getString("registro_exame"));
                usuarioEncontrado.setCargo_id(rs.getInt("cargo_id"));

            }

        } catch (SQLException ex) {
            System.out.println("Sintaxe de comando invalida");
        }

        return usuarioEncontrado;
    }
}
