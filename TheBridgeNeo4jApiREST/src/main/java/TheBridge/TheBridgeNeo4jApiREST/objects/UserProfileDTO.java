package TheBridge.TheBridgeNeo4jApiREST.objects;

import TheBridge.TheBridgeNeo4jApiREST.models.Comentario;
import TheBridge.TheBridgeNeo4jApiREST.models.Valoracion;

import java.util.HashMap;
import java.util.List;

public class UserProfileDTO extends UserDTO{

    private List<Comentario> comentarios;
    private HashMap<String, Integer> valoracionesHashMap;
    private List<ProjectDTO> proyects;
    private int liderazgo;
    private int organizacion;
    private int ideacion;
    private int desarrollo;
    private int comunicación;

    public UserProfileDTO(String name, String username, String roles, List<Comentario> comentarios, List<Valoracion> valoraciones) {
        super(name, username, roles);
        this.comentarios = comentarios;
        this.valoracionesHashMap = new HashMap<String, Integer>();
        for (Valoracion valoracion : valoraciones) {
            if (valoracionesHashMap.containsKey(valoracion.getAptitud1())) {
                valoracionesHashMap.put(valoracion.getAptitud1(), valoracionesHashMap.get(valoracion.getAptitud1()) + 1);
            } else {
                valoracionesHashMap.put(valoracion.getAptitud1(), 1);
            }
        }
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }
    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
    public HashMap<String, Integer> getValoraciones() {
        return valoracionesHashMap;
    }
    public void setValoraciones(HashMap<String, Integer> valoraciones) {
        this.valoracionesHashMap = valoraciones;
    }

    public int getLiderazgo() {
        return liderazgo;
    }

    public void setLiderazgo(int liderazgo) {
        this.liderazgo = liderazgo;
    }

    public int getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(int organizacion) {
        this.organizacion = organizacion;
    }

    public int getIdeacion() {
        return ideacion;
    }

    public void setIdeacion(int ideacion) {
        this.ideacion = ideacion;
    }

    public int getDesarrollo() {
        return desarrollo;
    }

    public void setDesarrollo(int desarrollo) {
        this.desarrollo = desarrollo;
    }

    public int getComunicación() {
        return comunicación;
    }

    public void setComunicación(int comunicación) {
        this.comunicación = comunicación;
    }
}
