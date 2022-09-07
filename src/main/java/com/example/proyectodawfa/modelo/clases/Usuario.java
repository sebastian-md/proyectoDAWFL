package com.example.proyectodawfa.modelo.clases;

public class Usuario implements Comparable<Usuario> {

	private int id_usuario;
	private String nombre;
	private String apellido;
	private String telefono;
	
	public Usuario() {
		
	}
	
	public Usuario( String nombre, String telefono) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
	}
	
	public Usuario(int id_usuario, String nombre) {
		super();
		this.id_usuario = id_usuario;
		this.nombre = nombre;
	}
	
	public Usuario(int id_usuario, String nombre, String apellido, String telefono) {
		super();
		this.id_usuario = id_usuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono="
				+ telefono + "]";
	}

	@Override
	public int compareTo(Usuario o) {
	
		int resul;
		
		if(this.getNombre().compareTo(o.getNombre())>0) {
			resul = 1;
		} else if (this.getNombre().compareTo(o.getNombre())<0) {
			resul = -1;
		} else {
			resul = 0;
		}
		
		return resul;
	}
	
	
}
