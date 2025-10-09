package modelo;

import java.time.LocalDate;

public class Ganador {
	LocalDate fecha;
	Equipo ganador;
	int goles;

	public Ganador(LocalDate fecha, Equipo ganador, int goles) {
		super();
		this.fecha = fecha;
		this.ganador = ganador;
		this.goles = goles;
	}

	public static Ganador calcularGanador(Partido partido) throws Exception {
		int[] golesPartido = partido.calcularGoles();
		int golesGanador = 0;
		Equipo equipoGanador = null;
		if (golesPartido[0] > golesPartido[1]) {
			equipoGanador = partido.getLocal();
			golesGanador = golesPartido[0];
		} else if (golesPartido[1] > golesPartido[0]) {
			equipoGanador = partido.getVisitante();
			golesGanador = golesPartido[1];
		}

		if (equipoGanador == null)
			throw new Exception("Error: No hay ganador");

		Ganador ganador = new Ganador(partido.getFecha(), equipoGanador, golesGanador);
		return ganador;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Equipo getGanador() {
		return ganador;
	}

	public void setGanador(Equipo ganador) {
		this.ganador = ganador;
	}

	public int getGoles() {
		return goles;
	}

	public void setGoles(int goles) {
		this.goles = goles;
	}

}