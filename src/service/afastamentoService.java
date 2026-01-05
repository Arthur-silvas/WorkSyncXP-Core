
package service;

import javax.swing.JTextField;

/**
 *
 * @author Arthur
 */
public class afastamentoService {
    
    public boolean emptyFilds(JTextField txtDataFinal, JTextField txtDataInicial) {
        //Verifica se os campos estão vazios
        if (txtDataInicial.getText().isEmpty() || txtDataFinal.getText().isEmpty()) {
            return false;
        }else{
            return true; // Se todos os testes passarem, o método retorna verdadeiro
        }
        
    }
    
    public String regexDate(JTextField txtDataFinal, JTextField txtDataInicial){
        //Armazena os valores dos campos como Texto
        String dataInicial = txtDataInicial.getText();
        String dataFinal = txtDataFinal.getText();

        //Define o padrão de data (Regex)
        String regexData = "[0-9]{2}/[0-9]{2}/[0-9]{4}";

        //Valida os formatos das datas com Regex
        if (!dataInicial.matches(regexData)) {
            return "erroDateInital"; //Retorna uma String personalizada para indicar qual erro está sendo referenciado
        }

        if (!dataFinal.matches(regexData)) {
            return "erroDateEnd"; //Retorna uma String personalizada para indicar qual erro está sendo referenciado
            
        }else{
            return "Ok";
        }    
    }
    
}
