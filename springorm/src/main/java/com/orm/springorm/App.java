package com.orm.springorm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.orm.springorm.dao.StudentDao;
import com.orm.springorm.entities.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

//		Student student = new Student(235, "Aman", "Lakhimpur");
//
//		int r = studentDao.insert(student);
//		System.out.println("Done " + r);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean flag = true;
		while (flag) {

			System.out.println("Press 1 to add New Studeentt");
			System.out.println("Press 2 to display all Studeentt");
			System.out.println("Press 3 to get particular Studeentt");
			System.out.println("Press 4 to delete Studeentt");
			System.out.println("Press 5 to updatee Studeentt");
			System.out.println("Press 6 to Exitt");

			try {
				int input = Integer.parseInt(br.readLine());

				switch (input) {
				case 1:
					// add
					System.out.println("Enter the StudenttID");
					int sId = Integer.parseInt(br.readLine());
					System.out.println("Enter the Student Name");
					String sName = br.readLine();
					System.out.println("Enter the Student City");
					String sCity = br.readLine();
					Student s = new Student();
					s.setStudentId(sId);
					s.setStudentName(sName);
					s.setStudentCity(sCity);

					int result = studentDao.insert(s);
					System.out.println("Successfully Added:" + result);
					System.out.println("----------------------------------------------");
					break;
				case 2:
					// display all
					System.out.println("Student Details:");
					List<Student> allStudents = studentDao.getAllStudents();
					System.out.println("----------------------------------------------");
					for (Student st : allStudents) {
						System.out.println("Student Id: " + st.getStudentId());
						System.out.println("Student Name: " + st.getStudentName());
						System.out.println("Student Citty: " + st.getStudentCity());
						System.out.println("----------------------------------------------");
						
					}

					break;
				case 3:
					// display particular
					System.out.println("Enter the Id of the student for details");
					int uid=Integer.parseInt(br.readLine());
					Student st = studentDao.getStudent(uid);
					System.out.println("----------------------------------------------");
					System.out.println("Student Id: " + st.getStudentId());
					System.out.println("Student Name: " + st.getStudentName());
					System.out.println("Student Citty: " + st.getStudentCity());
					System.out.println("----------------------------------------------");
					
					break;
				case 4:
					// delete
					System.out.println("Enter the Id of the student for details");
					int id=Integer.parseInt(br.readLine());
					studentDao.delete(id);
					System.out.println("Deleted Successffully");
					System.out.println("----------------------------------------------");
					break;
				case 5:
					// update
					System.out.println("Enter the deetails beelow");
					System.out.println("Enter the StudenttID");
					int uId = Integer.parseInt(br.readLine());
					System.out.println("Enter the Student Name");
					String uName = br.readLine();
					System.out.println("Enter the Student City");
					String uCity = br.readLine();
					Student upStudent = new Student();
					upStudent.setStudentId(uId);
					upStudent.setStudentName(uName);
					upStudent.setStudentCity(uCity);
					
					studentDao.update(upStudent);
					System.out.println("Updatted Succesfully");
					
					
					break;
				case 6:
					// exit
					System.out.println("Thankks for using application");
					flag = false;
					break;

				}

			} catch (Exception e) {
				System.out.println("Invalid Input try with anoothher inputt");
				System.out.println(e.getMessage());
			}

		}

	}
}
