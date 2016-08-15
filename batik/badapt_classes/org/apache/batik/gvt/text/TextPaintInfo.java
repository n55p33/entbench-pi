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
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "DMO5Noy+YfClPBq6U4ms4K/4FvsfUp5u59sjAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "PvIrb/5RsZH9/wCHH13lFi8AAA==");
}
