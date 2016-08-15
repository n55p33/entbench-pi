package org.apache.batik.apps.slideshow;
public class Main extends javax.swing.JComponent {
    org.apache.batik.gvt.renderer.StaticRenderer renderer;
    org.apache.batik.bridge.UserAgent userAgent;
    org.apache.batik.bridge.DocumentLoader loader;
    org.apache.batik.bridge.BridgeContext ctx;
    java.awt.image.BufferedImage image;
    java.awt.image.BufferedImage display;
    java.io.File[] files;
    static int duration = 3000;
    static int frameDelay = duration + 7000;
    volatile boolean done = false;
    public Main(java.io.File[] files, java.awt.Dimension size) { super();
                                                                 setBackground(
                                                                   java.awt.Color.
                                                                     black);
                                                                 this.
                                                                   files =
                                                                   files;
                                                                 org.apache.batik.bridge.UserAgentAdapter ua =
                                                                   new org.apache.batik.bridge.UserAgentAdapter(
                                                                   );
                                                                 renderer =
                                                                   new org.apache.batik.gvt.renderer.StaticRenderer(
                                                                     );
                                                                 userAgent =
                                                                   ua;
                                                                 loader =
                                                                   new org.apache.batik.bridge.DocumentLoader(
                                                                     userAgent);
                                                                 ctx =
                                                                   new org.apache.batik.bridge.BridgeContext(
                                                                     userAgent,
                                                                     loader);
                                                                 ua.
                                                                   setBridgeContext(
                                                                     ctx);
                                                                 if (size ==
                                                                       null) {
                                                                     size =
                                                                       java.awt.Toolkit.
                                                                         getDefaultToolkit(
                                                                           ).
                                                                         getScreenSize(
                                                                           );
                                                                 }
                                                                 setPreferredSize(
                                                                   size);
                                                                 setDoubleBuffered(
                                                                   false);
                                                                 addMouseListener(
                                                                   new java.awt.event.MouseAdapter(
                                                                     ) {
                                                                       public void mouseClicked(java.awt.event.MouseEvent me) {
                                                                           if (done)
                                                                               java.lang.System.
                                                                                 exit(
                                                                                   0);
                                                                           else
                                                                               togglePause(
                                                                                 );
                                                                       }
                                                                   });
                                                                 size.
                                                                   width +=
                                                                   2;
                                                                 size.
                                                                   height +=
                                                                   2;
                                                                 display =
                                                                   new java.awt.image.BufferedImage(
                                                                     size.
                                                                       width,
                                                                     size.
                                                                       height,
                                                                     java.awt.image.BufferedImage.
                                                                       TYPE_INT_BGR);
                                                                 java.lang.Thread t =
                                                                   new org.apache.batik.apps.slideshow.Main.RenderThread(
                                                                   );
                                                                 t.
                                                                   start(
                                                                     );
                                                                 javax.swing.JWindow w =
                                                                   new javax.swing.JWindow(
                                                                   );
                                                                 w.
                                                                   setBackground(
                                                                     java.awt.Color.
                                                                       black);
                                                                 w.
                                                                   getContentPane(
                                                                     ).
                                                                   setBackground(
                                                                     java.awt.Color.
                                                                       black);
                                                                 w.
                                                                   getContentPane(
                                                                     ).
                                                                   add(
                                                                     this);
                                                                 w.
                                                                   pack(
                                                                     );
                                                                 w.
                                                                   setLocation(
                                                                     new java.awt.Point(
                                                                       -1,
                                                                       -1));
                                                                 w.
                                                                   setVisible(
                                                                     true);
    }
    class RenderThread extends java.lang.Thread {
        RenderThread() { super("RenderThread");
                         setDaemon(true);
        }
        public void run() { renderer.setDoubleBuffered(
                                       true);
                            for (int i = 0;
                                 i <
                                   files.
                                     length;
                                 i++) { org.apache.batik.gvt.GraphicsNode gvtRoot =
                                          null;
                                        org.apache.batik.bridge.GVTBuilder builder =
                                          new org.apache.batik.bridge.GVTBuilder(
                                          );
                                        try {
                                            java.lang.String fileName =
                                              files[i].
                                              toURL(
                                                ).
                                              toString(
                                                );
                                            java.lang.System.
                                              out.
                                              println(
                                                "Reading: " +
                                                fileName);
                                            org.w3c.dom.Document svgDoc =
                                              loader.
                                              loadDocument(
                                                fileName);
                                            java.lang.System.
                                              out.
                                              println(
                                                "Building: " +
                                                fileName);
                                            gvtRoot =
                                              builder.
                                                build(
                                                  ctx,
                                                  svgDoc);
                                            java.lang.System.
                                              out.
                                              println(
                                                "Rendering: " +
                                                fileName);
                                            renderer.
                                              setTree(
                                                gvtRoot);
                                            org.w3c.dom.Element elt =
                                              ((org.w3c.dom.svg.SVGDocument)
                                                 svgDoc).
                                              getRootElement(
                                                );
                                            renderer.
                                              setTransform(
                                                org.apache.batik.bridge.ViewBox.
                                                  getViewTransform(
                                                    null,
                                                    elt,
                                                    display.
                                                      getWidth(
                                                        ),
                                                    display.
                                                      getHeight(
                                                        ),
                                                    ctx));
                                            renderer.
                                              updateOffScreen(
                                                display.
                                                  getWidth(
                                                    ),
                                                display.
                                                  getHeight(
                                                    ));
                                            java.awt.Rectangle r =
                                              new java.awt.Rectangle(
                                              0,
                                              0,
                                              display.
                                                getWidth(
                                                  ),
                                              display.
                                                getHeight(
                                                  ));
                                            renderer.
                                              repaint(
                                                r);
                                            java.lang.System.
                                              out.
                                              println(
                                                "Painting: " +
                                                fileName);
                                            image =
                                              renderer.
                                                getOffScreen(
                                                  );
                                            setTransition(
                                              image);
                                        }
                                        catch (java.lang.Exception ex) {
                                            ex.
                                              printStackTrace(
                                                );
                                        }
                            }
                            if (transitionThread !=
                                  null) {
                                try {
                                    transitionThread.
                                      join(
                                        );
                                }
                                catch (java.lang.InterruptedException ie) {
                                    
                                }
                                done =
                                  true;
                                setCursor(
                                  new java.awt.Cursor(
                                    java.awt.Cursor.
                                      WAIT_CURSOR));
                            } }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "AA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    volatile java.lang.Thread transitionThread =
      null;
    public void setTransition(java.awt.image.BufferedImage newImg) {
        synchronized (this)  {
            while (transitionThread !=
                     null) {
                try {
                    wait(
                      );
                }
                catch (java.lang.InterruptedException ie) {
                    
                }
            }
            transitionThread =
              new org.apache.batik.apps.slideshow.Main.TransitionThread(
                newImg);
            transitionThread.
              start(
                );
        }
    }
    long startLastTransition = 0;
    volatile boolean paused = false;
    public void togglePause() { synchronized (this)  {
                                    paused =
                                      !paused;
                                    java.awt.Cursor c;
                                    if (paused) {
                                        c =
                                          new java.awt.Cursor(
                                            java.awt.Cursor.
                                              WAIT_CURSOR);
                                    }
                                    else {
                                        c =
                                          new java.awt.Cursor(
                                            java.awt.Cursor.
                                              DEFAULT_CURSOR);
                                        if (transitionThread !=
                                              null) {
                                            synchronized (transitionThread)  {
                                                transitionThread.
                                                  notifyAll(
                                                    );
                                            }
                                        }
                                    }
                                    setCursor(
                                      c);
                                } }
    class TransitionThread extends java.lang.Thread {
        java.awt.image.BufferedImage src;
        int blockw = 75;
        int blockh = 75;
        public TransitionThread(java.awt.image.BufferedImage bi) {
            super(
              "TransitionThread");
            setDaemon(
              true);
            src =
              bi;
        }
        public void run() { int xblocks =
                              (display.
                                 getWidth(
                                   ) +
                                 blockw -
                                 1) /
                              blockw;
                            int yblocks =
                              (display.
                                 getHeight(
                                   ) +
                                 blockh -
                                 1) /
                              blockh;
                            int nblocks =
                              xblocks *
                              yblocks;
                            int tblock = duration /
                              nblocks;
                            java.awt.Point[] rects =
                              new java.awt.Point[nblocks];
                            for (int y = 0;
                                 y <
                                   yblocks;
                                 y++) for (int x =
                                             0;
                                           x <
                                             xblocks;
                                           x++)
                                          rects[y *
                                                  xblocks +
                                                  x] =
                                            new java.awt.Point(
                                              x,
                                              y);
                            java.awt.Graphics2D g2d =
                              display.
                              createGraphics(
                                );
                            g2d.setColor(
                                  java.awt.Color.
                                    black);
                            long currTrans =
                              java.lang.System.
                              currentTimeMillis(
                                );
                            while (currTrans -
                                     startLastTransition <
                                     frameDelay) {
                                try {
                                    long stime =
                                      frameDelay -
                                      (currTrans -
                                         startLastTransition);
                                    if (stime >
                                          500) {
                                        java.lang.System.
                                          gc(
                                            );
                                        currTrans =
                                          java.lang.System.
                                            currentTimeMillis(
                                              );
                                        stime =
                                          frameDelay -
                                            (currTrans -
                                               startLastTransition);
                                    }
                                    if (stime >
                                          0)
                                        sleep(
                                          stime);
                                }
                                catch (java.lang.InterruptedException ie) {
                                    
                                }
                                currTrans =
                                  java.lang.System.
                                    currentTimeMillis(
                                      );
                            }
                            synchronized (this)  {
                                while (paused) {
                                    try {
                                        wait(
                                          );
                                    }
                                    catch (java.lang.InterruptedException ie) {
                                        
                                    }
                                }
                            }
                            long last = startLastTransition =
                              java.lang.System.
                                currentTimeMillis(
                                  );
                            for (int i = 0;
                                 i <
                                   rects.
                                     length;
                                 i++) { int idx =
                                          (int)
                                            (java.lang.Math.
                                               random(
                                                 ) *
                                               (rects.
                                                  length -
                                                  i));
                                        java.awt.Point pt =
                                          rects[idx];
                                        java.lang.System.
                                          arraycopy(
                                            rects,
                                            idx +
                                              1,
                                            rects,
                                            idx +
                                              1 -
                                              1,
                                            rects.
                                              length -
                                              i -
                                              idx -
                                              1);
                                        int x =
                                          pt.
                                            x *
                                          blockw;
                                        int y =
                                          pt.
                                            y *
                                          blockh;
                                        int w =
                                          blockw;
                                        int h =
                                          blockh;
                                        if (x +
                                              w >
                                              src.
                                              getWidth(
                                                ))
                                            w =
                                              src.
                                                getWidth(
                                                  ) -
                                                x;
                                        if (y +
                                              h >
                                              src.
                                              getHeight(
                                                ))
                                            h =
                                              src.
                                                getHeight(
                                                  ) -
                                                y;
                                        synchronized (display)  {
                                            g2d.
                                              fillRect(
                                                x,
                                                y,
                                                w,
                                                h);
                                            java.awt.image.BufferedImage sub;
                                            sub =
                                              src.
                                                getSubimage(
                                                  x,
                                                  y,
                                                  w,
                                                  h);
                                            g2d.
                                              drawImage(
                                                sub,
                                                null,
                                                x,
                                                y);
                                        }
                                        repaint(
                                          x,
                                          y,
                                          w,
                                          h);
                                        long current =
                                          java.lang.System.
                                          currentTimeMillis(
                                            );
                                        try {
                                            long dt =
                                              current -
                                              last;
                                            if (dt <
                                                  tblock)
                                                sleep(
                                                  tblock -
                                                    dt);
                                        }
                                        catch (java.lang.InterruptedException ie) {
                                            
                                        }
                                        last =
                                          current;
                            }
                            synchronized (Main.this)  {
                                transitionThread =
                                  null;
                                Main.this.
                                  notifyAll(
                                    );
                            } }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "fwBlKD0FthgAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "df8DOWvEP98iAAA=");
    }
    public void paint(java.awt.Graphics g) {
        java.awt.Graphics2D g2d =
          (java.awt.Graphics2D)
            g;
        if (display ==
              null)
            return;
        g2d.
          drawImage(
            display,
            null,
            0,
            0);
    }
    public static void readFileList(java.lang.String file,
                                    java.util.List fileVec) {
        java.io.BufferedReader br;
        try {
            br =
              new java.io.BufferedReader(
                new java.io.FileReader(
                  file));
        }
        catch (java.io.FileNotFoundException fnfe) {
            java.lang.System.
              err.
              println(
                "Unable to open file-list: " +
                file);
            return;
        }
        try {
            java.net.URL flURL =
              new java.io.File(
              file).
              toURL(
                );
            java.lang.String line;
            while ((line =
                      br.
                        readLine(
                          )) !=
                     null) {
                java.lang.String str =
                  line;
                int idx =
                  str.
                  indexOf(
                    '#');
                if (idx !=
                      -1)
                    str =
                      str.
                        substring(
                          0,
                          idx);
                str =
                  str.
                    trim(
                      );
                if (str.
                      length(
                        ) ==
                      0)
                    continue;
                try {
                    java.net.URL imgURL =
                      new java.net.URL(
                      flURL,
                      str);
                    fileVec.
                      add(
                        imgURL.
                          getFile(
                            ));
                }
                catch (java.net.MalformedURLException mue) {
                    java.lang.System.
                      err.
                      println(
                        "Can\'t make sense of line:\n  " +
                        line);
                }
            }
        }
        catch (java.io.IOException ioe) {
            java.lang.System.
              err.
              println(
                "Error while reading file-list: " +
                file);
        }
        finally {
            try {
                br.
                  close(
                    );
            }
            catch (java.io.IOException ioe) {
                
            }
        }
    }
    public static void main(java.lang.String[] args) {
        java.util.List fileVec =
          new java.util.ArrayList(
          );
        java.awt.Dimension d =
          null;
        if (args.
              length ==
              0) {
            showUsage(
              );
            return;
        }
        for (int i =
               0;
             i <
               args.
                 length;
             i++) {
            if (args[i].
                  equals(
                    "-h") ||
                  args[i].
                  equals(
                    "-help") ||
                  args[i].
                  equals(
                    "--help")) {
                showUsage(
                  );
                return;
            }
            else
                if (args[i].
                      equals(
                        "--")) {
                    i++;
                    while (i <
                             args.
                               length) {
                        fileVec.
                          add(
                            args[i++]);
                    }
                    break;
                }
                else
                    if (args[i].
                          equals(
                            "-fl") ||
                          args[i].
                          equals(
                            "--file-list")) {
                        if (i +
                              1 ==
                              args.
                                length) {
                            java.lang.System.
                              err.
                              println(
                                "Must provide name of file list file after " +
                                args[i]);
                            break;
                        }
                        readFileList(
                          args[i +
                                 1],
                          fileVec);
                        i++;
                    }
                    else
                        if (args[i].
                              equals(
                                "-ft") ||
                              args[i].
                              equals(
                                "--frame-time")) {
                            if (i +
                                  1 ==
                                  args.
                                    length) {
                                java.lang.System.
                                  err.
                                  println(
                                    "Must provide time in millis after " +
                                    args[i]);
                                break;
                            }
                            try {
                                frameDelay =
                                  java.lang.Integer.
                                    decode(
                                      args[i +
                                             1]).
                                    intValue(
                                      );
                                i++;
                            }
                            catch (java.lang.NumberFormatException nfe) {
                                java.lang.System.
                                  err.
                                  println(
                                    "Can\'t parse frame time: " +
                                    args[i +
                                           1]);
                            }
                        }
                        else
                            if (args[i].
                                  equals(
                                    "-tt") ||
                                  args[i].
                                  equals(
                                    "--transition-time")) {
                                if (i +
                                      1 ==
                                      args.
                                        length) {
                                    java.lang.System.
                                      err.
                                      println(
                                        "Must provide time in millis after " +
                                        args[i]);
                                    break;
                                }
                                try {
                                    duration =
                                      java.lang.Integer.
                                        decode(
                                          args[i +
                                                 1]).
                                        intValue(
                                          );
                                    i++;
                                }
                                catch (java.lang.NumberFormatException nfe) {
                                    java.lang.System.
                                      err.
                                      println(
                                        "Can\'t parse transition time: " +
                                        args[i +
                                               1]);
                                }
                            }
                            else
                                if (args[i].
                                      equals(
                                        "-ws") ||
                                      args[i].
                                      equals(
                                        "--window-size")) {
                                    if (i +
                                          1 ==
                                          args.
                                            length) {
                                        java.lang.System.
                                          err.
                                          println(
                                            "Must provide window size [w,h] after " +
                                            args[i]);
                                        break;
                                    }
                                    try {
                                        int idx =
                                          args[i +
                                                 1].
                                          indexOf(
                                            ',');
                                        int w;
                                        int h;
                                        if (idx ==
                                              -1)
                                            w =
                                              (h =
                                                 java.lang.Integer.
                                                   decode(
                                                     args[i +
                                                            1]).
                                                   intValue(
                                                     ));
                                        else {
                                            java.lang.String wStr =
                                              args[i +
                                                     1].
                                              substring(
                                                0,
                                                idx);
                                            java.lang.String hStr =
                                              args[i +
                                                     1].
                                              substring(
                                                idx +
                                                  1);
                                            w =
                                              java.lang.Integer.
                                                decode(
                                                  wStr).
                                                intValue(
                                                  );
                                            h =
                                              java.lang.Integer.
                                                decode(
                                                  hStr).
                                                intValue(
                                                  );
                                        }
                                        d =
                                          new java.awt.Dimension(
                                            w,
                                            h);
                                        i++;
                                    }
                                    catch (java.lang.NumberFormatException nfe) {
                                        java.lang.System.
                                          err.
                                          println(
                                            "Can\'t parse window size: " +
                                            args[i +
                                                   1]);
                                    }
                                }
                                else
                                    fileVec.
                                      add(
                                        args[i]);
        }
        java.io.File[] files =
          new java.io.File[fileVec.
                             size(
                               )];
        for (int i =
               0;
             i <
               fileVec.
               size(
                 );
             i++) {
            try {
                files[i] =
                  new java.io.File(
                    (java.lang.String)
                      fileVec.
                      get(
                        i));
            }
            catch (java.lang.Exception ex) {
                ex.
                  printStackTrace(
                    );
            }
        }
        new org.apache.batik.apps.slideshow.Main(
          files,
          d);
    }
    public static void showUsage() { java.lang.System.
                                       out.
                                       println(
                                         "Options:\n" +
                                         ("                                 -- : Remaining args are fil" +
                                          "e names\n") +
                                         "                         -fl <file>\n" +
                                         ("                 --file-list <file> : file contains list of " +
                                          "images to\n") +
                                         "                                      show one per line\n" +
                                         "             -ws <width>[,<height>]\n" +
                                         ("    -window-size <width>[,<height>] : Set the size of slides" +
                                          "how window\n") +
                                         ("                                      defaults to full scree" +
                                          "n\n") +
                                         "                          -ft <int>\n" +
                                         ("                 --frame-time <int> : Amount of time in mill" +
                                          "isecs to\n") +
                                         "                                      show each frame.\n" +
                                         ("                                      Includes transition ti" +
                                          "me.\n") +
                                         "                          -tt <int>\n" +
                                         ("            --transition-time <int> : Amount of time in mill" +
                                          "isecs to\n") +
                                         ("                                      transition between fra" +
                                          "mes.\n") +
                                         "                             <file> : SVG file to display");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "u7v/C4QtNkQ2LQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "QLWb80DCmtSEgcWZPXEyXuwlABakNnii");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("Ks4FfDRHlgaeRsFwiM1gfTlpRLTu6Awx0DqStJI76khcygo1pCeO5sQBIy03" +
       "i02vOWa82iYyfMMbTje+EChSpk5UEQdhsYkbrVGvhbrDVVK1edojN2Gn63nV" +
       "FoluKyTeq9MoUSNTd6uB2+UaVdcip7Hyeyy8ARY0bqGUHINKg+nGmx6qrprT" +
       "6XTSrcXlAaYPfJDzhguCYNA24rZ78KwahDzjSmla72CL/jJMxaW16EV0hmkT" +
       "aDQiSThcj8dQW6oFI6Ohzp1h0Jio6NrwO8MtTTSYgTG3YINeTGxd54xWZsYC" +
       "zYlJu2rJHAqXFVhgVot1f9vcOk484EnMRo2uFwy7o46Dc7xZjmNqBPEKFDEb" +
       "WWcglLaSwdQiQ3omWfU6ZWcUM6fT0Kit1NRPOXbS7Mw64zCGBVD0b+opv2mz" +
       "hLx2+FYLXm7WHCTL5bYft5ehgzfQdGQSlGXNK8mqrFrbxPOb6/ZqILAMSOi2" +
       "RjCr2Qyfm6OxSgXT0FjQreo2jkwtqLTqcH2GmahsOYFsqUJj4ZUNpGpDi3Wi" +
       "K6LF4UwLuGqmGmPYo/rwfLRVagm3CkMI6ScTlxUREO+N1krUB5jNDrf1uIqJ" +
       "WggKBLwF4SDZQT14Go3W09pwiiD5o7xv3trjxIeKJ6dHS2r3TxG/dgtPEZMT" +
       "KwGOHi8Xv0ulM8swTzxePvE+upS/MX/ivJWyxWqPz33k1dfk8c9WL+6fk/ej" +
       "0t2R673XUjaKdWKoS8X+5PTrmDrYPr+H8fmzT7mPGb3+I+537QR1Zk3BhWOC" +
       "nykI/vQGiw7+LG/+OCrdHyo3e6a/cQ35WOp/crNntydnuh7n+TvxX9tz/ms/" +
       "HM5PMHbh3htcy9fyXLgUle6NXE2zlEn+fiA/VTpi78KdPyh7TwGk79z13f3/" +
       "0BR7+N7goaO3u/1A8HRDCgvmHrsB4z+SNw9HpTs8YbfM6CTLj/wALOdvX0sf" +
       "AODeu2f5vbfA8sVj978u3xePqb52av3V6eUxM2FbOOZV6V9Nv/HVz2ZfeH23" +
       "vCpfbRiVyud9DXHtBxn5+tsbLIU8sU7+D/vve/Ob/4176dD17z0SSDXnv3Ej" +
       "gRyq8YGTy3GKpaEXyoWynruBIg/y5kpUui9/MZivfjzsekKfT/2g+nwewB7t" +
       "4Y9+iPo8aceVoynfks+Qryq4sA8KxX9UunrtasH3XfFjITT82I2Ud+0W7l7Z" +
       "vTK/UixBvLJ7j/bBl67QYxS7OkJojLny/iuOst1f+ZBgi6988ODg4KUX3u3t" +
       "1ox97brw8hdQF963f9144f0343efufKmyHf5S/ELnWtX8uWHVN7Q1y7NKxSx" +
       "m7bonR+zNzAF9AbX8Lwp4vhqh+QGtINk99++AQ2ZN3WQC2wQP86YG/yDmtvT" +
       "gPsv7lX/xR+iuZ1k4EaC5PJmDJJ3/u3BPNwtkTnJ4eRWOEyAlPLvF/LF2G+7" +
       "5nuo3Tc80udfe/Cux16b/95uWfThdzZ3D0t3qbFlnVySe2L/khcoqlGwevfh" +
       "At0c3ktR6cmbfFGRM3e4nyO+8OO7ri9HpbdetytgIv87SStFpctnaUFGKf5P" +
       "0qlR6Z5juqh0abdzksSISrcBknzX9A7j4aPF5yUH4Rb46QGZO7/rKE6UXDhd" +
       "lR1qpfTwzbRyopB75lRULz5mO1ygGk/2yeMLr5GjD323+bO7zxMkS8iyfJS7" +
       "hqU7d19KFIPmi1yfOne0w7EuDd79vQd+8e7nDvPDAzvAx8Z8AtuT1/8WALO9" +
       "qFi9n/3KY//iR3/utd8v3tH/P7n0vk5lOAAA");
}
