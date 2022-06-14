package com.bruker.app;
	
import com.bruker.interfaces.Fitter;
	
public final class MockFitter implements Fitter {
	
	public HarmonicOscillatorParameters fitToData(HarmonicOscillatorModel model, Data data) throws FitFailedException {
		/**
		* Untouched implementation of the Fitter interface
		* @return  HarmonicOscillatorParameter
		*/		
		double amplitude = 1.0e-9;
		double omega0 = 1000.0;
		double qFactor = 10.0;
		return new HarmonicOscillatorParameters (
		amplitude , omega0 , qFactor
		);
	}
	
}	
	