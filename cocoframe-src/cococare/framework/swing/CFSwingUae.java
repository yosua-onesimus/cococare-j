package cococare.framework.swing;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCAccessibleListener.nonAccessible;
import static cococare.common.CCClass.*;
import cococare.common.CCField;
import static cococare.common.CCFormat.nextSequence;
import static cococare.common.CCFormat.toHumanizeCase;
import static cococare.common.CCLogic.isNotNull;
import static cococare.common.CCLogic.isNull;
import cococare.common.CCTrackable;
import static cococare.database.CCLoginInfo.INSTANCE_isCompAccessible;
import cococare.framework.model.bo.util.UtilInitInitialDataBo;
import cococare.framework.model.obj.util.UtilPrivilege;
import static cococare.framework.swing.CFSwingMap.getViewForm;
import cococare.swing.component.CCButton;
import cococare.swing.component.CCMenuBar;
import cococare.swing.component.CCMenuBar.MenuCandidate;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.AbstractButton;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class CFSwingUae {

//<editor-fold defaultstate="collapsed" desc=" private object ">
//<editor-fold defaultstate="collapsed" desc=" register controllerClass to create privilege ">
    private String screenCode = "00";
    private String actionCode = "00";
    protected List<UtilPrivilege> privileges = new ArrayList();
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc=" register controllerClass to menuBar ">
    private CCMenuBar menuBar;
    private List<Class<? extends CFSwingCtrl>> menuRoot = new ArrayList();
    private int pc = 1;
    private int cc = 1;
    private boolean leftSide = true;
    private HashMap<Integer, MenuCandidate> leftSideMenus = new LinkedHashMap();
    private HashMap<Integer, MenuCandidate> rightSideMenus = new LinkedHashMap();
    private HashMap<MenuCandidate, Boolean> accessibles = new HashMap();
//</editor-fold>
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" private method ">
//<editor-fold defaultstate="collapsed" desc=" register controllerClass to create privilege ">
    private String _getScreenComp(Class controllerClass) {
        return controllerClass.getName();
    }

    private String _getScreenCode(String moduleCode) {
        screenCode = nextSequence(screenCode, false);
        return moduleCode + "." + screenCode + ".00";
    }

    private String _getActionComp(Class controllerClass, CCButton button) {
        return _getScreenComp(controllerClass) + "." + button.getName();
    }

    private String _getActionCode(String moduleCode) {
        actionCode = nextSequence(actionCode, false);
        return moduleCode + "." + screenCode + "." + actionCode;
    }

    private String _getActionName(AbstractButton abstractButton) {
        return toHumanizeCase(abstractButton.getName().replaceFirst("btn", ""));
    }

    private List<CCButton> _getButton(Container container) {
        List<CCButton> buttons = new ArrayList();
        for (CCField field : getCCFields(container)) {
            if (field.getValue() instanceof CCButton) {
                CCButton cCButton = (CCButton) field.getValue();
                cCButton.setName(field.getFieldName());
                buttons.add(cCButton);
            } else if (field.getValue() instanceof CCTrackable && field.getValue() instanceof Container) {
                buttons.addAll(_getButton((Container) field.getValue()));
            }
        }
        return buttons;
    }

    private boolean _isValidAction(CCButton button) {
        return button.getName().startsWith("btn");
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" register controllerClass to menuBar ">
    private MenuCandidate _addMenuCandidate(Integer parentCode, int code, String label, String icon, Class<? extends CFSwingCtrl> controllerClass) {
        MenuCandidate menuCandidate = new MenuCandidate(parentCode, code, label, icon, controllerClass);
        if (leftSide) {
            leftSideMenus.put(code, menuCandidate);
        } else {
            rightSideMenus.put(code, menuCandidate);
        }
        return menuCandidate;
    }

    private void _addMenu(final MenuCandidate menuCandidate) {
        if (accessibles.get(menuCandidate)) {
            menuBar.addMenu(menuCandidate.getParentCode(), menuCandidate.getCode(),
                    menuCandidate.getLabel(), menuCandidate.getIcon(),
                    isNull(menuCandidate.getControllerClass()) ? null
                    : new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    ((CFSwingCtrl) newObject(menuCandidate.getControllerClass())).init();
                }
            });
        }
    }
//</editor-fold>
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" public method ">
//<editor-fold defaultstate="collapsed" desc=" register controllerClass to create privilege ">
    public void reg(String moduleCode, String screenName, Class controllerClass) {
        Class containerClass = getViewForm(controllerClass);
        if (instanceOf(Container.class, containerClass)) {
            UtilPrivilege screen = new UtilPrivilege(_getScreenComp(controllerClass), _getScreenCode(moduleCode), screenName);
            for (CCButton button : _getButton((Container) newObject(containerClass))) {
                if (_isValidAction(button)) {
                    UtilPrivilege action = new UtilPrivilege(_getActionComp(controllerClass, button), _getActionCode(moduleCode), _getActionName(button));
                    screen.addChilds(action);
                }
            }
            privileges.add(screen);
        }
    }

    public boolean compile() {
        return new UtilInitInitialDataBo().initFirstData(privileges);
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" register controllerClass to menuBar ">
    public void initMenuBar(CCMenuBar menuBar) {
        this.menuBar = menuBar;
        menuBar.clearMenu();
        menuRoot.clear();
        pc = 1;
        cc = 1;
        leftSide = true;
        leftSideMenus.clear();
        rightSideMenus.clear();
        accessibles.clear();
    }

    public void addMenuRoot(Class<? extends CFSwingCtrl>... controllerClasses) {
        menuRoot.addAll(Arrays.asList(controllerClasses));
    }

    public void addMenu(Integer parentCode, int code, String label, String icon, Class<? extends CFSwingCtrl> controllerClass) {
        if (isNull(parentCode)) {
            boolean isAccessible = false;
            if (isNotNull(controllerClass)) {
                if (!(isAccessible = menuRoot.contains(controllerClass) || isAccessible(controllerClass))) {
                    return;
                }
            }
            MenuCandidate menuCandidate = _addMenuCandidate(parentCode, code, label, icon, controllerClass);
            accessibles.put(menuCandidate, isAccessible);
        } else {
            MenuCandidate parent = (leftSide ? leftSideMenus.get(parentCode) : rightSideMenus.get(parentCode));
            if (isNotNull(controllerClass)) {
                boolean isAccessible = menuRoot.contains(controllerClass) || isAccessible(controllerClass);
                if (!isAccessible) {
                    return;
                }
                MenuCandidate menuCandidate = _addMenuCandidate(parentCode, code, label, icon, controllerClass);
                accessibles.put(menuCandidate, isAccessible);
                accessibles.put(parent, accessibles.get(parent) || isAccessible);
            }
        }
    }

    public void addMenuParent(String label, String icon, Class<? extends CFSwingCtrl> controllerClass) {
        addMenu(null, pc = cc++, label, icon, controllerClass);
    }

    public void addMenuChild(String label, String icon, Class<? extends CFSwingCtrl> controllerClass) {
        addMenu(pc, cc++, label, icon, controllerClass);
    }

    public void changeMenuSide() {
        leftSide = !leftSide;
    }

    public void compileMenu() {
        for (MenuCandidate menuCandidate : leftSideMenus.values()) {
            _addMenu(menuCandidate);
        }
        menuBar.addMenuGap();
        for (MenuCandidate menuCandidate : rightSideMenus.values()) {
            _addMenu(menuCandidate);
        }
        menuBar.validate();
    }
//</editor-fold>

    public boolean isAccessible(Class controllerClass) {
        return INSTANCE_isCompAccessible(_getScreenComp(controllerClass));
    }

    public boolean isAccessible(Class controllerClass, Container container) {
        boolean isAccessible = isAccessible(controllerClass);
        if (isAccessible) {
            for (CCButton button : _getButton(container)) {
                if (_isValidAction(button)) {
                    if (!INSTANCE_isCompAccessible(_getActionComp(controllerClass, button))) {
                        button.addAccessibleListener(nonAccessible);
                        button.updateUI();
                    }
                }
            }
        }
        return isAccessible;
    }
//</editor-fold>
}