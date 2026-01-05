package model;

import java.util.Date;

public class Ferias_licencas {
    
    private int id; 
    private int funcionarios_id;
    private String tipo_afastamento;
    private Date data_incial;
    private Date data_final;
    private boolean aprovacao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFuncionarios_id() {
        return funcionarios_id;
    }

    public void setFuncionarios_id(int funcionarios_id) {
        this.funcionarios_id = funcionarios_id;
    }

    public String getTipo_afastamento() {
        return tipo_afastamento;
    }

    public void setTipo_afastamento(String tipo_afastamento) {
        this.tipo_afastamento = tipo_afastamento;
    }

    public Date getData_incial() {
        return data_incial;
    }

    public void setData_incial(Date data_incial) {
        this.data_incial = data_incial;
    }

    public Date getData_final() {
        return data_final;
    }

    public void setData_final(Date data_final) {
        this.data_final = data_final;
    }

    public boolean isAprovacao() {
        return aprovacao;
    }

    public void setAprovacao(boolean aprovacao) {
        this.aprovacao = aprovacao;
    }
    
    
}
