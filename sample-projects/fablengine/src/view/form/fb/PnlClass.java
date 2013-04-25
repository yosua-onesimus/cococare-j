package view.form.fb;

public class PnlClass extends javax.swing.JPanel {

    public PnlClass() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlEditor = new javax.swing.JPanel();
        btnEdit = new cococare.swing.component.CCButton();
        btnSave = new cococare.swing.component.CCButton();
        btnClose = new cococare.swing.component.CCButton();
        xName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        xHp = new javax.swing.JLabel();
        txtHp = new javax.swing.JTextField();
        xAp = new javax.swing.JLabel();
        txtAp = new javax.swing.JTextField();
        xOffense = new javax.swing.JLabel();
        txtOffense = new javax.swing.JTextField();
        xDefense = new javax.swing.JLabel();
        txtDefense = new javax.swing.JTextField();
        xEssence = new javax.swing.JLabel();
        txtEssence = new javax.swing.JTextField();
        xVelense = new javax.swing.JLabel();
        txtVelense = new javax.swing.JTextField();
        xHitRate = new javax.swing.JLabel();
        txtHitRate = new javax.swing.JTextField();
        xCrtRate = new javax.swing.JLabel();
        txtCrtRate = new javax.swing.JTextField();

        setMinimumSize(new java.awt.Dimension(600, 400));
        setPreferredSize(new java.awt.Dimension(600, 400));

        pnlEditor.setMinimumSize(new java.awt.Dimension(600, 400));
        pnlEditor.setPreferredSize(new java.awt.Dimension(600, 400));

        btnEdit.setType(cococare.swing.component.CCButton.Type.EDIT);

        btnSave.setType(cococare.swing.component.CCButton.Type.SAVE);

        btnClose.setType(cococare.swing.component.CCButton.Type.CLOSE);

        xName.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xName.setText("Name");

        txtName.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        xHp.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xHp.setText("Health Point");

        txtHp.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        xAp.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xAp.setText("Action Point");

        txtAp.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        xOffense.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xOffense.setText("Offense");

        txtOffense.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        xDefense.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xDefense.setText("Defense");

        txtDefense.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        xEssence.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xEssence.setText("Essence");

        txtEssence.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        xVelense.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xVelense.setText("Velense");

        txtVelense.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        xHitRate.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xHitRate.setText("Hit Rate (%)");

        txtHitRate.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        xCrtRate.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xCrtRate.setText("Crt Rate (%)");

        txtCrtRate.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

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
                .addComponent(xName, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlEditorLayout.createSequentialGroup()
                .addComponent(xHp, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtHp, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(xAp, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtAp, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlEditorLayout.createSequentialGroup()
                .addComponent(xOffense, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtOffense, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(xDefense, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtDefense, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlEditorLayout.createSequentialGroup()
                .addComponent(xEssence, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtEssence, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(xVelense, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtVelense, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlEditorLayout.createSequentialGroup()
                .addComponent(xHitRate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtHitRate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(xCrtRate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtCrtRate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(xName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xHp, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHp, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xAp, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAp, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xOffense, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOffense, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xDefense, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDefense, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xEssence, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEssence, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xVelense, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVelense, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xHitRate, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHitRate, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xCrtRate, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCrtRate, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
    private javax.swing.JPanel pnlEditor;
    private javax.swing.JTextField txtAp;
    private javax.swing.JTextField txtCrtRate;
    private javax.swing.JTextField txtDefense;
    private javax.swing.JTextField txtEssence;
    private javax.swing.JTextField txtHitRate;
    private javax.swing.JTextField txtHp;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtOffense;
    private javax.swing.JTextField txtVelense;
    private javax.swing.JLabel xAp;
    private javax.swing.JLabel xCrtRate;
    private javax.swing.JLabel xDefense;
    private javax.swing.JLabel xEssence;
    private javax.swing.JLabel xHitRate;
    private javax.swing.JLabel xHp;
    private javax.swing.JLabel xName;
    private javax.swing.JLabel xOffense;
    private javax.swing.JLabel xVelense;
    // End of variables declaration//GEN-END:variables
}