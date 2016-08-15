package org.apache.batik.util.gui.xmleditor;
public class XMLDocument extends javax.swing.text.PlainDocument {
    protected org.apache.batik.util.gui.xmleditor.XMLScanner lexer;
    protected org.apache.batik.util.gui.xmleditor.XMLContext context;
    protected org.apache.batik.util.gui.xmleditor.XMLToken cacheToken = null;
    public XMLDocument() { this(new org.apache.batik.util.gui.xmleditor.XMLContext(
                                  )); }
    public XMLDocument(org.apache.batik.util.gui.xmleditor.XMLContext context) {
        super(
          );
        this.
          context =
          context;
        lexer =
          new org.apache.batik.util.gui.xmleditor.XMLScanner(
            );
    }
    public org.apache.batik.util.gui.xmleditor.XMLToken getScannerStart(int pos)
          throws javax.swing.text.BadLocationException { int ctx =
                                                           org.apache.batik.util.gui.xmleditor.XMLScanner.
                                                             CHARACTER_DATA_CONTEXT;
                                                         int offset =
                                                           0;
                                                         int tokenOffset =
                                                           0;
                                                         if (cacheToken !=
                                                               null) {
                                                             if (cacheToken.
                                                                   getStartOffset(
                                                                     ) >
                                                                   pos) {
                                                                 cacheToken =
                                                                   null;
                                                             }
                                                             else {
                                                                 ctx =
                                                                   cacheToken.
                                                                     getContext(
                                                                       );
                                                                 offset =
                                                                   cacheToken.
                                                                     getStartOffset(
                                                                       );
                                                                 tokenOffset =
                                                                   offset;
                                                                 javax.swing.text.Element element =
                                                                   getDefaultRootElement(
                                                                     );
                                                                 int line1 =
                                                                   element.
                                                                   getElementIndex(
                                                                     pos);
                                                                 int line2 =
                                                                   element.
                                                                   getElementIndex(
                                                                     offset);
                                                                 if (line1 -
                                                                       line2 <
                                                                       50) {
                                                                     return cacheToken;
                                                                 }
                                                             }
                                                         }
                                                         java.lang.String str =
                                                           getText(
                                                             offset,
                                                             pos -
                                                               offset);
                                                         lexer.
                                                           setString(
                                                             str);
                                                         lexer.
                                                           reset(
                                                             );
                                                         int lastCtx =
                                                           ctx;
                                                         int lastOffset =
                                                           offset;
                                                         while (offset <
                                                                  pos) {
                                                             lastOffset =
                                                               offset;
                                                             lastCtx =
                                                               ctx;
                                                             offset =
                                                               lexer.
                                                                 scan(
                                                                   ctx) +
                                                                 tokenOffset;
                                                             ctx =
                                                               lexer.
                                                                 getScanValue(
                                                                   );
                                                         }
                                                         cacheToken =
                                                           new org.apache.batik.util.gui.xmleditor.XMLToken(
                                                             lastCtx,
                                                             lastOffset,
                                                             offset);
                                                         return cacheToken;
    }
    public void insertString(int offset, java.lang.String str,
                             javax.swing.text.AttributeSet a)
          throws javax.swing.text.BadLocationException {
        super.
          insertString(
            offset,
            str,
            a);
        if (cacheToken !=
              null) {
            if (cacheToken.
                  getStartOffset(
                    ) >=
                  offset) {
                cacheToken =
                  null;
            }
        }
    }
    public void remove(int offs, int len)
          throws javax.swing.text.BadLocationException {
        super.
          remove(
            offs,
            len);
        if (cacheToken !=
              null) {
            if (cacheToken.
                  getStartOffset(
                    ) >=
                  offs) {
                cacheToken =
                  null;
            }
        }
    }
    public int find(java.lang.String str,
                    int fromIndex,
                    boolean caseSensitive)
          throws javax.swing.text.BadLocationException {
        int offset =
          -1;
        int startOffset =
          -1;
        int len =
          0;
        int charIndex =
          0;
        javax.swing.text.Element rootElement =
          getDefaultRootElement(
            );
        int elementIndex =
          rootElement.
          getElementIndex(
            fromIndex);
        if (elementIndex <
              0) {
            return offset;
        }
        charIndex =
          fromIndex -
            rootElement.
            getElement(
              elementIndex).
            getStartOffset(
              );
        for (int i =
               elementIndex;
             i <
               rootElement.
               getElementCount(
                 );
             i++) {
            javax.swing.text.Element element =
              rootElement.
              getElement(
                i);
            startOffset =
              element.
                getStartOffset(
                  );
            if (element.
                  getEndOffset(
                    ) >
                  getLength(
                    )) {
                len =
                  getLength(
                    ) -
                    startOffset;
            }
            else {
                len =
                  element.
                    getEndOffset(
                      ) -
                    startOffset;
            }
            java.lang.String text =
              getText(
                startOffset,
                len);
            if (!caseSensitive) {
                text =
                  text.
                    toLowerCase(
                      );
                str =
                  str.
                    toLowerCase(
                      );
            }
            charIndex =
              text.
                indexOf(
                  str,
                  charIndex);
            if (charIndex !=
                  -1) {
                offset =
                  startOffset +
                    charIndex;
                break;
            }
            charIndex =
              0;
        }
        return offset;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "FO8f8ledK+CR7V0hj35D5WMN2KdQ1G7486uOkWp5xYxlS1jc4zkD07Osl7lj" +
       "hmqIC/Wt3PbHn4c5wUlsjjJSpWgWnIE9CzxixyB+PcpI0YCuxF07H/uk7NzC" +
       "7SM+20dv53ysATuExD0NtzNv+NTfH8laz2PzXTj1mjQJWQV/nXJt8uwnYJMa" +
       "HBsLz25bsd2jt0k+1vyx9203AL/sCYNASJTGdF2lkpbLXgfE/j8/kkV/gc1Z" +
       "hrebWtxdldvzJx/LmYiRSs9NHh5BJ2X9dSCuu+Wnj9WUTTx2zxu88MhcSVdB" +
       "FkqkVNVb9nveSwyTJhSuTJU4BBj86yLg/U3UfVAlZd65DhcE++uMTM7LDhAP" +
       "rZf8TUbG5yQH0+KXl/ZtwJQgLZwb+LeX7jIUsy4dRL148ZL8DiQBEnx9z3Bw" +
       "qSELlzpVOOM5LkgX+CvQjL/Hj+RvT9Ha5Mva/C8jJ7WlxJ9GPfKZY2vX3X/t" +
       "00+KCzNZlYaGcJZKSGji7i5Ts83KO5szV8malhtjnimf7WTZOiGwu/mmeg73" +
       "yyDEDYy0KYHbJKs5c6n01vElZ3+5t+Qi1AebSYHEyNjN2efTtJGCYnlzNDtx" +
       "Q33Lr7laW765Y+n8xF/f5vclRCT6afnpe+RLJ+577cCk4w0hUtlOimHX0TQ/" +
       "OK/YoW2g8oDZTaoVa2UaRIRZFEn1VQVjcFNImCO4XWxzVmd68bqVkcbsOif7" +
       "krpC1QepuVxPiX0PdUWl2+P7L8veaBUpwwgwuD2eWvAxgVLoDYjOnmiHYThl" +
       "YOEig8PCgdyQhe2H/BWb6/8F/7hvFk4eAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "IcGjHAlK+cYI6p5Tf/pY6SvH7D9+G/udOA6L3ZLisKDE9a/vLMDi9Z+XAJ8t" +
       "in8RQw9YXqSF8X4/9E46uXfrW2cE9fNfr6CeL2Wz/22+MYI62B+xnwjqYyXU" +
       "f3gtEfxKUfxiDF0JNdfflj7wb04Z/aWvg9HrReNbwPPDR4z+8DfcIsrA+bE7" +
       "Keyq7PuOJu3N/wuvJYTfKYpfjYu7JJ56irMUwX96Q+duMfSmM/cjisPeR2+7" +
       "kLW/RKR85uXr9739Ze73yysCJxd97qeg+/TEcc6eQp2pXwlCTbdKou/fn0kF" +
       "5d8XY+jZ13FAAQL5Sb0k/r/su/9+DH3TXbuDkATKs+B/EENvuyM4EGHxdxb2" +
       "D2PoxkXYGLpc/p+F+3IMXTuFAwa5r5wF+Z+AEgBSVP84OI4DT9wWB2aOZHnH" +
       "KsgunZ/7TvT68Gvp9cx0+ey5Sa68iHc8ISX7q3i3lM++PJp8/1dbP7e/OaGA" +
       "tLU0yfso6Or+EsfJpPb0XbEd47oyeP5rD37u/ueOJ+AH9wSf+ssZ2p688zWF" +
       "rhvE5cWC/Jfe/u++/edf/qPysOX/AZoES/MhKQAA");
}
