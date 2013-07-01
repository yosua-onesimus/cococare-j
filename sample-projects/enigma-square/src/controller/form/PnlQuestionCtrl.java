package controller.form;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.swing.CFSwingCtrl;
import model.mdl.EnigmaSquareMain;
import model.obj.Question;
//</editor-fold>

public class PnlQuestionCtrl extends CFSwingCtrl {

    @Override
    protected Class _getEntity() {
        return Question.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.FORM_FUNCTION;
    }

    @Override
    protected boolean _doSaveEntity() {
        return EnigmaSquareMain.questions.contains((Question) objEntity)
                ? true
                : EnigmaSquareMain.questions.add((Question) objEntity);
    }
}