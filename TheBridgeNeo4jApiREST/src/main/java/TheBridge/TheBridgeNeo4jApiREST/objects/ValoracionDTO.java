package TheBridge.TheBridgeNeo4jApiREST.objects;

import TheBridge.TheBridgeNeo4jApiREST.models.Valoracion;

import java.util.List;

public class ValoracionDTO {
    private String destinatario;
    private List<String> votos;

    public ValoracionDTO(Valoracion valoracion){
        this.destinatario = valoracion.getDestinatario().getUsername();
        this.votos = valoracion.getVotos();
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public List<String> getVotos() {
        return votos;
    }

    public void setVotos(List<String> votos) {
        this.votos = votos;
    }
}
