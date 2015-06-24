package cococare.framework.swing;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCFinal.*;
import static cococare.swing.CCSwing.*;
import cococare.swing.component.CCButton;
import cococare.swing.component.CCPaging;
import java.awt.Container;
import javax.swing.*;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class CFSwingView {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private Container container;
    private JDialog dialog;
    private JPanel panel;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" CFSwingView ">
    public CFSwingView(Container container) {
        this.container = container;
        if (container instanceof JDialog) {
            dialog = (JDialog) container;
        } else if (container instanceof JPanel) {
            panel = (JPanel) container;
        }
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" getter() ">
    public Container getContainer() {
        return container;
    }

    public JDialog getDialog() {
        return dialog;
    }

    public JPanel getPanel() {
        return panel;
    }

    public CCButton getBtnAdd() {
        return getCCButton(getContainer(), btnAdd);
    }

    public CCButton getBtnView() {
        return getCCButton(getContainer(), btnView);
    }

    public CCButton getBtnEdit() {
        return getCCButton(getContainer(), btnEdit);
    }

    public CCButton getBtnDelete() {
        return getCCButton(getContainer(), btnDelete);
    }

    public CCButton getBtnExport() {
        return getCCButton(getContainer(), btnExport);
    }

    public CCButton getBtnFilter() {
        return getCCButton(getContainer(), "_" + btnFilter);
    }

    public CCButton getBtnNew() {
        return getCCButton(getContainer(), btnNew);
    }

    public CCButton getBtnSave() {
        return getCCButton(getContainer(), btnSave);
    }

    public CCButton getBtnSaveAndNew() {
        return getCCButton(getContainer(), btnSaveAndNew);
    }

    public CCButton getBtnCancel() {
        return getCCButton(getContainer(), btnCancel);
    }

    public CCButton getBtnClose() {
        return getCCButton(getContainer(), btnClose);
    }

    public JTextField getTxtKeyword() {
        return getJTextField(getContainer(), txtKeyword);
    }

    public JTabbedPane getTabEntity() {
        return getJTabbedPane(getContainer(), tabEntity);
    }

    public JTable getTblEntity() {
        return getJTable(getContainer(), tblEntity);
    }

    public CCPaging getPgnEntity() {
        return getCCPaging(getContainer(), pgnEntity);
    }

    public JPanel getPnlEntity() {
        return getJPanel(getContainer(), pnlEntity);
    }

    public JPanel getPnlGenerator() {
        return getJPanel(getContainer(), pnlGenerator);
    }

    public CCButton getBtnFirst() {
        return getCCButton(getContainer(), btnFirst);
    }

    public CCButton getBtnPrev() {
        return getCCButton(getContainer(), btnPrev);
    }

    public CCButton getBtnNext() {
        return getCCButton(getContainer(), btnNext);
    }

    public CCButton getBtnLast() {
        return getCCButton(getContainer(), btnLast);
    }
//</editor-fold>
}