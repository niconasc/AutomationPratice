package commons;

import cucumber.api.Scenario;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import static commons.SeleniumRobot.getWebDriver;


public class Utils {

    private static RestRobot restRobot = new RestRobot();

    public static int getRandomNumber(int n) {
        return new Random().nextInt(n);
    }

    public static void embeddImagesInReportWeb(Scenario scenario) {
        File srcFileWeb = null;

        try {
            if (getWebDriver() != null) {
                srcFileWeb = ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.FILE);
                byte[] data = FileUtils.readFileToByteArray(srcFileWeb);
                scenario.embed(data, "image/png");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void removeEmbeddedImages() {
        File folder = new File(System.getProperty("user.dir") + "/src/main/report/");

        if (folder.listFiles() != null) {
            for (File file : folder.listFiles()) {
                if (file.getName().startsWith("embedded") && file.getName().endsWith(".png"))
                    file.delete();
            }
        }
    }

    public static void killallChromeDriver() throws IOException {
        executeCommand("killall chromedriver");
    }

    public static String getCpf(boolean comPontos) {
        String retorno = restRobot.getRequest("https://api.nfse.io/Generate/NaturalPeople/taxNumber/1", "taxNumbers.value")[0];
        if (comPontos) {
            return retorno;
        } else {
            return retorno.replace(".", "").replace("-", "");
        }
    }

    public static String getCnpj(boolean comPontos) {
        String retorno = restRobot.getRequest("https://api.nfse.io/Generate/LegalEntities/taxNumber/1", "taxNumbers.value")[0];
        if (comPontos) {
            return retorno;
        } else {
            return retorno.replace(".", "").replace("-", "").replace("/", "");
        }
    }

    public static void setThreadSleep(int time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {

        }
    }

    public static BufferedReader executeCommand(String command) throws IOException {
        String sistemaOperacional = System.getProperty("os.name");
        Process p;
        if (!sistemaOperacional.equalsIgnoreCase("windows")) {
            p = Runtime.getRuntime().exec(new String[]{"/bin/bash", "-l", "-c", command});
        } else {
            p = Runtime.getRuntime().exec(new String[]{"powershell", "-c", command});
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(p.getInputStream()));
        return bufferedReader;
    }

    public static Integer weekDayInteger() {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("America/Sao_Paulo"));
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    public static String weekDayString() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE");
        return simpleDateFormat.format(date);
    }

    public static String getSaoPauloTime(String format) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("America/Sao_Paulo"));
        System.out.println(new SimpleDateFormat(format).format(calendar.getTime()));
        return new SimpleDateFormat(format).format(calendar.getTime());
    }

    private String removeCaracteresEspeciais(String doc) {
        if (doc.contains(".")) {
            doc = doc.replace(".", "");
        }
        if (doc.contains("-")) {
            doc = doc.replace("-", "");
        }
        if (doc.contains("/")) {
            doc = doc.replace("/", "");
        }
        if (doc.contains(";")) {
            doc = doc.replace(";", "");
        }
        if (doc.contains(":")) {
            doc = doc.replace(":", "");
        }
        return doc;
    }

    public String getRg(boolean comPontos) {

        String numerosContatenados = "";
        String numeroGerado;
        List<Integer> n = new ArrayList<Integer>();
        for (int i = 0; i < 9; i++) {
            n.add(getRandomNumber(10));
        }

        for (int i = 0; i < 9; i++) {
            numerosContatenados = numerosContatenados.concat(String.valueOf(n.get(i)));
        }

        if (comPontos)
            numeroGerado = n.get(0) + n.get(1) + "." + n.get(2) + n.get(3) + n.get(4) + "." + n.get(5) + n.get(6) + n.get(7) + "-" + n.get(8);
        else
            numeroGerado = numerosContatenados;

        return numeroGerado;
    }

    @Test
    public void te() throws IOException {
        writeTxtFile("", "Login = 222", "Senha = 111");
    }

    public static void writeTxtFile(String path, String... args) throws IOException {
        File arquivo = new File(path);
        if (arquivo.exists()) {
            arquivo.delete();
            arquivo.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(arquivo, true);
        fileWriter.write("# Último Cadastro em " + getSaoPauloTime("dd/MM/YYYY hh:mm:ss") + "\n");
        for (String value : args) {
            fileWriter.write(value + "\n");
        }
        fileWriter.close();

    }

    public static boolean isChrome(){
        String navegador = PropertiesManager.getProp("src/main/resources/properties/web.properties", "navegador");
        return navegador.equalsIgnoreCase("CHROME")
                || navegador.equalsIgnoreCase("HEADLESS");
    }
}