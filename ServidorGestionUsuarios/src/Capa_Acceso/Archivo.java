package Capa_Acceso;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Archivo 
{
	private BufferedWriter archivoEscritura;
	private BufferedReader archivoLectura;
	
	public void abrirArchivo(String nombre, boolean escritura, boolean sobreescribir)
			throws IOException
	{
		if (escritura)
			this.archivoEscritura = new BufferedWriter(new FileWriter(nombre, sobreescribir));
		else
			this.archivoLectura = new BufferedReader(new FileReader(nombre));
	}
	
	public void escribirArchivo(String datos)
			throws IOException
	{
		archivoEscritura.write(datos);
		archivoEscritura.newLine();
	}
	
	public String leerArchivo()
			throws IOException
	{
		return archivoLectura.readLine();
	}
	
	public void cerrarArchivo()
			throws IOException
	{
		if(archivoEscritura != null)
			archivoEscritura.close();
		if(archivoLectura != null)
			archivoLectura.close();
	}
	
	public boolean puedeLeer()
			throws IOException
	{
		return archivoLectura.ready();
	}
	
	public String[] leerPalabras(int cantidad)
	{
		String[] palabras = new String[cantidad];
		int i = 0;
		try
		{
			while(this.puedeLeer() && i < cantidad)
			{
				palabras[i] = this.leerArchivo();
				i++;
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return palabras;
	}
	
	public int contarLineas(String nombre)
			throws IOException
	{
		abrirArchivo(nombre ,false, true);
		int lineas = 0;
		while(puedeLeer())
		{
			leerArchivo();
			lineas++;
		}
		return lineas;
	}
}
