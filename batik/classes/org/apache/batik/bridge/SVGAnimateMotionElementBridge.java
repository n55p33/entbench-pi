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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "I1vabvDzfDR/8oJ2fSV/xKfN/wGIbJddRicAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "0u2ufzlw/8Whln/x1mv5pxe0/Vle/DFI");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("AAqYKk7zw4Lws2cB4LlDMY/ELUT8p4WIv54ceefzN1/zikPu8HCFzR12N8wt" +
       "I+6rRxH39f/HiMuLf1VMSl78+Y2hlf/8zbz4rQti5asFsz9/o1j59gVt/y0v" +
       "vpkXX9hJcgHtd04HypffAhfau2PXd/d9+y60d0LQLwi+e2tt9gqyvzzrR4UJ" +
       "TnR8/TZ0zF8BSj8IpLl2qOO1vxod9+6/QMf8ZsLeJZDyFTrSBcazolFcr/na" +
       "sZ57d9+Gnt93pOfzh3o+/2b1fMP3gb1HL2j73ry4ugO9KcjLAis1HL2YznNa" +
       "PnwbWj6YV/4AEBg+1BJ+a2bztCYXhPDes3lxDay0hmNExTJ6Ln8/t2jfuXUN" +
       "5UT1J9+M6klUeuLCy6v57bvHbrg/v7vzLX/mlcv3PPrK9N/vMrqje9n30qV7" +
       "tI1lnb4sder5kheomlFY6N7d1SmvUBuKSo/e4p0O5CzS8Vvd3sGOvhaVrpyn" +
       "B3lA8X2aDolK953QAVa7h9MkGMh8AEn+2PSOlgvojS/7nrFUsgPrx047VYEs" +
       "V99oQk5tvTxzJvsu/r3haHNjs/sHhxflz75CMj/+rcbP726fypaYZTmXe0Ci" +
       "vLsIe5gon76idJ7bEa9LxHOvP/ir9z57tJnz4E7gEwc/JduTN7/e2bO9qLiQ" +
       "mf3zR3/9h3/xlS8Xl8L+L8WYB7t3MgAA");
}
