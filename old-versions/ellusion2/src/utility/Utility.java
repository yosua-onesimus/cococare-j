package utility;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * @author Yosua Onesimus
 */
public class Utility {

// <editor-fold defaultstate="collapsed" desc=" common ">
    /**
     * logLogger(Class c, Level level, Exception exception)
     *
     * @param c
     * @param level
     * @param exception
     */
    public static void logLogger(Class c, Level level, Exception exception) {
        Logger.getLogger(c.getName()).log(level, exception.getMessage(), exception);
    }

    /**
     * setNimbusLookAndFeel()
     */
    public static void setNimbusLookAndFeel() {
        try {
            javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException classNotFoundException) {
            logLogger(Utility.class, Level.SEVERE, classNotFoundException);
        } catch (InstantiationException instantiationException) {
            logLogger(Utility.class, Level.SEVERE, instantiationException);
        } catch (IllegalAccessException illegalAccessException) {
            logLogger(Utility.class, Level.SEVERE, illegalAccessException);
        } catch (UnsupportedLookAndFeelException unsupportedLookAndFeelException) {
            logLogger(Utility.class, Level.SEVERE, unsupportedLookAndFeelException);
        }
    }

    /**
     * doCenterScreen(JFrame jFrame)
     *
     * @param jFrame
     */
    public static void doCenterScreen(JFrame jFrame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = jFrame.getSize();
        jFrame.setLocation(
                (screenSize.width - frameSize.width) / 2,
                (screenSize.height - frameSize.height) / 2);
    }

    /**
     * showInformation(Object message)
     *
     * @param message
     */
    public static void showInformation(Object message) {
        JOptionPane.showMessageDialog(null, message);
    }

    /**
     * exec(String[] arrayCommand)
     *
     * @param arrayCommand
     */
    public static Process exec(String[] arrayCommand) {
        try {
            return Runtime.getRuntime().exec(arrayCommand);
        } catch (IOException iOException) {
            return null;
        }
    }

    /**
     * goToUrl(String url)
     *
     * @param url
     */
    public static void goToUrl(String url) {
        String browserPath = "C:/Program Files/Mozilla Firefox/firefox.exe";
        if (!new File(browserPath).exists()) {
            browserPath = "C:/Program Files/Internet Explorer/IEXPLORE.EXE";
        }
        exec(new String[]{browserPath, url});
    }
// </editor-fold>
    private static Integer[][] aryBilangan = new Integer[][]{
        {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}
    };

    /**
     * getSimpleDateFormat(String pattern)
     *
     * @param pattern
     * @return
     */
    private static SimpleDateFormat getSimpleDateFormat(String pattern) {
        try {
            return new SimpleDateFormat(pattern);
        } catch (Exception exception) {
            return null;
        }
    }

    /**
     * getString(Date date, String pattern)
     *
     * @param date
     * @param pattern
     * @return the formatted time string
     */
    public static String getString(Date date, String pattern) {
        try {
            return getSimpleDateFormat(pattern).format(date);
        } catch (Exception exception) {
            return null;
        }
    }

    /**
     * getDate(String string, String pattern)
     *
     * @param string
     * @param pattern
     * @return A Date parsed from the string
     */
    public static Date getDate(String string, String pattern) {
        try {
            return getSimpleDateFormat(pattern).parse(string);
        } catch (Exception exception) {
            return null;
        }
    }
    public static Date TODAY = new Date();

    /**
     * getTodayMatrix()
     *
     * @return
     */
    public static Integer[][] getTodayMatrix() {
        Integer[][] aryToday = new Integer[4][4];
        TODAY = new Date();
        int month = Integer.parseInt(getString(TODAY, "MM"));
        int day = Integer.parseInt(getString(TODAY, "dd"));
        int mdTotal = (month * 100) + day - 34;
        int mdMod = mdTotal % 4;
        int mdTotal_4 = (mdTotal / 4);
        for (int index1 = 3; index1 >= 0; index1--) {
            for (int index2 = 0; index2 < 4; index2++) {
                aryToday[index1][index2] = aryBilangan[index1][index2] + (mdTotal_4);
                if (mdMod > 0) {
                    aryToday[index1][index2] += 1;
                }
            }
            if (mdMod > 0) {
                mdMod--;
            }
        }
        return aryToday;
    }

    /**
     * isNewItem(int[] aryObject, Object object)
     *
     * @param aryObject
     * @param object
     * @return
     */
    private static boolean isNewItem(int[] aryObject, Object object) {
        for (Object object1 : aryObject) {
            if (object1.equals(object)) {
                return false;
            }
        }
        return true;
    }

    /**
     * verticalShuffle(Object[][] aryObject)
     *
     * @param aryObject
     * @return
     */
    public static Object[][] verticalShuffle(Object[][] aryObject) {
        //
        int size = aryObject.length;
        int[] newIndex = new int[size];
        for (int index = 0; index < size; index++) {
            newIndex[index] = size;
        }
        //
        int newSize = 0;
        Random random = new Random();
        while (newSize < size) {
            int i = random.nextInt(size);
            if (isNewItem(newIndex, i)) {
                newIndex[newSize] = i;
                newSize++;
            }
        }
        //
        Object[][] aryObject2 = new Object[size][size];
        for (int index1 = 0; index1 < size; index1++) {
            for (int index2 = 0; index2 < size; index2++) {
                aryObject2[index1][index2] = aryObject[index1][newIndex[index2]];
            }
        }
        return aryObject2;
    }

    /**
     * horizontalShuffle(Object[][] aryObject)
     *
     * @param aryObject
     * @return
     */
    public static Object[][] horizontalShuffle(Object[][] aryObject) {
        //
        int size = aryObject.length;
        int[] newIndex = new int[size];
        for (int index = 0; index < size; index++) {
            newIndex[index] = size;
        }
        //
        int newSize = 0;
        Random random = new Random();
        while (newSize < size) {
            int i = random.nextInt(size);
            if (isNewItem(newIndex, i)) {
                newIndex[newSize] = i;
                newSize++;
            }
        }
        //
        Object[][] aryObject2 = new Object[size][size];
        for (int index1 = 0; index1 < size; index1++) {
            for (int index2 = 0; index2 < size; index2++) {
                aryObject2[index1][index2] = aryObject[newIndex[index1]][index2];
            }
        }
        return aryObject2;
    }
}