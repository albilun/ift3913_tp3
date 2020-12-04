package test;

import java.util.ArrayList;

import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import currencyConverter.Currency;
import currencyConverter.MainWindow;

public class TestBoiteNoire {
	
	@Rule
	public final ArrayList<Currency> currencies = Currency.init();
	
	//TESTS BOITE NOIRE
	
	@Test
	//Teste si deux devises existantes retourne un nombre
	public void testMainWindowConvert1() {
		Assertions.assertEquals(
			MainWindow.convert("US Dollar", "Euro", currencies, 10d).getClass(), 
			Double.class);
	}
	
	@Test
	//Teste si devise existante et devise inexistante ne retourne pas de nombre
	public void testMainWindowConvert2() {
		Assertions.assertNotEquals(
			MainWindow.convert("Swiss Franc", "German Mark", currencies, 10d).getClass(), 
			Double.class);
	}
	
	@Test
	//Teste si devise inexistante et devise existante ne retourne pas de nombre
	public void testMainWindowConvert3() {	
		Assertions.assertNotEquals(
			MainWindow.convert("Algerian Dinar", "Chinese Yuan Renminbi", currencies, 10d).getClass(), 
			Double.class);
	}
	
	@Test
	//Teste si devise inexistante et devise existante ne retourne pas de nombre
	public void testMainWindowConvert4() {	
		Assertions.assertNotEquals(
			MainWindow.convert("Afghan Afghani", "Central African CFA Franc", currencies, 10d).getClass(), 
			Double.class);
	}
	
	@Test
	//Teste si un nombre negatif ne retourne pas de nombre
	public void testMainWindowConvertNegative() {	
		Assertions.assertNotEquals(
			MainWindow.convert("US Dollar", "Euro", currencies, -10d).getClass(), 
			Double.class);
	}
	
	@Test
	//Teste si un nombre positif retourne un nombre
	public void testMainWindowConvertPositive() {
		Assertions.assertEquals(
			MainWindow.convert("US Dollar", "Euro", currencies, 10d).getClass(), 
			Double.class);
	}
	
	@Test
	//Teste la limite inferieure positive de la fonction MainWindow.convert()
	public void testMainWindowConvertLimitePositive() {
		Assertions.assertEquals(
			MainWindow.convert("US Dollar", "Euro", currencies, 0d).getClass(), 
			Double.class);
	}
	
	@Test
	//Teste la limite superieure negative de la fonction MainWindow.convert()
	public void testMainWindowConvertLimiteNegative() {
		Assertions.assertNotEquals(
			MainWindow.convert("US Dollar", "Euro", currencies, -0.1d).getClass(), 
			Double.class);
	}
	
	@Test
	//Teste si le montant et le taux d'echange sont positifs
	public void testCurrencyConvert1() {
		Assertions.assertEquals(
			Currency.convert(10d, 1.3).getClass(), 
			Double.class);
	}

	@Test
	//Teste si le montant est positif et le taux d'echange est negatif
	public void testCurrencyConvert2() {
		Assertions.assertNotEquals(
			Currency.convert(10d, -1.3).getClass(), 
			Double.class);
	}

	@Test
	//Teste si le montant est negatif et le taux d'echange est positif
	public void testCurrencyConvert3() {
		Assertions.assertNotEquals(
			Currency.convert(-10d, 1.3).getClass(), 
			Double.class);
	}

	@Test
	//Teste si le montant et le taux d'echange sont negatifs
	public void testCurrencyConvert4() {
		Assertions.assertNotEquals(
			Currency.convert(-10d, -1.3).getClass(), 
			Double.class);
	}
	
	@Test
	//Teste la limite inferieure positive du montant
	public void testCurrencyConvertLimitePositive1() {
		Assertions.assertEquals(
			Currency.convert(0d, 1.5d).getClass(), 
			Double.class);
	}
	
	@Test
	//Teste la limite inferieure positive du taux d'echange
	public void testCurrencyConvertLimitePositive2() {
		Assertions.assertEquals(
			Currency.convert(10d, 0d).getClass(), 
			Double.class);
	}
	
	@Test
	//Teste la limite superieure negative du montant
	public void testCurrencyConvertLimitenegative1() {
		Assertions.assertNotEquals(
			Currency.convert(-0.1d,1.5d).getClass(), 
			Double.class);
	}
	
	@Test
	//Teste la limite superieure negative du taux d'echange
	public void testCurrencyConvertLimiteNegative2() {
		Assertions.assertNotEquals(
			Currency.convert(10d, -0.1d).getClass(), 
			Double.class);
	}
	
	//TESTS BOITE BLANCHE
	
	@Test
	//Test qui couvre quand les 3 "if" sont respectes
	public void testCouverture1() {
		Assertions.assertEquals(
			MainWindow.convert("US Dollar", "Euro", currencies, 10d).getClass(), 
			Double.class);
	}
	
	@Test
	//Test qui couvre quand les 2 premiers "if" sont respectes, mais pas le 3eme
	public void testCouverture2() {
		Assertions.assertNotEquals(
			MainWindow.convert("German Mark", "Japanese Yen", currencies, 10d).getClass(), 
			Double.class);
		}
	
	@Test
	//Test qui couvre quand aucun des "if" ne sont respectes
	public void testCouverture3() {
		Assertions.assertNotEquals(
			MainWindow.convert("Afghan Afghani", "Central African CFA Franc", currencies, 10d).getClass(), 
			Double.class);
	}
}
