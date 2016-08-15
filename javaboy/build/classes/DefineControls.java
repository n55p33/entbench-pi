public class DefineControls extends java.awt.Frame implements java.awt.event.KeyListener, java.awt.event.WindowListener, java.awt.event.ActionListener {
    java.awt.TextField[] controlsField = new java.awt.TextField[8];
    java.util.Hashtable keyNames;
    public DefineControls() { super("Define Controls");
                              keyNames = new java.util.Hashtable();
                              keyNames.put(new java.lang.Integer(38), "Up arrow");
                              keyNames.put(new java.lang.Integer(40), "Down arrow");
                              keyNames.put(new java.lang.Integer(37), "Left arrow");
                              keyNames.put(new java.lang.Integer(39), "Right arrow");
                              keyNames.put(new java.lang.Integer(36), "Pad 7");
                              keyNames.put(new java.lang.Integer(33), "Pad 9");
                              keyNames.put(new java.lang.Integer(35), "Pad 1");
                              keyNames.put(new java.lang.Integer(64), "Pad 3");
                              keyNames.put(new java.lang.Integer(12), "Pad 5");
                              keyNames.put(new java.lang.Integer(155), "Insert");
                              keyNames.put(new java.lang.Integer(36), "Home");
                              keyNames.put(new java.lang.Integer(33), "Page up");
                              keyNames.put(new java.lang.Integer(127), "Delete");
                              keyNames.put(new java.lang.Integer(35), "End");
                              keyNames.put(new java.lang.Integer(34), "Page down");
                              keyNames.put(new java.lang.Integer(10), "Return");
                              keyNames.put(new java.lang.Integer(16), "Shift");
                              keyNames.put(new java.lang.Integer(17), "Control");
                              keyNames.put(new java.lang.Integer(18), "Alt");
                              keyNames.put(new java.lang.Integer(32), "Space");
                              keyNames.put(new java.lang.Integer(20), "Caps lock");
                              keyNames.put(new java.lang.Integer(8), "Backspace");
                              java.awt.GridLayout g = new java.awt.GridLayout(
                                9,
                                2,
                                12,
                                12);
                              setLayout(g);
                              controlsField[0] = addControlsLine("D-pad up:");
                              controlsField[1] = addControlsLine("D-pad down:");
                              controlsField[2] = addControlsLine("D-pad left:");
                              controlsField[3] = addControlsLine("D-pad right:");
                              controlsField[4] = addControlsLine("A button:");
                              controlsField[5] = addControlsLine("B button:");
                              controlsField[6] = addControlsLine("Start button:");
                              controlsField[7] = addControlsLine("Select button:");
                              for (int r = 0; r < 8; r++) { controlsField[r].
                                                              setText(
                                                                getKeyDesc(
                                                                  JavaBoy.
                                                                    keyCodes[r],
                                                                  (char)
                                                                    JavaBoy.
                                                                      keyCodes[r]) +
                                                                " (" +
                                                                JavaBoy.
                                                                  keyCodes[r] +
                                                                ")");
                              }
                              java.awt.Button cancel = new java.awt.Button(
                                "Close");
                              cancel.setActionCommand("Controls close");
                              cancel.addActionListener(this);
                              add(cancel);
                              setSize(230, 300);
                              setResizable(false);
                              addWindowListener(this);
                              show(); }
    public java.lang.String getKeyDesc(int code, char c) { if (keyNames.
                                                                 containsKey(
                                                                   new java.lang.Integer(
                                                                     code))) {
                                                               return (java.lang.String)
                                                                        keyNames.
                                                                        get(
                                                                          new java.lang.Integer(
                                                                            code));
                                                           }
                                                           else {
                                                               return c +
                                                               "";
                                                           }
    }
    public java.awt.TextField addControlsLine(java.lang.String name) {
        add(
          new java.awt.Label(
            name));
        java.awt.TextField t =
          new java.awt.TextField(
          4);
        t.
          addKeyListener(
            this);
        add(
          t);
        return t;
    }
    public void keyPressed(java.awt.event.KeyEvent e) {
        
    }
    public void keyReleased(java.awt.event.KeyEvent e) {
        java.lang.System.
          out.
          println(
            e.
              getKeyCode(
                ) +
            ", " +
            e.
              getKeyChar(
                ));
        for (int r =
               0;
             r <
               8;
             r++) {
            if (e.
                  getSource(
                    ) ==
                  controlsField[r]) {
                controlsField[r].
                  setText(
                    getKeyDesc(
                      e.
                        getKeyCode(
                          ),
                      e.
                        getKeyChar(
                          )) +
                    " (" +
                    e.
                      getKeyCode(
                        ) +
                    ")");
                JavaBoy.
                  keyCodes[r] =
                  e.
                    getKeyCode(
                      );
            }
        }
    }
    public void keyTyped(java.awt.event.KeyEvent e) {
        
    }
    public void windowClosed(java.awt.event.WindowEvent e) {
        
    }
    public void windowClosing(java.awt.event.WindowEvent e) {
        hide(
          );
    }
    public void windowOpened(java.awt.event.WindowEvent e) {
        
    }
    public void windowIconified(java.awt.event.WindowEvent e) {
        
    }
    public void windowDeiconified(java.awt.event.WindowEvent e) {
        
    }
    public void windowActivated(java.awt.event.WindowEvent e) {
        
    }
    public void windowDeactivated(java.awt.event.WindowEvent e) {
        
    }
    public void actionPerformed(java.awt.event.ActionEvent e) {
        hide(
          );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1470933729000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1470933729000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "ot/01vU1nLpTvRvvLD8aCaC76eeoN0apqebuOMDuYCOJ3M3CxXJm0iy+tFej" +
       "zbJptYmd57O2QQWtLpuq8s7NrBWeU7wbpgtDXUMms3FCr61ypqMxIN/i+WyM" +
       "shiyRWilDQLTOkQMdWEykzEM+9CHyiOO7Ns7ZXqgOlA7uqe3nHb5Qv42TlcO" +
       "Biyrp45OGau/22tn7nZP3j8dX0rccnh498jRKa+6Vb34MqVWFz/lkfchyaNn" +
       "SFamp/jpG1Fh1dXSIVV5QPXo9W77q8Opz370yssK+/Pg4elpFNfuiv3gA07B" +
       "zjkx8/sKTu+7/kHcuDr6Pr7T+N2P/s9H5t9rPPdt3NS+58w8z7L8J+NXfn/w" +
       "nfLfO1+75eiG46rPME53eub0vcbdoRonoTc/dbvx6JEiL5R6e1dR7ANF2meP" +
       "i49N5SqjO1cZ3d7UzlzNna8Izle/vRMmFsa1W8yDL2/OtN8qG2JYMbtyg3u+" +
       "z5TVT8W1u3U1Lgyop0aVMcvHxvziGx0VnmRZNfzEkTgeLBufKEp0II7ozRHH" +
       "uWMCuSL4hRtA/MWy+odx7YKoKIcfGpRfZZTNo2Oc/+gmcJaktSeL8vwBzuff" +
       "VJyHjvrw1R5PlA9V31+5gQj+eVl9rtCyre4moRpFqnJNk9n6pnIskc/frEQu" +
       "FeUjBxL5yJuu+X9aEfz2DWD/Tln9Vly7p4DNqY4qFrjLpl8/xvgvbxZjad0/" +
       "eoDxR98ijP/2Bhi/VFb/Zn+zVkalswC/eLMAv7soP3kA8CffErM+u5DtV6lj" +
       "y/6PN4D/Wln9SVy7N6064Y5/tY7/3c2K4OmivHggghffdB3/p4rgqzcA+bWy" +
       "+vO4dt8xyIO7uhMo//uboegrByivvEUov3kDlH9ZVt84UiUbFNnHWVW+frMg" +
       "60X51AHIT701IM+duz7Ic1Vi+VfFYrQHScq+V91TnsH51zeLs0wgf+YA58+8" +
       "RTjvuwHOC2V1Z5Ew73H2VPPaSM/d9WZo9KUDpC+9RUjfdQOk31FWbz/SaJk8" +
       "b8tPTs7gfOjN0OjPHuD82bcI51M3wPld");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("ZfX4CY2K10H6xJuh0Z87QPpzbyrS6604+x3P0YpzDryBHJCyen+ZTladJmpY" +
       "flN5lRQ+8O1IIbvqS9ggOJzr/Udz7RdbHTXbg3jnSflVIePBNxrwqMvJLyfL" +
       "XVj1Xf7hjimZHHx884WXR8zzr7d+fv/lpuyIeV5yuZOu3bH/iLRiWu66nrgu" +
       "t0Netw+f/tb9v3zXU4c7xPv3Ez7W5Ym5vefan0kSbhBX+9v81x/+Z9/zj1/+" +
       "s+qDkf8HewoIQjAxAAA=");
}
