package model.obj;

import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCTypeConfig;
import cococare.database.CCEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "inv_employees")
@CCTypeConfig(label = "Employee", uniqueKey = "name")
public class Employee extends CCEntity {

    @Column(length = 16)
    @CCFieldConfig(componentId = "txtCode", accessible = Accessible.MANDATORY, maxLength = 16, sequence = "EMP/[yyMMdd]/000", requestFocus = true, unique = true)
    private String code;
    @Column(length = 255)
    @CCFieldConfig(componentId = "txtName", accessible = Accessible.MANDATORY)
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}