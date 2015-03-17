package model.mdl;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCLanguage;
import cococare.common.CCMessage;
import cococare.database.CCLoginInfo;
import cococare.datafile.CCFile;
import static cococare.datafile.CCImage.readImage;
import cococare.datafile.jxl.CCExcel;
import cococare.framework.swing.CFSwingMap;
import cococare.framework.swing.CFSwingUae;
import cococare.swing.CCSwing;
import controller.form.PnlCococareCtrl;
import controller.form.PnlEnigmaSquareCtrl;
import controller.form.PnlExitCtrl;
import controller.form.PnlQuestionListCtrl;
import java.io.File;
import java.util.List;
import model.obj.GameOption;
import model.obj.Player;
import model.obj.Question;
import view.form.FrmEnigmaSquare;
//</editor-fold>

public class EnigmaSquareMain {

//<editor-fold defaultstate="collapsed" desc=" public objectt ">
    public static String gameOptionFileName = "game.conf";
    public static GameOption gameOption;
    public static String questionsFileName = "questions.xls";
    public static List<Question> questions;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" load-and-save ">
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
//</editor-fold>

    public static void main(String[] args) {
        //initial log default handler
        CCMessage.initLogHandler();
        //load language for auto-message purpose and auto-validation purpose
        CCLanguage.load(CCLanguage.LanguagePack.EN);
        //set login info for without-login purpose
        CCLoginInfo.INSTANCE = null;
        //load game option
        loadGameOption();
        //load questions from excel
        loadQuestions();
        //initial main screen
        CFSwingMap.initMainScreen(FrmEnigmaSquare.class.getName());
        //compile menubar
        boolean admin = args.length > 0 && "-admin".equals(args[0]);
        CFSwingUae swingUae = new CFSwingUae();
        swingUae.initMenuBar(CFSwingMap.getMenubarH());
        swingUae.addMenuParent("Permainan", null, PnlEnigmaSquareCtrl.class);
        if (admin) {
            swingUae.addMenuParent("Edit Pertanyaan", null, PnlQuestionListCtrl.class);
        }
        swingUae.changeMenuSide();
        if (admin) {
            swingUae.addMenuParent("created by cococare", null, PnlCococareCtrl.class);
        }
        swingUae.addMenuParent("Keluar", null, PnlExitCtrl.class);
        swingUae.compileMenu();
        //put main screen to center
        CCSwing.centerScreen(CFSwingMap.getMainScreen());
        //set icon
        CFSwingMap.getMainScreen().setIconImage(readImage("/cococare/resource/icon-cococare.jpg"));
        //show main screen
        CFSwingMap.getMainScreen().setVisible(true);
        //show screen
        new PnlEnigmaSquareCtrl().init();
    }
}