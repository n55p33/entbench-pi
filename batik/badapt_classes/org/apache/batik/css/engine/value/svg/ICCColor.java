package org.apache.batik.css.engine.value.svg;
public class ICCColor extends org.apache.batik.css.engine.value.AbstractValue {
    protected java.lang.String colorProfile;
    protected int count;
    protected float[] colors = new float[5];
    public ICCColor(java.lang.String name) { super();
                                             colorProfile = name; }
    public short getCssValueType() { return org.w3c.dom.css.CSSValue.CSS_CUSTOM;
    }
    public java.lang.String getColorProfile() throws org.w3c.dom.DOMException {
        return colorProfile;
    }
    public int getNumberOfColors() throws org.w3c.dom.DOMException { return count;
    }
    public float getColor(int i) throws org.w3c.dom.DOMException {
        return colors[i];
    }
    public java.lang.String getCssText() { java.lang.StringBuffer sb =
                                             new java.lang.StringBuffer(
                                             count *
                                               8);
                                           sb.append("icc-color(");
                                           sb.append(colorProfile);
                                           for (int i = 0; i < count;
                                                i++) { sb.append(
                                                            ", ");
                                                       sb.append(
                                                            colors[i]);
                                           }
                                           sb.append(')');
                                           return sb.toString(); }
    public void append(float c) { if (count == colors.length) { float[] t =
                                                                  new float[count *
                                                                              2];
                                                                java.lang.System.
                                                                  arraycopy(
                                                                    colors,
                                                                    0,
                                                                    t,
                                                                    0,
                                                                    count);
                                                                colors =
                                                                  t;
                                  }
                                  colors[count++] =
                                    c; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "e8xQ5N8vAvFLYyIAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "iupV/wi64dc3F7aK4lBW9kcxsgtnV/Pj");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("6Hjk9aLjVALw3JkPiuXR36OPf8n+8O+LyudfoUc/8a3WZ/fHtRRbzvOilysM" +
       "9MD+5NjxB8Rn7trbUV+X+y9856Ffvvr8UUrx0F7gk1l2Sran7nw2inD8uDzN" +
       "lP/aO3/lff/4la+U36r+LwvHwnyTLQAA");
}
