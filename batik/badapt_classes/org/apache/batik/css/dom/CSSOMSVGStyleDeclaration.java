package org.apache.batik.css.dom;
public class CSSOMSVGStyleDeclaration extends org.apache.batik.css.dom.CSSOMStyleDeclaration {
    protected org.apache.batik.css.engine.CSSEngine cssEngine;
    public CSSOMSVGStyleDeclaration(org.apache.batik.css.dom.CSSOMStyleDeclaration.ValueProvider vp,
                                    org.w3c.dom.css.CSSRule parent,
                                    org.apache.batik.css.engine.CSSEngine eng) {
        super(
          vp,
          parent);
        cssEngine =
          eng;
    }
    protected org.w3c.dom.css.CSSValue createCSSValue(java.lang.String name) {
        int idx =
          cssEngine.
          getPropertyIndex(
            name);
        if (idx >
              org.apache.batik.css.engine.SVGCSSEngine.
                FINAL_INDEX) {
            if (cssEngine.
                  getValueManagers(
                    )[idx] instanceof org.apache.batik.css.engine.value.svg.SVGPaintManager) {
                return new org.apache.batik.css.dom.CSSOMSVGStyleDeclaration.StyleDeclarationPaintValue(
                  name);
            }
            if (cssEngine.
                  getValueManagers(
                    )[idx] instanceof org.apache.batik.css.engine.value.svg.SVGColorManager) {
                return new org.apache.batik.css.dom.CSSOMSVGStyleDeclaration.StyleDeclarationColorValue(
                  name);
            }
        }
        else {
            switch (idx) {
                case org.apache.batik.css.engine.SVGCSSEngine.
                       FILL_INDEX:
                case org.apache.batik.css.engine.SVGCSSEngine.
                       STROKE_INDEX:
                    return new org.apache.batik.css.dom.CSSOMSVGStyleDeclaration.StyleDeclarationPaintValue(
                      name);
                case org.apache.batik.css.engine.SVGCSSEngine.
                       FLOOD_COLOR_INDEX:
                case org.apache.batik.css.engine.SVGCSSEngine.
                       LIGHTING_COLOR_INDEX:
                case org.apache.batik.css.engine.SVGCSSEngine.
                       STOP_COLOR_INDEX:
                    return new org.apache.batik.css.dom.CSSOMSVGStyleDeclaration.StyleDeclarationColorValue(
                      name);
            }
        }
        return super.
          createCSSValue(
            name);
    }
    public class StyleDeclarationColorValue extends org.apache.batik.css.dom.CSSOMSVGColor implements org.apache.batik.css.dom.CSSOMSVGColor.ValueProvider {
        protected java.lang.String property;
        public StyleDeclarationColorValue(java.lang.String prop) {
            super(
              null);
            valueProvider =
              this;
            setModificationHandler(
              new org.apache.batik.css.dom.CSSOMSVGColor.AbstractModificationHandler(
                ) {
                  protected org.apache.batik.css.engine.value.Value getValue() {
                      return StyleDeclarationColorValue.this.
                        getValue(
                          );
                  }
                  public void textChanged(java.lang.String text)
                        throws org.w3c.dom.DOMException {
                      if (handler ==
                            null) {
                          throw new org.w3c.dom.DOMException(
                            org.w3c.dom.DOMException.
                              NO_MODIFICATION_ALLOWED_ERR,
                            "");
                      }
                      java.lang.String prio =
                        getPropertyPriority(
                          property);
                      CSSOMSVGStyleDeclaration.this.
                        handler.
                        propertyChanged(
                          property,
                          text,
                          prio);
                  }
              });
            property =
              prop;
        }
        public org.apache.batik.css.engine.value.Value getValue() {
            return CSSOMSVGStyleDeclaration.this.
                     valueProvider.
              getValue(
                property);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "fvz7tNj/vOhi87X/AZaciIShFgAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL1Za+zsRnX3/Sf35uYScm8CCWlKntxAE6O/ve9dhVLs3fWu" +
           "d9dr73qfbsuN1+9dvz322qYpD4lCQaVRCY9KkE+gtig8VBW1UkWVqg9AoEpU" +
           "qC+pgKpKpaWo5ENpVdrSsff/vvcmwIeutLOzM+ecOWfmnN+cmXn+u8j5wEdQ" +
           "1zETzXTAvhKD/bVZ2QeJqwT7vUGFE/1AkZumGAQT2HZNevRzl7//g2f0K3vI" +
           "BQF5lWjbDhCB4djBWAkcM1LkAXL5uLVtKlYAkCuDtRiJWAgMExsYAXhygLzi" +
           "BCtArg4OVcCgChhUActVwIhjKsj0SsUOrWbGIdog8JBfRs4NkAuulKkHkEdO" +
           "C3FFX7QOxHC5BVDCxez/DBqVM8c+8vCR7TubrzP4Qyj27EfeeuV3b0EuC8hl" +
           "w+YzdSSoBICDCMgdlmKtFD8gZFmRBeQuW1FkXvEN0TTSXG8BuTswNFsEoa8c" +
           "TVLWGLqKn495PHN3SJltfigBxz8yTzUUUz78d141RQ3aeu+xrTsLqawdGnjJ" +
           "gIr5qigphyy3bgxbBshDZzmObLzahwSQ9TZLAbpzNNSttggbkLt3a2eKtobx" +
           "wDdsDZKed0I4CkDuv6nQbK5dUdqImnINIPedpeN2XZDq9nwiMhaA3HOWLJcE" +
           "V+n+M6t0Yn2+O3zTB95md+29XGdZkcxM/4uQ6cEzTGNFVXzFlpQd4x1PDD4s" +
           "3vuF9+4hCCS+5wzxjub3f+nFt7zxwRe+tKP56RvQsKu1IoFr0idWd37ttc3H" +
           "G7dkalx0ncDIFv+U5bn7cwc9T8YujLx7jyRmnfuHnS+M/3z5jk8p39lDLtHI" +
           "BckxQwv60V2SY7mGqfgdxVZ8ESgyjdyu2HIz76eR22B9YNjKrpVV1UABNHKr" +
           "mTddcPL/cIpUKCKbottg3bBV57DuikDP67GLIMgr4BfZh98psvvwWQEQGdMd" +
           "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" +
           "e2/6ree+kd8O/h9b2VdKViEAAA==");
    }
    public class StyleDeclarationPaintValue extends org.apache.batik.css.dom.CSSOMSVGPaint implements org.apache.batik.css.dom.CSSOMSVGColor.ValueProvider {
        protected java.lang.String property;
        public StyleDeclarationPaintValue(java.lang.String prop) {
            super(
              null);
            valueProvider =
              this;
            setModificationHandler(
              new org.apache.batik.css.dom.CSSOMSVGPaint.AbstractModificationHandler(
                ) {
                  protected org.apache.batik.css.engine.value.Value getValue() {
                      return StyleDeclarationPaintValue.this.
                        getValue(
                          );
                  }
                  public void textChanged(java.lang.String text)
                        throws org.w3c.dom.DOMException {
                      if (handler ==
                            null) {
                          throw new org.w3c.dom.DOMException(
                            org.w3c.dom.DOMException.
                              NO_MODIFICATION_ALLOWED_ERR,
                            "");
                      }
                      java.lang.String prio =
                        getPropertyPriority(
                          property);
                      CSSOMSVGStyleDeclaration.this.
                        handler.
                        propertyChanged(
                          property,
                          text,
                          prio);
                  }
              });
            property =
              prop;
        }
        public org.apache.batik.css.engine.value.Value getValue() {
            return CSSOMSVGStyleDeclaration.this.
                     valueProvider.
              getValue(
                property);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "dkcR19yyH/8+I/Y/K7rYfOO/ITVbwKEWAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL1Za+wjV3Wf3WQ3u0vIbgIJaUqebKCJ0X/s8VsBiufl8Yw9" +
           "Hntsj2faspmnZzxPz8tj05RHRaFBhaiERyXIJ1ALCg9VRa1UUaWqWkCgSlSo" +
           "L6mAqkqlpajkQ2lV2tI74/97d5PCh1ry9fW959x7zj3n/O659z7/fehcFEKl" +
           "wHc2C8eP9/Qs3ls69b14E+jRHt2vc3IY6RrmyFE0AW3X1Ee+cPmHP3rGvHIW" +
           "Oi9Br5I9z4/l2PK9aKxHvpPqWh+6fNRKOLobxdCV/lJOZTiJLQfuW1H8RB96" +
           "xTHWGLraPxABBiLAQAS4EAHuHFEBplfqXuJiOYfsxdEK+hXoTB86H6i5eDH0" +
           "8MlBAjmU3f1huEIDMMKF/P8MKFUwZyH00KHuO52vU/jDJfjZj77tyu/eAl2W" +
           "oMuWx+fiqECIGEwiQbe7uqvoYdTRNF2ToDs9Xdd4PbRkx9oWckvQXZG18OQ4" +
           "CfXDRcobk0APizmPVu52NdctTNTYDw/VMyzd0Q7+nTMceQF0vedI152GZN4O" +
           "FLxkAcFCQ1b1A5ZbbcvTYujB0xyHOl5lAAFgvc3VY9M/nOpWTwYN0F072zmy" +
           "t4D5OLS8BSA95ydglhi676aD5msdyKotL/RrMXTvaTpu1wWoLhYLkbPE0N2n" +
           "yYqRgJXuO2WlY/b5PvumD7zdo7yzhcyarjq5/BcA0wOnmMa6oYe6p+o7xtsf" +
           "739EvudL7zsLQYD47lPEO5rf/+UX3/rGB174yo7mZ29AM1SWuhpfUz+p3PGN" +
           "12KPtW/JxbgQ+JGVG/+E5oX7c/s9T2QBiLx7DkfMO/cOOl8Y/5n4zs/o3zsL" +
           "XepB51XfSVzgR3eqvhtYjh52dU8P5VjXetBF3dOwor8H3QbqfcvTd61Dw4j0" +
           "uAfd6hRN5/3iP1giAwyRL9FtoG55hn9QD+TYLOpZAEHQK8AX2gPf90C7z6/m" +
           "RQxpsOm7Oiyrsmd5PsyFfq5/BOterIC1NWEFeL0NR34SAheE/XABy8APTH2/" +
           "Q40iWPNdGOP54YCfdfl44+g4sBqI1lz1vdzbgv+nebJc3yvrM2eAKV57Gggc" +
           "EEOU72h6eE19NkGJFz937WtnDwNjf6ViqA+m3ttNvVdMvQem3gNT791s6qun" +
           "GzgZBO1MdhIdOnOmEObVuXQ7nwAWtQE2ANS8/TH+l+gn3/fILcAZg/WtwBw5" +
           "KXxz8MaO0KRXYKYKXBp64WPrd83eUT4LnT2JwrlGoOlSzs7l2HmIkVdPR9+N" +
           "xr383u/+8PMfeco/isMTsL4PD9dz5uH9yOm1D31V1wBgHg3/+EPyF6996amr" +
           "Z6FbAWYAnIzBouUQ9MDpOU6E+RMHkJnrcg4obPihKzt51wHOXYrN0F8ftRRO" +
           "cUdRvxOs8eXc7x8D3w/uB0Lxm/e+KsjLV++cKDfaKS0KSH4zH3zir//8n6rF" +
           "ch+g9+Vj+yGvx08cQ4x8sMsFNtx55AOTUNcB3d99jPvQh7//3l8oHABQvO5G" +
           "E17NSwwgRe5cfvier6z+5tvf+uQ3zx45TQy2zERxLDU7VPJCrtMdL6EkmO31" +
           "R/IAxHFANOZec3Xqub5mGZasOHrupf91+dHKF//lA1d2fuCAlgM3euPLD3DU" +
           "/jMo9M6vve3fHyiGOaPmO97Rmh2R7WD0VUcjd8JQ3uRyZO/6i/t/68vyJwAg" +
           "AxCMrK1e4NqZ/cDJhbobZCYFZ7657e02t8KacNH9eFHmGAgVTFDRV82LB6Pj" +
           "UXEy8I6lLNfUZ775g1fOfvBHLxZqnMx5jjvBQA6e2PldXjyUgeFfcxoCKDky" +
           "AV3tBfYXrzgv/AiMKIERVYB+0TAEKJWdcJl96nO3/e0f/8k9T37jFugsCV1y" +
           "fFkj5SL6oIvA7fXIBACXBT//1p3V17kfXClUha5Tfuct9xb/bgUCPnZz4CHz" +
           "lOUodu/9z6GjvPvv/+O6RSgg5wY79Sl+CX7+4/dhb/lewX8U+zn3A9n1yA3S" +
           "uyNe5DPuv5195PyfnoVuk6Ar6n7uWIAtiCgJ5EvRQUIJ8ssT/Sdzn91G/8Qh" +
           "tr32NO4cm/Y06hztGKCeU+f1S6eA5q58lR8B36f3Y/Dp00BzBioqnYLl4aK8" +
           "mhdvOIjri0Hox0BKXdsP7R+Dzxnw/Z/8mw+XN+w28ruw/WziocN0IgDb2QUw" +
           "RJGY5vzlHbTlZS0v0N2wzZv6y5vygszOAFnOIXvNvWIA5sby3pJXfw6AUVRk" +
           "1IDDsDzZKVaFjIH/O+rVAxlnIMPOd86l07yRXOT/WS7gt3cchXzfB9ns+//h" +
           "ma9/8HXfBs5FQ+fS3PDAp47hApvkCf6vPf/h+1/x7HfeX+AoWOzZOx/91yJd" +
           "mryUdnkxzAvuQK37crX4Imvpy1E8KKBP13LNXjqmuNBywQ6R7mev8FN3fdv+" +
           "+Hc/u8tMTwfQKWL9fc8+/eO9Dzx79th54HXXpeTHeXZngkLoV+6vcAg9/FKz" +
           "FBzkP37+qT/8nafeu5PqrpPZLQEOb5/9y//++t7HvvPVGyRStzrAGj+1YePb" +
           "v07Vol7n4NOviIa4nmTZ1Cg1Ta4ZpFzHMzqZ2Bmu0IrMEwJX7nXqtZ7FDasE" +
           "sZIVdEkZVDuiG1rb1VJjoE3GK98P8JY9oxmsayuwRWM9OiBm8hCZmux4LJT5" +
           "QAZVqmHPhOUUDgbIeISsXEd25iWYbXrhXM5ShmsK5ag0lFgEdg2jqrvNSsub" +
           "jGU6cbyuD29lkZVaQpddVriJ6NF8IMkVsiVuyvGAbWMtiout9mC6kssrfjti" +
           "KmNrFkRJi54i09WEs4XtkJ3aUlJxJwNxVtvIWxd36ESmQ3lCc9FUZsxV0MNM" +
           "eCaJIlFqWFJviUzVCkcjwYZNOutaY5qi/Lhv0T07rumuSXbdudblZLrSEntE" +
           "qysF2KYxbDuqxmhDe+TJat+1gqDHjEWDCRx7KXfDctWZ1aukUEtJvLGQ5qgS" +
           "891GMB1wqFVpqdVJJjfMUehOieokGeMcEg2iuVSxVT8ol2QOZ6xYHreWeICR" +
           "pLTQe0PRdVKiPIm6Nsamgt0GkdhGK4OoFtNzcYlz0zpr+iOq5o7r9HiIu+HE" +
           "j0x7Lq3FYV/bzOb8uitL+iyYC3aI9rPVRKDL5ZbR4OpIp+Qw9qZOui18yVOd" +
           "Hh4k9kjuRm5XcOOpILjS2uXGvqjXGAlzhFlXM/hUkvnKxqqujY0uePiIDRZB" +
           "Ox1X0LlIINNMqYWBRFotjxqE7UrdnMjjuu3pcL9hWzVK1dA1LpK4q7gMZ2kJ" +
           "MhHEqTAZzmx57nSFwVyEiQHO163+ElWQVoXfsOsFHmizjAhmfmkw6iZBSUBj" +
           "kqDQ7aguzPg5AxDbZ2nTdVWpPViMqspii874eGR2aybN1sVJH8XkTZnp8s6C" +
           "QpJmu1muk2QcZKJDTKztFhvNttuWQqYCRSYVcyiIG6vDeqKRriqo3YBL08l0" +
           "ynR0stFDGKreNLW02tcRuBWGeFS1ussx8CJ2UDO9wOgr25Cf02uxzOq9tTBq" +
           "qlOWapB1rM9kMSL5Ug/F8CG8RQmv1m7azqQMw+l66bQtaqr1kFHg23NF6NcI" +
           "tW07tTJJC9KwvuxOBiuJI2jZ5UUvM9Y9WZRKfNwVB9uVsKm4g2UdlVamuSpH" +
           "M3hKEkOBwRhkhaUy7mmNLJmSZR6WUBSTIhavpZ0WH2wNp0mZY6I2bWN0f9pz" +
           "VtYKjG2Xtbqi8gvclMrdsmmPhJSrb9YaGxFkeetLYKL1qMVsaWTUxyKz0ZoR" +
           "qktbCjW2qrUaza2QjSJ0KhYpTjmxqUvpxmhbrplSQ7dnEutM6q0JZjEabePK" +
           "TJDc8TKIlQwpteZbd6Ia9ABH1cm8yy9W1eU2lrJoPgUpWhOvpGRDaBlYpzSY" +
           "LoBlZkKl2zPJzO07tWGkemuGoTrjqOOxEUVnTVUzcGLUGdT8LVHBWhs06Axm" +
           "PB8GnZpFlYCdTK0xdPX5vBKWZVph+YDWmCojrurBOpbM5miChxHqZU0yZuZe" +
           "WRBQpdcLlu2JU18MeqSYuk1TFdIxLSW9Gl0d4FR/rZrtrrqi26YcNIw5bjc1" +
           "AaxxqTG0XdOpRZ24u6a2KmfX1l5ZqrisuWaWZFxKMnxbL9XUDE8WLY2UvB7f" +
           "QGdMpdtdKFjTZIWJPRNTf9N25l7Np+OJjsX4cK02em5aNTl+NQLHbVyXeAcd" +
           "TYYNQR6vlkunoVgsWc7aG7M1NuL1suRxaF/x17OOYZZEX0lKDBvBA1ZB1Zrh" +
           "t0tkQGMSTTbpWuYZsLDlqpm8YuP+kERQ3u1iLZnobLDudr4gPU5pKs3lVOo0" +
           "w+rWr8NN2QuXpfKcW0RTrT2XBz0pJqIOWysTVapabW/6CZzOlZIcT6rqui5V" +
           "ozoWzUYrrO1iA2+uj+ylqMgzmFqgNDnqECmvIIuOUlrpo6nrTCU0FuGkIkd6" +
           "yeEmVbFprHDMGmpdGYG5NQrDGalsNnREwbGYIsTInrBMaeutNyjseSV6U3Ux" +
           "Wcu84XQZVrV2KwvbpNfribjiLPs4io6pKrmkRhuEcG0kyqi1qsFMFg3F7mCO" +
           "VGVWX9LRyOolIiKGHIbZEinpHXK12gw0rr8aZ9Um54WOaWLLyF73hxHhs6Ko" +
           "pi3WlUae2F9by4pdX5EimsDSXJuXTCFsr4ml6y2YDrkQkIHbAZC2dmdqI1Lc" +
           "OQyvK4ZNVRF/UdYRe6IJQUojTAMbxjVOGTCLjuvUgHl0TTRGYdsnkx6/WhFh" +
           "FnS2fClWNM70oy5JCnIpLnWa7qahJhtF3VbRWh9r4k2pxyTonExNOHPazfp2" +
           "0EoNbj5wyEGCszKVaFjDNFritMlRBmxUmWDaXzDxeONPhCAbztOm7SeGg0da" +
           "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");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "IGwvyp8p0t+/73ff8pvPfzO/yPsffTRb9HUhAAA=");
}
