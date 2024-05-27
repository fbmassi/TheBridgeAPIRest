package TheBridge.TheBridgeNeo4jApiREST.services;

import TheBridge.TheBridgeNeo4jApiREST.models.Comentario;
import TheBridge.TheBridgeNeo4jApiREST.models.User;
import TheBridge.TheBridgeNeo4jApiREST.models.Valoracion;
import TheBridge.TheBridgeNeo4jApiREST.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class InteractionUserService {

    private final UserRepository userRepository;

    public InteractionUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void realizarComentario(User principal, Comentario comentario) {
        userRepository.comentarPerfilCompañero(
                principal.getUsername(),
                comentario.getDestinatario().getUsername(),
                comentario.getMensaje(),
                LocalDateTime.now().toString());
    }

    public void realizarValoracion(User principal, Valoracion valoracion) {
        userRepository.valorarPerfilCompañero(
                principal.getUsername(),
                valoracion.getDestinatario().getUsername(),
                valoracion.getAptitud1(),
                valoracion.getAptitud2(),
                valoracion.getAptitud3(),
                valoracion.getMensaje(),
                LocalDateTime.now().toString());
    }
}
