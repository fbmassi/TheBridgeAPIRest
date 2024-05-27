package TheBridge.TheBridgeNeo4jApiREST.repositories;

import TheBridge.TheBridgeNeo4jApiREST.models.Comentario;
import TheBridge.TheBridgeNeo4jApiREST.models.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends Neo4jRepository<User, UUID> {
    Optional<User> findUserByUsername(String email);

    @Query("MATCH (estudiante:User) WHERE estudiante.username IN $emails RETURN estudiante")
    List<User> findStudentsByEmails(List<String> emails);

    @Query("MATCH (destinatario:User {username: $emailDestinatario}) " +
            "MATCH (remitente:User {username: $emailRemitente}) " +
            "CREATE (remitente)-[:COMENTO_A {mensaje: $mensaje, timestamp: $fecha}]->(destinatario)")
    String comentarPerfilCompañero(String emailRemitente, String emailDestinatario, String mensaje, String fecha);

    @Query("MATCH (destinatario:User {username: $emailDestinatario}) " +
            "MATCH (remitente:User {username: $emailRemitente}) " +
            "CREATE (remitente)-[:VALORO_A {" +
            "a1: $a1, a2: $a2, a3: $a3, mensaje: $mensaje, timestamp: $fecha" +
            "}]->(destinatario)")
    String valorarPerfilCompañero(String emailRemitente, String emailDestinatario, String a1, String a2, String a3, String mensaje, String fecha);

}
