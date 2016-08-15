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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "CxkAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "RoWO0dAQlVy661FviuEdzGvLi0qDxmrtYhnBhmLfwnWFkix52HfqZEnoqOnC" +
       "nC9NAhPmFNEsqC2+yWw2fNypSVVWgstqilYEPtJtQXTrjlXtY3AsE02BgguU" +
       "pdEhzc1VlSBtxSA2TLFc5UgTt4JJrcEn5Uql2xu3KmPFnVmNgqJVZnSMpOMB" +
       "vvT1cp1vh+1BqzfV/aWm0pV1IWmq7rzKKPRGHtsDikS65f6EwUWK8uaL2WI2" +
       "l0upa7WKyaTVomYlQYi4RqdRG6iUNbYXOjwf+U1ZEmCXafCa0W4ZVLlbLldH" +
       "45Gr0Z1yc2TM23CdXytWhyTFKSEWa2Kr79VSR44Sr0s4tNvH0kIakKtVb063" +
       "1DGWksGGooheVx0jKDEg8VK36PThjpcybI/zYnLQnhtjYlZeTIMN0hmuSQtv" +
       "iv4Cn6QyPp0ntqAlzQXiTIKqWXVpJcDtKLbofrfOx4bhLdy5uZFVepwgsFzF" +
       "grXtTGKsEBBqoKz5SAr7Y6w+MmGrLrcdPDbjeJqu2cFoU2DEtdkaEaiKSZUu" +
       "2yq2Zw3YESdcU2g0PHU1MNOqorP95rKHTGTKF8IEwxvltoPiDm6iiDdqVlYV" +
       "VCxyvucEjrfsTKuWjjtRzKZUcUJPl5q8oGhtrq3KtdVoytXdFeINCMsg+QHM" +
       "6SAmQ2JuVBtU3dXceQFBlO6Ed9aRmXQL0SwqhHJMCm5xVGms2KlNJInbxyMY" +
       "UWnTKGvznu3BVVVXnTK1jMeOs2whi0opqjV7mibMulrJrPY90kMkUorHREj2" +
       "XZ2DiZ5PFBEk9hSznBLhYMwRJaWtLNS+pYGQnRd0gmHmxFhsMmGlYGKTbh1V" +
       "3AXFV9pJ2SuQLXlch4WUJOaJktS8ekWrjUWcraGbuN+NiY3tlVqbmDLUYFjc" +
       "VBmsII3JLidQrRlK8ZRgVuZdrGhNhDqhobAXuTyKebi5nsNRMFarmlpdteVN" +
       "ZVAm7MjhilK3QtX7mFwxGiSMDtYYvWq6GBYWu5O2y3cDfLmeCPjMx2p1ZEMh" +
       "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");
}
