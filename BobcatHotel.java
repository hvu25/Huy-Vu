
import java.util.Scanner;

public class BobcatHotel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double AAAdiscount = 0, clubmemberdiscount = 0, pretotalcost, roomcost = 0, mealcost = 0, totalcost, t = 0, o = 0;
		int meal, room, guest, night, AAAmember, clubmember;
		Scanner hdv = new Scanner (System.in);
		System.out.println("ROOM OPTIONS");
		System.out.println("1. Single @ $50.50 per night");
		System.out.println("2. Double @ $75.00 per night");
		System.out.println("3. Queen @ 100.75 per night");
		System.out.println("4. King @ $150.25 per night");
		System.out.println("5. Master Suite @ $225.50 per night");
		System.out.println();
		System.out.print("Number of guests: ");
		guest = hdv.nextInt();
		System.out.print("Please enter your choice of room (enter 1/2/3/4/5 corresponding to the options shown above): ");
		room = hdv.nextInt();
		System.out.print("Please enter the number of nights: ");
		night = hdv.nextInt();
		System.out.print("Are you a AAA member (enter 1 for yes, 0 for no)? ");
		AAAmember = hdv.nextInt();
		System.out.print("Are you a club member (enter 1 for yes, 0 for no)? ");
		clubmember = hdv.nextInt();
		switch (room) {
		case 1:
			t = 50.50;
			break;
		case 2:
			t = 75.00;
			break;
		case 3:
			t = 100.75;
			break;
		case 4:
			t = 150.25;
			break;
		case 5:
			t = 225.50;
			break;
		}
		roomcost = t * night;
		boolean member1 = (clubmember == 1);
		if (member1) {
			int pick =(int) (Math.random()*11);
			if (pick >=4) {
				int uu = night/4;
				System.out.println();
				System.out.println("Congratulations! You've qualified for our \"Stay 4 nights get 5th free promotion\". Discount will be applied during checkout depending on the number of days");
				clubmemberdiscount = t * uu;
			}
			else {
				System.out.println();
				System.out.println("Unfortunately, you didn't qualify for our \"Stay 4 nights get 5th free promotion\". Better luck next time!");
				clubmemberdiscount = 0;
			}
		}
		else  { 
			clubmemberdiscount = 0;
		}
		System.out.println();

		if(room != 5) {
			System.out.println("MEAL PACKAGES (PRICES SHOWN ARE PER NIGHT)");
			System.out.println("0. Complementary @ $0 per guest");
			System.out.println("1. Standard @ $30 per guest");
			System.out.println("2. Deluxe @ $50 per guest");
		}
		else  {
			System.out.println("MEAL PACKAGES (PRICES SHOWN ARE PER NIGHT)");
			System.out.println("0. Complementary @ $0 per guest");
			System.out.println("1. Standard @ $30 per guest");
			System.out.println("2. Deluxe @ $50 per guest");
			System.out.println("3. Indulgence @ $85 per guest");
		}
		System.out.println();
		if (room != 5){
			System.out.print("Please select your desired meal package (enter 0/1/2 corresponding to the options shown above): ");
		}
		else {
			System.out.print("Please select your desired meal package (enter 0/1/2/3 corresponding to the options shown above): ");
		}
		meal = hdv.nextInt();
		switch (meal){
		case 0:
			o = 0;
			break;
		case 1:
			o = 30;
			break;
		case 2:
			o = 50;
			break;
		case 3:
			o = 85;
			break;
		}
		mealcost = o * guest * night;
		pretotalcost = roomcost + mealcost;
		boolean member = (AAAmember == 1);
		if (member) {
			AAAdiscount = pretotalcost * 0.1;
		}
		else { 
			AAAdiscount = 0; 
		}
		totalcost = pretotalcost - AAAdiscount - clubmemberdiscount;
		System.out.println();
		System.out.println("CHECKOUT");
		System.out.println("Room Cost:\t\t$" + roomcost);
		if (mealcost > 0) {
			System.out.println("Meal Cost:\t       +$" + mealcost);
		}
		System.out.println("Preliminary Total Cost: $" + pretotalcost);
		if (AAAdiscount > 0) {
			System.out.println("AAA Discount:\t       -$" + AAAdiscount);
		}

		if (clubmemberdiscount > 0) {
			System.out.println("Club Member Discount:  -$" + clubmemberdiscount);
		}

		if ((clubmemberdiscount == 0)&&(AAAdiscount == 0)) {
			System.out.println("No Discounts Applied");
		}
		System.out.print("Total Cost of Booking: \t$" + totalcost);

	}
}



