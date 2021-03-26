/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matidirplik;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;



/**
 *
 * @author dabro
 */
public class MatiDirPlik {
    
    
    private static void copy(File src, File dest) throws IOException { 
        InputStream is = null; 
        OutputStream os = null; 
        try { 
            is = new FileInputStream(src);
            os = new FileOutputStream(dest);  
            byte[] buf = new byte[1024]; 
            int bytesRead; 
            while ((bytesRead = is.read(buf)) > 0) 
            { os.write(buf, 0, bytesRead); } } 
        finally { is.close(); os.close(); } }


    public static String nazwa(String linia){
        String[] a=linia.split(",");    
        String nazwa=a[0];         
            
        return nazwa;
    }
    public static void main(String[] args) {
        File dir = new File("C:\\Users\\dabro\\Documents\\NetBeansProjects\\MatiDirPlik\\Dir");
        String[] children =dir.list();
        String text=null;
        
        try{
        if(children == null)
        {
        System.out.println("Nie ma");
        }else{     
         
            
        for (int i = 0; i < children.length; i++) {
            String filename = children[i];
            System.out.println(filename);
            
            
            File f=new File("C:\\Users\\dabro\\Documents\\NetBeansProjects\\MatiDirPlik\\Dir\\");
            
            File g=new File("C:\\Users\\dabro\\Documents\\NetBeansProjects\\MatiDirPlik\\Dir\\"+filename);
            BufferedReader brTest = new BufferedReader(new FileReader("C:\\Users\\dabro\\Documents\\NetBeansProjects\\MatiDirPlik\\Dir\\"+filename));
            
            
            text = brTest .readLine();
            System.out.println("Firstline is : " + text);
            String naz=nazwa(text);
            System.out.println(naz);
            File e=new File("C:\\Users\\dabro\\Documents\\NetBeansProjects\\MatiDirPlik\\Dir\\level1\\"+naz+".csv");
            copy(g,e);
                                                  }
        }
        }
        catch(IOException e)
        {
             System.out.println("Blad");
             e.printStackTrace();
        }
}
}
