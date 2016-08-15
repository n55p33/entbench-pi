package org.apache.batik.script.rhino.svg12;
public class GlobalWrapper extends org.apache.batik.script.rhino.WindowWrapper {
    public GlobalWrapper(org.mozilla.javascript.Context context) { super(
                                                                     context);
                                                                   java.lang.String[] names =
                                                                     { "startMouseCapture",
                                                                   "stopMouseCapture" };
                                                                   this.
                                                                     defineFunctionProperties(
                                                                       names,
                                                                       org.apache.batik.script.rhino.svg12.GlobalWrapper.class,
                                                                       org.mozilla.javascript.ScriptableObject.
                                                                         DONTENUM);
    }
    public java.lang.String getClassName() {
        return "SVGGlobal";
    }
    public java.lang.String toString() { return "[object SVGGlobal]";
    }
    public static void startMouseCapture(org.mozilla.javascript.Context cx,
                                         org.mozilla.javascript.Scriptable thisObj,
                                         java.lang.Object[] args,
                                         org.mozilla.javascript.Function funObj) {
        int len =
          args.
            length;
        org.apache.batik.script.rhino.svg12.GlobalWrapper gw =
          (org.apache.batik.script.rhino.svg12.GlobalWrapper)
            thisObj;
        org.apache.batik.dom.svg12.SVGGlobal global =
          (org.apache.batik.dom.svg12.SVGGlobal)
            gw.
              window;
        if (len >=
              3) {
            org.w3c.dom.events.EventTarget et =
              null;
            if (args[0] instanceof org.mozilla.javascript.NativeJavaObject) {
                java.lang.Object o =
                  ((org.mozilla.javascript.NativeJavaObject)
                     args[0]).
                  unwrap(
                    );
                if (o instanceof org.w3c.dom.events.EventTarget) {
                    et =
                      (org.w3c.dom.events.EventTarget)
                        o;
                }
            }
            if (et ==
                  null) {
                throw org.mozilla.javascript.Context.
                  reportRuntimeError(
                    "First argument to startMouseCapture must be an EventTarget");
            }
            boolean sendAll =
              org.mozilla.javascript.Context.
              toBoolean(
                args[1]);
            boolean autoRelease =
              org.mozilla.javascript.Context.
              toBoolean(
                args[2]);
            global.
              startMouseCapture(
                et,
                sendAll,
                autoRelease);
        }
    }
    public static void stopMouseCapture(org.mozilla.javascript.Context cx,
                                        org.mozilla.javascript.Scriptable thisObj,
                                        java.lang.Object[] args,
                                        org.mozilla.javascript.Function funObj) {
        org.apache.batik.script.rhino.svg12.GlobalWrapper gw =
          (org.apache.batik.script.rhino.svg12.GlobalWrapper)
            thisObj;
        org.apache.batik.dom.svg12.SVGGlobal global =
          (org.apache.batik.dom.svg12.SVGGlobal)
            gw.
              window;
        global.
          stopMouseCapture(
            );
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
      ("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" +
       "B3s6x3y99pSvluN7Wqneo779+avlH57c1wCd2zsy7gYlOx87E1ZfyZ5/5R59" +
       "v1YUv5RA9ysFT3sR7gH+m0dWDHh++i7G00m98qishP/H96D1maL4MFhjQJyL" +
       "kr6fxlpLDsrLKXfQ8OXMt9RTP/uH36ufEeD50SM/m/8/8rOi+Eip06J4qYT/" +
       "N/fQyO8Xxe8CE47B6nVWIUX7vzgV/vdejfDbBHr43KF/cYL5+G13jfb3Y5RP" +
       "v3j96htfnP7h3ieP77A8yENXdfC1dvYk6Uz9ShBpulWK8OD+XGlvpJ9LoGf/" +
       "D+4kAOsr3yXr/36P+oUEevKeqACpfJ9F+lICvfEuSMUxVFk5C/8VoOqL8IBu" +
       "+T4L99UEunYKB0jtK2dBvg5iAAApqv8hOHYR+N7Cz0Dq4m+OZmV76XzOczLZ" +
       "j73SZJ9Jk549F6vLa2fHiUi6v3h2S/nMi6zwE99p/PL+hoDiyHleULkKwur+" +
       "ssJJMvPMXakd07rSfft3H/ntB996nHg9smf41H3O8Pb0nY/j226QlAfo+e+9" +
       "8V+961df/NPysO3vAVFjAMYPKAAA");
}
