package dao;

import model.Relatorios;
import infra.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Arthur
 */
public class RelatoriosDAO {

    private Conexao conexao;
    private Connection conn;

    public RelatoriosDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.conectar();
    }

    public List<Relatorios> getRelatorios() {
        String sql = "SELECT * FROM relatorios";

        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            List<Relatorios> listaRelatorios = new ArrayList<>();

            while (rs.next()) {

                Relatorios relatorio = new Relatorios();

                relatorio.setId(rs.getInt("id"));
                relatorio.setFuncionarios_id(rs.getInt("funcionario_id"));
                relatorio.setData_geracao(rs.getObject("data_geracao", java.time.LocalDateTime.class));
                relatorio.setDescricao(rs.getString("descricao"));

                listaRelatorios.add(relatorio);
            }
            return listaRelatorios;

        } catch (Exception e) {
            System.out.println("erro: " + e.getMessage());
            return null;
        }
    }
    
    public int salvar(Relatorios relatorios) {
        int status;
        String sql = "INSERT INTO relatorios (funcionario_id, data_geracao, descricao) VALUES(?,?,?)";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, relatorios.getFuncionarios_id());
            stmt.setString(2, relatorios.getData_geracao().toString());
            stmt.setString(3, relatorios.getDescricao());
            status = stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvamento concluido");

            return status;
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar");
            System.out.println(sqle.getMessage());
            return sqle.getErrorCode();
        }

    }
}
