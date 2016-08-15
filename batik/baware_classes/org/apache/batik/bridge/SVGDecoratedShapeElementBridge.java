package org.apache.batik.bridge;
public abstract class SVGDecoratedShapeElementBridge extends org.apache.batik.bridge.SVGShapeElementBridge {
    protected SVGDecoratedShapeElementBridge() { super(); }
    org.apache.batik.gvt.ShapePainter createFillStrokePainter(org.apache.batik.bridge.BridgeContext ctx,
                                                              org.w3c.dom.Element e,
                                                              org.apache.batik.gvt.ShapeNode shapeNode) {
        return super.
          createShapePainter(
            ctx,
            e,
            shapeNode);
    }
    org.apache.batik.gvt.ShapePainter createMarkerPainter(org.apache.batik.bridge.BridgeContext ctx,
                                                          org.w3c.dom.Element e,
                                                          org.apache.batik.gvt.ShapeNode shapeNode) {
        return org.apache.batik.bridge.PaintServer.
          convertMarkers(
            e,
            shapeNode,
            ctx);
    }
    protected org.apache.batik.gvt.ShapePainter createShapePainter(org.apache.batik.bridge.BridgeContext ctx,
                                                                   org.w3c.dom.Element e,
                                                                   org.apache.batik.gvt.ShapeNode shapeNode) {
        org.apache.batik.gvt.ShapePainter fillAndStroke;
        fillAndStroke =
          createFillStrokePainter(
            ctx,
            e,
            shapeNode);
        org.apache.batik.gvt.ShapePainter markerPainter =
          createMarkerPainter(
            ctx,
            e,
            shapeNode);
        java.awt.Shape shape =
          shapeNode.
          getShape(
            );
        org.apache.batik.gvt.ShapePainter painter;
        if (markerPainter !=
              null) {
            if (fillAndStroke !=
                  null) {
                org.apache.batik.gvt.CompositeShapePainter cp =
                  new org.apache.batik.gvt.CompositeShapePainter(
                  shape);
                cp.
                  addShapePainter(
                    fillAndStroke);
                cp.
                  addShapePainter(
                    markerPainter);
                painter =
                  cp;
            }
            else {
                painter =
                  markerPainter;
            }
        }
        else {
            painter =
              fillAndStroke;
        }
        return painter;
    }
    protected void handleCSSPropertyChanged(int property) {
        switch (property) {
            case org.apache.batik.css.engine.SVGCSSEngine.
                   MARKER_START_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   MARKER_MID_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   MARKER_END_INDEX:
                if (!hasNewShapePainter) {
                    hasNewShapePainter =
                      true;
                    org.apache.batik.gvt.ShapeNode shapeNode =
                      (org.apache.batik.gvt.ShapeNode)
                        node;
                    shapeNode.
                      setShapePainter(
                        createShapePainter(
                          ctx,
                          e,
                          shapeNode));
                }
                break;
            default:
                super.
                  handleCSSPropertyChanged(
                    property);
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "r33B4OF81g98vJPPfpl/suYn/wZ/usjTSxkAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL1aeewrR33fd+a9R5L3kpCjgdwPSrLkt17fbkiJj13b67V3" +
       "ba/X3m3LY733vd7TaxoKiEtQUUoDTSXIHxWIFoWjFYiqiCpV1QICVaJCvaQC" +
       "qiqVliKRP0qrpi2dXf/ud6AIVEs7Hs985zvfaz7z3Rk//wPoTOBDsOdaqWq5" +
       "4Y68DncMq7ITpp4c7BBkhRb8QJbalhAEDGi7Ij78uYs/eumD2qWT0FkeukNw" +
       "HDcUQt11gokcuFYsSyR08aAVs2Q7CKFLpCHEAhKFuoWQehA+QUKvODQ0hC6T" +
       "eyIgQAQEiIDkIiDNAyow6BbZiex2NkJwwmAFvRU6QUJnPTETL4QeOsrEE3zB" +
       "3mVD5xoADuey3yxQKh+89qEH93Xf6nyVwh+GkWd++02X/vAUdJGHLurONBNH" +
       "BEKEYBIeutmW7aXsB01JkiUeus2RZWkq+7pg6Ztcbh66PdBVRwgjX943UtYY" +
       "ebKfz3lguZvFTDc/EkPX31dP0WVL2vt1RrEEFeh614GuWw3xrB0oeEEHgvmK" +
       "IMp7Q06buiOF0APHR+zreHkACMDQm2w51Nz9qU47AmiAbt/6zhIcFZmGvu6o" +
       "gPSMG4FZQuje6zLNbO0Joimo8pUQuuc4Hb3tAlTnc0NkQ0LozuNkOSfgpXuP" +
       "eemQf34wesMH3uL0nJO5zJIsWpn858Cg+48NmsiK7MuOKG8H3vwY+RHhri+/" +
       "9yQEAeI7jxFvab74qy8+9fr7X/jqluZV16ChloYshlfEjy9v/ear2482TmVi" +
       "nPPcQM+cf0TzPPzp3Z4n1h5YeXftc8w6d/Y6X5j8Bfe2T8nfPwld6ENnRdeK" +
       "bBBHt4mu7emW7HdlR/aFUJb60HnZkdp5fx+6CdRJ3ZG3rZSiBHLYh05bedNZ" +
       "N/8NTKQAFpmJbgJ13VHcvbonhFpeX3sQBF0CD3QneC5D20/+HUI6orm2jAii" +
       "4OiOi9C+m+kfILITLoFtNWQJot5EAjfyQQgirq8iAogDTd7tWPq6pMrIlO12" +
       "ZNHNtZhqgidnSAF4tPLunSzkvP/PydaZ5peSEyeAU159HBIssJp6riXJ/hXx" +
       "maiFvfiZK18/ub9Edm0WQlUw/852/p18/p3t/Ds3nh86cSKf9pWZHNs4AF40" +
       "AR4ApLz50emvEG9+78OnQAB6yWnggowUuT5gtw8QpJ/jpAjCGHrh2eTt7K8V" +
       "TkInjyJvJjtoupANpzO83MfFy8dX3LX4XnzP93702Y887R6svSNQvgsJV4/M" +
       "lvTDx63su6IsAZA8YP/Yg8IXrnz56csnodMAJwA2hgKIZQA79x+f48jSfmIP" +
       "JjNdzgCFFde3BSvr2sO2C6Hmu8lBS+7+W/P6bcDGt2ax/nrwPLYb/Pl31nuH" +
       "l5Wv3IZL5rRjWuQw/OTU+9jf/uW/lHJz7yH2xUN74FQOnziEEhmzizke3HYQ" +
       "A4wvy4DuH56lf+vDP3jPL+UBACgeudaEl7OyDdABuBCY+V1fXf3dd7798W+d" +
       "PAiaEDrv+W4IVo8srff1zLqgW26gJ5jwtQciAaCxAIcscC7PHNuVdEUXlpac" +
       "Bep/X3wN+oV/+8ClbShYoGUvkl7/kxkctP9cC3rb19/0H/fnbE6I2UZ3YLYD" +
       "si163nHAuen7QprJsX77X933O18RPgZwGGBfoG/kHM6g3AxQ7jck1/+xvNw5" +
       "1odmxQPB4fg/usQOJSRXxA9+64e3sD/8kxdzaY9mNIfdPRS8J7YRlhUPrgH7" +
       "u48v9p4QaICu/MLoly9ZL7wEOPKAowhgLaB8gDzrI8GxS33mpr//0z+7683f" +
       "PAWdxKELlitIuJCvM+g8CHA50ABorb03PrV1bnJuD9fX0FXKb4PinvzXKSDg" +
       "o9eHGDxLSA5W6T3/RVnLd/zjf15lhBxcrrEPHxvPI89/9N72L34/H3+wyrPR" +
       "96+vRmOQvB2MLX7K/veTD5/985PQTTx0SdzNDFnBirK1w4NsKNhLF0H2eKT/" +
       "aGaz3caf2EexVx9HmEPTHseXg10A1DPqrH7hMKT8GHxOgOd/syczd9aw3U9v" +
       "b+9u6g/u7+qetz4BFuyZ4k5tp5CNf2PO5aG8vJwVP791Uwhy32hp6WCZnA3y" +
       "tBSMUnRHsPLJnwpBmFni5b0ZWJCmAr9cNqxazupOkJjnIZVZYGeb221xLSuL" +
       "OYttWFSuG0K/sKXKN7BbD5iRLkgT3/9PH/zGbzzyHeBXAjoTZzYH7jw04yjK" +
       "Mud3P//h+17xzHffn4MVQCr2nS/d+1TGdXgdrbMqlhV4VnT3VL03U3WaZwKk" +
       "EITDHFxkKdf2huFM+7oNYDjeTQuRp2//jvnR7316m/Idj91jxPJ7n3nfj3c+" +
       "8MzJQ4n2I1fluofHbJPtXOhbdi3sQw/daJZ8BP7Pn336S7/39Hu2Ut1+NG3E" +
       "wFvRp//6f76x8+x3v3aNvOS05f4Ujg1veWevHPSbex8S5eRiMluvbSWqUaOl" +
       "knSbMK4tXG7eLMlae25P+lxhPfJ0ecOZHZQw2sOlWJNqSrEUVVOqKCuO1LTZ" +
       "1rzATtrWGDPYOlaXzBnXclfeZFabE9P2ENV5Yj51V4JnsX2P5VaK0OyyMx9x" +
       "u6XqRtxEgKGson2UnltOoyjA8FyAURip8V61oc7dECvNJga39CysG9T7rS7X" +
       "0Av6KI25IBaapQJRVbAxEsYtINFSXWkRTrJm0JkFHBcMB+aU9dluYTLCAt2Y" +
       "E/M2haXddXfTHs+HUzFhF5MQ781WqNWZz1os4YpUlWkZLdped2dMZKP4dErN" +
       "Vt1lk5uRnNNmdKJOVDAYKbVivMMSkdGzTB1JTFqqTTTNQq0S6a7UkHI5R2xP" +
       "ejgzm7LTjWBvlMncHC28xmDFBEOTqY+MqskvW0xkdAvhLKAGFVRtxI6YFsTJ" +
       "YpjwK3uWVgHwhVxkeK1KW1tJi6DHEgO0sxrGrtWcbRRuPGuMJWkijJJBfzIf" +
       "TSfoat4uMSJD8kqI1swySuEzvqAF4/U4JIu8zrVGzpLh1rGtqDOsERYVyzR7" +
       "PD9mXY3n7D7f4LuM0YADCq31pXFVt1yWFKvFfh2zB+0kbauuVZyO1z5T4Ym4" +
       "7wqh0iz2cH1gaaxno6SEaoN5MCy0YL6EDvtVMeHWML+K/KBN9YmIN6vAP8GE" +
       "FDk5RRpzmyWS7lyWK4HqEi3URNoj3U2GyyHeFJCgqsyMdiQwI3yKlNO2MSoq" +
       "zWTAUXpIChgXk/jc4GSt2RMJnB2kVr+EJ/S0MPLIWZUatIiCOBgwhB11pumo" +
       "vJkQwz5SKIgLDMObqIjNk8FkgsKBWSZqnenYg1maFirDJVlZY7TQ0Yv9pt9y" +
       "7Jm6KiKNwB4xll2bLr2+RvSbNWw9EOQqbtZr9YUx5qbNaDTqkV0NrtOdUavB" +
       "o4uFNSq0k9W4NvSpGWfaXss2dTQm5YoSpA4WWnhcJZZtA6+bFAendqc0tTdi" +
       "k5M5liLJVtAZlXlFonuljdlVSKffdcWxM5/6kZCWMSU0vTKKE3OuWLa6DJYS" +
       "dH8s6O1lqY5g2qgZwW7Z604oOGKHri41DXZFpj4TKch4NvO4IT5Dm4aie8up" +
       "M693CskG2WhB32X48qwt1kszow4TgU7w5CRIp21CSDxbqxI2s2JKZbdZ1iet" +
       "sGL1MX8N013SoyYjcTgYLKtjtUvX1bGctryBMxAmFFkL7bphBlVL78rJeKIW" +
       "m304VDrGcDGslZW0OucrJG2PEyxp6yTCt9WxwYQFfM7bTceTujU/GaKkzshY" +
       "VMPGwQIs5EUxUUBK2oOXvlZfVMuy77uFdpPcRIvajC43WW3dozNsszxG2TQ3" +
       "Jt1jy0yzyZWIrtFs9VF0YhFGdSG1ErNT1hZyxXWsCrwUh/6YHTMgJDjXsIPA" +
       "2DB8lWslwmRN1fWl6bXT0jBdb4hhZT50NxLn9Jt4CsxrjDy2qvTbS98r6pFW" +
       "phgUVbFJ6jnWkqxNUIVimGq1VghLLbSbULidEPOgVWkYhW4fyOtNSnChq/dG" +
       "yJxriEjc2xR1qtaesL2iyBN2OkvsJFkhHGKwZqVVtaKeg6V1uSrzq2XSLHtr" +
       "o92ptNO01uhiEx+lAoPiB2ZPZamqLQLgKhGFEqZuPKPmNZw2vZQVRaxj4dzS" +
       "yr5LOetyZYHYglFPNvONJsqbeDMkkgXdw2N97VEIHJtKDe6tJI8YrqpiVW/R" +
       "QjXBiutV2hmjeq1a42sMNmjWfHQTzGE5WuABjUi8i2v8MsAjNOY6bh8jxiKq" +
       "yHIpieCGYtdMQaKLoqsuO2jbxGiit2kxDo91V1FfF4No5EuY3TbaWsqVS0yM" +
       "ii3c4qdtM/W0QJnTqDVbOjEC4mKptXW/QBHVQi3mhiW6WgtXRK9kGOVGWqMI" +
       "vb0uUelqM50xagfpVaS1Yzv6oDalkeooJB1HZenE9ppwR5itOGJS7GAo1wZT" +
       "8iksI3ZtWYSDGbzhvYXVUBAdo+nZDMRlZTSj7Vhq1EfEKA5jvR+s/ZqNB42m" +
       "S3P10oom20qtLjs9yRg0R8UGWxDgwoCXo/FMnJS7RgvTghrTb5H0CN/YOIPW" +
       "a9WGGMWbTlxgVRUHcWKs7FEFo4flcVJSy0Nm0BzWbEOsw/1+UpvLsOkayQpb" +
       "Vk01tcrCwmE68/Eo9WYNRCTrtSIMi3RZkDaTTh03TF5RiVIsJLxRijto3x0u" +
       "RsRqNPZWgUQ0m0suoKIxMlJWTGUia+laSMwJOQhnadysLqmFX43Jjb8aF/Vy" +
       "pLq+Wu+6dNqAhyESaybcaMSLNJ2qrZW7rKKzdMwytG2wQSoQ9aG4IemWvCnZ" +
       "QaWxDBRpJZdKpr3ieqgUFsxujW5MscHAGcZMLUTIVYGphyWwECphU3LpytTZ" +
       "+A0SqINQG7+ISqRXHtQ9bd5coH0SLyCrxtSd48aMwKm6gFVodERT5TluJWqP" +
       "t4sY0g4alaJKLyxzKQdiiilByM7KMt1RWy0Ho0gER9uFlUWifcEdwvWOPhs2" +
       "NJSgS9Muzm/Ky1AMxnw19TWLqKocWy0b/RYfMbriJ0RfQ/WNXSUrpmmrlZY1" +
       "Y1szqhO75W6/rDDeGrUsSV4X4kpXWmIaX6kihVDlWmijFdWVAcOJeoMLw2BQ" +
       "YjuYKCDCvLjypyg9KHJOXeGHKIxqGxUhR+xoaPn1ZM1Ni1raJWJjTU7QpCxM" +
       "fXcwMwp4S18nsTGypmu7arjk3BKWGZ+GOJZGLE6PE6FEJNPWbFCPVxSzqTO9" +
       "8giWh0W0zZfX87q+phoS7Qkm7I5pkMjXu4UYE/nBlFvNpxpJRAlTExRdK04N" +
       "R+kpeiNNcdQiVL26WYmGAaM1Hl6PDH+Jgu2K7FJySzLVjuOuNgxnJJiStOt0" +
       "StLzje/3qUYyWTYaBo7O5a6YaoNQl/hZxKorXG+lHkU36vOGEqcqVicQQxEZ" +
       "E6bsWJmMYZF1zUmvxwdL0owDDGDqutzu4WCpzYsRvGDZCNu04kYCizrtGJWU" +
       "7Kq1UqE6GLvuyK7PirYVBaLfo5dsI0SUHmGETdUbmRpLIIw1HFaG+njhVTye" +
       "1WtewOG1Edy3e07cY0b1WWvhNcPlBmSyM1fm+ugktQRz2BU6A9anm2UHL9Vq" +
       "aLPeEKaDSGlVN6yIy6Vq2+VNYsF3JDiOUwSkjHWCUFZaEZ8nesGN+D6DFoyp" +
       "p1BhQ6HpWglkUOkKX1XKdn2Ezhhr1hDi6SoclpPpzNdkW53iQqm12FBjt70y" +
       "mbZRXjflRXkTtRGVwJeLSlW3/UqxEJc62HxEasUE0xqy6cYqhXXatF7nGYMX" +
       "F/Ci6OITGp61vIroh2jPrFElc1XgWbwpOvF0XYxBnr8slCcFWNlQJidFpVie" +
       "US1tMPDAjmOtbbUKD4bFlYbhoWzycWdVrPVsKwg3m3kgqgN3Md9wLdHCeysl" +
       "VNEmyGuCoNEq8j7Y01LZkWyxECPyulySgjEch5MmRuklCq74k8lCLHWi1MTw" +
       "uNMQut5oHNKDzYKChWWhJMVpDUUbSDIuY1JSDvxCKpurtUghFDlTNbNcrxfk" +
       "sT9vgkwO0TWXFRrRLPTCPgZzrmAJgcqsA2ypuvN2YQC3lnbEG5LXGzSKlBeQ" +
       "8TQVkvmA9SbtOWVZnVaqEq5dYcWGF6gFPmgUZdcNRWrtCmJ5qdlwpyh3O7DR" +
       "bHZUWdcmPYYbtlLML5VaZQqvgzy+HhM0rXgWEkScgyQ8EgUGM12bIDF58sns" +
       "dexNL++N+Lb85X//lge8CGcd/ZfxJri+9oQn8wlD6JywDEJfEMODE8X8c/H4" +
       "tcHhE8WDYyYoe/W973o3O/lr78ff8cxzEvUJ9OTu8RwXQudD13vckmPZOsTq" +
       "NOD02PVf8Yf5xdbBsdFX3vGv9zK/qL35ZZyHP3BMzuMsf3/4/Ne6rxU/dBI6" +
       "tX+IdNWV29FBTxw9Orrgy2HkO8yRA6T79i2bW/d14Hl817KPX/tM+poe21rv" +
       "qWMHn6d2T/t2D4Nec737i+09xe6V5x71HRl1UhJ3JNfe2b3Q2Ou7/ypOahzu" +
       "5FcfIxfscRlZfINT2LdmxSqE7hZ9WQhlXLesaei7JvBJfr25N89D15/nMGUe" +
       "5/5POvE4LETe4By1fRbJT+7a/smfle2zn0lWpFnxlpz0fTewzK9nxbuA9beW" +
       "GQq+Kfu7umZdbztQ+N0/hcKv2gsweldh+mUofCKrvu7lav2RG2j9bFb8Zgjd" +
       "vtX6sIOPKf2hn0Lp/NanAR5jV2njZ6P0id17u+w3cwhyFyF0CuiQj/ndG2j/" +
       "yaz4WAjdowmOZMnt6ZT23fzPA23QosrStTifjsE7/IFdnns5dlmDFXzjO8vs" +
       "9uWeq/45sb3tFz/z3MVzdz83+5v82m7/Rv48CZ1TIss6fFh+qH7W82VFz/U9" +
       "vz069/KvPwAocB1cCqGz20quwOe29J8PoUvH6UPoTP59mO6LIXThgA6w2lYO" +
       "k/wx8A8gyapf8vYg5/EbXPJebaf1iaP73b4/bv9J/ji0RT5yZGPL/9aytwlF" +
       "2z+2XBE/+xwxesuL1U9srxxFS9hsMi7nSOim7e3n/kb20HW57fE623v0pVs/" +
       "d/41e5vurVuBD4L/kGwPXPtyD7O9ML+O2/zR3Z9/wyef+3Z+uv9/rSfEz28k" +
       "AAA=");
}
