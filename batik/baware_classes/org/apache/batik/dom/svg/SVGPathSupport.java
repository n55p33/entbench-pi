package org.apache.batik.dom.svg;
public class SVGPathSupport {
    public static float getTotalLength(org.apache.batik.dom.svg.SVGOMPathElement path) {
        org.apache.batik.dom.svg.SVGPathContext pathCtx =
          (org.apache.batik.dom.svg.SVGPathContext)
            path.
            getSVGContext(
              );
        return pathCtx.
          getTotalLength(
            );
    }
    public static int getPathSegAtLength(org.apache.batik.dom.svg.SVGOMPathElement path,
                                         float x) { org.apache.batik.dom.svg.SVGPathContext pathCtx =
                                                      (org.apache.batik.dom.svg.SVGPathContext)
                                                        path.
                                                        getSVGContext(
                                                          );
                                                    return pathCtx.
                                                      getPathSegAtLength(
                                                        x);
    }
    public static org.w3c.dom.svg.SVGPoint getPointAtLength(final org.apache.batik.dom.svg.SVGOMPathElement path,
                                                            final float distance) {
        final org.apache.batik.dom.svg.SVGPathContext pathCtx =
          (org.apache.batik.dom.svg.SVGPathContext)
            path.
            getSVGContext(
              );
        if (pathCtx ==
              null)
            return null;
        return new org.w3c.dom.svg.SVGPoint(
          ) {
            public float getX() {
                java.awt.geom.Point2D pt =
                  pathCtx.
                  getPointAtLength(
                    distance);
                return (float)
                         pt.
                         getX(
                           );
            }
            public float getY() {
                java.awt.geom.Point2D pt =
                  pathCtx.
                  getPointAtLength(
                    distance);
                return (float)
                         pt.
                         getY(
                           );
            }
            public void setX(float x)
                  throws org.w3c.dom.DOMException {
                throw path.
                  createDOMException(
                    org.w3c.dom.DOMException.
                      NO_MODIFICATION_ALLOWED_ERR,
                    "readonly.point",
                    null);
            }
            public void setY(float y)
                  throws org.w3c.dom.DOMException {
                throw path.
                  createDOMException(
                    org.w3c.dom.DOMException.
                      NO_MODIFICATION_ALLOWED_ERR,
                    "readonly.point",
                    null);
            }
            public org.w3c.dom.svg.SVGPoint matrixTransform(org.w3c.dom.svg.SVGMatrix matrix) {
                throw path.
                  createDOMException(
                    org.w3c.dom.DOMException.
                      NO_MODIFICATION_ALLOWED_ERR,
                    "readonly.point",
                    null);
            }
        };
    }
    public SVGPathSupport() { super(); }
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
       "K53XKR/ag246LL9cdRF1EunyyaLLOV8LI98ZnSi9vOZQs/flGnsdeB7f1+zj" +
       "1y7rXtMK9o6sYGcAp4qHZ/ar8/tVmCduVP0X+Lz+n993ak5YUPNvUIrc5o0d" +
       "QnfpWjgCarY4zdFDo4AdHjOxSV4pslw5PDI+50eVBI6vVQysDrV1bz74evCg" +
       "+9pC/x+1tXcEVYwlBdQv3kAL782bd4TQPUALxe2JphPh9TVxk+kc08M7fww9" +
       "vDofhMFT39dD/Seuhw/dQA/P5M2vhtCFXA8ukPKEFoDl3ZdbXlxRTlw3uSfU" +
       "8fRLUUcCLO/kjVVecr/vqqvw3fWt8tlnz9/2qmfHf1Nc2hxesd7OQbctI8s6" +
       "XiE91j/r+drSLOS7fVcv9Yo/H98X51qOBPYYtAW7H9tB/1YIveJa0AAStMch" +
       "fxvo7zQk8J7i73G43wmhc0dwIXR21zkO8ilAHYDk3U9716jB7grKyZmTUftw" +
       "K+75UVtxLNA/diI8F/+ycBBKo90/LVxRPvcs23v7C7VP7u6eFEvOspzKbRx0" +
       "6+4a7DAcP3Jdage0ztJPvHjX529/7cGn464dw0fmfoy3h659udO2vbC4jsn+" +
       "6FV/8KbfffabRUn4/wA8qekcSyIAAA==");
}
