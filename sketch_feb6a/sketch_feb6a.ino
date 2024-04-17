#include <dht.h>        // Include library
#include <LiquidCrystal_I2C.h>
#define outPin 3        // Defines pin number to which the sensor is connected

dht DHT;                // Creates a DHT object
LiquidCrystal_I2C lcd(0x3f,16,2);

void setup() {
	Serial.begin(9600);
}

void loop() {
	int readData = DHT.read11(outPin);

	float t = DHT.temperature;        // Read temperature
	float h = DHT.humidity;           // Read humidity

	Serial.print("Temperature = ");
	Serial.print(t);
	Serial.print("°C | ");
	Serial.print((t*9.0)/5.0+32.0);        // Convert celsius to fahrenheit
	Serial.println("°F ");
	Serial.print("Humidity = ");
	Serial.print(h);
	Serial.println("% ");
	Serial.println("");

  lcd.setCursor(0,0);
  lcd.print("Hello");

	delay(2000); // wait two seconds
}