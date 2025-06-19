/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.employeesystem;

import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    int id;
    String name;
    String position;
    double salary;

    Employee(int id, String name, String position, double salary) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    void display() {
        System.out.println(id + " | " + name + " | " + position + " | " + salary);
    }
}

public class EmployeeSystem {
    public static void main(String[] args) {
        ArrayList<Employee> employeeList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Employee Management Menu ---");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Delete Employee by ID");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Position: ");
                    String position = sc.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();

                    employeeList.add(new Employee(id, name, position, salary));
                    System.out.println("Employee added!");
                }

                case 2 -> {
                    if (employeeList.isEmpty()) {
                        System.out.println("No employees to show.");
                    } else {
                        System.out.println("ID | Name | Position | Salary");
                        for (Employee e : employeeList) {
                            e.display();
                        }
                    }
                }

                case 3 -> {
                    System.out.print("Enter ID to search: ");
                    int searchId = sc.nextInt();
                    boolean found = false;
                    for (Employee e : employeeList) {
                        if (e.id == searchId) {
                            System.out.println("Employee found:");
                            e.display();
                            found = true;
                            break;
                        }
                    }
                    if (!found) System.out.println("Employee not found.");
                }

                case 4 -> {
                    System.out.print("Enter ID to delete: ");
                    int deleteId = sc.nextInt();
                    boolean removed = employeeList.removeIf(e -> e.id == deleteId);
                    if (removed)
                        System.out.println("Employee deleted.");
                    else
                        System.out.println("Employee not found.");
                }

                case 5 -> System.out.println("Exiting...");

                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}


