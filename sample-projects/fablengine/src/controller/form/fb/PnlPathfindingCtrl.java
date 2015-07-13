package controller.form.fb;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.datafile.CCFile;
import cococare.framework.swing.CFSwingCtrl;
import cococare.swing.CCSwing;
import cococare.swing.component.CCButton;
import cococare.swing.component.CCImage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JScrollPane;
import model.bo.fb.FbMapBo;
import model.mdl.fb.FableModule;
import model.obj.fb.FbMap;
import view.form.fb.PnlTile;
//</editor-fold>

public class PnlPathfindingCtrl extends CFSwingCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private FbMapBo mapBo;
    private CCButton btnStart;
    private CCImage pnlMapTile;
    private CCImage mouse;
    private CCImage cheese;
//</editor-fold>

    @Override
    protected Class _getEntity() {
        return null;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.LIST_FUNCTION;
    }

    @Override
    protected void _initComponent() {
        super._initComponent();
        _initTile();
    }

    private void _initTile() {
        mapBo.initMap((FbMap) FableModule.INSTANCE.getCCHibernate().get(FbMap.class, 1L));
        //
        GroupLayout groupLayout;
        ParallelGroup parallelGroup;
        SequentialGroup sequentialGroup;
        //
        pnlMapTile.removeAll();
        pnlMapTile.setLayout(groupLayout = new GroupLayout(pnlMapTile));
        groupLayout.setHorizontalGroup(parallelGroup = groupLayout.createParallelGroup());
        groupLayout.setVerticalGroup(sequentialGroup = groupLayout.createSequentialGroup());
        //
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.getVerticalScrollBar().setUnitIncrement(15);
        parallelGroup.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
        sequentialGroup.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
        //
        CCImage container = new CCImage();
        container.setLayout(groupLayout = new GroupLayout(container));
        groupLayout.setHorizontalGroup(parallelGroup = groupLayout.createParallelGroup());
        groupLayout.setVerticalGroup(sequentialGroup = groupLayout.createSequentialGroup());
        scrollPane.setViewportView(container);
        //
        for (int y = mapBo.getMap().getSizeY() - 1; y >= 0; y--) {
            ParallelGroup pg = groupLayout.createParallelGroup();
            SequentialGroup sg = groupLayout.createSequentialGroup();
            for (int x = 0; x < mapBo.getMap().getSizeX(); x++) {
                PnlTile pnlTile = new PnlTile(mapBo.getMapTile(x, y));
                pg.addComponent(pnlTile, 60, 60, 60);
                sg.addComponent(pnlTile, 60, 60, 60);
            }
            parallelGroup.addGroup(sg);
            sequentialGroup.addGroup(pg);
        }
        //
        mouse = new CCImage();
        mouse.setBounds(0, 0, 40, 40);
        mouse.setIcon(CCFile.readByteA(CCFile.getFileSystArchFile("mouse.png")));
        PnlTile pnlTile = mapBo.getMapTile(1, 2).getTileView();
        pnlTile.getImgActor().add(mouse);
        //
        cheese = new CCImage();
        cheese.setBounds(0, 0, 40, 40);
        cheese.setIcon(CCFile.readByteA(CCFile.getFileSystArchFile("cheese.png")));
        pnlTile = mapBo.getMapTile(5, 1).getTileView();
        pnlTile.getImgActor().add(cheese);
    }

    @Override
    protected void _initListener() {
        super._initListener();
        CCSwing.addListener(btnStart, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("btnStart");
            }
        });
    }
}