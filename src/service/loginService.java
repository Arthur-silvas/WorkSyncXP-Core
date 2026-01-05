package service;

import javax.swing.JTextField;

/**
 *
 * @author Arthur
 */
public class loginService {
        public boolean emptyFilds(JTextField txtEmail, JTextField txtCpf ) {
            String login = txtEmail.getText().trim(); 
            String senha = txtCpf.getText().trim();
            if (txtEmail.getText().isEmpty() || txtCpf.getText().isEmpty()) {
                return false; //Campos vazios

            } else {
                return true; //Campos preenchidos
            }
            
        }
        
        
        public String regexDate(JTextField txtEmail, JTextField txtCpf){
            //Armazena os valores dos campos como Texto
            String login = txtEmail.getText();
            String senha = txtCpf.getText();

            //Define o padrão de login e senha (Regex)
            String loginRegexModel = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
            String passwordRegexModel = "^\\d{11}$";
                        
            boolean RegexEmail = login.matches(loginRegexModel);
            boolean RegexCpf = senha.matches(passwordRegexModel);
            
            if (RegexEmail == false) {
                return "erroLogin";
                
            } else if (RegexCpf == false) {
                return "erroPassword";
                
            } else {
                return "Ok"; 
            }
        }
}
