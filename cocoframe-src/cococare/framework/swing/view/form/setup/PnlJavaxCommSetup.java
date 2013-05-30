package cococare.framework.swing.view.form.setup;

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlJavaxCommSetup extends javax.swing.JPanel {

    public PnlJavaxCommSetup() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlJavaxComm = new javax.swing.JPanel();
        tabJavaxComm = new javax.swing.JTabbedPane();
        pnlSetup = new javax.swing.JPanel();
        xNote = new javax.swing.JLabel();
        xJavaHome = new javax.swing.JLabel();
        txtJavaHome = new javax.swing.JTextField();
        xJavaHomeBin = new javax.swing.JLabel();
        txtJavaHomeBin = new javax.swing.JTextField();
        xJavaHomeLib = new javax.swing.JLabel();
        txtJavaHomeLib = new javax.swing.JTextField();
        btnBrowseJavaHome = new cococare.swing.component.CCButton();
        btnBrowseJavaHomeBin = new cococare.swing.component.CCButton();
        btnBrowseJavaHomeLib = new cococare.swing.component.CCButton();
        btnCopy = new cococare.swing.component.CCButton();
        pnlTester = new javax.swing.JPanel();
        xPort = new javax.swing.JLabel();
        cmbPort = new javax.swing.JComboBox();
        xAscii = new javax.swing.JLabel();
        cmbAscii = new javax.swing.JComboBox();
        xText1 = new javax.swing.JLabel();
        txtText1 = new javax.swing.JTextField();
        xText2 = new javax.swing.JLabel();
        txtText2 = new javax.swing.JTextField();
        btnAscii2Port = new cococare.swing.component.CCButton();
        btnText2Display = new cococare.swing.component.CCButton();
        btnText2Port = new cococare.swing.component.CCButton();
        btnOpenDrawer1 = new cococare.swing.component.CCButton();
        btnOpenDrawer2 = new cococare.swing.component.CCButton();
        btnOpenDrawer3 = new cococare.swing.component.CCButton();
        btnOpenDrawer4 = new cococare.swing.component.CCButton();

        setMinimumSize(new java.awt.Dimension(600, 400));

        pnlJavaxComm.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Javax.Comm Setup", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12))); // NOI18N
        pnlJavaxComm.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        tabJavaxComm.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        xNote.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        xNote.setText("<html> To use the javax.comm, the following files need to be copied to your system: <ul> <li><b>win32com.dll</b> => <b>Java Home Bin</b></li> <li><b>comm.jar</b> => <b>Java Home Lib</b></li> <li><b>javax.comm.properties</b> => <b>Java Home Lib</b></li> </ul> </html>");

        xJavaHome.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xJavaHome.setText("Java Home");

        txtJavaHome.setEditable(false);
        txtJavaHome.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        xJavaHomeBin.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xJavaHomeBin.setText("Java Home Bin");

        txtJavaHomeBin.setEditable(false);
        txtJavaHomeBin.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        xJavaHomeLib.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xJavaHomeLib.setText("Java Home Lib");

        txtJavaHomeLib.setEditable(false);
        txtJavaHomeLib.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        btnBrowseJavaHome.setText("Browse");

        btnBrowseJavaHomeBin.setText("Browse");

        btnBrowseJavaHomeLib.setText("Browse");

        btnCopy.setText("Copy these files to a specific folder");

        javax.swing.GroupLayout pnlSetupLayout = new javax.swing.GroupLayout(pnlSetup);
        pnlSetup.setLayout(pnlSetupLayout);
        pnlSetupLayout.setHorizontalGroup(
            pnlSetupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSetupLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(xNote, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlSetupLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(xJavaHome, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtJavaHome, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnBrowseJavaHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlSetupLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(xJavaHomeBin, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtJavaHomeBin, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnBrowseJavaHomeBin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlSetupLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(xJavaHomeLib, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtJavaHomeLib, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnBrowseJavaHomeLib, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlSetupLayout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(btnCopy, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlSetupLayout.setVerticalGroup(
            pnlSetupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSetupLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(xNote, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlSetupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xJavaHome, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtJavaHome, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBrowseJavaHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlSetupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xJavaHomeBin, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtJavaHomeBin, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBrowseJavaHomeBin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlSetupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xJavaHomeLib, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtJavaHomeLib, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBrowseJavaHomeLib, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(btnCopy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tabJavaxComm.addTab("Setup", pnlSetup);

        xPort.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xPort.setText("Port");

        cmbPort.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        xAscii.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xAscii.setText("Ascii");

        cmbAscii.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        xText1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xText1.setText("Text1");

        txtText1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        xText2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xText2.setText("Text2");

        txtText2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        btnAscii2Port.setText("Ascii To Port");

        btnText2Display.setText("Text To Display");

        btnText2Port.setText("Text To Port");

        btnOpenDrawer1.setText("Open Drawer I");

        btnOpenDrawer2.setText("Open Drawer II");

        btnOpenDrawer3.setText("Open Drawer III");

        btnOpenDrawer4.setText("Open Drawer IV");

        javax.swing.GroupLayout pnlTesterLayout = new javax.swing.GroupLayout(pnlTester);
        pnlTester.setLayout(pnlTesterLayout);
        pnlTesterLayout.setHorizontalGroup(
            pnlTesterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTesterLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(xPort, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(cmbPort, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlTesterLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(xAscii, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(cmbAscii, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(btnAscii2Port, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlTesterLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(xText1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtText1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnText2Display, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlTesterLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(xText2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtText2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnText2Port, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlTesterLayout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(btnOpenDrawer1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnOpenDrawer2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlTesterLayout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(btnOpenDrawer3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnOpenDrawer4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlTesterLayout.setVerticalGroup(
            pnlTesterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTesterLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlTesterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xPort, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbPort, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(pnlTesterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xAscii, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbAscii, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAscii2Port, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlTesterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xText1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtText1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnText2Display, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlTesterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xText2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtText2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnText2Port, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(pnlTesterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnOpenDrawer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOpenDrawer2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlTesterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnOpenDrawer3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOpenDrawer4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        tabJavaxComm.addTab("Tester", pnlTester);

        javax.swing.GroupLayout pnlJavaxCommLayout = new javax.swing.GroupLayout(pnlJavaxComm);
        pnlJavaxComm.setLayout(pnlJavaxCommLayout);
        pnlJavaxCommLayout.setHorizontalGroup(
            pnlJavaxCommLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlJavaxCommLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(tabJavaxComm, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                .addGap(4, 4, 4))
        );
        pnlJavaxCommLayout.setVerticalGroup(
            pnlJavaxCommLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlJavaxCommLayout.createSequentialGroup()
                .addComponent(tabJavaxComm, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlJavaxComm, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlJavaxComm, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private cococare.swing.component.CCButton btnAscii2Port;
    private cococare.swing.component.CCButton btnBrowseJavaHome;
    private cococare.swing.component.CCButton btnBrowseJavaHomeBin;
    private cococare.swing.component.CCButton btnBrowseJavaHomeLib;
    private cococare.swing.component.CCButton btnCopy;
    private cococare.swing.component.CCButton btnOpenDrawer1;
    private cococare.swing.component.CCButton btnOpenDrawer2;
    private cococare.swing.component.CCButton btnOpenDrawer3;
    private cococare.swing.component.CCButton btnOpenDrawer4;
    private cococare.swing.component.CCButton btnText2Display;
    private cococare.swing.component.CCButton btnText2Port;
    private javax.swing.JComboBox cmbAscii;
    private javax.swing.JComboBox cmbPort;
    private javax.swing.JPanel pnlJavaxComm;
    private javax.swing.JPanel pnlSetup;
    private javax.swing.JPanel pnlTester;
    private javax.swing.JTabbedPane tabJavaxComm;
    private javax.swing.JTextField txtJavaHome;
    private javax.swing.JTextField txtJavaHomeBin;
    private javax.swing.JTextField txtJavaHomeLib;
    private javax.swing.JTextField txtText1;
    private javax.swing.JTextField txtText2;
    private javax.swing.JLabel xAscii;
    private javax.swing.JLabel xJavaHome;
    private javax.swing.JLabel xJavaHomeBin;
    private javax.swing.JLabel xJavaHomeLib;
    private javax.swing.JLabel xNote;
    private javax.swing.JLabel xPort;
    private javax.swing.JLabel xText1;
    private javax.swing.JLabel xText2;
    // End of variables declaration//GEN-END:variables
}