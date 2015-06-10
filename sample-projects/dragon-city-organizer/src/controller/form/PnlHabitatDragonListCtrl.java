package controller.form;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCLogic.isNotNull;
import cococare.framework.swing.CFSwingCtrl;
import static cococare.swing.CCSwing.addListener;
import cococare.swing.component.CCBandBox;
import cococare.swing.component.CCButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.obj.Dragon;
import static model.obj.Filter.isHabitatIsNull;
import model.obj.Filter.isHabitatType;
import model.obj.Habitat;
//</editor-fold>

public class PnlHabitatDragonListCtrl extends CFSwingCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private Habitat habitat;
    private CCBandBox bndDragon;
    private CCButton btnDragonAdd;
    private CCButton btnDragonDelete;
//</editor-fold>

    @Override
    protected Class _getEntity() {
        return Dragon.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.LIST_FUNCTION;
    }

    @Override
    protected void _initObject() {
        super._initObject();
        habitat = (Habitat) parameter.get(toString() + parentValue);
    }

    @Override
    protected void _initComponent() {
        super._initComponent();
        bndDragon.initTable(Dragon.class, "customName");
        bndDragon.getTable().setHqlFilters(new isHabitatType() {
            @Override
            public Object getFieldValue() {
                return habitat.getHabitatType();
            }
        }, isHabitatIsNull);
    }

    @Override
    protected void _initNaviElements() {
        tblEntity.setNaviElements(swingView.getPgnEntity(), swingView.getTxtKeyword(), btnDragonDelete);
    }

    @Override
    protected void _initListener() {
        super._initListener();
        addListener(btnDragonAdd, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                _doDragonAdd();
            }
        });
        addListener(btnDragonDelete, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                _doDragonDelete();
            }
        });
    }

    private void _doDragonAdd() {
        Dragon dragon = bndDragon.getObject();
        if (isNotNull(dragon)) {
            dragon.setHabitat(habitat);
            tblEntity.saveOrUpdate(dragon);
            doUpdateTable();
        }
    }

    private void _doDragonDelete() {
        Dragon dragon = tblEntity.getSelectedItem();
        if (isNotNull(dragon)) {
            dragon.setHabitat(null);
            tblEntity.saveOrUpdate(dragon);
            doUpdateTable();
        }
    }

    @Override
    public void doUpdateTable() {
        bndDragon.getTable().search();
        bndDragon.setObject(null);
        super.doUpdateTable();
    }
}