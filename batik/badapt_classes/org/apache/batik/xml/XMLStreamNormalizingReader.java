package org.apache.batik.xml;
public class XMLStreamNormalizingReader extends org.apache.batik.util.io.StreamNormalizingReader {
    public XMLStreamNormalizingReader(java.io.InputStream is, java.lang.String encod)
          throws java.io.IOException { super();
                                       java.io.PushbackInputStream pbis =
                                         new java.io.PushbackInputStream(
                                         is,
                                         128);
                                       byte[] buf = new byte[4];
                                       int len = pbis.read(buf);
                                       if (len > 0) { pbis.unread(
                                                             buf,
                                                             0,
                                                             len);
                                       }
                                       if (len == 4) { switch (buf[0] &
                                                                 255) {
                                                           case 0:
                                                               if (buf[1] ==
                                                                     60 &&
                                                                     buf[2] ==
                                                                     0 &&
                                                                     buf[3] ==
                                                                     63) {
                                                                   charDecoder =
                                                                     new org.apache.batik.util.io.UTF16Decoder(
                                                                       pbis,
                                                                       true);
                                                                   return;
                                                               }
                                                               break;
                                                           case '<':
                                                               switch (buf[1] &
                                                                         255) {
                                                                   case 0:
                                                                       if (buf[2] ==
                                                                             63 &&
                                                                             buf[3] ==
                                                                             0) {
                                                                           charDecoder =
                                                                             new org.apache.batik.util.io.UTF16Decoder(
                                                                               pbis,
                                                                               false);
                                                                           return;
                                                                       }
                                                                       break;
                                                                   case '?':
                                                                       if (buf[2] ==
                                                                             'x' &&
                                                                             buf[3] ==
                                                                             'm') {
                                                                           java.io.Reader r =
                                                                             org.apache.batik.xml.XMLUtilities.
                                                                             createXMLDeclarationReader(
                                                                               pbis,
                                                                               "UTF8");
                                                                           java.lang.String enc =
                                                                             org.apache.batik.xml.XMLUtilities.
                                                                             getXMLDeclarationEncoding(
                                                                               r,
                                                                               "UTF-8");
                                                                           charDecoder =
                                                                             createCharDecoder(
                                                                               pbis,
                                                                               enc);
                                                                           return;
                                                                       }
                                                               }
                                                               break;
                                                           case 76:
                                                               if (buf[1] ==
                                                                     111 &&
                                                                     (buf[2] &
                                                                        255) ==
                                                                     167 &&
                                                                     (buf[3] &
                                                                        255) ==
                                                                     148) {
                                                                   java.io.Reader r =
                                                                     org.apache.batik.xml.XMLUtilities.
                                                                     createXMLDeclarationReader(
                                                                       pbis,
                                                                       "CP037");
                                                                   java.lang.String enc =
                                                                     org.apache.batik.xml.XMLUtilities.
                                                                     getXMLDeclarationEncoding(
                                                                       r,
                                                                       "EBCDIC-CP-US");
                                                                   charDecoder =
                                                                     createCharDecoder(
                                                                       pbis,
                                                                       enc);
                                                                   return;
                                                               }
                                                               break;
                                                           case 254:
                                                               if ((buf[1] &
                                                                      255) ==
                                                                     255) {
                                                                   charDecoder =
                                                                     createCharDecoder(
                                                                       pbis,
                                                                       "UTF-16");
                                                                   return;
                                                               }
                                                               break;
                                                           case 255:
                                                               if ((buf[1] &
                                                                      255) ==
                                                                     254) {
                                                                   charDecoder =
                                                                     createCharDecoder(
                                                                       pbis,
                                                                       "UTF-16");
                                                                   return;
                                                               }
                                                       }
                                       }
                                       encod =
                                         encod ==
                                           null
                                           ? "UTF-8"
                                           : encod;
                                       charDecoder =
                                         createCharDecoder(
                                           pbis,
                                           encod);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "GVmHl/8D8/AhYG0RAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL05a8wj11Wz32Z3k81jN5snIc1zAyQu3/g1HlvbQsZjezz2" +
       "eMaPsT0eSrfz9njeL894QiCtVBJRKUQiKUFq8ysVqEqbClGBhIqCEFDUCqmo" +
       "4iVoKoREUYloflAQAcqd8ffe3VT0B5bmenzvOeee9z3n+o13oDOBDxVcx9xo" +
       "phPuKkm4uzKR3XDjKsFuj0KGgh8oMm4KQcCCuavSY1+68P33Xlpe3IHO8tBd" +
       "gm07oRDqjh2MlcAx14pMQRcOZ9umYgUhdJFaCWsBjkLdhCk9CK9Q0K1HUEPo" +
       "MrXPAgxYgAELcM4CjB1CAaTbFTuy8AxDsMPAg34ROkVBZ10pYy+EHj1OxBV8" +
       "wdojM8wlABRuzn7PgFA5cuJDjxzIvpX5GoFfKcAv//pHL/72aegCD13Q7UnG" +
       "jgSYCMEmPHSbpVii4geYLCsyD91pK4o8UXxdMPU055uHLgW6Zgth5CsHSsom" +
       "I1fx8z0PNXeblMnmR1Lo+Afiqbpiyvu/zqimoAFZ7z2UdSthJ5sHAp7XAWO+" +
       "KkjKPspNhm7LIfTwSYwDGS/3AQBAPWcp4dI52OomWwAT0KWt7UzB1uBJ6Ou2" +
       "BkDPOBHYJYQeuCHRTNeuIBmCplwNoftPwg23SwDqllwRGUoI3XMSLKcErPTA" +
       "CSsdsc879IdefMbu2js5z7IimRn/NwOkh04gjRVV8RVbUraItz1FfVq49ysv" +
       "7EAQAL7nBPAW5nd/4d2nP/jQW1/dwvz4dWAYcaVI4VXpdfGObzyIP9k4nbFx" +
       "s+sEemb8Y5Ln7j/cW7mSuCDy7j2gmC3u7i++Nf6TxXOfV767A50nobOSY0YW" +
       "8KM7JcdydVPxCcVWfCFUZBK6RbFlPF8noXPgndJtZTvLqGqghCR0k5lPnXXy" +
       "30BFKiCRqegceNdt1dl/d4Vwmb8nLgRB58AD3Qaey9D2k3+HkAgvHUuBBUmw" +
       "dduBh76TyR/Aih2KQLdLWAReb8CBE/nABWHH12AB+MFS2VtILBPmBhTwJEWw" +
       "aMe3skABTjVWBFnxdzNfc/9fdkkyWS/Gp04BMzx4MgmYIH66jglgr0ovR832" +
       "u1+8+rWdg6DY01IIZRvvbjfezTfeBRvv3nhj6NSpfL+7Mwa2JgcGM0Dog6R4" +
       "25OTn+997IXHTgNfc+ObgLYzUPjGuRk/TBZknhIl4LHQW6/GH5/9UnEH2jme" +
       "ZDOmwdT5DH2YpcaDFHj5ZHBdj+6F57/z/Tc//axzGGbHsvZe9F+LmUXvYyfV" +
       "6zuSIoN8eEj+qUeEL1/9yrOXd6CbQEoAaTAUgNuCDPPQyT2ORfGV/YyYyXIG" +
       "CKzmKs+W9tPY+XDpO/HhTG73O/L3O4GOb83c+gnwFPb8PP/OVu9ys/HurZ9k" +
       "RjshRZ5xPzxxP/vXf/7PlVzd+8n5wpHjbqKEV44khIzYhTz07zz0AdZXFAD3" +
       "968Of+2Vd57/udwBAMTj19vwcjbiIBEAEwI1f/Kr3t+8/a3Xv7lz6DQhOBEj" +
       "0dSl5EDIbB46/z5Cgt1+4pAfkFBMEG6Z11ye2pYj66ouiKaSeel/XXii9OV/" +
       "efHi1g9MMLPvRh/84QQO53+sCT33tY/++0M5mVNSdqAd6uwQbJsl7zqkjPm+" +
       "sMn4SD7+Fx/4jT8VPgvyLchxgZ4qedrayXWwk0t+T7iHqTu7pO1G4TYq99cu" +
       "5mvZuba7PddyS8P58lP5uJupcy8SryHItBNJcTMmczwkGx4OjkbT8YA9Uslc" +
       "lV765vdun33vD97NxT9eCh11noHgXtn6azY8kgDy951MHV0hWAK46lv0Ry6a" +
       "b70HKPKAogTSYsD4IOckx1xtD/rMub/9wz+692PfOA3tdKDzpiPIHSGPWugW" +
       "EC5KsAS5L3F/9umtt8Q3g+Fi9pZAB4qBcsVAydbL7s9/nQYMPnnjhNXJKpnD" +
       "mL//PxlT/MQ//Mc1SshT1XUO8BP4PPzGZx7Af+a7Of5hzsiwH0quTeqg6jvE" +
       "LX/e+redx87+8Q50jocuSnsl5UwwoywSeVBGBft1Jig7j60fL4m25/+Vg5z4" +
       "4Ml8dWTbk9nq8DAB7xl09n7+aIL6AficAs//ZE+m7mxiexBfwveqgUcOygHX" +
       "TU6B8D9T3kV3ixl+O6fyaD5ezoaf3Jope/0pkCeCvJYFGKpuC2a+cScELmZK" +
       "l/epz0BtC2xyeWWi2XJ5mw2zsZ6Db81/5Yau8vQWKj/27jiMOMoBdeSn/vGl" +
       "r//q428D+/WgM+tMt8BsR8KSjrLS+pffeOUDt7787U/lKQ6E4uy5J/41L1SG" +
       "7yddNvSzgdoX64FMrEleMVBCEA7yrKTImWTv77ZDX7dA8l7v1Y3ws5feNj7z" +
       "nS9sa8KTPnoCWHnh5V/5we6LL+8cqcQfv6YYPoqzrcZzpm/f07APPfp+u+QY" +
       "nX9689nf/61nn99ydel4XdkGbdMX/vK/v7776rf/7DplzE0msMaPbNjw/N91" +
       "qwGJ7X+oEieWY2mczFUGblTQXhombYRsp3JiC1S9yi7GrRllThmvKttDt7CA" +
       "A9rrc71QQdasrSZ2hFoNk1cKpYnQ64yKm8asSRiiwbhAandW7AgkvkJHG0+b" +
       "dJrz0VzvayRGqvoG19szCmkPaw0apSsRqtpauSDJ3RAdlGHFglULcLNORXlt" +
       "rATOKHcsXRwvZF4XbZ9td5lp1C/WFqXuVF36RB22SAqWo86qLEYsT5W7tKm4" +
       "Ua3ImsUyz+JpjRHJYUBvmuKsiATVeBaMZhKyQVZ4g13Iy/lKiwXRE3WL5COd" +
       "sNBNp6VRzIwvGoVOtS0225uY7TebBpfwZSewZIEZJjWxHdTkTsin02klKY7t" +
       "6mrgECMzZKb9oqs0Jj3FRTS7VaL6RL/O11mnWg19qybQjp5ym/Ha0hW83Yt7" +
       "dqSTo9FKrI0KEVc2K7jcCkga1KJlQylU61K5lFrjedprzhnW9YKqWdW5zSKc" +
       "i2RI6ikpULw3w5gVsdRDZRn2YwVBLWU261mpu/KWnmDLxUoP05oFb8b0WHbi" +
       "NS02qvJ0d9KPuwpCUKnMwfRckW2tuqa7YT9Yc9EKFbWwh0xX/aDJx0zqBiMH" +
       "H3exyXQ28gZRYdgh9bU1oeqdJVrBonaHXmyK1dqoy82piVNnWlWv3G2OpMaS" +
       "o53BIuZsnEISNpHKPmpyhoP1YX8+YymHXGu1zlp3hm4Fk7pMXF4QTH2MdSox" +
       "T8170sDD7Z6ttjk6aRDdEYbPZXOy6NNBaVorzpej9sbBm/rUCsfzuOXMF4FW" +
       "thYtjDI0BXG8ZKahs05B1zeboU6mvVQwXIPxJpqEmZqWEokwspj+tBHMmL49" +
       "gGmLHw6Hc0IOXdLAuCAahJU2PC+0xhKTjFUmSFp6a9jBKCVGbK7WbImlEtPW" +
       "KFxLO8ueOmxQjXINLqxixA/7iFMNeWJBdRAjqq9dYqGuUWUjMRU5wsuFZVGk" +
       "VSyuwSlHiDzXwlJktcYG7UFpxeq8byBRuoarRdCI8FyDMaLqQJDlsFgLsNXa" +
       "LUUFctGLBsOBEyZ9U0tGqLeY8ZtRPbEnmNLg43LPkyl+Krk2aXR4tuVzYn1V" +
       "aHsYMF6blesEsuiJ6xpqNsdmVCiM4pWr4bCrKXVnOoaRfnHZ7AOtuCYhzx3e" +
       "FCpDabxuyK2xbmNUOxTiGQbzlFVeVrs44ZS5xsip9lsDTbPgheWq9qCKG8Af" +
       "U1qva46BOz3XDgfLKuF3LbhTCArMyl+5szbmIEsRidvsQFeL6KIX2HbDs2Wv" +
       "HvJ+QZWmcQtzNV3raY7IbuymQBi1VpUbp/FmMjaGfLmqiVNDYprUtOthsFru" +
       "dpyqWhCTzWYQaq2Z7Y7n+kogVzI7c8ho0u17YANZ6iohsENrVWDdfpEPDKy0" +
       "mHXZSexWK/F403ZVfN1H3Lg160/iSWFDdzAvEMPKbN4kEW+mxzjFV8qDaFCl" +
       "ghWjk7yHS7RR4h3OwCsVNhXWPps0Gvq6a+hjnkvUEd8MR4ReU0dgLVB5x8YK" +
       "5aIb1hCPHnI2vJywobH0XXxaKw9bk/V4ibSrZEQtN0rUbTQGlXq53mAmfqui" +
       "Zf3q0iDcli7RCdFVicEMaEBVjPayGEx67HK24ohKv0ujvfFmPGXKHJoGzU4Y" +
       "xO0YxhtFfWStSY6vSpLKIJNiW5AScTMaK1SK1xFqDdsdO636cakc9momSaIt" +
       "LOno7bjU4jVi4sNLvNyqDIkRg1ZKBaFQV1OaryO9lKTa3CzguwPObnYxDjhF" +
       "uzBfr7m1H7dSEPO63LKxwAG5q6noBIzoE8YooHBVHy+Ao0utCq7ho03Ta5qN" +
       "BOvVCX3e6hgbQlfnw9KguxJh1IzYWgdLaMJbYbWCX58tGUZljLmiRDBeqSqm" +
       "5UwYmtUH8wk4brulrte1JAn1+gUYV2GrpdKVBs5VyQkmsgFhhYOBVZokOuYO" +
       "5XqouXPClpDFSpemxoy1C9FIMsEJ0w+4jduGydp8uFFGBWKwwYdNZ54aKMp0" +
       "6Y3BtRRiVaUjurf22qk4URmu1G9IMLqqoHU5qrjDdakyC6ZDejglZnQ1kVR5" +
       "6K3UzlxBi41RqDXihpUywwZviWGxs2qtWC9m2IjCFKHBRFrH0CuympbHhfpg" +
       "qCIFvGgCkVHWDaZu32fmcpuoDShpIDNFlEOXqjOfm+0EaRQYgZ1bOAnSSkLE" +
       "YpwwqERoEduZqmSxtEZjAV3bXGLCC6HtC3Sx0uzMCoRZ7/aN5ryLCtV4WsQj" +
       "rNbi00BoiKvNEJyatZArVaOUShqcLS0xVa7H+LySyBW0lCIF04crCchMU2+C" +
       "LBmknpRZMq2VE7zQEOozokPKK7WYeJ5aLDVEtsJFcxs2SghVE1YlroU0iQ07" +
       "pK2o4gz95hCpJcaESIt9clStW1KzH5hzeTbGdFOcriJlhnRsUqN0gyQqG3rj" +
       "Vzy8JTvjzUiveD19FRNlo93m6nW0NI2Rko/RxKxE2hO+WV8y9IDSht3q0FPF" +
       "2O3iQ1s1ZbkRmOIkaa2FKSzPa622jxR4RaHmSAmZ21ilYovTUlmZ4cUa2h/X" +
       "ipuupXu+4PmwOlmWG2u11vLISd8xa1ZzNKj10BiWutpUk5JBXyH6BOKkM6UA" +
       "Eg5CB/C6kRawSWvdbZujRS9JDTZqCS7e7LBlrECZQXmAtEW/PAFtIaPO16W1" +
       "x5hrGGF4czWCoySkXJjz0cYGdmW1ghabKyoORw1Hm/C6qsXRqFDHPVqCizxf" +
       "Xa0XC7QmDeaj0VratPpGEWUGkwSl4k7JZ+r9OenY/Qhjl2i/TC+CKcf32WXV" +
       "73XseAyKbqral6NU93SrA2tJt2+hrDZ3i0wRYa2kyXRIdOOW6XWklpoIQsNq" +
       "qz8aAMfs1GSmBAJQQLgRY2JyZdUytOGGGwZTFi6KQ82uwloEK4xWdZp+Q1vY" +
       "WugTMDjdsLJJp5QKOjCGnvJc2F8ZzlLh51WEYaokabfiuW70mI5KKhWKmFld" +
       "E6636jC2XBDFMahmP5yVucL/rdO4M2+gDq7Xf4TWabv0aDY8cXCLk3/OnryS" +
       "PXqLc9iJQ1nX8IEb3ZrnHcPrn3j5NZn5XCnrGDLEj4Sg+XfcnzaVtWIeIwV6" +
       "pxvfaWYXNPdf8yfK9uJf+uJrF26+77XpX+XXegeX87dQ0M1qZJpH298j72dd" +
       "X1H1nKdbts2wm395IXT39S5cQ+g0GHOO3S1kGEIXT0KCLjf/PgoXh9D5QzjQ" +
       "EG9fjoKkgDoAyV6fcfdvgYrXsJG3WbqzewMlJaeO2+bACS79sDbriDkfP9ai" +
       "5n9v7el7EG3/4Loqvflaj37m3drntveRkimkaf53CAWd216NHtz6PnpDavu0" +
       "znaffO+OL93yxL6D3LFl+NCNj/D28PUv/9qWG+bXdenv3fc7H/rN176VN/H/" +
       "CzRt9sV3HAAA");
}
