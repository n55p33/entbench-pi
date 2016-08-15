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
      1471109864000L;
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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "z2N2i/azJ+HsPfuh5sy0+4HmdBUAzzl1/nzvXmy5P5dyBZSnj2LL0/ux5UKp" +
       "ePhw0eWpor6eV9977MpXgtCPAZeaWoz9TLyb7dbKGoeWC6LN5ijFgV588BvL" +
       "n/nTX9ilL/ua2SPWPvHST/zV4adeOjiTNL7vDXnb2T67xLFg7+0Fj7mtP3Wr" +
       "WYoe3f/ypRd/5Z+8+PEdVw+eT4E6IMP/hf/wl791+Llv/uYNVt1LwMrDeBeY" +
       "8xrJK2xnzo2bmv6z5xVzCEr5SDHlmyhmfBPF5I/tY41clXQdWO/JKl9QPxSX" +
       "Hit8V0riQ0MDSQF2nmqP+8lb5P5RUKpH3Fdvwr3w3XB/CbiCs1sbu0fqy38N" +
       "4tzgfWlfyuJb5PNhUJpHfDZvwqfy3fC5W7if32NH/X9g57kjdp67CTv2d8XO" +
       "9kbsLN+UnZ2ILwDXvlQ9RA/h/O/VjSe8mD9+H1jOo2KzmSvE8iTnmIN32Y5y" +
       "/XgBX4DNJ4i/120HPTa/a4X55ZHucLdj2+P1me+aV+DP958ORvlg8/fJ//Tp" +
       "3/rJ930D+OagdGmTx1bgxGdmZNb5fvjvvvLZx9720jc/WWQnQIKLv/36ox/O" +
       "R/2xWyHOq3VebY6hPppDZYtEn5KimC6SCE09QbtnuHc5/m2gja99s1eL+tjx" +
       "D1WRtGqipFNXHzW1UQ0yFgMEbFzbxtjrmHVE7GB1rQOns2615uEjnomFlHDS" +
       "1Iuzeg1B1EAHu7A4Ii1iulpNu1PW7UwRrxY2MAwX+hOrXcOC+Tzuj4w2i63h" +
       "vsM6C26JO/JkFUjcXI+hCFkjGrKuuosWx8SDcSXrJRkCabKMoDqDjpEmpi2R" +
       "9rRPVJi62YFWWT+FV+GWJy2JUrf2nME0A2SEjaiWlUWtjI62TWpZ8825HQ+z" +
       "aWPgrlJKXIZKjxhQosovFwNOWIujdNQJYTJKl6ltO9FKGC3nsoh20MCyssGm" +
       "o1F0OUnYPiy4c6XOlNkpQ+pqyyAUql/FBw5psvJMrbYSrt/i2GDZbCBirCKz" +
       "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" +
       "984dQvQWCFt5VT1S5lJL+D2AyJ0A+JUj");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("gF/5awJI3AJgJ6+eOwUo7AH8wbcCMI1L77zRfdn8wt8jb7iav7tOrvziy1cv" +
       "v+vl+e8XV0ZPrnxfoUqX9bXjnL2fdeb57iDU9F2ovLK7rRUUcKi49MjNrvLG" +
       "pYugzpm+MNxRjwC/N6IGlKA+SzmNS9f2KePSpeL3Wbp5XLr3lC5PpIqHsyQ8" +
       "GB2Q5I9CUIjw/CWP3XW2dLcRfuSs6RQL3oNvppCTLmdvnuYb2+JfKI43oevd" +
       "P1G8oHzp5QHzo681fnZ381VxpCzLR7lMle7ZXcItBs03sk/ddLTjse7uPfP6" +
       "/V++8v7jTff9O4ZPzfgMb0/c+Gppxw3i4jJo9i/e9Uvf/8WXv17cOfm/JcrX" +
       "ldsyAAA=");
}
