package org.apache.batik.parser;
public class AWTPolylineProducer implements org.apache.batik.parser.PointsHandler, org.apache.batik.parser.ShapeProducer {
    protected java.awt.geom.GeneralPath path;
    protected boolean newPath;
    protected int windingRule;
    public static java.awt.Shape createShape(java.io.Reader r, int wr) throws java.io.IOException,
        org.apache.batik.parser.ParseException { org.apache.batik.parser.PointsParser p =
                                                   new org.apache.batik.parser.PointsParser(
                                                   );
                                                 org.apache.batik.parser.AWTPolylineProducer ph =
                                                   new org.apache.batik.parser.AWTPolylineProducer(
                                                   );
                                                 ph.
                                                   setWindingRule(
                                                     wr);
                                                 p.
                                                   setPointsHandler(
                                                     ph);
                                                 p.
                                                   parse(
                                                     r);
                                                 return ph.
                                                   getShape(
                                                     );
    }
    public void setWindingRule(int i) { windingRule =
                                          i;
    }
    public int getWindingRule() { return windingRule;
    }
    public java.awt.Shape getShape() { return path;
    }
    public void startPoints() throws org.apache.batik.parser.ParseException {
        path =
          new java.awt.geom.GeneralPath(
            windingRule);
        newPath =
          true;
    }
    public void point(float x, float y) throws org.apache.batik.parser.ParseException {
        if (newPath) {
            newPath =
              false;
            path.
              moveTo(
                x,
                y);
        }
        else {
            path.
              lineTo(
                x,
                y);
        }
    }
    public void endPoints() throws org.apache.batik.parser.ParseException {
        
    }
    public AWTPolylineProducer() { super(
                                     ); }
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
       "fjhCHtICoESgNJrLtBVb3OfNpR989s12vS4edZQNf+1MuA8Vjc/Bp3ci3N5b" +
       "EG65k/qdd5TrtXOAgwB/6g3Onb5YFH8LchiCSHzj7dh7E8/Uz1n/wttg/WbR" +
       "+CR8uBPWuXeG9Yuc/cIb9P2Dovg5yPX6EtelyM45/Ltvg8My5r0fPosTDhfv" +
       "PIe//AZ9v1IUvxQh90MOS5st3l855+0fvV3DLbT3sRPePvbO8/bP727Uf7ME" +
       "+EpR/FPorjCuBdFhQSiaXj3n8ctvl8fvgI9+wqP+zvB4MXhd8a/7DNtTygOP" +
       "f1ui/ps3E8HXiuK3IKLvnZyUXGD+t98u898OH/+Eef+dV/DvvRl3f1AU/zEq" +
       "7w7dUb3/6a1wuIcLxR0uwxSn+Y+/7sbd4ZaY9jOv3Lz/sVcWv13eBzm7yfUA" +
       "h9xvxDBTvnD4eqF+3Q+AYZYcPHA4ivXLv/8WIY/dZTUqLkuUlZLq/3qA/2aE" +
       "3LoKD1Vd/l+E+18R8uA5HBzqULkI8kcRcg8EKap/7N/h9OpwBr2/diG3OTGJ" +
       "Us6Pvpmcz1AuXhcp8qHyxuNp7hIf7jy+qH3pFXb0fd/Af/JwXUWzlTwvRrmf" +
       "Q24cbs6c5T/P3nW007Gu089/6+GffeC501zt4QPB5+Z5gban73wfpOf4UXmD" +
       "I//7j/297/7br/xOeZj2fwHxjPx2iioAAA==");
}
