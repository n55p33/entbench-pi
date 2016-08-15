package org.apache.batik.bridge;
public class SVGPolygonElementBridge extends org.apache.batik.bridge.SVGDecoratedShapeElementBridge {
    protected static final java.awt.Shape DEFAULT_SHAPE = new java.awt.geom.GeneralPath(
      );
    public SVGPolygonElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_POLYGON_TAG;
    }
    public org.apache.batik.bridge.Bridge getInstance() { return new org.apache.batik.bridge.SVGPolygonElementBridge(
                                                            );
    }
    protected void buildShape(org.apache.batik.bridge.BridgeContext ctx,
                              org.w3c.dom.Element e,
                              org.apache.batik.gvt.ShapeNode shapeNode) {
        org.apache.batik.dom.svg.SVGOMPolygonElement pe =
          (org.apache.batik.dom.svg.SVGOMPolygonElement)
            e;
        try {
            org.apache.batik.dom.svg.SVGOMAnimatedPoints _points =
              pe.
              getSVGOMAnimatedPoints(
                );
            _points.
              check(
                );
            org.w3c.dom.svg.SVGPointList pl =
              _points.
              getAnimatedPoints(
                );
            int size =
              pl.
              getNumberOfItems(
                );
            if (size ==
                  0) {
                shapeNode.
                  setShape(
                    DEFAULT_SHAPE);
            }
            else {
                org.apache.batik.parser.AWTPolygonProducer app =
                  new org.apache.batik.parser.AWTPolygonProducer(
                  );
                app.
                  setWindingRule(
                    org.apache.batik.bridge.CSSUtilities.
                      convertFillRule(
                        e));
                app.
                  startPoints(
                    );
                for (int i =
                       0;
                     i <
                       size;
                     i++) {
                    org.w3c.dom.svg.SVGPoint p =
                      pl.
                      getItem(
                        i);
                    app.
                      point(
                        p.
                          getX(
                            ),
                        p.
                          getY(
                            ));
                }
                app.
                  endPoints(
                    );
                shapeNode.
                  setShape(
                    app.
                      getShape(
                        ));
            }
        }
        catch (org.apache.batik.dom.svg.LiveAttributeException ex) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              ex);
        }
    }
    public void handleAnimatedAttributeChanged(org.apache.batik.dom.svg.AnimatedLiveAttributeValue alav) {
        if (alav.
              getNamespaceURI(
                ) ==
              null) {
            java.lang.String ln =
              alav.
              getLocalName(
                );
            if (ln.
                  equals(
                    SVG_POINTS_ATTRIBUTE)) {
                buildShape(
                  ctx,
                  e,
                  (org.apache.batik.gvt.ShapeNode)
                    node);
                handleGeometryChanged(
                  );
                return;
            }
        }
        super.
          handleAnimatedAttributeChanged(
            alav);
    }
    protected void handleCSSPropertyChanged(int property) {
        switch (property) {
            case org.apache.batik.css.engine.SVGCSSEngine.
                   FILL_RULE_INDEX:
                buildShape(
                  ctx,
                  e,
                  (org.apache.batik.gvt.ShapeNode)
                    node);
                handleGeometryChanged(
                  );
                break;
            default:
                super.
                  handleCSSPropertyChanged(
                    property);
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1Ze4xUVxk/M8su+95leZbHAstCw2uGR2mli9hl2YXF2WXC" +
       "wiYuluHMnTMzl71z7+XeM7vDVhTaKGgiQUopmsIfhkpLoFRjo1VpMLWWhlrT" +
       "Fq3VlJrWRLQSS4zViFq/c869cx/zQBJxknvmzjnfeXzf+X2/7ztnzl5HlaaB" +
       "WolKQ3SPTsxQt0qj2DBJokvBprkV6mLS4xX4Lzuu9a8Ooqoh1JjGZp+ETdIj" +
       "EyVhDqFZsmpSrErE7CckwXpEDWISYwRTWVOH0GTZ7M3oiizJtE9LECYwiI0I" +
       "moApNeR4lpJeawCKZkVgJWG+knCnv7kjguolTd/jiE9ziXe5WphkxpnLpKg5" +
       "sguP4HCWyko4Ipu0I2egxbqm7EkpGg2RHA3tUlZZJtgUWVVggrZnmz66eTjd" +
       "zE0wEauqRrl65hZiasoISURQk1PbrZCMuRt9HlVEUJ1LmKL2iD1pGCYNw6S2" +
       "to4UrL6BqNlMl8bVofZIVbrEFkTRXO8gOjZwxhomytcMI1RTS3feGbSdk9dW" +
       "aFmg4mOLw0cf39H8nQrUNISaZHWALUeCRVCYZAgMSjJxYpidiQRJDKEJKmz2" +
       "ADFkrMhj1k63mHJKxTQL22+bhVVmdWLwOR1bwT6CbkZWopqRVy/JAWX9qkwq" +
       "OAW6TnF0FRr2sHpQsFaGhRlJDLizuowbltUERbP9PfI6tn8aBKDr+AyhaS0/" +
       "1TgVQwVqERBRsJoKDwD01BSIVmoAQIOi6SUHZbbWsTSMUyTGEOmTi4omkKrh" +
       "hmBdKJrsF+MjwS5N9+2Sa3+u96859JC6UQ2iAKw5QSSFrb8OOrX6Om0hSWIQ" +
       "8APRsX5R5BiecuFgECEQnuwTFjLf+9yNB5a0XrwkZGYUkdkc30UkGpNOxRtf" +
       "n9m1cHUFW0a1rpky23yP5tzLolZLR04HhpmSH5E1huzGi1t++pl9Z8gHQVTb" +
       "i6okTclmAEcTJC2jywoxNhCVGJiSRC+qIWqii7f3ovHwHpFVImo3J5Mmob1o" +
       "nMKrqjT+G0yUhCGYiWrhXVaTmv2uY5rm7zkdITQeHlQPzyIkPvybong4rWVI" +
       "GEtYlVUtHDU0pr8ZBsaJg23T4TigfjhsalkDIBjWjFQYAw7SxGqIG3IiRcID" +
       "gxuiTHVBCtB5Ha8PMazp/5dZckzXiaOBAGzDTD8JKOA/GzUlQYyYdDS7rvvG" +
       "M7HLAmDMKSwrUcQmDomJQ3zikJg4VGJiFAjw+SaxBYgthw0bBtcH7q1fOPDg" +
       "pp0H2yoAa/roOLA2E23zxKAuhx9sUo9J51saxuZeXf5iEI2LoBYs0SxWWEjp" +
       "NFJAVtKw5c/1cYhOTpCY4woSLLoZmkQSwFGlgoU1SrU2QgxWT9Ek1wh2CGPO" +
       "Gi4dQIquH108Prp/8AvLgijojQtsykqgNNY9ytg8z9rtfj4oNm7TgWsfnT+2" +
       "V3OYwRNo7PhY0JPp0OZHhN88MWnRHPxc7MLedm72GmBuisHTgBRb/XN4iKfD" +
       "JnGmSzUonNSMDFZYk23jWpo2tFGnhkN1An+fBLCoY57YBs8qyzX5N2udorNy" +
       "qoA2w5lPCx4kPjmgn/jVa39Yyc1tx5MmVyIwQGiHi8PYYC2crSY4sN1qEAJy" +
       "7xyPPvrY9QPbOWZBYl6xCdtZ2QXcBVsIZv7ipd1vv3v11JWgg3MKQTwbh1wo" +
       "l1eS1aPaMkrCbAuc9QAHKsAQDDXt21TAp5yUcVwhzLH+2TR/+XN/OtQscKBA" +
       "jQ2jJbcewKm/ax3ad3nH31r5MAGJxWDHZo6YIPaJzsidhoH3sHXk9r8x6+sv" +
       "4xMQIoCWTXmMcKZF3AaIb9oqrv8yXt7ja7uPFfNNN/i9/uXKlWLS4SsfNgx+" +
       "+MINvlpvsuXe6z6sdwh4sWJBDoaf6ienjdhMg9w9F/s/26xcvAkjDsGIEhCv" +
       "udkAisx5kGFJV47/9Y9fnLLz9QoU7EG1ioYTPZg7GaoBdBMzDeya0z/1gNjc" +
       "0WoomrmqqED5ggpm4NnFt647o1Nu7LHvT/3umtMnr3KU6WKMGXlWnelhVZ6y" +
       "O4595s37fnH6a8dGRdBfWJrNfP2m/WOzEn/4vb8XmJzzWJGExNd/KHz2ield" +
       "az/g/R1CYb3bc4VBCkjZ6bviTOavwbaql4Jo/BBqlqwUeRArWeamQ5AWmnbe" +
       "DGm0p92b4ol8piNPmDP9ZOaa1k9lTnCEdybN3ht87DWDbWEXPMssx17mZ68A" +
       "4i+9vMvdvFzEiqV8+yooqtENjcIqCaS1VSbPxymsRFax4iOQ6WXmoahhfXdP" +
       "57bI1tjAxs5oN+85jaJGjiw8SkMDaSx0mMjbPsGKTWKGjmLIFU13s2Jxfh38" +
       "U+VPpNxE5kATMf+bVSrX5Xn6qYePnkxsfnK5AGeLN3/shuPRuV/+69XQ8d++" +
       "UiRdqaGavlQhI0RxzckOurM87tDHjwEOtt5pPPL+8+2pdbeTX7C61ltkEOz3" +
       "bFBiUWkP8y/l5Yf/OH3r2vTO20gVZvvM6R/y6b6zr2xYIB0J8jOPAH3BWcnb" +
       "qcML9VqDwOFO3eoB/Lw8AFrYxrbCc78FgPuLh+si2MkHwVJdy4SLVJk2mRVx" +
       "iupTcCLQJKz0gzY2/ps5/hkZhMR5zwG/VAb8/wVts4pOndfv8JpnFjydlo6d" +
       "t2+eUl3LmGCkTBsvdlNUB+ax99y2TmuplF9k+I6tjDtgq0bWtgKefkvhSBlb" +
       "+YkzwF77fATZYA9SZDCfhSoE/dqGmF/eENYFiS09kUmPrpRCCS0Tss5EpU2a" +
       "GrHItx9oguv0pTLbdYgV+yiqjWdlJcH7mWXjdtSQM5DajlgXAeG9Le8OP3Ht" +
       "nKBUf5D2CZODR7/ycejQUUGv4mplXsHthruPuF7hK20Wxv8YPgF4/s0epgar" +
       "YN8QirusM/6c/CGfZS8GmltuWXyKnt+f3/vDp/YeCFpmGaJo3IgmJxxI7r8D" +
       "kOSHkaXwqBaKMrfvvpkSXX17HrDSNws2Kwtgw7BljqQgEZYzzHIRME/+upTn" +
       "Onwx3yyDpW+x4gRgMo3VhELskfKjdEF9iiSY1KOOYU/eKV9fDc+YZZ2xWxj2" +
       "kULPLtW1hGE9tw0swg9k4yb1OcCK6E7pYHv0d8Jb7irSQchNfir81cG3dr3K" +
       "Q3U1yw3yAdKVF0AO4TrjNrPiqLDQYdf7MYoqZIswvAue5J1fTL3+y00/OtxS" +
       "0QMJSy+qzqry7izpTXiD9ngzG3ctyLmFdEK4tRrmnBQFFoEf8upvl4HPBVac" +
       "pWiagE/XwEDU0Pg9b3HgnPtfACdH0dQSF07spDSt4IZb3MpKz5xsqp56cttb" +
       "PK/L35zWw24ls4rizuVd71W6QZIyV7ZeZPY6/3oJFlEiIkCSHneC40+E/CVI" +
       "NPzykMTzb7fcZeB1Rw6GEi9ukdcAHSDCXn+u2+xwb5mrufVE0ji18ljhMVgu" +
       "4E3H8zs1+VY75crg53lCD/8fwsZoVvwTEZPOn9zU/9CNe58UtzCSgsfG2Ch1" +
       "gExxIZRPYOeWHM0eq2rjwpuNz9bMt5l/gliwww8zXBCFHCmgM1xM911RmO35" +
       "m4q3T6154WcHq96AILcdBTCE7+2FR8ScnoWTw/ZIoQdCss/vTjoWfmPP2iXJ" +
       "P/+GH8JRwdHbLx+Trpx+8M0j0061BlFdL6qEoEZy/Oy6fo+6hUgjxhBqkM3u" +
       "HCwRRpGx4nHvRgZhzDJWbhfLnA35WnaHR1FbYbAuvPmsVbRRYqzTsmrCIog6" +
       "p8bzB4nlFrVZXfd1cGpcDPe84BQR7CtikT5dt4N/5dM6d+gf+GmOV/Le7/FX" +
       "Vrz/H750I82jHAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "QicAAA==");
}
