package org.apache.batik.dom.svg;
public class SVGLocatableSupport {
    public SVGLocatableSupport() { super(); }
    public static org.w3c.dom.svg.SVGElement getNearestViewportElement(org.w3c.dom.Element e) {
        org.w3c.dom.Element elt =
          e;
        while (elt !=
                 null) {
            elt =
              org.apache.batik.css.engine.SVGCSSEngine.
                getParentCSSStylableElement(
                  elt);
            if (elt instanceof org.w3c.dom.svg.SVGFitToViewBox) {
                break;
            }
        }
        return (org.w3c.dom.svg.SVGElement)
                 elt;
    }
    public static org.w3c.dom.svg.SVGElement getFarthestViewportElement(org.w3c.dom.Element elt) {
        return (org.w3c.dom.svg.SVGElement)
                 elt.
                 getOwnerDocument(
                   ).
                 getDocumentElement(
                   );
    }
    public static org.w3c.dom.svg.SVGRect getBBox(org.w3c.dom.Element elt) {
        final org.apache.batik.dom.svg.SVGOMElement svgelt =
          (org.apache.batik.dom.svg.SVGOMElement)
            elt;
        org.apache.batik.dom.svg.SVGContext svgctx =
          svgelt.
          getSVGContext(
            );
        if (svgctx ==
              null)
            return null;
        if (svgctx.
              getBBox(
                ) ==
              null)
            return null;
        return new org.w3c.dom.svg.SVGRect(
          ) {
            public float getX() {
                return (float)
                         svgelt.
                         getSVGContext(
                           ).
                         getBBox(
                           ).
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
                         svgelt.
                         getSVGContext(
                           ).
                         getBBox(
                           ).
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
                         svgelt.
                         getSVGContext(
                           ).
                         getBBox(
                           ).
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
                         svgelt.
                         getSVGContext(
                           ).
                         getBBox(
                           ).
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
    public static org.w3c.dom.svg.SVGMatrix getCTM(org.w3c.dom.Element elt) {
        final org.apache.batik.dom.svg.SVGOMElement svgelt =
          (org.apache.batik.dom.svg.SVGOMElement)
            elt;
        return new org.apache.batik.dom.svg.AbstractSVGMatrix(
          ) {
            protected java.awt.geom.AffineTransform getAffineTransform() {
                return svgelt.
                  getSVGContext(
                    ).
                  getCTM(
                    );
            }
        };
    }
    public static org.w3c.dom.svg.SVGMatrix getScreenCTM(org.w3c.dom.Element elt) {
        final org.apache.batik.dom.svg.SVGOMElement svgelt =
          (org.apache.batik.dom.svg.SVGOMElement)
            elt;
        return new org.apache.batik.dom.svg.AbstractSVGMatrix(
          ) {
            protected java.awt.geom.AffineTransform getAffineTransform() {
                org.apache.batik.dom.svg.SVGContext context =
                  svgelt.
                  getSVGContext(
                    );
                java.awt.geom.AffineTransform ret =
                  context.
                  getGlobalTransform(
                    );
                java.awt.geom.AffineTransform scrnTrans =
                  context.
                  getScreenTransform(
                    );
                if (scrnTrans !=
                      null)
                    ret.
                      preConcatenate(
                        scrnTrans);
                return ret;
            }
        };
    }
    public static org.w3c.dom.svg.SVGMatrix getTransformToElement(org.w3c.dom.Element elt,
                                                                  org.w3c.dom.svg.SVGElement element)
          throws org.w3c.dom.svg.SVGException {
        final org.apache.batik.dom.svg.SVGOMElement currentElt =
          (org.apache.batik.dom.svg.SVGOMElement)
            elt;
        final org.apache.batik.dom.svg.SVGOMElement targetElt =
          (org.apache.batik.dom.svg.SVGOMElement)
            element;
        return new org.apache.batik.dom.svg.AbstractSVGMatrix(
          ) {
            protected java.awt.geom.AffineTransform getAffineTransform() {
                java.awt.geom.AffineTransform cat =
                  currentElt.
                  getSVGContext(
                    ).
                  getGlobalTransform(
                    );
                if (cat ==
                      null) {
                    cat =
                      new java.awt.geom.AffineTransform(
                        );
                }
                java.awt.geom.AffineTransform tat =
                  targetElt.
                  getSVGContext(
                    ).
                  getGlobalTransform(
                    );
                if (tat ==
                      null) {
                    tat =
                      new java.awt.geom.AffineTransform(
                        );
                }
                java.awt.geom.AffineTransform at =
                  new java.awt.geom.AffineTransform(
                  cat);
                try {
                    at.
                      preConcatenate(
                        tat.
                          createInverse(
                            ));
                    return at;
                }
                catch (java.awt.geom.NoninvertibleTransformException ex) {
                    throw currentElt.
                      createSVGException(
                        org.w3c.dom.svg.SVGException.
                          SVG_MATRIX_NOT_INVERTABLE,
                        "noninvertiblematrix",
                        null);
                }
            }
        };
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "P1MVXQYJGgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "rDCtiaLmlmqlsI6Xijwzzy0ZGFZGWm21KAaoba7EMTyInaU8GUYiPQl0i+OL" +
       "FXEO3Bi4U6dlSlVYhVnPrRKOPiJA6HYUlBUbCdblsSDW1Ghp1gu5IkhnSgXW" +
       "S7NaoszNJmFRpmdoqCnOmlZf8VBxjfRzM67bUPV8YZJbFIla0g8kehYv/fEK" +
       "8OmvkxCVJZKv9V1c8wd+NBajBjLN6XOvVizVghqzkifORPXyVIft+h0jF0cd" +
       "WYpnSD1UB4yWj+K1pnpUrSG6dXdKLdY8NgAejukre16ZsZWCwYrqujavoe3V" +
       "uiCXtWWlJhMCMWQcrVas+PE8n4MJQZqOUaY05fPN2qBCLqcN0dE7aBnsDmUO" +
       "y5tIvVCpjWdxHAmLilqfrPpFblZP1jLVjimFcmxtkmdGwhJeiu1cxIyTYA6b" +
       "Lc5FdYQ15y3CYIUiXaD4JuGuVUPTZD2pOH2B7uZxQejpWrPZwfzEixgTZBB3" +
       "PKHgnMKibM2vFjWELtqjSowyM1uty2hUIHOEUxQKc96p+XK1oU+9XmtEGLi3" +
       "KMprWWPXK7wQBeqiWWIrAdtnO2VY02B4ssRiPpcbc5wldGh6mQ9nQySOEynG" +
       "zLFdmjT1oTQsVnN+AyikplbEihuVKASoQeFWgzJMVgmLnonMIq5YMGnb0xwy" +
       "59EJ2yl2mmOUryPFZZKrMkuNR3W1wKnTnMv18vrYahAlE17IfYrs60jbm6o9" +
       "ySZYZ9yo+LzZKTcbjYKuseMwqNdmErsIiMKADHi7ErUUbV1sT7CV6HoNnVMp" +
       "mivg+Sk708ZTI4ZzodNb18s2UfYTrofPV3m9r3aVyWrZNHQDra9tkaKaxSpD" +
       "rezpvLjuTWOdbIpeyyrkRHtak4OpR7CTNW1ICrvWciWhwsyFgVad50YNrYHk" +
       "tMZwqXUmDL0e6QO3GcYkVkRgJ0/hzSDSI52YtntYK8GAi4DCp9sf9galQp+g" +
       "RxjZRzt0gPPV2YiaDgKXGBtRfeAOixFGzNyuWBpiIyunWYFZLmiuwTtyswy7" +
       "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" +
       "VtYa+X9ppHl0hyUAAA==");
}
