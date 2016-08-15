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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "aNtTw5oaAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
