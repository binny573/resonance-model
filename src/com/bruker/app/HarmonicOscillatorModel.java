package com.bruker.app;

import com.bruker.interfaces.ResonanceModel;

public class HarmonicOscillatorModel implements ResonanceModel {

	@Override
	public double evaluateSpectralPowerAt(double frequency, HarmonicOscillatorParameters parameters) {
		/**
		*Mathematical formulation that evaluates spectral Power
		* @return spectralPower
		*/
		
		double f = frequency;
		double A = parameters.getAmplitude();
		double w0 = parameters.getOmega0();
		double f0=w0/(2*Math.PI);
		double qFactor = parameters.getqFactor(); 
		
		double numerator= A*A;
		double denominator=
			16*Math.pow(Math.PI,4)*(Math.pow(f*f-f0*f0,2)+f*f*f0*f0/qFactor*qFactor);
		
		double spectralPower=numerator/denominator;
		
		return spectralPower;
	}	

}
