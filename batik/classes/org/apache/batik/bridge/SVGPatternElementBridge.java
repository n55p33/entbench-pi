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
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "X+Bv/OZJHwAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
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
      ("H4sIAAAAAAAAAL06aczsVnV+X5L3Xl5C3ksCJASyv1Bg6OfxLB4PgZJZPZu3" +
       "8TIetxC8jj3jbbyMPUPDVgqoSClqAwUV0j9BLTQsrUoXtVRBVQsUhERFV6mA" +
       "2kqFUiTyA1qVtvTa8+3vfS+NqDqSrz33nnvu2e/xPX76u9ANYQAVfM9ez2wv" +
       "2tXTaHduV3ejta+Hu4NRlZaDUNdathyGHOh7VH3g0xd/8MP3mZd2oLMSdLvs" +
       "ul4kR5bnhmM99OyVro2gi4e9HVt3wgi6NJrLKxmOI8uGR1YYPTyCbjoyNYIu" +
       "j/ZJgAEJMCABzkmAG4dQYNILdDd2WtkM2Y3CJfQW6MwIOuurGXkRdP9xJL4c" +
       "yM4eGjrnAGA4n/0XAFP55DSA7jvgfcvzFQy/vwA/8StvvPTb10EXJeii5bIZ" +
       "OSogIgKLSNDNju4oehA2NE3XJOhWV9c1Vg8s2bY2Od0SdFtozVw5igP9QEhZ" +
       "Z+zrQb7moeRuVjPegliNvOCAPcPSbW3/3w2GLc8Ary8+5HXLYTfrBwxesABh" +
       "gSGr+v6U6xeWq0XQvSdnHPB4eQgAwNRzjh6Z3sFS17sy6IBu2+rOlt0ZzEaB" +
       "5c4A6A1eDFaJoLtORZrJ2pfVhTzTH42gO0/C0dshAHVjLohsSgS96CRYjglo" +
       "6a4TWjqin++Sr338zW7P3clp1nTVzug/Dybdc2LSWDf0QHdVfTvx5leNPiC/" +
       "+LPv2YEgAPyiE8BbmN/72WcfefU9z3xhC/PSq8BQylxXo0fVp5Rbvvqy1ivr" +
       "12VknPe90MqUf4zz3PzpvZGHUx943osPMGaDu/uDz4z/bPq2j+vf2YEu9KGz" +
       "qmfHDrCjW1XP8S1bD3Dd1QM50rU+dKPuaq18vA+dA88jy9W3vZRhhHrUh663" +
       "866zXv4fiMgAKDIRnQPPlmt4+8++HJn5c+pDEHQOXNAuuErQ9odkTQQpsOk5" +
       "Oiyrsmu5HkwHXsZ/COtupADZmrACrH4Bh14cABOEvWAGy8AOTH1vQAksbabD" +
       "rIDTcgRsKA8RYHIz79/NbM3/f1klzXi9lJw5A9TwspNBwAb+0/NsTQ8eVZ+I" +
       "m51nP/nol3YOnGJPShGULby7XXg3X3h3u/DuKQtDZ87k670wI2CrcqCwBXB9" +
       "EBRvfiX7hsGb3vPAdcDW/OR6IO0MFD49NrcOg0U/D4kqsFjomQ8mbxfeWtyB" +
       "do4H2Yxo0HUhm05nofEgBF4+6VxXw3vx3d/6wac+8Jh36GbHovae9185M/Pe" +
       "B06KN/BUXQPx8BD9q+6TP/PoZx+7vANdD0ICCIORDMwWRJh7Tq5xzIsf3o+I" +
       "GS83AIYNL3BkOxvaD2MXIjPwksOeXO+35M+3AhnflJn1A+Cq7dl5fs9Gb/ez" +
       "9oVbO8mUdoKLPOK+jvU/8jdf+XY5F/d+cL54ZLtj9ejhIwEhQ3Yxd/1bD22A" +
       "C3QdwP39B+lffv933/3TuQEAiAevtuDlrG2BQABUCMT8819Y/u03vv7U13YO" +
       "jSYCO2Ks2JaaHjCZ9UMXrsEkWO3lh/SAgGIDd8us5jLvOp5mGZas2Hpmpf95" +
       "8SHkM//6+KWtHdigZ9+MXv3cCA77X9KE3valN/7bPTmaM2q2oR3K7BBsGyVv" +
       "P8TcCAJ5ndGRvv0v7v7Q5+WPgHgLYlxobfQ8bEG5DKBcaXDO/6vydvfEGJI1" +
       "94ZHjf+4fx1JPB5V3/e1771A+N4fP5tTezxzOaprQvYf3ppX1tyXAvR3nPT0" +
       "nhyaAK7yDPkzl+xnfggwSgCjCqJYSAUg3qTHLGMP+oZzf/e5P3nxm756HbTT" +
       "hS7Ynqx15dzJoBuBdeuhCUJV6r/+ka1yk/OguZSzCl3B/NYo7sz/XQcIfOXp" +
       "8aWbJR6HLnrnf1C28o5/+PcrhJBHlqvstyfmS/DTH76r9VPfyecfung2+570" +
       "yhgMkrTDuaWPO9/feeDsn+5A5yTokrqXAQqyHWeOI4GsJ9xPC0GWeGz8eAaz" +
       "3a4fPghhLzsZXo4sezK4HMZ+8JxBZ88XjsaTH4HfGXD9d3Zl4s46tvvmba29" +
       "zfu+g93b99MzwFtvKO3WdovZ/NfnWO7P28tZ8xNbNWWPrwBuHeapJ5hhWK5s" +
       "5ws/EgETs9XL+9gFkIoCnVye27UczYtA8p2bU8b97jZ/2wa0rC3lKLYmUT3V" +
       "fF6zhcp3rlsOkY08kAq+95/e9+VffPAbQKcD6IZVJm+gyiMrknGWHb/r6fff" +
       "fdMT33xvHqVAiBLe+cO7Hsmwjq7FcdZ0sqa7z+pdGatsvumP5DAi8sCiazm3" +
       "1zRlOrAcEH9Xe6kf/Nht31h8+Fuf2KZ1J+32BLD+nid+4Ue7jz+xcySZfvCK" +
       "fPbonG1CnRP9gj0JB9D911oln9H950899oe/8di7t1Tddjw17IA3n0/81X99" +
       "efeD3/ziVTKR623vx1BsdLHYq4T9xv5vhEh6KVHTsWNQmE5NN1GhaiDrTqgN" +
       "7IZWNjt6k7IbamXNUN2CtjRRE2mENbUcbbTUjWtOvVgtlAZ9nZ95KBvbnVZr" +
       "NrAndrHPTFr4cjRZ+E2Gn2FphxjOGY/HpGZjaDKMJbT9Xo21yxt9o9fich1t" +
       "M74vlTQHdpwS7BQKSs2I4PJ8DFcskpO7sT2jPDihWXnTLxfROUKPpNDW51pQ" +
       "EuKZwuto7El1tV6vNaRJlyWLa5moc3rQbSnAUyQ7YHtrZiBEG1foTqY0MVA6" +
       "uIiPSmoie0iC1PHOmqmJtRCVnaEVGEqLkTrOei546yKvViJS6s0Dsm4mhNPC" +
       "qWQxdKdsjVlQGqb1F6XhVN9s1iWuthYjrM87cj2apNTEoWpo0yKrgbUcT6jl" +
       "RllturZt49FSj3AlaRGrzbpVi6YLteuU+qKNWjOsgE+4TaE20oil0G6RaBA0" +
       "TXFe6o8IUpkm9hTlumihzE1IReeUahtQuyjyBsEKBiFyzNAqSiYvaPI88Ut0" +
       "VfTjyXrVVzlztFRRHuuQqjKsOH17MJJ8pERwXdfrtmlRW3SrZLO04LuyPOEH" +
       "7EiPWR/FqFowcesCgyxxdhov24VuqUvOOmZxgjNyJ3RKrUlZIokwZhJZo82w" +
       "r099YUC6YpOKI2RS3AQ2xZkFYV2eOhwlDTSlqDVEtzUaSNSUV4QFjtnthldF" +
       "tIhdkv6iN3EGaMyr7XJpVmmQQ2dDsDaeUCVj6He7Alcerom2Ne/jtIjwjQa/" +
       "1lxcxaamzDvomEHZUVjsTMtLVJ8xAJHejAZyI9kwFWccj2XZk6vE0ttw5Dhq" +
       "WI3yOKWYMc9XGEtteC5RGSxmJqUWo01jaLhUFaWaEaPHyMZYTsfDFs3qkhf3" +
       "Cnipy45LbbbfCVOr0jHWfZsclshyUXLoWoJxjZDZNEKWrQZq2R0ha001BtJa" +
       "JFftfnGSDmsOMejZQ2pQtemNjmiq4NHKsq2SE0xsj6oDVe+6Ktg1KKfSSIgk" +
       "VFWubbX9imrQgULCpZYxbjhto7Tg5nhRbCrhslMEri8viUnYLlbtLsWvSou1" +
       "TXCwPMTEyhpXqvNlWF3UqhK/dmTMLW7YcRe8Topo27JHjYYt8g2ysHTnI1Wp" +
       "0us5PQdrs8zaaDGtdiJ2aKfcNCOqE+HEYiKMl3ZTQ6aIV24PGGMeDq0B0ShP" +
       "ZKultNGibEbVVpIksmn6MsHXWu2228c7Pqtwo/ayqPCEOutXpYY5nmHzYNwr" +
       "dhUCxlbLwniMOO7cGzfUBE5mLXw+o9OQHKlO2NGFmWKXjdJUw11fxc1FzZT7" +
       "C05sz6xuBe2bLLmu8FbX5BfegJSVuRkz46TSI2fLuF2fKxE+8kqLYq1eNiaz" +
       "YUmqVMlGqTiXJ2O2rc8RTO106+O2O6ZdwcKkKACRlWO5HsuZE91Ll7jdrATt" +
       "Scuet4NCecA2UIrpWvyk0O/3xhuuz9szlliaTNhr1ZDUtDbhoMChXIVSZmZb" +
       "qiCTttW068U61TOXMHgPIqsVbRC3Z3FlMEQa+KJCT6ueuGiDzbqh2xSthHGh" +
       "zhVhNdIMEGQ6XnE0T8MJ46yjhhT1rZm+kHl7uvL6a4quFYqs7GOtNVH09eay" +
       "MV1oyZwdzVBRavbwid+sdDnTn9j4DK1STm2Gq+G0Xl52loo8qBXsWdcre5ZU" +
       "TkRqWPHd+RztJFwJcdmI7FENewhY7FUXPbeCSIa+QlpeqVJ0R0q1M+3PU8Us" +
       "4H2FLM0EKXIjO47Gs3Y8V6lUL1QwlKyXKiLZCCesOouA6sJRqSH0wH5QqGuu" +
       "FtTKSDXqcVMVpiiGS8XGYO2JaZOlErctTDomOZnoRthsk0yjrzWX8bI2Tria" +
       "YHc8Dl/QvcLCGBXnE9roWTNBWzab81KMy+XCdCbpcDVFqkPFDeCoZpYaHD9v" +
       "4PomAHGWTTiYqNSR2aQ8pWtrEsYwb1Bzl3ivzzONEbkCiMg+W2Eoq20VrYqI" +
       "VSurkhe2pwMNvOkZZVwspMbKTv3xyI3qA8cvYRVMFZQwms8lzIcRCXSxMN2S" +
       "7IVeIrDhLCJxsHE3assh19iAhE6ijIaqmZXhrIGRvjLqt/vGoGtTJIssYBir" +
       "domNVkWXfb2H+J3ORu71612+ivteEyE2YRsdeOVVGbdpcpPqjimbsrUY0xbb" +
       "trkkWQ16SFVFYqFdSqm6A0+UKGTJVcsKN4NpvWp4yigUbCFsG6lQMHDKMKJo" +
       "o9MMYmKbgrRgWRGbJwRPDearooUGYzJyJ1NJYPEgbTZB7HClju8qRdsjewt7" +
       "BbYVcrNYKVZ72Kc7MdODYY7uroe9sovGHNGSk1l5Q/dLJKEW3bY/RVuVoLXB" +
       "5XGr5zP1orKp6RhW8gW9XuKtNi0hRqdDJBo2YqaWYLMkrrZWdJkeibEQr9bU" +
       "BuuEXWvKtzRGUspKuTaLmfLIzqJqHAsqCAiTNaojFCKOWumS4OcrbcxwOjod" +
       "zhGfDYdIiRzylE5O0SiYlGi8JRJq2Gpnu92MT1a2YCtNS+nzqFz0Gxw+C4Tm" +
       "oiEjyFgxJ3UzNQtjXMGmcZNVAm1QjYOCVSkNevO1i0bpeKEQVFow2kVqMyoZ" +
       "ZRcRBp7Md/BoCrcorxMGBXlcFGWjr6KO2zfEisl7C3nCzDkb7TG1SJ2FvF0j" +
       "B3N6NGp6joQLetIk6LllNqqa3LLEsNWr8gHByJiurmO2VehUbQMxMFF3TRXz" +
       "iUWP2cwXGhxTJUFkMRDazV51HU09Ak6Tjl2XeTZAyLKLNfVWFYErHoEmjXqd" +
       "wWgelVTZYvxSs4Evx12Bj5ue17WoamSUVsVBAasPG3wfcTrNaaDAFVotzNOk" +
       "MqS6w+4yGrGx34XTVAo7PojWDhkjkaqM+XQKIwYXp/UaPdeNSa/XRGuOQ1em" +
       "dtMg+si4H6OqOETKcX0YrKLVxoxWslwHuw0sMwUfjWsqmsATJukuCoiauOpQ" +
       "dMWgMaU2Up2pDFBc8LqbsSvXrGCuWYtCa8ErnWmvP+uP0JpAMtHK1wms4vIj" +
       "ERGpmQxTCdcJWxiGtl29ZC0LQ83iS1XMqbSYXj9qJFQiBc2+ZkgVy7MXNG2m" +
       "qdMrSO6ybK4nYp+npz4xtuCCZ5lVeE4UC5wjN5pCyKTVxOI4C/XrXXbSacC9" +
       "OUOIMTdq8uKKRvThymwR6rS2GGowvJRHKQavpvCwycdoT2qHhiQWJzUaLVll" +
       "qW6qCeaqaTmywiYb4MNFTNBceVR2mR69UfFksKY0vr3sDKtCx+5UkXASe1Oq" +
       "u6jWFUGcCpFuqJOqwPQazYJTWVM+2LfKo0lJK4mGNPArlCBNzLqNFHu91aqO" +
       "0e21sOBZOwntGR/HFcxY2pq+4WpwMPWr48XQkBZTQ61tLEXvUetKrYDpXhcE" +
       "t1mvRopcUUaWtjXRWMrWa1LKwctBYcj7Ns2LsGpzQcGYsy6CxZqiV5h5e4M2" +
       "4Xo1it32oqDqnTY+mK5jd7heap26ps8dKkpAelpfd/S+gUYJYtCwW6Dqcayp" +
       "BQ+XIgPE4bQsuz2JKqOTdtOqqJjSmhMTO26Jq26Rx2upQ7SkiS5bw/6mMNhw" +
       "XQr1EaUtRAzKo2EqGVEhrfTc4mJqhrInOoKRRAUaXsMYrcKDoOGJSncmbSy0" +
       "WpT0cpHw22MkWEppqVo1hXE6HseWH840PrBJoigmcDldEWhx0vGEieOwptL3" +
       "RQtuDix/MU/bUseu+XV0uKATwdekho7N4LQeUVp1yTW9BKR6IUljM88l+VbL" +
       "RQtyzbcNvuUINaYLe+P1ilgwqL9ezqilExogox+asktS1IhbLpJUhOez9TSG" +
       "Y8Ni7H5cc+esxVJKc1mBC+D9pdovcV6ED1o6x7ZIh13RydIG72HD8mCja0Ik" +
       "0l0Jw0jODgKqaE3LtU4PpQeYVq80Bo4z49SEFglREiuC4kQyGbhlMzXq5RHI" +
       "aBR2aracANbqKUbrStlwOW0zAznLFBWkvsQiFR/1dGxS19Hq1DWCiib2TAZn" +
       "JpSCreGpuS5EFmLU0no9wikCd8NBbcK4tRFG4DZTk1cltE8SuELha4ETauGq" +
       "3fXwERtMQJpKSBtJsxRWKVaW5kZedsTaOqyibEp6xWilj8PitJpKaGWtugum" +
       "tBgxJZDbdeEkXYvDvilVl82WgNJBna2IzrDTboVIv9Yj/die4IrY46geQVaZ" +
       "XhtP4M4Anhq0uZoi4wifYhp4Q35d9ur8hud3enFrflBzUHWb27VsoPc83tq3" +
       "Q/dnzUMHh7v57+x+hWb/fvRw9/DEb2f/UOjB0yoXtGztVyv2YV9+GmwnCLzg" +
       "oBybHXLcfVqdLj/geOodTzypUR9FdvYOYcUIujHy/J+09ZVuH6Eyq0m/6vTD" +
       "HCIvUx4eDn7+Hf9yF/dT5pueR8nj3hN0nkT5MeLpL+IvV39pB7ru4KjwigLq" +
       "8UkPHz8gvBDoURy43LFjwrsPlHZbpqN7wPXaPaW99uplh6sa2JncwLZmdY0z" +
       "7uQaY+usCSLo5pkejTxVtsk90nuHlhg+1/nRUaR5h3fAX26YLwNXf4+//v8N" +
       "fzfsGcieaT50mmluLXivSr8PfXsGnZTVXc1zdvcKc9nQu/YB7r8C3WwV7eKB" +
       "7JuWGpKetvUJ9oifTrLjWNuTo5zcn7uGyB/PmrdE0E1qoMuRnjva/sLbY1U5" +
       "iXYPu3MdvPXH0MFLss5s/Nk9HTz7PHSwA3zTD7xIVyNdy2PZVfWxswXOpZg1" +
       "78yhfvUaYvhI1rw/gl4EFBPIarRXJ81VdSiQKxWbaWLsgW3spDZyOX3gx5VT" +
       "GZjdS7Zzt/f/rZyyxw89XwF97BoC+s2seSqC7toTUO6ex6WUQfzaIfMf/TGY" +
       "f2nW+SBgeq80eOaU+udpRnLOD6wVMOfnlMCxI/DjMX0sJ/lG8aj6B8w3v/qR" +
       "zaee3p5wK3KoR1DhtG+Drvw8KSs2P3SNgvnhVyPfx1/zzLf/UXjD/lZ004FA" +
       "Lmf8v+JaAjnutHu1vW0d9I/2x+69wn63H3jk9PLjUb7o717DCj6XNZ+OoPN7" +
       "hbLwapHnnOJ5ti67h6bwW8/HFNIIuuOULxWysuudV3watf2cR/3kkxfP3/Ek" +
       "/9d5sf7gk5sbR9B5I7bto1WyI89n/UA3rJy3G7c1Mz+/fQkQcUoUj6CzymEm" +
       "8udb+K9E0KWT8CAG5/ejcF+NoAuHcADV9uEoyNci6DoAkj3+pb+vudJpW0rD" +
       "tRw5ysrYeQXPUoHotsJKzxxJXvY8LNfGbc+ljYMpR6v9md3mH6/tJycxvece" +
       "n3pyQL75WfSj268NVFvebDIs50fQue2HDwcJzv2nYtvHdbb3yh/e8ukbH9r3" +
       "gFu2BB96+xHa7r16ab/j+FFejN/8/h2/89pff/LreX3vfwAXaW+jVSgAAA==");
}
