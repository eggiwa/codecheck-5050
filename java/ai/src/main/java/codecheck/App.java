package codecheck;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

public class App {
	public static void main(String[] args) {

		if(args.length<1){
			System.out.println("");
			return;
		}
		ArrayList<String> list = new ArrayList<String>();
		list.addAll(Arrays.asList(args));

		if(list.size() <= 1){
			System.out.println("");
			return;
		}
		String target = list.remove(0);

		for(String s : list) {
			if(s.charAt(0) == target.charAt(target.length()-1)){
				System.out.println(s);
				return;
			}
		}

		System.out.println("");
		return;
	}
}