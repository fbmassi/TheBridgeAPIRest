package TheBridge.TheBridgeNeo4jApiREST.projections;

import java.util.List;
import java.util.UUID;

public interface TeamProjection {
    UUID getId();
    List<String> getEstudiantes();
}
