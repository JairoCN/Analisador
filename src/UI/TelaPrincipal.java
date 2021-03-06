/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.StringReader;
import javax.swing.JFileChooser;
import analisador.LexicoVisualg;
import analisador.Token;

/**
 *
 * @author jairo
 */
public class TelaPrincipal extends javax.swing.JFrame {

    
    JFileChooser escolheArquivo;
    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
        escolheArquivo = new JFileChooser();
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        telaErros = new javax.swing.JTextArea();
        btnAbrir = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnAnalisar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAreaEditor = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        telaErros.setEditable(false);
        telaErros.setColumns(20);
        telaErros.setRows(5);
        jScrollPane2.setViewportView(telaErros);

        btnAbrir.setText("Abrir...");
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnAnalisar.setText("Analisar");
        btnAnalisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalisarActionPerformed(evt);
            }
        });

        txtAreaEditor.setColumns(20);
        txtAreaEditor.setRows(5);
        jScrollPane3.setViewportView(txtAreaEditor);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAnalisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAbrir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(btnAbrir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalvar)
                        .addGap(11, 11, 11)
                        .addComponent(btnAnalisar)
                        .addGap(18, 257, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        try {
            if (escolheArquivo.showOpenDialog(TelaPrincipal.this) ==
                    JFileChooser.APPROVE_OPTION) {
                File arquivo = escolheArquivo.getSelectedFile();
                FileReader ler = new FileReader(arquivo);
                char[] buffer = new char[1024];
                int n = ler.read(buffer);
                String text = new String(buffer, 0, n);
                txtAreaEditor.setText(text);
            } else {
                txtAreaEditor.append("Comando de abrir cancelado pelo usuário.\n");
            }
            txtAreaEditor.setCaretPosition(txtAreaEditor.getDocument().getLength());        
        } catch (Exception f) {
            f.printStackTrace();
        }
    }//GEN-LAST:event_btnAbrirActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try {
            if (escolheArquivo.showSaveDialog(TelaPrincipal.this) ==
                    JFileChooser.APPROVE_OPTION) {
                File arquivo = escolheArquivo.getSelectedFile();
                FileWriter out = new FileWriter(arquivo);
                out.write(txtAreaEditor.getText());
                out.close();
            } else {
                txtAreaEditor.append("Comando de salvar cancelado pelo usuário.\n");
            }
            txtAreaEditor.setCaretPosition(txtAreaEditor.getDocument().getLength());        
        } catch (Exception f) {
            f.printStackTrace();
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnAnalisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalisarActionPerformed
        try {
            String texto = (String) txtAreaEditor.getText();
            LexicoVisualg lexico = new LexicoVisualg(new StringReader(texto));
            
            String resultado = "";
            int errocol = -1;
            int errolinha = -1;
            while (true) {                
                Token token = lexico.yylex();
                if (token == null) {
                    telaErros.setText(resultado);
                    if (errocol != -1) {
                        //txtAreaEditor.;
                    }
                    return;
                }
                resultado = resultado + token.toString();
                if ((token.type == Token.T.ERRO) && (errocol != -1)) {
                    errocol = token.col;
                    errolinha = token.line;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        
    }//GEN-LAST:event_btnAnalisarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnAnalisar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea telaErros;
    private javax.swing.JTextArea txtAreaEditor;
    // End of variables declaration//GEN-END:variables
}
