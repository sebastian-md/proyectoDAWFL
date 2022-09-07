package com.example.proyectodawfa.modelo.ficheros;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class EscrituraFichero {

	public static void escribirFicheroCompleto(String fichero, List<String> contenido) { //llega por parametro fichero y contenido
		
		Path salida = Paths.get(fichero); //path que agarra fichero
		Charset charset = StandardCharsets.UTF_8;
		
		try {
			Files.write(salida, contenido, charset); // en el path salida, escribe el contenido, en charset UTF_8 
		} catch (IOException io) {
			System.err.println(io);
		}
		
	}
	
}
