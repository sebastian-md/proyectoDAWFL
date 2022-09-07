package com.example.proyectodawfa.modelo.clases;

public class Pedido {

	private int idPedido;
	private String nombrePedido;
	private String estado;
	private Usuario usuario;
	
	public Pedido() {
	}
	
	public Pedido(int idPedido, String nombrePedido) {
		super();
		this.idPedido = idPedido;
		this.nombrePedido = nombrePedido;
	}
	
	public Pedido(int idPedido, String nombrePedido, String estado, Usuario usuario) {
		super();
		this.idPedido = idPedido;
		this.nombrePedido = nombrePedido;
		this.estado = estado;
		this.usuario = usuario;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public String getNombrePedido() {
		return nombrePedido;
	}

	public void setNombrePedido(String nombrePedido) {
		this.nombrePedido = nombrePedido;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", nombrePedido=" + nombrePedido + ", estado=" + estado + ", usuario="
				+ usuario + "]";
	}
	
	
	
	
	
}
