package com.example.proyectodawfa.modelo.ficheros;

import java.util.List;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class LecturaFichero {

	public static List<String> lecturaCompletaLineas(String fichero, Charset charset){
		
		Path file = Paths.get(fichero);
		List<String> fileLista = null; // creamos lista vacia
		
		try {
			fileLista = Files.readAllLines(file, charset);
		} catch(IOException io) {
			System.err.println(io);
		}
		
		return fileLista; //devuelve lineas leidas
		
	}
	
}
