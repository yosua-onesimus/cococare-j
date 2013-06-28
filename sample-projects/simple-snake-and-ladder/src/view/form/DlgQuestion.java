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
        txtAnswer = new javax.swing.JTextField();
        lblTimer = new javax.swing.JLabel();
        btnEnter = new javax.swing.JButton();
        lblCorrectAnswer = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Question");
        setResizable(false);

        pnlQuestion.setLayout(null);

        lblQuestion.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lblQuestion.setText("Question");
        pnlQuestion.add(lblQuestion);
        lblQuestion.setBounds(10, 10, 300, 59);

        txtAnswer.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        pnlQuestion.add(txtAnswer);
        txtAnswer.setBounds(10, 70, 300, 29);

        lblTimer.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lblTimer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTimer.setText("Timer");
        lblTimer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pnlQuestion.add(lblTimer);
        lblTimer.setBounds(310, 10, 100, 59);

        btnEnter.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnEnter.setText("Enter");
        btnEnter.setFocusable(false);
        pnlQuestion.add(btnEnter);
        btnEnter.setBounds(310, 70, 100, 29);

        lblCorrectAnswer.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        pnlQuestion.add(lblCorrectAnswer);
        lblCorrectAnswer.setBounds(10, 100, 300, 29);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnter;
    private javax.swing.JLabel lblCorrectAnswer;
    private javax.swing.JLabel lblQuestion;
    private javax.swing.JLabel lblTimer;
    private javax.swing.JPanel pnlQuestion;
    private javax.swing.JTextField txtAnswer;
    // End of variables declaration//GEN-END:variables
}