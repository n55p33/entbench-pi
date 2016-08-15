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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "ARJb9DVXFwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
