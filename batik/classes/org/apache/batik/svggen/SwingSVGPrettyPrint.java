package org.apache.batik.svggen;
public abstract class SwingSVGPrettyPrint implements org.apache.batik.svggen.SVGSyntax {
    public static void print(javax.swing.JComponent cmp, org.apache.batik.svggen.SVGGraphics2D svgGen) {
        if (cmp instanceof javax.swing.JComboBox ||
              cmp instanceof javax.swing.JScrollBar) {
            printHack(
              cmp,
              svgGen);
            return;
        }
        org.apache.batik.svggen.SVGGraphics2D g =
          (org.apache.batik.svggen.SVGGraphics2D)
            svgGen.
            create(
              );
        g.
          setColor(
            cmp.
              getForeground(
                ));
        g.
          setFont(
            cmp.
              getFont(
                ));
        org.w3c.dom.Element topLevelGroup =
          g.
          getTopLevelGroup(
            );
        if (cmp.
              getWidth(
                ) <=
              0 ||
              cmp.
              getHeight(
                ) <=
              0)
            return;
        java.awt.Rectangle clipRect =
          g.
          getClipBounds(
            );
        if (clipRect ==
              null)
            g.
              setClip(
                0,
                0,
                cmp.
                  getWidth(
                    ),
                cmp.
                  getHeight(
                    ));
        paintComponent(
          cmp,
          g);
        paintBorder(
          cmp,
          g);
        paintChildren(
          cmp,
          g);
        org.w3c.dom.Element cmpGroup =
          g.
          getTopLevelGroup(
            );
        cmpGroup.
          setAttributeNS(
            null,
            "id",
            svgGen.
              getGeneratorContext(
                ).
              idGenerator.
              generateID(
                cmp.
                  getClass(
                    ).
                  getName(
                    )));
        topLevelGroup.
          appendChild(
            cmpGroup);
        svgGen.
          setTopLevelGroup(
            topLevelGroup);
    }
    private static void printHack(javax.swing.JComponent cmp, org.apache.batik.svggen.SVGGraphics2D svgGen) {
        org.apache.batik.svggen.SVGGraphics2D g =
          (org.apache.batik.svggen.SVGGraphics2D)
            svgGen.
            create(
              );
        g.
          setColor(
            cmp.
              getForeground(
                ));
        g.
          setFont(
            cmp.
              getFont(
                ));
        org.w3c.dom.Element topLevelGroup =
          g.
          getTopLevelGroup(
            );
        if (cmp.
              getWidth(
                ) <=
              0 ||
              cmp.
              getHeight(
                ) <=
              0)
            return;
        java.awt.Rectangle clipRect =
          g.
          getClipBounds(
            );
        if (clipRect ==
              null) {
            g.
              setClip(
                0,
                0,
                cmp.
                  getWidth(
                    ),
                cmp.
                  getHeight(
                    ));
        }
        cmp.
          paint(
            g);
        org.w3c.dom.Element cmpGroup =
          g.
          getTopLevelGroup(
            );
        cmpGroup.
          setAttributeNS(
            null,
            "id",
            svgGen.
              getGeneratorContext(
                ).
              idGenerator.
              generateID(
                cmp.
                  getClass(
                    ).
                  getName(
                    )));
        topLevelGroup.
          appendChild(
            cmpGroup);
        svgGen.
          setTopLevelGroup(
            topLevelGroup);
    }
    private static void paintComponent(javax.swing.JComponent cmp,
                                       org.apache.batik.svggen.SVGGraphics2D svgGen) {
        javax.swing.plaf.ComponentUI ui =
          javax.swing.UIManager.
          getUI(
            cmp);
        if (ui !=
              null) {
            ui.
              installUI(
                cmp);
            ui.
              update(
                svgGen,
                cmp);
        }
    }
    private static void paintBorder(javax.swing.JComponent cmp,
                                    org.apache.batik.svggen.SVGGraphics2D svgGen) {
        javax.swing.border.Border border =
          cmp.
          getBorder(
            );
        if (border !=
              null) {
            if (cmp instanceof javax.swing.AbstractButton ||
                  cmp instanceof javax.swing.JPopupMenu ||
                  cmp instanceof javax.swing.JToolBar ||
                  cmp instanceof javax.swing.JMenuBar ||
                  cmp instanceof javax.swing.JProgressBar) {
                if (cmp instanceof javax.swing.AbstractButton &&
                      ((javax.swing.AbstractButton)
                         cmp).
                      isBorderPainted(
                        ) ||
                      cmp instanceof javax.swing.JPopupMenu &&
                      ((javax.swing.JPopupMenu)
                         cmp).
                      isBorderPainted(
                        ) ||
                      cmp instanceof javax.swing.JToolBar &&
                      ((javax.swing.JToolBar)
                         cmp).
                      isBorderPainted(
                        ) ||
                      cmp instanceof javax.swing.JMenuBar &&
                      ((javax.swing.JMenuBar)
                         cmp).
                      isBorderPainted(
                        ) ||
                      cmp instanceof javax.swing.JProgressBar &&
                      ((javax.swing.JProgressBar)
                         cmp).
                      isBorderPainted(
                        ))
                    border.
                      paintBorder(
                        cmp,
                        svgGen,
                        0,
                        0,
                        cmp.
                          getWidth(
                            ),
                        cmp.
                          getHeight(
                            ));
            }
            else {
                border.
                  paintBorder(
                    cmp,
                    svgGen,
                    0,
                    0,
                    cmp.
                      getWidth(
                        ),
                    cmp.
                      getHeight(
                        ));
            }
        }
    }
    private static void paintChildren(javax.swing.JComponent cmp,
                                      org.apache.batik.svggen.SVGGraphics2D svgGen) {
        int i =
          cmp.
          getComponentCount(
            ) -
          1;
        java.awt.Rectangle tmpRect =
          new java.awt.Rectangle(
          );
        for (;
             i >=
               0;
             i--) {
            java.awt.Component comp =
              cmp.
              getComponent(
                i);
            if (comp !=
                  null &&
                  javax.swing.JComponent.
                  isLightweightComponent(
                    comp) &&
                  comp.
                  isVisible(
                    )) {
                java.awt.Rectangle cr =
                  null;
                boolean isJComponent =
                  comp instanceof javax.swing.JComponent;
                if (isJComponent) {
                    cr =
                      tmpRect;
                    ((javax.swing.JComponent)
                       comp).
                      getBounds(
                        cr);
                }
                else {
                    cr =
                      comp.
                        getBounds(
                          );
                }
                boolean hitClip =
                  svgGen.
                  hitClip(
                    cr.
                      x,
                    cr.
                      y,
                    cr.
                      width,
                    cr.
                      height);
                if (hitClip) {
                    org.apache.batik.svggen.SVGGraphics2D cg =
                      (org.apache.batik.svggen.SVGGraphics2D)
                        svgGen.
                        create(
                          cr.
                            x,
                          cr.
                            y,
                          cr.
                            width,
                          cr.
                            height);
                    cg.
                      setColor(
                        comp.
                          getForeground(
                            ));
                    cg.
                      setFont(
                        comp.
                          getFont(
                            ));
                    if (comp instanceof javax.swing.JComponent)
                        print(
                          (javax.swing.JComponent)
                            comp,
                          cg);
                    else {
                        comp.
                          paint(
                            cg);
                    }
                }
            }
        }
    }
    public SwingSVGPrettyPrint() { super(
                                     ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVYfWwUxxWfO38bfx5gKAHzZZDMx10ooW1kSoKNbUzOYGFA" +
       "rZ1wjPfmfIv3dpfdOfvs1GmSKoG0FaKEJCRqqBIR5UMkRGmjtmoTUUUtpGkr" +
       "JUVt0yqkUv8o/UANqkT/oG363sze7d6e74AKLO14b/bNm/d+85v33sypS6TC" +
       "tkgr03mYT5rMDnfrfIBaNot3adS2d0FfTHmqjP5z78XtdwZJ5RBpSFK7X6E2" +
       "61GZFreHyCJVtznVFWZvZyyOIwYsZjNrnHLV0IfIXNXuS5maqqi834gzFNhD" +
       "rShpppxb6kiasz5HASeLomBJRFgS2ez/3BEldYphTrri8z3iXZ4vKJly57I5" +
       "aYrup+M0kuaqFomqNu/IWGS1aWiTo5rBwyzDw/u1DQ4E26IbCiBY9nrjlatH" +
       "kk0CgtlU1w0u3LN3MtvQxlk8Shrd3m6NpewD5AFSFiWzPMKctEWzk0Zg0ghM" +
       "mvXWlQLr65meTnUZwh2e1VRpKmgQJ0vzlZjUoilHzYCwGTRUc8d3MRi8XZLz" +
       "VnpZ4OITqyPHntrb9EYZaRwijao+iOYoYASHSYYAUJYaYZa9OR5n8SHSrMNi" +
       "DzJLpZo65ax0yFZHdcrTsPxZWLAzbTJLzOliBesIvllphRtWzr2EIJTzqyKh" +
       "0VHwtcX1VXrYg/3gYK0KhlkJCrxzhpSPqXqck8X+ETkf2+4BARhalWI8aeSm" +
       "KtcpdJCQpIhG9dHIIFBPHwXRCgMIaHGyoKhSxNqkyhgdZTFkpE9uQH4CqRoB" +
       "BA7hZK5fTGiCVVrgWyXP+lzavvHw/fpWPUgCYHOcKRraPwsGtfoG7WQJZjHY" +
       "B3Jg3arok7TlrUNBQkB4rk9Yynz/K5fvXtN65pyUuW0GmR0j+5nCY8rJkYb3" +
       "F3a131mGZlSbhq3i4ud5LnbZgPOlI2NChGnJacSP4ezHMzt/9uUHX2F/C5La" +
       "PlKpGFo6BTxqVoyUqWrM6mU6syhn8T5Sw/R4l/jeR6rgParqTPbuSCRsxvtI" +
       "uSa6Kg3xGyBKgAqEqBbeVT1hZN9NypPiPWMSQprgIZvgWUvkn/jPyd5I0kix" +
       "CFWorupGZMAy0H87AhFnBLBNRkaA9WMR20hbQMGIYY1GKPAgybIfxkdHmR4Z" +
       "nAAiDe7phZjI+eQA0ApCDfDMvOUzZNDH2ROBAMC/0L/5Ndg3Ww0tzqyYcizd" +
       "2X35tdh7kli4GRx0OFkNk4blpGExaVhOGp5hUhIIiLnm4ORymWGRxmC7Q7yt" +
       "ax+8b9u+Q8vKgF/mRDkgjKLL8vJOlxsTsoE8ppwO1U8tvbDunSApj5IQVXia" +
       "aphGNlujEKCUMWcP141ARnITwxJPYsCMZhkKi0NcKpYgHC3VxjizsJ+TOR4N" +
       "2bSFGzRSPGnMaD85c3zioT1fvT1Igvm5AKesgDCGwwcwgucidZs/Bsykt/Hg" +
       "xSunn5w23GiQl1yyObFgJPqwzM8GPzwxZdUS+mbsrek2AXsNRGtOYXdBIGz1" +
       "z5EXbDqygRt9qQaHE4aVohp+ymJcy5OWMeH2CJo2YzNXMhYp5DNQxPwvDprP" +
       "/u5Xf1kvkMymh0ZPXh9kvMMTklBZSASfZpeRuyzGQO6j4wOPP3Hp4LCgI0gs" +
       "n2nCNmy7IBTB6gCCj5w78OHHF06eD7oU5pCT0yNQ2mSEL3M+hb8APP/FB8MI" +
       "dshwEupyYtqSXFAzceaVrm0Q3jQIAEiOtt060FBNqHREY7h//t24Yt2bfz/c" +
       "JJdbg54sW9ZcW4Hb/5lO8uB7e//VKtQEFEyvLn6umIzZs13Nmy2LTqIdmYc+" +
       "WPT0WfosRH+IuLY6xUQQJQIPIhZwg8DidtHe4fv2eWxW2F6O528jTxkUU46c" +
       "/6R+zydvXxbW5tdR3nXvp2aHZJFcBZjsLuI0eUEdv7aY2M7LgA3z/IFqK7WT" +
       "oOyOM9vvbdLOXIVph2BaBYKvvcOCUJnJo5IjXVH1+5+807Lv/TIS7CG1mkHj" +
       "PVRsOFIDTGd2EqJsxrzrbmnHRHU25WRIAUIFHbgKi2de3+6UycWKTP1g3vc2" +
       "vnjigqClKXXc5lW4UrTt2KwR/UF8XctJNR2B6ADGZnK4ib/GErh51AfE+3wo" +
       "R4smiT29g5MQOTKI9qJilY2oyk4+fOxEfMcL62T9EcqvFrqhGH71N//5Rfj4" +
       "H9+dIUnVcMNcq7Fxpnmsw2PNorz00i+KPjfEfdRw9E8/bBvtvJHMgn2t18gd" +
       "+HsxOLGqeKbwm3L24b8u2LUpue8GksRiH5x+lS/3n3q3d6VyNCgqXJkfCirj" +
       "/EEdXmBhUkjtaUtHN7GnXmyx5TmqhJAZnfCsd6iy3r/FZDQvScFKWxwyXAIK" +
       "3jaX0OoLLkGpLkvFFlH4hG2sTsLbMOQaOnNOUPB5RQmm9lrUTKqK/dktwvDh" +
       "ElGMYrOLkwoT6x4gWnuJk6SlpiAdjTu1eGQ69PHYty++KnnuL9x9wuzQsa9/" +
       "Gj58THJenm6WFxwwvGPkCUcY2YRNGHfe0lKziBE9fz49/aOXpg8GHQejnJSP" +
       "G6o8IX0Bm91yiTb+n3EMOzpN0T+QW+vZ+K0XnmFnrYdvhEGcVAH845BIsfNL" +
       "PgqFSqidmUL4815s9opp0yXWfwIbKHhrxPpvdWJFwkXLuFVoRYUK+Ze50f1m" +
       "FQOqmMbrAuprJYB6BJtpThpMqB55bjv60HrgVqHVB8+jjm+P3jS0imm8LrS+" +
       "VQKtx7H5BiezBFqdBpYcPqi+eaugugee5x3Hnr9pUBXTeF1QfacEVM9h8zQn" +
       "9ZJYSVWLwxnEB9YzNwOsDCezZzjsYmU2v+BGTd4CKa+daKyed2L3b0Vlkbup" +
       "qYMaIZHWNE+K9abbStNiCVV4VyerWVP8e5mTeUXSFuZP8SKMf0nKn+KkyS8P" +
       "qUr898qd5qTWlQNV8sUr8gYnZSCCr981szm0SdSjeEsWlldCmUBhzSnwn3st" +
       "/HNDvAcwzKDiRjNb2KTlnWZMOX1i2/b7L3/uBXkAVDQ6NYVaZkVJlTxm5oqj" +
       "pUW1ZXVVbm2/2vB6zYpsxss7gHptEyyAYlcc1hb4TkR2W+5g9OHJjW//8lDl" +
       "B5Crh0mAAmuGPfeJEik4VqWhKh2OunWp50ZcHNU62p+Z3LQm8Y8/iHKeyGuS" +
       "hcXlY8r5F+/79dH5J+FIN6uPVEAyZ5khUqvaWyb1nUwZt4ZIvWp3Z8BE0KJS" +
       "rY9Up3X1QJr1xaOkAclJ8a5T4OLAWZ/rxZsBTpYV1hyF9ylw9JlgVqeR1uOo" +
       "ph4KWbcn76rVIXxt2jR9A9ye3FLOKfQ9pmx5rPHHR0JlPbDB8tzxqq+y0yO5" +
       "2tV7+yo6vCUSrjMwPRbtN83sgb32iikZ/1Mpg/2cBFY5vRgoAvIUhD/PCXVn" +
       "xSs2P/8faUXHuFgZAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "JAAA");
}
