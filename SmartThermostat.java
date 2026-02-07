package INCLASSexercise2;

public class SmartThermostat extends SmartDevice implements Adjustable {
	private int temperature;
	
	public SmartThermostat(String deviceName) {
		super(deviceName);
		this.temperature = 75;
	}
	
	@Override
	public void setLevel(int level) {
		if(level < 60) level = 60;
		if(level >80) level = 80;
		
		temperature = level;
		System.out.println(deviceName + "temperature is " + "F");
		
	}
	
	@Override 
	public void turnOn() {
		System.out.println("HVAC System Starting...");
		super.turnOn();
		
	}
	
	@Override
	public void performSelfDiagnostic() {
		System.out.println(deviceName + "is running thermostat....");
		
		
	}

}
