package controller.form;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.swing.CFSwingCtrl;
import model.bo.HabitatBo;
import model.obj.Habitat;
//</editor-fold>

public class PnlHabitatCtrl extends CFSwingCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private HabitatBo habitatBo;
//</editor-fold>

    @Override
    protected Class _getClass() {
        return PnlHabitatCtrl.class;
    }

    @Override
    protected Class _getEntity() {
        return Habitat.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.FORM_FUNCTION;
    }

    @Override
    protected void _initComponent() {
        super._initComponent();
        _addChildScreen("habitat", new PnlHabitatDragonListCtrl(), "pnlDragon");
    }

    @Override
    protected boolean _doSaveEntity() {
        return habitatBo.saveOrUpdate((Habitat) objEntity);
    }
}