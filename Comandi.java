package robottino;

import java.io.File;

import lejos.hardware.Audio;
import lejos.hardware.BrickFinder;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.Color;
import lejos.robotics.RegulatedMotor;
public class Comandi {
	
	private RegulatedMotor motorB = new EV3LargeRegulatedMotor(MotorPort.B);
	private RegulatedMotor motorA = new EV3LargeRegulatedMotor(MotorPort.A);
	private RegulatedMotor motorC = new EV3LargeRegulatedMotor(MotorPort.C);
	private RegulatedMotor motorD = new EV3LargeRegulatedMotor(MotorPort.D);

	
	private final int maxSpeed = 1000;
	private final int minSpeed = 100;
	
	
	public Comandi() 
	{
		
		//set default velocity
	    motorB.setSpeed((int) motorB.getMaxSpeed()); //sinistra
	   	motorA.setSpeed((int) motorA.getMaxSpeed()); //destra

	}
	public void alza()
	{
		motorC.forward();
		motorD.forward();
	}
	public void abbassa()
	{
		motorC.backward();
		motorD.backward();
	}
	public void festeggia()
	{
		motorA.setSpeed(2000);
		motorB.setSpeed(-2000);

	}
	public void forward() {
		
		motorB.setSpeed(2000);
		motorA.setSpeed(2000);
	    motorA.forward();
	    motorB.forward();
	}
	
	public void backward() {
		
	
		motorA.backward();
		motorB.backward();
		

	}
	
	public void left() {
		motorA.setSpeed(600);
		motorB.setSpeed(1000);
		
	    motorA.forward();
	    motorB.forward();
	}
	
	public void right() {
		motorB.setSpeed(600);
		motorA.setSpeed(1000);
		
	    motorA.forward();
	    motorB.forward();
	}
	
	public void deceleration() {
		int n = 0;
		if(motorB.getSpeed() == motorA.getSpeed()) 
		{
			n = motorB.getSpeed();	
		}
		else if(motorB.getSpeed() < motorA.getSpeed()) 
		{
			n = motorA.getSpeed();
		}
		else 
		{
			n = motorB.getSpeed();
		}
			if(n > minSpeed) {
			motorB.setSpeed(n-200);
			motorA.setSpeed(n-200);
		}
	}
	
	public void acceleration() throws InterruptedException {
		int n = 0;
		
		
		if(motorB.getSpeed() == motorA.getSpeed()) 
		{
			
			n = motorB.getSpeed();	
		}
		else if(motorB.getSpeed() < motorA.getSpeed()) 
		{
			n = motorA.getSpeed();
		}
		else 
		{
			n = motorB.getSpeed();
		}
		if(n < maxSpeed) 
		{
			motorB.setSpeed(n+300);
			motorA.setSpeed(n+300);
		}
	}
	
	public void stop() 
	{
	    motorB.stop(true);
	    motorA.stop(true);
	    
	    motorA.close(); 
	    motorB.close();
	}
	
	public void freno() 
	{
		
		motorB.flt(true);
		motorA.flt(true);
		
		
		motorB.setSpeed(0);
		motorA.setSpeed(0);
	}
	
}