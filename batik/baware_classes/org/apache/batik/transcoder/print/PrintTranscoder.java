package org.apache.batik.transcoder.print;
public class PrintTranscoder extends org.apache.batik.transcoder.SVGAbstractTranscoder implements java.awt.print.Printable, ent.runtime.ENT_Attributable {
    public int ENT_attribute() { return org.apache.batik.apps.rasterizer.EntMode.
                                          LOW_MODE; }
    public static final java.lang.String KEY_AOI_STR = "aoi";
    public static final java.lang.String KEY_HEIGHT_STR = "height";
    public static final java.lang.String KEY_LANGUAGE_STR = "language";
    public static final java.lang.String KEY_MARGIN_BOTTOM_STR = "marginBottom";
    public static final java.lang.String KEY_MARGIN_LEFT_STR = "marginLeft";
    public static final java.lang.String KEY_MARGIN_RIGHT_STR = "marginRight";
    public static final java.lang.String KEY_MARGIN_TOP_STR = "marginTop";
    public static final java.lang.String KEY_PAGE_HEIGHT_STR = "pageHeight";
    public static final java.lang.String KEY_PAGE_ORIENTATION_STR =
      "pageOrientation";
    public static final java.lang.String KEY_PAGE_WIDTH_STR = "pageWidth";
    public static final java.lang.String KEY_PIXEL_TO_MM_STR = "pixelToMm";
    public static final java.lang.String KEY_SCALE_TO_PAGE_STR = "scaleToPage";
    public static final java.lang.String KEY_SHOW_PAGE_DIALOG_STR =
      "showPageDialog";
    public static final java.lang.String KEY_SHOW_PRINTER_DIALOG_STR =
      "showPrinterDialog";
    public static final java.lang.String KEY_USER_STYLESHEET_URI_STR =
      "userStylesheet";
    public static final java.lang.String KEY_WIDTH_STR = "width";
    public static final java.lang.String KEY_XML_PARSER_CLASSNAME_STR =
      "xmlParserClassName";
    public static final java.lang.String VALUE_MEDIA_PRINT = "print";
    public static final java.lang.String VALUE_PAGE_ORIENTATION_LANDSCAPE =
      "landscape";
    public static final java.lang.String VALUE_PAGE_ORIENTATION_PORTRAIT =
      "portrait";
    public static final java.lang.String VALUE_PAGE_ORIENTATION_REVERSE_LANDSCAPE =
      "reverseLandscape";
    private java.util.List inputs = new java.util.ArrayList(
      );
    private java.util.List printedInputs = null;
    private int curIndex = -1;
    private org.apache.batik.bridge.BridgeContext theCtx;
    public PrintTranscoder() { super();
                               hints.put(KEY_MEDIA, VALUE_MEDIA_PRINT);
    }
    public void transcode(org.apache.batik.transcoder.TranscoderInput in,
                          org.apache.batik.transcoder.TranscoderOutput out) {
        if (in !=
              null) {
            inputs.
              add(
                in);
        }
    }
    protected void transcode(org.w3c.dom.Document document,
                             java.lang.String uri,
                             org.apache.batik.transcoder.TranscoderOutput output)
          throws org.apache.batik.transcoder.TranscoderException {
        super.
          transcode(
            document,
            uri,
            output);
        theCtx =
          ctx;
        ctx =
          null;
    }
    public void print() throws java.awt.print.PrinterException {
        java.awt.print.PrinterJob printerJob =
          java.awt.print.PrinterJob.
          getPrinterJob(
            );
        java.awt.print.PageFormat pageFormat =
          printerJob.
          defaultPage(
            );
        java.awt.print.Paper paper =
          pageFormat.
          getPaper(
            );
        java.lang.Float pageWidth =
          (java.lang.Float)
            hints.
            get(
              KEY_PAGE_WIDTH);
        java.lang.Float pageHeight =
          (java.lang.Float)
            hints.
            get(
              KEY_PAGE_HEIGHT);
        if (pageWidth !=
              null) {
            paper.
              setSize(
                pageWidth.
                  floatValue(
                    ),
                paper.
                  getHeight(
                    ));
        }
        if (pageHeight !=
              null) {
            paper.
              setSize(
                paper.
                  getWidth(
                    ),
                pageHeight.
                  floatValue(
                    ));
        }
        float x =
          0;
        float y =
          0;
        float width =
          (float)
            paper.
            getWidth(
              );
        float height =
          (float)
            paper.
            getHeight(
              );
        java.lang.Float leftMargin =
          (java.lang.Float)
            hints.
            get(
              KEY_MARGIN_LEFT);
        java.lang.Float topMargin =
          (java.lang.Float)
            hints.
            get(
              KEY_MARGIN_TOP);
        java.lang.Float rightMargin =
          (java.lang.Float)
            hints.
            get(
              KEY_MARGIN_RIGHT);
        java.lang.Float bottomMargin =
          (java.lang.Float)
            hints.
            get(
              KEY_MARGIN_BOTTOM);
        if (leftMargin !=
              null) {
            x =
              leftMargin.
                floatValue(
                  );
            width -=
              leftMargin.
                floatValue(
                  );
        }
        if (topMargin !=
              null) {
            y =
              topMargin.
                floatValue(
                  );
            height -=
              topMargin.
                floatValue(
                  );
        }
        if (rightMargin !=
              null) {
            width -=
              rightMargin.
                floatValue(
                  );
        }
        if (bottomMargin !=
              null) {
            height -=
              bottomMargin.
                floatValue(
                  );
        }
        paper.
          setImageableArea(
            x,
            y,
            width,
            height);
        java.lang.String pageOrientation =
          (java.lang.String)
            hints.
            get(
              KEY_PAGE_ORIENTATION);
        if (VALUE_PAGE_ORIENTATION_PORTRAIT.
              equalsIgnoreCase(
                pageOrientation)) {
            pageFormat.
              setOrientation(
                java.awt.print.PageFormat.
                  PORTRAIT);
        }
        else
            if (VALUE_PAGE_ORIENTATION_LANDSCAPE.
                  equalsIgnoreCase(
                    pageOrientation)) {
                pageFormat.
                  setOrientation(
                    java.awt.print.PageFormat.
                      LANDSCAPE);
            }
            else
                if (VALUE_PAGE_ORIENTATION_REVERSE_LANDSCAPE.
                      equalsIgnoreCase(
                        pageOrientation)) {
                    pageFormat.
                      setOrientation(
                        java.awt.print.PageFormat.
                          REVERSE_LANDSCAPE);
                }
        pageFormat.
          setPaper(
            paper);
        pageFormat =
          printerJob.
            validatePage(
              pageFormat);
        java.lang.Boolean showPageFormat =
          (java.lang.Boolean)
            hints.
            get(
              KEY_SHOW_PAGE_DIALOG);
        if (showPageFormat !=
              null &&
              showPageFormat.
              booleanValue(
                )) {
            java.awt.print.PageFormat tmpPageFormat =
              printerJob.
              pageDialog(
                pageFormat);
            if (tmpPageFormat ==
                  pageFormat) {
                return;
            }
            pageFormat =
              tmpPageFormat;
        }
        printerJob.
          setPrintable(
            this,
            pageFormat);
        java.lang.Boolean showPrinterDialog;
        showPrinterDialog =
          (java.lang.Boolean)
            hints.
            get(
              KEY_SHOW_PRINTER_DIALOG);
        if (showPrinterDialog !=
              null &&
              showPrinterDialog.
              booleanValue(
                )) {
            if (!printerJob.
                  printDialog(
                    )) {
                return;
            }
        }
        printerJob.
          print(
            );
    }
    public int print(java.awt.Graphics _g, java.awt.print.PageFormat pageFormat,
                     int pageIndex) { if (printedInputs ==
                                            null) {
                                          printedInputs =
                                            new java.util.ArrayList(
                                              inputs);
                                      }
                                      if (pageIndex >=
                                            printedInputs.
                                            size(
                                              )) {
                                          curIndex =
                                            -1;
                                          if (theCtx !=
                                                null)
                                              theCtx.
                                                dispose(
                                                  );
                                          userAgent.
                                            displayMessage(
                                              "Done");
                                          return NO_SUCH_PAGE;
                                      }
                                      if (curIndex !=
                                            pageIndex) {
                                          if (theCtx !=
                                                null)
                                              theCtx.
                                                dispose(
                                                  );
                                          try {
                                              width =
                                                (int)
                                                  pageFormat.
                                                  getImageableWidth(
                                                    );
                                              height =
                                                (int)
                                                  pageFormat.
                                                  getImageableHeight(
                                                    );
                                              super.
                                                transcode(
                                                  (org.apache.batik.transcoder.TranscoderInput)
                                                    printedInputs.
                                                    get(
                                                      pageIndex),
                                                  null);
                                              curIndex =
                                                pageIndex;
                                          }
                                          catch (org.apache.batik.transcoder.TranscoderException e) {
                                              drawError(
                                                _g,
                                                e);
                                              return PAGE_EXISTS;
                                          }
                                      }
                                      java.awt.Graphics2D g =
                                        (java.awt.Graphics2D)
                                          _g;
                                      g.setRenderingHint(
                                          java.awt.RenderingHints.
                                            KEY_ANTIALIASING,
                                          java.awt.RenderingHints.
                                            VALUE_ANTIALIAS_ON);
                                      g.setRenderingHint(
                                          java.awt.RenderingHints.
                                            KEY_INTERPOLATION,
                                          java.awt.RenderingHints.
                                            VALUE_INTERPOLATION_BILINEAR);
                                      g.setRenderingHint(
                                          org.apache.batik.ext.awt.RenderingHintsKeyExt.
                                            KEY_TRANSCODING,
                                          org.apache.batik.ext.awt.RenderingHintsKeyExt.
                                            VALUE_TRANSCODING_PRINTING);
                                      java.awt.geom.AffineTransform t =
                                        g.
                                        getTransform(
                                          );
                                      java.awt.Shape clip =
                                        g.
                                        getClip(
                                          );
                                      g.translate(
                                          pageFormat.
                                            getImageableX(
                                              ),
                                          pageFormat.
                                            getImageableY(
                                              ));
                                      g.transform(
                                          curTxf);
                                      try {
                                          root.
                                            paint(
                                              g);
                                      }
                                      catch (java.lang.Exception e) {
                                          g.
                                            setTransform(
                                              t);
                                          g.
                                            setClip(
                                              clip);
                                          drawError(
                                            _g,
                                            e);
                                      }
                                      g.setTransform(
                                          t);
                                      g.setClip(
                                          clip);
                                      return PAGE_EXISTS;
    }
    protected void setImageSize(float docWidth,
                                float docHeight) {
        java.lang.Boolean scaleToPage =
          (java.lang.Boolean)
            hints.
            get(
              KEY_SCALE_TO_PAGE);
        if (scaleToPage !=
              null &&
              !scaleToPage.
              booleanValue(
                )) {
            float w =
              docWidth;
            float h =
              docHeight;
            if (hints.
                  containsKey(
                    KEY_AOI)) {
                java.awt.geom.Rectangle2D aoi =
                  (java.awt.geom.Rectangle2D)
                    hints.
                    get(
                      KEY_AOI);
                w =
                  (float)
                    aoi.
                    getWidth(
                      );
                h =
                  (float)
                    aoi.
                    getHeight(
                      );
            }
            super.
              setImageSize(
                w,
                h);
        }
    }
    private void drawError(java.awt.Graphics g,
                           java.lang.Exception e) {
        userAgent.
          displayError(
            e);
    }
    public static final org.apache.batik.transcoder.TranscodingHints.Key
      KEY_SHOW_PAGE_DIALOG =
      new org.apache.batik.transcoder.keys.BooleanKey(
      );
    public static final org.apache.batik.transcoder.TranscodingHints.Key
      KEY_SHOW_PRINTER_DIALOG =
      new org.apache.batik.transcoder.keys.BooleanKey(
      );
    public static final org.apache.batik.transcoder.TranscodingHints.Key
      KEY_PAGE_WIDTH =
      new org.apache.batik.transcoder.keys.LengthKey(
      );
    public static final org.apache.batik.transcoder.TranscodingHints.Key
      KEY_PAGE_HEIGHT =
      new org.apache.batik.transcoder.keys.LengthKey(
      );
    public static final org.apache.batik.transcoder.TranscodingHints.Key
      KEY_MARGIN_TOP =
      new org.apache.batik.transcoder.keys.LengthKey(
      );
    public static final org.apache.batik.transcoder.TranscodingHints.Key
      KEY_MARGIN_RIGHT =
      new org.apache.batik.transcoder.keys.LengthKey(
      );
    public static final org.apache.batik.transcoder.TranscodingHints.Key
      KEY_MARGIN_BOTTOM =
      new org.apache.batik.transcoder.keys.LengthKey(
      );
    public static final org.apache.batik.transcoder.TranscodingHints.Key
      KEY_MARGIN_LEFT =
      new org.apache.batik.transcoder.keys.LengthKey(
      );
    public static final org.apache.batik.transcoder.TranscodingHints.Key
      KEY_PAGE_ORIENTATION =
      new org.apache.batik.transcoder.keys.StringKey(
      );
    public static final org.apache.batik.transcoder.TranscodingHints.Key
      KEY_SCALE_TO_PAGE =
      new org.apache.batik.transcoder.keys.BooleanKey(
      );
    public static final java.lang.String USAGE =
      ("java org.apache.batik.transcoder.print.PrintTranscoder <svgF" +
       "ileToPrint>");
    public static void main(java.lang.String[] args)
          throws java.lang.Exception { if (args.
                                             length <
                                             1) {
                                           java.lang.System.
                                             err.
                                             println(
                                               USAGE);
                                           java.lang.System.
                                             exit(
                                               0);
                                       }
                                       org.apache.batik.transcoder.print.PrintTranscoder transcoder =
                                         new org.apache.batik.transcoder.print.PrintTranscoder(
                                         );
                                       setTranscoderFloatHint(
                                         transcoder,
                                         KEY_LANGUAGE_STR,
                                         KEY_LANGUAGE);
                                       setTranscoderFloatHint(
                                         transcoder,
                                         KEY_USER_STYLESHEET_URI_STR,
                                         KEY_USER_STYLESHEET_URI);
                                       setTranscoderStringHint(
                                         transcoder,
                                         KEY_XML_PARSER_CLASSNAME_STR,
                                         KEY_XML_PARSER_CLASSNAME);
                                       setTranscoderBooleanHint(
                                         transcoder,
                                         KEY_SCALE_TO_PAGE_STR,
                                         KEY_SCALE_TO_PAGE);
                                       setTranscoderRectangleHint(
                                         transcoder,
                                         KEY_AOI_STR,
                                         KEY_AOI);
                                       setTranscoderFloatHint(
                                         transcoder,
                                         KEY_WIDTH_STR,
                                         KEY_WIDTH);
                                       setTranscoderFloatHint(
                                         transcoder,
                                         KEY_HEIGHT_STR,
                                         KEY_HEIGHT);
                                       setTranscoderFloatHint(
                                         transcoder,
                                         KEY_PIXEL_TO_MM_STR,
                                         KEY_PIXEL_UNIT_TO_MILLIMETER);
                                       setTranscoderStringHint(
                                         transcoder,
                                         KEY_PAGE_ORIENTATION_STR,
                                         KEY_PAGE_ORIENTATION);
                                       setTranscoderFloatHint(
                                         transcoder,
                                         KEY_PAGE_WIDTH_STR,
                                         KEY_PAGE_WIDTH);
                                       setTranscoderFloatHint(
                                         transcoder,
                                         KEY_PAGE_HEIGHT_STR,
                                         KEY_PAGE_HEIGHT);
                                       setTranscoderFloatHint(
                                         transcoder,
                                         KEY_MARGIN_TOP_STR,
                                         KEY_MARGIN_TOP);
                                       setTranscoderFloatHint(
                                         transcoder,
                                         KEY_MARGIN_RIGHT_STR,
                                         KEY_MARGIN_RIGHT);
                                       setTranscoderFloatHint(
                                         transcoder,
                                         KEY_MARGIN_BOTTOM_STR,
                                         KEY_MARGIN_BOTTOM);
                                       setTranscoderFloatHint(
                                         transcoder,
                                         KEY_MARGIN_LEFT_STR,
                                         KEY_MARGIN_LEFT);
                                       setTranscoderBooleanHint(
                                         transcoder,
                                         KEY_SHOW_PAGE_DIALOG_STR,
                                         KEY_SHOW_PAGE_DIALOG);
                                       setTranscoderBooleanHint(
                                         transcoder,
                                         KEY_SHOW_PRINTER_DIALOG_STR,
                                         KEY_SHOW_PRINTER_DIALOG);
                                       for (int i =
                                              0;
                                            i <
                                              args.
                                                length;
                                            i++) {
                                           transcoder.
                                             transcode(
                                               new org.apache.batik.transcoder.TranscoderInput(
                                                 new java.io.File(
                                                   args[i]).
                                                   toURL(
                                                     ).
                                                   toString(
                                                     )),
                                               null);
                                       }
                                       transcoder.
                                         print(
                                           );
                                       java.lang.System.
                                         exit(
                                           0);
    }
    public static void setTranscoderFloatHint(org.apache.batik.transcoder.Transcoder transcoder,
                                              java.lang.String property,
                                              org.apache.batik.transcoder.TranscodingHints.Key key) {
        java.lang.String str =
          java.lang.System.
          getProperty(
            property);
        if (str !=
              null) {
            try {
                java.lang.Float value =
                  new java.lang.Float(
                  java.lang.Float.
                    parseFloat(
                      str));
                transcoder.
                  addTranscodingHint(
                    key,
                    value);
            }
            catch (java.lang.NumberFormatException e) {
                handleValueError(
                  property,
                  str);
            }
        }
    }
    public static void setTranscoderRectangleHint(org.apache.batik.transcoder.Transcoder transcoder,
                                                  java.lang.String property,
                                                  org.apache.batik.transcoder.TranscodingHints.Key key) {
        java.lang.String str =
          java.lang.System.
          getProperty(
            property);
        if (str !=
              null) {
            java.util.StringTokenizer st =
              new java.util.StringTokenizer(
              str,
              " ,");
            if (st.
                  countTokens(
                    ) !=
                  4) {
                handleValueError(
                  property,
                  str);
            }
            try {
                java.lang.String x =
                  st.
                  nextToken(
                    );
                java.lang.String y =
                  st.
                  nextToken(
                    );
                java.lang.String width =
                  st.
                  nextToken(
                    );
                java.lang.String height =
                  st.
                  nextToken(
                    );
                java.awt.geom.Rectangle2D r =
                  new java.awt.geom.Rectangle2D.Float(
                  java.lang.Float.
                    parseFloat(
                      x),
                  java.lang.Float.
                    parseFloat(
                      y),
                  java.lang.Float.
                    parseFloat(
                      width),
                  java.lang.Float.
                    parseFloat(
                      height));
                transcoder.
                  addTranscodingHint(
                    key,
                    r);
            }
            catch (java.lang.NumberFormatException e) {
                handleValueError(
                  property,
                  str);
            }
        }
    }
    public static void setTranscoderBooleanHint(org.apache.batik.transcoder.Transcoder transcoder,
                                                java.lang.String property,
                                                org.apache.batik.transcoder.TranscodingHints.Key key) {
        java.lang.String str =
          java.lang.System.
          getProperty(
            property);
        if (str !=
              null) {
            java.lang.Boolean value =
              "true".
              equalsIgnoreCase(
                str)
              ? java.lang.Boolean.
                  TRUE
              : java.lang.Boolean.
                  FALSE;
            transcoder.
              addTranscodingHint(
                key,
                value);
        }
    }
    public static void setTranscoderStringHint(org.apache.batik.transcoder.Transcoder transcoder,
                                               java.lang.String property,
                                               org.apache.batik.transcoder.TranscodingHints.Key key) {
        java.lang.String str =
          java.lang.System.
          getProperty(
            property);
        if (str !=
              null) {
            transcoder.
              addTranscodingHint(
                key,
                str);
        }
    }
    public static void handleValueError(java.lang.String property,
                                        java.lang.String value) {
        java.lang.System.
          err.
          println(
            "Invalid " +
            property +
            " value : " +
            value);
        java.lang.System.
          exit(
            1);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1cC5AcxXnu3dOdTvfQPfREQq/TSSCBb8EgHj4eXp327hbt" +
       "PXy3OsEhsZqb7bsdaXZnNNN7txIIMIECp2KCicCkAnIlwQZjLBESFwGHWA4V" +
       "HgVxFTaOY6d4JHbZEKIYioIYk5j8f0/vzuzszEo7lrJVPTvb0/3//f399///" +
       "/Zh9/ASpNw2ymuZYDzugU7MnlmOjkmHSdJ8qmWYS8lLyV+ukD254e/jyMGmY" +
       "JAszkjkkSybtV6iaNifJKiVnMiknU3OY0jTWGDWoSY1ZiSlabpIsUcx4VlcV" +
       "WWFDWppigQnJSJAOiTFDmcozGhcEGFmVgJZEeEsiUffj3gRpkTX9gF18uaN4" +
       "n+MJlszavExG2hN7pVkpkmeKGkkoJustGOQ8XVMPzKga66EF1rNX3SJEcE1i" +
       "S4UIup5o++iTezLtXASLpFxOYxyeOUZNTZ2l6QRps3NjKs2a+8nNpC5Bmh2F" +
       "GelOFJlGgGkEmBbR2qWg9a00l8/2aRwOK1Jq0GVsECPryonokiFlBZlR3mag" +
       "0MgEdl4Z0K4tobVQVkC877zI4a/e0P5kHWmbJG1KbhybI0MjGDCZBIHS7BQ1" +
       "zGg6TdOTpCMHnT1ODUVSlYOipztNZSYnsTx0f1EsmJnXqcF52rKCfgRsRl5m" +
       "mlGCN80VSvyqn1alGcC61MZqIezHfADYpEDDjGkJ9E5UmbdPyaUZWeOuUcLY" +
       "vR0KQNX5WcoyWonVvJwEGaTTUhFVys1ExkH1cjNQtF4DBTQYWeFLFGWtS/I+" +
       "aYamUCNd5UatR1BqARcEVmFkibsYpwS9tMLVS47+OTF8xd035gZzYRKCNqep" +
       "rGL7m6HSalelMTpNDQrjwKrYsjlxv7T02bvChEDhJa7CVpmnbnr/8+evPv6i" +
       "VWalR5mRqb1UZin54amFr57dt+nyOmxGo66ZCnZ+GXI+ykbFk96CDhZmaYki" +
       "PuwpPjw+9vx1tz5G3w2TpjhpkDU1nwU96pC1rK6o1BigOWpIjKbjZAHNpfv4" +
       "8ziZD/cJJUet3JHpaZOyOJmn8qwGjf8GEU0DCRRRE9wruWmteK9LLMPvCzoh" +
       "ZD4kshzSKLE+I3hhJB3JaFkakWQpp+S0yKihIX4zAhZnCmSbiUyB1u+LmFre" +
       "ABWMaMZMRAI9yFDxgBlSzpTBCBkRHZSJAQW4Jku5Paht+v8TnwLiXTQXCkFX" +
       "nO02BCqMoUFNhbIp+XB+a+z9o6mXLSXDgSEkxciFwLrHYt3DWffYrHs46x4X" +
       "axIKcY6LsQlWx0O37QMDABa4ZdP47mv23NVVBxqnz80DmWPRrjJP1GdbiaJp" +
       "T8nHOlsPrnvjwufCZF6CdEoyy0sqOpaoMQMmS94nRnXLFPgo21WsdbgK9HGG" +
       "JtM0WCo/lyGoNGqz1MB8RhY7KBQdGQ7ZiL8b8Ww/Of7A3BcnbrkgTMLl3gFZ" +
       "1oNhw+qjaNNLtrvbbRW86Lbd+fZHx+4/pNn2oczdFL1kRU3E0OXWCbd4UvLm" +
       "tdJ3Us8e6uZiXwD2m0kw3sA0rnbzKDM/vUVTjlgaAfC0ZmQlFR8VZdzEMoY2" +
       "Z+dwZe3g94tBLZpxPK6A9CUxQPk3Pl2q43WZpdyoZy4U3FVcOa4/9C8/eOci" +
       "Lu6iV2lzhAPjlPU6LBkS6+Q2q8NW26RBKZR7/YHRP7nvxJ3Xc52FEuu9GHbj" +
       "tQ8sGHQhiPmOF/f/9M03Hn4tbOs5A1een4KIqFACifmkqQpI4LbRbg9YQhWs" +
       "BGpN944c6KcyrUhTKsWB9T9tGy78zn/e3W7pgQo5RTU6/+QE7PyztpJbX77h" +
       "v1dzMiEZPbEtM7uYZd4X2ZSjhiEdwHYUvvjDVX/6gvQQOAowzqZykHJ7S7gM" +
       "CO+0LRz/Bfx6sevZpXjZYDqVv3x8OSKmlHzPa++1Trz39+/z1paHXM6+HpL0" +
       "Xku98LKxAOSXuY3ToGRmoNzFx4d3tavHPwGKk0BRBuNrjhhg1QplmiFK18//" +
       "2fefW7rn1ToS7idNqial+yU+yMgC0G5qZsC+FvSrP2917lwjXNo5VFIBviID" +
       "BbzGu+tiWZ1xYR/822V/c8UjR97gWqZbNFby+t1o8susKg/c7YH92I8u/fEj" +
       "X7l/znL9m/ytmave8t+OqFO3/ftvKkTO7ZhHWOKqPxl5/MEVfVe9y+vbBgVr" +
       "dxcq3RQYZbvuZx/LfhjuavjHMJk/SdplEShPSGoeh+kkBIdmMXqGYLrseXmg" +
       "Z0U1vSWDebbbmDnYuk2Z7R7hHkvjfavLemFkQS6CNCEG9oTbeoXAHtRJmoK/" +
       "4rzeOfy6GS+f4X1Yh7c9YDZMHpMzaIeSk1SX+VhWhQsjzdtj16WiI/HUeHKM" +
       "11sOsyKuVSiIHivitSwpXi/DyzUWh15fve0rx3k5pJ2iBTu9cDZkqDKT4QZp" +
       "ohpUvAzjZcQDox8HRhYixsFYfGAwiTAxd8wFaWeNkK6EdK1geK0XpEYUXx5C" +
       "fMxKBQblxwM6CUElosMDO6IDMT9Ye2qE1Q/pOsHyOi9YLVnJmFFyWzXGtCxm" +
       "ZwJD8+MD0yCENhQdG4gPp7aOJJMjQ374lBrxbYU0KfhOeuFrsvAl6DTXxv2B" +
       "0flxYWSRA10i1u+rkkaN2LZBul5wvd4LW7OFbaw41A4GBufHBqJhB7ixagPu" +
       "xhrRYbFdgu0uL3QLLHRJjef9QWBsfkzAQTiwJUdG/ZDdHkAndwumuz11Ugcz" +
       "MliykH8UGJofF6GTo2hIqpvJL9eILQnpBsH1Bi9sbYhtxFAgEpGKYfZ9gQH6" +
       "sWJkeQngyFg8NpyMJuMjw34o7w+gmynBOuWpm4hyp5K2FhiOBMbnx0ToJse3" +
       "M74tOeiH7Gs1IotC2iOY7vFGphSomtSGuDN4JDAyPyZF1YxfG0vAoEsN+bqC" +
       "R2uENgRJElwlL2jNpiypNKmNCif+RGBwfmyEpxvviyZiCG60iif/qxrhbYc0" +
       "JfhOecFbCJOPOcS2TZFUjYd4TwdG6MdJDLzxwZGdFrpt8WhiZMAP5DM1gvwC" +
       "JFmwlr1AdnCQBl8TtnH+Q2CcfswYWWnjHIsPJ2NjJ4H6XI1QhyGlBfe0Z3/m" +
       "TWqMswMqzCop5Z7i5cA4/TgJnDvGAd948rpEbHwwFkumdozF/XC+UiPOSyFR" +
       "wZ164ayfK9rR1wLD82PASCvCq2pCf1wjoHFI04LftBegzkJW5bsuBl/VHxaz" +
       "x9cDo/PjBtNYRHftUALG4hh2YV8iOj4+HB3ytTpv1Ai2F9KMYD/j2Xt8RRh/" +
       "/zIwPj8GMNwnookdsdRQDMaeNQ69QP0qwNDLCJ4ZL1ALYK6XBm9hTfV/HRiY" +
       "HxNG1lrAKgIYmP9tA/cxGvPC+V4Aj6iIJiheOBt1zWCGpPD++01gmH48GFnj" +
       "A3N0ZCw5Fo179ubHNaLE4HevaMFeL5TtBp2lMBwTjk4NhQKj9ePFyLk+aMdi" +
       "EzEYnlU7NxQ+ddgtmLsZkiGaYlTAJngTavIGCTKZD8N2VmLUha+5ClFGGpSc" +
       "nmemaZBV9kIjbpGM56dMNibNcXuXkned0760+/IPuqyVxtUeZR3bnXd/95nJ" +
       "yXPaZatwlxfh8m3ORx9plP81+/wvrApneVSwyi15NPLliZ/sfYVvCDTiLlGy" +
       "uHbn2AOKGtY6n7Ub0V4Sx0JE3wnpm0Ic/JuRXb/nNh5Uy0aYklVyM5GkkqVp" +
       "PEOAGMQ24Rmlz9fBy9aI7U771j41+uvLvnGlJdZ1PsvDdvmnv/DWqw8dPPa4" +
       "tf2A4mXkPL9TD5VHLXA3akOVHTVbQT4c+Nzxd34+sTssNgwWomYvtRR3OYRJ" +
       "znV9vgcSWs2f4dJ6qLThuLhcTyzS277U9nf3dNb1h8m8OGnM55T9eRpPl6/4" +
       "zjfzUw7FsXf3eYZTaz6FTwjS7zChtmCGpTWdfWKne21pq1vXC/ickdBmuHUZ" +
       "g+YajcFG/sT6FHyMwbmWMcDb1spR71cbIiju4Wk6zgc/Vl/iau2mGlu7GtIh" +
       "we+QT2sjVVvrVxtcmpw34rk0LZjexgTmDlmFKbNCAz47uke+q3v0F0K5Qovx" +
       "sh4rV9kgcdGIHOp8c9+Db39bmLuKLdaywvSuw3/4ac/dh61hY51kWV9xmMRZ" +
       "xzrNYilaqXXrqnHhNfp/dezQdx89dKfVqs7ycxmxXD777X/+31d6HnjrJY8j" +
       "AHWKOI3kGEPIusutpxfU2PPrIN0u+u52n56PVu15v9rgnViG9rGSXdhQcYxh" +
       "ylDSM7RnK/8S551ceLbWGHusBMEcs4qGjvrguSZopGFR9KAsVmXdk/Ai8guq" +
       "HeAontoA/zCIvdy9nR5wCWF7ACG8JJr6oo8QkoGF8KIPZUaW+czQkd+oC9OO" +
       "GjGtAI5vCc5v+mDaFRjTmz6Uxc6WveznBWV3ACgfCYYf+kBJB4byoQ9lRtpc" +
       "S9BeWGjtWMItVtFwsw8WNSgWi6IHZdEt9k6BF5RsAChdguE6HygsMJR1PpTF" +
       "NqNzQ8cLTD4AmMsEy0t9wNwUGMylPpQZ6ajYWPRCcygAmmHBc8gHze2B0Qz5" +
       "UBYjxrGR6IXljgBYxOJfuHJF1cISeAMqLPtQFh7KPRP2AlTrDhR4m/BNgu2N" +
       "PoAOBwZ0ow9loWplK/teaO6rEc1+4HWz4HlzBRqYqA/g9GZtzUcy115hzs70" +
       "K3y7A59chY17MLBY/JrISP2OcUsUFQsaD1URRaEU45HzStz4p4GIk7nFbwc3" +
       "XnKlmNLhPQQ7y/n0T5pjTjngCTeMklf5nbLmEfLDtx0+kh75+oXF2L+XkQVM" +
       "0z+j0lmqOni1lC94wKx5iJ8rt48pvb7w3p8/3T2ztZajqpi3+iSHUfH3Goje" +
       "N/vPRdxNeeG2/1iRvCqzp4ZTp2tcUnKT/ObQ4y8NbJTvDfND9Nb5qYrD9+WV" +
       "esvn0E0GZXkjVz5rXl/qeO5vI5C+Ijr+HvdIsFXLpTOl85T3+FTlJe2Th2He" +
       "o+Gi9px3KqEyNUpTX6xz/qnVGckzqMQV6ylXIxzHH0PP4uVJ1LxiTT7FvmS/" +
       "NdPDr88xMm9WU9L20Prrk1mZ6ucMMSOqc9pHS5LkC15bIP25kOTXqnSC24Tw" +
       "jWNDY1RmNO2yH61FWh40XYKps+xRUdKLUdJzF8k9aS3bs02T87iQVTQ1oWe4" +
       "/P7JRSJUbh4ip9ZZsYJMdRwmnOareHne2SeY8T1b/i+cAfk3C1tLxKyPVMwn" +
       "Tz4I/KpW0b83qstvjZd5dcvrLbz81LEX5JTVz86ArNrwGdyEllo0re+aZOVb" +
       "tbpKdpTkMWBIekaRzeKTs9ySkmZoP56B5wLZwgV1okpHfICXt51C3GIL8Z0z" +
       "NeCBXkg491BF/FEuxNBLFePat6q/1Q1d7LBsLitXP61qkv/CU+hTfv2dvxDD" +
       "9VjgYwYum7J4FnpgXDnoHry/PQOy5HPSi6Cxwg2FTuLBPFa2fKt6yxKJ/FdR" +
       "9xbZ53vLRma4vYqscKkz3AxWLm1IczHD0IxyQYVbzoCgcEcFt67Ct1o0rW8f" +
       "Qbm9DIIWgarLx3RUoehj4Lw3pvhbDdZK7a7m579n/uUvnyyGh4t0DCmr7Fk4" +
       "6h75xvof3HJk/b/xlwoaFROCO4gFPd77c9R57/E33/1h66qjPIjkGyrY5Fb3" +
       "C5OV70OWvebI5deml5ZBK45+e1r6Pl1MncKbTib6ES6M9Yw0qDQ3ww9uhC7H" +
       "mhv0gltJPfSzT9VyFOPzkpPnzxStp/SSKQ/ePVoZOsr3ScIbHHadt6WKkl9S" +
       "5RlX8ovA7MjYJgtCleK9firuGA1lJovXWuutfviogxe4Gi8rIMTLSkrONQJX" +
       "nqkROACdc0KMl3dP2wh814didZe68dRCNCzN475RLrbtVXpqBC8xRpaCF7AJ" +
       "9KNzGawIUML9Z0rI20EUnwiRfHzahPyxD0VvISPAhEt011cR3W687GBkRZno" +
       "xiCuh8GrUg/xTZwp8cWh+UssmnWLTpf4LEoeFE9dfEoV8eFMPywzsrxMfFs1" +
       "TaVSzkN46TM4wOvWCKirTpvwVvlQPHXhzVURHu5DhfczIOcUnuW1PGR30tcp" +
       "gsoOJsF15wikG0+b7Db6UPQN76wFtTEumjuqiO1OvNwCnj4j5dIq5S+/eYVz" +
       "t54OeRUYaXMtNeJri8sr/nTC+qME+eiRtsZlR3b8xApqin9m0JIgjdN5VXW+" +
       "WOe4b9ANOq1wUbdYr9lZjv+PGVl30pXQ4gwKEYTvtirey8jKKhUZabJ/OOvd" +
       "B1J11wP6/NtZ7gGgYJeD0Mi6cRb5M0bqoAjePqgXXV/VV+3HJwaiEJEakuwQ" +
       "dsGK11Y6u4mfmltyst4tVXG+zowxLP9bkWIcnB8Vx3uOHblm+Mb3L/m69Tq1" +
       "rEoHDyKVZgg3rTe7RbjpPirkpFak1TC46ZOFTyzYUDzB02E12B5KK2115m8o" +
       "lC+4VvxBTEoufP/8tp6/OOvcMC5put4pdb292aRqc2iC87k05kA8XZ8Vq2w8" +
       "nM7ruvOx67VO3q56Yr34gp8xT4OA3Xqx7hX+htbt53NcrAYqAI3RXdn4WmhW" +
       "SbuzwxASZpSZTFk+nixiJHS1zmP1bxV0m6c9rzm78qgTzD/4a98p+bVHdv/o" +
       "3uUPrw6T5jipV/CkDH+NdtuBHHj5WWOStCpmrKCYDKhAPF52LmohDmAJ7THv" +
       "WaEQraVc/DsBRroqj7NU/glDZbc02znFzilbQ3Z1FFSwc+y5T7m8Q9fq/F30" +
       "EF4W8q6yJMc1De+ewuJd/Gfh/wDJbf1kJkkAAA==");
    public ent.runtime.ENT_Attributable ENT_copy() {
        org.apache.batik.transcoder.print.PrintTranscoder ENT_ld =
          new org.apache.batik.transcoder.print.PrintTranscoder(
          );
        ENT_ld.
          inputs =
          this.
            inputs;
        ENT_ld.
          printedInputs =
          this.
            printedInputs;
        ENT_ld.
          curIndex =
          this.
            curIndex;
        ENT_ld.
          theCtx =
          this.
            theCtx;
        return ENT_ld;
    }
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "GCPXSCTX863O78P7K7eg5voOr74P7z25b67mpnL7BPYbl8N8dYv5huE099d7" +
       "ue1kkH0UfvMWLL2xo2Dso3C35/qhLxkbqf/O5Rg8cw4DhmZ5ttPf2wa/e0kC" +
       "hQe23BFY7iPwsK/FWq76xMmm+P3LEXnhHCIsIiB5V7i4Sf7Ha2d0f5H6zjz4" +
       "O0b+DYxKmx9f3o8/p3tX3kXi/HH6CPqdhuNFYRD4pbeeM4HCSsnGKlxTfmL0" +
       "xV/9ZPbZT22nzGQp0MJS+bxlrxtX3ooZ1LdfMAt8vCDyZ9g3fP4P/7vw8sFu" +
       "kuu+0xJ4+CIJHE0LPHhywmo7ufcXZyT/x5eU/PObK9tPeo7k/+ocyRc/v3Ld" +
       "xG/slKb2t7IvUv/0Rorn3uo6l7OE/vqShN6Sh1d2d3llP6Erd7wWQncrkd93" +
       "VC29eCIu90tsIzTi3fIV8MqjXzB/8A8+vV2aOjvrdiaz9t0f/7t/c/jRjx+c" +
       "WBB82w1rcifLbBcFNxAf2OBMT2n5nrtsSqD/87Ov/OS/fOW7tqgePb28hTiR" +
       "/enf/OtfOvyBL/7CnpWU23bDz3GbXLnzkm3y1jx8+65Nvv2cNnnstbTJnaGu" +
       "weH1/vD2GxZ5ZN9QF9phd/O1Ww0+A/6Nl7S2b8pBfHab9cpnzgH/9C1MLpx1" +
       "p49IVS5auTparjKcBZ63S/DcUFuf4feWW+D3Czt+P38Ov+cvx++Jc3ztoqpn" +
       "z8B9xyXhPpXD/OIO7hfOgfv1l4P74Onn4H0oD28B5Z/vUP7ZOSihy6F86Mwk" +
       "yT6Y9cvDPLh/m/XgvnNgvnQLwjyegdqH8t23gPLZHcq3noOyezmUD5+d3tuH" +
       "E74FnK0dzuY5OPuXdOJvmPfdB3RwC0CpHVDyHKDMLWjniXnefTBHtwBz90h9" +
       "cOPEwBbm5BYs71mfdh/W6eWt6MG37LB+8Bys77+Ftj81Y7QP6LVLAl3lAD+0" +
       "A/qhG4Dm3jRWOJlXL/36xNV3B/ECNTYzZMWVbyzAXXKx4I4xt2V59oHiys2X" +
       "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" +
       "ta2sPe+u21K/OW42wSUElqOYiB3MGqgi");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "VaxdWgAA");
}
