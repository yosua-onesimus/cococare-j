package cococare.framework.swing.view.form.wf;

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlWorkflowModule extends javax.swing.JPanel {

    public PnlWorkflowModule() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlWorkflowConfigurator = new javax.swing.JPanel();
        scrProcess = new javax.swing.JScrollPane();
        treeProcess = new javax.swing.JTree();
        tabEntity = new javax.swing.JTabbedPane();
        pnlList = new javax.swing.JPanel();
        pnlNorth = new javax.swing.JPanel();
        pnlNorthWest = new javax.swing.JPanel();
        btnAdd = new cococare.swing.component.CCButton();
        btnEdit = new cococare.swing.component.CCButton();
        btnDelete = new cococare.swing.component.CCButton();
        pnlNorthEast = new javax.swing.JPanel();
        txtKeyword = new javax.swing.JTextField();
        scrEntity = new javax.swing.JScrollPane();
        tblEntity = new javax.swing.JTable();
        pgnEntity = new cococare.swing.component.CCPaging();

        setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        setMinimumSize(new java.awt.Dimension(800, 200));
        setPreferredSize(new java.awt.Dimension(800, 200));

        pnlWorkflowConfigurator.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        pnlWorkflowConfigurator.setLayout(new java.awt.BorderLayout());

        scrProcess.setPreferredSize(new java.awt.Dimension(200, 200));

        treeProcess.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        scrProcess.setViewportView(treeProcess);

        pnlWorkflowConfigurator.add(scrProcess, java.awt.BorderLayout.WEST);

        tabEntity.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        pnlList.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        pnlList.setLayout(new java.awt.BorderLayout());

        pnlNorth.setPreferredSize(new java.awt.Dimension(10, 50));
        pnlNorth.setLayout(new java.awt.BorderLayout());

        pnlNorthWest.setPreferredSize(new java.awt.Dimension(300, 50));
        pnlNorthWest.setLayout(null);

        btnAdd.setType(cococare.swing.component.CCButton.Type.ADD);
        pnlNorthWest.add(btnAdd);
        btnAdd.setBounds(0, 10, 100, 29);

        btnEdit.setType(cococare.swing.component.CCButton.Type.EDIT);
        pnlNorthWest.add(btnEdit);
        btnEdit.setBounds(100, 10, 100, 29);

        btnDelete.setType(cococare.swing.component.CCButton.Type.DELETE);
        pnlNorthWest.add(btnDelete);
        btnDelete.setBounds(200, 10, 100, 29);

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

        tabEntity.addTab(null, pnlList);

        pnlWorkflowConfigurator.add(tabEntity, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlWorkflowConfigurator, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlWorkflowConfigurator, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private cococare.swing.component.CCButton btnAdd;
    private cococare.swing.component.CCButton btnDelete;
    private cococare.swing.component.CCButton btnEdit;
    private cococare.swing.component.CCPaging pgnEntity;
    private javax.swing.JPanel pnlList;
    private javax.swing.JPanel pnlNorth;
    private javax.swing.JPanel pnlNorthEast;
    private javax.swing.JPanel pnlNorthWest;
    private javax.swing.JPanel pnlWorkflowConfigurator;
    private javax.swing.JScrollPane scrEntity;
    private javax.swing.JScrollPane scrProcess;
    private javax.swing.JTabbedPane tabEntity;
    private javax.swing.JTable tblEntity;
    private javax.swing.JTree treeProcess;
    private javax.swing.JTextField txtKeyword;
    // End of variables declaration//GEN-END:variables
}