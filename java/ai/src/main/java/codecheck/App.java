package codecheck;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

public class App {
	public static void main(String[] args) {

		try {
			ArrayList<String> list = new ArrayList<String>();
			list.addAll(Arrays.asList(args));

			// if(list.size() <= 1){
			// 	System.out.println("");
			// 	return;
			// }
			String target = list.remove(0);

			for(String s : list) {
				String str = null;
				if(s.charAt(0) == target.charAt(str.length()-1)){
					System.out.println(s);
					return;
				}
			}

			System.out.println("");
			return;

		} catch (Exception e) {
			System.out.println("");
		}
	}
}