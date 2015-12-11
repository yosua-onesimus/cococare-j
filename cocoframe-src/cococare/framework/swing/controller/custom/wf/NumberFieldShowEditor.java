package cococare.framework.swing.controller.custom.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCClass;
import static cococare.common.CCClass.getMethod;
import static cococare.common.CCClass.invoke;
import cococare.common.CCCustomField;
import static cococare.common.CCFormat.getBoolean;
import static cococare.common.CCFormat.getString;
import cococare.framework.common.CFViewCtrl;
import static cococare.swing.CCSwing.addListener;
import cococare.swing.CCTable;
import cococare.swing.component.CCLink;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//</editor-fold>

public class NumberFieldShowEditor extends CCCustomField {

//<editor-fold defaultstate="collapsed" desc=" private ">
    private CFViewCtrl viewCtrl;
    private CCTable tblEntity;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" NumberFieldShowEditor ">
    public NumberFieldShowEditor(CFViewCtrl viewCtrl, CCTable tblEntity) {
        this.viewCtrl = viewCtrl;
        this.tblEntity = tblEntity;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" getter ">
    @Override
    public String getLabel() {
        return "Number";
    }

    @Override
    public Object getCustomView(final Object object) {
        CCLink link = new CCLink(getString(CCClass.getValue(object, "number")));
        addListener(link, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                tblEntity.getStopCellEditingListener().actionPerformed(actionEvent);
                boolean readonly = getBoolean(CCClass.getValue(viewCtrl, "readonly"));
                invoke(getMethod(viewCtrl.getClass(), "_doShowEditor", boolean.class, Object.class), viewCtrl, readonly, object);
            }
        });
        return link;
    }

    @Override
    public Integer getColumnWidth() {
        return 150;
    }
//</editor-fold>
}