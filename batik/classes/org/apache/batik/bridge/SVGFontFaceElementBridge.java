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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "lT0u/QslzT5Z/xgAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "cNfvvfm3X/h6fqb+P7ezvprMIwAA");
}
