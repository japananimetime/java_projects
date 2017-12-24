/*
Laboratory Numerical Methods
 */

package javaapplication2;

import java.awt.Desktop;
import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Chart;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.charts.AxisCrosses;
import org.apache.poi.ss.usermodel.charts.AxisPosition;
import org.apache.poi.ss.usermodel.charts.ChartAxis;
import org.apache.poi.ss.usermodel.charts.ChartDataSource;
import org.apache.poi.ss.usermodel.charts.ChartLegend;
import org.apache.poi.ss.usermodel.charts.DataSources;
import org.apache.poi.ss.usermodel.charts.LegendPosition;
import org.apache.poi.ss.usermodel.charts.LineChartData;
import org.apache.poi.ss.usermodel.charts.ValueAxis;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author 19452
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        double al;
        System.out.println("Hello. Welcome to the world of numerical methods. Below you will be guided to build the graph of the temperature change. Please ensure MS Excel or another ofiice spreadsheet program with function of building the graph is installed. \nFollow the instructions and you will get the graph.");
        System.out.println("Please, enter value of alpha");
        al = in.nextDouble();
        double lam;
        System.out.println("Please, enter value of lambda");
        lam = in.nextDouble();
        double L;
        System.out.println("Please, enter value of L");
        L = in.nextDouble();
        double T1;
        System.out.println("Please, enter inner temperature");
        T1 = in.nextDouble();
        double Ta;
        System.out.println("Please, enter outer temperature");
        Ta = in.nextDouble();
        double N;
        System.out.println("Please, enter value of N");
        N = in.nextDouble();
        double B;
        B = T1;
        double A;
        A = (al*(Ta-T1))/(lam+L*al);
        double dX;
        dX = L/N;
        LinkedList <Double> tetta;
        tetta = new LinkedList();
        double x;
        for(int i=0; i<N; i++){
            x=i*dX;
            tetta.add(A*x+B);
//            System.out.println(i+1+") "+tetta.get((int) i));
        }
        // создание самого excel файла в памяти
        XSSFWorkbook workbook;
        workbook = new XSSFWorkbook();
        // создание листа с названием "Lab1"
        XSSFSheet sheet;
        sheet = workbook.createSheet("Lab1");
        Row row;
        for(int i=0; i<tetta.size();i++){
            row = sheet.createRow(i);
            row.createCell(0).setCellValue(tetta.get(i));
//            row.createCell(1).setCellValue(i);
        }
        final int NUM_OF_ROWS = (int)N;
        final int NUM_OF_COLUMNS = 1;

        // Create a row and put some cells in it. Rows are 0 based.

        Drawing drawing = sheet.createDrawingPatriarch();
        ClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 0, 5, 10, 15);

        Chart chart = drawing.createChart(anchor);
//        ChartLegend legend = chart.getOrCreateLegend();
//        legend.setPosition(LegendPosition.TOP_RIGHT);

        LineChartData data = chart.getChartDataFactory().createLineChartData();

        // Use a category axis for the bottom axis.
        ChartAxis bottomAxis = chart.getChartAxisFactory().createCategoryAxis(AxisPosition.BOTTOM);
        ValueAxis leftAxis = chart.getChartAxisFactory().createValueAxis(AxisPosition.LEFT);
        leftAxis.setCrosses(AxisCrosses.AUTO_ZERO);

        ChartDataSource<Number> xs = DataSources.fromNumericCellRange(sheet, new CellRangeAddress(0, 0, 0, NUM_OF_COLUMNS));
        ChartDataSource<Number> ys1 = DataSources.fromNumericCellRange(sheet, new CellRangeAddress(0, (int) N, 0, NUM_OF_COLUMNS-1));
//        ChartDataSource<Number> ys2 = DataSources.fromNumericCellRange(sheet, new CellRangeAddress(2, 2, 0, NUM_OF_COLUMNS - 1));


        data.addSeries(xs, ys1);
//        data.addSeries(xs, ys2);

        chart.plot(data, bottomAxis, leftAxis);
        try {
            FileOutputStream out = new FileOutputStream(new File("Labs.xlsx"));
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Excel file was successfully created.");
        Desktop desktop = null;
        if (Desktop.isDesktopSupported()) {
            desktop = Desktop.getDesktop();
        }
        try {
            desktop.open(new File("Labs.xlsx"));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}
