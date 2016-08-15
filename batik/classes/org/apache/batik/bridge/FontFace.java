package org.apache.batik.bridge;
public abstract class FontFace extends org.apache.batik.gvt.font.GVTFontFace implements org.apache.batik.bridge.ErrorConstants {
    java.util.List srcs;
    public FontFace(java.util.List srcs, java.lang.String familyName, float unitsPerEm,
                    java.lang.String fontWeight,
                    java.lang.String fontStyle,
                    java.lang.String fontVariant,
                    java.lang.String fontStretch,
                    float slope,
                    java.lang.String panose1,
                    float ascent,
                    float descent,
                    float strikethroughPosition,
                    float strikethroughThickness,
                    float underlinePosition,
                    float underlineThickness,
                    float overlinePosition,
                    float overlineThickness) { super(familyName, unitsPerEm,
                                                     fontWeight,
                                                     fontStyle,
                                                     fontVariant,
                                                     fontStretch,
                                                     slope,
                                                     panose1,
                                                     ascent,
                                                     descent,
                                                     strikethroughPosition,
                                                     strikethroughThickness,
                                                     underlinePosition,
                                                     underlineThickness,
                                                     overlinePosition,
                                                     overlineThickness);
                                               this.srcs = srcs; }
    protected FontFace(java.lang.String familyName) { super(familyName);
    }
    public static org.apache.batik.bridge.CSSFontFace createFontFace(java.lang.String familyName,
                                                                     org.apache.batik.bridge.FontFace src) {
        return new org.apache.batik.bridge.CSSFontFace(
          new java.util.LinkedList(
            src.
              srcs),
          familyName,
          src.
            unitsPerEm,
          src.
            fontWeight,
          src.
            fontStyle,
          src.
            fontVariant,
          src.
            fontStretch,
          src.
            slope,
          src.
            panose1,
          src.
            ascent,
          src.
            descent,
          src.
            strikethroughPosition,
          src.
            strikethroughThickness,
          src.
            underlinePosition,
          src.
            underlineThickness,
          src.
            overlinePosition,
          src.
            overlineThickness);
    }
    public org.apache.batik.gvt.font.GVTFontFamily getFontFamily(org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String name =
          org.apache.batik.gvt.font.FontFamilyResolver.
          lookup(
            familyName);
        if (name !=
              null) {
            org.apache.batik.gvt.font.GVTFontFace ff =
              createFontFace(
                name,
                this);
            return new org.apache.batik.gvt.font.AWTFontFamily(
              ff);
        }
        java.util.Iterator iter =
          srcs.
          iterator(
            );
        while (iter.
                 hasNext(
                   )) {
            java.lang.Object o =
              iter.
              next(
                );
            if (o instanceof java.lang.String) {
                java.lang.String str =
                  (java.lang.String)
                    o;
                name =
                  org.apache.batik.gvt.font.FontFamilyResolver.
                    lookup(
                      str);
                if (name !=
                      null) {
                    org.apache.batik.gvt.font.GVTFontFace ff =
                      createFontFace(
                        str,
                        this);
                    return new org.apache.batik.gvt.font.AWTFontFamily(
                      ff);
                }
            }
            else
                if (o instanceof org.apache.batik.util.ParsedURL) {
                    try {
                        org.apache.batik.gvt.font.GVTFontFamily ff =
                          getFontFamily(
                            ctx,
                            (org.apache.batik.util.ParsedURL)
                              o);
                        if (ff !=
                              null)
                            return ff;
                    }
                    catch (java.lang.SecurityException ex) {
                        ctx.
                          getUserAgent(
                            ).
                          displayError(
                            ex);
                    }
                    catch (org.apache.batik.bridge.BridgeException ex) {
                        if (ERR_URI_UNSECURE.
                              equals(
                                ex.
                                  getCode(
                                    )))
                            ctx.
                              getUserAgent(
                                ).
                              displayError(
                                ex);
                    }
                    catch (java.lang.Exception ex) {
                        
                    }
                }
        }
        return new org.apache.batik.gvt.font.AWTFontFamily(
          this);
    }
    protected org.apache.batik.gvt.font.GVTFontFamily getFontFamily(org.apache.batik.bridge.BridgeContext ctx,
                                                                    org.apache.batik.util.ParsedURL purl) {
        java.lang.String purlStr =
          purl.
          toString(
            );
        org.w3c.dom.Element e =
          getBaseElement(
            ctx);
        org.w3c.dom.svg.SVGDocument svgDoc =
          (org.w3c.dom.svg.SVGDocument)
            e.
            getOwnerDocument(
              );
        java.lang.String docURL =
          svgDoc.
          getURL(
            );
        org.apache.batik.util.ParsedURL pDocURL =
          null;
        if (docURL !=
              null)
            pDocURL =
              new org.apache.batik.util.ParsedURL(
                docURL);
        java.lang.String baseURI =
          org.apache.batik.dom.AbstractNode.
          getBaseURI(
            e);
        purl =
          new org.apache.batik.util.ParsedURL(
            baseURI,
            purlStr);
        org.apache.batik.bridge.UserAgent userAgent =
          ctx.
          getUserAgent(
            );
        try {
            userAgent.
              checkLoadExternalResource(
                purl,
                pDocURL);
        }
        catch (java.lang.SecurityException ex) {
            userAgent.
              displayError(
                ex);
            return null;
        }
        if (purl.
              getRef(
                ) !=
              null) {
            org.w3c.dom.Element ref =
              ctx.
              getReferencedElement(
                e,
                purlStr);
            if (!ref.
                  getNamespaceURI(
                    ).
                  equals(
                    SVG_NAMESPACE_URI) ||
                  !ref.
                  getLocalName(
                    ).
                  equals(
                    SVG_FONT_TAG)) {
                return null;
            }
            org.w3c.dom.svg.SVGDocument doc =
              (org.w3c.dom.svg.SVGDocument)
                e.
                getOwnerDocument(
                  );
            org.w3c.dom.svg.SVGDocument rdoc =
              (org.w3c.dom.svg.SVGDocument)
                ref.
                getOwnerDocument(
                  );
            org.w3c.dom.Element fontElt =
              ref;
            if (doc !=
                  rdoc) {
                fontElt =
                  (org.w3c.dom.Element)
                    doc.
                    importNode(
                      ref,
                      true);
                java.lang.String base =
                  org.apache.batik.dom.AbstractNode.
                  getBaseURI(
                    ref);
                org.w3c.dom.Element g =
                  doc.
                  createElementNS(
                    SVG_NAMESPACE_URI,
                    SVG_G_TAG);
                g.
                  appendChild(
                    fontElt);
                g.
                  setAttributeNS(
                    org.apache.batik.util.XMLConstants.
                      XML_NAMESPACE_URI,
                    "xml:base",
                    base);
                org.apache.batik.bridge.CSSUtilities.
                  computeStyleAndURIs(
                    ref,
                    fontElt,
                    purlStr);
            }
            org.w3c.dom.Element fontFaceElt =
              null;
            for (org.w3c.dom.Node n =
                   fontElt.
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
                        SVG_FONT_FACE_TAG)) {
                    fontFaceElt =
                      (org.w3c.dom.Element)
                        n;
                    break;
                }
            }
            org.apache.batik.bridge.SVGFontFaceElementBridge fontFaceBridge;
            fontFaceBridge =
              (org.apache.batik.bridge.SVGFontFaceElementBridge)
                ctx.
                getBridge(
                  SVG_NAMESPACE_URI,
                  SVG_FONT_FACE_TAG);
            org.apache.batik.gvt.font.GVTFontFace gff =
              fontFaceBridge.
              createFontFace(
                ctx,
                fontFaceElt);
            return new org.apache.batik.bridge.SVGFontFamily(
              gff,
              fontElt,
              ctx);
        }
        try {
            java.awt.Font font =
              java.awt.Font.
              createFont(
                java.awt.Font.
                  TRUETYPE_FONT,
                purl.
                  openStream(
                    ));
            return new org.apache.batik.gvt.font.AWTFontFamily(
              this,
              font);
        }
        catch (java.lang.Exception ex) {
            
        }
        return null;
    }
    protected org.w3c.dom.Element getBaseElement(org.apache.batik.bridge.BridgeContext ctx) {
        org.w3c.dom.svg.SVGDocument d =
          (org.w3c.dom.svg.SVGDocument)
            ctx.
            getDocument(
              );
        return d.
          getRootElement(
            );
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
      ("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");
}
