package serialization_java_class;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


public class Deserialize {

	public static Carro deserializeCarObj(String filename) {
		Carro carro = null;
		
		try (FileInputStream fileIn = new FileInputStream(filename)){
			ObjectInputStream in = new ObjectInputStream(fileIn);
			carro = (Carro) in.readObject();
			fileIn.close();
			in.close();
		}catch(IOException i) {
			i.printStackTrace();
		}catch(ClassNotFoundException c) {
			System.out.println("Objeto carro não encontrado");
			c.printStackTrace();
		}
		
		return carro;
	}
	
	public static void main(String[] args) {
		
		Carro carro = deserializeCarObj("carro.ser");
		
		System.out.println("Object restored successfuly!");
		
		System.out.println("Showing some values:");
		System.out.println("Car brand: " + carro.getMarca());
		System.out.println("Car model: " + carro.getModelo());
		System.out.println("Car model year: " + carro.getAnoModelo());
		System.out.println("Car license plate: " + carro.getPlaca());
	}

}
