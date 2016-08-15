package org.apache.batik.svggen;
public class SVGTexturePaint extends org.apache.batik.svggen.AbstractSVGConverter {
    public SVGTexturePaint(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          generatorContext);
    }
    public org.apache.batik.svggen.SVGDescriptor toSVG(org.apache.batik.ext.awt.g2d.GraphicContext gc) {
        return toSVG(
                 (java.awt.TexturePaint)
                   gc.
                   getPaint(
                     ));
    }
    public org.apache.batik.svggen.SVGPaintDescriptor toSVG(java.awt.TexturePaint texture) {
        org.apache.batik.svggen.SVGPaintDescriptor patternDesc =
          (org.apache.batik.svggen.SVGPaintDescriptor)
            descMap.
            get(
              texture);
        org.w3c.dom.Document domFactory =
          generatorContext.
            domFactory;
        if (patternDesc ==
              null) {
            java.awt.geom.Rectangle2D anchorRect =
              texture.
              getAnchorRect(
                );
            org.w3c.dom.Element patternDef =
              domFactory.
              createElementNS(
                SVG_NAMESPACE_URI,
                SVG_PATTERN_TAG);
            patternDef.
              setAttributeNS(
                null,
                SVG_PATTERN_UNITS_ATTRIBUTE,
                SVG_USER_SPACE_ON_USE_VALUE);
            patternDef.
              setAttributeNS(
                null,
                SVG_X_ATTRIBUTE,
                doubleString(
                  anchorRect.
                    getX(
                      )));
            patternDef.
              setAttributeNS(
                null,
                SVG_Y_ATTRIBUTE,
                doubleString(
                  anchorRect.
                    getY(
                      )));
            patternDef.
              setAttributeNS(
                null,
                SVG_WIDTH_ATTRIBUTE,
                doubleString(
                  anchorRect.
                    getWidth(
                      )));
            patternDef.
              setAttributeNS(
                null,
                SVG_HEIGHT_ATTRIBUTE,
                doubleString(
                  anchorRect.
                    getHeight(
                      )));
            java.awt.image.BufferedImage textureImage =
              texture.
              getImage(
                );
            if (textureImage.
                  getWidth(
                    ) >
                  0 &&
                  textureImage.
                  getHeight(
                    ) >
                  0) {
                if (textureImage.
                      getWidth(
                        ) !=
                      anchorRect.
                      getWidth(
                        ) ||
                      textureImage.
                      getHeight(
                        ) !=
                      anchorRect.
                      getHeight(
                        )) {
                    if (anchorRect.
                          getWidth(
                            ) >
                          0 &&
                          anchorRect.
                          getHeight(
                            ) >
                          0) {
                        double scaleX =
                          anchorRect.
                          getWidth(
                            ) /
                          textureImage.
                          getWidth(
                            );
                        double scaleY =
                          anchorRect.
                          getHeight(
                            ) /
                          textureImage.
                          getHeight(
                            );
                        java.awt.image.BufferedImage newImage =
                          new java.awt.image.BufferedImage(
                          (int)
                            (scaleX *
                               textureImage.
                               getWidth(
                                 )),
                          (int)
                            (scaleY *
                               textureImage.
                               getHeight(
                                 )),
                          java.awt.image.BufferedImage.
                            TYPE_INT_ARGB);
                        java.awt.Graphics2D g =
                          newImage.
                          createGraphics(
                            );
                        g.
                          scale(
                            scaleX,
                            scaleY);
                        g.
                          drawImage(
                            textureImage,
                            0,
                            0,
                            null);
                        g.
                          dispose(
                            );
                        textureImage =
                          newImage;
                    }
                }
            }
            org.w3c.dom.Element patternContent =
              generatorContext.
                genericImageHandler.
              createElement(
                generatorContext);
            generatorContext.
              genericImageHandler.
              handleImage(
                (java.awt.image.RenderedImage)
                  textureImage,
                patternContent,
                0,
                0,
                textureImage.
                  getWidth(
                    ),
                textureImage.
                  getHeight(
                    ),
                generatorContext);
            patternDef.
              appendChild(
                patternContent);
            patternDef.
              setAttributeNS(
                null,
                SVG_ID_ATTRIBUTE,
                generatorContext.
                  idGenerator.
                  generateID(
                    ID_PREFIX_PATTERN));
            java.lang.String patternAttrBuf =
              URL_PREFIX +
            SIGN_POUND +
            patternDef.
              getAttributeNS(
                null,
                SVG_ID_ATTRIBUTE) +
            URL_SUFFIX;
            patternDesc =
              new org.apache.batik.svggen.SVGPaintDescriptor(
                patternAttrBuf,
                SVG_OPAQUE_VALUE,
                patternDef);
            descMap.
              put(
                texture,
                patternDesc);
            defSet.
              add(
                patternDef);
        }
        return patternDesc;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "bZU2MRUAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "AA==");
}
