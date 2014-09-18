package cococare.framework.common;

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public abstract class CFApplUae {

//<editor-fold defaultstate="collapsed" desc=" public method ">
    public abstract void reg(String moduleCode, String screenName, Class<? extends CFViewCtrl> controllerClass);

    public abstract boolean compile();

    public abstract void addMenuRoot(Class<? extends CFViewCtrl>... controllerClasses);

    public abstract void addMenuParent(String label, String icon, Class<? extends CFViewCtrl> controllerClass);

    public abstract void addMenuChild(String label, String icon, Class<? extends CFViewCtrl> controllerClass);

    public abstract void addMenuSeparator();

    public abstract void changeMenuSide();

    public abstract void compileMenu();
//</editor-fold>
}