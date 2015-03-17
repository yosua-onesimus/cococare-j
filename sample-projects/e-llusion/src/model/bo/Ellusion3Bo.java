package model.bo;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static model.bo.Ellusion2Bo.horizontalShuffle;
//</editor-fold>

public class Ellusion3Bo {

//<editor-fold defaultstate="collapsed" desc=" private object ">
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
//</editor-fold>

    public static Object[][] getTodayDict() {
        return horizontalShuffle(dict);
    }

    public static void main(String[] args) {
        Object[][] oses = getTodayDict();
        for (Object[] os : oses) {
            for (Object o : os) {
                System.out.print(o + " ");
            }
            System.out.println("");
        }
    }
}