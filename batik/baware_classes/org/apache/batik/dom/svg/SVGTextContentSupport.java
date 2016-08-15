package org.apache.batik.dom.svg;
public class SVGTextContentSupport {
    public static int getNumberOfChars(org.w3c.dom.Element elt) { final org.apache.batik.dom.svg.SVGOMElement svgelt =
                                                                    (org.apache.batik.dom.svg.SVGOMElement)
                                                                      elt;
                                                                  return ((org.apache.batik.dom.svg.SVGTextContent)
                                                                            svgelt.
                                                                            getSVGContext(
                                                                              )).
                                                                    getNumberOfChars(
                                                                      );
    }
    public static org.w3c.dom.svg.SVGRect getExtentOfChar(org.w3c.dom.Element elt,
                                                          final int charnum) {
        final org.apache.batik.dom.svg.SVGOMElement svgelt =
          (org.apache.batik.dom.svg.SVGOMElement)
            elt;
        if (charnum <
              0 ||
              charnum >=
              getNumberOfChars(
                elt)) {
            throw svgelt.
              createDOMException(
                org.w3c.dom.DOMException.
                  INDEX_SIZE_ERR,
                "",
                null);
        }
        final org.apache.batik.dom.svg.SVGTextContent context =
          (org.apache.batik.dom.svg.SVGTextContent)
            svgelt.
            getSVGContext(
              );
        return new org.w3c.dom.svg.SVGRect(
          ) {
            public float getX() {
                return (float)
                         org.apache.batik.dom.svg.SVGTextContentSupport.
                         getExtent(
                           svgelt,
                           context,
                           charnum).
                         getX(
                           );
            }
            public void setX(float x)
                  throws org.w3c.dom.DOMException {
                throw svgelt.
                  createDOMException(
                    org.w3c.dom.DOMException.
                      NO_MODIFICATION_ALLOWED_ERR,
                    "readonly.rect",
                    null);
            }
            public float getY() {
                return (float)
                         org.apache.batik.dom.svg.SVGTextContentSupport.
                         getExtent(
                           svgelt,
                           context,
                           charnum).
                         getY(
                           );
            }
            public void setY(float y)
                  throws org.w3c.dom.DOMException {
                throw svgelt.
                  createDOMException(
                    org.w3c.dom.DOMException.
                      NO_MODIFICATION_ALLOWED_ERR,
                    "readonly.rect",
                    null);
            }
            public float getWidth() {
                return (float)
                         org.apache.batik.dom.svg.SVGTextContentSupport.
                         getExtent(
                           svgelt,
                           context,
                           charnum).
                         getWidth(
                           );
            }
            public void setWidth(float width)
                  throws org.w3c.dom.DOMException {
                throw svgelt.
                  createDOMException(
                    org.w3c.dom.DOMException.
                      NO_MODIFICATION_ALLOWED_ERR,
                    "readonly.rect",
                    null);
            }
            public float getHeight() {
                return (float)
                         org.apache.batik.dom.svg.SVGTextContentSupport.
                         getExtent(
                           svgelt,
                           context,
                           charnum).
                         getHeight(
                           );
            }
            public void setHeight(float height)
                  throws org.w3c.dom.DOMException {
                throw svgelt.
                  createDOMException(
                    org.w3c.dom.DOMException.
                      NO_MODIFICATION_ALLOWED_ERR,
                    "readonly.rect",
                    null);
            }
        };
    }
    protected static java.awt.geom.Rectangle2D getExtent(org.apache.batik.dom.svg.SVGOMElement svgelt,
                                                         org.apache.batik.dom.svg.SVGTextContent context,
                                                         int charnum) {
        java.awt.geom.Rectangle2D r2d =
          context.
          getExtentOfChar(
            charnum);
        if (r2d ==
              null)
            throw svgelt.
              createDOMException(
                org.w3c.dom.DOMException.
                  INDEX_SIZE_ERR,
                "",
                null);
        return r2d;
    }
    public static org.w3c.dom.svg.SVGPoint getStartPositionOfChar(org.w3c.dom.Element elt,
                                                                  final int charnum)
          throws org.w3c.dom.DOMException {
        final org.apache.batik.dom.svg.SVGOMElement svgelt =
          (org.apache.batik.dom.svg.SVGOMElement)
            elt;
        if (charnum <
              0 ||
              charnum >=
              getNumberOfChars(
                elt)) {
            throw svgelt.
              createDOMException(
                org.w3c.dom.DOMException.
                  INDEX_SIZE_ERR,
                "",
                null);
        }
        final org.apache.batik.dom.svg.SVGTextContent context =
          (org.apache.batik.dom.svg.SVGTextContent)
            svgelt.
            getSVGContext(
              );
        return new org.apache.batik.dom.svg.SVGTextContentSupport.SVGTextPoint(
          svgelt) {
            public float getX() {
                return (float)
                         org.apache.batik.dom.svg.SVGTextContentSupport.
                         getStartPos(
                           this.
                             svgelt,
                           context,
                           charnum).
                         getX(
                           );
            }
            public float getY() {
                return (float)
                         org.apache.batik.dom.svg.SVGTextContentSupport.
                         getStartPos(
                           this.
                             svgelt,
                           context,
                           charnum).
                         getY(
                           );
            }
        };
    }
    protected static java.awt.geom.Point2D getStartPos(org.apache.batik.dom.svg.SVGOMElement svgelt,
                                                       org.apache.batik.dom.svg.SVGTextContent context,
                                                       int charnum) {
        java.awt.geom.Point2D p2d =
          context.
          getStartPositionOfChar(
            charnum);
        if (p2d ==
              null)
            throw svgelt.
              createDOMException(
                org.w3c.dom.DOMException.
                  INDEX_SIZE_ERR,
                "",
                null);
        return p2d;
    }
    public static org.w3c.dom.svg.SVGPoint getEndPositionOfChar(org.w3c.dom.Element elt,
                                                                final int charnum)
          throws org.w3c.dom.DOMException {
        final org.apache.batik.dom.svg.SVGOMElement svgelt =
          (org.apache.batik.dom.svg.SVGOMElement)
            elt;
        if (charnum <
              0 ||
              charnum >=
              getNumberOfChars(
                elt)) {
            throw svgelt.
              createDOMException(
                org.w3c.dom.DOMException.
                  INDEX_SIZE_ERR,
                "",
                null);
        }
        final org.apache.batik.dom.svg.SVGTextContent context =
          (org.apache.batik.dom.svg.SVGTextContent)
            svgelt.
            getSVGContext(
              );
        return new org.apache.batik.dom.svg.SVGTextContentSupport.SVGTextPoint(
          svgelt) {
            public float getX() {
                return (float)
                         org.apache.batik.dom.svg.SVGTextContentSupport.
                         getEndPos(
                           this.
                             svgelt,
                           context,
                           charnum).
                         getX(
                           );
            }
            public float getY() {
                return (float)
                         org.apache.batik.dom.svg.SVGTextContentSupport.
                         getEndPos(
                           this.
                             svgelt,
                           context,
                           charnum).
                         getY(
                           );
            }
        };
    }
    protected static java.awt.geom.Point2D getEndPos(org.apache.batik.dom.svg.SVGOMElement svgelt,
                                                     org.apache.batik.dom.svg.SVGTextContent context,
                                                     int charnum) {
        java.awt.geom.Point2D p2d =
          context.
          getEndPositionOfChar(
            charnum);
        if (p2d ==
              null)
            throw svgelt.
              createDOMException(
                org.w3c.dom.DOMException.
                  INDEX_SIZE_ERR,
                "",
                null);
        return p2d;
    }
    public static void selectSubString(org.w3c.dom.Element elt,
                                       int charnum,
                                       int nchars) {
        final org.apache.batik.dom.svg.SVGOMElement svgelt =
          (org.apache.batik.dom.svg.SVGOMElement)
            elt;
        if (charnum <
              0 ||
              charnum >=
              getNumberOfChars(
                elt)) {
            throw svgelt.
              createDOMException(
                org.w3c.dom.DOMException.
                  INDEX_SIZE_ERR,
                "",
                null);
        }
        final org.apache.batik.dom.svg.SVGTextContent context =
          (org.apache.batik.dom.svg.SVGTextContent)
            svgelt.
            getSVGContext(
              );
        context.
          selectSubString(
            charnum,
            nchars);
    }
    public static float getRotationOfChar(org.w3c.dom.Element elt,
                                          final int charnum) {
        final org.apache.batik.dom.svg.SVGOMElement svgelt =
          (org.apache.batik.dom.svg.SVGOMElement)
            elt;
        if (charnum <
              0 ||
              charnum >=
              getNumberOfChars(
                elt)) {
            throw svgelt.
              createDOMException(
                org.w3c.dom.DOMException.
                  INDEX_SIZE_ERR,
                "",
                null);
        }
        final org.apache.batik.dom.svg.SVGTextContent context =
          (org.apache.batik.dom.svg.SVGTextContent)
            svgelt.
            getSVGContext(
              );
        return context.
          getRotationOfChar(
            charnum);
    }
    public static float getComputedTextLength(org.w3c.dom.Element elt) {
        final org.apache.batik.dom.svg.SVGOMElement svgelt =
          (org.apache.batik.dom.svg.SVGOMElement)
            elt;
        final org.apache.batik.dom.svg.SVGTextContent context =
          (org.apache.batik.dom.svg.SVGTextContent)
            svgelt.
            getSVGContext(
              );
        return context.
          getComputedTextLength(
            );
    }
    public static float getSubStringLength(org.w3c.dom.Element elt,
                                           int charnum,
                                           int nchars) {
        final org.apache.batik.dom.svg.SVGOMElement svgelt =
          (org.apache.batik.dom.svg.SVGOMElement)
            elt;
        if (charnum <
              0 ||
              charnum >=
              getNumberOfChars(
                elt)) {
            throw svgelt.
              createDOMException(
                org.w3c.dom.DOMException.
                  INDEX_SIZE_ERR,
                "",
                null);
        }
        final org.apache.batik.dom.svg.SVGTextContent context =
          (org.apache.batik.dom.svg.SVGTextContent)
            svgelt.
            getSVGContext(
              );
        return context.
          getSubStringLength(
            charnum,
            nchars);
    }
    public static int getCharNumAtPosition(org.w3c.dom.Element elt,
                                           final float x,
                                           final float y)
          throws org.w3c.dom.DOMException {
        final org.apache.batik.dom.svg.SVGOMElement svgelt =
          (org.apache.batik.dom.svg.SVGOMElement)
            elt;
        final org.apache.batik.dom.svg.SVGTextContent context =
          (org.apache.batik.dom.svg.SVGTextContent)
            svgelt.
            getSVGContext(
              );
        return context.
          getCharNumAtPosition(
            x,
            y);
    }
    public static class SVGTextPoint extends org.apache.batik.dom.svg.SVGOMPoint {
        org.apache.batik.dom.svg.SVGOMElement
          svgelt;
        SVGTextPoint(org.apache.batik.dom.svg.SVGOMElement elem) {
            super(
              );
            svgelt =
              elem;
        }
        public void setX(float x) throws org.w3c.dom.DOMException {
            throw svgelt.
              createDOMException(
                org.w3c.dom.DOMException.
                  NO_MODIFICATION_ALLOWED_ERR,
                "readonly.point",
                null);
        }
        public void setY(float y) throws org.w3c.dom.DOMException {
            throw svgelt.
              createDOMException(
                org.w3c.dom.DOMException.
                  NO_MODIFICATION_ALLOWED_ERR,
                "readonly.point",
                null);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "kcV3v8CnbLj4H+nY3vPpGAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "NQIJIwAA");
    }
    public SVGTextContentSupport() { super(
                                       );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "a0zu2u/+7xV69nYHmvR4z54T6W/9/zz+PID9M7cB+yN58g/AsE/BPunn7cWu" +
       "s5SExysVdJAjLDkrS61hB6B/8g6A/pY8s5oX74FOvuGs+9jtbfb6WWJhAPhU" +
       "Vr3cqRWV/2me/OOw9ChAahZKfnhya+A8O6/fhJ2Me85W/8kdoPZ4nvlt4Pnp" +
       "PWo//UZR+9Dr8jL/+bN58uEDdL9yGw79yzz5ZFh68AwyJ3C89TyLCiTOMuhT" +
       "d8qgvPyjeyw++g1n0L+5OYPyn79YCPxGnnwmLL0ltydHOc+RvOzjB91//U55" +
       "kK9ln97r/ulvDg/+4DY8+Ld58rm9Lyl0zzN+7aDw796BwtfyzBF4PrtX+LNf" +
       "x8k+o/Busg8K/8ltFP5PefLvwUoVqPl5+Sxa7k4Eb7Zc3x27unKA4o/vAIrr" +
       "eWa+Xn9+D8Xnv+G8/8vboPClPPlzEA+DaZ/uw8AzPvECDvdoliudcYb/9U6B" +
       "+A7wfHEPxBe/jkCcMe2gEPib22Dwt3nyP4C7AxjkZ8cRWP/ztXikOqvd9a5X" +
       "Dyr/zztVOQ9PvrJX+SvfFDO4dPetlb90Oc/8Wli6lvv/Exu4meaXSneg+aN7" +
       "zS89uKu7+/8N0vzVIim0u/o6Lv/StTx5cOfyc9aDyB05DQ4KBA8APPRGAEgB" +
       "n256pS2/k3P9NRdod5c+5V9++cp9b3uZ+3xxq+v0Yub9o9J9WmRZZ69QnHm/" +
       "7PmqphfQ3L+7UOEVur19H9DcLN4EnyAgzUd96fpO+h0AhJtJA0mQnpV8Enzk" +
       "XJQEvqH4f1bu6bD0wEEuLF3evZwVeRa0DkTy13d5J2HHmSsTuxsn6S7Ku36W" +
       "W4UxXnu9GTnzpf3Mue/j4qLzybdstLvq/IL8yZcH1Pd/ufULu8tpsiVlWd7K" +
       "faPSvbt7ckWj+ffwU7ds7aSty/3nvvrwp+5/9uTb/eHdgA88PzO2J29++wu3" +
       "vbC4r5X92tt+5Tt/8eU/Le6M/D8FZWAhgS4AAA==");
}
