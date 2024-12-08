package controller.ejercicios;
import controller.util.Utilidades;
import java.util.Scanner;

public class Informe_autos{
    private int contador1 = 0; // contador para sumar los autos que vende el empleado
    private int contador2 = 0; // contador para sumar los autos que vende el empleado que tengan un costo mayor a 10000
    private float valor_totalAutos = 0.0f; // variable para almacenar el valor del precio total sumando todos los autos vendidos
    private float total_pagarEmpleado = 0.0f; // variable para almacenar el valor del sueldo del empleado
    private int comision = 0; // variable para almacenar el cálculo de la comisión
    private float utilidad = 0.0f; // variable para almacenar el cálculo de la utilidad
    private float precio_autos = 0.0f; // variable para almacenar el valor de un auto vendido por el empleado
    private String continuar = " "; // variable usada para saber si el usuario desea o no continuar ingresando precios de autos

    // método para calcular el valor total de los autos, así como almacenar la información dentro de los contadores
    public void RegistroVentas (){
        contador1 ++;
        valor_totalAutos += precio_autos;

        if (precio_autos > 10000){
            contador2++;
        }
    }

    // método para calcular el valor de la comisión
    public void calcular_comision(){
        comision = 250 * contador2;
    }

    // método para calcular el valor de la utilidad
    public void calcular_utilidad(){
        utilidad = valor_totalAutos * 0.05f;
    }

    // método para calcular el valor del sueldo del empleado
    public void calcular_sueldo_empleado(){
        total_pagarEmpleado = 2500 + comision + utilidad;
    }

    // método para que el usuario pueda ingresar datos
    public void ejecutar(){
        Scanner sc = new Scanner(System.in);  
        do { 
            System.out.println("Ingrese el precio del auto");
            String precioInput = sc.nextLine();  // Cambié a nextLine() para manejar la validación de texto
    
            // Validar si el valor ingresado es un número válido
            if (!Utilidades.validate(precioInput)) {
                System.out.println("Solo se permiten valores numéricos válidos y mayores a 0");
                continue; // Regresar al principio del ciclo si la entrada es inválida
            }
    
            // Convertir el precio a float si es válido
            precio_autos = Utilidades.transformStringFloat(precioInput);
    
            // Validar que el precio sea mayor a 0
            if (precio_autos <= 0) {
                System.out.println("Solo se permiten valores mayores a 0");
                continue; // Regresar al principio del ciclo si el precio es negativo o cero
            }
    
            // Se llama el método para que los contadores tengan valores
            RegistroVentas();
    
            System.out.println("Desea ingresar el precio de otro auto?");
            System.out.println("Escriba s para sí, y n para no");
            continuar = sc.nextLine().toLowerCase();
    
            // Validar si la opción es correcta
            if (!continuar.equals("s") && !continuar.equals("n")) {
                System.out.println("Solo puede ingresar 's' o 'n' como opción.");
                continue; // Regresar al principio del ciclo si la opción no es válida
            }
            
        } while (continuar.equals("s"));
    
        // Llamar los métodos restantes para presentar los datos finales
        calcular_comision();
        calcular_utilidad();
        calcular_sueldo_empleado();
    
        System.out.println("El numero total de autos vendidos por el empleado es " + contador1);
        System.out.println("El valor total de los autos que vendió es de $" + valor_totalAutos);
        System.out.println("El empleado vendió " + contador2 + " autos con un precio mayor a $10000, por lo que su comisión es de $" + comision);
        System.out.println("La utilidad obtenida del valor total de ventas es de $" + utilidad);
        System.out.println("El sueldo a pagar al empleado es de $" + total_pagarEmpleado);
    
        sc.close();
    }
}

