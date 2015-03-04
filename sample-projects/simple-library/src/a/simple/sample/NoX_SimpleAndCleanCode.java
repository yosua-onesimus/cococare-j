package a.simple.sample;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static a.simple.sample.No0_Static.newMember;
import cococare.common.CCFinal;
import cococare.common.CCFormat;
import cococare.common.CCHighcharts;
import cococare.common.CCHighcharts.ChartType;
import cococare.common.CCHighcharts.Serial;
import cococare.common.CCHighcharts.Step;
import cococare.common.CCMath;
import cococare.common.barbecue.CCBarcode;
import cococare.common.comm.CCComm;
import cococare.common.mail.CCMail;
import cococare.common.mail.CCMail.MailServer;
import cococare.common.quartz.CCJob;
import cococare.common.quartz.CCQuartz;
import cococare.database.CCDatabaseConfig.SupportedDatabase;
import cococare.database.*;
import cococare.datafile.CCDataFile;
import cococare.datafile.CCDom;
import cococare.datafile.CCProperties;
import cococare.datafile.jxl.CCExcel;
import java.io.File;
import java.sql.Time;
import java.util.*;
import model.obj.lib.LibMember;
import net.sourceforge.barbecue.Barcode;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
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

//<editor-fold defaultstate="collapsed" desc=" SimpleJob ">
    public static class SimpleJob extends CCJob {

        @Override
        public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
            System.out.println(
                    CCFormat.getString(new Date(), CCFinal.FORMAT_DATE_TIME)
                    + " "
                    + getValue(jobExecutionContext, "employee.firstName")
                    + " "
                    + getValue(jobExecutionContext, "employee.lastName"));
        }
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

    public static void sampleHighcharts2() {
        CCHighcharts highcharts = new CCHighcharts();
        highcharts.getChart().setRenderTo("container");
        highcharts.getChart().setType(ChartType.funnel);
        highcharts.getChart().setMarginRight(100);
        highcharts.getPlotOptions().getSeries().setShowInLegend(false);
        Serial serial = highcharts.newSerial();
        serial.setName("Unique users");
        serial.getDataLabels().setFormat("<b>{point.name}</b> ({point.y:,.0f})");
        serial.getData().add(highcharts.newList("Website visits", 15654));
        serial.getData().add(highcharts.newList("Downloads", 4064));
        serial.getData().add(highcharts.newList("Requested price list", 1987));
        serial.getData().add(highcharts.newList("Invoice sent", 976));
        serial.getData().add(highcharts.newList("Finalized", 846));
        highcharts.getSeries().add(serial);
        System.out.println(highcharts.compile());
    }

    public static void sampleHighcharts3() {
        CCHighcharts highcharts = new CCHighcharts();
        highcharts.getChart().setRenderTo("container");
        highcharts.getChart().setType(ChartType.line);
        String[] categories = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        highcharts.getxAxis().getCategories().addAll(Arrays.asList(categories));
        Serial serial = highcharts.newSerial();
        serial.setName("Right");
        serial.setStep(Step.right);
        Double[] data = new Double[]{1d, 2d, 3d, 4d, null, 6d, 7d, null, 9d};
        serial.getData().addAll(Arrays.asList(data));
        Serial serial2 = highcharts.newSerial();
        serial2.setName("Center");
        serial2.setStep(Step.center);
        Double[] data2 = new Double[]{5d, 6d, 7d, 8d, null, 10d, 11d, null, 13d};
        serial2.getData().addAll(Arrays.asList(data2));
        Serial serial3 = highcharts.newSerial();
        serial3.setName("Left");
        serial3.setStep(Step.left);
        Double[] data3 = new Double[]{9d, 10d, 11d, 12d, null, 14d, 15d, null, 17d};
        serial3.getData().addAll(Arrays.asList(data3));
        highcharts.getSeries().add(serial);
        highcharts.getSeries().add(serial2);
        highcharts.getSeries().add(serial3);
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

//<editor-fold defaultstate="collapsed" desc=" sampleMail ">
    public static void sampleMail() {
        CCMail mail = new CCMail();
        mail.setPropertyMailSmtpHost(null);
        mail.setPropertyTimeout(45000);
        mail.initSession(true);
        mail.setAddressFrom("your.mail@gmail.com");
        MailServer.gmailCom.setUser("your.mail");
        MailServer.gmailCom.setPassword("your.pass");
        if (mail.connect4Send(MailServer.gmailCom)) {
            mail.sendMessage(
                    new String[]{"arrow_405@yahoo.com"}, //to
                    null, //cc
                    null, //bcc
                    "This is a subject from a sample mail",
                    "This is a text from a sample mail",
                    false);
            mail.close4Send();
        }
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" sampleQuartz ">
    public static void sampleQuartz() {
        HashMap<String, Object> parameter = new HashMap();
        parameter.put("employee.firstName", "Yosua");
        parameter.put("employee.lastName", "Onesimus");
        CCQuartz.start(SimpleJob.class, parameter, "0/3 * * * * ?");
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" sampleDatabase ">
    public static void sampleDatabase() {
        CCDatabaseConfig databaseConfig = new CCDatabaseConfig().
                withSupportedDatabase(SupportedDatabase.MySQL).
                withHost("localhost").
                withPort("3306").
                withUsername("root").
                withPassword("1234").
                withDatabase("coco_trial");

        final CCDatabase database = new CCDatabase();
        database.getConnection(databaseConfig, false);

        CCDatabaseDao databaseDao = new CCDatabaseDao() {
            @Override
            protected CCDatabase getCCDatabase() {
                return database;
            }

            @Override
            protected Class<? extends CCEntity> getEntity() {
                return LibMember.class;
            }
        };
        databaseDao.saveOrUpdate(newMember("M001", "Yosua Onesimus", "06/06/1984"));
        databaseDao.saveOrUpdate(newMember("M002", "Sari Heriati", "17/03/1984"));
        databaseDao.saveOrUpdate(newMember("M003", "Delvin Acelin", "02/09/2014"));

        List<LibMember> members = databaseDao.getList();
        for (LibMember member : members) {
            System.out.println("Member: Code:" + member.getCode() + "; Full Name:" + member.getFullName() + "; Birth Date:" + CCFormat.getString(member.getBirthDate()) + "; ");
        }
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" sampleHibernate ">
    public static void sampleHibernate() {
        CCDatabaseConfig databaseConfig = new CCDatabaseConfig().
                withSupportedDatabase(SupportedDatabase.MySQL).
                withHost("localhost").
                withPort("3306").
                withUsername("root").
                withPassword("1234").
                withDatabase("coco_trial");

        final CCHibernate hibernate = new CCHibernate();
        hibernate.addAnnotatedClass(LibMember.class);
        hibernate.addDatabaseConfig(databaseConfig);

        CCHibernateDao hibernateDao = new CCHibernateDao() {
            @Override
            protected CCHibernate getCCHibernate() {
                return hibernate;
            }

            @Override
            protected List<CCHibernateFilter> getFilters() {
                return new ArrayList();
            }

            @Override
            protected Class getEntity() {
                return LibMember.class;
            }
        };
        hibernateDao.saveOrUpdate(newMember("M001", "Yosua Onesimus", "06/06/1984"));
        hibernateDao.saveOrUpdate(newMember("M002", "Sari Heriati", "17/03/1984"));
        hibernateDao.saveOrUpdate(newMember("M003", "Delvin Acelin", "02/09/2014"));

        List<LibMember> members = hibernateDao.getList();
        for (LibMember member : members) {
            System.out.println("Member: Code:" + member.getCode() + "; Full Name:" + member.getFullName() + "; Birth Date:" + CCFormat.getString(member.getBirthDate()) + "; ");
        }
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" sampleDataFile ">
    public static void sampleDatafile() {
        CCDataFile dataFile = new CCDataFile(LibMember.class);
        dataFile.saveOrUpdate(newMember("M001", "Yosua Onesimus", "06/06/1984"));
        dataFile.saveOrUpdate(newMember("M002", "Sari Heriati", "17/03/1984"));
        dataFile.saveOrUpdate(newMember("M003", "Delvin Acelin", "02/09/2014"));

        List<LibMember> members = dataFile.getList(null, null);
        for (LibMember member : members) {
            System.out.println("Member: Code:" + member.getCode() + "; Full Name:" + member.getFullName() + "; Birth Date:" + CCFormat.getString(member.getBirthDate()) + "; ");
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

    public static void sampleExcel2() {
        CCExcel excel = new CCExcel();
        excel.newWorkbook();

        List<LibMember> members = new ArrayList();
        members.add(newMember("M001", "Yosua Onesimus", "06/06/1984"));
        members.add(newMember("M002", "Sari Heriati", "17/03/1984"));
        members.add(newMember("M003", "Delvin Acelin", "02/09/2014"));
        excel.newSheet(LibMember.class.getSimpleName());
        excel.initEntity(LibMember.class, false);
        excel.writeRowEntityHeader();
        excel.writeRowEntity(members);

        excel.saveAndCloseWorkbook(new File("D:\\members.xls"));

        CCExcel excel2 = new CCExcel();
        excel2.openWorkbook(new File("D:\\members.xls"));

        excel2.getSheet(LibMember.class.getSimpleName());
        excel2.initEntity(LibMember.class, false);
        members = excel2.readRowEntity(1, excel2.getRowCount() - 1);
        for (LibMember member : members) {
            System.out.println("Member: Code:" + member.getCode() + "; Full Name:" + member.getFullName() + "; Birth Date:" + CCFormat.getString(member.getBirthDate()) + "; ");
        }
    }
//</editor-fold>

    public static void main(String[] args) {
        sampleDatabase();
    }
}