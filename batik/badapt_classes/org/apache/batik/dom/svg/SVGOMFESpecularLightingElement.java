package org.apache.batik.dom.svg;
public class SVGOMFESpecularLightingElement extends org.apache.batik.dom.svg.SVGOMFilterPrimitiveStandardAttributes implements org.w3c.dom.svg.SVGFESpecularLightingElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGOMFilterPrimitiveStandardAttributes.
                 xmlTraitInformation);
             t.put(null, SVG_IN_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_CDATA));
             t.put(null, SVG_SURFACE_SCALE_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_SPECULAR_CONSTANT_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_SPECULAR_EXPONENT_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             xmlTraitInformation = t; }
    protected org.apache.batik.dom.svg.SVGOMAnimatedString
      in;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      surfaceScale;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      specularConstant;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      specularExponent;
    protected SVGOMFESpecularLightingElement() { super(
                                                   );
    }
    public SVGOMFESpecularLightingElement(java.lang.String prefix,
                                          org.apache.batik.dom.AbstractDocument owner) {
        super(
          prefix,
          owner);
        initializeLiveAttributes(
          );
    }
    protected void initializeAllLiveAttributes() {
        super.
          initializeAllLiveAttributes(
            );
        initializeLiveAttributes(
          );
    }
    private void initializeLiveAttributes() {
        in =
          createLiveAnimatedString(
            null,
            SVG_IN_ATTRIBUTE);
        surfaceScale =
          createLiveAnimatedNumber(
            null,
            SVG_SURFACE_SCALE_ATTRIBUTE,
            1.0F);
        specularConstant =
          createLiveAnimatedNumber(
            null,
            SVG_SPECULAR_CONSTANT_ATTRIBUTE,
            1.0F);
        specularExponent =
          createLiveAnimatedNumber(
            null,
            SVG_SPECULAR_EXPONENT_ATTRIBUTE,
            1.0F);
    }
    public java.lang.String getLocalName() {
        return SVG_FE_SPECULAR_LIGHTING_TAG;
    }
    public org.w3c.dom.svg.SVGAnimatedString getIn1() {
        return in;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getSurfaceScale() {
        return surfaceScale;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getSpecularConstant() {
        return specularConstant;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getSpecularExponent() {
        return specularExponent;
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMFESpecularLightingElement(
          );
    }
    protected org.apache.batik.util.DoublyIndexedTable getTraitInformationTable() {
        return xmlTraitInformation;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "FrltqrihtGap5ocrZ6V3xS6az3ZTZzn0u6qsBL7f3OGZgmwb41rmAbWSHu9z" +
       "PSt3ms2qUuWrzaokrNajFdyfuJsBXfOyXuTSTkvVklHu2DWsybnefN6tdwWF" +
       "JmN4qo/rzCaOK/CsMiX4HiJu+DbWBsxchZW41fZag41ab1gTIa7MGSntUeoY" +
       "jYNq04EzJw51o+kMhJFty5OWbSE4SY38NubPRgPCF5FuGIm9dk0WV1tvKWma" +
       "MdAbSmMWzr2cUJA1r/UnW71Vz+jlhExyRAodcyuq3SYYpr1KFGpVoapn3HhV" +
       "kXW8klX0xU4gWGLmLnfYBlXFgQmPA361lZM1H2viSKjAbDcRK2RjzI6kwHN8" +
       "1yKHo0jjKhWlxsKeB6ZGDOmg/MDe4syY2Kyqu5miGmOPmOObrksL4bJFYGy4" +
       "zZuD3GW6stEE02dgRbVx0LMrdXo2qa/7wWbTD7o1aicSlqfxVIta25m3UbN1" +
       "z4oNr85IDD1HCRqNHc+SO80pY+T+YtJBshrTG6IYs8pIz+3XrQ2VmkpEr9hu" +
       "x8CUltUZq+Nkvdju3E04rq4ZvW8O07w2bLcjBgsa9JKZ1Y14h1mu2kcbW6Kb" +
       "L+NBu70k2xa3HLZSVoq9pqrwVVlUweStJ3VkTMDCaku087DJUPyW3+kLbJpU" +
       "1PqUljeRtFltBlhQXUd+MpbiTBArEqHhdUJEWX1Tr+wsDKta8pxfxQg+UqWV" +
       "azSwUXvms9NWg905g8qCRuBWLvP6HNNir6q6ERZ40x3MABrQ9HrYHG17/DBE" +
       "UHY1oKtNjXVaW8G1uxs1CvIE5Ze2DZZYKxSjvGDqcIILR2g09NMu38spbiPC" +
       "SW85aJNLzbLwfDEYGRTGSpwaOfk42Kzb5jxYLoX5gB21nM4CzM/xcEi20pa+" +
       "aLfRerYeuTN4G3aNasqTel0wULI3qVZ5ToBXNUNWFdQJdlSEMN7GklYp3xAU" +
       "fJfqDX/QaKzliiEkZiZ78RxpK23XX5JSFVnOyZzeWhV9pJtTOUMwEDKtWkrC" +
       "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" +
       "e24mDSRBelLygweucVIyhu4p/5+Uey6G");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("Lh/LgUlj/+WkyPOgdSBSvP5wcOh3P3qbO5ymE2vh0QmnAEhHlUL1OJ7ILpwI" +
       "dA/crxykD92uJ4+qnLziVwTH5U32w0A22b/L/pLytddo7ifebH15/4qh4ki7" +
       "XdHKfQx07/5tx6Ng+OlbtnbY1kXyue898CuXnj0M3B/YV/h4KJzQ7cmbX+br" +
       "u0FcXr/b/foj//jD/+C1b5cn4v8PA/9OWWIwAAA=");
}
