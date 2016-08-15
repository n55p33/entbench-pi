package org.apache.batik.parser;
public class TimingSpecifierParser extends org.apache.batik.parser.TimingParser {
    protected org.apache.batik.parser.TimingSpecifierHandler timingSpecifierHandler;
    public TimingSpecifierParser(boolean useSVG11AccessKeys, boolean useSVG12AccessKeys) {
        super(
          useSVG11AccessKeys,
          useSVG12AccessKeys);
        timingSpecifierHandler =
          org.apache.batik.parser.DefaultTimingSpecifierHandler.
            INSTANCE;
    }
    public void setTimingSpecifierHandler(org.apache.batik.parser.TimingSpecifierHandler handler) {
        timingSpecifierHandler =
          handler;
    }
    public org.apache.batik.parser.TimingSpecifierHandler getTimingSpecifierHandler() {
        return timingSpecifierHandler;
    }
    protected void doParse() throws org.apache.batik.parser.ParseException,
        java.io.IOException { current = reader.read(
                                                 );
                              java.lang.Object[] spec =
                                parseTimingSpecifier(
                                  );
                              skipSpaces();
                              if (current != -1) {
                                  reportError(
                                    "end.of.stream.expected",
                                    new java.lang.Object[] { new java.lang.Integer(
                                      current) });
                              }
                              handleTimingSpecifier(
                                spec); }
    protected void handleTimingSpecifier(java.lang.Object[] spec) {
        int type =
          ((java.lang.Integer)
             spec[0]).
          intValue(
            );
        switch (type) {
            case TIME_OFFSET:
                timingSpecifierHandler.
                  offset(
                    ((java.lang.Float)
                       spec[1]).
                      floatValue(
                        ));
                break;
            case TIME_SYNCBASE:
                timingSpecifierHandler.
                  syncbase(
                    ((java.lang.Float)
                       spec[1]).
                      floatValue(
                        ),
                    (java.lang.String)
                      spec[2],
                    (java.lang.String)
                      spec[3]);
                break;
            case TIME_EVENTBASE:
                timingSpecifierHandler.
                  eventbase(
                    ((java.lang.Float)
                       spec[1]).
                      floatValue(
                        ),
                    (java.lang.String)
                      spec[2],
                    (java.lang.String)
                      spec[3]);
                break;
            case TIME_REPEAT:
                {
                    float offset =
                      ((java.lang.Float)
                         spec[1]).
                      floatValue(
                        );
                    java.lang.String syncbaseID =
                      (java.lang.String)
                        spec[2];
                    if (spec[3] ==
                          null) {
                        timingSpecifierHandler.
                          repeat(
                            offset,
                            syncbaseID);
                    }
                    else {
                        timingSpecifierHandler.
                          repeat(
                            offset,
                            syncbaseID,
                            ((java.lang.Integer)
                               spec[3]).
                              intValue(
                                ));
                    }
                    break;
                }
            case TIME_ACCESSKEY:
                timingSpecifierHandler.
                  accesskey(
                    ((java.lang.Float)
                       spec[1]).
                      floatValue(
                        ),
                    ((java.lang.Character)
                       spec[2]).
                      charValue(
                        ));
                break;
            case TIME_ACCESSKEY_SVG12:
                timingSpecifierHandler.
                  accessKeySVG12(
                    ((java.lang.Float)
                       spec[1]).
                      floatValue(
                        ),
                    (java.lang.String)
                      spec[2]);
                break;
            case TIME_MEDIA_MARKER:
                timingSpecifierHandler.
                  mediaMarker(
                    (java.lang.String)
                      spec[1],
                    (java.lang.String)
                      spec[2]);
                break;
            case TIME_WALLCLOCK:
                timingSpecifierHandler.
                  wallclock(
                    (java.util.Calendar)
                      spec[1]);
                break;
            case TIME_INDEFINITE:
                timingSpecifierHandler.
                  indefinite(
                    );
                break;
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Hv5IS/w/j5aunASBn709spQBsX1o6uUfeeZ3v+vlZ/57GRa5z4wWUtgO9Uvu" +
       "TZxp89VXvvTlP3jzY6+Wcde7ZWmvmGsXL5zcep/k3DWRkv0HguySk+h9zOAW" +
       "mcoD2OD4OP+nL9fNwcnWcbJrXHU0T4+Nyxb5XYDHIvvqER+XGNNbTvkiHN/T" +
       "ipjkcd1bjy3n5N4OqMwuZTwLSnZePbP/vJ6V/+od6n69SH45rtyjFDztRbgD" +
       "+Rey/f9P3IHmi0XyI3HlbUaJCReA4oLt/+gbsf0MdHrp3YYiUPuOW65R7a/+" +
       "KK++fP2+R16e/5e9mR1fz7l/VLlvnTjO2dDQmfzVINTWZinP/ftA0V7v/ymu" +
       "PHIbVChi32Wm5Pv39vT/GRjkRXqg7fL/LN0fxZVrp3Sgq33mLMkfAzMDJEX2" +
       "T4Jjy7l55wjSXj3ZlfOOx4n2H3497Z/xVZ45hwPl1bZjbyDZX257Qfn8ywP2" +
       "Q19r/vD+RoLiSHle9HIfWLL7yxEnHsVTt+3tuK+r1Lu//uBP3f/ssffz4J7h" +
       "Uzg7w9sTl4f/e24QlwH7/Ocf+Zn3/ejLf1qGhv4fJ8GN73MoAAA=");
}
