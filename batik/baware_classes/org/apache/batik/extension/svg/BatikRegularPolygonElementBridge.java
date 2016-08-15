package org.apache.batik.extension.svg;
public class BatikRegularPolygonElementBridge extends org.apache.batik.bridge.SVGDecoratedShapeElementBridge implements org.apache.batik.extension.svg.BatikExtConstants {
    public BatikRegularPolygonElementBridge() { super(); }
    public java.lang.String getNamespaceURI() { return BATIK_EXT_NAMESPACE_URI;
    }
    public java.lang.String getLocalName() { return BATIK_EXT_REGULAR_POLYGON_TAG;
    }
    public org.apache.batik.bridge.Bridge getInstance() { return new org.apache.batik.extension.svg.BatikRegularPolygonElementBridge(
                                                            );
    }
    protected void buildShape(org.apache.batik.bridge.BridgeContext ctx,
                              org.w3c.dom.Element e,
                              org.apache.batik.gvt.ShapeNode shapeNode) {
        org.apache.batik.parser.UnitProcessor.Context uctx =
          org.apache.batik.bridge.UnitProcessor.
          createContext(
            ctx,
            e);
        java.lang.String s;
        s =
          e.
            getAttributeNS(
              null,
              SVG_CX_ATTRIBUTE);
        float cx =
          0;
        if (s.
              length(
                ) !=
              0) {
            cx =
              org.apache.batik.bridge.UnitProcessor.
                svgHorizontalCoordinateToUserSpace(
                  s,
                  SVG_CX_ATTRIBUTE,
                  uctx);
        }
        s =
          e.
            getAttributeNS(
              null,
              SVG_CY_ATTRIBUTE);
        float cy =
          0;
        if (s.
              length(
                ) !=
              0) {
            cy =
              org.apache.batik.bridge.UnitProcessor.
                svgVerticalCoordinateToUserSpace(
                  s,
                  SVG_CY_ATTRIBUTE,
                  uctx);
        }
        s =
          e.
            getAttributeNS(
              null,
              SVG_R_ATTRIBUTE);
        float r;
        if (s.
              length(
                ) !=
              0) {
            r =
              org.apache.batik.bridge.UnitProcessor.
                svgOtherLengthToUserSpace(
                  s,
                  SVG_R_ATTRIBUTE,
                  uctx);
        }
        else {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              e,
              ERR_ATTRIBUTE_MISSING,
              new java.lang.Object[] { SVG_R_ATTRIBUTE,
              s });
        }
        int sides =
          convertSides(
            e,
            BATIK_EXT_SIDES_ATTRIBUTE,
            3,
            ctx);
        java.awt.geom.GeneralPath gp =
          new java.awt.geom.GeneralPath(
          );
        for (int i =
               0;
             i <
               sides;
             i++) {
            double angle =
              (i +
                 0.5) *
              (2 *
                 java.lang.Math.
                   PI /
                 sides) -
              java.lang.Math.
                PI /
              2;
            double x =
              cx +
              r *
              java.lang.Math.
              cos(
                angle);
            double y =
              cy -
              r *
              java.lang.Math.
              sin(
                angle);
            if (i ==
                  0)
                gp.
                  moveTo(
                    (float)
                      x,
                    (float)
                      y);
            else
                gp.
                  lineTo(
                    (float)
                      x,
                    (float)
                      y);
        }
        gp.
          closePath(
            );
        shapeNode.
          setShape(
            gp);
    }
    protected static int convertSides(org.w3c.dom.Element filterElement,
                                      java.lang.String attrName,
                                      int defaultValue,
                                      org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String s =
          filterElement.
          getAttributeNS(
            null,
            attrName);
        if (s.
              length(
                ) ==
              0) {
            return defaultValue;
        }
        else {
            int ret =
              0;
            try {
                ret =
                  org.apache.batik.bridge.SVGUtilities.
                    convertSVGInteger(
                      s);
            }
            catch (java.lang.NumberFormatException nfEx) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  filterElement,
                  nfEx,
                  ERR_ATTRIBUTE_VALUE_MALFORMED,
                  new java.lang.Object[] { attrName,
                  s });
            }
            if (ret <
                  3)
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  filterElement,
                  ERR_ATTRIBUTE_VALUE_MALFORMED,
                  new java.lang.Object[] { attrName,
                  s });
            return ret;
        }
    }
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
       "6ZiGuwshXKxiZWEEYa0cNj3VRDW724NhCUeqQaU+CovMQJp3mX6kxCMZjeJ5" +
       "1VxGHbKCBXqDdMX6JME5HpSPyNjUZiOjG7K9BItVQoRX4/UoQatteCU0pHqh" +
       "VPfGPQsUxR7Y8L3hDdlW8M0vbjd+W37wcHDrBDbh2QD5Inah26EHsuahg8PK" +
       "/HNu/4Zi//voYeXhCdap/UMO5P9yMk+k0cFlY7Ylv+dat1D5dvzpdz35lDL4" +
       "eHFn78hwGkE3gVX9dbaaAFc85CG7cX3k2kcPdH4Jd3iU9aV3/cvdozcab30R" +
       "B/T3neDzJMnfoZ/5SufV8q/uQKcPDrauuB48jvTo8eOs84EaxYE7Onaodc+B" +
       "SW7PLPAAeEp7Jild/ZD8qu5zKnefrdNc50Q2vs7YKmv8CLqgqxEDuA6BodUx" +
       "R+X+duhqyxc68DhKN+9wjot4L3gaeyI2fvwivvM6Yz+fNW+PoFuAiH1Plmxm" +
       "zzpH5Hv8R5XvHvDs4W6/f7zy/cp1xt6fNU9E0M1Avn0n3A/ee68I3vn23m57" +
       "a3aogF/+ERRw677f0nsK6L0YBYDY9wMvUuVIVa6qh9N7J+p7Ij10fZH2/m6w" +
       "D31HBr0qy7uK5+zu3RheWzl6Eu3yhuSrYAun5sx89DqKfzprPhRB5+exaSs5" +
       "Xg7HH0nOkwg6k3imcqjpD/8Imn5F1vkQeN6zp+n3vAhN72Svv5EvNlfV85kc" +
       "6kz28zcPw+OEMKdNN7+W+lhO4nevo53fz5pnovyfGokaRLypbNXz2UNdfPLF" +
       "6CKNoPtf6Bo4u9O664r/qWz/WyF/6qkLN778qfFf5zehB/9/uKkP3QjKUPvo" +
       "FcSR93N+oGpmLtFN2wsJP//6/NX859jKCJQF2lyMP97iPBtBd18bBwTCwftR" +
       "rC9E0MWTWBF0Nv8+CvdF4ImHcBF0bvtyFOQrgCcAkr3+ub8fBtVrBRQvdFqq" +
       "7OU3Krl3H1N1eurISr3nqblRb38hox6gHL2IzVb3/H9I+ytxvP0n0mX50091" +
       "mbc9V/349iJYtqXNJqNyYx+6YXsnfbCaP3BNavu0zpEPP3/rZ256aL/yuHXL" +
       "8GHUHOHtvqvfuhKOH+X3pJs/fPnvvf63nvpmfvXyv/Uk6IwgJgAA");
}
