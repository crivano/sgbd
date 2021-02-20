package br.jus.trf2.sgbd;

import java.lang.reflect.Type;

/**
 * Gera siglas para tabelas e colunas de banco de dados com base na
 * especificação constante em
 * https://siga.jfrj.jus.br/sigagc/app/exibir/TRF2GC201700136
 */
public final class Sgbd {
	public static String abreviarNomeDaColuna(String nome) {
		String nomeSnakeCase = converterParaSnakeCase(nome);
		String nomeSemPreposicoesEArtigos = removerPreposicoesEArtigos(nomeSnakeCase);
		String nomeAbreviado = AbreviaturaDeColunaEnum.abreviar(nomeSemPreposicoesEArtigos);
		return nomeAbreviado;
	}

	public static String calcularNomeDaColuna(Type tipo, String nome) {
		String nomeAbreviado = abreviarNomeDaColuna(nome);
		String nomeComClasse = ClasseDeColunaEnum.inferir(tipo, nomeAbreviado);
		return nomeComClasse;
	}

	public static String removerPreposicoesEArtigos(String s) {
		s = s.replace("_de_", "_");
		s = s.replace("_da_", "_");
		s = s.replace("_do_", "_");
		s = s.replace("_das_", "_");
		s = s.replace("_dos_", "_");
		s = s.replace("_para_", "_");
		s = s.replace("_pelo_", "_");
		s = s.replace("_ao_", "_");
		s = s.replace("_a_", "_");
		s = s.replace("_o_", "_");
		return s;
	}

	public static String calcularNomeDeTabela(String nome) {
		String nomeComCifraoSubstituido = nome.replace("$X", "_x_").replace("$", "_");
		String nomeSnakeCase = converterParaSnakeCase(nomeComCifraoSubstituido);
		return nomeSnakeCase;
	}

	public static String abreviarNomeDeTabela(String nome) {
		String nomeDeTabela = calcularNomeDeTabela(nome);
		String nomeSemPreposicoesEArtigos = removerPreposicoesEArtigos(nomeDeTabela);

		if (nomeSemPreposicoesEArtigos.length() <= 4)
			return nomeSemPreposicoesEArtigos;

		String nomeAbreviado = AbreviaturaDeColunaEnum.abreviar(nomeSemPreposicoesEArtigos);
		String[] a = nomeAbreviado.split("_");
		if (a.length == 1) {
			if (nomeAbreviado.length() < 4)
				return nomeSemPreposicoesEArtigos.substring(0, 4);
			if (nomeAbreviado.length() == 4)
				return nomeAbreviado;
			return a[0].substring(0, 4);
		}
		if (a.length == 2) {
			return a[0].substring(0, 2) + a[1].substring(0, 2);
		} else if (a.length == 3) {
			return a[0].substring(0, 2) + a[1].substring(0, 1) + a[2].substring(0, 1);
		} else {
			return a[0].substring(0, 1) + a[1].substring(0, 1) + a[2].substring(0, 1) + a[3].substring(0, 1);
		}
	}

	public static String converterParaSnakeCase(final String identifier) {
		if (identifier == null)
			return null;
		final String regex = "([a-z])([A-Z])";
		final String replacement = "$1_$2";
		final String newName = identifier.replaceAll(regex, replacement).toLowerCase();
		return newName;
	}

}
