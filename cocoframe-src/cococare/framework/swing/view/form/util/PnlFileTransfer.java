package cococare.framework.swing.view.form.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCLanguage;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlFileTransfer extends javax.swing.JPanel {

    public PnlFileTransfer() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFileTransfer = new javax.swing.JPanel();
        attFileTransfer = new cococare.swing.component.CCAttachment();
        btnStoreFile = new cococare.swing.component.CCButton();
        btnRetrieveFile = new cococare.swing.component.CCButton();
        btnClose = new cococare.swing.component.CCButton();
        scrFileTransfer = new javax.swing.JScrollPane();
        tblFileTransfer = new javax.swing.JTable();

        setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        setMinimumSize(new java.awt.Dimension(600, 400));
        setPreferredSize(new java.awt.Dimension(600, 400));

        pnlFileTransfer.setBorder(javax.swing.BorderFactory.createTitledBorder(null, CCLanguage.turn(CCLanguage.File_Transfer), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12))); // NOI18N
        pnlFileTransfer.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        btnStoreFile.setMnemonic('S');
        btnStoreFile.setText("Store File");
        btnStoreFile.setToolTipText("Store File");

        btnRetrieveFile.setMnemonic('R');
        btnRetrieveFile.setText("Retrieve File");
        btnRetrieveFile.setToolTipText("Retrieve File");

        btnClose.setToolTipText("");
        btnClose.setType(cococare.swing.component.CCButton.Type.CLOSE);

        tblFileTransfer.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        scrFileTransfer.setViewportView(tblFileTransfer);

        javax.swing.GroupLayout pnlFileTransferLayout = new javax.swing.GroupLayout(pnlFileTransfer);
        pnlFileTransfer.setLayout(pnlFileTransferLayout);
        pnlFileTransferLayout.setHorizontalGroup(
            pnlFileTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFileTransferLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(pnlFileTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFileTransferLayout.createSequentialGroup()
                        .addComponent(attFileTransfer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(pnlFileTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnStoreFile, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRetrieveFile, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scrFileTransfer, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        pnlFileTransferLayout.setVerticalGroup(
            pnlFileTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFileTransferLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(pnlFileTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(attFileTransfer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlFileTransferLayout.createSequentialGroup()
                        .addComponent(btnStoreFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(btnRetrieveFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(scrFileTransfer, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFileTransfer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFileTransfer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private cococare.swing.component.CCAttachment attFileTransfer;
    private cococare.swing.component.CCButton btnClose;
    private cococare.swing.component.CCButton btnRetrieveFile;
    private cococare.swing.component.CCButton btnStoreFile;
    private javax.swing.JPanel pnlFileTransfer;
    private javax.swing.JScrollPane scrFileTransfer;
    private javax.swing.JTable tblFileTransfer;
    // End of variables declaration//GEN-END:variables
}