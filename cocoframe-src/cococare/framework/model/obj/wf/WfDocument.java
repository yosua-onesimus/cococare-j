package cococare.framework.model.obj.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCTypeConfig;
import cococare.database.CCEntity;
import javax.persistence.Entity;
import javax.persistence.Table;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
@Entity
@Table(name = "wf_documents")
@CCTypeConfig(label = "Document", uniqueKey = "")
public class WfDocument extends CCEntity {
}