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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "7O9+79965berw7T/C6m+1dSKKgAA");
}
