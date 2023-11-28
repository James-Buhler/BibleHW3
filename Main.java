package pac;

public class Main {

	public static void main(String[] args) {
		HumanBeings world = new HumanBeings(7700000000L, 18);
		int yearCount = 0;
		int AD = 2022;
		outlet(yearCount, AD);
		world.Initiate(13, 30);
		while(world.TotalDisciples < world.TotalPopulation) {
			yearCount++;
			AD++;
			outlet(yearCount, AD);
			world.OneYearPass();
		}
	}
	
	public static void outlet(int yearCount, int AD) {
		System.out.println("This is year " + yearCount + ", at AD" + AD);
	}

}
