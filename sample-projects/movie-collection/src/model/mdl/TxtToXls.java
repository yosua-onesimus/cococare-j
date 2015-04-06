package model.mdl;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFormat;
import cococare.common.CCLogic;
import cococare.datafile.CCFile;
import cococare.datafile.jxl.CCExcel;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//</editor-fold>

public class TxtToXls {

    private static final String regex = "---([^\\[\\]]+)(\\[(.+)\\])*";
    private static final String txtFileName = "MYVID4.TXT";
    private static final String xlsFileName = "MYVID4.XLS";

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile(regex);
        File input = CCFile.getFileSystArchFile(txtFileName);
        File output = CCFile.getFileSystArchFile(xlsFileName);
        CCExcel excel = new CCExcel();
        excel.newWorkbook();
        excel.newSheet("MYVID");
        for (String string : CCFile.readList(input)) {
            Matcher matcher = pattern.matcher(string);
            if (matcher.find()) {
                if (CCLogic.isNotNullAndNotEmpty(matcher.group(1))) {
                    excel.writeRow(0, excel.getRowCount(), CCFormat.trimAll(matcher.group(1)), CCFormat.trimAll(matcher.group(3)));
                }
            }
        }
        excel.saveAndCloseWorkbook(output);
    }
}