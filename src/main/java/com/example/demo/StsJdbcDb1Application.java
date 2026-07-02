package com.example.demo;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class StsJdbcDb1Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =SpringApplication.run(StsJdbcDb1Application.class, args);
		EmployeeDao emp2=(EmployeeDao)context.getBean(EmployeeDao.class);
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			System.out.println("<======== MENU========>");
			System.out.println("Press-1 to Insert");
			System.out.println("Press-2 to Read");
			System.out.println("Press-3 to Update");
			System.out.println("Press-4 to Delete");
			System.out.println("Press-5 to Exit");
			int n=sc.nextInt();
			if(n==1)
			{
				Employee emp3=new Employee(sc.nextInt(),sc.next(),sc.nextDouble());
				System.out.println(emp2.StoreData(emp3));
			}
			else if(n==2)
			{
				List<Employee> ll=emp2.getData();
				for(Employee e :ll )
				{
					System.out.print(e.getId()+" ");
					System.out.print(e.getName()+" ");
					System.out.println(e.getSal()+" ");
				}
			}
			else if(n==3)
			{
				System.out.println("Enter Id to update and also enter the name and salary of what to update: ");
				Employee x=new Employee(sc.nextInt(),sc.next(),sc.nextDouble());
				System.out.println(emp2.Update(x));
			}
			else if(n==4)
			{
					System.out.println("Enter Id to Delete: ");
					System.out.println(emp2.Delete(sc.nextInt()));
			}
			else
			{
				System.out.println("Thankyou!!!");
				break;
			}

		}
		
		
	}

}
