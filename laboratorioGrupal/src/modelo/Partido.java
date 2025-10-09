package modelo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Partido {
	private int id;
	private LocalDate fecha;
	Equipo local;
	Equipo visitante;
	String estadio;
	private List<EstadisticaPartido> estadisticas = new ArrayList<EstadisticaPartido>();
	
	public Partido(int id,LocalDate fecha, Equipo local, Equipo visitante, String estadio) {
		this.id = id;
		this.fecha = fecha;
		this.local = local;
		this.visitante = visitante;
		this.estadio = estadio;
	}
	
	public void agregarEstadistica(EstadisticaPartido estadistica) {
		estadisticas.add(estadistica);
	}

	public EstadisticaPartido getEstadistica(int id) throws Exception {
		EstadisticaPartido encontrado = null;
		int actual = 0;
		while (encontrado == null && actual < estadisticas.size()) {
			if (estadisticas.get(actual).getId() == id) {
				encontrado = estadisticas.get(actual);
			}
			actual++;
		}
		if (encontrado == null) throw new Exception("Error: Estadistica no encontrado");
		return encontrado;
	}
	

	public void setEstadisticas(List<EstadisticaPartido> estadisticas) {
		this.estadisticas = estadisticas;
	}
	public List<EstadisticaPartido> getEstadisticas(){
		return estadisticas;
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public void setLocal(Equipo local) {
		this.local = local;
	}
	public void setVisitante(Equipo visitante) {
		this.visitante = visitante;
	}
	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public Equipo getLocal() {
		return local;
	}
	public Equipo getVisitante() {
		return visitante;
	}
	public String getEstadio() {
		return estadio;
	}
	public int[] calcularGoles() {
		/* Retorna los goles del equipo local en el indice 0 y
		 * Retorna los goles del equipo visitante en el indice 1
		 * */
		List<EstadisticaPartido> estadisticas = this.getEstadisticas();
		
		int golesLocal = 0;
		int golesVisitante = 0;
		int indice = 0;
		
		while (indice < estadisticas.size()) {
			EstadisticaPartido actual = estadisticas.get(indice);
			if (actual.getEquipo() == this.local) {
				golesLocal+=actual.getGoles();
			} else {
				golesVisitante+=actual.getGoles();
			}
			indice++;
		}
		int[] goles = { golesLocal , golesVisitante };
		return goles;
	}
}
