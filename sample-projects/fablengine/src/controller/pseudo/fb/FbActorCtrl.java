package controller.pseudo.fb;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCFormat.formatNumeric;
import static cococare.common.CCLogic.isNotNull;
import cococare.framework.swing.controller.form.util.PnlParameterCtrl;
import static cococare.swing.CCSwing.addListener;
import cococare.swing.component.CCBandBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import model.obj.fb.FbClass;
//</editor-fold>

public class FbActorCtrl extends PnlParameterCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private CCBandBox txtClass;
    private JTextField txtHpMax;
    private JTextField txtApMax;
    private JTextField txtOffense;
    private JTextField txtDefense;
    private JTextField txtEssence;
    private JTextField txtVelense;
    private JTextField txtHitRate;
    private JTextField txtEvaRate;
    private JTextField txtCrtRate;
//</editor-fold>

    @Override
    protected void _initListener() {
        super._initListener();
        addListener(txtClass, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                _doUpdateParameterField();
            }
        });
    }

    private void _doUpdateParameterField() {
        FbClass class_ = txtClass.getObject();
        if (isNotNull(class_)) {
            txtHpMax.setText(formatNumeric(class_.getHp()));
            txtApMax.setText(formatNumeric(class_.getAp()));
            txtOffense.setText(formatNumeric(class_.getOffense()));
            txtDefense.setText(formatNumeric(class_.getDefense()));
            txtEssence.setText(formatNumeric(class_.getEssence()));
            txtVelense.setText(formatNumeric(class_.getVelense()));
            txtHitRate.setText(formatNumeric(class_.getHitRate()));
            txtEvaRate.setText(formatNumeric(class_.getEvaRate()));
            txtCrtRate.setText(formatNumeric(class_.getCrtRate()));
        }
    }
}