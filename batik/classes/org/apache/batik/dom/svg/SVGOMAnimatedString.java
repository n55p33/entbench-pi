package org.apache.batik.dom.svg;
public class SVGOMAnimatedString extends org.apache.batik.dom.svg.AbstractSVGAnimatedValue implements org.w3c.dom.svg.SVGAnimatedString {
    protected java.lang.String animVal;
    public SVGOMAnimatedString(org.apache.batik.dom.svg.AbstractElement elt,
                               java.lang.String ns,
                               java.lang.String ln) { super(elt, ns, ln);
    }
    public java.lang.String getBaseVal() { return element.getAttributeNS(
                                                            namespaceURI,
                                                            localName); }
    public void setBaseVal(java.lang.String baseVal) throws org.w3c.dom.DOMException {
        element.
          setAttributeNS(
            namespaceURI,
            localName,
            baseVal);
    }
    public java.lang.String getAnimVal() { if (hasAnimVal) { return animVal;
                                           }
                                           return element.getAttributeNS(
                                                            namespaceURI,
                                                            localName);
    }
    public org.apache.batik.anim.values.AnimatableValue getUnderlyingValue(org.apache.batik.dom.anim.AnimationTarget target) {
        return new org.apache.batik.anim.values.AnimatableStringValue(
          target,
          getBaseVal(
            ));
    }
    protected void updateAnimatedValue(org.apache.batik.anim.values.AnimatableValue val) {
        if (val ==
              null) {
            hasAnimVal =
              false;
        }
        else {
            hasAnimVal =
              true;
            this.
              animVal =
              ((org.apache.batik.anim.values.AnimatableStringValue)
                 val).
                getString(
                  );
        }
        fireAnimatedAttributeListeners(
          );
    }
    public void attrAdded(org.w3c.dom.Attr node, java.lang.String newv) {
        fireBaseAttributeListeners(
          );
        if (!hasAnimVal) {
            fireAnimatedAttributeListeners(
              );
        }
    }
    public void attrModified(org.w3c.dom.Attr node,
                             java.lang.String oldv,
                             java.lang.String newv) {
        fireBaseAttributeListeners(
          );
        if (!hasAnimVal) {
            fireAnimatedAttributeListeners(
              );
        }
    }
    public void attrRemoved(org.w3c.dom.Attr node,
                            java.lang.String oldv) {
        fireBaseAttributeListeners(
          );
        if (!hasAnimVal) {
            fireAnimatedAttributeListeners(
              );
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "SM5H+CsOBf8FjmwpJSofAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
