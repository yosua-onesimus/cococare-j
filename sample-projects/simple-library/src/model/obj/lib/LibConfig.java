package model.obj.lib;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCFieldConfig.Type;
import cococare.common.CCTypeConfig;
import cococare.database.CCEntity;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
@CCTypeConfig(label = "Library Module", tooltiptext = "Borrowing Cost, Borrowing Limit, Borrowing Fine, etc")
public class LibConfig extends CCEntity {

    @CCFieldConfig(group = "Default Value of Borrowing", label = "Cost (Rp)", tooltiptext = "Borrowing Cost", componentId = "txtBorrowingCost", accessible = Accessible.MANDATORY, type = Type.NUMBER_FORMAT, maxLength = 24, visible = false)
    private Double borrowingCost;
    @CCFieldConfig(group = "Default Value of Borrowing", label = "Limit (days)", tooltiptext = "Borrowing Limit", componentId = "txtBorrowingLimit", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 2, visible = false)
    private Integer borrowingLimit;
    @CCFieldConfig(group = "Default Value of Borrowing", label = "Fine (Rp)", tooltiptext = "Borrowing Fine", componentId = "txtBorrowingFine", accessible = Accessible.MANDATORY, type = Type.NUMBER_FORMAT, maxLength = 24, visible = false)
    private Double borrowingFine;

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public Double getBorrowingCost() {
        return borrowingCost;
    }

    public void setBorrowingCost(Double borrowingCost) {
        this.borrowingCost = borrowingCost;
    }

    public Integer getBorrowingLimit() {
        return borrowingLimit;
    }

    public void setBorrowingLimit(Integer borrowingLimit) {
        this.borrowingLimit = borrowingLimit;
    }

    public Double getBorrowingFine() {
        return borrowingFine;
    }

    public void setBorrowingFine(Double borrowingFine) {
        this.borrowingFine = borrowingFine;
    }
//</editor-fold>
}