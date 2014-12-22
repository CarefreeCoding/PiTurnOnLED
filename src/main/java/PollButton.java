import com.pi4j.io.gpio.*;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;

/*
 * Upload:
 * scp PollButton.java pi@192.168.7.21:/home/pi/dev/p2_poll_button
 * Compile:
 * javac -classpath .:classes:/opt/pi4j/lib/'*' PollButton.java
 * Run:
 * sudo java -classpath .:classes:/opt/pi4j/lib/'*' PollButton
 */
public class PollButton
{
	public static void main(String[] args)
	{
		System.out.println("<--Pi4J--> GPIO Listen Example ... started.");

		GpioController gpio = GpioFactory.getInstance();

		GpioPinDigitalInput myButton = gpio.provisionDigitalInputPin(RaspiPin.GPIO_02, PinPullResistance.PULL_DOWN);

		myButton.addListener(new GpioPinListenerDigital()
		{
			@Override
			public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event)
			{
				// display pin state on console
				System.out.println(" --> GPIO PIN STATE CHANGE: " + event.getPin() + " = " + event.getState());
			}
		});

		System.out.println(" ... complete the GPIO #02 circuit and see the listener feedback here in the console.");

		for (; ; )
		{
			sleep(500);
		}
	}

	public static void sleep(int duration)
	{
		try
		{
			Thread.sleep(duration);
		}
		catch (Exception e)
		{
		}
	}
}
