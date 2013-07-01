package view.form;

//<editor-fold defaultstate="collapsed" desc=" import ">
import java.net.URL;
//</editor-fold>

public class PnlSquare extends javax.swing.JPanel {

    private boolean hasQuestion = false;

    public PnlSquare() {
        initComponents();
    }

    public PnlSquare(String text) {
        this();
        lblSquare.setText(text);
    }

    public boolean isHasQuestion() {
        return hasQuestion;
    }

    public void setHasQuestion(boolean hasQuestion) {
        this.hasQuestion = hasQuestion;
        lblSquare.setForeground(hasQuestion ? java.awt.Color.RED : java.awt.Color.BLUE);
    }

    public void setIcon(URL url) {
        imgSquare.setIcon(url);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imgSquare = new cococare.swing.component.CCImage();
        lblSquare = new javax.swing.JLabel();
        imgIcon1 = new cococare.swing.component.CCImage();
        imgIcon2 = new cococare.swing.component.CCImage();
        imgIcon3 = new cococare.swing.component.CCImage();
        imgIcon4 = new cococare.swing.component.CCImage();
        imgIcon5 = new cococare.swing.component.CCImage();

        imgSquare.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        imgSquare.setIconAutoFit(true);
        imgSquare.setIconProportion(true);
        imgSquare.setMinimumSize(new java.awt.Dimension(110, 110));
        imgSquare.setPreferredSize(new java.awt.Dimension(110, 110));
        imgSquare.setLayout(null);

        lblSquare.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lblSquare.setText("25");
        imgSquare.add(lblSquare);
        lblSquare.setBounds(1, 1, 29, 19);

        imgIcon1.setOpaque(false);
        imgIcon1.setLayout(null);
        imgSquare.add(imgIcon1);
        imgIcon1.setBounds(20, 30, 30, 30);

        imgIcon2.setOpaque(false);
        imgIcon2.setLayout(null);
        imgSquare.add(imgIcon2);
        imgIcon2.setBounds(20, 60, 30, 30);

        imgIcon3.setOpaque(false);
        imgIcon3.setLayout(null);
        imgSquare.add(imgIcon3);
        imgIcon3.setBounds(60, 40, 30, 30);

        imgIcon4.setOpaque(false);
        imgIcon4.setLayout(null);
        imgSquare.add(imgIcon4);
        imgIcon4.setBounds(60, 10, 30, 30);

        imgIcon5.setOpaque(false);
        imgIcon5.setLayout(null);
        imgSquare.add(imgIcon5);
        imgIcon5.setBounds(60, 70, 30, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgSquare, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgSquare, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private cococare.swing.component.CCImage imgIcon1;
    private cococare.swing.component.CCImage imgIcon2;
    private cococare.swing.component.CCImage imgIcon3;
    private cococare.swing.component.CCImage imgIcon4;
    private cococare.swing.component.CCImage imgIcon5;
    private cococare.swing.component.CCImage imgSquare;
    private javax.swing.JLabel lblSquare;
    // End of variables declaration//GEN-END:variables
}