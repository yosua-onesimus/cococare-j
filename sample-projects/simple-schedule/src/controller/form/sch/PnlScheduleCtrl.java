package controller.form.sch;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.swing.CFSwingCtrl;
import model.obj.sch.SchSchedule;
//</editor-fold>

public class PnlScheduleCtrl extends CFSwingCtrl {

    @Override
    protected Class _getEntity() {
        return SchSchedule.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.FORM_FUNCTION;
    }
}