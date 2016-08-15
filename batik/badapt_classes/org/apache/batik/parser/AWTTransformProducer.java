package org.apache.batik.parser;
public class AWTTransformProducer implements org.apache.batik.parser.TransformListHandler {
    protected java.awt.geom.AffineTransform affineTransform;
    public static java.awt.geom.AffineTransform createAffineTransform(java.io.Reader r)
          throws org.apache.batik.parser.ParseException { org.apache.batik.parser.TransformListParser p =
                                                            new org.apache.batik.parser.TransformListParser(
                                                            );
                                                          org.apache.batik.parser.AWTTransformProducer th =
                                                            new org.apache.batik.parser.AWTTransformProducer(
                                                            );
                                                          p.
                                                            setTransformListHandler(
                                                              th);
                                                          p.
                                                            parse(
                                                              r);
                                                          return th.
                                                            getAffineTransform(
                                                              );
    }
    public static java.awt.geom.AffineTransform createAffineTransform(java.lang.String s)
          throws org.apache.batik.parser.ParseException {
        org.apache.batik.parser.TransformListParser p =
          new org.apache.batik.parser.TransformListParser(
          );
        org.apache.batik.parser.AWTTransformProducer th =
          new org.apache.batik.parser.AWTTransformProducer(
          );
        p.
          setTransformListHandler(
            th);
        p.
          parse(
            s);
        return th.
          getAffineTransform(
            );
    }
    public java.awt.geom.AffineTransform getAffineTransform() {
        return affineTransform;
    }
    public void startTransformList() throws org.apache.batik.parser.ParseException {
        affineTransform =
          new java.awt.geom.AffineTransform(
            );
    }
    public void matrix(float a, float b, float c,
                       float d,
                       float e,
                       float f) throws org.apache.batik.parser.ParseException {
        affineTransform.
          concatenate(
            new java.awt.geom.AffineTransform(
              a,
              b,
              c,
              d,
              e,
              f));
    }
    public void rotate(float theta) throws org.apache.batik.parser.ParseException {
        affineTransform.
          concatenate(
            java.awt.geom.AffineTransform.
              getRotateInstance(
                java.lang.Math.
                  toRadians(
                    theta)));
    }
    public void rotate(float theta, float cx,
                       float cy) throws org.apache.batik.parser.ParseException {
        java.awt.geom.AffineTransform at =
          java.awt.geom.AffineTransform.
          getRotateInstance(
            java.lang.Math.
              toRadians(
                theta),
            cx,
            cy);
        affineTransform.
          concatenate(
            at);
    }
    public void translate(float tx) throws org.apache.batik.parser.ParseException {
        java.awt.geom.AffineTransform at =
          java.awt.geom.AffineTransform.
          getTranslateInstance(
            tx,
            0);
        affineTransform.
          concatenate(
            at);
    }
    public void translate(float tx, float ty)
          throws org.apache.batik.parser.ParseException {
        java.awt.geom.AffineTransform at =
          java.awt.geom.AffineTransform.
          getTranslateInstance(
            tx,
            ty);
        affineTransform.
          concatenate(
            at);
    }
    public void scale(float sx) throws org.apache.batik.parser.ParseException {
        affineTransform.
          concatenate(
            java.awt.geom.AffineTransform.
              getScaleInstance(
                sx,
                sx));
    }
    public void scale(float sx, float sy)
          throws org.apache.batik.parser.ParseException {
        affineTransform.
          concatenate(
            java.awt.geom.AffineTransform.
              getScaleInstance(
                sx,
                sy));
    }
    public void skewX(float skx) throws org.apache.batik.parser.ParseException {
        affineTransform.
          concatenate(
            java.awt.geom.AffineTransform.
              getShearInstance(
                java.lang.Math.
                  tan(
                    java.lang.Math.
                      toRadians(
                        skx)),
                0));
    }
    public void skewY(float sky) throws org.apache.batik.parser.ParseException {
        affineTransform.
          concatenate(
            java.awt.geom.AffineTransform.
              getShearInstance(
                0,
                java.lang.Math.
                  tan(
                    java.lang.Math.
                      toRadians(
                        sky))));
    }
    public void endTransformList() throws org.apache.batik.parser.ParseException {
        
    }
    public AWTTransformProducer() { super(
                                      ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "b/GY4PCIeMW30f8BaBJZL/glAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
