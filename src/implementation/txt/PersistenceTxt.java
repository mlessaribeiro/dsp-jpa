package implementation.txt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import abstraction.model.Person;
import abstraction.interfaces.PersistencePerson;

public class PersistenceTxt implements PersistencePerson {
    private String fileName;
    
    public PersistenceTxt(String fileName){
        this.fileName = fileName;
    }
    
    @Override
    public void save(Person person) {
        try {
            OutputStream outputStream = new FileOutputStream(fileName, true);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

            bufferedWriter.write("Name:     " + person.getName());
            bufferedWriter.newLine();
            bufferedWriter.write("Adress: " + person.getAdress());
            bufferedWriter.newLine();
            bufferedWriter.write("Phone: " + person.getPhone());
            bufferedWriter.newLine();
            bufferedWriter.write("Email:   " + person.getEmail());
            bufferedWriter.newLine();
            bufferedWriter.write("---------------------------------------");
            bufferedWriter.newLine();
            
            bufferedWriter.close();
            outputStreamWriter.close();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
    @Override
    public void list(){
        try{
            InputStream inputStream = new FileInputStream(fileName);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            
            String line = bufferedReader.readLine();
            
            while(line != null) {
                System.out.println(line);
                line = bufferedReader.readLine();
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    } 
}
