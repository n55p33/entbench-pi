package org.apache.batik.css.engine.value.css2;
public class FontWeightManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_ALL_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          ALL_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_BOLD_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          BOLD_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_BOLDER_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          BOLDER_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_LIGHTER_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          LIGHTER_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_NORMAL_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          NORMAL_VALUE); }
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_FONT_WEIGHT_VALUE; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_FONT_WEIGHT_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.ValueConstants.
                 NORMAL_VALUE;
    }
    public org.apache.batik.css.engine.value.Value createValue(org.w3c.css.sac.LexicalUnit lu,
                                                               org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException {
        if (lu.
              getLexicalUnitType(
                ) ==
              org.w3c.css.sac.LexicalUnit.
                SAC_INTEGER) {
            int i =
              lu.
              getIntegerValue(
                );
            switch (i) {
                case 100:
                    return org.apache.batik.css.engine.value.ValueConstants.
                             NUMBER_100;
                case 200:
                    return org.apache.batik.css.engine.value.ValueConstants.
                             NUMBER_200;
                case 300:
                    return org.apache.batik.css.engine.value.ValueConstants.
                             NUMBER_300;
                case 400:
                    return org.apache.batik.css.engine.value.ValueConstants.
                             NUMBER_400;
                case 500:
                    return org.apache.batik.css.engine.value.ValueConstants.
                             NUMBER_500;
                case 600:
                    return org.apache.batik.css.engine.value.ValueConstants.
                             NUMBER_600;
                case 700:
                    return org.apache.batik.css.engine.value.ValueConstants.
                             NUMBER_700;
                case 800:
                    return org.apache.batik.css.engine.value.ValueConstants.
                             NUMBER_800;
                case 900:
                    return org.apache.batik.css.engine.value.ValueConstants.
                             NUMBER_900;
            }
            throw createInvalidFloatValueDOMException(
                    i);
        }
        return super.
          createValue(
            lu,
            engine);
    }
    public org.apache.batik.css.engine.value.Value createFloatValue(short type,
                                                                    float floatValue)
          throws org.w3c.dom.DOMException {
        if (type ==
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_NUMBER) {
            int i =
              (int)
                floatValue;
            if (floatValue ==
                  i) {
                switch (i) {
                    case 100:
                        return org.apache.batik.css.engine.value.ValueConstants.
                                 NUMBER_100;
                    case 200:
                        return org.apache.batik.css.engine.value.ValueConstants.
                                 NUMBER_200;
                    case 300:
                        return org.apache.batik.css.engine.value.ValueConstants.
                                 NUMBER_300;
                    case 400:
                        return org.apache.batik.css.engine.value.ValueConstants.
                                 NUMBER_400;
                    case 500:
                        return org.apache.batik.css.engine.value.ValueConstants.
                                 NUMBER_500;
                    case 600:
                        return org.apache.batik.css.engine.value.ValueConstants.
                                 NUMBER_600;
                    case 700:
                        return org.apache.batik.css.engine.value.ValueConstants.
                                 NUMBER_700;
                    case 800:
                        return org.apache.batik.css.engine.value.ValueConstants.
                                 NUMBER_800;
                    case 900:
                        return org.apache.batik.css.engine.value.ValueConstants.
                                 NUMBER_900;
                }
            }
        }
        throw createInvalidFloatValueDOMException(
                floatValue);
    }
    public org.apache.batik.css.engine.value.Value computeValue(org.apache.batik.css.engine.CSSStylableElement elt,
                                                                java.lang.String pseudo,
                                                                org.apache.batik.css.engine.CSSEngine engine,
                                                                int idx,
                                                                org.apache.batik.css.engine.StyleMap sm,
                                                                org.apache.batik.css.engine.value.Value value) {
        if (value ==
              org.apache.batik.css.engine.value.ValueConstants.
                BOLDER_VALUE) {
            sm.
              putParentRelative(
                idx,
                true);
            org.apache.batik.css.engine.CSSContext ctx =
              engine.
              getCSSContext(
                );
            org.apache.batik.css.engine.CSSStylableElement p =
              org.apache.batik.css.engine.CSSEngine.
              getParentCSSStylableElement(
                elt);
            float fw;
            if (p ==
                  null) {
                fw =
                  400;
            }
            else {
                org.apache.batik.css.engine.value.Value v =
                  engine.
                  getComputedStyle(
                    p,
                    pseudo,
                    idx);
                fw =
                  v.
                    getFloatValue(
                      );
            }
            return createFontWeight(
                     ctx.
                       getBolderFontWeight(
                         fw));
        }
        else
            if (value ==
                  org.apache.batik.css.engine.value.ValueConstants.
                    LIGHTER_VALUE) {
                sm.
                  putParentRelative(
                    idx,
                    true);
                org.apache.batik.css.engine.CSSContext ctx =
                  engine.
                  getCSSContext(
                    );
                org.apache.batik.css.engine.CSSStylableElement p =
                  org.apache.batik.css.engine.CSSEngine.
                  getParentCSSStylableElement(
                    elt);
                float fw;
                if (p ==
                      null) {
                    fw =
                      400;
                }
                else {
                    org.apache.batik.css.engine.value.Value v =
                      engine.
                      getComputedStyle(
                        p,
                        pseudo,
                        idx);
                    fw =
                      v.
                        getFloatValue(
                          );
                }
                return createFontWeight(
                         ctx.
                           getLighterFontWeight(
                             fw));
            }
            else
                if (value ==
                      org.apache.batik.css.engine.value.ValueConstants.
                        NORMAL_VALUE) {
                    return org.apache.batik.css.engine.value.ValueConstants.
                             NUMBER_400;
                }
                else
                    if (value ==
                          org.apache.batik.css.engine.value.ValueConstants.
                            BOLD_VALUE) {
                        return org.apache.batik.css.engine.value.ValueConstants.
                                 NUMBER_700;
                    }
        return value;
    }
    protected org.apache.batik.css.engine.value.Value createFontWeight(float f) {
        switch ((int)
                  f) {
            case 100:
                return org.apache.batik.css.engine.value.ValueConstants.
                         NUMBER_100;
            case 200:
                return org.apache.batik.css.engine.value.ValueConstants.
                         NUMBER_200;
            case 300:
                return org.apache.batik.css.engine.value.ValueConstants.
                         NUMBER_300;
            case 400:
                return org.apache.batik.css.engine.value.ValueConstants.
                         NUMBER_400;
            case 500:
                return org.apache.batik.css.engine.value.ValueConstants.
                         NUMBER_500;
            case 600:
                return org.apache.batik.css.engine.value.ValueConstants.
                         NUMBER_600;
            case 700:
                return org.apache.batik.css.engine.value.ValueConstants.
                         NUMBER_700;
            case 800:
                return org.apache.batik.css.engine.value.ValueConstants.
                         NUMBER_800;
            default:
                return org.apache.batik.css.engine.value.ValueConstants.
                         NUMBER_900;
        }
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public FontWeightManager() { super();
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1aC2wcxRmeO79f8StOQh5O7DhBeXAXEiggpymOY2OH80Nx" +
       "cFuH4Kz35nwb7+0uu3P2OTTlobZJS0E8wlMQVVUQlCYEIVAfFBoUtUChSEAo" +
       "0BboS4KWRiXQUlRa6P/P7t4+7m6NpbqWdjye+f+Z///+f/75Z8ZHT5MSQyfN" +
       "VGERNq1RI9KlsEFBN2i8UxYMYye0jYp3FAkfXPFO/0VhUjpC5iUFo08UDNot" +
       "UTlujJBlkmIwQRGp0U9pHDkGdWpQfVJgkqqMkCbJ6E1psiRKrE+NUyQYFvQY" +
       "qRcY06WxNKO91gCMLIuBJFEuSbTD390eI9Wiqk075Itc5J2uHqRMOXMZjNTF" +
       "9gqTQjTNJDkakwzWntHJOk2Vp8dllUVohkX2yudbEGyPnZ8DQevDtR9+fFOy" +
       "jkPQKCiKyrh6xg5qqPIkjcdIrdPaJdOUcSX5KimKkSoXMSNtMXvSKEwahUlt" +
       "bR0qkL6GKulUp8rVYfZIpZqIAjHS4h1EE3QhZQ0zyGWGEcqZpTtnBm1XZLU1" +
       "tcxR8bZ10UN3XFH3SBGpHSG1kjKE4oggBINJRgBQmhqjutERj9P4CKlXwNhD" +
       "VJcEWdpnWbrBkMYVgaXB/DYs2JjWqM7ndLACO4Juelpkqp5VL8EdyvqrJCEL" +
       "46DrAkdXU8NubAcFKyUQTE8I4HcWS/GEpMQZWe7nyOrYdikQAGtZirKkmp2q" +
       "WBGggTSYLiILynh0CFxPGQfSEhUcUGdkccFBEWtNECeEcTqKHumjGzS7gKqC" +
       "A4EsjDT5yfhIYKXFPiu57HO6f/ONVyk9SpiEQOY4FWWUvwqYmn1MO2iC6hTW" +
       "gclYvTZ2u7DgiYNhQoC4yUds0vzgK2cuXt984hmTZkkemoGxvVRko+KRsXkv" +
       "Lu1cc1ERilGuqYaExvdozlfZoNXTntEgwizIjoidEbvzxI6ff/maB+m7YVLZ" +
       "S0pFVU6nwI/qRTWlSTLVL6EK1QVG472kgirxTt7fS8qgHpMUarYOJBIGZb2k" +
       "WOZNpSr/GyBKwBAIUSXUJSWh2nVNYElez2iEkDL4SDV864j5w38zMhFNqika" +
       "FURBkRQ1OqirqL8RhYgzBtgmo2Pg9RNRQ03r4IJRVR+PCuAHSWp1iAbSjoNM" +
       "0UlBTlNs2BjtBqi+SKXxJOsTFPALPYJOp/1/p8ug9o1ToRAYZqk/LMiwonpU" +
       "OU71UfFQemvXmYdGnzNdDpeJhRsjF4IEEVOCCJcgAhNGTAkiXAJs2BjJkYCE" +
       "Qnzi+SiJ6Q1gywmIChCWq9cM7d6+52BrEbihNlUMhkDSVs/21OmEDjvej4rH" +
       "G2r2tbx57skwKY6RBkFkaUHG3aZDH4c4Jk5YS716DDYuZ/9Y4do/cOPTVZHG" +
       "IXwV2kesUcrVSapjOyPzXSPYuxuu42jhvSWv/OTEnVPXDl+9IUzC3i0DpyyB" +
       "aIfsgxjoswG9zR8q8o1be+CdD4/fvl91goZnD7K3zhxO1KHV7xp+eEbFtSuE" +
       "x0af2N/GYa+AoM4EsD/Ey2b/HJ6Y1G7Hd9SlHBROqHpKkLHLxriSJXV1ymnh" +
       "PluPRZPpvuhCPgH51vD5Ie3e11748yaOpL2L1Lq2/yHK2l2RCwdr4DGq3vHI" +
       "nTqlQPfGnYO33nb6wC7ujkCxMt+EbVh2QsQC6wCCX3/mytffevPIqbDjwgy2" +
       "7vQYZEAZrsv8T+EnBN8n+GG0wQYz6jR0WqFvRTb2aTjzakc2iIIyhAZ0jrbL" +
       "FHBDKSEJYzLF9fPv2lXnPvbXG+tMc8vQYnvL+pkHcNrP2kquee6KfzbzYUIi" +
       "7sIOfg6ZGdobnZE7dF2YRjky17607K6nhXthk4DAbEj7KI+1hONBuAHP51hs" +
       "4OV5vr4LsFhluH3cu4xc2dKoeNOp92qG33vyDJfWm2657d4naO2mF5lWgMku" +
       "Ilbhif3Yu0DDcmEGZFjoD1Q9gpGEwc470X95nXziY5h2BKYVISwbAzrEzYzH" +
       "lSzqkrJfP3VywZ4Xi0i4m1TKqhDvFviCIxXg6dRIQsjNaF+42JRjqhyKOo4H" +
       "yUEopwGtsDy/fbtSGuMW2ffDhY9uvv/wm9wtNXOMJdkIu9QTYXlm7yzyB1++" +
       "4JX7b759yswN1hSObD6+Rf8akMeu+8NHOXbhMS1P3uLjH4kevWdx55Z3Ob8T" +
       "XJC7LZO7c0GAdng3Ppj6R7i19GdhUjZC6kQrkx7GfQnW9Qhkj4adXkO27en3" +
       "ZoJm2tOeDZ5L/YHNNa0/rDk7JtSRGus1Ph9cgibcAt8Gywc3+H0wRHhlO2dZ" +
       "zcs1WKzn5itipELTVQZSUsh+Sw2etjOQRFIEOZOdh7vK4oB5gJfv2wZnWcTI" +
       "upm3eDNPBvc2QzKWF2JxqTnv5nz+nMmvRwir5zjy8p/SgLXpcmGC63RZodSZ" +
       "p/1Hrjt0OD5w37mmEzd409EuOG0d+9V/no/c+btn8+Q6FUzVzpHpJJVdc1bh" +
       "lJ5l08dPFY4PvjHvlj/+qG1862xyEmxrniHrwL+XgxJrC69EvyhPX/eXxTu3" +
       "JPfMIr1Y7oPTP+T3+o4+e8lq8ZYwP0KZiyPn6OVlavcuiUqdwllR2elZGCuz" +
       "DtCIhl0NX4flAB3+heE43WosvuT19coA1oC9Rwro4yaDRdYoGb1KEg6/sOQg" +
       "K+LnW2+einYeSo8ZkFNKKcgzJq2z2MbBPeLBtsE/mW54Vh4Gk67pgegNw6/u" +
       "fZ4brBw9JAuTyzvAk1zZUR0WEVwKATHaJ090f8NbE/e8c8yUxx+QfcT04KFv" +
       "fRq58ZC5RMzT9sqcA6+bxzxx+6RrCZqFc3S/fXz/4w/sPxC2cL+ckbIxVZWp" +
       "oGTtEspuXvO9KJqybvtm7U9uaijqhsXXS8rTinRlmvbGvQ5YZqTHXLA6B3TH" +
       "HS2pMUFjJLTW3jl5kKMBQe4zbNrYsFXj7Xu8Tn82fD2W5/bM3ukLsQY49tcC" +
       "+r6BxdVw1JGMDkVKCQxzRdvrsU91ILlmriBZBd+ApdfA7CEpxBqg9s0Bfbdi" +
       "8W1IFCS8DuO+WwCQG+YAkFrsa4Zv2NJqePaAFGINUPpwQN93sLgL8u1xymwk" +
       "sme3lLXy8ZfmqjNGiiTretO1ovHPadcyu3sOIGzAvhb4dls47J49hIVYA2B6" +
       "OKDvESy+74WwH2KVnY3V8QQfc1Ir63IQOjoHCNVj3wr44paa8dkjVIg1AIWf" +
       "BvQ9hcWPTYS20YSQls2E3Ubo7JnzVYeeA/f4XAG3FL4JS/uJ2QNXiNUHTpgL" +
       "Erb1X4L6T20SudqGIEZiNCOJgnyZIjGbZlUQRp1DQ128xkV8wTebveFaIy2y" +
       "Z4urqci2gb6ujEg1zCk58yksnmWkStSpwCjHHZtOOuD/Yq7Ax3V9vYXg9bMH" +
       "vxBrAPgBEa4ETvZ6UIwL4k3IqlCAlyvy+/wmwj9f4QSnsfgtBA/TDN04Xj5b" +
       "vDFXtlgG3zEL0GOzt0UhVp/epVyQUts1IzM4+RCbljGJwWc6yB2R61EsXsTi" +
       "u/YobUGj4BDUOvee5Ip8FBC5PsHiA4bPXiktnX85/H0OTMDP0W3wvWbh+FqA" +
       "CXjpP5D3+y4QagIGK+yMb+M8ocrCCIWqsSh2HDX7auBFKVQyByg1Yd9K+N63" +
       "FHt/9o5aiDVA5aC+s7BoYGQebHW9cfBRKSFR8yZgyAGj8X8BRoaR+pxHGrxR" +
       "XJTzYGw+cooPHa4tX3j4slf5vUb2IbIazqmJtCy777xc9VJNpwmJI1lt3oBp" +
       "XNMWRlZ/tqckRorxF+oRWmEytzHSMiMzxNFJe9u3Gc+2dssCjIyUmhU3z1o4" +
       "AuXjgSwWSjflOeDHfkqQgv92021gpNKhg0nNiptkE4wOJFg9T7Mj06aZAXOc" +
       "xrJoxty4l7i9gcedppmcyHXFttJzr8D/78A+eKfN/zwYFY8f3t5/1ZnP3We+" +
       "v4iysG8fjlIFx23zlYcPijdMLQVHs8cq7Vnz8byHK1bZ9wCe9x+3bNyVIdjw" +
       "t5LFvgcJoy37LvH6kc1P/vJg6UthEtpFQgIjjbty73ozWlony3bFcq8VhgWd" +
       "v5S0r7l7esv6xN9+w2/TSc4dup9+VDx1/+6Xb1l0pDlMqnpJiaTEaYZfQm+b" +
       "VnZQcVIfITWS0ZUBEdFuguy5s5iHa0zAnJ/jYsFZk23FhzlGWnNvYnKfMytl" +
       "dYrqW9W0EsdhamKkymkxLeO7pEtrmo/BabFMiSUvIhm0BrjsaKxP0+xXreJW" +
       "jcea6fyZDPr2JbyKtZ7/AkONKP6TJAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "8r5wludpsLe9GQ/YAIH8LOWzwAkvUgIt");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("yv9n6a4n0IOndKDTfeEsyYeAdEBSFH8gPI4M1bc22KlzHI3odr88PXHWr8vp" +
       "8OhbOcuZT9Hnzn1Alm+6jz/20v2r7pfUr7zGjn70e/Uv7l/aqZ682xVS7h9A" +
       "V/aP/kqhxQfjs7eUdizrMv3Cmw//2gPPH3/cPrxX+HSOndHt/Td/ykaswqR8" +
       "fLb7p+/5jR/6lde+WT4W+X+b+5DnbC8AAA==");
}
