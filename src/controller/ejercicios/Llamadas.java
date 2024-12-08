package controller.ejercicios;

import java.util.Scanner;

public class Llamadas {
    private float minutos = 0.00f; // variable para almacenar el valor de los minutos en llamada
    private float precio_pagar = 0.00f; // variable para el almacenar el valor que debe pagar la persona por la llamada
    private String continuar = " "; // variable para saber si el usuario desea o no continuar con las llamadas
    private int opcion; // variable para el switch

    // método para validar valores negativos cuando el usuario ingresa datos
    public void validar_datos_negativos(){
        if (minutos < 0){
            System.out.println("Los valores negativos no estan permitidos");
            minutos = 0.00f;
        }
    }

    // método para validar que ingrese un código correcto para la zona
    public void validar_opcion(Scanner sc) {
        while (!sc.hasNextInt()) { // aquí digo que si el valor del scanner no es un entero, entonces que valide eso
            System.out.println("Por favor ingrese un número válido para la zona.");
            sc.next();
        }
    }
    // Método para validar que los datos sean correctos para continuar con el programa, un caso el usuario lo desee hacer.
    public void validar_Continuar(Scanner sc){
        while (!continuar.equalsIgnoreCase("s") && !continuar.equalsIgnoreCase("n")){
            System.out.println("Sólo puede ingresar 's' o 'n' como opciones");
            continuar = sc.nextLine();
        }
    }

    // Enum con los cálculos para cada zona
    enum Zonas {
        AMERICA_DEL_NORTE {
            @Override
            public float calcularPrecio(float minutos) {
                return (float) Math.ceil(minutos) * 2.75f;
            }
        },
        AMERICA_CENTRAL {
            @Override
            public float calcularPrecio(float minutos) {
                return (float) Math.ceil(minutos) * 1.89f;
            }
        },
        AMERICA_DEL_SUR {
            @Override
            public float calcularPrecio(float minutos) {
                return (float) Math.ceil(minutos) * 1.6f;
            }
        },
        EUROPA {
            @Override
            public float calcularPrecio(float minutos) {
                return (float) Math.ceil(minutos) * 3.5f;
            }
        },
        ASIA {
            @Override
            public float calcularPrecio(float minutos) {
                return (float) Math.ceil(minutos) * 4.5f;
            }
        },
        AFRICA {
            @Override
            public float calcularPrecio(float minutos) {
                return (float) Math.ceil(minutos) * 3.1f;
            }
        },
        OCEANIA {
            @Override
            public float calcularPrecio(float minutos) {
                return (float) Math.ceil(minutos) * 3f;
            }
        },
        OTRO {
            @Override
            public float calcularPrecio(float minutos) {
                return (float) Math.ceil(minutos) * 6f;
            }
        };

        // Método que cada zona debe implementar para calcular el precio
        public abstract float calcularPrecio(float minutos);
    }

    // Método para presentar los datos finales en cada caso del switch
    public void Presentar_Datos(){
        System.out.println("El precio a pagar por realizar la llamada es de $"+ precio_pagar);
        System.out.println("Desea nuevamente realizar una llamada? Escriba 's' para si, y 'n' para no");
    }

    // método para ejecutar y recibir los datos que el usuario va a ingresar
    public void ejecutar () {
        System.out.println("Bienvenido a el menú de selección de la zona geográfica a la que deseas hacer una llamada");
        System.out.println("Para 'América del Norte', escriba la clave: 12");
        System.out.println("Para 'América Central', escriba la clave: 15");
        System.out.println("Para 'América del Sur', escriba la clave: 18");
        System.out.println("Para 'Europa', escriba la clave: 19");
        System.out.println("Para 'Asia', escriba la clave: 23");
        System.out.println("Para 'África', escriba la clave: 25");
        System.out.println("Para 'Oceanía', escriba la clave: 29");
        System.out.println("Si no pertenece a ninguna de las zonas mencionadas anteriormente, escriba la clave: 31");

        Scanner sc = new Scanner(System.in);

        // Bucle do-while para el switch y en caso el usuario desee ingresar más de una vez datos.
        do {
            validar_opcion(sc);
            opcion = sc.nextInt();
            System.out.println("Ingrese los minutos que ha estado en llamada");
            minutos = sc.nextFloat();
            validar_datos_negativos();

            // Usamos el enum para obtener el precio de acuerdo con la zona seleccionada
            switch (opcion) {
                case 12:
                    precio_pagar = Zonas.AMERICA_DEL_NORTE.calcularPrecio(minutos);
                    break;

                case 15:
                    precio_pagar = Zonas.AMERICA_CENTRAL.calcularPrecio(minutos);
                    break;
                
                case 18:
                    precio_pagar = Zonas.AMERICA_DEL_SUR.calcularPrecio(minutos);
                    break;
                
                case 19:
                    precio_pagar = Zonas.EUROPA.calcularPrecio(minutos);
                    break;

                case 23:
                    precio_pagar = Zonas.ASIA.calcularPrecio(minutos);
                    break;

                case 25:
                    precio_pagar = Zonas.AFRICA.calcularPrecio(minutos);
                    break;

                case 29:
                    precio_pagar = Zonas.OCEANIA.calcularPrecio(minutos);
                    break;

                case 31:
                    precio_pagar = Zonas.OTRO.calcularPrecio(minutos);
                    break;

                default:
                    System.out.println("Clave incorrecta o no permitida, por favor ingrese solo claves permitidas");
                    return;
            }

            // Presentamos los datos calculados
            Presentar_Datos();
            sc.nextLine();
            continuar = sc.nextLine();
            validar_Continuar(sc);
            if (continuar.equalsIgnoreCase("s")){
                System.out.println("Elija la clave nuevamente");
            }

        } while (continuar.equalsIgnoreCase("s")); 

        sc.close();
    }
}
