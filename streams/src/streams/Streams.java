package streams;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner; 
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class Streams {
	public static void main(String[] args) {
		Leer_Fichero accediendo= new Leer_Fichero();
		accediendo.lee();
                
                 ExecutorService pool = Executors.newFixedThreadPool(12);
        ExecutorCompletionService<Long> ecs = new ExecutorCompletionService<>(pool);
        System.out.println("////////////////////////////////////////////////////////////////////");  
        ecs.submit(new Tarea(new File("src/archivo/pg2000.txt")));               
        pool.shutdown();
        
        long total = 0;
        try {                        
            total += ecs.take().get();
        } catch (InterruptedException | ExecutionException ex) {
            ex.printStackTrace();
        }
        
        System.out.println("El archivo contiene " + total + " Palabras");       
	}
        
        
        
        
}

class Leer_Fichero{
	public void lee() {
		try {
		FileReader entrada = new FileReader("src/archivo/pg2000.txt");
		int c=entrada.read();
		while (c!=-1) {
			c=entrada.read();
			char letra=(char) c;
			System.out.print (letra);
			
		}
		entrada.close();
		}catch(IOException e) {
			System.out.println("No se ha encontrado el archivo");
			}
		}
        public void filtrar(){
            
                   
        
 
        }
        
}

