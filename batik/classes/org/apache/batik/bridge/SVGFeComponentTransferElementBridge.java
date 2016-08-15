package org.apache.batik.bridge;
public class SVGFeComponentTransferElementBridge extends org.apache.batik.bridge.AbstractSVGFilterPrimitiveElementBridge {
    public SVGFeComponentTransferElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_FE_COMPONENT_TRANSFER_TAG;
    }
    public org.apache.batik.ext.awt.image.renderable.Filter createFilter(org.apache.batik.bridge.BridgeContext ctx,
                                                                         org.w3c.dom.Element filterElement,
                                                                         org.w3c.dom.Element filteredElement,
                                                                         org.apache.batik.gvt.GraphicsNode filteredNode,
                                                                         org.apache.batik.ext.awt.image.renderable.Filter inputFilter,
                                                                         java.awt.geom.Rectangle2D filterRegion,
                                                                         java.util.Map filterMap) {
        org.apache.batik.ext.awt.image.renderable.Filter in =
          getIn(
            filterElement,
            filteredElement,
            filteredNode,
            inputFilter,
            filterMap,
            ctx);
        if (in ==
              null) {
            return null;
        }
        java.awt.geom.Rectangle2D defaultRegion =
          in.
          getBounds2D(
            );
        java.awt.geom.Rectangle2D primitiveRegion =
          org.apache.batik.bridge.SVGUtilities.
          convertFilterPrimitiveRegion(
            filterElement,
            filteredElement,
            filteredNode,
            defaultRegion,
            filterRegion,
            ctx);
        org.apache.batik.ext.awt.image.ComponentTransferFunction funcR =
          null;
        org.apache.batik.ext.awt.image.ComponentTransferFunction funcG =
          null;
        org.apache.batik.ext.awt.image.ComponentTransferFunction funcB =
          null;
        org.apache.batik.ext.awt.image.ComponentTransferFunction funcA =
          null;
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
                  !(bridge instanceof org.apache.batik.bridge.SVGFeComponentTransferElementBridge.SVGFeFuncElementBridge)) {
                continue;
            }
            org.apache.batik.bridge.SVGFeComponentTransferElementBridge.SVGFeFuncElementBridge funcBridge =
              (org.apache.batik.bridge.SVGFeComponentTransferElementBridge.SVGFeFuncElementBridge)
                bridge;
            org.apache.batik.ext.awt.image.ComponentTransferFunction func =
              funcBridge.
              createComponentTransferFunction(
                filterElement,
                e);
            if (funcBridge instanceof org.apache.batik.bridge.SVGFeComponentTransferElementBridge.SVGFeFuncRElementBridge) {
                funcR =
                  func;
            }
            else
                if (funcBridge instanceof org.apache.batik.bridge.SVGFeComponentTransferElementBridge.SVGFeFuncGElementBridge) {
                    funcG =
                      func;
                }
                else
                    if (funcBridge instanceof org.apache.batik.bridge.SVGFeComponentTransferElementBridge.SVGFeFuncBElementBridge) {
                        funcB =
                          func;
                    }
                    else
                        if (funcBridge instanceof org.apache.batik.bridge.SVGFeComponentTransferElementBridge.SVGFeFuncAElementBridge) {
                            funcA =
                              func;
                        }
        }
        org.apache.batik.ext.awt.image.renderable.Filter filter =
          new org.apache.batik.ext.awt.image.renderable.ComponentTransferRable8Bit(
          in,
          funcA,
          funcR,
          funcG,
          funcB);
        handleColorInterpolationFilters(
          filter,
          filterElement);
        filter =
          new org.apache.batik.ext.awt.image.renderable.PadRable8Bit(
            filter,
            primitiveRegion,
            org.apache.batik.ext.awt.image.PadMode.
              ZERO_PAD);
        updateFilterMap(
          filterElement,
          filter,
          filterMap);
        return filter;
    }
    public static class SVGFeFuncAElementBridge extends org.apache.batik.bridge.SVGFeComponentTransferElementBridge.SVGFeFuncElementBridge {
        public SVGFeFuncAElementBridge() {
            super(
              );
        }
        public java.lang.String getLocalName() {
            return SVG_FE_FUNC_A_TAG;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public static class SVGFeFuncRElementBridge extends org.apache.batik.bridge.SVGFeComponentTransferElementBridge.SVGFeFuncElementBridge {
        public SVGFeFuncRElementBridge() {
            super(
              );
        }
        public java.lang.String getLocalName() {
            return SVG_FE_FUNC_R_TAG;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public static class SVGFeFuncGElementBridge extends org.apache.batik.bridge.SVGFeComponentTransferElementBridge.SVGFeFuncElementBridge {
        public SVGFeFuncGElementBridge() {
            super(
              );
        }
        public java.lang.String getLocalName() {
            return SVG_FE_FUNC_G_TAG;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public static class SVGFeFuncBElementBridge extends org.apache.batik.bridge.SVGFeComponentTransferElementBridge.SVGFeFuncElementBridge {
        public SVGFeFuncBElementBridge() {
            super(
              );
        }
        public java.lang.String getLocalName() {
            return SVG_FE_FUNC_B_TAG;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "ukGcN503f3jv77/5t597Me9j/Q+aKlGyeR8AAA==");
    }
    protected abstract static class SVGFeFuncElementBridge extends org.apache.batik.bridge.AnimatableGenericSVGBridge {
        protected SVGFeFuncElementBridge() {
            super(
              );
        }
        public org.apache.batik.ext.awt.image.ComponentTransferFunction createComponentTransferFunction(org.w3c.dom.Element filterElement,
                                                                                                        org.w3c.dom.Element funcElement) {
            int type =
              convertType(
                funcElement,
                ctx);
            switch (type) {
                case org.apache.batik.ext.awt.image.ComponentTransferFunction.
                       DISCRETE:
                    {
                        float[] v =
                          convertTableValues(
                            funcElement,
                            ctx);
                        if (v ==
                              null) {
                            return org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction.
                              getIdentityTransfer(
                                );
                        }
                        else {
                            return org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction.
                              getDiscreteTransfer(
                                v);
                        }
                    }
                case org.apache.batik.ext.awt.image.ComponentTransferFunction.
                       IDENTITY:
                    {
                        return org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction.
                          getIdentityTransfer(
                            );
                    }
                case org.apache.batik.ext.awt.image.ComponentTransferFunction.
                       GAMMA:
                    {
                        float amplitude =
                          convertNumber(
                            funcElement,
                            SVG_AMPLITUDE_ATTRIBUTE,
                            1,
                            ctx);
                        float exponent =
                          convertNumber(
                            funcElement,
                            SVG_EXPONENT_ATTRIBUTE,
                            1,
                            ctx);
                        float offset =
                          convertNumber(
                            funcElement,
                            SVG_OFFSET_ATTRIBUTE,
                            0,
                            ctx);
                        return org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction.
                          getGammaTransfer(
                            amplitude,
                            exponent,
                            offset);
                    }
                case org.apache.batik.ext.awt.image.ComponentTransferFunction.
                       LINEAR:
                    {
                        float slope =
                          convertNumber(
                            funcElement,
                            SVG_SLOPE_ATTRIBUTE,
                            1,
                            ctx);
                        float intercept =
                          convertNumber(
                            funcElement,
                            SVG_INTERCEPT_ATTRIBUTE,
                            0,
                            ctx);
                        return org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction.
                          getLinearTransfer(
                            slope,
                            intercept);
                    }
                case org.apache.batik.ext.awt.image.ComponentTransferFunction.
                       TABLE:
                    {
                        float[] v =
                          convertTableValues(
                            funcElement,
                            ctx);
                        if (v ==
                              null) {
                            return org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction.
                              getIdentityTransfer(
                                );
                        }
                        else {
                            return org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction.
                              getTableTransfer(
                                v);
                        }
                    }
                default:
                    throw new java.lang.Error(
                      "invalid convertType:" +
                      type);
            }
        }
        protected static float[] convertTableValues(org.w3c.dom.Element e,
                                                    org.apache.batik.bridge.BridgeContext ctx) {
            java.lang.String s =
              e.
              getAttributeNS(
                null,
                SVG_TABLE_VALUES_ATTRIBUTE);
            if (s.
                  length(
                    ) ==
                  0) {
                return null;
            }
            java.util.StringTokenizer tokens =
              new java.util.StringTokenizer(
              s,
              " ,");
            float[] v =
              new float[tokens.
                          countTokens(
                            )];
            try {
                for (int i =
                       0;
                     tokens.
                       hasMoreTokens(
                         );
                     ++i) {
                    v[i] =
                      org.apache.batik.bridge.SVGUtilities.
                        convertSVGNumber(
                          tokens.
                            nextToken(
                              ));
                }
            }
            catch (java.lang.NumberFormatException nfEx) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  e,
                  nfEx,
                  ERR_ATTRIBUTE_VALUE_MALFORMED,
                  new java.lang.Object[] { SVG_TABLE_VALUES_ATTRIBUTE,
                  s });
            }
            return v;
        }
        protected static int convertType(org.w3c.dom.Element e,
                                         org.apache.batik.bridge.BridgeContext ctx) {
            java.lang.String s =
              e.
              getAttributeNS(
                null,
                SVG_TYPE_ATTRIBUTE);
            if (s.
                  length(
                    ) ==
                  0) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  e,
                  ERR_ATTRIBUTE_MISSING,
                  new java.lang.Object[] { SVG_TYPE_ATTRIBUTE });
            }
            if (SVG_DISCRETE_VALUE.
                  equals(
                    s)) {
                return org.apache.batik.ext.awt.image.ComponentTransferFunction.
                         DISCRETE;
            }
            if (SVG_IDENTITY_VALUE.
                  equals(
                    s)) {
                return org.apache.batik.ext.awt.image.ComponentTransferFunction.
                         IDENTITY;
            }
            if (SVG_GAMMA_VALUE.
                  equals(
                    s)) {
                return org.apache.batik.ext.awt.image.ComponentTransferFunction.
                         GAMMA;
            }
            if (SVG_LINEAR_VALUE.
                  equals(
                    s)) {
                return org.apache.batik.ext.awt.image.ComponentTransferFunction.
                         LINEAR;
            }
            if (SVG_TABLE_VALUE.
                  equals(
                    s)) {
                return org.apache.batik.ext.awt.image.ComponentTransferFunction.
                         TABLE;
            }
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              e,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_TYPE_ATTRIBUTE,
              s });
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "B8cT4hOHN/8LkHlNQKMdAAA=");
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
       "D/kBkk/y3U/xRzY8/S/yAjYkZBgAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "ynbCd+Sb/oNbHrABzho6r2AHuG16OCseOzgozD9nTt4MHD0oPDw9grJd7f3X" +
       "urzJd7SffPqZ5xT2U6WdvVO3aQjdHLrez1rqWrWOsNoBnJ649u69l99dHZ4G" +
       "ffHpf7lv+HPG217BGfeDJ+Q8yfJ3es9/uf06+cM70A0HZ0NX3Kod73Tp+InQ" +
       "OV8NI98ZHjsXuv/AsndmFnsAPOieZdGrnzNfFQWnchRsfX+dQ83gOm1RVjgh" +
       "dKuuhowrS1Z/T/TOIVzcH3dgcJRpXrG8Uj96Tz/6/0a/sznB2f3DrMeudfuy" +
       "vWDZu7rdp74ro47L8q7i2rt7NzFZ09P7BA9fwU5fh7ttX/IMUw76rqLuUxav" +
       "oMxgKsXhrmlLYHxfdRTVzw65d0nTClV/v+Nr8sOwjFBXgRS8KgP06JaKEMcO" +
       "hY6DnpfifCZdlv9w8K2vfSJ94fntmc9cCtQQKlzrRv3KS/3s+uWx61whHd61" +
       "/qD9hhe/84/jt+zP1VsOXPtg5slHwMPtuZY76dp9XW87PLnuSXnbB3Ne77wO" +
       "MD+cFSkApuyrUqhujZfVvecQmG9/JcBMQujRn+AuLrtYuPeKPwhsL7Xlzz53" +
       "/qZ7nhv9dX4ddXDxfDMD3aRFlnX0HPjI+xnPVzUzV+rm7amwl399LITuuQZs" +
       "Q+jM9iXX4tkt/cdD6MJJ+hA6nX8fpfv1EDp3SAdYbV+OkvxGCN0ASLLX3/T2" +
       "vfTma80hbB6EviSHmfVyNxycUR6zXHLq+Cpw4KY7f5ybjiwcjx4DZf5/jv3Q" +
       "HHF72H/hObr/9peqn9persmWlKYZl5sY6Oz2nu8gvD98TW77vM50Hn/59s/d" +
       "/Ng+vG/fCnwYlI7I9uDVb7Jathfmd0/pH9zze2/8ree+kR9n/w9zc7ggaCMA" +
       "AA==");
}
