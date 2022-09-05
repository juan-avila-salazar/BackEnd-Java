package Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class ControllerTxt {
    public void AddContentToTxt1 (){
        Path path = Paths.get("C:\\Users\\juanpablo.avila\\Desktop\\Proyectos Instrucion\\BackEnd Java\\3.Herramientas Maven, Git\\3.2.Crear repositorio Git\\Ficheros\\fichero1.txt");
        String add, res;
        Scanner sc = new Scanner(System.in);
        try{
            System.out.println("For file 1");
            System.out.println("Do you want to add content to the file? y/n");
            res = sc.nextLine();
            while (res.equalsIgnoreCase("y")){
                System.out.println("Content to add");
                add = sc.nextLine();
                add=add+"\n";
                Files.write(path,add.getBytes(), StandardOpenOption.APPEND);
                System.out.println("Do you want to continue adding content? y/n");
                res=sc.nextLine();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void AddContentToTxt2 (){
        Path path = Paths.get("C:\\Users\\juanpablo.avila\\Desktop\\Proyectos Instrucion\\BackEnd Java\\3.Herramientas Maven, Git\\3.2.Crear repositorio Git\\Ficheros\\fichero2.txt");
        String add, res;
        Scanner sc = new Scanner(System.in);
        try{
            System.out.println("for file 2");
            System.out.println("Do you want to add content to the file? y/n");
            res = sc.nextLine();
            while (res.equalsIgnoreCase("y")){
                System.out.println("Content to add");
                add = sc.nextLine();
                add=add+"\n";
                Files.write(path,add.getBytes(), StandardOpenOption.APPEND);
                System.out.println("Do you want to continue adding content? y/n");
                res=sc.nextLine();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
