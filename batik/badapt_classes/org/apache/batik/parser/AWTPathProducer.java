package org.apache.batik.parser;
public class AWTPathProducer implements org.apache.batik.parser.PathHandler, org.apache.batik.parser.ShapeProducer {
    protected org.apache.batik.ext.awt.geom.ExtendedGeneralPath path;
    protected float currentX;
    protected float currentY;
    protected float xCenter;
    protected float yCenter;
    protected int windingRule;
    public static java.awt.Shape createShape(java.io.Reader r, int wr) throws java.io.IOException,
        org.apache.batik.parser.ParseException { org.apache.batik.parser.PathParser p =
                                                   new org.apache.batik.parser.PathParser(
                                                   );
                                                 org.apache.batik.parser.AWTPathProducer ph =
                                                   new org.apache.batik.parser.AWTPathProducer(
                                                   );
                                                 ph.
                                                   setWindingRule(
                                                     wr);
                                                 p.
                                                   setPathHandler(
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
    public void startPath() throws org.apache.batik.parser.ParseException {
        currentX =
          0;
        currentY =
          0;
        xCenter =
          0;
        yCenter =
          0;
        path =
          new org.apache.batik.ext.awt.geom.ExtendedGeneralPath(
            windingRule);
    }
    public void endPath() throws org.apache.batik.parser.ParseException {
        
    }
    public void movetoRel(float x, float y)
          throws org.apache.batik.parser.ParseException {
        path.
          moveTo(
            xCenter =
              (currentX +=
                 x),
            yCenter =
              (currentY +=
                 y));
    }
    public void movetoAbs(float x, float y)
          throws org.apache.batik.parser.ParseException {
        path.
          moveTo(
            xCenter =
              (currentX =
                 x),
            yCenter =
              (currentY =
                 y));
    }
    public void closePath() throws org.apache.batik.parser.ParseException {
        path.
          closePath(
            );
        java.awt.geom.Point2D pt =
          path.
          getCurrentPoint(
            );
        currentX =
          (float)
            pt.
            getX(
              );
        currentY =
          (float)
            pt.
            getY(
              );
    }
    public void linetoRel(float x, float y)
          throws org.apache.batik.parser.ParseException {
        path.
          lineTo(
            xCenter =
              (currentX +=
                 x),
            yCenter =
              (currentY +=
                 y));
    }
    public void linetoAbs(float x, float y)
          throws org.apache.batik.parser.ParseException {
        path.
          lineTo(
            xCenter =
              (currentX =
                 x),
            yCenter =
              (currentY =
                 y));
    }
    public void linetoHorizontalRel(float x)
          throws org.apache.batik.parser.ParseException {
        path.
          lineTo(
            xCenter =
              (currentX +=
                 x),
            yCenter =
              currentY);
    }
    public void linetoHorizontalAbs(float x)
          throws org.apache.batik.parser.ParseException {
        path.
          lineTo(
            xCenter =
              (currentX =
                 x),
            yCenter =
              currentY);
    }
    public void linetoVerticalRel(float y)
          throws org.apache.batik.parser.ParseException {
        path.
          lineTo(
            xCenter =
              currentX,
            yCenter =
              (currentY +=
                 y));
    }
    public void linetoVerticalAbs(float y)
          throws org.apache.batik.parser.ParseException {
        path.
          lineTo(
            xCenter =
              currentX,
            yCenter =
              (currentY =
                 y));
    }
    public void curvetoCubicRel(float x1,
                                float y1,
                                float x2,
                                float y2,
                                float x,
                                float y) throws org.apache.batik.parser.ParseException {
        path.
          curveTo(
            currentX +
              x1,
            currentY +
              y1,
            xCenter =
              currentX +
                x2,
            yCenter =
              currentY +
                y2,
            currentX +=
              x,
            currentY +=
              y);
    }
    public void curvetoCubicAbs(float x1,
                                float y1,
                                float x2,
                                float y2,
                                float x,
                                float y) throws org.apache.batik.parser.ParseException {
        path.
          curveTo(
            x1,
            y1,
            xCenter =
              x2,
            yCenter =
              y2,
            currentX =
              x,
            currentY =
              y);
    }
    public void curvetoCubicSmoothRel(float x2,
                                      float y2,
                                      float x,
                                      float y)
          throws org.apache.batik.parser.ParseException {
        path.
          curveTo(
            currentX *
              2 -
              xCenter,
            currentY *
              2 -
              yCenter,
            xCenter =
              currentX +
                x2,
            yCenter =
              currentY +
                y2,
            currentX +=
              x,
            currentY +=
              y);
    }
    public void curvetoCubicSmoothAbs(float x2,
                                      float y2,
                                      float x,
                                      float y)
          throws org.apache.batik.parser.ParseException {
        path.
          curveTo(
            currentX *
              2 -
              xCenter,
            currentY *
              2 -
              yCenter,
            xCenter =
              x2,
            yCenter =
              y2,
            currentX =
              x,
            currentY =
              y);
    }
    public void curvetoQuadraticRel(float x1,
                                    float y1,
                                    float x,
                                    float y)
          throws org.apache.batik.parser.ParseException {
        path.
          quadTo(
            xCenter =
              currentX +
                x1,
            yCenter =
              currentY +
                y1,
            currentX +=
              x,
            currentY +=
              y);
    }
    public void curvetoQuadraticAbs(float x1,
                                    float y1,
                                    float x,
                                    float y)
          throws org.apache.batik.parser.ParseException {
        path.
          quadTo(
            xCenter =
              x1,
            yCenter =
              y1,
            currentX =
              x,
            currentY =
              y);
    }
    public void curvetoQuadraticSmoothRel(float x,
                                          float y)
          throws org.apache.batik.parser.ParseException {
        path.
          quadTo(
            xCenter =
              currentX *
                2 -
                xCenter,
            yCenter =
              currentY *
                2 -
                yCenter,
            currentX +=
              x,
            currentY +=
              y);
    }
    public void curvetoQuadraticSmoothAbs(float x,
                                          float y)
          throws org.apache.batik.parser.ParseException {
        path.
          quadTo(
            xCenter =
              currentX *
                2 -
                xCenter,
            yCenter =
              currentY *
                2 -
                yCenter,
            currentX =
              x,
            currentY =
              y);
    }
    public void arcRel(float rx, float ry,
                       float xAxisRotation,
                       boolean largeArcFlag,
                       boolean sweepFlag,
                       float x,
                       float y) throws org.apache.batik.parser.ParseException {
        path.
          arcTo(
            rx,
            ry,
            xAxisRotation,
            largeArcFlag,
            sweepFlag,
            xCenter =
              (currentX +=
                 x),
            yCenter =
              (currentY +=
                 y));
    }
    public void arcAbs(float rx, float ry,
                       float xAxisRotation,
                       boolean largeArcFlag,
                       boolean sweepFlag,
                       float x,
                       float y) throws org.apache.batik.parser.ParseException {
        path.
          arcTo(
            rx,
            ry,
            xAxisRotation,
            largeArcFlag,
            sweepFlag,
            xCenter =
              (currentX =
                 x),
            yCenter =
              (currentY =
                 y));
    }
    public AWTPathProducer() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "f/bK/TmKNgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "YnjtCTlPVvkr2Ee/OHqj8HOXSrcdrPid");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("+vbpeKFHj6/z3eVJQehZ1LHVvtcc2Oy+fTvBO5vBJ9/kH3rFKf+6dOhfW9c6" +
       "sV596bipt++2NfvGXOLE7RqEX5T7lWcvd+9+uTE+iAXJOdBp9uyNZ7tP9nPA" +
       "XjTzsZx8KCi9QPAkLpAKpzkuW74GeXi7iIIPn/c+++jadHHjXxwo9wX5zYey" +
       "Y7lT7vI5KLdYI3n4pnrdO2TYKvAzz/KhwL/PyacyhL4UMM++0HL7xtbEQ+j/" +
       "9hagX8tv5it8j+2gP3Yx0I8i+9KzPPu9nHw+Q60cQ12o7BDhF24BYZHxXpEd" +
       "6g6hevEI/+hZnn01J38QlK5mCAufza//zSG2r9yq474qO+wdNvvisf3p2U79" +
       "iYLhz3LytSw1Z3nNC/Y/A/jtQ4Rfv1WEufXSHcL04hF+5zyE/zsn3wqKbx1v" +
       "gu8vbhVfOTue2OF74mLwXTpM/MX68bzg+qvzkP51Tr6f2dK0N1JgzyXjBNa/" +
       "vAisT+6wPvk8Yt27eg7WvbtyctsB1i7vH8e6d/tFROZTO6xPXbjf7r3kPIQv" +
       "y8m1DKFg2L502nP3rl+ENZ/ZIXzm+bTm687D+kBOXpVhzb88vonn7r36IrB+" +
       "cIf1g88n1rech/VGTt50gPW05z58q1jfkh0f2WH9yMVgPYJiC7N9Hsy/k5NG" +
       "Nq7cwoRtT0vzj/mM08ZtXgTgj+0Af+x5Atw/D/AwJz9+E8CnLfz2WwX85uz4" +
       "5A7wJ58nwMR5gHOn30Oyie4W8ELyAk24mX3Ri4D76R3cTz9PcH/iPLjvyAlz" +
       "Cu5p6y5vFW4tO35nB/dzFwP3csFw+TBX3YwUMNXz9KDnRAhK14TQy7teKOQ1" +
       "4bTRxYvQwpd3WvjPP2otBOdpYZMT+4QWTvuCc6tayL+O/K87LXz1YrRwe8Fw" +
       "+5nYnzgP+3ty8q6g9NKj2EnTtgP1tB+8+yI08M2dBr7xo9HAPzlPA0/l5Mmb" +
       "auC0D7z3VjUAZMf3dxr43o9GA8+cp4F/lpOfz3q7nQZmISd6+Yedpz3g6QvA" +
       "v7e3Lbv9ef7xf+g8/B/JyQdvgv+0/f/5reJ/NGv56g7/1YvBf/Ox6yfOQ/3r" +
       "OfnXQekVJ1GfFf0fvQjs9+6w3/t8Yv9352H/rZz85pnYT9v9U7eK/eGs/Qd2" +
       "2F97MdivFAxXTrh88fjEa8orvG0bEpdvS9v74gldfeE8Xf2nnHwuKF3mvJsk" +
       "hP9wEYq5sVNM+flUzD74Uxr4w/M08Mc5+f2tBk67xh88Fw3E2SjjxG7RfLvb" +
       "fae2oW+3Tgu/9oFrV1/+AfoPiw2TB9ub70RLV+XQMI7uTjpyftnxJFkrVHPn" +
       "dq+SU+D4elB6+Rlv//PdhMVJLvHe17b8/yMoXT/JH5TuKH6P8v1ZULrrkC/X" +
       "U3FylOWbQem2jCU//XOn0MrxfQDbTVrxXvHovqPukuu4dM95Oj4ocnQ/Zb7+" +
       "VPwbgP21onD7jwAeEz7+gcn0Xd9tfXi7n1MwuDTNa7mKlq5st5YWlebrTa8/" +
       "s7b9ui7Dj/zg7k/c+dD+2tjdW4EPXfeIbK+9+YbJgekExRbH9FMv/+Tb/uUH" +
       "/qTYlvD/AXSP2TSfQQAA");
}
