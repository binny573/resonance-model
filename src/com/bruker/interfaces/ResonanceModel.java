package com.bruker.interfaces;

import com.bruker.app.HarmonicOscillatorParameters;

public interface ResonanceModel {
	/**
	* Evaluate the model at a given frequency
	* @param frequency the frequency f
	* @param parameters the parameters defining the specific model
	* @return spectral power P
	*/
	double evaluateSpectralPowerAt (
	double frequency , HarmonicOscillatorParameters parameters
	);
}
