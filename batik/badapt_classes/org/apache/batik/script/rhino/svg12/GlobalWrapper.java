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
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "2+/6lZe+Xh62/T1XNgwWDygAAA==");
}
