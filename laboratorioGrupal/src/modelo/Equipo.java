package modelo;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

public class Equipo {
	private int id;
    private String nombre;
    private String abreviatura;
    private Entrenador entrenador;
    private LocalDate fechaCreacion;
    private List<Jugador> jugadores = new ArrayList<Jugador>();

    public Equipo(int id,String nombre, Entrenador entrenador,LocalDate fechaCreacion) throws Exception {
    	this.nombre = nombre;
    	setAbreviatura();
    	this.id = id;
        this.entrenador = entrenador;
        this.fechaCreacion=fechaCreacion;
    }
    public int getId() {
    	return id;
    }
	public void setId(int id) {
		this.id = id;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}
	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void agregarJugador(Jugador jugador){
		jugadores.add(jugador);
	}

	public Jugador getJugador(int id) throws Exception {
		Jugador encontrado = null;
		int actual = 0;
		while (encontrado == null && actual < jugadores.size()) {
			if (jugadores.get(actual).getId() == id) {
				encontrado = jugadores.get(actual);
			}
			actual++;
		}
		if (encontrado == null) throw new Exception("Error: Jugador no encontrado");
		return encontrado;
	}
	
	public void eliminarJugador(int id) throws Exception {
		boolean removido = false;
		int actual = 0;
		while (!removido && actual < jugadores.size()) {
			if (jugadores.get(actual).getId() == id) {		
				jugadores.remove(jugadores.get(actual));
				removido = true;
			}
			actual++;
		}
		if (!removido) throw new Exception("Error: Jugador no eliminado");
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAbreviatura() {
		return abreviatura;
	}
	public void setAbreviatura() throws Exception {
		String abreviatura = nombre.substring(0, 3);
        if (abreviatura == null || abreviatura.length() != 3) {
            throw new Exception("La abreviatura del equipo debe tener 3 caracteres");
        }
        this.abreviatura = abreviatura.toUpperCase();
    }
	public Entrenador getEntrenador() {
		return entrenador;
	}
	public void setEntrenador(Entrenador entrenador) {
		this.entrenador = entrenador;
	}
	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public float calcularAlturaPromedio() throws Exception {
	    if (jugadores.isEmpty()) {
	        throw new Exception("El equipo no tiene jugadores para calcular el promedio.");
	    }

	    float totalAltura = 0;
	    for (Jugador j : jugadores) {
	        totalAltura += j.getEstatura();
	    }

	    return totalAltura / jugadores.size();
	}

	
	
}
