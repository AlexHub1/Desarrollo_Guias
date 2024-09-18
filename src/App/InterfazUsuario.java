package App;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class InterfazUsuario {

    private GestionMuestras gestionMuestras;

    public InterfazUsuario(GestionMuestras gestionMuestras) {
        this.gestionMuestras = gestionMuestras;
    }

    public void iniciar() {

        while (true) {
            String opcion = JOptionPane.showInputDialog(
                    "1.Agregar Muestra \n"
                    + "2.Eliminar Muestra \n"
                    + "3.Buscar Muestra \n"
                    + "4.Mostrar todas las muestra \n"
                    + "5.Exportar Muestra \n"
                    + "6.Salir \n"
                    + "Seleccione una opcion \n");

            if (opcion == null || opcion.equals("6")) {
                break;
            }
            switch (opcion) {
                case "1":
                    agregarMuestra();
                    break;
                case "2":
                    eliminarMuestra();
                    break;
                case "3":
                    buscarMuestra();
                    break;
                case "4":
                    gestionMuestras.mostrarMuestras();
                    break;
                case "5":
                    exportarMuestras();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion invalida");
                    break;
            }
        }
    }

    private void agregarMuestra() {

        String idMuestra = JOptionPane.showInputDialog("Ingrese ID de la muestra: ");
        String tipoMuestra = JOptionPane.showInputDialog("Ingrese tipo de la muestra: ");
        String fechaRecoleccion;

        do {
            fechaRecoleccion = JOptionPane.showInputDialog("Ingrese fecha de recoleccion: (dd-mm-aaaa)");
            if (!validarFecha(fechaRecoleccion)) {
                JOptionPane.showMessageDialog(null, "Formato fecha Invalido ");
            }
        } while (!validarFecha(fechaRecoleccion));
        Muestra nuevaMuestra = new Muestra(idMuestra, tipoMuestra, fechaRecoleccion);
        gestionMuestras.agregarMuestra(nuevaMuestra);

    }

    private void eliminarMuestra() {

        String idEliminar = JOptionPane.showInputDialog("Ingrese ID de la muestra a eliminar: ");
        gestionMuestras.eliminarMuestra(idEliminar);
    }

    private void buscarMuestra() {

        String idBuscar = JOptionPane.showInputDialog("Ingrese ID de la muestra a buscar: ");
        Muestra muestraEncontrada = gestionMuestras.buscarMuestra(idBuscar);
        if (muestraEncontrada != null) {
            JOptionPane.showMessageDialog(null, "Muestra encontrada: \n" + muestraEncontrada);
        } else {
            JOptionPane.showMessageDialog(null, "No se encontro la muestra: \n" + muestraEncontrada);
        }
    }

    private void exportarMuestras() {

        String nombreArchivo = JOptionPane.showInputDialog("Ingrese el nombre del archivo para exportar las muestras ( ej: muestras.txt )");
        gestionMuestras.exportarMuestras(nombreArchivo);
    }

    private boolean validarFecha(String fecha) {

        String regex = "^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])-(\\d{4})$";

        //Define el patron
        Pattern pattern = Pattern.compile(regex);
        //Busca que coincida con ese patron
        Matcher matcher = pattern.matcher(fecha);

        if (!matcher.matches()) {
            //Si no concide el patron devuelva falso
            return false;
        }

        String[] partes = fecha.split("-"); //divide la fecha en partes
        int dia = Integer.parseInt(partes[0]);
        int mes = Integer.parseInt(partes[1]);
        int anio = Integer.parseInt(partes[2]);

        if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia > 30) {
            return false;
        }

        if (mes == 2) {
            if ((anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0)) {
                if (dia > 29) {
                    return false;
                }
            } else {
                if (dia > 28) {
                    return false;
                }
            }
        }
        return true;

    }

}
