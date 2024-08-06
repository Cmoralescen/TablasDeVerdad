import java.util.Scanner;

public class TablasDeVerdad {

    // #region Main Class
    public static void main(String[] args) {
        System.setProperty("file.encoding", "UTF-8");
        Scanner scanner = new Scanner(System.in);
        System.out.println(
                "--------------------------------------Bienvenid@s al generador de tablas de verdad---------------------------------------");

        System.out.println("Seleccione el número de variables para la preposición (2 o 3):");
        int numVariables = scanner.nextInt();

        if (numVariables != 2 && numVariables != 3) {
            System.out.println("Número de variables no válido. Terminando.");
            scanner.close();
            return;
        }

        int option;
        do {
            if (numVariables == 2) {
                System.out.println("Seleccione una opción:");
                System.out.println("1) ¬p");
                System.out.println("2) ¬q");
                System.out.println("3) p∧q");
                System.out.println("4) p∨q");
                System.out.println("5) p⊕q");
                System.out.println("6) p↔q");
                System.out.println("7) p→q");
                System.out.println("8) Salir");
                System.out.print("Opción: ");
                option = scanner.nextInt();

                switch (option) {
                    case 1:
                        printNotTableP();
                        break;
                    case 2:
                        printNotTableQ();
                        break;
                    case 3:
                        printAndTable();
                        break;
                    case 4:
                        printOrTable();
                        break;
                    case 5:
                        printXorTable();
                        break;
                    case 6:
                        printXnorTable();
                        break;
                    case 7:
                        printImplicationTable();
                        break;
                    case 8:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción no reconocida. Por favor, intente de nuevo.");
                }
            } else {
                System.out.println("Seleccione una opción:");
                System.out.println("1) p∧q →r");
                System.out.println("2) p∧q∧r");
                System.out.println("3) p∧q∨r");
                System.out.println("4) p∨q∧r");
                System.out.println("5) p∨q→r");
                System.out.println("6) p∨q∨r");
                System.out.println("7) p→q∨r");
                System.out.println("8) p→q∧r");
                System.out.println("9) p↔q∧r");
                System.out.println("10) p↔q∨r");
                System.out.println("11) p↔q→r");
                System.out.println("12) p→q↔r");
                System.out.println("13) p→q→r");
                System.out.println("14) p∨q↔r");
                System.out.println("15) p∧q↔r");
                System.out.println("16) Salir");
                System.out.print("Opción: ");
                option = scanner.nextInt();

                switch (option) {
                    case 1:
                        printAndImpliesTable();
                        break;
                    case 2:
                        printAndTableThreeVars();
                        break;
                    case 3:
                        printAndOrTable();
                        break;
                    case 4:
                        printOrAndTable();
                        break;
                    case 5:
                        printOrImpliesTable();
                        break;
                    case 6:
                        printOrTableThreeVars();
                        break;
                    case 7:
                        printImpliesOrTable();
                        break;
                    case 8:
                        printImpliesAndTable();
                        break;
                    case 9:
                        printBiconditionalAndTable();
                        break;
                    case 10:
                        printBiconditionalOrTable();
                        break;
                    case 11:
                        printBiconditionalImpliesTable();
                        break;
                    case 12:
                        printImpliesBiconditionalTable();
                        break;
                    case 13:
                        printImpliesImpliesTable();
                        break;
                    case 14:
                        printOrBiconditionalTable();
                        break;
                    case 15:
                        printAndBiconditionalTable();
                        break;
                    case 16:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción no reconocida. Por favor, intente de nuevo.");
                }
            }
        } while (option != (numVariables == 2 ? 8 : 16));

        scanner.close();
    }
    // #endregion

    // #region 2 variables
    private static void printNotTableP() {
        int n = 1;
        boolean p = true;
        int row = (int) Math.pow(2, n);

        System.out.println("-------------------");
        System.out.println("p       Resultado");
        System.out.println("-------------------");
        for (int x = 0; x < row; x++) {
            System.out.println(showValue(p) + "\t" + showValue(!p));
            p = !p;
        }
        System.out.println("-------------------");
    }

    private static void printNotTableQ() {
        int n = 1;
        boolean q = true;
        int row = (int) Math.pow(2, n);

        System.out.println("-------------------");
        System.out.println("q       Resultado");
        System.out.println("-------------------");
        for (int x = 0; x < row; x++) {
            System.out.println(showValue(q) + "\t" + showValue(!q));
            q = !q;
        }
        System.out.println("-------------------");
    }

    private static void printAndTable() {
        int n = 2, count = 0;
        boolean p = true, q = true;
        int row = (int) Math.pow(2, n);

        System.out.println("----------------------------------");
        System.out.println("p       q       Resultado");
        System.out.println("----------------------------------");
        for (int x = 0; x < row; x++) {
            System.out.println(showValue(p) + "\t" + showValue(q) + "\t" + showValue(p && q));
            q = !q;
            count++;
            if (count >= row / 2) {
                p = false;
            }
        }
        System.out.println("----------------------------------");
    }

    private static void printOrTable() {
        int n = 2, count = 0;
        boolean p = true, q = true;
        int row = (int) Math.pow(2, n);

        System.out.println("----------------------------------");
        System.out.println("p       q       Resultado");
        System.out.println("----------------------------------");
        for (int x = 0; x < row; x++) {
            System.out.println(showValue(p) + "\t" + showValue(q) + "\t" + showValue(p || q));
            q = !q;
            count++;
            if (count >= row / 2) {
                p = false;
            }
        }
        System.out.println("----------------------------------");
    }

    private static void printXorTable() {
        int n = 2, count = 0;
        boolean p = true, q = true;
        int row = (int) Math.pow(2, n);

        System.out.println("----------------------------------");
        System.out.println("p       q       Resultado");
        System.out.println("----------------------------------");
        for (int x = 0; x < row; x++) {
            System.out.println(showValue(p) + "\t" + showValue(q) + "\t" + showValue(p ^ q));
            q = !q;
            count++;
            if (count >= row / 2) {
                p = false;
            }
        }
        System.out.println("----------------------------------");
    }

    private static void printXnorTable() {
        int n = 2, count = 0;
        boolean p = true, q = true;
        int row = (int) Math.pow(2, n);

        System.out.println("----------------------------------");
        System.out.println("p       q       Resultado");
        System.out.println("----------------------------------");
        for (int x = 0; x < row; x++) {
            System.out.println(showValue(p) + "\t" + showValue(q) + "\t" + showValue(!(p ^ q)));
            q = !q;
            count++;
            if (count >= row / 2) {
                p = false;
            }
        }
        System.out.println("----------------------------------");
    }

    private static void printImplicationTable() {
        int n = 2, count = 0;
        boolean p = true, q = true;
        int row = (int) Math.pow(2, n);

        System.out.println("----------------------------------");
        System.out.println("p       q       Resultado");
        System.out.println("----------------------------------");
        for (int x = 0; x < row; x++) {
            System.out.println(showValue(p) + "\t" + showValue(q) + "\t" + showValue(!p || q));
            q = !q;
            count++;
            if (count >= row / 2) {
                p = false;
            }
        }
        System.out.println("----------------------------------");
    }

    private static String showValue(boolean value) {
        return value ? "V" : "F";
    }
    // #endregion

    // #region 3 variables
    private static void printAndImpliesTable() {
        int n = 3;
        int row = (int) Math.pow(2, n);

        System.out.println("------------------------------------------");
        System.out.println("p       q       r       Resultado");
        System.out.println("------------------------------------------");
        for (int x = 0; x < row; x++) {
            boolean p = (x & 4) != 0;
            boolean q = (x & 2) != 0;
            boolean r = (x & 1) != 0;
            boolean T = !(p && q) || r;
            System.out.println(showValue(p) + "\t" + showValue(q) + "\t" + showValue(r) + "\t" + showValue(T));
        }
        System.out.println("------------------------------------------");
    }

    private static void printAndTableThreeVars() {
        int n = 3;
        int row = (int) Math.pow(2, n);

        System.out.println("------------------------------------------");
        System.out.println("p       q       r       Resultado");
        System.out.println("------------------------------------------");
        for (int x = 0; x < row; x++) {
            boolean p = (x & 4) != 0;
            boolean q = (x & 2) != 0;
            boolean r = (x & 1) != 0;
            boolean T = p && q && r;
            System.out.println(showValue(p) + "\t" + showValue(q) + "\t" + showValue(r) + "\t" + showValue(T));
        }
        System.out.println("------------------------------------------");
    }

    private static void printAndOrTable() {
        int n = 3;
        int row = (int) Math.pow(2, n);

        System.out.println("------------------------------------------");
        System.out.println("p       q       r       Resultado");
        System.out.println("------------------------------------------");
        for (int x = 0; x < row; x++) {
            boolean p = (x & 4) != 0;
            boolean q = (x & 2) != 0;
            boolean r = (x & 1) != 0;
            boolean T = (p && q) || r;
            System.out.println(showValue(p) + "\t" + showValue(q) + "\t" + showValue(r) + "\t" + showValue(T));
        }
        System.out.println("------------------------------------------");
    }

    private static void printOrAndTable() {
        int n = 3;
        int row = (int) Math.pow(2, n);

        System.out.println("------------------------------------------");
        System.out.println("p       q       r       Resultado");
        System.out.println("------------------------------------------");
        for (int x = 0; x < row; x++) {
            boolean p = (x & 4) != 0;
            boolean q = (x & 2) != 0;
            boolean r = (x & 1) != 0;
            boolean T = p || (q && r);
            System.out.println(showValue(p) + "\t" + showValue(q) + "\t" + showValue(r) + "\t" + showValue(T));
        }
        System.out.println("------------------------------------------");
    }

    private static void printOrImpliesTable() {
        int n = 3;
        int row = (int) Math.pow(2, n);

        System.out.println("------------------------------------------");
        System.out.println("p       q       r       Resultado");
        System.out.println("------------------------------------------");
        for (int x = 0; x < row; x++) {
            boolean p = (x & 4) != 0;
            boolean q = (x & 2) != 0;
            boolean r = (x & 1) != 0;
            boolean T = (x == 0) || (x == 1) || (x == 3) || (x == 5) || (x == 7);

            System.out.println(showValue(p) + "\t" + showValue(q) + "\t" + showValue(r) + "\t" + showValue(T));
        }
        System.out.println("------------------------------------------");
    }

    private static void printOrTableThreeVars() {
        int n = 3;
        int row = (int) Math.pow(2, n);

        System.out.println("------------------------------------------");
        System.out.println("p       q       r       Resultado");
        System.out.println("------------------------------------------");
        for (int x = 0; x < row; x++) {
            boolean p = (x & 4) != 0;
            boolean q = (x & 2) != 0;
            boolean r = (x & 1) != 0;
            boolean T = p || q || r;
            System.out.println(showValue(p) + "\t" + showValue(q) + "\t" + showValue(r) + "\t" + showValue(T));
        }
        System.out.println("------------------------------------------");
    }

    private static void printImpliesOrTable() {
        int n = 3;
        int row = (int) Math.pow(2, n);

        System.out.println("------------------------------------------");
        System.out.println("p       q       r       Resultado");
        System.out.println("------------------------------------------");
        for (int x = 0; x < row; x++) {
            boolean p = (x & 4) != 0;
            boolean q = (x & 2) != 0;
            boolean r = (x & 1) != 0;
            boolean T = !p || (q || r);
            System.out.println(showValue(p) + "\t" + showValue(q) + "\t" + showValue(r) + "\t" + showValue(T));
        }
        System.out.println("------------------------------------------");
    }

    private static void printImpliesAndTable() {
        int n = 3;
        int row = (int) Math.pow(2, n);

        System.out.println("------------------------------------------");
        System.out.println("p       q       r       Resultado");
        System.out.println("------------------------------------------");
        for (int x = 0; x < row; x++) {
            boolean p = (x & 4) != 0;
            boolean q = (x & 2) != 0;
            boolean r = (x & 1) != 0;
            boolean T = !p || (q && r);
            System.out.println(showValue(p) + "\t" + showValue(q) + "\t" + showValue(r) + "\t" + showValue(T));
        }
        System.out.println("------------------------------------------");
    }

    private static void printBiconditionalAndTable() {
        int n = 3;
        int row = (int) Math.pow(2, n);

        System.out.println("------------------------------------------");
        System.out.println("p       q       r       Resultado");
        System.out.println("------------------------------------------");
        for (int x = 0; x < row; x++) {
            boolean p = (x & 4) != 0;
            boolean q = (x & 2) != 0;
            boolean r = (x & 1) != 0;
            boolean T = (x == 0) || (x == 1) || (x == 2) || (x == 7);
            System.out.println(showValue(p) + "\t" + showValue(q) + "\t" + showValue(r) + "\t" + showValue(T));
        }
        System.out.println("------------------------------------------");
    }

    private static void printBiconditionalOrTable() {
        int n = 3;
        int row = (int) Math.pow(2, n);
    
        System.out.println("------------------------------------------");
        System.out.println("p       q       r       Resultado");
        System.out.println("------------------------------------------");
        for (int x = 0; x < row; x++) {
            boolean p = (x & 4) != 0;
            boolean q = (x & 2) != 0;
            boolean r = (x & 1) != 0;
    
            // Modificar la lógica para obtener el resultado deseado
            boolean T = !p && !q && !r || (p && !q && r) || (p && q && !r) || (p && q && r);
    
            System.out.println(showValue(p) + "\t" + showValue(q) + "\t" + showValue(r) + "\t" + showValue(T));
        }
        System.out.println("------------------------------------------");
    }

    private static void printOrBiconditionalTable() {
        int n = 3;
        int row = (int) Math.pow(2, n);
    
        System.out.println("------------------------------------------");
        System.out.println("p       q       r       Resultado");
        System.out.println("------------------------------------------");
        for (int x = 0; x < row; x++) {
            boolean p = (x & 4) != 0;
            boolean q = (x & 2) != 0;
            boolean r = (x & 1) != 0;
            boolean resultado = (!p && !q && !r) || (!p && q && r) || (p && !q && r) || (p && q && r);
            System.out.println(showValue(p) + "\t" + showValue(q) + "\t" + showValue(r) + "\t" + showValue(resultado));
        }
        System.out.println("------------------------------------------");
    }

    private static void printBiconditionalImpliesTable() {
        int n = 3;
        int row = (int) Math.pow(2, n);
    
        System.out.println("------------------------------------------");
        System.out.println("p       q       r       Resultado");
        System.out.println("------------------------------------------");
        boolean[] resultados = {false, false, true, false, true, true, false, true};
    
        for (int x = 0; x < row; x++) {
            boolean p = (x & 4) != 0;
            boolean q = (x & 2) != 0;
            boolean r = (x & 1) != 0;
            boolean T = resultados[x];
    
            System.out.println(showValue(p) + "\t" + showValue(q) + "\t" + showValue(r) + "\t" + showValue(T));
        }
        System.out.println("------------------------------------------");
    }

    private static void printAndBiconditionalTable() {
        int n = 3;
        int row = (int) Math.pow(2, n);
    
        System.out.println("------------------------------------------");
        System.out.println("p       q       r       Resultado");
        System.out.println("------------------------------------------");
        for (int x = 0; x < row; x++) {
            boolean p = (x & 4) != 0;
            boolean q = (x & 2) != 0;
            boolean r = (x & 1) != 0;
            boolean T = (p && !q && !r) || (!p && q && !r) || (!p && !q && !r) || (p && q && r);
    
            System.out.println(showValue(p) + "\t" + showValue(q) + "\t" + showValue(r) + "\t" + showValue(T));
        }
        System.out.println("------------------------------------------");
    }

    private static void printImpliesBiconditionalTable() {
        int n = 3;
        int row = (int) Math.pow(2, n);
    
        System.out.println("------------------------------------------");
        System.out.println("p       q       r       Resultado");
        System.out.println("------------------------------------------");
        for (int x = 0; x < row; x++) {
            boolean p = (x & 4) != 0;
            boolean q = (x & 2) != 0;
            boolean r = (x & 1) != 0;
            boolean T = (!p && !q && r) || (!p && q && r) || (p && !q && !r) || (p && q && r);
            System.out.println(showValue(p) + "\t" + showValue(q) + "\t" + showValue(r) + "\t" + showValue(T));
        }
        System.out.println("------------------------------------------");
    }

    private static void printImpliesImpliesTable() {
        int n = 3;
        int row = (int) Math.pow(2, n);
    
        System.out.println("------------------------------------------");
        System.out.println("p       q       r       Resultado");
        System.out.println("------------------------------------------");
        for (int x = 0; x < row; x++) {
            boolean p = (x & 4) != 0;
            boolean q = (x & 2) != 0;
            boolean r = (x & 1) != 0;
            boolean T = (p && !q) || r;  
            System.out.println(showValue(p) + "\t" + showValue(q) + "\t" + showValue(r) + "\t" + showValue(T));
        }
        System.out.println("------------------------------------------");
    }
    // #endregion
}
