package model.obj.sale;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCFieldConfig.OnDelete;
import cococare.common.CCFieldConfig.Type;
import cococare.common.CCTypeConfig;
import cococare.database.CCEntity;
import java.util.List;
import javax.persistence.*;
//</editor-fold>

@Entity
@Table(name = "sale_customers")
@CCTypeConfig(label = "Customer", uniqueKey = "name")
public class SCustomer extends CCEntity {

    @Column(length = 32)
    @CCFieldConfig(componentId = "txtName", accessible = Accessible.MANDATORY, maxLength = 32, requestFocus = true)
    private String name;
    @Column(length = 255)
    @CCFieldConfig(componentId = "txtAddress", visible = false)
    private String address;
    @Column(length = 16)
    @CCFieldConfig(componentId = "txtPhone", type = Type.PHONE_NUMBER, maxLength = 16, unique = true, visible = false)
    private String phone;
    @Column(length = 32)
    @CCFieldConfig(componentId = "txtEmail", type = Type.EMAIL, maxLength = 32, unique = true)
    private String email;
    @Column(length = 32)
    @CCFieldConfig(componentId = "txtFacebook", maxLength = 32, unique = true)
    private String facebook;
    /**
     * plus:receivable<br/>
     * minus:payable
     */
    @CCFieldConfig(componentId = "txtBalance", accessible = Accessible.READONLY, type = Type.NUMBER_FORMAT, maxLength = 24)
    private Double balance = 0d;
//<editor-fold defaultstate="collapsed" desc=" cascade ">
    @OneToMany(cascade = {CascadeType.REMOVE}, mappedBy = "customer")
    @CCFieldConfig(onDelete = OnDelete.CASCADE)
    private List<SCustomerPhone> customerPhones;
    @OneToMany(cascade = {CascadeType.REMOVE}, mappedBy = "customer")
    @CCFieldConfig(onDelete = OnDelete.RESTRICT)
    private List<SVSelling> sellings;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
//</editor-fold>
}