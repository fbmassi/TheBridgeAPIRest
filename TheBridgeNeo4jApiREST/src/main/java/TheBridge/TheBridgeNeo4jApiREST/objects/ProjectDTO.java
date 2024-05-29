package TheBridge.TheBridgeNeo4jApiREST.objects;

import TheBridge.TheBridgeNeo4jApiREST.models.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProjectDTO {

    private UUID identifier;
    private String titulo;
    private String descripcion;
    private List<String> links;
    private List<String> fotos;
    private Team equipo;
    private String curso;

    public ProjectDTO() {
    }

    public ProjectDTO(UUID identifier, String titulo, String descripcion, Team equipo, String curso) {
        this.identifier = identifier;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.equipo = equipo;
    }

    public UUID getIdentifier() {
        return identifier;
    }

    public void setIdentifier(UUID identifier) {
        this.identifier = identifier;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<String> getLinks() {
        return links;
    }

    public void setLinks(List<String> links) {
        this.links = links;
    }

    public List<String> getFotos() {
        return fotos;
    }

    public void setFotos(List<String> fotos) {
        this.fotos = fotos;
    }

    public Team getEquipo() {
        return equipo;
    }

    public void setEquipo(Team equipo) {
        this.equipo = equipo;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
