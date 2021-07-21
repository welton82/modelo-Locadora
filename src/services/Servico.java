package services;

import java.util.Date;

import entities.Locadora;
import entities.Pagamento;

public class Servico {
	
	private Double precoPorHora;
	private Double precoPorDia;
	
	TaxaBrasil taxaBrasil;

	public Servico() {
		
	}

	public Servico(Double precoPorHora, Double precoPorDia, TaxaBrasil taxaBrasil) {
		//super();
		this.precoPorHora = precoPorHora;
		this.precoPorDia = precoPorDia;
		this.taxaBrasil = taxaBrasil;
	}

	public Double getPrecoPorHora() {
		return precoPorHora;
	}

	public void setPrecoPorHora(Double precoPorHora) {
		this.precoPorHora = precoPorHora;
	}

	public Double getPrecoPorDia() {
		return precoPorDia;
	}

	public void setPrecoPorDia(Double precoPorDia) {
		this.precoPorDia = precoPorDia;
	}

	public TaxaBrasil getTaxaBrasil() {
		return taxaBrasil;
	}

	public void setTaxaBrasil(TaxaBrasil taxaBrasil) {
		this.taxaBrasil = taxaBrasil;
	}
	
	public void gerarNota(Locadora locadora) {
		
		long d1 = locadora.getInicioLocacao().getTime();
		long d2 = locadora.getFimLocacao().getTime();
		
		double horas = (d2-d1)/1000/60/60;
		double pagamento = (horas <= 12) ? Math.ceil(horas)*precoPorHora : Math.ceil(horas)/24*precoPorDia;
		
		double taxa = taxaBrasil.taxa(pagamento);
		locadora.setPagamento(new Pagamento(pagamento, taxa));
		
	}
	
}
