package org.apache.batik.bridge;
public class SVGFontFaceElementBridge extends org.apache.batik.bridge.AbstractSVGBridge implements org.apache.batik.bridge.ErrorConstants {
    public SVGFontFaceElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_FONT_FACE_TAG; }
    public org.apache.batik.bridge.SVGFontFace createFontFace(org.apache.batik.bridge.BridgeContext ctx,
                                                              org.w3c.dom.Element fontFaceElement) {
        java.lang.String familyNames =
          fontFaceElement.
          getAttributeNS(
            null,
            SVG_FONT_FAMILY_ATTRIBUTE);
        java.lang.String unitsPerEmStr =
          fontFaceElement.
          getAttributeNS(
            null,
            SVG_UNITS_PER_EM_ATTRIBUTE);
        if (unitsPerEmStr.
              length(
                ) ==
              0) {
            unitsPerEmStr =
              SVG_FONT_FACE_UNITS_PER_EM_DEFAULT_VALUE;
        }
        float unitsPerEm;
        try {
            unitsPerEm =
              org.apache.batik.bridge.SVGUtilities.
                convertSVGNumber(
                  unitsPerEmStr);
        }
        catch (java.lang.NumberFormatException nfEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              fontFaceElement,
              nfEx,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_UNITS_PER_EM_ATTRIBUTE,
              unitsPerEmStr });
        }
        java.lang.String fontWeight =
          fontFaceElement.
          getAttributeNS(
            null,
            SVG_FONT_WEIGHT_ATTRIBUTE);
        if (fontWeight.
              length(
                ) ==
              0) {
            fontWeight =
              SVG_FONT_FACE_FONT_WEIGHT_DEFAULT_VALUE;
        }
        java.lang.String fontStyle =
          fontFaceElement.
          getAttributeNS(
            null,
            SVG_FONT_STYLE_ATTRIBUTE);
        if (fontStyle.
              length(
                ) ==
              0) {
            fontStyle =
              SVG_FONT_FACE_FONT_STYLE_DEFAULT_VALUE;
        }
        java.lang.String fontVariant =
          fontFaceElement.
          getAttributeNS(
            null,
            SVG_FONT_VARIANT_ATTRIBUTE);
        if (fontVariant.
              length(
                ) ==
              0) {
            fontVariant =
              SVG_FONT_FACE_FONT_VARIANT_DEFAULT_VALUE;
        }
        java.lang.String fontStretch =
          fontFaceElement.
          getAttributeNS(
            null,
            SVG_FONT_STRETCH_ATTRIBUTE);
        if (fontStretch.
              length(
                ) ==
              0) {
            fontStretch =
              SVG_FONT_FACE_FONT_STRETCH_DEFAULT_VALUE;
        }
        java.lang.String slopeStr =
          fontFaceElement.
          getAttributeNS(
            null,
            SVG_SLOPE_ATTRIBUTE);
        if (slopeStr.
              length(
                ) ==
              0) {
            slopeStr =
              SVG_FONT_FACE_SLOPE_DEFAULT_VALUE;
        }
        float slope;
        try {
            slope =
              org.apache.batik.bridge.SVGUtilities.
                convertSVGNumber(
                  slopeStr);
        }
        catch (java.lang.NumberFormatException nfEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              fontFaceElement,
              nfEx,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_FONT_FACE_SLOPE_DEFAULT_VALUE,
              slopeStr });
        }
        java.lang.String panose1 =
          fontFaceElement.
          getAttributeNS(
            null,
            SVG_PANOSE_1_ATTRIBUTE);
        if (panose1.
              length(
                ) ==
              0) {
            panose1 =
              SVG_FONT_FACE_PANOSE_1_DEFAULT_VALUE;
        }
        java.lang.String ascentStr =
          fontFaceElement.
          getAttributeNS(
            null,
            SVG_ASCENT_ATTRIBUTE);
        if (ascentStr.
              length(
                ) ==
              0) {
            ascentStr =
              java.lang.String.
                valueOf(
                  unitsPerEm *
                    0.8);
        }
        float ascent;
        try {
            ascent =
              org.apache.batik.bridge.SVGUtilities.
                convertSVGNumber(
                  ascentStr);
        }
        catch (java.lang.NumberFormatException nfEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              fontFaceElement,
              nfEx,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_FONT_FACE_SLOPE_DEFAULT_VALUE,
              ascentStr });
        }
        java.lang.String descentStr =
          fontFaceElement.
          getAttributeNS(
            null,
            SVG_DESCENT_ATTRIBUTE);
        if (descentStr.
              length(
                ) ==
              0) {
            descentStr =
              java.lang.String.
                valueOf(
                  unitsPerEm *
                    0.2);
        }
        float descent;
        try {
            descent =
              org.apache.batik.bridge.SVGUtilities.
                convertSVGNumber(
                  descentStr);
        }
        catch (java.lang.NumberFormatException nfEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              fontFaceElement,
              nfEx,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_FONT_FACE_SLOPE_DEFAULT_VALUE,
              descentStr });
        }
        java.lang.String underlinePosStr =
          fontFaceElement.
          getAttributeNS(
            null,
            SVG_UNDERLINE_POSITION_ATTRIBUTE);
        if (underlinePosStr.
              length(
                ) ==
              0) {
            underlinePosStr =
              java.lang.String.
                valueOf(
                  -3 *
                    unitsPerEm /
                    40);
        }
        float underlinePos;
        try {
            underlinePos =
              org.apache.batik.bridge.SVGUtilities.
                convertSVGNumber(
                  underlinePosStr);
        }
        catch (java.lang.NumberFormatException nfEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              fontFaceElement,
              nfEx,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_FONT_FACE_SLOPE_DEFAULT_VALUE,
              underlinePosStr });
        }
        java.lang.String underlineThicknessStr =
          fontFaceElement.
          getAttributeNS(
            null,
            SVG_UNDERLINE_THICKNESS_ATTRIBUTE);
        if (underlineThicknessStr.
              length(
                ) ==
              0) {
            underlineThicknessStr =
              java.lang.String.
                valueOf(
                  unitsPerEm /
                    20);
        }
        float underlineThickness;
        try {
            underlineThickness =
              org.apache.batik.bridge.SVGUtilities.
                convertSVGNumber(
                  underlineThicknessStr);
        }
        catch (java.lang.NumberFormatException nfEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              fontFaceElement,
              nfEx,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_FONT_FACE_SLOPE_DEFAULT_VALUE,
              underlineThicknessStr });
        }
        java.lang.String strikethroughPosStr =
          fontFaceElement.
          getAttributeNS(
            null,
            SVG_STRIKETHROUGH_POSITION_ATTRIBUTE);
        if (strikethroughPosStr.
              length(
                ) ==
              0) {
            strikethroughPosStr =
              java.lang.String.
                valueOf(
                  3 *
                    ascent /
                    8);
        }
        float strikethroughPos;
        try {
            strikethroughPos =
              org.apache.batik.bridge.SVGUtilities.
                convertSVGNumber(
                  strikethroughPosStr);
        }
        catch (java.lang.NumberFormatException nfEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              fontFaceElement,
              nfEx,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_FONT_FACE_SLOPE_DEFAULT_VALUE,
              strikethroughPosStr });
        }
        java.lang.String strikethroughThicknessStr =
          fontFaceElement.
          getAttributeNS(
            null,
            SVG_STRIKETHROUGH_THICKNESS_ATTRIBUTE);
        if (strikethroughThicknessStr.
              length(
                ) ==
              0) {
            strikethroughThicknessStr =
              java.lang.String.
                valueOf(
                  unitsPerEm /
                    20);
        }
        float strikethroughThickness;
        try {
            strikethroughThickness =
              org.apache.batik.bridge.SVGUtilities.
                convertSVGNumber(
                  strikethroughThicknessStr);
        }
        catch (java.lang.NumberFormatException nfEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              fontFaceElement,
              nfEx,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_FONT_FACE_SLOPE_DEFAULT_VALUE,
              strikethroughThicknessStr });
        }
        java.lang.String overlinePosStr =
          fontFaceElement.
          getAttributeNS(
            null,
            SVG_OVERLINE_POSITION_ATTRIBUTE);
        if (overlinePosStr.
              length(
                ) ==
              0) {
            overlinePosStr =
              java.lang.String.
                valueOf(
                  ascent);
        }
        float overlinePos;
        try {
            overlinePos =
              org.apache.batik.bridge.SVGUtilities.
                convertSVGNumber(
                  overlinePosStr);
        }
        catch (java.lang.NumberFormatException nfEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              fontFaceElement,
              nfEx,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_FONT_FACE_SLOPE_DEFAULT_VALUE,
              overlinePosStr });
        }
        java.lang.String overlineThicknessStr =
          fontFaceElement.
          getAttributeNS(
            null,
            SVG_OVERLINE_THICKNESS_ATTRIBUTE);
        if (overlineThicknessStr.
              length(
                ) ==
              0) {
            overlineThicknessStr =
              java.lang.String.
                valueOf(
                  unitsPerEm /
                    20);
        }
        float overlineThickness;
        try {
            overlineThickness =
              org.apache.batik.bridge.SVGUtilities.
                convertSVGNumber(
                  overlineThicknessStr);
        }
        catch (java.lang.NumberFormatException nfEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              fontFaceElement,
              nfEx,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_FONT_FACE_SLOPE_DEFAULT_VALUE,
              overlineThicknessStr });
        }
        java.util.List srcs =
          null;
        org.w3c.dom.Element fontElt =
          org.apache.batik.bridge.SVGUtilities.
          getParentElement(
            fontFaceElement);
        if (!fontElt.
              getNamespaceURI(
                ).
              equals(
                SVG_NAMESPACE_URI) ||
              !fontElt.
              getLocalName(
                ).
              equals(
                SVG_FONT_TAG)) {
            srcs =
              getFontFaceSrcs(
                fontFaceElement);
        }
        return new org.apache.batik.bridge.SVGFontFace(
          fontFaceElement,
          srcs,
          familyNames,
          unitsPerEm,
          fontWeight,
          fontStyle,
          fontVariant,
          fontStretch,
          slope,
          panose1,
          ascent,
          descent,
          strikethroughPos,
          strikethroughThickness,
          underlinePos,
          underlineThickness,
          overlinePos,
          overlineThickness);
    }
    public java.util.List getFontFaceSrcs(org.w3c.dom.Element fontFaceElement) {
        org.w3c.dom.Element ffsrc =
          null;
        for (org.w3c.dom.Node n =
               fontFaceElement.
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
                    ) ==
                  org.w3c.dom.Node.
                    ELEMENT_NODE &&
                  n.
                  getNamespaceURI(
                    ).
                  equals(
                    SVG_NAMESPACE_URI) &&
                  n.
                  getLocalName(
                    ).
                  equals(
                    SVG_FONT_FACE_SRC_TAG)) {
                ffsrc =
                  (org.w3c.dom.Element)
                    n;
                break;
            }
        }
        if (ffsrc ==
              null)
            return null;
        java.util.List ret =
          new java.util.LinkedList(
          );
        for (org.w3c.dom.Node n =
               ffsrc.
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
                    ELEMENT_NODE ||
                  !n.
                  getNamespaceURI(
                    ).
                  equals(
                    SVG_NAMESPACE_URI))
                continue;
            if (n.
                  getLocalName(
                    ).
                  equals(
                    SVG_FONT_FACE_URI_TAG)) {
                org.w3c.dom.Element ffuri =
                  (org.w3c.dom.Element)
                    n;
                java.lang.String uri =
                  org.apache.batik.dom.util.XLinkSupport.
                  getXLinkHref(
                    ffuri);
                java.lang.String base =
                  org.apache.batik.dom.AbstractNode.
                  getBaseURI(
                    ffuri);
                org.apache.batik.util.ParsedURL purl;
                if (base !=
                      null)
                    purl =
                      new org.apache.batik.util.ParsedURL(
                        base,
                        uri);
                else
                    purl =
                      new org.apache.batik.util.ParsedURL(
                        uri);
                ret.
                  add(
                    purl);
                continue;
            }
            if (n.
                  getLocalName(
                    ).
                  equals(
                    SVG_FONT_FACE_NAME_TAG)) {
                org.w3c.dom.Element ffname =
                  (org.w3c.dom.Element)
                    n;
                java.lang.String s =
                  ffname.
                  getAttribute(
                    "name");
                if (s.
                      length(
                        ) !=
                      0)
                    ret.
                      add(
                        s);
            }
        }
        return ret;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1YfWwUxxWfO2Pj7y/AJnzYYGwQH70DJbShJiTGscH0bByb" +
       "WO3xccztzt0t3ttddufss9O0IVIVIhWEKAEaCZRIpCQtDVEV1KZtIleR8qGk" +
       "lUhR0zQKjZT+kbRFCYqa/kG/3szs3u7t3ZnSNj3p9vZm3ryZ9+b3fu/NXLiG" +
       "yi0TtRGNhuiUQaxQn0aHsWkRuVfFlrUL2mLSqTL86b4PhzYFUUUU1aewNShh" +
       "i/QrRJWtKFqqaBbFmkSsIUJkNmLYJBYxJzBVdC2KFijWQNpQFUmhg7pMmMAY" +
       "NiOoCVNqKvEMJQO2AoqWRmAlYb6ScI+/uzuCaiXdmHLFF3rEez09TDLtzmVR" +
       "1Bg5gCdwOEMVNRxRLNqdNdFaQ1enkqpOQyRLQwfUjbYLdkQ2Frig47mGz24c" +
       "SzVyF8zDmqZTbp41QixdnSByBDW4rX0qSVsH0TdQWQTVeIQp6ow4k4Zh0jBM" +
       "6ljrSsHq64iWSffq3BzqaKowJLYgipbnKzGwidO2mmG+ZtBQSW3b+WCwdlnO" +
       "WmFlgYmPrQ2fOLWv8UdlqCGKGhRtlC1HgkVQmCQKDiXpODGtHlkmchQ1abDZ" +
       "o8RUsKpM2zvdbClJDdMMbL/jFtaYMYjJ53R9BfsItpkZiepmzrwEB5T9rzyh" +
       "4iTY2uLaKizsZ+1gYLUCCzMTGHBnD5kzrmgyRe3+ETkbO78CAjB0bprQlJ6b" +
       "ao6GoQE1C4ioWEuGRwF6WhJEy3UAoEnRopJKma8NLI3jJIkxRPrkhkUXSFVx" +
       "R7AhFC3wi3FNsEuLfLvk2Z9rQ5uPPqBt14IoAGuWiaSy9dfAoDbfoBGSICaB" +
       "OBADa9dETuKWFw8HEQLhBT5hIfPjr1+/Z13bzGtCZnERmZ3xA0SiMelcvP7y" +
       "kt7Vm8rYMioN3VLY5udZzqNs2O7pzhrAMC05jawz5HTOjLzytYe+T/4URNUD" +
       "qELS1UwacNQk6WlDUYm5jWjExJTIA6iKaHIv7x9Ac+E9omhEtO5MJCxCB9Ac" +
       "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" +
       "sselfwHKc2KC/xgAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Xb/35t9+8Wv5mfr/AIZBN6DMIwAA");
}
