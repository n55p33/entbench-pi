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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
