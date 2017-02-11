package calculadoraredeip;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestElementoDeRede {

	@Test
	public void testInvalida() {
		CalculadoraDeRede calculadora = new CalculadoraDeRede();
		Mascara mascaraDeRede = new Mascara("255.192.255.1");
		mascaraDeRede.converterParaDecimal(mascara);
		mascaraDeRede.converterParaBinario();
		if(mascaraDeRede.verificarMascara(calculadora.getClasse()) == true) fail();	
	}
	
	@Test
	public void testValida() {
		CalculadoraDeRede calculadora = new CalculadoraDeRede();
		Mascara mascaraDeRede = new Mascara("255.255.255.0");
		mascaraDeRede.converterParaDecimal(mascara);
		mascaraDeRede.converterParaBinario();
		if(mascaraDeRede.verificarMascara(calculadora.getClasse()) == false) fail();	
	}

}
