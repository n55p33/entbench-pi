package org.apache.batik.parser;
public class AWTPolygonProducer extends org.apache.batik.parser.AWTPolylineProducer {
    public static java.awt.Shape createShape(java.io.Reader r, int wr) throws java.io.IOException,
        org.apache.batik.parser.ParseException { org.apache.batik.parser.PointsParser p =
                                                   new org.apache.batik.parser.PointsParser(
                                                   );
                                                 org.apache.batik.parser.AWTPolygonProducer ph =
                                                   new org.apache.batik.parser.AWTPolygonProducer(
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
    public void endPoints() throws org.apache.batik.parser.ParseException {
        path.
          closePath(
            );
    }
    public AWTPolygonProducer() { super();
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "nJ+PU/Ji9kXxiM23/wO8G9dkdxYAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "/1M54yN5ezVrfnrr9az7MyBjw7yMBBya4Yp2LueJCESMLV/dz9EpKCuBi6+a" +
       "di0X8wZQSOfRkRmzu63FtliVtehWi7xfvWU0XNvXFez+nYfCWA+UdR/7x098" +
       "81ce+y7YIho6s8rcB3bmyIq9OKt0P/zCsw/c/sz3PpYDEECf6Qdfvv+pTCrz" +
       "ShZnDZE15L6p92emjvKnOCuGUTfHCVXJrX3FyOwHhgOgdbVXxsFPX/mu9anv" +
       "f35bop0MwxPE6kef+eWf7H78mZ0jhfFjN9SmR3m2xXGu9Ov2PBxAj7zSKjlH" +
       "65+++PQf/c7TH9lqdeV4mUeCt5jP/9V/f3P3ue99/Sb1xWnb+z9sbHTH19rl" +
       "sIPtf9gpr80SeZjONA6FSbQEVySiKhONeOgyQ5QYjwfrJVmUVdRJTKtSNkfY" +
       "AGUEpBLXEHSxUmrdmlipKwRVtFtY18DDVoRV2QpTJVvRBGktsWZzWW0yUWvC" +
       "TqyIZETdJy2DNMsLasTN+hg3azgSKpm1rtKSW3SvJqP1gthwxircQKNVY+kG" +
       "freKjAhtrPJp35HXHKFa9eEIkYSBXBKjsO2NClG/JRAwWisiQbXmVYcFkx1M" +
       "lwRiTOiwtyxuWMTpWa4YSC7nMSEsp3Y4ERh+JWzopT4n5sWuRMvRsNealLpT" +
       "m6/zM57HF1VjStPIRC6uehyd2HNsJgfkCh/FtEFrLaWsUk2asodEu8+QJdgm" +
       "U7hoik2rKPVsucEM+2TZFXubxXIh9JcmrzEt21oitjdB3V6ZaM3KQdtE9Nq8" +
       "OY/HXNWXQ84VGisldg27iDfl0Jf8WGbJRiHBN8QMwQWBs1A1VIq2OexbZGGM" +
       "LEc+MGtD2qvQSYqEJZk8O6rPinVmGsGMwshlsWNGdZZxVLvfbM6pdVc0Sb/J" +
       "R7Hjj/gQ0T2eqqmpOuYlWWKCeBpXN2LZ6ElllOu3VbQ810t+e92PlmaVWZda" +
       "Ojlcd81Oi5iN2wTbjua9MF7z1eF4Ue+qgiAwvflc7KtWPKujgU1ECUzNUJ5R" +
       "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" +
       "rxc2f3jv77/1t5//Tn7E+b9pPQncJCEAAA==");
}
