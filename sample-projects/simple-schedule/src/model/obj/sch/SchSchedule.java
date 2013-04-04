package model.obj.sch;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCFieldConfig.CompareRule;
import cococare.common.CCTypeConfig;
import cococare.database.CCEntity;
import java.util.Date;
import javax.persistence.*;
//</editor-fold>

@Entity
@Table(name = "sch_schedules")
@CCTypeConfig(label = "Schedule", uniqueKey = "description")
public class SchSchedule implements CCEntity {

//<editor-fold defaultstate="collapsed" desc=" entity base ">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 32)
    private String logCreatedBy;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date logCreatedOn;
    @Column(length = 32)
    private String logChangedBy;
    @Temporal(value = TemporalType.TIMESTAMP)
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
    @CCFieldConfig(componentId = "cmbRepetition", accessible = Accessible.MANDATORY, optionSource = "model.obj.sch.SchEnum$Repetition", optionReflectKey = "repetition", requestFocus = true, visible = false)
    private Integer repetitionIndex;
    @Column(length = 16)
    @CCFieldConfig(maxLength = 16)
    private String repetition;
    @Temporal(value = TemporalType.DATE)
    @CCFieldConfig(componentId = "txtDateBegin", accessible = Accessible.MANDATORY, compareRule = CompareRule.SMALLER_OR_EQUAL_THAN)
    private Date dateBegin;
    @Temporal(value = TemporalType.DATE)
    @CCFieldConfig(componentId = "txtDateEnd")
    private Date dateEnd;
    @Temporal(value = TemporalType.TIME)
    @CCFieldConfig(componentId = "txtTimeBegin", accessible = Accessible.MANDATORY, compareRule = CompareRule.SMALLER_OR_EQUAL_THAN)
    private Date timeBegin;
    @Temporal(value = TemporalType.TIME)
    @CCFieldConfig(componentId = "txtTimeEnd", accessible = Accessible.MANDATORY)
    private Date timeEnd;
    @CCFieldConfig(componentId = "txtDescription")
    private String description;
    @ManyToOne
    @CCFieldConfig(componentId = "bndPerson", accessible = Accessible.MANDATORY, uniqueKey = "name")
    private SchPerson person;

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public Integer getRepetitionIndex() {
        return repetitionIndex;
    }

    public void setRepetitionIndex(Integer repetitionIndex) {
        this.repetitionIndex = repetitionIndex;
    }

    public String getRepetition() {
        return repetition;
    }

    public void setRepetition(String repetition) {
        this.repetition = repetition;
    }

    public Date getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(Date dateBegin) {
        this.dateBegin = dateBegin;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Date getTimeBegin() {
        return timeBegin;
    }

    public void setTimeBegin(Date timeBegin) {
        this.timeBegin = timeBegin;
    }

    public Date getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Date timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SchPerson getPerson() {
        return person;
    }

    public void setPerson(SchPerson person) {
        this.person = person;
    }
//</editor-fold>
}