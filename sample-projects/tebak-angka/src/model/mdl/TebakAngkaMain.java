package model.mdl;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCMessage;
import static cococare.datafile.CCImage.readImage;
import cococare.framework.swing.CFSwingMap;
import cococare.swing.CCSwing;
import controller.form.PnlIntroCtrl;
import view.form.FrmTebakAngka;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.07.20
 * @version 13.07.20
 */
public class TebakAngkaMain {

    public static int ANSWER = 0;

    public static void main(String[] args) {
        //initial log default handler
        CCMessage.initLogHandler();
        //initial main screen
        CFSwingMap.initMainScreen(FrmTebakAngka.class.getName());
        //put main screen to center
        CCSwing.centerScreen(CFSwingMap.getMainScreen());
        //set icon
        CFSwingMap.getMainScreen().setIconImage(readImage("/cococare/resource/icon-cococare.jpg"));
        //show main screen
        CFSwingMap.getMainScreen().setVisible(true);
        //show screen
        new PnlIntroCtrl().init();
    }
}