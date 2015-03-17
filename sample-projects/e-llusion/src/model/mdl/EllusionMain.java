package model.mdl;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCMessage;
import cococare.database.CCLoginInfo;
import static cococare.datafile.CCImage.readImage;
import cococare.framework.swing.CFSwingMap;
import cococare.framework.swing.CFSwingUae;
import cococare.swing.CCSwing;
import controller.form.PnlEllusion1Ctrl;
import controller.form.PnlExitCtrl;
import view.form.FrmEllusion;
//</editor-fold>

public class EllusionMain {

    public static void main(String[] args) {
        //initial log default handler
        CCMessage.initLogHandler();
        //set login info for without-login purpose
        CCLoginInfo.INSTANCE = null;
        //initial main screen
        CFSwingMap.initMainScreen(FrmEllusion.class.getName());
        //compile menubar
        CFSwingUae swingUae = new CFSwingUae();
        swingUae.initMenuBar(CFSwingMap.getMenubarH());
        swingUae.addMenuParent("(e)llusion I", null, PnlEllusion1Ctrl.class);
        swingUae.changeMenuSide();
        swingUae.addMenuParent("Keluar", null, PnlExitCtrl.class);
        swingUae.compileMenu();
        //put main screen to center
        CCSwing.centerScreen(CFSwingMap.getMainScreen());
        //set icon
        CFSwingMap.getMainScreen().setIconImage(readImage("/cococare/resource/icon-cococare.jpg"));
        //show main screen
        CFSwingMap.getMainScreen().setVisible(true);
    }
}