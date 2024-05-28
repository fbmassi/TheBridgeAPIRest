package TheBridge.TheBridgeNeo4jApiREST.objects;

public class ComentarioDTO {
    private String mensaje;
    private String remitente;
    private String destinatario;
    private String timestamp;

    public ComentarioDTO(String mensaje, String remitente, String destinatario) {
        this.mensaje = mensaje;
        this.remitente = remitente;
        this.destinatario = destinatario;
        this.timestamp = java.time.LocalDateTime.now().toString();
    }

    public String getMensaje() {
        return mensaje;
    }
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    public String getDestinatario() {
        return destinatario;
    }
    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }
    public String getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    public String getRemitente() {
        return remitente;
    }
}
