package org.apache.batik.gvt.flow;
class WordInfo {
    int index = -1;
    float ascent = -1;
    float descent = -1;
    float lineHeight = -1;
    org.apache.batik.gvt.flow.GlyphGroupInfo[] glyphGroups = null;
    java.lang.Object flowLine = null;
    WordInfo(int index) { super();
                          this.index = index; }
    WordInfo(int index, float ascent, float descent, float lineHeight, org.apache.batik.gvt.flow.GlyphGroupInfo[] glyphGroups) {
        super(
          );
        this.
          index =
          index;
        this.
          ascent =
          ascent;
        this.
          descent =
          descent;
        this.
          lineHeight =
          lineHeight;
        this.
          glyphGroups =
          glyphGroups;
    }
    public int getIndex() { return index; }
    public float getAscent() { return ascent; }
    public void setAscent(float ascent) { this.ascent = ascent; }
    public float getDescent() { return descent; }
    public void setDescent(float descent) { this.descent = descent;
    }
    public void addLineMetrics(org.apache.batik.gvt.font.GVTFont font,
                               org.apache.batik.gvt.font.GVTLineMetrics lm) {
        if (ascent <
              lm.
              getAscent(
                ))
            ascent =
              lm.
                getAscent(
                  );
        if (descent <
              lm.
              getDescent(
                ))
            descent =
              lm.
                getDescent(
                  );
    }
    public float getLineHeight() { return this.lineHeight; }
    public void setLineHeight(float lineHeight) { this.lineHeight =
                                                    lineHeight; }
    public void addLineHeight(float lineHeight) { if (this.lineHeight <
                                                        lineHeight)
                                                      this.
                                                        lineHeight =
                                                        lineHeight;
    }
    public java.lang.Object getFlowLine() { return this.flowLine;
    }
    public void setFlowLine(java.lang.Object fl) { this.flowLine =
                                                     fl; }
    public int getNumGlyphGroups() { if (glyphGroups == null) return -1;
                                     return glyphGroups.length; }
    public void setGlyphGroups(org.apache.batik.gvt.flow.GlyphGroupInfo[] glyphGroups) {
        this.
          glyphGroups =
          glyphGroups;
    }
    public org.apache.batik.gvt.flow.GlyphGroupInfo getGlyphGroup(int idx) {
        if (glyphGroups ==
              null)
            return null;
        return glyphGroups[idx];
    }
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
       "8W6glL/yfuJW+9WKN/tf/MQrryrsr1Qu");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("7B+SNqLSfZHn/6itblT7RFe7zSzqERuX8+4fBUd9z0b97CPZY6B/2Vcy/+qc" +
       "un+dF1+NSpd0Neofvag4luvX3sr7lDPYCjE/Dg50jw2989j+4Jy6/5gXXweK" +
       "ANjw49cMx+D+zW2Ae0d+8/3gwPbgsDsD7uCYgCwI/vgchH+SF98ECMNDhDd9" +
       "8rvxDOUY9R/drkp/EBwf2KP+wJ1X6f84p+57efHfo9L9QKUd9WY6/c7t6vQF" +
       "cFzfo7v+9uj0oHRriAcX8ptvAIjhKYh/dgzxz28X4o+B48U9xBfvDMQzL9qf" +
       "vvmmCs+NroElNeHtDfXW2y/2lPk7JkaNAkMOC+E8cI7gHsmLe6PSQ5KinGh3" +
       "WngHl27X+p8ER3cvvO4dt/6D955T92RePBqVHgTWT59+UXkM8LHbtY4yOIg9" +
       "QOJtmgDvPwflC3nxLEAZnkV5Qo1X7wRKco+SfJtQ1s5B2cgLGKDcW+tNUZZv" +
       "A+Uj+c0nwMHsUTJ33lg/fE5dKy+u5++v1YjYvy7O6X75GN4H70T8He7hDe+4" +
       "En+5wEGfg3GYFz2AMTyN8YQKydvAWCSHT4GD22Pk7rwK5+fUiXkxASk4UOEw" +
       "dnqnNyIcZ4kH09tV5AfBMduDnN1xRTIFGuUcpFpevARiB1DkGZgndPnR24CZ" +
       "58HFfpD5Hub8jsOsFlDO2VF1kO8XPLB2AeQYZk45OkZpv6UtVGDpcPjFRL4P" +
       "/LEbvr3afS8kf/nVy5cefXX273Y7Uw+/6bmPLl3SYts+uTnwxPk9fqBqRoH7" +
       "vt1WQb/AsY1KP3DLbZsg4c3/clYP0h39T0Wld92MPirdBcqTlB+LSlfOUkal" +
       "i8X/SbpPgATtmC7fV1WcnCT5WdA7IMlPP+nv/MlBIb/HTlpIkdE98mYiP7EO" +
       "ffbU9sPii7jDrYLx7pu4l+SvvEoNf/K7jV/Zfekg21KW5b1cokv37j66KDrN" +
       "txs+fcveDvu6h3z+jYd+/b7nDle2D+0YPrbWE7y97+bfF3QdPyq+CMj+0aP/" +
       "4IN/99U/LLa+/H/gxRKXqjgAAA==");
}
