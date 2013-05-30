package cococare.framework.swing.view.form.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCLanguage;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlApplicationSetting extends javax.swing.JPanel {

    public PnlApplicationSetting() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlEditor = new javax.swing.JPanel();
        btnSave = new cococare.swing.component.CCButton();
        btnClose = new cococare.swing.component.CCButton();
        pnlApplication = new javax.swing.JPanel();
        xApplLanguage = new javax.swing.JLabel();
        cmbApplLanguage = new javax.swing.JComboBox();
        xApplLookAndFeel = new javax.swing.JLabel();
        cmbApplLookAndFeel = new javax.swing.JComboBox();
        xApplMenuPosition = new javax.swing.JLabel();
        cmbApplMenuPosition = new javax.swing.JComboBox();
        attApplWallpaper = new cococare.swing.component.CCAttachment();
        pnlOwner = new javax.swing.JPanel();
        xOwnerName = new javax.swing.JLabel();
        txtOwnerName = new javax.swing.JTextField();
        xOwnerPosition = new javax.swing.JLabel();
        txtOwnerPosition = new javax.swing.JTextField();
        xOwnerKtp = new javax.swing.JLabel();
        txtOwnerKtp = new javax.swing.JTextField();
        xOwnerNpwp = new javax.swing.JLabel();
        txtOwnerNpwp = new javax.swing.JTextField();
        pnlCompany = new javax.swing.JPanel();
        attCompanyLogo = new cococare.swing.component.CCAttachment();
        xCompanyName = new javax.swing.JLabel();
        txtCompanyName = new javax.swing.JTextField();
        xCompanyAddress = new javax.swing.JLabel();
        txtCompanyAddress = new javax.swing.JTextField();
        xCompanyCity = new javax.swing.JLabel();
        cmbCompanyCity = new javax.swing.JComboBox();
        xCompanyProvince = new javax.swing.JLabel();
        cmbCompanyProvince = new javax.swing.JComboBox();
        xCompanyState = new javax.swing.JLabel();
        txtCompanyState = new javax.swing.JTextField();
        xCompanyPhone = new javax.swing.JLabel();
        txtCompanyPhone = new javax.swing.JTextField();
        xCompanyFax = new javax.swing.JLabel();
        txtCompanyFax = new javax.swing.JTextField();
        xCompanyEmail = new javax.swing.JLabel();
        txtCompanyEmail = new javax.swing.JTextField();
        xCompanyWeb = new javax.swing.JLabel();
        txtCompanyWeb = new javax.swing.JTextField();

        setMinimumSize(new java.awt.Dimension(600, 400));

        pnlEditor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, CCLanguage.turn(CCLanguage.Application_Setting), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12))); // NOI18N
        pnlEditor.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        btnSave.setType(cococare.swing.component.CCButton.Type.SAVE);

        btnClose.setType(cococare.swing.component.CCButton.Type.CLOSE);

        pnlApplication.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Application", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12))); // NOI18N
        pnlApplication.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        xApplLanguage.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xApplLanguage.setText("Language");

        cmbApplLanguage.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        xApplLookAndFeel.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xApplLookAndFeel.setText("Look And Feel");

        cmbApplLookAndFeel.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        xApplMenuPosition.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xApplMenuPosition.setText("Menu Position");

        cmbApplMenuPosition.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        javax.swing.GroupLayout pnlApplicationLayout = new javax.swing.GroupLayout(pnlApplication);
        pnlApplication.setLayout(pnlApplicationLayout);
        pnlApplicationLayout.setHorizontalGroup(
            pnlApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlApplicationLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(pnlApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlApplicationLayout.createSequentialGroup()
                        .addComponent(xApplLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(cmbApplLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlApplicationLayout.createSequentialGroup()
                        .addComponent(xApplLookAndFeel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(cmbApplLookAndFeel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlApplicationLayout.createSequentialGroup()
                        .addComponent(xApplMenuPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(cmbApplMenuPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(attApplWallpaper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        pnlApplicationLayout.setVerticalGroup(
            pnlApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlApplicationLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(pnlApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xApplLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbApplLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xApplLookAndFeel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbApplLookAndFeel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xApplMenuPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbApplMenuPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(attApplWallpaper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlOwner.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Owner", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12))); // NOI18N
        pnlOwner.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        xOwnerName.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xOwnerName.setText("Name");

        txtOwnerName.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        xOwnerPosition.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xOwnerPosition.setText("Position");

        txtOwnerPosition.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        xOwnerKtp.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xOwnerKtp.setText("KTP");

        txtOwnerKtp.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        xOwnerNpwp.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xOwnerNpwp.setText("NPWP");

        txtOwnerNpwp.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        javax.swing.GroupLayout pnlOwnerLayout = new javax.swing.GroupLayout(pnlOwner);
        pnlOwner.setLayout(pnlOwnerLayout);
        pnlOwnerLayout.setHorizontalGroup(
            pnlOwnerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOwnerLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(pnlOwnerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlOwnerLayout.createSequentialGroup()
                        .addComponent(xOwnerName, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txtOwnerName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlOwnerLayout.createSequentialGroup()
                        .addComponent(xOwnerPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txtOwnerPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlOwnerLayout.createSequentialGroup()
                        .addComponent(xOwnerKtp, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txtOwnerKtp, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlOwnerLayout.createSequentialGroup()
                        .addComponent(xOwnerNpwp, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txtOwnerNpwp, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlOwnerLayout.setVerticalGroup(
            pnlOwnerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOwnerLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(pnlOwnerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xOwnerName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOwnerName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlOwnerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xOwnerPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOwnerPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlOwnerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xOwnerKtp, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOwnerKtp, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlOwnerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xOwnerNpwp, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOwnerNpwp, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pnlCompany.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Company", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12))); // NOI18N
        pnlCompany.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        xCompanyName.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xCompanyName.setText("Name");

        txtCompanyName.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        xCompanyAddress.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xCompanyAddress.setText("Address");

        txtCompanyAddress.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        xCompanyCity.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xCompanyCity.setText("City");

        cmbCompanyCity.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        xCompanyProvince.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xCompanyProvince.setText("Province");

        cmbCompanyProvince.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        xCompanyState.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xCompanyState.setText("State");

        txtCompanyState.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        xCompanyPhone.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xCompanyPhone.setText("Phone");

        txtCompanyPhone.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        xCompanyFax.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xCompanyFax.setText("Fax");

        txtCompanyFax.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        xCompanyEmail.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xCompanyEmail.setText("Email");

        txtCompanyEmail.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        xCompanyWeb.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xCompanyWeb.setText("Web");

        txtCompanyWeb.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        javax.swing.GroupLayout pnlCompanyLayout = new javax.swing.GroupLayout(pnlCompany);
        pnlCompany.setLayout(pnlCompanyLayout);
        pnlCompanyLayout.setHorizontalGroup(
            pnlCompanyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCompanyLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(pnlCompanyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(attCompanyLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlCompanyLayout.createSequentialGroup()
                        .addComponent(xCompanyName, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txtCompanyName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlCompanyLayout.createSequentialGroup()
                        .addComponent(xCompanyAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txtCompanyAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlCompanyLayout.createSequentialGroup()
                        .addComponent(xCompanyCity, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(cmbCompanyCity, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlCompanyLayout.createSequentialGroup()
                        .addComponent(xCompanyProvince, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(cmbCompanyProvince, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlCompanyLayout.createSequentialGroup()
                        .addComponent(xCompanyState, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txtCompanyState, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlCompanyLayout.createSequentialGroup()
                        .addComponent(xCompanyPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txtCompanyPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlCompanyLayout.createSequentialGroup()
                        .addComponent(xCompanyFax, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txtCompanyFax, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlCompanyLayout.createSequentialGroup()
                        .addComponent(xCompanyEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txtCompanyEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlCompanyLayout.createSequentialGroup()
                        .addComponent(xCompanyWeb, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txtCompanyWeb, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        pnlCompanyLayout.setVerticalGroup(
            pnlCompanyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCompanyLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(attCompanyLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlCompanyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xCompanyName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCompanyName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlCompanyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xCompanyAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCompanyAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlCompanyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xCompanyCity, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCompanyCity, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlCompanyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xCompanyProvince, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCompanyProvince, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlCompanyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xCompanyState, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCompanyState, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlCompanyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xCompanyPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCompanyPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlCompanyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xCompanyFax, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCompanyFax, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlCompanyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xCompanyEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCompanyEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlCompanyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xCompanyWeb, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCompanyWeb, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout pnlEditorLayout = new javax.swing.GroupLayout(pnlEditor);
        pnlEditor.setLayout(pnlEditorLayout);
        pnlEditorLayout.setHorizontalGroup(
            pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditorLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEditorLayout.createSequentialGroup()
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlEditorLayout.createSequentialGroup()
                        .addGroup(pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pnlApplication, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlOwner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlCompany, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        pnlEditorLayout.setVerticalGroup(
            pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditorLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEditorLayout.createSequentialGroup()
                        .addComponent(pnlApplication, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(pnlOwner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlCompany, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
    private cococare.swing.component.CCAttachment attApplWallpaper;
    private cococare.swing.component.CCAttachment attCompanyLogo;
    private cococare.swing.component.CCButton btnClose;
    private cococare.swing.component.CCButton btnSave;
    private javax.swing.JComboBox cmbApplLanguage;
    private javax.swing.JComboBox cmbApplLookAndFeel;
    private javax.swing.JComboBox cmbApplMenuPosition;
    private javax.swing.JComboBox cmbCompanyCity;
    private javax.swing.JComboBox cmbCompanyProvince;
    private javax.swing.JPanel pnlApplication;
    private javax.swing.JPanel pnlCompany;
    private javax.swing.JPanel pnlEditor;
    private javax.swing.JPanel pnlOwner;
    private javax.swing.JTextField txtCompanyAddress;
    private javax.swing.JTextField txtCompanyEmail;
    private javax.swing.JTextField txtCompanyFax;
    private javax.swing.JTextField txtCompanyName;
    private javax.swing.JTextField txtCompanyPhone;
    private javax.swing.JTextField txtCompanyState;
    private javax.swing.JTextField txtCompanyWeb;
    private javax.swing.JTextField txtOwnerKtp;
    private javax.swing.JTextField txtOwnerName;
    private javax.swing.JTextField txtOwnerNpwp;
    private javax.swing.JTextField txtOwnerPosition;
    private javax.swing.JLabel xApplLanguage;
    private javax.swing.JLabel xApplLookAndFeel;
    private javax.swing.JLabel xApplMenuPosition;
    private javax.swing.JLabel xCompanyAddress;
    private javax.swing.JLabel xCompanyCity;
    private javax.swing.JLabel xCompanyEmail;
    private javax.swing.JLabel xCompanyFax;
    private javax.swing.JLabel xCompanyName;
    private javax.swing.JLabel xCompanyPhone;
    private javax.swing.JLabel xCompanyProvince;
    private javax.swing.JLabel xCompanyState;
    private javax.swing.JLabel xCompanyWeb;
    private javax.swing.JLabel xOwnerKtp;
    private javax.swing.JLabel xOwnerName;
    private javax.swing.JLabel xOwnerNpwp;
    private javax.swing.JLabel xOwnerPosition;
    // End of variables declaration//GEN-END:variables
}