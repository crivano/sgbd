package br.jus.trf2.sgbd;

import static org.junit.Assert.assertEquals;

import java.math.RoundingMode;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class ClasseDeColunaEnumTest {
	@Test
	public void stringSemFragmento() {
		assertEquals("tx_pessoa_principal", ClasseDeColunaEnum.inferir(String.class, "pessoa_principal"));
	}

	@Test
	public void stringComFragmento() {
		assertEquals("nm_pessoa", ClasseDeColunaEnum.inferir(String.class, "pessoa_nm"));
	}

	@Test
	public void stringComFragmentoIgualAClasse() {
		assertEquals("sg", ClasseDeColunaEnum.inferir(String.class, "sg"));
	}

	@Test
	public void stringComFragmentoDeferenteDaClasse() {
		assertEquals("cd_cpf", ClasseDeColunaEnum.inferir(String.class, "cpf"));
	}

	@Test
	public void id() {
		assertEquals("id", ClasseDeColunaEnum.inferir(Long.class, "id"));
	}

	@Test
	public void enumComPrimeiraPalavraSendoTipo() {
		assertEquals("tp_arredondamento", ClasseDeColunaEnum.inferir(RoundingMode.class, "tp_arredondamento"));
	}

}
