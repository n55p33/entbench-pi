package org.apache.batik.css.engine.value.svg;
public class TextRenderingManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_AUTO_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          AUTO_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_OPTIMIZESPEED_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          OPTIMIZESPEED_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_GEOMETRICPRECISION_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          GEOMETRICPRECISION_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_OPTIMIZELEGIBILITY_VALUE, org.apache.batik.css.engine.value.svg.SVGValueConstants.
                                                          OPTIMIZELEGIBILITY_VALUE);
    }
    public boolean isInheritedProperty() {
        return true;
    }
    public boolean isAnimatableProperty() {
        return true;
    }
    public boolean isAdditiveProperty() {
        return false;
    }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_IDENT;
    }
    public java.lang.String getPropertyName() {
        return org.apache.batik.util.CSSConstants.
                 CSS_TEXT_RENDERING_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 AUTO_VALUE;
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public TextRenderingManager() { super(
                                      ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "g8gbadOQqisGOQk9vhdt04gPlyxLsQ2AS8t83APBOMO8aNUYO80qT8f1ulKt" +
       "5Q1h2rQaAqMAbTysU9OAXEUdlc28USpHdkyZ/qLZpcS55iSMvx7OR30cE4Gm" +
       "tKL2eDuPMJqgGc6Wa5Fr1YIZII1kuLU8aBswmMeY2xmJbQVLhXCJmc10tpxX" +
       "dz2gmZOutx4PR/YsGnYIH1uyPc/j1N6QyEb0PNE9ftjpLRJLdFDYxUakNta0" +
       "ISjVPhUuIgN0tmaErsjm3OQ6A2vPxrgZDaw4kEJCIdF4Jk0Hzd4GDJXuhhrK" +
       "nb5LbEx/Zo/g5Guu+lprm08aq/qcrDRmtaZnUeZYpqqpIE0a6b4/NVZcPHST" +
       "1Kx31MWqvbAxkmo2jKC9ksYd6HydNUe3WmOwXHttwais5jYmD+go5Fp6ja3H" +
       "uJAYNsVhCsYwGSBZKazlczFNcFwRmq2YY3VFJUJqMPDlgUHtV2auD9YOQzSz" +
       "xl4g+l1lvlZmUjWaVbtBpyppI2G72e/r+6bPhlzm+abTl1IODJ2U84YDIu/L" +
       "8ny9s3xRkJmMc/p9at50fSPkR67T6fsbU8B9qbYRgx2/XbbrDuZQVWZc7/bn" +
       "rd5UaGZ8hZe8foWQJLs2Hm0gIszEhOsZEh6mZFr3e2vUN1WJaTmKH0WdrLOq" +
       "rbLKuCOp7R5HTHvjGTDbrm02piMVsxsuaQASqIowGeYkqRPzaV8mzZk1wito" +
       "rb43U2XFkeZ4r6/Z3nA1INcpxI5VZ95sV3kGa7bVWNwpbSWhuGWywOlspnWs" +
       "0PSmVXFIdSh5GK1YSuj3yIEwbIx40qJGdlN1Q7sujTCO0igyMfm+CggmItD1" +
       "uu0IUmcW1Pa9wZ52nXXT9QRmUO2qG64VB0qo7Zo7aw/Gy70/Yx1uJtiKHpmO" +
       "F3gaRVelXFmJoDWf5YLXAP1GYGfd8QqdNrhVJxytwkVq57Xxtid2epXcl4lR" +
       "QGZLOsw1ujsQlB3Ki2xVpQkO1AipYVPoyu156Z5hp6jM57Qqt7imlJNmY7TF" +
       "dYD2xWpdg27TCFV+act7yk/4Ee9MB/sZVRWblarSabTBzmjgEt4lSGmKOW6f" +
       "pHpS3Kls6yvA5lJTmtXw8VQfuPJGCE2X5x0BNHZNits61S6Y8elmzXYcsjPu" +
       "dk0hhcPTZg3D2OETsLcYPvZdzGMprUfrxNAz+L4P7P5UXEozbFDfk/gS0Hza" +
       "bjUn40o+HfPTHoXj9RGHMXIHHzJaZwoq9cZCI4gUrWt2I+kAq2e6LXqlNsdd" +
       "ruov99zE7tcniQTxuYEtmEEAEok3aT6j5j3a03Uicalk3u20hj1bIbwhaQUj" +
       "IQoG/dBAW1s81qu+gaqb3gDz633dyqoM6TU6sYFaYO7mTbBGa9QuMr2RPwRa" +
       "hfDcedg1GmyzlTm9kGI3s62OcotVpSWSFXreoS1MnuHsrJ/a6w5NzbZ1kXMg" +
       "TtD6wLLWTlJtVesg3aWgoWxkuAZ1G05L21V2dn9cHSlGm/ZwQ8M2jrYeMyOs" +
       "M5PXUz0fePv+XhtueEKbslmvUxuMnYW0Zo1RvKuJrL4YbJfsHKIG2VDmw56w" +
       "HuyzoTZzDW+Qb5LFAtXRgTfWdvq4S1tAmQnVhWUzM4mfZWGnqeaJ1eyuq+t2" +
       "dQudbdVzq5w61Ees1uVnWL1LTHICa8fCVrNn+Lqt8OFkbu2NnU2amznIc9Ya" +
       "YCO/0u3uNnrbGIlEVkN7Bk3nZqb0pWF3D2hg9gxAt4HEjwgUdSYBXZ2xQm3S" +
       "njEmUfd1Y5A2s1bEmKDFMYmjeWzALWddc6k112JTrNB+PUGX/sqbLKaDxN9G" +
       "uWbJ5hiFqKdUA2G8HtsNQ59UdNDZGNEm3y85n2XIhmdiA07Ugr0DhDq6q3c6" +
       "clAnla010ElHpfrTaTawaUtmao5v4yuLc3dUO5rvpQ21HphqNNDETqSsQtzx" +
       "hsMNkLKFuKTmXXnpT7U6uZCxdJpUc0ue0GMBNCPPZNS5G9PtSU/GF9vtNhsa" +
       "gUjX29Od1Qyz7a4ymi5aUnVidYJmU0m75HoaoiEKJmKmYpMeJZk7ChhNG5BL" +
       "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");
}
