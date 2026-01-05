package view;

import model.Ferias_licencas;
import model.Funcionarios;
import dao.Ferias_licencasDAO;
import infra.Sessao;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import service.afastamentoService;

public class AfastamentoVIEW extends javax.swing.JFrame {

    Ferias_licencas afastamento = new Ferias_licencas();
    Ferias_licencasDAO dao = new Ferias_licencasDAO();
    afastamentoService afastamentoService = new afastamentoService(); 

    public void preencherTabela() {

        List<Ferias_licencas> listaAfastamentos = dao.getAfastamento();

        DefaultTableModel tabelaAfastamento = (DefaultTableModel) tblAfastamento.getModel();
        tabelaAfastamento.setNumRows(0);

        tblAfastamento.setRowSorter(new TableRowSorter(tabelaAfastamento));

        for (Ferias_licencas f : listaAfastamentos) {

            Object[] obj = new Object[]{
                f.getId(),
                f.getFuncionarios_id(),
                f.getTipo_afastamento(),
                f.getData_incial(),
                f.getData_final(),
                f.isAprovacao()};
            tabelaAfastamento.addRow(obj);
        }

    }

    private String tipoAfastamento;
    private String dataInicial;
    private String dataFinal;
    private Date dataInicialFormat;
    private Date dataFinalFormat;

    public AfastamentoVIEW() {
        initComponents();
        aprovacao();
        preencherTabela();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        cmbTipoAfastamento = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        txtDataInicial = new javax.swing.JTextField();
        txtDataFinal = new javax.swing.JTextField();
        lblDataInicial = new javax.swing.JLabel();
        lblDataFinal = new javax.swing.JLabel();
        btnSolicitar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAfastamento = new javax.swing.JTable();
        btnVoltar = new javax.swing.JButton();
        btnAprovar = new javax.swing.JButton();
        lblBoasVindas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(19, 63, 146));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Novo Afastamento"));

        cmbTipoAfastamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Férias", "Atesteado Médico", "Licença" }));

        jPanel5.setBackground(new java.awt.Color(19, 63, 146));

        txtDataInicial.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtDataFinal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblDataInicial.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblDataInicial.setForeground(new java.awt.Color(255, 255, 255));
        lblDataInicial.setText("Data Incial");

        lblDataFinal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblDataFinal.setForeground(new java.awt.Color(255, 255, 255));
        lblDataFinal.setText("Data Final");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDataInicial)
                    .addComponent(txtDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 220, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDataFinal)
                    .addComponent(txtDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(97, 97, 97))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDataInicial)
                    .addComponent(lblDataFinal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );

        btnSolicitar.setBackground(new java.awt.Color(19, 63, 146));
        btnSolicitar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSolicitar.setForeground(new java.awt.Color(255, 255, 255));
        btnSolicitar.setText("Solicitar Afastamento");
        btnSolicitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolicitarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Tipo de Afastamento");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSolicitar))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbTipoAfastamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 228, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbTipoAfastamento, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(btnSolicitar)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de Afastamentos"));

        tblAfastamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "ID do Funcionario", "Tipo de afastamento", "Data de Inicio", "Data Final", "Aprovação"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblAfastamento);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        btnVoltar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        btnAprovar.setBackground(new java.awt.Color(8, 131, 30));
        btnAprovar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAprovar.setForeground(new java.awt.Color(255, 255, 255));
        btnAprovar.setText("Aprovar");
        btnAprovar.setToolTipText("Somente gerente pode aprovar");
        btnAprovar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAprovarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAprovar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAprovar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVoltar)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        lblBoasVindas.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblBoasVindas.setForeground(new java.awt.Color(255, 255, 255));
        lblBoasVindas.setText("Afastamento");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblBoasVindas)
                .addGap(527, 527, 527))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblBoasVindas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(156, 156, 156))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnSolicitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolicitarActionPerformed
        //Recebe os dados do usuário logado
        Funcionarios atual = Sessao.getUsuarioLogado();
        //Cria uma nova instância de afastamento
        Ferias_licencas afastamento = new Ferias_licencas();
        try {
            
            //Valida os campos primeiro: vazios ou com formato de data incorreto?
            if (afastamentoService.emptyFilds(txtDataFinal, txtDataInicial) == false) {
                JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
                return;
            }else if(validacaoErroRegex(afastamentoService.regexDate(txtDataFinal, txtDataInicial)) == false){
                //Método validacaoErroRegex gera mensagens de erro
                return;
            }
            
            //Se a validação passou, preenche as variáveis locais
            tipoAfastamento = cmbTipoAfastamento.getSelectedItem().toString();
            dataInicial = txtDataInicial.getText();
            dataFinal = txtDataFinal.getText();

            //Tenta formatar as datas. Se falhar, o método formatarData cuidará do erro.
            if (formatarData()) {
                // 6. Se a formatação for bem-sucedida, preenche o objeto de afastamento
                afastamento.setFuncionarios_id(atual.getId());
                afastamento.setTipo_afastamento(tipoAfastamento);
                afastamento.setData_incial(dataInicialFormat);
                afastamento.setData_final(dataFinalFormat);
                afastamento.setAprovacao(false);

                //Salva o afastamento no banco de dados.
                dao.salvar(afastamento);
                //Atualizando tabela
                preencherTabela();
                //Limpa os campos após a solicitação ser salva com sucesso
                limparCampos();

            } else {

            }
        } catch (Exception e) {
            //Trata qualquer outra exceção inesperada
            JOptionPane.showMessageDialog(this, "Erro ao Solicitar Afastamento");
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSolicitarActionPerformed

    private void btnAprovarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAprovarActionPerformed
        //Pega o índice da linha selecionada na tabela
        int linhaSelecionada = tblAfastamento.getSelectedRow();

        //Verifica se uma linha foi realmente selecionada
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecione uma solicitação para aprovar.");
            return; // Sai do método se nada foi selecionado
        }

        //Pega o ID da solicitação da linha selecionada
        int feriasLicencasId = (int) tblAfastamento.getValueAt(linhaSelecionada, 0);

        //Pergunta para o gerente se ele tem certeza
        int confirmacao = JOptionPane.showConfirmDialog(this,
                "Tem certeza que deseja aprovar\n esta solicitação?",
                "Confirmação de Aprovação",
                JOptionPane.YES_NO_OPTION);

        if (confirmacao == JOptionPane.YES_OPTION) {
            int status = dao.aprovar(feriasLicencasId);

            if (status > 0) {
                JOptionPane.showMessageDialog(this, "Solicitação aprovada com sucesso!");
                preencherTabela();
            } else {
                JOptionPane.showMessageDialog(this, "Falha ao aprovar a solicitação.");
            }
        }
    }//GEN-LAST:event_btnAprovarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AfastamentoVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AfastamentoVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AfastamentoVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AfastamentoVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AfastamentoVIEW().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAprovar;
    private javax.swing.JButton btnSolicitar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> cmbTipoAfastamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBoasVindas;
    private javax.swing.JLabel lblDataFinal;
    private javax.swing.JLabel lblDataInicial;
    private javax.swing.JTable tblAfastamento;
    private javax.swing.JTextField txtDataFinal;
    private javax.swing.JTextField txtDataInicial;
    // End of variables declaration//GEN-END:variables

    

    public boolean formatarData() {
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            // O setLenient(false) garante que datas inválidas como "31/02/2023" lancem uma exceção
            format.setLenient(false);
            dataInicialFormat = format.parse(dataInicial);
            dataFinalFormat = format.parse(dataFinal);
            return true; // Retorna true se a formatação for bem-sucedida
        } catch (ParseException e) {
            // Exibe uma mensagem de erro mais clara
            JOptionPane.showMessageDialog(this, "Erro de formato de data. Use o formato dd/MM/yyyy.");
            // A stack trace é útil para depuração
            e.printStackTrace();
            return false; // Retorna false em caso de erro
        }
    }

    public void limparCampos() {
        txtDataInicial.setText("");
        txtDataFinal.setText("");
    }

    public void aprovacao() {
        Funcionarios atual = Sessao.getUsuarioLogado();

        // Se o cargo_id for 2 (Gerente), o botão fica habilitado (padrão)
        if (atual.getCargo_id() == 2) {
            this.btnAprovar.setEnabled(true);
        } else {
            // Caso contrário, o botão é desabilitado
            this.btnAprovar.setEnabled(false);
        }

    }
    
    //Método que captura o erro de regex vindo da classe afastamentoService e retorna a mensagem personalizada
    public boolean validacaoErroRegex(String erroRegex){
        
        if(erroRegex.equals("erroDateInital")){
            JOptionPane.showMessageDialog(null, "Preencha a data inicial no formato\ndd/MM/yyyy");
            return false;
            
        }else if(erroRegex.equals("erroDateEnd")){
            JOptionPane.showMessageDialog(null, "Preencha a data final no formato\ndd/MM/yyyy");
            return false;
            
        }else{
            return true; 
        }
    }
}
