package view.form;

/**
 * @author Yosua Onesimus
 * @since 13.07.20
 * @version 13.07.20
 */
public class PnlIntro extends javax.swing.JPanel {

    public PnlIntro() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlIntro = new javax.swing.JPanel();
        xTebakAngka = new javax.swing.JLabel();
        xDescription = new javax.swing.JLabel();
        btnStart = new cococare.swing.component.CCButton();
        xCreatedBy = new javax.swing.JLabel();
        lnkCococare = new cococare.swing.component.CCLink();
        lnkProgLearn = new cococare.swing.component.CCLink();

        setMinimumSize(new java.awt.Dimension(600, 400));

        pnlIntro.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnlIntro.setMinimumSize(new java.awt.Dimension(600, 400));
        pnlIntro.setPreferredSize(new java.awt.Dimension(600, 400));
        pnlIntro.setLayout(null);

        xTebakAngka.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        xTebakAngka.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        xTebakAngka.setText("Tebak Angka");
        xTebakAngka.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pnlIntro.add(xTebakAngka);
        xTebakAngka.setBounds(10, 10, 580, 60);

        xDescription.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        xDescription.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        xDescription.setText("Pikirkan satu angka diantara 1 dengan 31");
        xDescription.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pnlIntro.add(xDescription);
        xDescription.setBounds(10, 70, 580, 60);

        btnStart.setText("Mulai");
        pnlIntro.add(btnStart);
        btnStart.setBounds(250, 270, 100, 29);

        xCreatedBy.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        xCreatedBy.setText("created by:");
        pnlIntro.add(xCreatedBy);
        xCreatedBy.setBounds(10, 360, 70, 29);

        lnkCococare.setText("http://cococare.wordpress.com/");
        lnkCococare.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        pnlIntro.add(lnkCococare);
        lnkCococare.setBounds(80, 360, 200, 29);

        lnkProgLearn.setText("http://programminglearning.wordpress.com/2013/07/18/lomba-membuat-game-sederhana-sesuai-contoh-level-pemula/");
        lnkProgLearn.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        pnlIntro.add(lnkProgLearn);
        lnkProgLearn.setBounds(390, 360, 200, 29);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlIntro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlIntro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private cococare.swing.component.CCButton btnStart;
    private cococare.swing.component.CCLink lnkCococare;
    private cococare.swing.component.CCLink lnkProgLearn;
    private javax.swing.JPanel pnlIntro;
    private javax.swing.JLabel xCreatedBy;
    private javax.swing.JLabel xDescription;
    private javax.swing.JLabel xTebakAngka;
    // End of variables declaration//GEN-END:variables
}