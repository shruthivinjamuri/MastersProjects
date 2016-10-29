package selfPreparation;

public class HelloWorld {

	public static void main(String [] args){
		System.out.println("Poda Patti!!");
		SandwichBuilder.Builder build = new SandwichBuilder.Builder();
		build.bread("wheat").veggies("tomato").meat("pork").bread("new bread");
		SandwichBuilder sandwich = new SandwichBuilder(build);
		//build.bread("bread").dressing("dress").veggies("veggies").meat("meat");
		SandwichBuilder sand = new SandwichBuilder(build);
		
		System.out.println(sandwich.getBread());
		System.out.println(sandwich.getMeat());
		System.out.println(sandwich.getDressing());
		System.out.println(sandwich.getVeggies());
		
		System.out.println(sand.getBread());
		System.out.println(sand.getMeat());
		System.out.println(sand.getDressing());
		System.out.println(sand.getVeggies());
	}
}
