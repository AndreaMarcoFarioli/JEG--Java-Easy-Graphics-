package Program;

import Program.Controller.Controller;
import Program.View.View;

public class Main {

    public static View v = new View();
    public static Controller c =  new Controller(v);

    public static void main(String[] args) throws Exception {
        System.setProperty("sun.java2d.opengl", "true");
        c.start();
    }
}
