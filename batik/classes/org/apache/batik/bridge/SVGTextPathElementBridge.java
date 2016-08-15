package org.apache.batik.bridge;
public class SVGTextPathElementBridge extends org.apache.batik.bridge.AnimatableGenericSVGBridge implements org.apache.batik.bridge.ErrorConstants {
    public SVGTextPathElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_TEXT_PATH_TAG; }
    public void handleElement(org.apache.batik.bridge.BridgeContext ctx, org.w3c.dom.Element e) {
        
    }
    public org.apache.batik.gvt.text.TextPath createTextPath(org.apache.batik.bridge.BridgeContext ctx,
                                                             org.w3c.dom.Element textPathElement) {
        java.lang.String uri =
          org.apache.batik.dom.util.XLinkSupport.
          getXLinkHref(
            textPathElement);
        org.w3c.dom.Element pathElement =
          ctx.
          getReferencedElement(
            textPathElement,
            uri);
        if (pathElement ==
              null ||
              !SVG_NAMESPACE_URI.
              equals(
                pathElement.
                  getNamespaceURI(
                    )) ||
              !pathElement.
              getLocalName(
                ).
              equals(
                SVG_PATH_TAG)) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              textPathElement,
              ERR_URI_BAD_TARGET,
              new java.lang.Object[] { uri });
        }
        java.lang.String s =
          pathElement.
          getAttributeNS(
            null,
            SVG_D_ATTRIBUTE);
        java.awt.Shape pathShape =
          null;
        if (s.
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
                    pathElement));
            try {
                org.apache.batik.parser.PathParser pathParser =
                  new org.apache.batik.parser.PathParser(
                  );
                pathParser.
                  setPathHandler(
                    app);
                pathParser.
                  parse(
                    s);
            }
            catch (org.apache.batik.parser.ParseException pEx) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  pathElement,
                  pEx,
                  ERR_ATTRIBUTE_VALUE_MALFORMED,
                  new java.lang.Object[] { SVG_D_ATTRIBUTE });
            }
            finally {
                pathShape =
                  app.
                    getShape(
                      );
            }
        }
        else {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              pathElement,
              ERR_ATTRIBUTE_MISSING,
              new java.lang.Object[] { SVG_D_ATTRIBUTE });
        }
        s =
          pathElement.
            getAttributeNS(
              null,
              SVG_TRANSFORM_ATTRIBUTE);
        if (s.
              length(
                ) !=
              0) {
            java.awt.geom.AffineTransform tr =
              org.apache.batik.bridge.SVGUtilities.
              convertTransform(
                pathElement,
                SVG_TRANSFORM_ATTRIBUTE,
                s,
                ctx);
            pathShape =
              tr.
                createTransformedShape(
                  pathShape);
        }
        org.apache.batik.gvt.text.TextPath textPath =
          new org.apache.batik.gvt.text.TextPath(
          new java.awt.geom.GeneralPath(
            pathShape));
        s =
          textPathElement.
            getAttributeNS(
              null,
              SVG_START_OFFSET_ATTRIBUTE);
        if (s.
              length(
                ) >
              0) {
            float startOffset =
              0;
            int percentIndex =
              s.
              indexOf(
                '%');
            if (percentIndex !=
                  -1) {
                float pathLength =
                  textPath.
                  lengthOfPath(
                    );
                java.lang.String percentString =
                  s.
                  substring(
                    0,
                    percentIndex);
                float startOffsetPercent =
                  0;
                try {
                    startOffsetPercent =
                      org.apache.batik.bridge.SVGUtilities.
                        convertSVGNumber(
                          percentString);
                }
                catch (java.lang.NumberFormatException e) {
                    startOffsetPercent =
                      -1;
                }
                if (startOffsetPercent <
                      0) {
                    throw new org.apache.batik.bridge.BridgeException(
                      ctx,
                      textPathElement,
                      ERR_ATTRIBUTE_VALUE_MALFORMED,
                      new java.lang.Object[] { SVG_START_OFFSET_ATTRIBUTE,
                      s });
                }
                startOffset =
                  (float)
                    (startOffsetPercent *
                       pathLength /
                       100.0);
            }
            else {
                org.apache.batik.parser.UnitProcessor.Context uctx =
                  org.apache.batik.bridge.UnitProcessor.
                  createContext(
                    ctx,
                    textPathElement);
                startOffset =
                  org.apache.batik.bridge.UnitProcessor.
                    svgOtherLengthToUserSpace(
                      s,
                      SVG_START_OFFSET_ATTRIBUTE,
                      uctx);
            }
            textPath.
              setStartOffset(
                startOffset);
        }
        return textPath;
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
      ("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" +
       "p77/B0JfQpBuIgAA");
}
