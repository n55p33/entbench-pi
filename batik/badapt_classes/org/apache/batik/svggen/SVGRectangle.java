package org.apache.batik.svggen;
public class SVGRectangle extends org.apache.batik.svggen.SVGGraphicObjectConverter {
    private org.apache.batik.svggen.SVGLine svgLine;
    public SVGRectangle(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          generatorContext);
        svgLine =
          new org.apache.batik.svggen.SVGLine(
            generatorContext);
    }
    public org.w3c.dom.Element toSVG(java.awt.geom.Rectangle2D rect) {
        return toSVG(
                 (java.awt.geom.RectangularShape)
                   rect);
    }
    public org.w3c.dom.Element toSVG(java.awt.geom.RoundRectangle2D rect) {
        org.w3c.dom.Element svgRect =
          toSVG(
            (java.awt.geom.RectangularShape)
              rect);
        if (svgRect !=
              null &&
              svgRect.
              getTagName(
                ) ==
              SVG_RECT_TAG) {
            svgRect.
              setAttributeNS(
                null,
                SVG_RX_ATTRIBUTE,
                doubleString(
                  java.lang.Math.
                    abs(
                      rect.
                        getArcWidth(
                          ) /
                        2)));
            svgRect.
              setAttributeNS(
                null,
                SVG_RY_ATTRIBUTE,
                doubleString(
                  java.lang.Math.
                    abs(
                      rect.
                        getArcHeight(
                          ) /
                        2)));
        }
        return svgRect;
    }
    private org.w3c.dom.Element toSVG(java.awt.geom.RectangularShape rect) {
        if (rect.
              getWidth(
                ) >
              0 &&
              rect.
              getHeight(
                ) >
              0) {
            org.w3c.dom.Element svgRect =
              generatorContext.
                domFactory.
              createElementNS(
                SVG_NAMESPACE_URI,
                SVG_RECT_TAG);
            svgRect.
              setAttributeNS(
                null,
                SVG_X_ATTRIBUTE,
                doubleString(
                  rect.
                    getX(
                      )));
            svgRect.
              setAttributeNS(
                null,
                SVG_Y_ATTRIBUTE,
                doubleString(
                  rect.
                    getY(
                      )));
            svgRect.
              setAttributeNS(
                null,
                SVG_WIDTH_ATTRIBUTE,
                doubleString(
                  rect.
                    getWidth(
                      )));
            svgRect.
              setAttributeNS(
                null,
                SVG_HEIGHT_ATTRIBUTE,
                doubleString(
                  rect.
                    getHeight(
                      )));
            return svgRect;
        }
        else {
            if (rect.
                  getWidth(
                    ) ==
                  0 &&
                  rect.
                  getHeight(
                    ) >
                  0) {
                java.awt.geom.Line2D line =
                  new java.awt.geom.Line2D.Double(
                  rect.
                    getX(
                      ),
                  rect.
                    getY(
                      ),
                  rect.
                    getX(
                      ),
                  rect.
                    getY(
                      ) +
                    rect.
                    getHeight(
                      ));
                return svgLine.
                  toSVG(
                    line);
            }
            else
                if (rect.
                      getWidth(
                        ) >
                      0 &&
                      rect.
                      getHeight(
                        ) ==
                      0) {
                    java.awt.geom.Line2D line =
                      new java.awt.geom.Line2D.Double(
                      rect.
                        getX(
                          ),
                      rect.
                        getY(
                          ),
                      rect.
                        getX(
                          ) +
                        rect.
                        getWidth(
                          ),
                      rect.
                        getY(
                          ));
                    return svgLine.
                      toSVG(
                        line);
                }
            return null;
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVYfYwTxxUf29z3HfcF3PF1B8cB4iN2SKAVPQIBc8AR34c4" +
                                                              "QlXTYMbrsb2w3l12x3e+S9ImVBVUlSJKCCFV4K+LUBENaZv0Q2oiqqhNorSV" +
                                                              "ktCPtAqt2n/SpqhBVdOq9Ou92V3vem0fRWos7ex65r03896893tv5vINUmMa" +
                                                              "pIepPMyndGaGB1U+Rg2TpaIKNc390JeQng7Rvxx6f2RzkNTGydwsNYclarJd" +
                                                              "MlNSZpwslVWTU1Vi5ghjKeQYM5jJjAnKZU2Nk/myOZTTFVmS+bCWYkhwgBox" +
                                                              "0k45N+RknrMhWwAnS2OwkohYSWS7f3ggRpolTZ9yybs95FHPCFLm3LlMTtpi" +
                                                              "R+gEjeS5rERisskHCgZZp2vKVEbReJgVePiIssk2wd7YpjIT9L3Q+tGtU9k2" +
                                                              "YYJOqqoaF+qZ+5ipKRMsFSOtbu+gwnLmMfI5EoqRJg8xJ/0xZ9IITBqBSR1t" +
                                                              "XSpYfQtT87moJtThjqRaXcIFcbK8VIhODZqzxYyJNYOEem7rLphB22VFbS0t" +
                                                              "y1R8al3kzNOH2r4ZIq1x0iqr47gcCRbBYZI4GJTlkswwt6dSLBUn7Sps9jgz" +
                                                              "ZKrI0/ZOd5hyRqU8D9vvmAU78zozxJyurWAfQTcjL3HNKKqXFg5l/6tJKzQD" +
                                                              "ui5wdbU03IX9oGCjDAsz0hT8zmaZc1RWU5z0+jmKOvY/AATAWpdjPKsVp5qj" +
                                                              "UuggHZaLKFTNRMbB9dQMkNZo4IAGJ4uqCkVb61Q6SjMsgR7poxuzhoCqQRgC" +
                                                              "WTiZ7ycTkmCXFvl2ybM/N0a2PPGwukcNkgCsOcUkBdffBEw9PqZ9LM0MBnFg" +
                                                              "MTavjZ2lC14+GSQEiOf7iC2a7zxy8/71PVdft2gWV6AZTR5hEk9IM8m5by2J" +
                                                              "rtkcwmXU65op4+aXaC6ibMweGSjogDALihJxMOwMXt33o888dol9ECSNQ6RW" +
                                                              "0pR8DvyoXdJyuqwwYzdTmUE5Sw2RBqamomJ8iNTBd0xWmdU7mk6bjA+ROYro" +
                                                              "qtXEfzBRGkSgiRrhW1bTmvOtU54V3wWdEFIHD2mGZwWxfuLNyacjWS3HIlSi" +
                                                              "qqxqkTFDQ/3NCCBOEmybjSTB649GTC1vgAtGNCMToeAHWeYMTGQyTI2MH9i9" +
                                                              "D/jAqRQWRgfTPz7RBdSqczIQAIMv8Ye7ApGyR1NSzEhIZ/I7Bm8+n3jTciV0" +
                                                              "f9seAFAwW9iaLSxmC1uzhb2zkUBATDIPZ7V2FPbjKEQ2QGvzmvGH9h4+2RcC" +
                                                              "V9In54AxkbSvJMVE3fB3MDshXelomV5+fcOrQTInRjqoxPNUwYyx3cgAFklH" +
                                                              "7XBtTkLycXPAMk8OwORlaBJLAQRVywW2lHptghnYz8k8jwQnQ2EsRqrnh4rr" +
                                                              "J1fPTT5+4PN3B0mwFPZxyhpALGQfQ7AugnK/P9wryW098f5HV84+qrmBX5JH" +
                                                              "nPRXxok69PndwG+ehLR2GX0p8fKj/cLsDQDMnEIgAeb1+OcowZUBB6NRl3pQ" +
                                                              "OK0ZOargkGPjRp41tEm3R/hnu/ieB27RhIHWBc96O/LEG0cX6Nh2Wf6MfubT" +
                                                              "QuSA+8b187/86R/uFeZ20kWrJ8+PMz7ggSgU1iHAqN112/0GY0D33rmxJ5+6" +
                                                              "ceKg8FmgWFFpwn5sowBNsIVg5i++fuzd31yfuRZ0/ZxDjs4nodQpFJXEftI4" +
                                                              "i5Iw2yp3PQBxCkQZek3/gyr4p5yWaVJhGFj/bF254aU/PdFm+YECPY4brb+9" +
                                                              "ALd/4Q7y2JuH/tYjxAQkTLGuzVwyC7c7XcnbDYNO4ToKj7+99JnX6HnIAIC6" +
                                                              "pjzNBJAG7FjHRXVzsm4WILFxXTPs6kJs9CbBebdoN6KRhDwixjZjs9L0Bkxp" +
                                                              "THrKp4R06tqHLQc+fOWm0LC0/vL6xzDVByyXxGZVAcR3+QFtDzWzQLfx6shn" +
                                                              "25Srt0BiHCRKAMvmqAFYWijxJpu6pu5XP3h1weG3QiS4izQqGk3toiIwSQNE" +
                                                              "BDOzAMMFfdv9lkNM1kPTJlQlZcqXdeCm9Fbe7sGczsUGTX+368UtFy9cF56p" +
                                                              "WzIWF5F4SQkSiyreBYNL73zyZxe/cnbSqgPWVEdAH1/3P0aV5PHf/b3M5AL7" +
                                                              "KtQoPv545PKzi6JbPxD8Lgghd3+hPJsBkLu891zK/TXYV/vDIKmLkzbJrpoP" +
                                                              "UCWPoR2HStF0SmmorEvGS6s+q8QZKILsEj8Aeqb1w5+bReEbqfG7xYd4WGaQ" +
                                                              "JfCstsFgtR/xAkR8PCBYVot2LTZ3OQBTpxsynKyYD2GaZhEKTBB6WDA5sdk7" +
                                                              "S2winYW72H4Km5g12X2VPNYaWo3NuuKSxK/WX1N5Qc91SYJxt7Ra2StK9pnj" +
                                                              "Zy6kRp/bYDllR2kpOQgnpa///F8/Dp/77RsV6pkGrul3KWyCKZ45QzhlSRgM" +
                                                              "ixOB61PvzT39++/1Z3bcSS2CfT23qTbwfy8osbZ6ZPmX8trxPy7avzV7+A7K" +
                                                              "il6fOf0ivzZ8+Y3dq6TTQXH8sZy97NhUyjRQ6uKNBoNznrq/xNFXFB2gEze2" +
                                                              "G56NtgNsrJzaK/hOMWFWY/WlCV/aWSiwkU7ycIZpuXCxZL1np5gyM0uSEZua" +
                                                              "5KSGaxAHjsBOjJXJe6VwCsThwZ7ZJ3IRGtIsofE/gDl2RHXRf6jceNtsC2y7" +
                                                              "c+NVY53deD0+42l5NeW3YGEWCz6CjelYEP/kXFPxj8FUAmwWwjNq6zt6G1ON" +
                                                              "lMNmNdY7M5VlpbxCjfEs1ZmY98QspvoyNsermOoL/w9TFThp9h7asHLoLrsE" +
                                                              "si4upOcvtNZ3XXjwFwLvipcLzYBc6byieHOb57tWN1haFuo0W5lOF68nOemq" +
                                                              "kmGgQrY+xKpPW/RnOWnz04NlxNtL9wwnjS4diLI+vCTPchICEvw8rzt7tWG2" +
                                                              "UtSgelaWrNQPZQLgNIeyLlCaoYo7M/92O+NJaitKMF7c0jl4nLfu6eDMe2Hv" +
                                                              "yMM3P/GcdYiRFDo9jVKaYqTOOk8VMX15VWmOrNo9a27NfaFhZdB2sXZrwW4E" +
                                                              "LPb4XxR8WUeXWOSr8M3+YqH/7syWV35ysvZtSKsHSYACFh4sr5YKeh6S6cGY" +
                                                              "m049t7zi6DGw5qtTW9en//xrUY+SsirUT5+Qrl186J3T3TNwRGkaIjVQAbCC" +
                                                              "KON2TqngzhNGnLTI5mABlghSZKoMkfq8Kh/Ls6FUjMxF76V4fyfsYpuzpdiL" +
                                                              "R2BO+sou6ipcHEDtPsmMHQiDIstB/nV7Sq4PnbSY13Ufg9tT3Mp55bonpJ1f" +
                                                              "av3+qY7QLojAEnW84uvMfLKYcr03im4ObrMA7j/wC8Dzb3xw07ED31DxRu3b" +
                                                              "tWXF6zU4JFhjoURsWNcd2qaQbsXQFWy+UcB+TgJr7V4PKuLfF8X83xKf2Hz7" +
                                                              "v8NtgGZdGAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "pNI/uPf3XveJ57+ZH/n+L0dQkO84IwAA");
}
