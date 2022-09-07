package com.example.proyectodawfa.modelo.dao;

import com.example.proyectodawfa.modelo.clases.Oferta;
import com.example.proyectodawfa.modelo.clases.Usuario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class OfertasDAO {

	public static List<Oferta> seleccionarOfertas(){
		
		List<Oferta> listaOfertas= new ArrayList<Oferta>();
		ResultSet rs= null;
		try {
			EnlaceJDBC enlace= new EnlaceJDBC();
			String querySql= "select * from oferta";
			rs=enlace.seleccionRegistros(querySql);
			while (rs.next()) {
				listaOfertas.add(new Oferta(rs.getInt(1),rs.getString(2), LocalDate.parse(rs.getString(3)), LocalDate.parse(rs.getString(4)) ));
			}
					
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return listaOfertas;
	}
	
	
	public static List<Oferta> seleccionarOfertasUsuarios2(Usuario u) {
		List<Oferta> listaOfertas= new ArrayList<Oferta>();
		ResultSet rs= null;
		try {
			EnlaceJDBC enlace= new EnlaceJDBC();
			String querySql= "SELECT * from oferta, oferta_usuario, usuario "
					+ "WHERE usuario.nombre like '%"+u.getNombre()+"%' "
					+ "AND oferta.id_oferta = oferta_usuario.id_oferta "
					+ "AND usuario.id_usuario = oferta_usuario.id_usuario";
			rs=enlace.seleccionRegistros(querySql);
			while (rs.next()) {
				listaOfertas.add(new Oferta(rs.getInt(1),rs.getString(2), LocalDate.parse(rs.getString(3)), LocalDate.parse(rs.getString(4))));
			}
					
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return listaOfertas;
	}
	
	public static List<Oferta> seleccionarOfertasConUsuarios() {
		List<Oferta> listaOfertas= new ArrayList<Oferta>();
		ResultSet rs= null;
		try {
			EnlaceJDBC enlace= new EnlaceJDBC();
			listaOfertas=seleccionarOfertas(); //pillamos todas las ofertas
			String sql;
			List<Usuario> listaU= new ArrayList<Usuario>();
			for (Oferta o: listaOfertas) { //recorremos todas las ofertas
				listaU= new ArrayList<Usuario>();
				sql= "select * "
						+ "from usuario, oferta_usuario "
						+ "where usuario.id_usuario = oferta_usuario.id_usuario "
						+ "and oferta_usuario.id_oferta = "+ o.getIdOferta();	
				rs= enlace.seleccionRegistros(sql);
				while (rs.next()) {
					listaU.add(new Usuario(rs.getInt(1), rs.getString(2)));
				}
				o.setListaUsuarios(listaU); //asigno para cada oferta una lista de usuarios
			}
					
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return listaOfertas; //salida de lista de fiestas
	}
	
	public static void insertarOferta(Oferta o) {
		try {
			EnlaceJDBC enlace= new EnlaceJDBC();
			String sql= "insert into oferta values (0, '"+o.getNombreOferta()+"','"+o.getFechaInicio()+"','"+o.getFechaFinal()+"')";
			if (enlace.insertar(sql)) System.out.println("insertado");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void asociarFiestasMunicipios(Oferta o, List<Usuario> listaUsuariosAsociados) {
		try {
			EnlaceJDBC enlace= new EnlaceJDBC();
			for (Usuario u: listaUsuariosAsociados) {
				String sql= "insert into oferta_usuario values ("+u.getId_usuario()+", "+o.getIdOferta()+")";
				//System.out.println(sql);
				enlace.insertar(sql);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	
	
}
