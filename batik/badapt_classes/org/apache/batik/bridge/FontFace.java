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
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
