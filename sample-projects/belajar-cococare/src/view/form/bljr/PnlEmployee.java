package view.form.bljr;

public class PnlEmployee extends javax.swing.JPanel {

    public PnlEmployee() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlEditor = new javax.swing.JPanel();
        btnEdit = new cococare.swing.component.CCButton();
        btnSave = new cococare.swing.component.CCButton();
        btnClose = new cococare.swing.component.CCButton();
        xCode = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        xName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        xBirthPlace = new javax.swing.JLabel();
        txtBirthPlace = new javax.swing.JTextField();
        xBirthDate = new javax.swing.JLabel();
        dtpBirthDate = new cococare.swing.component.CCDatePicker();
        xGender = new javax.swing.JLabel();
        cmbGender = new javax.swing.JComboBox();
        xBloodType = new javax.swing.JLabel();
        cmbBloodType = new javax.swing.JComboBox();
        xPhone = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        xEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        xPhoto = new javax.swing.JLabel();
        attPhoto = new cococare.swing.component.CCAttachment();

        setMinimumSize(new java.awt.Dimension(600, 400));
        setPreferredSize(new java.awt.Dimension(600, 400));

        pnlEditor.setLayout(null);

        btnEdit.setType(cococare.swing.component.CCButton.Type.EDIT);
        pnlEditor.add(btnEdit);
        btnEdit.setBounds(0, 10, 100, 29);

        btnSave.setType(cococare.swing.component.CCButton.Type.SAVE);
        pnlEditor.add(btnSave);
        btnSave.setBounds(100, 10, 100, 29);

        btnClose.setType(cococare.swing.component.CCButton.Type.CLOSE);
        pnlEditor.add(btnClose);
        btnClose.setBounds(200, 10, 100, 29);

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

        xBirthPlace.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xBirthPlace.setText("Birth Place");
        pnlEditor.add(xBirthPlace);
        xBirthPlace.setBounds(0, 110, 100, 29);

        txtBirthPlace.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        pnlEditor.add(txtBirthPlace);
        txtBirthPlace.setBounds(100, 110, 150, 29);

        xBirthDate.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xBirthDate.setText(",");
        pnlEditor.add(xBirthDate);
        xBirthDate.setBounds(250, 110, 10, 29);
        pnlEditor.add(dtpBirthDate);
        dtpBirthDate.setBounds(260, 110, 130, 29);

        xGender.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xGender.setText("Gender");
        pnlEditor.add(xGender);
        xGender.setBounds(0, 140, 100, 29);
        pnlEditor.add(cmbGender);
        cmbGender.setBounds(100, 140, 150, 29);

        xBloodType.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xBloodType.setText("BloodType");
        pnlEditor.add(xBloodType);
        xBloodType.setBounds(0, 170, 100, 29);
        pnlEditor.add(cmbBloodType);
        cmbBloodType.setBounds(100, 170, 150, 29);

        xPhone.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xPhone.setText("Phone");
        pnlEditor.add(xPhone);
        xPhone.setBounds(0, 200, 100, 29);

        txtPhone.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        pnlEditor.add(txtPhone);
        txtPhone.setBounds(100, 200, 150, 29);

        xEmail.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xEmail.setText("Email");
        pnlEditor.add(xEmail);
        xEmail.setBounds(0, 230, 100, 29);

        txtEmail.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        pnlEditor.add(txtEmail);
        txtEmail.setBounds(100, 230, 250, 29);

        xPhoto.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xPhoto.setText("Photo");
        pnlEditor.add(xPhoto);
        xPhoto.setBounds(0, 260, 100, 29);
        pnlEditor.add(attPhoto);
        attPhoto.setBounds(100, 260, 330, 60);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlEditor, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlEditor, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private cococare.swing.component.CCAttachment attPhoto;
    private cococare.swing.component.CCButton btnClose;
    private cococare.swing.component.CCButton btnEdit;
    private cococare.swing.component.CCButton btnSave;
    private javax.swing.JComboBox cmbBloodType;
    private javax.swing.JComboBox cmbGender;
    private cococare.swing.component.CCDatePicker dtpBirthDate;
    private javax.swing.JPanel pnlEditor;
    private javax.swing.JTextField txtBirthPlace;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JLabel xBirthDate;
    private javax.swing.JLabel xBirthPlace;
    private javax.swing.JLabel xBloodType;
    private javax.swing.JLabel xCode;
    private javax.swing.JLabel xEmail;
    private javax.swing.JLabel xGender;
    private javax.swing.JLabel xName;
    private javax.swing.JLabel xPhone;
    private javax.swing.JLabel xPhoto;
    // End of variables declaration//GEN-END:variables
}