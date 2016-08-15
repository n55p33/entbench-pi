package org.apache.batik.extension.svg;
public class BatikStarElementBridge extends org.apache.batik.bridge.SVGDecoratedShapeElementBridge implements org.apache.batik.extension.svg.BatikExtConstants {
    public BatikStarElementBridge() { super(); }
    public java.lang.String getNamespaceURI() { return BATIK_EXT_NAMESPACE_URI;
    }
    public java.lang.String getLocalName() { return BATIK_EXT_STAR_TAG; }
    public org.apache.batik.bridge.Bridge getInstance() { return new org.apache.batik.extension.svg.BatikStarElementBridge(
                                                            ); }
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
                ) ==
              0)
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              e,
              ERR_ATTRIBUTE_MISSING,
              new java.lang.Object[] { SVG_R_ATTRIBUTE,
              s });
        r =
          org.apache.batik.bridge.UnitProcessor.
            svgOtherLengthToUserSpace(
              s,
              SVG_R_ATTRIBUTE,
              uctx);
        s =
          e.
            getAttributeNS(
              null,
              BATIK_EXT_IR_ATTRIBUTE);
        float ir;
        if (s.
              length(
                ) ==
              0)
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              e,
              ERR_ATTRIBUTE_MISSING,
              new java.lang.Object[] { BATIK_EXT_IR_ATTRIBUTE,
              s });
        ir =
          org.apache.batik.bridge.UnitProcessor.
            svgOtherLengthToUserSpace(
              s,
              BATIK_EXT_IR_ATTRIBUTE,
              uctx);
        int sides =
          convertSides(
            e,
            BATIK_EXT_SIDES_ATTRIBUTE,
            3,
            ctx);
        java.awt.geom.GeneralPath gp =
          new java.awt.geom.GeneralPath(
          );
        double angle;
        double x;
        double y;
        final double SECTOR =
          2.0 *
          java.lang.Math.
            PI /
          sides;
        final double HALF_PI =
          java.lang.Math.
            PI /
          2.0;
        for (int i =
               0;
             i <
               sides;
             i++) {
            angle =
              i *
                SECTOR -
                HALF_PI;
            x =
              cx +
                ir *
                java.lang.Math.
                cos(
                  angle);
            y =
              cy -
                ir *
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
            angle =
              (i +
                 0.5) *
                SECTOR -
                HALF_PI;
            x =
              cx +
                r *
                java.lang.Math.
                cos(
                  angle);
            y =
              cy -
                r *
                java.lang.Math.
                sin(
                  angle);
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
      ("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" +
       "GHkl7/0r/smKd/4NlB21jagaAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "FNtCwet5MNbppFVtmETwGOmGEc9H60mlvxmjSeR1LWS21irRaiZzdtIJuu2u" +
       "MuG4sZQs2Sq9LmzYRg9nxguSMgCfiA8HFq3A5b7ZANujqIngDe+N2avfm1/a" +
       "2/ft+UHDwT0SeOnOJqiX8Na5nXowax4+OJzMP+f27xz2v48eTh6eWJ3aP9RA" +
       "/i/n7+0kPLg+zF7B773WvVL++v3su556RmE/WtzZOyKchtBNoeO+3lTXqnmE" +
       "h+wO9dFrHzX08mu1w6OrL7zrX+7hfnL51pdwIH//CT5Pkvyd3nNfIl8j/+oO" +
       "dPrgIOuKC7/jSI8dP74676th5NvcsUOsew9Mcsf+oTi6ZxL06ofiV3WfU7n7" +
       "bJ3mOiew0XXm4qxxQ+iCpoZ9wHUADK3yo07ub4eu5v2gA46jdPMB67iI94Gn" +
       "tidi7Ucv4juvM/dzWfP2ELoFiMg4smj296xzRL4nflj57gXPHu72+0cr369c" +
       "Z+59WfNkCN0M5Nt3wv3gve+K4JW2t3PbW7JDBfzSD6GA2/b9trenAPqlKADE" +
       "vus7oSqHqnJVPZzeO0HfE+nh64u09weCfeg7M+i4JO8qjrW7d0N4beVo63B3" +
       "vBRdte8oas7M09dR/LNZ88EQOi9FuqnkeDnc+EhynoTQmbWjK4ea/tAPoelX" +
       "ZoMPg+fpPU0//RI0vZN1fyPfbK6q5zM51Jns528ehscJYU7rdn4N9ZGcxO9e" +
       "Rzu/nzXPhfl/L9aqH451ZaueTx/q4uMvRRdJCN119cve7Obq7iv+b7L9j4T8" +
       "iWcu3PiKZ/i/zu87D/7HcBMD3biITPPoRcOR/jnXVxd6LsdN22sHN//67NW8" +
       "5th+CFQE2pz5P97iPB9C91wbB7j/Qf8o1udC6OJJrBA6m38fhfs88L9DuBA6" +
       "t+0cBfkS4AmAZN0/d/edv3qtMBoLZEuVnfzeJPfpY6pOTh3Zn/f8MzflHT/I" +
       "lAcoR69bsz09/z/R/v4bbf9RdFn+5DPd/tteqH50e90rm2KaZlRuZKAbtjfP" +
       "B3v4g9ektk/rHPXIi7d96qaH9+uN27YMH8bKEd7uv/rdattyw/w2NP3DV/ze" +
       "G37rma/nFyz/CwkkvqroJQAA");
}
