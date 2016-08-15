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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "EF4W8K6yJMc1De+ewuJd/Gfh/wAQnyDkJkkAAA==");
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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Ro6qEGtbWXveXbelfnPcbIJLCCxHMRE7");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "8v8B3ayDcl1aAAA=");
}
