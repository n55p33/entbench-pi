package org.apache.batik.bridge;
public class SVGTextPathElementBridge extends org.apache.batik.bridge.AnimatableGenericSVGBridge implements org.apache.batik.bridge.ErrorConstants {
    public SVGTextPathElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_TEXT_PATH_TAG; }
    public void handleElement(org.apache.batik.bridge.BridgeContext ctx, org.w3c.dom.Element e) {
        
    }
    public org.apache.batik.gvt.text.TextPath createTextPath(org.apache.batik.bridge.BridgeContext ctx,
                                                             org.w3c.dom.Element textPathElement) {
        java.lang.String uri =
          org.apache.batik.dom.util.XLinkSupport.
          getXLinkHref(
            textPathElement);
        org.w3c.dom.Element pathElement =
          ctx.
          getReferencedElement(
            textPathElement,
            uri);
        if (pathElement ==
              null ||
              !SVG_NAMESPACE_URI.
              equals(
                pathElement.
                  getNamespaceURI(
                    )) ||
              !pathElement.
              getLocalName(
                ).
              equals(
                SVG_PATH_TAG)) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              textPathElement,
              ERR_URI_BAD_TARGET,
              new java.lang.Object[] { uri });
        }
        java.lang.String s =
          pathElement.
          getAttributeNS(
            null,
            SVG_D_ATTRIBUTE);
        java.awt.Shape pathShape =
          null;
        if (s.
              length(
                ) !=
              0) {
            org.apache.batik.parser.AWTPathProducer app =
              new org.apache.batik.parser.AWTPathProducer(
              );
            app.
              setWindingRule(
                org.apache.batik.bridge.CSSUtilities.
                  convertFillRule(
                    pathElement));
            try {
                org.apache.batik.parser.PathParser pathParser =
                  new org.apache.batik.parser.PathParser(
                  );
                pathParser.
                  setPathHandler(
                    app);
                pathParser.
                  parse(
                    s);
            }
            catch (org.apache.batik.parser.ParseException pEx) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  pathElement,
                  pEx,
                  ERR_ATTRIBUTE_VALUE_MALFORMED,
                  new java.lang.Object[] { SVG_D_ATTRIBUTE });
            }
            finally {
                pathShape =
                  app.
                    getShape(
                      );
            }
        }
        else {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              pathElement,
              ERR_ATTRIBUTE_MISSING,
              new java.lang.Object[] { SVG_D_ATTRIBUTE });
        }
        s =
          pathElement.
            getAttributeNS(
              null,
              SVG_TRANSFORM_ATTRIBUTE);
        if (s.
              length(
                ) !=
              0) {
            java.awt.geom.AffineTransform tr =
              org.apache.batik.bridge.SVGUtilities.
              convertTransform(
                pathElement,
                SVG_TRANSFORM_ATTRIBUTE,
                s,
                ctx);
            pathShape =
              tr.
                createTransformedShape(
                  pathShape);
        }
        org.apache.batik.gvt.text.TextPath textPath =
          new org.apache.batik.gvt.text.TextPath(
          new java.awt.geom.GeneralPath(
            pathShape));
        s =
          textPathElement.
            getAttributeNS(
              null,
              SVG_START_OFFSET_ATTRIBUTE);
        if (s.
              length(
                ) >
              0) {
            float startOffset =
              0;
            int percentIndex =
              s.
              indexOf(
                '%');
            if (percentIndex !=
                  -1) {
                float pathLength =
                  textPath.
                  lengthOfPath(
                    );
                java.lang.String percentString =
                  s.
                  substring(
                    0,
                    percentIndex);
                float startOffsetPercent =
                  0;
                try {
                    startOffsetPercent =
                      org.apache.batik.bridge.SVGUtilities.
                        convertSVGNumber(
                          percentString);
                }
                catch (java.lang.NumberFormatException e) {
                    startOffsetPercent =
                      -1;
                }
                if (startOffsetPercent <
                      0) {
                    throw new org.apache.batik.bridge.BridgeException(
                      ctx,
                      textPathElement,
                      ERR_ATTRIBUTE_VALUE_MALFORMED,
                      new java.lang.Object[] { SVG_START_OFFSET_ATTRIBUTE,
                      s });
                }
                startOffset =
                  (float)
                    (startOffsetPercent *
                       pathLength /
                       100.0);
            }
            else {
                org.apache.batik.parser.UnitProcessor.Context uctx =
                  org.apache.batik.bridge.UnitProcessor.
                  createContext(
                    ctx,
                    textPathElement);
                startOffset =
                  org.apache.batik.bridge.UnitProcessor.
                    svgOtherLengthToUserSpace(
                      s,
                      SVG_START_OFFSET_ATTRIBUTE,
                      uctx);
            }
            textPath.
              setStartOffset(
                startOffset);
        }
        return textPath;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1YfWwcRxWfO387/s4n+XASx0mVD+4S2gCVQ1vbtROHs2Pi" +
       "NAKH5jK3O3e38d7uZnfOPjuENpVQQpGikDptimj+ShVapU2FqABBq6AK2qqA" +
       "1BIBBTVF4g/CR0QjpPJHgPLezO7t3p7PURBw0s7tzbx5M+/N7/3em7t0g9Q4" +
       "NulkBo/xaYs5sQGDj1LbYWq/Th1nH/Qllaeq6N8OXh+5N0pqx0lLljrDCnXY" +
       "oMZ01RknqzTD4dRQmDPCmIozRm3mMHuScs00xslizRnKWbqmaHzYVBkK7Kd2" +
       "grRTzm0tledsyFXAyaoE7CQudhLvDQ/3JEiTYlrTvviygHh/YAQlc/5aDidt" +
       "icN0ksbzXNPjCc3hPQWbbLZMfTqjmzzGCjx2WN/uumB3YnuZC7peav3w1uls" +
       "m3DBQmoYJhfmOXuZY+qTTE2QVr93QGc55wj5MqlKkAUBYU66E96icVg0Dot6" +
       "1vpSsPtmZuRz/aYwh3uaai0FN8TJ2lIlFrVpzlUzKvYMGuq5a7uYDNauKVor" +
       "rSwz8ezm+OxTB9u+XUVax0mrZozhdhTYBIdFxsGhLJdittOrqkwdJ+0GHPYY" +
       "szWqazPuSXc4WsagPA/H77kFO/MWs8Wavq/gHME2O69w0y6alxaAcn/VpHWa" +
       "AVuX+LZKCwexHwxs1GBjdpoC7twp1ROaoXKyOjyjaGP3Z0EAptblGM+axaWq" +
       "DQodpENCRKdGJj4G0DMyIFpjAgBtTpZXVIq+tqgyQTMsiYgMyY3KIZBqEI7A" +
       "KZwsDosJTXBKy0OnFDifGyM7Th01dhlREoE9q0zRcf8LYFJnaNJelmY2gziQ" +
       "E5s2JZ6kS145GSUEhBeHhKXMd79084EtnVfekDIr5pDZkzrMFJ5ULqRa3l7Z" +
       "v/HeKtxGvWU6Gh5+ieUiykbdkZ6CBQyzpKgRB2Pe4JW9P/nCo8+zP0dJ4xCp" +
       "VUw9nwMctStmztJ0Zu9kBrMpZ+oQaWCG2i/Gh0gdvCc0g8nePem0w/gQqdZF" +
       "V60pfoOL0qACXdQI75qRNr13i/KseC9YhJA6eMj98NxF5GcDNpwo8ayZY3Gq" +
       "UEMzzPiobaL9ThwYJwW+zcZTgPqJuGPmbYBg3LQzcQo4yDJ3IGVraobFx/bv" +
       "3AfxMwprIivA7D4xEEOwWf+fZQpo7cKpSAQOYmWYBnSIoF2mrjI7qczm+wZu" +
       "vph8S0IMw8L1EydbYeWYXDkmVo7JlWOVViaRiFhwEe5Anjqc2QREP9Bv08ax" +
       "h3cfOtlVBXCzpqrB4SjaVZKG+n2K8Hg9qVzuaJ5Ze23ba1FSnSAdVOF5qmNW" +
       "6bUzwFfKhBvSTSlIUH6eWBPIE5jgbFNhKtBUpXzhaqk3J5mN/ZwsCmjwshjG" +
       "a7xyDplz/+TKuanj+x/ZGiXR0tSAS9YAq+H0UST0InF3hylhLr2tJ65/ePnJ" +
       "Y6ZPDiW5xkuRZTPRhq4wJMLuSSqb1tCXk68c6xZubwDy5hSCDXixM7xGCff0" +
       "eDyOttSDwWnTzlEdhzwfN/KsbU75PQKr7eJ9EcBiAQbjOni2uNEpvnF0iYXt" +
       "UoltxFnICpEnPjNmPfPrn//xbuFuL6W0BmqBMcZ7AjSGyjoEYbX7sN1nMwZy" +
       "750bfeLsjRMHBGZBYt1cC3Zj2w/0BUcIbv7KG0feff/ahatRH+cc8ng+BeVQ" +
       "oWgk9pPGeYyE1Tb4+wEa1IEjEDXdDxmATy2t0ZTOMLD+0bp+28t/OdUmcaBD" +
       "jwejLbdX4Pd/rI88+tbBv3cKNREF07DvM19McvtCX3OvbdNp3Efh+Durnn6d" +
       "PgNZApjZ0WaYIFsifEDEoW0X9m8V7T2hsU9hs94Jgr80vgLlUlI5ffWD5v0f" +
       "vHpT7La03gqe9TC1eiS8sNlQAPVLw+S0izpZkLvnysgX2/Qrt0DjOGhUgHqd" +
       "PTZwZKEEGa50Td1vfvTakkNvV5HoIGnUTaoOUhFkpAHQzZws0GvBuv8BebhT" +
       "9dC0CVNJmfFlHejg1XMf3UDO4sLZM99b+p0dF89fEyizpI4VQYV3YbO5iDfx" +
       "qfVSnfcdxJuvISLel3GyoVICGLBt0y7WqujVVZWKGFGAXXhs9ry659ltstTo" +
       "KC0MBqDufeGX//xp7Nzv3pwjCzVw0/q4ziaZHthiFS5ZkjqGRX3n09d7LWd+" +
       "//3uTN+dZA3s67xNXsDfq8GITZWzQHgrrz/2p+X77sseuoMEsDrkzrDK54Yv" +
       "vblzg3ImKopZyf1lRXDppJ6gY2FRm0HVbqCZ2NMsomRdES8dCI9OeLa5eNk2" +
       "NwnPAbUitVWaOg8J7J9n7PPYfI6TpgyUeqZC9RGwxoNqm4gXLORjspAXA5/G" +
       "Zq8MiJ7/MBixo9cS/cOlOaoHnu2ujdvv3D2VpoZcEBUbiXqGrq8Uk7IEc+9u" +
       "nvRClJ66W4mpZi7m1mpia2weR4vYOMRJc5Yaqs7caRBxG+e5PdtaDtLppHv/" +
       "iB/reH/im9dfkAEfvqyEhNnJ2cc/ip2alcEvb3Tryi5VwTnyVic22yYd+xF8" +
       "IvD8Cx+0BDvwGy55/e7VYk3xboGMaZO1821LLDH4h8vHfvCtYyeirmeGOKme" +
       "NDXVBxf9H4BL8HUXPH0uQvruHFyVps4NLvyZxiYrVD8yDziOYzPDSYtiM3Cl" +
       "dw/wANdVBs/MJPgX8VIiKpx39L/hvALcQytdSDCTLiv7E0Re3JUXz7fWLz3/" +
       "0K9EhiherpuA69N5XQ9QZZA2ay2bpTXhiSZZWFji62ucLK0QmVD9yRdhweNS" +
       "/hRQVliekxrxHZT7OieNvhyoki9BkVlOqkAEX89a3jl8ohJN9BpajnIs/UQ0" +
       "aAr4TjqrECmvIsQxLb7dMRWnBCtkPHLxN5WXwvLyjyq40J3fPXL05ieflRW6" +
       "otOZGdSyIEHq5GWhmAbXVtTm6ardtfFWy0sN670IbZcb9gNkRQC7vVDbWIiJ" +
       "5aHy1ekuVrHvXtjx6s9O1r4DZHSARChQ6IHAn0TyHxGogfNQfxxI+BVI4G9O" +
       "UVf3bPzG9H1b0n/9rSjQiLzsrqwsn1SuXnz4F2eWXYD6e8EQqQHyYYVx0qg5" +
       "D04be5kyaY+TZs0ZKMAWQYtG9SFSnze0I3k2pCZIC8KXYt4TfnHd2Vzsxfsd" +
       "BGc5qZbfiqGYnWJ2n5k3VFEYQMni95T8f+ZVEnnLCk3we4pHuajc9qTy4Fdb" +
       "f3i6o2oQQrDEnKD6OiefKlYpwb/U/LKlDZsjBUn3VcnEsGV59F/zY0vGxEUp" +
       "g/2cRDa5vcgnEVn04s/nhbrnxCs2l/4NHg7xKC0XAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "L34zO/X9P1EonfxuIgAA");
}
