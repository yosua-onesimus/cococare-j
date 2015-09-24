package controller.form.lib;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.framework.swing.controller.form.PnlReportDefaultListCtrl;
import cococare.swing.component.CCBandBox;
import javax.swing.JLabel;
import model.obj.lib.LibReport;
import model.obj.lib.LibReport.Report;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlReportListCtrl extends PnlReportDefaultListCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private JLabel xBook;
    private CCBandBox bndBook;
    private JLabel xMember;
    private CCBandBox bndMember;
//</editor-fold>

    @Override
    protected Class _getEntity() {
        return LibReport.class;
    }

    @Override
    protected Class _getReportEnum() {
        return Report.class;
    }

    @Override
    protected void _doUpdateAccessible() {
        int selectedIndex = cmbReport.getSelectedIndex();
        edtEntity.setAccessible(bndBook, selectedIndex == Report.BOOK_HISTORY.ordinal() ? CCFieldConfig.Accessible.MANDATORY : CCFieldConfig.Accessible.NORMAL);
        edtEntity.setAccessible(bndMember, selectedIndex == Report.MEMBER_HISTORY.ordinal() ? CCFieldConfig.Accessible.MANDATORY : CCFieldConfig.Accessible.NORMAL);
        xBook.setVisible(selectedIndex == Report.BOOK_HISTORY.ordinal());
        bndBook.setVisible(selectedIndex == Report.BOOK_HISTORY.ordinal());
        xMember.setVisible(selectedIndex == Report.MEMBER_HISTORY.ordinal());
        bndMember.setVisible(selectedIndex == Report.MEMBER_HISTORY.ordinal());
    }
}