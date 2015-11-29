package mainPackage;


import java.lang.Object;
import org.apache.poi.ss.formula.functions.FinanceLib;
import java.util.Scanner;



public class Main {

	public static void main(String[] args) {
		//declare variables
		double Income;
		double SSImonthly;
		double yearsOfWork;
		double yearsRetirement;
		double annualreturnInv;
		double annualreturnRet;
		
		//new variables for PV use
		double r; 
		double n; 
		double f; 
		double p;
		double y;
		boolean t;
		
		
		//Getting input 
		Scanner input = new Scanner(System.in);
		
	
		//User inputs
		System.out.print("Please enter how many years you plan to work: ");
		yearsOfWork = input.nextDouble();
		
		System.out.print("Please enter how many years you plan to be retired: ");
		yearsRetirement = input.nextDouble();
		
		
		
		System.out.print("Please enter the percent average annual return for investment: ");
		double InvReturn = input.nextDouble();
		annualreturnInv = InvReturn / 100;
		
		
		System.out.print("Please enter the percent average anual return for retirement: ");
		double RetReturn = input.nextDouble();
		annualreturnRet = RetReturn / 100;
		
		
		System.out.print("Please enter your yearly income when retired: ");
		Income = input.nextDouble();
		
		System.out.print("Please enter your monthly Social Security Income once retired:");
		SSImonthly = input.nextDouble();
		
		input.close();
				
		
		//PV and PMT calculations
		
		double PV;
		r = (annualreturnRet / 12);
		n = yearsRetirement * 12;
		y = Income - SSImonthly;
		f = 0;
		t = false;

		PV = FinanceLib.pv(r, n, y, f, t);
		System.out.printf("You must save an amount of: $%.2f. \n", PV);


		double PMT;
		r = (annualreturnInv / 12);
		n = yearsOfWork * 12;
		p = 0;
		f = PV;
		t = false;

		PMT = FinanceLib.pmt(r, n, p, f, t);
		System.out.printf("Each month, you must save: $%.2f.", PMT);

		input.close();
	}				
	
		
		
		

}