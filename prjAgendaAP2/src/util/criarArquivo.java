package util;

import java.io.File;

public class criarArquivo {
    public static void main(String[] args) {
        
        // Implement the logic to write to a file here
        System.out.println("Implement file creation logic here.");

        // Example: You can use FileWriter or BufferedWriter to create a file
        try {
            File file = new File("../../Arquivos/arquivo.txt");
            if(file.createNewFile()){
                
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
