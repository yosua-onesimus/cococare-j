package an.example;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCConfig;
import cococare.common.CCHighcharts;
import cococare.common.CCHighcharts.Serial;
import java.util.Arrays;
//</editor-fold>

public class Ex4_Highcharts {

    public static void main(String[] args) {
        CCConfig.MSG_SHOW_PRINTLN = true;
        CCHighcharts highcharts = new CCHighcharts();
        highcharts.getChart().setRenderTo("container");
        String[] categories = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        highcharts.getxAxis().getCategories().addAll(Arrays.asList(categories));
        Serial serial = highcharts.newSerial();
        Double[] data = new Double[]{29.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4};
        serial.getData().addAll(Arrays.asList(data));
        highcharts.getSeries().add(serial);
        highcharts.compile();
        //output: var chart = new Highcharts.Chart({ chart: { renderTo: 'container', type: 'spline', }, credits: { enabled: false, }, plotOptions: { series: { allowPointSelect: true, cursor: 'pointer', dataLabels: { color: 'black', enabled: true, }, enableMouseTracking: true, showInLegend: true, }, }, series: [ { data: [ 29.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4, ], }, ], xAxis: { categories: [ 'Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec', ], }, yAxis: [ { }, ], });
    }
}