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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "mikxFQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
