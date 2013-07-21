package view.form;

/**
 * @author Yosua Onesimus
 * @since 13.07.20
 * @version 13.07.20
 */
public class PnlAnswer extends javax.swing.JPanel {

    public PnlAnswer() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        xQuestion = new javax.swing.JLabel();
        lblAnswer = new javax.swing.JLabel();
        btnTryAgain = new cococare.swing.component.CCButton();

        setMinimumSize(new java.awt.Dimension(600, 400));

        jPanel1.setMinimumSize(new java.awt.Dimension(600, 400));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 400));
        jPanel1.setLayout(null);

        xQuestion.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        xQuestion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        xQuestion.setText("Angka yang anda pikirkan adalah ...");
        xQuestion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(xQuestion);
        xQuestion.setBounds(10, 10, 580, 60);

        lblAnswer.setFont(new java.awt.Font("Verdana", 1, 72)); // NOI18N
        lblAnswer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAnswer.setText("7");
        lblAnswer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblAnswer);
        lblAnswer.setBounds(10, 130, 580, 120);

        btnTryAgain.setText("Coba Lagi");
        jPanel1.add(btnTryAgain);
        btnTryAgain.setBounds(250, 300, 100, 29);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private cococare.swing.component.CCButton btnTryAgain;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAnswer;
    private javax.swing.JLabel xQuestion;
    // End of variables declaration//GEN-END:variables
}