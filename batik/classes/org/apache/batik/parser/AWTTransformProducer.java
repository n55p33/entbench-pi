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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "3uIxweFh8YpvI/8Dlsv04PglAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
