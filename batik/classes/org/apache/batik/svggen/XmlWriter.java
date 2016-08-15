package org.apache.batik.svggen;
class XmlWriter implements org.apache.batik.util.SVGConstants {
    private static java.lang.String EOL;
    private static final java.lang.String TAG_END = "/>";
    private static final java.lang.String TAG_START = "</";
    private static final char[] SPACES = { ' ', ' ', ' ', ' ', ' ', ' ', ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ' };
    private static final int SPACES_LEN = SPACES.length;
    static { java.lang.String temp;
             try { temp = java.lang.System.getProperty("line.separator", "\n");
             }
             catch (java.lang.SecurityException e) {
                 temp =
                   "\n";
             }
             EOL = temp; }
    static class IndentWriter extends java.io.Writer {
        protected java.io.Writer proxied;
        protected int indentLevel;
        protected int column;
        public IndentWriter(java.io.Writer proxied) { super();
                                                      if (proxied == null)
                                                          throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
                                                            org.apache.batik.svggen.ErrorConstants.
                                                              ERR_PROXY);
                                                      this.
                                                        proxied =
                                                        proxied;
        }
        public void setIndentLevel(int indentLevel) { this.
                                                        indentLevel =
                                                        indentLevel;
        }
        public int getIndentLevel() { return indentLevel;
        }
        public void printIndent() throws java.io.IOException {
            proxied.
              write(
                EOL);
            int temp =
              indentLevel;
            while (temp >
                     0) {
                if (temp >
                      SPACES_LEN) {
                    proxied.
                      write(
                        SPACES,
                        0,
                        SPACES_LEN);
                    temp -=
                      SPACES_LEN;
                }
                else {
                    proxied.
                      write(
                        SPACES,
                        0,
                        temp);
                    break;
                }
            }
            column =
              indentLevel;
        }
        public java.io.Writer getProxied() { return proxied;
        }
        public int getColumn() { return column; }
        public void write(int c) throws java.io.IOException {
            column++;
            proxied.
              write(
                c);
        }
        public void write(char[] cbuf) throws java.io.IOException {
            column +=
              cbuf.
                length;
            proxied.
              write(
                cbuf);
        }
        public void write(char[] cbuf, int off, int len) throws java.io.IOException {
            column +=
              len;
            proxied.
              write(
                cbuf,
                off,
                len);
        }
        public void write(java.lang.String str) throws java.io.IOException {
            column +=
              str.
                length(
                  );
            proxied.
              write(
                str);
        }
        public void write(java.lang.String str, int off,
                          int len) throws java.io.IOException {
            column +=
              len;
            proxied.
              write(
                str,
                off,
                len);
        }
        public void flush() throws java.io.IOException {
            proxied.
              flush(
                );
        }
        public void close() throws java.io.IOException {
            column =
              -1;
            proxied.
              close(
                );
        }
        public static final java.lang.String jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAL1ae5AcRRnv3Xvkcu9cnuRxeV2iCbjLKyBeRHKbO3KwuVzl" +
           "klMuIZe52b7byc3ODDO9d5uDGKCgclglFTA8tOD+0GAQA0GUUlQwFmWA4lEF" +
           "RAEREKU0GilJUSJlVPy+7pmdx+7s1ZWeVzV9M939dX/fr79Xd+/R90mFZZJm" +
           "qrEY22tQK9ausW7JtGgqoUqWtQ3q+uV7yqQPd53quixKKvtIfVqyNsuSRTsU" +
           "qqasPrJE0SwmaTK1uihNIUW3SS1qjkhM0bU+MlexOjOGqsgK26ynKHbolcwk" +
           "mSUxZioDWUY77QEYWZIETuKck/iGYHNrktTKurHX7b7A0z3hacGeGXcui5HG" +
           "5B5pRIpnmaLGk4rFWnMmOdfQ1b1Dqs5iNMdie9R1NgRXJdcVQLDi0YaPzh5M" +
           "N3IIZkuapjMunrWVWro6QlNJ0uDWtqs0Y11HvkzKkqTG05mRlqQzaRwmjcOk" +
           "jrRuL+C+jmrZTELn4jBnpEpDRoYYWe4fxJBMKWMP0815hhGqmC07JwZpl+Wl" +
           "FVIWiHjXufFD9+xqfKyMNPSRBkXrQXZkYILBJH0AKM0MUNPakErRVB+ZpcFi" +
           "91BTkVRlzF7pJksZ0iSWheV3YMHKrEFNPqeLFawjyGZmZaabefEGuULZXxWD" +
           "qjQEss5zZRUSdmA9CFitAGPmoAR6Z5OUDytaipGlQYq8jC1XQwcgnZGhLK3n" +
           "pyrXJKggTUJFVEkbiveA6mlD0LVCBwU0GVkYOihibUjysDRE+1EjA/26RRP0" +
           "msmBQBJG5ga78ZFglRYGVsmzPu93rb/9em2TFiUR4DlFZRX5rwGi5gDRVjpI" +
           "TQp2IAhr1ybvluY9OR4lBDrPDXQWfX54w5krzms+/qzos6hIny0De6jM+uXD" +
           "A/UvL06suawM2agydEvBxfdJzq2s225pzRngYeblR8TGmNN4fOuJa258iJ6O" +
           "kupOUinrajYDejRL1jOGolLzSqpRU2I01UlmUi2V4O2dZAa8JxWNitotg4MW" +
           "ZZ2kXOVVlTr/BogGYQiEqBreFW1Qd94NiaX5e84ghNTAQxrh2UDEH//PyLZ4" +
           "Ws/QuCRLmqLp8W5TR/mtOHicAcA2HR8ArR+OW3rWBBWM6+ZQXAI9SFOnYWRo" +
           "iGrxL2XUL5oK6FAMtcuYpnFzKM/s0UgEoF4cNHQVbGSTrqao2S8fyra1n3mk" +
           "/3mhRKj4NhKMxGCqmJgqxqeKiali+alaOrUUsCk+SCTCp5uD84tVhTUZBusG" +
           "91q7pufaq3aPrygDdTJGywFQ7LrCF2YSrgtw/Ha/fKypbmz52xc8HSXlSdIk" +
           "ySwrqRg1NphD4I/kYdtkawcgALlxYJknDmAAM3WZpsANhcUDe5QqfYSaWM/I" +
           "HM8ITpRCe4yHx4ii/JPj947e1Lv//CiJ+l0/TlkBXgvJu9Fh5x1zS9Dki43b" +
           "cODUR8fu3qe7xu+LJU4ILKBEGVYEFSIIT7+8dpn0eP+T+1o47DPBOTMJjAn8" +
           "XnNwDp9vaXX8NMpSBQIP6mZGUrHJwbiapU191K3hmjqLv88BtWhAY1sET4dt" +
           "ffw/ts4zsJwvNBv1LCAFjwOf7zHuf/2lP13E4XZCRoMn1vdQ1upxUzhYE3dI" +
           "s1y13WZSCv3eurf7a3e9f2AH11nosbLYhC1YJsA9wRICzLc+e90b77x9+GTU" +
           "1XMGcTo7AOlOLi9kFcpUX0JImG21yw+4ORVcAmpNy3YN9FMZVKQBlaJh/bNh" +
           "1QWP/+X2RqEHKtQ4anTe5AO49ee0kRuf3/X3Zj5MRMYw62LmdhO+e7Y78gbT" +
           "lPYiH7mbXlny9Wek+yEKgOe1lDHKnWnEtnVkagEj9ZxS0WPCZfC1XMcbz+fl" +
           "xYgDJyG87TIsVllem/CbnSdL6pcPnvygrveDp85wIfxpllcFNktGq9A6LFbn" +
           "YPj5QZ+1SbLS0O/i4107G9XjZ2HEPhhRBgdsbTHBceZ8CmP3rpjx658/PW/3" +
           "y2Uk2kGqVV1KdUjc9shMUHpqpcHn5owvXCHWfLTKjjMkRwqEL6hA3JcWX9H2" +
           "jMH4Goz9aP4P1h+ZeJsrnyHGWMTpyzAM+JwtT9Zde3/o1Ut/eeSOu0dFuF8T" +
           "7uQCdAv+sUUduPl3HxdAzt1bkVQkQN8XP3rfwsTlpzm962eQuiVXGLrAV7u0" +
           "Fz6U+Vt0ReUvomRGH2mU7eS4V1KzaL19kBBaTsYMCbSv3Z/ciUymNe9HFwd9" +
           "nGfaoIdzQya8Y298rws4tSZcwuXwtNn23hZ0ahHCX67mJJ/i5VosPuP4kJmG" +
           "qTPgkqYCbmRWiWEZmQFkOYWm8PMS4Tmx/BwWSTHS50MVst0vwCp4EvZMiRAB" +
           "tgkBsOgq5DOMmpEahWcSSTpCVX9igMG3JztgQRBXMuCzR+wk9sLu3fJ4S/d7" +
           "QmPPKUIg+s19MP7V3tf2vMAjQhWmCducVfIkAZBOeMJRo2D9E/iLwPNvfJBl" +
           "rBDJYFPCzkiX5VNStLiSphMQIL6v6Z3h+049LAQI2kmgMx0/9JVPYrcfEm5e" +
           "7GtWFmwtvDRibyPEwWIncre81CycouOPx/b95MF9BwRXTf4svR02oQ//6l8v" +
           "xO797XNFEsYyxd6bXuzx/BCo/WsjBNp4W8NPDzaVdUCC0UmqsppyXZZ2pvz2" +
           "NMPKDngWy90vuTZmi4YLw0hkLaxBQMm3T1HJl8Gz0VbTjSFKrpZU8jBq5uxn" +
           "8GtHgM1MCTZzoU6h0uJbctcj8FhRTQJ7F29i4cYEggqxJGx7yZXh8M2HJlJb" +
           "HrggaodjyAsq7V2/O04tDuOLLZv5btp11G/V3/n7J1qG2qaSw2Nd8yRZOn4v" +
           "BS1dG25zQVaeufnPC7ddnt49hXR8aQCi4JDf2Xz0uStXy3dG+dGBiCAFRw5+" +
           "ola/nleblGVNza/ZK/0p8UXwdNmL2hXUS1eZuFKeW5hohpEGci/baLmG8lFv" +
           "LZGcHcDiRkjqcLftcd9Yvct2OfhvgJHyEV1Judp+02RGWToVwoqEwetvyIs6" +
           "G9swxm61Rd06dZTCSEuAcFeJtnuwOAgADfkA4ui6YNwxDWA0OGD02hL1Th2M" +
           "MNISAn+zuDo52f9sJ/vv3NKek6mBhsfpDmNxP2QBhgkhRECFVbe5KE1MA0rz" +
           "sG0ZPNQWlU4dpTDSEih9r0Tb97E4ykg1qEy3J3VzgXh4umxnMTyKLY0ydSDC" +
           "SEsI+1SJtuNYPAF5LwCRcMOmi8OPp8tsUCGGbWGGp45DGOlknvb58A4P8A4v" +
           "YnGCkYpR3DsHzOOZ6UJjNTyGLZIxdTTCSEMche/mKZ/I80MGkTburDnxM+tb" +
           "f3hMpKfFtgmBs+4Hj1TJb2ZOvOekMH15HvGQiSyF57s2j/w/I0P/5XkskGXi" +
           "I7jLxEscJSMxPGrpllh6I7zy7adz9Pv/mgozvVXhSZIH34lvr3xp/8TKd/mB" +
           "R5ViQdoFWVqRewgPzQdH3zn9St2SR3h6V45JHEJcF7zAKbyf8V278NVpwOI3" +
           "QkGvwcJOIYLphJy208GApaRzBSqF3+1iWDt9P1U8n47iawzsa1DRJJWzsxPy" +
           "XZVqQ+J6QMLiXcOdIiro/OENTxQgjdY1imvhtM1xQl/+hgwaizN7g2CWT+ax" +
           "Lc5PCYf5UYm2j7H4EESTkS8hRonuZ8MchMeX+EDnVK9P5sA+weLVEAd2croc" +
           "2GfhydoWnp26AwsjDQhbJo7Z8PNN7tPzjj1SPQkukVosKorjEqmcLlzwNGfM" +
           "Fm5s6riEkZbOABtdExE3qhyAErFRILQIi6YQhGZPF0KXwrPfFnP/1BEKIw3V" +
           "nMiCgOasngyXT2OxPASXFdOFCwbOW2zhbpk6LmGk4Q4pctFkQKzDgvtuNWul" +
           "A0DEpxOIcVua8akDEUZaAogrJgOiDYtW4emtoEas/18AkWOk1nvt65j28klv" +
           "iyEJWVDwmxPxOwn5kYmGqvkT218TOYTzW4baJKkazKqq94zd815pmHRQ4UjX" +
           "ihN3fvwXSTIyP4QbPDPjL8h25GrRfws4pmB/gJD/9/bbCvsytx8MJV68XbYz" +
           "UgZd8LWXA3ZJTji/RV5YecSbO9lqeI7pVvqSN/77HifvzYpf+PTLxyau6rr+" +
           "zCUPiKtPWZXGxnCUGsizxC2snWd5T4GDozljVW5ac7b+0ZmrnKx5lmDY1elF" +
           "nnQhARpo4P3UwsC9oNWSvx584/D6p14cr3wF8sodJCJBsrSj8AImZ2RNsmRH" +
           "svC8GNJQfmHZuuYbey8/b/Cvb/IrLiK2DIvD+/fLJ49c++qdCw43R0lNJ6nA" +
           "W4YcvxnauFfbSuURs4/UKVZ7DliEUSAz8x1G16MiShinOC42nHX5Wrw4Z2RF" +
           "4Tl84c8NqlV9lJptelbjG3rIjmvcGich9h0KZg0jQODWeFJm1DVIjXE1QPf6" +
           "k5sNw7mmqD5tcB1MF8/aUEk5NTrMSPo/X4G3ZPsnAAA=");
        public static final java.lang.String jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String jlc$ClassType$jl5 =
          ("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" +
           "bux2yGLLcWy5T/7PsbP41L//79cwoXQ411lpz/RXoLd+4anej3y77H9s+UXv" +
           "Z7JrPTPYnh33Rb7s/tfzH77wz89X7lUql7WDvZ+kOklhTwrY70SHG0KwPzxV" +
           "f3rvsl+oXz7ybB8663VOTHvW5xyvCOC5aF08XzzjZh4tuPw8SN0DC+yedTPn" +
           "KuUDVnZ5vsyvFNkPHFr1/UHox4BKQz8w7D8Hn3Mg/Z8iFcMVBfuF+NHewW7g" +
           "uaPtQACWq3vBEJll6EX32t6vFTlaZN39qK0bqsvHToN5EaTeAZjeDcAMbwCm" +
           "eCRKDpFx5QGrXCEZY2s4N9c8LrRc4EW3B3s06NVH37F/4c++st9/nVWzM42N" +
           "19/46T+/+tk3zp/Y9b5wzcbzZJ/9zrek8qGS1MJwn7/ZLGUP8k+/9upv/r1X" +
           "X9tT9ejpPRwBXlG+8i//9zeufuFbv3ed7cRdYH9+RizM+xTLcyDhB2LBbyAW" +
           "5S8iloOdZfFLOEPTj92Spj2/zgGtvQe52rpa6pp6/VnvKh5/EMwXle9OoMfS" +
           "8lTnkIwn1o525VCbJfAuBVzLlbXTOvTwl0uvWBjx1f0LyBlayb8wrUC6Dx8P" +
           "xvjgXeYz/+Fz3/iZF94BkqIr92wLtwFEemLGUVK83v31tz7/9ANvfOsz5RoM" +
           "2Ch9+r2nPl6M6twMcZGVkl8eQn2qgCqUe1hGjWK2XDYN/QgtdwKPGIPF178N" +
           "tPEj/T4aDbDDDwOrRgPTeN7b1mdbW0s6mpfwmSEhVm+xZoa7rsH3h4txfZgm" +
           "Uu7YDpsMFKOBLFqLnVYf4/i4ozcSnBr2VpqzckgRa8djvFqjsAlWo6ZTZ5KS" +
           "royhDkHyGMETw2mNshx6KtCOxO2qrcDVs2orghXZkHKpw3bqHX0GLcNWZ6ZX" +
           "Ib5Tc0lFod1NSMwRJJ4MO2oSyS06plYbf7qR40l9U02k1m4z4fRGfZNY2XC4" +
           "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" +
           "T2aRvXgrb/NfblL3vSJ7F5ihVtC1h3GT");
        public static final java.lang.String jlc$ClassType$jl5$1 =
          ("5v8j23//m1uZ93tF9kc3MO8/vl3zboOUHJh3cmfM+67jrfg7RyItfdm5e24B" +
           "9ty9RVa5Pthz524XbBFDkR+Aze+4uzZLBI/cCuJjRfbgDSA+dLsQWyB98gDi" +
           "J++4PI9NdC/Pp28F9tkie/IGYL/vdsEWcYSfPgD76TsD9oSJnnvpVuiqRXal" +
           "CKFwksg8g+7FO4Hu9QN0r995dI1boSvekc/V9g4tOis7+P2gy+LKgyfjcg8d" +
           "9vO3DOcFe4Qnr/lTwD6QXfvqm5fue+LN6R/tl/jDYPP7mcp9y8RxTkaJnXi+" +
           "EITG0iqZc/8+ZiwowX48rjxxA2qKWJnyoSD73I/u2/fiyuWz7QGryu+T7cDq" +
           "dvG4HRhq/3CyySCu3AWaFI90Kd1atl+knjypHKW7f/RWXD9xsvDCqb1V+QeM" +
           "w9f3ZP8XjFe0r71Jj37i3eaX9uG0mqPmeTHKfWAbtI/sPdgGnQzEOjva4VgX" +
           "+i+99/Av3//i4VnFw3uCjxX1BG3PXj92lXCDuIw2zX/9iV/92N9980/KEJ//" +
           "CwxX+dsZMwAA");
    }
    private static void writeXml(org.w3c.dom.Attr attr,
                                 org.apache.batik.svggen.XmlWriter.IndentWriter out,
                                 boolean escaped)
          throws java.io.IOException { java.lang.String name =
                                         attr.
                                         getName(
                                           );
                                       out.
                                         write(
                                           name);
                                       out.
                                         write(
                                           "=\"");
                                       writeChildrenXml(
                                         attr,
                                         out,
                                         escaped);
                                       out.
                                         write(
                                           '\"');
    }
    private static void writeChildrenXml(org.w3c.dom.Attr attr,
                                         org.apache.batik.svggen.XmlWriter.IndentWriter out,
                                         boolean escaped)
          throws java.io.IOException { char[] data =
                                         attr.
                                         getValue(
                                           ).
                                         toCharArray(
                                           );
                                       if (data ==
                                             null)
                                           return;
                                       int length =
                                         data.
                                           length;
                                       int start =
                                         0;
                                       int last =
                                         0;
                                       while (last <
                                                length) {
                                           char c =
                                             data[last];
                                           switch (c) {
                                               case '<':
                                                   out.
                                                     write(
                                                       data,
                                                       start,
                                                       last -
                                                         start);
                                                   start =
                                                     last +
                                                       1;
                                                   out.
                                                     write(
                                                       "&lt;");
                                                   break;
                                               case '>':
                                                   out.
                                                     write(
                                                       data,
                                                       start,
                                                       last -
                                                         start);
                                                   start =
                                                     last +
                                                       1;
                                                   out.
                                                     write(
                                                       "&gt;");
                                                   break;
                                               case '&':
                                                   out.
                                                     write(
                                                       data,
                                                       start,
                                                       last -
                                                         start);
                                                   start =
                                                     last +
                                                       1;
                                                   out.
                                                     write(
                                                       "&amp;");
                                                   break;
                                               case '\'':
                                                   out.
                                                     write(
                                                       data,
                                                       start,
                                                       last -
                                                         start);
                                                   start =
                                                     last +
                                                       1;
                                                   out.
                                                     write(
                                                       "&apos;");
                                                   break;
                                               case '\"':
                                                   out.
                                                     write(
                                                       data,
                                                       start,
                                                       last -
                                                         start);
                                                   start =
                                                     last +
                                                       1;
                                                   out.
                                                     write(
                                                       "&quot;");
                                                   break;
                                               default:
                                                   if (escaped &&
                                                         c >
                                                         127) {
                                                       out.
                                                         write(
                                                           data,
                                                           start,
                                                           last -
                                                             start);
                                                       java.lang.String hex =
                                                         "0000" +
                                                       java.lang.Integer.
                                                         toHexString(
                                                           c);
                                                       out.
                                                         write(
                                                           "&#x" +
                                                           hex.
                                                             substring(
                                                               hex.
                                                                 length(
                                                                   ) -
                                                                 4) +
                                                           ";");
                                                       start =
                                                         last +
                                                           1;
                                                   }
                                                   break;
                                           }
                                           last++;
                                       }
                                       out.
                                         write(
                                           data,
                                           start,
                                           last -
                                             start);
    }
    private static void writeXml(org.w3c.dom.Comment comment,
                                 org.apache.batik.svggen.XmlWriter.IndentWriter out,
                                 boolean escaped)
          throws java.io.IOException { char[] data =
                                         comment.
                                         getData(
                                           ).
                                         toCharArray(
                                           );
                                       if (data ==
                                             null) {
                                           out.
                                             write(
                                               "<!---->");
                                           return;
                                       }
                                       out.
                                         write(
                                           "<!--");
                                       boolean sawDash =
                                         false;
                                       int length =
                                         data.
                                           length;
                                       int start =
                                         0;
                                       int last =
                                         0;
                                       while (last <
                                                length) {
                                           char c =
                                             data[last];
                                           if (c ==
                                                 '-') {
                                               if (sawDash) {
                                                   out.
                                                     write(
                                                       data,
                                                       start,
                                                       last -
                                                         start);
                                                   start =
                                                     last;
                                                   out.
                                                     write(
                                                       ' ');
                                               }
                                               sawDash =
                                                 true;
                                           }
                                           else {
                                               sawDash =
                                                 false;
                                           }
                                           last++;
                                       }
                                       out.
                                         write(
                                           data,
                                           start,
                                           last -
                                             start);
                                       if (sawDash)
                                           out.
                                             write(
                                               ' ');
                                       out.
                                         write(
                                           "-->");
    }
    private static void writeXml(org.w3c.dom.Text text,
                                 org.apache.batik.svggen.XmlWriter.IndentWriter out,
                                 boolean escaped)
          throws java.io.IOException { writeXml(
                                         text,
                                         out,
                                         false,
                                         escaped);
    }
    private static void writeXml(org.w3c.dom.Text text,
                                 org.apache.batik.svggen.XmlWriter.IndentWriter out,
                                 boolean trimWS,
                                 boolean escaped)
          throws java.io.IOException { char[] data =
                                         text.
                                         getData(
                                           ).
                                         toCharArray(
                                           );
                                       if (data ==
                                             null) {
                                           java.lang.System.
                                             err.
                                             println(
                                               "Null text data??");
                                           return;
                                       }
                                       int length =
                                         data.
                                           length;
                                       int start =
                                         0;
                                       int last =
                                         0;
                                       if (trimWS) {
                                           while (last <
                                                    length) {
                                               char c =
                                                 data[last];
                                               switch (c) {
                                                   case ' ':
                                                   case '\t':
                                                   case '\n':
                                                   case '\r':
                                                       last++;
                                                       continue;
                                                   default:
                                                       break;
                                               }
                                               break;
                                           }
                                           start =
                                             last;
                                       }
                                       while (last <
                                                length) {
                                           char c =
                                             data[last];
                                           switch (c) {
                                               case ' ':
                                               case '\t':
                                               case '\n':
                                               case '\r':
                                                   if (trimWS) {
                                                       int wsStart =
                                                         last;
                                                       last++;
                                                       while (last <
                                                                length) {
                                                           switch (data[last]) {
                                                               case ' ':
                                                               case '\t':
                                                               case '\n':
                                                               case '\r':
                                                                   last++;
                                                                   continue;
                                                               default:
                                                                   break;
                                                           }
                                                           break;
                                                       }
                                                       if (last ==
                                                             length) {
                                                           out.
                                                             write(
                                                               data,
                                                               start,
                                                               wsStart -
                                                                 start);
                                                           return;
                                                       }
                                                       else {
                                                           continue;
                                                       }
                                                   }
                                                   break;
                                               case '<':
                                                   out.
                                                     write(
                                                       data,
                                                       start,
                                                       last -
                                                         start);
                                                   start =
                                                     last +
                                                       1;
                                                   out.
                                                     write(
                                                       "&lt;");
                                                   break;
                                               case '>':
                                                   out.
                                                     write(
                                                       data,
                                                       start,
                                                       last -
                                                         start);
                                                   start =
                                                     last +
                                                       1;
                                                   out.
                                                     write(
                                                       "&gt;");
                                                   break;
                                               case '&':
                                                   out.
                                                     write(
                                                       data,
                                                       start,
                                                       last -
                                                         start);
                                                   start =
                                                     last +
                                                       1;
                                                   out.
                                                     write(
                                                       "&amp;");
                                                   break;
                                               default:
                                                   if (escaped &&
                                                         c >
                                                         127) {
                                                       out.
                                                         write(
                                                           data,
                                                           start,
                                                           last -
                                                             start);
                                                       java.lang.String hex =
                                                         "0000" +
                                                       java.lang.Integer.
                                                         toHexString(
                                                           c);
                                                       out.
                                                         write(
                                                           "&#x" +
                                                           hex.
                                                             substring(
                                                               hex.
                                                                 length(
                                                                   ) -
                                                                 4) +
                                                           ";");
                                                       start =
                                                         last +
                                                           1;
                                                   }
                                                   break;
                                           }
                                           last++;
                                       }
                                       out.
                                         write(
                                           data,
                                           start,
                                           last -
                                             start);
    }
    private static void writeXml(org.w3c.dom.CDATASection cdataSection,
                                 org.apache.batik.svggen.XmlWriter.IndentWriter out,
                                 boolean escaped)
          throws java.io.IOException { char[] data =
                                         cdataSection.
                                         getData(
                                           ).
                                         toCharArray(
                                           );
                                       if (data ==
                                             null) {
                                           out.
                                             write(
                                               "<![CDATA[]]>");
                                           return;
                                       }
                                       out.
                                         write(
                                           "<![CDATA[");
                                       int length =
                                         data.
                                           length;
                                       int start =
                                         0;
                                       int last =
                                         0;
                                       while (last <
                                                length) {
                                           char c =
                                             data[last];
                                           if (c ==
                                                 ']') {
                                               if (last +
                                                     2 <
                                                     data.
                                                       length &&
                                                     data[last +
                                                            1] ==
                                                     ']' &&
                                                     data[last +
                                                            2] ==
                                                     '>') {
                                                   out.
                                                     write(
                                                       data,
                                                       start,
                                                       last -
                                                         start);
                                                   start =
                                                     last +
                                                       1;
                                                   out.
                                                     write(
                                                       "]]]]><![CDATA[>");
                                                   continue;
                                               }
                                           }
                                           last++;
                                       }
                                       out.
                                         write(
                                           data,
                                           start,
                                           last -
                                             start);
                                       out.
                                         write(
                                           "]]>");
    }
    private static void writeXml(org.w3c.dom.Element element,
                                 org.apache.batik.svggen.XmlWriter.IndentWriter out,
                                 boolean escaped)
          throws java.io.IOException,
        org.apache.batik.svggen.SVGGraphics2DIOException {
        out.
          write(
            TAG_START,
            0,
            1);
        out.
          write(
            element.
              getTagName(
                ));
        org.w3c.dom.NamedNodeMap attributes =
          element.
          getAttributes(
            );
        if (attributes !=
              null) {
            int nAttr =
              attributes.
              getLength(
                );
            for (int i =
                   0;
                 i <
                   nAttr;
                 i++) {
                org.w3c.dom.Attr attr =
                  (org.w3c.dom.Attr)
                    attributes.
                    item(
                      i);
                out.
                  write(
                    ' ');
                writeXml(
                  attr,
                  out,
                  escaped);
            }
        }
        boolean lastElem =
          element.
          getParentNode(
            ).
          getLastChild(
            ) ==
          element;
        if (!element.
              hasChildNodes(
                )) {
            if (lastElem)
                out.
                  setIndentLevel(
                    out.
                      getIndentLevel(
                        ) -
                      2);
            out.
              printIndent(
                );
            out.
              write(
                TAG_END,
                0,
                2);
            return;
        }
        org.w3c.dom.Node child =
          element.
          getFirstChild(
            );
        out.
          printIndent(
            );
        out.
          write(
            TAG_END,
            1,
            1);
        if (child.
              getNodeType(
                ) !=
              org.w3c.dom.Node.
                TEXT_NODE ||
              element.
              getLastChild(
                ) !=
              child) {
            out.
              setIndentLevel(
                out.
                  getIndentLevel(
                    ) +
                  2);
        }
        writeChildrenXml(
          element,
          out,
          escaped);
        out.
          write(
            TAG_START,
            0,
            2);
        out.
          write(
            element.
              getTagName(
                ));
        if (lastElem)
            out.
              setIndentLevel(
                out.
                  getIndentLevel(
                    ) -
                  2);
        out.
          printIndent(
            );
        out.
          write(
            TAG_END,
            1,
            1);
    }
    private static void writeChildrenXml(org.w3c.dom.Element element,
                                         org.apache.batik.svggen.XmlWriter.IndentWriter out,
                                         boolean escaped)
          throws java.io.IOException,
        org.apache.batik.svggen.SVGGraphics2DIOException {
        org.w3c.dom.Node child =
          element.
          getFirstChild(
            );
        while (child !=
                 null) {
            writeXml(
              child,
              out,
              escaped);
            child =
              child.
                getNextSibling(
                  );
        }
    }
    private static void writeDocumentHeader(org.apache.batik.svggen.XmlWriter.IndentWriter out)
          throws java.io.IOException { java.lang.String encoding =
                                         null;
                                       if (out.
                                             getProxied(
                                               ) instanceof java.io.OutputStreamWriter) {
                                           java.io.OutputStreamWriter osw =
                                             (java.io.OutputStreamWriter)
                                               out.
                                               getProxied(
                                                 );
                                           encoding =
                                             java2std(
                                               osw.
                                                 getEncoding(
                                                   ));
                                       }
                                       out.
                                         write(
                                           "<?xml version=\"1.0\"");
                                       if (encoding !=
                                             null) {
                                           out.
                                             write(
                                               " encoding=\"");
                                           out.
                                             write(
                                               encoding);
                                           out.
                                             write(
                                               '\"');
                                       }
                                       out.
                                         write(
                                           "?>");
                                       out.
                                         write(
                                           EOL);
                                       out.
                                         write(
                                           "<!DOCTYPE svg PUBLIC \'");
                                       out.
                                         write(
                                           SVG_PUBLIC_ID);
                                       out.
                                         write(
                                           "\'");
                                       out.
                                         write(
                                           EOL);
                                       out.
                                         write(
                                           "          \'");
                                       out.
                                         write(
                                           SVG_SYSTEM_ID);
                                       out.
                                         write(
                                           "\'");
                                       out.
                                         write(
                                           ">");
                                       out.
                                         write(
                                           EOL);
    }
    private static void writeXml(org.w3c.dom.Document document,
                                 org.apache.batik.svggen.XmlWriter.IndentWriter out,
                                 boolean escaped)
          throws java.io.IOException,
        org.apache.batik.svggen.SVGGraphics2DIOException {
        writeDocumentHeader(
          out);
        org.w3c.dom.NodeList childList =
          document.
          getChildNodes(
            );
        writeXml(
          childList,
          out,
          escaped);
    }
    private static void writeXml(org.w3c.dom.NodeList childList,
                                 org.apache.batik.svggen.XmlWriter.IndentWriter out,
                                 boolean escaped)
          throws java.io.IOException,
        org.apache.batik.svggen.SVGGraphics2DIOException {
        int length =
          childList.
          getLength(
            );
        if (length ==
              0)
            return;
        for (int i =
               0;
             i <
               length;
             i++) {
            org.w3c.dom.Node child =
              childList.
              item(
                i);
            writeXml(
              child,
              out,
              escaped);
            out.
              write(
                EOL);
        }
    }
    static java.lang.String java2std(java.lang.String encodingName) {
        if (encodingName ==
              null)
            return null;
        if (encodingName.
              startsWith(
                "ISO8859_"))
            return "ISO-8859-" +
            encodingName.
              substring(
                8);
        if (encodingName.
              startsWith(
                "8859_"))
            return "ISO-8859-" +
            encodingName.
              substring(
                5);
        if ("ASCII7".
              equalsIgnoreCase(
                encodingName) ||
              "ASCII".
              equalsIgnoreCase(
                encodingName))
            return "US-ASCII";
        if ("UTF8".
              equalsIgnoreCase(
                encodingName))
            return "UTF-8";
        if (encodingName.
              startsWith(
                "Unicode"))
            return "UTF-16";
        if ("SJIS".
              equalsIgnoreCase(
                encodingName))
            return "Shift_JIS";
        if ("JIS".
              equalsIgnoreCase(
                encodingName))
            return "ISO-2022-JP";
        if ("EUCJIS".
              equalsIgnoreCase(
                encodingName))
            return "EUC-JP";
        return "UTF-8";
    }
    public static void writeXml(org.w3c.dom.Node node,
                                java.io.Writer writer,
                                boolean escaped)
          throws org.apache.batik.svggen.SVGGraphics2DIOException {
        try {
            org.apache.batik.svggen.XmlWriter.IndentWriter out =
              null;
            if (writer instanceof org.apache.batik.svggen.XmlWriter.IndentWriter)
                out =
                  (org.apache.batik.svggen.XmlWriter.IndentWriter)
                    writer;
            else
                out =
                  new org.apache.batik.svggen.XmlWriter.IndentWriter(
                    writer);
            switch (node.
                      getNodeType(
                        )) {
                case org.w3c.dom.Node.
                       ATTRIBUTE_NODE:
                    writeXml(
                      (org.w3c.dom.Attr)
                        node,
                      out,
                      escaped);
                    break;
                case org.w3c.dom.Node.
                       COMMENT_NODE:
                    writeXml(
                      (org.w3c.dom.Comment)
                        node,
                      out,
                      escaped);
                    break;
                case org.w3c.dom.Node.
                       TEXT_NODE:
                    writeXml(
                      (org.w3c.dom.Text)
                        node,
                      out,
                      escaped);
                    break;
                case org.w3c.dom.Node.
                       CDATA_SECTION_NODE:
                    writeXml(
                      (org.w3c.dom.CDATASection)
                        node,
                      out,
                      escaped);
                    break;
                case org.w3c.dom.Node.
                       DOCUMENT_NODE:
                    writeXml(
                      (org.w3c.dom.Document)
                        node,
                      out,
                      escaped);
                    break;
                case org.w3c.dom.Node.
                       DOCUMENT_FRAGMENT_NODE:
                    writeDocumentHeader(
                      out);
                    org.w3c.dom.NodeList childList =
                      node.
                      getChildNodes(
                        );
                    writeXml(
                      childList,
                      out,
                      escaped);
                    break;
                case org.w3c.dom.Node.
                       ELEMENT_NODE:
                    writeXml(
                      (org.w3c.dom.Element)
                        node,
                      out,
                      escaped);
                    break;
                default:
                    throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
                      org.apache.batik.svggen.ErrorConstants.
                        INVALID_NODE +
                      node.
                        getClass(
                          ).
                        getName(
                          ));
            }
        }
        catch (java.io.IOException io) {
            throw new org.apache.batik.svggen.SVGGraphics2DIOException(
              io);
        }
    }
    public XmlWriter() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "HAKcTVqMvZP1wdn9qeBcj8W6YDjFEYAT8xcyGZh+2Wb+5SHAKWRDsmgAYsGm" +
       "egVDoM83wHPjIrBCB3TwyLjQtGJsmovOxpFCZxVIqpDT5P+Homw3Z4No3AAU" +
       "h5B6o7I5HWOdgzQ/ubuqd1Mg5rbW4Q6F64K1butw4Jq0yKjUHQO+uq7I+JaQ" +
       "f/8m3bevpHDSvitf4O8JnG/UxkRJYXdCUbwvVz31fN2g3TITxhj+qlVnvO20" +
       "yKSA1ATfm7IKblm4lY/fbSPsHW+RPPbfO26PRYrccUCKV7xD7rRIDgzB6l49" +
       "JT73hpm/Y07ym5ApXvjYEWjCYKinpng/TMFLX/Ytp3NBm+Bfc3ZKR/atarr2" +
       "zEX38A9jJEXczO5SRkdJAf/8hhHFS96ZgdQcWvkr554de/+o2c49WdqHOd69" +
       "MdljTooSn+z7ZMSsTn058uL+JY/8Znv+qRAR1hJBhFC9NvNtfFJPGGTa2mjm" +
       "G4p20WDfstTM/e6mpfO7//US+96B8Pv4qcHjO6XnDlz97M6K/ZUhMrqR5Mlq" +
       "jCbZZwL1m9Q1VOozOkixbDYkYYtARRaVtNcfY1E5RXxhznCx4SxOteIXUxap" +
       "ynz1k/mdWZGi9VNjmZZQmVcrjpLRbguXjO+ePKHrvgluiy1KLL+GxflJlAbo" +
       "Y2d0ta473x0Vva8z47wpmztm17jCEVbF2v3/BdCCcnjnLQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "pvOu5tSw5x3Niecv8iV1mb96zrc8UqL8RHE1D31L87xvOahVmfdVTd5WpdfK" +
       "5EerObkU1u71fD0u7LIw6qAKJ6shng5rdw3nREX/uiJorpSklOn6Pu7au6wy" +
       "bZUJvJ/o7oVK8cwxy288coHgIcvgTSwXDuYS8N7yBr8123eV2UGZDMMCNd0R" +
       "rSOu72Xh0Y0hWVWOznFJ3CGXJZitQy5bt+TyPUB5w96WyzKhjli8r2SRYWGa" +
       "vRWTyztkclBcvUMmOxfM/o/fGYP3MBSMDpnCXt9+sb1WvnEfmT7/T5760k89" +
       "/9T/qNzLFT0otBr2N7cIlU+1+dYLX/vGl1/75s9Wy/FlSQz2+n1+j3HzFuLM" +
       "zqDi+DXHgFQwPVqsUPfv8dj/hjXjFQZ05RZOTEJAt4t9AiC7hTUDoa5pADvB" +
       "sIHuq6V7zI7Cxx/iaOlL+1TK1+0iKIgPdxnAsw9/zfzU139lv4M470DPEasf" +
       "ee5n/+r6x567dGrf9tRNW6fTbfZ7t2pKXltpUsnd215qlKoF9qefe/bX/9mz" +
       "H95z9fDZXciw2GT/yn/5y9+7/sk//p1bBMSX5e3h/rn0KAeHMW1lJWWiHBmA" +
       "d4H7K7PvPKv7lupswm1FuTmUovwxC4dY6GKZlb30eMhL+36O/OQjJ34StVxH" +
       "LcOQo7p9SK6714+35EVlehPzfu1dF0/orNL9k5Xqix/634+z792+/w5i8bec" +
       "m5DzXf7z2Qu/M3qH/Pcv1e46Xrdu2q+fbfTM2dXqqq+Gke+wZ9asN+/no8Kv" +
       "TJ56iXDpQy9R9zNl8sHC68slvvvpeAnyD6e1c/71J+7Qvz5TXNChf4Uu8K8/" +
       "e2f+9erev94ghmRZEp7j8KO35XCvl+UKdDd4vXe9Ud7/vZfg4Z038/AGw5Kv" +
       "HQXnnOoHhdZcM6zerZakp182Q4X23n9iAoTrbJ756P/8+O/93FNfK4x3Wrs7" +
       "LmOkQglPxRNkVD6z+rsvfOLNP/LcH3+02mUUZsD9zPcef1/Z6yfvTKzHS7GY" +
       "yrMSYhDOqs2AqpSS3cqkLxdKdD6WefnShg//2rgdTOCjP6Ipoi2Ya9JmXQVm" +
       "5hCZMGMPG28Q1J2QbX8yaIvehDcX842lM4wtcYOBEPWngY+0lL6j2M0s0TG3" +
       "t8RVizFH6cRfhpjp0WNcmY+bIpG0N93lNqfFHYhrirES7aa12kIGFftAp56r" +
       "LSluSfY0aAS5bPYoBxKAXAOA3CFbA6kzhBoZynHEGm3qomJHw1Fz5dIDgRp1" +
       "tyxNktHG5+ZdaqlB/XwVk82GOIlNRRhlsYh3V/R0Flldk5nl8YTEzCbBjbgd" +
       "aQ3FReqEiLH0hqImzmwRNId2NhKMNaaYjCSsxHyEw30PmzT8kS4IVoY1pnou" +
       "iQiaZMTC7ekSqtAjv99iOXpmSkx/2Iog2KeggUcN2t1ZBEYCptukv9V66dBA" +
       "TY+bcAMxtHc0koezpsDNqWL/trV9Fu121hi5YXzXDfIJrnfjOqsEPa1hGZNJ" +
       "ZnJck8lHjm+PbM9naJCklxEOkvqmIdlts9kZyTjihKNVRnd3hW+GFytDRvWB" +
       "r0U4ue3PuCULsTsyWM06FjVtoqximoJTTA5LD+cz0KZFUOgiC5G0oQBy4B6f" +
       "LMNOTgwQoeWkmqBoQdNbAKY5ncyXOu770kZBWWGbMBMFRnVSaY4H/qSFiXg2" +
       "MDASAfHW0hxyWMtOiSjIlmqTpRl30B5zejITMXbTbXn8hssQsjvbjmiPdnd9" +
       "aScs+haphhkBwjjErrl2ZwtF6ZjeBKaNGbQvT1RboTKlsdnlI4KlNIqhMB5Y" +
       "LnkYmxHtkN01uWKVEV2dnMKZr+P4jhKGK3PcbCJt3t6pCLx1VzadTjBivKJX" +
       "9gAcznpLhuy3m14baydiyg9gnBaFNgKM8MloOY0jszMdU6tGk1CszPctekBP" +
       "4H7a1c021RknXRpvdRfNcBqI2DyD2TTJidZOmlPjbY/BUJ6Chy0QrndsRaPW" +
       "VAeY7QwWgNNlD5+Jakdks5W/7PsaqYnCbs3lBNRCpCKwtnXbgMhZW2hKKz7W" +
       "ltPxOpkhJIsRw7w3XqjrNQXhfVlz7fqIwYZGJsiNKT0cU7TriIXycjs93ez8" +
       "5RBtiGLGGDtk5/MASHrwYLfkbCsmVp2oH5mcTk05bsvGgajC4jSaTIYLbFm0" +
       "94v57nYJTq/70xanA63GXNuOennckTy0xewgzqOLATlObDKTaDvR+jYySOcY" +
       "OJBGdRP1FWgxk1ZDmHH5Bp+pOrztNoaRYvhddbzzRvE2Xcc2O3GH5LaJdvrb" +
       "+cY2BSDTzCG8w7XugGsgo6bt4Sy2U4a73jAIxDzM13WaXk8sGholToL7yNJG" +
       "IU4wI6zOEdsmNh0OyQ3ebmFTwtwskoRPRAp1+boIrv3mrqWJuzEJb2IWWs9m" +
       "zJYrNMGTu001UDil4Y0z123ledZvY/qkMxSmNrMVUG6MLDDM709gwjQknjN2" +
       "Ngri8y7gOSqWAKmeDkxwM6OG/QVKoB428vrNGQLq7by1HBerZMfbTAebQCAb" +
       "xW565wBtCfRpdcighgLW54yqoq48dol6pC+Jbg9ctUww0tfS2gFa2agpkaSm" +
       "NiB8PASWmaBPKG7dVqAZxeIyKE3YHl/X0JW4kXo4NRhbGwOEu92o4fdHthF5" +
       "MpfkkDWZDMaKT1vpMpjFSDQzdqRE18P20uvkm2DqwP0C0kwSkE5fDsW+FNYV" +
       "gIj1VGfYDexCSzbi7GKBnSbzoR4aPXsl7zpYiOyWSc9b9gkFEABFBMNlovAy" +
       "E0hwuOKb5jjfiCacbOsAb5NEr9NV437uCgvczGiD1xIHQjW4B1IQzwagPOjT" +
       "nC33dqnpSd21sXEomeDH2jIYjJaMuvObNFKv09FKTRl86pPbbJVjed42UtBa" +
       "z1w8HGzxmdNPYLvXm8vxpL/sK1CzbU0ycjIaKApIptsWYq+jDu0PlpS8pcJJ" +
       "y0F24Bak9JaKrBJlLQY7CdfUObnJ2rtFIGBbbEXERHPNs5hEzn0wclZtyIrn" +
       "O05ynKgXUa2QhrpJS+QdBuukfio1R7s2tIZ3CUg4QyLEIVIT5k1iJFuTRZ+l" +
       "iJ7XWengIh4SRi4q2MqT40VAkAGSNfzNGmracKFNMxMc9Eisg0h9oE8aQ0Uu" +
       "fC6JZMsd7fJ21snm2cyAJ5gH8nFEMibgrok62+ui3aErrPXFYLLIRhaMN3oU" +
       "EWajaNVIdLsF1buiQgyipJdLNN3JGTugbD4w+6TcTQKspYT1PppjAAAmONjq" +
       "a6RLGRrvao7NrfOFP2aVOq61ZnUWXWP2ip3NWnFGZuocMKMdFwexHbHQWGjK" +
       "ziyD6ToogD0IG0AOh3CAPdsuQwRh9GWvDzbW1oIR5UQz1a7IFsZad0hRc/w4" +
       "pfGl3WHnTj0GBaFpA2RrZkxCOiVJkdBYjzd0PNiSELpK5HV9zC0meM5kuDTj" +
       "VU4m5nwO8ctguYOlmZdR/FzrTM0oNzNnxw7HOLJDIlPIRh19I62T4XjUFbBs" +
       "rPPTbktOwGlnRov+fL4SFwMwZLpNyLBJCq2DHAZKyZTbmBhm44OmYneyxnjX" +
       "jVKRmMAry+Qwuu9ji1kAz9BGU+y50kjfpZDsa3jWGHSGHDLq0rGC6z6eBLqK" +
       "DDpdNODJEb3loU13ywvbddYIw1UkyvEok9xtoShU3I7DkObHOBbHQl3Q5QVi" +
       "LWe9lRXuuttQaowSYmZxLrsWJYzfyABlJc16rMc5DdT7i3Ek47tsQIkKs2ir" +
       "+JRW9W0fMJZQewoFQ8ruoYmst0Crz2tt3EImKx72+Q4XWVMIRbg+vhA9xlx5" +
       "GTJu1MetYSfE+iGkU1rfGGx6bNsb1pVBsy1PNcN113QEr+eYxi0Etjdliu39" +
       "uhFuW9NA6c03/SD0W27TdMJ6V+ov5RWyCK1hP9m2p5rVm9sCBEhbrg9BHJuH" +
       "lMcHnd2El5CROe67eV4v4gGwYTv0JDBwRlgvm+JgYM4jDtR8hidWfWEKdsMi" +
       "VPQ3FC7ynTplwjwuGg3BZPq2PwLEuqb31+QaGkIJaIMtTQGGVjvNuqpRmN+W" +
       "MwWh5cfjcddLkGUcSpEAd1uooOcA2BmGg7QlB24rLsKovkpmm2lEtKgYoHUN" +
       "Vak8Ezois8KBtThNvQY1JHbBYFmo5GC+1Botxuk0maYzl7eIMsms2Y4iRsgI" +
       "nHm82oUNiu5IQ7/fldDBGgKljtFamQzfyRZma9NIUmhliUBkSvwQmWF9SkHt" +
       "LMUazCRphqjF9Yh5b0yG4aLtA/5kjiO8PWq2emSgk2QG26POKDF8bAhaIirM" +
       "x3k9ySy3rayGmCOYs9GIFovem3ZU/HdxaOYUbqzVp1sSGeCowkl4IHfQDM/7" +
       "JILWeazbowG8DWj1mWSGu1W/2xaS7jSPGg0TyOh6TMW5qRsOk2/R3rA+7ywh" +
       "QVnFO9N2Fk3cwF2LHSyV2UpI2RXKMPVCJbZ8LFh+skDGBhGMulSgYo4Cp/po" +
       "2yVsezAYQEjHnM5Zadn1evJ6PWgpFsVgPcCayFJcBAwK76obJiH0fntMjYn6" +
       "AMciU59pcW5vB8NOPJqtJIvMIc5N5DE/pVu5jOlr22N3Un0DdRxnhM7aHcvm" +
       "ZI0axiPEr7f9ZRmJNlcWonSpmat2AVlR6ytq1kc76SKgV8xsGLN5U3HHzSW0" +
       "S8W8HvUaEtJh0xUgzfu9LdZBCaZYA+Tuip3ylDZcDmivY3bWJOoZSI/uYpC5" +
       "XZEiNUnihZDNIRxeK2RRsEmg0RhIGCOT2KzlNgym2CZ4IL2CWQPwQHzHEr6S" +
       "prt2ixws7Wk30mGQyJyA0i164fdkRk3iVe53AMGTg5QLeXkUdIsQrM/Kmk9N" +
       "+xbR7klLS1bVJNOkOTzxBYGPKAOcpoNJPAaJSSwUvrQw9AQW1VRF2svNDuOb" +
       "WeDPZH0DL5uBVux7eu6KXmy6YduypbxJDbZh5sETd7BqrDrNzN+FY12G3ByG" +
       "6xtpk4y7bJaqUFe3BpAOGAizYDWkl4NSL14NBzPX0IdkSoyyhUhtF8AIzjGj" +
       "N26zOYr32pk5dzomBOTbAB+3+QWCjZOsY2CLiPI6zeEyRqbbBQl7QYK4sbwg" +
       "9WGMjIbsytiSk7Xd5nFyCXmovBpYu4aet2NfDENvpUV1wXdpNF0hLhusdAIx" +
       "SMjDhnKXIqO8E4hzF8Em2mYIjAr+Mw2f5r6bIhnZotDJmkSWWBtBlQ2+6NM9" +
       "Qbbk1bxOQPIUIvAdOmURH5nPO9C4Ifm9aMwupi2kCc+MuYauEWDppBAsRqmj" +
       "SmqCTAICSVq7JMLpTQRlPIUvcjXb8vws1kd4Mqb7hownck4ia14azpRpa8uJ" +
       "/SmqsJnFMTNIk/FxYOzokLDHPVmgBp3ARBqUO9CTnAdaoJ8Mtg2IBfM6N3WE" +
       "TYOeBgmmzqbTlAKhTBsP+DabCIsxjMsst5vFAtVMFKdfbIlkA1p1+WLXNuRh" +
       "FkrlYvu7rYMrqd5hCuoVPQjsDcwHI1vdcAN3BrWSMWVMfARFWmyxCTYW4Wga" +
       "2G48Tz0MFVJusvMGbIeqj107aQlt0m3B8HLbQbpub9IZr+bKJl8AkRTtlOZs" +
       "0/GlVXvRxbptvClFYdKe7hoZbizHi3k92vUm9am40ADIbklq7I0HTKyHWnsO" +
       "TZ0RsExNesqvFXQpJTGXt5oaCW5a7IRNt0Z9Z3FOPAeLvhi4CbOa3ZvgkmW3" +
       "LR7QJIYKxqs6TVGSNge7FM37srxEca6XDno+PRlscqRrtftTttfaejbAN3qZ" +
       "3YG9dWzww5WB8rjueM4GYGcYsQb40GuRiF1HNLkl4DQghqLvg/lw3YLgvjEd" +
       "ruV83mFoU5nChSDb7Rhj+l1hoyzkVWz6nU5bUYG6C8rt/krZjedKtz9TLIN1" +
       "Xcap5z1hxgSs0+hAEVGf8gAkOHF9R8N0cztFthjaJ2My1LApNRqxImgb9qjt" +
       "gY3VQAtCdgaoXdvT5j0AWDL1fheBiuhiJ4+NeXftDKy835t1cUBYbmf+ju7M" +
       "rJ2BSoKQEE27v2hyczefm3oqDXiT50OYpkUuJGWNbw479Drd5g6atpl0HqqT" +
       "9TIVvczJmyZgKythpPc50rAFYVF4Wt/wCFraRGtjXlcpfOzHGyvSsyZOEPVR" +
       "qllTC5ZcHlQaodjutdIGF4tQ3u4lnp2HdrNnoENOwsC4BSAKisqO4RALGC4f" +
       "X336zh6rPVQ9LTw+pPX/8ZwwvfWAh+UP");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("1U79XXRO4tS75IOjh+pP3nQipnptwHCj46N55VuIN190Zqt6A/HpDz33vDL/" +
       "5ealw4fGVli7L3S9v26psWqdGvW1Vf7Zs29fy5eEP3fI8cfOPx8+AejW7x72" +
       "D4f3KJ97in3XfkKO38CWgiYt+bri2tfhMPSPKq7f9kzQtYmjqE64v7nVU9B7" +
       "Jde1VNGp+Pg35/g4OAv4I0dvMSbzYSqrXvm2oWr3G2Xy+bB2JSnHKQa/5fPW" +
       "2NWVE4X5l7d71Hr6cf6twO8X16cOwf+Hrz745e2vl8kXyuTfVaRfvjU+5e1v" +
       "VgRfKZP/WMxYBQS61S3FV50CkLL8iyfCf+mVCl9q3n8+FP7LPzjNe+S05qGu" +
       "bav712CnMPnq7TD5kzL5g1PKcQ6LP3ylWJDF9d1DLL77Q7JCVk3PA/FntwPi" +
       "W2XypxcD8fVXQyn+8hCI77+KQFyuqC6Xt988EfpE8r+4neTfL5M/v1jy77wK" +
       "kh9Q+7YH8x+cCjx2xhwGMAsz+9NjZ1Xh4J7bAHJwtUwOLgTk4NKrAcjuEBDv" +
       "h+QfykP2N/mHg0fP9XDpZJzfPOqmcdE6VqzlI1/0trocgINzq87BY2XywMUg" +
       "PvgqrDAH//gQxH/06oNY8vi6c2hdewm0yvo3VlTvKJO33HaZOXjrK0XgxwrJ" +
       "P3OIwGdeRQROGcQXKonOn6C8yWLKY5QH9ULjKpEHrhyVujZWRWV/sO+U1O9+" +
       "NYzni4dS/9YPzngePW08RxKd04f3vCx9KN+WH/QutgTo1UDkPx0i8qUfEiKk" +
       "q1TngM8hMn1ZiJSHKw6GFyOCvQJEHi4LHy+Q+KNDRP7oDhA5eFlGMaqEWJ8j" +
       "OHW45UAoE6YQsIzJwSBUqmYnArKvVMBpAeqVfdv9751M+Ttf9pQ/eH7Kjyru" +
       "P9ps7PcuJwqgXAjb4dwbZXLj4rl//51Akxb7wePdVHlE/LGbPtTaf1wkf/b5" +
       "B6684fnlf92fajz6AOg+onZFiyzr9IneU/l7PF/V9Aqo+/bne71Khl1Ye8MF" +
       "i2J5WLfKlLweeHv68BDJ0/Rh7e7q9zRdEtauntAVXe0zp0nysHZXQVJmP+Ad" +
       "T9PJoZ39weZ0vyt87LQGVbHcw7dD97jJ6W8QytNu1YdyRyfTov2ncjfkzz0/" +
       "JT/w7e4v77+BkC0xz8terhC1e/efY1Sdlqfb3nZhb0d93TN++nv3/+p9bz/a" +
       "7N+/Z/hEm0/x9pZbf2QwtL2w+iwg/9dv+LX3/NPnv1qdWvp/7Ny6nsE4AAA=");
}
