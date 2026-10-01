package ficheros_eneritz;

import java.io.*;
import java.util.Date;
import java.util.List;

import modelo.Libro;
import modelo.Pelicula;
import modelo.Prestamo;
import modelo.Recurso;
import modelo.Usuario;
import modelo.Videojuego;

public class ficheros {

    private static final String FICHERO_USUARIOS = "usuarios.csv";
    private static final String FICHERO_RECURSOS = "recursos.csv";
    private static final String FICHERO_PRESTAMOS = "prestamos.csv";

    // ---------------------------------------------------------
    // GUARDAR DATOS
    // ---------------------------------------------------------
    public static void guardarDatos(List<Usuario> usuarios, List<Recurso> recursos, List<Prestamo> prestamos) {

        // GUARDAR USUARIOS
        try (PrintWriter pw = new PrintWriter(new FileWriter(FICHERO_USUARIOS))) {
            for (Usuario u : usuarios) {
                pw.println(u.getId() + ";" + u.getNombre() + ";" + u.getCorreo());
            }
        } catch (IOException e) {
            System.out.println("Error al guardar usuarios: " + e.getMessage());
        }

        // GUARDAR RECURSOS
        try (PrintWriter pw = new PrintWriter(new FileWriter(FICHERO_RECURSOS))) {
            for (Recurso r : recursos) {

                if (r instanceof Libro l) {
                    pw.println("LIBRO;" + l.getId() + ";" + l.getTitulo() + ";" +
                               l.getAnio() + ";" + l.isDisponible() + ";" +
                               l.getAutor() + ";" + l.getPaginas());
                }

                else if (r instanceof Pelicula p) {
                    pw.println("PELICULA;" + p.getId() + ";" + p.getTitulo() + ";" +
                               p.getAnio() + ";" + p.isDisponible() + ";" +
                               p.getDirector() + ";" + p.getDuracionMinutos());
                }

                else if (r instanceof Videojuego v) {
                    pw.println("VIDEOJUEGO;" + v.getId() + ";" + v.getTitulo() + ";" +
                               v.getAnio() + ";" + v.isDisponible() + ";" +
                               v.getPlataforma() + ";" + v.getPegi());
                }
            }
        } catch (IOException e) {
            System.out.println("Error al guardar recursos: " + e.getMessage());
        }

        // GUARDAR PRESTAMOS
        try (PrintWriter pw = new PrintWriter(new FileWriter(FICHERO_PRESTAMOS))) {
            for (Prestamo p : prestamos) {

                long fechaPrestamo = p.getFechaPrestamo() != null ? p.getFechaPrestamo().getTime() : -1;
                long fechaDevolucion = p.getFechaDevolucion() != null ? p.getFechaDevolucion().getTime() : -1;

                pw.println(p.getUsuario() + ";" + p.getRecurso() + ";" +
                           fechaPrestamo + ";" + p.getEstado() + ";" +
                           fechaDevolucion);
            }
        } catch (IOException e) {
            System.out.println("Error al guardar préstamos: " + e.getMessage());
        }
    }

    // ---------------------------------------------------------
    // CARGAR DATOS
    // ---------------------------------------------------------
    public static void cargarDatos(List<Usuario> usuarios, List<Recurso> recursos, List<Prestamo> prestamos) {

        // CARGAR USUARIOS
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
            } catch (IOException e) {
                System.out.println("Error cargando usuarios.");
            }
        }

        // CARGAR RECURSOS
        File fR = new File(FICHERO_RECURSOS);
        if (fR.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(fR))) {
                String linea;
                while ((linea = br.readLine()) != null) {

                    String[] partes = linea.split(";");
                    if (partes.length < 7) continue;

                    String tipo = partes[0];
                    String id = partes[1];
                    String titulo = partes[2];
                    int anio = Integer.parseInt(partes[3]);
                    boolean disponible = Boolean.parseBoolean(partes[4]);

                    Recurso r = null;

                    switch (tipo) {
                        case "LIBRO":
                            r = new Libro(id, titulo, anio, partes[5], Integer.parseInt(partes[6]));
                            break;

                        case "PELICULA":
                            r = new Pelicula(id, titulo, anio, partes[5], Integer.parseInt(partes[6]));
                            break;

                        case "VIDEOJUEGO":
                            r = new Videojuego(id, titulo, anio, partes[5], partes[6]);
                            break;
                    }

                    if (r != null) {
                        r.setDisponible(disponible);
                        recursos.add(r);
                    }
                }
            } catch (Exception e) {
                System.out.println("Error cargando recursos.");
            }
        }

        // CARGAR PRESTAMOS
        File fP = new File(FICHERO_PRESTAMOS);
        if (fP.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(fP))) {
                String linea;
                while ((linea = br.readLine()) != null) {

                    String[] partes = linea.split(";");

                    if (partes.length == 5) {

                        String usuario = partes[0];
                        String recurso = partes[1];

                        long fechaPrestamoLong = Long.parseLong(partes[2]);
                        Date fechaPrestamo = fechaPrestamoLong == -1 ? null : new Date(fechaPrestamoLong);

                        String estado = partes[3];

                        long fechaDevolucionLong = Long.parseLong(partes[4]);
                        Date fechaDevolucion = fechaDevolucionLong == -1 ? null : new Date(fechaDevolucionLong);

                        prestamos.add(new Prestamo(usuario, recurso, fechaPrestamo, estado, fechaDevolucion));
                    }
                }
            } catch (IOException e) {
                System.out.println("Error cargando préstamos.");
            }
        }
    }
}
