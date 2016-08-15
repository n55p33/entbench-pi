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
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "AA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "n9+mPvX+Z5+T2U+X9g6qPlNwgT74JLPDk11p33znayOTf/fYlSK+/P5/eWj0" +
           "dv3dP0Fd9dFTRJ5G+bvM81/tvEn69T3o7FFh4pYvMicXXT9ZjrgcKFEcOKMT" +
           "RYmHj8R6JRPX68Fz80CsN29f27ytCZzJTWCr+JepqIUvMxdnjRNBZ4N4Kyf+" +
           "mHVMwM01cQ15ZzbuK11aTxS0Iuju46X1w5LHtf9NUR6o/sFbvvFtv0tJn3vu" +
           "ysXXPSf8dV6JPvp2dKkHXVRjyzpeCzrWv+AFimrkTF/aVoa8/PU+oNFXICiC" +
           "Lh31cybeu136gQi6/7ZLgdyy13HYpyPo6mnYCDqfv4/DfSiCLu/ggFdsO8dB" +
           "fhWoC4Bk3We829SRttJOz5z0yCMd3vdKOjzmxE+e8L780+yhp8Tbj7M3pM8/" +
           "R/Xf82Ll09v6umSJm02G5WIPumtb6j/ytsfviO0Q1wXyqZfu+cKlNx6GhXu2" +
           "BO984Bhtj96+qg0SyiivQ2/+8HW//9bffu5beVnrfwAz89IlMx8AAA==");
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
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "sYP6TjAD3bTh+bCueJYsxTrLQHVolndfZrdJqG3DEq7ba4MJ+8EUlY9qctrN" +
           "44dvV26zzzNsIa7nKWoMHiud0THy3xxKIU9bi75xie8y0rPTDVULpx98i6do" +
           "4dtJLSRbxlIUb+P2PFfqBsnI3CG1oo0LoHkMEuA2ClHALeeZG3FMsE5R1DIj" +
           "K/iU/XhpT4JDgrQUVfBfL90TFNW4dFDC4sFLchpCCSTscVp3nNrIZ0g29kSF" +
           "t/MhP3wU4ttyu/h6EGelr1j5p0mnsCzxcRLO9dM7+h66eddT4qAmKXhigkmZ" +
           "C+AvzoyF4lxRUpojq3L7mlv1z1WvcjCsSSjslsxiT17HAc50Nj+3BU4xZqRw" +
           "mHn7zJaXfnqk8jK0uj0oBMk+b0/xgJjXLUDFPYniJgdAxo9XnWueGL9nfebP" +
           "v+IjuI2jS0rTD0lXz+69crz1DBzD5vagCoBnkueT633j6i4ijRpJVCebXXlQ" +
           "EaTIWPF10HqW05h9tOR+sd1ZV1hlx3yKOoqHh+KPI3BcGSPGNs1S03YPnuuu" +
           "+L6ZOvhm6XqAwV3xDFgZASJiliobSvTqujNbocs6h4Hh4CTBFzn3t/kjuz3/" +
           "H9EYaJO2GAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "2yIAAA==");
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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "xbu7/wuedNeCNi0AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALV7edDj5nkfdyWtbmkl2ZKrWNbqcm3B/kCA4GVFlgkSJAES" +
       "IEiQAAnHWYO4iBvERRCumsRJa0/TOE4ru+6MrX/qNG2q2Jm0cdPxKFGnbZyM" +
       "M5k6k2najhu7x0zjup6x/8gxdZr0Bcjv3P12vbHLGbzE8bzv+3vuB8CL175V" +
       "uiMMSpDv2Vvd9qIDNY0OTLt6EG19NTyghlVWCkJVadtSGE7Buavy07/84J98" +
       "9+OryxdLl8TSI5LrepEUGZ4bTtTQsxNVGZYePD5L2KoTRqXLQ1NKJDiODBse" +
       "GmH0wrB074muUenZ4SEEGECAAQS4gAC3jqlAp/tVN3baeQ/JjcJ16W+WLgxL" +
       "l3w5hxeVnjo9iC8FkrMfhi04ACPclR/zgKmicxqUrhzxvuP5GoY/AcGv/IMf" +
       "vfwrt5UeFEsPGi6Xw5EBiAhMIpbuc1RnqQZhS1FURSw95KqqwqmBIdlGVuAW" +
       "Sw+Hhu5KURyoR0LKT8a+GhRzHkvuPjnnLYjlyAuO2NMM1VYOj+7QbEkHvD56" +
       "zOuOw25+HjB4jwGABZokq4ddbrcMV4lKT57tccTjswNAALre6ajRyjua6nZX" +
       "AidKD+90Z0uuDnNRYLg6IL3Di8EsUenxcwfNZe1LsiXp6tWo9JazdOzuEqC6" +
       "uxBE3iUqvfksWTES0NLjZ7R0Qj/fYn74Yx9y++7FArOiynaO/y7Q6W1nOk1U" +
       "TQ1UV1Z3He97fvhJ6dHXP3qxVALEbz5DvKP5l3/jO+9719ve+K0dzQ9dh2a0" +
       "NFU5uip/dvnAV97afmfzthzGXb4XGrnyT3FemD+7v/JC6gPPe/RoxPziweHF" +
       "Nya/ufjxX1S/ebF0D1m6JHt27AA7ekj2HN+w1aCnumogRapClu5WXaVdXCdL" +
       "d4L9oeGqu7MjTQvViCzdbhenLnnFMRCRBobIRXQn2DdczTvc96VoVeynfqlU" +
       "uhNspfvA9mJp9yv+o5IArzxHhSVZcg3Xg9nAy/kPYdWNlkC2K3gJrN6CQy8O" +
       "gAnCXqDDErCDlbq/IPl+CIe2oajhytvAtGS4B7mB+f//hk5zri5vLlwAAn/r" +
       "WXe3gaf0PVtRg6vyKzFOfOdzV7988cj89/IAAQrMdrCb7aCY7SCf7eBotoN8" +
       "ttKFC8Ukb8pn3WkU6MMCng1i3n3v5D5AffCjT98GTMnf3A6EmZPC54fe9nEs" +
       "IIuIJwODLL3xqc1P8D9Wvli6eDqG5kjBqXvy7mwe+Y4i3LNnfed64z74kT/6" +
       "k89/8mXv2ItOBeW9c1/bM3fOp8/KNPBkVQHh7nj4569Iv3r19ZefvVi6HXg8" +
       "iHIREFceQN52do5TTvrCYcDLebkDMKx5gSPZ+aXDKHVPtAq8zfGZQtkPFPsP" +
       "ARnfm1vtg2Cj92Zc/OdXH/Hz9k0748iVdoaLIqC+yPmf+Y+/+41KIe7D2Pvg" +
       "iWzGqdELJ/w9H+zBwrMfOraBaaCqgO6/fIr9+5/41kfeXxgAoHjmehM+m7dt" +
       "4OdAhUDMf+u31v/pa3/42d+/eGw0EUh48dI25PSIyfx86Z4bMAlme/sxHhAv" +
       "bOBYudU8O3MdTzE0Q1raam6lf/7gc8iv/u+PXd7ZgQ3OHJrRu24+wPH5v4aX" +
       "fvzLP/qnbyuGuSDn+epYZsdkuyD4yPHIrSCQtjmO9Cd+74l/+CXpMyCcghAW" +
       "GplaRKWLhQwugk7Pne84xSC7+P3qP37md3/s1Wf+K8Ahlu4yQpD5W4F+nYRy" +
       "os+3X/vaN3/v/ic+V9jq7UspLKLAPWcz8bWJ9lT+LOzqPn+npDdHpfsKJg3v" +
       "oAvCb3HyINfmUSB45/n8dPNpj33pLf9nZC8//N/+rJDtNSHgOnnvTH8Rfu3T" +
       "j7ff+82i/7Ev5r3fll4bIYHIjvuiv+j88cWnL/27i6U7xdJleV+J8ZId5xYu" +
       "AqGEh+UZqNZOXT9dSezS5gtHseatZ+PAiWnPRoHjyAz2c+pCPzvH99MLpcLm" +
       "XyionyraZ/Pmr+9MJ999RwQGNFzJ3rvQX4LfBbD9Rb7lrpOf2KW7h9v7nHvl" +
       "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" +
       "QcZ4e6ynbBQu1bkYmvwCx2ZqtK2YjSnj");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("SGXCrMYE5NbSdLBdl3uS34J7lB1wM3QcZEZvqk8xy8FrbL/VnWsLCp0055wK" +
       "tSmarUvldX/ZrNTVxFgz06q0Dg3OCurWOlizcy2r4PKSipFp3NGDdFDLaGYR" +
       "mcSmmWpydTucZCbG9Vf6fM1by151Nu5SSYdt10OmwixAbT8jYFhra5NIQDlM" +
       "HuJ9wpxoVoxtZi3dVOtmW3a6nT5RDhY9j9oQ3RolYr1NFvGLgT8Rm2YikTEz" +
       "8rkKyznd3sQZ6m55UeOmmbhQVW1TieZBEvS2syQhEGi0HazL4jgezUDmo1TS" +
       "7JpVb8Ev4gZWd8yu0Fgk0nyRYiqrMBQ9FdoLBtTTLhtZxrSVtsplG3OgbLsO" +
       "V8l03hXgMIYH/hzCQm3lcFjF4yynTcXTet3uKDY16C2ECcywACdVdRsqMFl0" +
       "LjPDan3ebDhLmNj2RQoF9w7derWrVeawNqjrbt1fceMGuHlu+yLP0ALrVmVG" +
       "QmMPOBtqlYOuZFm4MW0PyLUlUlnVLA9J2xw15WGwwAbNURNiyhMSnotirSLO" +
       "0Zhfa96YEZOyTy/mTpWfzOI62qYrmBkPuFXc7cj9KOSF4ZDd4OG0RqCbtl/3" +
       "YrSHTVLKgmWmHk162JBsKLgKp8u4Dm9iVWHUNmOUW63Wiy/mj/O+cWuPFB8q" +
       "np4eLavdP0n86i08SUxPrAY4esRc/C6VzizFPPGI+cQ76VL+1vyJ81bLFis+" +
       "PvvhV15VRj+PXNw/K+9Fpbsjz3+3rSaqfWKoS8U+e/qVTAVsn9vD+NzZJ93H" +
       "jF7/Mfc7doI6s67gwjHBzxUEf36DhQd/kTd/GpXuD9WbPddPPEM5lvqf3ez5" +
       "7cmZrsd5/l78N/ac/8YPhvMTjF249wbX8vU8Fy5FpXsjT9dtlc3fEeSnSkfs" +
       "Xbjz+2XvKYD07bu+u/8fmGIP3x08dPSGtxdI/sqQw4K5x27A+A/lzcNR6Q5f" +
       "2i01OsnyI98Hy/kb2NJ7Abh371l+9y2wfPHY/a/L98Vjqq+eWoN1eonMBFTL" +
       "uWNelf/V+Otf+Uz2+dd2S6zyFYdRCTrvi4hrP8rI1+DeYDnkibXyf9x7zxvf" +
       "+O/8Bw5d/94jgSA5/9UbCeRQjQ+cXJJTLA+9ABXKeu4GijzImytR6b785WC+" +
       "AvKw6wl9PvX96vN5AJvZw2d+gPo8acfloynflM+Qryy4sA8KxX9UunrtisH3" +
       "XFnHUmisYy9S37FbvHtl99r8SrEM8cruXdr7P3CFHnWIq0yLJrgrL15x1c3+" +
       "yockZ/ny+w8ODj7wwjv93bqxr14XXv4S6sJ79q8cL7x4M373mStvWnmTvxi/" +
       "0Lx2NV9+OMgb+trleYUidtMWvfPj6Q1MoXODa928KeL4YofkBrT9dPffuAEN" +
       "lTcVkAscED/OmBv2/Zrb04D7L+xV/4UfoLmdZOBGguTzZgSSd/79wSzcLZM5" +
       "ySF7KxymQEr5Nwz5guy3XPNN1O47Hvlzrz5412Ovzv5gtzT68Fubu4elu7TY" +
       "tk8uyz2xf8kPVM0oWL37cJFuDu8DUenJm3xVkTN3uJ8jvvAju64fjEpvvm5X" +
       "wET+d5JWjkqXz9KCjFL8n6TTotI9x3RR6dJu5ySJEZVuAyT5rukfxsNHi09M" +
       "DsIN8NMDKnd+z1XdKL1wuio71Erp4Ztp5UQh98ypqF580Ha4SDVm98nj869S" +
       "zIe+U/v53ScKsi1lWT7KXcPSnbuvJYpB84WuT5072uFYl/rv/O4Dv3z3c4f5" +
       "4YEd4GNjPoHtyet/D0A4flSs4M9+7bF/8cO/8OofFu/p/x+OAdZFaTgAAA==");
}
