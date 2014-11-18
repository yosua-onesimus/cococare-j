package a.simple.sample;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static a.simple.sample.No0_Static.newMember;
import cococare.common.CCFinal;
import cococare.common.CCFormat;
import cococare.common.CCHighcharts;
import cococare.common.CCHighcharts.Serial;
import cococare.common.CCMath;
import cococare.common.barbecue.CCBarcode;
import cococare.common.comm.CCComm;
import cococare.datafile.CCDom;
import cococare.datafile.CCProperties;
import cococare.datafile.jxl.CCExcel;
import java.io.File;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import model.obj.lib.LibMember;
import net.sourceforge.barbecue.Barcode;
import org.w3c.dom.Node;
//</editor-fold>

public class NoX_SimpleAndCleanCode {

//<editor-fold defaultstate="collapsed" desc=" BangunDatar ">
    private static class BangunDatar {

        private String luasPersegi = "L=s*s";
        private String luasPersegiPanjang = "L=p*l";
        private String luasSegitiga = "L=a*t/2";
        private String luasJajarGenjang = "L=a*t";
        private String luasTrapesium = "L=(s1+s2)*t/2";
        private double s = 4;
        private double p = 8;
        private double l = 6;
        private double a = 8;
        private double t = 6;
        private double s1 = 4;
        private double s2 = 8;
        private double L;
    }
//</editor-fold>
    //
//<editor-fold defaultstate="collapsed" desc=" private object ">
    private static String string1 = "yOSUA  oNESIMUS  sUHERU";
    private static Double double1 = 1234567.89D;
    private static Float float1 = 0.1234F;
    private static Date date1 = CCFormat.getDate("17/03/2012", CCFinal.FORMAT_DATE);
    private static Time time1 = CCFormat.getTime("12:34:56", CCFinal.FORMAT_TIME);
    private static BangunDatar bangunDatar = new BangunDatar();
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" sampleFormat ">
//<editor-fold defaultstate="collapsed" desc=" sampleStringOperation ">
    public static void sampleFormat_sampleStringOperation() {
        System.out.println(CCFormat.trimAll(string1));
        System.out.println(CCFormat.toSentenceCase(string1));
        System.out.println(CCFormat.toTitleCase(string1));
        System.out.println(CCFormat.pack(string1, "_", 2 * string1.length()));
        System.out.println(CCFormat.pack(string1, "_", -2 * string1.length()));
        System.out.println(CCFormat.maxLength(string1, string1.length() / 2));
        System.out.println(CCFormat.maxLength(string1, string1.length() / -2));
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" sampleNumberFormat ">
    public static void sampleFormat_sampleNumberFormat() {
        System.out.println(CCFormat.formatCurrency(double1));
        System.out.println(CCFormat.formatInteger(double1));
        System.out.println(CCFormat.formatNumber(double1));
        System.out.println(CCFormat.formatPercent(float1));
        System.out.println(CCFormat.formatDecimal(double1));
        System.out.println(CCFormat.formatNumeric(double1));
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" sampleStringConversion ">
    public static void sampleFormat_sampleStringConversion() {
        System.out.println(CCFormat.getString(double1));
        System.out.println(CCFormat.getString(float1));
        System.out.println(CCFormat.getString(date1));
        System.out.println(CCFormat.getString(time1));
        System.out.println(CCFormat.getString4View(double1));
        System.out.println(CCFormat.getString4View(float1));
        System.out.println(CCFormat.getString4View(date1));
        System.out.println(CCFormat.getString4View(time1));
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" sampleTerbilang ">
    public static void sampleFormat_sampleTerbilang() {
        for (double d = double1 - 3; d < double1 + 3; d++) {
            System.out.println(CCFormat.terbilang(d));
        }
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" sampleSpellOut ">
    public static void sampleFormat_sampleSpellOut() {
        for (double d = double1 - 3; d < double1 + 3; d++) {
            System.out.println(CCFormat.spellOut(d));
        }
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" sampleRomanNumerals ">
    public static void sampleFormat_sampleRomanNumerals() {
        for (int i = 97; i < 103; i++) {
            System.out.println(CCFormat.roman(i));
        }
    }
//</editor-fold>
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" sampleHighcharts ">
    public static void sampleHighcharts() {
        CCHighcharts highcharts = new CCHighcharts();
        highcharts.getChart().setRenderTo("container");
        String[] categories = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        highcharts.getxAxis().getCategories().addAll(Arrays.asList(categories));
        Serial serial = highcharts.newSerial();
        Double[] data = new Double[]{29.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4};
        serial.getData().addAll(Arrays.asList(data));
        highcharts.getSeries().add(serial);
        System.out.println(highcharts.compile());
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" sampleMath ">
    public static void sampleMath() {
        System.out.println(CCMath.calculate("((9+8-7)*6/5)^4"));
        System.out.println(CCMath.calculate("((9+x-7)*y/5)^z", "x=8;y=6;z=4;"));
        System.out.println(((BangunDatar) CCMath.manipulate(bangunDatar, bangunDatar.luasPersegi)).L);
        System.out.println(((BangunDatar) CCMath.manipulate(bangunDatar, bangunDatar.luasPersegiPanjang)).L);
        System.out.println(((BangunDatar) CCMath.manipulate(bangunDatar, bangunDatar.luasSegitiga)).L);
        System.out.println(((BangunDatar) CCMath.manipulate(bangunDatar, bangunDatar.luasJajarGenjang)).L);
        System.out.println(((BangunDatar) CCMath.manipulate(bangunDatar, bangunDatar.luasTrapesium)).L);
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" sampleBarcode ">
    public static void sampleBarcode() {
        Barcode barcode = CCBarcode.newCode128("Yosua Onesimus");
        CCBarcode.saveJPEG(barcode, new File("D:\\barcode.jpeg"));
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" sampleComm ">
    public static void sampleComm() {
        System.out.println("Paralel Ports: ");
        for (String paralelPort : CCComm.getParalelPorts()) {
            System.out.println(paralelPort);
        }
        System.out.println("\nSerial Ports: ");
        for (String serialPort : CCComm.getSerialPorts()) {
            System.out.println(serialPort);
        }
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" sampleXml ">
    public static void sampleXml() {
        CCDom dom = new CCDom();
        dom.newRoot("root");

        Node attributeBase = dom.appendChildNode(dom.getRoot(), "attributeBase");
        Node employee = dom.appendChildNode(attributeBase, "employee");
        dom.setAttribute(employee, "firstName", "Yosua");
        dom.setAttribute(employee, "lastName", "Onesimus");

        Node elementBase = dom.appendChildNode(dom.getRoot(), "elementBase");
        employee = dom.appendChildNode(elementBase, "employee");
        Node firstName = dom.appendChildNode(employee, "firstName");
        dom.appendChildTextNode(firstName, "Sari");
        Node lastName = dom.appendChildNode(employee, "lastName");
        dom.appendChildTextNode(lastName, "Heriati");

        dom.transform(new File("D:\\employee.xml"));

        CCDom dom2 = new CCDom();
        dom2.read(new File("D:\\employee.xml"));

        attributeBase = dom2.getNodeByTagName(dom2.getRoot(), "attributeBase");
        employee = dom2.getNodeByTagName(attributeBase, "employee");
        System.out.println(dom2.getAttribute(employee, "firstName"));
        System.out.println(dom2.getAttribute(employee, "lastName"));

        elementBase = dom2.getNodeByTagName(dom2.getRoot(), "elementBase");
        employee = dom2.getNodeByTagName(elementBase, "employee");
        System.out.println(dom2.getNodeValue(employee, "firstName"));
        System.out.println(dom2.getNodeValue(employee, "lastName"));
    }

    public static void sampleXml2() {
        CCDom dom = new CCDom();

        List<LibMember> members = new ArrayList();
        members.add(newMember("M001", "Yosua Onesimus", "06/06/1984"));
        members.add(newMember("M002", "Sari Heriati", "17/03/1984"));
        members.add(newMember("M003", "Delvin Acelin", "02/09/2014"));
        dom.writeEntity("root", members);

        dom.transform(new File("D:\\members.xml"));

        CCDom dom2 = new CCDom();
        dom2.read(new File("D:\\members.xml"));

        members = dom2.readEntity(LibMember.class);
        for (LibMember member : members) {
            System.out.println("Member: Code:" + member.getCode() + "; Full Name:" + member.getFullName() + "; Birth Date:" + CCFormat.getString(member.getBirthDate()) + "; ");
        }
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" sampleProperties ">
    public static void sampleProperties() {
        CCProperties properties = new CCProperties();
        properties.setValue(bangunDatar, false);
        properties.storeExtern(new File("D:\\bangunDatar.prop"));
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" sampleExcel ">
    public static void sampleExcel() {
        CCExcel excel = new CCExcel();
        excel.newWorkbook();
        excel.newSheet("common");
        excel.writeColumn(1, 2, "6", "11", "16");
        excel.writeColumn(5, 2, "10", "15", "20");
        excel.writeRow(1, 1, "1", "2", "3", "4", "5");
        excel.writeRow(1, 5, "21", "22", "23", "24", "25");
        excel.writeCell(2, 2, "x");
        excel.writeCell(3, 3, "y");
        excel.writeCell(4, 4, "z");
        excel.newSheet("row");
        excel.initEntity(BangunDatar.class, true);
        excel.writeRowEntityHeader();
        excel.writeRowEntity(bangunDatar);
        excel.newSheet("column");
        excel.initEntity(BangunDatar.class, true);
        excel.writeColumnEntityHeader();
        excel.writeColumnEntity(bangunDatar);
        excel.saveAndCloseWorkbook(new File("D:\\bangunDatar.xls"));
    }
//</editor-fold>

    public static void main(String[] args) {
        sampleXml();
    }
}