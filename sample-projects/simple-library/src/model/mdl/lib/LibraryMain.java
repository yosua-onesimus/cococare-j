package model.mdl.lib;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCLogic.isNotNull;
import static cococare.database.CCLoginInfo.INSTANCE_getUserLogin;
import static cococare.framework.common.CFApplCtrl.APPL_CODE;
import cococare.framework.common.CFApplUae;
import cococare.framework.model.obj.util.UtilUser;
import cococare.framework.swing.CFSwingMain;
import controller.form.lib.*;
import controller.form.sample.PnlBook2ListCtrl;
import controller.form.sample.PnlBook3ListCtrl;
import static model.mdl.lib.LibraryLanguage.*;
import model.obj.lib.LibReport;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class LibraryMain extends CFSwingMain {

    @Override
    protected void _loadInternalSetting() {
        APPL_LOGO = "/cococare/resource/icon-cococare.jpg";
        APPL_VER = "1.0.130317";
        APPL_CODE = "simple-library";
        APPL_NAME = "Simple Library";
        super._loadInternalSetting();
        LibReport.setupReportFile();
    }

    @Override
    protected void _loadExternalSetting() {
        init(false, LibraryLanguage.class);
        super._loadExternalSetting();
    }

    @Override
    protected void _initDatabaseEntity() {
        super._initDatabaseEntity();
        LibraryModule.INSTANCE.init(HIBERNATE);
    }

    @Override
    protected void _initInitialUaeBody(CFApplUae uae) {
        uae.reg(Lib, Config, PnlConfigCtrl.class);
        uae.reg(Lib, Book, PnlBookListCtrl.class);
        uae.reg(Lib, Member, PnlMemberListCtrl.class);
        uae.reg(Lib, Borrowing, PnlBorrowingListCtrl.class);
        uae.reg(Lib, Returning, PnlReturningListCtrl.class);
        uae.reg(Lib, Report, PnlReportListCtrl.class);
    }

    @Override
    protected void _applyUserConfigUaeBody(CFApplUae uae) {
        if (isNotNull(INSTANCE_getUserLogin()) && ((UtilUser) INSTANCE_getUserLogin()).getUserGroup().isRoot()) {
            //login with root-root to access the following two examples
            uae.addMenuRoot(PnlBook2ListCtrl.class, PnlBook3ListCtrl.class);
        }
        uae.addMenuParent(Archive, "/resource/Archive.png", null);
        uae.addMenuChild(Config, "/resource/Config.png", PnlConfigCtrl.class);
        uae.addMenuChild(Book, "/resource/Book.png", PnlBookListCtrl.class);
        uae.addMenuChild(Member, "/resource/Member.png", PnlMemberListCtrl.class);
        uae.addMenuParent(Transaction, "/resource/Transaction.png", null);
        uae.addMenuChild(Borrowing, "/resource/Borrowing.png", PnlBorrowingListCtrl.class);
        uae.addMenuChild(Returning, "/resource/Returning.png", PnlReturningListCtrl.class);
        uae.addMenuParent(Report, "/resource/Report.png", null);
        uae.addMenuChild(Report, "/resource/Report.png", PnlReportListCtrl.class);
        uae.addMenuParent("Other Flow Sample", "/resource/Sample.png", null);
        uae.addMenuChild("Dialog Flow Sample", "/resource/Sample.png", PnlBook2ListCtrl.class);
        uae.addMenuChild("Panel Flow Sample", "/resource/Sample.png", PnlBook3ListCtrl.class);
    }

    public static void main(String[] args) {
        new LibraryMain().showScreen();
    }
}