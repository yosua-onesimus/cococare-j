package controller.form;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCClass;
import static cococare.common.CCClass.getLabel;
import cococare.framework.model.obj.util.UtilFilter;
import cococare.framework.swing.controller.form.util.PnlParameterCtrl;
import cococare.swing.component.CCBandBox;
import model.bo.HabitatDragonBo;
import model.obj.Filter.isHabitatType;
import model.obj.Habitat;
import model.obj.HabitatDragon;
//</editor-fold>

public class PnlHabitatDragonCtrl extends PnlParameterCtrl {

//<editor-fold defaultstate="collapsed" desc=" private ">
    private HabitatDragonBo habitatDragonBo;
    private Habitat habitat;
    private CCBandBox bndDragon;
//</editor-fold>

    @Override
    protected Class _getEntity() {
        return HabitatDragon.class;
    }

    @Override
    protected void _initObject() {
        super._initObject();
        habitat = (Habitat) parameter.get(toString() + parentValue);
    }

    @Override
    protected void _initEditor() {
        super._initEditor();
        bndDragon.getTable().setHqlFilters(new isHabitatType() {
            @Override
            public Object getFieldValue() {
                return habitat.getHabitatType();
            }
        }, new UtilFilter.isIdNotInIds() {
            @Override
            public Object getFieldValue() {
                return CCClass.getIds(habitatDragonBo.getDragonsUnlimited());
            }
        });
    }

    @Override
    protected String _getTabTitle() {
        return super._getTabTitle().replaceFirst(getLabel(_getEntity()) + ": ", "");
    }
}