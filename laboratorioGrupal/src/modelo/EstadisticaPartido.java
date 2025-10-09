package modelo;

public class EstadisticaPartido {
	private int id;
	private Equipo equipo;
	private Jugador jugador;
	private int goles;
	private int asistencias;
	private int minutosJugados;
	private Partido partido;
	
	public EstadisticaPartido(int id,Partido partido,Equipo equipo, int goles, int asistencias, int minutosJugados) {
		this.id = id;
		this.setPartido(partido);
		this.equipo = equipo;
		this.goles = goles;
		this.asistencias = asistencias;
		this.minutosJugados = minutosJugados;
	}
	public Jugador getJugador() {
		return jugador;
	}
	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	public void setGoles(int goles) {
		this.goles = goles;
	}
	public void setAsistencias(int asistencias) {
		this.asistencias = asistencias;
	}
	public void setMinutosJugados(int minutosJugados) {
		this.minutosJugados = minutosJugados;
	}
	public Equipo getEquipo() {
		return equipo;
	}
	public int getGoles() {
		return goles;
	}
	public int getAsistencias() {
		return asistencias;
	}
	public int getMinutosJugados() {
		return minutosJugados;
	}
	public Partido getPartido() {
		return partido;
	}
	public void setPartido(Partido partido) {
		this.partido = partido;
	}
}
