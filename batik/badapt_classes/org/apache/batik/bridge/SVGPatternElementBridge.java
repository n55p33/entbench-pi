package org.apache.batik.bridge;
public class SVGPatternElementBridge extends org.apache.batik.bridge.AnimatableGenericSVGBridge implements org.apache.batik.bridge.PaintBridge, org.apache.batik.bridge.ErrorConstants {
    public SVGPatternElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_PATTERN_TAG; }
    public java.awt.Paint createPaint(org.apache.batik.bridge.BridgeContext ctx,
                                      org.w3c.dom.Element patternElement,
                                      org.w3c.dom.Element paintedElement,
                                      org.apache.batik.gvt.GraphicsNode paintedNode,
                                      float opacity) { org.apache.batik.gvt.RootGraphicsNode patternContentNode;
                                                       patternContentNode =
                                                         (org.apache.batik.gvt.RootGraphicsNode)
                                                           ctx.
                                                           getElementData(
                                                             patternElement);
                                                       if (patternContentNode ==
                                                             null) {
                                                           patternContentNode =
                                                             extractPatternContent(
                                                               patternElement,
                                                               ctx);
                                                           ctx.
                                                             setElementData(
                                                               patternElement,
                                                               patternContentNode);
                                                       }
                                                       if (patternContentNode ==
                                                             null) {
                                                           return null;
                                                       }
                                                       java.awt.geom.Rectangle2D patternRegion =
                                                         org.apache.batik.bridge.SVGUtilities.
                                                         convertPatternRegion(
                                                           patternElement,
                                                           paintedElement,
                                                           paintedNode,
                                                           ctx);
                                                       java.lang.String s;
                                                       java.awt.geom.AffineTransform patternTransform;
                                                       s =
                                                         org.apache.batik.bridge.SVGUtilities.
                                                           getChainableAttributeNS(
                                                             patternElement,
                                                             null,
                                                             SVG_PATTERN_TRANSFORM_ATTRIBUTE,
                                                             ctx);
                                                       if (s.
                                                             length(
                                                               ) !=
                                                             0) {
                                                           patternTransform =
                                                             org.apache.batik.bridge.SVGUtilities.
                                                               convertTransform(
                                                                 patternElement,
                                                                 SVG_PATTERN_TRANSFORM_ATTRIBUTE,
                                                                 s,
                                                                 ctx);
                                                       }
                                                       else {
                                                           patternTransform =
                                                             new java.awt.geom.AffineTransform(
                                                               );
                                                       }
                                                       boolean overflowIsHidden =
                                                         org.apache.batik.bridge.CSSUtilities.
                                                         convertOverflow(
                                                           patternElement);
                                                       short contentCoordSystem;
                                                       s =
                                                         org.apache.batik.bridge.SVGUtilities.
                                                           getChainableAttributeNS(
                                                             patternElement,
                                                             null,
                                                             SVG_PATTERN_CONTENT_UNITS_ATTRIBUTE,
                                                             ctx);
                                                       if (s.
                                                             length(
                                                               ) ==
                                                             0) {
                                                           contentCoordSystem =
                                                             org.apache.batik.bridge.SVGUtilities.
                                                               USER_SPACE_ON_USE;
                                                       }
                                                       else {
                                                           contentCoordSystem =
                                                             org.apache.batik.bridge.SVGUtilities.
                                                               parseCoordinateSystem(
                                                                 patternElement,
                                                                 SVG_PATTERN_CONTENT_UNITS_ATTRIBUTE,
                                                                 s,
                                                                 ctx);
                                                       }
                                                       java.awt.geom.AffineTransform patternContentTransform =
                                                         new java.awt.geom.AffineTransform(
                                                         );
                                                       patternContentTransform.
                                                         translate(
                                                           patternRegion.
                                                             getX(
                                                               ),
                                                           patternRegion.
                                                             getY(
                                                               ));
                                                       java.lang.String viewBoxStr =
                                                         org.apache.batik.bridge.SVGUtilities.
                                                         getChainableAttributeNS(
                                                           patternElement,
                                                           null,
                                                           SVG_VIEW_BOX_ATTRIBUTE,
                                                           ctx);
                                                       if (viewBoxStr.
                                                             length(
                                                               ) >
                                                             0) {
                                                           java.lang.String aspectRatioStr =
                                                             org.apache.batik.bridge.SVGUtilities.
                                                             getChainableAttributeNS(
                                                               patternElement,
                                                               null,
                                                               SVG_PRESERVE_ASPECT_RATIO_ATTRIBUTE,
                                                               ctx);
                                                           float w =
                                                             (float)
                                                               patternRegion.
                                                               getWidth(
                                                                 );
                                                           float h =
                                                             (float)
                                                               patternRegion.
                                                               getHeight(
                                                                 );
                                                           java.awt.geom.AffineTransform preserveAspectRatioTransform =
                                                             org.apache.batik.bridge.ViewBox.
                                                             getPreserveAspectRatioTransform(
                                                               patternElement,
                                                               viewBoxStr,
                                                               aspectRatioStr,
                                                               w,
                                                               h,
                                                               ctx);
                                                           patternContentTransform.
                                                             concatenate(
                                                               preserveAspectRatioTransform);
                                                       }
                                                       else {
                                                           if (contentCoordSystem ==
                                                                 org.apache.batik.bridge.SVGUtilities.
                                                                   OBJECT_BOUNDING_BOX) {
                                                               java.awt.geom.AffineTransform patternContentUnitsTransform =
                                                                 new java.awt.geom.AffineTransform(
                                                                 );
                                                               java.awt.geom.Rectangle2D objectBoundingBox =
                                                                 paintedNode.
                                                                 getGeometryBounds(
                                                                   );
                                                               patternContentUnitsTransform.
                                                                 translate(
                                                                   objectBoundingBox.
                                                                     getX(
                                                                       ),
                                                                   objectBoundingBox.
                                                                     getY(
                                                                       ));
                                                               patternContentUnitsTransform.
                                                                 scale(
                                                                   objectBoundingBox.
                                                                     getWidth(
                                                                       ),
                                                                   objectBoundingBox.
                                                                     getHeight(
                                                                       ));
                                                               patternContentTransform.
                                                                 concatenate(
                                                                   patternContentUnitsTransform);
                                                           }
                                                       }
                                                       org.apache.batik.gvt.GraphicsNode gn =
                                                         new org.apache.batik.bridge.SVGPatternElementBridge.PatternGraphicsNode(
                                                         patternContentNode);
                                                       gn.
                                                         setTransform(
                                                           patternContentTransform);
                                                       if (opacity !=
                                                             1) {
                                                           org.apache.batik.ext.awt.image.renderable.Filter filter =
                                                             gn.
                                                             getGraphicsNodeRable(
                                                               true);
                                                           filter =
                                                             new org.apache.batik.ext.awt.image.renderable.ComponentTransferRable8Bit(
                                                               filter,
                                                               org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction.
                                                                 getLinearTransfer(
                                                                   opacity,
                                                                   0),
                                                               org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction.
                                                                 getIdentityTransfer(
                                                                   ),
                                                               org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction.
                                                                 getIdentityTransfer(
                                                                   ),
                                                               org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction.
                                                                 getIdentityTransfer(
                                                                   ));
                                                           gn.
                                                             setFilter(
                                                               filter);
                                                       }
                                                       return new org.apache.batik.gvt.PatternPaint(
                                                         gn,
                                                         patternRegion,
                                                         !overflowIsHidden,
                                                         patternTransform);
    }
    protected static org.apache.batik.gvt.RootGraphicsNode extractPatternContent(org.w3c.dom.Element patternElement,
                                                                                 org.apache.batik.bridge.BridgeContext ctx) {
        java.util.List refs =
          new java.util.LinkedList(
          );
        for (;
             ;
             ) {
            org.apache.batik.gvt.RootGraphicsNode content =
              extractLocalPatternContent(
                patternElement,
                ctx);
            if (content !=
                  null) {
                return content;
            }
            java.lang.String uri =
              org.apache.batik.dom.util.XLinkSupport.
              getXLinkHref(
                patternElement);
            if (uri.
                  length(
                    ) ==
                  0) {
                return null;
            }
            org.apache.batik.dom.svg.SVGOMDocument doc =
              (org.apache.batik.dom.svg.SVGOMDocument)
                patternElement.
                getOwnerDocument(
                  );
            org.apache.batik.util.ParsedURL purl =
              new org.apache.batik.util.ParsedURL(
              doc.
                getURL(
                  ),
              uri);
            if (!purl.
                  complete(
                    ))
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  patternElement,
                  ERR_URI_MALFORMED,
                  new java.lang.Object[] { uri });
            if (contains(
                  refs,
                  purl)) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  patternElement,
                  ERR_XLINK_HREF_CIRCULAR_DEPENDENCIES,
                  new java.lang.Object[] { uri });
            }
            refs.
              add(
                purl);
            patternElement =
              ctx.
                getReferencedElement(
                  patternElement,
                  uri);
        }
    }
    protected static org.apache.batik.gvt.RootGraphicsNode extractLocalPatternContent(org.w3c.dom.Element e,
                                                                                      org.apache.batik.bridge.BridgeContext ctx) {
        org.apache.batik.bridge.GVTBuilder builder =
          ctx.
          getGVTBuilder(
            );
        org.apache.batik.gvt.RootGraphicsNode content =
          null;
        for (org.w3c.dom.Node n =
               e.
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
                    ELEMENT_NODE) {
                continue;
            }
            org.apache.batik.gvt.GraphicsNode gn =
              builder.
              build(
                ctx,
                (org.w3c.dom.Element)
                  n);
            if (gn !=
                  null) {
                if (content ==
                      null) {
                    content =
                      new org.apache.batik.gvt.RootGraphicsNode(
                        );
                }
                content.
                  getChildren(
                    ).
                  add(
                    gn);
            }
        }
        return content;
    }
    private static boolean contains(java.util.List urls,
                                    org.apache.batik.util.ParsedURL key) {
        java.util.Iterator iter =
          urls.
          iterator(
            );
        while (iter.
                 hasNext(
                   )) {
            if (key.
                  equals(
                    iter.
                      next(
                        )))
                return true;
        }
        return false;
    }
    public static class PatternGraphicsNode extends org.apache.batik.gvt.AbstractGraphicsNode {
        org.apache.batik.gvt.GraphicsNode
          pcn;
        java.awt.geom.Rectangle2D pBounds;
        java.awt.geom.Rectangle2D gBounds;
        java.awt.geom.Rectangle2D sBounds;
        java.awt.Shape oShape;
        public PatternGraphicsNode(org.apache.batik.gvt.GraphicsNode gn) {
            super(
              );
            this.
              pcn =
              gn;
        }
        public void primitivePaint(java.awt.Graphics2D g2d) {
            pcn.
              paint(
                g2d);
        }
        public java.awt.geom.Rectangle2D getPrimitiveBounds() {
            if (pBounds !=
                  null)
                return pBounds;
            pBounds =
              pcn.
                getTransformedBounds(
                  IDENTITY);
            return pBounds;
        }
        public java.awt.geom.Rectangle2D getGeometryBounds() {
            if (gBounds !=
                  null)
                return gBounds;
            gBounds =
              pcn.
                getTransformedGeometryBounds(
                  IDENTITY);
            return gBounds;
        }
        public java.awt.geom.Rectangle2D getSensitiveBounds() {
            if (sBounds !=
                  null)
                return sBounds;
            sBounds =
              pcn.
                getTransformedSensitiveBounds(
                  IDENTITY);
            return sBounds;
        }
        public java.awt.Shape getOutline() {
            if (oShape !=
                  null)
                return oShape;
            oShape =
              pcn.
                getOutline(
                  );
            java.awt.geom.AffineTransform tr =
              pcn.
              getTransform(
                );
            if (tr !=
                  null)
                oShape =
                  tr.
                    createTransformedShape(
                      oShape);
            return oShape;
        }
        protected void invalidateGeometryCache() {
            pBounds =
              null;
            gBounds =
              null;
            sBounds =
              null;
            oShape =
              null;
            super.
              invalidateGeometryCache(
                );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "fP8F2fKBTkkfAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
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
      ("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" +
       "8isXd96x3zcfJY8277ee7N5huL0CvfW+ymHzsJTP/+YCy5NFeytvvmavpvzx" +
       "a6FbJ0XqCWeYjq94xcLvAtDEPO3WMfYZTEWhTm65XrNA8zqYfBfmlHN/uM/f" +
       "9gEtbysFir1J1C81n2/YQxU718OnyNgApoI/+L8/9If/5enPQZ32kfvSXN5Q" +
       "lWdW5Nd5dvz9L334LQ++8PkfLKIUDFGz9z7zhffmWNm7cZw3nbyhj1l9LGd1" +
       "Wmz6rJIArggshl5we1dTHsXOCsbf9Cj1w55/9HPLH/mbn96ndRft9gKw8YEX" +
       "fuDfDj/4wsGZZPrp2/LZs3P2CXVB9GuOJBwjT95tlWIG/deffP5Xf/z59++p" +
       "evR8atiBbz4//af/+oeHH/38798hE7nXC74CxYIbpW4t6RHHP7Ysm/ONtp3M" +
       "zWHLGC6yFN2lhrTM7GHgTDaTTU+MiBHNiXVnTdnSsDQFRGZnRpWvMigGVF/1" +
       "m73Eros8qan4lFzTgqCEg2C8BB1+PAfylLRCqtZp41OFnlpOj+iIEUNMe5MB" +
       "1iCAOcdXeFVOmzWeXJVjpaJWZL6CrVLJT3G8po4waxKpIigldKm7ppsCI3dR" +
       "f2yEdZVfxiXoW2VQogynSpepUdNfpwua3UST9Yqa+BFbpgNBVSOqB5QxKkyU" +
       "cK01gjhr1y22t8xqtpKthBmznsOsoTKdK6nuC2J5NmOb9JTqLSudBmCYlevT" +
       "IOolupy2hsSyJG4rHU9skoLS2WZrN+ystgJVNYaTzDSmeGozy6wbxhV5V9r6" +
       "6oSbxLw2m7Nbb6rqKMxrk0UJUOUwM4gJ9KCJpEe0a0Vrly4vgoAdTsoBihm7" +
       "ijAA4814FzU2C6kGVlRGKSVOVrjlRElBCXfnUlJFx43QkWmmm3V8SaCrpamV" +
       "MMGMluZLfABcXB+ofhJXmE7PaPrDkGsLZmen952+o5QVXrY7W73Ztprlap/W" +
       "BUIOve106c0Gc6fr+qu101438BibibwyWa5YJUBtHkwWbU6j7SVjq/3E8ryK" +
       "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");
}
