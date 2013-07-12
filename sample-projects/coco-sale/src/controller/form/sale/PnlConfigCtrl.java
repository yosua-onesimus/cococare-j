package controller.form.sale;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCMessage;
import cococare.framework.swing.CFSwingCtrl;
import static cococare.swing.CCSwing.addActionListener;
import cococare.swing.component.CCButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.bo.sale.SVConfigBo;
import model.obj.sale.SVConfig;
//</editor-fold>

public class PnlConfigCtrl extends CFSwingCtrl {

    private SVConfigBo configBo;
    private CCButton btnCalc;

    @Override
    protected Class _getEntity() {
        return SVConfig.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.FORM_FUNCTION;
    }

    @Override
    protected void _initObjEntity() {
        objEntity = configBo.loadSVConfig();
    }

    @Override
    protected void _initListener() {
        super._initListener();
        //
        addActionListener(btnCalc, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _doSave();
                _doRecalculationSalePrice();
            }
        });
    }

    @Override
    protected boolean _doSaveEntity() {
        return configBo.saveConf(objEntity);
    }

    protected void _doRecalculationSalePrice() {
        if (updateCaller) {
            if (configBo.recalculationSalePrice()) {
                CCMessage.showInformation("OK");
            } else {
                CCMessage.showError();
            }
        }
    }
}