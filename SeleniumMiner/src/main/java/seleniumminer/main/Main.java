package seleniumminer.main;

import seleniumminer.plugin.IPlugin;
import seleniumminer.plugin.Plugins;
import seleniumminer.plugin.webdriver.FirefoxDriverEx;
import seleniumminer.plugin.webdriver.IWebDriver;
import seleniumminer.routes.Routes;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String ipAddress = "seleniumminer";
        int port = 5022;
        if (args.length > 0) {
            ipAddress = args[0];
        }
        if (args.length > 1) {
            try {
                port = Integer.parseInt(args[1]);
            } catch (NumberFormatException ex) {
                // default port
            }
        }

        try {
            IWebDriver driver = FirefoxDriverEx.GetNewWebDriver();
            IPlugin[] plugins = Plugins.GetAllPlugins();
            IMineController controller = new MineController(driver, plugins);

            Routes.EstablishRoutes(ipAddress, port, controller);

            System.out.println(String.format("Endpoint listening at: %s:%d", ipAddress, port));

            spark.Spark.awaitStop();
        } catch (Throwable ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex);
        }
    }
}
