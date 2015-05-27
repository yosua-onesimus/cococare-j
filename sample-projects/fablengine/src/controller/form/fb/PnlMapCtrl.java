package controller.form.fb;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCFormat.parseInt;
import cococare.framework.swing.CFSwingCtrl;
import static cococare.swing.CCSwing.addListener2;
import cococare.swing.component.CCImage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import model.bo.fb.FbMapBo;
import model.obj.fb.FbMap;
import model.obj.fb.FbMapTile;
import model.obj.fb.FbTileType;
import view.form.fb.PnlTile;
//</editor-fold>

public class PnlMapCtrl extends CFSwingCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private FbMapBo mapBo;
    private List tileses;
    private List<FbTileType> tileTypes;
    private JTextField txtSizeX;
    private JTextField txtSizeY;
    private CCImage pnlMapTile;
//</editor-fold>

    @Override
    protected Class _getEntity() {
        return FbMap.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.FORM_FUNCTION;
    }

    @Override
    protected void _initObject() {
        super._initObject();
        _initTile();
    }

    private void _initTile() {
        if (!newEntity) {
            tileses = new ArrayList();
            FbMap map = (FbMap) objEntity;
            for (int x = 0; x < map.getSizeX(); x++) {
                tileses.add(mapBo.getTilesBy(map, x));
            }
        }
        tileTypes = mapBo.getTileTypes();
    }

    @Override
    protected void _initListener() {
        super._initListener();
        ActionListener alUpdateTile = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                _doUpdateTile();
            }
        };
        addListener2(txtSizeX, alUpdateTile);
        addListener2(txtSizeY, alUpdateTile);
    }

    @Override
    protected void _doUpdateEditor() {
        super._doUpdateEditor();
        _doUpdateTile();
    }

    private void _doUpdateTile() {
        int sizeX = parseInt(txtSizeX.getText());
        int sizeY = parseInt(txtSizeY.getText());
        //
        while (sizeX > tileses.size()) {
            int sizeY2 = 0;
            if (!tileses.isEmpty()) {
                sizeY2 = ((List) tileses.get(0)).size();
            }
            List<FbMapTile> tiles = new ArrayList();
            while (sizeY2 > tiles.size()) {
                FbMapTile tile = new FbMapTile();
                tile.setMap((FbMap) objEntity);
                tiles.add(tile);
            }
            tileses.add(tiles);
        }
        while (tileses.size() > 0 && sizeY > ((List) tileses.get(0)).size()) {
            for (Object object : tileses) {
                List<FbMapTile> tiles = (List<FbMapTile>) object;
                while (sizeY > tiles.size()) {
                    FbMapTile tile = new FbMapTile();
                    tile.setMap((FbMap) objEntity);
                    tiles.add(tile);
                }
            }
        }
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
        for (int y = sizeY - 1; y >= 0; y--) {
            ParallelGroup pg = groupLayout.createParallelGroup();
            SequentialGroup sg = groupLayout.createSequentialGroup();
            for (int x = 0; x < sizeX; x++) {
                final PnlTile pnlTile = new PnlTile(((List<FbMapTile>) tileses.get(x)).get(y));
                pnlTile.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent mouseEvent) {
                        int index = -1;
                        if (pnlTile.getTile().getTileType() != null) {
                            for (FbTileType tileType : tileTypes) {
                                if (tileType.getId().equals(pnlTile.getTile().getTileType().getId())) {
                                    index = tileTypes.indexOf(tileType);
                                    break;
                                }
                            }
                        }
                        if (mouseEvent.getModifiers() == 16) {
                            index++;
                            if (index >= tileTypes.size()) {
                                index = 0;
                            }
                        } else if (mouseEvent.getModifiers() == 4) {
                            index--;
                            if (index <= -1) {
                                index = tileTypes.size() - 1;
                            }
                        }
                        pnlTile.getTile().setTileType(tileTypes.get(index));
                        pnlTile.updateTile();
                    }
                });
                pg.addComponent(pnlTile, 60, 60, 60);
                sg.addComponent(pnlTile, 60, 60, 60);
            }
            parallelGroup.addGroup(sg);
            sequentialGroup.addGroup(pg);
        }
    }
}