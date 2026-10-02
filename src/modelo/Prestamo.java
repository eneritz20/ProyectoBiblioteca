package modelo;

import java.util.Date;

public class Prestamo {

	private String usuario;
	private String recurso;
	private Date fechaPrestamo;
	private String estado;
	private Date FechaDevolucion;

	public Prestamo(String usuario, String recurso, Date fechaPrestamo, String estado, Date fechaDevolucion) {
		super();
		this.usuario = usuario;
		this.recurso = recurso;
		this.fechaPrestamo = fechaPrestamo;
		this.estado = estado;
		FechaDevolucion = fechaDevolucion;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getRecurso() {
		return recurso;
	}

	public void setRecurso(String recurso) {
		this.recurso = recurso;
	}

	public Date getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(Date fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaDevolucion() {
		return FechaDevolucion;
	}

	public void setFechaDevolucion(Date fechaDevolucion) {
		FechaDevolucion = fechaDevolucion;
	}
	
	@Override
	public String toString() {
		java.text.SimpleDateFormat formato = new java.text.SimpleDateFormat("dd/MM/yyyy");
		String devolucion = (FechaDevolucion == null) ? "-" : formato.format(FechaDevolucion);
		return "Usuario: " + usuario + " | Recurso: " + recurso + " | Préstamo: " + formato.format(fechaPrestamo)
				+ " | Estado: " + estado + " | Devolución: " + devolucion;
	}

}
