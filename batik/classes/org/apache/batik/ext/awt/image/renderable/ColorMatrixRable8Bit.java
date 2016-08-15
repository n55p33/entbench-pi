package org.apache.batik.ext.awt.image.renderable;
public class ColorMatrixRable8Bit extends org.apache.batik.ext.awt.image.renderable.AbstractColorInterpolationRable implements org.apache.batik.ext.awt.image.renderable.ColorMatrixRable {
    private static float[][] MATRIX_LUMINANCE_TO_ALPHA = { { 0, 0, 0, 0, 0 },
    { 0,
    0,
    0,
    0,
    0 },
    { 0,
    0,
    0,
    0,
    0 },
    { 0.2125F,
    0.7154F,
    0.0721F,
    0,
    0 } };
    private int type;
    private float[][] matrix;
    public void setSource(org.apache.batik.ext.awt.image.renderable.Filter src) {
        init(
          src,
          null);
    }
    public org.apache.batik.ext.awt.image.renderable.Filter getSource() {
        return (org.apache.batik.ext.awt.image.renderable.Filter)
                 getSources(
                   ).
                 get(
                   0);
    }
    public int getType() { return type; }
    public float[][] getMatrix() { return matrix; }
    private ColorMatrixRable8Bit() { super(); }
    public static org.apache.batik.ext.awt.image.renderable.ColorMatrixRable buildMatrix(float[][] matrix) {
        if (matrix ==
              null) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        if (matrix.
              length !=
              4) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        float[][] newMatrix =
          new float[4][];
        for (int i =
               0;
             i <
               4;
             i++) {
            float[] m =
              matrix[i];
            if (m ==
                  null) {
                throw new java.lang.IllegalArgumentException(
                  );
            }
            if (m.
                  length !=
                  5) {
                throw new java.lang.IllegalArgumentException(
                  );
            }
            newMatrix[i] =
              (new float[5]);
            for (int j =
                   0;
                 j <
                   5;
                 j++) {
                newMatrix[i][j] =
                  m[j];
            }
        }
        org.apache.batik.ext.awt.image.renderable.ColorMatrixRable8Bit filter =
          new org.apache.batik.ext.awt.image.renderable.ColorMatrixRable8Bit(
          );
        filter.
          type =
          TYPE_MATRIX;
        filter.
          matrix =
          newMatrix;
        return filter;
    }
    public static org.apache.batik.ext.awt.image.renderable.ColorMatrixRable buildSaturate(float s) {
        org.apache.batik.ext.awt.image.renderable.ColorMatrixRable8Bit filter =
          new org.apache.batik.ext.awt.image.renderable.ColorMatrixRable8Bit(
          );
        filter.
          type =
          TYPE_SATURATE;
        filter.
          matrix =
          (new float[][] { { 0.213F +
             0.787F *
             s,
           0.715F -
             0.715F *
             s,
           0.072F -
             0.072F *
             s,
           0,
           0 },
           { 0.213F -
             0.213F *
             s,
           0.715F +
             0.285F *
             s,
           0.072F -
             0.072F *
             s,
           0,
           0 },
           { 0.213F -
             0.213F *
             s,
           0.715F -
             0.715F *
             s,
           0.072F +
             0.928F *
             s,
           0,
           0 },
           { 0,
           0,
           0,
           1,
           0 } });
        return filter;
    }
    public static org.apache.batik.ext.awt.image.renderable.ColorMatrixRable buildHueRotate(float a) {
        org.apache.batik.ext.awt.image.renderable.ColorMatrixRable8Bit filter =
          new org.apache.batik.ext.awt.image.renderable.ColorMatrixRable8Bit(
          );
        filter.
          type =
          TYPE_HUE_ROTATE;
        float cos =
          (float)
            java.lang.Math.
            cos(
              a);
        float sin =
          (float)
            java.lang.Math.
            sin(
              a);
        float a00 =
          0.213F +
          cos *
          0.787F -
          sin *
          0.213F;
        float a10 =
          0.213F -
          cos *
          0.212F +
          sin *
          0.143F;
        float a20 =
          0.213F -
          cos *
          0.213F -
          sin *
          0.787F;
        float a01 =
          0.715F -
          cos *
          0.715F -
          sin *
          0.715F;
        float a11 =
          0.715F +
          cos *
          0.285F +
          sin *
          0.14F;
        float a21 =
          0.715F -
          cos *
          0.715F +
          sin *
          0.715F;
        float a02 =
          0.072F -
          cos *
          0.072F +
          sin *
          0.928F;
        float a12 =
          0.072F -
          cos *
          0.072F -
          sin *
          0.283F;
        float a22 =
          0.072F +
          cos *
          0.928F +
          sin *
          0.072F;
        filter.
          matrix =
          (new float[][] { { a00,
           a01,
           a02,
           0,
           0 },
           { a10,
           a11,
           a12,
           0,
           0 },
           { a20,
           a21,
           a22,
           0,
           0 },
           { 0,
           0,
           0,
           1,
           0 } });
        return filter;
    }
    public static org.apache.batik.ext.awt.image.renderable.ColorMatrixRable buildLuminanceToAlpha() {
        org.apache.batik.ext.awt.image.renderable.ColorMatrixRable8Bit filter =
          new org.apache.batik.ext.awt.image.renderable.ColorMatrixRable8Bit(
          );
        filter.
          type =
          TYPE_LUMINANCE_TO_ALPHA;
        filter.
          matrix =
          MATRIX_LUMINANCE_TO_ALPHA;
        return filter;
    }
    public java.awt.image.RenderedImage createRendering(java.awt.image.renderable.RenderContext rc) {
        java.awt.image.RenderedImage srcRI =
          getSource(
            ).
          createRendering(
            rc);
        if (srcRI ==
              null)
            return null;
        return new org.apache.batik.ext.awt.image.rendered.ColorMatrixRed(
          convertSourceCS(
            srcRI),
          matrix);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "KAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "dZryY80Td7pCVn2o+exHXnhRZ38WvXz0");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("zlhMofvTMPoBz9ga3hlq7j+8xT5BUl6TgN4O0nuPkLz3/MvYU169kq8Bl27G" +
       "Xnv52IeOlxpxNekXLngp/mtl9isAZWKkh3eSt30HuQ0d/VTQ//A7vX48u8o5" +
       "Tj1SVn4fSL0jTvW+O5w6C+orF7T98zL7EgBsHQMuK371FNw/exXgrpaVj4JE" +
       "HYGjvvvgfv+Ctn9TZv8ihe4F4I6/ST1/Cu33XgW08tsH9CRIiyNoi+8+tH9/" +
       "QdvXyuyPDnKjT79VnIL741cBrrrcWLarR+DUVwDu9OtY7yIbrsitOvzXC2D+" +
       "tzL7Rgq9Rs0cTz8F+kunQP/LqwVaA+njR0A//r0Buqg6/NmdgV6qFv1fKfTa" +
       "Cui8vBetpMY5qH/6aqGiIH3mCOpnvodQLz1wAdQHy+yeFHqogjrODL78dH0O" +
       "66UrrxZrG6RfP8L6699FrGehPHpB22Nl9nAKvaGCSWW+E5RfzBch4UW2cg7t" +
       "I68C7ZvKyneB9OUjtF9+BWhf/mb7zuoD4G03V74qHl3+r8C/7QLGvKPMnkih" +
       "q1psALkfBjuBdbzQm88tdOhg6GT5dMqyJ18Jy3Yp9Prb3SYub0Y+dsv/Ohzu" +
       "52ufe/HqfW98UfiXh3tYx3fo76eg+8zM885eZDtTvhLFhnlwUvcfrrVFFWok" +
       "hZ592eFKWt6kOH4owVy6fpilnkJPXjxLCt3jHDPqeFQzhR6706gUugvkZ3u3" +
       "Aa9u1xv0BPnZns+l0LXzPcH61e/Zfu8DeE77pdCVQ+FsFwLMDrqUxW50rAnk" +
       "y4/vCDVJY0VLKyGT5cU4INXqQswh1L10Jlo9sqDKpX5HwzsZcvYycUlG9Y80" +
       "xzdpssO/0tzQPv/ihPnhb7V+9nCZWfOUoihnuY+C7j3cq64mLW/jPHXH2Y7n" +
       "ujJ+9tsP/eL9bz+Ovh86EHxqzWdoe8vtLw4P/CitrvoWv/LGv//ev/viH1Rf" +
       "6/8vmU7Lw+E0AAA=");
}
