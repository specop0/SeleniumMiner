package seleniumminer.plugin;

public class Plugins {

    public static IPlugin[] GetAllPlugins() {
        return new IPlugin[] {
                new PageSourcePlugin(),
                new AmazonPlugin(),
                new DuckDuckGoPlugin(),
                new ScreenshotPlugin(),
        };
    }
}
