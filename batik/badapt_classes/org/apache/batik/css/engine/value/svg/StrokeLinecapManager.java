package org.apache.batik.css.engine.value.svg;
public class StrokeLinecapManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_BUTT_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          BUTT_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_ROUND_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          ROUND_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_SQUARE_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          SQUARE_VALUE); }
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_IDENT; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_STROKE_LINECAP_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 BUTT_VALUE;
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public StrokeLinecapManager() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "O+ekTLYvOT07Gn8OebbZo9fAhPU41gzPRtsOG0dvwmKsJcx0qsTYM9h832/C" +
       "9RCrnGqsThT4WJPaVZdroRPXwEITcWw2PHFbzfjoLVSMtYQVflZi7EVsfmJZ" +
       "aBVL0YxiFeyOheaPXK+69MJwz10DwzXg2Bx4qK09Hb3hirGWMM7rJcZ+jc0Z" +
       "TiaA4TqSkC3hwM+surLbNcYv/xfGyEKeKHTrh0fUaXn/Q1h359LTw7WVU4fv" +
       "PCcK5dz9dg0UPqmMongPUZ73ct1gKVnoV2MdqXTx9TYncz/T7SREH2iFIucs" +
       "1nc5aR6RFU5WAzkU2YznOZleghFOVtaLl+cPYKlCPCAWtF7KD2DzBylBCvHt" +
       "pfuQk2qXDha1XrwkH8HsQIKvF3Vn39w0srlc1Nj+zIb8x68cihpGQpHnxDbH" +
       "V6aKP7OcOi5j/Z3VI50cXrf+nsufe8K6zpMUunMnzjIOqjfr0jB3YGkuOpsz" +
       "V/naBVcmnKqa65SVvutEr2wCy5CKxNVbY+B+y2zNXXO9c3TZC7/aV/4mFMRb" +
       "SIjCwWBL/tVBVs/ASXFLLL9KhcOduHhrW/Do0PLFqb++Ky5nSN6VTJC+Rzp7" +
       "7O63Dk472hQm4zrIWKiYWVbcaawaUjcyacCIk/GyuToLIqLfqOIrgSfgDqOY" +
       "QoRdbHOOz/XiPS8nLfmFff7teLWiDTJjpZZRkzgNFNHj3B7n4Oo782V0PcDg" +
       "9njOMlmrTkBvAGR7Yp267lySjunQRbAZKlw4YPupeMXm6n8BTYQt0OgeAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "zrLPy5nG+jVDWIx8SqCIedbHR12kW5B7n6Q2wyy284mHrJXuUmsoydYbtofp" +
       "hB5t+qgcop1tPU18ozFe1Qpab+9abcNdxoNJPAx3XX0ot7SRgPMG7zZXsIrK" +
       "dLNuKIldC9McbIhGrSLmZnnIhcWK5tcrG6y4YDkeeDkfp4UMg9BDNoJwtNZa" +
       "TVHe5FkvQbbUvkmNdmNZX9TI2h4pxorCdwxUUikc1mQYC/rcVBfpFbWdkyyc" +
       "yaScwoSo9FmW7YyWBm/mw2Uyh7tRXWD7a71WG+2boThuyRJD1aZFjON8C+16" +
       "YBu4nARYkdDzkbuYy7qhaVtttjL2GtgyePBgn0sRS69Ze82DWS7aTnfNLybR" +
       "1NSHPF/AiiuI7ZC1g75t45nFzt2uxKxiVQWrgzPuj4crlMRDjI/wNoiVBaPr" +
       "dMDCADaAieSRG2IwxRcx0sL9vbjKw8lUJ9SRv8XAriy2OCVohW1SWkyyOu9Y" +
       "YMf7g+VW2H5jpxGPVAcvp7eCKx8vKyZvYBd+qHqqTJ49PeSq/q7d5QD93CEj" +
       "VJ4svO9Ol33VqcLnP/7yKyb/hcbV48NZLYMeyKL4B3xrY/nnmroOWvrQnU9Q" +
       "uOqu8+zQ8Ksf/y+PSx9efvQNXIu8/5Kcl5v8J9wXf2fwAeNnrkL3nB4hvuYW" +
       "9iLT8xcPDh8Em/08CaULx4fvO9XsY6XGPgC+5rFmm7e/mritFVyprOAw9nc5" +
       "+/7xu9T9RJlsM+gxN6XDpZW4mWUKSVTda1cMP3zOYD6aQdf1KPItLTwzpt3r" +
       "Hemc77IqyC6iLw9MXzhG/8Jbj/5Td6n7e2Xy0xn0djclQjfQsvLS4gR+Wfex" +
       "M5yfeLM4nwUfdYyTeutx/vxd6n6hTH4mgx51y0cO1RHfHVD+7JtAeaMsfAJ8" +
       "zDFK5q1H+Q/vUveFMnklg244VnYC7/RO8JId3+Mevz6pUP+DN4H60bLwKfBN" +
       "j1FP33rUv3qXul8rky9dRD0+9j+TM4hffhMQqyXgSfCpxxDVtx7ib9+l7tUy" +
       "+c0DRLD/1HL/cNVzcp3wwde/Djmjr7Txz96ENt5RFj4DPu1YG9pbr42v36Xu" +
       "98rkqxn0MNAGbVphVl44HN4aDc8Qfu2NINwBF3i7twzlZey7X/O66vAiyPjy" +
       "Kzfuf9crs39TXeefvtp5gIXut3PfP393di5/LU4s261wPHC4SYurf3+YQc/+" +
       "td5cgKkL0grBNw6sf5xBT70ua3Z8FXSe8d9n0HvuwphB1w6Z8zzfBJq6HQ8Q" +
       "C6TnKf9jBt28TAmkqP6fp/vTDHrwjA50esicJ/kz0DogKbPfjk+MHn19dZ1Z" +
       "x/F47q5cDNROreXR17OWc7HdMxcisuqJ3kn0lB8e6b1ofOUVZvxj32194fBk" +
       "wvC1oihbuZ+Frh9eb5xGYE/dsbWTtq4Nn/vew7/ywLMn0eLDB4HPJtk52d5/" +
       "+zcJvSDOqlcExW+869de+EevfLO69ft/QMI3sjspAAA=");
}
