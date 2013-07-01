package view.form;

public class DlgQuestion extends javax.swing.JDialog {

    public DlgQuestion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlQuestion = new javax.swing.JPanel();
        lblQuestion = new javax.swing.JLabel();
        lblTimer = new javax.swing.JLabel();
        txtAnswer = new javax.swing.JFormattedTextField();
        lblCorrectAnswer = new javax.swing.JLabel();
        btnEnter = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Question");
        setResizable(false);

        pnlQuestion.setLayout(null);

        lblQuestion.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        pnlQuestion.add(lblQuestion);
        lblQuestion.setBounds(10, 10, 400, 149);

        lblTimer.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lblTimer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTimer.setText("Timer");
        lblTimer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pnlQuestion.add(lblTimer);
        lblTimer.setBounds(410, 10, 100, 149);

        txtAnswer.setFont(new java.awt.Font("Lucida Console", 0, 18)); // NOI18N
        pnlQuestion.add(txtAnswer);
        txtAnswer.setBounds(10, 160, 400, 29);

        lblCorrectAnswer.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        pnlQuestion.add(lblCorrectAnswer);
        lblCorrectAnswer.setBounds(10, 160, 400, 29);

        btnEnter.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btnEnter.setText("Enter");
        btnEnter.setFocusable(false);
        pnlQuestion.add(btnEnter);
        btnEnter.setBounds(410, 160, 100, 29);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnter;
    private javax.swing.JLabel lblCorrectAnswer;
    private javax.swing.JLabel lblQuestion;
    private javax.swing.JLabel lblTimer;
    private javax.swing.JPanel pnlQuestion;
    private javax.swing.JFormattedTextField txtAnswer;
    // End of variables declaration//GEN-END:variables
}