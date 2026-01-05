package model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Arthur
 */
public class Funcionarios {

    private int id;
    private String nome;
    private String dataNasc;
    private String rg;
    private String cpf;
    private String telefone;
    private String endereco;
    private String email;
    private String registro_exame;
    private int cargo_id;

    //Tela de Funcionários
    public Funcionarios(int id, String nome, String dataNasc, String telefone, String email, int cargo_id) {
        this.id = id;
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.telefone = telefone;
        this.email = email;
        this.cargo_id = cargo_id;
    }

    //Contrutor com todos os dados
    public Funcionarios(int id, String nome, String dataNasc, String rg, String cpf, String telefone, String endereco, String email, String registro_exame, int cargo_id) {
        this.id = id;
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.rg = rg;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
        this.registro_exame = registro_exame;
        this.cargo_id = cargo_id;
    }

    //Construtor vazio
    public Funcionarios() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegistro_exame() {
        return registro_exame;
    }

    public void setRegistro_exame(String registro_exame) {
        this.registro_exame = registro_exame;
    }

    public int getCargo_id() {
        return cargo_id;
    }

    public void setCargo_id(int cargo_id) {
        this.cargo_id = cargo_id;
    }

    @Override
    public String toString() {
        return "Id: " + id + " Nome: " + nome + ", Data de Nascimento: " + dataNasc + ", RG: " + rg + ", CPF: " + cpf
                + ", Endereço: " + endereco + ", Email: " + email + ", Registro Exame: " + registro_exame + ", Cargo_id: " + cargo_id;
    }

}
