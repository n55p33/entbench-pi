package org.apache.batik.apps.svgpp;
public class Main {
    public static void main(java.lang.String[] args) { new org.apache.batik.apps.svgpp.Main(
                                                         args).
                                                         run(
                                                           ); }
    public static final java.lang.String BUNDLE_CLASSNAME = "org.apache.batik.apps.svgpp.resources.Messages";
    protected static org.apache.batik.i18n.LocalizableSupport localizableSupport =
      new org.apache.batik.i18n.LocalizableSupport(
      BUNDLE_CLASSNAME,
      org.apache.batik.apps.svgpp.Main.class.
        getClassLoader(
          ));
    protected java.lang.String[] arguments;
    protected int index;
    protected java.util.Map handlers = new java.util.HashMap(
      );
    { handlers.put("-doctype", new org.apache.batik.apps.svgpp.Main.DoctypeHandler(
                     ));
      handlers.put("-doc-width", new org.apache.batik.apps.svgpp.Main.DocWidthHandler(
                     ));
      handlers.put("-newline", new org.apache.batik.apps.svgpp.Main.NewlineHandler(
                     ));
      handlers.put("-public-id", new org.apache.batik.apps.svgpp.Main.PublicIdHandler(
                     ));
      handlers.put("-no-format", new org.apache.batik.apps.svgpp.Main.NoFormatHandler(
                     ));
      handlers.put("-system-id", new org.apache.batik.apps.svgpp.Main.SystemIdHandler(
                     ));
      handlers.put("-tab-width", new org.apache.batik.apps.svgpp.Main.TabWidthHandler(
                     ));
      handlers.put("-xml-decl", new org.apache.batik.apps.svgpp.Main.XMLDeclHandler(
                     )); }
    protected org.apache.batik.transcoder.Transcoder
      transcoder =
      new org.apache.batik.transcoder.svg2svg.SVGTranscoder(
      );
    public Main(java.lang.String[] args) {
        super(
          );
        arguments =
          args;
    }
    public void run() { if (arguments.length ==
                              0) { printUsage(
                                     );
                                   return;
                        }
                        try { for (; ; ) {
                                  org.apache.batik.apps.svgpp.Main.OptionHandler oh =
                                    (org.apache.batik.apps.svgpp.Main.OptionHandler)
                                      handlers.
                                      get(
                                        arguments[index]);
                                  if (oh ==
                                        null) {
                                      break;
                                  }
                                  oh.
                                    handleOption(
                                      );
                              }
                              org.apache.batik.transcoder.TranscoderInput in;
                              in = new org.apache.batik.transcoder.TranscoderInput(
                                     new java.io.FileReader(
                                       arguments[index++]));
                              org.apache.batik.transcoder.TranscoderOutput out;
                              if (index <
                                    arguments.
                                      length) {
                                  out =
                                    new org.apache.batik.transcoder.TranscoderOutput(
                                      new java.io.FileWriter(
                                        arguments[index]));
                              }
                              else {
                                  out =
                                    new org.apache.batik.transcoder.TranscoderOutput(
                                      new java.io.OutputStreamWriter(
                                        java.lang.System.
                                          out));
                              }
                              transcoder.
                                transcode(
                                  in,
                                  out); }
                        catch (java.lang.Exception e) {
                            e.
                              printStackTrace(
                                );
                            printUsage(
                              );
                        } }
    protected void printUsage() { printHeader(
                                    );
                                  java.lang.System.
                                    out.println(
                                          localizableSupport.
                                            formatMessage(
                                              "syntax",
                                              null));
                                  java.lang.System.
                                    out.println(
                                          );
                                  java.lang.System.
                                    out.println(
                                          localizableSupport.
                                            formatMessage(
                                              "options",
                                              null));
                                  java.util.Iterator it =
                                    handlers.
                                    keySet(
                                      ).
                                    iterator(
                                      );
                                  while (it.
                                           hasNext(
                                             )) {
                                      java.lang.String s =
                                        (java.lang.String)
                                          it.
                                          next(
                                            );
                                      java.lang.System.
                                        out.
                                        println(
                                          ((org.apache.batik.apps.svgpp.Main.OptionHandler)
                                             handlers.
                                             get(
                                               s)).
                                            getDescription(
                                              ));
                                  } }
    protected void printHeader() { java.lang.System.
                                     out.
                                     println(
                                       localizableSupport.
                                         formatMessage(
                                           "header",
                                           null));
    }
    protected static interface OptionHandler {
        void handleOption();
        java.lang.String getDescription();
        java.lang.String jlc$CompilerVersion$jl7 =
          "2.7.0";
        long jlc$SourceLastModified$jl7 =
          1471109864000L;
        java.lang.String jlc$ClassType$jl7 =
          ("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");
        java.lang.String jlc$CompilerVersion$jl5 =
          "2.7.0";
        long jlc$SourceLastModified$jl5 =
          1471109864000L;
        java.lang.String jlc$ClassType$jl5 =
          ("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" +
           "zmfgEnirWktm9Jpo2N6VDNxzpGF792bg");
        java.lang.String jlc$ClassType$jl5$1 =
          ("vtdIw/Z2etHMF3v9LQfsXcwHPHwHJ+S9BzPwUAYe2W3qjhn02GkGPZqBN72W" +
           "qra/21EzA5/Ll701Lw9Zde2OVerJDDydgWdeQ34VTvMro2TvrUkEve7Upc8j" +
           "43nile6KgsPWG264br69Ii3/8gtXLj3ywuj38wzR8TXmu/vQJS227ZP3GU88" +
           "X/QDVTNzLty9TQrlb9B7xQh6422IicDJPvvOCN+Dt1PK4JR60ynAQrOvk2Or" +
           "4O367FiAM/8+Oa4RQZd340DY3T6cHPJ2cFoBQ7LHH8puWd7iuPfAK8nvRKLy" +
           "6Vu+49Dx9v8ArsuffKE7+NFvVl/cXtMEZ840zbCAl4i7tum3HGmWynryltiO" +
           "cF0k3/Lyfb9y9zNHqc/7tgTvTOkEbW++eWKs7fhRnspK//Uj//Lt//SFL+dX" +
           "Bf8/03euUJ4xAAA=");
    }
    protected class DoctypeHandler implements org.apache.batik.apps.svgpp.Main.OptionHandler {
        protected final java.util.Map values =
          new java.util.HashMap(
          6);
        { values.put("remove", org.apache.batik.transcoder.svg2svg.SVGTranscoder.
                                 VALUE_DOCTYPE_REMOVE);
          values.put("change", org.apache.batik.transcoder.svg2svg.SVGTranscoder.
                                 VALUE_DOCTYPE_CHANGE);
        }
        public void handleOption() { index++;
                                     if (index >=
                                           arguments.
                                             length) {
                                         throw new java.lang.IllegalArgumentException(
                                           );
                                     }
                                     java.lang.Object val =
                                       values.
                                       get(
                                         arguments[index++]);
                                     if (val ==
                                           null) {
                                         throw new java.lang.IllegalArgumentException(
                                           );
                                     }
                                     transcoder.
                                       addTranscodingHint(
                                         org.apache.batik.transcoder.svg2svg.SVGTranscoder.
                                           KEY_DOCTYPE,
                                         val);
        }
        public java.lang.String getDescription() {
            return localizableSupport.
              formatMessage(
                "doctype.description",
                null);
        }
        public DoctypeHandler() { super();
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "+DFvIcg7+ejz/JU1v/gPzbqu0p4aAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "7kXf/oN8/mG6Z7PvT67EY1CSHc4tf9b58c7DZ/90B7pRgC7Ie/UeJ9pxlkQC" +
           "qHHC/SIQ1ITHxo/XK9vN+dIBnL3uJNQcWfYk0BzuA+A5o86ez53AlnsyK1fA" +
           "59k9bHn2JLacgvKHR/MpD+Xtxaz52dwnOxF0sx94EZBSBTXaGc10RTtf4xGQ" +
           "5KtMoxC47aFruG0krvNK6LL8B8PvfvOp9Llnt4kqiWCrhwrXKqqvrOszDH/D" +
           "dfahw3Lrx8TPvfD9f+DesbOXWq86bovXXs8WOemdEXTrYciDcM866S0EZy2S" +
           "Na0tbe2aQX4pt1FyCmDhmfJufbeY/R5c3cg3ZI9vAvYM89I9+9XZt/Hdli1f" +
           "3MdIDtTxIMQvWnZ9X9QLuahZMO1ui98Tgj7yPxYUuPG2Q2a0B+roj/zjx77x" +
           "0dd/B/iMgs7kzgZuOLIiG2evFh989sn7XvXEdz+SbwAA/bkPvHTvoxlX4Xrq" +
           "Zs3kmKr3ZqqO8wKKFsOIyXFaVXJtr4sMg8B0wNa22qub4cfu+M7iU9/7/LYm" +
           "PgkDJ4jVDz/xqz/dffyJnSNvIq+/4mXg6Jzt20gu9K17Fj6aAFdZJZ+B/9Nz" +
           "j/3hbz32oa1UdxyvqzvgtfHzf/mf39j95He/dpUi77Tt/S8cG91mdysh2dr/" +
           "ozkem62nSTJT+3BTJ+ACZsn9QWvODAnVUMQOMxF9krBaRUcoJCa/dLtpSiBs" +
           "QZFWtFqvM3XBSAbjds9BYRPvoSLOhfiEWo4XFVJciNFs0VNG09Kg6IsmPyxP" +
           "RGZYwodLkffGODqLxtGqmMqpWpcLChgr264QD7SVk8pJHYFXqlN1KubCZ1rp" +
           "dGIPJX/gl/n1sMY1HRqjBni5LawcNjbpsd6YV4bN8lxxNonX7JE1vWbKpRgV" +
           "4sV0I/QQcqO3JWo5XSa9hE3QMbVha9iMHPNrY0JwrCW2iLKa9Gq8F26kkWQm" +
           "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" +
           "JAAA");
    }
    protected class NewlineHandler implements org.apache.batik.apps.svgpp.Main.OptionHandler {
        protected final java.util.Map values =
          new java.util.HashMap(
          6);
        { values.put("cr", org.apache.batik.transcoder.svg2svg.SVGTranscoder.
                             VALUE_NEWLINE_CR);
          values.put("cr-lf", org.apache.batik.transcoder.svg2svg.SVGTranscoder.
                                VALUE_NEWLINE_CR_LF);
          values.put("lf", org.apache.batik.transcoder.svg2svg.SVGTranscoder.
                             VALUE_NEWLINE_LF);
        }
        public void handleOption() { index++;
                                     if (index >=
                                           arguments.
                                             length) {
                                         throw new java.lang.IllegalArgumentException(
                                           );
                                     }
                                     java.lang.Object val =
                                       values.
                                       get(
                                         arguments[index++]);
                                     if (val ==
                                           null) {
                                         throw new java.lang.IllegalArgumentException(
                                           );
                                     }
                                     transcoder.
                                       addTranscodingHint(
                                         org.apache.batik.transcoder.svg2svg.SVGTranscoder.
                                           KEY_NEWLINE,
                                         val);
        }
        public java.lang.String getDescription() {
            return localizableSupport.
              formatMessage(
                "newline.description",
                null);
        }
        public NewlineHandler() { super();
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "88CPeQtB3slHn+GvrPnVfwANP7R6nhoAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "8oPn/wY/r+AYKyQAAA==");
    }
    protected class NoFormatHandler implements org.apache.batik.apps.svgpp.Main.OptionHandler {
        public void handleOption() { index++;
                                     transcoder.
                                       addTranscodingHint(
                                         org.apache.batik.transcoder.svg2svg.SVGTranscoder.
                                           KEY_FORMAT,
                                         java.lang.Boolean.
                                           FALSE);
        }
        public java.lang.String getDescription() {
            return localizableSupport.
              formatMessage(
                "no-format.description",
                null);
        }
        public NoFormatHandler() { super(
                                     ); }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAALU5eezkVnne32Y3u0uyuwkkpIHcC20w+nnuQ0toZjyewzO+" +
           "PZ4Zl7Lx+J7xNb7GY5oWUGlQkSAqgQYJ8heoLQqHqqJWqqhSVS0gUCUq1Esq" +
           "R1VRWopE/iitmrb02fO794iitiP5+c173/e97/b33nvxR9CZwIdgz7U2uuWG" +
           "u2oS7i6s6m648dRgFx9VackPVAW1pCDgwdg1+dEvXvrJK88al3egsyL0eslx" +
           "3FAKTdcJWDVwrVhVRtClw1HMUu0ghC6PFlIsIVFoWsjIDMKrI+h1R1BD6Mpo" +
           "nwUEsIAAFpCcBaR1CAWQ7lSdyEYzDMkJgxX0y9CpEXTWkzP2QuiR40Q8yZfs" +
           "PTJ0LgGgcC77LwChcuTEhx4+kH0r83UCfwxGnvvNd1/+3dPQJRG6ZDpcxo4M" +
           "mAjBIiJ0h63ac9UPWoqiKiJ0l6OqCqf6pmSZac63CN0dmLojhZGvHigpG4w8" +
           "1c/XPNTcHXImmx/JoesfiKeZqqXs/zujWZIOZL33UNathN1sHAh4wQSM+Zok" +
           "q/soty1NRwmhh05iHMh4ZQgAAOrtthoa7sFStzkSGIDu3trOkhwd4ULfdHQA" +
           "esaNwCohdP9NiWa69iR5KenqtRC67yQcvZ0CUOdzRWQoIXTPSbCcErDS/Ses" +
           "dMQ+PyLf8eH3OH1nJ+dZUWUr4/8cQHrwBBKraqqvOrK6RbzjbaOPS/d++YM7" +
           "EASA7zkBvIX5/V96+cm3P/jSV7cwb7oBDDVfqHJ4Tf70/OI334w+3jydsXHO" +
           "cwMzM/4xyXP3p/dmriYeiLx7Dyhmk7v7ky+xfzZ772fVH+5AFwbQWdm1Ihv4" +
           "0V2ya3umpfo91VF9KVSVAXRedRQ0nx9At4P+yHTU7SilaYEaDqDbrHzorJv/" +
           "ByrSAIlMRbeDvulo7n7fk0Ij7yceBEEXwQO9Azzfhba//B1CHGK4topIsuSY" +
           "jovQvpvJHyCqE86Bbg1kDrx+iQRu5AMXRFxfRyTgB4a6NyF5XoAEse55CCGZ" +
           "zm7mXN7/D9kkk+by+tQpoOg3nwxzC0RI37UU1b8mPxe1sZc/f+3rOwduv6eH" +
           "ECqAlXa3K+3mK+1mK+3mK+1mK10h3a7r21LYlxwF2AY6dSpf8A0ZB1urApss" +
           "QXSDvHfH49wv4k998NHTwJ289W1AoRkocvP0ix7mg0Ge9WTglNBLz6/fJ/xK" +
           "YQfaOZ5HM67B0IUMnc6y30GWu3Iyfm5E99IzP/jJFz7+tHsYSccS816AX4+Z" +
           "BeijJ/Xru7KqgJR3SP5tD0tfuvblp6/sQLeBqAeZLgTqy5LIgyfXOBaoV/eT" +
           "XibLGSCwlqnbyqb2M9WF0PDd9eFIbviLef8uoOMnoL3mmCtns6/3svYNW0fJ" +
           "jHZCijypPsF5n/rrP/+ncq7u/fx76cgXjVPDq0diPiN2KY/uuw59gPdVFcD9" +
           "3fP0Rz/2o2d+IXcAAPHYjRa8krUoiHVgQqDmD3x19Tff+fanv7Vz6DQh+OhF" +
           "c8uUk62QPwW/U+D57+zJhMsGtvF6N7qXNB4+yBpetvJbD3kD+cMCwZZ50JWx" +
           "Y7uKqZnS3FIzj/3PS28pfulfPnx56xMWGNl3qbe/OoHD8Z9pQ+/9+rv/7cGc" +
           "zCk5+34d6u8QbJsUX39IueX70ibjI3nfXzzwia9InwLpFaS0wEzVPEtBuT6g" +
           "3ICFXBdw3iIn5kpZ81BwNBCOx9qROuOa/Oy3fnyn8OM/ejnn9nihctTuhORd" +
           "3bpa1jycAPJvPBn1fSkwAFzlJfJdl62XXgEURUBRBjksoHyQfJJjXrIHfeb2" +
           "v/3jP7n3qW+ehna60AXLlZSulAccdB54uhoYIG8l3s8/ufXm9TnQXM5Fha4T" +
           "fusg9+X/TgMGH795rulmdcZhuN73H5Q1f//f//t1SsizzA0+ryfwReTFT96P" +
           "vvOHOf5huGfYDybXJ2RQkx3ilj5r/+vOo2f/dAe6XYQuy3sFnyBZURZEIihy" +
           "gv0qEBSFx+aPFyzbr/PVg3T25pOp5siyJxPN4YcA9DPorH/h0OCPJ6dAIJ4p" +
           "7dZ3C9n/J3PER/L2Stb87FbrWffnQMQGeeEIMDTTkayczuMh8BhLvrIfowIo" +
           "JIGKryysek7mHlA6596RCbO7rb62uSpry1su8n7tpt5wdZ9XYP2Lh8RGLijk" +
           "PvQPz37jI499B5gIh87EmfqAZY6sSEZZbftrL37sgdc9990P5QkIZB/hV1+5" +
           "/8mM6vBWEmdNJ2uwfVHvz0Tl8i/4SApCIs8TqpJLe0vPpH3TBqk13ivckKfv" +
           "/s7ykz/43LYoO+mGJ4DVDz736z/d/fBzO0dK4ceuq0aP4mzL4ZzpO/c07EOP" +
           "3GqVHKP7j194+g9/++lntlzdfbyww8C+5XN/+V/f2H3+u1+7QZVxm+X+Lwwb" +
           "3vFUvxIMWvu/kTBTS2s5YW2NqjeUUkmumyJtV3iTwhpLIx6H44KLB8NRdzGr" +
           "aClT7g2KrXhJhLV51Awr87KaUiVV6wtrHVv6+mJjDDsSR0/ocsfs1FrucOX6" +
           "wooZ1hjUXRWwheJzpo6uWJLsC0N82BzABU9plIOyWg9htb/qeiOqrqqwKtZT" +
           "GKmLHlxnOC8w68zGmWnVkHACGUcotmZZQYGLWbtcR4kUfAS1UY2E6WkCw0RB" +
           "X81qjMGrBcNQVsG0JEhrt8b6khfJNddP21V7NMDqrFm0iVLEyeGUmZW4pqQ3" +
           "bR4rCkKnusTbOtcfChOrw7KpWSzSRCy6BNVa1opsAWVMcrCUG2izzI5tZeYt" +
           "+FFs9TplOxbXY4+oVQK7Svdq2LLGcaTo2yt21fNT30u68wVBzvmV1eNTQl4k" +
           "jXEYxxHVZpQ+jKNNT+v0i41aYVgbzw19pAhFfR2ndYImSJ/FLdfklp147tV7" +
           "hDbzGrbIdjesSxOcrBTmKYO2TFIn0UbIVQSpi9DN3sYuJh270dk4nEW2DX4h" +
           "ToMU89pzkuolPUOut1zRrYduTM56xfla8DxxZuN8szKxp3FNpejyZqm77HK4" +
           "ot35ajhsYe0NlsjoYrTo0CPaaw8CjCNIasnUO117JbC8WE0GZDNccSugHrhP" +
           "R+uxE2yk1MDSqZC0+wFRHg7DzRqNZhY7HlSR4nhJii46KYbypDbpIrxOt0Np" +
           "5eKm4OHtcurNN6gg0PJoRMY1Up81lCbTas9X6ZDwKiV01R8qa531LBBhY74g" +
           "9Gb0uFAkWxO722pZK3neXU2GGrA84WL8HKuIK46eW0zUEiak3GKjyoRrOoVk" +
           "rZtG2FhOcazamK+bZYeHg47qtTCGkrFxyo+1dTGQYiGkgg2X9vB1J+J7UVhm" +
           "vdJitIFV1Gh1EtWAE4922kyqxSWFqsGj1bI0X2OpvKhw0nwdjQbrctyZWGGd" +
           "ohohs5j4fNAdE5rXtyoeR1JmqFAswXiraQtjtQ4sT7vrFKkXTFqbTRv4MvTa" +
           "49VyNlnMOqrCLXttiy+KRnHUpESWt0YdfCB5plJLNBcEwKi8GropxUccT66I" +
           "ThXf8ONE6EU4IncxbjJER1LUVYoi2UPC0pJGy6q8mRlAZLWgl2m4wMOm0KQS" +
           "E/cGDcIUhr3ayojYsRy2YLgwGBCVCtyZKb2ZGjiVxYwNJbQ7WM8E00MHDMKl" +
           "XVv3bKtfJ+yxNJZ6q+GqT8wdAlkj8353lSqmy7QwJW6wzbQzrg/0IWbZbWFa" +
           "9QdNjVc0c9TwxusFX46xDl4O22PLGKJ6iM9EZgxSBDocWosSpZf9Vmq1iizN" +
           "9JLBAG1h/pIgxS5j4Aa5jvSuWkv9fn+RFCpWUu9JHE8JY6qznHLN1WBTgEOU" +
           "adfKlcZKqMYrsa5opZh1l1Whz/Htieqx3mTBkBM0bg/sKUrNyUKli6Lljs9W" +
           "a3prQhAhM2nhujSyapU+6pGmJBoaJfs0ud50ZY8ewGx1EmPLeMUn45BfJNWm" +
           "2oOZ9iAy+gVh0ur5RtPCsHprsFYQk0a6eIMpqbFWTq2V4HRoLemGHKu1lmHJ" +
           "1csh4vHraKNG9V5tMWoImhMVmPmq0ZapGSPLXFPwYWJgp94mIgola0C2QcnP" +
           "pKy8iaMKCIVw1lgp2NyRDIKs2XNpxiwq3bbMa+REVJGoECMIU63IVoNkjOom" +
           "1meVYkFtY7idMrhvhxuC7g2StsPHU8NvbjyinBoVvsboY6o640qDLgiEFs22" +
           "5AZMLnyvWa3Wmz5alND52kvHNj5vV+abDYvVZgFc4eFW3GqUmg2sY6wZHR/I" +
           "NeBNdqHb65AsjFanNNMqdOaGoTm87BcIe7W0hYUdEItmC2HSuBxr/LRRKWwq" +
           "hk9U26Sdwi5Rph26ibf75UUKL4rzNr5q68xUUGo4jlvdui8vqvpkykhNWW/C" +
           "8Xzi16u90ZpWW425VNPXfIDZGFcxB5Vp3TDrRTMmS+WmPpaV0FdBWoU5sd7D" +
           "a1U5oj0WUXr01F96IVqOnNHG6Ndw2yqslz1mzCiGkhjmYJY0xxOsIZOU0jb0" +
           "BPbbK1Np21J5tK4ghaEelvVhQrCo36JH0iARW+Kq4tpJujJXvoZovGAZZGyJ" +
           "XZ2uOUIH910PHhFL1hsotuS0JsW0amjxcuoRgkwzQzppc4tkTLhdtjQSCxod" +
           "bHBDBl91xzCiZplOQ4SfcPZwagXNxUjGZZHq0/NBSkynKTwbpsaw0OSCyqZB" +
           "pAOyUpYNXA3HQ8Iemt44QZhyMZrWSiKG18W1aFdgQhsRdGilZFspo/0y0+og" +
           "SK2MNOl+6iG8Ohl2VYFfaKuaYWHqeNwVl0ZB5eqDWAnXDaaB1JaLoob7ku5Q" +
           "4arI0Ei/MZ+M2nVY8A0BnhSJMqIqIHk1BxY95qQSPE09EXFCF+z2o746lReY" +
           "O7E8cTD2pIqKk1OhFusWOmJUOHKry8p406RKgypacJk12/QNWG7jto408EJq" +
           "wspARFEsDWByjZa5FGvBPWkET2Z1HfUJdjLpBy0j7VK1cGBiJWHCOGLBdzpa" +
           "0GQIAe/iXomi0o6EkEiPrDWQUUpzZWANU7HrkTlG0CqsLK3ArW8GNU6qtMuL" +
           "+qaPdgtzmVksJooNLw0ucRGYFkoiggzLYlDo99M4qAzFRkHo23TEUP1Bc1gt" +
           "aw2rGbWxxcax2bXHSkGv2HF0WBmOChXGMxK460ozdFqqeyhGj4ViwNqWSPW6" +
           "FNG3peJsZS0rdKs9XjADpMFWplYsg5DGHCSRqc0SSxqLKfiOdMNVCVu2+95i" +
           "MxbkqVETurDYKbKxXUeAgoYa2pYa1BKVxCLP04w2VktLn58tLSEaCpS1ZHmk" +
           "k2IbdSZYVG/JxOthMkZGIwbpxFMeH4ltB6Yoi2ZIUC4SKI/0fW8aEcviatpZ" +
           "tluxY+Cp0+XaJl+BfbPKgnye8MR0OCymSkMvyd6E6fpiBU6rWIvuK/gAtiea" +
           "Y7V7Fb1RUXt8E2kgHWpTLzIFakEs6iEoK8xJvbQemPMiPJlUq9PquOP4s9lU" +
           "Ks9tvpSwZTgWeI6ZuEPWxTpaNVqgdbeJEvGcZhDZjVNrAncEI120GBcvRbQ6" +
           "r0oc1mwPq2p37OhBzRA7aVkuF9hqSZlWQziqNDdzpDn1GYYl61RoJnS/qEZ0" +
           "HOv+phpNB62SHICilGmtZ/5ythKmod6kazNJJCaLLuc3vSYlgGJkaIx7G16Y" +
           "CIWmNZl0TM7w1t2NrbaH3WmSlIuGYjfGI5SbBp7oiWql1lFsG58sqn0Bq+E9" +
           "RhMKYsWFaxQ3moSzgsbGsj0euMXqVOpbMkUb9dpmNrXBB7uyKExtlbSmJcVJ" +
           "mKBf0CIyGdb0ToM1nA3NVhRCLzSqKhZEjRqOdPylPncoxgkUe8aqazxqpXJc" +
           "6hYmfmo0GimywacsGhtjsKF44olsq/Gu17bbuyvf2B7cMYBNXjbRew27nOTG" +
           "C4JN93nPd0OwsVeV5OCULz/vuPMWp3xHTkJO7e+ud1/1eJfyskOPvcPdbCf4" +
           "wM2uIvJd4Kff/9wLCvWZ4s7ewdMEbPz3bogOl98BZN528+0ukV/DHJ6GfOX9" +
           "/3w//07jqddw3vvQCSZPkvwd4sWv9d4q/8YOdPrgbOS6C6LjSFePn4hc8NUw" +
           "8h3+2LnIAwfWuJQp/1HwfG/PGt+78ZnrjS2cu9TWkW5xqBffYi5vViF0h5Fb" +
           "bmvFHJI94nYC2HrHrqkc+qP/arvuowvlA86BzPdmg1fA8/09mb//fy/zB24x" +
           "90zWvDeELupq2FED2Te9/fPo3qGE73stEiYhdOnEBcd+6Dz8aqEDnPy+6y5X" +
           "txeC8udfuHTujS+M/yq/Czi4tDs/gs5pkWUdPXg70j/r+apm5qKe3x7Defnr" +
           "2RB60y2YCaEz+Ttn/CNblI+G0D03RAEOkb2Own48hC6fhAU08/dRuE+E0IVD" +
           "OBD3285RkE+G0GkAknU/5d3ghG97XJmcOpIr9rwsN93dr2a6A5SjNwtZfsnv" +
           "wvdzQbS9Db8mf+EFnHzPy7XPbG82ZEtK04zKuRF0+/aS5SCfPHJTavu0zvYf" +
           "f+XiF8+/ZT/xXdwyfOjxR3h76MZXB5jthflhf/oHb/y9d/zWC9/ODxz/ByaH" +
           "bdCkIAAA");
    }
    protected class PublicIdHandler implements org.apache.batik.apps.svgpp.Main.OptionHandler {
        public void handleOption() { index++;
                                     if (index >=
                                           arguments.
                                             length) {
                                         throw new java.lang.IllegalArgumentException(
                                           );
                                     }
                                     java.lang.String s =
                                       arguments[index++];
                                     transcoder.
                                       addTranscodingHint(
                                         org.apache.batik.transcoder.svg2svg.SVGTranscoder.
                                           KEY_PUBLIC_ID,
                                         s);
        }
        public java.lang.String getDescription() {
            return localizableSupport.
              formatMessage(
                "public-id.description",
                null);
        }
        public PublicIdHandler() { super(
                                     ); }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "EDV41U6RpMUvzRHYUDzxRLbVeNdr2+3dlW9sD+4YwCYvm2i/hl1OeuMFwab7" +
           "fBD6MdjY61p6cMqXn3fceYtTviMnIaf2d9e7r3q8ywXZocfe4W62E3zgZlcR" +
           "+S7w0+9/7gWN+wy6s3fwJIGN/94N0eHyO4DM226+3e3l1zCHpyFfef8/3y+8" +
           "03zqNZz3PnSCyZMkf6f34tfab1V/Ywc6fXA2ct0F0XGkq8dPRC6EepyEnnDs" +
           "XOSBA2tcypT/KHh+uGeNH974zPXGFs5dautItzjUW95iLm8WMXSHmVtua8Uc" +
           "cnjE7USw9V76lnboj+Gr7bqPLpQPeAcy35sNXgHPT/Zk/sn/vcwfuMXcM1nz" +
           "3hi6ONPjlh6poRXsn0e3DyV832uRMI2hSycuOPZD5+FXCx3g5Pddd7m6vRBU" +
           "P//CpXNvfGH0V/ldwMGl3XkGOmckjnP04O1I/2wQ6oaVi3p+ewwX5K9nY+hN" +
           "t2Amhs7k75zxj2xRPhpD99wQBThE9joK+/EYunwSFtDM30fhPhFDFw7hQNxv" +
           "O0dBPhlDpwFI1v1UcIMTvu1xZXrqSK7Y87LcdHe/mukOUI7eLGT5Jb8L388F" +
           "yfY2/Jr6hRdo9j0vVz+zvdlQHXmzyaicY6Dbt5csB/nkkZtS26d1tvP4Kxe/" +
           "eP4t+4nv4pbhQ48/wttDN746INwgzg/7N3/wxt97x2+98O38wPF/AEXU+6yk" +
           "IAAA");
    }
    protected class SystemIdHandler implements org.apache.batik.apps.svgpp.Main.OptionHandler {
        public void handleOption() { index++;
                                     if (index >=
                                           arguments.
                                             length) {
                                         throw new java.lang.IllegalArgumentException(
                                           );
                                     }
                                     java.lang.String s =
                                       arguments[index++];
                                     transcoder.
                                       addTranscodingHint(
                                         org.apache.batik.transcoder.svg2svg.SVGTranscoder.
                                           KEY_SYSTEM_ID,
                                         s);
        }
        public java.lang.String getDescription() {
            return localizableSupport.
              formatMessage(
                "system-id.description",
                null);
        }
        public SystemIdHandler() { super(
                                     ); }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "IAAA");
    }
    protected class XMLDeclHandler implements org.apache.batik.apps.svgpp.Main.OptionHandler {
        public void handleOption() { index++;
                                     if (index >=
                                           arguments.
                                             length) {
                                         throw new java.lang.IllegalArgumentException(
                                           );
                                     }
                                     java.lang.String s =
                                       arguments[index++];
                                     transcoder.
                                       addTranscodingHint(
                                         org.apache.batik.transcoder.svg2svg.SVGTranscoder.
                                           KEY_XML_DECLARATION,
                                         s);
        }
        public java.lang.String getDescription() {
            return localizableSupport.
              formatMessage(
                "xml-decl.description",
                null);
        }
        public XMLDeclHandler() { super();
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "qNy328UkJacdRZzOXURkOht3PTbM8mRjdVNEFPUptUYHOjaiYjuq6AWJRsp1" +
           "UY4mA1KxF+Q6oekGPdoUkrUmjaoLBt5YK21esBf9EuvVqmkvVa0IbU0dylPw" +
           "aQ1ZcugKEcql0WCCecJohjJRupiCUhObA6tPMv2e7BaxbkMYIZV5gxd4HVdi" +
           "pmvwS54OZ/VFvzgx1kSQ2upUEJuqXo/5Sau7UhRajVLVXES1AQ3XEEYmeos2" +
           "Tsq8V+4yA4lQmi3ORlq86onAkS6ARYQobnhY8iaDel3qFHSyQwdzPNCay6Te" +
           "aCNDgmXX+Ly6WsFwu4p4c8WsU+KsZ843crfsW+rcpNkYhxW8zAYR3OqFZXKC" +
           "r0EpN+sTvq6pph01MM9yGxzYwWzg1JY7LWLSGU4opzTsNqvqqsyhtRJc9Aor" +
           "jxOHRbOvGyldK3aFdWoVdHVdK6ZltRAoerGxWXhuGDQMPWlLFYIs8B0DaUYL" +
           "ko1qMuYW4PG43i41WBwNbR+vqj0VD0mNwZvlpV+LF9pCKCA0wyRoNDdkuQfw" +
           "eor1w0U7sDFnTdSKhTGqCihA4GGK4em4yo3bJEVSiZBQ+DBedIsoeLOKMYeg" +
           "TEq4Ssd1ym1uIUbtNjbzkprUrLU1cjZslmsjnMbbA0HHEUaaWR2hBCejiO1J" +
           "SED6PWzKb/gBVhzEFV2Z9dphOt200PlqQGOI0XG0QHWbqwKJT2XK8RoUEy8Z" +
           "oYLxHENr/bSwZNlSaGBi1ConSGVYDyydq6mddW9Tq3GMoJVROZXnYg8N7KLF" +
           "LNTuqM3OU6XnFX1lpKfTIqWzVQYO3HQK0qcjMF646TaxylLAfGZk093ysFAl" +
           "sBUczOGVyhcwNizNquq8Mi2n1dDmRoTeac45ckDoYUIUhxKMs2whJjEr4VG7" +
           "l3pyMG3DCdxI0mVYcoM6FSWVQIeFtFgVCp7uJMqEKSUFjGbrWNCkBawAj2r6" +
           "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" +
           "oiAAAA==");
    }
    protected class TabWidthHandler implements org.apache.batik.apps.svgpp.Main.OptionHandler {
        public void handleOption() { index++;
                                     if (index >=
                                           arguments.
                                             length) {
                                         throw new java.lang.IllegalArgumentException(
                                           );
                                     }
                                     transcoder.
                                       addTranscodingHint(
                                         org.apache.batik.transcoder.svg2svg.SVGTranscoder.
                                           KEY_TABULATION_WIDTH,
                                         new java.lang.Integer(
                                           arguments[index++]));
        }
        public java.lang.String getDescription() {
            return localizableSupport.
              formatMessage(
                "tab-width.description",
                null);
        }
        public TabWidthHandler() { super(
                                     ); }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "yQKzuxeGH2nRF27DsQk4VgHkdUZsgMxCWTS51DUrfvuT19uPv1NFwgOkQTep" +
           "OkBFzpF6CHbmZAFtC9bnH5CCTNXB0CLsQSosVDGBXti8uH/7cxYXHpn5wdrv" +
           "7X1h7rqITEvy2OBnuF2MPTjslJGLj58ulIwlaJuWMZaPZ0g8r+MkescKMWKh" +
           "pG59QHtvWqqbEZ3Y/JmLc+rI87tlz9FW3iH0QwN85Vf/+ln00u/fWqRc1brd" +
           "qCdnGM8rKzBDosvzQO795gt/+GFXZv8nqS0413GH6oH/N4MGO5auFUFR3jjz" +
           "5/Xj92ePf4IysTlgyyDLbw+9+NaD25ULYdHSygpR0QqXb+r1WxUOtRn07gaq" +
           "iTNNIsO2lYImgjHSCQHR7QZNdzDDJJ4vHoHgMiufglugF4WYGNh+LclwGVhJ" +
           "LLP2CA5jnDRmRSTKqITo6FnmvmdrOagik27HHDvd9sHEN25ckZEZbK8DxGz2" +
           "4pc/jp67KKNU3kG2VVwD/HvkPUTI2oJDFHNl63KniB0Df7x6+kffOn027Or5" +
           "ECfVk6Ym7zH34DAujbv3v8QenNhvifmRkpfacQ3wIRR1vRRdxu04HKl08FJb" +
           "l3Giscya2Kxx0pxh/ABzFFuzSskDQNUi8BPvcVF5j/MMdOJ/YaACFKNAM1w8" +
           "esudMBIcva7iIi4vj8pLc5G6tXMP/1rgU+mC1whIk87rui9R/Ulba9ksrQmz" +
           "NMqSaImfxzjZsIwwnNSIXyH4KbnlcbiXLroF4gx//LRnwMxBWuApfv10T3HS" +
           "4NEBCMgHP8ksJ1VAgo9PW4v4UF48C6HKOnePbCPv4NLSFn/fhwgg3psU0TQv" +
           "35zADWTu0PCpW599Xvadik5nZsQ9O05WyO62hMhbl+RW5FV7sOd288v13cWM" +
           "Let7/bKJwIIEEQ3i+kAX5nSVmrH35ve+9vPZ2ncBa46SEOVk1VHfWwtpKWjl" +
           "8lAKj8a9Yuh77ybaw96er03fvzP9t9+JFoLI29nGpemTyrUXHv3lhXXz0Eau" +
           "HCQ1AEaskCANmnNg2jjMlEk7QZo0p78AIgIXjeqDpC5vaCfzbFCNk2aMZYqZ" +
           "KOzimrOpNIsXEk46KzGz8hoH7dYUs/ebeUMVNQqqpzdT9kKnWNTylhXY4M2U" +
           "XLm6UvekcuDpyI/Pt1UNQD6WqeNnv8LJp0oF0/+Ox6ugLsSjnyHSk/Ehyype" +
           "EqquuBn4dUmD85yEdriziD0hr4GbE+wui0ccvvkfLbXfxb4VAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "S24n6qggAAA=");
    }
    protected class DocWidthHandler implements org.apache.batik.apps.svgpp.Main.OptionHandler {
        public void handleOption() { index++;
                                     if (index >=
                                           arguments.
                                             length) {
                                         throw new java.lang.IllegalArgumentException(
                                           );
                                     }
                                     transcoder.
                                       addTranscodingHint(
                                         org.apache.batik.transcoder.svg2svg.SVGTranscoder.
                                           KEY_DOCUMENT_WIDTH,
                                         new java.lang.Integer(
                                           arguments[index++]));
        }
        public java.lang.String getDescription() {
            return localizableSupport.
              formatMessage(
                "doc-width.description",
                null);
        }
        public DocWidthHandler() { super(
                                     ); }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "8X8ABLBtZaQgAAA=");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "/L9MNCgjAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALV6a/Dj1nUfdyWttKvHSrJlq4plrSzZlcT0D5AECdJrJwZA" +
       "gARA8AGQIAlXWYF4v0E8SBCOmsRtbTeZcT2NlLgzsaYfnKbNKHambabtdNJR" +
       "2mniNJlMnUmbttPETtOZ2nU9tT/YfTitewH+3/uQlLScwSVw77n3nnPuOb9z" +
       "cHFf/2blnjiqVMPA3RlukBxoWXJgu82DZBdq8QEzaI7lKNZUwpXjeArqbijv" +
       "++Wr3/3eZ8yHL1YuSZV3yL4fJHJiBX7Ma3HgbjR1ULl6Uku6mhcnlYcHtryR" +
       "oTSxXGhgxcn1QeX+U12TyrODIxYgwAIEWIBKFiDshAp0elDzU48oesh+Eq8r" +
       "f6lyYVC5FCoFe0nl6bODhHIke4fDjEsJwAj3Fc8iEKrsnEWVa8ey72W+SeBX" +
       "q9ArP/sjD/+9uypXpcpVyxcKdhTARAImkSoPeJq30qIYU1VNlSqP+JqmClpk" +
       "ya6Vl3xLlUdjy/DlJI20YyUVlWmoReWcJ5p7QClki1IlCaJj8XRLc9Wjp3t0" +
       "VzaArO86kXUvIVXUAwGvWICxSJcV7ajL3Y7lq0nlqfM9jmV8lgUEoOu9npaY" +
       "wfFUd/syqKg8ul87V/YNSEgiyzcA6T1BCmZJKk/cdtBC16GsOLKh3Ugqj5+n" +
       "G++bANXlUhFFl6Ty2HmyciSwSk+cW6VT6/PN4Yc+/TG/718seVY1xS34vw90" +
       "eu+5Tryma5HmK9q+4wMvDH5GftevfupipQKIHztHvKf5hz/67Y/84Hvf+NKe" +
       "5gduQTNa2ZqS3FA+v3roy+8hnu/cVbBxXxjEVrH4ZyQvzX982HI9C4Hnvet4" +
       "xKLx4KjxDf7Xlz/+i9o3Llau0JVLSuCmHrCjR5TACy1Xi3qar0Vyoql05bLm" +
       "q0TZTlfuBfcDy9f2tSNdj7WErtztllWXgvIZqEgHQxQquhfcW74eHN2HcmKW" +
       "91lYqVTuBVflAXA9V9n/yv+kIkBm4GmQrMi+5QfQOAoK+WNI85MV0K0JrYDV" +
       "O1AcpBEwQSiIDEgGdmBqhw1yGMZQvDHCEOJkyz8ojCv8/zNsVkjz8PbCBaDo" +
       "95x3cxd4SD9wVS26obyS4uS3v3Djty4em/2hHpLKNTDTwX6mg3Kmg2Kmg3Km" +
       "g2KmyoUL5QTvLGbcryJYAwd4M8C5B54XXmRe+tT77gLmE27vBgosSKHbwy1x" +
       "4v90iXIKMMLKG5/d/oT4Y/DFysWzuFlwCaquFN3HBdodo9qz5/3lVuNe/eTX" +
       "vvvFn3k5OPGcM0B86NA39ywc8n3n9RkFiqYCiDsZ/oVr8q/c+NWXn71YuRt4" +
       "OUC2BKirAI33np/jjGNePwK5QpZ7gMB6EHmyWzQdIdOVxIyC7UlNudAPlfeP" +
       "AB3fX1jqVXC9dGi65X/R+o6wKN+5N4xi0c5JUYLoh4Xwc//2d77eKNV9hLdX" +
       "T0UwQUuun/LxYrCrpTc/cmID00jTAN0ffHb8069+85MfLQ0AUDxzqwmfLUoC" +
       "+DZYQqDmv/ql9b/7yh9+/vcunhhNAoJcunItJTsWsqivXLmDkGC2D5zwAzDC" +
       "BQ5VWM2zM98LVEu35JWrFVb6J1ffX/uV//rph/d24IKaIzP6wTcf4KT+z+GV" +
       "H/+tH/nv7y2HuaAUMepEZydke+B7x8nIWBTJu4KP7Cd+98m/+Rvy5wCEAtiK" +
       "rVwrkejCseO8//aOUw6yx+zX/vYzv/Njrz3zR4APqXKfFYNoj0XGLYLIqT7f" +
       "ev0r3/jdB5/8Qmmrd6/kuESAK+ej783B9UzMLO3qgeMlemexIk8UvB8u0YU9" +
       "hN4gDnH82jGQf/DaOpVja50GifbcfqmvxWWicU23fNm9to+8H33xGjfqkjeG" +
       "GEcK1z58zde2hy0fk73Vyx89ODh48frzYbg3k8dA4lWquYjdB3u6suHgjFaf" +
       "v71WqUL4E49+/H+N3NXH/+P/KFf4JiC6RcQ911+CXv+5J4gf+kbZ/wQRit7v" +
       "zW7GaLBwJ33rv+h95+L7Lv2Li5V7pcrDymEOKMpuWviZBJYmPkoMQZ54pv1s" +
       "DrMP2NePEe8959Ho1LTnsegkNoD7grq0kj38FEUju1Apve/DZY+ny/LZovjz" +
       "pbovFrfPJWDQYlEPnfn74HcBXP+nuAoLKSr2lvLozZYSgqB0ydV8IzHvvHbj" +
       "yPIAPm0Osx3o5Ue/4vzc135pn8mcX6hzxNqnXvnJ7x98+pWLp/LHZ25K4U73" +
       "2eeQpSYeLAosA9w9fadZyh7Uf/7iy//k77z8yT1Xj57NhkiQ7P/Sv/nfv33w" +
       "2a/+5i1C813AGYuH+qG5F1Z9ca/mI/N/x4n5E27gawVgHbXtA7YVHBxn66Ax" +
       "u4V/vHB7HXOl858Y6W98/L88Mf0h86W3EamfOqej80P+Xe713+x9QPkbFyt3" +
       "HZvsTan82U7XzxrqlUgD7x7+9Iy5Prk311J/e1stiveXS1c+v3CsiUqpiUpJ" +
       "u7hDm1QUM2DcSqHq/crcgfzFbP8P3YHmRlE8FZ/OZ86uwanXwxvKZ37vWw+K" +
       "3/qn374Jns6Gb04Or5+47LXCUN99Pnnry7EJ6JA3hn/xYfeN75Wh5H5ZAbgf" +
       "jyKQM2Zngv0h9T33/vtf++fveunLd1UuUpUrbiCrlFzmTZXLIGHRYhOkm1n4" +
       "wx/ZB4PtfaB4uBS1cpPwezt8vHy6XN63j8PK4wVFB1ytw7DSPJ/eXAAJw8Gd" +
       "ElfAzD6RBuYWx+A9rBzcvDVo3XUIWpf2Aal4+kipPwzEF3w27A7IG8QAE4Qi" +
       "KhX1zX16VZQvFYW1l0a5reQnsj1W1A7B9aFD2a7fJNseYNe3AdikcjmMQBBV" +
       "AFQW1d4Rp4+6gXLk5UIahkGUHCHBczepyqq1/YPBTR3OyRW9dbkeKmqfBhd2" +
       "KBd2G7k+dmu5LhS36ZEsl+XISD3tcAukfo6tH32bbBX2RB2yRd2GrY+/Fbbu" +
       "AYCulQ+9cyz95bfJUhVc7CFL7G1Y+mtvhaX7TNlXQfyMz0SjsxjCy9tyO+GG" +
       "8o8nX/3y5/Ivvr4PNkUWmFSqt9uZunlzrHgvukOKemrP4ju9D77x9T8WX7x4" +
       "iHP3nxX/kTuJf2S1D57gD8CeovKnz2n9J9+m1j8ILulwWuk2Wv/Zt6L1K0kk" +
       "+7ESAKA84vYDN/nYCQ14WTq6PSfBZ99UgnLGEvDuqR+gB3Dx/LfuhGMlKJzB" +
       "sHfbrvLsUaIlApZByHjWdtFbQRn2lhkCBvfQSfYxCHzj+k/9p8/89l9/5ivA" +
       "upjKPZsiMwUGcypDH6bFTuInXn/1yftf+epPla9/QLPiX/neEx8pRv2FtyfW" +
       "E4VYQgnzAzlOuPKNTVMLycohuqfk6SfgvQ+w+KeWNnnkuT4S09jRbzCT5PpW" +
       "yRZ+CtGmnbXb7Z0yZFaENsFHCM3M8G3QtXuM0fSztsCEIoJJKNwYe9V2gm4k" +
       "f8VtQssZrwWekg0+3DobY7zlCZrHSWu7dmFKCMYYTzEqLkxoARa7O5k3cZ6l" +
       "2XpnnHiq19Y7W5P3msO66qFetS5XO5A+ROm+HXLbnSCMxTnNJ1zLEFsqvozq" +
       "vDwc9lIhlGuYsuw1uwkbctUUkk1fkqxZBvvDuMfXdk2GGmXzNbPeIp6sBlTI" +
       "wZ4YdFxiOQk6mkPZYp+RV8E8zDixtUtdllzHMdvqTHjK6KOMzVAta0pNe7Nt" +
       "Xvdmmy1ntXsUJjQlnqwjg2k0JXe8Kg9XAooMsA6S1pUeLY7Thbm01RWZwGtj" +
       "Np0OKVtZzixU9KaDAQcPxUQQRZ+UQtMRGmvCjUm5zkWKM510KDuhapA+cvM+" +
       "P8VF2BZURZfjjjoVamJPthhKVlG+GwpuxEIOzi49njXaW3oHZ1KHC1b4mpry" +
       "tXQhWMYmDNctUUDzxDVzJ3LNYEtyq8FkgximJw7YxVpewNttJHaJlYogXINA" +
       "acVKkbxHZSgKHMBO02iRts3htCfIdasjkE3O7OJLhkMIRvDwtRsmwkwY4qTf" +
       "4YMgRaqytZ6sEVT2erutu545cVcLGxnNduXlSNbJzkJc432Eq3E7eNuIq9uh" +
       "shztoOZsuBZpQWMaZtsKEJTjs+UAFzBlwNETP86dZdgXezBOjHMjM6W+m6Y4" +
       "hmO+JFgryh6v3PlamOJYLxCYNcPO7bGMt+YugxGN6XaCD3lvuVjgvLua2TuL" +
       "ERysbvHYytS4iThxUMcg6TnfmpHbjckE8kLChAzt9EcdKdHi1moJzxmrZ4xm" +
       "lEtp3gZbT3vYkGmNHH5I+IhBskpsq3CaL0xPahoTjEE0DF9uN5BdtZQNeHXN" +
       "4SAgJGereg0Nm7MRh2tqx8jnSV5vavGAJHeskaszt9scx62mCy1krgVL2G7A" +
       "2aMdO8LdjDGqiQ410WGekTYiMhKvhG5jVvMnNLoO9ZrL9oLaYEfIYDF6ZA12" +
       "FHcmoNO8KiA7Qg8y4CmWOmxMHFKUqJ0rVkWimW+qXYuWDILneUafiKuZ2agG" +
       "K9L0HWiZ4QQTU90wxnPKJCHIk51Bvo7DujlzLHEI63wQtRwbqi1ndIwYu/4S" +
       "GRnmfJyxtc5gwjCmLeZzfobZ8TLcyKSEm/MaHg57jgzPayxM4OuFsljPcwFr" +
       "zNoqwIgu3GCJ1bqKmXJjUpsoMK7NOi1V0Rh+q2qUBcbwoIEhkVRMDUkUn5oj" +
       "WNyGW1tnlzTqiAS9yrGhCiTF8TpndNXuiKnvwlFVTqSkMQznWJU37VAAVtNr" +
       "7EJJrNeqc3XUhY1+fRf03Q4ijd18KdIyva0L+ZAVLNez8llGQAzVX4EV4wyD" +
       "yZAGSuRZ1s9G87USw9i858/Gu4bY8id8y2MQJOPardyQiAW8qdumzxAL3R8E" +
       "eUSuqq02NIRzAnKJ8bwp4S45gBdGPqnPugrpTzN9tJmjGzuwkFFj1VFVCdLd" +
       "rqW7zTlmdeEaTm4tVgJqSR28tUwJCRVqCspwZq87nnCc3MxSTNu4ttCKebfJ" +
       "zogejgq5JDhIOLEROKivRqGNGlYjX0Sav5W82XIxEiebsZRsVlU88aXMXuam" +
       "ULf7yzlCD/rQbNOy+xuoM4r6jWrfUl2GjASt0an15y3DHaSU0e3C3VqUuClH" +
       "OFTa1zfouME0Ug4d+r0VvrQ9HU/ry2E8QiYmYGhQRZbJqtGINrsB0tiuWyrX" +
       "tgfA74JVzkiM31NEXDJJX1qhQ7q7nNWpHo3PYZThMSiZmSYfzthFMB9X14vV" +
       "tG2toM3aHNYDjqWXsOT7jS2uQjuupgk9twV1pN1QZyzenvui2wxYZt5tiIuV" +
       "PxyyAHtJ3cvicY76IZ6amjV2eFnIPH/ct3pxhKas0Od9KBKMbGXXCRZaUI0a" +
       "xFaTat5EFiNhEdo5ZsjTGjJG2KoETLjRFome7kx4fAtnVQ6KbCgX6huFToNt" +
       "l8CRneXITnti9LsWpygtesvNBrsobpkowWTNQN8sWpa2hIzq1ApJNqOZHFv6" +
       "zi6Z6D68HW/600QZax0edeuuwAyHNgqRO7lm6PSMYdDFnOwtawQcLiNzCbJV" +
       "1hqPyGkTSmFuqAA/8yjUjjqTVkev0non6cBVxhFaYbeLYqtMWrRqU7wOtXZN" +
       "XdH6jLVg0BaNYLqdtRCpsUJDRUE2ZhKTg9h1mmk24egU9Z1xOEXGw+YCGjpb" +
       "L5t56orSSUhiQUzXRsZ2m4TwrrdOnAbaggJ+7AueUfcUZITn0TDhuF3T4wet" +
       "vEtuSNXjprS5DauoA/f0nWo59WaDSMwBuVquCCNwvHVfGFUNsU37G8gwUBLH" +
       "4akEq3hay5FBHM/HmOY1F6woO0ZtxeuLubwLQqKf2omRUEmutYeNwZhH2rQ+" +
       "0UQKI7wRpCttp+bUMoSXyYnbkLJp3g8zvjtL+th6lWjAXpFNsrXJ1jjfIZDm" +
       "9JNqeyJ2F0irTY9G42W7HavQJmOb7ao50JbrGbnBltBgzHaMAIYibBJXOXdW" +
       "gzeyqNbsOa2oI4lsyYPA0XZNXFjmmpoFflwdppE7Te1VcxU30k6zsxZkpOpK" +
       "AZVl4XgWLgwIcgynNaeG/NZpLucryJbQbWvR9eCqCTGGDlP4did16v2GHVrx" +
       "YofaGNQzXH83dYWqRMmQ0BRkEaxoPVjpNCqsxt0Fm5JunchtPh5DfnMjYhrZ" +
       "ovGsHnOmgpkxsmoumHWPN0l4gTm5Z3sj22uC+fqC123LkwaUTjm/BcnjRo+U" +
       "GrE9gZjlzuahpclW1bE3lv1OTYaHDJOZNNVyabkdzYejGlulZ/BuFow1mxW1" +
       "3IT5uYRSIHfjHWZgTOjqhqVpP98KgxXb5uWVbtr5oouNd9G8054nDai14nzF" +
       "YNFNa7V2jdxsbhbLAbls+JnTxtkdH/V62AjqTPKOWGutexsNvA86Hk+v1GWL" +
       "bCNaT2xTkjNaTBcROgRwXB9nMgGW33FC0c1YlbQ63m4uBPTaqXU5DeQRfXUH" +
       "T/ihuMRBTuW72mTrtxK9PzStDHGa+oBQOjto4HpeTvYxd4zrS0lds0sClo00" +
       "SGdpZuCkwBrZGnHmC3wktTfjEIEoabpcy10FsZWoyrajWXc6UlmbnmxrM4yN" +
       "Gx13q7UyM7DRRa2jz2F1ocwGWI0Eoiait0vJTro11gxsTmmVb2yM+Xw+haXA" +
       "pnqUO8x0WgVxaOjsVGM65NH1dIHXLKW53klSvUbrrSAdNXvNQR1eprGjMDHE" +
       "zpbCDiLohIwTnOgSENKJ8wUysokqFcZbN2bb3fZK96QusDIXwH5ttphjdYqR" +
       "bFYNNsuk0Q4wdJWMncUSbs2aaNRGiGQIuWaKdVJpMt8G0oRoeytpnbdri9Tw" +
       "bGujoqN23JovxCpApZCkJdWu42sugJyaiwW5ri/X3AABwBFuYHYbb3W3w2dG" +
       "YnI1Ohv0HGbNGbFeXxi+u3O4RXOItzSFqyZewubtiPPSdDzAtBTNVbvR2TXs" +
       "dt6NJEftUXqArpGpu4bbU92m8s6mg6jyLFjvHBwkLJ3NjKJhQ9dnAst3hg1R" +
       "rlXVcFtTFykARo3kk2pVsPAdwitusqT7WrNNgmCtCzWtrYz7JubSiSTZxDZS" +
       "ByNNa9bH7o6npn5b6y9q1UyZ98fAcaAs7PP5Yjlmth3HnaPspCH0JmgVpRKp" +
       "gzanyag1QJb+KjGxzXJYG1MgCZ8kBic4/BS2tlJ3yMN1aq2QdRegp9VbdXWs" +
       "Rg0pjwuRXYTEip4tpgbdiDLUGg+8VTD2ObYxaeZGe16tozLXpJYq1NnxNT2i" +
       "V8auMTX7oTycdYRM3G3SVexNYGTMFDwsJVIgSPA3WBBtECN8YD5xj7WNMSvv" +
       "HA+qyyEpoJC+3HAmLU/CEczvrPmWXzSiNss4Uo3ReuumPJ/W1XWDlTmCTkcN" +
       "jTJCpgf3HFgkm67a6nitmOwFfC1oz7xpyuZisuW70yk0XG1iIsUTuNrFB+Yq" +
       "D3RfCtOhB7ctY7qtzidWjWD0vhVv1ay67Co9o8s6RJ2UN7xBYNUxVSfmWHe8" +
       "CNPVRlZSi2QDXrI7cWwrYsdsZ44hUu2JzCZetrNGjA5tIYYh8UWb29ANa+Yz" +
       "i1wVxTYpgUAsW4nX9bL2rJZRVbOdSDGRQS0TvHW2Bs1lG1oMuiHJsVJdZpU2" +
       "TEYZNqs1Rmyf1Aw+HW6YrjEjLdO1yXxsbQck0o4H8y3pWwIWR5yvLyJjzXXp" +
       "RdcA2VrKUesJNcbxblwzw6Zt+dbIQqbtQEeifssDSQHkr/MJym0cqDdCZo25" +
       "q1XrBKJ1yXqIRlM3A+8fZkqzGwFk+enMWPjKmGToRtyJo64hx025OU/nOtXI" +
       "6yNgn2ErpLYCKtkoyOSTFc0iK5kgcqypr0VnU19t6okupxqkNoDTDif5fGvR" +
       "4L1zLSW7wQ7JeTMQEFZaon6tu6lPd3UInTMLdZNC0ziYQRqiKiIzUokRZkD0" +
       "oJpBzWihtiG5lhmeKNbqmtLZiASkh+u6314bEtOZszWJxEmPFHmR6biZU5O5" +
       "WOjbcnPRyzLRU/ttOZ7ScL0pIlazUY2MVrfTA4vVmqecn6XBcr1g+mZvSQzh" +
       "bAtjsZESozobUSKIOSCxwDrdWGh1lVFTFmrNfISnPhEuY3oua7iK5nqbggYd" +
       "bkgYNoZhHy62TP7+29vKeaTcoTo+rvWn2JvKTn3jOd70K3+XKueO+Jza9Dv1" +
       "EaJSfCZ58nansMpveZ//+CuvqaOfrx1tatJJ5XIShH/B1Taae2qou8t7/piN" +
       "R4vhXwDXwSEbB+f3Hk8Evc0X1VJle22d+5p04WR7sl4S/PodPjd9qSh+Lanc" +
       "7cmWf8tNsk1gqSca/2dvtj92eoJzUpeH");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("VIrPHcah1MbbkLqU57lbCnxann99h7bfL4p/lVTuitLyBMu/PBHry38GscqN" +
       "5KfA9YlDsT7xdsVK31SsP7pD2x8XxX9IKlfCyPKTWfFt65x0f/Bnle4auF49" +
       "lO7V//fSffMObf+tKL6WVO4vpetr8uGW+Snxvv52xMuASReH2IoTOY/fdBB2" +
       "f3hT+cJrV+9792uz39+fjTk6YHl5ULlPT1339ImIU/eXwkjTrZLpy/uPrWH5" +
       "992k8gN3+DKZVO4p/0tOv7Pv8j+TymO37AKYL/5O0/5JUnn4PC0Ys/w/Tfd9" +
       "YCEndEnl0v7mFMmFi8A3AElxe1d49Bnj1G79/hxJduEsSB6vw6Nvtg6ncPWZ" +
       "Mx+NynPLR6cB0vHht6kvvsYMP/bt1s/vT6UprpznxSj3DSr37g/IlYMWJwqe" +
       "vu1oR2Nd6j//vYd++fL7j5D6oT3DJ7Z7irenbn0EjPTCpDy0lf+jd/+DD/3C" +
       "a39Yfq74v0veXl1QLgAA");
}
