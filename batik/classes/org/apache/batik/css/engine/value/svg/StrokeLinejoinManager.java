package org.apache.batik.css.engine.value.svg;
public class StrokeLinejoinManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_MITER_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          MITER_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_ROUND_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          ROUND_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_BEVEL_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          BEVEL_VALUE); }
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_IDENT; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_STROKE_LINEJOIN_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 MITER_VALUE;
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public StrokeLinejoinManager() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "lJSchJEgqrxQfzHiOSzvt0/h7H2XoeZct5eB5mxNAPmSusw/fAlb3lta+WPg" +
       "+dAxtnzoMrZcgarMxyuWZ6v0Vpl8qBqT+1LooSgOUyClBaK8a0kVnqZAEifQ" +
       "vKqzF0FxtegkFfOTKVR74/XpEOoBXzpAW5miZYIfHKJ9V+e5XXWZXwEY80Dj" +
       "qHOElO/sXYQvs3+xTPplQp2I+27XM26d4M4MRNfAbW65XudE/puVx5cDdCzn" +
       "JSFf/HMLCTz60bPG2BBEt5/9w89/628//13gdgz0QGUM4G3neuSyMuD/ma98" +
       "4f0/8soffLYCVYCos7/+w6c+XrY6fXOqPlWqKlWxC6sl6bjCPsustL3nbBNi" +
       "xwfLxfY4moVffvy761/63lcPkerlqXWJ2PrMK3/zz44+98rVc98Hz78uRD/P" +
       "c/hGqIR+x7GFY+jZe/VScVB/9PWX/+nff/nTB6kevxjt9sHH3Ff/zf/51tEX" +
       "/+C37xBE3e+Fb2Fg0xv3D5sJjZ/82LpqtfBpPgm26ILrGHNc4Pu4ReS7IYVj" +
       "6ESaD3hHJg3DXQ29PJdIhTW2Mo+lTY4rkqIQZKujDGhQTkTkiHJoR5lnU4HF" +
       "cyLU8oU1sTkvmobIbDWRTGKxWLUUSZpMI4rONypBbzdYoAJPcmF+I8bqxvKt" +
       "zrYNdyy4aNc6nUyYDxi3N+WQZDIdZlSPd8duR4q3Yagzax8ZcUadQzjDFWbM" +
       "AO7o9d020ndtsSs7OjLVOTl0VJ0uxiA+1RmZWtf52dRTN62ApdfGXFwUvkzh" +
       "mbaPDJMO/bwezdW+58/NjbRY9P32ekLDytRAOF7tuXFCLm11sBgz9HokaXRs" +
       "d/l0PKNdbbkRpaIzE7GOP5gORymbKfupZ+q9xAy5/thrzUK5p7Y0bGE76Iwb" +
       "WNGMI1orZdJRY2dfyDoOxr0QiHEj0NwaZmzIrRytbNqbzVxxWy9odFxnRMIL" +
       "9xMlttC5QkXGbtkaOD67nvetxbqlLZK2M53ZCBkm7UYcTWmh3ox8XdLVSFyB" +
       "cfKsRCITmRkK3TXvzsJG1Palrj0e1yd7BV0SPS7mC9+LNdUPmgnPhk3Dasxi" +
       "VCf8yFU5TbHqA0MSRTsZO4aMh9LeWiy01pjx1ns5i2bGcIGOG9Jm30tTubAW" +
       "xgYbWaJudFo2xRfj9rgrafEGxd02qa/VQVPN5Km08/CGDg+ilayRnYg3A6XO" +
       "UfserBF2Ku7JgbQeZSyn5luZ1aKRrEwHfEA3U3NHEwmlrQcWLBvrjJtKHrLG" +
       "FyxtRzOrLZh4r1GnEHeo2QRut7gIOB6l1NJpe2NhMW5MBlovTkIN36zDBe6t" +
       "m5q4lxw1wCVsTM63bLOFse3WcrudmdZmMaFJX+XGU69XM4zelBr0tD3Fjhcs" +
       "LrBjTZvow54p0GytO+rjQ8q1OcepWdScxWq1iA+QTa5zGE4jg5zVfWPSiUY8" +
       "Qyowr1FpU8v90VTz4igseKyxzkzgeYI50urSkJTHHc6hxxMV7iG5h3XVpZmb" +
       "LjXeuCmdaWLky7K9oToSEm+SMT/mI3fUMyI9oanZWNY1piu2JNzq5ooyUzpN" +
       "dbovR7uZTyaU1WKCds+Z0TtC3YSDtOVx2rTVKWJvadHYJufIUYavuCWO9GuJ" +
       "u3W9SYjWNX+tRBNqptY1xlyFetuvD2ge93f6rIvgGiBrRVpu4/TEVVwOCQkC" +
       "RcfDiBhHPEL5Gt2bjf3dpre2jdG8Pm5NsGyvxcFMpMBQT3IGrS3r3dwptAVP" +
       "2CN7nvoEzffwbbqJtcXaN/vu0NgkWgx35TEWU1til2Cu0myLsxW9Wohrqd8n" +
       "+iLt00x/QpGTPkmDkpVE2ut61O7vPGeH01GNxLti0EgUM60VeprVWi6Lh0Wz" +
       "Sbh7Mho3agI39/MVHnQFk2by7aDTyotlFrALmfYnq02Y97jpTpcKJHMom9Tr" +
       "DTSrMXZfLfrIOikaDNHj7XC6Tsj5IFH6o1xtB1MicghYzcfdpLCjXgCgZOhI" +
       "mgYCKBlZG8MOh2Go2HL6sL7uefmOXYiwmhU9p7VnOlJB+BSzQc2sRslI10I3" +
       "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" +
       "7dLhyNoO9zBOSZrTt/p4qrE1ZZgIWc8jSaom6NLSmDDpNBk69XA7j0YCQH97" +
       "Z1psFnO5vorVOdlK9CHmi3CnmO1aA1cSiP2QW/u1LJ52p0tl3Vx5nWENyTYT" +
       "2W5vFRTetqRuVzPRQBJjM5twwUBcej46i/1elhfkuu0X3LxmbqjZXgMjFQd1" +
       "RqnVEGmr4+x4TW/7IIhAdrgyb6ijTguN0bZAz5cdZQuTjdBhLbFPK/JO1btZ" +
       "k0+CcOA2I3WxjNajqEjzLqa1u+xgRU1TaYnWBXTcFre9TKWHDcEU9IWgdJfB" +
       "cIOMpsXAVMl82hsVMetOFbAk6r4s2UQ/aDaUQhATJ0xrYXOTEUwN58PWqrei" +
       "6onR7AiYxVDsfsnV1BkGb2fNVKO5sc/PPG8g83h9iliCMcyW67a7RdS5iO34" +
       "XsPCm4WipaI46OLqMHUCPc5QZsQr2obVQKyWDVkcc4XcSdAZvBvpy2YP6xBN" +
       "8NH70Y+Wn8PLN7cj8Vi1+XJ6OOh6nbJCfBNf4oeqZ8vkhdONrup37R6b6Oc2" +
       "GqFyd+H9dzvzq3YWvvSpV141+S/Xrx5v0Gop9FAaRn/Js7aWd66p66ClD999" +
       "F2VcHXmebRx+41P/9Sn5Y6tPvImjkQ9ckvNyk/9g/JXfHnzQ+Nmr0H2n24iv" +
       "O4y9yHT74ubhw7GVZnEgX9hCfP+pZZ8oLfZB8LSOLdu68/HEHb3gSuUFh7G/" +
       "x/73T96j7qfKZJdCTzgJHays2EktU4jD6ni7Yvixcw7ziRS6roehZ2nBmTPl" +
       "b7Stc77LqiC9qH25afqRY+0/8vZr/9l71P2tMvmZFHqnk+CB42tpeXBxon5Z" +
       "98kzPT/9VvV8ATzksZ7k26/nL9yj7hfL5GdT6HGnvOtQbfPdRcufewta3igL" +
       "nwYPc6wl8/Zr+XfvUfflMnk1hW7YVnqi3um54CU/vs85voRSaf133oLWj5eF" +
       "z4Jncqz15O3X+tfuUffrZfLVi1pzx/gjnqn4tbegYrUEPAMe9VhF9e1X8bfu" +
       "Ufdamfzjg4rgG1TLvMNxz8mRwofe+EjkjL6yxj95C9Z4six8HjzasTW0t98a" +
       "37pH3e+WyTdS6FFgDdq0grQ8dDhcORqeafjNN6NhnkJP3vFCQ3ki+57X3bI6" +
       "3AwyvvbqjQff/er031Zn+qe3dx5ioQeXmeedP0A7l78WxdbSqRR56HCcFlV/" +
       "/zqFXvhz3bwAcxeklQrfPrD+fgo9+4as6fF50HnG/5BC770HYwpdO2TO83wH" +
       "rBZ34gFigfQ85X9KoZuXKYEU1f95uj9MoYfP6ECnh8x5kj8CrQOSMvu96MTr" +
       "0Tc215l7HI9nfuVipHbqLo+/kbucC+6evxCSVVf1TsKn7HBZ7yXj668y3E/8" +
       "oP3lw70Jw9OKomzlQRa6frjCcRqCPXvX1k7aujZ88YeP/upDL5yEi48eBD6b" +
       "Zedk+8CdLyb0/SitrhIU/+jdv/6Rv/fqd6qjv/8H6BjVskMpAAA=");
}
