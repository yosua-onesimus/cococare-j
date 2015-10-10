package cococare.framework.swing.view.form;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCLanguage;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlReportDefaultList extends javax.swing.JPanel {

    public PnlReportDefaultList() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabEntity = new javax.swing.JTabbedPane();
        pnlList = new javax.swing.JPanel();
        pnlNorth = new javax.swing.JPanel();
        pnlNorthWest = new javax.swing.JPanel();
        _btnView = new cococare.swing.component.CCButton();
        _btnExport = new cococare.swing.component.CCButton();
        pnlGenerator = new javax.swing.JPanel();

        setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        setMinimumSize(new java.awt.Dimension(600, 200));
        setPreferredSize(new java.awt.Dimension(600, 200));

        tabEntity.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        pnlList.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        pnlList.setLayout(new java.awt.BorderLayout());

        pnlNorth.setPreferredSize(new java.awt.Dimension(10, 50));
        pnlNorth.setLayout(new java.awt.BorderLayout());

        pnlNorthWest.setPreferredSize(new java.awt.Dimension(500, 50));
        pnlNorthWest.setLayout(null);

        _btnView.setType(cococare.swing.component.CCButton.Type.VIEW);
        pnlNorthWest.add(_btnView);
        _btnView.setBounds(0, 10, 100, 29);

        _btnExport.setType(cococare.swing.component.CCButton.Type.EXPORT);
        pnlNorthWest.add(_btnExport);
        _btnExport.setBounds(100, 10, 100, 29);

        pnlNorth.add(pnlNorthWest, java.awt.BorderLayout.WEST);

        pnlList.add(pnlNorth, java.awt.BorderLayout.NORTH);

        javax.swing.GroupLayout pnlGeneratorLayout = new javax.swing.GroupLayout(pnlGenerator);
        pnlGenerator.setLayout(pnlGeneratorLayout);
        pnlGeneratorLayout.setHorizontalGroup(
            pnlGeneratorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 595, Short.MAX_VALUE)
        );
        pnlGeneratorLayout.setVerticalGroup(
            pnlGeneratorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );

        pnlList.add(pnlGenerator, java.awt.BorderLayout.CENTER);

        tabEntity.addTab(CCLanguage.turn(CCLanguage.Report), pnlList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabEntity)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabEntity)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private cococare.swing.component.CCButton _btnExport;
    private cococare.swing.component.CCButton _btnView;
    private javax.swing.JPanel pnlGenerator;
    private javax.swing.JPanel pnlList;
    private javax.swing.JPanel pnlNorth;
    private javax.swing.JPanel pnlNorthWest;
    private javax.swing.JTabbedPane tabEntity;
    // End of variables declaration//GEN-END:variables
}