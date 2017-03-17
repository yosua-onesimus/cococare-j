package cococare.framework.swing.controller.form.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.model.obj.wf.WfDocument;
import cococare.framework.model.obj.wf.WfEnum.DocumentStatus;
import cococare.framework.swing.controller.form.PnlDefaultWithChildCtrl;
import static cococare.swing.CCSwing.execute;
import static cococare.swing.CCSwing.setVisible;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlPortfolioCtrl extends PnlDefaultWithChildCtrl {

    @Override
    protected void _initComponent() {
        super._initComponent();
        WfDocument document = (WfDocument) objEntity;
        if (!newEntity && DocumentStatus.PORTFOLIO.equals(document.getDocumentStatus())) {
            _addChildScreen2("Application", "portfolio", new PnlPortfolioApplicationListCtrl());
            ActionListener alCloseOnSuccess = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    updateCaller = true;//update caller
                    execute(alClose, actionEvent);
                }
            };
            parameter.put(toString() + "alCloseOnSuccess", alCloseOnSuccess);
            parameter.put(toString() + "document", document);
            _addChildScreen2("Process", "", new PnlRoutingCtrl());
        }
    }

    @Override
    protected void _doUpdateAccessible() {
        super._doUpdateAccessible();
        if (!newEntity) {
            setVisible(false, swingView.getBtnSave());
            edtEntity.setAccessible2Readonly();
        }
    }
}