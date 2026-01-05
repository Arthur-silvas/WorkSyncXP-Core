package model;

public class Cargos {

    private int id;
    private String cargo;
    private String nivel_acesso;
    private String funcao;

    public Cargos(int id, String cargo, String nivel_acesso, String funcao) {
        this.id = id;
        this.cargo = cargo;
        this.nivel_acesso = nivel_acesso;
        this.funcao = funcao;
    }

    public Cargos(int id, String cargo) {
        this.id = id;
        this.cargo = cargo;
    }
    
    

    public Cargos() {
    }

    //Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getNivel_acesso() {
        return nivel_acesso;
    }

    public void setNivel_acesso(String nivel_acesso) {
        this.nivel_acesso = nivel_acesso;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    @Override
    public String toString() {
        return cargo; // <-- AQUI! O JComboBox só verá "nome" para exibir.
    }
}
