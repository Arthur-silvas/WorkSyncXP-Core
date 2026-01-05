package dao;

import model.Ferias_licencas;
import infra.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Ferias_licencasDAO {

    private Conexao conexao;
    private Connection conn;

    public Ferias_licencasDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.conectar();
    }

    public List<Ferias_licencas> getAfastamento() {
        String sql = "SELECT * FROM ferias_licencas";

        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            List<Ferias_licencas> listaAfastamento = new ArrayList<>();

            while (rs.next()) {

                Ferias_licencas afastamento = new Ferias_licencas();

                afastamento.setId(rs.getInt("id"));
                afastamento.setFuncionarios_id(rs.getInt("funcionario_id"));
                afastamento.setTipo_afastamento(rs.getString("tipo_Ferias_licenca"));
                afastamento.setData_incial(rs.getDate("data_inicio"));
                afastamento.setData_final(rs.getDate("data_fim"));
                afastamento.setAprovacao(rs.getBoolean("aprovacao"));

                listaAfastamento.add(afastamento);
            }
            return listaAfastamento;

        } catch (Exception e) {
            System.out.println("erro: " + e.getMessage());
            return null;
        }
    }

    public int salvar(Ferias_licencas afastamento) {
        int status;

        java.sql.Date dataInicialSql = new java.sql.Date(afastamento.getData_incial().getTime());
        java.sql.Date dataFinalSql = new java.sql.Date(afastamento.getData_final().getTime());

        String sql = "INSERT INTO ferias_licencas (funcionario_id, tipo_Ferias_licenca, data_inicio, data_fim, aprovacao) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, afastamento.getFuncionarios_id());
            stmt.setString(2, afastamento.getTipo_afastamento());
            stmt.setDate(3, dataInicialSql);
            stmt.setDate(4, dataFinalSql);
            stmt.setBoolean(5, afastamento.isAprovacao());
            status = stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvamento concluido");

            return status;
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar" + sqle.getMessage());
            System.out.println(sqle.getMessage());
            return sqle.getErrorCode();
        }

    }

    public int aprovar(int feriasLicencasId) {
        int status;
        String sql = "UPDATE ferias_licencas SET aprovacao = ? WHERE id = ?";
        try (PreparedStatement stmt = this.conn.prepareStatement(sql)) {
            stmt.setBoolean(1, true); // Define a aprovação como true
            stmt.setInt(2, feriasLicencasId); // O ID do registro a ser atualizado
            status = stmt.executeUpdate();
            return status;
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro ao aprovar o registro.");
            System.err.println("Erro ao aprovar: " + sqle.getMessage());
            return -1;
        }
    }

}
