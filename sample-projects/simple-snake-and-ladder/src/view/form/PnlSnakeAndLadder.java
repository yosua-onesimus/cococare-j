package view.form;

public class PnlSnakeAndLadder extends javax.swing.JPanel {

    public PnlSnakeAndLadder() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBoard = new javax.swing.JPanel();
        imgBoard = new cococare.swing.component.CCImage();
        pnlNavi = new javax.swing.JPanel();
        xHallOfFame = new javax.swing.JLabel();
        scrPlayer = new javax.swing.JScrollPane();
        tblPlayer = new javax.swing.JTable();
        lblPlayer = new javax.swing.JLabel();
        imgDice = new cococare.swing.component.CCImage();
        btnThrowDice = new javax.swing.JButton();
        separator1 = new javax.swing.JSeparator();
        btnNewGame = new javax.swing.JButton();
        btnEndGame = new javax.swing.JButton();

        pnlBoard.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlBoard.setMinimumSize(new java.awt.Dimension(800, 570));
        pnlBoard.setPreferredSize(new java.awt.Dimension(800, 570));
        pnlBoard.setLayout(null);

        imgBoard.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        imgBoard.setLayout(null);
        pnlBoard.add(imgBoard);
        imgBoard.setBounds(10, 10, 550, 550);

        pnlNavi.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlNavi.setLayout(null);

        xHallOfFame.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xHallOfFame.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        xHallOfFame.setText("Ranking Pemain");
        xHallOfFame.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pnlNavi.add(xHallOfFame);
        xHallOfFame.setBounds(10, 10, 200, 29);

        tblPlayer.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        scrPlayer.setViewportView(tblPlayer);

        pnlNavi.add(scrPlayer);
        scrPlayer.setBounds(10, 40, 200, 100);

        lblPlayer.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        lblPlayer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPlayer.setText("<html>Giliran ... untuk lempar dadu</html>");
        lblPlayer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pnlNavi.add(lblPlayer);
        lblPlayer.setBounds(20, 240, 180, 29);

        imgDice.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        imgDice.setIconAutoFit(true);
        imgDice.setIconProportion(true);

        javax.swing.GroupLayout imgDiceLayout = new javax.swing.GroupLayout(imgDice);
        imgDice.setLayout(imgDiceLayout);
        imgDiceLayout.setHorizontalGroup(
            imgDiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 96, Short.MAX_VALUE)
        );
        imgDiceLayout.setVerticalGroup(
            imgDiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 96, Short.MAX_VALUE)
        );

        pnlNavi.add(imgDice);
        imgDice.setBounds(60, 280, 100, 100);

        btnThrowDice.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnThrowDice.setText("Lempar Dadu");
        btnThrowDice.setFocusable(false);
        pnlNavi.add(btnThrowDice);
        btnThrowDice.setBounds(20, 390, 180, 29);
        pnlNavi.add(separator1);
        separator1.setBounds(0, 440, 220, 5);

        btnNewGame.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnNewGame.setText("Permainan Baru");
        btnNewGame.setFocusable(false);
        pnlNavi.add(btnNewGame);
        btnNewGame.setBounds(20, 460, 180, 29);

        btnEndGame.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnEndGame.setText("Akhiri Permainan");
        btnEndGame.setFocusable(false);
        pnlNavi.add(btnEndGame);
        btnEndGame.setBounds(20, 500, 180, 29);

        pnlBoard.add(pnlNavi);
        pnlNavi.setBounds(570, 10, 220, 550);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEndGame;
    private javax.swing.JButton btnNewGame;
    private javax.swing.JButton btnThrowDice;
    private cococare.swing.component.CCImage imgBoard;
    private cococare.swing.component.CCImage imgDice;
    private javax.swing.JLabel lblPlayer;
    private javax.swing.JPanel pnlBoard;
    private javax.swing.JPanel pnlNavi;
    private javax.swing.JScrollPane scrPlayer;
    private javax.swing.JSeparator separator1;
    private javax.swing.JTable tblPlayer;
    private javax.swing.JLabel xHallOfFame;
    // End of variables declaration//GEN-END:variables
}