package com.bruker.app;

import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(
		  name = "EvaluateSpectralPower",
		  description = "Write results into a file for the scientific equation "
		  		+ "to find spectral power of a single Harmonic Oscillator"
		)
public class CommandLineSpectralPower implements Runnable {
	/*
	* We use the CommandLine interface from the picocli framework to build a command line application
	*/
	
	@SuppressWarnings("resource")
	public static void ApplicationSpectralPower() {
		/**
		* Static method where Scanner class is used to get inputs from the 
		*  user and the corresponding output is written into the .dat file
		* @return null
		*/
		Scanner keyIn = new Scanner(System.in);

	    System.out.println("Welcome to the spectral power estimator app for the single Harmonic Oscillator! Press enter to continue");
	    keyIn.nextLine();
		Scanner myObj = new Scanner(System.in);		
		
		System.out.println("Enter Amplitude (A) of your oscillator :");
	    double A = myObj.nextDouble();
		
	    System.out.println("Enter resonance angular frequency (w0) of your oscillator  :");
	    double w0 = myObj.nextDouble();  
	    
	    System.out.println("Enter Qfactor (q) of your oscillator :");
	    double q = myObj.nextDouble();
	    	    
	    System.out.println("Enter angular frequency (w) of your oscillator:");
	    double w = myObj.nextDouble();  
	    
	    HarmonicOscillatorParameters params = new HarmonicOscillatorParameters(A, w0, q);
	    HarmonicOscillatorModel  model = new HarmonicOscillatorModel();
	    
	    double frequency = w/(2*Math.PI);
	    
	    writeResultsToFile(model, params, frequency);
	    
	    String message = "Succesfully executed the application";
	    
	    System.out.println(message);   
	}
	
	public static void writeResultsToFile( HarmonicOscillatorModel model,
			HarmonicOscillatorParameters params, double frequency) {
		/**
		* FileWriter class is used to write the output of the Spectral density formula
		* @return null
		*/
		try{    
        	double spectralPower=model.evaluateSpectralPowerAt(frequency, params);
            FileWriter fw=new FileWriter("SpectralPowerResult.dat");
            
            LocalDateTime myDateObj = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formattedDate = myDateObj.format(myFormatObj);

            fw.write("Date and Time : " + formattedDate+ "\n");
            fw.write("Frequency \t Spectral_Power \n");
            
    		for (int i=0;i<5; i++) {
       			fw.write(String.format("%.3f",frequency)+" \t\t " + String.format("%.3g", spectralPower*0.1)+"\n");
    		}
    		
            fw.flush();
            fw.close(); 
            
           }catch(Exception e){System.out.println(e);}    
           System.out.println("\nSuccessfully written data to the File \n");
           }
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
        CommandLine.run(new CommandLineSpectralPower(), args);
	}

	@Override
	public void run() {
		ApplicationSpectralPower();
	}
}
