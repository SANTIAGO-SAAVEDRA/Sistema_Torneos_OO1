package modelo;

import java.time.LocalDate;

public class Entrenador {

	private int id;
	private String estrategiaFavorita;
	private String nombre;
	private String apellido;
	private long dni;
	private LocalDate fechaNacimiento;
	
	public Entrenador(int id, String nombre, String apellido, long dni,
			LocalDate fechaNacimiento,String estrategiaFavorita) {
		super();
		this.estrategiaFavorita = estrategiaFavorita;
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getEstrategiaFavorita() {
		return estrategiaFavorita;
	}
	public void setEstrategiaFavorita(String estrategiaFavorita) {
		this.estrategiaFavorita = estrategiaFavorita;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
}
