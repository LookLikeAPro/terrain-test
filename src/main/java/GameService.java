import org.atmosphere.config.service.*;
import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.AtmosphereResourceEventListenerAdapter;
import org.atmosphere.cpr.AtmosphereResponse;
import org.atmosphere.handler.OnMessage;
import org.atmosphere.config.service.ManagedService;
import org.atmosphere.cpr.AtmosphereResponse;

@ManagedService(path = "/game")
public class GameService {
    @Message
    public void onMessage(AtmosphereResponse res, String m) {
        res.write("Echo: " + m);
    }
}
