package com.example.proyectodawfa.modelo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.proyectodawfa.modelo.clases.Usuario;

public class UsuariosDAO {

	public static List<Usuario> seleccionarUsuarios(){
		
		List <Usuario> listaUsuarios = new ArrayList<Usuario>();
		
		ResultSet rs=null;
		try {
			EnlaceJDBC enlaceBD= new EnlaceJDBC();
			String consultaSQL= "select * from usuario ";
			rs=enlaceBD.seleccionRegistros(consultaSQL);
			while (rs.next()) {
				listaUsuarios.add(new Usuario(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4)));
			}
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		}
		return listaUsuarios;
	}
	
	public static List<Usuario> seleccionarUsuariosC(String l){
		
		List <Usuario> listaUsuarios = new ArrayList<Usuario>();
		
		ResultSet rs=null;
		try {
			EnlaceJDBC enlaceBD= new EnlaceJDBC();
			String consultaSQL= "select * from usuario where nombre like '"+l+"%' ";
			rs=enlaceBD.seleccionRegistros(consultaSQL);
			while (rs.next()) {
				listaUsuarios.add(new Usuario(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4)));
			}
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		}
		
		return listaUsuarios;
		
	}
	
	public static List<Usuario> seleccionarUsuariosTrayendoNombre(String n){
		
		List <Usuario> listaUsuarios = new ArrayList<Usuario>();
		
		ResultSet rs=null;
		try {
			EnlaceJDBC enlaceBD= new EnlaceJDBC();
			String consultaSQL= "select * from usuario where nombre='"+n+"' ";
			rs=enlaceBD.seleccionRegistros(consultaSQL);
			while (rs.next()) {
				listaUsuarios.add(new Usuario(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4)));
			}
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		}
		
		return listaUsuarios;
		
	}
	
	public static void insertarUsuario(Usuario u) {
		
		try {
			EnlaceJDBC enlace= new EnlaceJDBC();
			String sql= "insert into usuario values(0,'"+u.getNombre()+"','"+u.getApellido()+"','"+u.getTelefono()+"')";
			if (enlace.insertar(sql)) {
				System.out.println("La insercion de "+ u.getNombre() + " se ha realizado correctamente");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static int seleccionarIdUsuario(String nombre) {
		
		int codigo=0;
		ResultSet rs=null;
		try {
			EnlaceJDBC enlaceBD= new EnlaceJDBC();
			String consultaSQL= "select id_usuario from usuario where nombre like '"+nombre+"'";
			rs=enlaceBD.seleccionRegistros(consultaSQL);
			if (rs.next()) {
				codigo=rs.getInt(1);
			}
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		}
			
		return codigo;
		
	}
	

	
}
