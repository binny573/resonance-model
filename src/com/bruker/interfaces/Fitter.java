package com.bruker.interfaces;

import com.bruker.app.Data;
import com.bruker.app.FitFailedException;
import com.bruker.app.HarmonicOscillatorModel;
import com.bruker.app.HarmonicOscillatorParameters;

public interface Fitter {
	/**
	* Fit the given model to given data
	* @return the parameters that best fit the data for the given model
	*/
	HarmonicOscillatorParameters fitToData (
	HarmonicOscillatorModel model , Data data
	) throws FitFailedException;
}
