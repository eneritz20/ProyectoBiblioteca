package ficheros_eneritz;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ficheros {
private static final String FICHERO_USUARIOS = "usuarios.csv";
private static final String FICHERO_RECURSOS = "recursos.csv";
private static final String FICHERO_PRESTAMOS = "prestamos.csv";

public static void guardarDatos(List<Usuario> usuarios, List<Recurso> recursos, List<Prestamo> prestamos) {
try (PrintWriter pw = new PrintWriter(new FileWriter(FICHERO_USUARIOS))) {
for (Usuario u : usuarios) {
pw.println(u.getId() + ";" + u.getNombre() + ";" + u.getCorreo());
}
} catch (IOException e) { System.out.println("Error al guardar usuarios: " + e.getMessage()); }

try (PrintWriter pw = new PrintWriter(new FileWriter(FICHERO_RECURSOS))) {
for (Recurso r : recursos) {
if (r instanceof Libro) {
Libro l = (Libro) r;
pw.println("LIBRO;" + l.getId() + ";" + l.getTitulo() + ";" + l.getAno() + ";" + l.isDisponible() + ";" + l.getAutor() + ";" + l.getPaginas());
} else if (r instanceof Pelicula) {
Pelicula p = (Pelicula) r;
pw.println("PELICULA;" + p.getId() + ";" + p.getTitulo() + ";" + p.getAno() + ";" + p.isDisponible() + ";" + p.getDirector() + ";" + p.getDuracionMinutos());
} else if (r instanceof Videojuego) {
Videojuego v = (Videojuego) r;
pw.println("VIDEOJUEGO;" + v.getId() + ";" + v.getTitulo() + ";" + v.getAno() + ";" + v.isDisponible() + ";" + v.getPlataforma() + ";" + v.getPegi());
}
}
} catch (IOException e) { System.out.println("Error al guardar recursos: " + e.getMessage()); }

try (PrintWriter pw = new PrintWriter(new FileWriter(FICHERO_PRESTAMOS))) {
for (Prestamo p : prestamos) {
pw.println(p.getIdUsuario() + ";" + p.getIdRecurso() + ";" + p.getFechaPrestamo() + ";" + p.getFechaDevolucion() + ";" + p.isActivo());
}
} catch (IOException e) { System.out.println("Error al guardar préstamos: " + e.getMessage()); }
}

public static void cargarDatos(List<Usuario> usuarios, List<Recurso> recursos, List<Prestamo> prestamos) {
File fU = new File(FICHERO_USUARIOS);
if (fU.exists()) {
try (BufferedReader br = new BufferedReader(new FileReader(fU))) {
String linea;
while ((linea = br.readLine()) != null) {
String[] partes = linea.split(";");
if (partes.length == 3) {
usuarios.add(new Usuario(partes[0], partes[1], partes[2]));
}
}
} catch (IOException e) { System.out.println("Error cargando usuarios."); }
}

File fR = new File(FICHERO_RECURSOS);
if (fR.exists()) {
try (BufferedReader br = new BufferedReader(new FileReader(fR))) {
String linea;
while ((linea = br.readLine()) != null) {
String[] partes = linea.split(";");
if (partes.length >= 7) {
String tipo = partes[0];
String id = partes[1];
String titulo = partes[2];
int ano = Integer.parseInt(partes[3]);
boolean disponible = Boolean.parseBoolean(partes[4]);
Recurso r = null;
if (tipo.equals("LIBRO")) {
r = new Libro(id, titulo, ano, partes[5], Integer.parseInt(partes[6]));
} else if (tipo.equals("PELICULA")) {
r = new Pelicula(id, titulo, ano, partes[5], Integer.parseInt(partes[6]));
} else if (tipo.equals("VIDEOJUEGO")) {
r = new Videojuego(id, titulo, ano, partes[5], partes[6]);
}
if (r != null) {
r.setDisponible(disponible);
recursos.add(r);
}
}
}
} catch (Exception e) { System.out.println("Error cargando recursos."); }
}

File fP = new File(FICHERO_PRESTAMOS);
if (fP.exists()) {
try (BufferedReader br = new BufferedReader(new FileReader(fP))) {
String linea;
while ((linea = br.readLine()) != null) {
String[] partes = linea.split(";");
if (partes.length == 5) {
prestamos.add(new Prestamo(partes[0], partes[1], partes[2], partes[3], Boolean.parseBoolean(partes[4])));
}
}
} catch (IOException e) { System.out.println("Error cargando préstamos."); }
}
}
}