package view.form;

public class FrmEllusion extends javax.swing.JFrame {

    public FrmEllusion() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        aMenuBarH = new cococare.swing.component.CCMenuBar();
        aContent = new cococare.swing.component.CCImage();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("(e)llusion ~ electronic illusion 1.0.150317");
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        aMenuBarH.setMinimumSize(new java.awt.Dimension(800, 30));
        aMenuBarH.setPreferredSize(new java.awt.Dimension(800, 30));
        getContentPane().add(aMenuBarH, java.awt.BorderLayout.NORTH);

        aContent.setMinimumSize(new java.awt.Dimension(800, 570));
        aContent.setPreferredSize(new java.awt.Dimension(800, 570));
        aContent.setLayout(new java.awt.BorderLayout());
        getContentPane().add(aContent, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private cococare.swing.component.CCImage aContent;
    private cococare.swing.component.CCMenuBar aMenuBarH;
    // End of variables declaration//GEN-END:variables
}