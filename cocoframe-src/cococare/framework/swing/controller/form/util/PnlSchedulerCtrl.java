package cococare.framework.swing.controller.form.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.model.bo.util.UtilSchedulerBo;
import cococare.framework.model.obj.util.UtilScheduler;
import cococare.framework.swing.controller.form.PnlDefaultCtrl;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlSchedulerCtrl extends PnlDefaultCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private UtilSchedulerBo schedulerBo;
//</editor-fold>

    @Override
    protected boolean _doSaveEntity() {
        return schedulerBo.saveOrUpdate((UtilScheduler) objEntity);
    }
}