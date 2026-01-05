
package model;
import java.time.LocalDateTime;


public class Logs {
    private int id;
    private int funcionario_id;
    private String acaoFuncionario;
    private LocalDateTime data_horario; 

    
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

    public String getAcaoFuncionario() {
        return acaoFuncionario;
    }

    public void setAcaoFuncionario(String acaoFuncionario) {
        this.acaoFuncionario = acaoFuncionario;
    }

    public LocalDateTime getData_horario() {
        return data_horario;
    }

    public void setData_horario(LocalDateTime data_horario) {
        this.data_horario = data_horario;
    }
    
    
}
