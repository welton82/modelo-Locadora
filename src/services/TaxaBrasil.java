package services;

public class TaxaBrasil {
	public double taxa(double taxa) {
		double t = (taxa >= 100.00) ? 0.15*taxa : 0.20*taxa;
		
		return t;
	}
}
