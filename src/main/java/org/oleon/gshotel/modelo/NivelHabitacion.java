
package org.oleon.gshotel.modelo;


public class NivelHabitacion {
    private int idNivel;
    private String nombreNivel;

    public NivelHabitacion() {
    }

    public NivelHabitacion(int idNivel, String nombreNivel) {
        this.idNivel = idNivel;
        this.nombreNivel = nombreNivel;
    }

    public int getIdNivel() {
        return idNivel;
    }

    public void setIdNivel(int idNivel) {
        this.idNivel = idNivel;
    }

    public String getNombreNivel() {
        return nombreNivel;
    }

    public void setNombreNivel(String nombreNivel) {
        this.nombreNivel = nombreNivel;
    }
    
}
