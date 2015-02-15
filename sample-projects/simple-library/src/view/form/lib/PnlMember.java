package view.form.lib;

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlMember extends javax.swing.JPanel {

    public PnlMember() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlEditor = new javax.swing.JPanel();
        btnSave = new cococare.swing.component.CCButton();
        btnClose = new cococare.swing.component.CCButton();
        xCode = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        chkSuspend = new javax.swing.JCheckBox();
        xFullName = new javax.swing.JLabel();
        txtFullName = new javax.swing.JTextField();
        xBirthDate = new javax.swing.JLabel();
        dtpBirthDate = new cococare.swing.component.CCDatePicker();
        xGender = new javax.swing.JLabel();
        cmbGender = new javax.swing.JComboBox();
        xAddress = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        xRegency = new javax.swing.JLabel();
        cmbRegency = new javax.swing.JComboBox();
        xProvince = new javax.swing.JLabel();
        cmbProvince = new javax.swing.JComboBox();
        xPhone = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        xEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        xPhoto = new javax.swing.JLabel();
        attPhoto = new cococare.swing.component.CCAttachment();
        xKtp = new javax.swing.JLabel();
        txtKtp = new javax.swing.JTextField();

        setMinimumSize(new java.awt.Dimension(600, 500));
        setPreferredSize(new java.awt.Dimension(600, 500));

        btnSave.setType(cococare.swing.component.CCButton.Type.SAVE);

        btnClose.setType(cococare.swing.component.CCButton.Type.CLOSE);

        xCode.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xCode.setText("Code");

        txtCode.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        chkSuspend.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        chkSuspend.setText("Suspend");

        xFullName.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xFullName.setText("Full Name");

        txtFullName.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        xBirthDate.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xBirthDate.setText("Birth Date");

        xGender.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xGender.setText("Gender");

        cmbGender.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        xAddress.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xAddress.setText("Address");

        txtAddress.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        xRegency.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xRegency.setText("Regency");

        cmbRegency.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        xProvince.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xProvince.setText("Province");

        cmbProvince.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        xPhone.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xPhone.setText("Phone");

        txtPhone.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        xEmail.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xEmail.setText("Email");

        txtEmail.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        xPhoto.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xPhoto.setText("Photo");

        xKtp.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xKtp.setText("KTP");

        txtKtp.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        javax.swing.GroupLayout pnlEditorLayout = new javax.swing.GroupLayout(pnlEditor);
        pnlEditor.setLayout(pnlEditorLayout);
        pnlEditorLayout.setHorizontalGroup(
            pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditorLayout.createSequentialGroup()
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlEditorLayout.createSequentialGroup()
                .addComponent(xCode, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(chkSuspend, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlEditorLayout.createSequentialGroup()
                .addComponent(xFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlEditorLayout.createSequentialGroup()
                .addComponent(xBirthDate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(dtpBirthDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlEditorLayout.createSequentialGroup()
                .addComponent(xGender, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(cmbGender, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlEditorLayout.createSequentialGroup()
                .addComponent(xAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlEditorLayout.createSequentialGroup()
                .addComponent(xRegency, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(cmbRegency, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlEditorLayout.createSequentialGroup()
                .addComponent(xProvince, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(cmbProvince, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlEditorLayout.createSequentialGroup()
                .addComponent(xPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlEditorLayout.createSequentialGroup()
                .addComponent(xEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlEditorLayout.createSequentialGroup()
                .addComponent(xPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(attPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlEditorLayout.createSequentialGroup()
                .addComponent(xKtp, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtKtp, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlEditorLayout.setVerticalGroup(
            pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditorLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xCode, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkSuspend, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xBirthDate, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtpBirthDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xGender, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbGender, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xRegency, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbRegency, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xProvince, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbProvince, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(attPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xKtp, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKtp, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
    private cococare.swing.component.CCAttachment attPhoto;
    private cococare.swing.component.CCButton btnClose;
    private cococare.swing.component.CCButton btnSave;
    private javax.swing.JCheckBox chkSuspend;
    private javax.swing.JComboBox cmbGender;
    private javax.swing.JComboBox cmbProvince;
    private javax.swing.JComboBox cmbRegency;
    private cococare.swing.component.CCDatePicker dtpBirthDate;
    private javax.swing.JPanel pnlEditor;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFullName;
    private javax.swing.JTextField txtKtp;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JLabel xAddress;
    private javax.swing.JLabel xBirthDate;
    private javax.swing.JLabel xCode;
    private javax.swing.JLabel xEmail;
    private javax.swing.JLabel xFullName;
    private javax.swing.JLabel xGender;
    private javax.swing.JLabel xKtp;
    private javax.swing.JLabel xPhone;
    private javax.swing.JLabel xPhoto;
    private javax.swing.JLabel xProvince;
    private javax.swing.JLabel xRegency;
    // End of variables declaration//GEN-END:variables
}