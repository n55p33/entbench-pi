package org.apache.batik.transcoder.svg2svg;
public class SVGTranscoder extends org.apache.batik.transcoder.AbstractTranscoder implements ent.runtime.ENT_Attributable {
    public int ENT_attribute() { return org.apache.batik.apps.rasterizer.EntMode.
                                          LOW_MODE; }
    public static final org.apache.batik.transcoder.ErrorHandler DEFAULT_ERROR_HANDLER =
      new org.apache.batik.transcoder.ErrorHandler(
      ) {
        public void error(org.apache.batik.transcoder.TranscoderException ex)
              throws org.apache.batik.transcoder.TranscoderException {
            throw ex;
        }
        public void fatalError(org.apache.batik.transcoder.TranscoderException ex)
              throws org.apache.batik.transcoder.TranscoderException {
            throw ex;
        }
        public void warning(org.apache.batik.transcoder.TranscoderException ex)
              throws org.apache.batik.transcoder.TranscoderException {
            
        }
    };
    public static final org.apache.batik.transcoder.TranscodingHints.Key
      KEY_NEWLINE =
      new org.apache.batik.transcoder.svg2svg.SVGTranscoder.NewlineKey(
      );
    public static final org.apache.batik.transcoder.svg2svg.SVGTranscoder.NewlineValue
      VALUE_NEWLINE_CR =
      new org.apache.batik.transcoder.svg2svg.SVGTranscoder.NewlineValue(
      "\r");
    public static final org.apache.batik.transcoder.svg2svg.SVGTranscoder.NewlineValue
      VALUE_NEWLINE_CR_LF =
      new org.apache.batik.transcoder.svg2svg.SVGTranscoder.NewlineValue(
      "\r\n");
    public static final org.apache.batik.transcoder.svg2svg.SVGTranscoder.NewlineValue
      VALUE_NEWLINE_LF =
      new org.apache.batik.transcoder.svg2svg.SVGTranscoder.NewlineValue(
      "\n");
    public static final org.apache.batik.transcoder.TranscodingHints.Key
      KEY_FORMAT =
      new org.apache.batik.transcoder.keys.BooleanKey(
      );
    public static final java.lang.Boolean
      VALUE_FORMAT_ON =
      java.lang.Boolean.
        TRUE;
    public static final java.lang.Boolean
      VALUE_FORMAT_OFF =
      java.lang.Boolean.
        FALSE;
    public static final org.apache.batik.transcoder.TranscodingHints.Key
      KEY_TABULATION_WIDTH =
      new org.apache.batik.transcoder.keys.IntegerKey(
      );
    public static final org.apache.batik.transcoder.TranscodingHints.Key
      KEY_DOCUMENT_WIDTH =
      new org.apache.batik.transcoder.keys.IntegerKey(
      );
    public static final org.apache.batik.transcoder.TranscodingHints.Key
      KEY_DOCTYPE =
      new org.apache.batik.transcoder.svg2svg.SVGTranscoder.DoctypeKey(
      );
    public static final org.apache.batik.transcoder.svg2svg.SVGTranscoder.DoctypeValue
      VALUE_DOCTYPE_CHANGE =
      new org.apache.batik.transcoder.svg2svg.SVGTranscoder.DoctypeValue(
      org.apache.batik.transcoder.svg2svg.PrettyPrinter.
        DOCTYPE_CHANGE);
    public static final org.apache.batik.transcoder.svg2svg.SVGTranscoder.DoctypeValue
      VALUE_DOCTYPE_REMOVE =
      new org.apache.batik.transcoder.svg2svg.SVGTranscoder.DoctypeValue(
      org.apache.batik.transcoder.svg2svg.PrettyPrinter.
        DOCTYPE_REMOVE);
    public static final org.apache.batik.transcoder.svg2svg.SVGTranscoder.DoctypeValue
      VALUE_DOCTYPE_KEEP_UNCHANGED =
      new org.apache.batik.transcoder.svg2svg.SVGTranscoder.DoctypeValue(
      org.apache.batik.transcoder.svg2svg.PrettyPrinter.
        DOCTYPE_KEEP_UNCHANGED);
    public static final org.apache.batik.transcoder.TranscodingHints.Key
      KEY_PUBLIC_ID =
      new org.apache.batik.transcoder.keys.StringKey(
      );
    public static final org.apache.batik.transcoder.TranscodingHints.Key
      KEY_SYSTEM_ID =
      new org.apache.batik.transcoder.keys.StringKey(
      );
    public static final org.apache.batik.transcoder.TranscodingHints.Key
      KEY_XML_DECLARATION =
      new org.apache.batik.transcoder.keys.StringKey(
      );
    public SVGTranscoder() { super();
                             setErrorHandler(
                               DEFAULT_ERROR_HANDLER);
    }
    public void transcode(org.apache.batik.transcoder.TranscoderInput input,
                          org.apache.batik.transcoder.TranscoderOutput output)
          throws org.apache.batik.transcoder.TranscoderException {
        java.io.Reader r =
          input.
          getReader(
            );
        java.io.Writer w =
          output.
          getWriter(
            );
        if (r ==
              null) {
            org.w3c.dom.Document d =
              input.
              getDocument(
                );
            if (d ==
                  null) {
                throw new java.lang.Error(
                  "Reader or Document expected");
            }
            java.io.StringWriter sw =
              new java.io.StringWriter(
              1024);
            try {
                org.apache.batik.dom.util.DOMUtilities.
                  writeDocument(
                    d,
                    sw);
            }
            catch (java.io.IOException ioEx) {
                throw new java.lang.Error(
                  "IO:" +
                  ioEx.
                    getMessage(
                      ));
            }
            r =
              new java.io.StringReader(
                sw.
                  toString(
                    ));
        }
        if (w ==
              null) {
            throw new java.lang.Error(
              "Writer expected");
        }
        prettyPrint(
          r,
          w);
    }
    protected void prettyPrint(java.io.Reader in,
                               java.io.Writer out)
          throws org.apache.batik.transcoder.TranscoderException {
        try {
            org.apache.batik.transcoder.svg2svg.PrettyPrinter pp =
              new org.apache.batik.transcoder.svg2svg.PrettyPrinter(
              );
            org.apache.batik.transcoder.svg2svg.SVGTranscoder.NewlineValue nlv =
              (org.apache.batik.transcoder.svg2svg.SVGTranscoder.NewlineValue)
                hints.
                get(
                  KEY_NEWLINE);
            if (nlv !=
                  null) {
                pp.
                  setNewline(
                    nlv.
                      getValue(
                        ));
            }
            java.lang.Boolean b =
              (java.lang.Boolean)
                hints.
                get(
                  KEY_FORMAT);
            if (b !=
                  null) {
                pp.
                  setFormat(
                    b.
                      booleanValue(
                        ));
            }
            java.lang.Integer i =
              (java.lang.Integer)
                hints.
                get(
                  KEY_TABULATION_WIDTH);
            if (i !=
                  null) {
                pp.
                  setTabulationWidth(
                    i.
                      intValue(
                        ));
            }
            i =
              (java.lang.Integer)
                hints.
                get(
                  KEY_DOCUMENT_WIDTH);
            if (i !=
                  null) {
                pp.
                  setDocumentWidth(
                    i.
                      intValue(
                        ));
            }
            org.apache.batik.transcoder.svg2svg.SVGTranscoder.DoctypeValue dtv =
              (org.apache.batik.transcoder.svg2svg.SVGTranscoder.DoctypeValue)
                hints.
                get(
                  KEY_DOCTYPE);
            if (dtv !=
                  null) {
                pp.
                  setDoctypeOption(
                    dtv.
                      getValue(
                        ));
            }
            java.lang.String s =
              (java.lang.String)
                hints.
                get(
                  KEY_PUBLIC_ID);
            if (s !=
                  null) {
                pp.
                  setPublicId(
                    s);
            }
            s =
              (java.lang.String)
                hints.
                get(
                  KEY_SYSTEM_ID);
            if (s !=
                  null) {
                pp.
                  setSystemId(
                    s);
            }
            s =
              (java.lang.String)
                hints.
                get(
                  KEY_XML_DECLARATION);
            if (s !=
                  null) {
                pp.
                  setXMLDeclaration(
                    s);
            }
            pp.
              print(
                in,
                out);
            out.
              flush(
                );
        }
        catch (java.io.IOException e) {
            getErrorHandler(
              ).
              fatalError(
                new org.apache.batik.transcoder.TranscoderException(
                  e.
                    getMessage(
                      )));
        }
    }
    protected static class NewlineKey extends org.apache.batik.transcoder.TranscodingHints.Key {
        public boolean isCompatibleValue(java.lang.Object v) {
            return v instanceof org.apache.batik.transcoder.svg2svg.SVGTranscoder.NewlineValue;
        }
        public NewlineKey() { super(); }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "nxUAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "AA==");
    }
    public static class NewlineValue {
        protected final java.lang.String value;
        protected NewlineValue(java.lang.String val) {
            super(
              );
            value =
              val;
        }
        public java.lang.String getValue() {
            return value;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAL1Ya2wU1xW+u34bvwHbNWDAGCo7dCekIRU1oYGNDSbrh7Bj" +
           "qUvDcnfm7u7g2Zlh5o69Nk0akKrQPxGlhJC28S9HKIg8VDVqKzWRq6hNorSV" +
           "ktBHWoVW7Z+0KWpQ1bQqDem5d2Z2Hrs24U8tzez1veece8/rO+fO5WuoyjRQ" +
           "N1FpjM7pxIwNqnQcGyaR4go2zUmYS4lPVuB/HHl/dFcUVSdRUw6bIyI2yZBM" +
           "FMlMog2yalKsisQcJURiHOMGMYkxg6msqUm0VjaH87oiizId0STCCKawkUCt" +
           "mFJDTluUDDsCKNqQgJMI/CTC3vDyQAI1iJo+55F3+sjjvhVGmff2MilqSRzD" +
           "M1iwqKwICdmkAwUD3aFrylxW0WiMFGjsmLLTMcHBxM4SE/S82PzRjTO5Fm6C" +
           "1VhVNcrVMw8RU1NmiJRAzd7soELy5nH0CKpIoFU+Yop6E+6mAmwqwKauth4V" +
           "nL6RqFY+rnF1qCupWhfZgSjaHBSiYwPnHTHj/MwgoZY6unNm0HZTUVtbyxIV" +
           "n7hDOPfkkZbvVaDmJGqW1Ql2HBEOQWGTJBiU5NPEMPdKEpGSqFUFZ08QQ8aK" +
           "PO94us2UsyqmFrjfNQubtHRi8D09W4EfQTfDEqlmFNXL8IBy/qvKKDgLurZ7" +
           "utoaDrF5ULBehoMZGQxx57BUTsuqRNHGMEdRx94HgABYa/KE5rTiVpUqhgnU" +
           "ZoeIgtWsMAGhp2aBtEqDADQo6lpWKLO1jsVpnCUpFpEhunF7CajquCEYC0Vr" +
           "w2RcEnipK+Qln3+uje5+/IR6QI2iCJxZIqLCzr8KmLpDTIdIhhgE8sBmbOhP" +
           "nMftL5+OIgTEa0PENs0Pvnr9vu3dS6/bNOvK0IyljxGRpsTFdNNb6+N9uyrY" +
           "MWp1zZSZ8wOa8ywbd1YGCjogTHtRIluMuYtLh3725UcvkQ+iqH4YVYuaYuUh" +
           "jlpFLa/LCjH2E5UYmBJpGNURVYrz9WFUA+OErBJ7diyTMQkdRpUKn6rW+P9g" +
           "ogyIYCaqh7GsZjR3rGOa4+OCjhBqgwd1wPMxsv/4L0WSkNPyRMAiVmVVE8YN" +
           "jelvCoA4abBtTkhD1E8LpmYZEIKCZmQFDHGQI84CNbBqigBChmDOZO+CR5iY" +
           "2j9ZnI2xaNP/T/sUmL6rZyMRcMX6MBAokEMHNAVoU+I5a9/g9edTb9pBxhLD" +
           "sRRFe2DrmL11jG8d87aOOVvHAlv3jpJZ5pQprFgERSJ8+zXsPHYUgA+nAQ0A" +
           "jhv6Jh46ePR0TwWEnz5bCQ5gpD2BshT3IMPF+ZT4Qlvj/OarO16NosoEasMi" +
           "tbDCqsxeIwv4JU47Kd6QhoLl1Y1NvrrBCp6hiUQC2FqufjhSarUZYrB5itb4" +
           "JLhVjeWvsHxNKXt+tHRh9uTU1+6MomiwVLAtqwDlGPs4A/gikPeGIaKc3ObH" +
           "3v/ohfMPax5YBGqPWzJLOJkOPeEACZsnJfZvwi+lXn64l5u9DsCcYvAz4GR3" +
           "eI8AFg24uM50qQWFM5qRxwpbcm1cT3OGNuvN8Mht5eM1brZ2w/OJk638l622" +
           "6+zdYUc6i7OQFrxu3DuhP/3bX/7l89zcbolp9vUGE4QO+GCNCWvjANbqhe2k" +
           "QQjQvXdh/FtPXHvsMI9ZoNhSbsNe9o4DnIELwcxff/34u3+4ungl6sU5RXW6" +
           "oVHIeSIVinrWMrVaV9ATNtzmHQmQUQEJLHB6H1QhROWMjNMKYbn13+atO176" +
           "2+MtdigoMONG0vZbC/DmP7MPPfrmkX91czERkVVmz2wemQ33qz3Jew0Dz7Fz" +
           "FE6+veGp1/DTUDgArE15nnD8jTjpzg7VCY0a52RFOGYXYe7QnXz5Tv6+m1mC" +
           "MyG+tou9tpr+xAjmnq+1SolnrnzYOPXhK9e5GsHezB8HI1gfsEOPvbYVQHxH" +
           "GLgOYDMHdHcvjX6lRVm6ARKTIFEElDbHDIC/QiBqHOqqmt/95NX2o29VoOgQ" +
           "qlc0LA1hnoCoDiKfmDkA4oL+pftsr8+yOGjhqqIS5UsmmOU3lvfpYF6n3Avz" +
           "P+z4/u6LC1d5BOq2jHVFxF0fQFze4XtJf+mdL/zq4jfPz9o9Qt/ySBfi6/zP" +
           "mJI+9ad/l5icY1yZ/iXEnxQuf7crvucDzu+BDePuLZTWMwBsj/euS/l/Rnuq" +
           "fxpFNUnUIjodNS9IkMJJ6CJNt82GrjuwHuwI7fZnoAim68NA59s2DHNeHYUx" +
           "o2bjxhCydTIXboXnppPxN8PIFkF88ABn+Sx/97PX57j7omwYo7CzrGIlhCQd" +
           "K8gFlhmmL/vnHhs92fuL7JWw5dxbLh4Ly5yDwkXFSsN9DwYmv0N4h6l0YS3Q" +
           "bPlhzYtHxJJuw3L9MO/lF0+dW5DGntlhR2RbsMcchCvUc7/++OexC398o0w7" +
           "U+3cZ4IJsCGQACP8nuBF03tNZ//8o97svtvpNthc9y36Cfb/RtCgf/mcCh/l" +
           "tVN/7Zrckzt6G43DxpAtwyKfHbn8xv5t4tkovxTZYV5ymQoyDQSDu94gcPtT" +
           "JwMhvqXo/XaneEeitvPt39LiXTauImw4FYrrphWErVAy5BXWuBMhdmuzxMYB" +
           "nhdeSkgrpMSngGg2EdcLFDX4m2O3+u247R4bYraz5GZv30bF5xeaazsWHvwN" +
           "D9fijbEBAi9jKYoflHzjat0gGZmbosGGKJ3/WBRt+RSno6jGGXGdqM0M+q5b" +
           "gZlCuHoa+fhOQEMQ5gO84r9+ukdAgkcHyW0P/CQnKaoAEjY8pZfpNmyAL0SC" +
           "CFR0+9pbud0HWlsCacw/z7gpZ9kfaODisnBw9MT1e56xO1FRwfPz/DqfQDV2" +
           "U1xM283LSnNlVR/ou9H0Yt3WqBPCrfaBvWRa54vvOKSKzjqFrlCPZvYWW7V3" +
           "F3e/8ovT1W8DbB5GEUzR6sOlpbCgW4CXhxMeYvo+7/HmcaDv23N7tmf+/nve" +
           "bJS2GGH6lHjl4kPvnO1chCZz1TCqAoQnBV6j759TDxFxxkiiRtkcLMARQYqM" +
           "lWFUa6nycYsMSwnUxCIcs56R28UxZ2Nxlt1jKOop+UJT5vYHjdksMfZplipx" +
           "IAOI9WYC341c5LN0PcTgzRRduaZU95R4/zeaf3ymrWIIsjSgjl98jWmli6jq" +
           "/5TkwWyLjYyfwF8EnpvsYU5nE+wX2pm481llU/G7CnSA9lpFKjGi6y7tqiu6" +
           "nSLn2Ot8gc1TFOl3ZhmgRTxQforvf4EP2es7/wN1tOZzVhYAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "wgjOIAAA");
    }
    protected static class DoctypeKey extends org.apache.batik.transcoder.TranscodingHints.Key {
        public boolean isCompatibleValue(java.lang.Object v) {
            return v instanceof org.apache.batik.transcoder.svg2svg.SVGTranscoder.DoctypeValue;
        }
        public DoctypeKey() { super(); }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "nxUAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public static class DoctypeValue {
        final int value;
        protected DoctypeValue(int value) {
            super(
              );
            this.
              value =
              value;
        }
        public int getValue() { return value;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "rKh/3eDo0Bccovki5/42v2WX2f8BsVR1wbEXAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "7X8B+/G49oQhAAA=");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "ll0nAAA=");
    public ent.runtime.ENT_Attributable ENT_copy() {
        org.apache.batik.transcoder.svg2svg.SVGTranscoder ENT_ld =
          new org.apache.batik.transcoder.svg2svg.SVGTranscoder(
          );
        return ENT_ld;
    }
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "0l7YHuO6brrR9Uz/8k7/2gsvXn/p+o9t");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("x7x+y2sd2ffD/UAOIy0wN9kxDjfb+dRekp3Zy/sUMzmgGQy/+eOj6y+/6Psn" +
       "Xl+e5zOnQGel/w0MkH3f/mTVX96h7H9myetR4ZFT4uRVv3XCsf84Ktxj7o55" +
       "5w7/X3/Q1uTJgfKM/3IkR37ArweuL+/k+PLZTf0TKjgbp3t5nG6j84xcl/IK" +
       "lw6jpfhGjp5oQc/14+iwzXvfWBsmjkCjDMTe5TMg9k6HLPTGOsQTRfOzoMn7" +
       "fDhL9rLoPKxwO4Pcu/JM9cgie5fehEUezTJr4PrGziLfuIhFAFA/ANGhgGh5" +
       "I4bZvoIwvX1Ok4Hst2RPAhNESq6JZ26v3azokbzC81nyRFR4yAfBF6VsALw0" +
       "yzrm5r0n34Ricp54/lae+IU3xhNnOTrPUDw/3fLFqXe7ORvkFWz1+vuvu9r6" +
       "+q3lL+zv7794873Xd0yzrZ2XvAn62HvxTvSx9yN3KIOy5Iejwv2HgmWVvnus" +
       "+xcuovsE0NApkbOTpk/d8p+Q7f8YlF979er9T746/tf5+eSj/xo8QBXun8e2" +
       "ffJg4In7y8BN5mauowe2xwRzhe3Vo8K73sDb+KhwZXeXgd+rbRu3osLb79A4" +
       "AjPg0Y+T7d4XFa6dbRcV7su/T9b7IOjhuF5UuLy9OVkFBfwMqmS3bf8woPbv" +
       "JBEyC8EvJTrWdrJ3Yg2wi4Sc6x//QUY8anLyhHS2bsj/9nM4x8fbP/4cKF99" +
       "lRy89Hr9l7YntBVb3myyXu6nCle2h8WP1gnPndvbYV+Xuy9+/9GvPfDuwzXN" +
       "o1vAx0FwAts7b38cGnf8KD/AvPnNJ//x+/7hq9/OX3L+PzEzZNSPNQAA");
}
