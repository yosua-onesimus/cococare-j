package controller.pseudo;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCClass;
import cococare.framework.model.obj.util.UtilFilter.isIdNotInIds;
import cococare.framework.swing.controller.form.util.PnlParameterCtrl;
import cococare.swing.component.CCBandBox;
import model.bo.HabitatDragonBo;
//</editor-fold>

public class HabitatDragonCtrl extends PnlParameterCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private HabitatDragonBo habitatDragonBo;
    private CCBandBox bndDragon;
//</editor-fold>

    @Override
    protected void _initEditor() {
        super._initEditor();
        bndDragon.getTable().setHqlFilters(new isIdNotInIds() {
            @Override
            public Object getFieldValue() {
                return CCClass.getIds(habitatDragonBo.getDragonsUnlimited());
            }
        });
    }
}