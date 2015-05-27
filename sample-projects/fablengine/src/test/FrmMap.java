package test;

import cococare.database.CCHibernate;
import cococare.swing.component.CCImage;
import java.util.ArrayList;
import java.util.List;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JScrollPane;
import model.bo.fb.FbPathfindingBo;
import model.dao.fb.FbMapTileDao;
import model.obj.fb.FbMap;
import model.obj.fb.FbMapTile;
import static test.Test2.newHibernate;

public class FrmMap extends javax.swing.JFrame {

    private CCHibernate hibernate;

    public FrmMap() {
        initComponents();

        hibernate = newHibernate();
        FbMapTileDao tileDao = new FbMapTileDao();
        FbMap map = hibernate.get(FbMap.class, 1L);
        tileses = new ArrayList();
        for (int x = 0; x < map.getSizeX(); x++) {
            tileses.add(tileDao.getListUnlimitedBy(map, x));
        }

        GroupLayout groupLayout;
        ParallelGroup parallelGroup;
        SequentialGroup sequentialGroup;

        imgMap.removeAll();
        imgMap.setLayout(groupLayout = new GroupLayout(imgMap));
        groupLayout.setHorizontalGroup(parallelGroup = groupLayout.createParallelGroup());
        groupLayout.setVerticalGroup(sequentialGroup = groupLayout.createSequentialGroup());

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.getVerticalScrollBar().setUnitIncrement(15);
        parallelGroup.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
        sequentialGroup.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);

        CCImage container = new CCImage();
        container.setLayout(groupLayout = new GroupLayout(container));
        groupLayout.setHorizontalGroup(parallelGroup = groupLayout.createParallelGroup());
        groupLayout.setVerticalGroup(sequentialGroup = groupLayout.createSequentialGroup());
        scrollPane.setViewportView(container);
        
//        Math.ceil(WIDTH);

        for (int y = map.getSizeY() - 1; y >= 0; y--) {
            ParallelGroup pg = groupLayout.createParallelGroup();
            SequentialGroup sg = groupLayout.createSequentialGroup();
            for (int x = 0; x < map.getSizeX(); x++) {
                PnlTile pnlTile = new PnlTile(tileses.get(x).get(y));
                tileses.get(x).get(y).setTileView(pnlTile);
                pg.addComponent(pnlTile, 60, 60, 60);
                sg.addComponent(pnlTile, 60, 60, 60);
            }
            parallelGroup.addGroup(sg);
            sequentialGroup.addGroup(pg);
        }

        mouse = tileses.get(1).get(2);
        PnlTile pnlTile = mouse.getTileView();
        pnlTile.setText("MO");
        cheese = tileses.get(5).get(1);
        pnlTile = cheese.getTileView();
        pnlTile.setText("CH");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imgMap = new cococare.swing.component.CCImage();
        cCButton1 = new cococare.swing.component.CCButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        imgMap.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        imgMap.setLayout(null);

        cCButton1.setText("cCButton1");
        cCButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cCButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(imgMap, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(cCButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 122, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(imgMap, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(cCButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private List<List<FbMapTile>> tileses;
    private FbMapTile mouse;
    private FbMapTile cheese;
    private FbPathfindingBo pathfindingBo = new FbPathfindingBo();

    private void cCButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cCButton1ActionPerformed
        pathfindingBo.init(tileses, mouse, cheese);

        pathfindingBo.moveToDestination();
    }//GEN-LAST:event_cCButton1ActionPerformed

    public static void main(String args[]) {
        new FrmMap().setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private cococare.swing.component.CCButton cCButton1;
    private cococare.swing.component.CCImage imgMap;
    // End of variables declaration//GEN-END:variables
}