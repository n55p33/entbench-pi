package org.apache.batik.dom.svg;
public abstract class SVGPointShapeElement extends org.apache.batik.dom.svg.SVGGraphicsElement implements org.w3c.dom.svg.SVGAnimatedPoints {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGGraphicsElement.
                 xmlTraitInformation);
             t.put(null, SVG_POINTS_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_POINTS_VALUE));
             xmlTraitInformation = t; }
    protected org.apache.batik.dom.svg.SVGOMAnimatedPoints
      points;
    protected SVGPointShapeElement() { super(); }
    public SVGPointShapeElement(java.lang.String prefix, org.apache.batik.dom.AbstractDocument owner) {
        super(
          prefix,
          owner);
        initializeLiveAttributes(
          );
    }
    protected void initializeAllLiveAttributes() {
        super.
          initializeAllLiveAttributes(
            );
        initializeLiveAttributes(
          );
    }
    private void initializeLiveAttributes() { points =
                                                createLiveAnimatedPoints(
                                                  null,
                                                  SVG_POINTS_ATTRIBUTE,
                                                  "");
    }
    public org.apache.batik.dom.svg.SVGOMAnimatedPoints getSVGOMAnimatedPoints() {
        return points;
    }
    public org.w3c.dom.svg.SVGPointList getPoints() {
        return points.
          getPoints(
            );
    }
    public org.w3c.dom.svg.SVGPointList getAnimatedPoints() {
        return points.
          getAnimatedPoints(
            );
    }
    protected org.apache.batik.util.DoublyIndexedTable getTraitInformationTable() {
        return xmlTraitInformation;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "hLqsXnQ2ITNTw58fcXYf8ldoQuS/GrYSF+seAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
