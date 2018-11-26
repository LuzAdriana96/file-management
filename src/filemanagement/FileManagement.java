/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filemanagement;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Luz Adriana Torres Torres
 * clase: Algoritmia
 */

public class FileManagement {

    /**
     * @param args the command line arguments
     */

    
    public static void main(String[] args) {
        // TODO code application logic here
      String read;
      String parts[];
            
       File directorio=new File("Files"); 
       directorio.mkdir(); 
       Hashtable<String,String> contenedor=new Hashtable<>();     
        
        try (RandomAccessFile file = new RandomAccessFile("commands1.txt", "rw");){
            int[] inst = new int [7];

          
            String arrayLine[];
                    
            String[] arr = new String [10];
      
                int cont = 0;
                int cont2= 1;
                for (int i = 0; i < inst.length; i++) {
                    read=file.readLine();
                    parts = read.split(" ");
                    arr[i] = read;
                 
                   
                    if ("create".equals(parts[0])) {
                        //create(read);
                        //System.out.println("va a crear ");
                            String nameFile;
                            String identifier;


                            //Hashtable<String,String> contenedor=new Hashtable<String,String>();
                            String sep[] = read.split(" ");
                            nameFile = sep[1];
                            identifier = sep[3];

                            //System.out.println("entro a nombre create "+nameFile);
                            //System.out.println("entro a identifi create "+identifier);
                            contenedor.put(identifier,nameFile);
                            
                            String limName = nameFile.replaceAll("[^\\dA-Za-z]", "");
                            String quotation[]=limName.split("txt");
                            //System.out.println("nombre "+quotation[0]);
                            File createFile;
                            createFile = new File("Files\\"+quotation[0]+".txt");
                    }
                    else if ("assign".equals(parts[0])) {
                         //assign(read);
                        //System.out.println("va a asignar ");
                            String nameFile;
                            String identifier;


                            //Hashtable<String,String> contenedor=new Hashtable<String,String>();
                            String sep[] = read.split(" ");
                            nameFile = sep[1];
                            identifier = sep[3];

                            //System.out.println("entro a nombre ass "+nameFile);
                            //System.out.println("entro a identifi ass "+identifier);
                            contenedor.put(identifier,nameFile);
                    }
                    else if ("sort".equals(parts[2])) {
                        
                            
                        //System.out.println("entro a ordenar ");
                                
                            String var1;
                            String var2;
                            String sepAsc[] = read.split(" ");
                            var1 = sepAsc[0];
                            var2 = sepAsc[3];
                        //System.out.println("entro a asc "+var2);
                       //System.out.println("entro a ordenar desendentemente");
                       //System.out.println("contenerods ident "+contenedor.get(var2));
                       orderAsc(contenedor.get(var2),contenedor.get(var1));
                       
                    }
                    else if ("rem_doubles".equals(parts[2])) {
                        //System.out.println("va a crear ");
                       //System.out.println("entro a remplazar _____________");
                                
                            String var_id1;
                            String var_id2;
                            String sepRem[] = read.split(" ");
                            var_id1 = sepRem[0];
                            var_id2 = sepRem[3];
                        //System.out.println("entro a asc "+var_id1);
                       //System.out.println("entro a ordenar desendentemente");
                       //System.out.println("contenerods ident "+contenedor.get(var2));
                       rem(contenedor.get(var_id1),contenedor.get(var_id2));
                    }
                    else if ("+".equals(parts[3]))
                    {
                        System.out.println("entro a sumar los ");
                        
                                
                            String var_id1;
                            String var_id2;
                            String var_id3;
                            String sepSum[] = read.split(" ");
                            var_id1 = sepSum[0];
                            var_id2 = sepSum[2];
                            var_id3 = sepSum[4];
                        //System.out.println("entro a sumar "+var_id1);
                       //System.out.println("entro a ordenar desendentemente");
                       //System.out.println("contenerods ident "+contenedor.get(var2));
                       sum(contenedor.get(var_id1),contenedor.get(var_id2),contenedor.get(var_id3));
                                
                    }
                  
                    //arr[i] = read;
                    //System.out.println("entro 42");
                    System.out.println("entro a igualar archivos"+read.length());
                }   
                

        } catch (Exception e) {
        }
        
        //metodos(read);
    }
    
    public static void orderAsc(String arc, String var1) {
        //String quotation[]=arc.split("");
        String read;
        int[] number = new int [10];
        System.out.println("ordenar acende ");
        System.out.println(arc.replaceAll("[^\\dA-Za-z]", ""));
        String lim = arc.replaceAll("[^\\dA-Za-z]", "");
        String quotation[]=lim.split("txt");
        System.out.println("nombre "+quotation[0]);
        
        String limVar1 = var1.replaceAll("[^\\dA-Za-z]", "");
        String quotation1[]=limVar1.split("txt");
        System.out.println("nombre2 "+quotation1[0]);
        //System.out.println("ordenar archivo "+quotation1[1]);
        
        
        try (RandomAccessFile file = new RandomAccessFile(quotation[0]+".txt", "rw");){
            int[] inst = new int [10];
            
            for (int i = 0; i < inst.length; i++) {
               read=file.readLine();
               number[i]=Integer.parseInt(read);
               //inst[i]=read;
                //System.out.println("numeros "+read);
                
            }     
            
            
            
            
        } catch (Exception e) {
        }
        Arrays.sort(number);
        
        try (RandomAccessFile fichero = new RandomAccessFile("Files\\"+quotation1[0]+".txt", "rw")){

            for (int i = 0; i < number.length; i++) {
                String ordenado = Integer.toString(number[i]);
                fichero.writeBytes(ordenado + "\r\n");

            }
       } catch (Exception e) {
       }
    }
    
    public static void rem(String var_id1, String var_id2) {
        System.out.println("entro a remplazar "+var_id1);
        
        String read;
        String[] number = new String [20];
        
        
        System.out.println(var_id1.replaceAll("[^\\dA-Za-z]", ""));
        String limVar1 = var_id1.replaceAll("[^\\dA-Za-z]", "");
        String quotation1[]=limVar1.split("txt");
        //System.out.println("nombre "+quotation1[0]);
       
        System.out.println(var_id2.replaceAll("[^\\dA-Za-z]", ""));
        String lim = var_id2.replaceAll("[^\\dA-Za-z]", "");
        String quotation[]=lim.split("txt");
       // System.out.println("nombre "+quotation[0]);
  
        //System.out.println("ordenar archivo "+quotation1[1]);
        
        
        try (RandomAccessFile file = new RandomAccessFile("Files\\"+quotation[0]+".txt", "rw");){
            String[] inst = new String [20];
            
            for (int i = 0; i < inst.length; i++) {
               read=file.readLine();
               number[i]=read;
               
                
            }
            
        } catch (Exception e) {
        }
        //repetidos
        
        System.out.println("llego remp ");
		for(int m=0;m<number.length;m++){
                    for(int j=0;j<number.length-1;j++){
                            if(m!=j){
                                    if(number[m] == null ? number[j] == null : number[m].equals(number[j])){
                                            // eliminamos su valor
                                            number[m]=null;
                                            System.out.println("entro al for rem");
                                    }
                            }
                    }
		}
 
                
        try (RandomAccessFile fichero = new RandomAccessFile("Files\\"+quotation1[0]+".txt", "rw")){
            int n=number.length;
            for (int k=0;k<=n-1;k++) {
                //String ordenado = Integer.toString(number[l]);
                if (number[k] != null) {
                    fichero.writeBytes(number[k] + "\r\n");
                }
                

            }
       } catch (Exception e) {
       }
    }
    
    public static void sum(String var_id1, String var_id2, String var_id3) {
        System.out.println("sumar archivos "+var_id1+", "+var_id2+", "+var_id3);
        
        String readVar2,readVar3;
        String[] arryVar1 = new String [20];
        ArrayList<String> nombreArrayList = new ArrayList<String>();
        String[] arryVar2 = new String [10];
        String[] arryVar3 = new String [10];
        
        System.out.println(var_id1.replaceAll("[^\\dA-Za-z]", ""));
        String limVar1 = var_id1.replaceAll("[^\\dA-Za-z]", "");
        String quotation1[]=limVar1.split("txt");
        //System.out.println("nombre1 "+quotation1[0]);
       
        System.out.println(var_id2.replaceAll("[^\\dA-Za-z]", ""));
        String limVar2 = var_id2.replaceAll("[^\\dA-Za-z]", "");
        String quotation2[]=limVar2.split("txt");
        //System.out.println("nombre2 "+quotation2[0]);
        
        System.out.println(var_id3.replaceAll("[^\\dA-Za-z]", ""));
        String limVar3 = var_id3.replaceAll("[^\\dA-Za-z]", "");
        String quotation3[]=limVar3.split("txt");
        //System.out.println("nombre2 "+quotation3[0]);
        
        
        try{
            RandomAccessFile filesVar2 = new RandomAccessFile(quotation2[0]+".txt", "rw");
            RandomAccessFile filesVar3 = new RandomAccessFile(quotation3[0]+".txt", "rw");
             for (int i = 0; i < arryVar1.length; i++) {
               
               readVar2=filesVar2.readLine();
               readVar3=filesVar3.readLine();
               int posicion = arryVar1.length;
               nombreArrayList.add(readVar2);
               nombreArrayList.add(nombreArrayList.lastIndexOf(readVar2), readVar3);
               //arryVar1[i]=readVar2;
                 //System.out.println("union dos archivos "+readVar2);
                //arryVar1[i]= readVar3;
               //arryVar1[i]=readVar3;
               //System.out.println("union tres archivos "+nombreArrayList.get(i));
               //String array[i] = 
               //String[] result = arryVar1[i]
               //cont[i]=read;
               //inst[i]=read;
                //System.out.println("numeros "+read);
                
                //quitar los repetidos
               
                
            }
        } catch (Exception e) {
        }
        
        //write file 1        
        try (RandomAccessFile fichero = new RandomAccessFile("Files\\"+quotation1[0]+".txt", "rw");){
          
            for (int g = 0; g < arryVar1.length; g++) {
                //String ordenado = Integer.toString(number[i]);
                
                //System.out.println("archivo dos "+arryVar2[g]);
              
                    fichero.writeBytes(nombreArrayList.get(g) + "\r\n");
                    //System.out.println("entro al archivo dos "+nombreArrayList.get(g));
                    //fichero2.writeBytes(arryVar3[g] +"\r\n");
                    //System.out.println("archivo tres "+arryVar3[g]);
                    
                
            }
            
        


       } catch (Exception e) {
       }
        
    }
    

    
}
