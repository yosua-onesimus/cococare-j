package cococare.framework.swing.controller.form.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCLogic.isNotNull;
import cococare.framework.model.obj.wf.WfActivityTab;
import cococare.framework.model.obj.wf.WfTab;
import cococare.framework.swing.controller.form.PnlDefaultCtrl;
import static cococare.swing.CCSwing.addListener;
import cococare.swing.component.CCBandBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlActivityTabCtrl extends PnlDefaultCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private CCBandBox txtTab;
    private JTextField txtTabName;
//</editor-fold>

    @Override
    protected Class _getEntity() {
        return WfActivityTab.class;
    }

    @Override
    protected void _initListener() {
        super._initListener();
        addListener(txtTab, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                _doUpdateTxtTabName();
            }
        });
    }

    private void _doUpdateTxtTabName() {
        WfTab tab = txtTab.getObject();
        if (newEntity && isNotNull(tab)) {
            txtTabName.setText(tab.getName());
        }
    }
}