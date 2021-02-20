package br.jus.trf2.sgbd;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AbreviaturaDeColunaEnumTest {
	@Test
	public void abreviacaoSimples() {
		assertEquals("adia", AbreviaturaDeColunaEnum.abreviar("adiamento"));
	}

	@Test
	public void abreviacaoDupla() {
		assertEquals("andam_ant", AbreviaturaDeColunaEnum.abreviar("andamento_anterior"));
	}

	@Test
	public void abreviacaoItemComposto() {
		assertEquals("ar", AbreviaturaDeColunaEnum.abreviar("aviso_de_recebimento"));
	}

	@Test
	public void abreviacaoItemCompostoComSubitem() {
		assertEquals("rmi", AbreviaturaDeColunaEnum.abreviar("renda_mensal_inicial"));
	}

}
