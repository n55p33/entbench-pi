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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AV14s6gJGgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Y8SMdT2h667jVPhCWF7zjD2W3OFsUOx2egs+7xpzvu7ONLZQ6627piSh1HIu" +
       "TevWFG4XfU+u0XlxyueDISNFrRLjk8vmnDVjwi7Zw7UlG8FoRhfCahejyrIe" +
       "EbU6UaB8s8j4YbttjlyZxq11fjRaGsUmW2kVCg1D68gDHGcK/Ynjr1khLrQN" +
       "lOVYvqbDQ0Yfz+sMOTK1Lu7a7QQ1NLM/a48nemksVT0jlvt1nq6O60sXLs66" +
       "+ZheWEV4vpwV+gKQ+pC0JFJrFbShkKzqJKInptjLMU6tuJqpM2dl0yRSyRV6" +
       "E6Ta4Um/bODJtJ6v0b0iSy67nmeVwwmM4utJUW+4chcZ5VUHs2au0kOIgSyw" +
       "+cWw1Z9QUbHZdXodFsVy8/FAnaFwwcg5TJuX8jQ/agyQ5ShoM2G7EhXXJGuN" +
       "uqUFNe6QBXKhNvEcS6y0/nq9TBRH1SV+EDcIc8ySSoleFetsi9Q0tjaOMMWP" +
       "vWk3yJdKjL225RFN1YZrg3TL2GIwGor54iKacRO+AVx7PJ4ECkE5QivHz/HF" +
       "cM5FQ4bTi4PxkBn3Ok2FIBgJmdXJTqRFXFJDaKFrzfvaOuy1othrhKP80quz" +
       "Zrvk1XxGkOrDauIElFPiPR6Nct1uzcJgfgqcU8q7zKy77nBqe4nCuZlnTKWg" +
       "UOkEs/6gzrEyVR/POTxPL/E202SaS00jh4tKZM7LBaLMT6woHw99BV+UAjFo" +
       "2cm8AjdjjBAXs4HZbVNEz1Xy2LI8HRDMQpiwZbYznI4TpAyvVLk34Py+sRg5" +
       "FZadduk62qS7jCNIHljuxizXcPtioFtrDZkV8Lg30xvUUBqv510EWGFg1VZ8" +
       "4vsYSfH9kkRVmouc0tNC3+Zi2R46VTjHFuGKolh4DAzRbXTdYlVrdCvNclRa" +
       "NQm9EcBlXk9yVbnfcBPGoPqqYRqxmPBLqo+NS2ilSw2N4RLNjyV9XMKWjU5t" +
       "ykh1i6zPZs2O3WuvuzZqs/ZMV5cjzWjHyUjn2JG0tmpSwvabvXCQJ+rVgOzB" +
       "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");
}
