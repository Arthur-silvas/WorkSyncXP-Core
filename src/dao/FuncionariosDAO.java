package dao;

import model.Cargos;
import model.Funcionarios;
import infra.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class FuncionariosDAO {

    private Conexao conexao;
    private Connection conn;

    public FuncionariosDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.conectar();
    }

    public int salvar(Funcionarios funcionario) {
        int status;
        String sql = "INSERT INTO funcionarios (nome, data_nasc, rg, cpf, telefone, endereco, email, registro_exame, cargo_id) VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getDataNasc());
            stmt.setString(3, funcionario.getRg());
            stmt.setString(4, funcionario.getCpf());
            stmt.setString(5, funcionario.getTelefone());
            stmt.setString(6, funcionario.getEndereco());
            stmt.setString(7, funcionario.getEmail());
            stmt.setString(8, funcionario.getRegistro_exame());
            stmt.setInt(9, funcionario.getCargo_id());
            status = stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvamento concluido");

            return status;
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar");
            System.out.println(sqle.getMessage());
            return sqle.getErrorCode();
        }

    }

    /**
     * Retorna uma lista com todos os funcionários cadastradados no banco de
     * dados
     *
     * @return Lista de objetos Funcioanrios com os dados recuperados do banco.
     */
    public List<Funcionarios> getFucionarios() {
        String sql = "SELECT * FROM funcionarios";

        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            List<Funcionarios> listaFuncionarios = new ArrayList<>();

            while (rs.next()) {

                Funcionarios funcionario = new Funcionarios();

                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setDataNasc(rs.getString("data_nasc"));
                funcionario.setTelefone(rs.getString("telefone"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setCargo_id(rs.getInt("cargo_id"));

                listaFuncionarios.add(funcionario);
            }
            return listaFuncionarios;

        } catch (Exception e) {
            System.out.println("erro: " + e.getMessage());
            return null;
        }
    }

    /**
     * Retornar os registro do cargos do banco de dados
     *
     * @param ComboBox
     */
    public void comboBoxDB(JComboBox ComboBox) {
        String sql = "SELECT id, cargo FROM cargos";
        ArrayList<String> cargos = new ArrayList<>();
        try {

            PreparedStatement stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            ComboBox.removeAllItems();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nomeCargo = rs.getString("cargo");

                Cargos cargoObjeto = new Cargos(id, nomeCargo);

                ComboBox.addItem(cargoObjeto);
            }

            if (ComboBox.getItemCount() > 0) {
                ComboBox.setSelectedIndex(0);
            }

        } catch (SQLException slqe) {
            JOptionPane.showMessageDialog(null, "Erro ao exibir o comboBox  " + slqe.getMessage());
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM funcionarios WHERE id = ?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, id);

            stmt.execute();

            JOptionPane.showMessageDialog(null, "Exclusão concluída");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao Excluir");
            System.out.println("Erro ao tentar excluir um dado" + e.getMessage());
        }
    }

    public Funcionarios buscarPorId(int id) {
        try {
            String sql = "SELECT * FROM funcionarios WHERE id = ?";
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Funcionarios f = new Funcionarios();
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setDataNasc(rs.getString("data_nasc"));
                f.setRg(rs.getString("rg"));
                f.setCpf(rs.getString("cpf"));
                f.setTelefone(rs.getString("telefone"));
                f.setEndereco(rs.getString("endereco"));
                f.setEmail(rs.getString("email"));
                f.setRegistro_exame("registro_exame");
                f.setCargo_id(rs.getInt("cargo_id"));
                return f;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO na busca por id");
        } finally {

        }
        return null; // Retorna null se não encontrar
    }

    public void Editar(Funcionarios f) {
        String sql = "UPDATE funcionarios SET nome = ?, data_nasc = ?, rg = ?, cpf = ?, telefone = ?, endereco = ?, email = ?, registro_exame = ?, cargo_id = ? WHERE id = ?;";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getDataNasc());
            stmt.setString(3, f.getRg());
            stmt.setString(4, f.getCpf());
            stmt.setString(5, f.getTelefone());
            stmt.setString(6, f.getEndereco());
            stmt.setString(7, f.getEmail());
            stmt.setString(8, f.getRegistro_exame());
            stmt.setInt(9, f.getCargo_id());

            //O último parâmetro (o 10º) é o ID do funcionário
            stmt.setInt(10, f.getId());
            
            stmt.execute();

            JOptionPane.showMessageDialog(null, "Edição concluída");
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Falha ao Editar");
            System.out.println("Erro ao editar: " + sqle.getMessage());
        }

    }

    public Funcionarios pesquisarFuncionarios(String nomeFuncionario) {
        String sql = "SELECT * FROM funcionarios WHERE nome LIKE ?";

        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);

            stmt.setString(1, "%" + nomeFuncionario + "%");

            ResultSet rs = stmt.executeQuery();

            Funcionarios f = new Funcionarios();

            if (rs.next()) {
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setDataNasc(rs.getString("data_nasc"));
                f.setRg(rs.getString("rg"));
                f.setCpf(rs.getString("cpf"));
                f.setTelefone(rs.getString("telefone"));
                f.setEndereco(rs.getString("endereco"));
                f.setEmail(rs.getString("email"));
                f.setRegistro_exame("registro_exame");
                f.setCargo_id(rs.getInt("cargo_id"));
                return f;
            } else {
                JOptionPane.showMessageDialog(null, "Filme não encontrado");
            }
            return f;
        } catch (Exception e) {
            System.out.println("erro: " + e.getMessage());
            return null;
        }
    }
    
    public String getNomeCargoPorFuncionarioId(int funcionarioId) {
    String nomeCargo = null;
    String sql = "SELECT c.cargo FROM funcionarios f JOIN cargos c ON f.cargo_id = c.id WHERE f.id = ?";

    try (PreparedStatement stmt = this.conn.prepareStatement(sql)) {
        // Define o ID do funcionário como parâmetro da consulta
        stmt.setInt(1, funcionarioId);

        try (ResultSet rs = stmt.executeQuery()) {
            // Se houver um resultado, obtém o nome do cargo
            if (rs.next()) {
                nomeCargo = rs.getString("cargo");
            }
        }
    } catch (SQLException e) {
        System.err.println("Erro ao buscar o cargo do funcionário: " + e.getMessage());
        e.printStackTrace();
    }
    return nomeCargo;
}

}
