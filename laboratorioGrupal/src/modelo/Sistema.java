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
    
    public EstadisticaPartido agregarEstadistica(Partido partido, Equipo equipo,Jugador jugador, int goles, int asistencias, int minutosJugados) {
        int id = (estadisticas.isEmpty()) ? 1 : estadisticas.get(estadisticas.size() - 1).getId() + 1;
        EstadisticaPartido estadistica = new EstadisticaPartido(id, partido,equipo, jugador, goles, asistencias, minutosJugados);
        if (estadisticas.add(estadistica)) {
        	partido.agregarEstadistica(estadistica);
        	jugador.agregarEstadistica(estadistica);
        }
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
        Equipo agregado = null;
        try {
            Equipo equipo = new Equipo(id, nombre, entrenador, fechaCreacion);
            if(equipos.add(equipo))
            	agregado = equipo;
        } catch (Exception e) {
            System.out.println("Excepción: " + e.getMessage());
        }
        return agregado;
    }
    public Jugador agregarJugador(String nombre, String apellido, long dni, LocalDate fechaNacimiento, float estatura, float peso, String posicion, int camiseta) {
        int id = (jugadores.isEmpty()) ? 1 : jugadores.get(jugadores.size() - 1).getId() + 1;
        Jugador agregado = null;
        try {
            Jugador jugador = new Jugador(id, nombre, apellido, dni, fechaNacimiento, estatura, peso, posicion, camiseta);
            if (jugadores.add(jugador))
            	agregado = jugador;
        } catch (Exception e) {
            System.out.println("Excepción: " + e.getMessage());
        }
        return agregado;
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
		if (entrenadores.isEmpty())
			throw new Exception("Error: Tactica no valida");
		return entrenadores;
    }

    public Entrenador traerEntrenadorPorId(int id) throws Exception {
    	Entrenador encontrado = null;
    	for (Entrenador e : entrenadores) {
            if (e.getId() == id)
            	encontrado = e;
        }
        if (encontrado == null)
        	throw new Exception("Entrenador no encontrado.");
        return encontrado;
    }
    
    public Jugador traerJugadorPorId(int id) throws Exception {
    	Jugador encontrado = null;
    	for (Jugador j : jugadores) {
            if (j.getId() == id)
            	encontrado = j;
        }
        if (encontrado == null)
        	throw new Exception("Jugador no encontrado.");
        return encontrado;
    }
    
    public Equipo traerEquipoPorId(int id) throws Exception {
    	Equipo encontrado = null;
    	for (Equipo eq : equipos) {
            if (eq.getId() == id)
            	encontrado = eq;
        }
        if (encontrado == null)
        	throw new Exception("Equipo no encontrado.");
        return encontrado;
    }
    
    public Partido traerPartidoPorId(int id) throws Exception {
    	Partido encontrado = null;
        for (Partido p : partidos) {
            if (p.getId() == id)
            	encontrado = p;
        }
        if (encontrado == null)
        	throw new Exception("Partido no encontrado.");
        return encontrado;
    }
    
    public Torneo traerTorneoPorNombre(String nombre) throws Exception {
    	Torneo encontrado = null;
        for (Torneo t : torneos) {
            if (t.getNombre().equalsIgnoreCase(nombre))
            	encontrado = t;
        }
        if (encontrado == null)
        	throw new Exception("Torneo no encontrado.");
        return encontrado;
    }
    
    public List<Jugador> buscarJugadoresNacidosEntre(LocalDate inicio, LocalDate fin) throws Exception {
        List<Jugador> encontrados = new ArrayList<>();

        for (Jugador j : jugadores) {
        	if (j.getFechaNacimiento().isAfter(inicio) && j.getFechaNacimiento().isBefore(fin)) {
                encontrados.add(j);
            }
        }

        if (encontrados.isEmpty()) {
            throw new Exception("No se encontraron jugadores nacidos entre esas fechas.");
        }

        return encontrados;
    }

    public List<Equipo> buscarEquiposFundadosAntesDe(LocalDate fecha) throws Exception {
        List<Equipo> encontrados = new ArrayList<>();

        for (Equipo e : equipos) {
            if (e.getFechaCreacion().isBefore(fecha)) {
                encontrados.add(e);
            }
        }

        if (encontrados.isEmpty()) {
            throw new Exception("No se encontraron equipos fundados antes de la fecha indicada.");
        }

        return encontrados;
    }

	public List<Torneo> getTorneos() {
		return torneos;
	}

	public void setTorneos(List<Torneo> torneos) {
		this.torneos = torneos;
	}

	public List<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public List<Entrenador> getEntrenadores() {
		return entrenadores;
	}

	public void setEntrenadores(List<Entrenador> entrenadores) {
		this.entrenadores = entrenadores;
	}

	public List<Partido> getPartidos() {
		return partidos;
	}

	public void setPartidos(List<Partido> partidos) {
		this.partidos = partidos;
	}

	public List<EstadisticaPartido> getEstadisticas() {
		return estadisticas;
	}

	public void setEstadisticas(List<EstadisticaPartido> estadisticas) {
		this.estadisticas = estadisticas;
	}

}
