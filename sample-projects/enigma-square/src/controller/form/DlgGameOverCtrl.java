package controller.form;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFormat;
import cococare.framework.swing.CFSwingCtrl;
import cococare.swing.CCSwing;
import cococare.swing.CCTable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JLabel;
import model.bo.EnigmaSquareBo;
import model.obj.Player;
//</editor-fold>

public class DlgGameOverCtrl extends CFSwingCtrl {

    private JLabel lblTurn;
    private JLabel lblTime;
    private CCTable tblPlayer;
    private JButton btnOk;

    @Override
    protected Class _getEntity() {
        return null;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.FORM_FUNCTION;
    }

    @Override
    protected ShowMode _getShowMode() {
        return ShowMode.DIALOG_MODE;
    }

    @Override
    protected void _initComponent() {
        super._initComponent();
        //
        EnigmaSquareBo enigmaSquareBo = (EnigmaSquareBo) objEntity;
        lblTurn.setText(enigmaSquareBo.getGameTurn() + " giliran");
        lblTime.setText(CCFormat.formatDecimal(CCFormat.getDiffMinutes(enigmaSquareBo.getGameStart(), new Date())) + " menit");
        tblPlayer = CCSwing.newCCTable(getContainer(), "tblPlayer", Player.class);
        tblPlayer.setHeadersVisible(false);
        tblPlayer.setList(enigmaSquareBo.getFinishedPlayers());
        for (Player player : enigmaSquareBo.getUnfinishedPlayers()) {
            tblPlayer.addItem(player);
        }
    }

    @Override
    protected void _initListener() {
        super._initListener();
        //
        CCSwing.addListener(btnOk, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _doCloseScreen();
            }
        });
    }
}