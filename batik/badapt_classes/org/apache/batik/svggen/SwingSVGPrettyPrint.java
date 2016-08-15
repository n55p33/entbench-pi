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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "8YrNz/8Hz428olgZAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "xkXQucj1XmcpiWIdWTS7UnzN9V/eh/kt0+HZztfe+6/3MW/U3/4iTq8fPMHn" +
       "ySk/M3z2G8SrpY/uQKcPTnquuv86Pujy8fOd84ESxYHDHDvluf/ABndmKm+D" +
       "p7Jng8q1T5BvYNvcmbZ+dOKccmdLtW+6u/Nbi90wu1rY7WcnQ66j7F1/gu5H" +
       "b2BZIhA83ZDC8nah5AYHou/MCj+CznjZpUVOMj3iu2wE3ZS4hnzo1MELHUcc" +
       "XSFvcA7Ud1fWSIDnLXvqe8uLUV8E3QKYTIRIeUEdZj9XWbHOqT54AwX8elb8" +
       "GnDpXAFdQTKzhncdCvy+lyowmZNuP+mL9ZcnXqysH7+BrE9lxW9G0O2eAGQ9" +
       "cKkTAn/0pQrcA8/79wR+/89d4E/dQOBnsuKTEfSyXOC2m520n5D26Zcq7QA8" +
       "n9qT9lM/d2k/fwNpv5gVn4mg27bm1Q1LDhTnhLyffTHyphF01zXuNrPLmXuv" +
       "+gPF9tJf+vzTF87e8/Tsb/LrvYOL+XMkdFaNLevoWfqR+s1eoKhGLsW57cm6" +
       "l399OYLuuQ7QZSfpeSXn+g+39H8cQRdP0gNwy7+P0n0lgs4f0oGptpWjJM9F" +
       "0GlAklW/6l3jFH57pZCeOrID7jlIruc7X0jPB0OO3v5lu2b+B5b9HS7e/oXl" +
       "ivSFp/vUO56vf3p7+yhZwmaTzXKWhG7ZXoQe7JIPX3e2/blu7j7209u/eO7R" +
       "/R399i3Dh856hLcHr329h9telF/Ibf7onj94/e8+/d38UuD/AdwwC4dZJAAA");
}
