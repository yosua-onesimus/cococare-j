package view.form.fb;

public class PnlAction extends javax.swing.JPanel {

    public PnlAction() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlEditor = new javax.swing.JPanel();
        btnEdit = new cococare.swing.component.CCButton();
        btnSave = new cococare.swing.component.CCButton();
        btnClose = new cococare.swing.component.CCButton();
        xActionType = new javax.swing.JLabel();
        cmbActionType = new javax.swing.JComboBox();
        xName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        xDescription = new javax.swing.JLabel();
        txtDescription = new javax.swing.JTextField();
        xCondition = new javax.swing.JLabel();
        txtCondition = new javax.swing.JTextField();
        xFormulaPre = new javax.swing.JLabel();
        txtFormulaPre = new javax.swing.JTextField();
        xFormulaMain = new javax.swing.JLabel();
        txtFormulaMain = new javax.swing.JTextField();
        xFormulaPost = new javax.swing.JLabel();
        txtFormulaPost = new javax.swing.JTextField();

        setMinimumSize(new java.awt.Dimension(600, 400));
        setPreferredSize(new java.awt.Dimension(600, 400));

        pnlEditor.setMinimumSize(new java.awt.Dimension(600, 400));
        pnlEditor.setPreferredSize(new java.awt.Dimension(600, 400));

        btnEdit.setType(cococare.swing.component.CCButton.Type.EDIT);

        btnSave.setType(cococare.swing.component.CCButton.Type.SAVE);

        btnClose.setType(cococare.swing.component.CCButton.Type.CLOSE);

        xActionType.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xActionType.setText("Type");

        cmbActionType.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        xName.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xName.setText("Name");

        txtName.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        xDescription.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xDescription.setText("Description");

        txtDescription.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        xCondition.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xCondition.setText("Condition");

        txtCondition.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        xFormulaPre.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xFormulaPre.setText("Formula (Pre)");

        txtFormulaPre.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        xFormulaMain.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xFormulaMain.setText("Formula (Main)");

        txtFormulaMain.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        xFormulaPost.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xFormulaPost.setText("Formula (Post)");

        txtFormulaPost.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        javax.swing.GroupLayout pnlEditorLayout = new javax.swing.GroupLayout(pnlEditor);
        pnlEditor.setLayout(pnlEditorLayout);
        pnlEditorLayout.setHorizontalGroup(
            pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditorLayout.createSequentialGroup()
                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlEditorLayout.createSequentialGroup()
                .addComponent(xActionType, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(cmbActionType, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlEditorLayout.createSequentialGroup()
                .addComponent(xName, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlEditorLayout.createSequentialGroup()
                .addComponent(xDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlEditorLayout.createSequentialGroup()
                .addComponent(xCondition, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtCondition, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlEditorLayout.createSequentialGroup()
                .addComponent(xFormulaPre, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtFormulaPre, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlEditorLayout.createSequentialGroup()
                .addComponent(xFormulaMain, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtFormulaMain, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlEditorLayout.createSequentialGroup()
                .addComponent(xFormulaPost, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtFormulaPost, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlEditorLayout.setVerticalGroup(
            pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditorLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xActionType, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbActionType, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xCondition, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCondition, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xFormulaPre, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFormulaPre, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xFormulaMain, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFormulaMain, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xFormulaPost, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFormulaPost, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

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
    private cococare.swing.component.CCButton btnClose;
    private cococare.swing.component.CCButton btnEdit;
    private cococare.swing.component.CCButton btnSave;
    private javax.swing.JComboBox cmbActionType;
    private javax.swing.JPanel pnlEditor;
    private javax.swing.JTextField txtCondition;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtFormulaMain;
    private javax.swing.JTextField txtFormulaPost;
    private javax.swing.JTextField txtFormulaPre;
    private javax.swing.JTextField txtName;
    private javax.swing.JLabel xActionType;
    private javax.swing.JLabel xCondition;
    private javax.swing.JLabel xDescription;
    private javax.swing.JLabel xFormulaMain;
    private javax.swing.JLabel xFormulaPost;
    private javax.swing.JLabel xFormulaPre;
    private javax.swing.JLabel xName;
    // End of variables declaration//GEN-END:variables
}