package selfPreparation;

public class ReverseStringSpaces {

	public static void main(String[] args) {
		System.out.println(reverse("q abbbb xc cd ee q"));

	}
	
	public static String reverse(String str){
		if(str == null || str.length() == 0)
			return str;
		char[] arr = str.toCharArray();
		int i=0;
		int j=str.length()-1;
		while(i < j){
			while(i<j && arr[i]==' ') i++;
			while(i<j && arr[j]==' ') j--;
			char temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
		
		return new String(arr);
	}

}
