class GameBoyScreen extends java.awt.Frame implements java.awt.event.ActionListener, java.awt.event.ComponentListener, java.awt.event.ItemListener {
    GraphicsChip graphicsChip = null;
    JavaBoy applet;
    java.awt.CheckboxMenuItem viewFrameCounter;
    java.awt.CheckboxMenuItem viewSpeedThrottle;
    java.awt.CheckboxMenuItem viewFrameSkip0;
    java.awt.CheckboxMenuItem viewFrameSkip1;
    java.awt.CheckboxMenuItem viewFrameSkip2;
    java.awt.CheckboxMenuItem viewFrameSkip3;
    java.awt.CheckboxMenuItem viewFrameSkip4;
    java.awt.CheckboxMenuItem soundChannel1Enable;
    java.awt.CheckboxMenuItem soundChannel2Enable;
    java.awt.CheckboxMenuItem soundChannel3Enable;
    java.awt.CheckboxMenuItem soundChannel4Enable;
    java.awt.CheckboxMenuItem soundFreq11;
    java.awt.CheckboxMenuItem soundFreq22;
    java.awt.CheckboxMenuItem soundFreq44;
    java.awt.CheckboxMenuItem soundBuffer200;
    java.awt.CheckboxMenuItem soundBuffer300;
    java.awt.CheckboxMenuItem soundBuffer400;
    java.awt.CheckboxMenuItem networkServer;
    java.awt.CheckboxMenuItem fileGameboyColor;
    java.awt.CheckboxMenuItem viewSingle;
    java.awt.CheckboxMenuItem viewDouble;
    java.awt.CheckboxMenuItem viewTriple;
    java.awt.CheckboxMenuItem viewQuadrouple;
    java.awt.CheckboxMenuItem view5;
    java.awt.CheckboxMenuItem view6;
    java.awt.CheckboxMenuItem networkPrinter;
    java.awt.TextField hostAddress;
    java.awt.Dialog connectDialog;
    java.awt.CheckboxMenuItem[] schemes = new java.awt.CheckboxMenuItem[JavaBoy.
                                                                          schemeNames.
                                                                          length];
    int viewSetting = 4;
    public GameBoyScreen(java.lang.String s, JavaBoy a) { super(s);
                                                          applet =
                                                            a;
                                                          this.addComponentListener(
                                                                 this);
                                                          java.awt.MenuBar menuBar =
                                                            new java.awt.MenuBar(
                                                            );
                                                          java.awt.MenuItem fileOpen =
                                                            new java.awt.MenuItem(
                                                            "Open ROM");
                                                          fileOpen.
                                                            setActionCommand(
                                                              "Open ROM");
                                                          fileOpen.
                                                            addActionListener(
                                                              this);
                                                          java.awt.MenuItem fileEmulate =
                                                            new java.awt.MenuItem(
                                                            "Emulate");
                                                          fileEmulate.
                                                            setActionCommand(
                                                              "Emulate");
                                                          fileEmulate.
                                                            addActionListener(
                                                              this);
                                                          java.awt.MenuItem fileReset =
                                                            new java.awt.MenuItem(
                                                            "Reset");
                                                          fileReset.
                                                            setActionCommand(
                                                              "Reset");
                                                          fileReset.
                                                            addActionListener(
                                                              this);
                                                          java.awt.MenuItem filePause =
                                                            new java.awt.MenuItem(
                                                            "Pause");
                                                          filePause.
                                                            setActionCommand(
                                                              "Pause");
                                                          filePause.
                                                            addActionListener(
                                                              this);
                                                          java.awt.MenuItem fileControls =
                                                            new java.awt.MenuItem(
                                                            "Define controls...");
                                                          fileControls.
                                                            setActionCommand(
                                                              "Controls");
                                                          fileControls.
                                                            addActionListener(
                                                              this);
                                                          fileGameboyColor =
                                                            new java.awt.CheckboxMenuItem(
                                                              "Use Gameboy Color features");
                                                          fileGameboyColor.
                                                            addItemListener(
                                                              this);
                                                          fileGameboyColor.
                                                            setState(
                                                              true);
                                                          java.awt.MenuItem fileQuit =
                                                            new java.awt.MenuItem(
                                                            "Exit");
                                                          fileQuit.
                                                            setActionCommand(
                                                              "Exit");
                                                          fileQuit.
                                                            addActionListener(
                                                              this);
                                                          viewSingle =
                                                            new java.awt.CheckboxMenuItem(
                                                              "Size: actual");
                                                          viewSingle.
                                                            addItemListener(
                                                              this);
                                                          viewDouble =
                                                            new java.awt.CheckboxMenuItem(
                                                              "Size: 2x");
                                                          viewDouble.
                                                            addItemListener(
                                                              this);
                                                          viewTriple =
                                                            new java.awt.CheckboxMenuItem(
                                                              "Size: 3x");
                                                          viewTriple.
                                                            addItemListener(
                                                              this);
                                                          viewQuadrouple =
                                                            new java.awt.CheckboxMenuItem(
                                                              "Size: 4x");
                                                          viewQuadrouple.
                                                            addItemListener(
                                                              this);
                                                          view5 =
                                                            new java.awt.CheckboxMenuItem(
                                                              "Size: 5x");
                                                          view5.
                                                            addItemListener(
                                                              this);
                                                          view6 =
                                                            new java.awt.CheckboxMenuItem(
                                                              "Size: 6x");
                                                          view6.
                                                            addItemListener(
                                                              this);
                                                          viewFrameSkip0 =
                                                            new java.awt.CheckboxMenuItem(
                                                              "Frame skip: 0");
                                                          viewFrameSkip0.
                                                            addItemListener(
                                                              this);
                                                          viewFrameSkip1 =
                                                            new java.awt.CheckboxMenuItem(
                                                              "Frame skip: 1");
                                                          viewFrameSkip1.
                                                            addItemListener(
                                                              this);
                                                          viewFrameSkip2 =
                                                            new java.awt.CheckboxMenuItem(
                                                              "Frame skip: 2");
                                                          viewFrameSkip2.
                                                            addItemListener(
                                                              this);
                                                          viewFrameSkip3 =
                                                            new java.awt.CheckboxMenuItem(
                                                              "Frame skip: 3");
                                                          viewFrameSkip3.
                                                            addItemListener(
                                                              this);
                                                          viewFrameSkip4 =
                                                            new java.awt.CheckboxMenuItem(
                                                              "Frame skip: 4");
                                                          viewFrameSkip4.
                                                            addItemListener(
                                                              this);
                                                          viewFrameCounter =
                                                            new java.awt.CheckboxMenuItem(
                                                              "Frame counter");
                                                          viewFrameCounter.
                                                            setActionCommand(
                                                              "Frame counter");
                                                          viewFrameCounter.
                                                            addActionListener(
                                                              this);
                                                          viewSpeedThrottle =
                                                            new java.awt.CheckboxMenuItem(
                                                              "Speed throttle");
                                                          viewSpeedThrottle.
                                                            setActionCommand(
                                                              "Speed throttle");
                                                          viewSpeedThrottle.
                                                            addActionListener(
                                                              this);
                                                          viewSpeedThrottle.
                                                            setState(
                                                              true);
                                                          java.awt.CheckboxMenuItem viewStandardCols =
                                                            new java.awt.CheckboxMenuItem(
                                                            "Standard colours");
                                                          viewStandardCols.
                                                            addItemListener(
                                                              this);
                                                          viewStandardCols.
                                                            setState(
                                                              true);
                                                          java.awt.CheckboxMenuItem viewLcdCols =
                                                            new java.awt.CheckboxMenuItem(
                                                            "LCD shades");
                                                          viewLcdCols.
                                                            addItemListener(
                                                              this);
                                                          java.awt.CheckboxMenuItem viewGreenyCols =
                                                            new java.awt.CheckboxMenuItem(
                                                            "Greeny shades");
                                                          viewGreenyCols.
                                                            addItemListener(
                                                              this);
                                                          java.awt.MenuItem debugEnter =
                                                            new java.awt.MenuItem(
                                                            "Enter debugger");
                                                          debugEnter.
                                                            setActionCommand(
                                                              "Enter debugger");
                                                          debugEnter.
                                                            addActionListener(
                                                              this);
                                                          java.awt.MenuItem debugExecuteScript =
                                                            new java.awt.MenuItem(
                                                            "Execute script");
                                                          debugExecuteScript.
                                                            setActionCommand(
                                                              "Execute script");
                                                          debugExecuteScript.
                                                            addActionListener(
                                                              this);
                                                          soundChannel1Enable =
                                                            new java.awt.CheckboxMenuItem(
                                                              "Channel 1 (Square wave)");
                                                          soundChannel1Enable.
                                                            addItemListener(
                                                              this);
                                                          soundChannel1Enable.
                                                            setState(
                                                              true);
                                                          soundChannel2Enable =
                                                            new java.awt.CheckboxMenuItem(
                                                              "Channel 2 (Square wave)");
                                                          soundChannel2Enable.
                                                            addItemListener(
                                                              this);
                                                          soundChannel2Enable.
                                                            setState(
                                                              true);
                                                          soundChannel3Enable =
                                                            new java.awt.CheckboxMenuItem(
                                                              "Channel 3 (Voluntary wave)");
                                                          soundChannel3Enable.
                                                            addItemListener(
                                                              this);
                                                          soundChannel3Enable.
                                                            setState(
                                                              true);
                                                          soundChannel4Enable =
                                                            new java.awt.CheckboxMenuItem(
                                                              "Channel 4 (Noise)");
                                                          soundChannel4Enable.
                                                            addItemListener(
                                                              this);
                                                          soundChannel4Enable.
                                                            setState(
                                                              true);
                                                          soundFreq11 =
                                                            new java.awt.CheckboxMenuItem(
                                                              "Sample rate: 11khz");
                                                          soundFreq11.
                                                            addItemListener(
                                                              this);
                                                          soundFreq22 =
                                                            new java.awt.CheckboxMenuItem(
                                                              "Sample rate: 22khz");
                                                          soundFreq22.
                                                            addItemListener(
                                                              this);
                                                          soundFreq44 =
                                                            new java.awt.CheckboxMenuItem(
                                                              "Sample rate: 44khz");
                                                          soundFreq44.
                                                            addItemListener(
                                                              this);
                                                          soundFreq44.
                                                            setState(
                                                              true);
                                                          soundBuffer200 =
                                                            new java.awt.CheckboxMenuItem(
                                                              "Buffer length: 200ms");
                                                          soundBuffer200.
                                                            addItemListener(
                                                              this);
                                                          soundBuffer200.
                                                            setState(
                                                              true);
                                                          soundBuffer300 =
                                                            new java.awt.CheckboxMenuItem(
                                                              "Buffer length: 300ms");
                                                          soundBuffer300.
                                                            addItemListener(
                                                              this);
                                                          soundBuffer400 =
                                                            new java.awt.CheckboxMenuItem(
                                                              "Buffer length: 400ms");
                                                          soundBuffer400.
                                                            addItemListener(
                                                              this);
                                                          java.awt.MenuItem networkConnect =
                                                            new java.awt.MenuItem(
                                                            "Connect to client");
                                                          networkConnect.
                                                            setActionCommand(
                                                              "Connect to client");
                                                          networkConnect.
                                                            addActionListener(
                                                              this);
                                                          networkServer =
                                                            new java.awt.CheckboxMenuItem(
                                                              "Allow connections");
                                                          networkServer.
                                                            addItemListener(
                                                              this);
                                                          networkPrinter =
                                                            new java.awt.CheckboxMenuItem(
                                                              "Emulate printer");
                                                          networkPrinter.
                                                            addItemListener(
                                                              this);
                                                          java.awt.Menu fileMenu =
                                                            new java.awt.Menu(
                                                            "File");
                                                          java.awt.Menu viewMenu =
                                                            new java.awt.Menu(
                                                            "View");
                                                          java.awt.Menu soundMenu =
                                                            new java.awt.Menu(
                                                            "Sound");
                                                          java.awt.Menu networkMenu =
                                                            new java.awt.Menu(
                                                            "Serial Port");
                                                          java.awt.Menu debugMenu =
                                                            new java.awt.Menu(
                                                            "Debug");
                                                          fileMenu.
                                                            add(
                                                              fileOpen);
                                                          fileMenu.
                                                            add(
                                                              fileReset);
                                                          fileMenu.
                                                            add(
                                                              filePause);
                                                          fileMenu.
                                                            add(
                                                              fileEmulate);
                                                          fileMenu.
                                                            add(
                                                              fileGameboyColor);
                                                          fileMenu.
                                                            add(
                                                              fileControls);
                                                          fileMenu.
                                                            add(
                                                              new java.awt.MenuItem(
                                                                "-"));
                                                          fileMenu.
                                                            add(
                                                              fileQuit);
                                                          viewMenu.
                                                            add(
                                                              viewSingle);
                                                          viewMenu.
                                                            add(
                                                              viewDouble);
                                                          viewMenu.
                                                            add(
                                                              viewTriple);
                                                          viewMenu.
                                                            add(
                                                              viewQuadrouple);
                                                          viewMenu.
                                                            add(
                                                              view5);
                                                          viewMenu.
                                                            add(
                                                              view6);
                                                          viewMenu.
                                                            add(
                                                              new java.awt.MenuItem(
                                                                "-"));
                                                          viewMenu.
                                                            add(
                                                              viewFrameSkip0);
                                                          viewMenu.
                                                            add(
                                                              viewFrameSkip1);
                                                          viewMenu.
                                                            add(
                                                              viewFrameSkip2);
                                                          viewMenu.
                                                            add(
                                                              viewFrameSkip3);
                                                          viewMenu.
                                                            add(
                                                              viewFrameSkip4);
                                                          viewMenu.
                                                            add(
                                                              new java.awt.MenuItem(
                                                                "-"));
                                                          viewMenu.
                                                            add(
                                                              viewFrameCounter);
                                                          viewMenu.
                                                            add(
                                                              viewSpeedThrottle);
                                                          viewMenu.
                                                            add(
                                                              new java.awt.MenuItem(
                                                                "-"));
                                                          for (int r =
                                                                 0;
                                                               r <
                                                                 JavaBoy.
                                                                   schemeNames.
                                                                   length;
                                                               r++) {
                                                              schemes[r] =
                                                                new java.awt.CheckboxMenuItem(
                                                                  JavaBoy.
                                                                    schemeNames[r]);
                                                              schemes[r].
                                                                addItemListener(
                                                                  this);
                                                              viewMenu.
                                                                add(
                                                                  schemes[r]);
                                                              if (r ==
                                                                    0)
                                                                  schemes[r].
                                                                    setState(
                                                                      true);
                                                          }
                                                          soundMenu.
                                                            add(
                                                              soundChannel1Enable);
                                                          soundMenu.
                                                            add(
                                                              soundChannel2Enable);
                                                          soundMenu.
                                                            add(
                                                              soundChannel3Enable);
                                                          soundMenu.
                                                            add(
                                                              soundChannel4Enable);
                                                          soundMenu.
                                                            add(
                                                              new java.awt.MenuItem(
                                                                "-"));
                                                          soundMenu.
                                                            add(
                                                              soundFreq11);
                                                          soundMenu.
                                                            add(
                                                              soundFreq22);
                                                          soundMenu.
                                                            add(
                                                              soundFreq44);
                                                          soundMenu.
                                                            add(
                                                              new java.awt.MenuItem(
                                                                "-"));
                                                          soundMenu.
                                                            add(
                                                              soundBuffer200);
                                                          soundMenu.
                                                            add(
                                                              soundBuffer300);
                                                          soundMenu.
                                                            add(
                                                              soundBuffer400);
                                                          networkMenu.
                                                            add(
                                                              networkConnect);
                                                          networkMenu.
                                                            add(
                                                              networkServer);
                                                          networkMenu.
                                                            add(
                                                              networkPrinter);
                                                          debugMenu.
                                                            add(
                                                              debugEnter);
                                                          debugMenu.
                                                            add(
                                                              debugExecuteScript);
                                                          menuBar.
                                                            add(
                                                              fileMenu);
                                                          menuBar.
                                                            add(
                                                              viewMenu);
                                                          menuBar.
                                                            add(
                                                              soundMenu);
                                                          menuBar.
                                                            add(
                                                              networkMenu);
                                                          menuBar.
                                                            add(
                                                              debugMenu);
                                                          setMenuBar(
                                                            menuBar);
    }
    public void init() { setWindowSize(viewSetting);
                         setMagnify(); }
    public void makeConnectDialog() { connectDialog =
                                        new java.awt.Dialog(
                                          this,
                                          "Game Link connect",
                                          true);
                                      java.awt.Panel p1 =
                                        new java.awt.Panel(
                                        );
                                      java.awt.Panel p2 =
                                        new java.awt.Panel(
                                        );
                                      java.awt.Panel p3 =
                                        new java.awt.Panel(
                                        );
                                      p1.
                                        add(
                                          new java.awt.Label(
                                            "Host address:"),
                                          "Center");
                                      hostAddress =
                                        new java.awt.TextField(
                                          35);
                                      p2.
                                        add(
                                          hostAddress,
                                          "Center");
                                      java.awt.Button connectButton =
                                        new java.awt.Button(
                                        "Connect");
                                      connectButton.
                                        setActionCommand(
                                          "Connect ok");
                                      connectButton.
                                        addActionListener(
                                          this);
                                      java.awt.Button cancelButton =
                                        new java.awt.Button(
                                        "Cancel");
                                      cancelButton.
                                        setActionCommand(
                                          "Connect cancel");
                                      cancelButton.
                                        addActionListener(
                                          this);
                                      p3.
                                        add(
                                          cancelButton,
                                          "West");
                                      p3.
                                        add(
                                          connectButton,
                                          "East");
                                      connectDialog.
                                        add(
                                          p1,
                                          "North");
                                      connectDialog.
                                        add(
                                          p2,
                                          "Center");
                                      connectDialog.
                                        add(
                                          p3,
                                          "South");
                                      connectDialog.
                                        setSize(
                                          350,
                                          125);
                                      connectDialog.
                                        setResizable(
                                          false);
                                      connectDialog.
                                        show(
                                          );
    }
    public void setGraphicsChip(GraphicsChip g) {
        graphicsChip =
          g;
    }
    public void update(java.awt.Graphics g) {
        paint(
          g);
    }
    public void clearWindow() { java.awt.Dimension d =
                                  getSize(
                                    );
                                java.awt.Graphics g =
                                  getGraphics(
                                    );
                                g.setColor(
                                    new java.awt.Color(
                                      255,
                                      255,
                                      255));
                                g.fillRect(
                                    0,
                                    0,
                                    d.
                                      width,
                                    d.
                                      height);
    }
    public void componentHidden(java.awt.event.ComponentEvent e) {
        
    }
    public void componentMoved(java.awt.event.ComponentEvent e) {
        
    }
    public void componentResized(java.awt.event.ComponentEvent e) {
        clearWindow(
          );
    }
    public void componentShown(java.awt.event.ComponentEvent e) {
        
    }
    public void setWindowSize(int mag) { setSize(
                                           175 *
                                             mag +
                                             20,
                                           174 *
                                             mag +
                                             20);
    }
    public void setSoundFreq() { if (applet.
                                       dmgcpu !=
                                       null &&
                                       applet.
                                         dmgcpu.
                                         soundChip.
                                         soundEnabled) {
                                     if (soundFreq11.
                                           getState(
                                             )) {
                                         applet.
                                           dmgcpu.
                                           soundChip.
                                           setSampleRate(
                                             11025);
                                     }
                                     if (soundFreq22.
                                           getState(
                                             )) {
                                         applet.
                                           dmgcpu.
                                           soundChip.
                                           setSampleRate(
                                             22050);
                                     }
                                     if (soundFreq44.
                                           getState(
                                             )) {
                                         applet.
                                           dmgcpu.
                                           soundChip.
                                           setSampleRate(
                                             44100);
                                     }
                                 } }
    public void setBufferLength() { if (applet.
                                          dmgcpu !=
                                          null &&
                                          applet.
                                            dmgcpu.
                                            soundChip.
                                            soundEnabled) {
                                        if (soundBuffer200.
                                              getState(
                                                )) {
                                            applet.
                                              dmgcpu.
                                              soundChip.
                                              setBufferLength(
                                                200);
                                        }
                                        if (soundBuffer300.
                                              getState(
                                                )) {
                                            applet.
                                              dmgcpu.
                                              soundChip.
                                              setBufferLength(
                                                300);
                                        }
                                        if (soundBuffer400.
                                              getState(
                                                )) {
                                            applet.
                                              dmgcpu.
                                              soundChip.
                                              setBufferLength(
                                                400);
                                        }
                                    } }
    public void setChannelEnable() { if (applet.
                                           dmgcpu !=
                                           null &&
                                           applet.
                                             dmgcpu.
                                             soundChip.
                                             soundEnabled) {
                                         applet.
                                           dmgcpu.
                                           soundChip.
                                           channel1Enable =
                                           soundChannel1Enable.
                                             getState(
                                               );
                                         applet.
                                           dmgcpu.
                                           soundChip.
                                           channel2Enable =
                                           soundChannel2Enable.
                                             getState(
                                               );
                                         applet.
                                           dmgcpu.
                                           soundChip.
                                           channel3Enable =
                                           soundChannel3Enable.
                                             getState(
                                               );
                                         applet.
                                           dmgcpu.
                                           soundChip.
                                           channel4Enable =
                                           soundChannel4Enable.
                                             getState(
                                               );
                                     } }
    public void setMagnify() { if (applet.
                                     dmgcpu !=
                                     null) {
                                   applet.
                                     dmgcpu.
                                     graphicsChip.
                                     setMagnify(
                                       viewSetting);
                               } }
    public void setFrameSkip() { if (applet.
                                       dmgcpu !=
                                       null) {
                                     if (viewFrameSkip0.
                                           getState(
                                             )) {
                                         graphicsChip.
                                           frameSkip =
                                           1;
                                     }
                                     if (viewFrameSkip1.
                                           getState(
                                             )) {
                                         graphicsChip.
                                           frameSkip =
                                           2;
                                     }
                                     if (viewFrameSkip2.
                                           getState(
                                             )) {
                                         graphicsChip.
                                           frameSkip =
                                           3;
                                     }
                                     if (viewFrameSkip3.
                                           getState(
                                             )) {
                                         graphicsChip.
                                           frameSkip =
                                           4;
                                     }
                                     if (viewFrameSkip4.
                                           getState(
                                             )) {
                                         graphicsChip.
                                           frameSkip =
                                           5;
                                     }
                                 } }
    public void actionPerformed(java.awt.event.ActionEvent e) {
        java.lang.String command =
          e.
          getActionCommand(
            );
        if (command.
              equals(
                "Open ROM")) {
            if (applet.
                  dmgcpu !=
                  null) {
                applet.
                  dmgcpu.
                  terminate =
                  true;
                if (applet.
                      cartridge !=
                      null)
                    applet.
                      cartridge.
                      dispose(
                        );
                if (applet.
                      dmgcpu !=
                      null) {
                    applet.
                      dmgcpu.
                      dispose(
                        );
                    applet.
                      dmgcpu =
                      null;
                }
                clearWindow(
                  );
            }
            java.lang.String recovstr =
              java.lang.System.
              getenv(
                "PANDA_RECOVER");
            boolean recover =
              true;
            if (recovstr !=
                  null &&
                  recovstr.
                  equals(
                    "false")) {
                recover =
                  false;
            }
            java.lang.String cartridgePath =
              java.lang.System.
              getenv(
                "JAVABOY_ROM");
            Cartridge dc =
              (Cartridge)
                ent.runtime.ENT_Runtime.
                putObj(
                  new Cartridge(
                    cartridgePath,
                    this),
                  new java.lang.Integer[] { EntMode.
                                              DYNAMIC_MODE });
            Cartridge cartridge =
              null;
            try {
                cartridge =
                  ent.runtime.ENT_Snapshot.
                    snapshot(
                      dc,
                      EntMode.
                        LOW_MODE,
                      ent.runtime.ENT_Runtime.
                        getObjMode(
                          this,
                          0),
                      false);
            }
            catch (java.lang.Exception e1) {
                cartridge =
                  ent.runtime.ENT_Snapshot.
                    forceSnapshot(
                      dc,
                      EntMode.
                        LOW_MODE,
                      ent.runtime.ENT_Runtime.
                        getObjMode(
                          this,
                          0),
                      false);
                if (recover) {
                    setWindowSize(
                      2);
                    setMagnify(
                      );
                }
            }
            applet.
              cartridge =
              cartridge;
            applet.
              dmgcpu =
              new Dmgcpu(
                applet.
                  cartridge,
                applet.
                  gameLink,
                this);
            if (applet.
                  gameLink !=
                  null)
                applet.
                  gameLink.
                  setDmgcpu(
                    applet.
                      dmgcpu);
            setGraphicsChip(
              applet.
                dmgcpu.
                graphicsChip);
            setSoundFreq(
              );
            setBufferLength(
              );
            setMagnify(
              );
            setFrameSkip(
              );
            setChannelEnable(
              );
            applet.
              dmgcpu.
              allowGbcFeatures =
              fileGameboyColor.
                getState(
                  );
            applet.
              dmgcpu.
              reset(
                );
        }
        else
            if (command.
                  equals(
                    "Frame counter")) {
                viewFrameCounter.
                  setState(
                    !viewFrameCounter.
                      getState(
                        ));
            }
            else
                if (command.
                      equals(
                        "Speed throttle")) {
                    viewSpeedThrottle.
                      setState(
                        !viewSpeedThrottle.
                          getState(
                            ));
                }
                else
                    if (command.
                          equals(
                            "Emulate")) {
                        if (applet.
                              cartridge !=
                              null &&
                              applet.
                                cartridge.
                                cartridgeReady) {
                            applet.
                              queueDebuggerCommand(
                                "g");
                            applet.
                              dmgcpu.
                              terminate =
                              true;
                        }
                        else {
                            new ModalDialog(
                              this,
                              "Error",
                              "You need to load a ROM before",
                              "you select \'Emulate\'.");
                        }
                    }
                    else
                        if (command.
                              equals(
                                "Reset")) {
                            applet.
                              queueDebuggerCommand(
                                "s;g");
                            applet.
                              dmgcpu.
                              terminate =
                              true;
                        }
                        else
                            if (command.
                                  equals(
                                    "Pause")) {
                                applet.
                                  dmgcpu.
                                  terminate =
                                  true;
                            }
                            else
                                if (command.
                                      equals(
                                        "Controls")) {
                                    new DefineControls(
                                      );
                                }
                                else
                                    if (command.
                                          equals(
                                            "Execute script")) {
                                        if (applet.
                                              dmgcpu !=
                                              null) {
                                            java.awt.FileDialog fd =
                                              new java.awt.FileDialog(
                                              this,
                                              "Execute debugger script");
                                            fd.
                                              show(
                                                );
                                            applet.
                                              queueDebuggerCommand(
                                                "c " +
                                                fd.
                                                  getDirectory(
                                                    ) +
                                                fd.
                                                  getFile(
                                                    ));
                                            applet.
                                              dmgcpu.
                                              terminate =
                                              true;
                                        }
                                        else {
                                            new ModalDialog(
                                              this,
                                              "Error",
                                              "Load a ROM before executing a debugger script",
                                              "");
                                        }
                                    }
                                    else
                                        if (command.
                                              equals(
                                                "Enter debugger")) {
                                            if (applet.
                                                  dmgcpu !=
                                                  null) {
                                                applet.
                                                  debuggerActive =
                                                  true;
                                                applet.
                                                  dmgcpu.
                                                  terminate =
                                                  true;
                                            }
                                            else {
                                                new ModalDialog(
                                                  this,
                                                  "Error",
                                                  "Load a ROM before entering the debugger",
                                                  "");
                                            }
                                        }
                                        else
                                            if (command.
                                                  equals(
                                                    "1x")) {
                                                applet.
                                                  dmgcpu.
                                                  graphicsChip.
                                                  setMagnify(
                                                    1);
                                                setWindowSize(
                                                  1);
                                                clearWindow(
                                                  );
                                            }
                                            else
                                                if (command.
                                                      equals(
                                                        "2x")) {
                                                    applet.
                                                      dmgcpu.
                                                      graphicsChip.
                                                      setMagnify(
                                                        2);
                                                    setWindowSize(
                                                      2);
                                                    clearWindow(
                                                      );
                                                }
                                                else
                                                    if (command.
                                                          equals(
                                                            "3x")) {
                                                        applet.
                                                          dmgcpu.
                                                          graphicsChip.
                                                          setMagnify(
                                                            3);
                                                        setWindowSize(
                                                          3);
                                                        clearWindow(
                                                          );
                                                    }
                                                    else
                                                        if (command.
                                                              equals(
                                                                "4x")) {
                                                            applet.
                                                              dmgcpu.
                                                              graphicsChip.
                                                              setMagnify(
                                                                4);
                                                            setWindowSize(
                                                              4);
                                                            clearWindow(
                                                              );
                                                        }
                                                        else
                                                            if (command.
                                                                  equals(
                                                                    "Connect to client")) {
                                                                makeConnectDialog(
                                                                  );
                                                            }
                                                            else
                                                                if (command.
                                                                      equals(
                                                                        "Connect cancel")) {
                                                                    connectDialog.
                                                                      hide(
                                                                        );
                                                                    connectDialog =
                                                                      null;
                                                                }
                                                                else
                                                                    if (command.
                                                                          equals(
                                                                            "Connect ok")) {
                                                                        connectDialog.
                                                                          hide(
                                                                            );
                                                                        connectDialog =
                                                                          null;
                                                                        applet.
                                                                          gameLink =
                                                                          new TCPGameLink(
                                                                            this,
                                                                            hostAddress.
                                                                              getText(
                                                                                ));
                                                                        if (applet.
                                                                              dmgcpu !=
                                                                              null) {
                                                                            applet.
                                                                              dmgcpu.
                                                                              gameLink =
                                                                              applet.
                                                                                gameLink;
                                                                            applet.
                                                                              gameLink.
                                                                              setDmgcpu(
                                                                                applet.
                                                                                  dmgcpu);
                                                                        }
                                                                    }
                                                                    else
                                                                        if (command.
                                                                              equals(
                                                                                "Exit")) {
                                                                            applet.
                                                                              dispose(
                                                                                );
                                                                            java.lang.System.
                                                                              exit(
                                                                                0);
                                                                        }
    }
    public void setColourScheme(java.lang.String command) {
        if (applet.
              dmgcpu ==
              null) {
            new ModalDialog(
              this,
              "Error",
              "Load a ROM before selecting",
              "a colour scheme.");
            for (int r =
                   0;
                 r <
                   JavaBoy.
                     schemeNames.
                     length;
                 r++) {
                if (JavaBoy.
                      schemeNames[r] ==
                      command) {
                    schemes[r].
                      setState(
                        false);
                }
            }
        }
        else {
            for (int r =
                   0;
                 r <
                   JavaBoy.
                     schemeNames.
                     length;
                 r++) {
                if (JavaBoy.
                      schemeNames[r] ==
                      command) {
                    applet.
                      dmgcpu.
                      graphicsChip.
                      backgroundPalette.
                      setColours(
                        JavaBoy.
                          schemeColours[r][0],
                        JavaBoy.
                          schemeColours[r][1],
                        JavaBoy.
                          schemeColours[r][2],
                        JavaBoy.
                          schemeColours[r][3]);
                    applet.
                      dmgcpu.
                      graphicsChip.
                      obj1Palette.
                      setColours(
                        JavaBoy.
                          schemeColours[r][4],
                        JavaBoy.
                          schemeColours[r][5],
                        JavaBoy.
                          schemeColours[r][6],
                        JavaBoy.
                          schemeColours[r][7]);
                    applet.
                      dmgcpu.
                      graphicsChip.
                      obj2Palette.
                      setColours(
                        JavaBoy.
                          schemeColours[r][8],
                        JavaBoy.
                          schemeColours[r][9],
                        JavaBoy.
                          schemeColours[r][10],
                        JavaBoy.
                          schemeColours[r][11]);
                    applet.
                      dmgcpu.
                      graphicsChip.
                      invalidateAll(
                        );
                }
                else {
                    schemes[r].
                      setState(
                        false);
                }
            }
        }
    }
    public void itemStateChanged(java.awt.event.ItemEvent e) {
        java.lang.String command =
          (java.lang.String)
            e.
            getItem(
              );
        java.lang.System.
          out.
          println(
            command);
        if (command.
              equals(
                "Channel 1 (Square wave)")) {
            if (applet.
                  dmgcpu !=
                  null) {
                applet.
                  dmgcpu.
                  soundChip.
                  channel1Enable =
                  soundChannel1Enable.
                    getState(
                      );
            }
        }
        else
            if (command.
                  equals(
                    "Channel 2 (Square wave)")) {
                if (applet.
                      dmgcpu !=
                      null) {
                    applet.
                      dmgcpu.
                      soundChip.
                      channel2Enable =
                      soundChannel2Enable.
                        getState(
                          );
                }
            }
            else
                if (command.
                      equals(
                        "Channel 3 (Voluntary wave)")) {
                    if (applet.
                          dmgcpu !=
                          null) {
                        applet.
                          dmgcpu.
                          soundChip.
                          channel3Enable =
                          soundChannel3Enable.
                            getState(
                              );
                    }
                }
                else
                    if (command.
                          equals(
                            "Channel 4 (Noise)")) {
                        if (applet.
                              dmgcpu !=
                              null) {
                            applet.
                              dmgcpu.
                              soundChip.
                              channel4Enable =
                              soundChannel4Enable.
                                getState(
                                  );
                        }
                    }
                    else
                        if (command.
                              equals(
                                "Size: actual")) {
                            viewSingle.
                              setState(
                                true);
                            viewDouble.
                              setState(
                                false);
                            viewTriple.
                              setState(
                                false);
                            viewQuadrouple.
                              setState(
                                false);
                            view5.
                              setState(
                                false);
                            view6.
                              setState(
                                false);
                            setMagnify(
                              );
                            setWindowSize(
                              1);
                        }
                        else
                            if (command.
                                  equals(
                                    "Size: 2x")) {
                                viewSingle.
                                  setState(
                                    false);
                                viewDouble.
                                  setState(
                                    true);
                                viewTriple.
                                  setState(
                                    false);
                                viewQuadrouple.
                                  setState(
                                    false);
                                view5.
                                  setState(
                                    false);
                                view6.
                                  setState(
                                    false);
                                setMagnify(
                                  );
                                setWindowSize(
                                  2);
                            }
                            else
                                if (command.
                                      equals(
                                        "Size: 3x")) {
                                    viewSingle.
                                      setState(
                                        false);
                                    viewDouble.
                                      setState(
                                        false);
                                    viewTriple.
                                      setState(
                                        true);
                                    viewQuadrouple.
                                      setState(
                                        false);
                                    view5.
                                      setState(
                                        false);
                                    view6.
                                      setState(
                                        false);
                                    setMagnify(
                                      );
                                    setWindowSize(
                                      3);
                                }
                                else
                                    if (command.
                                          equals(
                                            "Size: 4x")) {
                                        viewSingle.
                                          setState(
                                            false);
                                        viewDouble.
                                          setState(
                                            false);
                                        viewTriple.
                                          setState(
                                            false);
                                        viewQuadrouple.
                                          setState(
                                            true);
                                        view5.
                                          setState(
                                            false);
                                        view6.
                                          setState(
                                            false);
                                        setMagnify(
                                          );
                                        setWindowSize(
                                          4);
                                    }
                                    else
                                        if (command.
                                              equals(
                                                "Size: 5x")) {
                                            viewSingle.
                                              setState(
                                                false);
                                            viewDouble.
                                              setState(
                                                false);
                                            viewTriple.
                                              setState(
                                                false);
                                            viewQuadrouple.
                                              setState(
                                                false);
                                            view5.
                                              setState(
                                                true);
                                            view6.
                                              setState(
                                                false);
                                            setMagnify(
                                              );
                                            setWindowSize(
                                              5);
                                        }
                                        else
                                            if (command.
                                                  equals(
                                                    "Size: 6x")) {
                                                viewSingle.
                                                  setState(
                                                    false);
                                                viewDouble.
                                                  setState(
                                                    false);
                                                viewTriple.
                                                  setState(
                                                    false);
                                                viewQuadrouple.
                                                  setState(
                                                    false);
                                                view5.
                                                  setState(
                                                    false);
                                                view6.
                                                  setState(
                                                    true);
                                                setMagnify(
                                                  );
                                                setWindowSize(
                                                  6);
                                            }
                                            else
                                                if (command.
                                                      equals(
                                                        "Sample rate: 11khz")) {
                                                    soundFreq22.
                                                      setState(
                                                        false);
                                                    soundFreq44.
                                                      setState(
                                                        false);
                                                    soundFreq11.
                                                      setState(
                                                        true);
                                                    setSoundFreq(
                                                      );
                                                }
                                                else
                                                    if (command.
                                                          equals(
                                                            "Sample rate: 22khz")) {
                                                        soundFreq11.
                                                          setState(
                                                            false);
                                                        soundFreq44.
                                                          setState(
                                                            false);
                                                        soundFreq22.
                                                          setState(
                                                            true);
                                                        setSoundFreq(
                                                          );
                                                    }
                                                    else
                                                        if (command.
                                                              equals(
                                                                "Frame skip: 0")) {
                                                            viewFrameSkip0.
                                                              setState(
                                                                true);
                                                            viewFrameSkip1.
                                                              setState(
                                                                false);
                                                            viewFrameSkip2.
                                                              setState(
                                                                false);
                                                            viewFrameSkip3.
                                                              setState(
                                                                false);
                                                            viewFrameSkip4.
                                                              setState(
                                                                false);
                                                            setFrameSkip(
                                                              );
                                                        }
                                                        else
                                                            if (command.
                                                                  equals(
                                                                    "Frame skip: 1")) {
                                                                viewFrameSkip0.
                                                                  setState(
                                                                    false);
                                                                viewFrameSkip1.
                                                                  setState(
                                                                    true);
                                                                viewFrameSkip2.
                                                                  setState(
                                                                    false);
                                                                viewFrameSkip3.
                                                                  setState(
                                                                    false);
                                                                viewFrameSkip4.
                                                                  setState(
                                                                    false);
                                                                setFrameSkip(
                                                                  );
                                                            }
                                                            else
                                                                if (command.
                                                                      equals(
                                                                        "Frame skip: 2")) {
                                                                    viewFrameSkip0.
                                                                      setState(
                                                                        false);
                                                                    viewFrameSkip1.
                                                                      setState(
                                                                        false);
                                                                    viewFrameSkip2.
                                                                      setState(
                                                                        true);
                                                                    viewFrameSkip3.
                                                                      setState(
                                                                        false);
                                                                    viewFrameSkip4.
                                                                      setState(
                                                                        false);
                                                                    setFrameSkip(
                                                                      );
                                                                }
                                                                else
                                                                    if (command.
                                                                          equals(
                                                                            "Frame skip: 3")) {
                                                                        viewFrameSkip0.
                                                                          setState(
                                                                            false);
                                                                        viewFrameSkip1.
                                                                          setState(
                                                                            false);
                                                                        viewFrameSkip2.
                                                                          setState(
                                                                            false);
                                                                        viewFrameSkip3.
                                                                          setState(
                                                                            true);
                                                                        viewFrameSkip4.
                                                                          setState(
                                                                            false);
                                                                        setFrameSkip(
                                                                          );
                                                                    }
                                                                    else
                                                                        if (command.
                                                                              equals(
                                                                                "Frame skip: 4")) {
                                                                            viewFrameSkip0.
                                                                              setState(
                                                                                false);
                                                                            viewFrameSkip1.
                                                                              setState(
                                                                                false);
                                                                            viewFrameSkip2.
                                                                              setState(
                                                                                false);
                                                                            viewFrameSkip3.
                                                                              setState(
                                                                                false);
                                                                            viewFrameSkip4.
                                                                              setState(
                                                                                true);
                                                                            setFrameSkip(
                                                                              );
                                                                        }
                                                                        else
                                                                            if (command.
                                                                                  equals(
                                                                                    "Sample rate: 44khz")) {
                                                                                soundFreq11.
                                                                                  setState(
                                                                                    false);
                                                                                soundFreq22.
                                                                                  setState(
                                                                                    false);
                                                                                soundFreq44.
                                                                                  setState(
                                                                                    true);
                                                                                setSoundFreq(
                                                                                  );
                                                                            }
                                                                            else
                                                                                if (command.
                                                                                      equals(
                                                                                        "Buffer length: 200ms")) {
                                                                                    soundBuffer300.
                                                                                      setState(
                                                                                        false);
                                                                                    soundBuffer400.
                                                                                      setState(
                                                                                        false);
                                                                                    soundBuffer200.
                                                                                      setState(
                                                                                        true);
                                                                                    setBufferLength(
                                                                                      );
                                                                                }
                                                                                else
                                                                                    if (command.
                                                                                          equals(
                                                                                            "Buffer length: 300ms")) {
                                                                                        soundBuffer200.
                                                                                          setState(
                                                                                            false);
                                                                                        soundBuffer400.
                                                                                          setState(
                                                                                            false);
                                                                                        soundBuffer300.
                                                                                          setState(
                                                                                            true);
                                                                                        setBufferLength(
                                                                                          );
                                                                                    }
                                                                                    else
                                                                                        if (command.
                                                                                              equals(
                                                                                                "Buffer length: 400ms")) {
                                                                                            soundBuffer200.
                                                                                              setState(
                                                                                                false);
                                                                                            soundBuffer300.
                                                                                              setState(
                                                                                                false);
                                                                                            soundBuffer400.
                                                                                              setState(
                                                                                                true);
                                                                                            setBufferLength(
                                                                                              );
                                                                                        }
                                                                                        else
                                                                                            if (command.
                                                                                                  equals(
                                                                                                    "Use Gameboy Color features")) {
                                                                                                if (applet.
                                                                                                      dmgcpu !=
                                                                                                      null) {
                                                                                                    applet.
                                                                                                      dmgcpu.
                                                                                                      allowGbcFeatures =
                                                                                                      !applet.
                                                                                                         dmgcpu.
                                                                                                         allowGbcFeatures;
                                                                                                }
                                                                                                else {
                                                                                                    fileGameboyColor.
                                                                                                      setState(
                                                                                                        !fileGameboyColor.
                                                                                                          getState(
                                                                                                            ));
                                                                                                }
                                                                                            }
                                                                                            else
                                                                                                if (command.
                                                                                                      equals(
                                                                                                        "Allow connections")) {
                                                                                                    if (applet.
                                                                                                          gameLink ==
                                                                                                          null) {
                                                                                                        applet.
                                                                                                          gameLink =
                                                                                                          new TCPGameLink(
                                                                                                            this);
                                                                                                        if (applet.
                                                                                                              gameLink.
                                                                                                              serverRunning) {
                                                                                                            networkServer.
                                                                                                              setState(
                                                                                                                true);
                                                                                                        }
                                                                                                        else {
                                                                                                            networkServer.
                                                                                                              setState(
                                                                                                                false);
                                                                                                            applet.
                                                                                                              gameLink =
                                                                                                              null;
                                                                                                        }
                                                                                                        if (applet.
                                                                                                              dmgcpu !=
                                                                                                              null) {
                                                                                                            applet.
                                                                                                              dmgcpu.
                                                                                                              gameLink =
                                                                                                              applet.
                                                                                                                gameLink;
                                                                                                            applet.
                                                                                                              gameLink.
                                                                                                              setDmgcpu(
                                                                                                                applet.
                                                                                                                  dmgcpu);
                                                                                                        }
                                                                                                    }
                                                                                                    else {
                                                                                                        applet.
                                                                                                          gameLink.
                                                                                                          shutDown(
                                                                                                            );
                                                                                                        applet.
                                                                                                          gameLink =
                                                                                                          null;
                                                                                                        if (applet.
                                                                                                              dmgcpu !=
                                                                                                              null)
                                                                                                            applet.
                                                                                                              dmgcpu.
                                                                                                              gameLink =
                                                                                                              null;
                                                                                                    }
                                                                                                }
                                                                                                else
                                                                                                    if (command.
                                                                                                          equals(
                                                                                                            "Emulate printer")) {
                                                                                                        if (networkPrinter.
                                                                                                              getState(
                                                                                                                )) {
                                                                                                            if (applet.
                                                                                                                  gameLink !=
                                                                                                                  null) {
                                                                                                                applet.
                                                                                                                  gameLink.
                                                                                                                  shutDown(
                                                                                                                    );
                                                                                                                networkServer.
                                                                                                                  setState(
                                                                                                                    false);
                                                                                                            }
                                                                                                            applet.
                                                                                                              gameLink =
                                                                                                              new GameBoyPrinter(
                                                                                                                );
                                                                                                            applet.
                                                                                                              gameLink.
                                                                                                              setDmgcpu(
                                                                                                                applet.
                                                                                                                  dmgcpu);
                                                                                                            applet.
                                                                                                              dmgcpu.
                                                                                                              gameLink =
                                                                                                              applet.
                                                                                                                gameLink;
                                                                                                        }
                                                                                                        else {
                                                                                                            applet.
                                                                                                              gameLink.
                                                                                                              shutDown(
                                                                                                                );
                                                                                                            applet.
                                                                                                              gameLink =
                                                                                                              null;
                                                                                                        }
                                                                                                    }
                                                                                                    else {
                                                                                                        setColourScheme(
                                                                                                          command);
                                                                                                    }
    }
    public void paint(java.awt.Graphics g) {
        if (graphicsChip !=
              null) {
            java.awt.Dimension d =
              getSize(
                );
            int x =
              d.
                width /
              2 -
              graphicsChip.
                width /
              2;
            int y =
              d.
                height /
              2 -
              graphicsChip.
                height /
              2;
            boolean b =
              graphicsChip.
              draw(
                g,
                x,
                y +
                  20,
                this);
            if (viewFrameCounter.
                  getState(
                    )) {
                g.
                  setColor(
                    new java.awt.Color(
                      255,
                      255,
                      255));
                g.
                  fillRect(
                    0,
                    d.
                      height -
                      20,
                    d.
                      width,
                    20);
                g.
                  setColor(
                    new java.awt.Color(
                      0,
                      0,
                      0));
                g.
                  drawString(
                    graphicsChip.
                      getFPS(
                        ) +
                    " frames per second",
                    10,
                    d.
                      height -
                      7);
            }
        }
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
       "O0peJMN5az7Py4tpZVYJqSE+itoawwkF");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "/2UWfD7M3XWok3ZjVdmR+U+uVSYMgKKtzOgnJPP3zpD5pSz4Qpi9dbaVyarZ" +
       "e4m7Qv/19WjP1Vbo6ick9KtnCP1aFvy74+051N1k12y/cq0ynwJA79/KfP91" +
       "l1lYS/nGGTK/lQV/HObuBEPPxkMNQWvuqPyTa1X5RsDz/Fbl89dH5XER3zkj" +
       "7s+z4L+GuTuAwOHBM/A7+v7btep7FKC+sNX3wvXX94Mz4n6YBa9u5g6bh8Mp" +
       "1dHWPzhwXOIVn019LXOHl7YSX7ruEvf3z4i7McP5C+BzgMTtWyiHL6Ec1/iX" +
       "16rxDQD301uNn77+Gu86I+6eLLgtzN0ONNKi5hiz1aXq9m+/Hp3wC1t1X7j+" +
       "6h4+I+5NWfDAphMevrO2o+/Ba9UHAdSvb/V9/fro25kKPXziXfnhPGj/LWdU" +
       "wTNZ8ATop+I6E6P62a847I6b+09eh3uZ/e1LCvuXvaRwTbWQfc2vtaBn6Fyr" +
       "gDf+KHvzIvKH62dzd3Tmr1XnM0CftdVp/URa+6ETFk2O2vqdZ9QBngUXgcMy" +
       "QJbsZ43UzG1plzX226/DuHPDE5u8m//Xs7H3fm0tpneGUCYL2mHuJk/cPA57" +
       "XF3nPOqWu78i4x2+tH/XYTusXcdy00APHV9nWy/T3Xel6x1mOf6rI9ky1foH" +
       "rQ6WlKLNT1o9J3/2pU7vva+WPrX51RPZEtM0K+VWKnfL5gdY1oVmy1JPnFra" +
       "QVk3k2/90V2fu+3N2yW0zU9i3HesiY6xPXbyT4wQtheufxQk/Wev/8dv//RL" +
       "31g/a/v/AQ67wuppTAAA");
}
