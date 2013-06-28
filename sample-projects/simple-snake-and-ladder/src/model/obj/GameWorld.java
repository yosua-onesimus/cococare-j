package model.obj;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.swing.CCSwing;
import cococare.swing.component.CCImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import static model.mdl.SnakeAndLadderMain.gameOption;
import static model.mdl.SnakeAndLadderMain.questions;
import model.obj.Enum.QuestionOrder;
import view.form.PnlSquare;
//</editor-fold>

public class GameWorld {

    private List<Player> playingPlayers = new ArrayList();
    private List<Player> finishedPlayers = new ArrayList();
    private List<Integer> questionNumbers = new ArrayList();
    //
    private List<Question> playingQuestions = new ArrayList();
    //
    private HashMap<Integer, PnlSquare> number_square = new HashMap();
    private HashMap<Player, CCImage> player_icon = new HashMap();
    //
    private Player currentPlayer;
    private int currentDice;

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public List<Player> getPlayingPlayers() {
        return playingPlayers;
    }

    public void setPlayingPlayers(List<Player> playingPlayers) {
        this.playingPlayers = playingPlayers;
    }

    public List<Player> getFinishedPlayers() {
        return finishedPlayers;
    }

    public void setFinishedPlayers(List<Player> finishedPlayers) {
        this.finishedPlayers = finishedPlayers;
    }

    public List<Integer> getQuestionNumbers() {
        return questionNumbers;
    }

    public void setQuestionNumbers(List<Integer> questionNumbers) {
        this.questionNumbers = questionNumbers;
    }

    public List<Question> getPlayingQuestions() {
        return playingQuestions;
    }

    public void setPlayingQuestions(List<Question> playingQuestions) {
        this.playingQuestions = playingQuestions;
    }

    public HashMap<Integer, PnlSquare> getNumber_square() {
        return number_square;
    }

    public void setNumber_square(HashMap<Integer, PnlSquare> number_square) {
        this.number_square = number_square;
    }

    public HashMap<Player, CCImage> getPlayer_icon() {
        return player_icon;
    }

    public void setPlayer_icon(HashMap<Player, CCImage> player_icon) {
        this.player_icon = player_icon;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
//</editor-fold>

    public void registerPlayer() {
        gameOption.resetPlayerScore();
        for (int i = 0; i < gameOption.getPlayerNumber(); i++) {
            Player player = gameOption.getPlayers().get(i);
            getPlayingPlayers().add(player);
            CCImage imgIcon = new CCImage();
            imgIcon.setBounds(0, 0, 30, 30);
            imgIcon.setIcon(player.getIcon());
            imgIcon.setIconAutoFit(true);
            imgIcon.setIconProportion(true);
            imgIcon.setToolTipText(player.getName());
            getPlayer_icon().put(player, imgIcon);
        }
        if (gameOption.getQuestionNumber() > 0) {
            Random random = new Random();
            while (getQuestionNumbers().size() < gameOption.getQuestionNumber()) {
                int index = random.nextInt(25) + 1;
                if (!getQuestionNumbers().contains(index)) {
                    getQuestionNumbers().add(index);
                }
            }
        }
        setCurrentPlayer(gameOption.getPlayers().get(0));
    }

    public void registerQuestion() {
        if (gameOption.getQuestionNumber() > 0) {
            getPlayingQuestions().clear();
            QuestionOrder questionOrder = QuestionOrder.values()[gameOption.getQuestionOrderIndex()];
            if (QuestionOrder.SEQUENCE.equals(questionOrder)) {
                for (int i = 0; i < questions.size(); i++) {
                    getPlayingQuestions().add(questions.get(i));
                }
            } else if (QuestionOrder.RANDOM.equals(questionOrder)) {
                List<Integer> indexes = new ArrayList();
                Random random = new Random();
                while (indexes.size() < questions.size()) {
                    int index = random.nextInt(questions.size());
                    if (!indexes.contains(index)) {
                        indexes.add(index);
                    }
                }
                for (int i = 0; i < indexes.size(); i++) {
                    getPlayingQuestions().add(questions.get(indexes.get(i)));
                }
            }
        }
    }

    public void showPlayerOnBoard() {
        for (int i = 0; i < getPlayingPlayers().size(); i++) {
            Player player = getPlayingPlayers().get(i);
            CCSwing.getCCImage(getNumber_square().get(player.getSquareNumber()), "imgIcon" + (i + 1)).add(getPlayer_icon().get(player));
        }
    }

    public Integer[] rollDice() {
        List<Integer> diceEyes = new ArrayList();
        Random random = new Random();
        while (diceEyes.size() < 10) {
            diceEyes.add(random.nextInt(6));
        }
        currentDice = diceEyes.get(diceEyes.size() - 1) + 1;
        return diceEyes.toArray(new Integer[0]);
    }

    public int getCurrentDice() {
        return currentDice;
    }

    public void showPlayerOnBoardOnNextSquare(Player player) {
        if (player.getSquareNumber() >= 25) {
            player.setReverse(true);
        }
        player.setSquareNumber(player.getSquareNumber() + (player.isReverse() ? -1 : +1));
        int i = gameOption.getPlayers().indexOf(player);
        CCSwing.getCCImage(getNumber_square().get(player.getSquareNumber()), "imgIcon" + (i + 1)).add(getPlayer_icon().get(player));
    }

    public void nextPlayer() {
        int index = getPlayingPlayers().indexOf(getCurrentPlayer());
        if (++index >= gameOption.getPlayerNumber()) {
            index = 0;
        }
        setCurrentPlayer(getPlayingPlayers().get(index));
        getCurrentPlayer().setReverse(false);
    }
}