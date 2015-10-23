package cococare.framework.swing.controller.form.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.model.obj.wf.WfDocumentSampleAttachment;
import cococare.framework.swing.controller.form.PnlDefaultListCtrl;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlDocumentSampleAttachmentListCtrl extends PnlDefaultListCtrl {

    @Override
    protected Class _getEntity() {
        return WfDocumentSampleAttachment.class;
    }
}