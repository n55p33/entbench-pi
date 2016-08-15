package org.apache.batik.bridge;
public abstract class AbstractSVGLightingElementBridge extends org.apache.batik.bridge.AbstractSVGFilterPrimitiveElementBridge {
    protected AbstractSVGLightingElementBridge() { super(); }
    protected static org.apache.batik.ext.awt.image.Light extractLight(org.w3c.dom.Element filterElement,
                                                                       org.apache.batik.bridge.BridgeContext ctx) {
        java.awt.Color color =
          org.apache.batik.bridge.CSSUtilities.
          convertLightingColor(
            filterElement,
            ctx);
        for (org.w3c.dom.Node n =
               filterElement.
               getFirstChild(
                 );
             n !=
               null;
             n =
               n.
                 getNextSibling(
                   )) {
            if (n.
                  getNodeType(
                    ) !=
                  org.w3c.dom.Node.
                    ELEMENT_NODE) {
                continue;
            }
            org.w3c.dom.Element e =
              (org.w3c.dom.Element)
                n;
            org.apache.batik.bridge.Bridge bridge =
              ctx.
              getBridge(
                e);
            if (bridge ==
                  null ||
                  !(bridge instanceof org.apache.batik.bridge.AbstractSVGLightingElementBridge.AbstractSVGLightElementBridge)) {
                continue;
            }
            return ((org.apache.batik.bridge.AbstractSVGLightingElementBridge.AbstractSVGLightElementBridge)
                      bridge).
              createLight(
                ctx,
                filterElement,
                e,
                color);
        }
        return null;
    }
    protected static double[] convertKernelUnitLength(org.w3c.dom.Element filterElement,
                                                      org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String s =
          filterElement.
          getAttributeNS(
            null,
            SVG_KERNEL_UNIT_LENGTH_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            return null;
        }
        double[] units =
          new double[2];
        java.util.StringTokenizer tokens =
          new java.util.StringTokenizer(
          s,
          " ,");
        try {
            units[0] =
              org.apache.batik.bridge.SVGUtilities.
                convertSVGNumber(
                  tokens.
                    nextToken(
                      ));
            if (tokens.
                  hasMoreTokens(
                    )) {
                units[1] =
                  org.apache.batik.bridge.SVGUtilities.
                    convertSVGNumber(
                      tokens.
                        nextToken(
                          ));
            }
            else {
                units[1] =
                  units[0];
            }
        }
        catch (java.lang.NumberFormatException nfEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              filterElement,
              nfEx,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_KERNEL_UNIT_LENGTH_ATTRIBUTE,
              s });
        }
        if (tokens.
              hasMoreTokens(
                ) ||
              units[0] <=
              0 ||
              units[1] <=
              0) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              filterElement,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_KERNEL_UNIT_LENGTH_ATTRIBUTE,
              s });
        }
        return units;
    }
    protected abstract static class AbstractSVGLightElementBridge extends org.apache.batik.bridge.AnimatableGenericSVGBridge {
        public abstract org.apache.batik.ext.awt.image.Light createLight(org.apache.batik.bridge.BridgeContext ctx,
                                                                         org.w3c.dom.Element filterElement,
                                                                         org.w3c.dom.Element lightElement,
                                                                         java.awt.Color color);
        public AbstractSVGLightElementBridge() {
            super(
              );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "/wFkiRnbpRQAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public static class SVGFeSpotLightElementBridge extends org.apache.batik.bridge.AbstractSVGLightingElementBridge.AbstractSVGLightElementBridge {
        public SVGFeSpotLightElementBridge() {
            super(
              );
        }
        public java.lang.String getLocalName() {
            return SVG_FE_SPOT_LIGHT_TAG;
        }
        public org.apache.batik.ext.awt.image.Light createLight(org.apache.batik.bridge.BridgeContext ctx,
                                                                org.w3c.dom.Element filterElement,
                                                                org.w3c.dom.Element lightElement,
                                                                java.awt.Color color) {
            double x =
              convertNumber(
                lightElement,
                SVG_X_ATTRIBUTE,
                0,
                ctx);
            double y =
              convertNumber(
                lightElement,
                SVG_Y_ATTRIBUTE,
                0,
                ctx);
            double z =
              convertNumber(
                lightElement,
                SVG_Z_ATTRIBUTE,
                0,
                ctx);
            double px =
              convertNumber(
                lightElement,
                SVG_POINTS_AT_X_ATTRIBUTE,
                0,
                ctx);
            double py =
              convertNumber(
                lightElement,
                SVG_POINTS_AT_Y_ATTRIBUTE,
                0,
                ctx);
            double pz =
              convertNumber(
                lightElement,
                SVG_POINTS_AT_Z_ATTRIBUTE,
                0,
                ctx);
            double specularExponent =
              convertNumber(
                lightElement,
                SVG_SPECULAR_EXPONENT_ATTRIBUTE,
                1,
                ctx);
            double limitingConeAngle =
              convertNumber(
                lightElement,
                SVG_LIMITING_CONE_ANGLE_ATTRIBUTE,
                90,
                ctx);
            return new org.apache.batik.ext.awt.image.SpotLight(
              x,
              y,
              z,
              px,
              py,
              pz,
              specularExponent,
              limitingConeAngle,
              color);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "/GfEKw7f/i/7vhGg4BUAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public static class SVGFeDistantLightElementBridge extends org.apache.batik.bridge.AbstractSVGLightingElementBridge.AbstractSVGLightElementBridge {
        public SVGFeDistantLightElementBridge() {
            super(
              );
        }
        public java.lang.String getLocalName() {
            return SVG_FE_DISTANT_LIGHT_TAG;
        }
        public org.apache.batik.ext.awt.image.Light createLight(org.apache.batik.bridge.BridgeContext ctx,
                                                                org.w3c.dom.Element filterElement,
                                                                org.w3c.dom.Element lightElement,
                                                                java.awt.Color color) {
            double azimuth =
              convertNumber(
                lightElement,
                SVG_AZIMUTH_ATTRIBUTE,
                0,
                ctx);
            double elevation =
              convertNumber(
                lightElement,
                SVG_ELEVATION_ATTRIBUTE,
                0,
                ctx);
            return new org.apache.batik.ext.awt.image.DistantLight(
              azimuth,
              elevation,
              color);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "iPOfFq84fPe/M60okeYVAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public static class SVGFePointLightElementBridge extends org.apache.batik.bridge.AbstractSVGLightingElementBridge.AbstractSVGLightElementBridge {
        public SVGFePointLightElementBridge() {
            super(
              );
        }
        public java.lang.String getLocalName() {
            return SVG_FE_POINT_LIGHT_TAG;
        }
        public org.apache.batik.ext.awt.image.Light createLight(org.apache.batik.bridge.BridgeContext ctx,
                                                                org.w3c.dom.Element filterElement,
                                                                org.w3c.dom.Element lightElement,
                                                                java.awt.Color color) {
            double x =
              convertNumber(
                lightElement,
                SVG_X_ATTRIBUTE,
                0,
                ctx);
            double y =
              convertNumber(
                lightElement,
                SVG_Y_ATTRIBUTE,
                0,
                ctx);
            double z =
              convertNumber(
                lightElement,
                SVG_Z_ATTRIBUTE,
                0,
                ctx);
            return new org.apache.batik.ext.awt.image.PointLight(
              x,
              y,
              z,
              color);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "cf4z4hGHb/8XOqvIGuIVAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "dd3G7QpF5yk+UxxG2HiGP7Lh7D8BJ6tM+w0ZAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "um3+8M7ff+NvP/PN/BD/fwDRR9JBXCQAAA==");
}
