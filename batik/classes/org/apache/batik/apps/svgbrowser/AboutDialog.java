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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "AM/hkjqWPcHsrisS3kX8rJRSs9jaTubtkjmRJIOGE55NS8NSI0lhPuhSJYTv" +
       "WVUb44djflsaZR2hrHfndrWrDGTeVu0pzKzl1myrowYxEbm+IABf6eB6tVRf" +
       "r7zyarqeDq1Fh9kMk7k0LE8Hq6q3nDT5EuCovJBNtNqPe7bd1C2yUmrM2pqL" +
       "lEcOu02WLrOsTrP5ZlTnstRTumjWayDIUh9oXXOmqjLhmo0uaaDloajLaLxh" +
       "lrFH4FO7Q/adhjmOFrVqw+Dx7XiymSxQW5zFDI/SajPm20xaL/HrbjeLfCnJ" +
       "XKSE+YM4wDrVecs1rFkfo9EAXlJZU1LctY83jUBOmdWkNw8rZL81iEcLh+9L" +
       "k0kXjaoq6mE4tm1QnXaqSQ3OSsu+nRFDHNlUIrFZQxK4EuMK3JdHfIiavEp7" +
       "4y285bpaUHar3qo0h+HmbKY3qp0pTGRNIo7oOLOJflydY02EI8vaIFljMOpl" +
       "DUePKC9a1TtmF4VXPZTp890Ztp5FmwZaq2e+MTOBu/jI0ALA4AyW8sbibMgi" +
       "I6mUtkbDLVmBdVagNktXyvTmZCOUyAWJwVGzgzBzTqhO3LEy23gbuIGyLNIQ" +
       "2QVeMpVFQMvI1Op21IDUiX6D0CVVkRt4UvGq3jAMOpEXLvutqmXhXpUZU/Na" +
       "dR0p7ApnXN+tYOsa7mVKNu8pvZoTySRpOJu0IUoDmpvCfms4I/02VkHlAWmG" +
       "fXswQCKwZtbLlXmrWSk1sbq4jms8IWANqpzUYJ30R0R/u9a7jUG25HVTCrCY" +
       "2KplQ4ARZtvqNWZdJsARWNXX2byy7Xt9w+SmgwyuGLCKIj43cWykhsj1XrNv" +
       "T9eak2StPtKJshRmWSHxTcykdaNsZPys04FtW3YztjI3B+EaCfBtF0lEURRQ" +
       "0lX1Pl11LYwaUTzeWbmlukCWRQ7DkCwbrnW9jDXYLinBwAVmlTaepHKVcZkY" +
       "1motzKjE/iC0VvURWarN1sN5qSmvyqtRfUWvsvHKi4Keu0FgpZJ0bT5a86iT" +
       "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");
}
