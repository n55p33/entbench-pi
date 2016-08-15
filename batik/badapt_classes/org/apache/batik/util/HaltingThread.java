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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "qCAAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "g8/fAsCth2iqKgAA");
}
