package org.apache.batik.bridge;
public class SVGFeImageElementBridge extends org.apache.batik.bridge.AbstractSVGFilterPrimitiveElementBridge {
    public SVGFeImageElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_FE_IMAGE_TAG; }
    public org.apache.batik.ext.awt.image.renderable.Filter createFilter(org.apache.batik.bridge.BridgeContext ctx,
                                                                         org.w3c.dom.Element filterElement,
                                                                         org.w3c.dom.Element filteredElement,
                                                                         org.apache.batik.gvt.GraphicsNode filteredNode,
                                                                         org.apache.batik.ext.awt.image.renderable.Filter inputFilter,
                                                                         java.awt.geom.Rectangle2D filterRegion,
                                                                         java.util.Map filterMap) {
        java.lang.String uriStr =
          org.apache.batik.dom.util.XLinkSupport.
          getXLinkHref(
            filterElement);
        if (uriStr.
              length(
                ) ==
              0) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              filterElement,
              ERR_ATTRIBUTE_MISSING,
              new java.lang.Object[] { "xlink:href" });
        }
        org.w3c.dom.Document document =
          filterElement.
          getOwnerDocument(
            );
        boolean isUse =
          uriStr.
          indexOf(
            '#') !=
          -1;
        org.w3c.dom.Element contentElement =
          null;
        if (isUse) {
            contentElement =
              document.
                createElementNS(
                  SVG_NAMESPACE_URI,
                  SVG_USE_TAG);
        }
        else {
            contentElement =
              document.
                createElementNS(
                  SVG_NAMESPACE_URI,
                  SVG_IMAGE_TAG);
        }
        contentElement.
          setAttributeNS(
            XLINK_NAMESPACE_URI,
            XLINK_HREF_QNAME,
            uriStr);
        org.w3c.dom.Element proxyElement =
          document.
          createElementNS(
            SVG_NAMESPACE_URI,
            SVG_G_TAG);
        proxyElement.
          appendChild(
            contentElement);
        java.awt.geom.Rectangle2D defaultRegion =
          filterRegion;
        org.w3c.dom.Element filterDefElement =
          (org.w3c.dom.Element)
            filterElement.
            getParentNode(
              );
        java.awt.geom.Rectangle2D primitiveRegion =
          org.apache.batik.bridge.SVGUtilities.
          getBaseFilterPrimitiveRegion(
            filterElement,
            filteredElement,
            filteredNode,
            defaultRegion,
            ctx);
        contentElement.
          setAttributeNS(
            null,
            SVG_X_ATTRIBUTE,
            java.lang.String.
              valueOf(
                primitiveRegion.
                  getX(
                    )));
        contentElement.
          setAttributeNS(
            null,
            SVG_Y_ATTRIBUTE,
            java.lang.String.
              valueOf(
                primitiveRegion.
                  getY(
                    )));
        contentElement.
          setAttributeNS(
            null,
            SVG_WIDTH_ATTRIBUTE,
            java.lang.String.
              valueOf(
                primitiveRegion.
                  getWidth(
                    )));
        contentElement.
          setAttributeNS(
            null,
            SVG_HEIGHT_ATTRIBUTE,
            java.lang.String.
              valueOf(
                primitiveRegion.
                  getHeight(
                    )));
        org.apache.batik.gvt.GraphicsNode node =
          ctx.
          getGVTBuilder(
            ).
          build(
            ctx,
            proxyElement);
        org.apache.batik.ext.awt.image.renderable.Filter filter =
          node.
          getGraphicsNodeRable(
            true);
        short coordSystemType;
        java.lang.String s =
          org.apache.batik.bridge.SVGUtilities.
          getChainableAttributeNS(
            filterDefElement,
            null,
            SVG_PRIMITIVE_UNITS_ATTRIBUTE,
            ctx);
        if (s.
              length(
                ) ==
              0) {
            coordSystemType =
              org.apache.batik.bridge.SVGUtilities.
                USER_SPACE_ON_USE;
        }
        else {
            coordSystemType =
              org.apache.batik.bridge.SVGUtilities.
                parseCoordinateSystem(
                  filterDefElement,
                  SVG_PRIMITIVE_UNITS_ATTRIBUTE,
                  s,
                  ctx);
        }
        java.awt.geom.AffineTransform at =
          new java.awt.geom.AffineTransform(
          );
        if (coordSystemType ==
              org.apache.batik.bridge.SVGUtilities.
                OBJECT_BOUNDING_BOX) {
            at =
              org.apache.batik.bridge.SVGUtilities.
                toObjectBBox(
                  at,
                  filteredNode);
        }
        filter =
          new org.apache.batik.ext.awt.image.renderable.AffineRable8Bit(
            filter,
            at);
        handleColorInterpolationFilters(
          filter,
          filterElement);
        java.awt.geom.Rectangle2D primitiveRegionUserSpace =
          org.apache.batik.bridge.SVGUtilities.
          convertFilterPrimitiveRegion(
            filterElement,
            filteredElement,
            filteredNode,
            defaultRegion,
            filterRegion,
            ctx);
        filter =
          new org.apache.batik.ext.awt.image.renderable.PadRable8Bit(
            filter,
            primitiveRegionUserSpace,
            org.apache.batik.ext.awt.image.PadMode.
              ZERO_PAD);
        updateFilterMap(
          filterElement,
          filter,
          filterMap);
        return filter;
    }
    protected static org.apache.batik.ext.awt.image.renderable.Filter createSVGFeImage(org.apache.batik.bridge.BridgeContext ctx,
                                                                                       java.awt.geom.Rectangle2D primitiveRegion,
                                                                                       org.w3c.dom.Element refElement,
                                                                                       boolean toBBoxNeeded,
                                                                                       org.w3c.dom.Element filterElement,
                                                                                       org.apache.batik.gvt.GraphicsNode filteredNode) {
        org.apache.batik.gvt.GraphicsNode node =
          ctx.
          getGVTBuilder(
            ).
          build(
            ctx,
            refElement);
        org.apache.batik.ext.awt.image.renderable.Filter filter =
          node.
          getGraphicsNodeRable(
            true);
        java.awt.geom.AffineTransform at =
          new java.awt.geom.AffineTransform(
          );
        if (toBBoxNeeded) {
            short coordSystemType;
            org.w3c.dom.Element filterDefElement =
              (org.w3c.dom.Element)
                filterElement.
                getParentNode(
                  );
            java.lang.String s =
              org.apache.batik.bridge.SVGUtilities.
              getChainableAttributeNS(
                filterDefElement,
                null,
                SVG_PRIMITIVE_UNITS_ATTRIBUTE,
                ctx);
            if (s.
                  length(
                    ) ==
                  0) {
                coordSystemType =
                  org.apache.batik.bridge.SVGUtilities.
                    USER_SPACE_ON_USE;
            }
            else {
                coordSystemType =
                  org.apache.batik.bridge.SVGUtilities.
                    parseCoordinateSystem(
                      filterDefElement,
                      SVG_PRIMITIVE_UNITS_ATTRIBUTE,
                      s,
                      ctx);
            }
            if (coordSystemType ==
                  org.apache.batik.bridge.SVGUtilities.
                    OBJECT_BOUNDING_BOX) {
                at =
                  org.apache.batik.bridge.SVGUtilities.
                    toObjectBBox(
                      at,
                      filteredNode);
            }
            java.awt.geom.Rectangle2D bounds =
              filteredNode.
              getGeometryBounds(
                );
            at.
              preConcatenate(
                java.awt.geom.AffineTransform.
                  getTranslateInstance(
                    primitiveRegion.
                      getX(
                        ) -
                      bounds.
                      getX(
                        ),
                    primitiveRegion.
                      getY(
                        ) -
                      bounds.
                      getY(
                        )));
        }
        else {
            at.
              translate(
                primitiveRegion.
                  getX(
                    ),
                primitiveRegion.
                  getY(
                    ));
        }
        return new org.apache.batik.ext.awt.image.renderable.AffineRable8Bit(
          filter,
          at);
    }
    protected static org.apache.batik.ext.awt.image.renderable.Filter createRasterFeImage(org.apache.batik.bridge.BridgeContext ctx,
                                                                                          java.awt.geom.Rectangle2D primitiveRegion,
                                                                                          org.apache.batik.util.ParsedURL purl) {
        org.apache.batik.ext.awt.image.renderable.Filter filter =
          org.apache.batik.ext.awt.image.spi.ImageTagRegistry.
          getRegistry(
            ).
          readURL(
            purl);
        java.awt.geom.Rectangle2D bounds =
          filter.
          getBounds2D(
            );
        java.awt.geom.AffineTransform scale =
          new java.awt.geom.AffineTransform(
          );
        scale.
          translate(
            primitiveRegion.
              getX(
                ),
            primitiveRegion.
              getY(
                ));
        scale.
          scale(
            primitiveRegion.
              getWidth(
                ) /
              (bounds.
                 getWidth(
                   ) -
                 1),
            primitiveRegion.
              getHeight(
                ) /
              (bounds.
                 getHeight(
                   ) -
                 1));
        scale.
          translate(
            -bounds.
              getX(
                ),
            -bounds.
              getY(
                ));
        return new org.apache.batik.ext.awt.image.renderable.AffineRable8Bit(
          filter,
          scale);
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
      ("H4sIAAAAAAAAAL1aeewjV32f3U12k82xmwSSkObOhjYZ+ht7xuOD0JLxOWPP" +
       "jMdje3y0sMxpj+f03B6aAhGFqEiAaIBUJfmjAkFRIKgqpYeogloKCFSJCvWS" +
       "CqitVChFIn9Aq6YtfTP+3XvQiKqW/Dx+7/u+73u9z/v6ff3896FrfQ+CXcfc" +
       "LEwn2FGTYGdl4jvBxlX9nS6Nc6Lnq0rDFH1/BPouyg9+5tyPXn7/8vxJ6PQc" +
       "uk20bScQA92xfV71HTNSFRo6d9DbMlXLD6Dz9EqMRCQMdBOhdT94jIZuODQ1" +
       "gC7QeyIgQAQEiIDkIiDEARWYdJNqh1YjmyHagb+GfhU6QUOnXTkTL4AeOMrE" +
       "FT3R2mXD5RoADtdl3wWgVD458aD793Xf6nyJwh+Ekac//Obzv3sKOjeHzun2" +
       "MBNHBkIEYJE5dKOlWpLq+YSiqMocusVWVWWoerpo6mku9xy61dcXthiEnrpv" +
       "pKwzdFUvX/PAcjfKmW5eKAeOt6+epqumsvftWs0UF0DX2w903WrYzvqBgmd1" +
       "IJinibK6N+UaQ7eVALrv+Ix9HS/0AAGYesZSg6Wzv9Q1tgg6oFu3vjNFe4EM" +
       "A0+3F4D0WicEqwTQXVdkmtnaFWVDXKgXA+jO43TcdghQXZ8bIpsSQK8+TpZz" +
       "Al6665iXDvnn++wb3vtWm7RP5jIrqmxm8l8HJt17bBKvaqqn2rK6nXjjo/SH" +
       "xNs//9RJCALErz5GvKX53K+89Pjr7n3xy1uan7kMTV9aqXJwUf6odPPX7248" +
       "UjuViXGd6/h65vwjmufhz+2OPJa4YOfdvs8xG9zZG3yR//PZ2z+pfu8kdJaC" +
       "TsuOGVogjm6RHcvVTdXrqLbqiYGqUND1qq008nEKOgOead1Wt719TfPVgIKu" +
       "MfOu007+HZhIAywyE50Bz7qtOXvPrhgs8+fEhSDoDHhDN4L3o9D2lX8GkIQs" +
       "HUtFRFm0ddtBOM/J9PcR1Q4kYNslIoGoNxDfCT0QgojjLRARxMFS3R2QPF1Z" +
       "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");
}
