package TheBridge.TheBridgeNeo4jApiREST.controllers;

import TheBridge.TheBridgeNeo4jApiREST.models.Project;
import TheBridge.TheBridgeNeo4jApiREST.objects.ProjectDTO;
import TheBridge.TheBridgeNeo4jApiREST.queryresults.ProjectTeamCourseQueryResult;
import TheBridge.TheBridgeNeo4jApiREST.requests.CreateProyectRequest;
import TheBridge.TheBridgeNeo4jApiREST.services.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/proyectos")
public class ProjectController {

    private final ProjectService proyectoService;

    public ProjectController(ProjectService proyectoService) { this.proyectoService = proyectoService; }

    @GetMapping("/{indentifier}")
    public ResponseEntity<ProjectDTO> proyectoDetails(@PathVariable String identifier) {
        ProjectTeamCourseQueryResult result = proyectoService.getProjectWithTeamAndCourseByIdentifier(identifier);

        ProjectDTO projectDTO = new ProjectDTO(
        );

        projectDTO.setCurso(result.getCourse().getNombre());
        projectDTO.setEquipo(result.getTeam());
        projectDTO.setDescripcion(result.getProject().getDescripcion());
        projectDTO.setTitulo(result.getProject().getTitulo());
        projectDTO.setIdentifier(result.getProject().getIdentifier());
        projectDTO.setFotos(result.getProject().getFotos());
        projectDTO.setLinks(result.getProject().getLinks());

        return new ResponseEntity<>(projectDTO, HttpStatus.OK);
    }

    @PostMapping("/crearProyecto")
    public ResponseEntity<ProjectDTO> crearProyecto(@RequestBody CreateProyectRequest request) {
        Project projecto = proyectoService.createProject(request);

        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @GetMapping("/proyectosUsuario/{username}")
    public ResponseEntity<List<Project>> proyectosUsuario(@PathVariable String username) {
        List<Project> proyectos = proyectoService.getProjectsByUser(username);

        return new ResponseEntity<>(proyectos, HttpStatus.OK);
    }

    @GetMapping("/misProyectos")
    public ResponseEntity<List<Project>> misProyectos(Principal principal) {
        List<Project> proyectos = proyectoService.getProjectsByUser(principal.getName());

        return new ResponseEntity<>(proyectos, HttpStatus.OK);
    }

}
