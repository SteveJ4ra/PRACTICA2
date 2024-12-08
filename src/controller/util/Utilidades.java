package controller.util;

public class Utilidades {
    public static boolean validate(String num) {
        boolean band = true;
        if(num.charAt(0) == '-') {
            num = num.substring(1);
        }
        //System.out.println(num);
        int cont_p = 0;
        for(int i = 0; i < num.length(); i++){
            if(!Character.isDigit(num.charAt(i)) && num.charAt(i) != '.') {
                band = false;
                break;
            } else if(num.charAt(i) == '.')
                cont_p++;
        }
        if(cont_p >= 2 )
            band = false;
        return band;
    }
    public static int transformStringInt(String num) {
        int resp = 0;
        if(Utilidades.validate(num)) {
            resp = (int)Utilidades.transformStringFloat(num);//Integer.parseInt(num);
        }
        return resp;
    }

    public static double transformStringDouble(String num) {
        double resp = 0;
        if(Utilidades.validate(num)) {
            resp = Double.parseDouble(num);
        }
        return resp;
    }

    public static float transformStringFloat(String num) {
        float resp = 0;
        if(Utilidades.validate(num)) {
            resp = Float.parseFloat(num);
        }
        return resp;
    }
}