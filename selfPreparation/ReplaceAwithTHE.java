package selfPreparation;

public class ReplaceAwithTHE {

	public static void main(String[] args) {
		simpleReplace("a a place ");
		replace("a plc    tat   a a th a");

	}
	public static void simpleReplace(String str){
		//String input = str.replaceAll(" a "," the ");
		String[] input = str.split(" ");
		String output ="";
		for(int i = 0;i<input.length;i++){
			if(input[i].equals("a")){
				output+="the ";
			}
			else {
				output+= input[i]+" ";
			}
			
		}
		System.out.println(output);
	}
	
	public static void replace(String str) {
		StringBuilder sb = new StringBuilder();
		for(int idx=0;idx<str.length();idx++){
			if(str.charAt(idx)=='a'){
				if((idx-1<0 || str.charAt(idx-1) == ' ') && (idx+1>=str.length() || str.charAt(idx+1)==' ')){
					sb.append("the");
				}
				else {
					sb.append('a');
				}
			}
			else{
				sb.append(str.charAt(idx));
			}
		}
		System.out.println(sb.toString());
	}

}
