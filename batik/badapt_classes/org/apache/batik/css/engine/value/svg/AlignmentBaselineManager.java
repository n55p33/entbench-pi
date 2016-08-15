package org.apache.batik.css.engine.value.svg;
public class AlignmentBaselineManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_AFTER_EDGE_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          AFTER_EDGE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_ALPHABETIC_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          ALPHABETIC_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_AUTO_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          AUTO_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_BASELINE_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          BASELINE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_BEFORE_EDGE_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          BEFORE_EDGE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_HANGING_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          HANGING_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_IDEOGRAPHIC_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          IDEOGRAPHIC_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_MATHEMATICAL_VALUE, org.apache.batik.css.engine.value.svg.SVGValueConstants.
                                                    MATHEMATICAL_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_MIDDLE_VALUE, org.apache.batik.css.engine.value.svg.SVGValueConstants.
                                              MIDDLE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_TEXT_AFTER_EDGE_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          TEXT_AFTER_EDGE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_TEXT_BEFORE_EDGE_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          TEXT_BEFORE_EDGE_VALUE);
    }
    public boolean isInheritedProperty() {
        return false;
    }
    public boolean isAnimatableProperty() {
        return true;
    }
    public boolean isAdditiveProperty() {
        return false;
    }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_IDENT;
    }
    public java.lang.String getPropertyName() {
        return org.apache.batik.util.CSSConstants.
                 CSS_ALIGNMENT_BASELINE_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 AUTO_VALUE;
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public AlignmentBaselineManager() { super(
                                          );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "QkD4HgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAMV6aewr13XfvCfpPUmR9Z4kL6psy1qe7MpM/8NlhkNCqWvO" +
       "DMkZchYuM0NymkaejbMvnIWcYaLUMZDYiBHXSOTEARL1Q220DbwEQYJmQQIV" +
       "RWIHMQKkcJukRe00CBCnqdH4Q9OibpveGf53vfcUQQJKYC6H955z7/mde865" +
       "h/feL3wbui+JoVoUeoXphemRkadHjocepUVkJEcjBp0ocWLohKckiQDqXtSe" +
       "+cUbf/3dT1s3r0LXZOgxJQjCVEntMEhmRhJ6W0NnoBtntX3P8JMUusk4ylaB" +
       "s9T2YMZO0hcY6HvOsabQLeZEBBiIAAMR4EoEuHdGBZjeZgSZT5QcSpAmG+iH" +
       "oSsMdC3SSvFS6OmLnURKrPjH3UwqBKCH+8vfEgBVMecx9NQp9gPm1wD+TA1+" +
       "+Wd+4OYv3QPdkKEbdjAvxdGAECkYRIYe8g1fNeKkp+uGLkOPBIahz43YVjx7" +
       "X8ktQ48mthkoaRYbp0oqK7PIiKsxzzT3kFZiizMtDeNTeGvb8PSTX/etPcUE" +
       "WN95hvWAcFDWA4AP2kCweK1oxgnLva4d6Cn0vsscpxhvjQEBYL3uG6kVng51" +
       "b6CACujRw9x5SmDC8zS2AxOQ3hdmYJQUeuKOnZa6jhTNVUzjxRR6/DLd5NAE" +
       "qB6oFFGypNA7LpNVPYFZeuLSLJ2bn29z3/epHwyo4Gols25oXin//YDpyUtM" +
       "M2NtxEagGQfGhz7I/LTyzt/8xFUIAsTvuER8oPlXP/SdD3/vk69+9UDz7tvQ" +
       "8KpjaOmL2ufUh//gPcTz3XtKMe6PwsQuJ/8C8sr8J8ctL+QR8Lx3nvZYNh6d" +
       "NL46+53VR3/B+Mur0IM0dE0LvcwHdvSIFvqR7Rnx0AiMWEkNnYYeMAKdqNpp" +
       "6Dp4Z+zAONTy63VipDR0r1dVXQur30BFa9BFqaLr4N0O1uHJe6SkVvWeRxAE" +
       "XQcP9BB4noEOn+o7hTawFfoGrGhKYAchPInDEn8CG0GqAt1asAqs3oWTMIuB" +
       "CcJhbMIKsAPLOG7QkpLWBDLBW8XLDDjZmnDPAx7igy5wJTFKeVklANYRH5Wm" +
       "F/3/GDQvNXFzd+UKmKT3XA4RHvAuKvR0I35ReznD+9/50ou/d/XUZY51mEIf" +
       "AnIcHeQ4quQ4AnIcHeQ4quQ4AnIc3UkO6MqVavi3l/Ic7APMrgviBIigDz0/" +
       "/0ejj3zimXuAYUa7e8HUlKTwnQM5cRZZ6Cp+asC8oVc/u/sR6R/Xr0JXL0bk" +
       "EgOoerBkn5Rx9DRe3rrsibfr98bHv/XXX/7pl8Izn7wQ4o9DxWs5S1d/5rK2" +
       "41AzdBA8z7r/4FPKr7z4my/dugrdC+IHiJmpAtQGwtGTl8e44PIvnITPEst9" +
       "APA6jH3FK5tOYt6DqRWHu7Oaygwert4fATr+MHRcXHCKsvWxqCzffjCbctIu" +
       "oajC89+fRz//R7//F61K3SeR/Ma5tXFupC+cix5lZzeqOPHImQ0IsWEAuv/0" +
       "2clPfebbH/+HlQEAimdvN+CtsiRA1ABTCNT8o1/d/PE3v/G5r189M5oULJ+Z" +
       "6tlafgD5N+BzBTz/t3xKcGXFwfMfJY7Dz1On8ScqR37/mWwgEnnAMUsLuiUG" +
       "fqjba1tRPaO02P9947nGr/zXT9082IQHak5M6ntfv4Oz+r+DQx/9vR/4H09W" +
       "3VzRypXwTH9nZIfw+thZz704VopSjvxH/u17f/Yrys+DQA2CY2LvjSreQZU+" +
       "oGoC65UualUJX2prlsX7kvOOcNHXzmUsL2qf/vpfvU36q9/6TiXtxZTn/Lyz" +
       "SvTCwdTK4qkcdP+uy15PKYkF6JBXue+/6b36XdCjDHrUQLxL+BiEovyClRxT" +
       "33f9P/zrf/POj/zBPdDVAfSgFyr6QKkcDnoAWLqRWCCK5dE/+PDBmnf3g+Jm" +
       "BRV6DfiDgTxe/boXCPj8nWPNoMxYztz18f/Fe+rH/vR/vkYJVZS5zUJ9iV+G" +
       "v/BzTxAf+suK/8zdS+4n89eGZ5DdnfE2f8H/71efufbbV6HrMnRTO04dpTL4" +
       "AieSQbqUnOSTIL280H4x9Tms8y+chrP3XA4154a9HGjOlgXwXlKX7w9eii3v" +
       "LrX8IfB84Di2fOBybLkCVS8frlierspbZfGBak7uSaEHojhMgZQGSPeuJVWe" +
       "mgJJ7EDxqsGeB9XVupNUzO9IodrrL1GHnA/Y0iG0lWWrLHoHg2jf0XheqIbM" +
       "r4AYc1/zCDuql7+ZOwhfvv7dsuiXxeBE3Hc5nnbrJO5IIM0GZnPL8bAT+W9W" +
       "Fl9O0LGcl4R8/m8tJLDoh886Y0KQ5n7yzz79tX/y7DeB2Y2g+yplAGs7NyKX" +
       "lZn/j33hM+/9npf/5JNVUAURVfroc/+tyqPENwb1iRLqvMpgGCVJ2Sr2GXqF" +
       "9q7eNoltHywX2+O0Fn7p0W+6P/etLx5S1suudYnY+MTLP/43R596+eq5PwrP" +
       "viZXP89z+LNQCf22Yw3H0NN3G6XiGPz5l1/6jX/x0scPUj16Me3tg391X/z3" +
       "/+drR5/9k9+9TR51rxe+iYlNb9xPIQndO/mwkrxe4mJjtoAzZNDpiyaNj4jJ" +
       "tD/uIRqni4rXmNquO8IZzerleOQ1RW2yTluGgDdhzcC6DY7zzA0fq1PBF6d9" +
       "nZoJE7i3k2gx3wQC2d4ONGnjLTbahpEiCqO1vWh7gBRNI0yYazUUU7swJTu6" +
       "H7l5C00bXaPWQbtoe9Lat4IWkwRMROWRS218LXTWfSuQNzMO1VsiO/ALSRn6" +
       "2TRoGxuJmmfOOvWwMHMkdp5xruh0GnwhbZJAkceiuxcyld4kfjR2hnsb67ta" +
       "MFX3Q2HY4xdFlMijYJE3I0oaeL5gbOai3PcLfxbmbBTtVM1myMVK6/bm+n5l" +
       "4yOpb86XM1ZTw/Zs7AaC1dgXwxlWSEmHFjeqnoo5r/iM2p4SnBzbyWzIF4Wc" +
       "7XHP3yidCEjM5AS7LQpK9qxFk+iqfcmYy+FksOy2ZZGEhSWBD/hw40faZqhn" +
       "8ljxSQZ3ncEc2y7q4zmaYIWuj+arnO3g+L5uzfaDsAVW/MGqwVGLaMpEoz3d" +
       "cJuYZJGxBhI70Wv0TMGKO27NEcOhh/k+YrGdfLr3WzoucCFf1IJYkbwgDCcM" +
       "UjcMfxbvVdaLyIjf+IsG3lnMpj2TtzsCHhKFvqIVdBR5biHYckyP9wZqWmJ9" +
       "acjLrN2IBExiwz1CYRTD2XJddq1GMEvxJdJvrQo2J0UnaqDjHhvXOKHt1Uls" +
       "qsubeNOWLB5WSDMSC2KouGOe5GXLb00bihCwO07LZnWVCXWCJhoM20C2qKwq" +
       "UT4OVxNxYeGzDRcusSkVbpaNHu8hZA/faHtih4z1SIm6NN9M9HZf7uOZj8bE" +
       "2NxYxHBqyXybHvkrQt3V2VrPc1qdTFda2hoz2oLZFPqsrcmjMdFxO71oG/bq" +
       "dWWxMhVyvejlkt0cUYoqLFNzOTLndHvH9AdJfbJtyWhXZdr1dlfhGG4Ycv60" +
       "ySJuy050QczbWkuNES9lRDovlgLn6SBwaUBVWdacoZsd31/IiuquNIe0yWi/" +
       "riGbFHNinllJjDwVQ0/QfLcnGsJo3kyLXbhXfXbDFlZQTNH5Tp+5m9zZ0sPl" +
       "joo4Sd5K2XwssWUV35fq3iK2OdQMcYk37XlsLSVZ8Ld8JnaRbStm27QyZSmP" +
       "HggFn0+yseqirdnabnGhN7c3m3xTX6DkFG5x4/5cwzm7OUHDXoOv0b4XD3s9" +
       "a8gp7HZu9ilY2xluv3CxKS+HJicWKhHyem+5VCY90g3IAVGfTgeUIWxCgg93" +
       "9NSF4XVRKDMxZYfTYrDr+3uzGBCm3mwIHj/f87ZE+pLStBG4DmcKLsAaG684" +
       "XnIHmjtN+PmIcEyH7quUa/dMlLZxKhr1tBE+nRf17sCY5x2T0lvTUdGbDpqN" +
       "jDeyrr5tcvKqx06WuGb0lNGwVR8p+QLoBxkq+JL3XEyT1mTNELdWx0eGY9/r" +
       "J90pvp5Mhht2QkdZfdfFOtLUneZJPezsdzLQqxWKbkJMh6k4VHK5CJZ4ZOOw" +
       "nLNdbW+i5FZr6hTRXMj9mhZENDIB1oAFltMb1VCWZhzXQKxaoTcnwIGWSOST" +
       "u+EwMNpxfTlxGqjBrH3LGqylYDxXZkjQTnsrvO9MJ0xr7gZBPdORpe5oo6Sh" +
       "93xeEye9+iwl24hld8eckMyolhjhiCT40dAnTATlNpgLr1bN9mRFo31sGCUI" +
       "wYp0SI9xeuDBm7rcRVCkDreKadI25pLidvE6yyFJYSyQxbxB+xGnW0O0WPTY" +
       "NgfmZtua7tB1U7UGO5yOUbporaxhPc5Jckd6zm7YhrP1xCA79fXE8uq0Vnd8" +
       "fyqIs4FvFd153OkFeCd3a0OqttshEZkqjSY7KpY2smrH8X7qTVt2aI6sXkLN" +
       "dFobs6OZwLr1kJysJ9t2smQoOGPgNGYoLa7zvCnrQdjHnG4DW0wnSjeFRaPr" +
       "Eyt3JaFNDPx7XGiDmu1s98OEN6eFRXXTdgt19m0iqBN1U+kr3sTIRaE+0mhj" +
       "Rlo7SyUHpDLu8mAJJPYrRiDgIaxvaXEPN+bmml87o7xTaNulpc5rZrKLux1s" +
       "o6NJqDlFzy6afmpzTL412+RUb9Y82R0O2uyASMPmChYodd9WEExBBUFqkjJP" +
       "7OLpymxyuTmdqGxtzAUi0klr3S7D1DGluxAZAlNm8/rCLoJVyM2KsNfW9onV" +
       "IdSGWus0o5GT4AVYJfsT1zesbQ+r79JiBuvZohEHu2KMrIU1jBf+hER3YqIv" +
       "Mn6hujTfTZYrcZFiTaxAmvC6E6UOmSNGOt4M8pXoLBB8m8ed5pgOMHjrTCYM" +
       "8H9SJkazienU9cmEbO91XRrsjM5wUJtlRaYGzM6ZMlmNy7scTO6NBezkbJGN" +
       "3Vk8itud5ipY4Ou8PTS4UZMY1qJtC7NhLp6OQ0PWOqOdTg4LQ15x1l5rqh0a" +
       "E2skkpvsQG6zI6lDFAWrmqHN9qf9ORzjWkrU59hQjrzdcucGA3VjaTIxnwoN" +
       "TQkjIghZN3E3kjpE9J68kGf6Cl9Gw66g9QsT5b2w0NubFj00Bok11JPtKuCx" +
       "1MDG7prQKMmf9BnUwDphPNlIg+5mRe1ModWWcyJXpwiBF12si++0hBeKoj5t" +
       "wCHTIFfIet/qNuFah3KCorZnHYncSUuO30pdsyfu89jLhvOt3xLGGiIzproO" +
       "WsJO2Heztp/I83qTWK8XjoS3EKNAwkQBbWYx7iRRl+rAWjqO4GbujG3MxbWd" +
       "EsADLLAFvgVWC95KFlaRhpqx0vJJg9+v6yAsmTnv1EK/1VFWwW7SG1BCMg0c" +
       "Re0RdVwwhgS2GTSp/cCBl2N6kw+0sKvJ/QIhSVUecEEiTrYW38tVchPaIENv" +
       "NNpBiKIouwvniuiiZCAMzKCDZhiH+Nhiu4FTgkCWosMOrLoudgdU1+qo2228" +
       "8ynPHhGaL+zDHgGWvg2rqMQYGazifpvudeog9lO1HIFZRvCcPW7iO1PeJvx6" +
       "nW7kScdSkHSF1mDUEHWTQboN3OzSjQaeDDRqBqfUqKV14HSZbpuMigVyIY6E" +
       "GbeSBK42X4jzBiqA/6l1edDCYmOzpjZmqqzWXKNOjdn2psN22LYbID0v8mWL" +
       "NRIsonRLYVNuJocBPV/wI0/ASW8xYq2us5lz1LzZbnOwj+8bQzSyuRbnrKZS" +
       "jU6n9g4rOkXXbSRYOHQcv8hEQ6yjkhnzG4ditXqjkNFYlulBZyKsjO2Cbc3n" +
       "gwWdhfCCmCUrY1ebIiLhjAy3FyQDh6R73XWP5kREMruTFrfaTAKFHAzpNNzO" +
       "dq5KbVdbNmxwadchs0Uxaun1rcrnBax3Ogg6lingHPDESZT1FEXTbmo22GE/" +
       "dZxlz8XI1MVtjJhm+cChhM185OybzH6tdkZZgS94XVo5c2eXzJXGpsCWU9vI" +
       "zJXoI12zYzCqqvjIOkPEcTJT8l1SGztMs78XOwnRbnhjOZrFNKMnOmHXjVTy" +
       "GsgK23rxijHb1CjZDphVje/oWdYH7Kv9fhYN82WT21sRN1oxNj8azhh+0ttv" +
       "2liirVoATm3AqmOQ31n1DrKmGriHwvV0pdeCOduZSKjOU9jeDOxsqa2XmjQg" +
       "a5EzHiFkY2x0G4y+Ijy5PbA8SknrnbXIj4DAjaLuzQg8tAQmYDi1xQ/dlTeT" +
       "eGnHoiPOZ9G9L0ur6Uzw1gsbXQckikuzGo0nCtkQA4TuzXGakMa0CnQ9Q3Mx" +
       "C+a7zWRpj9buSja1+ZpphnxrG0QpxaFzhur6WhMlawQq4yKXb+aTsdGsqehc" +
       "Whcoqs+KoQGcRMIiFATUOE6269pg1K5HEzEDqASHwceOGdNbsjUeeqGBJ3uv" +
       "8Nq5vPaX880qHAjA9bIB0ywIISd5i1mqe5bUG7kv1tqbdrfpjBtwp6Fi87Td" +
       "C1vuiBj0EGoBj7ckNmrjbptZNBnUm4dahxW8BTyxc0ReMOK22xUa+VScFLG/" +
       "ILog72guuNZ22djlKQXCcTCdajLZ0IoC8VAHk4m2K7rkLMpZj202Gdqm1xt+" +
       "HO8KwyIzdmWFMz2mOF6glnbL6Aak4A/gNQqcVLIdlXbwVRoWcj60bXeEmd19" +
       "Rkl6DWPa1Ka3M1p5MDTAv7xmr2WSdDdZtXW9iY7x1jKksx67nxWdFZnKNVry" +
       "21sYF4lk6pIIZfZ65V/i9RvblXik2oA5PSl0PKxsmL6Bf+OHpqfL4rnTza7q" +
       "c+0uG+nnNhuhcofhvXc6AKx2Fz73sZdf0fnPN64eb9IqKfRAGkZ/zzO2hneu" +
       "q+ugpw/eeSeFrc4/zzYPv/Kx//KE8CHrI2/geOR9l+S83OW/ZL/wu8P3az95" +
       "FbrndCvxNSezF5leuLiB+GBspFkcCBe2Ed97qtnHSo29Hzz9Y832b39EcVsr" +
       "uFJZwWHu77IH/kN3afvhstil0GN2QgeWEdupoU/isDrrrhi+/5zBfCSFrqth" +
       "6BlKcGZM+ett7ZwfsqpIL6IvN06ZY/TMW4/+k3dp+4my+LEUerud9ALbV9Ly" +
       "8OIEftn20TOcH3+zOJ8Dz/wY5/ytx/kzd2n72bL4yRR61C4vPlRbfXdA+VNv" +
       "AuWNsvJJ8MjHKOW3HuU/u0vb58vilRS6YRrpCbzTs8FLdnyPfXwjpUL9T98E" +
       "6kfLyqfBox6jVt961L90l7ZfLosvXkTNHcef6RnEL70JiNUS8BR4nGOIzlsP" +
       "8bfu0vZqWfzaASJprJXMOxz5nBwrfOD1j0XO6Ctt/Pqb0MY7yspnKwUcPpu3" +
       "Xhtfu0vb75fFV1LoYaANWjeCtDx4ONw/os4QfvWNIMxT6PE73WsoD2Yff82t" +
       "q8NNIe1Lr9y4/12viH9YHe2f3uZ5gIHuX2eed/4c7dz7tSg21naF5YHDqVpU" +
       "ff27FHrub3UHA7gvKCsUXz+w/lEKPf26rOnxsdB5xv+YQu++C2MKXTu8nOf5" +
       "BlgwbscDxALlecr/nEI3L1MCKarv83R/lkIPntGBQQ8v50n+HPQOSMrXb0Un" +
       "ht96fXWdWcjxfOZXLiZrpxbz6OtZzLn87tkLWVl1de8kg8oOl/de1L78yoj7" +
       "we+0P3+4PqF5yn5f9nI/A10/3OQ4zcKevmNvJ31do57/7sO/+MBzJxnjwweB" +
       "zxztnGzvu/39hL4fpdWNgv2vvuuXv++fv/KN6gTw/wGkoRyuUykAAA==");
}
