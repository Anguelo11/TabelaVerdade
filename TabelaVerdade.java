import java.util.Scanner;

public class TabelaVerdade {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        boolean pass1 = false, pass2 = false, pass3 = false;
        String n1 = "", n2 = "", operator = "";
        while (!pass1) {
            System.out.println("Digite uma proposição (Qualquer letra)");
            n1 = in.next();
            
            try {
                Integer.parseInt(n1);
                System.out.println("Você digitou um número!!! digite uma proposição (ex: P)");
            } catch (NumberFormatException e) {
                pass1 = true;
            }
        }

        while (!pass2) {
            System.out.println("Digite um operador lógico (E, OU, ->, <->)");
            operator = in.next();
            if ("E".equalsIgnoreCase(operator) || "OU".equalsIgnoreCase(operator) || "->".equalsIgnoreCase(operator) || "<->".equalsIgnoreCase(operator)) {

                pass2 = true;
            } else {
                System.out.println("Você não digitou um dos operadores E, OU, ->, <->");
            }
        }

        while (!pass3) {
            System.out.println("Digite uma proposição (Qualquer letra)");
            n2 = in.next();
            if (n2.equalsIgnoreCase(n1)) {
                System.out.println("Você digitou uma proposição igual, digite outra (ex: Q):");
            } else {

                try {
                    Integer.parseInt(n2);
                    System.out.println("Você digitou um número!!! digite uma proposição (ex: Q): ");
  
                } catch (NumberFormatException e) {
                    pass3 = true;
                }
            }
        }
        

        boolean[] valoresN1 = {true, true, false, false};
        boolean[] valoresN2 = {true, false, true, false};

        System.out.println("-------------------------------");

        System.out.printf("| %-7s | %-7s | %-7s |%n", n1 , n2 , n1 + " " + operator + " " + n2);

        System.out.println("-------------------------------");        

        for (int i = 0; i < 4; i++) {
            boolean resultado = false;

            if (operator.equalsIgnoreCase("E" )) {
                resultado = valoresN1[i] && valoresN2[i];
            }

            if (operator.equalsIgnoreCase("OU")) {
                resultado = valoresN1[i] || valoresN2[i];
            }

            if (operator.equals("->")) {
                resultado = !valoresN1[i] || valoresN2[i]; 
            }

            if (operator.equals("<->")) {
                resultado = valoresN1[i] == valoresN2[i]; 
            }

            System.out.printf("| %-7s | %-7s | %-7s |%n", valoresN1[i], valoresN2[i], resultado);
            System.out.println("-------------------------------");
        }

    }
}
