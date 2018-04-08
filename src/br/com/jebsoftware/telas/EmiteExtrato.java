/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jebsoftware.telas;

import br.com.jebsoftware.classes.ContaCorrente;
import br.com.jebsoftware.classes.Movimentacao;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author TitanNot
 */
public class EmiteExtrato extends javax.swing.JFrame {

ArrayList<ContaCorrente> lista_de_contas = CriaConta.lista_de_contas;
    /**
     * Creates new form EmiteExtrato
     */
    public EmiteExtrato() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnEmiteExtrato = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cmbContaCorrente = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Emitindo Extrato");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        btnEmiteExtrato.setText("Emitir Extrato");
        btnEmiteExtrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmiteExtratoActionPerformed(evt);
            }
        });

        jLabel2.setText("Conta-Corrente");

        jLabel1.setText("Emitindo extrato da conta...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(cmbContaCorrente, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(141, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(124, 124, 124)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEmiteExtrato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(37, 37, 37)))
                    .addContainerGap(140, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addComponent(cmbContaCorrente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jLabel2)
                    .addGap(37, 37, 37)
                    .addComponent(btnEmiteExtrato)
                    .addContainerGap(21, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        for(int i=0;i<lista_de_contas.size();i++){
            cmbContaCorrente.addItem(String.valueOf(lista_de_contas.get(i).getNumero()));
        }
    }//GEN-LAST:event_formWindowOpened

    private void btnEmiteExtratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmiteExtratoActionPerformed
        int numero = Integer.parseInt((String)cmbContaCorrente.getSelectedItem());
        String extrato;

        for(int i=0;i<lista_de_contas.size();i++){
            if(numero == lista_de_contas.get(i).getNumero()){
                
                ArrayList<Movimentacao>lista_de_movimentacoes = lista_de_contas.get(i).getLista_de_movimentacoes();
                
                if(!String.valueOf(lista_de_movimentacoes).equals("[]")){
                    
                    extrato = "EXTRATO DA CONTA\n\n";
                    for(int j=0;j<lista_de_movimentacoes.size();j++){
                        boolean tipoOperacao = lista_de_movimentacoes.get(j).getCredito();
                        String operacao;
                        if(tipoOperacao == false){
                            operacao = "Débito";
                        }else{
                            operacao = "Crédito";
                        }
                        extrato += "========================\n";
                        extrato += "DESCRIÇÃO : "+lista_de_movimentacoes.get(j).getDescricao()+"\n";
                        extrato += "TIPO DA OPERAÇÃO : "+operacao+"\n";
                        extrato += "VALOR DA OPERAÇÃO : "+lista_de_movimentacoes.get(j).getValor()+"\n";
                    }
                    JOptionPane.showMessageDialog(null, extrato);
                }else{
                    JOptionPane.showMessageDialog(null, "Não existem informações para esse extrato!");
                }
            }
        }
    }//GEN-LAST:event_btnEmiteExtratoActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(EmiteExtrato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmiteExtrato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmiteExtrato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmiteExtrato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmiteExtrato().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEmiteExtrato;
    private javax.swing.JComboBox<String> cmbContaCorrente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}