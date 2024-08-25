package iuh.fit.se;

import java.util.Scanner;

/**
 * @description:  This class represents oop exercises
 * @author:  Bui Van Tai
 * @version: 1.0
 * @created: Aug 24, 2024
 */

public class TestCourse {
	public static void main(String[] args) {
		CourseList c = new  CourseList(11);
		Course c1 = new Course("CS101", "Introduction to Computer Science", 3, "CS");
		Course c2 = new Course("CS102", "Data Structures", 4, "CS");
		Course c3 = new Course("CS103", "Algorithms", 4, "CS");
		Course c4 = new Course("CS104", "Operating Systems", 3, "CS");
		Course c5 = new Course("SE201", "Software Engineering", 3, "SE");
		Course c6 = new Course("SE202", "Object-Oriented Programming", 4, "SE");
		Course c7 = new Course("SE203", "Software Testing", 3, "SE");
		Course c8 = new Course("SE204", "Software Project Management", 3, "SE");
		Course c9 = new Course("IT301", "Network Security", 3, "IT");
		Course c10 = new Course("IT302", "Database Management", 4, "IT");
		c.addCourse(c1);
		c.addCourse(c2);
		c.addCourse(c3);
		c.addCourse(c4);
		c.addCourse(c5);
		c.addCourse(c6);
		c.addCourse(c7);
		c.addCourse(c8);
		c.addCourse(c9);
		c.addCourse(c10);
		Course[] courses;
        int n;
        Scanner scanner= new Scanner(System.in);
        do {
        	System.out.println();
        	System.out.println("|------------------------------------|");
        	System.out.println("|                 MENU               |");
        	System.out.println("|------------------------------------|");
        	System.out.println("|1. them khoa hoc                    |");
        	System.out.println("|2. in danh sach khoa hoc            |");
        	System.out.println("|3. xoa khoa hoc                     |");
        	System.out.println("|4. tim khoa hoc bang ten            |");
        	System.out.println("|5. tim khoa hoc theo khoa           |");
        	System.out.println("|6. tim khoa hoc theo id             |");
        	System.out.println("|7. xap xep khoa hoc                 |");
        	System.out.println("|8. tim khoa hoc co tin chi cao nhat |");
        	System.out.println("|9. tim khoa co nhiu khoa hoc nhat   |");
        	System.out.println("|0. thoat                            |");
        	System.out.println("|------------------------------------|");
        	System.out.println("nhap lua con cua ban : ");
        	n=scanner.nextInt();
        	scanner.nextLine();
        	switch(n) {
        	case 1: 
        		System.out.println("enter id :");
        		String id= scanner.nextLine();
        		System.out.println("enter title :");
        		String title= scanner.nextLine();
        		System.out.println("enter credit :");
        		int credit= scanner.nextInt();
        		System.out.println("enter department :");
        		String department= scanner.nextLine();
        		Course temp=new Course(id,title,credit,department);
        		c.addCourse(temp);
        		break;
        	case 2:
        		 courses =c.getCourses();
        		 System.out.println("||-----------------------------------------------------||");
        		 for(Course course : courses) {
        			 System.out.println("|"+course.toString()+"|");
        		 }
        		 System.out.println("||-----------------------------------------------------||");
        		 break;
        	case 3:
        		System.out.println("Enter the deletion id : ");
        		id= scanner.nextLine();
        	    c.removeCourse(id); 
        	    System.out.println("remove successfully");
        		break;
        	case 4:
        		System.out.println("enter title :");
        		title= scanner.nextLine();
        		courses =c.searchCourse(title);
        		System.out.println("||-----------------------------------------------------||");
       		    for(Course course : courses) {
       			    System.out.println("|"+course.toString()+"|");
       		    }
       		    System.out.println("||-----------------------------------------------------||");
       		    break;
        	case 5:
        		System.out.println("enter department :");
        		department= scanner.nextLine();
        		courses =c.searchCourseByDepartment(department);
        		System.out.println("||-----------------------------------------------------||");
       		    for(Course course : courses) {
       			    System.out.println("|"+course.toString()+"|");
       		    }
       		    System.out.println("||-----------------------------------------------------||");
       		    break;
        	case 6:
        		System.out.println("enter id :");
        		id= scanner.nextLine();
        		Course cs =c.searchCourseById(id);
        		System.out.println("||-----------------------------------------------------||");
                System.out.println("|"+cs.toString()+"|");
       		    System.out.println("||-----------------------------------------------------||");
       		    break;
        	case 7:
        		courses =c.sortCourses();
        		System.out.println("||-----------------------------------------------------||");
       		    for(Course course : courses) {
       		    	if(course != null)
       			    System.out.println("|"+course.toString()+"|");
       		    }
       		    System.out.println("||-----------------------------------------------------||");
       		    break;
        	case 8:
        		courses =c.findMaxCreditCourses();
        		System.out.println("||-----------------------------------------------------||");
       		    for(Course course : courses) {
       		    	if(course != null)
       			    System.out.println("|"+course.toString()+"|");
       		    }
       		    System.out.println("||-----------------------------------------------------||");
       		    break;
        	case 9:
        		department = c.findDepartmentWithMostCourses();
        		System.out.println("The department with the most courses is : " + department);
        		break;
            default:
        	}
        }
        while(n!=0);
        scanner.close();
    }
}
