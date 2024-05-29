package TheBridge.TheBridgeNeo4jApiREST.models;

import org.springframework.data.neo4j.core.schema.*;

import java.util.List;
import java.util.UUID;

@Node
public class Project {

    @Id @GeneratedValue(GeneratedValue.UUIDGenerator.class)
    private UUID id;
    @GeneratedValue(GeneratedValue.UUIDGenerator.class)
    private UUID identifier;
    private String titulo;
    private String descripcion;
    private List<String> links;
    private List<String> fotos;

    public Project() {
    }

    public Project(String titulo, String descripcion) {
        this.setTitulo(titulo);
        this.setDescripcion(descripcion);
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {return this.descripcion;}

    public String getTitulo() {
        return this.titulo;
    }

    public List<String> getFotos() {
        return fotos;
    }

    public void setFotos(List<String> fotos) {
        this.fotos = fotos;
    }

    public List<String> getLinks() {
        return links;
    }

    public void setLinks(List<String> links) {
        this.links = links;
    }

    public UUID getIdentifier() {
        return identifier;
    }

}
