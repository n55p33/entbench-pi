class TCPGameLink extends GameLink implements java.lang.Runnable {
    final int PORTNO = 1989;
    Dmgcpu dmgcpu;
    java.net.ServerSocket server;
    java.net.Socket client;
    java.io.BufferedInputStream inStream;
    java.io.BufferedOutputStream outStream;
    boolean terminate = false;
    boolean clientConnected = false;
    java.awt.Frame parent;
    public TCPGameLink(java.awt.Frame parent) { super();
                                                this.parent = parent;
                                                try { server = new java.net.ServerSocket(
                                                                 PORTNO);
                                                      new ModalDialog(
                                                        parent,
                                                        "Server startup succeeded!",
                                                        "Game Link server running",
                                                        "A client can now connect.");
                                                      java.lang.Thread t =
                                                        new java.lang.Thread(
                                                        this);
                                                      t.
                                                        start(
                                                          );
                                                      serverRunning =
                                                        true;
                                                }
                                                catch (java.lang.Exception e) {
                                                    new ModalDialog(
                                                      parent,
                                                      "Server startup failed",
                                                      "Cannot start server on port " +
                                                      PORTNO,
                                                      "Check that the port is not in use.");
                                                }
    }
    public TCPGameLink(java.awt.Frame parent,
                       java.lang.String ip) {
        super(
          );
        this.
          parent =
          parent;
        try {
            client =
              new java.net.Socket(
                java.net.InetAddress.
                  getByName(
                    ip),
                PORTNO);
            client.
              setTcpNoDelay(
                true);
            outStream =
              new java.io.BufferedOutputStream(
                client.
                  getOutputStream(
                    ));
            inStream =
              new java.io.BufferedInputStream(
                client.
                  getInputStream(
                    ));
            new ModalDialog(
              parent,
              "Connect succeeded!",
              "Connected to Game Link server.",
              "You may now start a two player game.");
            java.lang.Thread t =
              new java.lang.Thread(
              this);
            t.
              start(
                );
            clientConnected =
              true;
        }
        catch (java.lang.Exception e) {
            new ModalDialog(
              parent,
              "Connect failed",
              "Cannot connect to host " +
              ip +
              ":" +
              PORTNO,
              "Ensure \'allow connections\' is checked on the server.");
        }
    }
    public void setDmgcpu(Dmgcpu d) { dmgcpu =
                                        d;
    }
    public void shutDown() { terminate = true;
                             try { if (server !=
                                         null)
                                       server.
                                         close(
                                           );
                             }
                             catch (java.lang.Exception e) {
                                 
                             } }
    public void writeInt(java.io.OutputStream s,
                         int i) { int b1;
                                  int b2;
                                  int b3;
                                  int b4;
                                  b1 = i &
                                         255;
                                  b2 = (i &
                                          65280) >>
                                         8;
                                  b3 = (i &
                                          16711680) >>
                                         16;
                                  b4 = (i &
                                          -16777216) >>
                                         24;
                                  try { s.
                                          write(
                                            b1);
                                        s.
                                          write(
                                            b2);
                                        s.
                                          write(
                                            b3);
                                        s.
                                          write(
                                            b4);
                                  }
                                  catch (java.io.IOException e) {
                                      
                                  } }
    public void run() { while ((serverRunning ||
                                  clientConnected) &&
                                 !terminate) {
                            try {
                                if (serverRunning) {
                                    java.net.Socket conn =
                                      null;
                                    conn =
                                      server.
                                        accept(
                                          );
                                    java.lang.System.
                                      out.
                                      println(
                                        "Connection established!");
                                    outStream =
                                      new java.io.BufferedOutputStream(
                                        conn.
                                          getOutputStream(
                                            ));
                                    inStream =
                                      new java.io.BufferedInputStream(
                                        conn.
                                          getInputStream(
                                            ));
                                }
                                int data =
                                  0;
                                int clock;
                                int initial;
                                int b1;
                                int b2;
                                int b3;
                                int b4;
                                int v =
                                  0;
                                while (data !=
                                         -1 &&
                                         !terminate) {
                                    if (dmgcpu !=
                                          null) {
                                        v =
                                          dmgcpu.
                                            instrCount;
                                    }
                                    initial =
                                      inStream.
                                        read(
                                          );
                                    b1 =
                                      inStream.
                                        read(
                                          );
                                    b2 =
                                      inStream.
                                        read(
                                          );
                                    b3 =
                                      inStream.
                                        read(
                                          );
                                    b4 =
                                      inStream.
                                        read(
                                          );
                                    clock =
                                      b1 +
                                        (b2 <<
                                           8) +
                                        (b3 <<
                                           16) +
                                        (b4 <<
                                           24);
                                    data =
                                      inStream.
                                        read(
                                          );
                                    if (dmgcpu !=
                                          null) {
                                        while (!dmgcpu.
                                                  interruptsEnabled ||
                                                 (dmgcpu.
                                                    ioHandler.
                                                    registers[15] &
                                                    dmgcpu.
                                                      INT_SER) !=
                                                 0 &&
                                                 !terminate) {
                                            try {
                                                java.lang.Thread.
                                                  sleep(
                                                    5);
                                            }
                                            catch (java.lang.InterruptedException e) {
                                                
                                            }
                                        }
                                    }
                                    if (initial ==
                                          1) {
                                        outStream.
                                          write(
                                            0);
                                        writeInt(
                                          outStream,
                                          -1);
                                        outStream.
                                          write(
                                            dmgcpu.
                                              ioHandler.
                                              registers[1]);
                                        outStream.
                                          flush(
                                            );
                                        dmgcpu.
                                          ioHandler.
                                          registers[2] &=
                                          127;
                                        dmgcpu.
                                          ioHandler.
                                          registers[1] =
                                          (byte)
                                            data;
                                        dmgcpu.
                                          triggerInterrupt(
                                            dmgcpu.
                                              INT_SER);
                                    }
                                    else
                                        if (initial ==
                                              0) {
                                            dmgcpu.
                                              ioHandler.
                                              registers[2] &=
                                              127;
                                            dmgcpu.
                                              ioHandler.
                                              registers[1] =
                                              (byte)
                                                data;
                                            dmgcpu.
                                              triggerInterrupt(
                                                dmgcpu.
                                                  INT_SER);
                                        }
                                }
                            }
                            catch (java.io.IOException e) {
                                
                            }
                            clientConnected =
                              false;
                            new ModalDialog(
                              parent,
                              "Connection lost",
                              "The connection with the other",
                              "machine has been lost.");
                        } }
    public void send(byte b) { try { outStream.
                                       write(
                                         1);
                                     writeInt(
                                       outStream,
                                       dmgcpu.
                                         instrCount);
                                     outStream.
                                       write(
                                         b);
                                     outStream.
                                       flush(
                                         );
                                     try {
                                         java.lang.Thread.
                                           sleep(
                                             10);
                                     }
                                     catch (java.lang.InterruptedException e) {
                                         
                                     } }
                               catch (java.io.IOException e) {
                                   
                               } }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1470933729000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1470933729000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "qSMhAjyn3PEAvWgGdDAl17G1hYmWz+W9HhQy4iSepCTckL1ha5cHSQqCZZpa" +
       "2JwSeTAIiBcBTMptiGnuWLByp9WR2YS6Joy1FWcJvtR/sPiE/7X721p4qtwW" +
       "Obtw8h1siGzvtPlzto909rt0Y+HCPtKF86Wzo8lr59sqfOr7xfFosWv/9jvd" +
       "Nyl37D/3sVc+q7M/Wz8+2Xv6YLF5F4Q/4Bobw70wSnG36r13Pp0Yl9dtzo+S" +
       "futjf/aM+EPLD93HpYF3HOA87PJfjV/9nf73az9xXHng7GDplotAl4luXj5O" +
       "ejwykjTyxUuHSm+/fET5HEjGidCNw8278zm+9RSo1Ja9jhycKh6dN1iWDb50" +
       "l2PHPyqy3weTEBsJeX4ScbhftQls/VzZ/uB+zibLgi9e5vrNIK1OuF59b7i+" +
       "yNR/ukvdfymyrySVR+NlmpBBVu4K//E5b1/9bnl7X6U4etv/ku8NbycnzKeG" +
       "98bT3fjDXfgfLqn/x124/59F9meA+yyyE4Pa7/he4P7r3y3310D6+An3H//e" +
       "z+xf36Xu20X2V0nlgSg9nNT//d2yVZz9fvmErS9/T830tua22CXlnvTRY3fm" +
       "96i4jHH0IGgdg/j1MsNHD93X7YHLd7zC8FTRHj0t2h5dcM0nEioFe+1e45yR" +
       "XLwNVLjz8orpqetN95dMX9Q+/1ma+fA30Z/d30bSXDXPi14eHVUe2V+MOnPf" +
       "z9+xt9O+Hh6851tPfuGxd58uNU/uAZ/P1gVs77j91Z+uFyblZZ38V9/8Sy/8" +
       "y89+pTyg//8VV4ja+ysAAA==");
}
