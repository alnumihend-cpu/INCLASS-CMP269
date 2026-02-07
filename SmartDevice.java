package INCLASSexercise2;

public abstract class SmartDevice implements Powerable {
	protected String deviceName;
	protected boolean isOn;

	public SmartDevice(String deviceName) {  //CONSTRUCTOR 
		this.deviceName = deviceName;
		this.isOn = false;
	}
	
	public abstract void performSelfDiagnostic();
	
	public  static int activeDevicesCount = 0;
	
	@Override
	public void turnOn() {
		if(!isOn) {
			isOn = true;			//***
			activeDevicesCount++;
			System.out.println(deviceName + " is ON!");
		}
		
	}
	public void turnOff() {
		if(isOn) {
			isOn = false; 		//***
			activeDevicesCount--;
			System.out.println(deviceName + "is OFF!");
			
		}
	}

}
