package com.ifsc.tds.main;

public class Tarifas {

	private static Double tarResidencial1 = 0.38790;
	private static Double tarResidencial2 = 0.40500;
	private static Double tarComercial1 = 0.42550;
	private static Double tarComercial2 = 0.45113;
	private static Double icms = 27.0;
	private static Double taxaIluminacaoPublica = 7.8;
	
	public static Double getTarResidencial1() {
		return tarResidencial1;
	}
	public static void setTarResidencial1(Double tarResidencial1) {
		Tarifas.tarResidencial1 = tarResidencial1;
	}
	public static Double getTarResidencial2() {
		return tarResidencial2;
	}
	public static void setTarResidencial2(Double tarResidencial2) {
		Tarifas.tarResidencial2 = tarResidencial2;
	}
	public static Double getTarComercial1() {
		return tarComercial1;
	}
	public static void setTarComercial1(Double tarComercial1) {
		Tarifas.tarComercial1 = tarComercial1;
	}
	public static Double getTarComercial2() {
		return tarComercial2;
	}
	public static void setTarComercial2(Double tarComercial2) {
		Tarifas.tarComercial2 = tarComercial2;
	}
	public static Double getIcms() {
		return icms;
	}
	public static void setIcms(Double icms) {
		Tarifas.icms = icms;
	}
	public static Double getTaxaIluminacaoPublica() {
		return taxaIluminacaoPublica;
	}
	public static void setTaxaIluminacaoPublica(Double taxaIluminacaoPublica) {
		Tarifas.taxaIluminacaoPublica = taxaIluminacaoPublica;
	}
	
}
