package TheBridge.TheBridgeNeo4jApiREST.models;

import org.springframework.data.neo4j.core.schema.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Node
public class Team {

    @Id @GeneratedValue(GeneratedValue.UUIDGenerator.class)
    private UUID id;
    @Property
    private String nombre;
    @Relationship(type = "FORMA_PARTE_DE", direction = Relationship.Direction.INCOMING)
    private List<User> estudiantes = new ArrayList<User>();
    @Relationship(type = "REALIZADO_EN_EQUIPO_CON", direction = Relationship.Direction.INCOMING)
    private List<Proyect> proyectos;


    public Team(String nombre) {
        this.nombre = nombre;
    };

    public Team(String nombre, ArrayList<User> estudiantes) {
        this.estudiantes = estudiantes;
    };

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<User> getEstudiantes() {
        return this.estudiantes;
    };

    public void addEstudiante(User estudiante) {
        this.estudiantes.add(estudiante);
    }

    public List<Proyect> getProyecto() {
        return proyectos;
    }

    public void setProyecto(List<Proyect> proyecto) {
        this.proyectos = proyecto;
    }

    public void addProyecto(Proyect proyecto) {
        this.proyectos.add(proyecto);
    }
}
