package br.jus.trf2.sgbd;

import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Comparator;

public enum AbreviaturaDeColunaEnum {
    //
    ADIA("adiamento"),
    //
    ADIC("adicional"),
    //
    ADMIN("administrador,administracao"),
    //
    ADV("advogado"),
    //
    ALIN("alinea"),
    //
    ALT("alteracao"),
    //
    ANDAM("andamento"),
    //
    ANT("anterior"),
    //
    APOSENT("aposentado,aposentadoria"),
    //
    ARQ("arquivamento,arquivo"),
    //
    ART("artigo"),
    //
    ATEND("atendimento"),
    //
    ATIV("atividade"),
    //
    AVAL("avaliacao,avaliador"),
    //
    AR("aviso_de_recebimento"),
    //
    BAI("bairro"),
    //
    CAD("cadastro"),
    //
    CALC("calculo"),
    //
    CAT("categoria"),
    //
    CERT("certidao"),
    //
    CID("cidade,municipio"),
    //
    CLASS("classe,classificacao"),
    //
    CLI("cliente"),
    //
    COB("cobranca"),
    //
    COD("codigo"),
    //
    COMP("complemento,completo"),
    //
    CONF("conferencia,conferir,confirmar,confirmacao,confianca"),
    //
    CFG("configuracao"),
    //
    CONT("contato"),
    //
    CTB("contribuicao"),
    //
    CST("custas,custo,custeio"),
    //
    DT("data"),
    //
    DEP("dependente,dependencia"),
    //
    DESC("desconto"),
    //
    DSC("descricao"),
    //
    DEST("destino,destinatario"),
    //
    DEV("devolucao"),
    //
    DIF("diferenca"),
    //
    DIR("direcao,direto"),
    //
    DISP("disponivel"),
    //
    DOC("documento"),
    //
    ECO("economia,economico"),
    //
    END("endereco"),
    //
    ENT("entidade"),
    //
    ESC("escolaridade"),
    //
    EST("estado"),
    //
    ESTU("estudante"),
    //
    ETA("etaria"),
    //
    XTR("extra"),
    //
    FX("faixa"),
    //
    FINANC("financeiro"),
    //
    FL("folha"),
    //
    FRM("form,formulario"),
    //
    FORMA("forma"),
    //
    FUND("fundamento"),
    //
    FUNC("funcao,funcionario"),
    //
    GER("geral,gerado,geracao,gerar"),
    //
    HST("historico"),
    //
    HR("hora"),
    //
    ID("identidade,identificador"),
    //
    IMG("imagem"),
    //
    INI("iniciar,inicio,inicial"),
    //
    INV("invalidar,invalido,invalida"),
    //
    JUD("judicial"),
    //
    LEG("legislativa,legal"),
    //
    LOGO("logotipo"),
    //
    LOGR("logradouro"),
    //
    LOT("lotacao"),
    //
    MAG("magistrado"),
    //
    MAI("maiusculo"),
    //
    MAN("manual"),
    //
    MAX("maximo"),
    //
    MSG("mensagem"),
    //
    MIN("minimo"),
    //
    MOD("modelo"),
    //
    MOV("movimento,movimentacao"),
    //
    MULT("multiplicador"),
    //
    N("nao"),
    //
    NASC("nascimento"),
    //
    NAT("natureza"),
    //
    NM("nome"),
    //
    NUM("numero"),
    //
    OBJ("objeto"),
    //
    OBS("observacao"),
    //
    OFIC("oficio,oficial"),
    //
    ORG("orgao"),
    //
    ORGJULG("orgao_julgador"),
    //
    PGTO("pagamento"),
    //
    PAG("pagina"),
    //
    PAR("parâmetro"),
    //
    PART("parte,Participante"),
    //
    PESQ("pesquisa"),
    //
    PLA("plano"),
    //
    PRZ("prazo"),
    //
    PREV("prevencao,prevento"),
    //
    PRINC("principal"),
    //
    PRIV("privado"),
    //
    PROC ("processo"),
    //
    PROT("protocolo"),
    //
    PROV("provisorio"),
    //
    PROPORC("proporcionalidade"),
    //
    PROX("proximo,proxima"),
    //
    PUBL("publicacao"),
    //
    QUALI("qualificacao"),
    //
    QTDE("quantia,quantidade"),
    //
    REAL("realizado,realizada,real"),
    //
    REAT("reativacao"),
    //
    RED("redistribuicao"),
    //
    REF("referente,referencia"),
    //
    REGIM("regimento,regimental"),
    //
    REG("registro"),
    //
    RELAC("relacionado,relacional"),
    //
    REL("relator"),
    //
    RELAT("relatorio"),
    //
    REMAN("remanescente"),
    //
    REM("remessa"),
    //
    RMI("renda_mensal_inicial"),
    //
    REPAR("reparticao"),
    //
    RESP("responsavel"),
    //
    REUN("reuniao"),
    //
    REVIS("revisada"),
    //
    REV("revisor,revisao"),
    //
    RUB("rubrica"),
    //
    SAL("salario"),
    //
    SECR("secretaria,secretario"),
    //
    SEC("secundario,secundaria"),
    //
    SEG("segredo"),
    //
    SEGU("seguro,seguradora"),
    //
    SEL("selecao"),
    //
    SENT("sentido"),
    //
    SQ("sequencia,sequencial"),
    //
    SG("sigla"),
    //
    S("sim"),
    //
    SIST("sistema"),
    //
    SIT("situacao"),
    //
    SOL("solicitacao"),
    //
    SUBST("substituto"),
    //
    SXX("sumula"),
    //
    SUP("superior"),
    //
    TAM("tamanho"),
    //
    TAR("tarefa"),
    //
    TEL("telefone"),
    //
    TMP("temporario,temporalidade,tempo"),
    //
    TXT("texto"),
    //
    THES("thesaurus"),
    //
    TP("tipo"),
    //
    TIT("titulo,titular"),
    //
    TRIB("tribunal"),
    //
    ULT("ultimo,ultima"),
    //
    UNIC("unicidade"),
    //
    UNID("unidade"),
    //
    UA("unidade_administrativa"),
    //
    UF("unidade_federativa,unidade_da_federacao"),
    //
    UNIT("unitario"),
    //
    URG("urgente"),
    //
    USU("usuario"),
    //
    VL("valor"),
    //
    VIG("vigencia"),
    //
    VOL("volume");

    final private static Map<String, AbreviaturaDeColunaEnum> map = new TreeMap<>();
    final private static SortedSet<String> set = new TreeSet<>(new Comparator<String>() {
        @Override
        public int compare(String e1, String e2) {
            if (e1.length() != e2.length())
                return Integer.valueOf(e2.length()).compareTo(e1.length());
            return e1.compareTo(e2);
        }
    });

    static {
        for (final AbreviaturaDeColunaEnum e : AbreviaturaDeColunaEnum.values()) {
            String[] a = e.nome.split(",");
            for (String i : a) {
                String fragment = "_" + i + "_";
                map.put(fragment, e);
                set.add(fragment);
            }
        }
    };

    String nome;

    AbreviaturaDeColunaEnum(final String nome) {
        this.nome = nome;
    }

    public static String abreviar(final String s) {
        String id = "_" + s + "_";
        for (String i : set) {
            if (id.contains(i))
                id = id.replace(i, "_" + map.get(i).name().toLowerCase() + "_");
        }
        return id.substring(1, id.length() - 1);
    }

    
}