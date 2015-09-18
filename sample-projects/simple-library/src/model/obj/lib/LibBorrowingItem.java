package model.obj.lib;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCFieldConfig.Type;
import static cococare.common.CCFormat.getBoolean;
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
public class LibBorrowingItem extends CCEntity {

    @ManyToOne
    @CCFieldConfig(componentId = "bndBorrowing", accessible = Accessible.MANDATORY, maxLength = 12, uniqueKey = "code")
    private LibBorrowing borrowing;
    @ManyToOne
    @CCFieldConfig(componentId = "bndBook", accessible = Accessible.MANDATORY, maxLength = 32, uniqueKey = "title", requestFocus = true)
    private LibBook book;
    @CCFieldConfig(label = "Cost", tooltiptext = "Borrowing Cost", componentId = "txtBorrowingCost", accessible = Accessible.MANDATORY_READONLY, type = Type.NUMBER_FORMAT, maxLength = 24)
    private Double borrowingCost;
    @Temporal(value = TemporalType.DATE)
    @CCFieldConfig(componentId = "dtpDateReturn", accessible = Accessible.MANDATORY_READONLY, maxLength = 12)
    private Date dateReturn;
    @CCFieldConfig(label = "Fine", tooltiptext = "Borrowing Fine", componentId = "txtBorrowingFine", accessible = Accessible.MANDATORY_READONLY, type = Type.NUMBER_FORMAT, maxLength = 24, visible = false)
    private Double borrowingFine;
    @CCFieldConfig(label = "R", tooltiptext = "Returned", componentId = "chkReturned", maxLength = 4)
    private Boolean returned = false;

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

    public Boolean getReturned() {
        return returned;
    }

    public boolean isReturned() {
        return getBoolean(returned);
    }

    public void setReturned(Boolean returned) {
        this.returned = returned;
    }
//</editor-fold>
}