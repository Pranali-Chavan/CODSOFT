import java.util.Scanner;

public class GradeCalculator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of subjects: ");
		int subs = sc.nextInt();
		int totalMarks = 0;
		
		for(int i = 1; i <= subs; i++) {
			System.out.println("Enter the marks of subject " + i + "(out of 100)");
			totalMarks += sc.nextInt();
		}
		double avgPercentage = (double)totalMarks / subs;
		System.out.println("Total marks: " + totalMarks);
		
		char grade;
		if(avgPercentage >= 90)
			grade = 'A';
		else if(avgPercentage >=75)
			grade = 'B';
		else if(avgPercentage >= 60)
			grade = 'C';
		else if(avgPercentage >=45)
			grade = 'D';
		else
			grade = 'F';
		
		System.out.println("\n-----------------------------------------");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + avgPercentage + "%");
        System.out.println("Grade: " + grade);
	}

}
