package com.example.proyectodawfa.modelo.dao;

import com.example.proyectodawfa.modelo.clases.Pedido;
import com.example.proyectodawfa.modelo.clases.Usuario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PedidosDAO {

	public static List<Pedido> seleccionarPedidos(){
		
		List<Pedido> listaPedidos= new ArrayList<Pedido>();
		ResultSet rs=null;
		try {
			EnlaceJDBC enlaceBD= new EnlaceJDBC();
			String consultaSQL= "select pedido.id_pedido, nombre_pedido, estado, usuario.id_usuario, usuario.nombre from usuario, pedido "
			+ "where usuario.id_usuario=pedido.id_usuario";
			rs=enlaceBD.seleccionRegistros(consultaSQL);
			while (rs.next()) {
				listaPedidos.add(new Pedido(rs.getInt(1), rs.getString(2), rs.getString(3), new Usuario(rs.getInt(4), rs.getString(5))));
			}
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		}
		return listaPedidos;
	}

	public static List<Pedido> seleccionarPedidosPorUsuario(String usuario){

		List<Pedido> listaPedidos= new ArrayList<Pedido>();
		ResultSet rs=null;
		try {
			EnlaceJDBC enlaceBD= new EnlaceJDBC();
			String consultaSQL= "select pedido.id_pedido, nombre_pedido, estado, usuario.id_usuario, usuario.nombre from usuario, pedido "
					+ "where usuario.id_usuario=pedido.id_usuario and usuario.nombre like '"+usuario+"' ";
			rs=enlaceBD.seleccionRegistros(consultaSQL);
			while (rs.next()) {
				listaPedidos.add(new Pedido(rs.getInt(1), rs.getString(2), rs.getString(3), new Usuario(rs.getInt(4), rs.getString(5))));
			}

		} catch (SQLException e) {

			System.out.println(e.getMessage());
		}
		return listaPedidos;
	}
	
	public static void insertarPedido(Pedido p) {
		
		int codigoU=0;
		try {
			EnlaceJDBC enlace= new EnlaceJDBC();
			
			//enviamos nombreUsuario q es lo unico q tenemos (para obtener idUsuario)
			codigoU = UsuariosDAO.seleccionarIdUsuario(p.getUsuario().getNombre());
			
			//xq da como correcto solo meter 1 atributo de Provincia? xq es para insertarlo en la BD
			String sql= "insert into pedido values (0, '"+ p.getNombrePedido() +"','"+ p.getEstado() + "',"+ codigoU +")";
			
			if (enlace.insertar(sql)) {
				System.out.println("La inserción del pedido "+ p.getNombrePedido() + " se ha realizado correctamente");
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
