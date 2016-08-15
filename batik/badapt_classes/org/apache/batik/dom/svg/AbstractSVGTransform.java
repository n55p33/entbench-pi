package org.apache.batik.dom.svg;
public abstract class AbstractSVGTransform implements org.w3c.dom.svg.SVGTransform {
    protected short type = SVG_TRANSFORM_UNKNOWN;
    protected java.awt.geom.AffineTransform affineTransform;
    protected float angle;
    protected float x;
    protected float y;
    protected abstract org.w3c.dom.svg.SVGMatrix createMatrix();
    protected void setType(short type) { this.type = type; }
    public float getX() { return x; }
    public float getY() { return y; }
    public void assign(org.apache.batik.dom.svg.AbstractSVGTransform t) {
        this.
          type =
          t.
            type;
        this.
          affineTransform =
          t.
            affineTransform;
        this.
          angle =
          t.
            angle;
        this.
          x =
          t.
            x;
        this.
          y =
          t.
            y;
    }
    public short getType() { return type; }
    public org.w3c.dom.svg.SVGMatrix getMatrix() { return createMatrix();
    }
    public float getAngle() { return angle; }
    public void setMatrix(org.w3c.dom.svg.SVGMatrix matrix) { type = SVG_TRANSFORM_MATRIX;
                                                              affineTransform =
                                                                new java.awt.geom.AffineTransform(
                                                                  matrix.
                                                                    getA(
                                                                      ),
                                                                  matrix.
                                                                    getB(
                                                                      ),
                                                                  matrix.
                                                                    getC(
                                                                      ),
                                                                  matrix.
                                                                    getD(
                                                                      ),
                                                                  matrix.
                                                                    getE(
                                                                      ),
                                                                  matrix.
                                                                    getF(
                                                                      ));
    }
    public void setTranslate(float tx, float ty) { type = SVG_TRANSFORM_TRANSLATE;
                                                   affineTransform =
                                                     java.awt.geom.AffineTransform.
                                                       getTranslateInstance(
                                                         tx,
                                                         ty);
    }
    public void setScale(float sx, float sy) { type = SVG_TRANSFORM_SCALE;
                                               affineTransform =
                                                 java.awt.geom.AffineTransform.
                                                   getScaleInstance(
                                                     sx,
                                                     sy);
    }
    public void setRotate(float angle, float cx, float cy) {
        type =
          SVG_TRANSFORM_ROTATE;
        affineTransform =
          java.awt.geom.AffineTransform.
            getRotateInstance(
              java.lang.Math.
                toRadians(
                  angle),
              cx,
              cy);
        this.
          angle =
          angle;
        this.
          x =
          cx;
        this.
          y =
          cy;
    }
    public void setSkewX(float angle) { type = SVG_TRANSFORM_SKEWX;
                                        affineTransform =
                                          java.awt.geom.AffineTransform.
                                            getShearInstance(
                                              java.lang.Math.
                                                tan(
                                                  java.lang.Math.
                                                    toRadians(
                                                      angle)),
                                              0.0);
                                        this.angle = angle;
    }
    public void setSkewY(float angle) { type = SVG_TRANSFORM_SKEWY;
                                        affineTransform =
                                          java.awt.geom.AffineTransform.
                                            getShearInstance(
                                              0.0,
                                              java.lang.Math.
                                                tan(
                                                  java.lang.Math.
                                                    toRadians(
                                                      angle)));
                                        this.angle = angle;
    }
    public AbstractSVGTransform() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1ae2wcxRmfO8eO4/gVJ3ackDgPnEh53ZEA5eE0xTF24nBO" +
       "XNtYxClxxntz5433dpfdOftsGiCRqqRFRSmER3n4r6AABYIQiD4ApUUtIOgD" +
       "SAu0IlSlVWkBlbQqpaWUft/s3u3e3u2mV9WNtJP1zHwz3/ebb37fN7P38Aek" +
       "3DRIC1N5hE/qzIx0qryXGiaLdyjUNAegbli6s4z+Ze+7Oy8Lk4ohUjtKzR6J" +
       "mqxLZkrcHCJLZdXkVJWYuZOxOEr0GsxkxjjlsqYOkUbZ7E7piizJvEeLM+ww" +
       "SI0YmUc5N+SRNGfd9gCcLI2BJlGhSbTd29wWI9WSpk863Ztd3TtcLdgz5cxl" +
       "clIf20/HaTTNZSUak03eljHIOl1TJpOKxiMswyP7lYttCHbELi6AYOVjdR99" +
       "cnS0XkAwn6qqxoV5Zh8zNWWcxWOkzqntVFjKvI7cQMpiZK6rMyetseykUZg0" +
       "CpNmrXV6gfY1TE2nOjRhDs+OVKFLqBAnK/IH0alBU/YwvUJnGKGS27YLYbB2" +
       "ec5ay8oCE29fFz125976x8tI3RCpk9V+VEcCJThMMgSAstQIM8z2eJzFh8g8" +
       "FRa7nxkyVeQpe6UbTDmpUp6G5c/CgpVpnRliTgcrWEewzUhLXDNy5iWEQ9l/" +
       "lScUmgRbmxxbLQu7sB4MrJJBMSNBwe9skVljshrnZJlXImdj61XQAURnpxgf" +
       "1XJTzVIpVJAGy0UUqiaj/eB6ahK6lmvggAYni30HRax1Ko3RJBtGj/T067Wa" +
       "oNccAQSKcNLo7SZGglVa7Fkl1/p8sHPzLder29UwCYHOcSYpqP9cEGrxCPWx" +
       "BDMY7ANLsHpt7A7a9MyRMCHQudHT2erz1JfPXrG+5dQLVp/zivTZNbKfSXxY" +
       "Oj5S+8qSjjWXlaEalbpmyrj4eZaLXdZrt7RldGCYptyI2BjJNp7q+9Humx5i" +
       "74VJVTepkDQlnQI/midpKV1WmLGNqcygnMW7yRymxjtEezeZDe8xWWVW7a5E" +
       "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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "uUOI3gJhK6+qR8pcagm/BxC5EwC/fATw");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("y39LAIlbAOzk1XOnAIU9gD/4ZgCmcentN7ovm1/4e+R1V/N318mVX3z56uV3" +
       "vDz/k+LK6MmV7ytU6bK+dpyz97POPN8dhJq+C5VXdre1ggIOFZceudlV3rh0" +
       "EdQ50xeGO+oR4PdG1IAS1Gcpp3Hp2j5lXLpU/D5LN49L957S5YlU8XCWhAej" +
       "A5L8UQgKEZ6/5LG7zpbuNsKPnDWdYsF78I0UctLl7M3TfGNb/AvF8SZ0vfsn" +
       "iheUL748YH7ktcbP7G6+Ko6UZfkol6nSPbtLuMWg+Ub2qZuOdjzW3b1nvnP/" +
       "l66893jTff+O4VMzPsPbEze+Wtpxg7i4DJr9q3f80vd/4eWvFXdO/i8yXze2" +
       "2zIAAA==");
}
