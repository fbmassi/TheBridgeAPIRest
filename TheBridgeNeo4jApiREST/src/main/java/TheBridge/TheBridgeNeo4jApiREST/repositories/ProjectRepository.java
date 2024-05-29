package TheBridge.TheBridgeNeo4jApiREST.repositories;

import TheBridge.TheBridgeNeo4jApiREST.models.Project;
import TheBridge.TheBridgeNeo4jApiREST.queryresults.ProjectTeamCourseQueryResult;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProjectRepository extends Neo4jRepository<Project, UUID> {

    @Query("MATCH (p:Proyecto {identifier: $identifier}) RETURN p")
    Optional<Project> findProyectByIdentifier(String identifier);

    @Query("MATCH (p:Proyecto {identifier: $identifier}) " +
            "WITH p " +
            "MATCH (p)-[:CON_EQUIPO]->(t:Team) " +
            "MATCH (p)-[:PARA_CURSO]->(c:Course) " +
            "RETURN p as project, t as team, c as course")
    ProjectTeamCourseQueryResult findProyectWithTeamAndCourseByIdentifier(String identifier);

    @Query("MATCH (u:User {username: $username})-[:FORMA_PARTE_DE]->(t:Team) " +
            "WITH t " +
            "MATCH (p)-[:CON_EQUIPO]->(t)" +
            "RETURN p")
    List<Project> findProjectsByUser(String username);

    @Query("MATCH (p:Proyecto {titulo: $titulo, descripcion: $descripcion}) " +
            "CREATE (p)-[:CON_EQUIPO]->(t:Team {identifier: $equipoIdentifier}) " +
            "CREATE (p)-[:PARA_CURSO]->(c:Course {identifier: $cursoIdentifier}) " +
            "SET p.links = $links, p.fotos = $fotos " +
            "RETURN p as project, t as team, c as course")
    ProjectTeamCourseQueryResult createProject(String titulo, String descripcion, List<String> links, List<String> fotos, String equipoIdentifier, String cursoIdentifier);
}
