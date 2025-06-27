import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ExemploMonitoramento {
    public static void main(String[] args) {
        DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        // Create multiple Titulo objects
        Titulo titulo1 = new Titulo("T1", 100.0, 105.0, "Stock", sdf, sdf);
        Titulo titulo2 = new Titulo("T2", 200.0, 205.0, "Bond", sdf, sdf);
        Titulo titulo3 = new Titulo("T3", 300.0, 305.0, "Option", sdf, sdf);
        
        // Instantiate listener implementations using the Google and Uol classes
        Listener google = new Google();
        Listener uol = new Uol();
        
        // Subscribe listeners to different titles:
        // titulo1 notifies only Google
        titulo1.subscribeListener(google);
        // titulo2 notifies only Uol
        titulo2.subscribeListener(uol);
        // titulo3 notifies both
        titulo3.subscribeListener(google);
        titulo3.subscribeListener(uol);
        
        // Update attributes to trigger notifications:
        System.out.println("Updating titulo1 valorCompra...");
        titulo1.setValorCompra(110.0);
        
        System.out.println("Updating titulo2 tipo...");
        titulo2.setTipo("Modified Bond");
        
        System.out.println("Updating titulo3 codigo...");
        titulo3.setCodigo("T3-Updated");
    }
}