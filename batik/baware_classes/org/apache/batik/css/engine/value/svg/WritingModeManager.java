package org.apache.batik.css.engine.value.svg;
public class WritingModeManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_LR_VALUE, org.apache.batik.css.engine.value.svg.SVGValueConstants.
                                                                           LR_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_LR_TB_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          LR_TB_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_RL_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          RL_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_RL_TB_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          RL_TB_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_TB_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          TB_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_TB_RL_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          TB_RL_VALUE); }
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return false; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_IDENT; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_WRITING_MODE_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 LR_TB_VALUE;
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public WritingModeManager() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1Ze5AUxRnv3YN7cXAPOEAex+tAebgrKlFzhAgHyJ17cHJI" +
       "wqEcvbO9u8PNzgwzvXd7GCJSSSCpSCEioqVU/sDCEBTKipWH0WBZiRKNFZUE" +
       "jSXmYZVEQkUqFZMKieT7emZ2Hnu751UFt2p6Z7u/r/t7/L6vv+49doGMNA3S" +
       "xFQe4QM6MyMrVN5JDZMlWhVqmuugr0d6uIz+fdO51beESXk3GZOmZodETbZS" +
       "ZkrC7CZTZdXkVJWYuZqxBHJ0GsxkRh/lsqZ2k0bZbMvoiizJvENLMCRYT40Y" +
       "qaecG3I8y1mbPQEnU2MgSVRIEl0aHG6JkRpJ0wdc8oke8lbPCFJm3LVMTupi" +
       "W2gfjWa5rERjsslbcgaZr2vKQErReITleGSLssg2QXtsUYEJZp6o/eTS3nSd" +
       "MMFYqqoaF+qZa5mpKX0sESO1bu8KhWXMreTrpCxGRnmIOWmOOYtGYdEoLOpo" +
       "61KB9KOZms20akId7sxUrksoECcz/JPo1KAZe5pOITPMUMlt3QUzaDs9r62l" +
       "ZYGKD82P7n94U90zZaS2m9TKaheKI4EQHBbpBoOyTJwZ5tJEgiW6Sb0Kzu5i" +
       "hkwVeZvt6QZTTqmUZ8H9jlmwM6szQ6zp2gr8CLoZWYlrRl69pACU/WtkUqEp" +
       "0HW8q6ul4UrsBwWrZRDMSFLAnc0yoldWE5xMC3LkdWy+HQiAtSLDeFrLLzVC" +
       "pdBBGiyIKFRNRbsAemoKSEdqAECDk0lFJ0Vb61TqpSnWg4gM0HVaQ0BVJQyB" +
       "LJw0BsnETOClSQEvefxzYfXiPfeoq9QwCYHMCSYpKP8oYGoKMK1lSWYwiAOL" +
       "sWZe7AAd//zuMCFA3Bggtmh+9LWLty5oOvmKRTN5EJo18S1M4j3S4fiYN6a0" +
       "zr2lDMWo1DVTRuf7NBdR1mmPtOR0yDDj8zPiYMQZPLn2lxt2HGXnw6S6jZRL" +
       "mpLNAI7qJS2jywozbmMqMyhniTZSxdREqxhvIxXwHpNVZvWuSSZNxtvICEV0" +
       "lWviN5goCVOgiarhXVaTmvOuU54W7zmdEFIBD6mBZxaxPuKbk95oWsuwKJWo" +
       "KqtatNPQUH8zChknDrZNR+OA+t6oqWUNgGBUM1JRCjhIM3tAMpE2BTJF+6iS" +
       "ZVGzLxX9igFqqynMgx1UBVwYEQSd/vkul0Ptx/aHQuCYKcG0oEBErdKUBDN6" +
       "pP3ZZSsuPt3zqgU5DBPbbpzcDBJELAkiQoIISBCxJIgICSIgQaRQAhIKiYXH" +
       "oSQWGsCXvZAVIC3XzO26u33z7pllAEO9fwQ4Akln+ranVjd1OPm+RzreMHrb" +
       "jLMLXwqTETHSQCWepQouutRIQR6Teu1Qr4nDxuXuH9M9+wdufIYmsQSkr2L7" +
       "iD1LpdbHDOznZJxnBmd3wziOFt9bBpWfnDzYf9/6e68Lk7B/y8AlR0K2Q/ZO" +
       "TPT5hN4cTBWDzVu769wnxw9s19yk4duDnK2zgBN1mBmERtA8PdK86fTZnue3" +
       "NwuzV0FS5xT8D/myKbiGLye1OPkddakEhZOakaEKDjk2ruZpQ+t3ewRm67Fp" +
       "tOCLEAoIKLaGL3Xpj7/9+l9uEJZ0dpFaz/bfxXiLJ3PhZA0iR9W7iFxnMAZ0" +
       "7x3sfPChC7s2CjgCxazBFmzGthUyFngHLPjNV7a+8/7Zw6fDLoQ5bN3ZOFRA" +
       "OaHLuMvwCcHzKT6YbbDDyjoNrXbqm57PfTquPMeVDbKgAqkBwdF8pwowlJMy" +
       "jSsM4+c/tbMXPvvXPXWWuxXocdCyYOgJ3P6rlpEdr276Z5OYJiThLuzazyWz" +
       "UvtYd+alhkEHUI7cfW9OfeRl+jhsEpCYTXkbE7mWCHsQ4cBFwhbXifbGwNhN" +
       "2Mw2vRj3h5GnWuqR9p7+ePT6j1+4KKT1l1tev3dQvcVCkeUFWOyLxG58uR9H" +
       "x+vYTsiBDBOCiWoVNdMw2Y0nV99Vp5y8BMt2w7ISpGVzjQF5M+eDkk09suL3" +
       "L740fvMbZSS8klQrGk2spCLgSBUgnZlpSLk5/cu3WnL0V0JTJ+xBCixU0IFe" +
       "mDa4f1dkdC48su3HE364+MihswKWujXH5HyGneLLsKKyd4P86Fs3/fbIAwf6" +
       "rdpgbvHMFuCb+O81Snznn/5V4BeR0wapWwL83dFjj01qXXJe8LvJBbmbc4U7" +
       "FyRol/f6o5l/hGeW/yJMKrpJnWRX0utxX4K47obq0XTKa6i2feP+StAqe1ry" +
       "yXNKMLF5lg2mNXfHhHekxvfRAQxORhcugecaG4PXBDEYIuKlXbDMEe1cbBYI" +
       "95VxUqUbGgcpGVS/5aYo2zlIIqtUyeXXEVCZVGId4BX7tilYJnIyf+gt3qqT" +
       "Ad5WSsb2Zmxut9ZdPBiec4PrEcLXa115xae8RGx6IEwwTqcWK51F2X945/5D" +
       "iTVPLLRA3OAvR1fAaeup3/33tcjBP5wapNap4pp+rcL6mOJZswKX9IVNhzhV" +
       "uBh8b8y+P/+kObVsODUJ9jUNUXXg72mgxLzikRgU5eWdH01atyS9eRjlxbSA" +
       "OYNTfr/j2Knb5kj7wuIIZQVHwdHLz9TiD4lqg8FZUV3nC4xZeQCMRcfOgWex" +
       "DYDFwcBwQTcHm6/6sV5dgrXE3iOXGBMugyAbK5ttahoOvxByUBWJ862/TkU/" +
       "d2XjJtSUcgbqjD77LHZ952Zpd3PnBxYMrxqEwaJrfDJ6//ozW14TDqtEhOTN" +
       "5EEHIMlTHdVhE8FQKJGjA/JEtze83/vYuacseYIJOUDMdu//zuXInv1WiFin" +
       "7VkFB14vj3XiDkg3o9QqgmPlh8e3P/fk9l1h2+53cVIR1zSFUTXvl1B+8xrn" +
       "t6Il6/Jv1/5sb0PZSgi+NlKZVeWtWdaW8AOwwszGPWZ1D+guHG2psUDjJDTP" +
       "2TlFkmMlktxn2LSxY5ku+jf7QX81PK02cluHD/pirCWA/Y0SY9/C5l446sjm" +
       "UlXOUI61ooN6HNNck+y4UiaZDU+7rVf78E1SjLWE2g+UGHsQm+9CoSDjdZjA" +
       "bhGD3H8FDFKLY03w3GFrdcfwDVKMtYTSh0qMfQ+bR6DeTjHuWCJ/dsvYkY9f" +
       "uuedc1Im29ebnojGnwOeMHv0CpiwAcdmwLPBtsOG4ZuwGGsJM50oMfYMNj/w" +
       "m3A15CqnGqsTBT7WpHbV5Vro2BWwUD2OTYeH2mrS4VuoGGsJK/y8xNiL2PzU" +
       "stBylqRZxSrYHQtdPXS96tILwz13BQzXiGNYq6Zt7dPDN1wx1hLGeb3E2G+w" +
       "OcXJGDBcWwJ2SzjwM6uu7HKN8av/hzFykBQL7/zwgDqx4P8H685cevpQbeWE" +
       "Q3eeEWVy/l67BsqeZFZRvEcoz3u5brCkLLSrsQ5Uuvh6m5PZn+lmEnIPtEKN" +
       "Mxbru5zMGJIVzlV9eQzZjGc5mVyCEc5V1ouX54+wnw7GA2JB66X8AEI/SAlS" +
       "iG8v3YecVLt0sKj14iX5CGYHEnw9rztRc8PQ5nIxY/szF/IfvvIYahwKQ57z" +
       "2ixfkSr+xHKquKz1N1aPdPxQ++p7Ln7hCesyT1Lotm04yyio3awrw/xxZUbR" +
       "2Zy5ylfNvTTmRNVsp6j0XSZ6ZRNIho1IXLxNCtxumc35S653Di9+4de7y9+E" +
       "cngjCVE4FmwsvDjI6Vk4J26MFdaocLQT124tcx8dWLIg+bd3xdUMKbiQCdL3" +
       "SKeP3P3WvomHm8JkVBsZCfUyy4kbjeUD6lom9RndZLRsrsiBiOg3qvgK4DEY" +
       "YRQ3EGEX25yj8714y8vJzMKyvvBuvFrR+pmxTMuqCZwGSuhRbo9zbPWd+LK6" +
       "HmBwezwnmZxVJaA3ALI9sQ5dd65IR9yii1QzMHjZgO2n4hWby/8DpTiUWeAe" +
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "W26Q3SNI/uiOzz/8e09+Jzv3+z/qR/4VNykAAA==");
}
