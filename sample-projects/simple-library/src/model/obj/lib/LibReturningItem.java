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
@Table(name = "lib_returning_items")
@CCTypeConfig(label = "Returning Item", uniqueKey = "borrowingItem.book.title")
public class LibReturningItem implements CCEntity {

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
    @CCFieldConfig(componentId = "bndReturning", accessible = Accessible.MANDATORY, maxLength = 12, uniqueKey = "code")
    private LibReturning returning;
    @ManyToOne
    @CCFieldConfig(label = "Book", componentId = "bndBorrowingItem", accessible = Accessible.MANDATORY, maxLength = 12, uniqueKey = "book.title", requestFocus = true)
    private LibBorrowingItem borrowingItem;
    @CCFieldConfig(label = "Fine", tooltiptext = "Borrowing Fine", componentId = "txtBorrowingFine", accessible = Accessible.MANDATORY_READONLY, type = Type.NUMBER_FORMAT, maxLength = 24)
    private Double borrowingFine;

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public LibReturning getReturning() {
        return returning;
    }

    public void setReturning(LibReturning returning) {
        this.returning = returning;
    }

    public LibBorrowingItem getBorrowingItem() {
        return borrowingItem;
    }

    public void setBorrowingItem(LibBorrowingItem borrowingItem) {
        this.borrowingItem = borrowingItem;
    }

    public Double getBorrowingFine() {
        return borrowingFine;
    }

    public void setBorrowingFine(Double borrowingFine) {
        this.borrowingFine = borrowingFine;
    }
//</editor-fold>
}