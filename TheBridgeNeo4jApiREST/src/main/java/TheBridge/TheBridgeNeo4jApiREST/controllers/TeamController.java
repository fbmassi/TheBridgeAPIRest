package TheBridge.TheBridgeNeo4jApiREST.controllers;

import TheBridge.TheBridgeNeo4jApiREST.models.Team;
import TheBridge.TheBridgeNeo4jApiREST.objects.TeamDTO;
import TheBridge.TheBridgeNeo4jApiREST.objects.UserDTO;
import TheBridge.TheBridgeNeo4jApiREST.queryresults.TeamUsersQueryResult;
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

    @GetMapping("/porIdentifier")
    public ResponseEntity<TeamDTO> equipoDetails(@RequestParam String identifier) {
        TeamUsersQueryResult result = equipoService.getTeamWithUsersByIdentifier(identifier);

        TeamDTO responseEquipo = result.toTeamDTO();

        return new ResponseEntity<>(responseEquipo, HttpStatus.OK);
    }

    @GetMapping("/deUsuario")
    public ResponseEntity<List<Team>> getEquiposByUser(@RequestParam String username) {
        List<Team> equipos = equipoService.getTeamsByStudent(username);

        return new ResponseEntity<>(equipos, HttpStatus.OK);
    }

    @GetMapping("/misEquipos")
    public ResponseEntity<List<Team>> getMisEquipos(Principal principal) {
        List<Team> equipos = equipoService.getTeamsByStudent(principal.getName());

        return new ResponseEntity<>(equipos, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<TeamDTO> createEquipo(Principal principal, @RequestParam String nombreEquipo) {
        TeamDTO nuevoEquipo = equipoService.createTeam(principal.getName(), nombreEquipo);

        return new ResponseEntity<>(nuevoEquipo, HttpStatus.CREATED);
    }

    @PostMapping("/addStudent")
    public ResponseEntity<TeamDTO> addStudentToEquipo(Principal principal, @RequestParam String username, @RequestParam String identifier) {
        TeamDTO nuevoEquipo = equipoService.addStudentToTeam(principal.getName(), username, identifier);
        return new ResponseEntity<>(nuevoEquipo, HttpStatus.CREATED);
    }

    @DeleteMapping("/removeStudent")
    public ResponseEntity<TeamDTO> removeStudentFromEquipo(Principal principal, @RequestParam String username, @RequestParam String identifier) {
        TeamDTO nuevoEquipo = equipoService.removeStudentFromTeam(principal.getName(), username, identifier);
        return new ResponseEntity<>(nuevoEquipo, HttpStatus.OK);
    }
}
