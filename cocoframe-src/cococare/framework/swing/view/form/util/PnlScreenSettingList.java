package cococare.framework.swing.view.form.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCLanguage;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlScreenSettingList extends javax.swing.JPanel {

    public PnlScreenSettingList() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabEntity = new javax.swing.JTabbedPane();
        pnlList = new javax.swing.JPanel();
        pnlNorth = new javax.swing.JPanel();
        pnlNorthWest = new javax.swing.JPanel();
        cmbEntity = new cococare.swing.component.CCComboBox();
        btnEdit = new cococare.swing.component.CCButton();
        pnlNorthEast = new javax.swing.JPanel();
        txtKeyword = new javax.swing.JTextField();
        scrEntity = new javax.swing.JScrollPane();
        tblEntity = new javax.swing.JTable();
        pgnEntity = new cococare.swing.component.CCPaging();

        setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        setMinimumSize(new java.awt.Dimension(600, 400));
        setPreferredSize(new java.awt.Dimension(600, 400));

        tabEntity.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        pnlList.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        pnlList.setLayout(new java.awt.BorderLayout());

        pnlNorth.setPreferredSize(new java.awt.Dimension(10, 50));
        pnlNorth.setLayout(new java.awt.BorderLayout());

        pnlNorthWest.setPreferredSize(new java.awt.Dimension(500, 50));
        pnlNorthWest.setLayout(null);
        pnlNorthWest.add(cmbEntity);
        cmbEntity.setBounds(0, 10, 150, 29);

        btnEdit.setType(cococare.swing.component.CCButton.Type.EDIT);
        pnlNorthWest.add(btnEdit);
        btnEdit.setBounds(150, 10, 100, 29);

        pnlNorth.add(pnlNorthWest, java.awt.BorderLayout.WEST);

        pnlNorthEast.setPreferredSize(new java.awt.Dimension(100, 50));
        pnlNorthEast.setLayout(null);

        txtKeyword.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        pnlNorthEast.add(txtKeyword);
        txtKeyword.setBounds(0, 10, 100, 29);

        pnlNorth.add(pnlNorthEast, java.awt.BorderLayout.EAST);

        pnlList.add(pnlNorth, java.awt.BorderLayout.NORTH);

        tblEntity.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        scrEntity.setViewportView(tblEntity);

        pnlList.add(scrEntity, java.awt.BorderLayout.CENTER);
        pnlList.add(pgnEntity, java.awt.BorderLayout.SOUTH);

        tabEntity.addTab(CCLanguage.turn(CCLanguage.Screen_Setting), pnlList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabEntity, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabEntity, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private cococare.swing.component.CCButton btnEdit;
    private cococare.swing.component.CCComboBox cmbEntity;
    private cococare.swing.component.CCPaging pgnEntity;
    private javax.swing.JPanel pnlList;
    private javax.swing.JPanel pnlNorth;
    private javax.swing.JPanel pnlNorthEast;
    private javax.swing.JPanel pnlNorthWest;
    private javax.swing.JScrollPane scrEntity;
    private javax.swing.JTabbedPane tabEntity;
    private javax.swing.JTable tblEntity;
    private javax.swing.JTextField txtKeyword;
    // End of variables declaration//GEN-END:variables
}