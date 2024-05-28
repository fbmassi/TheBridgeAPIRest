package TheBridge.TheBridgeNeo4jApiREST.objects;

import java.util.List;

public class TeamDTO {
    private String nombre;
    private List<String> estudiantes;

    public TeamDTO() {
    }

    public TeamDTO(String nombre, List<String> estudiantes) {
        this.nombre = nombre;
        this.estudiantes = estudiantes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<String> estudiantes) {
        this.estudiantes = estudiantes;
    }
}
