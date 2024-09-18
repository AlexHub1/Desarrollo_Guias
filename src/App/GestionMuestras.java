package App;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.*;
import javax.swing.JOptionPane;

public class GestionMuestras {

    private HashSet<Muestra> muestras;

    public GestionMuestras() {
        muestras = new HashSet<>();
    }

    public void agregarMuestra(Muestra muestra) {

        if (muestras.contains(muestra)) {
            JOptionPane.showMessageDialog(null, "Error la muestra ya existe");
        } else {
            muestras.add(muestra);
            JOptionPane.showMessageDialog(null, "Muestra Agregada con exito");
        }

    }

    public void eliminarMuestra(String id) {

        //Se comporta como foreach
        Iterator<Muestra> it = muestras.iterator();
        //Verifica si hay mas elementos por verificar
        while (it.hasNext()) {
            Muestra muestra = it.next();
            if (muestra.getIdMuestra().equals(id)) {
                it.remove();
                JOptionPane.showMessageDialog(null, "Muestra Eliminada con exito");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Error no se encontro la muestra con id: " + id);
    }

    public Muestra buscarMuestra(String id) {
        for (Muestra muestra : muestras) {
            if (muestra.getIdMuestra().equals(id)) {
                return muestra;
            }
        }
        return null;
    }

    public void mostrarMuestras() {
        if (muestras.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay muestras disponibles");
        } else {
            StringBuilder sb = new StringBuilder("Muestras Almacenadas: \n");
            for (Muestra muestra : muestras) {
                sb.append(muestra).append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());

        }

    }

    public void exportarMuestras(String nombreArchivo) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {

            for (Muestra muestra : muestras) {
                writer.write(muestra.toString());
                //salto de linea
                writer.newLine();
                JOptionPane.showMessageDialog(null, "Muestras exportadas exitosamente al archivo: " + nombreArchivo);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al exportar las muestras: " + e.getMessage());

        }
    }

}
