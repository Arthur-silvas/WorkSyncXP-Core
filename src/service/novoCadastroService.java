
package service;

import javax.swing.JTextField;

/**
 *
 * @author Arthur  
 */
public class novoCadastroService {
    
        public boolean EmptyFilds(String nome, String dataNascimento, String rg, String cpf, String tel, String 
endereco, String email) {

        if (nome.isEmpty()
                || dataNascimento.isEmpty()
                || rg.isEmpty()
                || cpf.isEmpty()
                || tel.isEmpty()
                || endereco.isEmpty()
                || email.isEmpty()) {
            
            return false; 
            
        } else {

            return true;
        }
    }
        
        public String regexData(JTextField Data, JTextField Rg, JTextField Cpf,JTextField Tel){
            
            String dataNascimento = Data.getText();
            String rg = Rg.getText(); 
            String cpf = Cpf.getText();
            String tel = Tel.getText();
            
            String dataNascimentoRegexModel = "[0-9]{4}[/][0-9]{2}[/][0-9]{2}";
            String rgRegexModel = "^\\d{9}$";
            String cpfRegexModel = "^\\d{11}$";
            String telRegexModel = "^\\d{5}-\\d{4}$";
            
            boolean RegexData = dataNascimento.matches(dataNascimentoRegexModel);
            boolean RegexRg = rg.matches(rgRegexModel);
            boolean RegexCpf = cpf.matches(cpfRegexModel);
            boolean RegexTel = tel.matches(telRegexModel);

            if (RegexData == false) {
                
                return "erroData";
            } else if (RegexRg == false) {
                
                return "erroRg";
            } else if (RegexCpf == false) {
                
                return "erroCpf";
            } else if (RegexTel == false) {
                
                return "erroTel";
            } else {
                return "Ok";
            }
        }
    
}
