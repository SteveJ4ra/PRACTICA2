package controller.ejercicios;
import java.util.Scanner;

public class Informe_agua {
    private int consumo_agua = 0; // variable para el valor del consumo de agua que se ha realizado durante el mes
    private String tercera_edad; // variable para determinar si es o no una persona de la tercera edad
    private String discapacidad; // varaible para determinar si tiene o no una discapacidad
    private float porcentaje_discapacidad = 0.00f; // variable para determinar el porcentaje de discapacidad
    private float gastos_pagarAgua = 0.00f; // variable para determinar el valor a pagar por el consumo de agua sin tener en cuenta los otros factores
    private float impuesto_alcantarillado = 0.35f; // variable para el valor del impuesto del alcantarillado
    private float tasa_Rbasura = 0.75f; // variable para el valor de la tasa de recolección de basura
    private float tasa_ProcesamientoD = 0.50f; // variable para la tasa de procesamiento de datos
    private float total_pagar = 0.00f; // variable para el valor del total a pagar sin tener en cuenta descuentos
    private float suma_gastos_agua = 0.00f; // variable para almacenar el valor del contador si supera la base
    private float total_pagar_descuento = 0.00f; // variable para el valor del total a pagar teniendo en cuenta descuentos
    private float suma_descuentos = 0.00f; // variable para sumar los descuentos si se aplican ambas condiciones
    private float descuento_edad = 0.00f; // variable para almacenar el descuento por edad
    private float descuento_discapacidad = 0.00f; // variable para almacenar el descuento por discapacidad

    // método para los valores a calcular entre el rango 15-24
    public void Suma_Rango_15_24(){
        for (int contador = 15; contador<= consumo_agua; contador++){
            suma_gastos_agua += 0.10;
        }
        gastos_pagarAgua = 3 + suma_gastos_agua;
        total_pagar = gastos_pagarAgua + (gastos_pagarAgua * impuesto_alcantarillado) + tasa_Rbasura + tasa_ProcesamientoD;
    }

    // método para los valores a calcular entre el rango 25-39
    public void Suma_Rango_25_39(){
        suma_gastos_agua = 0.00f;
        for (int contador = 25; contador <= consumo_agua; contador ++){
        suma_gastos_agua += 0.20;
        }
        gastos_pagarAgua = 3 + suma_gastos_agua + 1;
        total_pagar = gastos_pagarAgua + (gastos_pagarAgua * impuesto_alcantarillado) + tasa_Rbasura + tasa_ProcesamientoD;
    }

    // método para los valores a calcular entre el rango 40-59
    public void Suma_Rango_40_59(){
        suma_gastos_agua = 0.00f;
        for (int contador = 40; contador <= consumo_agua; contador ++){
            suma_gastos_agua += 0.30;
        }
        gastos_pagarAgua = 3 + suma_gastos_agua + 1 + 3;
        total_pagar = gastos_pagarAgua + (gastos_pagarAgua * impuesto_alcantarillado) + tasa_Rbasura + tasa_ProcesamientoD;
    }

    // método para los valores a calcular en los rangos superiores a 60
    public void Suma_Rango_60(){
        suma_gastos_agua = 0.00f;
        for (int contador = 60; contador <= consumo_agua; contador ++){
            suma_gastos_agua += 0.35;      
        }
        gastos_pagarAgua = 3 + suma_gastos_agua + 1 + 3 + 6;
        total_pagar = gastos_pagarAgua + (gastos_pagarAgua * impuesto_alcantarillado) + tasa_Rbasura + tasa_ProcesamientoD;
    }

    // método para sumar los descuentos teniendo en cuenta el 50% por edad
    public void Suma_Descuentos_50(){
        suma_descuentos = ((porcentaje_discapacidad + 50)/100);
        if (suma_descuentos > 1){
            total_pagar_descuento = total_pagar - 3;
        }else {
            total_pagar_descuento = total_pagar - (3 * suma_descuentos);
            descuento_edad = 50;
            descuento_discapacidad = porcentaje_discapacidad;
        }
    }

    // método para sumar los descuentos teniendo en cuenta el 30% por edad
    public void Suma_Descuento_30(){
        suma_descuentos = ((porcentaje_discapacidad + 30)/100);
        if (suma_descuentos > 1){
            total_pagar_descuento = total_pagar - 3;
        }else {
            total_pagar_descuento = total_pagar - (3 * suma_descuentos);
            descuento_edad = 30;
            descuento_discapacidad = porcentaje_discapacidad;
        }
    }

    // método para calcular los valores si no es de la tercer edad y tampoco tiene discapacidad
    public void Calcular_Total_Pagar1(){
        if (consumo_agua >= 0 && consumo_agua <=14 && tercera_edad.equalsIgnoreCase("no") && discapacidad.equalsIgnoreCase("no")){
            gastos_pagarAgua  = 3;
            total_pagar = gastos_pagarAgua + (gastos_pagarAgua * impuesto_alcantarillado) + tasa_Rbasura + tasa_ProcesamientoD; 
            total_pagar_descuento  = total_pagar;
        } if (consumo_agua >= 15 && consumo_agua <=24 && tercera_edad.equalsIgnoreCase("no") && discapacidad.equalsIgnoreCase("no")){
            Suma_Rango_15_24();
            total_pagar_descuento  = total_pagar;
        } if (consumo_agua >= 25 && consumo_agua <=39 && tercera_edad.equalsIgnoreCase("no") && discapacidad.equalsIgnoreCase("no")){
            Suma_Rango_25_39();
            total_pagar_descuento  = total_pagar;
        } if (consumo_agua >= 40 && consumo_agua <=59 && tercera_edad.equalsIgnoreCase("no") && discapacidad.equalsIgnoreCase("no")){
            Suma_Rango_40_59();
            total_pagar_descuento  = total_pagar;
        } if (consumo_agua >= 60 && tercera_edad.equalsIgnoreCase("discapacidad") && discapacidad.equalsIgnoreCase("no")){
            Suma_Rango_60();
            total_pagar_descuento  = total_pagar;
        }
    }

    // método para calcular los valores si es de la tercer edad y no tiene discapacidad
    public void Calcular_Total_Pagar2(){
        if (consumo_agua >= 0 && consumo_agua <=14 && tercera_edad.equalsIgnoreCase("si") && discapacidad.equalsIgnoreCase("no")){
            gastos_pagarAgua  = 3;
            total_pagar = gastos_pagarAgua + (gastos_pagarAgua * impuesto_alcantarillado) + tasa_Rbasura + tasa_ProcesamientoD; 
            total_pagar_descuento = total_pagar - (3* 0.5f);
            descuento_edad = 50;
        } if (consumo_agua >= 15 && consumo_agua <=24 && tercera_edad.equalsIgnoreCase("si") && discapacidad.equalsIgnoreCase("no")){
            Suma_Rango_15_24();
            total_pagar_descuento = total_pagar - ( 3 * 0.30f);
            descuento_edad = 30;
        } if (consumo_agua >= 25 && consumo_agua <=39 && tercera_edad.equalsIgnoreCase("si") && discapacidad.equalsIgnoreCase("no")){
            Suma_Rango_25_39();
            total_pagar_descuento = total_pagar - ( 3 * 0.30f);
            descuento_edad = 30;
        } if (consumo_agua >= 40 && consumo_agua <=59 && tercera_edad.equalsIgnoreCase("si") && discapacidad.equalsIgnoreCase("no")){
            Suma_Rango_40_59();
            total_pagar_descuento = total_pagar - ( 3 * 0.30f);
            descuento_edad = 30;
        } if (consumo_agua >= 60 && tercera_edad.equalsIgnoreCase("si") && discapacidad.equalsIgnoreCase("no")){
            Suma_Rango_60();
            total_pagar_descuento = total_pagar - ( 3 * 0.30f);
            descuento_edad = 30;
        }
    }

    // método para calcular los valores si no es de la tercer edad y si tiene una discapacidad
    public void Calcular_Total_Pagar3(){
        if (consumo_agua >= 0 && consumo_agua <=14 && tercera_edad.equalsIgnoreCase("no") && discapacidad.equalsIgnoreCase("si")){
            gastos_pagarAgua  = 3; 
            total_pagar = gastos_pagarAgua + (gastos_pagarAgua * impuesto_alcantarillado) + tasa_Rbasura + tasa_ProcesamientoD;
            total_pagar_descuento = total_pagar - (3 * (porcentaje_discapacidad/100));
            descuento_discapacidad = porcentaje_discapacidad;
        } if (consumo_agua >= 15 && consumo_agua <=24 && tercera_edad.equalsIgnoreCase("no") && discapacidad.equalsIgnoreCase("si")){
            Suma_Rango_15_24();
            total_pagar_descuento = total_pagar - (3 * (porcentaje_discapacidad/100));
            descuento_discapacidad = porcentaje_discapacidad;
        } if (consumo_agua >= 25 && consumo_agua <=39 && tercera_edad.equalsIgnoreCase("no") && discapacidad.equalsIgnoreCase("si")){
            Suma_Rango_25_39();
            total_pagar_descuento = total_pagar - (3 * (porcentaje_discapacidad/100));
            descuento_discapacidad = porcentaje_discapacidad;
        } if(consumo_agua >= 40 && consumo_agua <=59 && tercera_edad.equalsIgnoreCase("no") && discapacidad.equalsIgnoreCase("si")){
            Suma_Rango_40_59();
            total_pagar_descuento = total_pagar - (3 * (porcentaje_discapacidad/100));
            descuento_discapacidad = porcentaje_discapacidad;
        } if(consumo_agua >= 60 && tercera_edad.equalsIgnoreCase("no") && discapacidad.equalsIgnoreCase("si")){
            Suma_Rango_60();
            total_pagar_descuento = total_pagar - (3 * (porcentaje_discapacidad/100));
            descuento_discapacidad = porcentaje_discapacidad;
        }
    }

    // método para calcular los valores si es de la tercer edad y también tiene una discapacidad
    public void Calcular_Total_Pagar4(){
        if (consumo_agua >= 0 && consumo_agua <=14 && tercera_edad.equalsIgnoreCase("si") && discapacidad.equalsIgnoreCase("si")){
            gastos_pagarAgua  = 3f; 
            total_pagar = gastos_pagarAgua + (gastos_pagarAgua * impuesto_alcantarillado) + tasa_Rbasura + tasa_ProcesamientoD;
            Suma_Descuentos_50();
        }if (consumo_agua >= 15 && consumo_agua <=24 && tercera_edad.equalsIgnoreCase("si") && discapacidad.equalsIgnoreCase("si")){
            Suma_Rango_15_24();
            Suma_Descuento_30();              
        }if (consumo_agua >= 25 && consumo_agua <=39 && tercera_edad.equalsIgnoreCase("si") && discapacidad.equalsIgnoreCase("si")){
            Suma_Rango_25_39();
            Suma_Descuento_30();

        }if (consumo_agua >= 40 && consumo_agua <=59 && tercera_edad.equalsIgnoreCase("si") && discapacidad.equalsIgnoreCase("si")){
            Suma_Rango_40_59();
            Suma_Descuento_30();
        } if (consumo_agua >= 60 && tercera_edad.equalsIgnoreCase("si") && discapacidad.equalsIgnoreCase("si")){
            Suma_Rango_60();
            Suma_Descuento_30();
        }
    }

    // método para preguntar datos
    public void preguntar_datos(){
        Scanner sc = new Scanner(System.in);
        System.out.println("El siguiente programa da un informe sobre la planilla del consumo de agua así como de otros factores");
        System.out.println("Por favor ingrese el consumo de agua realizado durante el mes");
        consumo_agua = sc.nextInt();
        sc.nextLine();
        System.out.println("Pertenece usted al grupo de personas de la tercera edad?");
        System.out.println("Si es asi, escriba 'si', sino 'no' ");
        tercera_edad = sc.nextLine();

        System.out.println("Usted tiene alguna discapacidad?");
        System.out.println("Si es asi, escriba 'si', sino 'no'");
        discapacidad = sc.nextLine();

        if (discapacidad.equalsIgnoreCase("si")){
            System.out.println("Por favor, indique el porcentaje de discapacidad que posee");
            porcentaje_discapacidad = sc.nextFloat();
        }
        sc.close();
    }

    // método ejecutable para el main
    public void ejecutar(){
        preguntar_datos();
        Suma_Descuento_30();
        Suma_Descuentos_50();
        if (tercera_edad.equalsIgnoreCase("no") && discapacidad.equalsIgnoreCase("no")){
            Calcular_Total_Pagar1();
            System.out.println("El costo a cobrar por el gasto de agua que ha realizado durante el mes es de $" + gastos_pagarAgua);
            System.out.println("El impuesto del alcantarillado es del 35% del gasto de agua realizado durante el mes. Se incluyen $" + gastos_pagarAgua * 0.35f);
            System.out.println("La tasa de recolección de basura es de $" + tasa_Rbasura);
            System.out.println("La tasa por costo de procesamiento de datos es de $" + tasa_ProcesamientoD);
            System.out.println("El total a pagar será de $" + total_pagar_descuento);

        }if (tercera_edad.equalsIgnoreCase("si") && discapacidad.equalsIgnoreCase("no")){
            Calcular_Total_Pagar2();
            System.out.println("El costo a cobrar por el gasto de agua que ha realizado durante el mes es de $" + gastos_pagarAgua);
            System.out.println("El impuesto del alcantarillado es del 35% del gasto de agua realizado durante el mes. Se incluyen $" + gastos_pagarAgua * 0.35f);
            System.out.println("El descuento por tercera edad es de " + descuento_edad + "%");
            System.out.println("La tasa de recolección de basura es de $" + tasa_Rbasura);
            System.out.println("La tasa por costo de procesamiento de datos es de $" + tasa_ProcesamientoD);
            System.out.println("El total a pagar será de $" + total_pagar_descuento);

        }if (tercera_edad.equalsIgnoreCase("no") && discapacidad.equalsIgnoreCase("si")){
            Calcular_Total_Pagar3();
            System.out.println("El costo a cobrar por el gasto de agua que ha realizado durante el mes es de $" + gastos_pagarAgua);
            System.out.println("El impuesto del alcantarillado es del 35% del gasto de agua realizado durante el mes. Se incluyen $" + gastos_pagarAgua * 0.35f);
            System.out.println("El descuento por discapacidad es de " + descuento_discapacidad + "%");
            System.out.println("La tasa de recolección de basura es de $" + tasa_Rbasura);
            System.out.println("La tasa por costo de procesamiento de datos es de $" + tasa_ProcesamientoD);
            System.out.println("El total a pagar será de $" + total_pagar_descuento);

        } if (tercera_edad.equalsIgnoreCase("si") && discapacidad.equalsIgnoreCase("si")){
            Calcular_Total_Pagar4();
            System.out.println("El costo a cobrar por el gasto de agua que ha realizado durante el mes es de $" + gastos_pagarAgua);
            System.out.println("El impuesto del alcantarillado es del 35% del gasto de agua realizado durante el mes. Se incluyen $" + gastos_pagarAgua * 0.35f);
            System.out.println("El descuento por tercera edad es de " + descuento_edad + "%");
            System.out.println("El descuento por discapacidad es de " + descuento_discapacidad + "%");
            System.out.println("Si lo descuentos superan el 100%, se lo tomara como 100%");
            System.out.println("La tasa de recolección de basura es de $" + tasa_Rbasura);
            System.out.println("La tasa por costo de procesamiento de datos es de $" + tasa_ProcesamientoD);
            System.out.println("El total a pagar será de $" + total_pagar_descuento);
        } 
    }  
}