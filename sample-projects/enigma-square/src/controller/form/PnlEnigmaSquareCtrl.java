package controller.form;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFormat;
import cococare.framework.swing.CFSwingCtrl;
import cococare.swing.CCSwing;
import cococare.swing.CCTable;
import cococare.swing.component.CCImage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import model.bo.EnigmaSquareBo;
import model.obj.Player;
//</editor-fold>

public class PnlEnigmaSquareCtrl extends CFSwingCtrl {

//<editor-fold defaultstate="collapsed" desc=" private ">
    private EnigmaSquareBo enigmaSquareBo;
    private CCImage imgBoard;
    private CCTable tblPlayer;
    private CCImage imgPlayerIcon;
    private JLabel lblPlayerName;
    private CCImage imgDice;
    private JButton btnNewGame;
    private JButton btnRollDice;
    private JButton btnEndGame;
    private ActionListener postActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            _doUpdateComponentPlayer();
            _doUpdateComponentNavi(true);
        }
    };
//</editor-fold>

    @Override
    protected Class _getEntity() {
        return null;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.LIST_FUNCTION;
    }

    @Override
    protected void _initListener() {
        super._initListener();
        //
        CCSwing.addListener(btnRollDice, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _rollDice();
            }
        });
        CCSwing.addListener(btnNewGame, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _newGame();
            }
        });
        CCSwing.addListener(btnEndGame, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _endGame();
            }
        });
    }

    protected void _rollDice() {
        _doUpdateComponentNavi(false);
        enigmaSquareBo.rollDice(postActionListener);
    }

    protected void _newGame() {
        if (new DlgGameOptionCtrl().init()) {
            enigmaSquareBo.newGame();
            tblPlayer.setList(enigmaSquareBo.getPlayingPlayers());
            _doUpdateComponentNavi(true);
            _doUpdateComponentPlayer();
            imgBoard.repaint();
        }
    }

    protected void _endGame() {
        new DlgGameOverCtrl().init(enigmaSquareBo);
    }

    @Override
    protected void _doShowScreen() {
        super._doShowScreen();
        //
        enigmaSquareBo = new EnigmaSquareBo(imgBoard);
        enigmaSquareBo.initSpriteDice(imgDice);
        //
        tblPlayer = CCSwing.newCCTable(getContainer(), "tblPlayer", Player.class);
        tblPlayer.setHeadersVisible(false);
        //
        _doUpdateComponentNavi(true);
    }

    protected void _doUpdateComponentNavi(boolean enabled) {
        btnRollDice.setEnabled(!enigmaSquareBo.isGameEnd() && enabled);
        btnNewGame.setEnabled(enabled);
        btnEndGame.setEnabled(!enigmaSquareBo.isGameEnd() && enabled);
    }

    protected void _doUpdateComponentPlayer() {
        tblPlayer.reloadItems();
        //
        imgPlayerIcon.setIcon(enigmaSquareBo.getCurrentPlayer().getIcon());
        imgPlayerIcon.repaint();
        lblPlayerName.setText(CCFormat.wordWrap("<b color='red'>" + enigmaSquareBo.getCurrentPlayer().getName() + "</b><br/>sekarang giliranmu.."));
    }
}