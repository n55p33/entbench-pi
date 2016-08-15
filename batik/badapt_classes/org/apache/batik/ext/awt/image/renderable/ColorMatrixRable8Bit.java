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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "KAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "qh1lpQxZbjCsp/XISwl06ch+pa666GS7Vts51rNpy8VHHYU2mXE76+Oq0V/q" +
       "ubfewXqNVtTI0JYCnOadeuAl2Jpm401jjSw7ze2MbaayZ3pLbTfeLuyZZiwF" +
       "T3WNSbW6RgVpVHM7zBhvDmu1ZS1yBxOjP4YVYkbEaRJzOoF6wlZgGLCnwZvp" +
       "roVLWey51XCYUTU+iiNepnRsNJ/YUxkJ2Sm3YD22WZmNNtmcEXhW2PC8pzUH" +
       "DktOSCV3M3Ts8XlnLY03DbklMQuiKmt1IB25qW7GS2w4HjJa0jQ6+kT10TVO" +
       "N2u5mmULtmu2DdqqJ7tBC63qjfqyi68rzUFXq7PbaW9q6vqEa1X5Cd5Pw4We" +
       "dMLlKiNrDCLqI6UnpJ67XIpwI4PNMB7pZtWtTxoeh6+IhtGYe01xh0w3RDgW" +
       "ugjBVuuw7BDByqws4uFCqcu653teS022tZpPMhjeB2upXhGj7qJmUKLcayUM" +
       "jHiN5hSbNlV/PEuWFkxK9kBf2+3KzDTCBLVXeMysWlMcEGEueupARFKda6oC" +
       "htP02I7wRRzLQlPGa01VXLVa8QJl8ykquOux193ovtjDBqZb4xg41fAW1mTJ" +
       "UT0YdSZiL8iVicCY6zCs17lNhxl128bGqdb7E3Rspho6GPP9bDpqqVSz4yvK" +
       "wNjpqDYcN2J2xvGM0R/R+opPm1YQR+Zu4xoUn7uk2BNwbFXD1Sm3RToksd0s" +
       "mgLme5NM362WnsQPNs2KLcbqYL1D4Q2SDurrit6PnNFm2k+IfErVTUz3KqMe" +
       "OvGturiWOugImNeRV16dlJPx0l/tXMDsFX0R7Rpmv675KRITlkLuWr3pzMJh" +
       "f2IQYHXpriM03/SRcbIT7A0X2j0O66CSNDdiwkQ6WGeLB+gWz+QMdsQpMWsQ" +
       "hKTnQnO4jdRVt80m3Z7Npy0nrKqbhAs4b9xqjytbicWjDSxWssoqrwyNioJm" +
       "MU6oE12T0eYCkdkl0VasRGzobittSPxsS68wUwjTjaqPSTHr8viy2VhPGJ9A" +
       "dW3YEwW/nnhxKs+jqapVYH227SGwhtfbqNFbCKG6qhmVfpL5RJ3N0y5JqZo3" +
       "SbGdvnTxeWfga1Mrnntyd83Z3jzT5g20angTb9nj1FR1kCZt1pyOlyTmJkgx" +
       "4AuJLJiJGjSqS0YNjRirVaeu4PS68oyihEky8yRBCtjE6o0dumNuBs2OTXHt" +
       "qTIZ6AnMrJT+eF1t+Wpo9WxrPQ+zQNqsbLYxY0U3ogZJqKBVylkbVder59OO" +
       "r+dJVsdr8dRD1+u1XU96QlhntZWwtuezYaAD3/JiMsh6OO7CdBKvFbnirsYy" +
       "12C5vjfmtnCLHsBTTbPr7EKnUkyuwyKRV5Y+Oo/dLi0Defvu3LWl2pJFRLo+" +
       "J/Fa3bSnthlsveqQ7ASwILZRpAFA98itbNemLkOaaYUfVFVr2libJOfvevR6" +
       "wmt5q612h51WNxlO08Wyv+YWPWQW4zGWmUgc5ZkeIutuSuVgTW8OrMEMn7IV" +
       "dcEi/dqqZlHTno3v6jVpQggpxzIxCXelsDoNJSEYs5WFh9esKk0zrWBAW8EM" +
       "DnIqjxmc3eURzXPMTBuMSE4ZKU2milFcv6LWQ2s3lLZoDx82LcoatA0+2Bg1" +
       "hOF5GxvksaqhuyFDbJtbrIpW7fEGhUfbCWKL8A7djVVql4zA+rfD1nAlNhIV" +
       "yzZWC18rfQ3X06VSzfRGJeTrCsMYBq3OWbAoq2EU+qw26TmKOTJCa0YIxAIB" +
       "+5ImM8lWGd8xFqzW5zvReFMxlx1r4XcCBV8Fo/ac0rcaQ5gVbCgEFRIjRHc9" +
       "pyu5Kendba7WwoWTwdrE5zc9Y8P6ihS2gj49nvVFUpLHM4lLW/wwmxGJDa+c" +
       "jg6mVGMQt0WV7hCmpSqDAbYhbJtfgWqjTk/2WDvEaiTDdjsLNp800ISOWF4e" +
       "taf6AMTycbDuNPqjTrvbDPujAYKAy7erw03VICg7X1bXK1jIqkN57CK7xpjO" +
       "UdM2croyB2GhI/e78zZn8J08aegzhe/mDNaLxfayt6ogvEL0BwhTW/b6kUmF" +
       "Mx5pjCbodKb53cWoXyWYkE2dHPU5ENr73cR2hwqVZwJQaCgMJdbfUfO8Nog2" +
       "fAVz+oOGMgmTeEBIpLfQaXVRYTCRY1aYnzecSnukU4sev2OCgZ12RFbbdYRm" +
       "uytEphMHZKPbjKdpLWX9zsgEvsHmHrGe1rCZ0N6y3LgrbdR2PF/Eu2a1lgqr" +
       "qr2dcsKuMyIlY4n6044bkeiq2h6FqTmv1RiVNlZjM/HdYNkZ1BuV0aS1yqNx" +
       "tTJsdyjVUqeYncogAJab3UQasmNzwjadqkOkhEPgjXqDxJrdiun1KVdpjJJU" +
       "95CVv9YALXVxcuITVTUaSdJ4uZ7jWYdC9ZE76/h2ZSq4y7Uu236m5Hlj1c53" +
       "raWlpjtDoqd5sib5vLrte7K+M+xRjzZFRbDpeZ/Je7wn99oqaUqe4Gh2N5o5" +
       "kdEKGpUe3Y5YIuxPs6qaraTZeN0aehQMt7C6TMAjDNt24O4U1oYi2h6sZGNV" +
       "102paw8iRXcBR9GeSDMVUkQxks9wMoKnRE+cNy1OY80oX6OES7GhUJe7lRxs" +
       "gpo9OBlzynrE9bi6bDWzwUwVaksfti3A7HQ82ozG6MpwG8FqNFN0Y+dyaxoR" +
       "hfpczhtpgivUBDhjVQ/63BxsuYE9JrCzmdhsezRrmW11gee6iFS9mNFHKrxa" +
       "V2hqWcEybecyUzOl5n3KqSZyM64y4jCvimgiruAMtYnEd/xqTe75dbTSjHfE" +
       "Gm9QgANmyayHNHYWVplso1zLtGy5aOgJkGUeteEpCGfRzqSWqpmLxoE+yhG+" +
       "FfX6aY0IV8MlAbb4si/5w7bPARLLl/0NJu2oNKNRrSpJzaxVa6JwjR/50bA1" +
       "U0JJq1H0KLTEbpRWl4k9bpJ0v7qaGCN0o9ZH8cRlMW3F4MYqUOzdQprZ41TX" +
       "sV6+yUx2RqJhqPPYHJtWB3bXiZtEfbv1SZgZtdvt4tXQz93eK6sHyrdzRwfF" +
       "bBcvCj5zG2+l9kVPFYl/9Aqz/LsIHRwqOvw98QrzxGfnc4dvAt/3Vz9OU3ys" +
       "eexWR8jKDzWf/ejLr6rjn62dP3hnLKTQ");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("PWkQfp+rrTX3hDT37N9iHyEpjklAz4Hr/QdI3n/6Zeyxrm7na8C567FX3zj2" +
       "nuWmWlx2+oUzXor/WpH8CkCZaOn+neRN30GuA0s9NvQ/+navH0+OckpTDxaZ" +
       "3wMu8kBT5HdGUydBffmMsn9WJF8EgI1DwEXGrx6D+6dvAtzlIvNhcNEH4Ojv" +
       "PLg/PKPsXxfJP0+huwC4w29SLx5D+4M3Aa349gE9Di7uABr3nYf2784o+2qR" +
       "/Mnebszxt4pjcH/6JsCVhxuLcvkAnHwb4I6/jpFnzeFS3LLCfz0D5n8rkq+n" +
       "0FvkzHLVY6C/dAz0P79ZoFVwfeIA6Ce+O0C5ssJf3BrouXLQ/5VC95VA58W5" +
       "aCnVTkH98zcLtQauVw6gvvJdhHru0hlQ7y2SCyl0fwl1kGmz4tP1KaznLr5Z" +
       "rE1w/cYB1t/4DmI9CeXhM8oeKZIHUuihEiadeZZffDHngrYbmtIptA++CbTv" +
       "KDLfA64vHaD90m2gfeOL7bvLD4A3XVxn5e3B4f8S/NNnKOZdRfJYCl1WYg3Y" +
       "fd/Y8o3Dgd55aqB9BU0dFk/HKnv8dlS2SaG33ew0cXEy8pEb/tdhfz5f+dyr" +
       "l+9++6v8v9ifwzo8Q38PDd2tZ6578iDbifuLYazpe5K6Z3+sLSxRwyn0/BsO" +
       "V9LiJMXhQwHm3NV9L0gKPX52Lyl0wTpU1GGrego9cqtWKXQHSE/WbgJd3aw2" +
       "qAnSkzVfSKErp2uC8cvfk/U+APAc10uhi/ubk1XaoHdQpbglwkNPGL7x+K4t" +
       "J2ksKWlp5GFxMA5YtTwQsw91z52IVg9mUEmp33biHTU5eZi4EKP8R5rDkzTZ" +
       "/l9primff5Vif/CbjZ/dH2ZWXGm3K3q5m4bu2p+rLjstTuM8dcveDvu6OHj+" +
       "W/f/4j3PHUbf9+8FPp7NJ2R74uYHh7temJZHfXe/8vZ/8P6/9+oflV/r/y+h" +
       "6uZP4TQAAA==");
}
