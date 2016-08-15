package org.apache.batik.dom.svg;
public class SVGOMAnimatedNumber extends org.apache.batik.dom.svg.AbstractSVGAnimatedValue implements org.w3c.dom.svg.SVGAnimatedNumber {
    protected float defaultValue;
    protected boolean allowPercentage;
    protected boolean valid;
    protected float baseVal;
    protected float animVal;
    protected boolean changing;
    public SVGOMAnimatedNumber(org.apache.batik.dom.svg.AbstractElement elt,
                               java.lang.String ns,
                               java.lang.String ln,
                               float val) { this(elt, ns, ln, val, false);
    }
    public SVGOMAnimatedNumber(org.apache.batik.dom.svg.AbstractElement elt,
                               java.lang.String ns,
                               java.lang.String ln,
                               float val,
                               boolean allowPercentage) { super(elt, ns, ln);
                                                          defaultValue = val;
                                                          this.allowPercentage =
                                                            allowPercentage;
    }
    public float getBaseVal() { if (!valid) { update(); }
                                return baseVal; }
    protected void update() { org.w3c.dom.Attr attr = element.getAttributeNodeNS(
                                                                namespaceURI,
                                                                localName);
                              if (attr == null) { baseVal = defaultValue;
                              }
                              else {
                                  java.lang.String v =
                                    attr.
                                    getValue(
                                      );
                                  int len =
                                    v.
                                    length(
                                      );
                                  if (allowPercentage &&
                                        len >
                                        1 &&
                                        v.
                                        charAt(
                                          len -
                                            1) ==
                                        '%') {
                                      baseVal =
                                        0.01F *
                                          java.lang.Float.
                                          parseFloat(
                                            v.
                                              substring(
                                                0,
                                                len -
                                                  1));
                                  }
                                  else {
                                      baseVal =
                                        java.lang.Float.
                                          parseFloat(
                                            v);
                                  }
                              }
                              valid = true; }
    public void setBaseVal(float baseVal) throws org.w3c.dom.DOMException {
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
    public float getAnimVal() { if (hasAnimVal) { return animVal;
                                }
                                if (!valid) { update(); }
                                return baseVal; }
    public org.apache.batik.anim.values.AnimatableValue getUnderlyingValue(org.apache.batik.dom.anim.AnimationTarget target) {
        return new org.apache.batik.anim.values.AnimatableNumberValue(
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
              ((org.apache.batik.anim.values.AnimatableNumberValue)
                 val).
                getValue(
                  );
        }
        fireAnimatedAttributeListeners(
          );
    }
    public void attrAdded(org.w3c.dom.Attr node, java.lang.String newv) {
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
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALV6C8zs2F3ffHf37t692ey9u3ktS7KP5CZkd5Lr8Yxn7OnS" +
       "EI/H9szYHs/TnnEoNx6/xuP3e8Z0S4gIiYgUonYDQYWVkIIaICSo7aoIRLuA" +
       "WkhBUCpUaNUmUYvUtJCKqC1FpG167Pne97t3d7PbT/L5PMf/c87/93/b53zh" +
       "G5XLUVip+p69M2wvvqlt45sbu3kz3vladHPANkdyGGkqYctRNAN9t5R3/vK1" +
       "v/zWp9fXL1Xukypvkl3Xi+XY9NxookWenWoqW7l20kvamhPFlevsRk5lKIlN" +
       "G2LNKH6Wrbzh1NC4coM9YgECLECABahkAcJPqMCgN2pu4hDFCNmNo6DydyoH" +
       "bOU+XynYiytPnZ3El0PZOZxmVCIAM1wpfgsAVDl4G1aePMa+x3wb4M9Uoed/" +
       "8geu/8N7KtekyjXTnRbsKICJGCwiVR50NGelhRGuqpoqVR52NU2daqEp22Ze" +
       "8i1VHolMw5XjJNSOhVR0Jr4WlmueSO5BpcAWJkrshcfwdFOz1aNfl3VbNgDW" +
       "t55g3SOkin4A8KoJGAt1WdGOhtxrma4aV544P+IY4w0GEICh9ztavPaOl7rX" +
       "lUFH5ZG97mzZNaBpHJquAUgvewlYJa48dsdJC1n7smLJhnYrrjx6nm60fwSo" +
       "HigFUQyJK285T1bOBLT02DktndLPN4bf+6kfdHvupZJnVVPsgv8rYNDj5wZN" +
       "NF0LNVfR9gMffIb9Cfmtv/6JS5UKIH7LOeI9zT/529/84Psef+l39jTffQEN" +
       "v9poSnxL+dzqoT98O/F0+56CjSu+F5mF8s8gL81/dPjk2a0PPO+txzMWD28e" +
       "PXxp8i+WH/kF7c8uVa72K/cpnp04wI4eVjzHN20tpDVXC+VYU/uVBzRXJcrn" +
       "/cr94J41XW3fy+t6pMX9yr122XWfV/4GItLBFIWI7gf3pqt7R/e+HK/L+61f" +
       "qVTuB1flBrjeXdn/vato4sotaO05GiQrsmu6HjQKvQJ/BGluvAKyXUMrYPUW" +
       "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" +
       "9ZuH0H/z9YF+z3G1dFCemqifYH3kLljf");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("XDRvjCsPFliP9rHOwX3otcJtgOsPDuH+weuq6RO4JZrH74L0yaL5rhgUQQDp" +
       "RHO89Dagj72qwyDASy44OlmcA3v0tiPa+2PFyhdfuHblbS/M/7g8PXh89PcB" +
       "tnJFT2z79BGJU/f3+aGmm6UUHtgfmPBLQN9zmNUuOjYWV+4BbcHzwXv21M/E" +
       "lTdfRA0oQXua8v2HjnOaMq5cLv+fpquBjHJCBwqK/c1pkgaYHZAUt4h/5JXw" +
       "y551O1U+l5Fne3CqAD40sTIGPfJyCjsecvqUYlE0l2ftjwrcZH/a/pbypRcG" +
       "wx/8Zuvn9qckFVvO82KWK2zl/v2BzeMi+ak7znY01329p7/10C8/8O6jgv6h" +
       "PcMn5n6KtycuPpJIOn5cHiLMf+Vt//h7/8ELXyn3rf8f3kSqgAQxAAA=");
}
