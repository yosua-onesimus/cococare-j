package view.form.alpha;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFormat;
import cococare.common.CCSprite;
import cococare.datafile.CCImage;
import cococare.swing.CCSwing;
import cococare.swing.CCSwing.LookAndFeel;
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
//</editor-fold>

public class DlgSnakeAndLadder extends javax.swing.JDialog {

    private static final String LEFT = "LEFT";
    private static final String RIGHT = "RIGHT";
    private BufferedImage[] bufferedImages = CCImage.splitImages(CCImage.getImage(getClass().getResource("/resource/mario-luigi.png")), 12, 8);
    private CCSprite sprite1;
    private CCSprite sprite2;
    private int score1 = 1;
    private int score2 = 1;

    public DlgSnakeAndLadder(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        _init();
    }

    private void _init() {
        //init board
        int text = 100;
        for (int y = 0; y < 10; y++) {
            if (y % 2 == 0) {
                for (int x = 0; x < 10; x++) {
                    _newLabel(null, CCFormat.getString(text--), 60 * x, 60 * y);
                }
            } else if (y % 2 == 1) {
                for (int x = 9; x > -1; x--) {
                    _newLabel(null, CCFormat.getString(text--), 60 * x, 60 * y);
                }
            }
        }
        //init sprite
        sprite1 = new CCSprite(bufferedImages, pnlBoard, 0, 0);
        sprite1.addScene(LEFT, 39, 40, 41);
        sprite1.addScene(RIGHT, 15, 16, 17);
        sprite1.setScene(RIGHT);
        _spriteAlter(sprite1, score1);
        sprite1.play();
        sprite2 = new CCSprite(bufferedImages, pnlBoard, 0, 0);
        sprite2.addScene(LEFT, 36, 37, 38);
        sprite2.addScene(RIGHT, 12, 13, 14);
        sprite2.setScene(RIGHT);
        _spriteAlter(sprite2, score2);
        sprite2.play();
    }

    private void _newLabel(Icon icon, String text, int x, int y) {
        JLabel label = new JLabel();
        label.setBorder(BorderFactory.createEtchedBorder());
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setHorizontalTextPosition(SwingConstants.CENTER);
        label.setIcon(icon);
        label.setText(text);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setVerticalTextPosition(SwingConstants.CENTER);
        pnlBoard.add(label);
        label.setBounds(x, y, 60, 60);
    }

    private void _spriteAlter(CCSprite sprite, int score) {
        int x = ((score - 1) / 10) % 2 == 0 ? ((score - 1) % 10) * 60 : 540 - ((score - 1) % 10) * 60;
        int y = 560 - ((score - 1) / 10) * 60;
        sprite.alter(x, y);
    }

    public static void main(String[] args) {
        //set look and feel
        CCSwing.setLookAndFeel(LookAndFeel.WINDOWS.getName(), null);
        //
        DlgSnakeAndLadder dlgSnakeAndLadder = new DlgSnakeAndLadder(null, false);
        CCSwing.centerScreen(dlgSnakeAndLadder);
        dlgSnakeAndLadder.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBoard = new cococare.swing.component.CCImage();
        pnlNavigation = new cococare.swing.component.CCImage();
        xSnakeAndLadder = new javax.swing.JLabel();
        lblDice = new javax.swing.JLabel();
        lblPlayerTurn = new javax.swing.JLabel();
        btnRollDice = new cococare.swing.component.CCButton();
        pnlLogo = new cococare.swing.component.CCImage();
        btnNewGames = new cococare.swing.component.CCButton();
        btnClose = new cococare.swing.component.CCButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setUndecorated(true);

        pnlBoard.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnlBoard.setLayout(null);

        pnlNavigation.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnlNavigation.setLayout(null);

        xSnakeAndLadder.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        xSnakeAndLadder.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        xSnakeAndLadder.setText("Snake And Ladder");
        xSnakeAndLadder.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pnlNavigation.add(xSnakeAndLadder);
        xSnakeAndLadder.setBounds(0, 10, 200, 40);

        lblDice.setFont(new java.awt.Font("Verdana", 1, 48)); // NOI18N
        lblDice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDice.setText("6");
        lblDice.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pnlNavigation.add(lblDice);
        lblDice.setBounds(40, 90, 120, 120);

        lblPlayerTurn.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lblPlayerTurn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPlayerTurn.setText("Player 1 Turn");
        lblPlayerTurn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pnlNavigation.add(lblPlayerTurn);
        lblPlayerTurn.setBounds(40, 210, 120, 30);

        btnRollDice.setMnemonic('R');
        btnRollDice.setText("Roll Dice");
        btnRollDice.setToolTipText("Roll Dice");
        btnRollDice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRollDiceActionPerformed(evt);
            }
        });
        pnlNavigation.add(btnRollDice);
        btnRollDice.setBounds(40, 240, 120, 29);

        pnlLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/mario-luigi.jpg"))); // NOI18N
        pnlLogo.setIconAutoFit(true);

        javax.swing.GroupLayout pnlLogoLayout = new javax.swing.GroupLayout(pnlLogo);
        pnlLogo.setLayout(pnlLogoLayout);
        pnlLogoLayout.setHorizontalGroup(
            pnlLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );
        pnlLogoLayout.setVerticalGroup(
            pnlLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );

        pnlNavigation.add(pnlLogo);
        pnlLogo.setBounds(40, 380, 120, 120);

        btnNewGames.setMnemonic('N');
        btnNewGames.setText("New Game");
        btnNewGames.setToolTipText("New Game");
        btnNewGames.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewGamesActionPerformed(evt);
            }
        });
        pnlNavigation.add(btnNewGames);
        btnNewGames.setBounds(50, 530, 100, 29);

        btnClose.setMnemonic('C');
        btnClose.setText("Close");
        btnClose.setToolTipText("");
        btnClose.setType(cococare.swing.component.CCButton.Type.DELETE);
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        pnlNavigation.add(btnClose);
        btnClose.setBounds(50, 560, 100, 29);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlNavigation, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pnlNavigation, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnNewGamesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewGamesActionPerformed
        _spriteAlter(sprite1, score1 = 1);
        _spriteAlter(sprite2, score2 = 1);
    }//GEN-LAST:event_btnNewGamesActionPerformed

    private void btnRollDiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRollDiceActionPerformed
        Random random = new Random();
        int nextInt = random.nextInt(6) + 1;
        _spriteAlter(sprite1, score1 += nextInt);
//        repaint();
    }//GEN-LAST:event_btnRollDiceActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private cococare.swing.component.CCButton btnClose;
    private cococare.swing.component.CCButton btnNewGames;
    private cococare.swing.component.CCButton btnRollDice;
    private javax.swing.JLabel lblDice;
    private javax.swing.JLabel lblPlayerTurn;
    private cococare.swing.component.CCImage pnlBoard;
    private cococare.swing.component.CCImage pnlLogo;
    private cococare.swing.component.CCImage pnlNavigation;
    private javax.swing.JLabel xSnakeAndLadder;
    // End of variables declaration//GEN-END:variables
}