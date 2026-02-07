package INCLASSexercise2;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		ArrayList<SmartDevice> homeHub = new ArrayList<>();
		
		SmartLight livingRoomLight = new SmartLight("Living Room Light");
		SmartLight kitchenLight = new SmartLight("Kitchen LigHt");
		SmartThermostat hallwayThermostat = new SmartThermostat("Hallway Thermostat");
		//SmartLight
		
		homeHub.add(livingRoomLight);
		homeHub.add(kitchenLight);
		homeHub.add(hallwayThermostat);
		
		
		livingRoomLight.turnOn();
		hallwayThermostat.turnOn();
		kitchenLight.setLevel(75);
		
		System.out.println("ACTIVE DEVICE: " + SmartDevice.activeDevicesCount);
		
		for(SmartDevice device : homeHub) {
			device.performSelfDiagnostic();
			
		}
		
		
	}

}
