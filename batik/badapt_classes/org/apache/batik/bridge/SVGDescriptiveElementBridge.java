package org.apache.batik.bridge;
public abstract class SVGDescriptiveElementBridge extends org.apache.batik.bridge.AbstractSVGBridge implements org.apache.batik.bridge.GenericBridge, org.apache.batik.bridge.BridgeUpdateHandler, org.apache.batik.dom.svg.SVGContext {
    org.w3c.dom.Element theElt;
    org.w3c.dom.Element parent;
    org.apache.batik.bridge.BridgeContext theCtx;
    public SVGDescriptiveElementBridge() { super(); }
    public void handleElement(org.apache.batik.bridge.BridgeContext ctx, org.w3c.dom.Element e) {
        org.apache.batik.bridge.UserAgent ua =
          ctx.
          getUserAgent(
            );
        ua.
          handleElement(
            e,
            java.lang.Boolean.
              TRUE);
        if (ctx.
              isDynamic(
                )) {
            org.apache.batik.bridge.SVGDescriptiveElementBridge b;
            b =
              (org.apache.batik.bridge.SVGDescriptiveElementBridge)
                getInstance(
                  );
            b.
              theElt =
              e;
            b.
              parent =
              (org.w3c.dom.Element)
                e.
                getParentNode(
                  );
            b.
              theCtx =
              ctx;
            ((org.apache.batik.dom.svg.SVGOMElement)
               e).
              setSVGContext(
                b);
        }
    }
    public void dispose() { org.apache.batik.bridge.UserAgent ua =
                              theCtx.
                              getUserAgent(
                                );
                            ((org.apache.batik.dom.svg.SVGOMElement)
                               theElt).setSVGContext(null);
                            ua.handleElement(theElt, parent);
                            theElt = null;
                            parent = null; }
    public void handleDOMNodeInsertedEvent(org.w3c.dom.events.MutationEvent evt) {
        org.apache.batik.bridge.UserAgent ua =
          theCtx.
          getUserAgent(
            );
        ua.
          handleElement(
            theElt,
            java.lang.Boolean.
              TRUE);
    }
    public void handleDOMCharacterDataModified(org.w3c.dom.events.MutationEvent evt) {
        org.apache.batik.bridge.UserAgent ua =
          theCtx.
          getUserAgent(
            );
        ua.
          handleElement(
            theElt,
            java.lang.Boolean.
              TRUE);
    }
    public void handleDOMNodeRemovedEvent(org.w3c.dom.events.MutationEvent evt) {
        dispose(
          );
    }
    public void handleDOMAttrModifiedEvent(org.w3c.dom.events.MutationEvent evt) {
        
    }
    public void handleCSSEngineEvent(org.apache.batik.css.engine.CSSEngineEvent evt) {
        
    }
    public void handleAnimatedAttributeChanged(org.apache.batik.dom.svg.AnimatedLiveAttributeValue alav) {
        
    }
    public void handleOtherAnimationChanged(java.lang.String type) {
        
    }
    public float getPixelUnitToMillimeter() {
        return theCtx.
          getUserAgent(
            ).
          getPixelUnitToMillimeter(
            );
    }
    public float getPixelToMM() { return getPixelUnitToMillimeter(
                                           );
    }
    public java.awt.geom.Rectangle2D getBBox() {
        return null;
    }
    public java.awt.geom.AffineTransform getScreenTransform() {
        return theCtx.
          getUserAgent(
            ).
          getTransform(
            );
    }
    public void setScreenTransform(java.awt.geom.AffineTransform at) {
        theCtx.
          getUserAgent(
            ).
          setTransform(
            at);
    }
    public java.awt.geom.AffineTransform getCTM() {
        return null;
    }
    public java.awt.geom.AffineTransform getGlobalTransform() {
        return null;
    }
    public float getViewportWidth() { return theCtx.
                                        getBlockWidth(
                                          theElt);
    }
    public float getViewportHeight() { return theCtx.
                                         getBlockHeight(
                                           theElt);
    }
    public float getFontSize() { return 0;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Pg5Nn8hVm86lT/FHzB7+L3q1D3G4LQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "wUBg92phb6ta8p/fKAp88xzI/yCPfiUq");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("PXUEGdeFnICVoCNEwuG5zhnYf/d2WMPH97A//mOC/a1zYH87j/5xVHr3qZGe" +
       "Kba7ufFA/+rtQHxtj/jajwnxvzgH8W/l0T87adtYFAWH43sjyN+5VchNEF7a" +
       "Q37pxzLlX7huEZbC8EABXqujHOAM0y2ejif/vztHQf8xj/5tVHrHTkGna59R" +
       "zW/fqmqeB0Hcq0b4sajm+htwh/4J5hh2fi1hbGyU3AYMMY6U4jZG0e5/PUdH" +
       "/y2Pfv+ILQ5bOmoFcIejXccW37sdhiTttSXd9rmzu3D4x+fA/lEe/VFUes8O" +
       "NhXpSrDDDpaWG2P+n7eA+eFDC1nvMa9vD+YTkC7ce07e/Xl0Z1R6XFMi2kgV" +
       "a+EY0dydGJZl2Eq094HPuEJ3qZYrREcKuHDXrSrgyVJ+nWb3F91+BTx+Tt4T" +
       "efRoVHrgUAEA/CRPe/AY3ztuAd9jeeJTIGz3+La3H9/Vc/I+kEdPA18P4Gu3" +
       "3aMLNu8ubosISXSgKYAsZooE/HjNUqDOMe5nbgH3e/LED4GQ7XFntx83dE4e" +
       "nEcfikqPANyMFCiKMw8EJ8yvpR6q4MnTKsBUFSwBp0sVaji4VU5rgPDyXg0v" +
       "3x41HHPahUaB92Pn6KKdRy8CXYTX6eI0lV34yK2O+LMgvLKH+srtH/HxOXlk" +
       "HvWj0iUw4vi8mMONY2TE7bDlT+6RffL2I+POyePziNnZct9yRcE6OX4nUc5v" +
       "lYnz8Xt1j/LV249SPidPzaNrUekKQMkaSuK5QbQ05OK7iJNs/NKtYnwOhE/t" +
       "MX7q9mP0zsnLL9leWEelh09gJBRD06MzIK1bBfleEF7bg3zt9oP82XPyfi6P" +
       "kqh0PwDZc52IMTLlDLz07cBLgTd2zrcc+cX0x6/7kGz38ZP0S29cvuexNxa/" +
       "VXzOcPSB0r3j0j1qbFkn7xGfeL7kBYpqFDq4d3er2CuAfSoqPXaT7UNAO+LR" +
       "PuOFP70r/xow5rPlgfdU/D9Z7jNR6b7jcqCp3cPJIp+NSneAIvnj57zDBez5" +
       "m+1lYvudVaC1nY7S3bvC4ycNpvBdH3mrgTiqcvIziHxTsvjC73ADMd5943dN" +
       "+vobQ/JnftD4yu4zDMkSsixv5Z5x6e7dFyFFo/km5LM3be2wrUvE8z986Bv3" +
       "vv9ww/ShncDHxntCtqdv/M1D1/ai4iuF7Fce+9sf+atv/E5xF/b/Ag1M4ZR6" +
       "OQAA");
}
