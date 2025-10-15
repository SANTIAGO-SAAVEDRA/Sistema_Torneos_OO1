package modelo;

import java.util.ArrayList;
import java.util.List;

public class Goleador {
	Jugador jugador;
	int goles;
	
	public Goleador(Jugador jugador, int goles) {
		this.jugador = jugador;
		this.goles = goles;
	}
	public Jugador getJugador() {
		return jugador;
	}
	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
	public int getGoles() {
		return goles;
	}
	public void setGoles(int goles) {
		this.goles = goles;
	}
	
	private static void agregarEstadisticaALista(List<Goleador> lista, EstadisticaPartido stat) {
		int goles = stat.getGoles();
		boolean encontrado = false;
		int i = 0;
		while (i < lista.size() && !encontrado) {
			Goleador g = lista.get(i);
			if (g.getJugador().equals(stat.getJugador())) {
				g.goles += goles;
				encontrado = true;
			}
			i++;
		}
		if (!encontrado) {
			lista.add(new Goleador(stat.getJugador(), goles));
		}
	}

	
	private static void ordenarGoleadores(List<Goleador> lista) {
	    for (int i = 0; i < lista.size() - 1; i++) {
	        for (int j = 0; j < lista.size() - 1 - i; j++) {
	            if (lista.get(j).getGoles() < lista.get(j + 1).getGoles()) {
	                Goleador temp = lista.get(j);
	                lista.set(j, lista.get(j + 1));
	                lista.set(j + 1, temp);
	            }
	        }
	    }
	}
	
	public static List<Goleador> generarTablaGoleador(Torneo t) throws Exception {
		if (t.getEquipos().isEmpty()) {
	        throw new Exception("El torneo "+ t.getNombre() + " no tiene equipos.");
	    }
		if (t.getPartidos().isEmpty()) {
	        throw new Exception("El torneo "+ t.getNombre() + " no jugo ningún partido.");
	    }
	    List<Goleador> goleadores = new ArrayList<>();

	    for (Partido p : t.getPartidos()) {
	        for (EstadisticaPartido stat : p.getEstadisticas()) {
	        	if (stat.getGoles() > 0)
	        		agregarEstadisticaALista(goleadores, stat);
	        }
	    }
	    if (goleadores.isEmpty())
	        throw new Exception("No hubo goles en " + t.getNombre() + ".");

	    ordenarGoleadores(goleadores);
	    return goleadores;
	}
	
	@Override
	public String toString() {
		return String.format("%-30s | %2d", 
				jugador.getNombreCompleto().length() > 30 
		        ? jugador.getNombreCompleto().substring(0, 30) 
		        : jugador.getNombreCompleto(), 
		    goles);
	}
}

	