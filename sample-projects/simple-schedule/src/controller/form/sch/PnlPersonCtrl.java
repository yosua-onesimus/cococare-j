package controller.form.sch;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.swing.CFSwingCtrl;
import model.obj.sch.SchPerson;
//</editor-fold>

public class PnlPersonCtrl extends CFSwingCtrl {

    @Override
    protected Class _getEntity() {
        return SchPerson.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.FORM_FUNCTION;
    }
}