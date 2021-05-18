
package streams;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
/**
 *
 * @author mvatm
 */
public class Tarea implements Callable<Long> {
    private final File file;    
    
    public Tarea(File file){
        this.file = file;        
    }
    
    @Override
    public Long call() throws Exception {
        String line, contenido;        
        FileReader fr;
        BufferedReader br;        
        StringBuilder aux = new StringBuilder();
        try {
            fr = new FileReader(this.file);
            br = new BufferedReader(fr);
            try {
                while ((line = br.readLine()) != null) {
                    aux.append(line);
                    aux.append("\n");
                }
            } catch (IOException ex) {
                Logger.getLogger(Tarea.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Tarea.class.getName()).log(Level.SEVERE, null, ex);
        }
        contenido = aux.toString();       
                
        if (contenido.equals("")) {
            return 0L;
        } else {
            long count = contenido.replace("\n", " ").split("\\s+").length;
            return count;
        }                                
    } 
    
}
