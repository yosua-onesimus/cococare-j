package cococare.framework.swing.controller.form.note;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.model.obj.note.NoteEnum.ReferenceType;
import cococare.framework.model.obj.note.NoteReference;
import cococare.framework.swing.CFSwingCtrl;
import static cococare.swing.CCSwing.addListener;
import cococare.swing.component.CCAttachment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JTextField;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlReferenceCtrl extends CFSwingCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private JComboBox cmbType;
    private CCAttachment attByteA;
    private JTextField txtValue;
//</editor-fold>

    @Override
    protected Class _getEntity() {
        return NoteReference.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.FORM_FUNCTION;
    }

    @Override
    protected void _initListener() {
        super._initListener();
        addListener(cmbType, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                _doUpdateVisibility();
            }
        });
    }

    private void _doUpdateVisibility() {
        ReferenceType referenceType = ReferenceType.values()[cmbType.getSelectedIndex()];
        attByteA.setVisible(ReferenceType.ATTACHMENT.equals(referenceType));
        txtValue.setVisible(!ReferenceType.ATTACHMENT.equals(referenceType));
    }

    @Override
    protected void _getValueFromEditor() {
        super._getValueFromEditor();
        ReferenceType referenceType = ReferenceType.values()[cmbType.getSelectedIndex()];
        if (ReferenceType.ATTACHMENT.equals(referenceType)) {
            ((NoteReference) objEntity).setValue(attByteA.getFileName());
        }
    }
}