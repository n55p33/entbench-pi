package org.apache.batik.util;
public class HaltingThread extends java.lang.Thread {
    protected boolean beenHalted = false;
    public HaltingThread() { super(); }
    public HaltingThread(java.lang.Runnable r) { super(r); }
    public HaltingThread(java.lang.String name) { super(name); }
    public HaltingThread(java.lang.Runnable r, java.lang.String name) { super(
                                                                          r,
                                                                          name);
    }
    public boolean isHalted() { synchronized (this)  { return beenHalted;
                                } }
    public void halt() { synchronized (this)  { beenHalted = true; } }
    public void clearHalted() { synchronized (this)  { beenHalted = false;
                                } }
    public static void haltThread() { haltThread(java.lang.Thread.currentThread(
                                                                    )); }
    public static void haltThread(java.lang.Thread t) { if (t instanceof org.apache.batik.util.HaltingThread)
                                                            ((org.apache.batik.util.HaltingThread)
                                                               t).
                                                              halt(
                                                                );
    }
    public static boolean hasBeenHalted() { return hasBeenHalted(
                                                     java.lang.Thread.
                                                       currentThread(
                                                         ));
    }
    public static boolean hasBeenHalted(java.lang.Thread t) {
        if (t instanceof org.apache.batik.util.HaltingThread)
            return ((org.apache.batik.util.HaltingThread)
                      t).
              isHalted(
                );
        return false;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "IAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
