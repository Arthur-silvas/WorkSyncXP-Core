package dao;

import model.Cargos;
import infra.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CargosDAO {

    private Conexao conexao;
    private Connection conn;

    public CargosDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.conectar();
    }

    Cargos cargo = new Cargos();

    public List<Cargos> getFilme() {
        String sql = "SELECT * FROM cargos";

        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            List<Cargos> listaCargos = new ArrayList<>();

            while (rs.next()) {

                Cargos cargo = new Cargos();

                cargo.setId(rs.getInt("id"));
                cargo.setCargo(rs.getString("cargo"));
                cargo.setFuncao(rs.getString("funcao"));
                cargo.setNivel_acesso(rs.getString("nivel_acesso"));

                listaCargos.add(cargo);
            }
            return listaCargos;

        } catch (Exception e) {
            System.out.println("erro: " + e.getMessage());
            return null;
        }
    }

    public Cargos pesquisarFuncionarios(String nomeCargo) {
        String sql = "SELECT * FROM cargos WHERE cargo LIKE ?";

        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);

            stmt.setString(1, "%" + nomeCargo + "%");

            ResultSet rs = stmt.executeQuery();

            Cargos c = new Cargos();

            if (rs.next()) {

                c.setId(rs.getInt("id"));
                c.setCargo(rs.getString("cargo"));
                c.setFuncao(rs.getString("funcao"));
                c.setNivel_acesso(rs.getString("nivel_acesso"));
                return c;
            } else {
                JOptionPane.showMessageDialog(null, "Filme não encontrado");
            }
            return c;
        } catch (Exception e) {
            System.out.println("erro: " + e.getMessage());
            return null;
        }

    }
}
