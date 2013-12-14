package cococare.framework.swing;

// <editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCClass;
import static cococare.common.CCClass.instanceOf;
import static cococare.common.CCClass.newObject;
import static cococare.common.CCFinal.*;
import cococare.framework.swing.view.form.FrmMain;
import static cococare.swing.CCSwing.*;
import cococare.swing.component.CCImage;
import cococare.swing.component.CCMenuBar;
import cococare.swing.component.CCProgressBar;
import java.awt.Component;
import java.awt.Container;
import java.awt.Frame;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
// </editor-fold>

/**
 * CFSwingMap is a class that contains a mapping for the swing so easy retrieval
 * of common components.
 *
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class CFSwingMap {

// <editor-fold defaultstate="collapsed" desc=" private enum ">
    private enum ClassType {

        MODEL_OBJ("model.obj", ""),
        MODEL_DAO("model.dao", "Dao"),
        MODEL_BO("model.bo", "Bo"),
        VIEW_FORM("view.form", ""),
        VIEW_FORM_LIST("view.form", "List"),
        CONTROLLER_FORM("controller.form", "Ctrl"),
        CONTROLLER_FORM_LIST("controller.form", "ListCtrl");
        private String prefix;
        private String suffix;

        private ClassType(String prefix, String suffix) {
            this.prefix = prefix;
            this.suffix = suffix;
        }

        private String getPrefix() {
            return prefix;
        }

        private String getSuffix() {
            return suffix;
        }
    }
// </editor-fold>
    //
// <editor-fold defaultstate="collapsed" desc=" private object ">
    private static final String PATH_MAIN_SCREEN = FrmMain.class.getName();
    private static JFrame frmMain;
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc=" swing map ">
    private static boolean _isClassType(String className, ClassType classType) {
        return className.contains(classType.getPrefix()) && className.endsWith(classType.getSuffix());
    }

    /**
     * @param clazz CONTROLLER_FORM | VIEW_FORM_LIST | VIEW_FORM
     * @return VIEW_FORM
     */
    public static Class getViewForm(Class clazz) {
        String className = clazz.getName();
        String viewForm = null;
        if (_isClassType(className, ClassType.CONTROLLER_FORM)) {
            viewForm = className.replaceFirst(ClassType.CONTROLLER_FORM.getPrefix(), ClassType.VIEW_FORM.getPrefix()).replaceFirst(ClassType.CONTROLLER_FORM.getSuffix(), ClassType.VIEW_FORM.getSuffix());
        } else if (_isClassType(className, ClassType.VIEW_FORM_LIST)) {
            viewForm = className.replaceFirst(ClassType.VIEW_FORM_LIST.getSuffix(), ClassType.VIEW_FORM.getSuffix());
        } else if (_isClassType(className, ClassType.VIEW_FORM)) {
            viewForm = className + ClassType.VIEW_FORM_LIST.getSuffix();
        }
        return CCClass.getClass(viewForm);
    }

    /**
     * @param controllerClass CONTROLLER_FORM | VIEW_FORM_LIST
     * @return JDialog | JPanel
     */
    public static Container newContainer(Class controllerClass) {
        Class viewClass = getViewForm(controllerClass);
        if (instanceOf(JDialog.class, viewClass)) {
            return (Container) newObject(viewClass, new Class[]{Frame.class, boolean.class}, new Object[]{getMainScreen(), true});
        } else if (instanceOf(JPanel.class, viewClass)) {
            return (Container) newObject(viewClass);
        } else {
            return null;
        }
    }

    /**
     * @param clazz VIEW_FORM | CONTROLLER_FORM_LIST | CONTROLLER_FORM
     * @return CONTROLLER_FORM
     */
    public static Class getControllerForm(Class clazz) {
        String className = clazz.getName();
        String controllerForm = null;
        if (_isClassType(className, ClassType.VIEW_FORM)) {
            controllerForm = className.replaceFirst(ClassType.VIEW_FORM.getPrefix(), ClassType.CONTROLLER_FORM.getPrefix()) + ClassType.CONTROLLER_FORM.getSuffix();
        } else if (_isClassType(className, ClassType.CONTROLLER_FORM_LIST)) {
            controllerForm = className.replaceFirst(ClassType.CONTROLLER_FORM_LIST.getSuffix(), ClassType.CONTROLLER_FORM.getSuffix());
        } else if (_isClassType(className, ClassType.CONTROLLER_FORM)) {
            controllerForm = className.replaceFirst(ClassType.CONTROLLER_FORM.getSuffix(), ClassType.CONTROLLER_FORM_LIST.getSuffix());
        }
        return CCClass.getClass(controllerForm);
    }
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc=" swing path ">
    static {
        initMainScreen(PATH_MAIN_SCREEN);
    }

    /**
     * Initial a main screen.
     *
     * @param frmMainPath the frmMainPath.
     */
    public static void initMainScreen(String frmMainPath) {
        frmMain = (JFrame) newObject(frmMainPath);
    }

    /**
     * Returns a main screen.
     *
     * @return the main screen.
     */
    public static JFrame getMainScreen() {
        return frmMain;
    }

    /**
     * Returns a header.
     *
     * @return the header.
     */
    public static JPanel getHeader() {
        return getJPanel(getMainScreen(), aHeader);
    }

    /**
     * Returns a appl logo.
     *
     * @return the appl logo.
     */
    public static CCImage getApplLogo() {
        return getCCImage(getMainScreen(), aApplLogo);
    }

    /**
     * Returns a appl name.
     *
     * @return the appl name.
     */
    public static JLabel getApplName() {
        return getJLabel(getMainScreen(), aApplName);
    }

    /**
     * Returns a appl ver.
     *
     * @return the appl ver.
     */
    public static JLabel getApplVer() {
        return getJLabel(getMainScreen(), aApplVer);
    }

    /**
     * Returns a comp logo.
     *
     * @return the comp logo.
     */
    public static CCImage getCompLogo() {
        return getCCImage(getMainScreen(), aCompLogo);
    }

    /**
     * Returns a comp name.
     *
     * @return the comp name.
     */
    public static JLabel getCompName() {
        return getJLabel(getMainScreen(), aCompName);
    }

    /**
     * Returns a menu bar.
     *
     * @return the menu bar.
     */
    public static Component getMenubar() {
        return getComponent(getMainScreen(), aMenuBar);
    }

    /**
     * Returns a menu bar.
     *
     * @return the menu bar.
     */
    public static CCMenuBar getMenubarH() {
        return getCCMenuBar(getMainScreen(), aMenuBarH);
    }

    /**
     * Returns a menu bar.
     *
     * @return the menu bar.
     */
    public static CCMenuBar getMenubarV() {
        return getCCMenuBar(getMainScreen(), aMenuBarV);
    }

    /**
     * Returns a content.
     *
     * @return the content.
     */
    public static JPanel getContent() {
        return getJPanel(getMainScreen(), aContent);
    }

    /**
     * Returns a content image.
     *
     * @return the content image.
     */
    public static CCImage getContentImage() {
        return getCCImage(getMainScreen(), aContent);
    }

    /**
     * Returns a footer.
     *
     * @return the footer.
     */
    public static JPanel getFooter() {
        return getJPanel(getMainScreen(), aFooter);
    }

    /**
     * Returns a progress bar.
     *
     * @return the progress bar.
     */
    public static CCProgressBar getCCProgressbar() {
        return getCCProgressBar(getMainScreen(), aProgressBar);
    }
// </editor-fold>
}