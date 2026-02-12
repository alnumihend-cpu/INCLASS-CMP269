package Exercise3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GradebookProcessor {
	public static void main(String[] args) {
		File file = new File("src/Exercise3/students.txt");
		
		try(
				Scanner scanner = new Scanner(file);
				PrintWriter writer = new PrintWriter("grades_report.text") ){
			while(scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] parts = line.split(" ");
				
				try {
					String name = parts[0];
					int s1 = Integer.parseInt(parts[1]);
					int s2 = Integer.parseInt(parts[2]);
					int s3 = Integer.parseInt(parts[3]);
					
					double avg = (s1 + s2 + s3) / 3.0;
					
					String result = "Student: " + name + " | Average: " + avg;
					
					if(avg < 60) {
						result += " | Warning";
					}
					
					writer.println(result);
					
					
				} catch(Exception e) {
					System.out.println("Invalid data " + line);
				}
			
			}
			
		} catch(FileNotFoundException e) {
			System.out.println("File not found: students.txt");
		} finally {
			System.out.println("Processing Complete");
		}
	}

}
