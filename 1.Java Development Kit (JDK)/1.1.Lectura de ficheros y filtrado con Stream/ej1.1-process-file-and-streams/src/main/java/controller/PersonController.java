package controller;

import model.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersonController {
    //instanciar una lista de person
    List<Person> personList = new ArrayList<Person>();
    //metodo para leer un archivo
    public void showContent (){
        Path path = Paths.get("C:\\Users\\juanpablo.avila\\Desktop\\Proyectos Instrucion\\BackEnd Java\\1.Java Development Kit (JDK)\\1.1.Lectura de ficheros y filtrado con Stream\\Ficheros\\prueba.txt");
        try(BufferedReader br = Files.newBufferedReader(path)){
            String currentLine= br.readLine();
            while (currentLine!=null){
                String[] person = currentLine.split(":");
                Person personP = new Person();
                if (person.length>0) {
                    personP.setName(person[0]);
                }
                if (person.length >= 2) {
                    personP.setTown(person[1]);
                }
                try {
                    if (person[1].equals((""))) {
                        person[1]= null;
                    }
                    Optional<String> op= Optional.ofNullable(person[1]);
                    String variableTown = op.orElse("Unknown Town");
                    personP.setTown(variableTown);
                }catch (Exception e){
                    Optional<String> op = Optional.empty();
                }
                personP.setAge(person.length > 2 ? Integer.parseInt(person[2]) : 0);

                personList.add(personP);
                currentLine = br.readLine();
            }
            System.out.println("============ File reading =============");
            personList.forEach(p -> System.out.println("|Name:"+p.getName() + " |Town:"+p.getTown() + " |Age:"+p.getAge()));

        } catch (IOException ex) {
            System.out.println("Error al encontar e fichero");
        }
    }

    //Metodos para filtrar
    public void FilterA() {
        System.out.println("================ Under 25 years old ===============");
        personList.stream().filter(age -> age.getAge() < 25).filter((c) -> c.getAge() != 0).forEach(System.out::println);
    }
    public void FilterB(){
        System.out.println("============ Remove people whose name starts with A =============");
        personList.stream().filter((p)->!p.getName().startsWith("A")).forEach(System.out::println);
    }
    public void FilterC(){
        System.out.println("============ First result of People in Madrid and Under 25 years old ===========");
        Optional<Person> personMadrid = personList.stream().filter((p)->p.getAge() <25).filter((p)-> p.getAge()>0).filter((p)->p.getTown().equals("Madrid")).findFirst();
        if (personMadrid.isPresent()) {
            System.out.println(personMadrid.get());
        }else {
            System.out.println("non-existent");
        }
    }
    public void FilterD(){
        System.out.println("============ First result of People in Barcelona and Under 25 years old ===========");
        Optional<Person> personBarcelona = personList.stream().filter((p)->p.getAge() <25).filter((p)-> p.getAge()>0).filter((p)->p.getTown().equals("Barcelona")).findFirst();
        if (personBarcelona.isPresent()) {
            System.out.println(personBarcelona.get());
        }else {
            System.out.println("non-existent");
        }
    }
}
    /*con ayuda de jonatan
    //Lista de la clase person
    List <Person> listPeople = new ArrayList<>();

    public Person CreatedObjetPerson (String name, String town, int age){
        Person person = new Person(name, town, age);
        return person;
    }

    public List<Person> getListPeople() {

        return listPeople;
    }*/

