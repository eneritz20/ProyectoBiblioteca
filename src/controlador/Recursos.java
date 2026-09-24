package controlador;

public class Recursos {
	
	/*public void crear(int id, String titulo, Date año, boolean estado) throws ParseException, ExistenciaExcepcion, NumberFormatException {
        Contactos c;

        if (dao.getContacto(nombre) != null) {
            throw new ExistenciaExcepcion(true, nombre);
        }

        Integer tel = Integer.parseInt(tlf); //parseamos tlf. lo meto n una variablw pa meter esa varaible parseada a la instanciacion d los cntcts

        if (amigo) { //si es amigo true //AQUI SERIA PONER SI ESTA PRESTADO O NO
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy"); //dar mascara a feha
            Date fe = sdf.parse(fecha); //parseo d fecha d str a date
            c = new Amigos(nombre, tel, fe); //instanciamos amigo
        } else { //y aqui si amigo es false (empresa)
            c = new Profesionales(nombre, tel, empresa); //instanciamos pro
        }
        try {
            dao.insertar(c); //si todo bn lo metemos
        } catch (SQLException ex) {
            System.err.println("error: no se ha podido crear contacto");
        }
    }*/
	
	//---------------------------------------
	
	/*public void eliminar(String nombre) throws ExistenciaExcepcion {
        Contactos c = dao.borrar(nombre);
        //si todo bn lo metemos

        if (c == null) {
            throw new ExistenciaExcepcion(false, nombre);
            /*esta exception c pone abajo xq no puede comprobar si un contacto
            existe o no sin primero intentar quitar un contacto*/
        /*}
    }*/
	
	//---------------------------------------
	
	/*public void modificar(String n, String tlf, String f, String e) throws ParseException, ExistenciaExcepcion, NumberFormatException, SQLException {

        Contactos c = dao.getContacto(n);
        Date fecha = null;
        Integer tel = null;

        if (c == null) {
            throw new ExistenciaExcepcion(false, n);
        }

        if (tlf != null && !tlf.isEmpty()) {
            c.setTlf(tel = Integer.parseInt(tlf));
        }

        if (c instanceof Amigos) { //si contactos es amigos
            if (f != null && !f.isEmpty()) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy"); //le ponemos mascara a la fec
                ((Amigos) c).setFecha(fecha = sdf.parse(f)); //los contactos casteadso a amigos modifica la fecha mntras parsea el str fec
            }
        }

        if (c instanceof Profesionales) { //lo mismo q arriba
            if (e != null && !e.isEmpty()) {
                ((Profesionales) c).setEmpresa(e); //lo mismo q arriba pero n este caso mofidica la empresa
            }
        }

        dao.editar(n, tel, e, fecha);
    }*/
	
	//---------------------------------------
	
	/*public String buscar(String n) throws ExistenciaExcepcion {

        Contactos c = dao.getContacto(n); //coge el nombre d un contactos

        if (c == null) {
            throw new ExistenciaExcepcion(false, n);
        }

        return c.toString(); //retorna el tostring
        
        public ArrayList<String> getDatos(String nombre) { //pa q salgan los datos d los contactos. recibimos nombre de contacto
        ArrayList<String> datos = new ArrayList<>(); //array q va a contener los datos del contacto
        Contactos c = dao.getContacto(nombre); //recogemos el contacto
        datos.add(nombre);
        datos.add(c.getTlf().toString());
        
    }*/
	
	//---------------------------------------
	
	/*public String listar() throws Exception {
		//listado alfabeticamente x pantalla
		        ArrayList<Contactos> lista = dao.listar();//creamos arraylist lista pa guardar ahi el metodo del dao

		        if (lista.isEmpty()) {
		            throw new Exception("La agenda está vacía, no se pueden visualizar contactos.");
		        }

		        Collections.sort(lista); //ordena el array
		        String retorno = "";

		        for (Contactos c : lista) { //x cada contacto lo mete n el array
		            retorno += (c.toString() + "\n"); //al retorno le concadenamos el tostring
		        }

		        return retorno; //retorna
		    }
		    
		    public ArrayList<String> getNombres() { //pa q salgan los names d los contactos n la lista
        	ArrayList<String> nombres = new ArrayList<>(dao.getNombres());
        	Collections.sort(nombres);
        	return nombres;
    }
		    */
	
	
}
