package inversionesMensuales;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Modulo {

	public static Double[] calcularInversion(double montoAInvertir, double interes, int anios) {
		sonMontosValidosParaInversion(montoAInvertir, interes, anios);
			Double[] montosPorAnio = new Double[anios];
			double suma = montoAInvertir;
			for (int i = 0; i < anios; i++) {
				for (int j = 0; j < 12; j++) {
					suma += (suma * interes / 12);
				}
				BigDecimal bd = new BigDecimal(suma);
				bd = bd.setScale(4, RoundingMode.HALF_UP);
				montosPorAnio[i] = bd.doubleValue();
			}
			return montosPorAnio;
		
	}

	public static int superarMonto(double montoAInvertir, double interes, double montoDeseado) {
		int contador = 0;
		sonMontosValidosParaProyeccion(montoAInvertir, interes, montoDeseado);
			double suma = montoAInvertir;
			while (suma < montoDeseado) {
				suma += (suma * interes / 12);
				contador++;
			}
		return contador;
	}

	private static void sonMontosValidosParaInversion(double montoAInvertir, double interes, int anios) {
		sonMontosValidos(montoAInvertir, interes);
		if (anios <= 0) throw new Error("Los años no pueden ser cero o menos");
		}

	private static void sonMontosValidosParaProyeccion(double montoAInvertir, double interes, double montoDeseado) {
		sonMontosValidos(montoAInvertir, interes);
		if (montoDeseado <= montoAInvertir) throw new Error("El monto deseado es menor o igual que el monto invertido");
		}

	private static void sonMontosValidos(double montoAInvertir, double interes) {
		if (montoAInvertir <= 0) throw new Error("El monto a invertir no puede ser menor o igual a cero");
		if (interes <= 0) throw new Error("El interes no puede ser menor o igual a cero");
	}
}
