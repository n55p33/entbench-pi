package org.apache.batik.svggen;
public class SVGLookupOp extends org.apache.batik.svggen.AbstractSVGFilterConverter {
    private static final double GAMMA = 1.0 / 2.4;
    private static final int[] linearToSRGBLut = new int[256];
    private static final int[] sRGBToLinear = new int[256];
    static { for (int i = 0; i < 256; i++) { float value = i / 255.0F;
                                             if (value <= 0.0031308) { value *=
                                                                         12.92F;
                                             }
                                             else {
                                                 value =
                                                   1.055F *
                                                     (float)
                                                       java.lang.Math.
                                                       pow(
                                                         value,
                                                         GAMMA) -
                                                     0.055F;
                                             }
                                             linearToSRGBLut[i] = java.lang.Math.
                                                                    round(
                                                                      value *
                                                                        255);
                                             value = i / 255.0F;
                                             if (value <= 0.04045) {
                                                 value /=
                                                   12.92F;
                                             }
                                             else {
                                                 value =
                                                   (float)
                                                     java.lang.Math.
                                                     pow(
                                                       (value +
                                                          0.055F) /
                                                         1.055F,
                                                       1 /
                                                         GAMMA);
                                             }
                                             sRGBToLinear[i] = java.lang.Math.
                                                                 round(
                                                                   value *
                                                                     255);
             } }
    public SVGLookupOp(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          generatorContext);
    }
    public org.apache.batik.svggen.SVGFilterDescriptor toSVG(java.awt.image.BufferedImageOp filter,
                                                             java.awt.Rectangle filterRect) {
        if (filter instanceof java.awt.image.LookupOp)
            return toSVG(
                     (java.awt.image.LookupOp)
                       filter);
        else
            return null;
    }
    public org.apache.batik.svggen.SVGFilterDescriptor toSVG(java.awt.image.LookupOp lookupOp) {
        org.apache.batik.svggen.SVGFilterDescriptor filterDesc =
          (org.apache.batik.svggen.SVGFilterDescriptor)
            descMap.
            get(
              lookupOp);
        org.w3c.dom.Document domFactory =
          generatorContext.
            domFactory;
        if (filterDesc ==
              null) {
            org.w3c.dom.Element filterDef =
              domFactory.
              createElementNS(
                SVG_NAMESPACE_URI,
                SVG_FILTER_TAG);
            org.w3c.dom.Element feComponentTransferDef =
              domFactory.
              createElementNS(
                SVG_NAMESPACE_URI,
                SVG_FE_COMPONENT_TRANSFER_TAG);
            java.lang.String[] lookupTables =
              convertLookupTables(
                lookupOp);
            org.w3c.dom.Element feFuncR =
              domFactory.
              createElementNS(
                SVG_NAMESPACE_URI,
                SVG_FE_FUNC_R_TAG);
            org.w3c.dom.Element feFuncG =
              domFactory.
              createElementNS(
                SVG_NAMESPACE_URI,
                SVG_FE_FUNC_G_TAG);
            org.w3c.dom.Element feFuncB =
              domFactory.
              createElementNS(
                SVG_NAMESPACE_URI,
                SVG_FE_FUNC_B_TAG);
            org.w3c.dom.Element feFuncA =
              null;
            java.lang.String type =
              SVG_TABLE_VALUE;
            if (lookupTables.
                  length ==
                  1) {
                feFuncR.
                  setAttributeNS(
                    null,
                    SVG_TYPE_ATTRIBUTE,
                    type);
                feFuncG.
                  setAttributeNS(
                    null,
                    SVG_TYPE_ATTRIBUTE,
                    type);
                feFuncB.
                  setAttributeNS(
                    null,
                    SVG_TYPE_ATTRIBUTE,
                    type);
                feFuncR.
                  setAttributeNS(
                    null,
                    SVG_TABLE_VALUES_ATTRIBUTE,
                    lookupTables[0]);
                feFuncG.
                  setAttributeNS(
                    null,
                    SVG_TABLE_VALUES_ATTRIBUTE,
                    lookupTables[0]);
                feFuncB.
                  setAttributeNS(
                    null,
                    SVG_TABLE_VALUES_ATTRIBUTE,
                    lookupTables[0]);
            }
            else
                if (lookupTables.
                      length >=
                      3) {
                    feFuncR.
                      setAttributeNS(
                        null,
                        SVG_TYPE_ATTRIBUTE,
                        type);
                    feFuncG.
                      setAttributeNS(
                        null,
                        SVG_TYPE_ATTRIBUTE,
                        type);
                    feFuncB.
                      setAttributeNS(
                        null,
                        SVG_TYPE_ATTRIBUTE,
                        type);
                    feFuncR.
                      setAttributeNS(
                        null,
                        SVG_TABLE_VALUES_ATTRIBUTE,
                        lookupTables[0]);
                    feFuncG.
                      setAttributeNS(
                        null,
                        SVG_TABLE_VALUES_ATTRIBUTE,
                        lookupTables[1]);
                    feFuncB.
                      setAttributeNS(
                        null,
                        SVG_TABLE_VALUES_ATTRIBUTE,
                        lookupTables[2]);
                    if (lookupTables.
                          length ==
                          4) {
                        feFuncA =
                          domFactory.
                            createElementNS(
                              SVG_NAMESPACE_URI,
                              SVG_FE_FUNC_A_TAG);
                        feFuncA.
                          setAttributeNS(
                            null,
                            SVG_TYPE_ATTRIBUTE,
                            type);
                        feFuncA.
                          setAttributeNS(
                            null,
                            SVG_TABLE_VALUES_ATTRIBUTE,
                            lookupTables[3]);
                    }
                }
            feComponentTransferDef.
              appendChild(
                feFuncR);
            feComponentTransferDef.
              appendChild(
                feFuncG);
            feComponentTransferDef.
              appendChild(
                feFuncB);
            if (feFuncA !=
                  null)
                feComponentTransferDef.
                  appendChild(
                    feFuncA);
            filterDef.
              appendChild(
                feComponentTransferDef);
            filterDef.
              setAttributeNS(
                null,
                SVG_ID_ATTRIBUTE,
                generatorContext.
                  idGenerator.
                  generateID(
                    ID_PREFIX_FE_COMPONENT_TRANSFER));
            java.lang.String filterAttrBuf =
              URL_PREFIX +
            SIGN_POUND +
            filterDef.
              getAttributeNS(
                null,
                SVG_ID_ATTRIBUTE) +
            URL_SUFFIX;
            filterDesc =
              new org.apache.batik.svggen.SVGFilterDescriptor(
                filterAttrBuf,
                filterDef);
            defSet.
              add(
                filterDef);
            descMap.
              put(
                lookupOp,
                filterDesc);
        }
        return filterDesc;
    }
    private java.lang.String[] convertLookupTables(java.awt.image.LookupOp lookupOp) {
        java.awt.image.LookupTable lookupTable =
          lookupOp.
          getTable(
            );
        int nComponents =
          lookupTable.
          getNumComponents(
            );
        if (nComponents !=
              1 &&
              nComponents !=
              3 &&
              nComponents !=
              4)
            throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
              ERR_ILLEGAL_BUFFERED_IMAGE_LOOKUP_OP);
        java.lang.StringBuffer[] lookupTableBuf =
          new java.lang.StringBuffer[nComponents];
        for (int i =
               0;
             i <
               nComponents;
             i++)
            lookupTableBuf[i] =
              new java.lang.StringBuffer(
                );
        if (!(lookupTable instanceof java.awt.image.ByteLookupTable)) {
            int[] src =
              new int[nComponents];
            int[] dest =
              new int[nComponents];
            int offset =
              lookupTable.
              getOffset(
                );
            for (int i =
                   0;
                 i <
                   offset;
                 i++) {
                for (int j =
                       0;
                     j <
                       nComponents;
                     j++) {
                    lookupTableBuf[j].
                      append(
                        doubleString(
                          i /
                            255.0)).
                      append(
                        SPACE);
                }
            }
            for (int i =
                   offset;
                 i <=
                   255;
                 i++) {
                java.util.Arrays.
                  fill(
                    src,
                    i);
                lookupTable.
                  lookupPixel(
                    src,
                    dest);
                for (int j =
                       0;
                     j <
                       nComponents;
                     j++) {
                    lookupTableBuf[j].
                      append(
                        doubleString(
                          dest[j] /
                            255.0)).
                      append(
                        SPACE);
                }
            }
        }
        else {
            byte[] src =
              new byte[nComponents];
            byte[] dest =
              new byte[nComponents];
            int offset =
              lookupTable.
              getOffset(
                );
            for (int i =
                   0;
                 i <
                   offset;
                 i++) {
                for (int j =
                       0;
                     j <
                       nComponents;
                     j++) {
                    lookupTableBuf[j].
                      append(
                        doubleString(
                          i /
                            255.0)).
                      append(
                        SPACE);
                }
            }
            for (int i =
                   0;
                 i <=
                   255;
                 i++) {
                java.util.Arrays.
                  fill(
                    src,
                    (byte)
                      (255 &
                         i));
                ((java.awt.image.ByteLookupTable)
                   lookupTable).
                  lookupPixel(
                    src,
                    dest);
                for (int j =
                       0;
                     j <
                       nComponents;
                     j++) {
                    lookupTableBuf[j].
                      append(
                        doubleString(
                          (255 &
                             dest[j]) /
                            255.0)).
                      append(
                        SPACE);
                }
            }
        }
        java.lang.String[] lookupTables =
          new java.lang.String[nComponents];
        for (int i =
               0;
             i <
               nComponents;
             i++)
            lookupTables[i] =
              lookupTableBuf[i].
                toString(
                  ).
                trim(
                  );
        return lookupTables;
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
       "kS2Xo4yhuAhDicC8YbvZbIUzoqKTfXST0p3ubCg3p/22sGErsswFu91G0fX6" +
       "sJb5ANQkU54zcZPmKgutSwkST/BV0mvTLLqyq6jT6zI7yve6QzMYdKZNl0Br" +
       "u/6w0oir/S6ayhIes412tYbLFT/CfKeL9jqOW60wptLtZcNdR8VpA97FOowv" +
       "KnILqTGrLeGvZjzbJhMsgrHqyKwt6zXFqzOcvrQYm23jlmKScUWsBu5Oz+sq" +
       "SXW1urhkpt0J1eBgHYclB17z4nJMzkxb4KyJLA4bDj2YLkbeBqFEqW1XR4Mp" +
       "cD4a3gn61oFX4Y5Fx8SWdGsCCDFm1qzud6R6JaTMntJ1ElLRqH6t2xEok9Wn" +
       "ksEB7aB+Qnu9MdNbwhVqoM6S3rQhkaotTXEDRPqK2Is2zdFad0YkvEKqlazS" +
       "aCQK5muVmAcLIKJVbJhV9b5U32FEg68b7X5j0d0qhN/meX6l06aL0ivTlHxi" +
       "IsiL2nTKducjvtZK1jk8XO1W6pRVAN9rhjJINDUbdF6BdabbSppwpYoPiRy3" +
       "0ok6HMcbNd3B461D5yY+r/W4Xp1BmqHrzcgIVay4XRtPXJxyyEYVRtGulE0a" +
       "PDIVq7WlbKWL6tpck3y1tSIIS6qOeFxPOFeCO1Tbq6a0Gbv1+ihHB1jLiFg6" +
       "Vqa2n7cNEOVoTKcfTknR4OtRc7Ni3KzbquCcrNf9ZB4lnSDa4pEuLZfULBlX" +
       "qjqGTpKYUxswM9PJeYY5czGg3MHcQXJYW/HstlaJ9Sbvzmp2fU6krQG1jRhR" +
       "sZqrlrLE+3M68B1W1TAQ0bUnETDjyai/Ww5TIjXrizFGLnbAzZWEmZizpY4R" +
       "C8MdU1HUm1cmHTruJE7qd4gA5VZtrp/PCQ3bwZ3uss+4G89SEEPv0WbO+L4D" +
       "R/EsoJMcpixE6y5HSF7JkySRSeD4uDEfoeOshmHotjLbbCUeRWJuuwyTWN5E" +
       "kb9m1YWVrB2RHcMaOyQW6dwHcSJYsGESWOVoInYVsTvmCE2ein2cS5p8yvUC" +
       "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" +
       "i2/E8LIIetOpq1LFvY+33XHvcn9XUPns");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("K9ceeOKV2b/YnyAe3ed7cAg9oMe2ffrI/VT+ih9oully+eD+AH4/Z/8R+N1d" +
       "AKU4/i4zJbf/YU//RxF0/Tw98Lzy/zTdH0fQ1RM60NU+c5rkTyLoEiApst86" +
       "xsna3dCNkMMokJToGOWovTtoQXbh7IJyPAOPfrcZOLUGPXvmIK68GXt0aBbv" +
       "78beVj73ymD0gW83f35/3Umxpbw0iQeG0P37m1fHB2/vuGtvR31d6T3/nYd/" +
       "5cHnjla1h/cMn+DJKd6eef27RR3Hj8rbQPnfe+LvvPsXX/lqecXhfwMVl9TG" +
       "siwAAA==");
}
