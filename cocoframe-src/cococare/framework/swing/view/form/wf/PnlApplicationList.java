package cococare.framework.swing.view.form.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCLanguage;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlApplicationList extends javax.swing.JPanel {

    public PnlApplicationList() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabEntity = new javax.swing.JTabbedPane();
        pnlList = new javax.swing.JPanel();
        pnlNorth = new javax.swing.JPanel();
        pnlNorthWest = new javax.swing.JPanel();
        cmbActivity = new cococare.swing.component.CCComboBox();
        pnlNorthEast = new javax.swing.JPanel();
        _btnFilter = new cococare.swing.component.CCButton();
        pnlCenter = new javax.swing.JPanel();
        pnlEntity = new javax.swing.JPanel();
        scrEntity = new javax.swing.JScrollPane();
        tblEntity = new javax.swing.JTable();
        pgnEntity = new cococare.swing.component.CCPaging();
        pnlPool = new javax.swing.JPanel();
        scrPool = new javax.swing.JScrollPane();
        tblPool = new javax.swing.JTable();

        setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        setMinimumSize(new java.awt.Dimension(600, 200));
        setPreferredSize(new java.awt.Dimension(600, 200));

        tabEntity.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        pnlList.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        pnlList.setLayout(new java.awt.BorderLayout());

        pnlNorth.setPreferredSize(new java.awt.Dimension(10, 50));
        pnlNorth.setLayout(new java.awt.BorderLayout());

        pnlNorthWest.setPreferredSize(new java.awt.Dimension(500, 50));
        pnlNorthWest.setLayout(null);
        pnlNorthWest.add(cmbActivity);
        cmbActivity.setBounds(0, 10, 200, 29);

        pnlNorth.add(pnlNorthWest, java.awt.BorderLayout.WEST);

        pnlNorthEast.setPreferredSize(new java.awt.Dimension(100, 50));
        pnlNorthEast.setLayout(null);

        _btnFilter.setType(cococare.swing.component.CCButton.Type.FILTER);
        pnlNorthEast.add(_btnFilter);
        _btnFilter.setBounds(50, 10, 50, 29);

        pnlNorth.add(pnlNorthEast, java.awt.BorderLayout.EAST);

        pnlList.add(pnlNorth, java.awt.BorderLayout.NORTH);

        pnlCenter.setLayout(new javax.swing.BoxLayout(pnlCenter, javax.swing.BoxLayout.Y_AXIS));

        pnlEntity.setLayout(new java.awt.BorderLayout());

        tblEntity.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        scrEntity.setViewportView(tblEntity);

        pnlEntity.add(scrEntity, java.awt.BorderLayout.CENTER);
        pnlEntity.add(pgnEntity, java.awt.BorderLayout.SOUTH);

        pnlCenter.add(pnlEntity);

        pnlPool.setBorder(javax.swing.BorderFactory.createTitledBorder(null, CCLanguage.turn(CCLanguage.Pool_List), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12))); // NOI18N
        pnlPool.setLayout(new java.awt.BorderLayout());

        tblPool.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        scrPool.setViewportView(tblPool);

        pnlPool.add(scrPool, java.awt.BorderLayout.CENTER);

        pnlCenter.add(pnlPool);

        pnlList.add(pnlCenter, java.awt.BorderLayout.CENTER);

        tabEntity.addTab("", pnlList);

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
                .addComponent(tabEntity, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private cococare.swing.component.CCButton _btnFilter;
    private cococare.swing.component.CCComboBox cmbActivity;
    private cococare.swing.component.CCPaging pgnEntity;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlEntity;
    private javax.swing.JPanel pnlList;
    private javax.swing.JPanel pnlNorth;
    private javax.swing.JPanel pnlNorthEast;
    private javax.swing.JPanel pnlNorthWest;
    private javax.swing.JPanel pnlPool;
    private javax.swing.JScrollPane scrEntity;
    private javax.swing.JScrollPane scrPool;
    private javax.swing.JTabbedPane tabEntity;
    private javax.swing.JTable tblEntity;
    private javax.swing.JTable tblPool;
    // End of variables declaration//GEN-END:variables
}