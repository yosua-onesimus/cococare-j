package an.example;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCConfig;
import cococare.common.CCLanguage;
import cococare.database.CCDatabaseConfig;
import cococare.database.CCHibernate;
import cococare.swing.CCSwing;
import cococare.swing.CCTable;
import model.mdl.InventoryModule;
import model.obj.inv.InvEmployee;
//</editor-fold>

public class Ex3_ListDialog extends javax.swing.JDialog {

    private CCHibernate hibernate;
    private CCTable tblEmployee_;

    public Ex3_ListDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        _init();
    }

    private void _init() {
        //basic config
        CCConfig.MSG_SHOW_PRINTLN = false;
        CCConfig.MSG_SHOW_LOG_INFO = false;
        CCConfig.MSG_SHOW_LOG_SEVERE = true;
        CCConfig.HBN_SHOW_HQL = "true";
        CCLanguage.init(true);
        //initial hibernate
        hibernate = new CCHibernate();
        //add annotated class
        InventoryModule.INSTANCE.init(hibernate);
        //add database config
        hibernate.addDatabaseConfig(new CCDatabaseConfig().withPassword("1234").withDatabase("test"));
        //initial table
        tblEmployee_ = new CCTable(tblEmployee, InvEmployee.class);
        tblEmployee_.setNaviElements(pgnEmployee, txtKeyword);
        tblEmployee_.setHqlMaxResults(10);
        tblEmployee_.search();
    }

    public static void main(String args[]) {
        Ex3_ListDialog listDialog = new Ex3_ListDialog(null, true);
        CCSwing.centerScreen(listDialog);
        listDialog.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlEmployee = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txtKeyword = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmployee = new javax.swing.JTable();
        pgnEmployee = new cococare.swing.component.CCPaging();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        pnlEmployee.setBorder(new javax.swing.border.LineBorder(java.awt.Color.cyan, 1, true));
        pnlEmployee.setLayout(new java.awt.BorderLayout());

        jPanel1.setBorder(new javax.swing.border.LineBorder(java.awt.Color.cyan, 1, true));
        jPanel1.setPreferredSize(new java.awt.Dimension(398, 30));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(299, 299, 299)
                .addComponent(txtKeyword, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtKeyword, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pnlEmployee.add(jPanel1, java.awt.BorderLayout.NORTH);

        jPanel2.setBorder(new javax.swing.border.LineBorder(java.awt.Color.cyan, 1, true));

        jScrollPane1.setViewportView(tblEmployee);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
        );

        pnlEmployee.add(jPanel2, java.awt.BorderLayout.CENTER);
        pnlEmployee.add(pgnEmployee, java.awt.BorderLayout.SOUTH);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private cococare.swing.component.CCPaging pgnEmployee;
    private javax.swing.JPanel pnlEmployee;
    private javax.swing.JTable tblEmployee;
    private javax.swing.JTextField txtKeyword;
    // End of variables declaration//GEN-END:variables
}