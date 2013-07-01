package view.form;

public class PnlEnigmaSquare extends javax.swing.JPanel {

    public PnlEnigmaSquare() {
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
        separator1 = new javax.swing.JSeparator();
        imgPlayerIcon = new cococare.swing.component.CCImage();
        lblPlayerName = new javax.swing.JLabel();
        imgDice = new cococare.swing.component.CCImage();
        btnRollDice = new javax.swing.JButton();
        separator2 = new javax.swing.JSeparator();
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
        xHallOfFame.setText("Nilai Pemain");
        xHallOfFame.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        xHallOfFame.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        xHallOfFame.setOpaque(true);
        pnlNavi.add(xHallOfFame);
        xHallOfFame.setBounds(20, 20, 180, 24);

        tblPlayer.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        scrPlayer.setViewportView(tblPlayer);

        pnlNavi.add(scrPlayer);
        scrPlayer.setBounds(20, 30, 180, 100);
        pnlNavi.add(separator1);
        separator1.setBounds(0, 150, 220, 5);

        imgPlayerIcon.setIconAutoFit(true);
        imgPlayerIcon.setIconProportion(true);

        javax.swing.GroupLayout imgPlayerIconLayout = new javax.swing.GroupLayout(imgPlayerIcon);
        imgPlayerIcon.setLayout(imgPlayerIconLayout);
        imgPlayerIconLayout.setHorizontalGroup(
            imgPlayerIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );
        imgPlayerIconLayout.setVerticalGroup(
            imgPlayerIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        pnlNavi.add(imgPlayerIcon);
        imgPlayerIcon.setBounds(80, 170, 60, 60);

        lblPlayerName.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblPlayerName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPlayerName.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pnlNavi.add(lblPlayerName);
        lblPlayerName.setBounds(10, 230, 200, 49);

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

        btnRollDice.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnRollDice.setText("Lempar Dadu");
        btnRollDice.setFocusable(false);
        pnlNavi.add(btnRollDice);
        btnRollDice.setBounds(20, 390, 180, 29);
        pnlNavi.add(separator2);
        separator2.setBounds(0, 440, 220, 5);

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
    private javax.swing.JButton btnRollDice;
    private cococare.swing.component.CCImage imgBoard;
    private cococare.swing.component.CCImage imgDice;
    private cococare.swing.component.CCImage imgPlayerIcon;
    private javax.swing.JLabel lblPlayerName;
    private javax.swing.JPanel pnlBoard;
    private javax.swing.JPanel pnlNavi;
    private javax.swing.JScrollPane scrPlayer;
    private javax.swing.JSeparator separator1;
    private javax.swing.JSeparator separator2;
    private javax.swing.JTable tblPlayer;
    private javax.swing.JLabel xHallOfFame;
    // End of variables declaration//GEN-END:variables
}