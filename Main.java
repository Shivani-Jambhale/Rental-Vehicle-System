package mini;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
// Interface
interface GuidelineAgreement {
boolean agreeToGuidelines();
}
// Abstract User class
abstract class User {
String name, gmail, phone, aadhaar, address, license;
int age;
abstract boolean isEligible();
}
// Concrete Renter class
class Renter extends User implements GuidelineAgreement {
static Scanner sc = new Scanner(System.in);
void collectDetails() {
int ans;
do {

System.out.print("Enter your name: ");
name = sc.nextLine();
System.out.print("Enter your Gmail: ");
gmail = sc.nextLine();
System.out.print("Enter your phone number: ");
phone = sc.nextLine();
System.out.print("Enter your Aadhaar number: ");
aadhaar = sc.nextLine();
System.out.print("Enter your address: ");
address = sc.nextLine();
// Confirmation loop
while (true) {
System.out.println("\nPlease check your details:");
System.out.println("Name: " + name);
System.out.println("Gmail: " + gmail);
System.out.println("Phone number: " + phone);
System.out.println("Aadhaar number: " + aadhaar);
System.out.println("Address: " + address);
System.out.println("\nCheck your details:");
System.out.println("1. They are right, continue further.");

System.out.println("2. No, I want to input details again. ");
System.out.print("Enter your choice: ");
ans = sc.nextInt();
sc.nextLine(); // consume newline
if (ans == 1 || ans == 2) {
break; // valid answer → break inner loop
} else {
System.out.println(" ⚠Invalid choice. Please enter 1 or 2.\n");
}
}
} while (ans == 2); // repeat only if user wants to re-enter details
}
@Override

boolean isEligible() {
int ans;
do {
System.out.print("\nEnter your age: ");
age = sc.nextInt();
sc.nextLine(); // consume newline
if (age < 18) {
System.out.println("YOU ARE UNDER 18, SO WE ARE SORRY TO INFORM YOU THAT YOU ARE NOT ALLOWED TO RENT VEHICLE.");

return false;
} else {
System.out.println("\nYour age is " + age + ", which is above 18.\nSo you can rent vehicle here.");
}
System.out.println("\nCheck your age:\n1. It is right, continue further.😄 \n2. No, I want to input age again. 😞 ");
ans = sc.nextInt();
} while (ans == 2);
sc.nextLine();
while (true) {
System.out.print("\nDo you have a driving license? (yes/no): ");
String hasLicense = sc.nextLine().trim();
if (hasLicense.equalsIgnoreCase("yes")) {
break; // valid and acceptable, continue program
} else if (hasLicense.equalsIgnoreCase("no")) {
System.out.println("You need to have a driving license.");
return false; // exit the current method
} else {
System.out.println("Invalid input. Please enter 'yes' or 'no'.");
}
}
int ch;
do {

System.out.print("\nEnter your license number: ");
license = sc.nextLine();
System.out.println("Your license number is: " + license);
while(true) {
System.out.println("\nCheck your license number:\n1. It is right,continue further. 😄 \n2. No, I want to input license number again. 😞 ");
ch = sc.nextInt();
sc.nextLine(); // consume newline
if(ch==1||ch==2) {
break;
}else {
System.out.println("Invalid input.");
}
}
} while (ch == 2);
return true;
}
@Override
public boolean agreeToGuidelines() {
String agree;
do {
System.out.println("\n--- COMMUNITY GUIDELINES ---");
System.out.println("1. Respect and Courtesy: Treat all users, hosts,and support staff with respect.");
System.out.println("2. Responsible Vehicle Use: Drive safely and follow all traffic laws.");
System.out.println("3. Cleanliness and Care: Return vehicles clean and damage-free.");
System.out.println("4. Accurate Information: Provide valid personal details.");
System.out.println("5. Timely Returns: Return vehicles on time.");
System.out.println("6. No Unauthorized Usage: Only the renter may use the vehicle.");

System.out.println("7. Review and Feedback: Give honest, respectful reviews.");
System.out.println("8. Report Violations: Report suspicious activity promptly.");
System.out.print("\nDo you agree? (yes/no): ");
agree = sc.nextLine().trim();
if (agree.equalsIgnoreCase("no")) {
System.out.println(" ❌ You must agree to the guidelines to proceed.");

return false; // Stop the process
} else if (!agree.equalsIgnoreCase("yes")) {
System.out.println(" ⚠ Invalid input. Please enter 'yes' or 'no'. Guidelines will be shown again.\n");
}
} while (!agree.equalsIgnoreCase("yes"));
return true; // Proceed only if user says yes
}
}
// Abstract Vehicle class
abstract class Vehicle {
String modelName;
int capacity;
double pricePerDay;
boolean available = true;
Vehicle(String modelName, int capacity, double pricePerDay) {
this.modelName = modelName;
this.capacity = capacity;
this.pricePerDay = pricePerDay;
}
void displayDetails() {
System.out.println(modelName + " | Capacity: " + capacity + " | ₹" +
pricePerDay + "/day" +

(available ? " | Available" : " | Not Available"));
}
}

class Car extends Vehicle {
Car(String modelName, int capacity, double pricePerDay) {
super(modelName, capacity, pricePerDay);
}
}
class Bike extends Vehicle {
Bike(String modelName, int capacity, double pricePerDay) {
super(modelName, capacity, pricePerDay);
}
}
class Bus extends Vehicle {
Bus(String modelName, int capacity, double pricePerDay) {
super(modelName, capacity, pricePerDay);
}
}
class RentalRecord {
Vehicle vehicle;
LocalDate expectedReturnDate;
double rentalAmount;
RentalRecord(Vehicle vehicle, LocalDate expectedReturnDate, double
rentalAmount) {
this.vehicle = vehicle;
this.expectedReturnDate = expectedReturnDate;
this.rentalAmount = rentalAmount;
}
}
public class Main {
static ArrayList<Vehicle> cars = new ArrayList<>();
static ArrayList<Vehicle> bikes = new ArrayList<>();
static ArrayList<Vehicle> buses = new ArrayList<>();
static boolean vehicleListsInitialized = false;
static ArrayList<RentalRecord> rentalRecords = new ArrayList<>();
static {
System.out.println(" ❤ WELCOME TO OUR VEHICLE RENTAL SERVICE ❤ " );

}
static void initializeVehicles() {
if (vehicleListsInitialized) return;
cars.add(new Car("Swift", 5, 1200));
cars.add(new Car("Innova", 7, 2000));
cars.add(new Car("Baleno", 5, 1300));
cars.add(new Car("Fortuner", 7, 3000));
cars.add(new Car("WagonR", 5, 1100));
cars.add(new Car("Creta", 5, 2200));
cars.add(new Car("City", 5, 1800));
cars.add(new Car("Venue", 5, 1600));
cars.add(new Car("XUV700", 7, 2800));
cars.add(new Car("Ciaz", 5, 1700));
bikes.add(new Bike("Splendor", 2, 300));
bikes.add(new Bike("Pulsar", 2, 400));
bikes.add(new Bike("Activa", 2, 250));
bikes.add(new Bike("Apache", 2, 350));
bikes.add(new Bike("R15", 2, 500));
bikes.add(new Bike("Duke", 2, 600));
bikes.add(new Bike("FZ", 2, 350));
bikes.add(new Bike("Bullet", 2, 700));
bikes.add(new Bike("Access", 2, 250));
bikes.add(new Bike("Xtreme", 2, 300));
buses.add(new Bus("MiniBus A", 15, 3500));
buses.add(new Bus("MiniBus B", 18, 4000));
buses.add(new Bus("Tourist A", 30, 6000));
buses.add(new Bus("Tourist B", 35, 6500));
buses.add(new Bus("Volvo A", 40, 8000));
buses.add(new Bus("Volvo B", 45, 8500));
buses.add(new Bus("Luxury A", 50, 10000));
buses.add(new Bus("Luxury B", 55, 11000));
buses.add(new Bus("Sleeper", 30, 9500));
buses.add(new Bus("Express", 40, 9000));
vehicleListsInitialized = true;
}

public static void main(String[] args) {
initializeVehicles();
Renter renter = new Renter();
renter.collectDetails();
if (!renter.isEligible()) return;
if (!renter.agreeToGuidelines()) {
System.out.println("You must agree to the guidelines to continue.");
return;
}
int choice;
do {
System.out.println("\nMenu:");
System.out.println("1. Rent a vehicle");
System.out.println("2. Return a vehicle & calculate fine");
System.out.println("3. View available vehicles");
System.out.println("4. Give review");
System.out.println("5. Exit");
System.out.print("Enter your choice: ");
choice = Renter.sc.nextInt();
switch (choice) {
case 1 -> rentVehicle();
case 2 -> calculateFine();
case 3 -> showAvailableVehicles();
case 4 -> getReview();
case 5 -> System.out.println("Thank you! Visit again. ❤");
default -> System.out.println("Invalid choice.");
}
} while (choice != 5);
}
static void getReview() {
Scanner sc = new Scanner(System.in);
System.out.println("Kindly enter the review:");
String review = sc.nextLine();
System.out.println("This is your review:");

System.out.println("***********************************\n"+review+"\n***********************************");
}
static void rentVehicle() {
Scanner sc = Renter.sc;
System.out.println("\nChoose vehicle type:\n 🚘 1.Car\n 🛵 2.Bike\n🚌 3.Bus");
int type = sc.nextInt();
ArrayList<Vehicle> vehicles;
switch (type) {
case 1 -> vehicles = cars;
case 2 -> vehicles = bikes;
case 3 -> vehicles = buses;
default -> {
System.out.println("Invalid type.");
return;
}
}
ArrayList<Vehicle> availableList = new ArrayList<>();
for (Vehicle v : vehicles) {
if (v.available) {
availableList.add(v);
System.out.print(availableList.size() + ". ");
v.displayDetails();
}
}
if (availableList.isEmpty()) {
System.out.println("No vehicles available.");
return;
}
System.out.print("Choose a model (1-" + availableList.size() + "): ");
int model = sc.nextInt();
sc.nextLine();
if (model < 1 || model > availableList.size()) {
System.out.println("Invalid selection.");

return;
}
Vehicle selected = availableList.get(model - 1);
DateTimeFormatter formatter =
DateTimeFormatter.ofPattern("dd/MM/yyyy");
LocalDate startDate = null, endDate = null;
do {
try {
System.out.print("Enter rental start date (dd/MM/yyyy): ");
startDate = LocalDate.parse(sc.nextLine(), formatter);
System.out.print("Enter rental end date (dd/MM/yyyy): ");
endDate = LocalDate.parse(sc.nextLine(), formatter);
if (endDate.isBefore(startDate)) {
System.out.println("End date cannot be before start date.Please try again.\n");
} else {
break; // valid dates, exit the loop
}
} catch (Exception e) {
System.out.println("Invalid date format. Please use dd/MM/yyyy.\n");
}
} while (true);
long totalDays = ChronoUnit.DAYS.between(startDate, endDate) + 1;
double baseCost = selected.pricePerDay * totalDays;
System.out.print("Do you need a driver? (yes/no): ");
String withDriver = sc.nextLine();
double driverCost = withDriver.equalsIgnoreCase("yes") ? 500 *
totalDays : 0;
double lastRentalAmount = baseCost + driverCost;
selected.available = false;
rentalRecords.add(new RentalRecord(selected, endDate,
lastRentalAmount));

System.out.println("\n--- RENTAL RECEIPT ---");
System.out.println("Vehicle: " + selected.modelName);
System.out.println("Rental Period: " + startDate.format(formatter) + " to" +endDate.format(formatter));
System.out.println("Rental Days: " + totalDays);
System.out.println("Vehicle Cost: ₹" + baseCost);
if (driverCost > 0) System.out.println("Driver Cost: ₹" + driverCost);
System.out.println("Total Rental Amount: ₹" + lastRentalAmount);
System.out.println("Return by: " + endDate.format(formatter));
System.out.println("YOU HAVE SUCCESSFULLY RENTED VEHICLE🎉 ");
}
static void calculateFine() {
Scanner scanner = Renter.sc;
if (rentalRecords.isEmpty()) {
System.out.println("No active rentals found.");
return;
}
System.out.println("\n--- Your Rented Vehicles ---");
for (int i = 0; i < rentalRecords.size(); i++) {
RentalRecord r = rentalRecords.get(i);
System.out.println((i + 1) + ". " + r.vehicle.modelName + " | Expected Return: " +
r.expectedReturnDate);
}
System.out.print("Select the vehicle you are returning (1-" +
rentalRecords.size() + "): ");
int index = scanner.nextInt();
scanner.nextLine();
if (index < 1 || index > rentalRecords.size()) {
System.out.println("Invalid choice.");
return;
}
Scanner sc=new Scanner(System.in);

RentalRecord returning = rentalRecords.get(index - 1);
Vehicle rentedVehicle = returning.vehicle;
System.out.print("Enter Actual Return Date (dd/MM/yyyy): ");
String actualDateStr = scanner.nextLine();
DateTimeFormatter formatter =
DateTimeFormatter.ofPattern("dd/MM/yyyy");

boolean validReturnDate = false;
do {
try {
LocalDate actualDate = LocalDate.parse(actualDateStr,

formatter);

System.out.println("\n--- RETURN SUMMARY ---");
if (actualDate.isAfter(returning.expectedReturnDate)) {
long lateDays =

ChronoUnit.DAYS.between(returning.expectedReturnDate, actualDate);
double extraRent = lateDays * rentedVehicle.pricePerDay;
long fine = lateDays * 1000;
double finalAmount = extraRent + fine;
System.out.println("Returned Late by: " + lateDays + " day(s)");
System.out.println("Extra Rent (₹" + rentedVehicle.pricePerDay

+ " per day): ₹" +
extraRent);

System.out.println("Fine (₹1000 per day): ₹" + fine);
System.out.println("Total Payable Amount: ₹" + finalAmount);
System.out.println("WARNING:YOU HAVE TO PAY FINE,OR LEGAL ACTION CAN BE TAKEN AGAINST YOU!");

} else {
System.out.println("Returned on time. No fine.");
}
rentedVehicle.available = true;
rentalRecords.remove(index - 1);
validReturnDate = true; // Exit loop after successful processing
} catch (Exception e) {

System.out.println("Invalid date format. Please use dd/MM/yyyy.");
System.out.print("Enter actual return date again (dd/MM/yyyy): ");
actualDateStr = sc.nextLine(); // Prompt again
}
} while (!validReturnDate);
}
static void showAvailableVehicles() {
System.out.println("\n--- �� Available Cars ---");
for (Vehicle car : cars) if (car.available) car.displayDetails();
System.out.println("\n--- �� Available Bikes ---");
for (Vehicle bike : bikes) if (bike.available) bike.displayDetails();
System.out.println("\n--- Available Buses ---");
for (Vehicle bus : buses) if (bus.available) bus.displayDetails();
}
}