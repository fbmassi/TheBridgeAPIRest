package TheBridge.TheBridgeNeo4jApiREST.services;

import TheBridge.TheBridgeNeo4jApiREST.models.Project;
import TheBridge.TheBridgeNeo4jApiREST.queryresults.ProjectTeamCourseQueryResult;
import TheBridge.TheBridgeNeo4jApiREST.repositories.CourseRepository;
import TheBridge.TheBridgeNeo4jApiREST.repositories.ProjectRepository;
import TheBridge.TheBridgeNeo4jApiREST.repositories.TeamRepository;
import TheBridge.TheBridgeNeo4jApiREST.requests.CreateProyectRequest;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProjectService {
    private final ProjectRepository proyectoRepository;
    private final TeamRepository teamRepository;
    private final CourseRepository courseRepository;

    public ProjectService(ProjectRepository proyectoRepository, TeamRepository teamRepository, CourseRepository courseRepository) {
        this.proyectoRepository = proyectoRepository;
        this.teamRepository = teamRepository;
        this.courseRepository = courseRepository;
    }

    public List<Project> getAllProjects() {
        return proyectoRepository.findAll();
    }

    public Project getProjectByIdentifier(String identifier) {
        return proyectoRepository.findProyectByIdentifier(identifier).orElseThrow(()-> new ResponseStatusException(HttpStatusCode.valueOf(404)));
    }

    public List<Project> getProjectsByUser(String username) {
        return proyectoRepository.findProjectsByUser(username);
    }

    public ProjectTeamCourseQueryResult getProjectWithTeamAndCourseByIdentifier(String identifier) {
        return proyectoRepository.findProyectWithTeamAndCourseByIdentifier(identifier);
    }

    public Project createProject(CreateProyectRequest request) {
        //TODO: Implementar la creación de un proyecto

        return null;
    }
}
