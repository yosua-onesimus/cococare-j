package view.form;

public class DlgGameOver extends javax.swing.JDialog {

    public DlgGameOver(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlGameOver = new javax.swing.JPanel();
        xGameOver = new javax.swing.JLabel();
        lblTurn = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        scrPlayer = new javax.swing.JScrollPane();
        tblPlayer = new javax.swing.JTable();
        btnOk = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Game Over");
        setResizable(false);

        pnlGameOver.setLayout(null);

        xGameOver.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xGameOver.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        xGameOver.setText("Permainan Berakhir");
        xGameOver.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pnlGameOver.add(xGameOver);
        xGameOver.setBounds(10, 10, 200, 29);

        lblTurn.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lblTurn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTurn.setText("x turns");
        lblTurn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        lblTurn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblTurn.setOpaque(true);
        pnlGameOver.add(lblTurn);
        lblTurn.setBounds(10, 40, 100, 29);

        lblTime.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lblTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTime.setText("x minutes");
        lblTime.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        lblTime.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblTime.setOpaque(true);
        pnlGameOver.add(lblTime);
        lblTime.setBounds(110, 40, 100, 29);

        tblPlayer.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        scrPlayer.setViewportView(tblPlayer);

        pnlGameOver.add(scrPlayer);
        scrPlayer.setBounds(10, 50, 200, 100);

        btnOk.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnOk.setText("OK");
        btnOk.setFocusable(false);
        pnlGameOver.add(btnOk);
        btnOk.setBounds(60, 160, 100, 29);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlGameOver, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlGameOver, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOk;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblTurn;
    private javax.swing.JPanel pnlGameOver;
    private javax.swing.JScrollPane scrPlayer;
    private javax.swing.JTable tblPlayer;
    private javax.swing.JLabel xGameOver;
    // End of variables declaration//GEN-END:variables
}