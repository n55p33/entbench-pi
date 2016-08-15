package org.apache.batik.gvt.text;
public class TextPaintInfo {
    public boolean visible;
    public java.awt.Paint fillPaint;
    public java.awt.Paint strokePaint;
    public java.awt.Stroke strokeStroke;
    public java.awt.Composite composite;
    public java.awt.Paint underlinePaint;
    public java.awt.Paint underlineStrokePaint;
    public java.awt.Stroke underlineStroke;
    public java.awt.Paint overlinePaint;
    public java.awt.Paint overlineStrokePaint;
    public java.awt.Stroke overlineStroke;
    public java.awt.Paint strikethroughPaint;
    public java.awt.Paint strikethroughStrokePaint;
    public java.awt.Stroke strikethroughStroke;
    public int startChar;
    public int endChar;
    public TextPaintInfo() { super(); }
    public TextPaintInfo(org.apache.batik.gvt.text.TextPaintInfo pi) { super(
                                                                         );
                                                                       set(
                                                                         pi);
    }
    public void set(org.apache.batik.gvt.text.TextPaintInfo pi) { if (pi ==
                                                                        null) {
                                                                      this.
                                                                        fillPaint =
                                                                        null;
                                                                      this.
                                                                        strokePaint =
                                                                        null;
                                                                      this.
                                                                        strokeStroke =
                                                                        null;
                                                                      this.
                                                                        composite =
                                                                        null;
                                                                      this.
                                                                        underlinePaint =
                                                                        null;
                                                                      this.
                                                                        underlineStrokePaint =
                                                                        null;
                                                                      this.
                                                                        underlineStroke =
                                                                        null;
                                                                      this.
                                                                        overlinePaint =
                                                                        null;
                                                                      this.
                                                                        overlineStrokePaint =
                                                                        null;
                                                                      this.
                                                                        overlineStroke =
                                                                        null;
                                                                      this.
                                                                        strikethroughPaint =
                                                                        null;
                                                                      this.
                                                                        strikethroughStrokePaint =
                                                                        null;
                                                                      this.
                                                                        strikethroughStroke =
                                                                        null;
                                                                      this.
                                                                        visible =
                                                                        false;
                                                                  }
                                                                  else {
                                                                      this.
                                                                        fillPaint =
                                                                        pi.
                                                                          fillPaint;
                                                                      this.
                                                                        strokePaint =
                                                                        pi.
                                                                          strokePaint;
                                                                      this.
                                                                        strokeStroke =
                                                                        pi.
                                                                          strokeStroke;
                                                                      this.
                                                                        composite =
                                                                        pi.
                                                                          composite;
                                                                      this.
                                                                        underlinePaint =
                                                                        pi.
                                                                          underlinePaint;
                                                                      this.
                                                                        underlineStrokePaint =
                                                                        pi.
                                                                          underlineStrokePaint;
                                                                      this.
                                                                        underlineStroke =
                                                                        pi.
                                                                          underlineStroke;
                                                                      this.
                                                                        overlinePaint =
                                                                        pi.
                                                                          overlinePaint;
                                                                      this.
                                                                        overlineStrokePaint =
                                                                        pi.
                                                                          overlineStrokePaint;
                                                                      this.
                                                                        overlineStroke =
                                                                        pi.
                                                                          overlineStroke;
                                                                      this.
                                                                        strikethroughPaint =
                                                                        pi.
                                                                          strikethroughPaint;
                                                                      this.
                                                                        strikethroughStrokePaint =
                                                                        pi.
                                                                          strikethroughStrokePaint;
                                                                      this.
                                                                        strikethroughStroke =
                                                                        pi.
                                                                          strikethroughStroke;
                                                                      this.
                                                                        visible =
                                                                        pi.
                                                                          visible;
                                                                  }
    }
    public static boolean equivilent(org.apache.batik.gvt.text.TextPaintInfo tpi1,
                                     org.apache.batik.gvt.text.TextPaintInfo tpi2) {
        if (tpi1 ==
              null) {
            if (tpi2 ==
                  null)
                return true;
            return false;
        }
        else
            if (tpi2 ==
                  null)
                return false;
        if (tpi1.
              fillPaint ==
              null !=
              (tpi2.
                 fillPaint ==
                 null))
            return false;
        if (tpi1.
              visible !=
              tpi2.
                visible)
            return false;
        boolean tpi1Stroke =
          tpi1.
            strokePaint !=
          null &&
          tpi1.
            strokeStroke !=
          null;
        boolean tpi2Stroke =
          tpi2.
            strokePaint !=
          null &&
          tpi2.
            strokeStroke !=
          null;
        return tpi1Stroke ==
          tpi2Stroke;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "DMO5Now+bvClPBq6U4ms4K/4FvsfLwOY79sjAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "x8VG9v8D2xzWihYvAAA=");
}
