package dao;

import model.Logs;
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
public class LogsDAO {

    private Conexao conexao;
    private Connection conn;

    public LogsDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.conectar();
    }

    public int salvar(Logs log) {
        int status;
        String sql = "INSERT INTO logs (funcionario_id, acao_funcionario, data_hora) VALUES(?,?,?)";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, log.getFuncionario_id());
            stmt.setString(2, log.getAcaoFuncionario());
            stmt.setObject(3, log.getData_horario());
            status = stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvamento concluido");

            return status;
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar");
            System.out.println(sqle.getMessage());
            return sqle.getErrorCode();
        }

    }

    public List<Logs> getLogs() {
        String sql = "SELECT * FROM logs";

        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            List<Logs> listaLogs = new ArrayList<>();

            while (rs.next()) {

                Logs log = new Logs();

                log.setId(rs.getInt("id"));
                log.setFuncionario_id(rs.getInt("funcionario_id"));
                log.setAcaoFuncionario(rs.getString("acao_funcionario"));
                log.setData_horario(rs.getObject("data_hora", java.time.LocalDateTime.class));

                listaLogs.add(log);
            }
            return listaLogs;

        } catch (Exception e) {
            System.out.println("erro: " + e.getMessage());
            return null;
        }
    }

}
