package org.apache.batik.bridge;
public class SVGLinearGradientElementBridge extends org.apache.batik.bridge.AbstractSVGGradientElementBridge {
    public SVGLinearGradientElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_LINEAR_GRADIENT_TAG;
    }
    protected java.awt.Paint buildGradient(org.w3c.dom.Element paintElement,
                                           org.w3c.dom.Element paintedElement,
                                           org.apache.batik.gvt.GraphicsNode paintedNode,
                                           org.apache.batik.ext.awt.MultipleGradientPaint.CycleMethodEnum spreadMethod,
                                           org.apache.batik.ext.awt.MultipleGradientPaint.ColorSpaceEnum colorSpace,
                                           java.awt.geom.AffineTransform transform,
                                           java.awt.Color[] colors,
                                           float[] offsets,
                                           org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String x1Str =
          org.apache.batik.bridge.SVGUtilities.
          getChainableAttributeNS(
            paintElement,
            null,
            SVG_X1_ATTRIBUTE,
            ctx);
        if (x1Str.
              length(
                ) ==
              0) {
            x1Str =
              SVG_LINEAR_GRADIENT_X1_DEFAULT_VALUE;
        }
        java.lang.String y1Str =
          org.apache.batik.bridge.SVGUtilities.
          getChainableAttributeNS(
            paintElement,
            null,
            SVG_Y1_ATTRIBUTE,
            ctx);
        if (y1Str.
              length(
                ) ==
              0) {
            y1Str =
              SVG_LINEAR_GRADIENT_Y1_DEFAULT_VALUE;
        }
        java.lang.String x2Str =
          org.apache.batik.bridge.SVGUtilities.
          getChainableAttributeNS(
            paintElement,
            null,
            SVG_X2_ATTRIBUTE,
            ctx);
        if (x2Str.
              length(
                ) ==
              0) {
            x2Str =
              SVG_LINEAR_GRADIENT_X2_DEFAULT_VALUE;
        }
        java.lang.String y2Str =
          org.apache.batik.bridge.SVGUtilities.
          getChainableAttributeNS(
            paintElement,
            null,
            SVG_Y2_ATTRIBUTE,
            ctx);
        if (y2Str.
              length(
                ) ==
              0) {
            y2Str =
              SVG_LINEAR_GRADIENT_Y2_DEFAULT_VALUE;
        }
        short coordSystemType;
        java.lang.String s =
          org.apache.batik.bridge.SVGUtilities.
          getChainableAttributeNS(
            paintElement,
            null,
            SVG_GRADIENT_UNITS_ATTRIBUTE,
            ctx);
        if (s.
              length(
                ) ==
              0) {
            coordSystemType =
              org.apache.batik.bridge.SVGUtilities.
                OBJECT_BOUNDING_BOX;
        }
        else {
            coordSystemType =
              org.apache.batik.bridge.SVGUtilities.
                parseCoordinateSystem(
                  paintElement,
                  SVG_GRADIENT_UNITS_ATTRIBUTE,
                  s,
                  ctx);
        }
        org.apache.batik.dom.svg.SVGContext bridge =
          org.apache.batik.bridge.BridgeContext.
          getSVGContext(
            paintedElement);
        if (coordSystemType ==
              org.apache.batik.bridge.SVGUtilities.
                OBJECT_BOUNDING_BOX &&
              bridge instanceof org.apache.batik.bridge.AbstractGraphicsNodeBridge) {
            java.awt.geom.Rectangle2D bbox =
              ((org.apache.batik.bridge.AbstractGraphicsNodeBridge)
                 bridge).
              getBBox(
                );
            if (bbox !=
                  null &&
                  bbox.
                  getWidth(
                    ) ==
                  0 ||
                  bbox.
                  getHeight(
                    ) ==
                  0) {
                return null;
            }
        }
        if (coordSystemType ==
              org.apache.batik.bridge.SVGUtilities.
                OBJECT_BOUNDING_BOX) {
            transform =
              org.apache.batik.bridge.SVGUtilities.
                toObjectBBox(
                  transform,
                  paintedNode);
        }
        org.apache.batik.parser.UnitProcessor.Context uctx =
          org.apache.batik.bridge.UnitProcessor.
          createContext(
            ctx,
            paintElement);
        java.awt.geom.Point2D p1 =
          org.apache.batik.bridge.SVGUtilities.
          convertPoint(
            x1Str,
            SVG_X1_ATTRIBUTE,
            y1Str,
            SVG_Y1_ATTRIBUTE,
            coordSystemType,
            uctx);
        java.awt.geom.Point2D p2 =
          org.apache.batik.bridge.SVGUtilities.
          convertPoint(
            x2Str,
            SVG_X2_ATTRIBUTE,
            y2Str,
            SVG_Y2_ATTRIBUTE,
            coordSystemType,
            uctx);
        if (p1.
              getX(
                ) ==
              p2.
              getX(
                ) &&
              p1.
              getY(
                ) ==
              p2.
              getY(
                )) {
            return colors[colors.
                            length -
                            1];
        }
        else {
            return new org.apache.batik.ext.awt.LinearGradientPaint(
              p1,
              p2,
              offsets,
              colors,
              spreadMethod,
              colorSpace,
              transform);
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "4siF7Tv8FZt3/w2XM2MPxx4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL16e+wr112n7y+5N7m3Se5NQh+EJmmaG0pq9je2x+OxCS2d" +
       "GXs8Y489Y489Yw+PdJ72eJ6et6cE0krQiopS7abQldpIu2phKaFFaBGLUFEQ" +
       "YqELi4Ctloe0lEVIPEql9g8eorzOjH/v+yhRBZbmeHzO93zP93U+5+tzzitf" +
       "qlwOg0rV9+zdyvaiQz2LDjc2chjtfD08HDAIJwehrhG2HIYzUPe8+tafuf43" +
       "X/3w+sZB5YpUeVR2XS+SI9Nzw6keenaia0zl+mltz9adMKrcYDZyIkNxZNoQ" +
       "Y4bRc0zldWe6RpWbzLEIEBABAiJApQgQdkoFOj2ou7FDFD1kNwq3le+rXGIq" +
       "V3y1EC+qPHWeiS8HsnPEhis1ABzuL34LQKmycxZU3nKi+17nWxT+SBV66ce+" +
       "58bP3lO5LlWumy5fiKMCISIwiFR5wNEdRQ9CTNN0Tao87Oq6xuuBKdtmXsot" +
       "VR4JzZUrR3GgnxipqIx9PSjHPLXcA2qhWxCrkRecqGeYuq0d/7ps2PIK6PqG" +
       "U133GpJFPVDwmgkECwxZ1Y+73GuZrhZVnrzY40THm0NAALre5+jR2jsZ6l5X" +
       "BhWVR/a+s2V3BfFRYLorQHrZi8EoUeWxOzItbO3LqiWv9Oejypsu0nH7JkB1" +
       "tTRE0SWqvP4iWckJeOmxC146458vjb/9Q+9xKfeglFnTVbuQ/37Q6YkLnaa6" +
       "oQe6q+r7jg+8nflR+Q2f/cBBpQKIX3+BeE/z89/7lXd96xOv/vqe5ptuQ8Mq" +
       "G12Nnlc/oTz0O28mnu3cU4hxv++FZuH8c5qX4c8dtTyX+WDmveGEY9F4eNz4" +
       "6vR/Ll/8lP7Fg8o1unJF9ezYAXH0sOo5vmnrQV939UCOdI2uXNVdjSjb6cp9" +
       "4J0xXX1fyxpGqEd05V67rLrilb+BiQzAojDRfeDddA3v+N2Xo3X5nvmVSuU+" +
       "8FQeAM+3VPaf8juqmNDac3RIVmXXdD2IC7xC/xDS3UgBtl1DCoh6Cwq9OAAh" +
       "CHnBCpJBHKz1owYlMLWVDvFCvxBVDvqBrJmgc4EU4Asvmw+LkPP/PQfLCs1v" +
       "pJcuAae8+SIk2GA2UZ6t6cHz6ksx3vvKp5//jYOTKXJks6jSAuMf7sc/LMc/" +
       "3I9/ePfxK5culcN+QyHHPg4AtQXwACDlA8/y3z149wfeeg8IQD+9F7igIIXu" +
       "DNjEKYLQJU6qIIwrr340fa/w/bWDysF55C1kB1XXiu5cgZcnuHjz4oy7Hd/r" +
       "7//zv/nMj77gnc69c1B+BAm39iym9FsvWjnwVF0DIHnK/u1vkX/u+c++cPOg" +
       "ci/ACYCNkQzMCGDniYtjnJvazx3DZKHLZaCw4QWObBdNx9h2LVoHXnpaU7r/" +
       "ofL9YWDj1xWx/ix4Do+Cv/wuWh/1i/Ib9uFSOO2CFiUMv4P3P/77v/UXcGnu" +
       "Y8S+fmYN5PXouTMoUTC7XuLBw6cxMAt0HdD9v49y/+kjX3r/d5YBACievt2A" +
       "N4uSAOgAXAjM/AO/vv2DL/zRJz5/cBo0EVgmY8U21exEyaK+cu0uSoLRvvlU" +
       "HoAyNph8RdTcnLuOp5mGKSu2XkTpP1x/pv5zf/WhG/s4sEHNcRh969dmcFr/" +
       "jXjlxd/4nr99omRzSS1WuVObnZLtofPRU85YEMi7Qo7svb/7+H/+NfnjAIQB" +
       "8IVmrpdYViltUCmdBpX6v70sDy+01YviyfBs8J+fX2eykefVD3/+yw8KX/6l" +
       "r5TSnk9nzvp6JPvP7cOrKN6SAfZvvDjTKTlcA7rmq+PvumG/+lXAUQIcVYBp" +
       "IRsA2MnORcYR9eX7/vCXf+UN7/6deyoHZOWa7ckaKZeTrHIVRLcergFiZf53" +
       "vGvv3PR+UNwoVa3covw+KN5U/roHCPjsnfGFLLKR0yn6pr9nbeV9f/J3txih" +
       "RJbbLMIX+kvQKx97jHjnF8v+p1O86P1EdisUg8zttG/jU85fH7z1yq8eVO6T" +
       "KjfUo7RQkO24mDgSSIXC41wRpI7n2s+nNfs1/LkTCHvzRXg5M+xFcDldAsB7" +
       "QV28XzuLJ/8MPpfA80/FU5i7qNgvpo8QRyv6W06WdN/PLoHZerlxiB7Wiv7f" +
       "UXJ5qixvFsXb9m4qXr8FTOuwzEdBD8N0Zbsc+F0RCDFbvXnMXQD5KfDJzY2N" +
       "lmxeDzLyMpwK7Q/3Sd0e0IqyUbLYhwRyx/D5tj1VuXI9dMqM8UB++ME//fBv" +
       "/sjTXwA+HVQuJ4W9gSvPjDiOi5T5B1/5yOOve+mPP1iiFIAo4cVnvvhiwZW5" +
       "m8ZF0SsK8ljVxwpV+TIFYOQwGpXAomultncNZS4wHYC/yVE+CL3wyBesj/35" +
       "T+9zvYtxe4FY/8BLP/TPhx966eBMhv30LUnu2T77LLsU+sEjCweVp+42StmD" +
       "/LPPvPCL/+2F9++leuR8vtgDf4d++v/+428efvSPP3ebhORe2/s6HBtd/22q" +
       "GdLY8YepSwSCqdOpGzfgxIK37Tah2IwaOBihYMy6r2pTorXg4WGq1e28yaeJ" +
       "NYJDhYV0pC+5a9/VY7S+Qvqkj9mitVylk+HMDAY4scIsckjik5QPnU0v6NEM" +
       "0iMMsjuc1HzedsyBmUAGp3B5o6f1LLkhw5EbJxAUQ9CiY0Cqbgw6c3Gn+D7u" +
       "MeHO6YoxWd2oc6vWYgacLe4CGp6QiJYE0qyacG7kTaKu35fnY7ozqG+xUFzw" +
       "40kkWuO51yJHddMypZnc3PCDUYt2NN5EvFmPJGvKQBkJ8g7fbOltGPZ6HV4i" +
       "V9PucOP36mZOTnhxvqQUTB5pvel6kPWrVm2dqMzK5de+DUvr3U7XkB0Xtuma" +
       "Kamavuv3nbHizx2/Z4pD0bO2YOkcNHS+lmaaO98G7CqZUViUCGq1LixwvzNO" +
       "CXIx6TQ4Zj1FE0oMrKFkbWV/M4rdQMTFwGtNpPG0FjONzjasLet1MrHordea" +
       "4ZN2RmudqTTGhszUwafT+nZBuIoxZYTQtyC3uSGoebO2bjaXS1HP3KVlOjZD" +
       "SRln6qv5KAobC9eqUfJ0YftraULSEdIWnRmwaaRQLc9iZNaaav2+Ogt3Cs3g" +
       "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" +
       "KgAA");
}
