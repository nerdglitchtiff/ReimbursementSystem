package Sandbox;

import dev.warren.ers.entities.Employee;
import dev.warren.ers.entities.Manager;
import dev.warren.ers.entities.Staff;

public class ReimbursSysSandbox {

	public static void main(String[] args) {
		Staff a = new Manager();
		
		Staff b = new Employee(2, "Tiff", "Warren", 22, 'E', "tlowolow", "psswrd");
		
		a.setEmpdId(22);
		
		System.out.println(a.getEmpdId());
		System.out.println();
		
		b.equals(a);
		
		System.out.println(a.getStatus());

	}

}
