package cococare.framework.swing.view.form.setup;

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlLanguageSetup extends javax.swing.JPanel {

    public PnlLanguageSetup() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlLanguage = new javax.swing.JPanel();
        pnlNorth = new javax.swing.JPanel();
        scrLanguage = new javax.swing.JScrollPane();
        tblLanguage = new javax.swing.JTable();

        pnlLanguage.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Language Setup", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12))); // NOI18N
        pnlLanguage.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        pnlLanguage.setMinimumSize(new java.awt.Dimension(600, 400));
        pnlLanguage.setLayout(new java.awt.BorderLayout());

        pnlNorth.setPreferredSize(new java.awt.Dimension(588, 60));

        javax.swing.GroupLayout pnlNorthLayout = new javax.swing.GroupLayout(pnlNorth);
        pnlNorth.setLayout(pnlNorthLayout);
        pnlNorthLayout.setHorizontalGroup(
            pnlNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 588, Short.MAX_VALUE)
        );
        pnlNorthLayout.setVerticalGroup(
            pnlNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        pnlLanguage.add(pnlNorth, java.awt.BorderLayout.NORTH);

        tblLanguage.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        scrLanguage.setViewportView(tblLanguage);

        pnlLanguage.add(scrLanguage, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlLanguage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlLanguage, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pnlLanguage;
    private javax.swing.JPanel pnlNorth;
    private javax.swing.JScrollPane scrLanguage;
    private javax.swing.JTable tblLanguage;
    // End of variables declaration//GEN-END:variables
}