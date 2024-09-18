
package App;

import java.util.Objects;

public class Muestra {
   
    private String idMuestra;
    private String tipoMuestra;
    private String fechaRecoleccion;

    public Muestra(String idMuestra, String tipoMuestra, String fechaRecoleccion) {
        this.idMuestra = idMuestra;
        this.tipoMuestra = tipoMuestra;
        this.fechaRecoleccion = fechaRecoleccion;
    }

    public String getIdMuestra() {
        return idMuestra;
    }

    public String getTipoMuestra() {
        return tipoMuestra;
    }

    public String getFechaRecoleccion() {
        return fechaRecoleccion;
    }

    @Override
    public int hashCode() {
//        int hash = 3;
//        hash = 47 * hash + Objects.hashCode(this.idMuestra);
//        return hash;
        return Objects.hash(idMuestra);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Muestra muestra = (Muestra) obj;
        return idMuestra.equals(muestra.idMuestra);
        
    }

    @Override
    public String toString() {
        return "Muestra{" + "ID= " + idMuestra + ", tipoMuestra=" + tipoMuestra + ", fechaRecoleccion=" + fechaRecoleccion + '}';
    }
    
    
    
}
