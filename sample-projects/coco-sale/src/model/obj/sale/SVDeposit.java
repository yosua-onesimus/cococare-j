package model.obj.sale;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCFieldConfig.Type;
import cococare.common.CCTypeConfig;
import cococare.database.CCEntity;
import java.util.Date;
import javax.persistence.*;
//</editor-fold>

@Entity
@Table(name = "sale_v_deposits")
@CCTypeConfig(label = "Deposit", uniqueKey = "code")
public class SVDeposit extends CCEntity {

    @Column(length = 16)
    @CCFieldConfig(componentId = "txtCode", accessible = Accessible.MANDATORY, maxLength = 16, sequence = "[yyyy]/[MM]/[dd]/00", unique = true, requestFocus = true)
    private String code;
    @Column(name = "date_")
    @Temporal(value = TemporalType.TIMESTAMP)
    @CCFieldConfig(componentId = "dtpDate", accessible = Accessible.MANDATORY, maxLength = 12)
    private Date date = new Date();
    @CCFieldConfig(componentId = "txtAmount", accessible = Accessible.MANDATORY, type = Type.NUMBER_FORMAT, maxLength = 24)
    private Double amount = 0d;

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
//</editor-fold>
}