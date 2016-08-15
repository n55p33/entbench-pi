package org.apache.batik.css.engine.value.svg;
public abstract class GlyphOrientationManager extends org.apache.batik.css.engine.value.AbstractValueManager {
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return false; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_ANGLE; }
    public org.apache.batik.css.engine.value.Value createValue(org.w3c.css.sac.LexicalUnit lu,
                                                               org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException { switch (lu.getLexicalUnitType(
                                                         )) {
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_INHERIT:
                                                    return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                                                             INHERIT_VALUE;
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_DEGREE:
                                                    return new org.apache.batik.css.engine.value.FloatValue(
                                                      org.w3c.dom.css.CSSPrimitiveValue.
                                                        CSS_DEG,
                                                      lu.
                                                        getFloatValue(
                                                          ));
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_GRADIAN:
                                                    return new org.apache.batik.css.engine.value.FloatValue(
                                                      org.w3c.dom.css.CSSPrimitiveValue.
                                                        CSS_GRAD,
                                                      lu.
                                                        getFloatValue(
                                                          ));
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_RADIAN:
                                                    return new org.apache.batik.css.engine.value.FloatValue(
                                                      org.w3c.dom.css.CSSPrimitiveValue.
                                                        CSS_RAD,
                                                      lu.
                                                        getFloatValue(
                                                          ));
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_INTEGER:
                                                    {
                                                        int n =
                                                          lu.
                                                          getIntegerValue(
                                                            );
                                                        return new org.apache.batik.css.engine.value.FloatValue(
                                                          org.w3c.dom.css.CSSPrimitiveValue.
                                                            CSS_DEG,
                                                          n);
                                                    }
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_REAL:
                                                    {
                                                        float n =
                                                          lu.
                                                          getFloatValue(
                                                            );
                                                        return new org.apache.batik.css.engine.value.FloatValue(
                                                          org.w3c.dom.css.CSSPrimitiveValue.
                                                            CSS_DEG,
                                                          n);
                                                    }
                                            }
                                            throw createInvalidLexicalUnitDOMException(
                                                    lu.
                                                      getLexicalUnitType(
                                                        ));
    }
    public org.apache.batik.css.engine.value.Value createFloatValue(short type,
                                                                    float floatValue)
          throws org.w3c.dom.DOMException {
        switch (type) {
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_DEG:
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_GRAD:
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_RAD:
                return new org.apache.batik.css.engine.value.FloatValue(
                  type,
                  floatValue);
        }
        throw createInvalidFloatValueDOMException(
                floatValue);
    }
    public GlyphOrientationManager() { super(
                                         );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAMUZa2wUx3nu/MBP/AAD4WEwGCIT5y6UkDYxSWMbG5ucH8KA" +
       "WpNwzO3N3S3e21125+wzhJYgVTiVQhElCU0b+geapEoCqhK1VZvIVaRCRBqJ" +
       "FJUmUUilVip90ARVSn/QNv1mZvf2cb6zXBX1pJ3bm/m+b77XfI+5l2+gMtNA" +
       "zUSlITqpEzPUo9JhbJgk3q1g09wBc1Hp2RL89z3XB+8PovJRND+FzQEJm6RX" +
       "JkrcHEUrZNWkWJWIOUhInGEMG8QkxjimsqaOoibZ7E/riizJdECLEwawCxsR" +
       "1IApNeRYhpJ+iwBFKyLASZhzEu70L3dEUI2k6ZMO+BIXeLdrhUGmnb1Miuoj" +
       "+/A4DmeorIQjskk7sga6S9eUyaSi0RDJ0tA+ZZOlgm2RTXkqWH2+7rNbx1P1" +
       "XAULsKpqlItnbiempoyTeATVObM9Ckmb+9HXUEkEVbuAKWqN2JuGYdMwbGpL" +
       "60AB97VEzaS7NS4OtSmV6xJjiKIWLxEdGzhtkRnmPAOFCmrJzpFB2lU5aYWU" +
       "eSI+fVf45LN76n9UgupGUZ2sjjB2JGCCwiajoFCSjhHD7IzHSXwUNahg7BFi" +
       "yFiRD1iWbjTlpIppBsxvq4VNZnRi8D0dXYEdQTYjI1HNyImX4A5l/SpLKDgJ" +
       "si5yZBUS9rJ5ELBKBsaMBAa/s1BKx2Q1TtFKP0ZOxtZHAABQ56UJTWm5rUpV" +
       "DBOoUbiIgtVkeARcT00CaJkGDmhQtLQgUaZrHUtjOEmizCN9cMNiCaAquSIY" +
       "CkVNfjBOCay01Gcll31uDG4+dlDtU4MoADzHiaQw/qsBqdmHtJ0kiEHgHAjE" +
       "mvWRZ/CiN6aCCAFwkw9YwPz48ZsPtzdPXxQwy2aAGYrtIxKNSmdi8y8v7267" +
       "v4SxUaFrpsyM75Gcn7Jha6Ujq0OEWZSjyBZD9uL09l9+9fAPyV+CqKoflUua" +
       "kkmDHzVIWlqXFWJsJSoxMCXxflRJ1Hg3X+9H8+A9IqtEzA4lEiah/ahU4VPl" +
       "Gv8NKkoACaaiKniX1YRmv+uYpvh7VkcI1cODmuBZh8SHf1Okh1NamoSxhFVZ" +
       "1cLDhsbkN8MQcWKg21Q4Bl4/Fja1jAEuGNaMZBiDH6SItSCZDDYJPIXHsZIh" +
       "YXM8Gd6qTOqpIUMGIvzMDGAVnMMIMc/T/w97ZpkeFkwEAmCi5f4AocDZ6tOU" +
       "ODGi0slMV8/NV6OXhPOxA2NpkKIHgY2QYCPE2QgBGyHBRoizEQI2QgXYQIEA" +
       "330hY0c4B5h2DIIEROmatpHHtu2dWl0CXqlPlIJdGOhqT7bqdiKJHf6j0rnG" +
       "2gMt1za8FUSlEdSIJZrBCks+nUYSwpo0Zp38mhjkMSedrHKlE5YHDU0icYhm" +
       "hdKKRaVCGycGm6dooYuCnezYsQ4XTjUz8o+mT008sevr9wRR0JtB2JZlEPwY" +
       "+jCL+7n43uqPHDPRrTt6/bNzzxzSnBjiSUl2Js3DZDKs9vuHXz1Raf0q/Hr0" +
       "jUOtXO2VEOMpBieA8Nns38MTojrscM9kqQCBE5qRxgpbsnVcRVOGNuHMcMdt" +
       "YEOT8GHmQj4GeaZ4cER//rfv/mkj16SdVOpc1cAIoR2uQMaINfKQ1eB45A6D" +
       "EID76NTwt5++cXQ3d0eAWDPThq1s7IYABtYBDX7j4v73P7525krQcWEKmTwT" +
       "g4Ioy2VZ+Dl8AvD8mz0s+LAJEYQau61IuCoXCnW28zqHNwiKCgQJ5hytO1Vw" +
       "Qzkh45hC2Pn5Z93aDa//9Vi9MLcCM7a3tM9OwJm/owsdvrTnH82cTEBiSdnR" +
       "nwMmIv0Ch3KnYeBJxkf2ifdWfOcCfh5yBsRpUz5AeOhFXB+IG3AT18U9fLzX" +
       "t/ZFNqw13T7uPUau4ikqHb/yae2uT9+8ybn1Vl9uuw9gvUN4kbACbPYIsgZP" +
       "KmCri3Q2Ls4CD4v9gaoPmykgdu/04KP1yvQt2HYUtpUgQJtDBgTPrMeVLOiy" +
       "eR/84q1Fey+XoGAvqlI0HO/F/MChSvB0YqYg7mb1Lz8s+JiosBNVFuVpKG+C" +
       "WWHlzPbtSeuUW+TATxa/tvmF09e4W+qCxjI3wXV8bGNDO58Pste7KarAMYgO" +
       "wGw2pzf+qSuiNy95A60oVOXwCu3MkZOn40NnN4hapNFbOfRAYfzKb/71TujU" +
       "796eIRlVUk2/WyHjRHHtWc629CSNAV4AOoHro/knfv/T1mTXXPIFm2ueJSOw" +
       "3ytBiPWF47+flQtH/rx0x0OpvXMI/St96vSTfGng5be3rpNOBHm1K6J+XpXs" +
       "RepwKxY2NQiU9SoTk83U8oOzJucAC2yjt1sO0O4/OCJGz+hYAe5YjjdxL6kq" +
       "QqxIpPhKkbVRNmynaAH0o2oKOhcIppDDeHPirSqY5Ucy4ObDhpyGrDBuFdJf" +
       "GN4rTbUO/0E45h0zIAi4phfDT+26uu8dbsIK5jM5xbn8BXzLlcvq2RBih6Ot" +
       "SFvq5Sd8qPHjse9df0Xw4+8CfMBk6uQ3Pw8dOykOjWiV1uR1K24c0S75uGsp" +
       "tgvH6P3juUM/e/HQ0aCl920UzYtpmkKwmrNLIFfMLfRqUfC65cm6nx9vLOmF" +
       "49iPKjKqvD9D+uNel5xnZmIutTrdleOgFtcsnVIUWG/HuS+xYUS8b/4vQyyb" +
       "6NL5/KD3GNwJz0bLczcWOQZs2Jnv9IVQizi2WWQtwwbozhbKZqcqpzFlmd32" +
       "era2x1GJdrtUshaeByy5Hpi7SgqhFhH7cJG1I2w4CLWVzO4yuO8WUMjjt0Eh" +
       "LE2iZng6Lak6566QQqhFhH6qyNq32DAF1VGSUFsTuUr7Uevks6+o6x2qwBLZ" +
       "uptynWj2M+U6Zk/eBhU2sLXl8PRZeuibuwoLofrUFBSlD/+9hKJlrNWd2Cjx" +
       "DtfEUihCsrKElZ2qTG2YtcXa4e6RkR7+xln8vm83OypalJbYu8W1dGjL0EBP" +
       "ViI6KwU48lk2PEdRtWQQ6At2sUbbxrxz9pbcged2+u7tslMLPGlL2em526kQ" +
       "ahE7FfHYMqirjWI+Www3AVV6AVwuyGszW5P9/AEHmGbDOYrqhcV6GT1uBjb/" +
       "kmOL8/8LW2QpWlzgyoX1B0vyboPFDab06um6isWnd17llXDulrEG6phERlFc" +
       "+dedi8t1gyRkLmSN6Kl0/nVxluOQux2CYAIjl+WCQL1EUcusqGCV8ZwfW4jv" +
       "Wse0ACI03+LFjXMZEuRMOMAWjG7IK2A+PyRwwb/dcFcpqnLgYFPx4gb5AKgD" +
       "CHv9ULdP7n2zq6vT6r+461gmzQbyOzjuS02z+ZKrK1vjKTz5vwp2ZZYR/ytE" +
       "pXOntw0evHnfWXGdIin4wAFGpRrqMXFpk2tKWgpSs2mV97Xdmn++cq1dKHqu" +
       "c9y8cY+Go8SvPpb67hfM1tw1w/tnNr/5q6ny96DE3Y0CGEr93a47fXGB3ZHV" +
       "M9AN7o7k153QwPGLj4625yYfak988iFvjpGoU5cXho9KV1547NcnlpxpDqLq" +
       "flQGNTDJjqIq2dwyqW4n0rgximplsycLLAIVGSueonY+O2SY/d/A9WKpszY3" +
       "y+7ZKFqdX6rn305WKdoEMbq0jBpnZKAsrnZmPH93WAe3KqPrPgRnxtWdJEUs" +
       "ZNYAr41GBnTdvqQq7dJ5yEnNHBrZ+Df+yoZP/gObsJ4acRwAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Nz8j+z9DOdtknicAAA==");
}
