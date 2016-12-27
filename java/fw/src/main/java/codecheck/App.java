package codecheck;

import java.io.*;
import java.util.*;

public class App {

	public static void main(String[] args) {
		ArrayList<String> operation1 = new ArrayList<String>();

		try {
			operation1.addAll(Arrays.asList(args));
			if(operation1.size()<3){
				throw new IllegalArgumentException();
			}
			operation1.remove(1);

		}catch(Exception e){
			System.out.println("exception");
			return;
		}

		String[] argsOperation1 = operation1.toArray(new String[operation1.size()]);

		while(true){

			for(int i=0;i<2;i++){

				try {
					ProcessBuilder pb = new ProcessBuilder(argsOperation1);
					Process process = pb.start();

					BufferedReader reader =
							new BufferedReader(new InputStreamReader(process.getInputStream()));

					int ret = process.waitFor();
					if(ret != 0){
						System.out.print(i==0 ? "FIRST (" : "SECOND (NG): ");
						return;
					}

					String out = reader.readLine();

					Boolean judge = out.length() > 0 ? out.charAt(0) == argsOperation1[1].charAt(argsOperation1[1].length()-1) : false;

					System.out.print(i==0 ? "FIRST (" : "SECOND (");
					System.out.println((judge ? "OK" : "NG") + "): " + out);

					if(!judge){
						System.out.println("WIN - " + (i==0 ? "SECOND" : "FIRST"));
						return;
					}

					argsOperation1[0] = i==0 ? args[1] : args[0];
					argsOperation1 = remove(argsOperation1,out);
					argsOperation1[1] = out;


				} catch (Exception e) {
					 System.out.println("exception");
					return;
				}

			}

		}
	}

	private static String[] remove(String[] target, String removeStr) {
		ArrayList<String> temp = new ArrayList<>(Arrays.asList(target));
		temp.remove(removeStr);
		return temp.toArray(new String[0]);
	}
}