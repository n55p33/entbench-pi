package org.apache.batik.parser;
public class AngleParser extends org.apache.batik.parser.NumberParser {
    protected org.apache.batik.parser.AngleHandler angleHandler = org.apache.batik.parser.DefaultAngleHandler.
                                                                    INSTANCE;
    public void setAngleHandler(org.apache.batik.parser.AngleHandler handler) {
        angleHandler =
          handler;
    }
    public org.apache.batik.parser.AngleHandler getAngleHandler() {
        return angleHandler;
    }
    protected void doParse() throws org.apache.batik.parser.ParseException,
        java.io.IOException { angleHandler.startAngle();
                              current = reader.read();
                              skipSpaces();
                              try { float f = parseFloat();
                                    angleHandler.angleValue(f);
                                    s: if (current != -1) { switch (current) {
                                                                case 13:
                                                                case 10:
                                                                case 32:
                                                                case 9:
                                                                    break s;
                                                            }
                                                            switch (current) {
                                                                case 'd':
                                                                    current =
                                                                      reader.
                                                                        read(
                                                                          );
                                                                    if (current !=
                                                                          'e') {
                                                                        reportCharacterExpectedError(
                                                                          'e',
                                                                          current);
                                                                        break;
                                                                    }
                                                                    current =
                                                                      reader.
                                                                        read(
                                                                          );
                                                                    if (current !=
                                                                          'g') {
                                                                        reportCharacterExpectedError(
                                                                          'g',
                                                                          current);
                                                                        break;
                                                                    }
                                                                    angleHandler.
                                                                      deg(
                                                                        );
                                                                    current =
                                                                      reader.
                                                                        read(
                                                                          );
                                                                    break;
                                                                case 'g':
                                                                    current =
                                                                      reader.
                                                                        read(
                                                                          );
                                                                    if (current !=
                                                                          'r') {
                                                                        reportCharacterExpectedError(
                                                                          'r',
                                                                          current);
                                                                        break;
                                                                    }
                                                                    current =
                                                                      reader.
                                                                        read(
                                                                          );
                                                                    if (current !=
                                                                          'a') {
                                                                        reportCharacterExpectedError(
                                                                          'a',
                                                                          current);
                                                                        break;
                                                                    }
                                                                    current =
                                                                      reader.
                                                                        read(
                                                                          );
                                                                    if (current !=
                                                                          'd') {
                                                                        reportCharacterExpectedError(
                                                                          'd',
                                                                          current);
                                                                        break;
                                                                    }
                                                                    angleHandler.
                                                                      grad(
                                                                        );
                                                                    current =
                                                                      reader.
                                                                        read(
                                                                          );
                                                                    break;
                                                                case 'r':
                                                                    current =
                                                                      reader.
                                                                        read(
                                                                          );
                                                                    if (current !=
                                                                          'a') {
                                                                        reportCharacterExpectedError(
                                                                          'a',
                                                                          current);
                                                                        break;
                                                                    }
                                                                    current =
                                                                      reader.
                                                                        read(
                                                                          );
                                                                    if (current !=
                                                                          'd') {
                                                                        reportCharacterExpectedError(
                                                                          'd',
                                                                          current);
                                                                        break;
                                                                    }
                                                                    angleHandler.
                                                                      rad(
                                                                        );
                                                                    current =
                                                                      reader.
                                                                        read(
                                                                          );
                                                                    break;
                                                                default:
                                                                    reportUnexpectedCharacterError(
                                                                      current);
                                                            }
                                    }
                                    skipSpaces(
                                      );
                                    if (current !=
                                          -1) {
                                        reportError(
                                          "end.of.stream.expected",
                                          new java.lang.Object[] { new java.lang.Integer(
                                            current) });
                                    } }
                              catch (java.lang.NumberFormatException e) {
                                  reportUnexpectedCharacterError(
                                    current);
                              }
                              angleHandler.
                                endAngle(
                                  ); }
    public AngleParser() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVYe4xUVxk/M/t+L8trpbDA7oJZSmdAi9gsYmG7C0tnH7J0" +
       "EwfLcObeMzOXvXPv5d5zd2cXV1vUgP2DIAKlDaX+QYMSWpqmpBptg2m0baom" +
       "bfFRTanRP0QrscRYjaj1O+e+7+wMkthN7tk753zn+873+n3fuReuoypDRx1E" +
       "oTE6rREj1q/QUawbROyTsWHsgrmU8GgF/uuea8P3RFF1EjXnsDEkYIMMSEQW" +
       "jSRaJikGxYpAjGFCRLZjVCcG0ScxlVQliRZKxmBekyVBokOqSBjBONYTaB6m" +
       "VJfSJiWDNgOKliXgJHF+kviW8HJvAjUKqjbtkbf7yPt8K4wy78kyKGpN7MOT" +
       "OG5SSY4nJIP2FnR0p6bK01lZpTFSoLF98gbbBDsSG4pM0Plsywc3j+ZauQnm" +
       "Y0VRKVfP2EkMVZ4kYgK1eLP9Mskb+9GXUEUCNfiIKepOOELjIDQOQh1tPSo4" +
       "fRNRzHyfytWhDqdqTWAHomhlkImGdZy32YzyMwOHWmrrzjeDtitcbS0ti1Q8" +
       "cWf8+KN7Wp+rQC1J1CIpY+w4AhyCgpAkGJTk00Q3togiEZNongLOHiO6hGVp" +
       "xvZ0myFlFUxNcL9jFjZpakTnMj1bgR9BN90UqKq76mV4QNm/qjIyzoKuizxd" +
       "LQ0H2DwoWC/BwfQMhrizt1ROSIpI0fLwDlfH7vuBALbW5AnNqa6oSgXDBGqz" +
       "QkTGSjY+BqGnZIG0SoUA1ClaUpIps7WGhQmcJSkWkSG6UWsJqOq4IdgWihaG" +
       "yTgn8NKSkJd8/rk+vOnIAWW7EkUROLNIBJmdvwE2dYQ27SQZohPIA2tj45rE" +
       "SbzoxcNRhIB4YYjYonnhizfuXdtx+VWL5o45aEbS+4hAU8LZdPMbS/t67qlg" +
       "x6jVVENizg9ozrNs1F7pLWiAMItcjmwx5ixe3vnjzz90nrwXRfWDqFpQZTMP" +
       "cTRPUPOaJBN9G1GIjikRB1EdUcQ+vj6IauA9ISnEmh3JZAxCB1GlzKeqVf4b" +
       "TJQBFsxE9fAuKRnVedcwzfH3goYQqoEHNcLTgaw//p+i8XhOzZM4FrAiKWp8" +
       "VFeZ/kYcECcNts3F0xD1E3FDNXUIwbiqZ+MY4iBH7AWN5ZcOeZ2VCc81Pcbi" +
       "S/vIOBeYTvOnIhEw99JwssuQJ9tVWSR6Sjhubu2/8UzqdSuQWPDb1qCoC4TF" +
       "LGExLixmCYv5hKFIhMtYwIRa7gRnTEBaA6429ow9uGPv4c4KiCNtqhIsyUg7" +
       "A/Wlz8t9B7BTwsW2ppmVV9e/HEWVCdSGBWpimZWLLXoWgEiYsHO1MQ2VxysA" +
       "K3wFgFUuXRWICPhTqhDYXGrVSaKzeYoW+Dg45YklYrx0cZjz/OjyqamHx7+8" +
       "LoqiQcxnIqsArtj2UYbULiJ3h3N9Lr4th659cPHkrOplfaCIOLWvaCfToTMc" +
       "BWHzpIQ1K/Cl1Iuz3dzsdYDKFEMWAeB1hGUEQKXXAWimSy0onFH1PJbZkmPj" +
       "eprT1SlvhofnPDYstCKVhVDogBzbPzOmPfGrn/3xk9ySThlo8dXvMUJ7fdDD" +
       "mLVxkJnnReQunRCge+fU6DdPXD+0m4cjUHTNJbCbjX0AOeAdsODXXt3/9rtX" +
       "z16JeiFMofaaaWhhClyXBR/CXwSe/7CHwQWbsGCjrc/GrhUueGlM8mrvbABj" +
       "MiQ8C47uBxQIQykj4bRMWP78q2XV+kt/PtJquVuGGSda1t6agTf/sa3oodf3" +
       "/L2Ds4kIrIx69vPILGye73Heout4mp2j8PCbyx57BT8BKA/IakgzhIMl4vZA" +
       "3IEbuC3W8fHu0NpGNqwy/DEeTCNfu5MSjl55v2n8/Zdu8NMG+yW/34ew1mtF" +
       "keUFEBZD9hAAb7a6SGPj4gKcYXEYqLZjIwfM7r48/IVW+fJNEJsEsQKArTGi" +
       "A0QWAqFkU1fV/PqHLy/a+0YFig6gelnF4gDmCYfqINKJkQN0LWifvdc6x1Qt" +
       "DK3cHqjIQkUTzAvL5/Zvf16j3CMz3138/KZzZ67ysNQsHne4CLs0gLC8NfeS" +
       "/PxbG39+7hsnp6zi3lMa2UL72v85IqcP/u4fRX7hmDZH4xHan4xfOL2kb/N7" +
       "fL8HLmx3d6G4SAFAe3s/cT7/t2hn9Y+iqCaJWgW7FR7HssnyOgntn+H0x9Au" +
       "B9aDrZzVt/S64Lk0DGw+sWFY84ojvDNq9t4UisFm5sJt8HTZMdgVjsEI4i87" +
       "+JbVfOxhw1oHXeo0XaVwSiIWXLY8MprKsKWoEbOqvB0rIuAN39gOxaFsCbeJ" +
       "LQBm46fZcL8ldtNc0VsocWr2epd3XP5XXSYTfQGLWFYuK9Xp8i797MHjZ8SR" +
       "p9ZbIdsW7B774XL09C/+/ZPYqd++NkcTU0dV7S6ZTBLZJ7OCiQwkyRC/BHgR" +
       "907zsd9/rzu79XY6EDbXcYseg/1eDkqsKZ134aO8cvBPS3Ztzu29jWZiecic" +
       "YZbfGbrw2rbVwrEov/FYqVB0Uwpu6g0mQL1O4Gqn7AqkQZcbAA3MsRvgWWcH" +
       "wLpwGnhBt5oN48FQry+zNVRpIl4Efo5zzZYpRRIb0lBJ4FLgTwGjLBKO6lIe" +
       "uotJ+woVn217d+L0taetcAzDXoiYHD7+yIexI8et0LQupV1F90L/Hutiyo/b" +
       "yoYYS5CV5aTwHQN/uDj7/W/PHoraqiYpqpxUJdFLbKFMYv8PZYlNbNX4/B7X" +
       "W+1s7ePwbLS9tfH2HV1qaxk/HiizNsuGSfBxNuhjHiGeNaY+Amtw9F8Kz2Zb" +
       "pc23sMZQMcKX2lpG48OhtShfizpFYHWpIsCvcP0FgWgungC51QFKamxwxF3j" +
       "Yh5hw1coqhFVvpP9VDyDfvX/YdACRQ2+6yXrhdqLvlVZ31eEZ8601C4+88Av" +
       "OUa730AaAW0zpiz7q7XvvVrTSUbi+jRatVvj/05StLiEnVjDz1/4oU9Y9I9R" +
       "1Bqmp6iK//fTnaao3qMDVtaLn+RJiiqAhL1+S7tl5R422Zc3yzyFSLCQur5Y" +
       "eCtf+GpvVwD4+PdDp2yY1hdEuJCf2TF84MannrKuYYKMZ2YYl4YEqrEue27p" +
       "WVmSm8OrenvPzeZn61Y5QBW4BvrPxiMCoJ1fmZaE7iVGt3s9efvsppd+erj6" +
       "TYDY3SiCIYJ3F7d8Bc2Emr874VV93/dnfmHq7Xl8evPazF9+w5tqVNRKh+lT" +
       "wpVzD751rP0sXKwaBlEVYDAp8F70vmllJxEm9SRqkoz+AhwRuEhYHkS1piLt" +
       "N8mgmEDNLGAx+7LI7WKbs8mdZfdzijqLS0XxVw24gEwRfatqKiIvxtAmeDOB" +
       "D5tO9TY1LbTBm3FduaBY95Rw39dbfnC0rWIAki6gjp99jWGm3c7A/63TaxXs" +
       "ysb8DNGfSgxpmnNtrtqjWVnwnEXD5imKrLFnQzX/Emf3PH9lwwv/BVC0nYnG" +
       "GAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "7dV97d6Zf9gf3BKBj9ysY/wqvvK2XQ9nxWMHJyf579zLnMoeObmCsi/X+292" +
       "+ZN/tT7/nmefU4afLu3snfiJIXQhdL2ft9S1ah1hdRpwetPNv9D7+d3X4UnU" +
       "V97zT/dNn9CffBVn7Q+ekPMky9/uv/C19hvkD+1Apw/Opa67lTs+6Orx06iL" +
       "vhpGvjM9diZ1/4Flb80sVgVPcc+yxRufd9/4QCr3gu3anzhQPXVIQOYE73yZ" +
       "E9d3ZUUcQpcCNcRPHme97YjHPBlCZ9auoRy6UvJKBwZH58obwgPd780a3wge" +
       "dE939P9G96Oqvf9l+n49K94L1F4cVzs32qGKz/wUKuZHjq8HzxN7Kj7xalVs" +
       "vaKKHzvRt5P37eyf5b3hZmeR+R0YkciqdxAkgHx7oG+4u9TwoC+f5hNZ8aEQ" +
       "Oq+4+cjs9elDK3341VgpCaFbj9zDZRcJ9153qb+9iJY//9ylW+55bvaX+VXU" +
       "wWXxBRq6RYss6+i575H6Oc9XNSOX+8L2FNjL/zwfQvfcxB7ZPU1eyaX9zS39" +
       "Z0Lo8kn6EDqb/z1K99kQunhIB1htK0dJPhdCpwFJVv2894oHxdtD0K15klPH" +
       "4fXA5ne9ks2PIPKjx3A0/0eLfcyLtv9qcU3+wnPdwTteqn16e3smW2KaZlxu" +
       "oaHz24u8A9x8+Kbc9nmd6zz+4zu+eOGxfYy/Yyvwobsfke3BG19PEbYX5hdK" +
       "6e/f87tv+cxz387Pgv8HcwMGoQEjAAA=");
}
