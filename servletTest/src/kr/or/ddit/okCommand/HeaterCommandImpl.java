package kr.or.ddit.okCommand;

public class HeaterCommandImpl implements ICommand{
	
	private Heater heater;
	
	public HeaterCommandImpl(Heater heater) {
		this.heater = heater;
	}
	
	@Override
	public void excute() {
		heater.powerOn();
	}

}
