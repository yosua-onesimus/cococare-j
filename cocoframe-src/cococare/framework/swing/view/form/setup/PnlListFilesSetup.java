package cococare.framework.swing.view.form.setup;

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlListFilesSetup extends javax.swing.JPanel {

    public PnlListFilesSetup() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlListFiles = new javax.swing.JPanel();
        pnlNorth = new javax.swing.JPanel();
        xNote = new javax.swing.JLabel();
        xFolder = new javax.swing.JLabel();
        txtFolder = new javax.swing.JTextField();
        btnBrowse = new cococare.swing.component.CCButton();
        btnCopy = new cococare.swing.component.CCButton();
        scrListFiles = new javax.swing.JScrollPane();
        tblListFiles = new javax.swing.JTable();

        setMinimumSize(new java.awt.Dimension(600, 400));

        pnlListFiles.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "List Files Setup", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12))); // NOI18N
        pnlListFiles.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        pnlListFiles.setLayout(new java.awt.BorderLayout());

        pnlNorth.setPreferredSize(new java.awt.Dimension(588, 60));

        xNote.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        xNote.setText("Copy the selected files below to a specific folder.");

        xFolder.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xFolder.setText("Folder");

        txtFolder.setEditable(false);
        txtFolder.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        btnBrowse.setText("Browse");

        btnCopy.setText("Copy");

        javax.swing.GroupLayout pnlNorthLayout = new javax.swing.GroupLayout(pnlNorth);
        pnlNorth.setLayout(pnlNorthLayout);
        pnlNorthLayout.setHorizontalGroup(
            pnlNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(xNote, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(pnlNorthLayout.createSequentialGroup()
                .addComponent(xFolder, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtFolder, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(btnBrowse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnCopy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88))
        );
        pnlNorthLayout.setVerticalGroup(
            pnlNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNorthLayout.createSequentialGroup()
                .addComponent(xNote, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(pnlNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xFolder, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFolder, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBrowse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCopy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pnlListFiles.add(pnlNorth, java.awt.BorderLayout.NORTH);

        tblListFiles.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        scrListFiles.setViewportView(tblListFiles);

        pnlListFiles.add(scrListFiles, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlListFiles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlListFiles, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private cococare.swing.component.CCButton btnBrowse;
    private cococare.swing.component.CCButton btnCopy;
    private javax.swing.JPanel pnlListFiles;
    private javax.swing.JPanel pnlNorth;
    private javax.swing.JScrollPane scrListFiles;
    private javax.swing.JTable tblListFiles;
    private javax.swing.JTextField txtFolder;
    private javax.swing.JLabel xFolder;
    private javax.swing.JLabel xNote;
    // End of variables declaration//GEN-END:variables
}