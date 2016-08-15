package org.apache.batik.script;
public class InterpreterPool {
    public static final java.lang.String BIND_NAME_DOCUMENT = "document";
    protected static java.util.Map defaultFactories = new java.util.HashMap(
      7);
    protected java.util.Map factories = new java.util.HashMap(7);
    static { java.util.Iterator iter = org.apache.batik.util.Service.providers(
                                                                       org.apache.batik.script.InterpreterFactory.class);
             while (iter.hasNext()) { org.apache.batik.script.InterpreterFactory factory =
                                        null;
                                      factory = (org.apache.batik.script.InterpreterFactory)
                                                  iter.
                                                  next(
                                                    );
                                      java.lang.String[] mimeTypes =
                                        factory.
                                        getMimeTypes(
                                          );
                                      for (int i = 0; i <
                                                        mimeTypes.
                                                          length;
                                           i++) { defaultFactories.
                                                    put(
                                                      mimeTypes[i],
                                                      factory);
                                      } } }
    public InterpreterPool() { super();
                               factories.putAll(defaultFactories);
    }
    public org.apache.batik.script.Interpreter createInterpreter(org.w3c.dom.Document document,
                                                                 java.lang.String language) {
        org.apache.batik.script.InterpreterFactory factory =
          (org.apache.batik.script.InterpreterFactory)
            factories.
            get(
              language);
        if (factory ==
              null)
            return null;
        org.apache.batik.script.Interpreter interpreter =
          null;
        org.apache.batik.dom.svg.SVGOMDocument svgDoc =
          (org.apache.batik.dom.svg.SVGOMDocument)
            document;
        try {
            java.net.URL url =
              new java.net.URL(
              svgDoc.
                getDocumentURI(
                  ));
            interpreter =
              factory.
                createInterpreter(
                  url,
                  svgDoc.
                    isSVG12(
                      ));
        }
        catch (java.net.MalformedURLException e) {
            
        }
        if (interpreter ==
              null)
            return null;
        if (document !=
              null)
            interpreter.
              bindObject(
                BIND_NAME_DOCUMENT,
                document);
        return interpreter;
    }
    public void putInterpreterFactory(java.lang.String language,
                                      org.apache.batik.script.InterpreterFactory factory) {
        factories.
          put(
            language,
            factory);
    }
    public void removeInterpreterFactory(java.lang.String language) {
        factories.
          remove(
            language);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "FJhofPWbvIvNH/8LxNLFbmcdAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "UwGrq4SGYUwmbXE/opXKIlzH87aQwMv2kJiuB50eNkS6noQMGilGknau9hW8" +
       "NvS3KF8HvpZtZS3vIOY6aYT6YFBb16aCho2EUGrjPLrDsNRcYWoCVqfVfL2b" +
       "92kUY1cm1aq3+FmvzdsmNVvvJNrb9fMQ18CCNs2wONUUTustcoZssdIarHmt" +
       "Wkvuh9QsTRJdwTB4162CzQg9UacKrnVZvIkQQZhGXrWTu8F4ZrPTXg+E0QBe" +
       "sIbqYzhXE8QVTFVbrEDGs2GISglsDODZoJWa055UQxB1zhrZHGSrYVvr7uJN" +
       "2Nzkjpnmo4WcTxN5VPXVqYiadYVPZnO8M4umtYQYmJVwwmXJ0JCXhrJaw1UU" +
       "qQmovOF6wXIoBrDtsozUbg91H1eHhj+f6qJD4UR9Pu60trCDYlmqC9nQ2Kbw" +
       "vG4vdAPvDOk2ktZaOVJTXLBi8YZLAhwJQMq9Zlb9nOXmizkVq8to3NDnDUV1" +
       "vNbU3EjYxnBmIkt3vAppYut2c8K49HKt4TSntkBSJc3dnsaGg9St1KLNPCPw" +
       "KkFYhMXu9JUwB3lEbxXwK75J1Rv1ib9rwX02ME2uNpAN3eZq8ITrEaK9ARtL" +
       "tGnalQxLTG7OVpbjeCqOdg6aDbJRpzEP9NQdd6tTz2PEIdXMjXCY5WTH2o6C" +
       "5UKoDvyKmFmbaROXeLlSWfXHuEfO7DQP55bUQhWJh72GF+oVbxl0BS8XSdzG" +
       "CdwYI2t1Bda6OlWrCxtYaxMRr2wDwRKxntbh/C3IDPUKGfeHK9/kZmpKpeMB" +
       "gtP5mO6rrqaDnfQ3Flvs57+yU46Hy8Obkwvp/8Gxzf7VU0XxzMmZVfm5DF24" +
       "xDx7H3J6SA4VJxZvutM9c3la8Yn3v/Cizv5Y5fjoL4+hK7EffL1jpIZzhtU9" +
       "gNOzdz6ZYcpr9tND70+//++fEL9p9Z6v4CrvzRfkvMjyJ5mXfof8Gu37DqB7" +
       "To7Ab/kDwPlOz50/+L4aGnESeuK54+83nVj2scJibwOPfGRZ+XangdfvcuL4" +
       "tv3cX7i7OdgfDh8flL6+uHDNatqh7ruHvTNn6VTZ+/vvcvPzg0XxYeBaWmgo" +
       "sXHmhvaY+dOv4jb31Pm+98sdLZ0VoGz40PnLxzZ4kiNrxf+n1ioNcqzVs69C" +
       "q/3R+rbk+aN3seGPF8WLMfRokMS3di+7RGcCM4uhe1Pf0k+N9iP/W6O1wPPe" +
       "I6O99//GaJdOCfZe9HN3scAvFMXLMfR4aLh+atxqhOL9T54q/MmvRGGAH9cu" +
       "/HOguAZ9/Ja/JO3/RqP9zIvXHnjsxekfl5fnJ391uUJDD5iJ45y9tTpTvwyY" +
       "m1apzJX9HVZQfn0qhh67g6sUd1FlpZT4V/f0r8TQ9Yv0MXRf+X2W7jdi6Oop" +
       "HWC1r5wl+a0YugeQFNVPB7e5m9pf3uWXzqPziY0f+XI2PgPoT5+D4fIvYceQ" +
       "mXBHV0cvvzgcf9sXmz+2v9vXHGW3K7g8QEP37/9mcAK7T92R2zGvy4O3f+mh" +
       "T1555niJeGgv8KmnnpHtzbe/SCfcIC6vvne/9NjPvePHX/yL8grhvwFJ8Bdw" +
       "qycAAA==");
}
