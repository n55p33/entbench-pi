package org.apache.batik.util.gui.xmleditor;
public class XMLView extends javax.swing.text.PlainView {
    protected org.apache.batik.util.gui.xmleditor.XMLContext context = null;
    protected org.apache.batik.util.gui.xmleditor.XMLScanner lexer = new org.apache.batik.util.gui.xmleditor.XMLScanner(
      );
    protected int tabSize = 4;
    public XMLView(org.apache.batik.util.gui.xmleditor.XMLContext context,
                   javax.swing.text.Element elem) { super(elem);
                                                    this.context =
                                                      context; }
    public int getTabSize() { return tabSize; }
    protected int drawUnselectedText(java.awt.Graphics g, int x, int y,
                                     int p0,
                                     int p1) throws javax.swing.text.BadLocationException {
        org.apache.batik.util.gui.xmleditor.XMLDocument doc =
          (org.apache.batik.util.gui.xmleditor.XMLDocument)
            getDocument(
              );
        org.apache.batik.util.gui.xmleditor.XMLToken token =
          doc.
          getScannerStart(
            p0);
        java.lang.String str =
          doc.
          getText(
            token.
              getStartOffset(
                ),
            p1 -
              token.
              getStartOffset(
                ) +
              1);
        lexer.
          setString(
            str);
        lexer.
          reset(
            );
        int pos =
          token.
          getStartOffset(
            );
        int ctx =
          token.
          getContext(
            );
        int lastCtx =
          ctx;
        while (pos <
                 p0) {
            pos =
              lexer.
                scan(
                  ctx) +
                token.
                getStartOffset(
                  );
            lastCtx =
              ctx;
            ctx =
              lexer.
                getScanValue(
                  );
        }
        int mark =
          p0;
        while (pos <
                 p1) {
            if (lastCtx !=
                  ctx) {
                g.
                  setColor(
                    context.
                      getSyntaxForeground(
                        lastCtx));
                g.
                  setFont(
                    context.
                      getSyntaxFont(
                        lastCtx));
                javax.swing.text.Segment text =
                  getLineBuffer(
                    );
                doc.
                  getText(
                    mark,
                    pos -
                      mark,
                    text);
                x =
                  javax.swing.text.Utilities.
                    drawTabbedText(
                      text,
                      x,
                      y,
                      g,
                      this,
                      mark);
                mark =
                  pos;
            }
            pos =
              lexer.
                scan(
                  ctx) +
                token.
                getStartOffset(
                  );
            lastCtx =
              ctx;
            ctx =
              lexer.
                getScanValue(
                  );
        }
        g.
          setColor(
            context.
              getSyntaxForeground(
                lastCtx));
        g.
          setFont(
            context.
              getSyntaxFont(
                lastCtx));
        javax.swing.text.Segment text =
          getLineBuffer(
            );
        doc.
          getText(
            mark,
            p1 -
              mark,
            text);
        x =
          javax.swing.text.Utilities.
            drawTabbedText(
              text,
              x,
              y,
              g,
              this,
              mark);
        return x;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "7W4omhoAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "JQAA");
}
