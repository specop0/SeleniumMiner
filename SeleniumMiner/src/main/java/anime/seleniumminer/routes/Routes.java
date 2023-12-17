package anime.seleniumminer.routes;

import anime.seleniumminer.main.IMineController;

public class Routes {

    public static void EstablishRoutes(String ipAddress, int port, IMineController controller) {
        spark.Spark.ipAddress(ipAddress);
        spark.Spark.port(port);
        spark.Spark.get("/", (req, res) -> "SeleniumMiner is running");
        spark.Spark.post("/mine/*", "application/json", new MineRoute(controller));
    }
}
