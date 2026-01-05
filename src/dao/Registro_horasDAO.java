package dao;

import model.Registro_horas;
import infra.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Arthur
 */
public class Registro_horasDAO {

    private Conexao conexao;
    private Connection conn;

    public Registro_horasDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.conectar();
    }

    public int salvar(Registro_horas registro) {
        int status;
        String sql = "INSERT INTO registro_horas (funcionario_id, data_registro, hora_entrada, hora_saida) VALUES(?,?,?,?)";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);

            java.sql.Date dataSql = new java.sql.Date(registro.getData_registro().getTime());
            java.sql.Time horaEntradaSql = java.sql.Time.valueOf(registro.getHorario_entrada());
            java.sql.Time horaSaidaSql = java.sql.Time.valueOf(registro.getHorario_saida());

            stmt.setInt(1, registro.getFuncionario_id());
            stmt.setDate(2, dataSql);
            stmt.setTime(3, horaEntradaSql);
            stmt.setTime(4, horaSaidaSql);
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
