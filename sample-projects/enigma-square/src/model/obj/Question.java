package model.obj;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
//</editor-fold>

public class Question {

    @CCFieldConfig(componentId = "txtQuestion", accessible = Accessible.MANDATORY, requestFocus = true)
    private String question;
    @CCFieldConfig(componentId = "txtAnswer", accessible = Accessible.MANDATORY)
    private String answer;
    @CCFieldConfig(componentId = "txtGift", accessible = Accessible.MANDATORY, maxLength = 2)
    private int gift = 0;
    @CCFieldConfig(componentId = "txtPenalty", accessible = Accessible.MANDATORY, maxLength = 2)
    private int penalty = 1;
    @CCFieldConfig(componentId = "cmbAutoAnswer", accessible = Accessible.MANDATORY, optionSource = "model.obj.Enum$AutoAnswer", optionReflectKey = "autoAnswer", visible = false)
    private Integer autoAnswerIndex = 0;
    @CCFieldConfig(maxLength = 8)
    private String autoAnswer;

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getGift() {
        return gift;
    }

    public void setGift(int gift) {
        this.gift = gift;
    }

    public int getPenalty() {
        return penalty;
    }

    public void setPenalty(int penalty) {
        this.penalty = penalty;
    }

    public Integer getAutoAnswerIndex() {
        return autoAnswerIndex;
    }

    public void setAutoAnswerIndex(Integer autoAnswerIndex) {
        this.autoAnswerIndex = autoAnswerIndex;
    }

    public String getAutoAnswer() {
        return autoAnswer;
    }

    public void setAutoAnswer(String autoAnswer) {
        this.autoAnswer = autoAnswer;
    }
//</editor-fold>
}