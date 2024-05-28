package TheBridge.TheBridgeNeo4jApiREST.repositories;

import TheBridge.TheBridgeNeo4jApiREST.models.Team;
import TheBridge.TheBridgeNeo4jApiREST.objects.TeamDTO;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TeamRepository  extends Neo4jRepository<Team, UUID> {

    @Query("MATCH (e:Team {id: $identifier}) RETURN e")
    Optional<Team> findTeamByIdentifier(String identifier);

    @Query("MATCH (p:User{username: $username})-[:FORMA_PARTE_DE]->(e:Team) RETURN e")
    List<Team> findTeamsByStudent(String username);

    @Query("MATCH (u:User{username: $username }) " +
            "CREATE (u)-[:FORMA_PARTE_DE]->(e:Team {nombre: $nombre }) " +
            "WITH e " +
            "MATCH (s:User)-[:FORMA_PARTE_DE]->(e) " +
            "RETURN e.nombre as nombre, apoc.text.join(collect(s.username), ',') as estudiantes")
    TeamDTO createTeam(String username, String nombre);

    @Query("MATCH (u:User{username: $username}) " +
            "WITH u " +
            "MATCH (d:User{username: $dueño})-[:FORMA_PARTE_DE]->(e:Team{nombre: $nombre}) " +
            "CREATE (u)-[:FORMA_PARTE_DE]->(e) RETURN e, u")
    void addStudentToTeam(String dueño, String username, String nombre);

    @Query("MATCH (u:User{username: $username})-[r:FORMA_PARTE_DE]->(e:Team{nombre: $nombre}) " +
            "WITH u, r, e " +
            "MATCH (d:User{username: $dueño})-[:FORMA_PARTE_DE]->(e) " +
            "DELETE r")
    void removeStudentFromTeam(String dueño, String username, String nombre);
}
