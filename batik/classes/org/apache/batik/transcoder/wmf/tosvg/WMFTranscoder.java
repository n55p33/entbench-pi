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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "pjInqx4AAA==");
    public ent.runtime.ENT_Attributable ENT_copy() {
        org.apache.batik.transcoder.wmf.tosvg.WMFTranscoder ENT_ld =
          new org.apache.batik.transcoder.wmf.tosvg.WMFTranscoder(
          );
        return ENT_ld;
    }
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "SP/g/c9f+/i1D+/mvHbLSaLsecGhLwch8I0U+Iekk+3KgY/L9uLFQ3o0u8mM" +
       "2uSNj/LXXnze85K9a93JZ84wnbV+Ck5w58ORn7tL22ey4hNh4aEz4uSkyinH" +
       "XoaFe4yj+xq5w3/yzbbNTk+UV7x49oyuB7/OkRzO+c3lUyo4H6cX8jjdRec5" +
       "uQ5ygoPjaCne7UR3f4jbc7woPO7zgbfWZxSFsFPOxOfPMXHhbMgib21AMlGA" +
       "lwVNPubfyIrPZdF5THA7g1zcuIa6t8hf+REs8kRWmbV/68gi33o7FgkL93m+" +
       "sYHBcluzXNjb7Qs5wd+9M8GXcoKvZsVXwsKjSxDmZ6OhAQHujKF2B3GGe9iW" +
       "Qzlv4UMfHEFMro9f/hH08WhW+QL8/uBIHz94G/o42K8kd9MHBNnn7gyy+cHo" +
       "bmv95V9+9nd+9uVn/zA/W7xsBFPZJ/zlbW7UnOrz+iuvfe/bDz35tfz8/eJC" +
       "DnYoeP4q0q03jc5cIMrZf/BEK++6A2jefGuguTv7upaffF3bHVB9+KPXMui7" +
       "OSQYkr/2wWsOiI9acmz88OHh4UdvHGNi77Yxlm/PfzO5UMgN8+qbmeRkXb9k" +
       "AWe5uy3z81nxj73kTkDyzv1JTctyHZCttsdt7zr2w5MLY/lSfDtOX9xxmk92" +
       "Ct5v5yKnEfpf3aXtX2fFvwwL9yoZXzsx7kL+7WT3+w/fLAC/kxW/BiHGlo38" +
       "jsPf3MfVN36EuMqX3Wdu9aBffGsedD7lySsU19vult8zd3NyB8oJLPXIs25t" +
       "fz90sOdvfODa0cK9o85bfpTV+N/fdTV+7S5tf5gVvxsWLh8Llv2P97r/vbej" +
       "+2R3TrwXObt78dgtdyV39/uUr7185fJ7Xxb+7Q4xju/g3U8XLmuRZZ0+Kj/1" +
       "fMnzgWbkrN+/OzjfKey7YeG5t3SfCrpu/psz/0e7zt+Dud6bdIbZCCxPd/pv" +
       "YeHH7tIphFnoyZ/T/d4IC1fP94NM5b+n6f47HGFPB+Fj93Ca5I8hV5Ake/wT" +
       "7xgf7nqtbOLy0w6xCGCVEu7tlFw4lYwf");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("xVBu/kffzPwnXU7fNsrWlvwi7XGyHe2u0t5Uvv5yf/jxN/Cv7G47KZacptko" +
       "l+EysLt4dZKwP33H0Y7HutR9/ocP/+r9zx2/XDy8Y3gfPqd4e9/trxaRthfm" +
       "l4HSf/DeX/vJv/Xy7+cn4f8XAi3cAeEsAAA=");
}
