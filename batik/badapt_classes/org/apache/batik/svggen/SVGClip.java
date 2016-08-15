package org.apache.batik.svggen;
public class SVGClip extends org.apache.batik.svggen.AbstractSVGConverter {
    public static final java.awt.Shape ORIGIN = new java.awt.geom.Line2D.Float(
      0,
      0,
      0,
      0);
    public static final org.apache.batik.svggen.SVGClipDescriptor NO_CLIP =
      new org.apache.batik.svggen.SVGClipDescriptor(
      SVG_NONE_VALUE,
      null);
    private org.apache.batik.svggen.SVGShape shapeConverter;
    public SVGClip(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          generatorContext);
        this.
          shapeConverter =
          new org.apache.batik.svggen.SVGShape(
            generatorContext);
    }
    public org.apache.batik.svggen.SVGDescriptor toSVG(org.apache.batik.ext.awt.g2d.GraphicContext gc) {
        java.awt.Shape clip =
          gc.
          getClip(
            );
        org.apache.batik.svggen.SVGClipDescriptor clipDesc =
          null;
        if (clip !=
              null) {
            java.lang.StringBuffer clipPathAttrBuf =
              new java.lang.StringBuffer(
              URL_PREFIX);
            java.awt.geom.GeneralPath clipPath =
              new java.awt.geom.GeneralPath(
              clip);
            org.apache.batik.svggen.ClipKey clipKey =
              new org.apache.batik.svggen.ClipKey(
              clipPath,
              generatorContext);
            clipDesc =
              (org.apache.batik.svggen.SVGClipDescriptor)
                descMap.
                get(
                  clipKey);
            if (clipDesc ==
                  null) {
                org.w3c.dom.Element clipDef =
                  clipToSVG(
                    clip);
                if (clipDef ==
                      null)
                    clipDesc =
                      NO_CLIP;
                else {
                    clipPathAttrBuf.
                      append(
                        SIGN_POUND);
                    clipPathAttrBuf.
                      append(
                        clipDef.
                          getAttributeNS(
                            null,
                            SVG_ID_ATTRIBUTE));
                    clipPathAttrBuf.
                      append(
                        URL_SUFFIX);
                    clipDesc =
                      new org.apache.batik.svggen.SVGClipDescriptor(
                        clipPathAttrBuf.
                          toString(
                            ),
                        clipDef);
                    descMap.
                      put(
                        clipKey,
                        clipDesc);
                    defSet.
                      add(
                        clipDef);
                }
            }
        }
        else
            clipDesc =
              NO_CLIP;
        return clipDesc;
    }
    private org.w3c.dom.Element clipToSVG(java.awt.Shape clip) {
        org.w3c.dom.Element clipDef =
          generatorContext.
            domFactory.
          createElementNS(
            SVG_NAMESPACE_URI,
            SVG_CLIP_PATH_TAG);
        clipDef.
          setAttributeNS(
            null,
            SVG_CLIP_PATH_UNITS_ATTRIBUTE,
            SVG_USER_SPACE_ON_USE_VALUE);
        clipDef.
          setAttributeNS(
            null,
            SVG_ID_ATTRIBUTE,
            generatorContext.
              idGenerator.
              generateID(
                ID_PREFIX_CLIP_PATH));
        org.w3c.dom.Element clipPath =
          shapeConverter.
          toSVG(
            clip);
        if (clipPath !=
              null) {
            clipDef.
              appendChild(
                clipPath);
            return clipDef;
        }
        else {
            clipDef.
              appendChild(
                shapeConverter.
                  toSVG(
                    ORIGIN));
            return clipDef;
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "CxkAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
class ClipKey {
    int hashCodeValue = 0;
    public ClipKey(java.awt.geom.GeneralPath proxiedPath,
                   org.apache.batik.svggen.SVGGeneratorContext gc) {
        super(
          );
        java.lang.String pathData =
          org.apache.batik.svggen.SVGPath.
          toSVGPathData(
            proxiedPath,
            gc);
        hashCodeValue =
          pathData.
            hashCode(
              );
    }
    public int hashCode() { return hashCodeValue; }
    public boolean equals(java.lang.Object clipKey) { return clipKey instanceof org.apache.batik.svggen.ClipKey &&
                                                        hashCodeValue ==
                                                        ((org.apache.batik.svggen.ClipKey)
                                                           clipKey).
                                                          hashCodeValue;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
