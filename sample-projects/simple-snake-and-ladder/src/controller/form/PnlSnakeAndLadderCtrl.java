package controller.form;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFormat;
import cococare.common.CCLogic;
import cococare.common.CCSprite;
import cococare.common.CCThread;
import static cococare.common.CCThread.threadSleep;
import cococare.framework.swing.CFSwingCtrl;
import cococare.swing.CCSwing;
import cococare.swing.component.CCImage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import model.obj.GameWorld;
import view.form.PnlSquare;
//</editor-fold>

public class PnlSnakeAndLadderCtrl extends CFSwingCtrl {

//<editor-fold defaultstate="collapsed" desc=" private ">
    private GameWorld gameWorld;
    private CCImage imgBoard;
    private CCSprite sprDice;
    private CCImage imgDice;
    private JButton btnNewGame;
    private JButton btnThrowDice;
//</editor-fold>

    @Override
    protected Class _getEntity() {
        return null;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return null;
    }

    @Override
    protected ShowMode _getShowMode() {
        return ShowMode.PANEL_MODE;
    }

    @Override
    public boolean init() {
        return super.init(null);
    }

    @Override
    protected void _initComponent() {
        super._initComponent();
        //
        _initBoard();
    }

    @Override
    protected void _initListener() {
        super._initListener();
        //
        CCSwing.addActionListener(btnThrowDice, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _throwDice();
            }
        });
        CCSwing.addActionListener(btnNewGame, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _newGame();
            }
        });
    }
    private int dice;

    protected void _throwDice() {
        if (CCLogic.isNotNull(gameWorld)) {
            btnThrowDice.setEnabled(false);
            //roll dice animation
            sprDice.addScene("RollDice", gameWorld.rollDice());
            sprDice.playOnLoop();
            //sprite animation
            dice = gameWorld.getCurrentDice();
            CCThread thread = new CCThread() {
                @Override
                public void run() {
                    while (dice > 0) {
                        gameWorld.showPlayerOnBoardOnNextSquare(gameWorld.getCurrentPlayer());
                        imgBoard.repaint();
                        dice--;
                        threadSleep();
                        threadSleep();
                    }
                    btnThrowDice.setEnabled(true);
                    gameWorld.nextPlayer();
                }
            };
            thread.start();
        }
    }

    protected void _newSquare(int number, int x, int y) {
        PnlSquare square = new PnlSquare(CCFormat.getString(number));
        square.setBounds(x, y, 110, 110);
        if (CCLogic.isNotNull(gameWorld)) {
            square.setHasQuestion(gameWorld.getQuestionNumbers().contains(number));
            gameWorld.getNumber_square().put(number, square);
        }
        imgBoard.add(square);
    }

    protected void _initBoard() {
        imgBoard.removeAll();
        int number = 1;
        for (int y = 4; y > -1; y--) {
            if (y % 2 == 0) {
                for (int x = 0; x < 5; x++) {
                    _newSquare(number++, 110 * x, 110 * y);
                }
            } else if (y % 2 == 1) {
                for (int x = 4; x > -1; x--) {
                    _newSquare(number++, 110 * x, 110 * y);
                }
            }
        }
        imgBoard.repaint();
    }

    protected void _initImageDice() {
        BufferedImage bufferedImage = cococare.datafile.CCImage.getImage(getClass().getResource("/resource/dice.png"));
        bufferedImage = cococare.datafile.CCImage.resizeImage(bufferedImage, 300, 200);
        BufferedImage[] bufferedImages = cococare.datafile.CCImage.splitImages(bufferedImage, 3, 2);
        sprDice = new CCSprite(bufferedImages, imgDice, 0, 0);
    }

    protected void _newGame() {
        if (new DlgGameOptionCtrl().init()) {
            gameWorld = new GameWorld();
            gameWorld.registerPlayer();
            gameWorld.registerQuestion();
            _initBoard();
            _initImageDice();
            gameWorld.showPlayerOnBoard();
            imgBoard.repaint();
        }
    }
}