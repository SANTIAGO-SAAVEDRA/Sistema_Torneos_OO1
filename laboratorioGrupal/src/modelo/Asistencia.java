package modelo;

import java.util.ArrayList;
import java.util.List;

public class Asistencia {
	Jugador jugador;
	int asistencias;
	public Asistencia(Jugador jugador, int asistencias) {
		this.jugador = jugador;
		this.asistencias = asistencias;
	}
	public Jugador getJugador() {
		return jugador;
	}
	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
	public int getAsistencias() {
		return asistencias;
	}
	public void setAsistencias(int asistencias) {
		this.asistencias = asistencias;
	}

	private static void agregarEstadisticaALista(List<Asistencia> lista, EstadisticaPartido stat) {
		int asistencias = stat.getAsistencias();
		boolean encontrado = false;
		int i = 0;
		while (i < lista.size() && !encontrado) {
			Asistencia g = lista.get(i);
			if (g.getJugador().equals(stat.getJugador())) {
				g.asistencias += asistencias;
				encontrado = true;
			}
			i++;
		}
		if (!encontrado) {
			lista.add(new Asistencia(stat.getJugador(), asistencias));
		}
	}

	
	private static void ordenarGoleadores(List<Asistencia> lista) {
	    for (int i = 0; i < lista.size() - 1; i++) {
	        for (int j = 0; j < lista.size() - 1 - i; j++) {
	            if (lista.get(j).getAsistencias() < lista.get(j + 1).getAsistencias()) {
	                Asistencia temp = lista.get(j);
	                lista.set(j, lista.get(j + 1));
	                lista.set(j + 1, temp);
	            }
	        }
	    }
	}
	
	public static List<Asistencia> generarTablaAsistencia(Torneo t) throws Exception {
		if (t.getEquipos().isEmpty()) {
	        throw new Exception("El torneo "+ t.getNombre() + " no tiene equipos.");
	    }
		if (t.getPartidos().isEmpty()) {
	        throw new Exception("El torneo "+ t.getNombre() + " no jugo ningún partido.");
	    }
	    List<Asistencia> goleadores = new ArrayList<>();

	    for (Partido p : t.getPartidos()) {
	        for (EstadisticaPartido stat : p.getEstadisticas()) {
	        	if (stat.getAsistencias() > 0)
	        		agregarEstadisticaALista(goleadores, stat);
	        }
	    }
	    if (goleadores.isEmpty())
	        throw new Exception("No hubo asistencias en " + t.getNombre() + ".");

	    ordenarGoleadores(goleadores);
	    return goleadores;
	}
	
	@Override
	public String toString() {
		return String.format("%-30s | %2d", 
				jugador.getNombreCompleto().length() > 30 
		        ? jugador.getNombreCompleto().substring(0, 30) 
		        : jugador.getNombreCompleto(), 
		    asistencias);
	}
}
