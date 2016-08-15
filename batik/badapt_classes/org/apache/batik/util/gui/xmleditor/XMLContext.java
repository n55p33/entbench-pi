package org.apache.batik.util.gui.xmleditor;
public class XMLContext extends javax.swing.text.StyleContext {
    public static final java.lang.String XML_DECLARATION_STYLE = "xml_declaration";
    public static final java.lang.String DOCTYPE_STYLE = "doctype";
    public static final java.lang.String COMMENT_STYLE = "comment";
    public static final java.lang.String ELEMENT_STYLE = "element";
    public static final java.lang.String CHARACTER_DATA_STYLE = "character_data";
    public static final java.lang.String ATTRIBUTE_NAME_STYLE = "attribute_name";
    public static final java.lang.String ATTRIBUTE_VALUE_STYLE = "attribute_value";
    public static final java.lang.String CDATA_STYLE = "cdata";
    protected java.util.Map syntaxForegroundMap = null;
    protected java.util.Map syntaxFontMap = null;
    public XMLContext() { super();
                          java.lang.String syntaxName;
                          java.awt.Font font;
                          java.awt.Color fontForeground;
                          syntaxFontMap = new java.util.HashMap();
                          syntaxForegroundMap = new java.util.HashMap();
                          java.awt.Font defaultFont = new java.awt.Font("Monospaced",
                                                                        java.awt.Font.
                                                                          PLAIN,
                                                                        12);
                          syntaxName = org.apache.batik.util.gui.xmleditor.XMLContext.
                                         DEFAULT_STYLE;
                          font = defaultFont;
                          fontForeground = java.awt.Color.
                                             black;
                          syntaxFontMap.put(syntaxName,
                                            font);
                          syntaxForegroundMap.put(
                                                syntaxName,
                                                fontForeground);
                          syntaxName = org.apache.batik.util.gui.xmleditor.XMLContext.
                                         XML_DECLARATION_STYLE;
                          font = defaultFont.
                                   deriveFont(
                                     java.awt.Font.
                                       BOLD);
                          fontForeground =
                            new java.awt.Color(
                              0,
                              0,
                              124);
                          syntaxFontMap.put(
                                          syntaxName,
                                          font);
                          syntaxForegroundMap.
                            put(
                              syntaxName,
                              fontForeground);
                          syntaxName = org.apache.batik.util.gui.xmleditor.XMLContext.
                                         DOCTYPE_STYLE;
                          font = defaultFont.
                                   deriveFont(
                                     java.awt.Font.
                                       BOLD);
                          fontForeground =
                            new java.awt.Color(
                              0,
                              0,
                              124);
                          syntaxFontMap.put(
                                          syntaxName,
                                          font);
                          syntaxForegroundMap.
                            put(
                              syntaxName,
                              fontForeground);
                          syntaxName = org.apache.batik.util.gui.xmleditor.XMLContext.
                                         COMMENT_STYLE;
                          font = defaultFont;
                          fontForeground =
                            new java.awt.Color(
                              128,
                              128,
                              128);
                          syntaxFontMap.put(
                                          syntaxName,
                                          font);
                          syntaxForegroundMap.
                            put(
                              syntaxName,
                              fontForeground);
                          syntaxName = org.apache.batik.util.gui.xmleditor.XMLContext.
                                         ELEMENT_STYLE;
                          font = defaultFont;
                          fontForeground =
                            new java.awt.Color(
                              0,
                              0,
                              255);
                          syntaxFontMap.put(
                                          syntaxName,
                                          font);
                          syntaxForegroundMap.
                            put(
                              syntaxName,
                              fontForeground);
                          syntaxName = org.apache.batik.util.gui.xmleditor.XMLContext.
                                         CHARACTER_DATA_STYLE;
                          font = defaultFont;
                          fontForeground =
                            java.awt.Color.
                              black;
                          syntaxFontMap.put(
                                          syntaxName,
                                          font);
                          syntaxForegroundMap.
                            put(
                              syntaxName,
                              fontForeground);
                          syntaxName = org.apache.batik.util.gui.xmleditor.XMLContext.
                                         ATTRIBUTE_NAME_STYLE;
                          font = defaultFont;
                          fontForeground =
                            new java.awt.Color(
                              0,
                              124,
                              0);
                          syntaxFontMap.put(
                                          syntaxName,
                                          font);
                          syntaxForegroundMap.
                            put(
                              syntaxName,
                              fontForeground);
                          syntaxName = org.apache.batik.util.gui.xmleditor.XMLContext.
                                         ATTRIBUTE_VALUE_STYLE;
                          font = defaultFont;
                          fontForeground =
                            new java.awt.Color(
                              153,
                              0,
                              107);
                          syntaxFontMap.put(
                                          syntaxName,
                                          font);
                          syntaxForegroundMap.
                            put(
                              syntaxName,
                              fontForeground);
                          syntaxName = org.apache.batik.util.gui.xmleditor.XMLContext.
                                         CDATA_STYLE;
                          font = defaultFont;
                          fontForeground =
                            new java.awt.Color(
                              124,
                              98,
                              0);
                          syntaxFontMap.put(
                                          syntaxName,
                                          font);
                          syntaxForegroundMap.
                            put(
                              syntaxName,
                              fontForeground);
    }
    public XMLContext(java.util.Map syntaxFontMap,
                      java.util.Map syntaxForegroundMap) {
        super(
          );
        setSyntaxFont(
          syntaxFontMap);
        setSyntaxForeground(
          syntaxForegroundMap);
    }
    public void setSyntaxForeground(java.util.Map syntaxForegroundMap) {
        if (syntaxForegroundMap ==
              null) {
            throw new java.lang.IllegalArgumentException(
              "syntaxForegroundMap can not be null");
        }
        this.
          syntaxForegroundMap =
          syntaxForegroundMap;
    }
    public void setSyntaxFont(java.util.Map syntaxFontMap) {
        if (syntaxFontMap ==
              null) {
            throw new java.lang.IllegalArgumentException(
              "syntaxFontMap can not be null");
        }
        this.
          syntaxFontMap =
          syntaxFontMap;
    }
    public java.awt.Color getSyntaxForeground(int ctx) {
        java.lang.String name =
          getSyntaxName(
            ctx);
        return getSyntaxForeground(
                 name);
    }
    public java.awt.Color getSyntaxForeground(java.lang.String name) {
        return (java.awt.Color)
                 syntaxForegroundMap.
                 get(
                   name);
    }
    public java.awt.Font getSyntaxFont(int ctx) {
        java.lang.String name =
          getSyntaxName(
            ctx);
        return getSyntaxFont(
                 name);
    }
    public java.awt.Font getSyntaxFont(java.lang.String name) {
        return (java.awt.Font)
                 syntaxFontMap.
                 get(
                   name);
    }
    public java.lang.String getSyntaxName(int ctx) {
        java.lang.String name =
          CHARACTER_DATA_STYLE;
        switch (ctx) {
            case org.apache.batik.util.gui.xmleditor.XMLScanner.
                   XML_DECLARATION_CONTEXT:
                name =
                  XML_DECLARATION_STYLE;
                break;
            case org.apache.batik.util.gui.xmleditor.XMLScanner.
                   DOCTYPE_CONTEXT:
                name =
                  DOCTYPE_STYLE;
                break;
            case org.apache.batik.util.gui.xmleditor.XMLScanner.
                   COMMENT_CONTEXT:
                name =
                  COMMENT_STYLE;
                break;
            case org.apache.batik.util.gui.xmleditor.XMLScanner.
                   ELEMENT_CONTEXT:
                name =
                  ELEMENT_STYLE;
                break;
            case org.apache.batik.util.gui.xmleditor.XMLScanner.
                   ATTRIBUTE_NAME_CONTEXT:
                name =
                  ATTRIBUTE_NAME_STYLE;
                break;
            case org.apache.batik.util.gui.xmleditor.XMLScanner.
                   ATTRIBUTE_VALUE_CONTEXT:
                name =
                  ATTRIBUTE_VALUE_STYLE;
                break;
            case org.apache.batik.util.gui.xmleditor.XMLScanner.
                   CDATA_CONTEXT:
                name =
                  CDATA_STYLE;
                break;
            default:
                name =
                  DEFAULT_STYLE;
                break;
        }
        return name;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "BABb+vp62tdt7muNdbZ05LGze6cIEB3nCovtilwAq2yAo+jdseXQtBH6sQKP" +
       "aSPc0hLdnAfifVOEiGQrLb4rc0GcIaZ188FpA/NjwMjMSH6VfOi/h8PD6/Ph" +
       "CVvcwllwCH/5WW4cgLVU01UGGzKNe0BU5BmWwXzHIXpItak6HdLVpBK3osao" +
       "B8yjUwSDfne1xXW1D5hf2VnYY9lz9usN7i49Z4X5zPZYntmmcuV+/K+IeA5E" +
       "HVwdYSHBvKHO78yan7cfunH/wXjXfavMwLDGfQ7cqiQTD/7hXy+E7j7xXI6D" +
       "x1KmaufLdJTKDp7F7iwTQtEOfpxvx3VvVu57+7HGoXVTOSrEuvrTHAbi/wsA" +
       "xHL/6NY7lWdu/Ou8vsuHd0zh1G+BR5zeIX/UceS5DUvFfUF+d2EGnFl3Hu5O" +
       "ze4ws0ynLKkr7lxlsfvcYC08k5YCTHqV1lYxv3MDv66eHMZKw7je8lFfy5Pk" +
       "vI7Fy2inlPV6TNXIm3N065D2MmnUyu7CkzVvjdz73oPWKUTWIaiLmO7ef+uX" +
       "oT37TfU0r5gWZ93yOPuY10xmAohFPxrJonxceI+2d49OPn7/5M3pbPa3jBSO" +
       "qlLcNuVXvoqsjte/6F7sC+C5yVqxm6a+2H5dT7fYH+RZ7JNY/AUdnL3YZtR4" +
       "3BbIu2dAIHiyQxrhuc1CddvUBeLXNbdAjNyHWx49XN29Q9zd2P1OWj2uslQL" +
       "f95wvL/FSIFkXRp7pL41xXt+5i/2AJ/tx2BjQzlsDNsgs6vkmZ0wxvBM0rq/" +
       "5cvx9zO5HHstme6d+nL4dfXXT4MLoyKPoKqwKMktKGwKZsQSKD0DYuHd6+DZ" +
       "b2HbP3Wx+HX1F8vnHPq8PGKZj0UtmO2Q02zTmlOR0ZxMLZfQ7DMpoXssmPdM" +
       "XUJ+XU+nOE15JLQCi0avhLCy3hbIkjMgkBpsWwDPAQvVgakLxK/r6VTmojwC" +
       "4YBXOQXSaYUqhi2Q1V/JgSYjZfY1Nd6vzM36KMb8kEN86GBVyZyDm1/jIWTm" +
       "Y4tyCAYHk7LsPLJzvBdpOh2UuBjLzQM8fn4buBIihv/iCh3i3cw7QghcYXaP" +
       "MHKOb3fw9lA6ydsgz8xJDvEE/jhp2xmp9tJCrsh/nXRRkJxNx0iR+eIk6YKZ" +
       "AAm+dmtpg6/jdwshY0xShkL8m4ReNo7XjXwFUgF3KpHZSGpPt9qO7GOxK+zj" +
       "30Kld9Jkt3UjcfTgps7rTl10n3kZLMrCxASOMjNKis176Uzwvch3tPRYRRub" +
       "vqh8uHRJeh+eZU7Ytp1zHVFMC1iBhoo2z3NTajRmLkxfP7T2yd/tLnoZAsxt" +
       "JCDAlrIt+2g5pSUh69kWzb6sgESFX+E2N31//PKVgx++we8CiRlXzPenj4mv" +
       "Hr72lX1zD9UHycx2MgMiUJriZ97rx5UeKo7q/aRCMlpTMEUYRRJk101IpXnO" +
       "DOvK5WKJsyJTi58SMNKQHShnf4BRJqtjVF9n7Zx4lzLTrkknYa78Jalpng52" +
       "jbWUWF69i4dFuBqgnLFoh6alb17K2zXuFLbmjpNQi0X+im/x/wDfTeP7JykA" +
       "AA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "35W7bF/+9GtvKOOfqR+8R/9nYeWe0PV+");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("yFJj1TpW1UVQ04u33lFkyuOHRy9+f+XT/+0x7qP6J27jNNOTJ3CerPLvMm/+" +
       "2vB5+SfPV+44fA1808HIGwu9fOPL30u+Gka+w93wCvjxG49UfBhcr+xr9pXT" +
       "drGvnLFb/qG9vj9xBuDcnsCJPfOrB9vzZ7Z27GjB75xxtOBrRfJvi5cPajg/" +
       "8f6hLPBPjtnaL4eVO2PXUI6M8Ldv5yRCmfGbN2qtBq4f3+fx4z9IrT1RVP70" +
       "27V2TGvfPENrf1Ak/7V4t3Gktb23rt840s3vfh+6Kcdr0dGf20f7uXdfNyd6" +
       "9g7DCcsy//sM4n9SJP8DmIt2C3N5ONx/tSEmYXEobP9Ic6mQ77wbCnl1XyGv" +
       "vqsKKR1sIXDu0q3Zn7uvSO46nX3xqHLI9dyF74NrKfY4uF7b5/rau871j0s+" +
       "j5zB9dEieRCYuHbcxA/6+P7DPj7MLWk/9G7Q/tI+7S/9gLr46hm0ny+SJ0/S" +
       "LjIfO2L51PfB8qEi80lwvb7P8vUfUOfWzmBZsqgeZ8nuT3YfP2L50m2dMgsr" +
       "l45OPRdHOB+96T8We/8LkH/+jct3v+8N/t+VB38Pz+7fQ1fu3kSWdfzI1bH7" +
       "C56vboyS+T17B7C8kkkvrDz7Dk5kg9jk8L7Afq67V/zDYeX9tywOfCJIj4t/" +
       "LKw8fKo4mBiLr+Oy/bBy5aRsWLmr/D4uhwPNHcmFlQt7N8dFCIAEiBS3pHcw" +
       "BB8vT7RfCxLD0a6VR9znYVYcuC17ID13YzR36ITfdoQeCwCfvSFsK/9acxBi" +
       "RZP9c5tfeWPE/ti3Oz+zdxxatsQ8L2q5m65c3DuZfRimPX3L2g7qukC88N0H" +
       "fuGe5w5Cygf2AB8NiGPYnjz97DFue2F5Wjj/R+/7Bx/+2298rXxV/v8AgriB" +
       "6/M0AAA=");
}
