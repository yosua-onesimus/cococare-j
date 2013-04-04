package view.form.inv;

public class PnlEmployee extends javax.swing.JPanel {

    public PnlEmployee() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlEditor = new javax.swing.JPanel();
        btnEdit = new cococare.swing.component.CCButton();
        btnCancel = new cococare.swing.component.CCButton();
        btnSave = new cococare.swing.component.CCButton();
        btnClose = new cococare.swing.component.CCButton();
        xCode = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        xName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        separator = new javax.swing.JSeparator();
        xInventory = new javax.swing.JLabel();
        bndInventory = new cococare.swing.component.CCBandBox();
        btnAddInventory = new cococare.swing.component.CCButton();
        btnRemoveInventory = new cococare.swing.component.CCButton();
        scrOwnership = new javax.swing.JScrollPane();
        tblOwnership = new javax.swing.JTable();

        setMinimumSize(new java.awt.Dimension(600, 400));
        setPreferredSize(new java.awt.Dimension(600, 400));

        pnlEditor.setMinimumSize(new java.awt.Dimension(600, 400));
        pnlEditor.setPreferredSize(new java.awt.Dimension(600, 400));
        pnlEditor.setLayout(null);

        btnEdit.setType(cococare.swing.component.CCButton.Type.EDIT);
        pnlEditor.add(btnEdit);
        btnEdit.setBounds(0, 10, 100, 29);

        btnCancel.setType(cococare.swing.component.CCButton.Type.CANCEL);
        pnlEditor.add(btnCancel);
        btnCancel.setBounds(100, 10, 100, 29);

        btnSave.setType(cococare.swing.component.CCButton.Type.SAVE);
        pnlEditor.add(btnSave);
        btnSave.setBounds(200, 10, 100, 29);

        btnClose.setType(cococare.swing.component.CCButton.Type.CLOSE);
        pnlEditor.add(btnClose);
        btnClose.setBounds(300, 10, 100, 29);

        xCode.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xCode.setText("Code");
        pnlEditor.add(xCode);
        xCode.setBounds(0, 50, 100, 29);

        txtCode.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        pnlEditor.add(txtCode);
        txtCode.setBounds(100, 50, 150, 29);

        xName.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xName.setText("Name");
        pnlEditor.add(xName);
        xName.setBounds(0, 80, 100, 29);

        txtName.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        pnlEditor.add(txtName);
        txtName.setBounds(100, 80, 250, 29);
        pnlEditor.add(separator);
        separator.setBounds(0, 120, 570, 5);

        xInventory.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xInventory.setText("Inventory");
        pnlEditor.add(xInventory);
        xInventory.setBounds(0, 130, 100, 29);

        bndInventory.setVisibleClearButton(false);
        pnlEditor.add(bndInventory);
        bndInventory.setBounds(100, 130, 250, 29);

        btnAddInventory.setType(cococare.swing.component.CCButton.Type.ADD);
        pnlEditor.add(btnAddInventory);
        btnAddInventory.setBounds(350, 130, 100, 29);

        btnRemoveInventory.setType(cococare.swing.component.CCButton.Type.REMOVE);
        pnlEditor.add(btnRemoveInventory);
        btnRemoveInventory.setBounds(450, 130, 120, 29);

        tblOwnership.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        scrOwnership.setViewportView(tblOwnership);

        pnlEditor.add(scrOwnership);
        scrOwnership.setBounds(0, 160, 570, 240);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlEditor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlEditor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private cococare.swing.component.CCBandBox bndInventory;
    private cococare.swing.component.CCButton btnAddInventory;
    private cococare.swing.component.CCButton btnCancel;
    private cococare.swing.component.CCButton btnClose;
    private cococare.swing.component.CCButton btnEdit;
    private cococare.swing.component.CCButton btnRemoveInventory;
    private cococare.swing.component.CCButton btnSave;
    private javax.swing.JPanel pnlEditor;
    private javax.swing.JScrollPane scrOwnership;
    private javax.swing.JSeparator separator;
    private javax.swing.JTable tblOwnership;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtName;
    private javax.swing.JLabel xCode;
    private javax.swing.JLabel xInventory;
    private javax.swing.JLabel xName;
    // End of variables declaration//GEN-END:variables
}