package br.jus.trf2.sgbd;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class SgbdTest {
	@Test
	public void stringAbreviacaoEFragmento() {
		assertEquals("nm_estu", Sgbd.calcularNomeDaColuna(String.class, "estudante_nome"));
	}

	@Test
	public void stringAbreviacoesEFragmento() {
		assertEquals("ds_dsc_cob_cli", Sgbd.calcularNomeDaColuna(String.class, "descricao_cobranca_cliente"));
	}

	@Test
	public void stringAbreviacoesEFragmentoEPreposicoesEArtigos() {
		assertEquals("vl_cob_cli_servico",
				Sgbd.calcularNomeDaColuna(Float.class, "valor_da_cobranca_ao_cliente_pelo_servico"));
	}

	@Test
	public void stringMneumonicosDeTabela() {
		assertEquals("cda", Sgbd.abreviarNomeDeTabela("Cda"));
		assertEquals("pess", Sgbd.abreviarNomeDeTabela("Pessoa"));
		assertEquals("qtde", Sgbd.abreviarNomeDeTabela("Quantidade"));
		assertEquals("quan", Sgbd.abreviarNomeDeTabela("Quantitativo"));
		assertEquals("temp", Sgbd.abreviarNomeDeTabela("Tempo"));
		assertEquals("tmes", Sgbd.abreviarNomeDeTabela("TempoDeEstudo"));
		assertEquals("tmet", Sgbd.abreviarNomeDeTabela("tempoDeEstudoTotal"));
		assertEquals("tenh", Sgbd.abreviarNomeDeTabela("tempoDeEstudoNecessarioHoje"));
	}

}
