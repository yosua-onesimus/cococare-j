package view.form.fb;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.swing.component.CCImage;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import model.obj.fb.FbMapTile;
//</editor-fold>

public class PnlTile extends javax.swing.JPanel {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private FbMapTile tile;
//</editor-fold>

    public PnlTile() {
        initComponents();
    }

    public PnlTile(FbMapTile tile) {
        this();
        this.tile = tile;
        _initTile();
    }

    private void _initTile() {
        tile.setTileView(this);
        updateTile();
    }

    public void updateTile() {
        if (tile.getTileType() != null) {
            imgTile.setBorder(new LineBorder(tile.getTileType().isWalkable() ? Color.GREEN : Color.RED, 1, true));
            imgTile.setIcon(new ImageIcon(tile.getTileType().getImage()));
        }
    }

//<editor-fold defaultstate="collapsed" desc=" getter ">
    public CCImage getImgActor() {
        return imgActor;
    }

    public CCImage getImgCeil() {
        return imgCeil;
    }

    public CCImage getImgFloor() {
        return imgFloor;
    }

    public CCImage getImgTile() {
        return imgTile;
    }

    public JLabel getLblTile() {
        return lblTile;
    }

    public FbMapTile getTile() {
        return tile;
    }
//</editor-fold>

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imgTile = new cococare.swing.component.CCImage();
        lblTile = new javax.swing.JLabel();
        imgCeil = new cococare.swing.component.CCImage();
        imgActor = new cococare.swing.component.CCImage();
        imgFloor = new cococare.swing.component.CCImage();

        imgTile.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        imgTile.setIconAutoFit(true);
        imgTile.setIconProportion(true);
        imgTile.setMinimumSize(new java.awt.Dimension(110, 110));
        imgTile.setPreferredSize(new java.awt.Dimension(110, 110));
        imgTile.setLayout(null);

        lblTile.setFont(new java.awt.Font("Verdana", 1, 8)); // NOI18N
        lblTile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTile.setText("This is Tile");
        imgTile.add(lblTile);
        lblTile.setBounds(1, 1, 60, 10);

        imgCeil.setOpaque(false);

        javax.swing.GroupLayout imgCeilLayout = new javax.swing.GroupLayout(imgCeil);
        imgCeil.setLayout(imgCeilLayout);
        imgCeilLayout.setHorizontalGroup(
            imgCeilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        imgCeilLayout.setVerticalGroup(
            imgCeilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        imgTile.add(imgCeil);
        imgCeil.setBounds(10, 10, 40, 40);

        imgActor.setOpaque(false);

        javax.swing.GroupLayout imgActorLayout = new javax.swing.GroupLayout(imgActor);
        imgActor.setLayout(imgActorLayout);
        imgActorLayout.setHorizontalGroup(
            imgActorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        imgActorLayout.setVerticalGroup(
            imgActorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        imgTile.add(imgActor);
        imgActor.setBounds(10, 10, 40, 40);

        imgFloor.setOpaque(false);

        javax.swing.GroupLayout imgFloorLayout = new javax.swing.GroupLayout(imgFloor);
        imgFloor.setLayout(imgFloorLayout);
        imgFloorLayout.setHorizontalGroup(
            imgFloorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        imgFloorLayout.setVerticalGroup(
            imgFloorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        imgTile.add(imgFloor);
        imgFloor.setBounds(10, 10, 40, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgTile, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgTile, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private cococare.swing.component.CCImage imgActor;
    private cococare.swing.component.CCImage imgCeil;
    private cococare.swing.component.CCImage imgFloor;
    private cococare.swing.component.CCImage imgTile;
    private javax.swing.JLabel lblTile;
    // End of variables declaration//GEN-END:variables
}