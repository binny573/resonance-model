package com.bruker.app;

public class HarmonicOscillatorParameters {
	
	private double amplitude;
	private double omega0;
	private double qFactor;
	public HarmonicOscillatorParameters(double amplitude, double omega0, double qFactor) {
		/**
		* Bean class for the HarmonicOscillatorParameters
		*/
		this.amplitude= amplitude;
		this.omega0=omega0;
		this.qFactor=qFactor;
	}
	public double getAmplitude() {
		return this.amplitude;
	}
	public void setAmplitude(double amplitude) {
		this.amplitude = amplitude;
	}
	public double getOmega0() {
		return this.omega0;
	}
	public void setOmega0(double omega0) {
		this.omega0 = omega0;
	}
	public double getqFactor() {
		return this.qFactor;
	}
	public void setqFactor(double qFactor) {
		this.qFactor = qFactor;
	}
}
