package org.apache.batik.svggen;
public class SVGArc extends org.apache.batik.svggen.SVGGraphicObjectConverter {
    private org.apache.batik.svggen.SVGLine svgLine;
    private org.apache.batik.svggen.SVGEllipse svgEllipse;
    public SVGArc(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          generatorContext);
    }
    public org.w3c.dom.Element toSVG(java.awt.geom.Arc2D arc) { double ext =
                                                                  arc.
                                                                  getAngleExtent(
                                                                    );
                                                                double width =
                                                                  arc.
                                                                  getWidth(
                                                                    );
                                                                double height =
                                                                  arc.
                                                                  getHeight(
                                                                    );
                                                                if (width ==
                                                                      0 ||
                                                                      height ==
                                                                      0) {
                                                                    java.awt.geom.Line2D line =
                                                                      new java.awt.geom.Line2D.Double(
                                                                      arc.
                                                                        getX(
                                                                          ),
                                                                      arc.
                                                                        getY(
                                                                          ),
                                                                      arc.
                                                                        getX(
                                                                          ) +
                                                                        width,
                                                                      arc.
                                                                        getY(
                                                                          ) +
                                                                        height);
                                                                    if (svgLine ==
                                                                          null) {
                                                                        svgLine =
                                                                          new org.apache.batik.svggen.SVGLine(
                                                                            generatorContext);
                                                                    }
                                                                    return svgLine.
                                                                      toSVG(
                                                                        line);
                                                                }
                                                                if (ext >=
                                                                      360 ||
                                                                      ext <=
                                                                      -360) {
                                                                    java.awt.geom.Ellipse2D ellipse =
                                                                      new java.awt.geom.Ellipse2D.Double(
                                                                      arc.
                                                                        getX(
                                                                          ),
                                                                      arc.
                                                                        getY(
                                                                          ),
                                                                      width,
                                                                      height);
                                                                    if (svgEllipse ==
                                                                          null) {
                                                                        svgEllipse =
                                                                          new org.apache.batik.svggen.SVGEllipse(
                                                                            generatorContext);
                                                                    }
                                                                    return svgEllipse.
                                                                      toSVG(
                                                                        ellipse);
                                                                }
                                                                org.w3c.dom.Element svgPath =
                                                                  generatorContext.
                                                                    domFactory.
                                                                  createElementNS(
                                                                    SVG_NAMESPACE_URI,
                                                                    SVG_PATH_TAG);
                                                                java.lang.StringBuffer d =
                                                                  new java.lang.StringBuffer(
                                                                  64);
                                                                java.awt.geom.Point2D startPt =
                                                                  arc.
                                                                  getStartPoint(
                                                                    );
                                                                java.awt.geom.Point2D endPt =
                                                                  arc.
                                                                  getEndPoint(
                                                                    );
                                                                int type =
                                                                  arc.
                                                                  getArcType(
                                                                    );
                                                                d.
                                                                  append(
                                                                    PATH_MOVE);
                                                                d.
                                                                  append(
                                                                    doubleString(
                                                                      startPt.
                                                                        getX(
                                                                          )));
                                                                d.
                                                                  append(
                                                                    SPACE);
                                                                d.
                                                                  append(
                                                                    doubleString(
                                                                      startPt.
                                                                        getY(
                                                                          )));
                                                                d.
                                                                  append(
                                                                    SPACE);
                                                                d.
                                                                  append(
                                                                    PATH_ARC);
                                                                d.
                                                                  append(
                                                                    doubleString(
                                                                      width /
                                                                        2));
                                                                d.
                                                                  append(
                                                                    SPACE);
                                                                d.
                                                                  append(
                                                                    doubleString(
                                                                      height /
                                                                        2));
                                                                d.
                                                                  append(
                                                                    SPACE);
                                                                d.
                                                                  append(
                                                                    '0');
                                                                d.
                                                                  append(
                                                                    SPACE);
                                                                if (ext >
                                                                      0) {
                                                                    if (ext >
                                                                          180)
                                                                        d.
                                                                          append(
                                                                            '1');
                                                                    else
                                                                        d.
                                                                          append(
                                                                            '0');
                                                                    d.
                                                                      append(
                                                                        SPACE);
                                                                    d.
                                                                      append(
                                                                        '0');
                                                                }
                                                                else {
                                                                    if (ext <
                                                                          -180)
                                                                        d.
                                                                          append(
                                                                            '1');
                                                                    else
                                                                        d.
                                                                          append(
                                                                            '0');
                                                                    d.
                                                                      append(
                                                                        SPACE);
                                                                    d.
                                                                      append(
                                                                        '1');
                                                                }
                                                                d.
                                                                  append(
                                                                    SPACE);
                                                                d.
                                                                  append(
                                                                    doubleString(
                                                                      endPt.
                                                                        getX(
                                                                          )));
                                                                d.
                                                                  append(
                                                                    SPACE);
                                                                d.
                                                                  append(
                                                                    doubleString(
                                                                      endPt.
                                                                        getY(
                                                                          )));
                                                                if (type ==
                                                                      java.awt.geom.Arc2D.
                                                                        CHORD) {
                                                                    d.
                                                                      append(
                                                                        PATH_CLOSE);
                                                                }
                                                                else
                                                                    if (type ==
                                                                          java.awt.geom.Arc2D.
                                                                            PIE) {
                                                                        double cx =
                                                                          arc.
                                                                          getX(
                                                                            ) +
                                                                          width /
                                                                          2;
                                                                        double cy =
                                                                          arc.
                                                                          getY(
                                                                            ) +
                                                                          height /
                                                                          2;
                                                                        d.
                                                                          append(
                                                                            PATH_LINE_TO);
                                                                        d.
                                                                          append(
                                                                            SPACE);
                                                                        d.
                                                                          append(
                                                                            doubleString(
                                                                              cx));
                                                                        d.
                                                                          append(
                                                                            SPACE);
                                                                        d.
                                                                          append(
                                                                            doubleString(
                                                                              cy));
                                                                        d.
                                                                          append(
                                                                            SPACE);
                                                                        d.
                                                                          append(
                                                                            PATH_CLOSE);
                                                                    }
                                                                svgPath.
                                                                  setAttributeNS(
                                                                    null,
                                                                    SVG_D_ATTRIBUTE,
                                                                    d.
                                                                      toString(
                                                                        ));
                                                                return svgPath;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "AAA=");
}
