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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "OD8fp+TF7IviEZtv/wd/FGs+dxYAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "eemWqA2TaAVkyNk47aezHgvqEQ5V2LYzShB5ao2qFhGR6Kax0QrUPG34ftvq" +
       "aJxRxT0tdRsMtS6veaOKxquho8BpBWuusCIjdJOl2U44MZjWcExu6z2xqNIJ" +
       "O8cVe6lOqOWwKXaJjWIQZo0Ip2Q4LKQNsrfpYxKzrGEcOYqxNqoJXXM+JXSc" +
       "LToypc9UmEvVAKELzKxEd3V2wncpnpyswygxLHkuWV2+WRVWRK+ZWonARht2" +
       "4emwbDg9Bq/T+NgXZmgcTqLyIgxhZECy/JSiUxodSuIiDlrkTJwFDZRvIeUp" +
       "X1k1F1O/w9aRYYuaCIxZ7hOYsTSGfo3U22N5VZW6A6yMlqyxgmyQCtNnC312" +
       "XZ9b5rDd7bLrSdBhR/xCTssTi5VqG1we9BrUZkm04XFfxSWuy4K3JdWWVosV" +
       "zpGeLlZrYyTudmCuiS3WDi5UOZpXWLtQJnGYrApYHzd9fBYM8bJW12mYmhnM" +
       "IFl2OpZEmpOZzFCKv0ylKCl0E99qLuIoaZEYTBOVxWrJjldYwNNGBcPimdVy" +
       "l/NZUagXaxLl2i1PW1ZE30FxD1vhKZ0gxGaltVyZmuiDJTKYaYWRtBSj+Zx3" +
       "BUFUeMkvR06yol1uw/tDbCKVy/gG41PCHZbmPmZNRxbNjQzD6BlxMG5EmxVF" +
       "tBO9yy/5ZAEbCo22CqUQbRMxwVFFp4+ys8mqRxlDxZmMhYgoSGvLk2deq6gU" +
       "oolhBoY9mWjTgI2TzWZTd1rUxl4tlnhZwJuywplaxNS9eWudtnqcuRTG/GZZ" +
       "C0FntTTteVo3NnZF2KT+wFnhsDRUBJlGzboakdq4CFd6hbUes0yzH4bNuIzV" +
       "8NBCx8GoMR+T82kJQdd8FM1mbiGJcKfXx4TN0kpEfRHO+eG8RXTLbp8NarCZ" +
       "1hTZhp3pgqgQa2o+Gze1hd8K/N5wWGxaCy4ZxKW4IiRaR7SIcYlVRwiBC2xS" +
       "o8ekactL36xgHbzH8mRzhcxrtFVBETgR6vCglQjpshxE6zG8ifTmqtIY84K8" +
       "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");
}
