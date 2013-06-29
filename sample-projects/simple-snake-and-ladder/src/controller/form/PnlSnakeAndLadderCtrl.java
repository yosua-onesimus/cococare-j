package controller.form;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFormat;
import cococare.common.CCLogic;
import cococare.common.CCSprite;
import cococare.common.CCThread;
import static cococare.common.CCThread.threadSleep;
import cococare.framework.swing.CFSwingCtrl;
import cococare.swing.CCSwing;
import cococare.swing.CCTable;
import cococare.swing.component.CCImage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.JLabel;
import model.obj.GameWorld;
import model.obj.Player;
import model.obj.Question;
import view.form.PnlSquare;
//</editor-fold>

public class PnlSnakeAndLadderCtrl extends CFSwingCtrl {

//<editor-fold defaultstate="collapsed" desc=" private ">
    private GameWorld gameWorld;
    private CCImage imgBoard;
    private CCTable tblPlayer;
    private CCImage imgPlayerIcon;
    private JLabel lblPlayerName;
    private CCSprite sprDice;
    private CCImage imgDice;
    private JButton btnNewGame;
    private JButton btnThrowDice;
    private JButton btnEndGame;
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
        _initTblPlayer();
        //_initSprDice();
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
        CCSwing.addActionListener(btnEndGame, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _endGame();
            }
        });
    }

    protected void _doNaviSetEnabled(boolean enabled) {
        btnThrowDice.setEnabled(enabled);
        btnNewGame.setEnabled(enabled);
        btnEndGame.setEnabled(enabled);
    }
    private int dice;

    protected void _throwDice() {
        if (CCLogic.isNotNull(gameWorld)) {
            _doNaviSetEnabled(false);
            //roll dice animation
            sprDice.addScene("RollDice", gameWorld.rollDice());
            sprDice.playOneLoop();
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
                    if (gameWorld.isCurrentSquareHasQuestion()) {
                        Question question = gameWorld.getCurrentQuestion();
                        if (new DlgQuestionCtrl().init(question)) {
                            System.out.println("GIFT");
                            dice = question.getGift();
                            gameWorld.getCurrentPlayer().answerTrue();
                        } else {
                            System.out.println("PENALTY");
                            dice = question.getPenalty();
                            if (dice > 0) {
                                dice = -gameWorld.getCurrentDice();
                            }
                            gameWorld.getCurrentPlayer().answerFalse();
                        }
                        while (dice > 0) {
                            gameWorld.showPlayerOnBoardOnNextSquare(gameWorld.getCurrentPlayer());
                            imgBoard.repaint();
                            dice--;
                            threadSleep();
                            threadSleep();
                        }
                        while (dice < 0) {
                            gameWorld.showPlayerOnBoardOnPrevSquare(gameWorld.getCurrentPlayer());
                            imgBoard.repaint();
                            dice++;
                            threadSleep();
                            threadSleep();
                        }
                    }
                    _doNaviSetEnabled(true);
                    gameWorld.nextPlayer();
                    _doUpdateTblPlayer();
                    _doUpdateLblPlayer();
                    interrupt();
                }
            };
            thread.start();
        }
    }

    protected void _newSquare(int number, int x, int y) {
        PnlSquare square = new PnlSquare(CCFormat.getString(number));
        square.setBounds(x, y, 110, 110);
        if (number == 1) {
            square.setIcon(getClass().getResource("/resource/start.jpg"));
        } else if (number == 25) {
            square.setIcon(getClass().getResource("/resource/finish.png"));
        }
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

    protected void _initTblPlayer() {
        tblPlayer = CCSwing.newCCTable(getContainer(), "tblPlayer", Player.class);
        tblPlayer.setHeadersVisible(false);
    }

    protected void _initSprDice() {
        BufferedImage bufferedImage = cococare.datafile.CCImage.getImage(getClass().getResource("/resource/dice.png"));
        bufferedImage = cococare.datafile.CCImage.resizeImage(bufferedImage, 300, 200);
        BufferedImage[] bufferedImages = cococare.datafile.CCImage.splitImages(bufferedImage, 3, 2);
        sprDice = new CCSprite(bufferedImages, imgDice, 0, 0);
    }

    protected void _doUpdateTblPlayer() {
        tblPlayer.reloadItems();
    }

    protected void _doUpdateLblPlayer() {
        imgPlayerIcon.setIcon(gameWorld.getCurrentPlayer().getIcon());
        imgPlayerIcon.repaint();
        lblPlayerName.setText(CCFormat.wordWrap("<b color='red'>" + gameWorld.getCurrentPlayer().getName() + "</b><br/>sekarang giliranmu.."));
    }

    protected void _newGame() {
        if (new DlgGameOptionCtrl().init()) {
            gameWorld = new GameWorld();
            gameWorld.registerPlayer();
            tblPlayer.setList(gameWorld.getPlayingPlayers());
            gameWorld.registerQuestion();
            _initBoard();
            //_initSprDice();
            _doUpdateTblPlayer();
            _doUpdateLblPlayer();
            gameWorld.showPlayerOnBoard();
            imgBoard.repaint();
        }
    }

    protected void _endGame() {
        new DlgGameOverCtrl().init(gameWorld);
    }

    @Override
    protected void _doShowScreen() {
        super._doShowScreen();
        //
        _initSprDice();
    }
}