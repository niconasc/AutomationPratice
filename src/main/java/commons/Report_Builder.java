package commons;

import com.rajatthareja.reportbuilder.ReportBuilder;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Report_Builder {

    private static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private static DateFormat dateFormatFile = new SimpleDateFormat("dd-M-yyyy");
    private static Date date = new Date();

    public static void main(String... args) {
        // Create Report_Builder Object
        ReportBuilder reportBuilder = new ReportBuilder();

        //reportBuilder.setReportDirectory(userDir + "\\automacao-teste-fv\\report_doc/");
        reportBuilder.setReportDirectory("src/main/report/");


        // Set output report_doc file name
        reportBuilder.setReportFileName(dateFormatFile.format(date) + "_TestReport");

        // Set Report Title
        reportBuilder.setReportTitle("Automation Pratice - Desafio de Automação");

        // Set Report Color for more visit http://materializecss.com/color.html
        reportBuilder.setReportColor(String.valueOf(Color.ORANGE));

        // Enable voice control for report_doc
        reportBuilder.enableVoiceControl();

        // Add additional info for Report
        reportBuilder.setAdditionalInfo("Environment", "Ambiente de Produção");
        reportBuilder.setAdditionalInfo("Date", dateFormat.format(date));


        // Create list or report_doc Files or Directories or URLs or JSONObject or JSONString
        List<Object> cucumberJsonReports = new ArrayList<>();
        cucumberJsonReports.add(new File("src/main/report/cucumber.json"));
        cucumberJsonReports.add(new File("src/main/report/"));
        //cucumberJsonReports.add(new URL("http://myReportUrl/report.json"));
        // cucumberJsonReports.add(new JSONObject("report_doc Json String"));

        // Build your report_doc
        reportBuilder.build(cucumberJsonReports);
    }

    public enum Color {

        ORANGE("orange lighten-4");

        private final String color;

        /**
         * @param color for report_doc
         */
        Color(final String color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return color.toLowerCase();
        }
    }
}
