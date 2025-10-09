package modelo;
import java.time.LocalDate;

import java.util.List;
import java.util.ArrayList;

public class Torneo {
	private String nombre;
    private List<Equipo> equipos = new ArrayList<Equipo>();
    private List<Partido> partidos = new ArrayList<Partido>();
	private LocalDate inicio;
	private LocalDate fin;

	public Torneo(String nombre, LocalDate inicio, LocalDate fin) {
		this.nombre = nombre;
		this.inicio = inicio;
		this.fin = fin;
	}

	public List<Equipo> getEquipos() {
		return equipos;
	}
	public Equipo getEquipo(int id) throws Exception {
		Equipo encontrado = null;
		int actual = 0;
		while (encontrado == null && actual < equipos.size()) {
			if (equipos.get(actual).getId() == id) {
				encontrado = equipos.get(actual);
			}
			actual++;
		}
		if (encontrado == null) throw new Exception("Error: Equipo no encontrado");
		return encontrado;
	}
	public void agregarEquipo(Equipo equipo) {
		equipos.add(equipo);
	}
	
	public List<Partido> getPartidos() {
		return partidos;
	}
	public void agregarPartido(Partido partido) {
        partidos.add(partido);
    }
	public Partido getPartido(int id) throws Exception{
		Partido encontrado = null;
		int actual = 0;
		while (encontrado == null && actual < partidos.size()) {
			if (partidos.get(actual).getId() == id) {
				encontrado = partidos.get(actual);
			}
			actual++;
		}
		if (encontrado == null) throw new Exception("Error: Partido no encontrado");
		return encontrado;
	}

	public String getTemporada() {
		int mes = inicio.getMonthValue();
        int dia = inicio.getDayOfMonth();
        String temporada = "";
        if ((mes == 12 && dia >= 21) || (mes <= 3 && dia < 20)) {
            temporada = "Verano";
        } else if ((mes == 3 && dia >= 20) || (mes < 6 || (mes == 6 && dia < 21))) {
            temporada = "Otoño";
        } else if ((mes == 6 && dia >= 21) || (mes < 9 || (mes == 9 && dia < 23))) {
            temporada = "Invierno";
        } else {
        	temporada = "Primavera";
        }
        return temporada;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setInicio(LocalDate inicio) {
		this.inicio = inicio;
	}
	public LocalDate getInicio() {
		return inicio;
	}
	public LocalDate getFin() {
		return fin;
	}
	public void setFin(LocalDate fin) {
		this.fin = fin;
	}
	public List<Ganador> ganadoresEnFecha(LocalDate fecha) throws Exception{
		List<Ganador> ganadores = new ArrayList<Ganador>();
		boolean fechaValida = false;

		for (Partido actual : partidos) {
			if (actual.getFecha().isEqual(fecha)) {
				fechaValida = true;		
				try {
					Ganador ganador = Ganador.calcularGanador(actual);
					ganadores.add(ganador);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
		if (!fechaValida)
			throw new Exception("Error: En la fecha no hubieron partidos.");
		if (ganadores.size() == 0)
			throw new Exception("Error: No hay ganadores");
		return ganadores;
	}
	
	public void eliminarEquipo(int idEquipo) throws Exception {
	    boolean eliminado = false;
	    int i = 0;
	    while (!eliminado && i < equipos.size()) {
	        if (equipos.get(i).getId() == idEquipo) {
	            equipos.remove(i);
	            eliminado = true;
	        } else {
	            i++;
	        }
	    }
	    if (!eliminado) throw new Exception("Error: Equipo no encontrado en el torneo.");
	}
	public Equipo equipoConMayorAlturaPromedio() throws Exception {
	    if (equipos.isEmpty()) {
	        throw new Exception("El torneo no tiene equipos cargados.");
	    }

	    Equipo mayor = equipos.get(0);
	    float maxPromedio = mayor.calcularAlturaPromedio();

	    for (Equipo e : equipos) {
	        float promedioActual = e.calcularAlturaPromedio();
	        if (promedioActual > maxPromedio) {
	            maxPromedio = promedioActual;
	            mayor = e;
	        }
	    }

	    return mayor;
	}

	public int calcularPuntosEquipo(Equipo equipo) throws Exception {
	    int puntos = 0;
	    if (partidos.isEmpty()) {
	        throw new Exception("No hay partidos registrados en el torneo.");
	    }

	    for (Partido p : partidos) {
	        int[] goles = p.calcularGoles();

	        if (p.getLocal() == equipo) {
	            if (goles[0] > goles[1]) puntos += 3; // gana local
	            else if (goles[0] == goles[1]) puntos += 1; // empate
	        } else if (p.getVisitante() == equipo) {
	            if (goles[1] > goles[0]) puntos += 3; // gana visitante
	            else if (goles[1] == goles[0]) puntos += 1; // empate
	        }
	    }

	    return puntos;
	}
}
