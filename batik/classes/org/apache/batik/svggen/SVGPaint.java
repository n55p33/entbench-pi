package org.apache.batik.svggen;
public class SVGPaint implements org.apache.batik.svggen.SVGConverter {
    private org.apache.batik.svggen.SVGLinearGradient svgLinearGradient;
    private org.apache.batik.svggen.SVGTexturePaint svgTexturePaint;
    private org.apache.batik.svggen.SVGColor svgColor;
    private org.apache.batik.svggen.SVGCustomPaint svgCustomPaint;
    private org.apache.batik.svggen.SVGGeneratorContext generatorContext;
    public SVGPaint(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          );
        this.
          svgLinearGradient =
          new org.apache.batik.svggen.SVGLinearGradient(
            generatorContext);
        this.
          svgTexturePaint =
          new org.apache.batik.svggen.SVGTexturePaint(
            generatorContext);
        this.
          svgCustomPaint =
          new org.apache.batik.svggen.SVGCustomPaint(
            generatorContext);
        this.
          svgColor =
          new org.apache.batik.svggen.SVGColor(
            generatorContext);
        this.
          generatorContext =
          generatorContext;
    }
    public java.util.List getDefinitionSet() { java.util.List paintDefs =
                                                 new java.util.LinkedList(
                                                 svgLinearGradient.
                                                   getDefinitionSet(
                                                     ));
                                               paintDefs.addAll(svgTexturePaint.
                                                                  getDefinitionSet(
                                                                    ));
                                               paintDefs.
                                                 addAll(
                                                   svgCustomPaint.
                                                     getDefinitionSet(
                                                       ));
                                               paintDefs.
                                                 addAll(
                                                   svgColor.
                                                     getDefinitionSet(
                                                       ));
                                               return paintDefs;
    }
    public org.apache.batik.svggen.SVGTexturePaint getTexturePaintConverter() {
        return svgTexturePaint;
    }
    public org.apache.batik.svggen.SVGLinearGradient getGradientPaintConverter() {
        return svgLinearGradient;
    }
    public org.apache.batik.svggen.SVGCustomPaint getCustomPaintConverter() {
        return svgCustomPaint;
    }
    public org.apache.batik.svggen.SVGColor getColorConverter() {
        return svgColor;
    }
    public org.apache.batik.svggen.SVGDescriptor toSVG(org.apache.batik.ext.awt.g2d.GraphicContext gc) {
        return toSVG(
                 gc.
                   getPaint(
                     ));
    }
    public org.apache.batik.svggen.SVGPaintDescriptor toSVG(java.awt.Paint paint) {
        org.apache.batik.svggen.SVGPaintDescriptor paintDesc =
          svgCustomPaint.
          toSVG(
            paint);
        if (paintDesc ==
              null) {
            if (paint instanceof java.awt.Color)
                paintDesc =
                  org.apache.batik.svggen.SVGColor.
                    toSVG(
                      (java.awt.Color)
                        paint,
                      generatorContext);
            else
                if (paint instanceof java.awt.GradientPaint)
                    paintDesc =
                      svgLinearGradient.
                        toSVG(
                          (java.awt.GradientPaint)
                            paint);
                else
                    if (paint instanceof java.awt.TexturePaint)
                        paintDesc =
                          svgTexturePaint.
                            toSVG(
                              (java.awt.TexturePaint)
                                paint);
        }
        return paintDesc;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "b37TH3J4J8fwPP6Kbx3/BZD51vHNIgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "ZasevENJa7ylMyoytfZ6i2l1w9PnAWieROhUrZv0RuFRXVBqwq7SthmpS/fI" +
       "vkmy0rDBz+14WDMXgRCEUYaPanE89+M4sVN426HJFe/QOzufwasObWwRxXE3" +
       "zjDQw9EgGqX9qNd1Q7+hG8wQNWm0GXtofbc18N1k1V4N/GrK22KNmnK2PPTx" +
       "TkCLlY7BxZo1XLU3juqIm45E2Zjr6zTvssaqqrs1ilYpa9rCsoytgXAyqcg9" +
       "aa4ukw6H0d3p1nLXWx1XFByJlFEyYoftCjv2LZriqHmnLQx1uxtogRVu0wB1" +
       "Q3EhDPy2m2MDZenOgkU3CprxeCTGg6jVkSQi7k6yWMQ0V7ZCTO+jFL5hW7sV" +
       "CwcO3GvFm1qUx0a767FKVTVCMdInMNonSd3mAlemsiHeHbsuHoxmAtj2e6OJ" +
       "xyuL5azVSxIvGslcEIS2OWyRFTsfsAOatXi4zZCL2CbFaDZoKUvBJbOgy1XS" +
       "dtrdDFBjZqK2jPOtKrlaoDhJD7Jxgk235pqkY7xSF4aR1iDiNM05TfZ7w6Vv" +
       "xhMe7XIrWduNM0Uz+SRpjTHWq+qyx2PDSnVJWFt4jM1nPllNfYQPph4pNJpq" +
       "KuUWwYzdXMhGzDDtK1hvHsgzK2vg0xzGlDT0Rw7W80JepFwYmXv9jaB31uyy" +
       "OdOzOPNZeUG6Hawqx+kCa2LVKY56rBHVWL7i7/xlo9ozR+GEx1hRqqlhMFtz" +
       "LRRfImEo0CmhTpsBKakUMWznSp1x+S3JLWBhOJ2kvWCNdHbSSG/p6HI2abBo" +
       "0EuUBqar66qKUZbBLNqzRq1PbKcUMpkgVivvyZVQ3eqr+bI971ozxB+lwWbb" +
       "7pudAZPISNeYTfE0HVGcMiD1NcPl8qyb2aNpJaP0Ckusq1WmU2vNenrPZjJx" +
       "PrYS3xIXZIWZjzszGcFS2p/0pW7HYZjVohr3225Uyzs1UWXYHhXTWpyN9bbb" +
       "dtzcWFjjxnrscnQFSMlW58w423rMmp81Ky1c7Ux6qKh6uhUmFTzZCqTWmc9N" +
       "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" +
       "5d8pr2P/PziyTwHCLQAA");
}
