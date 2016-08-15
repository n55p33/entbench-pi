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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "+Qh/xaHgv3NxKbMqHwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "XvsLj3+1OPz8H34ew4RAKgAA");
}
