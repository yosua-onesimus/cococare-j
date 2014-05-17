package model.obj.lib;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import static cococare.common.CCLogic.isNull;
import cococare.common.jasperreports.CCJasper;
import static cococare.datafile.CCFile.getFileSystRepoPath;
import cococare.datafile.CCSetup;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class LibReport extends CCJasper {

//<editor-fold defaultstate="collapsed" desc=" enum Report ">
    private enum Report {

        BOOK_LIST("Book List", "LibBook.jasper", "RptHeader.jasper"),
        MEMBER_LIST("Member List", "LibMember.jasper"),
        BOOK_HISTORY("Book History", "LibBookHistory.jasper"),
        MEMBER_HISTORY("Member History", "LibMemberHistory.jasper");
        private String string;
        private String jasperFile;
        private String[] reqJasperFiles;

        private Report(String string, String jasperFile, String... reqJasperFiles) {
            this.string = string;
            this.jasperFile = jasperFile;
            this.reqJasperFiles = reqJasperFiles;
        }

        @Override
        public String toString() {
            return string;
        }

        private String getJasperFile() {
            return jasperFile;
        }

        private String[] getReqJasperFiles() {
            return reqJasperFiles;
        }
    }
//</editor-fold>
    //
    @CCFieldConfig(componentId = "cmbReport", accessible = Accessible.MANDATORY, optionSource = "model.obj.lib.LibReport$Report", requestFocus = true)
    private Integer reportIndex = 0;
    @CCFieldConfig(componentId = "bndBook", accessible = Accessible.MANDATORY, maxLength = 32, uniqueKey = "title")
    private LibBook book;
    @CCFieldConfig(componentId = "bndMember", accessible = Accessible.MANDATORY, maxLength = 32, uniqueKey = "fullName")
    private LibMember member;

//<editor-fold defaultstate="collapsed" desc=" public method ">
    public static boolean setupReportFile() {
        CCSetup setup = new CCSetup(LibReport.class);
        setup.setResourcePath("files/system/report/");
        String setupPath = getFileSystRepoPath();
        for (Report report : Report.values()) {
            setup.addSetupMap(report.getJasperFile(), setupPath);
            for (String jasperFile : report.getReqJasperFiles()) {
                setup.addSetupMap(jasperFile, setupPath);
            }
        }
        return setup.execute();
    }

    @Override
    protected void _initDefaultMap() {
        super._initDefaultMap();
        map.put("bookCode", isNull(book) ? "" : book.getCode());
        map.put("bookTitle", isNull(book) ? "" : book.getTitle());
        map.put("bookTypeName", isNull(book) ? "" : book.getBookType().getName());
        map.put("bookAuthorName", isNull(book) ? "" : book.getAuthor().getName());
        map.put("bookPublisherName", isNull(book) ? "" : book.getPublisher().getName());
        map.put("book", isNull(book) ? null : book.getId());
        map.put("memberCode", isNull(member) ? "" : member.getCode());
        map.put("memberFullName", isNull(member) ? "" : member.getFullName());
        map.put("memberPhone", isNull(member) ? "" : member.getPhone());
        map.put("memberKtp", isNull(member) ? "" : member.getKtp());
        map.put("member", isNull(member) ? null : member.getId());
    }

    public CCJasper newReport() {
        return newReport(Report.values()[reportIndex].getJasperFile(), map, null);
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public Integer getReportIndex() {
        return reportIndex;
    }

    public String getReportName() {
        return Report.values()[reportIndex].toString();
    }

    public void setReportIndex(Integer reportIndex) {
        this.reportIndex = reportIndex;
    }

    public LibBook getBook() {
        return book;
    }

    public void setBook(LibBook book) {
        this.book = book;
    }

    public LibMember getMember() {
        return member;
    }

    public void setMember(LibMember member) {
        this.member = member;
    }
//</editor-fold>
}