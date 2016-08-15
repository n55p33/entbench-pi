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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AF2UKgwFHAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "hST20LHUm3AMt6pvRgwTh2ZYBHgs2m61SGhso1omYlysgUWqZ2J8Hd+kcQVO" +
       "VNnq9vnA7PAY3mniK8G07ULftctSSk4xWyjVS2WzUac6s26JcfiybCsWDi+D" +
       "NqZi2IyHOwPOqmNwoOF1ny1gVRtmA9wY12IExWt037JtTgpEVEWHvjnvijUL" +
       "WU7Z0Zzd6JQYVbGNibt9ngqjAWcLtFIfgxy0BnJUjpZ6JoOvGHRATNp6hVq1" +
       "4naILqsdOF5sTCpSRoLYdBtrJKF5qdumB0W3xoktVV01nAInNsWCiqbOZAmy" +
       "NkcbY62OIHilDVETANxgnem4EQqaMikMZnMrmCVpm4RTX+/1JrHvMXRhMpBF" +
       "JkJNhiaplTAaFO246/nxkJFUYMR47iooVcVpl7Mn49aIDSuTkDIQQVokRYOT" +
       "S6ZiEAvcw0mc7qXsAi9Phm7SQApEo6IEFDVUkZErpBHIH73Zwku6njnA1ji3" +
       "0uYFp12zcKwP16mSwJgrqg1ef7PXYuPl7UzcnG/C7J8Uzh0saxi8jDfybdN9" +
       "WfHg/hZZ/ju9d6q09394N/pgi/LY3obPQ1c7a2mGoR/uHwtnmxJ3Xe28MN+Q" +
       "+Pg7nnxa630COb67EyzH0PWxH/yioy9159DIJ0BPj1x986WbH5ce7FB+6R3/" +
       "eif/+tnjL+Pc5Z4jch7t8g+6z3yl9ZD6oePQif39yssOci9levTSXcqzoR4n" +
       "ocdfsld5174hbsnm/W5wYbuGwK589nFFpzmWO83WVa6x0f6Wa7S9LSvWMXSD" +
       "qcesr8oOtyv64MC7Nj9pv+dwp3nFcl+/W7PKh8DV2tWv9X+j38nd3fNd13zw" +
       "aq65PfTb/Vpgj/rWjHqFqjua7+7sng7mbW88FEyPZ/u+ji/vcz34U+3Z5tK+" +
       "9xoz/lRWvBMIoYa6HOt7h5T5qQrw9wev7u85yXbv8OlPPvD1tz79wD/kZxdn" +
       "rEiUw3poXuGg/hDPD5554XvfvPGuZ/PzvZOKHG0d8ugXDpd/wHDJdwm5Djdc" +
       "enZ3/lr23Zu+ey4zkbmMdwxgmZ18AoIggA587l0/g8/lMXUnuH60K9OPXo7P" +
       "xdB1QWgtgWmu6HincqpT2eP79qH4N7LiA1nxoZzpk9ew/6ey4ndj6AyIuFzx" +
       "7Pl3DjT/vZejeRpDd1ztpDs7trvjsq9rtl+EqM8+fe7M7U8Lf711hr2vNq5n" +
       "oTNG4jiHT1kO3Z8OQt2wci2u3565BPnfczF0+1UCMIZOb29y0Z/d0n8uhs4f" +
       "pQfRlv8fpvt8DJ09oANdbW8Ok3whhk4Akuz2j4M9V3v4amhQV6I4C1cwZds5" +
       "So8dWm52HSm3wi0/yQr7LIcPibOQzT972ltOku2HTxfV557ucG9+sfqJ7SG1" +
       "6sibTdbLGRBd2/Py/SXpvqv2ttfX6fbDL9302esf3Fs+b9oKfODUh2S758on" +
       "wk03iPMz3M0Xbv/D1/3+09/OT1D+FxLgJw6PJgAA");
}
