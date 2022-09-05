package Greeting;

import Controller.ControllerTxt;

public class HelloWorld {
    public static void main(String[] args) {
        ControllerTxt obj = new ControllerTxt();

        System.out.println("Hola mundo");

        obj.AddContentToTxt1();
        obj.AddContentToTxt2();
    }
}
