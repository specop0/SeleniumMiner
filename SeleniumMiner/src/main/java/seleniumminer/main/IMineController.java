package seleniumminer.main;

import seleniumminer.plugin.IPlugin;
import seleniumminer.plugin.webdriver.IWebDriver;
import java.util.function.Function;
import org.json.JSONObject;

public interface IMineController {
    JSONObject RequestDriver(Function<IWebDriver, JSONObject> action);

    IPlugin GetPlugin(String pluginId);
}
