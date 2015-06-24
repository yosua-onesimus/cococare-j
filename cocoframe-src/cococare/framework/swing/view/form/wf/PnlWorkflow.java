package cococare.framework.swing.view.form.wf;

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlWorkflow extends javax.swing.JPanel {

    public PnlWorkflow() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlEditor = new javax.swing.JPanel();
        btnRoute = new cococare.swing.component.CCButton();
        btnClose = new cococare.swing.component.CCButton();

        setMinimumSize(new java.awt.Dimension(600, 200));
        setPreferredSize(new java.awt.Dimension(600, 200));

        pnlEditor.setLayout(null);

        btnRoute.setText("Route");
        btnRoute.setToolTipText("Route");
        btnRoute.setType(cococare.swing.component.CCButton.Type.SAVE);
        pnlEditor.add(btnRoute);
        btnRoute.setBounds(0, 10, 100, 29);

        btnClose.setType(cococare.swing.component.CCButton.Type.CLOSE);
        pnlEditor.add(btnClose);
        btnClose.setBounds(100, 10, 100, 29);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlEditor, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlEditor, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private cococare.swing.component.CCButton btnClose;
    private cococare.swing.component.CCButton btnRoute;
    private javax.swing.JPanel pnlEditor;
    // End of variables declaration//GEN-END:variables
}