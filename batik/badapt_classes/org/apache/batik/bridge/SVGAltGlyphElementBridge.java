package org.apache.batik.bridge;
public class SVGAltGlyphElementBridge extends org.apache.batik.bridge.AbstractSVGBridge implements org.apache.batik.bridge.ErrorConstants {
    public static final java.text.AttributedCharacterIterator.Attribute PAINT_INFO =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        PAINT_INFO;
    public SVGAltGlyphElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_ALT_GLYPH_TAG;
    }
    public org.apache.batik.gvt.font.Glyph[] createAltGlyphArray(org.apache.batik.bridge.BridgeContext ctx,
                                                                 org.w3c.dom.Element altGlyphElement,
                                                                 float fontSize,
                                                                 java.text.AttributedCharacterIterator aci) {
        java.lang.String uri =
          org.apache.batik.dom.util.XLinkSupport.
          getXLinkHref(
            altGlyphElement);
        org.w3c.dom.Element refElement =
          null;
        try {
            refElement =
              ctx.
                getReferencedElement(
                  altGlyphElement,
                  uri);
        }
        catch (org.apache.batik.bridge.BridgeException e) {
            if (ERR_URI_UNSECURE.
                  equals(
                    e.
                      getCode(
                        ))) {
                ctx.
                  getUserAgent(
                    ).
                  displayError(
                    e);
            }
        }
        if (refElement ==
              null) {
            return null;
        }
        if (!SVG_NAMESPACE_URI.
              equals(
                refElement.
                  getNamespaceURI(
                    )))
            return null;
        if (refElement.
              getLocalName(
                ).
              equals(
                SVG_GLYPH_TAG)) {
            org.apache.batik.gvt.font.Glyph glyph =
              getGlyph(
                ctx,
                uri,
                altGlyphElement,
                fontSize,
                aci);
            if (glyph ==
                  null) {
                return null;
            }
            org.apache.batik.gvt.font.Glyph[] glyphArray =
              new org.apache.batik.gvt.font.Glyph[1];
            glyphArray[0] =
              glyph;
            return glyphArray;
        }
        if (refElement.
              getLocalName(
                ).
              equals(
                SVG_ALT_GLYPH_DEF_TAG)) {
            org.apache.batik.dom.svg.SVGOMDocument document =
              (org.apache.batik.dom.svg.SVGOMDocument)
                altGlyphElement.
                getOwnerDocument(
                  );
            org.apache.batik.dom.svg.SVGOMDocument refDocument =
              (org.apache.batik.dom.svg.SVGOMDocument)
                refElement.
                getOwnerDocument(
                  );
            boolean isLocal =
              refDocument ==
              document;
            org.w3c.dom.Element localRefElement =
              isLocal
              ? refElement
              : (org.w3c.dom.Element)
                  document.
                  importNode(
                    refElement,
                    true);
            if (!isLocal) {
                java.lang.String base =
                  org.apache.batik.dom.AbstractNode.
                  getBaseURI(
                    altGlyphElement);
                org.w3c.dom.Element g =
                  document.
                  createElementNS(
                    SVG_NAMESPACE_URI,
                    SVG_G_TAG);
                g.
                  appendChild(
                    localRefElement);
                g.
                  setAttributeNS(
                    org.apache.batik.util.XMLConstants.
                      XML_NAMESPACE_URI,
                    "xml:base",
                    base);
                org.apache.batik.bridge.CSSUtilities.
                  computeStyleAndURIs(
                    refElement,
                    localRefElement,
                    uri);
            }
            org.w3c.dom.NodeList altGlyphDefChildren =
              localRefElement.
              getChildNodes(
                );
            boolean containsGlyphRefNodes =
              false;
            int numAltGlyphDefChildren =
              altGlyphDefChildren.
              getLength(
                );
            for (int i =
                   0;
                 i <
                   numAltGlyphDefChildren;
                 i++) {
                org.w3c.dom.Node altGlyphChild =
                  altGlyphDefChildren.
                  item(
                    i);
                if (altGlyphChild.
                      getNodeType(
                        ) ==
                      org.w3c.dom.Node.
                        ELEMENT_NODE) {
                    org.w3c.dom.Element agc =
                      (org.w3c.dom.Element)
                        altGlyphChild;
                    if (SVG_NAMESPACE_URI.
                          equals(
                            agc.
                              getNamespaceURI(
                                )) &&
                          SVG_GLYPH_REF_TAG.
                          equals(
                            agc.
                              getLocalName(
                                ))) {
                        containsGlyphRefNodes =
                          true;
                        break;
                    }
                }
            }
            if (containsGlyphRefNodes) {
                org.w3c.dom.NodeList glyphRefNodes =
                  localRefElement.
                  getElementsByTagNameNS(
                    SVG_NAMESPACE_URI,
                    SVG_GLYPH_REF_TAG);
                int numGlyphRefNodes =
                  glyphRefNodes.
                  getLength(
                    );
                org.apache.batik.gvt.font.Glyph[] glyphArray =
                  new org.apache.batik.gvt.font.Glyph[numGlyphRefNodes];
                for (int i =
                       0;
                     i <
                       numGlyphRefNodes;
                     i++) {
                    org.w3c.dom.Element glyphRefElement =
                      (org.w3c.dom.Element)
                        glyphRefNodes.
                        item(
                          i);
                    java.lang.String glyphUri =
                      org.apache.batik.dom.util.XLinkSupport.
                      getXLinkHref(
                        glyphRefElement);
                    org.apache.batik.gvt.font.Glyph glyph =
                      getGlyph(
                        ctx,
                        glyphUri,
                        glyphRefElement,
                        fontSize,
                        aci);
                    if (glyph ==
                          null) {
                        return null;
                    }
                    glyphArray[i] =
                      glyph;
                }
                return glyphArray;
            }
            else {
                org.w3c.dom.NodeList altGlyphItemNodes =
                  localRefElement.
                  getElementsByTagNameNS(
                    SVG_NAMESPACE_URI,
                    SVG_ALT_GLYPH_ITEM_TAG);
                int numAltGlyphItemNodes =
                  altGlyphItemNodes.
                  getLength(
                    );
                if (numAltGlyphItemNodes >
                      0) {
                    boolean foundMatchingGlyph =
                      false;
                    org.apache.batik.gvt.font.Glyph[] glyphArray =
                      null;
                    for (int i =
                           0;
                         i <
                           numAltGlyphItemNodes &&
                           !foundMatchingGlyph;
                         i++) {
                        org.w3c.dom.Element altGlyphItemElement =
                          (org.w3c.dom.Element)
                            altGlyphItemNodes.
                            item(
                              i);
                        org.w3c.dom.NodeList altGlyphRefNodes =
                          altGlyphItemElement.
                          getElementsByTagNameNS(
                            SVG_NAMESPACE_URI,
                            SVG_GLYPH_REF_TAG);
                        int numAltGlyphRefNodes =
                          altGlyphRefNodes.
                          getLength(
                            );
                        glyphArray =
                          (new org.apache.batik.gvt.font.Glyph[numAltGlyphRefNodes]);
                        foundMatchingGlyph =
                          true;
                        for (int j =
                               0;
                             j <
                               numAltGlyphRefNodes;
                             j++) {
                            org.w3c.dom.Element glyphRefElement =
                              (org.w3c.dom.Element)
                                altGlyphRefNodes.
                                item(
                                  j);
                            java.lang.String glyphUri =
                              org.apache.batik.dom.util.XLinkSupport.
                              getXLinkHref(
                                glyphRefElement);
                            org.apache.batik.gvt.font.Glyph glyph =
                              getGlyph(
                                ctx,
                                glyphUri,
                                glyphRefElement,
                                fontSize,
                                aci);
                            if (glyph !=
                                  null) {
                                glyphArray[j] =
                                  glyph;
                            }
                            else {
                                foundMatchingGlyph =
                                  false;
                                break;
                            }
                        }
                    }
                    if (!foundMatchingGlyph) {
                        return null;
                    }
                    return glyphArray;
                }
            }
        }
        return null;
    }
    private org.apache.batik.gvt.font.Glyph getGlyph(org.apache.batik.bridge.BridgeContext ctx,
                                                     java.lang.String glyphUri,
                                                     org.w3c.dom.Element altGlyphElement,
                                                     float fontSize,
                                                     java.text.AttributedCharacterIterator aci) {
        org.w3c.dom.Element refGlyphElement =
          null;
        try {
            refGlyphElement =
              ctx.
                getReferencedElement(
                  altGlyphElement,
                  glyphUri);
        }
        catch (org.apache.batik.bridge.BridgeException e) {
            if (ERR_URI_UNSECURE.
                  equals(
                    e.
                      getCode(
                        ))) {
                ctx.
                  getUserAgent(
                    ).
                  displayError(
                    e);
            }
        }
        if (refGlyphElement ==
              null ||
              !SVG_NAMESPACE_URI.
              equals(
                refGlyphElement.
                  getNamespaceURI(
                    )) ||
              !SVG_GLYPH_TAG.
              equals(
                refGlyphElement.
                  getLocalName(
                    )))
            return null;
        org.apache.batik.dom.svg.SVGOMDocument document =
          (org.apache.batik.dom.svg.SVGOMDocument)
            altGlyphElement.
            getOwnerDocument(
              );
        org.apache.batik.dom.svg.SVGOMDocument refDocument =
          (org.apache.batik.dom.svg.SVGOMDocument)
            refGlyphElement.
            getOwnerDocument(
              );
        boolean isLocal =
          refDocument ==
          document;
        org.w3c.dom.Element localGlyphElement =
          null;
        org.w3c.dom.Element localFontFaceElement =
          null;
        org.w3c.dom.Element localFontElement =
          null;
        if (isLocal) {
            localGlyphElement =
              refGlyphElement;
            localFontElement =
              (org.w3c.dom.Element)
                localGlyphElement.
                getParentNode(
                  );
            org.w3c.dom.NodeList fontFaceElements =
              localFontElement.
              getElementsByTagNameNS(
                SVG_NAMESPACE_URI,
                SVG_FONT_FACE_TAG);
            if (fontFaceElements.
                  getLength(
                    ) >
                  0) {
                localFontFaceElement =
                  (org.w3c.dom.Element)
                    fontFaceElements.
                    item(
                      0);
            }
        }
        else {
            localFontElement =
              (org.w3c.dom.Element)
                document.
                importNode(
                  refGlyphElement.
                    getParentNode(
                      ),
                  true);
            java.lang.String base =
              org.apache.batik.dom.AbstractNode.
              getBaseURI(
                altGlyphElement);
            org.w3c.dom.Element g =
              document.
              createElementNS(
                SVG_NAMESPACE_URI,
                SVG_G_TAG);
            g.
              appendChild(
                localFontElement);
            g.
              setAttributeNS(
                org.apache.batik.util.XMLConstants.
                  XML_NAMESPACE_URI,
                "xml:base",
                base);
            org.apache.batik.bridge.CSSUtilities.
              computeStyleAndURIs(
                (org.w3c.dom.Element)
                  refGlyphElement.
                  getParentNode(
                    ),
                localFontElement,
                glyphUri);
            java.lang.String glyphId =
              refGlyphElement.
              getAttributeNS(
                null,
                SVG_ID_ATTRIBUTE);
            org.w3c.dom.NodeList glyphElements =
              localFontElement.
              getElementsByTagNameNS(
                SVG_NAMESPACE_URI,
                SVG_GLYPH_TAG);
            for (int i =
                   0;
                 i <
                   glyphElements.
                   getLength(
                     );
                 i++) {
                org.w3c.dom.Element glyphElem =
                  (org.w3c.dom.Element)
                    glyphElements.
                    item(
                      i);
                if (glyphElem.
                      getAttributeNS(
                        null,
                        SVG_ID_ATTRIBUTE).
                      equals(
                        glyphId)) {
                    localGlyphElement =
                      glyphElem;
                    break;
                }
            }
            org.w3c.dom.NodeList fontFaceElements =
              localFontElement.
              getElementsByTagNameNS(
                SVG_NAMESPACE_URI,
                SVG_FONT_FACE_TAG);
            if (fontFaceElements.
                  getLength(
                    ) >
                  0) {
                localFontFaceElement =
                  (org.w3c.dom.Element)
                    fontFaceElements.
                    item(
                      0);
            }
        }
        if (localGlyphElement ==
              null ||
              localFontFaceElement ==
              null) {
            return null;
        }
        org.apache.batik.bridge.SVGFontFaceElementBridge fontFaceBridge =
          (org.apache.batik.bridge.SVGFontFaceElementBridge)
            ctx.
            getBridge(
              localFontFaceElement);
        org.apache.batik.bridge.SVGFontFace fontFace =
          fontFaceBridge.
          createFontFace(
            ctx,
            localFontFaceElement);
        org.apache.batik.bridge.SVGGlyphElementBridge glyphBridge =
          (org.apache.batik.bridge.SVGGlyphElementBridge)
            ctx.
            getBridge(
              localGlyphElement);
        aci.
          first(
            );
        org.apache.batik.gvt.text.TextPaintInfo tpi =
          (org.apache.batik.gvt.text.TextPaintInfo)
            aci.
            getAttribute(
              PAINT_INFO);
        return glyphBridge.
          createGlyph(
            ctx,
            localGlyphElement,
            altGlyphElement,
            -1,
            fontSize,
            fontFace,
            tpi);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "ARIm8ScFHAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
