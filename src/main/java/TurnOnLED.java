import com.pi4j.io.gpio.*;

/*
 * Upload:
 * scp TurnOnLED.java pi@192.168.7.21:/home/pi/dev/p1_led_blink
 * Compile:
 * javac -classpath .:classes:/opt/pi4j/lib/'*' TurnOnLED.java
 * Run:
 * sudo java -classpath .:classes:/opt/pi4j/lib/'*' TurnOnLED
 */
public class TurnOnLED
{
	public static void main(String[] args)
	{
		System.out.println("<--Pi4J--> GPIO Control Example ... started.");

		GpioController gpio = GpioFactory.getInstance();

		GpioPinDigitalOutput pin =
				gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01,
											   "Pin 1",
											   PinState.HIGH);
		System.out.println("GPIO 1 state should be: ON");

		sleep(5000);
		pin.low();
		System.out.println("GPIO 1 state should be: OFF");

		sleep(5000);
		pin.toggle();
		System.out.println("GPIO 1 state should be: ON");

		sleep(5000);
		pin.toggle();
		System.out.println("GPIO 1 state should be: OFF");

		sleep(5000);
		System.out.println("GPIO 1 state should be: ON for only 1 second");
		pin.pulse(1000, true);

		gpio.shutdown();
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
