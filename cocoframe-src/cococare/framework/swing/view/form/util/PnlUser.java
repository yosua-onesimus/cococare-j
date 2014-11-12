package cococare.framework.swing.view.form.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCLanguage;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlUser extends javax.swing.JPanel {

    public PnlUser() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlEditor = new javax.swing.JPanel();
        btnSave = new cococare.swing.component.CCButton();
        btnClose = new cococare.swing.component.CCButton();
        xUsername = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        xPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        xRetypePassword = new javax.swing.JLabel();
        txtRetypePassword = new javax.swing.JPasswordField();
        xFullname = new javax.swing.JLabel();
        txtFullname = new javax.swing.JTextField();
        xUserGroup = new javax.swing.JLabel();
        bndUserGroup = new cococare.swing.component.CCBandBox();
        chkActive = new javax.swing.JCheckBox();
        tabEntity = new javax.swing.JTabbedPane();
        pnlPrivilege = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        tblPrivilege = new javax.swing.JTable();
        pnlIp = new javax.swing.JPanel();
        xIp = new javax.swing.JLabel();
        txtIp = new javax.swing.JTextField();
        btnIpAdd = new cococare.swing.component.CCButton();
        btnIpRemove = new cococare.swing.component.CCButton();
        scrIp = new javax.swing.JScrollPane();
        tblIp = new javax.swing.JTable();

        setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        setMinimumSize(new java.awt.Dimension(600, 400));
        setPreferredSize(new java.awt.Dimension(600, 400));

        btnSave.setType(cococare.swing.component.CCButton.Type.SAVE);

        btnClose.setType(cococare.swing.component.CCButton.Type.CLOSE);

        xUsername.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xUsername.setText("Username");

        txtUsername.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        xPassword.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xPassword.setText("Password");

        txtPassword.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        xRetypePassword.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xRetypePassword.setText("Retype Password");

        txtRetypePassword.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        xFullname.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xFullname.setText("Fullname");

        txtFullname.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        xUserGroup.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xUserGroup.setText("User Group");

        bndUserGroup.setVisibleClearButton(true);

        chkActive.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        chkActive.setText("Active");

        tabEntity.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        tblPrivilege.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        scrollPane.setViewportView(tblPrivilege);

        javax.swing.GroupLayout pnlPrivilegeLayout = new javax.swing.GroupLayout(pnlPrivilege);
        pnlPrivilege.setLayout(pnlPrivilegeLayout);
        pnlPrivilegeLayout.setHorizontalGroup(
            pnlPrivilegeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
        );
        pnlPrivilegeLayout.setVerticalGroup(
            pnlPrivilegeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
        );

        tabEntity.addTab(CCLanguage.turn(CCLanguage.Privilege), pnlPrivilege);

        xIp.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xIp.setText("IP");

        txtIp.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        btnIpAdd.setType(cococare.swing.component.CCButton.Type.ADD);

        btnIpRemove.setType(cococare.swing.component.CCButton.Type.REMOVE);

        tblIp.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        scrIp.setViewportView(tblIp);

        javax.swing.GroupLayout pnlIpLayout = new javax.swing.GroupLayout(pnlIp);
        pnlIp.setLayout(pnlIpLayout);
        pnlIpLayout.setHorizontalGroup(
            pnlIpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIpLayout.createSequentialGroup()
                .addComponent(xIp, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtIp, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnIpAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnIpRemove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(scrIp)
        );
        pnlIpLayout.setVerticalGroup(
            pnlIpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIpLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlIpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xIp, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIp, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIpAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIpRemove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(scrIp, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
        );

        tabEntity.addTab(CCLanguage.turn(CCLanguage.IP), pnlIp);

        javax.swing.GroupLayout pnlEditorLayout = new javax.swing.GroupLayout(pnlEditor);
        pnlEditor.setLayout(pnlEditorLayout);
        pnlEditorLayout.setHorizontalGroup(
            pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditorLayout.createSequentialGroup()
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlEditorLayout.createSequentialGroup()
                .addComponent(xUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlEditorLayout.createSequentialGroup()
                .addComponent(xPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlEditorLayout.createSequentialGroup()
                .addComponent(xRetypePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtRetypePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlEditorLayout.createSequentialGroup()
                .addComponent(xFullname, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtFullname, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlEditorLayout.createSequentialGroup()
                .addComponent(xUserGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(bndUserGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlEditorLayout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(chkActive, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(tabEntity)
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
                    .addComponent(xUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xRetypePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRetypePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xFullname, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFullname, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xUserGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bndUserGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(chkActive, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(tabEntity, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlEditor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlEditor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private cococare.swing.component.CCBandBox bndUserGroup;
    private cococare.swing.component.CCButton btnClose;
    private cococare.swing.component.CCButton btnIpAdd;
    private cococare.swing.component.CCButton btnIpRemove;
    private cococare.swing.component.CCButton btnSave;
    private javax.swing.JCheckBox chkActive;
    private javax.swing.JPanel pnlEditor;
    private javax.swing.JPanel pnlIp;
    private javax.swing.JPanel pnlPrivilege;
    private javax.swing.JScrollPane scrIp;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTabbedPane tabEntity;
    private javax.swing.JTable tblIp;
    private javax.swing.JTable tblPrivilege;
    private javax.swing.JTextField txtFullname;
    private javax.swing.JTextField txtIp;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JPasswordField txtRetypePassword;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JLabel xFullname;
    private javax.swing.JLabel xIp;
    private javax.swing.JLabel xPassword;
    private javax.swing.JLabel xRetypePassword;
    private javax.swing.JLabel xUserGroup;
    private javax.swing.JLabel xUsername;
    // End of variables declaration//GEN-END:variables
}