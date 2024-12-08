package controller.ejercicios;
import java.util.Scanner;

public class Fibonacci {

    // Método para hacer los cálculos entre las fracciones
    public static double calcularFraccion(int num1, int denominador, int potencia) {
        return Math.pow((double) num1 / denominador, potencia);
    }
    
    // Método que permitirá visualizar la fracción como corresponde, es decir (numerador/denominador)^potencia
    public static void imprimirFraccion(int num1, int denominador, int potencia, int i, int numero, int signo) {
        // Si es el primer término, no poner signo de + ya que no queda bien, de ahí es correcto.
        if (i == 1) {
            System.out.print("(" + num1 + " / " + denominador + ")^" + potencia);
        } else {
            // Si no es el primer término, colocar el signo adecuado
            if (signo == 1) {
                System.out.print(" + (" + num1 + " / " + denominador + ")^" + potencia);
            } else {
                System.out.print(" - (" + num1 + " / " + denominador + ")^" + potencia);
            }
        }
        
        // Si no es el último término, imprimir el signo para así evitar que en el último término, después de este se le imprima un signo
        if (i != numero) {
            System.out.print(" ");
        }
    }

    // Método para calcular el resultado de la sucesión
    public static double calcularResultado(int numero) {
        int num1 = 1; // Numerador del Fibonacci
        int num2 = 1; // Numerador siguiente en la secuencia
        int denominador = 1; // Denominador del Fibonacci
        int potencia = 2; // Potencia que irá en cada una de las fracciones
        
        double resultado = 0; // Variable para calcular el total de los cálculos
        int signo = 1; // Control para alternar los signos (+1 para +, -1 para -)
        
        // Bucle para las fracciones con sus potencias respectivas, así como calcular el resultado
        for (int i = 1; i <= numero; i++) {
            double fraccion = calcularFraccion(num1, denominador, potencia);
            
            // Sumar o restar dependiendo del bloque de 2
            resultado += signo * fraccion;
            
            // Imprimir la fracción
            imprimirFraccion(num1, denominador, potencia, i, numero, signo);
            
            // Esto permite que cada 2 el signo cambie, que es como funciona la lógica de la sucesión
            if (i % 2 == 0) {
                signo *= -1; // Cambia el signo después cada 2 términos
            }
            
            // Aquí vamos haciendo que en la siguiente cifra de la sucesión, el valor vaya cambiando como corresponde
            int siguienteNum = num1 + num2; // Siguiente numerador de Fibonacci
            num1 = num2; 
            num2 = siguienteNum; 

            denominador += 2; // Denominador va de 2 en 2 como debe ser
            potencia += 2; // Potencia va de 2 en 2 como debe ser
        }
        
        return resultado;
    }

    // Método para ejecutar y recibir los datos por parte del usuario
    public void ejecutar() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingresa el número de términos: ");
        int numero = sc.nextInt();
        double resultado = calcularResultado(numero);
        
        System.out.println("\nResultado total: " + resultado);
        
        sc.close();
    }
}