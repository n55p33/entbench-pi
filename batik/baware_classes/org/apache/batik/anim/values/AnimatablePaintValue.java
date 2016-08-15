package org.apache.batik.anim.values;
public class AnimatablePaintValue extends org.apache.batik.anim.values.AnimatableColorValue {
    public static final int PAINT_NONE = 0;
    public static final int PAINT_CURRENT_COLOR = 1;
    public static final int PAINT_COLOR = 2;
    public static final int PAINT_URI = 3;
    public static final int PAINT_URI_NONE = 4;
    public static final int PAINT_URI_CURRENT_COLOR = 5;
    public static final int PAINT_URI_COLOR = 6;
    public static final int PAINT_INHERIT = 7;
    protected int paintType;
    protected java.lang.String uri;
    protected AnimatablePaintValue(org.apache.batik.dom.anim.AnimationTarget target) {
        super(
          target);
    }
    protected AnimatablePaintValue(org.apache.batik.dom.anim.AnimationTarget target,
                                   float r,
                                   float g,
                                   float b) { super(target,
                                                    r,
                                                    g,
                                                    b); }
    public static org.apache.batik.anim.values.AnimatablePaintValue createNonePaintValue(org.apache.batik.dom.anim.AnimationTarget target) {
        org.apache.batik.anim.values.AnimatablePaintValue v =
          new org.apache.batik.anim.values.AnimatablePaintValue(
          target);
        v.
          paintType =
          PAINT_NONE;
        return v;
    }
    public static org.apache.batik.anim.values.AnimatablePaintValue createCurrentColorPaintValue(org.apache.batik.dom.anim.AnimationTarget target) {
        org.apache.batik.anim.values.AnimatablePaintValue v =
          new org.apache.batik.anim.values.AnimatablePaintValue(
          target);
        v.
          paintType =
          PAINT_CURRENT_COLOR;
        return v;
    }
    public static org.apache.batik.anim.values.AnimatablePaintValue createColorPaintValue(org.apache.batik.dom.anim.AnimationTarget target,
                                                                                          float r,
                                                                                          float g,
                                                                                          float b) {
        org.apache.batik.anim.values.AnimatablePaintValue v =
          new org.apache.batik.anim.values.AnimatablePaintValue(
          target,
          r,
          g,
          b);
        v.
          paintType =
          PAINT_COLOR;
        return v;
    }
    public static org.apache.batik.anim.values.AnimatablePaintValue createURIPaintValue(org.apache.batik.dom.anim.AnimationTarget target,
                                                                                        java.lang.String uri) {
        org.apache.batik.anim.values.AnimatablePaintValue v =
          new org.apache.batik.anim.values.AnimatablePaintValue(
          target);
        v.
          uri =
          uri;
        v.
          paintType =
          PAINT_URI;
        return v;
    }
    public static org.apache.batik.anim.values.AnimatablePaintValue createURINonePaintValue(org.apache.batik.dom.anim.AnimationTarget target,
                                                                                            java.lang.String uri) {
        org.apache.batik.anim.values.AnimatablePaintValue v =
          new org.apache.batik.anim.values.AnimatablePaintValue(
          target);
        v.
          uri =
          uri;
        v.
          paintType =
          PAINT_URI_NONE;
        return v;
    }
    public static org.apache.batik.anim.values.AnimatablePaintValue createURICurrentColorPaintValue(org.apache.batik.dom.anim.AnimationTarget target,
                                                                                                    java.lang.String uri) {
        org.apache.batik.anim.values.AnimatablePaintValue v =
          new org.apache.batik.anim.values.AnimatablePaintValue(
          target);
        v.
          uri =
          uri;
        v.
          paintType =
          PAINT_URI_CURRENT_COLOR;
        return v;
    }
    public static org.apache.batik.anim.values.AnimatablePaintValue createURIColorPaintValue(org.apache.batik.dom.anim.AnimationTarget target,
                                                                                             java.lang.String uri,
                                                                                             float r,
                                                                                             float g,
                                                                                             float b) {
        org.apache.batik.anim.values.AnimatablePaintValue v =
          new org.apache.batik.anim.values.AnimatablePaintValue(
          target,
          r,
          g,
          b);
        v.
          uri =
          uri;
        v.
          paintType =
          PAINT_URI_COLOR;
        return v;
    }
    public static org.apache.batik.anim.values.AnimatablePaintValue createInheritPaintValue(org.apache.batik.dom.anim.AnimationTarget target) {
        org.apache.batik.anim.values.AnimatablePaintValue v =
          new org.apache.batik.anim.values.AnimatablePaintValue(
          target);
        v.
          paintType =
          PAINT_INHERIT;
        return v;
    }
    public org.apache.batik.anim.values.AnimatableValue interpolate(org.apache.batik.anim.values.AnimatableValue result,
                                                                    org.apache.batik.anim.values.AnimatableValue to,
                                                                    float interpolation,
                                                                    org.apache.batik.anim.values.AnimatableValue accumulation,
                                                                    int multiplier) {
        org.apache.batik.anim.values.AnimatablePaintValue res;
        if (result ==
              null) {
            res =
              new org.apache.batik.anim.values.AnimatablePaintValue(
                target);
        }
        else {
            res =
              (org.apache.batik.anim.values.AnimatablePaintValue)
                result;
        }
        if (paintType ==
              PAINT_COLOR) {
            boolean canInterpolate =
              true;
            if (to !=
                  null) {
                org.apache.batik.anim.values.AnimatablePaintValue toPaint =
                  (org.apache.batik.anim.values.AnimatablePaintValue)
                    to;
                canInterpolate =
                  toPaint.
                    paintType ==
                    PAINT_COLOR;
            }
            if (accumulation !=
                  null) {
                org.apache.batik.anim.values.AnimatablePaintValue accPaint =
                  (org.apache.batik.anim.values.AnimatablePaintValue)
                    accumulation;
                canInterpolate =
                  canInterpolate &&
                    accPaint.
                      paintType ==
                    PAINT_COLOR;
            }
            if (canInterpolate) {
                res.
                  paintType =
                  PAINT_COLOR;
                return super.
                  interpolate(
                    res,
                    to,
                    interpolation,
                    accumulation,
                    multiplier);
            }
        }
        int newPaintType;
        java.lang.String newURI;
        float newRed;
        float newGreen;
        float newBlue;
        if (to !=
              null &&
              interpolation >=
              0.5) {
            org.apache.batik.anim.values.AnimatablePaintValue toValue =
              (org.apache.batik.anim.values.AnimatablePaintValue)
                to;
            newPaintType =
              toValue.
                paintType;
            newURI =
              toValue.
                uri;
            newRed =
              toValue.
                red;
            newGreen =
              toValue.
                green;
            newBlue =
              toValue.
                blue;
        }
        else {
            newPaintType =
              paintType;
            newURI =
              uri;
            newRed =
              red;
            newGreen =
              green;
            newBlue =
              blue;
        }
        if (res.
              paintType !=
              newPaintType ||
              res.
                uri ==
              null ||
              !res.
                 uri.
              equals(
                newURI) ||
              res.
                red !=
              newRed ||
              res.
                green !=
              newGreen ||
              res.
                blue !=
              newBlue) {
            res.
              paintType =
              newPaintType;
            res.
              uri =
              newURI;
            res.
              red =
              newRed;
            res.
              green =
              newGreen;
            res.
              blue =
              newBlue;
            res.
              hasChanged =
              true;
        }
        return res;
    }
    public int getPaintType() { return paintType;
    }
    public java.lang.String getURI() { return uri;
    }
    public boolean canPace() { return false;
    }
    public float distanceTo(org.apache.batik.anim.values.AnimatableValue other) {
        return 0.0F;
    }
    public org.apache.batik.anim.values.AnimatableValue getZeroValue() {
        return org.apache.batik.anim.values.AnimatablePaintValue.
          createColorPaintValue(
            target,
            0.0F,
            0.0F,
            0.0F);
    }
    public java.lang.String getCssText() {
        switch (paintType) {
            case PAINT_NONE:
                return "none";
            case PAINT_CURRENT_COLOR:
                return "currentColor";
            case PAINT_COLOR:
                return super.
                  getCssText(
                    );
            case PAINT_URI:
                return "url(" +
                uri +
                ")";
            case PAINT_URI_NONE:
                return "url(" +
                uri +
                ") none";
            case PAINT_URI_CURRENT_COLOR:
                return "url(" +
                uri +
                ") currentColor";
            case PAINT_URI_COLOR:
                return "url(" +
                uri +
                ") " +
                super.
                  getCssText(
                    );
            default:
                return "inherit";
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "4Ct/bf79Fy37eZ7F3Av/A7KJpi8jMQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "LITGk2qdiOGqPqoSMLqC0Gqb9ozanOmj");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("2eOy12/uEdx92ePDw5N07+DBYXTCY9MP705uZL8zuWPnsY48hj3y4jWXvlV+" +
       "7EZH5rI3yl/51Cuvar2vFve3L33JMHcObJp/0tJXunWkqfOgpfff+B0uk50Y" +
       "3L1I/Z1P/fkjwodmH72Jc0dPHMN5vMl/zHzt91rPqZ/fz506fK16zVnGqytd" +
       "vvpl6l2+DmYOR7jqlepjh5LNXgpcBldzK9nm8Qfcu9G8Zpj2d3qxUYljL9b3" +
       "doNZyAr8yQlv3v80Df4ozL1b9XUl1Luuc+TU2DGV+nc381Y+S/i3VzPGwNXb" +
       "Mu79OBn/5xMY/9c0+FaYe3TDGFv6vu6EmGu5/g2Zf/tWmX8AXPKWuXwbmR89" +
       "pZIG+C7Iyv+PEwTxRhr8eZh7cCuIEyXw/VuVwN8El7qVgHobJbC/K5VJ4LWs" +
       "1Jsn8P6rNPhhmHtgw1vkqBuy/tGtsv4QuNwta/fHzXrv7I1Z751Lg/0w99Ah" +
       "65Nsfe/UrTInwPWxLfOP/diZP3AC8wfT4F7gwQ+Zvx2b3zt/qxL4KXC9vJXA" +
       "y7dRAqezUqd3EriO4e89cYJA0pNxe4+EuYd3AjlREu+9HVbw+a0kPn8bJXHc" +
       "7+/lT2D9k2nw3KEBUM5M98E280ak33cLpN+bJqYHFb68Jf3lmyC9XYWdMPIH" +
       "L7NfeJvHwA/o7dUOlGQTy86i71VPkNnlNCiFuXdlX3iABRAQXFZ9Jyf4FuR0" +
       "PrcV1ne3cvru7ZHTUQon5bXS4MUwd/dU3yjC4dmFHT/0FvjdnyamJ0K+t+X3" +
       "vdvPr39CHp8GnTB3BvDbnnh6bceMuQVmD6SJj4DrjS2zN24/sw+fkHclDYZh" +
       "7qyqOOzBh0fHzh6cHbuupSvOjrF8C4zvO9DVv9wy/svbw3jnw/ZqGTXrBNrp" +
       "Kf69aZi7SzM22w4h+5QG31Gc3arbAg57b8tw8397BzU6IS9Jg2BjjiPdd3d+" +
       "a8cvvFVzfBRAPbvld/b28/uZE/I+nQYfB6MH+GFgYwy2tsdM8hM3de4Z7Nqu" +
       "961P+tXCw9d8Yrj5LE79+qvn73zoVfFPss9dDj9dO9fJ3TlZWtbR48BH4mc8" +
       "X58YGfdzm8PBXkboH4Bd1ElzEPA8m0iKfe/vbyp9Duw4rlspzN2R/h0t+/Nh" +
       "7sLxsmHudPZ/tNwXgVB35UC3m8jRIr8Y5k6BImn0l7yDGfTtfkiVrY8y4Uab" +
       "03sPH9WwbKtw/1sN3ZHnJM9c9XQj+2j04EnEcvPZ6BX1G6/S3Y+9Ufnq5vse" +
       "1VKS1Dxyd3ZyZzefGmWNpk8znrphawdtnSGff/Pe3zj37MGTl3s3gHfafgTb" +
       "E9f/kqZpe2H27UvyWw/90w/86qvfyk5r/z8O4MTUzTsAAA==");
}
