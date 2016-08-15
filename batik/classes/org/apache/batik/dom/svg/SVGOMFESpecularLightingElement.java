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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "0s/G0HtuJQ0kQXpS8kN71zgpGUMXt/8n");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("5Z6LoSvHcmDS2N2cFHketA5EitsfDQ797sfvcIbTcmM9PNrhFAHpaEqoHccT" +
       "+YUTge7e/baD9OE79eRRlZNH/IrgeHuS/TCQTXZn2V9Sv/4a0/+pN/Gv7I4Y" +
       "qq6y2RSt3M9C9+1OOx4Fw8/ctrXDti51n/v+g79++YOHgfuDO4WPh8IJ3Z66" +
       "9WE+ahnE2+N3m9969B985O++9p3tjvj/AxjX+7RiMAAA");
}
