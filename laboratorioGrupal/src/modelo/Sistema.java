package modelo;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Sistema {
    private List<Torneo> torneos = new ArrayList<Torneo>();
    private List<Equipo> equipos = new ArrayList<Equipo>();
    private List<Jugador> jugadores = new ArrayList<Jugador>();
    private List<Entrenador> entrenadores = new ArrayList<Entrenador>();
    private List<Partido> partidos = new ArrayList<Partido>();
    private List<EstadisticaPartido> estadisticas = new ArrayList<EstadisticaPartido>();

    public Torneo crearTorneo(String nombre, LocalDate inicio, LocalDate fin) {
        Torneo torneo = new Torneo(nombre, inicio, fin);
        torneos.add(torneo);
        return torneo;
    }
    
    public EstadisticaPartido agregarEstadistica(Partido partido, Equipo equipo, int goles, int asistencias, int minutosJugados) {
        int id = (estadisticas.isEmpty()) ? 1 : estadisticas.get(estadisticas.size() - 1).getId() + 1;
        EstadisticaPartido estadistica = new EstadisticaPartido(id, partido, equipo, goles, asistencias, minutosJugados);
        estadisticas.add(estadistica);
        partido.agregarEstadistica(estadistica);
        return estadistica;
    }
    public Partido agregarPartido(LocalDate fecha, Equipo local, Equipo visitante, String estadio) {
        int id = (partidos.isEmpty()) ? 1 : partidos.get(partidos.size() - 1).getId() + 1;
        Partido partido = new Partido(id, fecha, local, visitante, estadio);
        partidos.add(partido);
        return partido;
    }
   
    public Equipo agregarEquipo(String nombre, Entrenador entrenador, LocalDate fechaCreacion) {
        int id = (equipos.isEmpty()) ? 1 : equipos.get(equipos.size() - 1).getId() + 1;
        try {
            Equipo equipo = new Equipo(id, nombre, entrenador, fechaCreacion);
            equipos.add(equipo);
            return equipo;
        } catch (Exception e) {
            System.out.println("Excepción: " + e.getMessage());
            return null;
        }
    }
    public Jugador agregarJugador(String nombre, String apellido, long dni, LocalDate fechaNacimiento, float estatura, float peso, String posicion, int camiseta) {
        int id = (jugadores.isEmpty()) ? 1 : jugadores.get(jugadores.size() - 1).getId() + 1;
        try {
            Jugador jugador = new Jugador(id, nombre, apellido, dni, fechaNacimiento, estatura, peso, posicion, camiseta);
            jugadores.add(jugador);
            return jugador;
        } catch (Exception e) {
            System.out.println("Excepción: " + e.getMessage());
            return null;
        }
    }

    public Entrenador agregarEntrenador(String nombre, String apellido, long dni, LocalDate fechaNacimiento, String estrategiaFavorita) {
        int id = (entrenadores.isEmpty()) ? 1 : entrenadores.get(entrenadores.size() - 1).getId() + 1;
        Entrenador entrenador = new Entrenador(id, nombre, apellido, dni, fechaNacimiento, estrategiaFavorita);
        entrenadores.add(entrenador);
        return entrenador;
    }

    public List<Entrenador> getEntrenadoresPorTactica(String tactica) throws Exception{
		List<Entrenador> entrenadores = new ArrayList<Entrenador>();
    	for(Entrenador actual : this.entrenadores) {
    		if (actual.getEstrategiaFavorita().equals(tactica)) {
    			entrenadores.add(actual);
    		}
    	}
		if (entrenadores.size() == 0) throw new Exception("Error: Tactica no valida");
		return entrenadores;
    }
    
    public List<Jugador> getJugadoresNacidosEntre(LocalDate inicio,LocalDate fin) throws Exception {
		List<Jugador> encontrados = new ArrayList<Jugador>();
    	for(Jugador actual: this.jugadores) {
    		if (actual.getFechaNacimiento().isAfter(inicio) && actual.getFechaNacimiento().isBefore(fin)) {
    			encontrados.add(actual);
    		}
    	}
		if (encontrados.size() == 0) throw new Exception("Error: Fechas no validas.");
		return encontrados;
    }
    
    public Entrenador traerEntrenadorPorId(int id) throws Exception {
        for (Entrenador e : entrenadores) {
            if (e.getId() == id) return e;
        }
        throw new Exception("Entrenador no encontrado.");
    }
    
    public Jugador traerJugadorPorId(int id) throws Exception {
        for (Jugador j : jugadores) {
            if (j.getId() == id) return j;
        }
        throw new Exception("Jugador no encontrado.");
    }
    
    public Equipo traerEquipoPorId(int id) throws Exception {
        for (Equipo eq : equipos) {
            if (eq.getId() == id) return eq;
        }
        throw new Exception("Equipo no encontrado.");
    }
    
    public Partido traerPartidoPorId(int id) throws Exception {
        for (Partido p : partidos) {
            if (p.getId() == id) return p;
        }
        throw new Exception("Partido no encontrado.");
    }
    
    public Torneo traerTorneoPorNombre(String nombre) throws Exception {
        for (Torneo t : torneos) {
            if (t.getNombre().equalsIgnoreCase(nombre)) return t;
        }
        throw new Exception("Torneo no encontrado.");
    }
    
}
