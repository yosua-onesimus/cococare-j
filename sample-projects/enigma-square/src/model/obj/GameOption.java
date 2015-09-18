package model.obj;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCFieldConfig.Type;
import cococare.database.CCEntity;
import java.util.ArrayList;
import java.util.List;
//</editor-fold>

public class GameOption extends CCEntity {

    @CCFieldConfig(componentId = "cmbGameMode", accessible = Accessible.MANDATORY, optionSource = "model.obj.Enum$GameMode", optionReflectKey = "gameMode", requestFocus = true)
    private Integer gameModeIndex = 0;
    @CCFieldConfig(maxLength = 16, visible = false)
    private String gameMode;
    @CCFieldConfig(componentId = "chkQuestionShow", accessible = Accessible.READONLY)
    private Boolean questionShow = true;
    @CCFieldConfig(componentId = "cmbQuestionOrder", accessible = Accessible.MANDATORY, optionSource = "model.obj.Enum$QuestionOrder", optionReflectKey = "questionOrder")
    private Integer questionOrderIndex = 0;
    @CCFieldConfig(maxLength = 16, visible = false)
    private String questionOrder;
    @CCFieldConfig(componentId = "txtQuestionNumber", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 2)
    private int questionNumber = 25;
    @CCFieldConfig(componentId = "txtQuestionTime", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 2)
    private int questionTime = 30;
    @CCFieldConfig(componentId = "chkQuestionAnswerShow", accessible = Accessible.READONLY)
    private Boolean questionAnswerShow = false;
    @CCFieldConfig(componentId = "txtPlayerNumber", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 1)
    private int playerNumber = 5;
    private List<Player> players = new ArrayList();

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public Integer getGameModeIndex() {
        return gameModeIndex;
    }

    public void setGameModeIndex(Integer gameModeIndex) {
        this.gameModeIndex = gameModeIndex;
    }

    public String getGameMode() {
        return gameMode;
    }

    public void setGameMode(String gameMode) {
        this.gameMode = gameMode;
    }

    public Boolean getQuestionShow() {
        return questionShow;
    }

    public void setQuestionShow(Boolean questionShow) {
        this.questionShow = questionShow;
    }

    public Integer getQuestionOrderIndex() {
        return questionOrderIndex;
    }

    public void setQuestionOrderIndex(Integer questionOrderIndex) {
        this.questionOrderIndex = questionOrderIndex;
    }

    public String getQuestionOrder() {
        return questionOrder;
    }

    public void setQuestionOrder(String questionOrder) {
        this.questionOrder = questionOrder;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    public int getQuestionTime() {
        return questionTime;
    }

    public void setQuestionTime(int questionTime) {
        this.questionTime = questionTime;
    }

    public Boolean getQuestionAnswerShow() {
        return questionAnswerShow;
    }

    public void setQuestionAnswerShow(Boolean questionAnswerShow) {
        this.questionAnswerShow = questionAnswerShow;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
//</editor-fold>
}