package model;

import java.time.LocalTime;
import java.util.Date;

public class Registro_horas {
    private int id; 
    private int funcionario_id;
    private Date data_registro;
    private LocalTime Horario_entrada;
    private LocalTime Horario_saida;

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFuncionario_id() {
        return funcionario_id;
    }

    public void setFuncionario_id(int funcionario_id) {
        this.funcionario_id = funcionario_id;
    }

    public Date getData_registro() {
        return data_registro;
    }

    public void setData_registro(Date data_registro) {
        this.data_registro = data_registro;
    }

    public LocalTime getHorario_entrada() {
        return Horario_entrada;
    }

    public void setHorario_entrada(LocalTime Horario_entrada) {
        this.Horario_entrada = Horario_entrada;
    }

    public LocalTime getHorario_saida() {
        return Horario_saida;
    }

    public void setHorario_saida(LocalTime Horario_saida) {
        this.Horario_saida = Horario_saida;
    }
    
    
}
