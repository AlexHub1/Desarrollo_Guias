
package App;


public class AppLaboratorio {
    
    public static void main(String[] args) {
        
        GestionMuestras gestionMuestras = new GestionMuestras();
        
        InterfazUsuario interfazUsuario = new InterfazUsuario(gestionMuestras);
        interfazUsuario.iniciar();
        
        
    }
}
