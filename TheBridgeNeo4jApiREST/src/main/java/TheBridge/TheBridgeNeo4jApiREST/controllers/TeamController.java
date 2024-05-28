package TheBridge.TheBridgeNeo4jApiREST.controllers;

import TheBridge.TheBridgeNeo4jApiREST.models.Team;
import TheBridge.TheBridgeNeo4jApiREST.objects.TeamDTO;
import TheBridge.TheBridgeNeo4jApiREST.services.TeamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/equipos")
public class TeamController {

    private final TeamService equipoService;

    public TeamController(TeamService equipoService) {
        this.equipoService = equipoService;
    }

    @GetMapping("/porID")
    public ResponseEntity<TeamDTO> equipoDetails(@RequestParam String identifier) {
        Optional<Team> equipo = equipoService.getTeamByIdentifier(identifier);

        if (equipo.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        TeamDTO responseEquipo = new TeamDTO(
                equipo.get().getNombre(),
                equipo.get().getEstudiantes().stream()
                        .map(estudiante -> estudiante.getUsername())
                        .collect(Collectors.toList()));

        return new ResponseEntity<>(responseEquipo, HttpStatus.OK);
    }

    @GetMapping("/deUsuario/{username}")
    public ResponseEntity<List<TeamDTO>> getEquiposByUser(@PathVariable String username) {
        List<Team> equipos = equipoService.getTeamsByStudent(username);
        List<TeamDTO> equiposResponse = equipos.stream().map(
                (equipo) -> {TeamDTO responseEquipo = new TeamDTO(
                        equipo.getNombre(),
                        equipo.getEstudiantes().stream()
                                .map(estudiante -> estudiante.getUsername())
                                .collect(Collectors.toList()));
                    return responseEquipo;}
        ).collect(Collectors.toList());
        return new ResponseEntity<>(equiposResponse, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<TeamDTO> createEquipo(Principal principal, @RequestParam String nombre) {
        TeamDTO nuevoEquipo = equipoService.createTeam(principal.getName(), nombre);

        return new ResponseEntity<>(nuevoEquipo, HttpStatus.CREATED);
    }

    @PostMapping("/addStudent")
    public String addStudentToEquipo(Principal principal, @RequestParam String username, @RequestParam String equipo) {
        equipoService.addStudentToTeam(principal.getName(), username, equipo);
        return principal.getName()+" added " + username + " to team "+equipo;
    }

    @DeleteMapping("/removeStudent")
    public String removeStudentFromEquipo(Principal principal, @RequestParam String username, @RequestParam String equipo) {
        equipoService.removeStudentFromTeam(principal.getName(), username, equipo);
        return principal.getName()+" removed from team "+ equipo;
    }
}
