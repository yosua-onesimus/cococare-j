package model.mdl;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCLanguage;
import cococare.common.CCMessage;
import cococare.database.CCLoginInfo;
import cococare.datafile.CCFile;
import static cococare.datafile.CCImage.getImage;
import cococare.datafile.jxl.CCExcel;
import cococare.framework.swing.CFSwingMap;
import static cococare.framework.swing.CFSwingMap.getMainScreen;
import cococare.framework.swing.CFSwingUae;
import cococare.swing.CCSwing;
import controller.form.PnlExitCtrl;
import controller.form.PnlQuestionListCtrl;
import controller.form.PnlSnakeAndLadderCtrl;
import java.io.File;
import java.util.List;
import model.obj.GameOption;
import model.obj.Player;
import model.obj.Question;
import view.form.FrmSnakeAndLadder;
//</editor-fold>

public class SnakeAndLadderMain {

//<editor-fold defaultstate="collapsed" desc=" public objectt ">
    public static String gameOptionFileName = "game.conf";
    public static GameOption gameOption;
    public static String questionsFileName = "questions.xls";
    public static List<Question> questions;
//</editor-fold>

    public static boolean loadGameOption() {
        try {
            File file = CCFile.getFileSystConfFile(gameOptionFileName);
            if (!file.exists()) {
                gameOption = new GameOption();
                gameOption.getPlayers().add(new Player());
                gameOption.getPlayers().add(new Player());
                gameOption.getPlayers().add(new Player());
                gameOption.getPlayers().add(new Player());
                gameOption.getPlayers().add(new Player());
                saveGameOption();
            }
            gameOption = (GameOption) CCFile.readObject(file);
            return true;
        } catch (Exception exception) {
            CCMessage.logp(exception);
            CCMessage.showError();
            return false;
        }
    }

    public static boolean saveGameOption() {
        try {
            return CCFile.writeObject(gameOption, CCFile.getFileSystConfFile(gameOptionFileName));
        } catch (Exception exception) {
            CCMessage.logp(exception);
            CCMessage.showError();
            return false;
        }
    }

    public static boolean loadQuestions() {
        try {
            CCExcel excel = new CCExcel();
            File file = CCFile.getFileSystConfFile(questionsFileName);
            if (!file.exists()) {
                saveQuestions();
            }
            excel.openWorkbook(file);
            excel.getSheet(Question.class.getSimpleName());
            excel.initEntity(Question.class, false);
            questions = excel.readRowEntity(1, excel.getRowCount() - 1);
            return excel.closeWorkbook();
        } catch (Exception exception) {
            CCMessage.logp(exception);
            CCMessage.showError();
            return false;
        }
    }

    public static boolean saveQuestions() {
        try {
            CCExcel excel = new CCExcel();
            excel.newWorkbook();
            excel.newSheet(Question.class.getSimpleName());
            excel.initEntity(Question.class, false);
            excel.writeRowEntityHeader();
            excel.writeRowEntity(questions);
            return excel.saveAndCloseWorkbook(CCFile.getFileSystConfFile(questionsFileName));
        } catch (Exception exception) {
            CCMessage.logp(exception);
            CCMessage.showError();
            return false;
        }
    }

    public static void main(String[] args) {
        //initial log default handler
        CCMessage.initDefaultHandler();
        //load language for auto-message purpose and auto-validation purpose
        CCLanguage.load(CCLanguage.LanguagePack.EN);
        //set login info for without-login purpose
        CCLoginInfo.INSTANCE = null;
        //load game option
        loadGameOption();
        //load questions from excel
        loadQuestions();
        //initial main screen
        CFSwingMap.initMainScreen(FrmSnakeAndLadder.class.getName());
        //compile menubar
        CFSwingUae swingUae = new CFSwingUae();
        swingUae.initMenuBar(CFSwingMap.getMenubarH());
        swingUae.addMenuParent("Ular Tangga", null, PnlSnakeAndLadderCtrl.class);
        swingUae.addMenuParent("Edit Pertanyaan", null, PnlQuestionListCtrl.class);
        swingUae.changeMenuSide();
        swingUae.addMenuParent("Keluar", null, PnlExitCtrl.class);
        swingUae.compileMenu();
        //show screen
        new PnlSnakeAndLadderCtrl().init();
        CCSwing.centerScreen(CFSwingMap.getMainScreen());
        getMainScreen().setIconImage(getImage("/cococare/resource/icon-cococare.jpg"));
        CFSwingMap.getMainScreen().setVisible(true);
    }
}