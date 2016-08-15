package org.apache.batik.bridge;
public class SVGGlyphElementBridge extends org.apache.batik.bridge.AbstractSVGBridge implements org.apache.batik.bridge.ErrorConstants {
    protected SVGGlyphElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_GLYPH_TAG; }
    public org.apache.batik.gvt.font.Glyph createGlyph(org.apache.batik.bridge.BridgeContext ctx,
                                                       org.w3c.dom.Element glyphElement,
                                                       org.w3c.dom.Element textElement,
                                                       int glyphCode,
                                                       float fontSize,
                                                       org.apache.batik.gvt.font.GVTFontFace fontFace,
                                                       org.apache.batik.gvt.text.TextPaintInfo tpi) {
        float fontHeight =
          fontFace.
          getUnitsPerEm(
            );
        float scale =
          fontSize /
          fontHeight;
        java.awt.geom.AffineTransform scaleTransform =
          java.awt.geom.AffineTransform.
          getScaleInstance(
            scale,
            -scale);
        java.lang.String d =
          glyphElement.
          getAttributeNS(
            null,
            SVG_D_ATTRIBUTE);
        java.awt.Shape dShape =
          null;
        if (d.
              length(
                ) !=
              0) {
            org.apache.batik.parser.AWTPathProducer app =
              new org.apache.batik.parser.AWTPathProducer(
              );
            app.
              setWindingRule(
                org.apache.batik.bridge.CSSUtilities.
                  convertFillRule(
                    textElement));
            try {
                org.apache.batik.parser.PathParser pathParser =
                  new org.apache.batik.parser.PathParser(
                  );
                pathParser.
                  setPathHandler(
                    app);
                pathParser.
                  parse(
                    d);
            }
            catch (org.apache.batik.parser.ParseException pEx) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  glyphElement,
                  pEx,
                  ERR_ATTRIBUTE_VALUE_MALFORMED,
                  new java.lang.Object[] { SVG_D_ATTRIBUTE });
            }
            finally {
                java.awt.Shape shape =
                  app.
                  getShape(
                    );
                java.awt.Shape transformedShape =
                  scaleTransform.
                  createTransformedShape(
                    shape);
                dShape =
                  transformedShape;
            }
        }
        org.w3c.dom.NodeList glyphChildren =
          glyphElement.
          getChildNodes(
            );
        int numChildren =
          glyphChildren.
          getLength(
            );
        int numGlyphChildren =
          0;
        for (int i =
               0;
             i <
               numChildren;
             i++) {
            org.w3c.dom.Node childNode =
              glyphChildren.
              item(
                i);
            if (childNode.
                  getNodeType(
                    ) ==
                  org.w3c.dom.Node.
                    ELEMENT_NODE) {
                numGlyphChildren++;
            }
        }
        org.apache.batik.gvt.CompositeGraphicsNode glyphContentNode =
          null;
        if (numGlyphChildren >
              0) {
            org.apache.batik.bridge.GVTBuilder builder =
              ctx.
              getGVTBuilder(
                );
            glyphContentNode =
              new org.apache.batik.gvt.CompositeGraphicsNode(
                );
            org.w3c.dom.Element fontElementClone =
              (org.w3c.dom.Element)
                glyphElement.
                getParentNode(
                  ).
                cloneNode(
                  false);
            org.w3c.dom.NamedNodeMap fontAttributes =
              glyphElement.
              getParentNode(
                ).
              getAttributes(
                );
            int numAttributes =
              fontAttributes.
              getLength(
                );
            for (int i =
                   0;
                 i <
                   numAttributes;
                 i++) {
                fontElementClone.
                  setAttributeNode(
                    (org.w3c.dom.Attr)
                      fontAttributes.
                      item(
                        i));
            }
            org.w3c.dom.Element clonedGlyphElement =
              (org.w3c.dom.Element)
                glyphElement.
                cloneNode(
                  true);
            fontElementClone.
              appendChild(
                clonedGlyphElement);
            textElement.
              appendChild(
                fontElementClone);
            org.apache.batik.gvt.CompositeGraphicsNode glyphChildrenNode =
              new org.apache.batik.gvt.CompositeGraphicsNode(
              );
            glyphChildrenNode.
              setTransform(
                scaleTransform);
            org.w3c.dom.NodeList clonedGlyphChildren =
              clonedGlyphElement.
              getChildNodes(
                );
            int numClonedChildren =
              clonedGlyphChildren.
              getLength(
                );
            for (int i =
                   0;
                 i <
                   numClonedChildren;
                 i++) {
                org.w3c.dom.Node childNode =
                  clonedGlyphChildren.
                  item(
                    i);
                if (childNode.
                      getNodeType(
                        ) ==
                      org.w3c.dom.Node.
                        ELEMENT_NODE) {
                    org.w3c.dom.Element childElement =
                      (org.w3c.dom.Element)
                        childNode;
                    org.apache.batik.gvt.GraphicsNode childGraphicsNode =
                      builder.
                      build(
                        ctx,
                        childElement);
                    glyphChildrenNode.
                      add(
                        childGraphicsNode);
                }
            }
            glyphContentNode.
              add(
                glyphChildrenNode);
            textElement.
              removeChild(
                fontElementClone);
        }
        java.lang.String unicode =
          glyphElement.
          getAttributeNS(
            null,
            SVG_UNICODE_ATTRIBUTE);
        java.lang.String nameList =
          glyphElement.
          getAttributeNS(
            null,
            SVG_GLYPH_NAME_ATTRIBUTE);
        java.util.List names =
          new java.util.ArrayList(
          );
        java.util.StringTokenizer st =
          new java.util.StringTokenizer(
          nameList,
          " ,");
        while (st.
                 hasMoreTokens(
                   )) {
            names.
              add(
                st.
                  nextToken(
                    ));
        }
        java.lang.String orientation =
          glyphElement.
          getAttributeNS(
            null,
            SVG_ORIENTATION_ATTRIBUTE);
        java.lang.String arabicForm =
          glyphElement.
          getAttributeNS(
            null,
            SVG_ARABIC_FORM_ATTRIBUTE);
        java.lang.String lang =
          glyphElement.
          getAttributeNS(
            null,
            SVG_LANG_ATTRIBUTE);
        org.w3c.dom.Element parentFontElement =
          (org.w3c.dom.Element)
            glyphElement.
            getParentNode(
              );
        java.lang.String s =
          glyphElement.
          getAttributeNS(
            null,
            SVG_HORIZ_ADV_X_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            s =
              parentFontElement.
                getAttributeNS(
                  null,
                  SVG_HORIZ_ADV_X_ATTRIBUTE);
            if (s.
                  length(
                    ) ==
                  0) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  parentFontElement,
                  ERR_ATTRIBUTE_MISSING,
                  new java.lang.Object[] { SVG_HORIZ_ADV_X_ATTRIBUTE });
            }
        }
        float horizAdvX;
        try {
            horizAdvX =
              org.apache.batik.bridge.SVGUtilities.
                convertSVGNumber(
                  s) *
                scale;
        }
        catch (java.lang.NumberFormatException nfEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              glyphElement,
              nfEx,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_HORIZ_ADV_X_ATTRIBUTE,
              s });
        }
        s =
          glyphElement.
            getAttributeNS(
              null,
              SVG_VERT_ADV_Y_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            s =
              parentFontElement.
                getAttributeNS(
                  null,
                  SVG_VERT_ADV_Y_ATTRIBUTE);
            if (s.
                  length(
                    ) ==
                  0) {
                s =
                  java.lang.String.
                    valueOf(
                      fontFace.
                        getUnitsPerEm(
                          ));
            }
        }
        float vertAdvY;
        try {
            vertAdvY =
              org.apache.batik.bridge.SVGUtilities.
                convertSVGNumber(
                  s) *
                scale;
        }
        catch (java.lang.NumberFormatException nfEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              glyphElement,
              nfEx,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_VERT_ADV_Y_ATTRIBUTE,
              s });
        }
        s =
          glyphElement.
            getAttributeNS(
              null,
              SVG_VERT_ORIGIN_X_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            s =
              parentFontElement.
                getAttributeNS(
                  null,
                  SVG_VERT_ORIGIN_X_ATTRIBUTE);
            if (s.
                  length(
                    ) ==
                  0) {
                s =
                  java.lang.Float.
                    toString(
                      horizAdvX /
                        2);
            }
        }
        float vertOriginX;
        try {
            vertOriginX =
              org.apache.batik.bridge.SVGUtilities.
                convertSVGNumber(
                  s) *
                scale;
        }
        catch (java.lang.NumberFormatException nfEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              glyphElement,
              nfEx,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_VERT_ORIGIN_X_ATTRIBUTE,
              s });
        }
        s =
          glyphElement.
            getAttributeNS(
              null,
              SVG_VERT_ORIGIN_Y_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            s =
              parentFontElement.
                getAttributeNS(
                  null,
                  SVG_VERT_ORIGIN_Y_ATTRIBUTE);
            if (s.
                  length(
                    ) ==
                  0) {
                s =
                  java.lang.String.
                    valueOf(
                      fontFace.
                        getAscent(
                          ));
            }
        }
        float vertOriginY;
        try {
            vertOriginY =
              org.apache.batik.bridge.SVGUtilities.
                convertSVGNumber(
                  s) *
                -scale;
        }
        catch (java.lang.NumberFormatException nfEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              glyphElement,
              nfEx,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_VERT_ORIGIN_Y_ATTRIBUTE,
              s });
        }
        java.awt.geom.Point2D vertOrigin =
          new java.awt.geom.Point2D.Float(
          vertOriginX,
          vertOriginY);
        s =
          parentFontElement.
            getAttributeNS(
              null,
              SVG_HORIZ_ORIGIN_X_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            s =
              SVG_HORIZ_ORIGIN_X_DEFAULT_VALUE;
        }
        float horizOriginX;
        try {
            horizOriginX =
              org.apache.batik.bridge.SVGUtilities.
                convertSVGNumber(
                  s) *
                scale;
        }
        catch (java.lang.NumberFormatException nfEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              parentFontElement,
              nfEx,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_HORIZ_ORIGIN_X_ATTRIBUTE,
              s });
        }
        s =
          parentFontElement.
            getAttributeNS(
              null,
              SVG_HORIZ_ORIGIN_Y_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            s =
              SVG_HORIZ_ORIGIN_Y_DEFAULT_VALUE;
        }
        float horizOriginY;
        try {
            horizOriginY =
              org.apache.batik.bridge.SVGUtilities.
                convertSVGNumber(
                  s) *
                -scale;
        }
        catch (java.lang.NumberFormatException nfEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              glyphElement,
              nfEx,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_HORIZ_ORIGIN_Y_ATTRIBUTE,
              s });
        }
        java.awt.geom.Point2D horizOrigin =
          new java.awt.geom.Point2D.Float(
          horizOriginX,
          horizOriginY);
        return new org.apache.batik.gvt.font.Glyph(
          unicode,
          names,
          orientation,
          arabicForm,
          lang,
          horizOrigin,
          vertOrigin,
          horizAdvX,
          vertAdvY,
          glyphCode,
          tpi,
          dShape,
          glyphContentNode);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AYS/coJXFwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
