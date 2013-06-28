package model.obj;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Type;
import cococare.common.CCFormat;
import cococare.database.CCEntity;
import cococare.datafile.CCImage;
import java.util.Date;
//</editor-fold>

public class Player implements CCEntity {

//<editor-fold defaultstate="collapsed" desc=" entity base ">
    private Long id;
    private String logCreatedBy;
    private Date logCreatedOn;
    private String logChangedBy;
    private Date logChangedOn;
    private Integer logSaveTimes = 0;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getLogCreatedBy() {
        return logCreatedBy;
    }

    @Override
    public void setLogCreatedBy(String logCreatedBy) {
        this.logCreatedBy = logCreatedBy;
    }

    @Override
    public Date getLogCreatedOn() {
        return logCreatedOn;
    }

    @Override
    public void setLogCreatedOn(Date logCreatedOn) {
        this.logCreatedOn = logCreatedOn;
    }

    @Override
    public String getLogChangedBy() {
        return logChangedBy;
    }

    @Override
    public void setLogChangedBy(String logChangedBy) {
        this.logChangedBy = logChangedBy;
    }

    @Override
    public Date getLogChangedOn() {
        return logChangedOn;
    }

    @Override
    public void setLogChangedOn(Date logChangedOn) {
        this.logChangedOn = logChangedOn;
    }

    @Override
    public Integer getLogSaveTimes() {
        return logSaveTimes;
    }

    @Override
    public void setLogSaveTimes(Integer logSaveTimes) {
        this.logSaveTimes = logSaveTimes;
    }
//</editor-fold>
    @CCFieldConfig(type = Type.THUMB_FILE, visible = false)
    private byte[] icon = CCImage.getByteA(getClass().getResource("/resource/avatar.png"));
    @CCFieldConfig()
    private String name = "Player";
    @CCFieldConfig(type = Type.NUMERIC, visible = false)
    private int squareNumber;
    @CCFieldConfig(visible = false)
    private boolean reverse = false;
    //
    @CCFieldConfig(type = Type.NUMERIC, visible = false)
    private int turnNumber;
    //
    @CCFieldConfig(type = Type.NUMERIC, visible = false)
    private int giftNumber;
    @CCFieldConfig(type = Type.DECIMAL, visible = false)
    private float questionNumber;
    //
    @CCFieldConfig(type = Type.DECIMAL, maxLength = 5)
    private float score;

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public byte[] getIcon() {
        return icon;
    }

    public void setIcon(byte[] icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSquareNumber() {
        return squareNumber;
    }

    public void setSquareNumber(int squareNumber) {
        this.squareNumber = squareNumber;
    }

    public boolean isReverse() {
        return reverse;
    }

    public void setReverse(boolean reverse) {
        this.reverse = reverse;
    }

    public int getTurnNumber() {
        return turnNumber;
    }

    public void incTurnNumber() {
        turnNumber++;
    }

    public void setTurnNumber(int turnNumber) {
        this.turnNumber = turnNumber;
    }

    public int getGiftNumber() {
        return giftNumber;
    }

    public void setGiftNumber(int giftNumber) {
        this.giftNumber = giftNumber;
    }

    public float getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(float questionNumber) {
        this.questionNumber = questionNumber;
    }

    public void answerFalse() {
        questionNumber++;
    }

    public void answerTrue() {
        giftNumber++;
        questionNumber++;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
//</editor-fold>

    public void resetScore() {
        setSquareNumber(1);
        setReverse(false);
        setTurnNumber(0);
        setGiftNumber(0);
        setQuestionNumber(0);
        setScore(0);
    }

    public void countScore() {
        setScore(
                CCFormat.parseFloat(getSquareNumber() * 2)
                + CCFormat.parseFloat((getGiftNumber() + 1) / (getQuestionNumber() + 1) * 50f)
                + CCFormat.parseFloat(4 - getTurnNumber()));
    }
}