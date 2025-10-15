package modelo;

public class Posicion {
	Equipo equipo;
	int puntaje;
	public Posicion(Equipo equipo, int puntaje) {
		this.equipo = equipo;
		this.puntaje = puntaje;
	}
	public Equipo getEquipo() {
		return equipo;
	}
	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	public int getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	@Override
	public String toString() {
		// Que el nombre del equipo sea de 20 caracteres.
		return String.format("%-20s | %2d pts.", 
			    equipo.getNombre().length() > 20 
		        ? equipo.getNombre().substring(0, 20) 
		        : equipo.getNombre(), 
		    puntaje);
	}
	
}
