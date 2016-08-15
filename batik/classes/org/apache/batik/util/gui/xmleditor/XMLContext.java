package org.apache.batik.util.gui.xmleditor;
public class XMLContext extends javax.swing.text.StyleContext {
    public static final java.lang.String XML_DECLARATION_STYLE = "xml_declaration";
    public static final java.lang.String DOCTYPE_STYLE = "doctype";
    public static final java.lang.String COMMENT_STYLE = "comment";
    public static final java.lang.String ELEMENT_STYLE = "element";
    public static final java.lang.String CHARACTER_DATA_STYLE = "character_data";
    public static final java.lang.String ATTRIBUTE_NAME_STYLE = "attribute_name";
    public static final java.lang.String ATTRIBUTE_VALUE_STYLE = "attribute_value";
    public static final java.lang.String CDATA_STYLE = "cdata";
    protected java.util.Map syntaxForegroundMap = null;
    protected java.util.Map syntaxFontMap = null;
    public XMLContext() { super();
                          java.lang.String syntaxName;
                          java.awt.Font font;
                          java.awt.Color fontForeground;
                          syntaxFontMap = new java.util.HashMap();
                          syntaxForegroundMap = new java.util.HashMap();
                          java.awt.Font defaultFont = new java.awt.Font("Monospaced",
                                                                        java.awt.Font.
                                                                          PLAIN,
                                                                        12);
                          syntaxName = org.apache.batik.util.gui.xmleditor.XMLContext.
                                         DEFAULT_STYLE;
                          font = defaultFont;
                          fontForeground = java.awt.Color.
                                             black;
                          syntaxFontMap.put(syntaxName,
                                            font);
                          syntaxForegroundMap.put(
                                                syntaxName,
                                                fontForeground);
                          syntaxName = org.apache.batik.util.gui.xmleditor.XMLContext.
                                         XML_DECLARATION_STYLE;
                          font = defaultFont.
                                   deriveFont(
                                     java.awt.Font.
                                       BOLD);
                          fontForeground =
                            new java.awt.Color(
                              0,
                              0,
                              124);
                          syntaxFontMap.put(
                                          syntaxName,
                                          font);
                          syntaxForegroundMap.
                            put(
                              syntaxName,
                              fontForeground);
                          syntaxName = org.apache.batik.util.gui.xmleditor.XMLContext.
                                         DOCTYPE_STYLE;
                          font = defaultFont.
                                   deriveFont(
                                     java.awt.Font.
                                       BOLD);
                          fontForeground =
                            new java.awt.Color(
                              0,
                              0,
                              124);
                          syntaxFontMap.put(
                                          syntaxName,
                                          font);
                          syntaxForegroundMap.
                            put(
                              syntaxName,
                              fontForeground);
                          syntaxName = org.apache.batik.util.gui.xmleditor.XMLContext.
                                         COMMENT_STYLE;
                          font = defaultFont;
                          fontForeground =
                            new java.awt.Color(
                              128,
                              128,
                              128);
                          syntaxFontMap.put(
                                          syntaxName,
                                          font);
                          syntaxForegroundMap.
                            put(
                              syntaxName,
                              fontForeground);
                          syntaxName = org.apache.batik.util.gui.xmleditor.XMLContext.
                                         ELEMENT_STYLE;
                          font = defaultFont;
                          fontForeground =
                            new java.awt.Color(
                              0,
                              0,
                              255);
                          syntaxFontMap.put(
                                          syntaxName,
                                          font);
                          syntaxForegroundMap.
                            put(
                              syntaxName,
                              fontForeground);
                          syntaxName = org.apache.batik.util.gui.xmleditor.XMLContext.
                                         CHARACTER_DATA_STYLE;
                          font = defaultFont;
                          fontForeground =
                            java.awt.Color.
                              black;
                          syntaxFontMap.put(
                                          syntaxName,
                                          font);
                          syntaxForegroundMap.
                            put(
                              syntaxName,
                              fontForeground);
                          syntaxName = org.apache.batik.util.gui.xmleditor.XMLContext.
                                         ATTRIBUTE_NAME_STYLE;
                          font = defaultFont;
                          fontForeground =
                            new java.awt.Color(
                              0,
                              124,
                              0);
                          syntaxFontMap.put(
                                          syntaxName,
                                          font);
                          syntaxForegroundMap.
                            put(
                              syntaxName,
                              fontForeground);
                          syntaxName = org.apache.batik.util.gui.xmleditor.XMLContext.
                                         ATTRIBUTE_VALUE_STYLE;
                          font = defaultFont;
                          fontForeground =
                            new java.awt.Color(
                              153,
                              0,
                              107);
                          syntaxFontMap.put(
                                          syntaxName,
                                          font);
                          syntaxForegroundMap.
                            put(
                              syntaxName,
                              fontForeground);
                          syntaxName = org.apache.batik.util.gui.xmleditor.XMLContext.
                                         CDATA_STYLE;
                          font = defaultFont;
                          fontForeground =
                            new java.awt.Color(
                              124,
                              98,
                              0);
                          syntaxFontMap.put(
                                          syntaxName,
                                          font);
                          syntaxForegroundMap.
                            put(
                              syntaxName,
                              fontForeground);
    }
    public XMLContext(java.util.Map syntaxFontMap,
                      java.util.Map syntaxForegroundMap) {
        super(
          );
        setSyntaxFont(
          syntaxFontMap);
        setSyntaxForeground(
          syntaxForegroundMap);
    }
    public void setSyntaxForeground(java.util.Map syntaxForegroundMap) {
        if (syntaxForegroundMap ==
              null) {
            throw new java.lang.IllegalArgumentException(
              "syntaxForegroundMap can not be null");
        }
        this.
          syntaxForegroundMap =
          syntaxForegroundMap;
    }
    public void setSyntaxFont(java.util.Map syntaxFontMap) {
        if (syntaxFontMap ==
              null) {
            throw new java.lang.IllegalArgumentException(
              "syntaxFontMap can not be null");
        }
        this.
          syntaxFontMap =
          syntaxFontMap;
    }
    public java.awt.Color getSyntaxForeground(int ctx) {
        java.lang.String name =
          getSyntaxName(
            ctx);
        return getSyntaxForeground(
                 name);
    }
    public java.awt.Color getSyntaxForeground(java.lang.String name) {
        return (java.awt.Color)
                 syntaxForegroundMap.
                 get(
                   name);
    }
    public java.awt.Font getSyntaxFont(int ctx) {
        java.lang.String name =
          getSyntaxName(
            ctx);
        return getSyntaxFont(
                 name);
    }
    public java.awt.Font getSyntaxFont(java.lang.String name) {
        return (java.awt.Font)
                 syntaxFontMap.
                 get(
                   name);
    }
    public java.lang.String getSyntaxName(int ctx) {
        java.lang.String name =
          CHARACTER_DATA_STYLE;
        switch (ctx) {
            case org.apache.batik.util.gui.xmleditor.XMLScanner.
                   XML_DECLARATION_CONTEXT:
                name =
                  XML_DECLARATION_STYLE;
                break;
            case org.apache.batik.util.gui.xmleditor.XMLScanner.
                   DOCTYPE_CONTEXT:
                name =
                  DOCTYPE_STYLE;
                break;
            case org.apache.batik.util.gui.xmleditor.XMLScanner.
                   COMMENT_CONTEXT:
                name =
                  COMMENT_STYLE;
                break;
            case org.apache.batik.util.gui.xmleditor.XMLScanner.
                   ELEMENT_CONTEXT:
                name =
                  ELEMENT_STYLE;
                break;
            case org.apache.batik.util.gui.xmleditor.XMLScanner.
                   ATTRIBUTE_NAME_CONTEXT:
                name =
                  ATTRIBUTE_NAME_STYLE;
                break;
            case org.apache.batik.util.gui.xmleditor.XMLScanner.
                   ATTRIBUTE_VALUE_CONTEXT:
                name =
                  ATTRIBUTE_VALUE_STYLE;
                break;
            case org.apache.batik.util.gui.xmleditor.XMLScanner.
                   CDATA_CONTEXT:
                name =
                  CDATA_STYLE;
                break;
            default:
                name =
                  DEFAULT_STYLE;
                break;
        }
        return name;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "wNb+/t6OtZv622JdrZ157OzeKQJEx9lssW3OBbDSBjiG3h1bDk8boR8r8Jg2" +
       "ws2t0U15IN43RYhItsLiuyIXxJliWjcfnDYwPwaMzIrkV8mH/ns4PLw+H56w" +
       "xS2cBYfwl5/lxgFYSzRdZbAh07gHRHmeYRnMdwKih1S7qtNhXU0qcStqjHrA" +
       "PDpFMOh3V1lcV/mA+ZWdhT2WPWe/3uDu0nNWmM9sJ/PMNpUr9+N/hcRzIOrg" +
       "6ggLCeYNdX5n1vy8/fCNBw7Fu+9baQaGNe5z4DYlmXjwD/96IXT3iedyHDyW" +
       "MFU7X6ZjVHbwLHJnmRCKdvLjfDuue7Ni/9uPNQ6vncpRIdbVn+YwEP9fACCW" +
       "+0e33qk8c+Nf5/VfPrJ9Cqd+Czzi9A75o86jz61fKu4P8rsLM+DMuvNwd2px" +
       "h5mlOmVJXXHnKovd5wZr4NltKcBur9LaKuZ3buDX1ZPDWGkY11s+6mt5kpzX" +
       "sXgZ7ZSyPo+pGnlzjh4d0l4mjVnZXXh3zVuj9773oHUKkXUI6iKmew7c+mVo" +
       "7wFTPc0rpsVZtzzOPuY1k5kAYjGARrIoHxfeo/3dY7sfv3/3zels9reMzBhT" +
       "pbhtyq98FVkdr3/RvdgXwHOTtWI3TX2x/bqebrE/yLPYJ7H4Czo4e7HNqPG4" +
       "LZB3z4BA8GSHNMJzm4XqtqkLxK9rboEYuQ+3PHq4qme7uKex5520elxlqRb+" +
       "vOF4f4uRAsm6NPZIfUuK9/zMX+wBPtuPwcaGc9gYtkFmV8EzO2Gc4ZmkdX/L" +
       "l+PvZ3I59lky3Tf15fDr6q+fBhdGeR5BVWJRnFtQ2BTMiCVQcgbEwrvXwXPA" +
       "wnZg6mLx6+ovls859Hl5xDIfi9lgtsNOs01rTnlGczK1XEK1Z1JC91gw75m6" +
       "hPy6nk5xmvJIqBmLRq+EsLLeFsiSMyCQGmxbAM9BC9XBqQvEr+vpVOaiPALh" +
       "gFc6BdJlhSqGLZBVX8mBJiOl9jU13q/MzfooxvyQQ3zoUGXxnEObXuMhZOZj" +
       "izIIBoeSsuw8snO8F2o6HZK4GMvMAzx+fhu4EiKG/+IKHeLdzDtCCFxhdo8w" +
       "co5vd/D2UDrJ2yHPzEkO8QT+OGk7GKny0kKuyH+ddFGQnE3HSKH54iTphpkA" +
       "Cb72aGmDr+N3CyFjXFKGQ/ybhD42gdeNfAVSAXcqkdlIZp9utR3Zx2JX2Me/" +
       "hUrvpMke60bi2KGNXdeduug+8zJYlIVdu3CUWVFSZN5LZ4LvRb6jpccq3ND0" +
       "RcXDJUvS+3C1OWHbds51RDGtYAUaKto8z02p0Zi5MH398Jonf7en8GUIMLeS" +
       "gABbytbso+WUloSsZ2s0+7ICEhV+hdvS9P2Jy1cMffgGvwskZlwx358+Jr56" +
       "5NpX9s89XB8kszrITIhAaYqfea+bUHqpOKYPkHLJaEvBFGEUSZBdNyEV5jkz" +
       "rCuXiyXO8kwtfkrASEN2oJz9AUaprI5Tfa21c+Jdyiy7Jp2EufKXpKZ5Otg1" +
       "1lJiefVOHhbhaoByxqKdmpa+eSlr1rhT2JI7TkItFvkrvsX/A6LQFfMnKQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL17e9Dj1nUfdyXtSqvHrmRLllXrvZItQVmQIMFH5NomQBAP" +
       "AuADIEiiddZ4kXgDxIMAmaqNPW7txjOOksqp3Yn0T51pm1HiTNtMX5NUnT6S" +
       "TDKdcSZN28zU9rSdJqnraTxTp23cJr3A99xvv/2kteVyBpfgxbn3/n7nnnvu" +
       "uReXb36rclccVaAwcLcrN0iuGXlyzXbRa8k2NOJrDIuOlCg2dNxV4lgEede1" +
       "Z37x8h9991XzyvnKBbnyHsX3g0RJrMCPJ0YcuBtDZyuXj3IJ1/DipHKFtZWN" +
       "AqeJ5cKsFScvs5V7jxVNKlfZAwgwgAADCHAJAe4eSYFC9xt+6uFFCcVP4nXl" +
       "L1bOsZULoVbASypP31hJqESKt1/NqGQAari7+C0BUmXhPKo8dch9j/NNhL8A" +
       "wa/99R+58nfvqFyWK5ctXyjgaABEAhqRK/d5hqcaUdzVdUOXKw/6hqELRmQp" +
       "rrUrccuVh2Jr5StJGhmHSioy09CIyjaPNHefVnCLUi0JokN6S8tw9YNfdy1d" +
       "ZQW4PnLEdY9hv8gHBC9ZAFi0VDTjoMidjuXrSeXJkyUOOV4dAAFQ9KJnJGZw" +
       "2NSdvgIyKg/t9Z2r+CtYSCLLXwHRu4IUtJJUHrtlpYWuQ0VzlJVxPak8elJu" +
       "tPcISN1TKqIoklQePilW1gR66bETvXSsf77Ff/jzP+pT/vkSs25oboH/blDo" +
       "iROFJsbSiAxfM/YK3vci+9PKI7/82fOVChB++ITwnsw/+Avf/thLT7z1a3sy" +
       "f+YUmaFqG1pyXfuy+sBXP4C/0LmjgHF3GMRW0fk3MC/Nf7T/5OU8BCPvkcMa" +
       "i4fXDh6+NflXix/7OeOb5yuX6MoFLXBTD9jRg1rghZZrRKThG5GSGDpducfw" +
       "dbx8TlcugnvW8o293OFyGRsJXbnTLbMuBOVvoKIlqKJQ0UVwb/nL4OA+VBKz" +
       "vM/DSqVyEVyV+8D1TGXvU34nFQU2A8+AFU3xLT+AR1FQ8I9hw09UoFsTVoHV" +
       "O3AcpBEwQTiIVrAC7MA09h+USlilFpx7rqFbwNDhOcfuD6drhamF/z8ayQum" +
       "V7Jz50AnfOCkC3DB6KECVzei69prKUZ8+xeu/8b5wyGxr6Okcg20e22v3Wtl" +
       "u3udCNq9dtjutaN2K+fOlc29t2h/TxT0lgPGPfCI970gfJz5xGefuQMYWpjd" +
       "CVR9HojCt3bM+JGnoEt/qAFzrbz1xeyT0l+qnq+cv9HDFphB1qWi+Kjwi4f+" +
       "7+rJkXVavZc/8/t/9JWffiU4GmM3uOz9oX9zyWLoPnNSu1GgGTpwhkfVv/iU" +
       "8kvXf/mVq+crdwJ/AHxgogCbBe7liZNt3DCEXz5whwWXuwDhZRB5ils8OvBh" +
       "lxIzCrKjnLLbHyjvHwQ6vrew6YfBhe4befldPH1PWKTv3TOTotNOsCjd7Z8V" +
       "wtf/3b/+g3qp7gPPfPnYXCcYycvHvEFR2eVy3D94ZANiZBhA7j98cfTXvvCt" +
       "z/y50gCAxLOnNXi1SHHgBUAXAjX/5V9b//uvf+3Lv33+0GjOJWA6TFXX0vJD" +
       "kkV+5dIZJEFrzx/hAd7EBYOtsJqrU98LdGtpKaprFFb6fy4/V/ul//b5K3t2" +
       "4IKcAzN66e0rOMp/P1b5sd/4kf/5RFnNOa2YzY50diS25yLfc1RzN4qUbYEj" +
       "/+RvPf6lX1VeB84WOLjY2hmlz6qUOqiUnQaX/F8s02snntWK5Mn4uPHfOL6O" +
       "RR3XtVd/+w/vl/7wV75dor0xbDne15wSvrxnXkXyVA6qf9/JkU4psQnkGm/x" +
       "f/6K+9Z3QY0yqFEDPiweRsDd5DdYxr70XRd/95/980c+8dU7Kuf7lUtuoOh9" +
       "pRxklXuAdRuxCTxVHn70Y3udm90Nkisl1cpN5MuMx242/3zfMvLTzb9Iny6S" +
       "5242qlsVPaH+84c+7elb6HyiZOWsfl37R+NvfPX13Vfe3LMyVQHTVgW6VYB4" +
       "c4xaOJ3nznCcR6HDd8gffusP/pP08fP7dnHvIb1HCjbvP0szpejDSeX+o/4C" +
       "fVVk9spHHz2s64Wi6Etvp+VemZS3HznDdOki6ZSPkCL54T0g6Dvq/j3ZR8tf" +
       "94OueOHWWuoXQeeRh370j4eu+qn/+L9uGgPlxHJKrHWivAy/+TOP4R/5Zln+" +
       "yMMXpZ/Ib56BQYB+VBb5Oe8755+58C/PVy7KlSvafvQvKW5a+E0ZRLzxwZIA" +
       "rBBueH5j9LoXqr18OIN94OTscqzZk3PL0cwP7gvp4v7Sienk0ULLDLie2+/p" +
       "50729DngoC+D4OB6gaBw4vuzgrA3xsr0apF8sOykO4rbDwGfHpeLjgRgsnzF" +
       "3fftfwo+58D1J8VVtFRk7EVpD+H7oeJTh7FiCCKWh0E0cr1H4Gx30hXpIX9d" +
       "EBcscWDKV0pTLlR1bS/QPxr9pa2Jb2dr/I2awMD1/L4mnj9NExf1QDvQpXKW" +
       "BopkXiSLUuMyGHa9IS4uRsQegyLz4yfQqt8D2g/uo/3gqWhB+O2BCLTIsW4T" +
       "LT7kOIIXb43W/h7Qfmgf7YdORWuApfc+2vVtoiVY4my00W2ipQ/c4MH3SbQP" +
       "aCYYDRpYU17XlUQpHmxvD/R7cQoYNS4Sk+u9rti9Nfbd94D9xX3sL56KXUnA" +
       "aFHBgvj6gZP45G1i74rihMamInGd73Jn2PSnbhN74YugfezQqb7oCPumcJjF" +
       "k796e+AfPgIvddnpGeh//DbRF2Iv7aN/6TT0d2kHxvKTt4f5XvxsG/mpd470" +
       "gSL3h8AF7yOFb0JaKW++dDpEQOOeMAoSMDMZ+gG+98RbMEPm/SAyVlGQ+joI" +
       "LU5EFWW7D57VbpH2DpNj7P7GbbIrvCGy3wpyC3Z/8xbsitvXDx3LAS0/OYPQ" +
       "LZu6JaEvvy2hEsCezSDXWteqxe83b89m3me72tWDaVUyohhM3Vdtt3Wa/cjv" +
       "GBCIwh44mnbZwF+9/Ln//Opv/sSzXwehElO5qxyVIEI6NjfzabHh+Ffe/MLj" +
       "9772jc+Vaz+gaOnT333sY0Wtf+/2aD1W0BLKjRRWiROuXK4ZesHs7AhxFFke" +
       "WNVu9nfT4Fce+rrzM7//83s7ZSfDwRPCxmdf+/E/vfb5184f25989qYtwuNl" +
       "9vYoS9D372v4+FLilFbKEv3f+8or/+Rvv/KZPVQP3bjbRvip9/O/839/89oX" +
       "v/Hrp2zv3OkGN4VA77xjk4fuoxox3T34sDVlOcemtckMThv9tjNruzRDd+lF" +
       "10zxZAqTdkZvMwbraUtxTNtjyTXqScOxW3mnBVNGfSb0QmlO2WtTNC0GSjRm" +
       "ORvkfU1c12pumAydVmfNL+RRLYwomQxFEABPTC/SVSEZGQaUwDGkJ7AQ8iy3" +
       "YeNNB0VbOxjRjXYTRTu7lh02HC5D9Fp/2Dd1i5gEtbHXZpoYj6zai1VMEgu4" +
       "xs2JNFsTdsvo1OpS6GDjoUMHk8xYTbHFEBFqwpDMho7o0hxjrSxeDQJ7NhxR" +
       "YVWRsLboDcbrLiIgMjV2+L4jMLoS5pYjqJhaHQycGckP3UwQbEpfdG1+0l8I" +
       "sjkK+WzdMlBmGg0m/Zkac74/jFe2bSqOyFvtHqGsAzslOIHUZIbWbCcglaof" +
       "hn1XRBeuOZtNTc8bmNSSWQvZWA2a6W7C9zJtOPPnUKauDdoaEsm4z0i5QSw2" +
       "vDRBbU6xQ36QqjIfZonJbJzpIPCE2Qq1JrlnKcrEWphBPyTXNR5TuU1YDbaE" +
       "RKAUszDWUlfUpgOOpehRsPKaDouTTaO/M01y4C1mup4pVXzHB6I8kYlhJ+iZ" +
       "UEOpbSQxC2l0jIcuM4Z8ukE7SK8rd7uEYA57Uk9XGnVCobY9CbdyhOpM3bEs" +
       "IzMh0RdVuwfWP0I8ysN4hrnTNddEEZ/Fk8UkHrqMo7hNLGmMpa0dbVC3F9td" +
       "bkaCSR9XcX2dUavBVBCJbEk4vU2EN3YTa+ru4hWuNtpcHivRqos3+9Y0IGvE" +
       "LiIXQdcVxqTL92WCkHsbA2tafm/cC0VsPJ+SMuibrT2YmSNiOiMXudu1R/Nx" +
       "Rzb5sTvHsAWmA5ENAxFWJmy49hqaLHyU1xVYNkIkH6+scVdroOJUU9Fdgxl2" +
       "ZHS4mQt00xTjbJgvEjtvhrVeK2caK3rabSNVPq7au+ZO4ufR2louecUZihol" +
       "LpernrXeepTZiIcDF5JJT8iSjIxniuJYDQhvOXUubEaMMnO7CyO0FzvaVshq" +
       "gIibaWeTLhsY5JBjl1LGY5eUnMwfB0g4EWeWII7mNWlANjPSaq/QyZiZtMzW" +
       "BHFwvmk7DssjadOkF8Ntz2Z6qDvrDzbt5aQ3JsZNnBbSvj4N1GmHjb0YoyA/" +
       "oWl6Os+cHtMgAxvN622Z0ACSYEBiUn/MEFO+A63WDXuJNyiCHKsLuzGlxlBC" +
       "ZoEg16Ycma1XEIXpeI+YBTUNJzimKWUDixLTrjCgomaTQ9byNDMlcZnAHOGY" +
       "1WhEdrP+why5Rn+L9zqzfIyKtrSABhjKr5FpBvd9eynh1TrumIRNG11g4R45" +
       "7Hd2xKK/GXBcXR5x7mqM+fpO3fJV10ymKtaKqdy157W5muQQ2iS7breqzoGW" +
       "egEddpG0J5jWsGFUJw2IyZFooG+rzc1mENKMM2HEGb5lBrg9Spj1rsH5DlgW" +
       "LraoiuEI46fUbGgv6DkWVWuzSR73McioTmuW3W+athTLzUmcV+1wpG0SXshg" +
       "qDnRYNRpp62c3Mkw1KCBMQd1bDZGCTiT9bSDSSiaI4uaIaNYVOfWah3eVBEG" +
       "aUl6nKSUIneGyqI24XKeWkmZlRoea7aDJUa3aF+3pV3MGDjijTEPM5t5Pd70" +
       "0LmkVM2GFk/GvQbeB2N5teXXkjvnQlKn5lqUksosri93mVLzaMkbYqlRk2W9" +
       "7XbiSJ9lPsmv+XQtY9l8SQutqJq1oLY2r2/aat/XUW5g1iZjrOOy4wZlBiNJ" +
       "6+uSCgL3TbURVtkaqrfhREe3bUPYzGcKtvDpxKTRxUTrbzMT73mt3bbVhmd1" +
       "2+xAvGxP2hneo8QMxen+eLDihGbVDamw11UVp0PV8S63WVE1JiLFcRSEu7GD" +
       "L7jtRBs1ZWgmuAu4rc4gaT3WtrWBKCncPMRavWhXc9nI70DIDl5DYhcjRH01" +
       "QxYIWIJKuxZDqYlUW4xZ31EjE1XDlm8Sw2zT6I4Sb6y7VCqvvHnXINkkjOxN" +
       "A5/365HCxrJlGf3pMtI7w/HA9Vh7U1vAA74OV1HcgWZ1w0GlXSQ6/YjTp6zV" +
       "nIYk1RzWdm5C0NkkYJMsTlNl4PtbPDfzLrGYZkZVqYthY8tMWG67W3tTCYaA" +
       "+030ZDmwepju0ut1ddCeGxg5ccJu2nTybtyohVItD1Wv0WhLY4kiA6abtKXV" +
       "dGAQVBrOElahM9boLEconFd3cr+Xt7yZMt/SqZexgusPXC1MxtIqzZo0OtvC" +
       "ndQPZxxj5yg1Q5iqvkFkTeP71objWrbHmI2dOlgjscyOkEaWNXZNihWGK3K5" +
       "abTaC7Jvzhg5InqqQ+orrdnJ22E/6dCjETJEDFKjsBqXJn7dbEEtSJ3qbL23" +
       "nNKZiiUL2/VZSl91VQu4d2kmOdMGaa1p1TfxmUogalfj6nDK6D2+YVvheAxC" +
       "pD40mFK2R0xXmJXMhoORraF8pmosEmxqDYlsddoMvZx7ykCXydFcj6p2vW7n" +
       "REzpebWl+IHVx9v2bo6iYl3ZmpON6Nhbdd2srvzmDoZSsaUiEMR7Nmqvgnjo" +
       "1FgvTuh0Vm0vBuEiFTw77lIiY4zShrQQNWhSS2oipLkdfixuYsNEHODi6SE6" +
       "rNJQk7O2OMsxg14vQvKsnhgNSVBYiNh0OQhuT/tuNg5FZRZY0tpqcdgoUtxg" +
       "gGxJbrZqboYEPnWhzc7gaslssHNFWV8RItmv9hgeuCUpkiNZw5sblptnVWW6" +
       "BPquNxpjah75jU7VgHTIaKyFCQ+nG78pLuttBEXb3AJeoqqbzd2Fiw/R9nK8" +
       "xDGoo9daTnvVaSx3MZTpTX5tbMd9hG6nELTG8sESw+LBMuecCQixhEgUWhqC" +
       "+9xEX2aYIOJDfVXlBy0vrIeNxFMTQbBU2DMQzsZqyUYeTqbric+FIopwvfG8" +
       "hkztERHHfmtENNtBj+ij07E9NrLcXeEk2+d7Cddpt1hUsrRdx9h1+50ewRCL" +
       "EZf4HK4zxGwyknu036vq9MKiHLtZi6zqRDVqm9awtW4t/Hpn1mQSxUijRqJQ" +
       "jZUnI6rQQeZdiRIR3YpVwHCJxx1B2XYYrUlvrHVozer1FVTr2xkYLmxXN0aY" +
       "aom6jkxgq9pRBZmLeuO202fFFStyjUiLme2ENvl+f9Gu16oN1ckzejVRg9aw" +
       "kzahTdWsi11eGOoyzLVYfOEpadaa1XtMIoBAvNtn1ASvwmE/9fGB0/MthZ2D" +
       "YSJgcwvHLG2L46y9SriMVjvVqurlmSNUtRXJsRN6CXSq9mvRshnDGZ/63TmO" +
       "5nMZFQNcdjrhAnH9zoIPurC4wjJeheCkOUzkTRNBGD2Sa2hruDMGYDbPO24c" +
       "z+pDTO0JmG2RdbOm9py2GkzaUZtZIVmMJGBmQ2m+UZ8sTDqJWSvd0vOcca2Z" +
       "rS393iIbZQq3oyNHansU7MeNEZtBFNrMcgHRsMUyc1HYzVcgdN5NdFntmtXW" +
       "ippQnrEA9qCDyMCsCa11wpvzaXWtCcnapqLuqBf2uaFZl2quJsFeF5Jnuiki" +
       "s9HMgOtpL636/MzjOjEDjzg+nEZgFoFNbbKjh9GquVqxuLHg9Tnq1zbbNrzE" +
       "eSxr9VOooypjheQNEMr1Fq43t7Me3GnSc7EOlpdbqredcf1pa96UbYlSM5Zi" +
       "fG+CD/QNay97aWq0eAt4yRE/bm58LZzQuir50CIjRp1lF8dnUNWo19dOW4P4" +
       "JQpLy1HEdPC1DuG7ndXpttCg3QSRYW05SBujdhSzHNTj0g2f6UiYm6jnDj2J" +
       "mc8pfxBsdDSTowbvJgMNS6MOqwxSua6mvXlNHvVmpLOo1WKo6SWoE+7m8Xwl" +
       "t2RhOwqgkPTdnW029Krb8GzJl+dzs76TUrvTatUDajpw5lO6aQ08I2tpkCcF" +
       "rawvjrRqFMaSnOx2w1G6qDmo013YZHcS0QGVL40AruuLVrzc1OH6znDjTmRw" +
       "O8wUQ9VMtutOuy85elSHJxt9Nc+ooZjM6Lo4R3IYrGTUiIC37GjBtKgGvgsa" +
       "Rovi1yOywcpYfdfAum1SoHiO2XmN+TpZO2w+6ERqQCzSMVQfUevG2jNa6cDI" +
       "URSpGm7uricqtBn2G8tGOunGXpMfyfRymg468I4DaydslKSjTFNIrbNaJE7f" +
       "k9rEboiQWkP2HH0Osy402sh1Gu24zrYuLmvoshc119ASM3XSmKCYNGMmfj8Z" +
       "I5jIWbg01lYqkUWbeTYfdTNfXjU9Nm9CwcaN22iHctG8Ry+tjrtKYn4YV2uR" +
       "6LukthvU5sSgJtcYvFNbZS3Ua5qjbdN30NzbMPQa89jJGiJiljX6sSVwW3xM" +
       "erna5ToY3plj6/GGiKBNKA0Va9RlzVVfa2I645rCmgR6k+ZtD2Osoduxp7X6" +
       "GuZ2yyDIN9vxuL4LpuQ894mhOk85Ux7KtrWjaSwwhDjN2rE/bPeRoEnJgwbJ" +
       "bbjuLoeWZtogrAEJQ/SAMlh910twvJ+betDOtADd6HAPmfYiBtlSox3hDNtj" +
       "ERqSTosc+NuqM0i3FKTrfXLsE3UKRPdowxJDM3S6uNpCFNLrRRBfx7d9e94f" +
       "kGN4q5q9BrLSDX7ZlYTuXFs7ILiRw06aTOpyjjBzhDNgcxptQs4xmlXVQgYk" +
       "P9cNPU1XUHvHLFxa0tM6Pp1JfUHmUVZusJuJ2rRDTVvX+V51os17zHQjQHW8" +
       "NpxRqh6jtUmPTBbdqTJIgvauioRV2UI5qg5ihMBftgy/TU5pjjWEVRdTt4ka" +
       "B9Bs6gZCLCNxFWrROGFKkKlvhM4IYbY1jQNLOXKTxY7sZnkdbUNMhDZRPpx3" +
       "4jbovbYT7yJapM2uslgvDQVEO9Q6HA4WI4diGYXYYH2SmAoypvNghY7azi7C" +
       "07m1nQ/bTpYsnagrEDwSMLsOgBxGNCouFaSmQYy+tbYtJkSIdDmYhwOwEE1W" +
       "tZrLWMZSGlKmaioBts3XA90LFcgQ3KgWAY/J0C3RoZP+xok28RzuNtlxf8n5" +
       "g3G3W2wL/Yvb25l7sNxwPDyk9z1sNeanvbkvPxcqJw52HdtnPfaSuFLssj1+" +
       "q7N35Q7blz/12hv68GdrB+/Q/2lSuScJ");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("wh9yjQ1wX0dVXQQ1vXjr3USuPHp49NL3Vz/1Xx8TP2J+4jZOMj15AufJKv8O" +
       "9+avk89rP3W+csfhK+CbDkXeWOjlG1/8XoqMJI188YbXv4/feJziw+B6ZV+z" +
       "r5y2g33ljJ3yD+31/Yn3/+f2BE7sl1892Jo/s7Vjxwp+94xjBV8rkn9TvHgw" +
       "EuHEu4eywD8+Zmu/klTu3ASWfmSEv3M7pxDKjN+6UWtVcH16n8enf5Bae6Ko" +
       "/Om3a+2Y1r55htb+e5H8l+K9xpHW9t64fuNIN7/3feimHK9FR39uH+3n3n3d" +
       "nOjZOyw/Kcv87zOI/0mR/A9gLqtbmMvDyf5rDSVLigNh+8eZS4V8591QyKv7" +
       "Cnn1XVVI6WALgXOXbs3+3H1Fctfp7ItHlUOu5y58H1xLscfB9do+19feda5/" +
       "XPJ55AyujxbJg8DEV8dN/KCP7z/s48PckvZD7wbtL+3T/tIPqIuvnkH7+SJ5" +
       "8iTtIvOxI5ZPfR8sHyoynwTX6/ssX/8BdW71DJYlC+g4S35/svv4EcuXbuuE" +
       "WVK5dHTiuTi++ehN/6/Y+0+A9gtvXL77fW9M/2156Pfw3P49bOXuZeq6x49b" +
       "Hbu/EEbG0iqZ37N3+CosmXSSyrPv4DQ2iE0O7wvs59p7xT+cVN5/y+LAJ4L0" +
       "uPhHk8rDp4qDibH4Oi6LJZUrJ2WTyl3l93E5AmjuSC6pXNi7OS5CASRApLil" +
       "w4Mh+Hh5mv1anFn+6lp5vF1ItsVh27IH8nM3RnOHTvhtR+ixAPDZG8K28m81" +
       "ByFWOto/s/mVNxj+R7/d/Nm9o9Caq+x2RS13s5WLe6eyD8O0p29Z20FdF6gX" +
       "vvvAL97z3EFI+cAe4KMBcQzbk6efOya8MClPCu/+4fv+/of/1htfK1+T/z+K" +
       "3+4T7zQAAA==");
}
