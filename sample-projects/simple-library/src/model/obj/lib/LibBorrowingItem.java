package model.obj.lib;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCFieldConfig.Type;
import cococare.common.CCTypeConfig;
import cococare.database.CCEntity;
import java.util.Date;
import javax.persistence.*;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
@Entity
@Table(name = "lib_borrowing_items")
@CCTypeConfig(label = "Borrowing Item", uniqueKey = "book.title")
public class LibBorrowingItem implements CCEntity {

//<editor-fold defaultstate="collapsed" desc=" entity base ">
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 32)
    private String logCreatedBy;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date logCreatedOn;
    @Column(length = 32)
    private String logChangedBy;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date logChangedOn;
    @Version
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
    @ManyToOne
    @CCFieldConfig(componentId = "bndBorrowing", accessible = Accessible.MANDATORY, maxLength = 12, uniqueKey = "code")
    private LibBorrowing borrowing;
    @ManyToOne
    @CCFieldConfig(componentId = "bndBook", accessible = Accessible.MANDATORY, maxLength = 32, uniqueKey = "title")
    private LibBook book;
    @CCFieldConfig(label = "Cost", tooltiptext = "Borrowing Cost", componentId = "txtBorrowingCost", accessible = Accessible.MANDATORY_READONLY, type = Type.NUMBER_FORMAT, maxLength = 24, visible = false)
    private Double borrowingCost;
    @Temporal(value = TemporalType.DATE)
    @CCFieldConfig(componentId = "dtpDateReturn", accessible = Accessible.MANDATORY_READONLY, maxLength = 12)
    private Date dateReturn;
    @CCFieldConfig(label = "Fine", tooltiptext = "Borrowing Fine", componentId = "txtBorrowingFine", accessible = Accessible.MANDATORY_READONLY, type = Type.NUMBER_FORMAT, maxLength = 24, visible = false)
    private Double borrowingFine;

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public LibBorrowing getBorrowing() {
        return borrowing;
    }

    public void setBorrowing(LibBorrowing borrowing) {
        this.borrowing = borrowing;
    }

    public LibBook getBook() {
        return book;
    }

    public void setBook(LibBook book) {
        this.book = book;
    }

    public Double getBorrowingCost() {
        return borrowingCost;
    }

    public void setBorrowingCost(Double borrowingCost) {
        this.borrowingCost = borrowingCost;
    }

    public Date getDateReturn() {
        return dateReturn;
    }

    public void setDateReturn(Date dateReturn) {
        this.dateReturn = dateReturn;
    }

    public Double getBorrowingFine() {
        return borrowingFine;
    }

    public void setBorrowingFine(Double borrowingFine) {
        this.borrowingFine = borrowingFine;
    }
//</editor-fold>
}