package model.obj.sale;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCFieldConfig.Type;
import cococare.common.CCTypeConfig;
import cococare.database.CCEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//</editor-fold>

@Entity
@Table(name = "sale_customer_phones")
@CCTypeConfig(label = "Customer Phone", uniqueKey = "phone")
public class SCustomerPhone extends CCEntity {

    @ManyToOne
    @CCFieldConfig(componentId = "bndCustomer", accessible = Accessible.MANDATORY, maxLength = 32, uniqueKey = "name", visible = false)
    private SCustomer customer;
    @Column(length = 16)
    @CCFieldConfig(componentId = "txtPhone", accessible = Accessible.MANDATORY, type = Type.PHONE_NUMBER, maxLength = 16, unique = true, requestFocus = true)
    private String phone;

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public SCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(SCustomer customer) {
        this.customer = customer;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
//</editor-fold>
}