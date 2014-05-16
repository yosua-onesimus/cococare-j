package model.mdl.lib;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.common.CFApplCtrl;
import static cococare.framework.common.CFApplCtrl.APPL_CODE;
import cococare.framework.swing.CFSwingMain;
import static cococare.framework.swing.CFSwingMap.*;
import cococare.framework.swing.CFSwingUae;
import cococare.framework.swing.controller.form.util.PnlLoginCtrl;
import controller.form.lib.*;
import static model.mdl.lib.LibraryLanguage.*;
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
    public boolean initInitialData() {
        super.initInitialData();
        CFSwingUae uae = new CFSwingUae();
        uae.reg(Lib, Config, PnlConfigCtrl.class);
        uae.reg(Lib, Book, PnlBookListCtrl.class);
        uae.reg(Lib, Member, PnlMemberListCtrl.class);
        uae.reg(Lib, Borrowing, PnlBorrowingListCtrl.class);
        uae.reg(Lib, Returning, PnlReturningListCtrl.class);
        return _initInitialDataUaeUtility(uae).compile();
    }

    @Override
    protected void _applyUserConfig() {
        CFSwingUae uae = new CFSwingUae();
        uae.initMenuBar(CFApplCtrl.MenuPosition.LEFT_SIDE.equals(MENU_POST) ? getMenubarV() : getMenubarH());
        uae.addMenuRoot(PnlLoginCtrl.class);
        uae.addMenuParent(Archive, null, null);
        uae.addMenuChild(Config, null, PnlConfigCtrl.class);
        uae.addMenuChild(Book, null, PnlBookListCtrl.class);
        uae.addMenuChild(Member, null, PnlMemberListCtrl.class);
        uae.addMenuParent(Transaction, null, null);
        uae.addMenuChild(Borrowing, null, PnlBorrowingListCtrl.class);
        uae.addMenuChild(Returning, null, PnlReturningListCtrl.class);
        uae.changeMenuSide();
        _applyUserConfigUaeUtility(uae).compileMenu();
        getMainScreen().validate();
    }

    public static void main(String[] args) {
        new LibraryMain().showScreen();
    }
}