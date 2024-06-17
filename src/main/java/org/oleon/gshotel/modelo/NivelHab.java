package org.oleon.gshotel.modelo;

public class NivelHab {
    private int IdNivel;
    private String NombreNivel;

    public NivelHab() {
    }

    public NivelHab(int IdNivel, String NombreNivel) {
        this.IdNivel = IdNivel;
        this.NombreNivel = NombreNivel;
    }

    public int getIdNivel() {
        return IdNivel;
    }

    public void setIdNivel(int IdNivel) {
        this.IdNivel = IdNivel;
    }

    public String getNombreNivel() {
        return NombreNivel;
    }

    public void setNombreNivel(String NombreNivel) {
        this.NombreNivel = NombreNivel;
    }
    
    
    
}
