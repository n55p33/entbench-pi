package org.apache.batik.bridge;
public class SVGAnimateMotionElementBridge extends org.apache.batik.bridge.SVGAnimateElementBridge {
    public java.lang.String getLocalName() { return SVG_ANIMATE_MOTION_TAG;
    }
    public org.apache.batik.bridge.Bridge getInstance() { return new org.apache.batik.bridge.SVGAnimateMotionElementBridge(
                                                            ); }
    protected org.apache.batik.anim.AbstractAnimation createAnimation(org.apache.batik.dom.anim.AnimationTarget target) {
        animationType =
          org.apache.batik.anim.AnimationEngine.
            ANIM_TYPE_OTHER;
        attributeLocalName =
          "motion";
        org.apache.batik.anim.values.AnimatableValue from =
          parseLengthPair(
            SVG_FROM_ATTRIBUTE);
        org.apache.batik.anim.values.AnimatableValue to =
          parseLengthPair(
            SVG_TO_ATTRIBUTE);
        org.apache.batik.anim.values.AnimatableValue by =
          parseLengthPair(
            SVG_BY_ATTRIBUTE);
        boolean rotateAuto =
          false;
        boolean rotateAutoReverse =
          false;
        float rotateAngle =
          0;
        short rotateAngleUnit =
          org.w3c.dom.svg.SVGAngle.
            SVG_ANGLETYPE_UNKNOWN;
        java.lang.String rotateString =
          element.
          getAttributeNS(
            null,
            SVG_ROTATE_ATTRIBUTE);
        if (rotateString.
              length(
                ) !=
              0) {
            if (rotateString.
                  equals(
                    "auto")) {
                rotateAuto =
                  true;
            }
            else
                if (rotateString.
                      equals(
                        "auto-reverse")) {
                    rotateAuto =
                      true;
                    rotateAutoReverse =
                      true;
                }
                else {
                    class Handler implements org.apache.batik.parser.AngleHandler {
                        float
                          theAngle;
                        short
                          theUnit =
                          org.w3c.dom.svg.SVGAngle.
                            SVG_ANGLETYPE_UNSPECIFIED;
                        public void startAngle()
                              throws org.apache.batik.parser.ParseException {
                            
                        }
                        public void angleValue(float v)
                              throws org.apache.batik.parser.ParseException {
                            theAngle =
                              v;
                        }
                        public void deg()
                              throws org.apache.batik.parser.ParseException {
                            theUnit =
                              org.w3c.dom.svg.SVGAngle.
                                SVG_ANGLETYPE_DEG;
                        }
                        public void grad()
                              throws org.apache.batik.parser.ParseException {
                            theUnit =
                              org.w3c.dom.svg.SVGAngle.
                                SVG_ANGLETYPE_GRAD;
                        }
                        public void rad()
                              throws org.apache.batik.parser.ParseException {
                            theUnit =
                              org.w3c.dom.svg.SVGAngle.
                                SVG_ANGLETYPE_RAD;
                        }
                        public void endAngle()
                              throws org.apache.batik.parser.ParseException {
                            
                        }
                        public Handler() {
                            super(
                              );
                        }
                    }
                    ;
                    org.apache.batik.parser.AngleParser ap =
                      new org.apache.batik.parser.AngleParser(
                      );
                    Handler h =
                      new Handler(
                      );
                    ap.
                      setAngleHandler(
                        h);
                    try {
                        ap.
                          parse(
                            rotateString);
                    }
                    catch (org.apache.batik.parser.ParseException pEx) {
                        throw new org.apache.batik.bridge.BridgeException(
                          ctx,
                          element,
                          pEx,
                          org.apache.batik.bridge.ErrorConstants.
                            ERR_ATTRIBUTE_VALUE_MALFORMED,
                          new java.lang.Object[] { SVG_ROTATE_ATTRIBUTE,
                          rotateString });
                    }
                    rotateAngle =
                      h.
                        theAngle;
                    rotateAngleUnit =
                      h.
                        theUnit;
                }
        }
        return new org.apache.batik.anim.MotionAnimation(
          timedElement,
          this,
          parseCalcMode(
            ),
          parseKeyTimes(
            ),
          parseKeySplines(
            ),
          parseAdditive(
            ),
          parseAccumulate(
            ),
          parseValues(
            ),
          from,
          to,
          by,
          parsePath(
            ),
          parseKeyPoints(
            ),
          rotateAuto,
          rotateAutoReverse,
          rotateAngle,
          rotateAngleUnit);
    }
    protected org.apache.batik.ext.awt.geom.ExtendedGeneralPath parsePath() {
        org.w3c.dom.Node n =
          element.
          getFirstChild(
            );
        while (n !=
                 null) {
            if (n.
                  getNodeType(
                    ) ==
                  org.w3c.dom.Node.
                    ELEMENT_NODE &&
                  SVG_NAMESPACE_URI.
                  equals(
                    n.
                      getNamespaceURI(
                        )) &&
                  SVG_MPATH_TAG.
                  equals(
                    n.
                      getLocalName(
                        ))) {
                java.lang.String uri =
                  org.apache.batik.dom.util.XLinkSupport.
                  getXLinkHref(
                    (org.w3c.dom.Element)
                      n);
                org.w3c.dom.Element path =
                  ctx.
                  getReferencedElement(
                    element,
                    uri);
                if (!SVG_NAMESPACE_URI.
                      equals(
                        path.
                          getNamespaceURI(
                            )) ||
                      !SVG_PATH_TAG.
                      equals(
                        path.
                          getLocalName(
                            ))) {
                    throw new org.apache.batik.bridge.BridgeException(
                      ctx,
                      element,
                      org.apache.batik.bridge.ErrorConstants.
                        ERR_URI_BAD_TARGET,
                      new java.lang.Object[] { uri });
                }
                org.apache.batik.dom.svg.SVGOMPathElement pathElt =
                  (org.apache.batik.dom.svg.SVGOMPathElement)
                    path;
                org.apache.batik.parser.AWTPathProducer app =
                  new org.apache.batik.parser.AWTPathProducer(
                  );
                org.apache.batik.dom.svg.SVGAnimatedPathDataSupport.
                  handlePathSegList(
                    pathElt.
                      getPathSegList(
                        ),
                    app);
                return (org.apache.batik.ext.awt.geom.ExtendedGeneralPath)
                         app.
                         getShape(
                           );
            }
            n =
              n.
                getNextSibling(
                  );
        }
        java.lang.String pathString =
          element.
          getAttributeNS(
            null,
            SVG_PATH_ATTRIBUTE);
        if (pathString.
              length(
                ) ==
              0) {
            return null;
        }
        try {
            org.apache.batik.parser.AWTPathProducer app =
              new org.apache.batik.parser.AWTPathProducer(
              );
            org.apache.batik.parser.PathParser pp =
              new org.apache.batik.parser.PathParser(
              );
            pp.
              setPathHandler(
                app);
            pp.
              parse(
                pathString);
            return (org.apache.batik.ext.awt.geom.ExtendedGeneralPath)
                     app.
                     getShape(
                       );
        }
        catch (org.apache.batik.parser.ParseException pEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              element,
              pEx,
              org.apache.batik.bridge.ErrorConstants.
                ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_PATH_ATTRIBUTE,
              pathString });
        }
    }
    protected float[] parseKeyPoints() { java.lang.String keyPointsString =
                                           element.
                                           getAttributeNS(
                                             null,
                                             SVG_KEY_POINTS_ATTRIBUTE);
                                         int len = keyPointsString.
                                           length(
                                             );
                                         if (len == 0) { return null;
                                         }
                                         java.util.List keyPoints =
                                           new java.util.ArrayList(
                                           7);
                                         int i = 0;
                                         int start = 0;
                                         int end;
                                         char c;
                                         outer: while (i <
                                                         len) {
                                             while (keyPointsString.
                                                      charAt(
                                                        i) ==
                                                      ' ') {
                                                 i++;
                                                 if (i ==
                                                       len) {
                                                     break outer;
                                                 }
                                             }
                                             start =
                                               i++;
                                             if (i !=
                                                   len) {
                                                 c =
                                                   keyPointsString.
                                                     charAt(
                                                       i);
                                                 while (c !=
                                                          ' ' &&
                                                          c !=
                                                          ';' &&
                                                          c !=
                                                          ',') {
                                                     i++;
                                                     if (i ==
                                                           len) {
                                                         break;
                                                     }
                                                     c =
                                                       keyPointsString.
                                                         charAt(
                                                           i);
                                                 }
                                             }
                                             end =
                                               i++;
                                             try {
                                                 float keyPointCoord =
                                                   java.lang.Float.
                                                   parseFloat(
                                                     keyPointsString.
                                                       substring(
                                                         start,
                                                         end));
                                                 keyPoints.
                                                   add(
                                                     new java.lang.Float(
                                                       keyPointCoord));
                                             }
                                             catch (java.lang.NumberFormatException nfEx) {
                                                 throw new org.apache.batik.bridge.BridgeException(
                                                   ctx,
                                                   element,
                                                   nfEx,
                                                   org.apache.batik.bridge.ErrorConstants.
                                                     ERR_ATTRIBUTE_VALUE_MALFORMED,
                                                   new java.lang.Object[] { SVG_KEY_POINTS_ATTRIBUTE,
                                                   keyPointsString });
                                             }
                                         }
                                         len =
                                           keyPoints.
                                             size(
                                               );
                                         float[] ret =
                                           new float[len];
                                         for (int j =
                                                0;
                                              j <
                                                len;
                                              j++) {
                                             ret[j] =
                                               ((java.lang.Float)
                                                  keyPoints.
                                                  get(
                                                    j)).
                                                 floatValue(
                                                   );
                                         }
                                         return ret;
    }
    protected int getDefaultCalcMode() { return org.apache.batik.anim.MotionAnimation.
                                                  CALC_MODE_PACED;
    }
    protected org.apache.batik.anim.values.AnimatableValue[] parseValues() {
        java.lang.String valuesString =
          element.
          getAttributeNS(
            null,
            SVG_VALUES_ATTRIBUTE);
        int len =
          valuesString.
          length(
            );
        if (len ==
              0) {
            return null;
        }
        return parseValues(
                 valuesString);
    }
    protected org.apache.batik.anim.values.AnimatableValue[] parseValues(java.lang.String s) {
        try {
            org.apache.batik.parser.LengthPairListParser lplp =
              new org.apache.batik.parser.LengthPairListParser(
              );
            org.apache.batik.parser.LengthArrayProducer lap =
              new org.apache.batik.parser.LengthArrayProducer(
              );
            lplp.
              setLengthListHandler(
                lap);
            lplp.
              parse(
                s);
            short[] types =
              lap.
              getLengthTypeArray(
                );
            float[] values =
              lap.
              getLengthValueArray(
                );
            org.apache.batik.anim.values.AnimatableValue[] ret =
              new org.apache.batik.anim.values.AnimatableValue[types.
                                                                 length /
                                                                 2];
            for (int i =
                   0;
                 i <
                   types.
                     length;
                 i +=
                   2) {
                float x =
                  animationTarget.
                  svgToUserSpace(
                    values[i],
                    types[i],
                    org.apache.batik.dom.anim.AnimationTarget.
                      PERCENTAGE_VIEWPORT_WIDTH);
                float y =
                  animationTarget.
                  svgToUserSpace(
                    values[i +
                             1],
                    types[i +
                            1],
                    org.apache.batik.dom.anim.AnimationTarget.
                      PERCENTAGE_VIEWPORT_HEIGHT);
                ret[i /
                      2] =
                  new org.apache.batik.anim.values.AnimatableMotionPointValue(
                    animationTarget,
                    x,
                    y,
                    0);
            }
            return ret;
        }
        catch (org.apache.batik.parser.ParseException pEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              element,
              pEx,
              org.apache.batik.bridge.ErrorConstants.
                ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_VALUES_ATTRIBUTE,
              s });
        }
    }
    protected org.apache.batik.anim.values.AnimatableValue parseLengthPair(java.lang.String ln) {
        java.lang.String s =
          element.
          getAttributeNS(
            null,
            ln);
        if (s.
              length(
                ) ==
              0) {
            return null;
        }
        return parseValues(
                 s)[0];
    }
    public org.apache.batik.anim.values.AnimatableValue getUnderlyingValue() {
        return new org.apache.batik.anim.values.AnimatableMotionPointValue(
          animationTarget,
          0.0F,
          0.0F,
          0.0F);
    }
    protected void initializeAnimation() {
        java.lang.String uri =
          org.apache.batik.dom.util.XLinkSupport.
          getXLinkHref(
            element);
        org.w3c.dom.Node t;
        if (uri.
              length(
                ) ==
              0) {
            t =
              element.
                getParentNode(
                  );
        }
        else {
            t =
              ctx.
                getReferencedElement(
                  element,
                  uri);
            if (t.
                  getOwnerDocument(
                    ) !=
                  element.
                  getOwnerDocument(
                    )) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  element,
                  org.apache.batik.bridge.ErrorConstants.
                    ERR_URI_BAD_TARGET,
                  new java.lang.Object[] { uri });
            }
        }
        animationTarget =
          null;
        if (t instanceof org.apache.batik.dom.svg.SVGOMElement) {
            targetElement =
              (org.apache.batik.dom.svg.SVGOMElement)
                t;
            animationTarget =
              targetElement;
        }
        if (animationTarget ==
              null) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              element,
              org.apache.batik.bridge.ErrorConstants.
                ERR_URI_BAD_TARGET,
              new java.lang.Object[] { uri });
        }
        timedElement =
          createTimedElement(
            );
        animation =
          createAnimation(
            animationTarget);
        eng.
          addAnimation(
            animationTarget,
            org.apache.batik.anim.AnimationEngine.
              ANIM_TYPE_OTHER,
            attributeNamespaceURI,
            attributeLocalName,
            animation);
    }
    public SVGAnimateMotionElementBridge() {
        super(
          );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "I1t6hcHP89H8yQva9ZX8EZ82/wcttivbRicAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "ll++3fUvB+4/P9Tyz99+Lf/kgrY/zYs/");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("AglAAVPFaX5YEH7uLAA8dyjmkbiFiP+0EPHXkiPvfP7ma15xyB0errC5w+6G" +
       "uWXEfe0o4t74f4y4vPhXxaTkxZ/dGFr5z9/Ii9+8IFa+VjD7szeLlW9f0Pbf" +
       "8uKbefHFnSQX0H7ndKB85W1wob07dn1337fvQnsnBL2C4Hu31mavIPuLs35U" +
       "mOBEx+/eho75K0Dph4E01w51vPaXo+Pe/RfomN9M2LsEUr5CR6bAeE4yi+s1" +
       "Xz/Wc+/u29DzB470fP5Qz+ffqp5v+j6w9+gFbd+fF1d3oDcBeVlgp6ZrFNN5" +
       "TsuHb0PLB/PKHwICw4dawm/PbJ7W5IIQ3ns2L66BldZ0zahYRs/l7+cW7Tu3" +
       "nqmeqP7kW1E9iUpPXHh5Nb9999gN9+d3d76Vz756+Z5HX538+11Gd3Qv+16m" +
       "dI++se3Tl6VOPV/yA003Cwvdu7s65RdqQ1Hp0Vu804GcRT5+q9s72NHXotKV" +
       "8/QgDyi+T9MhUem+EzrAavdwmgQDmQ8gyR+b/tFyAb35Zd8zlkp2YP3Yaacq" +
       "kOXqm03Iqa2XZ85k38W/Nxxtbmx2/+DwovK5Vyn2p77V+IXd7VPFlrIs53IP" +
       "SJR3F2EPE+XTV5TOczvidYl87rsP/sq9zx5t5jy4E/jEwU/J9uTNr3fijh8V" +
       "FzKzf/7or/3oL736leJS2P8FIsk+ZHcyAAA=");
}
