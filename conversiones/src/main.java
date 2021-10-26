import java.util.Scanner;
public class main {


    public static void main(String[] args) {
        String infija = "";
        Scanner leer = new Scanner(System.in);
        System.out.println("Se usaran pilas para realizar las conversiones de las expresiones de notación\n");
        System.out.println("Introduce una notación infija para convertirla a prefija y postfija\n");
        infija = leer.nextLine();
        StringBuffer infijo = new StringBuffer(infija);
        System.out.println("Notacion introducida ---> " + infija + " \n");
        System.out.println("Conversiones ---> ");
        prefija(infijo);
        postfija(infijo);
    }
    public static void  prefija(StringBuffer notacion){
        StringBuffer infijo = notacion, prefijo;//Leer expresion
        Pila pila;
        prefijo = new StringBuffer();
        pila = new Pila();
        pila.push(')');
        infijo.insert(0, '(');  //

        for (int i = infijo.length()-1; i > -1; i--) {

            if (Character.isDigit(infijo.charAt(i)))
            {
                prefijo.insert(0,infijo.charAt(i));

            }else if(infijo.charAt(i) == ')'){

                pila.push(infijo.charAt(i));

            } else if (esOperador(infijo.charAt(i))){

                boolean entroIf = true;
                while (entroIf) {
                    Nodo operador = (Nodo) pila.pop();
                    System.out.println(operador.datos);
                    if (esOperador(operador.datos) && precedencia1(operador.datos,infijo.charAt(i))) {
                        prefijo.insert(0,operador.datos);
                        entroIf = true;
                    } else {
                        pila.push(operador.datos);
                        pila.push(infijo.charAt(i));
                        entroIf = false;
                    }
                }

            } else if(infijo.charAt(i) == '('){

                boolean entroIf = true;
                while (entroIf) {
                    Nodo operador = (Nodo) pila.pop();
                    System.out.println(operador.datos);
                    if (esOperador(operador.datos)) {
                        prefijo.insert(0,operador.datos);
                        entroIf = true;
                    } else {
                        System.out.println("Prefijo: " + prefijo.toString());
                        entroIf = false;
                    }
                }

            }
        }


}
    public static void postfija(StringBuffer notacion){
        StringBuffer infijo=notacion, posfija;//Leer expresion
        Pila pilau1;
        posfija = new StringBuffer();
        pilau1 = new Pila();
        pilau1.push('('); // agregar parentesis izquierdo a la pila
        infijo.append(")");  // anexar un parentesis derecho al infijo


            for(int i=0; i<infijo.length(); i++)
            {
                if (Character.isDigit(infijo.charAt(i)))
                {
                    posfija.append(infijo.charAt(i));
                }else if(infijo.charAt(i) == '('){
                    pilau1.push(infijo.charAt(i));
                } else if ( esOperador(infijo.charAt(i))){
                    boolean entroIf = true;
                    while (entroIf) {
                        Nodo operador = (Nodo) pilau1.pop();

                        if (esOperador(operador.datos) && precedencia2(infijo.charAt(i), operador.datos)) {
                            posfija.append(operador.datos);
                            entroIf = true;
                        } else {
                            pilau1.push(operador.datos);
                            pilau1.push(infijo.charAt(i));
                            entroIf = false;
                        }
                    }
                } else if(infijo.charAt(i) == ')'){
                    boolean entroIf = true;
                    while (entroIf) {
                        Nodo operador = (Nodo) pilau1.pop();

                        if (esOperador(operador.datos)) {
                            posfija.append(operador.datos);
                            entroIf = true;
                        } else {

                            System.out.println("Postfija: " + posfija.toString());
                            entroIf = false;
                        }
                    }
                }
            }
        }


    public static boolean esOperador(char c)
    {
        if(c=='+'||c=='-'||c=='*'||c=='/'||c=='^'||c=='%'){
            return true;
        }else return false;
    }

    public static boolean precedencia1(char op1, char op2){

        int valorOp1 = 0;
        int valorOp2 = 0;

        switch (op1) {
            case '+':valorOp1=3;
                break;
            case '-':valorOp1=4;
                break;
            case '*':valorOp1=1;
                break;
            case '/':valorOp1=2;
                break;

        }
        switch (op2) {
            case '+':valorOp2=3;
                break;
            case '-':valorOp2=4;
                break;
            case '*':valorOp2=1;
                break;
            case '/':valorOp2=2;
                break;
        }

        if(valorOp1<valorOp2){
            return true;
        } else{
            return false;
        }


    }
    public static boolean precedencia2(char op1, char op2){

        int valorOp1 = 0;
        int valorOp2 = 0;

        switch (op1) {
            case '+':valorOp1=3;
                break;
            case '-':valorOp1=3;
                break;
            case '*':valorOp1=1;
                break;
            case '/':valorOp1=1;
                break;
        }

        switch (op2) {
            case '+':valorOp2=3;
                break;
            case '-':valorOp2=3;
                break;
            case '*':valorOp2=1;
                break;
            case '/':valorOp2=1;
                break;
        }

        if(valorOp1>valorOp2){
            return true;
        } else{
            return false;
        }

    }
}
