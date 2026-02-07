package INCLASSexercise2;

public class SmartLight extends SmartDevice implements Adjustable {
	private int brightness; //it has to be between  (0-100).
	
	
	public SmartLight(String deviceName) {
		super(deviceName);
		this.brightness = 0;
	}
	
	@Override
	public void setLevel(int level) {
		if(!isOn) {
			System.out.println("DEvice is off");
			return;
		}
		if(level< 0 ) level = 0;
		if(level > 100) level = 100;
		
		brightness = level;
		System.out.println(deviceName + " brighness is " + brightness);
		
	}
	
	@Override 
	public void performSelfDiagnostic() {
		System.out.println(deviceName + "Checking LED health...");
	}
	
	
}
