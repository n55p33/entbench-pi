package org.apache.batik.dom.svg;
public class SVGOMAnimatedBoolean extends org.apache.batik.dom.svg.AbstractSVGAnimatedValue implements org.w3c.dom.svg.SVGAnimatedBoolean {
    protected boolean defaultValue;
    protected boolean valid;
    protected boolean baseVal;
    protected boolean animVal;
    protected boolean changing;
    public SVGOMAnimatedBoolean(org.apache.batik.dom.svg.AbstractElement elt,
                                java.lang.String ns,
                                java.lang.String ln,
                                boolean val) { super(elt, ns, ln);
                                               defaultValue = val; }
    public boolean getBaseVal() { if (!valid) { update(); }
                                  return baseVal; }
    protected void update() { org.w3c.dom.Attr attr = element.getAttributeNodeNS(
                                                                namespaceURI,
                                                                localName);
                              if (attr == null) { baseVal = defaultValue;
                              }
                              else {
                                  baseVal =
                                    attr.
                                      getValue(
                                        ).
                                      equals(
                                        "true");
                              }
                              valid = true; }
    public void setBaseVal(boolean baseVal) throws org.w3c.dom.DOMException {
        try {
            this.
              baseVal =
              baseVal;
            valid =
              true;
            changing =
              true;
            element.
              setAttributeNS(
                namespaceURI,
                localName,
                java.lang.String.
                  valueOf(
                    baseVal));
        }
        finally {
            changing =
              false;
        }
    }
    public boolean getAnimVal() { if (hasAnimVal) { return animVal;
                                  }
                                  if (!valid) { update(); }
                                  return baseVal; }
    public void setAnimatedValue(boolean animVal) { hasAnimVal = true;
                                                    this.animVal =
                                                      animVal;
                                                    fireAnimatedAttributeListeners(
                                                      ); }
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
              ((org.apache.batik.anim.values.AnimatableBooleanValue)
                 val).
                getValue(
                  );
        }
        fireAnimatedAttributeListeners(
          );
    }
    public org.apache.batik.anim.values.AnimatableValue getUnderlyingValue(org.apache.batik.dom.anim.AnimationTarget target) {
        return new org.apache.batik.anim.values.AnimatableBooleanValue(
          target,
          getBaseVal(
            ));
    }
    public void attrAdded(org.w3c.dom.Attr node,
                          java.lang.String newv) {
        if (!changing) {
            valid =
              false;
        }
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
        if (!changing) {
            valid =
              false;
        }
        fireBaseAttributeListeners(
          );
        if (!hasAnimVal) {
            fireAnimatedAttributeListeners(
              );
        }
    }
    public void attrRemoved(org.w3c.dom.Attr node,
                            java.lang.String oldv) {
        if (!changing) {
            valid =
              false;
        }
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
       "MrjD95YqOHu5kfNtWS++XfYfIj3Mr6ckAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "7K9K+CWixw/j9+3uSEWVe0BdMH3usT31");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("k4Df21EDSlCfprxxaDmnKaPKhfL/abofALHzhA6kTvuH0yTPgNEBSfEI+Udm" +
       "WXvDi12nvhT2/vzcqVT/UMdKS3zwjVbsuMvpK3nF50F5t/wolY/3t8ufU195" +
       "aTj6sddaX9xfCVRtOc+LUS4zlUv724nHnwNP3nG0o7EuUk+/fv8vX/nA0afL" +
       "/XuGT/T9FG9P3P7+Xd/xo/LGXP6rD//KD/69l/6oPE7/v6S/ujD0LwAA");
}
