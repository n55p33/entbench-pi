package org.apache.batik.transcoder.wmf.tosvg;
public class WMFTranscoder extends org.apache.batik.transcoder.ToSVGAbstractTranscoder implements ent.runtime.ENT_Attributable {
    public int ENT_attribute() { return org.apache.batik.apps.rasterizer.EntMode.
                                          LOW_MODE; }
    public WMFTranscoder() { super(); }
    public void transcode(org.apache.batik.transcoder.TranscoderInput input,
                          org.apache.batik.transcoder.TranscoderOutput output)
          throws org.apache.batik.transcoder.TranscoderException {
        java.io.DataInputStream is =
          getCompatibleInput(
            input);
        org.apache.batik.transcoder.wmf.tosvg.WMFRecordStore currentStore =
          new org.apache.batik.transcoder.wmf.tosvg.WMFRecordStore(
          );
        try {
            currentStore.
              read(
                is);
        }
        catch (java.io.IOException e) {
            handler.
              fatalError(
                new org.apache.batik.transcoder.TranscoderException(
                  e));
            return;
        }
        float wmfwidth;
        float wmfheight;
        float conv =
          1.0F;
        if (hints.
              containsKey(
                KEY_INPUT_WIDTH)) {
            wmfwidth =
              ((java.lang.Integer)
                 hints.
                 get(
                   KEY_INPUT_WIDTH)).
                intValue(
                  );
            wmfheight =
              ((java.lang.Integer)
                 hints.
                 get(
                   KEY_INPUT_HEIGHT)).
                intValue(
                  );
        }
        else {
            wmfwidth =
              currentStore.
                getWidthPixels(
                  );
            wmfheight =
              currentStore.
                getHeightPixels(
                  );
        }
        float width =
          wmfwidth;
        float height =
          wmfheight;
        if (hints.
              containsKey(
                KEY_WIDTH)) {
            width =
              ((java.lang.Float)
                 hints.
                 get(
                   KEY_WIDTH)).
                floatValue(
                  );
            conv =
              width /
                wmfwidth;
            height =
              height *
                width /
                wmfwidth;
        }
        int xOffset =
          0;
        int yOffset =
          0;
        if (hints.
              containsKey(
                KEY_XOFFSET)) {
            xOffset =
              ((java.lang.Integer)
                 hints.
                 get(
                   KEY_XOFFSET)).
                intValue(
                  );
        }
        if (hints.
              containsKey(
                KEY_YOFFSET)) {
            yOffset =
              ((java.lang.Integer)
                 hints.
                 get(
                   KEY_YOFFSET)).
                intValue(
                  );
        }
        float sizeFactor =
          currentStore.
          getUnitsToPixels(
            ) *
          conv;
        int vpX =
          (int)
            (currentStore.
               getVpX(
                 ) *
               sizeFactor);
        int vpY =
          (int)
            (currentStore.
               getVpY(
                 ) *
               sizeFactor);
        int vpW;
        int vpH;
        if (hints.
              containsKey(
                KEY_INPUT_WIDTH)) {
            vpW =
              (int)
                (((java.lang.Integer)
                    hints.
                    get(
                      KEY_INPUT_WIDTH)).
                   intValue(
                     ) *
                   conv);
            vpH =
              (int)
                (((java.lang.Integer)
                    hints.
                    get(
                      KEY_INPUT_HEIGHT)).
                   intValue(
                     ) *
                   conv);
        }
        else {
            vpW =
              (int)
                (currentStore.
                   getWidthUnits(
                     ) *
                   sizeFactor);
            vpH =
              (int)
                (currentStore.
                   getHeightUnits(
                     ) *
                   sizeFactor);
        }
        org.apache.batik.transcoder.wmf.tosvg.WMFPainter painter =
          new org.apache.batik.transcoder.wmf.tosvg.WMFPainter(
          currentStore,
          xOffset,
          yOffset,
          conv);
        org.w3c.dom.Document doc =
          this.
          createDocument(
            output);
        svgGenerator =
          new org.apache.batik.svggen.SVGGraphics2D(
            doc);
        svgGenerator.
          getGeneratorContext(
            ).
          setPrecision(
            4);
        painter.
          paint(
            svgGenerator);
        svgGenerator.
          setSVGCanvasSize(
            new java.awt.Dimension(
              vpW,
              vpH));
        org.w3c.dom.Element svgRoot =
          svgGenerator.
          getRoot(
            );
        svgRoot.
          setAttributeNS(
            null,
            SVG_VIEW_BOX_ATTRIBUTE,
            java.lang.String.
              valueOf(
                vpX) +
            ' ' +
            vpY +
            ' ' +
            vpW +
            ' ' +
            vpH);
        writeSVGToOutput(
          svgGenerator,
          svgRoot,
          output);
    }
    private java.io.DataInputStream getCompatibleInput(org.apache.batik.transcoder.TranscoderInput input)
          throws org.apache.batik.transcoder.TranscoderException {
        if (input ==
              null) {
            handler.
              fatalError(
                new org.apache.batik.transcoder.TranscoderException(
                  java.lang.String.
                    valueOf(
                      ERROR_NULL_INPUT)));
        }
        java.io.InputStream in =
          input.
          getInputStream(
            );
        if (in !=
              null) {
            return new java.io.DataInputStream(
              new java.io.BufferedInputStream(
                in));
        }
        java.lang.String uri =
          input.
          getURI(
            );
        if (uri !=
              null) {
            try {
                java.net.URL url =
                  new java.net.URL(
                  uri);
                in =
                  url.
                    openStream(
                      );
                return new java.io.DataInputStream(
                  new java.io.BufferedInputStream(
                    in));
            }
            catch (java.net.MalformedURLException e) {
                handler.
                  fatalError(
                    new org.apache.batik.transcoder.TranscoderException(
                      e));
            }
            catch (java.io.IOException e) {
                handler.
                  fatalError(
                    new org.apache.batik.transcoder.TranscoderException(
                      e));
            }
        }
        handler.
          fatalError(
            new org.apache.batik.transcoder.TranscoderException(
              java.lang.String.
                valueOf(
                  ERROR_INCOMPATIBLE_INPUT_TYPE)));
        return null;
    }
    public static final java.lang.String WMF_EXTENSION = ".wmf";
    public static final java.lang.String SVG_EXTENSION = ".svg";
    public static void main(java.lang.String[] args) throws org.apache.batik.transcoder.TranscoderException {
        if (args.
              length <
              1) {
            java.lang.System.
              out.
              println(
                "Usage : WMFTranscoder.main <file 1> ... <file n>");
            java.lang.System.
              exit(
                1);
        }
        org.apache.batik.transcoder.wmf.tosvg.WMFTranscoder transcoder =
          new org.apache.batik.transcoder.wmf.tosvg.WMFTranscoder(
          );
        int nFiles =
          args.
            length;
        for (int i =
               0;
             i <
               nFiles;
             i++) {
            java.lang.String fileName =
              args[i];
            if (!fileName.
                  toLowerCase(
                    ).
                  endsWith(
                    WMF_EXTENSION)) {
                java.lang.System.
                  err.
                  println(
                    args[i] +
                    " does not have the " +
                    WMF_EXTENSION +
                    " extension. It is ignored");
            }
            else {
                java.lang.System.
                  out.
                  print(
                    "Processing : " +
                    args[i] +
                    "...");
                java.lang.String outputFileName =
                  fileName.
                  substring(
                    0,
                    fileName.
                      toLowerCase(
                        ).
                      indexOf(
                        WMF_EXTENSION)) +
                SVG_EXTENSION;
                java.io.File inputFile =
                  new java.io.File(
                  fileName);
                java.io.File outputFile =
                  new java.io.File(
                  outputFileName);
                try {
                    org.apache.batik.transcoder.TranscoderInput input =
                      new org.apache.batik.transcoder.TranscoderInput(
                      inputFile.
                        toURL(
                          ).
                        toString(
                          ));
                    org.apache.batik.transcoder.TranscoderOutput output =
                      new org.apache.batik.transcoder.TranscoderOutput(
                      new java.io.FileOutputStream(
                        outputFile));
                    transcoder.
                      transcode(
                        input,
                        output);
                }
                catch (java.net.MalformedURLException e) {
                    throw new org.apache.batik.transcoder.TranscoderException(
                      e);
                }
                catch (java.io.IOException e) {
                    throw new org.apache.batik.transcoder.TranscoderException(
                      e);
                }
                java.lang.System.
                  out.
                  println(
                    ".... Done");
            }
        }
        java.lang.System.
          exit(
            0);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "lQvJqx4AAA==");
    public ent.runtime.ENT_Attributable ENT_copy() {
        org.apache.batik.transcoder.wmf.tosvg.WMFTranscoder ENT_ld =
          new org.apache.batik.transcoder.wmf.tosvg.WMFTranscoder(
          );
        return ENT_ld;
    }
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "r5WNXW7aIMUQVEnRbp6ScyeS8cMYyqf/");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("wVeb/mOWk7eNsrUlv0h7lGzH26u016TPPd/qvf+V8qe3t50kS0jTrJeLYBnY" +
       "Xrw6Ttgfv2VvR31daD79jft/8e6njl4u7t8KvAufE7K97eZXi2q2F+WXgdJf" +
       "fesvf+fPPP/n+Un4vwOe9MFF4SwAAA==");
}
