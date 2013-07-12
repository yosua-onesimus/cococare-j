package cococare.framework.swing.controller.form.setup;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCClass.getCCFields;
import cococare.common.CCField;
import static cococare.common.CCLanguage.*;
import cococare.framework.model.mdl.note.NotesLanguage;
import cococare.framework.swing.CFSwingCtrl;
import static cococare.swing.CCSwing.*;
import cococare.swing.CCTable;
import cococare.swing.component.CCButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlLanguageSetupCtrl extends CFSwingCtrl {

    private JComboBox cmbLanguagePack;
    private CCButton btnLoad;
    private CCButton btnSave;
    private CCTable tblLanguage;

    @Override
    protected Class _getEntity() {
        return null;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.FORM_FUNCTION;
    }

    @Override
    protected void _initComponent() {
        super._initComponent();
        fillUp(cmbLanguagePack, LanguagePack.class, false);
        tblLanguage = new CCTable(getJTable(getContainer(), "tblLanguage"), "Key", "Value");
        tblLanguage.setEditableColumn(true, 1);
    }

    @Override
    protected void _initListener() {
        super._initListener();
        addActionListener(btnLoad, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _doLoad();
            }
        });
        addActionListener(btnSave, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _doSave();
            }
        });
    }

    private void _doLoad() {
        load(LanguagePack.values()[cmbLanguagePack.getSelectedIndex()]);
        tblLanguage.removeRows();
        for (CCField field : getCCFields(NotesLanguage.class)) {
            if (String.class.equals(field.getType())) {
                tblLanguage.addRow(field.getFieldName(), turn(field.getFieldName()));
            }
        }
    }

    @Override
    protected void _doSave() {
        for (int row = 0; row < tblLanguage.getRowCount(); row++) {
            getProperties().setProperty(tblLanguage.getTable().getValueAt(row, 0).toString(), tblLanguage.getTable().getValueAt(row, 1).toString());
        }
        save(LanguagePack.values()[cmbLanguagePack.getSelectedIndex()]);
    }
}