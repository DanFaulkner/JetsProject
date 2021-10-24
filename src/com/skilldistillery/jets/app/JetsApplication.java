package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.jets.entities.AirField;
import com.skilldistillery.jets.entities.Bomber;
import com.skilldistillery.jets.entities.CargoPlane;
import com.skilldistillery.jets.entities.JetImpl;
import com.skilldistillery.jets.entities.Jets;

public class JetsApplication {


	public static void main(String[] args) {
		JetsApplication ja = new JetsApplication();
		ja.launch();

	}

	private void launch() {
		Scanner sc = new Scanner (System.in);
		List <Jets> sortedPlanes = new ArrayList();
		populateAirfield(sortedPlanes);
			menu(sortedPlanes, sc);
		
	}

	private void menu(List<Jets> airfield, Scanner sc) {
		boolean keepGoing = true;
		System.out.println("Welcome to the SD air show!");
		System.out.println("===========================");
		System.out.println();
		System.out.println("Below is a menu with options to view the planes.");
		System.out.println("Please select to corrosponding number with your menu choice.");
		System.out.println();
		while(keepGoing == true) {
		System.out.println("==========Menu==========");
		System.out.println("1. List the collection of planes ");
		System.out.println("2. Fly all the planes ");
		System.out.println("3. View the fastest plane");
		System.out.println("4. View the plane with the longest range");
		System.out.println("5. Load all Cargo Jets");
		System.out.println("6. Drop bombs!");
		System.out.println("7. Add a jet to the show");
		System.out.println("8. Remove a jet from the show");
		System.out.println("9. Quit");
		
		int menuChoice = sc.nextInt();
		sc.nextLine();
		switch(menuChoice) {
		case 1:
			display(airfield);
			break;
		
		case 2: 
			flyPlanes(airfield);
			break;
			
		case 3:
			findFastestPlane(airfield);
			break;
			
		case 4:
			findFurthestRange(airfield);
			break;
			
		case 5:
			try{ loadCargoPlanes(airfield, sc);
			}catch(Exception e) {
				System.err.println("Invalid data entry.");
				System.out.println();
			}finally {
				sc.nextLine();
			}
			break;
			
		case 6:
			useBomberPlanes(airfield);
			break;
			
		case 7:
			try{ addPlane(airfield, sc);
			}catch(Exception e) {
				System.err.println("Invalid data entry.");
				System.out.println();
			}finally {
				sc.nextLine();
			}
			break;
			
		case 8:
			try{ removePlane(airfield, sc);
			}catch(Exception e) {
				System.err.println("Invalid data entry.");
				System.out.println();
			}finally {
				sc.nextLine();
			}
			break;
		
		case 9:
			System.out.println("Goodbye");
			keepGoing = false;
			break;
		
		default:
			System.out.println("Please enter a valid entry");
			break;
		}
		}
	}

	private List populateAirfield(List airfield) {
		try (BufferedReader bufIn = new BufferedReader(new FileReader("Jets.txt"))) {
			String line;
			while ((line = bufIn.readLine()) != null) {
				// insert code to manipulate line data here
				String[] jetArr = line.split(", ");
				String model = jetArr[1];
				Integer speed = Integer.parseInt(jetArr[2]);
				Double range = Double.parseDouble(jetArr[3]);
				Long price = Long.parseLong(jetArr[4]);
				if (jetArr[0].equals("CargoPlane")) {
					Integer cargoCap = Integer.parseInt(jetArr[5]);
					CargoPlane cargo = new CargoPlane(model, speed, range, price, cargoCap);
					airfield.add(cargo);
				} else if (jetArr[0].equals("Bomber")) {
					Integer payload = Integer.parseInt(jetArr[5]);
					Bomber bomber = new Bomber(model, speed, range, price, payload);
					airfield.add(bomber);
				} else {
					JetImpl commercialJet = new JetImpl(model, speed, range, price);
					airfield.add(commercialJet);
				}
			}
		} catch (IOException e) {
			System.err.println(e);
		}

		return airfield;
	}

	public void display(List airfield) {
		
		Iterator<AirField> it = (airfield.iterator());
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	public void flyPlanes(List<Jets> airfield) {
		for(Jets j : airfield) {
			Double timeFlying = j.fly(j.getRange(), j.getSpeed());
			System.out.println("You flew the " + j.getModel() + " for " + Math.round(timeFlying) + " hours your speed converted to Mach was " + j.getSpeedInMach(j.getSpeed()));
		}
		
	}
	public void findFastestPlane(List<Jets> airfield) {
		Integer fastestSpeed= airfield.get(0).getSpeed();
		Jets fastestPlane = airfield.get(0);
		for(Jets j : airfield) {
			if(j.getSpeed() >= fastestSpeed) {
				fastestSpeed = j.getSpeed();
				fastestPlane = j;
			}
		}
		System.out.println("The fastest plane is " + fastestPlane);
	}
	public void findFurthestRange(List<Jets> airfield) {
		Double mostRange= airfield.get(0).getRange();
		Jets mostRangePlane = airfield.get(0);
		for(Jets j : airfield) {
			if(j.getRange() >= mostRange) {
				mostRange = j.getRange();
				mostRangePlane = j;
			}
		}
		System.out.println("Most range: " + mostRangePlane);
	}
	public void loadCargoPlanes(List<Jets> airfield, Scanner sc) {
		for(Jets j : airfield) {
			if(j instanceof CargoPlane) {
				Integer cargoCap = ((CargoPlane) j).getCargoCapacity();
				((CargoPlane) j).loadCargo(cargoCap, sc);
			}
		}
	}
	public void useBomberPlanes(List<Jets> airfield) {
		for(Jets j : airfield) {
			if(j instanceof Bomber) {
				Integer cargoCap = ((Bomber) j).getPayload();
				((Bomber) j).dropBombs();
			}
		}
	}
	public List addPlane(List<Jets> airfield, Scanner sc) {
		System.out.println("To add a plane please select the type of plane you would like to use.");
		System.out.println("Please select the number that corrosponds with the option.");
		System.out.println("1. Cargo Plane");
		System.out.println("2. Bomber");
		System.out.println("3. Passenger Plane");
		System.out.println();
		int planeType = sc.nextInt();
		sc.nextLine();
		System.out.println();
		System.out.println("Enter the model of the plane.");
		System.out.println();
		String model = sc.nextLine();
		System.out.println();
		System.out.println("Enter the top speed of your plane in MPH.");
		System.out.println();
		Integer planeSpeed = sc.nextInt();
		sc.nextLine();
		System.out.println();
		System.out.println("Enter the how far your plane can fly in miles.");
		System.out.println();
		Double planeRange = sc.nextDouble();
		sc.nextLine();
		System.out.println();
		System.out.println("Enter the price of your plane.");
		System.out.println();
		Long planePrice = sc.nextLong();
		sc.nextLine();
		if(planeType == 1) {
			System.out.println("Enter the amount of cargo you can load in LBS.");
			Integer planeCargo = sc.nextInt();
			sc.nextLine();
			airfield.add(new CargoPlane(model, planeSpeed, planeRange, planePrice, planeCargo));
		}else if(planeType == 2) {
			System.out.println("Enter the amount of bombs you can hold in LBS.");
			Integer planePayload = sc.nextInt();
			sc.nextLine();
			airfield.add(new Bomber(model, planeSpeed, planeRange, planePrice, planePayload));
		}else if(planeType == 3) {
			airfield.add(new JetImpl(model, planeSpeed, planeRange, planePrice));
		}
		return airfield;
	}
	public List removePlane(List<Jets> airfield, Scanner sc) {
		System.out.println("Here is a list of planes.");
		for(Jets j : airfield) {
			System.out.println(j.getModel());
		}
		System.out.println("Enter the model you would like to have removed.");
		System.out.println("Enter the model exactly how you see it printed above.");
		String planeRemoved = sc.nextLine();
		for(Jets j : airfield) {
			if(j.getModel().equals(planeRemoved)) {
				airfield.remove(j);
			}
		}
		return airfield;
	}
}
