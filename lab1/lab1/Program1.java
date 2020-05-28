package lab1;

import java.util.InputMismatchException;
import java.util.Scanner;
//
//CONVENTIONS...
//
//Имена на променливи и функции:
//Имената на променливите и функциите започват с малка буква; всяка следваща дума в името започва с главна буква с останали малки. Примерно numGolfBalls.
//
//Имена на класове и структури:
//Имената на класовете и структурите започват с главна буква; всяка следваща дума в името започва с главна буква с останали малки. Примерно RedBlackTree.
//
//Имена на константи:
//Имената на константи са с изцяло главни букви; различни думи в едно име са разделени с подчертавки. Примерно MAX_NODES или MIN_SIDE_LEN. 
//За предпочитане е да са изведени в началото на сорса.
//
//Променливите са предмети, функциите/методите са действия:
//Използвайте предмети за имена на променливи (масиви, класове), и действия за имена на функции. 
//Например int numStudents или double probability, докато int countStudents() или double getProbability().
//
//Къдрави скоби:
//Отварящата скоба е на същия ред, разделена със шпация от елемента, на който принадлежи. 
//Затварящата е на отделен ред, със същата индентация, с която е елемента, който затваря.
//
//Коментари:
//Оставяйте кратки коментари преди сложно парче код. 
//

public class Program1 {
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
        	inputData(input);
        }catch(NumberFormatException nfe) {
        	System.out.println("Invalid input");
        }catch(InputMismatchException ime) {
        	System.out.println("Invalid input");
        }
        input.close();
    }

    public static double discriminant(double a, double b, double c) {
        double x1, x2, x;
        double D = b * b - 4 * a * c;

        if (D < 0) {
            System.out.println("Дискриминантата е по-малка от 0 и няма решение.");
        } else if (D == 0) {
            x = (b * (-1)) / (2 * a);
            System.out.println("Дискриминантата e равна на 0 и уравнението има 1 реален корен. X = " + x);
        } else if (D > 0) {
            x1 = ((-b) + Math.sqrt(D)) / (2 * a);
            x2 = ((-b) - Math.sqrt(D)) / (2 * a);
            System.out.println("Дискриминантата e по-голяма от 0 и уравнението има 2 реални корена. Х1 = " + x1 + ", X2 = " + x2);
        }
        return D;
    }
    
    public static void inputData(Scanner input) throws NumberFormatException, InputMismatchException{
    	System.out.print("Въведи променлива 1: ");
        double a = Double.parseDouble(input.nextLine());
	    
        System.out.print("Въведи променлива 2: ");
        double b = Double.parseDouble(input.nextLine());
	    
        System.out.print("Въведи променлива 3: ");
        double c = Double.parseDouble(input.nextLine());
        
        System.out.println(discriminant(a, b, c));
    }
}
