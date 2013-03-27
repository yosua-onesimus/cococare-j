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
        xLanguagePack = new javax.swing.JLabel();
        cmbLanguagePack = new javax.swing.JComboBox();
        btnLoad = new cococare.swing.component.CCButton();
        btnSave = new cococare.swing.component.CCButton();
        scrLanguage = new javax.swing.JScrollPane();
        tblLanguage = new javax.swing.JTable();

        pnlLanguage.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Language Setup", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12))); // NOI18N
        pnlLanguage.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        pnlLanguage.setMinimumSize(new java.awt.Dimension(600, 400));
        pnlLanguage.setLayout(new java.awt.BorderLayout());

        pnlNorth.setPreferredSize(new java.awt.Dimension(588, 30));

        xLanguagePack.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xLanguagePack.setText("Language Pack");

        cmbLanguagePack.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        btnLoad.setText("Load");

        btnSave.setText("Save");
        btnSave.setType(cococare.swing.component.CCButton.Type.SAVE);

        javax.swing.GroupLayout pnlNorthLayout = new javax.swing.GroupLayout(pnlNorth);
        pnlNorth.setLayout(pnlNorthLayout);
        pnlNorthLayout.setHorizontalGroup(
            pnlNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNorthLayout.createSequentialGroup()
                .addComponent(xLanguagePack, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(cmbLanguagePack, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnLoad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlNorthLayout.setVerticalGroup(
            pnlNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(xLanguagePack, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(cmbLanguagePack, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnLoad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    private cococare.swing.component.CCButton btnLoad;
    private cococare.swing.component.CCButton btnSave;
    private javax.swing.JComboBox cmbLanguagePack;
    private javax.swing.JPanel pnlLanguage;
    private javax.swing.JPanel pnlNorth;
    private javax.swing.JScrollPane scrLanguage;
    private javax.swing.JTable tblLanguage;
    private javax.swing.JLabel xLanguagePack;
    // End of variables declaration//GEN-END:variables
}