package views;

import java.util.Scanner;

import controller.ejercicios.Fibonacci;
import controller.ejercicios.Informe_agua;
import controller.ejercicios.Informe_autos;
import controller.ejercicios.Llamadas;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        System.out.println("Bienvenido a la selección de uno de los ejercicios que desees poner en marcha");

        System.out.println("Seleccione una opcion");
        System.out.println("1: Informe sobre los autos vendidos por un empleado");
        System.out.println("2: Llamadas por zona geográfica");
        System.out.println("3: Informe planilla por consumo de agua");
        System.out.println("4: Sucesión Fibonnaci");
        opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                Informe_autos iau = new Informe_autos();
                iau.ejecutar();
                break;

            case 2:
                Llamadas llds = new Llamadas();
                llds.ejecutar();
                break;

            case 3:
                Informe_agua iag = new Informe_agua();
                iag.ejecutar();
                break;

            case 4:
                Fibonacci fbn = new Fibonacci();
                fbn.ejecutar();
                break;

            default:
                System.out.println("Numero o dato incorrecto");
                sc.close();
                break;
        }
    }
}
