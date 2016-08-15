public class JavaBoy extends java.applet.Applet implements java.lang.Runnable, java.awt.event.KeyListener, java.awt.event.WindowListener, java.awt.event.MouseListener, java.awt.event.ActionListener, java.awt.event.ItemListener, ent.runtime.ENT_Attributable {
    int[] HACK = new int[] { 0, 0, 0 };
    public int ENT_attribute() { if (ent.runtime.ENT_Util.Battery.percentRemaining(
                                                                    ) >=
                                       0.75) { return EntMode.HIGH_MODE;
                                 }
                                 else
                                     if (ent.runtime.ENT_Util.
                                           Battery.
                                           percentRemaining(
                                             ) >=
                                           0.5) {
                                         return EntMode.
                                                  MID_MODE;
                                     }
                                     else {
                                         return EntMode.
                                                  LOW_MODE;
                                     } }
    private final int WIDTH = 160;
    private final int HEIGHT = 144;
    private final java.lang.String WEBSITE_URL = "http://www.millstone.demon.co.uk/download/javaboy";
    private static final java.lang.String hexChars = "0123456789ABCDEF";
    private static java.lang.String versionString = "0.92";
    private boolean appletRunning = true;
    public static boolean runningAsApplet;
    private java.awt.Image backBuffer;
    private boolean gameRunning;
    private boolean fullFrame = true;
    private boolean saveToWebEnable = false;
    public static java.lang.String[] schemeNames = { "Standard colours",
    "LCD shades",
    "Midnight garden",
    "Psychadelic" };
    public static int[][] schemeColours = { { -1, -5592406, -11184811,
    -16777216,
    -1,
    -5592406,
    -11184811,
    -16777216,
    -1,
    -5592406,
    -11184811,
    -16777216 },
    { -64,
    -4013026,
    -7039488,
    -10131968,
    -64,
    -4013026,
    -7039488,
    -10131968,
    -64,
    -4013026,
    -7039488,
    -10131968 },
    { -4144897,
    -12566273,
    -16776961,
    -16777088,
    -4128832,
    -16728064,
    -16744448,
    -16760832,
    -4128832,
    -16728064,
    -16744448,
    -16760832 },
    { -16129,
    -8355585,
    -4194112,
    -8388480,
    -192,
    -4145152,
    -49088,
    -8388608,
    -8323073,
    -16727872,
    -16744320,
    -16760832 } };
    Cartridge cartridge;
    Dmgcpu dmgcpu;
    GraphicsChip graphicsChip;
    GameLink gameLink;
    short breakpointInstr;
    short breakpointAddr = -1;
    short breakpointBank;
    GameBoyScreen mainWindow;
    java.lang.String debuggerQueue = null;
    boolean debuggerPending = false;
    boolean debuggerActive = false;
    java.awt.Image doubleBuffer;
    static int[] keyCodes = { 38, 40, 37, 39, 90, 88, 10, 8 };
    boolean keyListener = false;
    java.awt.CheckboxMenuItem soundCheck;
    boolean imageSizeChanged = false;
    int stripTimer = 0;
    java.awt.PopupMenu popupMenu;
    long lastClickTime = 0;
    public static void debugLog(java.lang.String s) { java.lang.System.
                                                        out.println(
                                                              "Debug: " +
                                                              s);
    }
    public static short unsign(byte b) { if (b < 0) { return (short)
                                                               (256 +
                                                                  b);
                                         }
                                         else {
                                             return b;
                                         } }
    public static short unsign(short b) { if (b < 0) { return (short)
                                                                (256 +
                                                                   b);
                                          }
                                          else {
                                              return b;
                                          } }
    public static java.lang.String hexByte(int b) { java.lang.String s =
                                                      new java.lang.Character(
                                                      hexChars.
                                                        charAt(
                                                          b >>
                                                            4)).
                                                      toString(
                                                        );
                                                    s = s + new java.lang.Character(
                                                          hexChars.
                                                            charAt(
                                                              b &
                                                                15)).
                                                          toString(
                                                            );
                                                    return s;
    }
    public static java.lang.String hexWord(int w) { return new java.lang.String(
                                                      hexByte(
                                                        (w &
                                                           65280) >>
                                                          8) +
                                                      hexByte(
                                                        w &
                                                          255));
    }
    public void paint(java.awt.Graphics g) { if (dmgcpu !=
                                                   null) {
                                                 int stripLength =
                                                   300;
                                                 int x =
                                                   getSize(
                                                     ).
                                                     width /
                                                   2 -
                                                   dmgcpu.
                                                     graphicsChip.
                                                   getWidth(
                                                     ) /
                                                   2;
                                                 int y =
                                                   getSize(
                                                     ).
                                                     height /
                                                   2 -
                                                   dmgcpu.
                                                     graphicsChip.
                                                   getHeight(
                                                     ) /
                                                   2;
                                                 if (stripTimer >
                                                       stripLength &&
                                                       !fullFrame &&
                                                       !imageSizeChanged) {
                                                     dmgcpu.
                                                       graphicsChip.
                                                       draw(
                                                         g,
                                                         x,
                                                         y,
                                                         this);
                                                 }
                                                 else {
                                                     java.awt.Graphics bufferGraphics =
                                                       doubleBuffer.
                                                       getGraphics(
                                                         );
                                                     if (dmgcpu.
                                                           graphicsChip.
                                                           isFrameReady(
                                                             )) {
                                                         bufferGraphics.
                                                           setColor(
                                                             new java.awt.Color(
                                                               255,
                                                               255,
                                                               255));
                                                         bufferGraphics.
                                                           fillRect(
                                                             0,
                                                             0,
                                                             getSize(
                                                               ).
                                                               width,
                                                             getSize(
                                                               ).
                                                               height);
                                                         dmgcpu.
                                                           graphicsChip.
                                                           draw(
                                                             bufferGraphics,
                                                             x,
                                                             y,
                                                             this);
                                                         int stripPos =
                                                           getSize(
                                                             ).
                                                             height -
                                                           40;
                                                         if (stripTimer <
                                                               10) {
                                                             stripPos =
                                                               getSize(
                                                                 ).
                                                                 height -
                                                                 stripTimer *
                                                                 4;
                                                         }
                                                         if (stripTimer >=
                                                               stripLength -
                                                               10) {
                                                             stripPos =
                                                               getSize(
                                                                 ).
                                                                 height -
                                                                 40 +
                                                                 (stripTimer -
                                                                    (stripLength -
                                                                       10)) *
                                                                 4;
                                                         }
                                                         bufferGraphics.
                                                           setColor(
                                                             new java.awt.Color(
                                                               0,
                                                               0,
                                                               255));
                                                         bufferGraphics.
                                                           fillRect(
                                                             0,
                                                             stripPos,
                                                             getSize(
                                                               ).
                                                               width,
                                                             44);
                                                         bufferGraphics.
                                                           setColor(
                                                             new java.awt.Color(
                                                               128,
                                                               128,
                                                               255));
                                                         bufferGraphics.
                                                           fillRect(
                                                             0,
                                                             stripPos,
                                                             getSize(
                                                               ).
                                                               width,
                                                             2);
                                                         if (stripTimer <
                                                               stripLength) {
                                                             if (stripTimer <
                                                                   stripLength /
                                                                   2) {
                                                                 bufferGraphics.
                                                                   setColor(
                                                                     new java.awt.Color(
                                                                       255,
                                                                       255,
                                                                       255));
                                                                 bufferGraphics.
                                                                   drawString(
                                                                     "JavaBoy - Neil Millstone",
                                                                     2,
                                                                     stripPos +
                                                                       12);
                                                                 bufferGraphics.
                                                                   setColor(
                                                                     new java.awt.Color(
                                                                       255,
                                                                       255,
                                                                       255));
                                                                 bufferGraphics.
                                                                   drawString(
                                                                     "www.millstone.demon.co.uk",
                                                                     2,
                                                                     stripPos +
                                                                       24);
                                                                 bufferGraphics.
                                                                   drawString(
                                                                     "/download/javaboy",
                                                                     2,
                                                                     stripPos +
                                                                       36);
                                                             }
                                                             else {
                                                                 bufferGraphics.
                                                                   setColor(
                                                                     new java.awt.Color(
                                                                       255,
                                                                       255,
                                                                       255));
                                                                 bufferGraphics.
                                                                   drawString(
                                                                     "ROM: " +
                                                                     cartridge.
                                                                       getCartName(
                                                                         ),
                                                                     2,
                                                                     stripPos +
                                                                       12);
                                                                 bufferGraphics.
                                                                   drawString(
                                                                     "Double click for options",
                                                                     2,
                                                                     stripPos +
                                                                       24);
                                                                 bufferGraphics.
                                                                   drawString(
                                                                     "Emulator version: " +
                                                                     versionString,
                                                                     2,
                                                                     stripPos +
                                                                       36);
                                                             }
                                                         }
                                                         stripTimer++;
                                                         g.
                                                           drawImage(
                                                             doubleBuffer,
                                                             0,
                                                             0,
                                                             this);
                                                     }
                                                     else {
                                                         dmgcpu.
                                                           graphicsChip.
                                                           draw(
                                                             bufferGraphics,
                                                             x,
                                                             y,
                                                             this);
                                                     }
                                                 }
                                             }
                                             else {
                                                 g.
                                                   setColor(
                                                     new java.awt.Color(
                                                       0,
                                                       0,
                                                       0));
                                                 g.
                                                   fillRect(
                                                     0,
                                                     0,
                                                     160,
                                                     144);
                                                 g.
                                                   setColor(
                                                     new java.awt.Color(
                                                       255,
                                                       255,
                                                       255));
                                                 g.
                                                   drawRect(
                                                     0,
                                                     0,
                                                     160,
                                                     144);
                                                 g.
                                                   drawString(
                                                     "JavaBoy (tm)",
                                                     10,
                                                     10);
                                                 g.
                                                   drawString(
                                                     "Version " +
                                                     versionString,
                                                     10,
                                                     20);
                                                 g.
                                                   drawString(
                                                     "Charging flux capacitor...",
                                                     10,
                                                     40);
                                                 g.
                                                   drawString(
                                                     "Loading game ROM...",
                                                     10,
                                                     50);
                                             }
    }
    public void mouseClicked(java.awt.event.MouseEvent e) {
        long doubleClickTime =
          java.lang.System.
          currentTimeMillis(
            ) -
          lastClickTime;
        if (doubleClickTime <=
              250) {
            popupMenu.
              show(
                e.
                  getComponent(
                    ),
                e.
                  getX(
                    ),
                e.
                  getY(
                    ));
        }
        lastClickTime =
          java.lang.System.
            currentTimeMillis(
              );
    }
    public void mouseEntered(java.awt.event.MouseEvent e) {
        
    }
    public void mouseExited(java.awt.event.MouseEvent e) {
        
    }
    public void mousePressed(java.awt.event.MouseEvent e) {
        
    }
    public void mouseReleased(java.awt.event.MouseEvent e) {
        
    }
    public void actionPerformed(java.awt.event.ActionEvent e) {
        java.lang.System.
          out.
          println(
            e.
              getActionCommand(
                ));
        if (e.
              getActionCommand(
                ).
              equals(
                "Size: 1x")) {
            dmgcpu.
              graphicsChip.
              setMagnify(
                1);
            imageSizeChanged =
              true;
        }
        else
            if (e.
                  getActionCommand(
                    ).
                  equals(
                    "Size: 2x")) {
                dmgcpu.
                  graphicsChip.
                  setMagnify(
                    2);
                imageSizeChanged =
                  true;
            }
            else
                if (e.
                      getActionCommand(
                        ).
                      equals(
                        "Size: 3x")) {
                    dmgcpu.
                      graphicsChip.
                      setMagnify(
                        3);
                    imageSizeChanged =
                      true;
                }
                else
                    if (e.
                          getActionCommand(
                            ).
                          equals(
                            "Size: 4x")) {
                        dmgcpu.
                          graphicsChip.
                          setMagnify(
                            4);
                        imageSizeChanged =
                          true;
                    }
                    else
                        if (e.
                              getActionCommand(
                                ).
                              equals(
                                "Define Controls")) {
                            new DefineControls(
                              );
                        }
                        else
                            if (e.
                                  getActionCommand(
                                    ).
                                  equals(
                                    "FrameSkip: 0")) {
                                dmgcpu.
                                  graphicsChip.
                                  frameSkip =
                                  1;
                            }
                            else
                                if (e.
                                      getActionCommand(
                                        ).
                                      equals(
                                        "FrameSkip: 1")) {
                                    dmgcpu.
                                      graphicsChip.
                                      frameSkip =
                                      2;
                                }
                                else
                                    if (e.
                                          getActionCommand(
                                            ).
                                          equals(
                                            "FrameSkip: 2")) {
                                        dmgcpu.
                                          graphicsChip.
                                          frameSkip =
                                          3;
                                    }
                                    else
                                        if (e.
                                              getActionCommand(
                                                ).
                                              equals(
                                                "FrameSkip: 3")) {
                                            dmgcpu.
                                              graphicsChip.
                                              frameSkip =
                                              4;
                                        }
                                        else
                                            if (e.
                                                  getActionCommand(
                                                    ).
                                                  equals(
                                                    "Reset")) {
                                                dmgcpu.
                                                  reset(
                                                    );
                                            }
                                            else
                                                if (e.
                                                      getActionCommand(
                                                        ).
                                                      equals(
                                                        "Save")) {
                                                    try {
                                                        dmgcpu.
                                                          cartridge.
                                                          saveBatteryRAMToWeb(
                                                            new java.net.URL(
                                                              getParameter(
                                                                "SAVERAMURL")),
                                                            getParameter(
                                                              "USERNAME"),
                                                            dmgcpu);
                                                    }
                                                    catch (java.net.MalformedURLException ex) {
                                                        
                                                    }
                                                }
                                                else
                                                    if (e.
                                                          getActionCommand(
                                                            ).
                                                          equals(
                                                            "Load")) {
                                                        try {
                                                            dmgcpu.
                                                              cartridge.
                                                              loadBatteryRAMFromWeb(
                                                                new java.net.URL(
                                                                  getParameter(
                                                                    "LOADRAMURL")),
                                                                getParameter(
                                                                  "USERNAME"),
                                                                dmgcpu);
                                                            java.lang.System.
                                                              out.
                                                              println(
                                                                "Resetting...");
                                                        }
                                                        catch (java.lang.Exception ex) {
                                                            
                                                        }
                                                    }
                                                    else
                                                        if (e.
                                                              getActionCommand(
                                                                ).
                                                              equals(
                                                                "JavaBoy Website")) {
                                                            try {
                                                                getAppletContext(
                                                                  ).
                                                                  showDocument(
                                                                    new java.net.URL(
                                                                      WEBSITE_URL),
                                                                    "_new");
                                                            }
                                                            catch (java.net.MalformedURLException ex) {
                                                                
                                                            }
                                                        }
    }
    public void itemStateChanged(java.awt.event.ItemEvent e) {
        setSoundEnable(
          soundCheck.
            getState(
              ));
    }
    public void setSoundEnable(boolean on) {
        soundCheck.
          setState(
            on);
        if (dmgcpu.
              soundChip !=
              null) {
            dmgcpu.
              soundChip.
              channel1Enable =
              on;
            dmgcpu.
              soundChip.
              channel2Enable =
              on;
            dmgcpu.
              soundChip.
              channel3Enable =
              on;
            dmgcpu.
              soundChip.
              channel4Enable =
              on;
        }
    }
    public void activateDebugger() { debuggerActive =
                                       true;
    }
    public void deactivateDebugger() { debuggerActive =
                                         false;
    }
    public void update(java.awt.Graphics g) {
        paint(
          g);
        fullFrame =
          true;
    }
    public void drawNextFrame() { fullFrame =
                                    false;
                                  repaint(
                                    ); }
    public void keyTyped(java.awt.event.KeyEvent e) {
        
    }
    public void keyPressed(java.awt.event.KeyEvent e) {
        int key =
          e.
          getKeyCode(
            );
        if (key ==
              keyCodes[0]) {
            dmgcpu.
              ioHandler.
              padUp =
              true;
            dmgcpu.
              triggerInterruptIfEnabled(
                dmgcpu.
                  INT_P10);
        }
        else
            if (key ==
                  keyCodes[1]) {
                dmgcpu.
                  ioHandler.
                  padDown =
                  true;
                dmgcpu.
                  triggerInterruptIfEnabled(
                    dmgcpu.
                      INT_P10);
            }
            else
                if (key ==
                      keyCodes[2]) {
                    dmgcpu.
                      ioHandler.
                      padLeft =
                      true;
                    dmgcpu.
                      triggerInterruptIfEnabled(
                        dmgcpu.
                          INT_P10);
                }
                else
                    if (key ==
                          keyCodes[3]) {
                        dmgcpu.
                          ioHandler.
                          padRight =
                          true;
                        dmgcpu.
                          triggerInterruptIfEnabled(
                            dmgcpu.
                              INT_P10);
                    }
                    else
                        if (key ==
                              keyCodes[4]) {
                            dmgcpu.
                              ioHandler.
                              padA =
                              true;
                            dmgcpu.
                              triggerInterruptIfEnabled(
                                dmgcpu.
                                  INT_P10);
                        }
                        else
                            if (key ==
                                  keyCodes[5]) {
                                dmgcpu.
                                  ioHandler.
                                  padB =
                                  true;
                                dmgcpu.
                                  triggerInterruptIfEnabled(
                                    dmgcpu.
                                      INT_P10);
                            }
                            else
                                if (key ==
                                      keyCodes[6]) {
                                    dmgcpu.
                                      ioHandler.
                                      padStart =
                                      true;
                                    dmgcpu.
                                      triggerInterruptIfEnabled(
                                        dmgcpu.
                                          INT_P10);
                                }
                                else
                                    if (key ==
                                          keyCodes[7]) {
                                        dmgcpu.
                                          ioHandler.
                                          padSelect =
                                          true;
                                        dmgcpu.
                                          triggerInterruptIfEnabled(
                                            dmgcpu.
                                              INT_P10);
                                    }
        switch (key) {
            case java.awt.event.KeyEvent.
                   VK_F1:
                if (dmgcpu.
                      graphicsChip.
                      frameSkip !=
                      1)
                    dmgcpu.
                      graphicsChip.
                      frameSkip--;
                if (runningAsApplet)
                    showStatus(
                      "Frameskip now " +
                      dmgcpu.
                        graphicsChip.
                        frameSkip);
                break;
            case java.awt.event.KeyEvent.
                   VK_F2:
                if (dmgcpu.
                      graphicsChip.
                      frameSkip !=
                      10)
                    dmgcpu.
                      graphicsChip.
                      frameSkip++;
                if (runningAsApplet)
                    showStatus(
                      "Frameskip now " +
                      dmgcpu.
                        graphicsChip.
                        frameSkip);
                break;
            case java.awt.event.KeyEvent.
                   VK_F5:
                dmgcpu.
                  terminateProcess(
                    );
                activateDebugger(
                  );
                java.lang.System.
                  out.
                  println(
                    "- Break into debugger");
                break;
        }
    }
    public void keyReleased(java.awt.event.KeyEvent e) {
        int key =
          e.
          getKeyCode(
            );
        if (key ==
              keyCodes[0]) {
            dmgcpu.
              ioHandler.
              padUp =
              false;
            dmgcpu.
              triggerInterruptIfEnabled(
                dmgcpu.
                  INT_P10);
        }
        else
            if (key ==
                  keyCodes[1]) {
                dmgcpu.
                  ioHandler.
                  padDown =
                  false;
                dmgcpu.
                  triggerInterruptIfEnabled(
                    dmgcpu.
                      INT_P10);
            }
            else
                if (key ==
                      keyCodes[2]) {
                    dmgcpu.
                      ioHandler.
                      padLeft =
                      false;
                    dmgcpu.
                      triggerInterruptIfEnabled(
                        dmgcpu.
                          INT_P10);
                }
                else
                    if (key ==
                          keyCodes[3]) {
                        dmgcpu.
                          ioHandler.
                          padRight =
                          false;
                        dmgcpu.
                          triggerInterruptIfEnabled(
                            dmgcpu.
                              INT_P10);
                    }
                    else
                        if (key ==
                              keyCodes[4]) {
                            dmgcpu.
                              ioHandler.
                              padA =
                              false;
                            dmgcpu.
                              triggerInterruptIfEnabled(
                                dmgcpu.
                                  INT_P10);
                        }
                        else
                            if (key ==
                                  keyCodes[5]) {
                                dmgcpu.
                                  ioHandler.
                                  padB =
                                  false;
                                dmgcpu.
                                  triggerInterruptIfEnabled(
                                    dmgcpu.
                                      INT_P10);
                            }
                            else
                                if (key ==
                                      keyCodes[6]) {
                                    dmgcpu.
                                      ioHandler.
                                      padStart =
                                      false;
                                    dmgcpu.
                                      triggerInterruptIfEnabled(
                                        dmgcpu.
                                          INT_P10);
                                }
                                else
                                    if (key ==
                                          keyCodes[7]) {
                                        dmgcpu.
                                          ioHandler.
                                          padSelect =
                                          false;
                                        dmgcpu.
                                          triggerInterruptIfEnabled(
                                            dmgcpu.
                                              INT_P10);
                                    }
    }
    public void displayDebuggerHelp() { java.lang.System.
                                          out.
                                          println(
                                            ("Enter a command followed by it\'s parameters (all values in " +
                                             "hex):"));
                                        java.lang.System.
                                          out.
                                          println(
                                            "?                     Display this help screen");
                                        java.lang.System.
                                          out.
                                          println(
                                            ("c [script]            Execute _c_ommands from script file [d" +
                                             "efault.scp]"));
                                        java.lang.System.
                                          out.
                                          println(
                                            "s                     Re_s_et CPU");
                                        java.lang.System.
                                          out.
                                          println(
                                            "r                     Show current register values");
                                        java.lang.System.
                                          out.
                                          println(
                                            "r reg val             Set value of register reg to value val");
                                        java.lang.System.
                                          out.
                                          println(
                                            ("e addr val [val] ...  Write values to RAM / ROM starting at " +
                                             "address addr"));
                                        java.lang.System.
                                          out.
                                          println(
                                            "d addr len            Hex _D_ump len bytes starting at addr");
                                        java.lang.System.
                                          out.
                                          println(
                                            ("i addr len            D_i_sassemble len instructions startin" +
                                             "g at addr"));
                                        java.lang.System.
                                          out.
                                          println(
                                            ("p len                 Disassemble len instructions starting " +
                                             "at current PC"));
                                        java.lang.System.
                                          out.
                                          println(
                                            "n                     Show interrupt state");
                                        java.lang.System.
                                          out.
                                          println(
                                            "n 1|0                 Enable/disable interrupts");
                                        java.lang.System.
                                          out.
                                          println(
                                            ("t [len]               Execute len instructions starting at c" +
                                             "urrent PC [1]"));
                                        java.lang.System.
                                          out.
                                          println(
                                            "g                     Execute forever");
                                        java.lang.System.
                                          out.
                                          println(
                                            "o                     Output Gameboy screen to applet window");
                                        java.lang.System.
                                          out.
                                          println(
                                            "b addr                Set breakpoint at addr");
                                        java.lang.System.
                                          out.
                                          println(
                                            "k [keyname]           Toggle Gameboy key");
                                        java.lang.System.
                                          out.
                                          println(
                                            "m bank                _M_ap to ROM bank");
                                        java.lang.System.
                                          out.
                                          println(
                                            "m                     Display current ROM mapping");
                                        java.lang.System.
                                          out.
                                          println(
                                            "q                     Quit debugger interface");
                                        java.lang.System.
                                          out.
                                          println(
                                            "<CTRL> + C            Quit JavaBoy");
    }
    public void hexDump(int address, int length) {
        int start =
          address &
          65520;
        int lines =
          length /
          16;
        if (lines ==
              0)
            lines =
              1;
        for (int l =
               0;
             l <
               lines;
             l++) {
            java.lang.System.
              out.
              print(
                JavaBoy.
                  hexWord(
                    start +
                      l *
                      16) +
                "   ");
            for (int r =
                   start +
                   l *
                   16;
                 r <
                   start +
                   l *
                   16 +
                   16;
                 r++) {
                java.lang.System.
                  out.
                  print(
                    JavaBoy.
                      hexByte(
                        unsign(
                          dmgcpu.
                            addressRead(
                              r))) +
                    " ");
            }
            java.lang.System.
              out.
              print(
                "   ");
            for (int r =
                   start +
                   l *
                   16;
                 r <
                   start +
                   l *
                   16 +
                   16;
                 r++) {
                char c =
                  (char)
                    dmgcpu.
                    addressRead(
                      r);
                if (c >=
                      32 &&
                      c <=
                      128) {
                    java.lang.System.
                      out.
                      print(
                        c);
                }
                else {
                    java.lang.System.
                      out.
                      print(
                        ".");
                }
            }
            java.lang.System.
              out.
              println(
                "");
        }
    }
    public void showRegisterValues() { java.lang.System.
                                         out.
                                         println(
                                           "- Register values");
                                       java.lang.System.
                                         out.
                                         print(
                                           "A = " +
                                           JavaBoy.
                                             hexWord(
                                               dmgcpu.
                                                 a) +
                                           "    BC = " +
                                           JavaBoy.
                                             hexWord(
                                               dmgcpu.
                                                 b) +
                                           JavaBoy.
                                             hexWord(
                                               dmgcpu.
                                                 c));
                                       java.lang.System.
                                         out.
                                         print(
                                           "    DE = " +
                                           JavaBoy.
                                             hexByte(
                                               dmgcpu.
                                                 d) +
                                           JavaBoy.
                                             hexByte(
                                               dmgcpu.
                                                 e));
                                       java.lang.System.
                                         out.
                                         print(
                                           "    HL = " +
                                           JavaBoy.
                                             hexWord(
                                               dmgcpu.
                                                 hl));
                                       java.lang.System.
                                         out.
                                         print(
                                           "    PC = " +
                                           JavaBoy.
                                             hexWord(
                                               dmgcpu.
                                                 pc));
                                       java.lang.System.
                                         out.
                                         println(
                                           "    SP = " +
                                           JavaBoy.
                                             hexWord(
                                               dmgcpu.
                                                 sp));
                                       java.lang.System.
                                         out.
                                         println(
                                           "F = " +
                                           JavaBoy.
                                             hexByte(
                                               unsign(
                                                 (short)
                                                   dmgcpu.
                                                     f)));
    }
    public void getDebuggerMenuChoice() {
        java.lang.String command =
          new java.lang.String(
          "");
        char b =
          0;
        if (dmgcpu !=
              null)
            dmgcpu.
              terminate =
              false;
        if (!debuggerActive) {
            if (debuggerPending) {
                debuggerPending =
                  false;
                executeDebuggerCommand(
                  debuggerQueue);
            }
        }
        else {
            java.lang.System.
              out.
              println(
                );
            java.lang.System.
              out.
              print(
                "Enter command (\'?\' for help)> ");
            while (b !=
                     10 &&
                     appletRunning) {
                try {
                    b =
                      (char)
                        java.lang.System.
                          in.
                        read(
                          );
                }
                catch (java.io.IOException e) {
                    
                }
                if (b >=
                      32)
                    command =
                      command +
                      b;
            }
        }
        if (appletRunning)
            executeDebuggerCommand(
              command);
    }
    public void executeDebuggerScript(java.lang.String fn) {
        java.io.InputStream is =
          null;
        java.io.BufferedReader in =
          null;
        try {
            if (JavaBoy.
                  runningAsApplet) {
                is =
                  new java.net.URL(
                    getDocumentBase(
                      ),
                    fn).
                    openStream(
                      );
            }
            else {
                is =
                  new java.io.FileInputStream(
                    new java.io.File(
                      fn));
            }
            in =
              new java.io.BufferedReader(
                new java.io.InputStreamReader(
                  is));
            java.lang.String line;
            while ((line =
                      in.
                        readLine(
                          )) !=
                     null &&
                     !dmgcpu.
                        terminate &&
                     appletRunning) {
                executeDebuggerCommand(
                  line);
            }
            in.
              close(
                );
        }
        catch (java.io.IOException e) {
            java.lang.System.
              out.
              println(
                "Can\'t open script file \'" +
                fn +
                "\'!");
        }
    }
    public void queueDebuggerCommand(java.lang.String command) {
        debuggerQueue =
          command;
        debuggerPending =
          true;
    }
    public void executeDebuggerCommand(java.lang.String commands) {
        java.util.StringTokenizer commandTokens =
          new java.util.StringTokenizer(
          commands,
          ";");
        while (commandTokens.
                 hasMoreTokens(
                   )) {
            executeSingleDebuggerCommand(
              commandTokens.
                nextToken(
                  ));
        }
    }
    public void setupKeyboard() { if (!keyListener) {
                                      if (!runningAsApplet) {
                                          java.lang.System.
                                            out.
                                            println(
                                              "Starting key controls");
                                          mainWindow.
                                            addKeyListener(
                                              this);
                                          mainWindow.
                                            requestFocus(
                                              );
                                      }
                                      else {
                                          addKeyListener(
                                            this);
                                      }
                                      keyListener =
                                        true;
                                  } }
    public void executeSingleDebuggerCommand(java.lang.String command) {
        java.util.StringTokenizer st =
          new java.util.StringTokenizer(
          command,
          " \n");
        try {
            switch (st.
                      nextToken(
                        ).
                      charAt(
                        0)) {
                case '?':
                    displayDebuggerHelp(
                      );
                    break;
                case 'd':
                    try {
                        int address =
                          java.lang.Integer.
                          valueOf(
                            st.
                              nextToken(
                                ),
                            16).
                          intValue(
                            );
                        int length =
                          java.lang.Integer.
                          valueOf(
                            st.
                              nextToken(
                                ),
                            16).
                          intValue(
                            );
                        java.lang.System.
                          out.
                          println(
                            "- Dumping " +
                            JavaBoy.
                              hexWord(
                                length) +
                            " instructions starting from " +
                            JavaBoy.
                              hexWord(
                                address));
                        hexDump(
                          address,
                          length);
                    }
                    catch (java.util.NoSuchElementException e) {
                        java.lang.System.
                          out.
                          println(
                            "Invalid number of parameters to \'d\' command.");
                    }
                    catch (java.lang.NumberFormatException e) {
                        java.lang.System.
                          out.
                          println(
                            "Error parsing hex value.");
                    }
                    break;
                case 'i':
                    try {
                        int address =
                          java.lang.Integer.
                          valueOf(
                            st.
                              nextToken(
                                ),
                            16).
                          intValue(
                            );
                        int length =
                          java.lang.Integer.
                          valueOf(
                            st.
                              nextToken(
                                ),
                            16).
                          intValue(
                            );
                        java.lang.System.
                          out.
                          println(
                            "- Dissasembling " +
                            JavaBoy.
                              hexWord(
                                length) +
                            " instructions starting from " +
                            JavaBoy.
                              hexWord(
                                address));
                        dmgcpu.
                          disassemble(
                            address,
                            length);
                    }
                    catch (java.util.NoSuchElementException e) {
                        java.lang.System.
                          out.
                          println(
                            "Invalid number of parameters to \'i\' command.");
                    }
                    catch (java.lang.NumberFormatException e) {
                        java.lang.System.
                          out.
                          println(
                            "Error parsing hex value.");
                    }
                    break;
                case 'p':
                    try {
                        int length =
                          java.lang.Integer.
                          valueOf(
                            st.
                              nextToken(
                                ),
                            16).
                          intValue(
                            );
                        java.lang.System.
                          out.
                          println(
                            "- Dissasembling " +
                            JavaBoy.
                              hexWord(
                                length) +
                            " instructions starting from program counter (" +
                            JavaBoy.
                              hexWord(
                                dmgcpu.
                                  pc) +
                            ")");
                        dmgcpu.
                          disassemble(
                            dmgcpu.
                              pc,
                            length);
                    }
                    catch (java.util.NoSuchElementException e) {
                        java.lang.System.
                          out.
                          println(
                            "Invalid number of parameters to \'p\' command.");
                    }
                    catch (java.lang.NumberFormatException e) {
                        java.lang.System.
                          out.
                          println(
                            "Error parsing hex value.");
                    }
                    break;
                case 'k':
                    try {
                        java.lang.String keyName =
                          st.
                          nextToken(
                            );
                        dmgcpu.
                          ioHandler.
                          toggleKey(
                            keyName);
                    }
                    catch (java.util.NoSuchElementException e) {
                        java.lang.System.
                          out.
                          println(
                            "Invalid number of parameters to \'k\' command.");
                    }
                    break;
                case 'r':
                    try {
                        java.lang.String reg =
                          st.
                          nextToken(
                            );
                        try {
                            int val =
                              java.lang.Integer.
                              valueOf(
                                st.
                                  nextToken(
                                    ),
                                16).
                              intValue(
                                );
                            if (dmgcpu.
                                  setRegister(
                                    reg,
                                    val)) {
                                java.lang.System.
                                  out.
                                  println(
                                    "- Set register " +
                                    reg +
                                    " to " +
                                    JavaBoy.
                                      hexWord(
                                        val) +
                                    ".");
                            }
                            else {
                                java.lang.System.
                                  out.
                                  println(
                                    "Invalid register name \'" +
                                    reg +
                                    "\'.");
                            }
                        }
                        catch (java.util.NoSuchElementException e) {
                            java.lang.System.
                              out.
                              println(
                                "Missing value");
                        }
                        catch (java.lang.NumberFormatException e) {
                            java.lang.System.
                              out.
                              println(
                                "Error parsing hex value.");
                        }
                    }
                    catch (java.util.NoSuchElementException e) {
                        showRegisterValues(
                          );
                    }
                    break;
                case 's':
                    java.lang.System.
                      out.
                      println(
                        "- CPU Reset");
                    dmgcpu.
                      reset(
                        );
                    break;
                case 'o':
                    repaint(
                      );
                    break;
                case 'c':
                    try {
                        java.lang.String fn =
                          st.
                          nextToken(
                            );
                        java.lang.System.
                          out.
                          println(
                            "* Starting execution of script \'" +
                            fn +
                            "\'");
                        executeDebuggerScript(
                          fn);
                        java.lang.System.
                          out.
                          println(
                            "* Script execution finished");
                    }
                    catch (java.util.NoSuchElementException e) {
                        java.lang.System.
                          out.
                          println(
                            "* Starting execution of default script");
                        executeDebuggerScript(
                          "default.scp");
                        java.lang.System.
                          out.
                          println(
                            "* Script execution finished");
                    }
                    break;
                case 'q':
                    cartridge.
                      restoreMapping(
                        );
                    java.lang.System.
                      out.
                      println(
                        "- Quitting debugger");
                    deactivateDebugger(
                      );
                    break;
                case 'e':
                    int address;
                    try {
                        address =
                          java.lang.Integer.
                            valueOf(
                              st.
                                nextToken(
                                  ),
                              16).
                            intValue(
                              );
                    }
                    catch (java.lang.NumberFormatException e) {
                        java.lang.System.
                          out.
                          println(
                            "Error parsing hex value.");
                        break;
                    }
                    catch (java.util.NoSuchElementException e) {
                        java.lang.System.
                          out.
                          println(
                            "Missing address.");
                        break;
                    }
                    java.lang.System.
                      out.
                      print(
                        "- Written data starting at " +
                        JavaBoy.
                          hexWord(
                            address) +
                        " (");
                    if (!st.
                          hasMoreTokens(
                            )) {
                        java.lang.System.
                          out.
                          println(
                            "");
                        java.lang.System.
                          out.
                          println(
                            "Missing data value(s)");
                        break;
                    }
                    try {
                        while (st.
                                 hasMoreTokens(
                                   )) {
                            short data =
                              (byte)
                                java.lang.Integer.
                                valueOf(
                                  st.
                                    nextToken(
                                      ),
                                  16).
                                intValue(
                                  );
                            dmgcpu.
                              addressWrite(
                                address++,
                                data);
                        }
                        java.lang.System.
                          out.
                          println(
                            ")");
                    }
                    catch (java.lang.NumberFormatException e) {
                        java.lang.System.
                          out.
                          println(
                            "");
                        java.lang.System.
                          out.
                          println(
                            "Error parsing hex value.");
                    }
                    break;
                case 'b':
                    try {
                        if (breakpointAddr !=
                              -1) {
                            cartridge.
                              saveMapping(
                                );
                            cartridge.
                              mapRom(
                                breakpointBank);
                            dmgcpu.
                              addressWrite(
                                breakpointAddr,
                                breakpointInstr);
                            cartridge.
                              restoreMapping(
                                );
                            breakpointAddr =
                              -1;
                            java.lang.System.
                              out.
                              println(
                                "- Clearing original breakpoint");
                            dmgcpu.
                              setBreakpoint(
                                false);
                        }
                        int addr =
                          java.lang.Integer.
                          valueOf(
                            st.
                              nextToken(
                                ),
                            16).
                          intValue(
                            );
                        java.lang.System.
                          out.
                          println(
                            "- Setting breakpoint at " +
                            JavaBoy.
                              hexWord(
                                addr));
                        breakpointAddr =
                          (short)
                            addr;
                        breakpointInstr =
                          (short)
                            dmgcpu.
                            addressRead(
                              addr);
                        breakpointBank =
                          (short)
                            cartridge.
                              currentBank;
                        dmgcpu.
                          addressWrite(
                            addr,
                            82);
                        dmgcpu.
                          setBreakpoint(
                            true);
                    }
                    catch (java.util.NoSuchElementException e) {
                        java.lang.System.
                          out.
                          println(
                            "Invalid number of parameters to \'b\' command.");
                    }
                    catch (java.lang.NumberFormatException e) {
                        java.lang.System.
                          out.
                          println(
                            "Error parsing hex value.");
                    }
                    break;
                case 'g':
                    setupKeyboard(
                      );
                    cartridge.
                      restoreMapping(
                        );
                    dmgcpu.
                      execute(
                        -1);
                    break;
                case 'n':
                    try {
                        int state =
                          java.lang.Integer.
                          valueOf(
                            st.
                              nextToken(
                                ),
                            16).
                          intValue(
                            );
                        if (state ==
                              1) {
                            dmgcpu.
                              interruptsEnabled =
                              true;
                        }
                        else {
                            dmgcpu.
                              interruptsEnabled =
                              false;
                        }
                    }
                    catch (java.util.NoSuchElementException e) {
                        
                    }
                    catch (java.lang.NumberFormatException e) {
                        java.lang.System.
                          out.
                          println(
                            "Error parsing hex value.");
                    }
                    java.lang.System.
                      out.
                      print(
                        "- Interrupts are ");
                    if (dmgcpu.
                          interruptsEnabled)
                        java.lang.System.
                          out.
                          println(
                            "enabled.");
                    else
                        java.lang.System.
                          out.
                          println(
                            "disabled.");
                    break;
                case 'm':
                    try {
                        int bank =
                          java.lang.Integer.
                          valueOf(
                            st.
                              nextToken(
                                ),
                            16).
                          intValue(
                            );
                        java.lang.System.
                          out.
                          println(
                            "- Mapping ROM bank " +
                            JavaBoy.
                              hexByte(
                                bank) +
                            " to 4000 - 7FFFF");
                        cartridge.
                          saveMapping(
                            );
                        cartridge.
                          mapRom(
                            bank);
                    }
                    catch (java.util.NoSuchElementException e) {
                        java.lang.System.
                          out.
                          println(
                            "- ROM Mapper state:");
                        java.lang.System.
                          out.
                          println(
                            cartridge.
                              getMapInfo(
                                ));
                    }
                    break;
                case 't':
                    try {
                        cartridge.
                          restoreMapping(
                            );
                        int length =
                          java.lang.Integer.
                          valueOf(
                            st.
                              nextToken(
                                ),
                            16).
                          intValue(
                            );
                        java.lang.System.
                          out.
                          println(
                            "- Executing " +
                            JavaBoy.
                              hexWord(
                                length) +
                            " instructions starting from program counter (" +
                            JavaBoy.
                              hexWord(
                                dmgcpu.
                                  pc) +
                            ")");
                        dmgcpu.
                          execute(
                            length);
                        if (dmgcpu.
                              pc ==
                              breakpointAddr) {
                            dmgcpu.
                              addressWrite(
                                breakpointAddr,
                                breakpointInstr);
                            breakpointAddr =
                              -1;
                            java.lang.System.
                              out.
                              println(
                                "- Breakpoint instruction restored");
                        }
                    }
                    catch (java.util.NoSuchElementException e) {
                        java.lang.System.
                          out.
                          println(
                            "- Executing instruction at program counter (" +
                            JavaBoy.
                              hexWord(
                                dmgcpu.
                                  pc) +
                            ")");
                        dmgcpu.
                          execute(
                            1);
                    }
                    catch (java.lang.NumberFormatException e) {
                        java.lang.System.
                          out.
                          println(
                            "Error parsing hex value.");
                    }
                    break;
                default:
                    java.lang.System.
                      out.
                      println(
                        "Command not recognized.  Try looking at the help page.");
            }
        }
        catch (java.util.NoSuchElementException e) {
            
        }
    }
    public void windowClosed(java.awt.event.WindowEvent e) {
        
    }
    public void windowClosing(java.awt.event.WindowEvent e) {
        dispose(
          );
        java.lang.System.
          exit(
            0);
    }
    public void windowDeiconified(java.awt.event.WindowEvent e) {
        
    }
    public void windowIconified(java.awt.event.WindowEvent e) {
        
    }
    public void windowOpened(java.awt.event.WindowEvent e) {
        
    }
    public void windowActivated(java.awt.event.WindowEvent e) {
        
    }
    public void windowDeactivated(java.awt.event.WindowEvent e) {
        
    }
    public JavaBoy() { super(); }
    public JavaBoy(java.lang.String cartName) {
        super(
          );
    }
    public void einit() { mainWindow = (GameBoyScreen)
                                         ent.runtime.ENT_Runtime.
                                         putObj(
                                           new GameBoyScreen(
                                             "JavaBoy " +
                                             versionString,
                                             this),
                                           new java.lang.Integer[] { ent.runtime.ENT_Runtime.
                                             getObjMode(
                                               this,
                                               0) });
                          mainWindow.init(
                                       );
                          mainWindow.setVisible(
                                       true);
                          this.requestFocus(
                                 );
                          mainWindow.addWindowListener(
                                       this);
    }
    public static void main(java.lang.String[] args) {
        java.lang.System.
          out.
          println(
            "JavaBoy (tm) Version " +
            versionString +
            " (c) 2005 Neil Millstone (application)");
        runningAsApplet =
          false;
        JavaBoy djavaBoy =
          (JavaBoy)
            ent.runtime.ENT_Runtime.
            putObj(
              new JavaBoy(
                ""),
              new java.lang.Integer[] { EntMode.
                                          DYNAMIC_MODE });
        JavaBoy javaBoy =
          ent.runtime.ENT_Snapshot.
          snapshot(
            djavaBoy,
            EntMode.
              LOW_MODE,
            EntMode.
              HIGH_MODE,
            true);
        javaBoy.
          einit(
            );
        if (args.
              length >
              0) {
            if (args[0].
                  equals(
                    "server")) {
                javaBoy.
                  gameLink =
                  new TCPGameLink(
                    null);
            }
            else
                if (args[0].
                      equals(
                        "client")) {
                    javaBoy.
                      gameLink =
                      new TCPGameLink(
                        null,
                        args[1]);
                }
        }
        java.lang.Thread p =
          new java.lang.Thread(
          javaBoy);
        p.
          start(
            );
    }
    public void start() { java.lang.Thread p =
                            new java.lang.Thread(
                            this);
                          runningAsApplet =
                            true;
                          setupKeyboard();
                          java.lang.System.
                            out.println("JavaBoy (tm) Version " +
                                        versionString +
                                        " (c) 2005 Neil Millstone (applet)");
                          cartridge = new Cartridge(
                                        getParameter(
                                          "ROMIMAGE"),
                                        this);
                          dmgcpu = new Dmgcpu(
                                     cartridge,
                                     null,
                                     this);
                          dmgcpu.graphicsChip.
                            setMagnify(
                              getSize(
                                ).
                                width /
                                160);
                          this.requestFocus(
                                 );
                          p.start();
                          saveToWebEnable =
                            getParameter(
                              "SAVERAMURL") !=
                              null;
                          popupMenu = new java.awt.PopupMenu(
                                        );
                          popupMenu.add("JavaBoy " +
                                        versionString);
                          popupMenu.add("-");
                          popupMenu.add("Define Controls");
                          popupMenu.add(soundCheck =
                                          new java.awt.CheckboxMenuItem(
                                            "Sound"));
                          popupMenu.add("-");
                          popupMenu.add("Reset");
                          if (saveToWebEnable) {
                              popupMenu.
                                add(
                                  "Save");
                              popupMenu.
                                add(
                                  "Load");
                          }
                          popupMenu.add("-");
                          popupMenu.add("Size: 1x");
                          popupMenu.add("Size: 2x");
                          popupMenu.add("Size: 3x");
                          popupMenu.add("Size: 4x");
                          popupMenu.add("-");
                          popupMenu.add("FrameSkip: 0");
                          popupMenu.add("FrameSkip: 1");
                          popupMenu.add("FrameSkip: 2");
                          popupMenu.add("FrameSkip: 3");
                          popupMenu.add("-");
                          popupMenu.add("JavaBoy Website");
                          popupMenu.addActionListener(
                                      this);
                          soundCheck.addItemListener(
                                       this);
                          setSoundEnable(
                            getParameter(
                              "SOUND") ==
                              null ||
                              getParameter(
                                "SOUND").
                              equals(
                                "ON"));
                          addMouseListener(
                            this);
                          add(popupMenu);
                          cartridge.outputCartInfo(
                                      ); }
    public void run() { if (runningAsApplet) {
                            java.lang.System.
                              out.
                              println(
                                "Starting...");
                            do  {
                                dmgcpu.
                                  reset(
                                    );
                                dmgcpu.
                                  execute(
                                    -1);
                            }while(appletRunning); 
                        }
                        try { java.lang.Thread.
                                sleep(
                                  5000); }
                        catch (java.lang.Exception e) {
                            java.lang.System.
                              out.
                              println(
                                e);
                        }
                        mainWindow.actionPerformed(
                                     new java.awt.event.ActionEvent(
                                       this,
                                       0,
                                       "Open ROM"));
                        mainWindow.actionPerformed(
                                     new java.awt.event.ActionEvent(
                                       this,
                                       0,
                                       "Reset"));
                        do  { try { getDebuggerMenuChoice(
                                      );
                                    java.lang.Thread.
                                      sleep(
                                        1);
                                    this.
                                      requestFocus(
                                        );
                              }
                              catch (java.lang.InterruptedException e) {
                                  java.lang.System.
                                    out.
                                    println(
                                      "Interrupted!");
                                  break;
                              } }while(appletRunning); 
                        dispose();
                        java.lang.System.
                          out.println("Thread terminated");
    }
    public void dispose() { if (cartridge !=
                                  null) cartridge.
                                          dispose(
                                            );
                            if (dmgcpu !=
                                  null) dmgcpu.
                                          dispose(
                                            );
    }
    public void init() { requestFocus();
                         doubleBuffer = createImage(
                                          getSize(
                                            ).
                                            width,
                                          getSize(
                                            ).
                                            height);
    }
    public void stop() { java.lang.System.
                           out.println("Applet stopped");
                         appletRunning = false;
                         if (dmgcpu != null)
                             dmgcpu.
                               terminate =
                               true; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1470933913000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "8yZm+v8BAWCea5tkAAA=");
    public ent.runtime.ENT_Attributable ENT_copy() {
        JavaBoy ENT_ld =
          new JavaBoy(
          );
        ENT_ld.
          HACK =
          this.
            HACK;
        ENT_ld.
          appletRunning =
          this.
            appletRunning;
        ENT_ld.
          backBuffer =
          this.
            backBuffer;
        ENT_ld.
          gameRunning =
          this.
            gameRunning;
        ENT_ld.
          fullFrame =
          this.
            fullFrame;
        ENT_ld.
          saveToWebEnable =
          this.
            saveToWebEnable;
        ENT_ld.
          cartridge =
          this.
            cartridge;
        ENT_ld.
          dmgcpu =
          this.
            dmgcpu;
        ENT_ld.
          graphicsChip =
          this.
            graphicsChip;
        ENT_ld.
          gameLink =
          this.
            gameLink;
        ENT_ld.
          breakpointInstr =
          this.
            breakpointInstr;
        ENT_ld.
          breakpointAddr =
          this.
            breakpointAddr;
        ENT_ld.
          breakpointBank =
          this.
            breakpointBank;
        ENT_ld.
          mainWindow =
          this.
            mainWindow;
        ENT_ld.
          debuggerQueue =
          this.
            debuggerQueue;
        ENT_ld.
          debuggerPending =
          this.
            debuggerPending;
        ENT_ld.
          debuggerActive =
          this.
            debuggerActive;
        ENT_ld.
          doubleBuffer =
          this.
            doubleBuffer;
        ENT_ld.
          keyListener =
          this.
            keyListener;
        ENT_ld.
          soundCheck =
          this.
            soundCheck;
        ENT_ld.
          imageSizeChanged =
          this.
            imageSizeChanged;
        ENT_ld.
          stripTimer =
          this.
            stripTimer;
        ENT_ld.
          popupMenu =
          this.
            popupMenu;
        ENT_ld.
          lastClickTime =
          this.
            lastClickTime;
        return ENT_ld;
    }
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1470933913000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "iUvCk6BtL3ptYZwvm0HZaskDY7GcYbVe");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
