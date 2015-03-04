package cococare.framework.swing.controller.form.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCClass.getCCTypeConfig;
import static cococare.common.CCClass.newObject;
import cococare.common.CCCustomField;
import static cococare.common.CCLogic.isNullOrEmpty;
import static cococare.common.CCMessage.logp;
import cococare.common.CCTypeConfig;
import cococare.framework.model.bo.util.UtilConfigBo;
import cococare.framework.model.obj.util.UtilConfAppl;
import cococare.framework.model.obj.util.UtilScheduler;
import cococare.framework.swing.CFSwingCtrl;
import static cococare.swing.CCSwing.addListener;
import cococare.swing.component.CCLink;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
//</editor-fold>

public class PnlApplicationSettingListCtrl extends CFSwingCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private UtilConfigBo configBo;
    private List<Class> settingClasses;
    private HashMap<CCTypeConfig, Class> typeConfig_settingClass;
//</editor-fold>

    @Override
    protected Class _getEntity() {
        return CCTypeConfig.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.LIST_FUNCTION;
    }

    @Override
    protected void _initObject() {
        super._initObject();
        settingClasses = new ArrayList();
        settingClasses.add(UtilConfAppl.class);
        settingClasses.addAll(configBo.loadConfAppl().getUtilAdditionalSettingClass());
        settingClasses.add(UtilScheduler.class);
        typeConfig_settingClass = new LinkedHashMap();
        for (Class settingClass : settingClasses) {
            typeConfig_settingClass.put(getCCTypeConfig(settingClass), settingClass);
        }
    }

    @Override
    protected void _initTable() {
        super._initTable();
        tblEntity.initFields();
        tblEntity.addField(0, new CCCustomField() {
            @Override
            public String getLabel() {
                return "Module Name";
            }

            @Override
            public Integer getColumnWidth() {
                return 200;
            }

            @Override
            public Object getCustomView(Object object) {
                try {
                    final CCTypeConfig typeConfig = (CCTypeConfig) object;
                    CCLink link = new CCLink(typeConfig.label());
                    addListener(link, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent actionEvent) {
                            tblEntity.getStopCellEditingListener().actionPerformed(actionEvent);
                            _doEdit(typeConfig);
                        }
                    });
                    return link;
                } catch (NullPointerException nullPointerException) {
                    logp(nullPointerException);
                    return null;
                }
            }
        });
        tblEntity.addField(1, new CCCustomField() {
            @Override
            public String getLabel() {
                return "Description";
            }

            @Override
            public Object getCustomView(Object object) {
                return ((CCTypeConfig) object).tooltiptext();
            }
        });
        tblEntity.getTable().setRowHeight(29);
        tblEntity.setEditableColumn(true, 0);
    }

    @Override
    public void doUpdateTable() {
        tblEntity.removeItems();
        for (CCTypeConfig typeConfig : typeConfig_settingClass.keySet()) {
            tblEntity.addItem(typeConfig);
        }
    }

    private void _doEdit(CCTypeConfig typeConfig) {
        String controllerClass = typeConfig.controllerClass();
        objEntity = configBo.loadHash(typeConfig_settingClass.get(typeConfig));
        if (isNullOrEmpty(controllerClass)) {
            _doShowEditor(false, objEntity);
        } else {
            try {
                ((CFSwingCtrl) newObject(controllerClass)).with(parameter).with(this).with(readonly).init(objEntity);
            } catch (NullPointerException nullPointerException) {
                logp(nullPointerException);
            }
        }
    }
}