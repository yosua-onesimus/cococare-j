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

    private static final Pattern PATTERN = Pattern.compile("---([^\\[\\]]+)(\\[(.+)\\])*");

    private static void txtToXls(String fileName) {
        File input = CCFile.getFileSystArchFile(fileName + ".TXT");
        File output = CCFile.getFileSystArchFile(fileName + ".XLS");
        if (input.exists()) {
            if (output.exists()) {
                CCFile.delete(output);
            }
            CCExcel excel = new CCExcel();
            excel.newWorkbook();
            excel.newSheet("MYVID");
            for (String string : CCFile.readList(input)) {
                Matcher matcher = PATTERN.matcher(string);
                if (matcher.find()) {
                    if (CCLogic.isNotNullAndNotEmpty(matcher.group(1))) {
                        excel.writeRow(0, excel.getRowCount(), CCFormat.trimAll(matcher.group(1)), CCFormat.trimAll(matcher.group(3)));
                    }
                }
            }
            excel.saveAndCloseWorkbook(output);
        }
    }

    public static void main(String[] args) {
        txtToXls("MYVID3");
        txtToXls("MYVID4");
    }
}