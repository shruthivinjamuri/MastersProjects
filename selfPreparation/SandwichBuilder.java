package selfPreparation;

//make this class immutable
//also using a static class allows us to create a dynamic object
public class SandwichBuilder {

	public static class Builder{
		private String bread;
		private String dressing;
		private String veggies;
		private String meat;
		
		public  Builder(){
			
		}
		
		public Builder bread(String bread){
			this.bread = bread;
			return this;
		}
		
		public Builder meat(String meat){
			this.meat = meat;
			return this;
		}
		
		public Builder dressing(String dressing){
			this.dressing = dressing;
			return this;
		}
		
		public Builder veggies(String veggies){
			this.veggies = veggies;
			return this;
		}
		
		
	}
	
	private final String bread;
	private final String dressing;
	private final String veggies;
	private final String meat;
	
	public SandwichBuilder(Builder builder){
		bread = builder.bread;
		dressing = builder.dressing;
		veggies = builder.veggies;
		meat = builder.meat;
	}
	
	public String getBread(){
		return bread;
	}
	public String getDressing(){
		return dressing;
	}
	public String getVeggies(){
		return veggies;
	}
	public String getMeat(){
		return meat;
	}
	
	
}
