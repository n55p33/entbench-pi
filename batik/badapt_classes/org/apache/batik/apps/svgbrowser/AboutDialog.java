package org.apache.batik.apps.svgbrowser;
public class AboutDialog extends javax.swing.JWindow {
    public static final java.lang.String ICON_BATIK_SPLASH = "AboutDialog.icon.batik.splash";
    public AboutDialog() { super();
                           buildGUI(); }
    public AboutDialog(java.awt.Frame owner) { super(owner);
                                               buildGUI();
                                               addKeyListener(new java.awt.event.KeyAdapter(
                                                                ) {
                                                                  public void keyPressed(java.awt.event.KeyEvent e) {
                                                                      if (e.
                                                                            getKeyCode(
                                                                              ) ==
                                                                            java.awt.event.KeyEvent.
                                                                              VK_ESCAPE) {
                                                                          setVisible(
                                                                            false);
                                                                          dispose(
                                                                            );
                                                                      }
                                                                  }
                                                              });
                                               addMouseListener(
                                                 new java.awt.event.MouseAdapter(
                                                   ) {
                                                     public void mousePressed(java.awt.event.MouseEvent e) {
                                                         setVisible(
                                                           false);
                                                         dispose(
                                                           );
                                                     }
                                                 });
    }
    public void setLocationRelativeTo(java.awt.Frame f) {
        java.awt.Dimension invokerSize =
          f.
          getSize(
            );
        java.awt.Point loc =
          f.
          getLocation(
            );
        java.awt.Point invokerScreenLocation =
          new java.awt.Point(
          loc.
            x,
          loc.
            y);
        java.awt.Rectangle bounds =
          getBounds(
            );
        int dx =
          invokerScreenLocation.
            x +
          (invokerSize.
             width -
             bounds.
               width) /
          2;
        int dy =
          invokerScreenLocation.
            y +
          (invokerSize.
             height -
             bounds.
               height) /
          2;
        java.awt.Dimension screenSize =
          getToolkit(
            ).
          getScreenSize(
            );
        if (dy +
              bounds.
                height >
              screenSize.
                height) {
            dy =
              screenSize.
                height -
                bounds.
                  height;
            dx =
              invokerScreenLocation.
                x <
                screenSize.
                  width >>
                1
                ? invokerScreenLocation.
                    x +
                invokerSize.
                  width
                : invokerScreenLocation.
                    x -
                bounds.
                  width;
        }
        if (dx +
              bounds.
                width >
              screenSize.
                width) {
            dx =
              screenSize.
                width -
                bounds.
                  width;
        }
        if (dx <
              0)
            dx =
              0;
        if (dy <
              0)
            dy =
              0;
        setLocation(
          dx,
          dy);
    }
    protected void buildGUI() { getContentPane(
                                  ).setBackground(
                                      java.awt.Color.
                                        white);
                                java.lang.ClassLoader cl =
                                  this.
                                  getClass(
                                    ).
                                  getClassLoader(
                                    );
                                java.net.URL url =
                                  cl.
                                  getResource(
                                    org.apache.batik.apps.svgbrowser.Resources.
                                      getString(
                                        ICON_BATIK_SPLASH));
                                javax.swing.ImageIcon icon =
                                  new javax.swing.ImageIcon(
                                  url);
                                int w = icon.
                                  getIconWidth(
                                    );
                                int h = icon.
                                  getIconHeight(
                                    );
                                javax.swing.JLayeredPane p =
                                  new javax.swing.JLayeredPane(
                                  );
                                p.setSize(
                                    600,
                                    425);
                                getContentPane(
                                  ).add(p);
                                javax.swing.JLabel l =
                                  new javax.swing.JLabel(
                                  icon);
                                l.setBounds(
                                    0,
                                    0,
                                    w,
                                    h);
                                p.add(l, new java.lang.Integer(
                                        0));
                                javax.swing.JLabel l2 =
                                  new javax.swing.JLabel(
                                  "Batik " +
                                  org.apache.batik.Version.
                                    getVersion(
                                      ));
                                l2.setForeground(
                                     new java.awt.Color(
                                       232,
                                       232,
                                       232,
                                       255));
                                l2.setOpaque(
                                     false);
                                l2.setBackground(
                                     new java.awt.Color(
                                       0,
                                       0,
                                       0,
                                       0));
                                l2.setHorizontalAlignment(
                                     javax.swing.JLabel.
                                       RIGHT);
                                l2.setVerticalAlignment(
                                     javax.swing.JLabel.
                                       BOTTOM);
                                l2.setBounds(
                                     w -
                                       320,
                                     h -
                                       117,
                                     300,
                                     100);
                                p.add(l2,
                                      new java.lang.Integer(
                                        2));
                                ((javax.swing.JComponent)
                                   getContentPane(
                                     )).setBorder(
                                          javax.swing.BorderFactory.
                                            createCompoundBorder(
                                              javax.swing.BorderFactory.
                                                createBevelBorder(
                                                  javax.swing.border.BevelBorder.
                                                    RAISED,
                                                  java.awt.Color.
                                                    gray,
                                                  java.awt.Color.
                                                    black),
                                              javax.swing.BorderFactory.
                                                createCompoundBorder(
                                                  javax.swing.BorderFactory.
                                                    createCompoundBorder(
                                                      javax.swing.BorderFactory.
                                                        createEmptyBorder(
                                                          3,
                                                          3,
                                                          3,
                                                          3),
                                                      javax.swing.BorderFactory.
                                                        createLineBorder(
                                                          java.awt.Color.
                                                            black)),
                                                  javax.swing.BorderFactory.
                                                    createEmptyBorder(
                                                      10,
                                                      10,
                                                      10,
                                                      10))));
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "F+VXXZs/eN3vvfkTz389P3/9X5mgYl6qIwAA");
}
