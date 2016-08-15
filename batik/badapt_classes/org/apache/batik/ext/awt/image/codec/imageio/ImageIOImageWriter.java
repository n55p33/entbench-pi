package org.apache.batik.ext.awt.image.codec.imageio;
public class ImageIOImageWriter implements org.apache.batik.ext.awt.image.spi.ImageWriter, javax.imageio.event.IIOWriteWarningListener {
    private java.lang.String targetMIME;
    public ImageIOImageWriter(java.lang.String mime) { super();
                                                       this.targetMIME = mime;
    }
    public void writeImage(java.awt.image.RenderedImage image, java.io.OutputStream out)
          throws java.io.IOException { writeImage(image, out, null);
    }
    public void writeImage(java.awt.image.RenderedImage image, java.io.OutputStream out,
                           org.apache.batik.ext.awt.image.spi.ImageWriterParams params)
          throws java.io.IOException { java.util.Iterator iter;
                                       iter = javax.imageio.ImageIO.
                                                getImageWritersByMIMEType(
                                                  getMIMEType(
                                                    ));
                                       javax.imageio.ImageWriter iiowriter =
                                         null;
                                       try { iiowriter =
                                               (javax.imageio.ImageWriter)
                                                 iter.
                                                 next(
                                                   );
                                             if (iiowriter !=
                                                   null) {
                                                 iiowriter.
                                                   addIIOWriteWarningListener(
                                                     this);
                                                 javax.imageio.stream.ImageOutputStream imgout =
                                                   null;
                                                 try {
                                                     imgout =
                                                       javax.imageio.ImageIO.
                                                         createImageOutputStream(
                                                           out);
                                                     javax.imageio.ImageWriteParam iwParam =
                                                       getDefaultWriteParam(
                                                         iiowriter,
                                                         image,
                                                         params);
                                                     javax.imageio.ImageTypeSpecifier type;
                                                     if (iwParam.
                                                           getDestinationType(
                                                             ) !=
                                                           null) {
                                                         type =
                                                           iwParam.
                                                             getDestinationType(
                                                               );
                                                     }
                                                     else {
                                                         type =
                                                           javax.imageio.ImageTypeSpecifier.
                                                             createFromRenderedImage(
                                                               image);
                                                     }
                                                     javax.imageio.metadata.IIOMetadata meta =
                                                       iiowriter.
                                                       getDefaultImageMetadata(
                                                         type,
                                                         iwParam);
                                                     if (params !=
                                                           null &&
                                                           meta !=
                                                           null) {
                                                         meta =
                                                           updateMetadata(
                                                             meta,
                                                             params);
                                                     }
                                                     iiowriter.
                                                       setOutput(
                                                         imgout);
                                                     javax.imageio.IIOImage iioimg =
                                                       new javax.imageio.IIOImage(
                                                       image,
                                                       null,
                                                       meta);
                                                     iiowriter.
                                                       write(
                                                         null,
                                                         iioimg,
                                                         iwParam);
                                                 }
                                                 finally {
                                                     if (imgout !=
                                                           null) {
                                                         java.lang.System.
                                                           err.
                                                           println(
                                                             "closing");
                                                         imgout.
                                                           close(
                                                             );
                                                     }
                                                 }
                                             }
                                             else {
                                                 throw new java.lang.UnsupportedOperationException(
                                                   "No ImageIO codec for writing " +
                                                   getMIMEType(
                                                     ) +
                                                   " is available!");
                                             }
                                       }
                                       finally {
                                           if (iiowriter !=
                                                 null) {
                                               java.lang.System.
                                                 err.
                                                 println(
                                                   "disposing");
                                               iiowriter.
                                                 dispose(
                                                   );
                                           }
                                       } }
    protected javax.imageio.ImageWriteParam getDefaultWriteParam(javax.imageio.ImageWriter iiowriter,
                                                                 java.awt.image.RenderedImage image,
                                                                 org.apache.batik.ext.awt.image.spi.ImageWriterParams params) {
        javax.imageio.ImageWriteParam param =
          iiowriter.
          getDefaultWriteParam(
            );
        java.lang.System.
          err.
          println(
            "Param: " +
            params);
        if (params !=
              null &&
              params.
              getCompressionMethod(
                ) !=
              null) {
            param.
              setCompressionMode(
                javax.imageio.ImageWriteParam.
                  MODE_EXPLICIT);
            param.
              setCompressionType(
                params.
                  getCompressionMethod(
                    ));
        }
        return param;
    }
    protected javax.imageio.metadata.IIOMetadata updateMetadata(javax.imageio.metadata.IIOMetadata meta,
                                                                org.apache.batik.ext.awt.image.spi.ImageWriterParams params) {
        final java.lang.String stdmeta =
          "javax_imageio_1.0";
        if (meta.
              isStandardMetadataFormatSupported(
                )) {
            javax.imageio.metadata.IIOMetadataNode root =
              (javax.imageio.metadata.IIOMetadataNode)
                meta.
                getAsTree(
                  stdmeta);
            javax.imageio.metadata.IIOMetadataNode dim =
              getChildNode(
                root,
                "Dimension");
            javax.imageio.metadata.IIOMetadataNode child;
            if (params.
                  getResolution(
                    ) !=
                  null) {
                child =
                  getChildNode(
                    dim,
                    "HorizontalPixelSize");
                if (child ==
                      null) {
                    child =
                      new javax.imageio.metadata.IIOMetadataNode(
                        "HorizontalPixelSize");
                    dim.
                      appendChild(
                        child);
                }
                child.
                  setAttribute(
                    "value",
                    java.lang.Double.
                      toString(
                        params.
                          getResolution(
                            ).
                          doubleValue(
                            ) /
                          25.4));
                child =
                  getChildNode(
                    dim,
                    "VerticalPixelSize");
                if (child ==
                      null) {
                    child =
                      new javax.imageio.metadata.IIOMetadataNode(
                        "VerticalPixelSize");
                    dim.
                      appendChild(
                        child);
                }
                child.
                  setAttribute(
                    "value",
                    java.lang.Double.
                      toString(
                        params.
                          getResolution(
                            ).
                          doubleValue(
                            ) /
                          25.4));
            }
            try {
                meta.
                  mergeTree(
                    stdmeta,
                    root);
            }
            catch (javax.imageio.metadata.IIOInvalidTreeException e) {
                throw new java.lang.RuntimeException(
                  "Cannot update image metadata: " +
                  e.
                    getMessage(
                      ));
            }
        }
        return meta;
    }
    protected static javax.imageio.metadata.IIOMetadataNode getChildNode(org.w3c.dom.Node n,
                                                                         java.lang.String name) {
        org.w3c.dom.NodeList nodes =
          n.
          getChildNodes(
            );
        for (int i =
               0;
             i <
               nodes.
               getLength(
                 );
             i++) {
            org.w3c.dom.Node child =
              nodes.
              item(
                i);
            if (name.
                  equals(
                    child.
                      getNodeName(
                        ))) {
                return (javax.imageio.metadata.IIOMetadataNode)
                         child;
            }
        }
        return null;
    }
    public java.lang.String getMIMEType() {
        return this.
                 targetMIME;
    }
    public void warningOccurred(javax.imageio.ImageWriter source,
                                int imageIndex,
                                java.lang.String warning) {
        java.lang.System.
          err.
          println(
            "Problem while writing image using ImageI/O: " +
            warning);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456836489000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "KbzQiVLVxgnkjk0TXexN/y8rsOHJpyAAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456836489000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "6I1wd92s1ZsyurbJ7Y5yhcXIx2ZiL7Hao7qGNMdLdrvgFMJsgDVqEhkNk2Ep" +
       "cmsPpQ0iDCMVxhPEUwS1Oq0p7XVYsdOgkdR4cTvtGIbGLeY7iurS69ZyRlSo" +
       "lB2Y1mC4YF2CmvRjucZEXU+QcwNrjOsSN/fW89iWB0QV84nlLm7C60qb76+Y" +
       "BLPT+brDzGfm2HTMHBnV/GTeF9KYFmZrG40cbYCQNLoRp26/gg2oBdM2F9Mg" +
       "ibDY5bQIdMerUaUu+2y9xSrieuHASYNgwzrI4ea01evYhpTPjFEL5XjUjndE" +
       "qKsiZ+mxg4O6GuU7ONFbKN3GBFttQtVuk2mwrEstvZ2jjiX4lF4HsYSvCLMb" +
       "0WRMSwOiP5qOyIHeE8hh30IQeMDW3JkzxyixysqDJWewttGezgnfUBl6kPfh" +
       "cS2itvUhPF7i0XhZ1deZ4E8aS9NdqZFdGVeaEzLo9jvTejZNgl7bkF1jMYjc" +
       "BtIasuGqpaWt1bAZTQdWrZHpfcni/VlXlCZSxWetatCqGll/itdbHfDHrRrp" +
       "yCyesOOElkgm1WUZczN9zbtEuMDcmbHZBsOl3GoQugjji1mTteGWadq1ZDfx" +
       "xwsqmphTDsNNll0YqGaqQSZZlkR02bi7HlpZ5g+0Gm5PJnJGcIyLTqtNTfI7" +
       "U9WmEI6YCH18FksoOavWc86a9vAVppNRvJwzCDYLqtguD+3qzu9WVvx63Ftv" +
       "xk2YXk77bDO0XAsntc5wDdYkmsF6WLe/mYmCOoupmcEHzGI3sqdDsGL6zsqp" +
       "SDMj55AtHid8fxBui02AD3yg2B4wXt0OzWPlxtPZmenfYctp/+iZonnn2fZe" +
       "+Xnw8jnb+S32w/bq0en29PErnCcloX187vjolA0uz7POzpmMteGnxzTNl1Sy" +
       "Gvu2vyz2yIutv2Jj56m7nbqWmzqf/9gLL+r8z1aPTnbAP5RCD6dB+H0ukOue" +
       "0/oqkPTeu29gseWh82Fn9ssf++9PSh+0PvQqDqLedknPyyL/BfuF3+m9S/sn" +
       "R9B9Z/u0tx2HX2R67uLu7LXYSLPYly7s0T518TCIANcHTybxg3c+DLrzBm0Z" +
       "cPswu3TAcHRx2t9a7j4epnls+LoRG3o51adE+zNCML18loZZKqaxoXql9B++" +
       "JP3SmccbThlpnsw1IyycXvL9SNHsUujapoiTw2A/eC7gb6XQ/evA1g+Z8OFX" +
       "2qM7f4hQdmwu+vOd4KJO/El+d/x53yHDP1I0Hzu1HXt1CbUPv3KIF+7s1OLn" +
       "j5YEny2an7jgvaLnxw6e+tRr8FRxMACh4Proiac++mo8BTI2jIPU0FJDv5fD" +
       "Tt30PRcB5JxHzlz6mVLOz9zjpOzniuZzIFCXRto1TDVz01LGIafBSE/dbaQD" +
       "Vem7F1+D754sOt8Nrk+f+O7TrzbKfvo7ydpnL5riGamqq6laAC97cn9w3L+8" +
       "h+N+tWi+mEKPZqAqSY3zzL988MhLr8EjRcqV50u/duKRX3sVHjkqPVI0/Hfi" +
       "lhtFym1q2rEeeMdcoJdZUSk5f/MeTvitovmNFHoERE/Hsl29YD2V+a5XdvUZ" +
       "eemsL70GZz1edBZvAHz5xFlf/u6A1Hlrv3qPZ/+xaL6SQq87OZk7XZwqB/P+" +
       "3WvFYBhc//7EvN/77ph3DoM/f6dl5D7bTw+h8Ef3cMCfFs0fpND1zb504TUt" +
       "i8FyeAle//DVOCFPocdvf/+meJngidteFNy/3KZ98cXrD73lxcl/Ll9BOXsB" +
       "7eEh9JCZue75I95z9w+GsWHapRkP7w98w/Lrz1Lofa/mZaEUunpyV5ry9b2U" +
       "v0ihm9+JlBR6oPw+z/s/Uujpe/MCLvusCDjh+p8p9MTduMCcgvY89V8B9L8T" +
       "NaAE7XnKvzkBivOUYPzy+zzdt8ACe6BLoQf3N+dJ/hZIByTF7bfDMxQ6HOju" +
       "T/LzK+dK15OkKMPo8VcKozOW82/gFC4oX0Q9LU2z/auot7SXXhxwH/5m42f3" +
       "bwBprrrbFVIeGkJX9y8jnZW3z9xV2qmsB/vv+dajv/jwO09L8Uf3Ch8S9Jxu" +
       "b7vz6zakF6blCzK7f/WWX37/z734x+WJ");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      "9v8DVH0JnCEsAAA=";
}
