package utility;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
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
    private static String[][] dict = new String[][]{
        {"APE", "HUMAN"},
        {"BED", "SLEEP"},
        {"BEE", "HONEY"},
        {"BET", "WAGER"},
        {"BIG", "SMALL"},
        {"BOA", "SNAKE"},
        {"BOW", "ARROW"},
        {"CAT", "MOUSE"},
        {"RAT", "MOUSE"},
        {"DAY", "NIGHT"},
        {"DRY", "RAINY"},
        {"MAD", "ANGRY"},
        {"MAN", "WOMAN"},
        {"OIL", "WATER"},
        {"OLD", "YOUNG"},
        {"RED", "GREEN"},
        {"SAD", "HAPPY"},
        {"SEA", "RIVER"},
        {"SIT", "STAND"},
        {"SKY", "EARTH"}
    };

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
     * shuffle(Object[] aryObject)
     *
     * @param aryObject
     * @return
     */
    public static Object[] shuffle(Object[] aryObject) {
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
        Object[] aryObject2 = new Object[size];
        for (int index = 0; index < size; index++) {
            aryObject2[index] = aryObject[newIndex[index]];
        }
        return aryObject2;
    }

    /**
     * getTodayDict()
     *
     * @return
     */
    public static String[][] getTodayDict() {
        //
        int size = dict.length;
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
        String[][] todayDict = new String[size][size];
        for (int index1 = 0; index1 < size; index1++) {
            for (int index2 = 0; index2 < 2; index2++) {
                todayDict[index1][index2] = dict[newIndex[index1]][index2];
            }
        }
        return todayDict;
    }
}