package com.example.proyectodawfa.modelo.clases;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Oferta {

	private int idOferta;
	private String nombreOferta;
	private LocalDate fechaInicio;
	private LocalDate fechaFinal;
	private List<Usuario> listaUsuarios;
	
	
	public Oferta() {
		super();
		this.listaUsuarios = new ArrayList<Usuario>();
	}
	
	public Oferta(int idOferta, String nombreOferta) {
		super();
		this.idOferta = idOferta;
		this.nombreOferta = nombreOferta;
	}
	
	public Oferta(int idOferta, String nombreOferta, LocalDate fechaInicio, LocalDate fechaFinal) {
		super();
		this.idOferta = idOferta;
		this.nombreOferta = nombreOferta;
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
	}

	public Oferta(int idOferta, String nombreOferta, LocalDate fechaInicio, LocalDate fechaFinal,
			List<Usuario> listaUsuarios) {
		super();
		this.idOferta = idOferta;
		this.nombreOferta = nombreOferta;
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
		this.listaUsuarios = listaUsuarios;
	}

	public int getIdOferta() {
		return idOferta;
	}

	public void setIdOferta(int idOferta) {
		this.idOferta = idOferta;
	}

	public String getNombreOferta() {
		return nombreOferta;
	}

	public void setNombreOferta(String nombreOferta) {
		this.nombreOferta = nombreOferta;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(LocalDate fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	//getter-setter para agregar Usuarios
	public void addUsuarioOferta(Usuario usuario) {
		this.listaUsuarios.add(usuario);
	}
	
	@Override
	public String toString() {
		return "Oferta [idOferta=" + idOferta + ", nombreOferta=" + nombreOferta + ", fechaInicio=" + fechaInicio
				+ ", fechaFinal=" + fechaFinal + ", listaUsuarios=" + listaUsuarios + "]";
	}


	
	
	
	
}
