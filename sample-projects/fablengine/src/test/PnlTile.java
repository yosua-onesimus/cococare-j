package test;

//<editor-fold defaultstate="collapsed" desc=" import ">
import java.awt.Color;
import java.net.URL;
import model.obj.fb.FbMapTile;
//</editor-fold>

public class PnlTile extends javax.swing.JPanel {

    private FbMapTile tile;

    public PnlTile() {
        initComponents();
    }

    public PnlTile(FbMapTile tile) {
        this();
        this.tile = tile;
        if (tile.getTileType().getWalkable()) {
            lblSquare.setForeground(Color.DARK_GRAY);
        } else {
            lblSquare.setForeground(Color.RED);
        }
    }

    public void setText(String text) {
        lblSquare.setText(text);
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

        imgSquare.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        imgSquare.setIconAutoFit(true);
        imgSquare.setIconProportion(true);
        imgSquare.setMinimumSize(new java.awt.Dimension(110, 110));
        imgSquare.setPreferredSize(new java.awt.Dimension(110, 110));
        imgSquare.setLayout(null);

        lblSquare.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lblSquare.setText("0");
        imgSquare.add(lblSquare);
        lblSquare.setBounds(1, 1, 29, 19);

        imgIcon1.setOpaque(false);
        imgIcon1.setLayout(null);
        imgSquare.add(imgIcon1);
        imgIcon1.setBounds(10, 20, 30, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgSquare, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgSquare, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private cococare.swing.component.CCImage imgIcon1;
    private cococare.swing.component.CCImage imgSquare;
    private javax.swing.JLabel lblSquare;
    // End of variables declaration//GEN-END:variables
}