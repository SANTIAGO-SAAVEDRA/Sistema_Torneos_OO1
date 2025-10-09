package modelo;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Jugador {
	private int id;
	private String nombre;
	private String apellido;
	private long dni;
	private LocalDate fechaNacimiento;
	private float estatura;
	private float peso;
	private String posicion;
	private int camiseta;
	private List<EstadisticaPartido> estadisticas = new ArrayList<EstadisticaPartido>();

	public Jugador(int id,String nombre, String apellido, long dni, LocalDate fechaNacimiento,float estatura,float peso,String posicion,int camiseta) throws Exception {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		if (calcularEdad(fechaNacimiento) < 18) {
			throw new Exception("El jugador debe ser mayor de edad");
	    }
		this.fechaNacimiento = fechaNacimiento;
		this.estatura = estatura;
		this.peso = peso;
		this.posicion = posicion;
		this.camiseta = camiseta;
	}
	
	public void agregarEstadistica(Partido partido, Equipo equipo, int goles, int asistencias, int minutosJugados) {
	    int id = (estadisticas.isEmpty()) ? 1 : estadisticas.get(estadisticas.size() - 1).getId() + 1;
	    EstadisticaPartido estadistica = new EstadisticaPartido(id, partido, equipo, goles, asistencias, minutosJugados);
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
	
	public float getEstatura() {
		return estatura;
	}
	public void setEstatura(float estatura) {
		this.estatura = estatura;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public String getPosicion() {
		return posicion;
	}
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	public int getCamiseta() {
		return camiseta;
	}
	public void setCamiseta(int camiseta) {
		this.camiseta = camiseta;
	}
	public int getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public long getDni() {
		return dni;
	}
	public void setDni(long dni) {
		this.dni = dni;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
    public static int calcularEdad(LocalDate nacimiento) {
        LocalDate hoy = LocalDate.now();
        /* Primero Calculo aproximadamente solo con el año, y
         * despues le resto 1, si corresponde.*/
        int edad = hoy.getYear() - nacimiento.getYear();
        
        if (hoy.getMonthValue() < nacimiento.getMonthValue() ||
           (hoy.getMonthValue() == nacimiento.getMonthValue() && 
            hoy.getDayOfMonth() < nacimiento.getDayOfMonth())) {
            edad--;
        }
        return edad;
    }
    
	@Override
	public String toString() {
		return super.toString()
				+ "\nEstatura: " + estatura + "m, peso: " + peso + "kg, posicion " + posicion + ", camiseta " + camiseta;
	}
}
