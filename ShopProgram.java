import java.util.Scanner;
public class ShopProgram {
	private static int a, d, e, r; 
	private static double discount1, discount2;
	public static void introduction(Scanner hdv) {
		int b = 0;
		int c = 0;
		System.out.println("This program supports 4 functions: ");
		System.out.println("   1. Setup Shop");
		System.out.println("   2. Buy");
		System.out.println("   3. List Items");
		System.out.println("   4. Checkout");
		System.out.print("Please choose the function you want: ");
		a = hdv.nextInt();
		if ( (a == 2 || a == 3 || a == 4) && ( d != 1)){
			for (int i = 0; i < a; i--){
				System.out.println();
				System.out.println("Shop is not set up yet!");
				System.out.println();
				System.out.println("This program supports 4 functions: ");
				System.out.println("   1. Setup Shop");
				System.out.println("   2. Buy");
				System.out.println("   3. List Items");
				System.out.println("   4. Checkout");
				System.out.print("Please choose the function you want: ");
				b = hdv.nextInt();
				if (b == 1) {break;} 
			}
			a = b;
		}
		if ( a == 3 && (d == 1) && (e != 1)){
			for (int i = 0; i < a; i--){
				System.out.println();
				System.out.println("You have not bought anything!");
				System.out.println();
				System.out.println("This program supports 4 functions: ");
				System.out.println("   1. Setup Shop");
				System.out.println("   2. Buy");
				System.out.println("   3. List Items");
				System.out.println("   4. Checkout");
				System.out.print("Please choose the function you want: ");
				c = hdv.nextInt();
				if (c == 2) {break;} 
			}
			a = c;
		}
	}

	public static String numSuffix (int i){ 
		int rem = i %10;
		switch (rem){
		case 0:
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
		case 9:
			return (i + "th");
		case 1:
			if (i % 100 != 11)
				return (i + "st");
			else 
				return (i + "th");
		case 2:
			if ( i % 100 != 12)
				return (i + "nd");
			else 
				return (i + "th");
		case 3:
			if (i % 100 != 13)
				return (i + "rd");
			else 
				return (i+ "th");
		default:
			break;
		}
		return "";
	}		
	public static void setup (Scanner hdv, String[] items, double[] price, double [] packages) {
		System.out.println();
		for (int i = 0; i < price.length; i++){
			System.out.print("Enter the name of the " + numSuffix(i+1) +" product: ");
			items [i] = hdv.next();
			System.out.print("Enter the per package price of " + items [i] + ": ");
			price [i] = hdv.nextDouble();
			System.out.print("Enter the number of packages ('x') to qualify for Special Discount (buy 'x' get 1 free) for " + items [i] +", or 0 if no Special Discount offered: ");
			packages [i]= hdv.nextDouble();	
		}
		System.out.println();
		d = 1;}
	public static double additional(Scanner hdv){
		System.out.print("Enter the dollar amount to qualify for Additional Discount (or 0 if none offered): ");
		discount1 = hdv.nextDouble();
		return discount1;}
	public static double additional2(Scanner hdv){
		double o = 0;
		if (discount1 > 0){
			System.out.print("Enter the Additional Discount rate (e.g, 0.1 for 10%): ");
			discount2 = hdv.nextDouble();
			if (discount2 < 0 || discount2 > 0.5){
				for (int i = 0; i < a; i--) {
					System.out.print("Invalid input. Enter a value > 0 and <= 0.5: ");
					o = hdv.nextDouble();
					if (o <= 0.5 && o > 0) {
						break;
					}
				}
				discount2 = o;
			}

		}
		return discount2;
	}
	public static void Buysan(Scanner hdv, String[] items, double[] amounts) {
		System.out.println();
		e = 1;
		double tata = 0;
		for (int i = 0; i < items.length; i++){
			System.out.print("Enter the number of " + items[i] + " packages to buy: ");
			amounts [i] = hdv.nextDouble();
			if(amounts[i] < 0){
				for (int v =0; v < amounts.length; v--) {
					System.out.print("Invalid input. Enter a value >=0: ");
					tata = hdv.nextDouble();
					if (tata >= 0) { 
						break;}	}
				amounts[i] = tata;	
			}
		}
	}
	public static double Calculatetotal(double[] price, double[] amounts) {
		double subtotalsan = 0;
		for (int i = 0; i < price.length; i ++){
			subtotalsan += price[i] * amounts[i];
		}
		return subtotalsan;
	}
	public static double Specialdiscount1(double[] amounts, double[] price, double [] packages, double [] Specialdis, double totaldiscount3){
		Specialdis = new double[amounts.length];
		totaldiscount3 = 0;
		for (int i = 0; i < price.length; i++){
			if (amounts[i] > packages[i]){
				if (amounts.length > 0){
					if (packages[i] == 1) {
						Specialdis[i]= 0.5 * amounts[i]*price[i];
					}
					int t1 = (int) amounts[i]/ (int) (packages[i]+1); 
					Specialdis [i] = t1 * price[i];}
				totaldiscount3 += Specialdis[i];
				//}
			}}
		return totaldiscount3;
	}
	public static double Specialdiscount2(double discount3, double discount4, double subtotalsan1, double totaldiscount3){
		double newsubtotal = 0;
		newsubtotal = subtotalsan1-totaldiscount3;
		double newdiscount2 = 0;
		if (newsubtotal > discount3){
			newdiscount2 = newsubtotal * discount4;
		}
		return newdiscount2;
	}
	public static double newTotal(double newdiscount3, double newsubtotal1){
		double Finaltotal = 0;
		Finaltotal = newsubtotal1 - newdiscount3;
		return Finaltotal;
	}
	public static void List(String [] items, double [] price, double [] amounts){
		System.out.println();
		for (int i = 0; i < items.length; i++){
			if (amounts[i] > 0){
				System.out.printf("%.1f lb of %s @ $%.2f = $%.2f\n", amounts[i], items[i], price[i], price[i]*amounts[i]);
			}
			if (amounts[i] == 0 && amounts[items.length-1] == 0) {
				System.out.print("No items were purchased.");
				System.out.println();
				break;
			}
		}

	}
	public static void displayCheckout(double subtotalsan1, double totaldiscount3, double newsubtotal1, double newdiscount3, double Finaltotal1, double discount4){
		System.out.println();
		System.out.printf("Original Sub Total:                      $%.2f\n", subtotalsan1);
		if (totaldiscount3 >0){
			System.out.printf("Special Discounts:                      -$%.2f\n", totaldiscount3);}
		if (totaldiscount3 == 0){
			System.out.println("No Special Discount applied");
		}
		System.out.printf("New Sub Total:                           $%.2f\n", newsubtotal1);
		if (newdiscount3 > 0) {
			System.out.printf("Additional %.1f%% Discount:              -$%.2f\n", (discount4 * 100), newdiscount3);}
		if (newdiscount3 == 0){
			System.out.println("You did not qualify for an Additional Discount");
		}
		System.out.printf("Final Sub Total:                         $%.2f", Finaltotal1);
		System.out.println();
		System.out.println("Thanks for coming!");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner hdv = new Scanner(System.in);
		int i = 0;
		a = 0;
		r = 1;
		d = 0;
		e = 0;
		discount1 = 0;
		discount2 = 0;
		int numsell = 0;
		String[] items = new String[numsell];
		double[] price = new double[numsell];
		double[] amounts = new double[numsell];
		double [] packages = new double[numsell];
		double [] Specialdis = new double [numsell];
		double discount3 = 0;
		double discount4 = 0;
		double totaldiscount3 = 0;
		double newdiscount3 = 0;
		double Finaltotal1 = 0;
		double subtotalsan1= 0;
		double newsubtotal1 = 0;
		double re = 1;
		while (r == 1){

			introduction(hdv);

			while (a == 1) {
				System.out.print("Please enter the number of items to setup shop: ");
				numsell = hdv.nextInt();
				items = new String[numsell];
				price = new double[numsell];
				amounts = new double[numsell];
				packages = new double[numsell];
				numSuffix(i);
				setup(hdv, items, price, packages);
				discount3 = additional(hdv);
				discount4 = additional2(hdv);
				System.out.println();
				introduction(hdv);

				while (a == 2){
					Buysan(hdv, items, amounts);
					System.out.println();
					subtotalsan1 = Calculatetotal(price, amounts);
					totaldiscount3 = Specialdiscount1(amounts, price, packages, Specialdis, totaldiscount3);
					newdiscount3 = Specialdiscount2(discount3, discount4, subtotalsan1, totaldiscount3);
					newsubtotal1 = subtotalsan1 - totaldiscount3; 
					Finaltotal1 = newTotal(newdiscount3, newsubtotal1);
					introduction(hdv);

					while (a == 3){
						List(items, price, amounts);
						System.out.println();
						introduction(hdv);
					}
					if (a==4){
						displayCheckout(subtotalsan1, totaldiscount3, newsubtotal1, newdiscount3, Finaltotal1, discount4);
						System.out.println();
					}}}
			d = 0;
			e = 0;
			System.out.print("Would you like to re-run (1 for yes, 0 for no)? ");
			r = hdv.nextInt();
			System.out.println();
		}
	}
}