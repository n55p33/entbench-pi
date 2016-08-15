package org.apache.batik.css.engine.value.svg;
public class ColorProfileManager extends org.apache.batik.css.engine.value.AbstractValueManager {
    public boolean isInheritedProperty() { return true; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_COLOR_PROFILE_PROPERTY;
    }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_URI_OR_IDENT;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 AUTO_VALUE;
    }
    public org.apache.batik.css.engine.value.Value createValue(org.w3c.css.sac.LexicalUnit lu,
                                                               org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException {
        switch (lu.
                  getLexicalUnitType(
                    )) {
            case org.w3c.css.sac.LexicalUnit.
                   SAC_INHERIT:
                return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                         INHERIT_VALUE;
            case org.w3c.css.sac.LexicalUnit.
                   SAC_IDENT:
                java.lang.String s =
                  lu.
                  getStringValue(
                    ).
                  toLowerCase(
                    );
                if (s.
                      equals(
                        org.apache.batik.util.CSSConstants.
                          CSS_AUTO_VALUE)) {
                    return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                             AUTO_VALUE;
                }
                if (s.
                      equals(
                        org.apache.batik.util.CSSConstants.
                          CSS_SRGB_VALUE)) {
                    return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                             SRGB_VALUE;
                }
                return new org.apache.batik.css.engine.value.StringValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_IDENT,
                  s);
            case org.w3c.css.sac.LexicalUnit.
                   SAC_URI:
                return new org.apache.batik.css.engine.value.URIValue(
                  lu.
                    getStringValue(
                      ),
                  resolveURI(
                    engine.
                      getCSSBaseURI(
                        ),
                    lu.
                      getStringValue(
                        )));
        }
        throw createInvalidLexicalUnitDOMException(
                lu.
                  getLexicalUnitType(
                    ));
    }
    public org.apache.batik.css.engine.value.Value createStringValue(short type,
                                                                     java.lang.String value,
                                                                     org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException {
        switch (type) {
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_IDENT:
                java.lang.String s =
                  value.
                  toLowerCase(
                    );
                if (s.
                      equals(
                        org.apache.batik.util.CSSConstants.
                          CSS_AUTO_VALUE)) {
                    return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                             AUTO_VALUE;
                }
                if (s.
                      equals(
                        org.apache.batik.util.CSSConstants.
                          CSS_SRGB_VALUE)) {
                    return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                             SRGB_VALUE;
                }
                return new org.apache.batik.css.engine.value.StringValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_IDENT,
                  s);
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_URI:
                return new org.apache.batik.css.engine.value.URIValue(
                  value,
                  resolveURI(
                    engine.
                      getCSSBaseURI(
                        ),
                    value));
        }
        throw createInvalidStringTypeDOMException(
                type);
    }
    public ColorProfileManager() { super(
                                     ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "JYNBVSlwx66LLvgvzRX4dfAYNoLG7MFPx+qDI1sokj3T/s2FUstIs4OxjWNz" +
       "Sby+PT3g+PPnguA32FzhpMIC1cq200H7y/8FtAk4505zoYbV36Ip9/vWnbR0" +
       "/lRZwcJTO94TJU/y3rgEjrDRuKJ4jl7eY1iebrCoLCwssSpmXXxdm8Fdk/d+" +
       "ECWhFXb80WL9kJPaGVlhcUaT8cBm/MjeRmkYOcmzXrw8f4bMPx0PqAWtl/Jj" +
       "OC35KUEL8e2l+4STIpcOJrVevCSfgnQgwddburMnH5gZrmYoMQyoRYXb2Eua" +
       "yJpanws/qp7Jjzzl98qUmkP8T+QcyuPWP0UD0oVTW7v2337geeuyTFLoxARK" +
       "KYajuHUll6w+a9NKc2TltTfcmXexcJVTI6Rc1nl1E94M+0hcbC323R6Z9clL" +
       "pPdPb7z0q8m8d6G62UmyYOtW7fT8S2P9JdGU0ONQ9u8MTy05oFIX11pNDc+M" +
       "b2qMfvoHcfVBrBJlaXr6AenqmV2/PrrodE2AFHeQXCh/WKKfFMnmlnF1G5NG" +
       "jX5SKputCVARpMhUSaln5uEmoxgIBC42nKXJXrxF5aRuapU29e65SNHGmLFZ" +
       "i6sRFAMVUbHb49xCpBTwcV33Mbg9nsKUWSERVwO8diDcqevOFWROgy7CTTRt" +
       "hMzKFq/4lvMfEWb3E0MeAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL1aC+wsV1mf+7/tvW0pvbctlFpKn7dg2fqf3Zl9UkRmZ3d2" +
       "Znd2Zndn9jEjcpn3zO68Z3ZndqEKGKVKBKItQoQGEwhKCiUGlMRAqgaBQFQM" +
       "UTGREjUKAoFqRCMqnpn9v3vvbZo2bv5z/jPnfN853+873/nOdx6Pfw+6Ogqh" +
       "gu/Za8P24l0tjXfndmU3XvtatNulKwMpjDQVt6Uo4kHeReWeT5774Y/eY57f" +
       "gc6I0M2S63qxFFueG420yLNXmkpD5w5z27bmRDF0np5LKwlexpYN01YUP0hD" +
       "LzrCGkMX6H0RYCACDESAcxFg7JAKML1Yc5cOnnFIbhwF0M9Dp2jojK9k4sXQ" +
       "3ccr8aVQcvaqGeQIQA3XZN8TACpnTkPorgPsW8zPAPxoAX7kN994/vdOQ+dE" +
       "6Jzlcpk4ChAiBo2I0PWO5shaGGGqqqkidKOraSqnhZZkW5tcbhG6KbIMV4qX" +
       "oXagpCxz6Wth3uah5q5XMmzhUom98ACebmm2uv91tW5LBsB6yyHWLUIiywcA" +
       "r7OAYKEuKdo+y1ULy1Vj6M6THAcYL/QAAWA962ix6R00dZUrgQzopm3f2ZJr" +
       "wFwcWq4BSK/2lqCVGLrtspVmuvYlZSEZ2sUYuvUk3WBbBKiuzRWRscTQS0+S" +
       "5TWBXrrtRC8d6Z/vMa9915td0t3JZVY1xc7kvwYw3XGCaaTpWqi5irZlvP7V" +
       "9HulWz778A4EAeKXniDe0vzBW55+/QN3PPnFLc3LL0HDynNNiS8qH5Zv+Ort" +
       "+P2N05kY1/heZGWdfwx5bv6DvZIHUx+MvFsOaswKd/cLnxz9qfDWj2nf2YGu" +
       "o6AzimcvHWBHNyqe41u2FnY0VwulWFMp6FrNVfG8nILOgnfacrVtLqvrkRZT" +
       "0FV2nnXGy7+BinRQRaais+DdcnVv/92XYjN/T30Igs6CB7oePK+Ctr/8fwzZ" +
       "sOk5Giwpkmu5HjwIvQx/BGtuLAPdmrAMrH4BR94yBCYIe6EBS8AOTG2vQIky" +
       "WgPIBK8ke6nB0cqAAQIvBFVlovUlFxhGuJtZnf//3F6a4T+fnDoFuub2k47B" +
       "BmOK9GxVCy8qjyyb7ac/cfHLOwcDZU9zMdQAIuxuRdjNRdgFIuxuRdjNRdgF" +
       "IuxeQgTo1Km85ZdkomwNAnTnAjgG4DKvv5/7ue6bHr7nNLBEP7kK9EVGCl/e" +
       "c+OHroTKHaYC7Bl68n3J2ya/UNyBdo674Ex8kHVdxj7IHOeBg7xwcuhdqt5z" +
       "7/jWD59470Pe4SA85tP3fMMzObOxfc9JRYeeoqnAWx5W/+q7pE9f/OxDF3ag" +
       "q4DDAE4yloA2gf+542Qbx8b4g/v+MsNyNQCse6Ej2VnRvpO7LjZDLznMyS3g" +
       "hvz9RqDj10F7ybFRkJXe7GfpS7YWk3XaCRS5P/5pzv/g3/zZt9Fc3fuu+9yR" +
       "yZDT4gePuIussnO5Y7jx0Ab4UNMA3d+9b/Abj37vHT+bGwCguPdSDV7IUhy4" +
       "CdCFQM2/9MXg609948Nf2zk0mhjMl0vZtpR0C/LH4HcKPP+bPRm4LGM71G/C" +
       "9/zNXQcOx89afuWhbMCKbTAcMwu6MHYdT7V0S5JtLbPY/z53X+nT333X+a1N" +
       "2CBn36QeePYKDvN/ogm99ctv/I878mpOKdnUd6i/Q7KtP735sGYsDKV1Jkf6" +
       "tr98xfu/IH0QeGbgDSNro+UODsr1AeUdWMx1UchT+EQZkiV3RkcHwvGxdiRE" +
       "uai852s/ePHkB597Opf2eIxztN/7kv/g1tSy5K4UVP+yk6OelCIT0JWfZN5w" +
       "3n7yR6BGEdSoAC8XsSHwQukxK9mjvvrs3/7Rn9zypq+ehnYI6Drbk1RCygcc" +
       "dC2wdC0ygQNL/Z95/daak2tAcj6HCj0D/NZAbs2/TgMB77+8ryGyEOVwuN76" +
       "X6wtv/3v//MZSsi9zCVm5hP8Ivz4B27DX/ednP9wuGfcd6TP9MwgnDvkRT7m" +
       "/PvOPWc+vwOdFaHzyl6sOMn8LhhEIoiPov0AEsSTx8qPxzrbif3BA3d2+0lX" +
       "c6TZk47mcEYA7xl19n7dYYffn54CA/FqZLe2W8y+X58z3p2nF7LkVVutZ68/" +
       "CUZslMecgEO3XMnO67k/BhZjKxf2x+gExKBAxRfmdi2v5qUg6s6tIwOzuw3c" +
       "tr4qS9GtFPl79bLW8OC+rKD3bzisjPZADPjOf3zPV95971Ogi7rQ1fm0Bnrm" +
       "SIvMMguLf/nxR1/xoke++c7cAQHvM3nrfd/Pg4zelRBnSStL2vtQb8ugcvkc" +
       "T0tR3M/9hKbmaK9omYPQcoBrXe3FfPBDNz21+MC3Pr6N506a4Qli7eFHfvXH" +
       "u+96ZOdIFH3vMwLZozzbSDoX+sV7Gg6hu6/USs5B/PMTD/3h7zz0jq1UNx2P" +
       "CdtgyfPxv/qfr+y+75tfukS4cZXtPY+OjW/4EFmOKGz/R5dEfZqM03Ssu7UC" +
       "XG8qncTTm6mJiyypmSbNt+2+ILAboaGnXKskBlhHgxlEWKGqr4OYM46GfmSM" +
       "eGsyNNvEMGDbq7JlEENizIyRkKGM4thkJYbocsh8FFMiAZZTQwYPTK5gqHER" +
       "Vh0VgdFSWN3MmHFD0nREjCu1eqOyQsMElQs1hRe7YSfgOgG/oVJ04jTteIIu" +
       "+syiOJGITiAhVWI1JL2qA1cajTKybA07XKkIO60JuxlXKUeqsGJ7TtbWfFdk" +
       "eHvSnYpIfyQ252a15SiJ4E820xJZ4WgxUvsTZNQVbVQyO50miY7xbr+3Dhdm" +
       "qy5UqjWMUGgqanWDtolLprhqJOOKNea6XqHmU6u6j6NaWxr2lzIrzrocGVfo" +
       "EbLwNs7YJkDTqD9M1i2k6nvJoDfyBpExHNTs2RRJm1FLKujYglRTmR7UzESk" +
       "TWU4IYhJSTaSTWPT4dtFURTbSW/G1KbpeNqHtZFcoaM+7iJtkuFIVHBaSmdB" +
       "ifNxpEo2tizRzigYxNM5TrIVah337Qll8Yg9NNn5xNs0ZZ5Chx18OFNiu5gY" +
       "tXG4iEVpsiindd1oeFNmUFvXYIEX/OpatcFUTlcXltGk1G4h610zXoA/xZKb" +
       "1KBqDwWZqDkcwY/EajKphZxNqeP1kk1grBwhTXfmcKSj0h1cHfLynJ63GY7x" +
       "Z/awbA+KIVMNh5TcLBnTZShO23LDY5sjnvLExdAvdFFmMe9bQUqw9iqqLOby" +
       "VE/HlNEaw+nKSmw/CUbV2XDIeTFR6nisyQdNVeXNMlacJH2SaZmiSwieEJR4" +
       "SRiy0ZAscs2GOt+M2xNqjOMd3vQZf9C1+GbPQpFQ7Lr6tILI/Lo+Q0ozbD2k" +
       "VaqccGOyYZU7fhppxfl4KiZTTJ9SiS3VKbdKdWddg21jZKc0b1iWprkjJKmX" +
       "SnZaSKpdsW+UmEahqXVX7WZV540VqU3j+Shat4US7vKMTZLpeJ3MltUNSTp2" +
       "r9psmoQ1tMsOsGR5Xa+NdF1jE7LWqTfH8ahZt0aMpejYfO0taEmm8XlfEy1v" +
       "0+too5ZNU6W2RXfYugEsSrPtidOYiaS3luckNyLbk1LFWRlMuz1pNtvdcZMt" +
       "rDvxVFEr6FrQO1oRW5gFHR+23fmyG4ukTrKWSUmlDhaPLClYB96k2sLQmCn2" +
       "h8pQaCIFckiR8wbXn4/LhlQW2sbGXFBjuIMLyJDlLHnU8gjGs3E/JeZd0lw3" +
       "qZ7oNUFGiQ8CXEjNZqMVNuBNqmNLZNWJVj0jmIhVo97Hl2tfXSDdfofBWFPW" +
       "UTKswX1ctuOBOQo7ozIybAVNvDjBjB4h9Ixh3OQozhzjFNVLpvaYImxRWMqV" +
       "gArtNo0rVIoJVAuMoAG/RELfjayyPCDa+rrcKQ2ZXtXGNpPyQhh0C8MB11QC" +
       "bq0GYbXRoMfNdRJwHDdPWWKclDeKMDRbXT9lanFXYIdL4AaiqMcP5y20I4Zt" +
       "ymw1i8GYmxaDJhN5/RqrLlYLDV8UmkmvrHN+RfUbnDbjy+UGutLiQkItFl2v" +
       "pPR9BSfnFOqx6cB0+SqMjoR5UBEFdamTspliJAPMBiw0513X7peLglBdIXC5" +
       "PHKGpWBt0Em1rgRNLSHKlCKWeAXDKIefFdgJjY/9Pl+OO1NsjpUDc5EGS3xo" +
       "oO0RuZGKfVkl2U6RYOLpFK5SdGE0HCMaSa90f7NCV7UycIMcp41s0mYxGukz" +
       "qIMTSRASnU6QrGZUbSjOh6Qei/0GOm/U6zHBlqkSHrmdGq45qUx15s2qgeN8" +
       "bZ3W4OIg9AuFjttUnfYAmYOlOcUZptx1YXa2XpcHC3RgmknU7/cG3XGsrkby" +
       "YpjCbFStI/GYafhDPBl2VA+tkrhT9kbIuBq0WsoArkfT2gxJx3XWLq3ocIwP" +
       "ymuE6SdxUijAEt+s1BRYgSWPE2hswUfCUucQkWis/ZkSMmaRJMcUTJaX9WWh" +
       "sfEbrRXVTjsi7zqYhTZ7zWbappdExVDEhleDNUYfdeSJJM/SEosuNB1jcExd" +
       "zoIwZuGpr8Y40hjyNgrmx6qriaQziodegnCixaxdkywqsypjLHkKY3EYaQY+" +
       "IoGJIYKjWJ1XhqFdgLF4UEzCIddEtAShSAzMIJuuH9UYGEbCcI0K9WIZwWVu" +
       "RC2m8wUvBIyZ+M12w63MW22U4gu2oEQDReh5+GKmdTEfb6N+QkyEwQqtxpFY" +
       "pG1xUbYUWq/x6abnholVKnF1gQvrrYnnoJgfE+spum4wlXabQzfrvodPenHf" +
       "WDcoVayPRrUB3xSqioUqhVU8LKu2ZJMmIZQxGU4QtNAg+E2lLE78aFE3S/Co" +
       "RvByj+gXlCZv2lwgewSuNJiSrzqoXvQq8LSFIBov0tjK98Si0SrMjEonbC/0" +
       "xgAJVmQtCctLVE5DrV+Oy2DaJf0SvGhsVoPZzC7Hs2GRoqqlSWDpipmy4jRc" +
       "Y0C9HWPD1taBlM16AlgJ8S0fI7haBIJVSR6qXoOtT3sbjJbrPYdRFoHeozwM" +
       "WXYEBp8J2iZEyDWzWHtevzExe23DmC16Uns+IatRu1mqATt1THzhq/P2wCRr" +
       "+iAl0BDhuoPSYFZYowN8KY2MaLkMNp6kV9F4VbNtK8FW3LDbTrRa0hzUAy5U" +
       "nDW+bI6lvs3JgR60W/ao0B/Q0XykRLq+JrW0njqbDVJTCi2z3BCndS4wCJHt" +
       "jXv1ASFMKgy7ZOJ+ZICpnk4VdkVukKTXweaziOyCEMgJhCSwZBCNxJWZv9St" +
       "oGdXK4K7RiuI3+rVWryoN9cOFcC9AssuKb/lGysT6L3fCogFsmQbviTU5UW3" +
       "s2Ta9aBg9otIFUXnemoT0ZTd0CuvtqhUZGvKluq99WYw09Vat1ggp1EnbVRn" +
       "wjgtJkth2UFoRdGFJUaQRbrQW8x6Q5zuTFsTyw0pk5OxMhe4xCbxOqhj1Biy" +
       "1yyFTXOorTdNpN1dNZRWMNtMxcnc7rBgnUr2zLSWUrNFUXZwsTmub2RR3cgs" +
       "2c34QlZfz1sIOU2csoD55fWURYCxYaS9bhmYn9Taksb4cdDw3VbRqJaMtDOo" +
       "MGaNsKN5oC89h6sUpzA5Wm2kysxx3Q5PN4Kp0i3I5qZquO0uImCJEYJImRgw" +
       "RaQVIxtzg6lSIgkg1hPYMsx0hiuc5tJeOQlXSYPW8fEI3aBpt8xQdBnMCMSs" +
       "SZc1ZxNqBXkwa/lTEgWx1dDCFL3Qnc5hpOV3nU6J641MB5841tqoTCpAMcEi" +
       "EWKdR2LPQz2Nplexo5idmJ4u+T4RE1bCoaorFbtgeV32Tb4fIvRGKFZ7XYFp" +
       "Tjg7SatVwGSsNqNZWdUxgfHoTq1PDNJC0KJKkbeYozwcIcQ4iqmozKbzKbPh" +
       "5HVhwKNGYTBwjSWGIsTG9PsUXlICpFgEcTVcJ2JsUa4UKxtPkCdolfIb8Grq" +
       "yqMibI/EROnybKPMd8fwGg2N9jxsjZa9bhks5TShZGlyiHs0nkQR5zuzWao6" +
       "dUJdwGqhjU9NYibXi1O6segOpM7ENpWxxNeVpgP359rIWQis4mxmYVLXy3J/" +
       "kBYHATaNbbg7Z3G00hu36bqG2IUyx1O+wnbBknmFc7rhDo1EVeVl2HfJiiGG" +
       "juD1h2tvJMxkpL2U1l1fcpMIDvxad77Z2I16MHYWgzpfGCrr5WA6KI5bRW/C" +
       "T2srBEVrhqYt1zxBeyk26vUEab4kx7ZdTQpSg+kpCG/HvK44My1VuhOeqo6U" +
       "kmuX2o1yv1A0FRlHEXRUFRuKTfsDdSDXNsWg7tTVaqeKjJ21wMbTms7XOWTQ" +
       "6KqdcZFlho1lvc+vixWPoGalks+0lEJfRoK+vvJIRZ80w2bXlmZhFdPcwJkg" +
       "YMEaemobAUNPG85wE572ejrRdx3bBRFzhenMZxWu5y9jfIKN/L455iTbrSzb" +
       "jpcaVBMvI25v1p2FKVGRRkvJHyMNrVrhGLLj0IRoVaMRgfUnY5mUy40U95t8" +
       "okxQtC8bDTfqjadcezRJ2LpqtZRAW7HEdMQa6xrO86PY7G96RACX7VVfb09l" +
       "tF3sa2BF+tPZUvUNz2234MZ8Y+TgeAtYVlbQeQ6r5G3R3Vly38FmcP47c4XN" +
       "4CMbZlC28n/F5U6t8lX/h9/+yGMq+5HSzt5G4zSGro09/6dsbaXZR6q6BtT0" +
       "6svvcPTzQ7vDDbAvvP1fbuNfZ77pOWzx33lCzpNV/m7/8S91Xqn8+g50+mA7" +
       "7BnHiceZHjy+CXZdqMXL0OWPbYW94kCzN2caeyV4HtjT7AOX3ma/pBWcyq1g" +
       "2/dX2McNr1CW70w7MXSzFVGuqYVWrKmD0MsPaHOG0RGDmcTQWdnzbE1yD43J" +
       "fbYtl6NN5hnzA/Q3ZZl3gwfdQ4++8OjfdoWyX8ySt8TQOUOL91Eze33XOYT4" +
       "0POAePP+cHnNHsTXvPAQf+0KZe/Okodj6CVWhLmWI8XZGcM+1qxsdYjzV54v" +
       "zvvAg+3hxF54nO+/QtlvZckjMXSTlV1IyHcZL4Py0eeB8lyWeQd4yD2U5AuP" +
       "8iNXKPtolnzouMEeHOGdGKqnrb2bIjnq334eqPMp4C7wsHuo2Rce9aeuUPb7" +
       "WfLEFnVL06WlvT222N/uf9WzHzwf0ufa+OTz1cbt4JnsaWPywmhjJyfY2Qf1" +
       "8gxUgio5lkhSdmkttRTJHrtWvE9z35WA4xzXzt/y1v74RGun9k7S92q6db81" +
       "1XN2W2y/nSqan02eOfMXs+SzMfQiJdSkWMuVmWV95lCjn3u+Gr0HPOGeRsMX" +
       "RqOn907wLjE4ro5ML8wnvzw4+nzO/7VL6yj7/FJO8PUs+XMQZm31sD1bupQ2" +
       "/uK5aCMF0+8lLkVkp7q3PuOO1vZekfKJx85d87LHxn+d3ws4uPtzLQ1doy9t" +
       "++gh3JH3M36o6VaO5NrtkZyf//vms1jSwd0N4FRAmgN4asv6DzF097Oyxnvn" +
       "ZEcZ/2nPwi/DGENnti9Heb4NprFL8QCxQHqU8rsxdP4kJZAi/3+U7vsxdN0h" +
       "HWh0+3KU5F9B7YAke/03f3+4VJ9dXZgcxaGkbD3VXpemp44Hygf2ctOz2cuR" +
       "2PreYxFxftdvP3pdbm/7XVSeeKzLvPnp6ke21y8UW9psslquoaGz25sgBxHw" +
       "3Zetbb+uM+T9P7rhk9fetx+t37AV+HBIHpHtzkvfb2g7fpzfSNh85mWfeu1H" +
       "H/tGfir6f5VwyXyEKQAA");
}
