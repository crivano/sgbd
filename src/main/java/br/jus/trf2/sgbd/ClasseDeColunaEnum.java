package br.jus.trf2.sgbd;

import java.lang.reflect.Type;

public enum ClasseDeColunaEnum {
	// Caracteres
	CD("Código", "String", "cod,cpf,cnpj",
			"Código propriamente dito representando uma chave , identificador, tipo, classificação, categoria, nível e tudo que requeira decodificação e tenha formato.",
			"CPF, alínea, classificação documental"),
	//
	DS("Descrição", "String", "dsc",
			"Descrição de alguma coisa ou ser, sem formato pré-definido e sem regras rígidas de preenchimento.",
			"Um texto qualquer"),
	//
	IE("Identificador Externo", "String", "ie",
			"Identificador de objeto com mesmo valor de identificador em sistema externo. Usado para manter uma correspondência dos objetos em sistemas diferentes.",
			"Ex1: Usado em tabelas de correpondência (de/para), Ex2: DOENTE.IE_PESSOA contém os mesmos valores de PESSOA.ID_PESSOA em um suposto sistema médico que importe dados de um sistema de RH externo via arquivos XML."),
	//
	IP("Internet Protocol", "String", "ip", "Indica o número IP de um dispositivo de rede", "Ex: 192.168.0.1"),
	//
	MM("Multimídia", "String", "http,https", "Elementos multimídia", "gráficos, imagens, sons, filmes ou animações"),
	//
	NM("Nome", "String", "nm", "Nome completo ou abreviado pelo qual o objeto é conhecido",
			"nome de pessoa física/jurídica, nome de atividades, nome de peça, etc."),
	//
	SG("Sigla", "String", "sg",
			"Abreviação ou simples conjunto de caracteres (com significado) que identifica objetos do mundo real",
			"Sigla de estados, órgãos, pessoas, etc."),
	//
	TX("Texto", "String", "txt", "Texto que não necessariamente descreve um objeto",
			"Comentário livre, observação livre, explicação, exemplificação, significado, etc."),

	// Numéricos
	ID("Identificador", "Long", "id", "Identificador principal da tabela", "12356"),
	//
	MD("Medida", "Float,Double",
			"peso,capacidade,area,profundidade,distancia,perimetro,vazao,pressao,densidade,velocidade,comprimento",
			"Número que exprime uma quantidade sujeita à medição",
			"peso, capacidade, área, profundidade, distância, perímetro, vazão, pressão, densidade, velocidade, comprimento, etc."),
	//
	NR("Número", "Long,long,Integer,int", "nr,posicao,ordem",
			"Numeração cardinal livre que representa uma sequência ou constante", "posição na fila, número Pi, etc."),
	//
	PR("Percentual", "Long,long,Integer,int,Float,float,Double,double", "perc,percentual",
			"Número que exprime uma percentagem ou taxa", "lucro, cumprimeto de meta, perda"),
	//
	QT("Quantidade", "Long,long,Integer,int,Float,float,Double,double", "quantidade,qtd",
			"Número que exprime uma quantidade obtida através de contagem do objeto tratado, exceto valores monetários e medições, ou simplesmente um quantitativo acumulado.",
			"Totais, contagens, etc."),
	//
	VL("Valor", "Money,Long,long,Integer,int,Float,float,Double,double", "vl",
			"Quantitativo monetário ou para medições",
			"custo, preço, pagamento, recebimento, velocidade, altura, etc."),

	// Outros tipos
	BT("Byte", "byte[]", null, "Dados em bytes brutos", "Imagens, Arquivos, ZIPs"),
	//
	// Desabilitado enquanto não encontramos um tipo de dados para localização
	// geográfica
	// SD("Dado Espacial", null, null, "Dado espacial (spatial data) que descreve a
	// forma e a posição de objetos. A forma destes objetos é representada por
	// elementos geométricos como pontos, linhas e polígonos, incluindo agrupamento
	// destes. A posição é representada por um sistema de referência de
	// coordenadas.", "Coordenada Geográfica, Latitude, Longitude, Área"),
	//
	DF("Data Fuso", "Date", null,
			"Marca temporal (timestamp),composta pela data e hora com elevada precisão e a diferença  entre o tempo local e o tempo universal",
			"Ex1. 1490299233160, Ex2. Thu Mar 23 2017 16:59:33 GMT-0300 (Hora oficial do Brasil)"),
	//
	DT("Data", "LocalDate", null, "Qualquer data (completa ou não) que exprime a data efetiva de um evento",
			"01/01/2000"),
	//
	HR("Hora", "LocalTime", null, "Qualquer valor hora (completa ou não) que exprime o horário efetivo de um evento",
			"13:02:17"),
	//
	DH("Data/Hora", "LocalDateTime", null, "Qualquer valor data e hora que exprime o momento em que um evento ocorre",
			"01/01/2000 13:02:17"),
	//
	LG("Lógico", "Boolean,boolean", null, "Indica valores booleanos Verdadeiro ou Falso, 0 e 1",
			"Ex: campo PESSOA.LG_ADMIN com valor falso"),
	//
	// Desabilitado porque normalmente é mais seguro optar por tipo, já que o
	// domínio pode crescer com o tempo
	// FG("Flag ou sinalizador", "Enum", null, "Indicação de domínio restrito, no
	// sentido de apontar dois elementos possíveis", "(S,N), (+,-)"),
	//
	TP("Domínio Restrito", "Enum", null, "Indicação de domínio restrito ou lista de elementos possíveis.",
			"Domínio de Status: [ausente, presente, indefinido], Domínio de sexo: [masculino,feminino]");

	String nome;
	String classe;
	String fragmento;
	String dsc;
	String exemplo;

	ClasseDeColunaEnum(final String nome, final String classe, final String fragmento, final String dsc,
			final String exemplo) {
		this.nome = nome;
		this.classe = classe;
		this.fragmento = fragmento;
		this.dsc = dsc;
		this.exemplo = exemplo;
	}

	public static String inferir(Type tipo, String s) {
		String tipoStr = tipo.toString();
		if (tipo instanceof Class && ((Class<?>) tipo).isEnum()) {
			tipoStr += " Enum";
		}
		ClasseDeColunaEnum aceitavel = null;
		for (final ClasseDeColunaEnum e : ClasseDeColunaEnum.values()) {
			String[] classes = e.classe.split(",");
			for (String classe : classes) {
				if (!tipoStr.contains(classe))
					continue;
				aceitavel = e;
				if (e.fragmento != null) {
					String[] fragmentos = e.fragmento.split(",");
					for (String fragmento : fragmentos) {
						boolean containsFragmento = ("_" + s + "_").contains("_" + fragmento + "_");
						if (containsFragmento) {
							// String id = removerFragmentoDeIdentificador(fragmento, s);
							String id = removerFragmentoDeIdentificador(e.name().toLowerCase(), s);
							id = e.name().toLowerCase() + ("".equals(id) ? "" : "_" + id);
							return id;
						}
					}
				}
			}
		}
		if (aceitavel != null) {
			String id = removerFragmentoDeIdentificador(aceitavel.name().toLowerCase(), s);
			return aceitavel.name().toLowerCase() + ("".equals(id) ? "" : "_" + id);
		}
		return s;
	}

	public static String removerFragmentoDeIdentificador(String frag, String id) {
		String idEsc = "_" + id + "_";
		String fragEsc = "_" + frag + "_";
		if (idEsc.contains(fragEsc)) {
			idEsc = idEsc.replace(fragEsc, "_");
		}
		if ("_".equals(idEsc))
			return "";
		return idEsc.substring(1, idEsc.length() - 1);
	}

}