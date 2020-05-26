package lab1;

import java.util.InputMismatchException;
import java.util.Scanner;
//
//CONVENTIONS...
//
//����� �� ���������� � �������:
//������� �� ������������ � ��������� �������� � ����� �����; ����� �������� ���� � ����� ������� � ������ ����� � �������� �����. �������� numGolfBalls.
//
//����� �� ������� � ���������:
//������� �� ��������� � ����������� �������� � ������ �����; ����� �������� ���� � ����� ������� � ������ ����� � �������� �����. �������� RedBlackTree.
//
//����� �� ���������:
//������� �� ��������� �� � ������ ������ �����; �������� ���� � ���� ��� �� ��������� � �����������. �������� MAX_NODES ��� MIN_SIDE_LEN. 
//�� ������������ � �� �� �������� � �������� �� �����.
//
//������������ �� ��������, ���������/�������� �� ��������:
//����������� �������� �� ����� �� ���������� (������, �������), � �������� �� ����� �� �������. 
//�������� int numStudents ��� double probability, ������ int countStudents() ��� double getProbability().
//
//������� �����:
//���������� ����� � �� ����� ���, ��������� ��� ������ �� ��������, �� ����� ����������. 
//����������� � �� ������� ���, ��� ������ ����������, � ����� � ��������, ����� �������.
//
//���������:
//��������� ������ ��������� ����� ������ ����� ���. 
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
            System.out.println("��������������� � ��-����� �� 0 � ���� �������.");
        } else if (D == 0) {
            x = (b * (-1)) / (2 * a);
            System.out.println("��������������� e ����� �� 0 � ����������� ��� 1 ������ �����. X = " + x);
        } else if (D > 0) {
            x1 = ((-b) + Math.sqrt(D)) / (2 * a);
            x2 = ((-b) - Math.sqrt(D)) / (2 * a);
            System.out.println("��������������� e ��-������ �� 0 � ����������� ��� 2 ������ ������. �1 = " + x1 + ", X2 = " + x2);
        }
        return D;
    }
    
    public static void inputData(Scanner input) throws NumberFormatException, InputMismatchException{
    	System.out.print("������ ���������� 1: ");
        double a = Double.parseDouble(input.nextLine());
        System.out.print("������ ���������� 2: ");
        double b = Double.parseDouble(input.nextLine());
        System.out.print("������ ���������� 3: ");
        double c = Double.parseDouble(input.nextLine());
        
        System.out.println(discriminant(a, b, c));
    }
}