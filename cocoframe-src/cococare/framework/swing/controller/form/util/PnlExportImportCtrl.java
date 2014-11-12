package cococare.framework.swing.controller.form.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCAccessibleListener;
import static cococare.common.CCClass.getLabel;
import static cococare.common.CCLogic.*;
import static cococare.common.CCMessage.showExport;
import static cococare.common.CCMessage.showImport;
import cococare.database.CCEntityBo;
import cococare.database.CCEntityModule;
import static cococare.datafile.CCFile.*;
import cococare.datafile.jxl.CCExcel;
import cococare.framework.swing.CFSwingCtrl;
import static cococare.swing.CCSwing.addListener;
import static cococare.swing.CCSwing.applyAccessible;
import cococare.swing.component.CCButton;
import cococare.swing.component.CCOptionBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlExportImportCtrl extends CFSwingCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private CCButton btnTemplate;
    private CCButton btnImport;
    private CCOptionBox optParameter;
//</editor-fold>

    @Override
    protected Class _getEntity() {
        return null;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.FORM_FUNCTION;
    }

    @Override
    protected void _initComponent() {
        super._initComponent();
        for (Class clazz : CCEntityModule.INSTANCE.getCCHibernate().getParameterClasses()) {
            optParameter.addItem(getLabel(clazz));
        }
    }

    @Override
    protected void _initAccessible() {
        super._initAccessible();
        CCAccessibleListener isSelected = new CCAccessibleListener() {
            @Override
            public boolean isAccessible() {
                return optParameter.isSelected();
            }
        };
        swingView.getBtnExport().addAccessibleListener(isSelected);
        btnTemplate.addAccessibleListener(isSelected);
        btnImport.addAccessibleListener(isSelected);
    }

    @Override
    protected void _doUpdateAccessible() {
        super._doUpdateAccessible();
        applyAccessible(swingView.getBtnExport(), btnTemplate, btnImport);
    }

    @Override
    protected void _initListener() {
        super._initListener();
        addListener(swingView.getBtnExport(), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                _doExport(true);
            }
        });
        addListener(btnTemplate, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                _doExport(false);
            }
        });
        addListener(btnImport, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                _doImport();
            }
        });
        optParameter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                _doUpdateAccessible();
            }
        });
    }

    private void _doExport(boolean withData) {
        if (isSureExport()) {
            File file;
            if (isNotNull(file = showSaveDialog("xls"))) {
                CCExcel excel = new CCExcel();
                excel.newWorkbook();
                for (int index : optParameter.getSelectedIndexes()) {
                    Class clazz = CCEntityModule.INSTANCE.getCCHibernate().getParameterClasses().get(index);
                    excel.newSheet(clazz.getSimpleName());
                    excel.initEntity(clazz, false);
                    excel.writeRowEntityHeader();
                    if (withData) {
                        excel.writeRowEntity(CCEntityBo.INSTANCE.getListBy(clazz, null, null, null, 0, null));
                    }
                }
                showExport(updateCaller = excel.saveAndCloseWorkbook(file));
                if (updateCaller) {
                    open(file);
                }
            }
        }
    }

    private void _doImport() {
        if (isSureImport()) {
            File file;
            if (isNotNull(file = showOpenDialog("xls"))) {
                CCExcel excel = new CCExcel();
                excel.openWorkbook(file);
                for (int index : optParameter.getSelectedIndexes()) {
                    Class clazz = CCEntityModule.INSTANCE.getCCHibernate().getParameterClasses().get(index);
                    if (isNotNull(excel.getSheet(clazz.getSimpleName()))) {
                        excel.initEntity(clazz, false);
                        if (!(updateCaller = CCEntityModule.INSTANCE.getCCHibernate().restore(excel.readRowEntity(1, excel.getRowCount() - 1)))) {
                            break;
                        }
                    }
                }
                showImport(updateCaller);
            }
        }
    }
}