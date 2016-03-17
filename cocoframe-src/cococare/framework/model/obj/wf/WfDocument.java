package cococare.framework.model.obj.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCFieldConfig.Type;
import static cococare.common.CCLogic.isNull;
import cococare.common.CCTypeConfig;
import cococare.database.CCEntity;
import cococare.framework.model.obj.wf.WfEnum.DocumentStatus;
import java.util.Date;
import javax.persistence.*;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
@Entity
@Table(name = "wf_documents")
@CCTypeConfig(label = "Document", uniqueKey = "number")
public class WfDocument extends CCEntity {

    @ManyToOne
    @CCFieldConfig(visible = false, visible2 = false)
    private WfDocument portfolio;
    @Column(length = 32)
    @CCFieldConfig(accessible = Accessible.MANDATORY, maxLength = 32, sequence = "P/[yyMMdd]/000", unique = true, requestFocus = true)
    private String number;
    @Temporal(value = TemporalType.DATE)
    @Column(name = "date_")
    @CCFieldConfig(componentId = "dtpDate", type = Type.DATE, accessible = Accessible.MANDATORY)
    private Date date = new Date();
    @CCFieldConfig(accessible = Accessible.MANDATORY, optionSource = "cococare.framework.model.obj.wf.WfEnum$DocumentStatus", optionReflectKey = "status", visible = false, visible2 = false)
    private Integer statusIndex = DocumentStatus.PORTFOLIO.ordinal();
    @Column(length = 12)
    @CCFieldConfig(maxLength = 12, visible = false, visible2 = false)
    private String status = DocumentStatus.PORTFOLIO.toString();
    //
    transient private WfWorkflow workflow;

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public WfDocument getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(WfDocument portfolio) {
        this.portfolio = portfolio;
        if (isNull(portfolio)) {
            setDocumentStatus(DocumentStatus.PORTFOLIO);
        } else {
            setDocumentStatus(DocumentStatus.ACTIVE);
        }
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getStatusIndex() {
        return statusIndex;
    }

    public void setStatusIndex(Integer statusIndex) {
        this.statusIndex = statusIndex;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DocumentStatus getDocumentStatus() {
        return DocumentStatus.values()[getStatusIndex()];
    }

    public void setDocumentStatus(DocumentStatus documentStatus) {
        setStatusIndex(documentStatus.ordinal());
        setStatus(documentStatus.toString());
    }

    public WfWorkflow getWorkflow() {
        return workflow;
    }

    public void setWorkflow(WfWorkflow workflow) {
        this.workflow = workflow;
    }
//</editor-fold>
}