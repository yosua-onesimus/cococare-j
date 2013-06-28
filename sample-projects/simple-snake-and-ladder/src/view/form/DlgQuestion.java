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
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Question");
        setResizable(false);

        pnlQuestion.setLayout(null);

        jLabel1.setText("Question");
        pnlQuestion.add(jLabel1);
        jLabel1.setBounds(50, 30, 330, 60);
        pnlQuestion.add(jTextField1);
        jTextField1.setBounds(50, 120, 360, 20);

        jButton1.setText("jButton1");
        pnlQuestion.add(jButton1);
        jButton1.setBounds(420, 120, 73, 23);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Timer");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pnlQuestion.add(jLabel2);
        jLabel2.setBounds(420, 30, 70, 60);

        jLabel3.setText("jLabel3");
        pnlQuestion.add(jLabel3);
        jLabel3.setBounds(50, 170, 450, 60);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 92, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel pnlQuestion;
    // End of variables declaration//GEN-END:variables
}