package org.apache.batik.bridge.svg12;
public class SVGSolidColorElementBridge extends org.apache.batik.bridge.AnimatableGenericSVGBridge implements org.apache.batik.bridge.PaintBridge {
    public SVGSolidColorElementBridge() { super(); }
    public java.lang.String getNamespaceURI() { return org.apache.batik.util.SVG12Constants.
                                                         SVG_NAMESPACE_URI;
    }
    public java.lang.String getLocalName() { return org.apache.batik.util.SVG12Constants.
                                                      SVG_SOLID_COLOR_TAG;
    }
    public java.awt.Paint createPaint(org.apache.batik.bridge.BridgeContext ctx,
                                      org.w3c.dom.Element paintElement,
                                      org.w3c.dom.Element paintedElement,
                                      org.apache.batik.gvt.GraphicsNode paintedNode,
                                      float opacity) {
        opacity =
          extractOpacity(
            paintElement,
            opacity,
            ctx);
        return extractColor(
                 paintElement,
                 opacity,
                 ctx);
    }
    protected static float extractOpacity(org.w3c.dom.Element paintElement,
                                          float opacity,
                                          org.apache.batik.bridge.BridgeContext ctx) {
        java.util.Map refs =
          new java.util.HashMap(
          );
        org.apache.batik.css.engine.CSSEngine eng =
          org.apache.batik.bridge.CSSUtilities.
          getCSSEngine(
            paintElement);
        int pidx =
          eng.
          getPropertyIndex(
            org.apache.batik.util.SVG12CSSConstants.
              CSS_SOLID_OPACITY_PROPERTY);
        for (;
             ;
             ) {
            org.apache.batik.css.engine.value.Value opacityVal =
              org.apache.batik.bridge.CSSUtilities.
              getComputedStyle(
                paintElement,
                pidx);
            org.apache.batik.css.engine.StyleMap sm =
              ((org.apache.batik.css.engine.CSSStylableElement)
                 paintElement).
              getComputedStyleMap(
                null);
            if (!sm.
                  isNullCascaded(
                    pidx)) {
                float attr =
                  org.apache.batik.bridge.PaintServer.
                  convertOpacity(
                    opacityVal);
                return opacity *
                  attr;
            }
            java.lang.String uri =
              org.apache.batik.dom.util.XLinkSupport.
              getXLinkHref(
                paintElement);
            if (uri.
                  length(
                    ) ==
                  0) {
                return opacity;
            }
            org.apache.batik.dom.svg.SVGOMDocument doc =
              (org.apache.batik.dom.svg.SVGOMDocument)
                paintElement.
                getOwnerDocument(
                  );
            org.apache.batik.util.ParsedURL purl =
              new org.apache.batik.util.ParsedURL(
              doc.
                getURL(
                  ),
              uri);
            if (refs.
                  containsKey(
                    purl)) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  paintElement,
                  org.apache.batik.bridge.ErrorConstants.
                    ERR_XLINK_HREF_CIRCULAR_DEPENDENCIES,
                  new java.lang.Object[] { uri });
            }
            refs.
              put(
                purl,
                purl);
            paintElement =
              ctx.
                getReferencedElement(
                  paintElement,
                  uri);
        }
    }
    protected static java.awt.Color extractColor(org.w3c.dom.Element paintElement,
                                                 float opacity,
                                                 org.apache.batik.bridge.BridgeContext ctx) {
        java.util.Map refs =
          new java.util.HashMap(
          );
        org.apache.batik.css.engine.CSSEngine eng =
          org.apache.batik.bridge.CSSUtilities.
          getCSSEngine(
            paintElement);
        int pidx =
          eng.
          getPropertyIndex(
            org.apache.batik.util.SVG12CSSConstants.
              CSS_SOLID_COLOR_PROPERTY);
        for (;
             ;
             ) {
            org.apache.batik.css.engine.value.Value colorDef =
              org.apache.batik.bridge.CSSUtilities.
              getComputedStyle(
                paintElement,
                pidx);
            org.apache.batik.css.engine.StyleMap sm =
              ((org.apache.batik.css.engine.CSSStylableElement)
                 paintElement).
              getComputedStyleMap(
                null);
            if (!sm.
                  isNullCascaded(
                    pidx)) {
                if (colorDef.
                      getCssValueType(
                        ) ==
                      org.w3c.dom.css.CSSValue.
                        CSS_PRIMITIVE_VALUE) {
                    return org.apache.batik.bridge.PaintServer.
                      convertColor(
                        colorDef,
                        opacity);
                }
                else {
                    return org.apache.batik.bridge.PaintServer.
                      convertRGBICCColor(
                        paintElement,
                        colorDef.
                          item(
                            0),
                        (org.apache.batik.css.engine.value.svg.ICCColor)
                          colorDef.
                          item(
                            1),
                        opacity,
                        ctx);
                }
            }
            java.lang.String uri =
              org.apache.batik.dom.util.XLinkSupport.
              getXLinkHref(
                paintElement);
            if (uri.
                  length(
                    ) ==
                  0) {
                return new java.awt.Color(
                  0,
                  0,
                  0,
                  opacity);
            }
            org.apache.batik.dom.svg.SVGOMDocument doc =
              (org.apache.batik.dom.svg.SVGOMDocument)
                paintElement.
                getOwnerDocument(
                  );
            org.apache.batik.util.ParsedURL purl =
              new org.apache.batik.util.ParsedURL(
              doc.
                getURL(
                  ),
              uri);
            if (refs.
                  containsKey(
                    purl)) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  paintElement,
                  org.apache.batik.bridge.ErrorConstants.
                    ERR_XLINK_HREF_CIRCULAR_DEPENDENCIES,
                  new java.lang.Object[] { uri });
            }
            refs.
              put(
                purl,
                purl);
            paintElement =
              ctx.
                getReferencedElement(
                  paintElement,
                  uri);
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "hZfpFo/lXoY3Y7Mh52/iV+GkQOft9TeXQ0B8L+VkTbFEMARQYGM+mrSlWGUj" +
       "qrIzDx8/Hd/5zCar/mjOrxZ6oBh+4Zf/fDd06rdvz5GKqrim36KwCaZ45MNj" +
       "TUte3hgQRZ+LXR/VH/vdD9qT264nZWBf6zWSAv5fCUqsL54C/KK8+fCflu26" +
       "O7XvOtB/pc+cfpbfGXj+7b510rGgqHAt4C+ojPMndXoNC4saDEp5FdXEnjoR" +
       "ImtyztKMvtEGj+2+1rsQgefwsxyuFZtaAgFGS4x9CZsvQnAnGR8ERUzwSrZ7" +
       "uN9x1UYRL1jgh6wCXwzcic2wFRCd/2UwYkeXLvoH8i2ElWWfrWbf9Vuo2NQS" +
       "VmAlxpLY7OOkFiwU0SSqDNr7Peaagt4AUzTh2Ap4dtn67Lp+UxSb6lO33A5/" +
       "e8/XFoMnC5ns461DvQCpJ2+TQnEtHbLLVhzKOARtBeySEzzUZ1A9JUvmIIR/" +
       "fr2KgDKSiZlQW8ppKCUm7DPZ5qF90kz70O8tvLtpjgkW3aKz4W+OfrD/XYEM" +
       "lQhFuXj0wBBAlqdKarRs9xn8AvD8Cx+0GXbgG4663fYBa1XuhIX5wSAdJa5E" +
       "8hUIH2r+ePzJSy9YCvhPoD5iNnP80c9CR45b4G0d09cUnJS9c6yjuqUONg+g" +
       "dG2lVhEzev9w7tCPzh46HLT9vZ9jdadRnnOPQO5UsTDf6Jak936j4cdHm8t6" +
       "ISn0k8qMKh/IsP54PjDONzMxzy6453oXJm2Z0eKcBNaDcUW3USI0H8UmzUmN" +
       "ZDDYEJE9Ha+rF8BFJ3nI7Raxqt6AWF2OYx3wRO2Ai5aIVdGux+YWwTQI6Vg3" +
       "NA61CINNrjDFJZKvpF1YgrnPQmWCa5mIQWwOYmMKCZ4oYcwnsTkGhgM3NiC1" +
       "74SIlfmU4OBa77EbZb2b4ZmxFZy5Huvh5wlsTs5hsmIc/3OTnS1hsueweRpS" +
       "g20ycXIvdEC3W5jw2/8LE2Y5WVb8wgAr3aUFl5fWhZv04umGyiWnd38girjc" +
       "pVgtYGUioyieoPUGcIVusIQstK61Cn9dvF7mpKXktQagiXgLRb5nTXqVkyVF" +
       "JoH/Wx9e+h9CHeKnB77i7aU7z0m1SwesrA8vySwnZUCCn6/rzlZtLqZBlyqn" +
       "KcfznAB9WQKT2+V5oPBoIHZ30bV2NzfFe+zF1CHupB10zVi30lHp3Okdgwev" +
       "3PGMdeyWFDo9jVxqAFOtG4BcedtWlJvDq2J7x9X6l6rWOlDfZAnsRtdyj3N3" +
       "AeTr6EjLfGdSsz13NP3wzNbXfjpT8T4kqT0kQKEY2OO5EbauP+Fgm4FzxZ5I" +
       "Ye6Ao4A4LHd2PDF198bEX38jTl12rllRnD4qXXj2/p8fW3oGDtU1/aQcshjL" +
       "jpFq2bx3Sh1m0oQxRupksycLIgIXmSp5iakefZ5iMSvsYpuzLteLlzacrC5M" +
       "toVXXXBCnWTGNi2jxu3UVuP25F2W23FUndF13wS3x1OQfN3Khrgb4LHRyICu" +
       "O7VIxSldgMBhf4IWnWL2BfGJzS/+DYF6VPuvGgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL06eezkVnne32Y3yebYTQJJGnJnA02G/jxjj+foUojtGXs8" +
       "47Hn8hxuYfFtz/gaHzMeQ1qgB2lR06gNNJUgrVQQLQpHD9RKlDZtRQGBKlGh" +
       "XlIBVZVKS5HIH6VVQ0ufPb9rf3ugFNSR/ObNe9/73ne/z++bF74JnQoDqOB7" +
       "9sawvWhXS6LduY3tRhtfC3fbLNaTglBTSVsKwxEYu6g8/Imz3375GfPcDnRa" +
       "hO6QXNeLpMjy3HCghZ690lQWOns42rQ1J4ygc+xcWklwHFk2zFphdIGFbjqy" +
       "NILOs/skwIAEGJAA5yTA+CEUWHSL5sYOma2Q3ChcQj8JnWCh076SkRdBD12K" +
       "xJcCydlD08s5ABhuyH6PAVP54iSAHjzgfcvzZQy/twA/+6tvOfe7J6GzInTW" +
       "cocZOQogIgKbiNDNjubIWhDiqqqpInSbq2nqUAssybbSnG4Ruj20DFeK4kA7" +
       "EFI2GPtakO95KLmblYy3IFYiLzhgT7c0W93/dUq3JQPweuchr1sOqWwcMHjG" +
       "AoQFuqRo+0uuW1iuGkEPHF9xwOP5DgAAS693tMj0Dra6zpXAAHT7Vne25Brw" +
       "MAos1wCgp7wY7BJB91wVaSZrX1IWkqFdjKC7j8P1tlMA6sZcENmSCHr1cbAc" +
       "E9DSPce0dEQ/3+Te8PTb3Ja7k9Osaoqd0X8DWHT/sUUDTdcCzVW07cKbH2ff" +
       "J9356ad2IAgAv/oY8BbmD97+0hOvv//Fz21hXnMFGF6ea0p0UfmgfOuX7iUf" +
       "q5/MyLjB90IrU/4lnOfm39ubuZD4wPPuPMCYTe7uT744+IvZOz6ifWMHOsNA" +
       "pxXPjh1gR7cpnuNbthbQmqsFUqSpDHSj5qpkPs9A14M+a7nadpTX9VCLGOg6" +
       "Ox867eW/gYh0gCIT0fWgb7m6t9/3pcjM+4kPQdD14IHuB08F2n6wrImgBWx6" +
       "jgZLiuRargf3Ai/jP4Q1N5KBbE1YBla/gEMvDoAJwl5gwBKwA1Pbm5ADSzU0" +
       "OFwZJQQejumhZ1sZB16QxQqAhcgBdjOj8/9/t0sy7s+tT5wAirn3eFiwgUe1" +
       "PFvVgovKszHRfOljF7+wc+Ame3KLoBqgYHdLwW5Owe6Wgt2cgt2rUwCdOJFv" +
       "/KqMkq01AF0uQFQA8fLmx4Zvbr/1qYdPAjP019cBRWSg8NXDNnkYR5g8WirA" +
       "mKEXn1u/c/xTxR1o59L4m1EPhs5ky3tZ1DyIjueP+92V8J5999e//fH3Pekd" +
       "euAlAX0vMFy+MnPsh4/LOfAUTQWh8hD94w9Kn7z46SfP70DXgWgBImQkAYsG" +
       "wef+43tc4uAX9oNlxsspwLDuBY5kZ1P7Ee5MZAbe+nAkN4Bb8/5tQMY3ZRb/" +
       "KHgu7LlA/p3N3uFn7au2BpMp7RgXeTD+saH/gb/9y39Bc3Hvx+2zR07CoRZd" +
       "OBIrMmRn86hw26ENjAJNA3D/8FzvV977zXf/eG4AAOKRK214PmtJECOACoGY" +
       "f/Zzy7/76lc++OWdQ6OJwGEZy7alJAdMZuPQmWswCXZ77SE9wHBt4ICZ1ZwX" +
       "XMdTLd2SZFvLrPQ7Zx8tffLfnj63tQMbjOyb0eu/N4LD8R8ioHd84S3/cX+O" +
       "5oSSnXWHMjsE2wbQOw4x40EgbTI6knf+1X2/9lnpAyAUg/AXWqmWRzQolwGU" +
       "Kw3O+X88b3ePzZWy5oHwqPFf6l9HcpKLyjNf/tYt42/98Us5tZcmNUd13ZX8" +
       "C1vzypoHE4D+ruOe3pJCE8CVX+R+4pz94ssAowgwKiCuhXwAAk9yiWXsQZ+6" +
       "/u//9M/vfOuXTkI7FHTG9iSVknIng24E1q2FJohZif+mJ7bKXd8AmnM5q9Bl" +
       "zG+N4u7810lA4GNXjy9UlpMcuujd/8Xb8rv+8T8vE0IeWa5wFB9bL8IvvP8e" +
       "8o3fyNcfuni2+v7k8mAM8rfDtchHnH/fefj0Z3ag60XonLKXHI4lO84cRwQJ" +
       "UbifMYIE8pL5S5Ob7Ul+4SCE3Xs8vBzZ9nhwOTwEQD+DzvpnjsaT74LPCfD8" +
       "T/Zk4s4Gtkfq7eTeuf7gwcHu+8kJ4K2nkN3qbjFb/6Ycy0N5ez5rXrdVU9b9" +
       "YeDWYZ6VghW65Up2vvETETAxWzm/j30MslSgk/Nzu5qjeTXIy3Nzyrjf3aZ2" +
       "24CWtUiOYmsS2FXN50e3UPnJdeshMtYDWeJ7/umZL/7SI18FOm1Dp1aZvIEq" +
       "j+zIxVni/HMvvPe+m5792nvyKAVC1PhnXr7niQwrey2Os6aZNdQ+q/dkrA7z" +
       "NICVwqibBxZNzbm9pin3AssB8Xe1lxXCT97+1cX7v/7RbcZ33G6PAWtPPfsL" +
       "3919+tmdI3n2I5elukfXbHPtnOhb9iQcQA9da5d8BfXPH3/yU7/15Lu3VN1+" +
       "adbYBC9FH/3r//7i7nNf+/wVUpLrbO/7UGx0y3da5ZDB9z9saaZP1kKSTHQe" +
       "6c2rm1oBr5tGt9mnFVNlhgQv+nOal4WUT4IpIS3QRldWULWqlmVUF12512sH" +
       "g7ZP9FHBbFoEbQm1ptqhCM9mJt7IH9ebc4spWWJ7MlwsZd8eM/54toQFnFv6" +
       "o0JfXRVXqqsi1WIdLdHLos8hqgM7qbhC0SBFNQR2CkoMdh0wnRKHWU3YT/G0" +
       "tGxtGNqSWHWzEriWSkxL/cpEkOFopQ/LVIkQ5hRdsXtCq016m6lv++GI66qM" +
       "tdxI7jIcdfuKbPF0j5mRs7RtWVNuOumybZaDg2G8abNdotov98vtgbQYMM3C" +
       "VFnQXTFd+RHhb4qDJjkM2/gC5QW96m36k4U78kvpxh9UN3JYY4SlrEZCwtNW" +
       "r1rp9zmxaoUmyW82ozglIseQar4gRFTZoseYxBY2yUgm5qE1wU0+1JeuWaxE" +
       "LaGMkgQee0vHV5a0wndL3KhtG7W+GSioWaF8pdjAOvGCbbaXve5QiZqaMlD4" +
       "tUQYE1UelJZCo8IvRacYIZLAKFWX9Itkf2r5JKJbQplzAlls4I5oCF07QoXp" +
       "otiSxyM7YodFdtxKan14Xt7ICIduivPGhF/0x2JLINZtkyfXG8KY2Z3xPG2Q" +
       "1bLbnLQ2HNdxUoRscItlOB/VF2XUQdtDf7RuIIXCjBiFKT/vNZ1lJZoRdYLb" +
       "dOeKgjJLUek3nCncKdY8DncqrCuWotEoTKZYP6Q8ej1bNwm5kPq1tWzXhXJ7" +
       "s6p3UaYSRbUW0SBKuh8kdluUJR/reLNucbKpWEJDEFtGaypgHD5ZVgg8WSos" +
       "uepQNBIJiKO07YXQU9stDulz+Hgy7uIDvjwZDtxisjbskoRFoZ3CmNKKkgrW" +
       "ISvTPjLEu4Yigh+1SMd9StZ9mp7McKnBs7hTWlZ6bodk01qtSfZb1mCEWVZB" +
       "HhOVqhJWqVLdQlhxtVC4RjQvYG7Tq3fESa9U7VS9atXyG90hsBxxkNTgbpEq" +
       "NRGRqRdFd4w7XQGbz42ZYoiuicIbrK/pM7TGL2K/IFiUP7RmnB71F9LEVsf+" +
       "fJCUBo7QrVqwNOwsdSruqlgPCzl0QEliSQ7TxQgXqxs9pThq7M1ceNZhmmET" +
       "H40VHg3IWRErxW6PnBTC1DPFRrnmExONL89LSJnh2oWeCeTszIb+YDyWSrU2" +
       "aXo65tAE7hKByJmTnlHXOFOohbMy0zZTwaI7uklY0aLRFXi+XXJnbtOMEXOt" +
       "0VpRLg76Iqfi3QGuG+Gi2De5hl/vwSvFdgU9pBYgOGVu1CPXfrPUEjlr1J13" +
       "TLQn8zFWc9hiS1nZ3WYSxii1aReNfmj1GbJvk7bRNxmB9mK8v2gSOMsWB22W" +
       "LuCrwbo1xolZEBdn8RRurXx3LGokXYj7NQQ3FlMRmbqBr1ZajXXPWqpSpSLL" +
       "QVyuzIqGM1DMdDyyaMk3onixWXjEvBgYaiUQkiGVxLA9tzeDwqyAJ9zMpfEA" +
       "aWMJLw6XQnGNwyE20eZmme6jc55b19T1xoeTRT0aLfoVTo/TMWOsFj6OKSFR" +
       "HTUqQpepN2xchtVGMk5q9BrTC6uRYgm8RCY+xitm2+0LqTDTx3qkr52NsgzG" +
       "dWpadrRevR+nVJnyumWfIFuGKEXwfJR0K+5o3ZpOfIIRRo5PO6RRxrhl1ekI" +
       "vKy24maaSu1qeWpQc2Hm0yuzIg/n4yBJVJbmqwOWTeqtnk4tGbjXwpo64k9h" +
       "NJxXlbaSxr4fUiOmvF6jsUNwyGjCMmS4mU7laV+c93v6YCm1Wq2gXtMYeD2R" +
       "iFm3rpFV1UTwSkpQXkdsoW6wZhR9miYpo80r/EyvuZ5NOOKI68zcus8um4ug" +
       "IfG2olkNgerifN13EZRclf020peExKBL85pUcrAKNqy3aKsIC51GS5F4roTI" +
       "Rj0qFOejtJxGFThaewjed0chEqZ2LSVhXIixTbXhUV1vAEtmvRQX6kOxTgZM" +
       "i2Fn/ijtEuvFaGYwJods2OKqNClG8IrueTo3iXoB3HMTbOjMvYgdkBgszKfV" +
       "DWIKpjwtq1iEBrjko5O4QqWyF4YUbBEVPSo11wQ40FKjVPfHtLTCQyUpkwZB" +
       "tcNqQ2l05DbmItzIrqFwvWDGbL1amg68Tt2ngoHEbqaWhc/HWkNNAZ6Ulkts" +
       "PZnLGrZoj4Zc3x4PvVZCEIlfxtRELmG9STxqIPWeNl2xaQlRu1NT1H3Kg+2p" +
       "N0Nn1a6JIbA1LtCLPq9H9ZE27ReJGlsYL0Yy1QRxsT+juwUnGNoTWpgvAyZt" +
       "gCjVUmEsJaUAduZ8kIgVjzALZVGH9YZarATqKsXozhKkO2ilsyYlsYx1uflI" +
       "iDTUNPoDscBOB/C4Ba/URn05QiplV5wQeiWdDPEVppPCMmSxMgl3OrWCTup2" +
       "jFT46nTFRwTsKwVF92Wdns4LVRkrFQPaWLbwqEwWvHmv66pTjyPLodRo+hil" +
       "Tpvu3BswTrRJo053FTXpeQEplIKwb2j6Okw2MSVGEm5Q9LCc1EkxXPVd3KUH" +
       "teZASNfDQKzGXD0pCbMBW5obZmVNTtepYinImhqQKowI69lCm7Irr1WzkKY9" +
       "mejBRNbr49hDuP5w7OB24rOzKs8vKGstFIfDZYMLqj1NkoyojAvpCDiBX1Yj" +
       "t1JlQTxPhnLF5lEUx2CtBk+BE7sk5oblSqmx6pPA1gujvtuMWjLLjs20w+OD" +
       "iNA2Q+C8gljC621h5TDMANYDpGM0OkNLtPuTmu93SMGpNnoitqTqxUVaLfK1" +
       "aMVG/txYTFCpk5YnBV4PGvB01uzafZOKp/PimiBwe6l2pGAQ1hO3hq8aNTIp" +
       "FOmpbNDlSgXVZ4RUmsYmM8XWQ1xtS1izZgpMCwkKWi9tDzf1Gbkye14Dszi3" +
       "VysqdXJQxuQyXVSLdUVw28O6UtnM46XAc0bBUGnEHpvNVFvV19WI7KVmudJi" +
       "R/WVWJ+rkjpwXb7X5zEhHDX0Slta1NHKvKyoLacWVZihW1zUlt2OCTNhDyv3" +
       "5g2eS7tJuqmUMdSbth1ELGodheCkhiJMUGHIFFs1wUkFhxMbjVmz3ay3pEJA" +
       "1YALoi5THUjJMqrgEwrhZwm6HvAIbmESM1bpOCnMJutRn6mMDZTDKyWS4bhg" +
       "3qDaYmflU6WZEbi9vjMhJcxh+pM1P3O6HVIsezNl7YajBQ0yapSzyFK1PGRs" +
       "3RHKPCFVq01ZlBG5LDoJJW6wVrwysbUdjkLMDB1GgVF+5A5LZhhra23gDw2k" +
       "uFGmzEptkugEm68RuMY2kRk2Gcu1tYEHqCRQNqZPTHFVLMcOvbEmrorWDCuY" +
       "K/7YiGa0YHkbS/N6Aq0w4zhk+mHUAby4dXVFVR2/M11EfcmwpgY7kDF3NF2O" +
       "F5sx1fZa8CSpawWzTra0jkuAzKUqCdW06JSGay0M8NpqM1y7okCSbgUOUluM" +
       "2KVI2Jul21H01MWJ+qTfGSGFMeb1CI9piWhRHiNcqlNaIaVKZCv2iVIxHVto" +
       "0W75KL9QjbW2Qnt0V9U2E6rh1efjZIlTfESXCUVTo4ndXjWWSLua1KcVuxJM" +
       "eLuhi7gbDiJ1M0c5FNdGQaU5Z3VaHYZpCeV66Drl5Kk+90e1UXmxHBUX/U5z" +
       "hvA81pSluFegDKdMpYmIMTOtgntlvMy2VKTXADlcTW5O0dp8ZJeQwLYHbqO8" +
       "nE7nCOzX9Anq0Y1IKMFSXwnNOTv3qSUiJ+jQLDlFr58MYn8RbhSWMZipM/Qx" +
       "S1pouohZ3eEqnPlxykYaa6eSEpBYN/LG0+mUIN3JiOYsZJ7EqDCOewhGIRME" +
       "pQTw2lhC10M0KfF9nUM7ZmDIgMjBhiFjvjpmkqGtGl3C1MvMxJ2wCKHT7XQI" +
       "FxozqjLuxSvawPHsNfDNr+xN/Lb80uGguARewLOJ1it4A91OPZQ1jx5cVOaf" +
       "0/uFiP3voxeVh7dXJ/YvOB652nV8T7L2b96zN/D7rlZfyt++P/iuZ59X+Q+V" +
       "dvZuCKcRdGPk+T9iayvNPrJtVkt9/Oo3Dd28vHZ4c/XZd/3rPaM3mm99Bffx" +
       "Dxyj8zjK3+6+8Hn6tcov70AnD+6xLiv8XbrowqW3V2cCLYoDd3TJHdZ9B1q4" +
       "PRP6Q+DZU9v2+/I78StazIncYrZ2co0L2Pgac+us8SPorKFFHKA6BLrVhAGT" +
       "m9ihdS2/1/3GUbz5gHMpi1nli95jkf7Bs/jOa8z9dNa8PYJuBiyyniLZ3J52" +
       "jvD35PfBX+5M94JntMff6AfD36k9H9hzvUev5npbr9sroO9D35FBr1FlV/Wc" +
       "3b3CWDb1zD7AQ5ehM1bRLh1IvmkpIeep2xrO8EhsmWTXobYnRTm5v3gNkT+X" +
       "NU9F0E1KoEmRlgeH/Y2315rSOto9HM518PPfhw5ekw0+Bp6Lezq4+Ap0sAPC" +
       "jx94kaZEmprH3yvq4+RhlH4ma57Nmqdz0A9dQxYfzppfB3wD7QSSEvFA5la0" +
       "yTEcMv8b3y/zrwPPU3vMP/VKmM+6v/l/4vp3rsH172XNC8Dp9rjOC7SXm8Dh" +
       "cC6Fj74SKSQRdM/V679ZMevuy/6Lsv3/hPKx58/ecNfzwt/kJdCD/zjcyEI3" +
       "6LFtH609HOmf9gNNt3LubtxWIvz8648i6L5rVqmB2+TfOQef2i76kwi66yqL" +
       "Iuj0tnMU/s8i6NxxeIA3/z4K95kIOnMIB1BtO0dBPhdBJwFI1v28v68S5Goc" +
       "4K7lSFFWUcyLKZYCRL53zp84clTvGWWuxdu/lxYPlhwtvGbHe/4Xo/2jON7+" +
       "yeii8vHn29zbXqp8aFv4VWwpTTMsN7DQ9dsa9MFx/tBVse3jOt167OVbP3Hj" +
       "o/upx61bgg8d5AhtD1y5ytp0/Civi6Z/eNfvv+HDz38lL7X8L7tyRrH7JQAA");
}
